{
import java.io.*;
import java.util.*;
import java.util.LinkedHashMap;

import antlr.CommonAST;
import antlr.DumpASTVisitor;
}class GnuCEmitter extends TreeParser;

options {
	importVocab= GNUC;
	buildAST= false;
	ASTLabelType= "TNode";
	codeGenMakeSwitchThreshold= 2;
	codeGenBitsetTestThreshold= 3;
}

{
    public void setOutputPath(String outputPath){
        this.outputPath=outputPath;
    }

    /* Class that define an identifier linked with type, value
    *   and the pointed variable.*/
	class Identificatore
	{
		public String tipo;
		public String valore;
                public String variabilepuntata;
    
                public Identificatore(String _tipo, String _valore)
		{
			tipo = _tipo;
			valore = _valore;
                        variabilepuntata="";
		}
		
		public Identificatore(String _tipo, String _valore, String _variabilepuntata)
		{
                        tipo = _tipo;
			valore = _valore;
                        variabilepuntata=_variabilepuntata;
		}
	}

    //Class that represent the function with name, type and paramiters' list
    class InfoFunzione
    {
        public LinkedList lista_parametri;
        public String tipo_di_ritorno;
        public InfoFunzione()
        {
            tipo_di_ritorno="";
            lista_parametri=new LinkedList();
        }
    }

    /* Class that contains the list if identifier */
	class LHM_identificatori<K,V> extends LinkedHashMap<K,V>
    {
        @Override
        public V get(Object key)
        {
            return (V)super.get((String)key+"_"+FunzioneCorrente.peek());
        }

        public V put(Object key, Object value)
        {
            return (V)super.put((K)((String)key+"_"+FunzioneCorrente.peek()),(V) value);
        }

        public V getByCompleteName(K value)
        {
            return (V)super.get(value);
        }
    }


	int tabs = 0;
	PrintStream currentOutput = System.out;
	int lineNum = 1;
	String currentSource = "";
	LineObject trueSourceFile;
	final int lineDirectiveThreshold = Integer.MAX_VALUE;
	PreprocessorInfoChannel preprocessorInfoChannel = null;
	Stack sourceFiles = new Stack();

    // codeList maintains the instruction for the .code part of file.s
    LinkedList codeList = new LinkedList();

    /// functionList maintains the list of the function present in the program.
    HashMap <String,InfoFunzione> functionList = new HashMap<String,InfoFunzione>();

    /*  identificatori is a linkedHashMap that permits to maintain the
    *   instruction to put into the .data part of the file.s*/
    LHM_identificatori<String, Identificatore> identificatori = new LHM_identificatori<String, Identificatore>();

    /*  ansRegister is the variable that permit to now the result of the last expression.
    *   e.g. ADDI R1,R3,R4   ansRegister = R1.*/
    int ansRegister = 0;

    /*  ansType maintain the last type of an identifier.
    *   int x = 3; int t = 3.5; x+t; ansType = double. */
    String ansType = "";

    /*  operazioneBinaria is a variable used into the switch case to choos the operation.*/
    int operazioneBinaria = 0;

    /*  this stack contains the numeric constant associated to operations */
    Stack<Integer> operazioniPendenti=new Stack<Integer>();
    Stack<Integer> WhilePendenti=new Stack<Integer>();
    Stack<Integer> SwitchLabelPendenti=new Stack<Integer>();
    Stack<Integer> ForPendenti=new Stack<Integer>();
    Stack<Integer> SwitchPendenti=new Stack<Integer>();
    Stack<Integer> DoPendenti=new Stack<Integer>();
    Stack<Integer> ifPendenti=new Stack<Integer>();

    //rapresents all blocks that can contain break or continue tags
    Stack<String> strutturePendenti=new Stack<String>();

    //contains the name of the current function
    Stack<String> FunzioneCorrente=new Stack<String>();

    //variables that contains the last register,or label used in order to manage the cycles
    int lastAssignedRegister=1;
    int lastAssignedRegisterFloat=1;
    int lastAssignedFor;
    int lastAssignedDo;
    int lastAssignedWhile;
    int lastAssignedIf;
    int lastAssignedSwitch;
    int lastAssignedCase;
    int lastAssignedLabel;

    //variable that contains type of the last variable visited
    String tipoCorrente = "";

    //vectors that indicate if a register is busy e.g. if (registri[2] == 1)--> r1 is used.
    int registri[]=new int[31];
    int registriFloat[]=new int[31];

    //tipoId contains the type of a variable
    String tipoId = "";

    //this variable is used for vector initialization and contains the vector size or the initializer values
    String numero = "0";

    //listaValori contains the initializer values of a vector and is loaded by numero
    String listaValori="";

    //we put flag_puntamento=1 if there is a pointer initialization e.g. int*x; x=&i;
    int flag_puntamento=0;

    //we put flagFunzione=1 if the identifier indicates a function
    int flagFunzione;

    /*  tipo is a support variable that allows to maintain the type of a variable
    *   if the index of a vector is an operation e.g. double v[5]; int i =0; v[i+3];
    *   while we calculate the offset in braket [tipo = .double, tipoCorrente = i]
    *   then tipoCorrente = tipo..*/
    String tipo="";

    //variable that contains the value of the register where is the return values
    int registroRitorno;

    //we put flag_passaggio_parametri=1 if the paramiters list is not empty
    int flag_passaggio_parametri;

    String nome_funzione;
    int cont;
    int ritorno = 0;
    String tiporitorno="";
    int registroOffset =0;

    //from x[5]  obtain x
    String nomeVettoreCorrente;

    // used  only for identifiers declaration (do not use for other goal)
    String nomeIdCorrente;     

    // contains data of type   x(R5) calculated from the previous load instruction
    String ultimoOffsetCalcolato;

    /*  the offset calculated from the loading instruction of left right reachs
    *   binaryExpr() and a corresponging Store is generated using this offset
    *   e.g   if e.g x[d]=3      from LW R1,x(d) obtained in postfix we obtain
    *   SW R5,x(d)  [SW is dual, x(d) is the same ] */
    String offsetLatoSinistro="";

    // the type detected from
    String tipoLatoSinistro="";

    // in declarations it refers to the type   e.g   int a; --> int
    String tipoDichiarazione;      

    //contains the name of the left side variable
    String variabileSinistra = "";

    String OffsetPuntatore ="";

    //this variable contains the path where we put the output.s file. It is passed by command line as second argument.
    String outputPath="";

    GnuCEmitter( PreprocessorInfoChannel preprocChannel )
    {
            preprocessorInfoChannel = preprocChannel;
    }

    //Methods that return the number of a free register (float or int)
    int getFreeRegister()
    {
        for(int i=lastAssignedRegister+1;i<=30;i++)
        {
            if (registri[i]==0)
            {
                lastAssignedRegister=i;
                holdRegister(i);
                return i;
            }
        }
        for(int i=1;i<lastAssignedRegister;i++)
        {
            if (registri[i]==0)
            {
                lastAssignedRegister=i;
                holdRegister(i);
                return i;
            }
        }
        return -1;
    }

    int getFreeRegisterFloat()
    {
        for(int i=lastAssignedRegisterFloat+1;i<=30;i++)
        {
            if (registriFloat[i]==0)
            {
                lastAssignedRegisterFloat=i;
                holdRegisterFloat(i);
                return i;
            }
        }
        for(int i=1;i<lastAssignedRegisterFloat;i++)
        {
            if (registriFloat[i]==0)
            {
                lastAssignedRegisterFloat=i;
                holdRegisterFloat(i);
                return i;
            }
        }
        return -1;
    }

    //Methods that free registers
    void freeRegisterFloat(int i)
    {
       registriFloat[i]=0;
    }

    void freeRegister(int i)
    {
       registri[i]=0;
    }

    void freeBinaryRegister(String tipo, int registro1, int registro2)
    {
        if(tipo.equals(".double"))
            freeBinaryRegisterFloat(registro1, registro2);
        else
            freeBinaryRegisterInteger(registro1,registro2);
    }

    void freeBinaryRegisterInteger(int registro1, int registro2)
    {
        freeRegister(ansRegister);
        freeRegister(registro1);
        freeRegister(registro2);
    }

    void freeBinaryRegisterFloat(int registro1, int registro2)
    {
        freeRegisterFloat(ansRegister);
        freeRegisterFloat(registro1);
        freeRegisterFloat(registro2);
    }

    //Methods that hold a register setting register[i]=1
    void holdRegister(int i)
    {
       registri[i]=1;
    }

    void holdRegisterFloat(int i)
    {
       registriFloat[i]=1;
    }

    //Create a suffix in order to know the scope of the variable
    String creaSuffisso(String value)
    {
        return value + "_" + FunzioneCorrente.peek();
    }

    //this method return true if the identifier represent a function
    public boolean is_a_function(String s1)
    {
        if(this.functionList.containsKey(s1))
            return true;
        return false;
    }

    //Methods that return the number of a free label and free the label indicates
    int getFreeLabelWhile()
    {
        return (++lastAssignedWhile);
    }

    int getFreeLabelDo()
    {
        return (++lastAssignedDo);
    }

    int getFreeLabelSwitch()
    {

        return (++lastAssignedSwitch);
    }

    int getFreeLabelIf()
    {
            return (++lastAssignedIf);
    }

    int getFreeLabelFor()
    {

        return (++lastAssignedFor);
    }

    int getFreeLabel()
    {
        return (++lastAssignedLabel);
    }

    int getFreeLabelCase()
    {
      return (++lastAssignedCase);
    }

    //This function permits us to take the name of the last variable visited
    String getVariableName(String lastOffset)
    {
        String variabile[] = lastOffset.split("\\(");
        return removeSuffix(variabile[0]);
    }

    //Thi function allows us to take the offset of a vector
    String extractOffset(String lastOffset)
    {
        int index1 = lastOffset.indexOf("(");
        int index2 = lastOffset.indexOf(")");
        return lastOffset.substring(index1 +1, index2);
    }

    //This function extracs the name of a variable without the suffix
    public static String removeSuffix(String value){
        int index=value.lastIndexOf("_");
        return value.substring(0, index);
    }

    //Method that returns true if the TNode or the value passed is a float number
    boolean isFloatNumber(TNode t)
    {
        String s1=t.getText();
        if(s1.indexOf(".")>0 || s1.indexOf("F")>0 || s1.indexOf("f")>0)
            return true;
        return false;
    }

    boolean isFloatNumber(String value)
    {
        if(value.indexOf(".")>0 || value.indexOf("F")>0 || value.indexOf("f")>0)
            return true;
        return false;
    }

    //Methods that allows to translate instruction making a controll of type
    String getLoad(String nome)
    {
        if(nome.equals(".word16"))
            return "LH R";
        if(nome.equals(".word32"))
            return "LW R";
        if(nome.equals(".word64"))
            return "LD R";
        if(nome.equals(".double"))
            return "LDC1 F";
        return "Non so che istruzione load applicare";
    }

    String getReturn(String tipo)
    {
        if(tipo.equals("short"))
            return ".word16";
        if(tipo.equals("int"))
            return ".word32";
        if(tipo.equals("long"))
            return ".word64";
        if(tipo.equals("double"))
            return ".double";
        return "Non so il tipo del valore di ritorno";
    }

    String getStore(String nome)
    {
        if(nome.equals(".word16"))
            return "SH R";
        if(nome.equals(".word32") || nome.equals("immediato"))
            return "SW R";
        if(nome.equals(".word64"))
            return "SD R";
        if(nome.equals(".double"))
            return "SDC1 F";
        return "Non so che tipo si store fare";
    }

    void getUguaglianza(String tipo, int registro1, int registro2)
    {
        if(!tipo.equals(".double"))
        {
            int ansRegister1 = getFreeRegister();
            codeList.addLast("SLT R" + ansRegister1 + ",R"+registro1+",R"+registro2);
            int ansRegister2 = getFreeRegister();
            codeList.addLast("SLT R" + ansRegister2 + ",R"+registro2+",R"+registro1);
            int ansRegister3 = getFreeRegister();
            codeList.addLast("OR R" + ansRegister3 + ",R"+ansRegister1+",R"+ansRegister2);
            ansRegister = getFreeRegister();
            codeList.addLast("SLTI R"+ ansRegister+",R"+ansRegister3+",1");
            freeBinaryRegisterInteger(registro1,registro2);
            freeRegister(ansRegister1);
            freeRegister(ansRegister2);
            freeRegister(ansRegister3);
        }
        else
        {
            codeList.addLast("C.EQ.D 3,F"+registro1+", F"+registro2);
            confrontoFP();
            freeRegisterFloat(registro1);
            freeRegisterFloat(registro2);
        }
    }

    void getSomma(int registro1, String tipo1, int registro2, String tipo2)
    {
        if(tipo1.equals(".double") || tipo2.equals(".double"))
        {
            ansRegister=getFreeRegisterFloat();
            int registroF1 = getFreeRegisterFloat();
            if(tipo1.equals(".word64") || tipo1.equals(".word32") || tipo1.equals(".word16") || tipo1.equals("immediato"))
            {
                codeList.addLast("DMTC1 R"+registro1+",F"+registroF1);
                codeList.addLast("CVT.D.L F"+registroF1 + ",F"+registroF1);
                codeList.addLast("ADD.D F"+ansRegister+", F" + registroF1 + ", F" + registro2);
                freeRegister(registro1);
            }
            else if(tipo2.equals(".word64") || tipo2.equals(".word32") || tipo2.equals(".word16") || tipo2.equals("immediato"))
            {
                codeList.addLast("DMTC1 R"+registro2+",F"+registroF1);
                codeList.addLast("CVT.D.L F"+registroF1 + ",F"+registroF1);
                codeList.addLast("ADD.D F"+ansRegister+", F" + registro1 + ", F" + registroF1);
                freeRegister(registro2);
            }
            else
            {
                codeList.addLast("ADD.D F"+ansRegister+", F" + registro1 + ", F" + registro2);
            }
            freeBinaryRegisterFloat(registro1,registro2);
            freeRegisterFloat(registroF1);
        }
        else if(tipo1.equals(".word64") || tipo2.equals(".word64"))
        {
            ansRegister=getFreeRegister();
            codeList.addLast("DADD R"+ansRegister+", R" + registro1 + ", R" + registro2);
            freeBinaryRegisterInteger(registro1,registro2);
        }
        else if(tipo1.equals(".word32") || tipo2.equals(".word32") || tipo1.equals(".word16") || tipo2.equals(".word16") || tipo1.equals("immediato") || tipo2.equals("immediato"))
        {
            ansRegister=getFreeRegister();
            codeList.addLast("ADD R"+ansRegister+", R" + registro1 + ", R" + registro2);
            freeBinaryRegisterInteger(registro1,registro2);
        }
    }

    void getSottrazione(int registro1, String tipo1, int registro2, String tipo2)
    {
        if(tipo1.equals(".double") || tipo2.equals(".double"))
        {
            ansRegister=getFreeRegisterFloat();
            int registroF1 = getFreeRegisterFloat();
            if(tipo1.equals(".word64") || tipo1.equals(".word32") || tipo1.equals(".word16") || tipo1.equals("immediato"))
            {
                codeList.addLast("DMTC1 R"+registro1+",F"+registroF1);
                codeList.addLast("CVT.D.L F"+registroF1 + ",F"+registroF1);
                codeList.addLast("SUB.D F"+ansRegister+", F" + registroF1 + ", F" + registro2);
                freeRegister(registro1);
            }
            else if(tipo2.equals(".word64") || tipo2.equals(".word32") || tipo2.equals(".word16") || tipo2.equals("immediato"))
            {
                codeList.addLast("DMTC1 R"+registro2+",F"+registroF1);
                codeList.addLast("CVT.D.L F"+registroF1 + ",F"+registroF1);
                codeList.addLast("SUB.D F"+ansRegister+", F" + registro1 + ", F" + registroF1);
                freeRegister(registro2);
            }
            else
                codeList.addLast("SUB.D F"+ansRegister+", F" + registro1 + ", F" + registro2);
            freeBinaryRegisterFloat(registro1,registro2);
        }
        else if(tipo1.equals(".word64") || tipo2.equals(".word64"))
        {
            ansRegister = getFreeRegister();
            codeList.addLast("DSUB R"+ansRegister+", R" + registro1 + ", R" + registro2);
            freeBinaryRegisterInteger(registro1,registro2);
        }
        else if(tipo1.equals(".word32") || tipo2.equals(".word32") || tipo1.equals(".word16") || tipo2.equals(".word16") || tipo1.equals("immediato") || tipo2.equals("immediato"))
        {
            ansRegister=getFreeRegister();
            codeList.addLast("SUB R"+ansRegister+",R"+ registro1 + ", R" + registro2);
            freeBinaryRegisterInteger(registro1,registro2);
        }
    }

    void getMoltiplicazione(int registro1, String tipo1, int registro2, String tipo2)
    {
        if(tipo1.equals(".double") || tipo2.equals(".double"))
        {
            ansRegister=getFreeRegisterFloat();
            int registroF1 = getFreeRegisterFloat();
            if(tipo1.equals(".word64") || tipo1.equals(".word32") || tipo1.equals(".word16") || tipo1.equals("immediato"))
            {
                codeList.addLast("DMTC1 R"+registro1+",F"+registroF1);
                codeList.addLast("CVT.D.L F"+registroF1 + ",F"+registroF1);
                codeList.addLast("MUL.D F"+ansRegister+", F" + registroF1 + ", F" + registro2);
                freeRegister(registro1);
            }
            else if(tipo2.equals(".word64") || tipo2.equals(".word32") || tipo2.equals(".word16") || tipo2.equals("immediato"))
            {
                codeList.addLast("DMTC1 R"+registro2+",F"+registroF1);
                codeList.addLast("CVT.D.L F"+registroF1 + ",F"+registroF1);
                codeList.addLast("MUL.D F"+ansRegister+", F" + registro1 + ", F" + registroF1);
                freeRegister(registro2);
            }
            else
                codeList.addLast("MUL.D F"+ansRegister+", F" + registro1 + ", F" + registro2);
            freeBinaryRegisterFloat(registro1,registro2);
        }
        else if(tipo1.equals(".word64") || tipo2.equals(".word64"))
        {
            ansRegister=getFreeRegister();
            codeList.addLast("DMULT R" + registro1 + ", R" + registro2);
            codeList.addLast("MFLO R" + ansRegister);
            freeBinaryRegisterInteger(registro1,registro2);
        }
        else if(tipo1.equals(".word32") || tipo2.equals(".word32") || tipo1.equals(".word16") || tipo2.equals(".word16") || tipo1.equals("immediato") || tipo2.equals("immediato"))
        {
            ansRegister = getFreeRegister();
            codeList.addLast("MULT R" + registro1 + ", R" + registro2);
            codeList.addLast("MFLO R" + ansRegister);
            freeBinaryRegisterInteger(registro1,registro2);
        }
    }

    void getDivisione(int registro1, String tipo1, int registro2, String tipo2)
    {
        if(tipo1.equals(".double") || tipo2.equals(".double"))
        {
            ansRegister=getFreeRegisterFloat();
            int registroF1 = getFreeRegisterFloat();
            if(tipo1.equals(".word64") || tipo1.equals(".word32") || tipo1.equals(".word16") || tipo1.equals("immediato"))
            {
                codeList.addLast("DMTC1 R"+registro1+",F"+registroF1);
                codeList.addLast("CVT.D.L F"+registroF1 + ",F"+registroF1);
                codeList.addLast("DIV.D F"+ansRegister+", F" + registroF1 + ", F" + registro2);
                freeRegister(registro1);
            }
            else if(tipo2.equals(".word64") || tipo2.equals(".word32") || tipo2.equals(".word16") || tipo2.equals("immediato"))
            {
                codeList.addLast("DMTC1 R"+registro2+",F"+registroF1);
                codeList.addLast("CVT.D.L F"+registroF1 + ",F"+registroF1);
                codeList.addLast("DIV.D F"+ansRegister+", F" + registro1 + ", F" + registroF1);
                freeRegister(registro2);
            }
            else
                codeList.addLast("DIV.D F"+ansRegister+", F" + registro1 + ", F" + registro2);
            freeBinaryRegisterFloat(registro1,registro2);
        }
        else if(tipo1.equals(".word64") || tipo2.equals(".word64"))
        {
            ansRegister=getFreeRegister();
            codeList.addLast("DDIV R" + registro1 + ", R" + registro2);
            codeList.addLast("MFLO R" + ansRegister);
            freeBinaryRegisterInteger(registro1,registro2);
        }
        else if(tipo1.equals(".word32") || tipo2.equals(".word32") || tipo1.equals(".word16") || tipo2.equals(".word16") || tipo1.equals("immediato") || tipo2.equals("immediato"))
        {
            ansRegister = getFreeRegister();
            codeList.addLast("DIV R" + registro1 + ", R" + registro2);
            codeList.addLast("MFLO R" + ansRegister);
            freeBinaryRegisterInteger(registro1,registro2);
        }
    }

    void getModulo(int registro1, String tipo1, int registro2, String tipo2)
    {
        if(tipo1.equals(".word32") || tipo2.equals(".word32") || tipo1.equals(".word16") || tipo2.equals(".word16") || tipo1.equals("immediato") || tipo2.equals("immediato"))
        {
            ansRegister = getFreeRegister();
            codeList.addLast("DIV R" + registro1 + ", R" + registro2);
            codeList.addLast("MFHI R" + ansRegister);
            freeBinaryRegisterInteger(registro1,registro2);
        }
        else if(tipo1.equals(".word64") || tipo2.equals(".word64"))
        {
            ansRegister=getFreeRegister();
            codeList.addLast("DDIV R" + registro1 + ", R" + registro2);
            codeList.addLast("MFHI R" + ansRegister);
            freeBinaryRegisterInteger(registro1,registro2);
        }
    }

    void getSLT(String tipo, int registro1, int registro2)
    {
       if(tipo.equals(".word32") || tipo.equals(".word16") || tipo.equals(".word64") || tipo.equals("immediato"))
        {
            ansRegister = getFreeRegister();
            codeList.addLast("SLT R" + ansRegister + ",R"+registro1+",R"+registro2);
            freeBinaryRegisterInteger(registro1,registro2);
        }
        else
        {
            ansRegister = getFreeRegisterFloat();
            codeList.addLast("C.LT.D " + 3 + ",F"+registro1+",F"+registro2);
            confrontoFP();
            freeBinaryRegisterFloat(registro1,registro2);
        }
    }

    //Method that make a comparison between floating point in order to save the result in a known register
    void confrontoFP()
    {
        int registro1 = getFreeRegister();
        int registroF1 = getFreeRegisterFloat();
        int registroF2 = getFreeRegisterFloat();
        ansRegister = getFreeRegister();
        codeList.addLast("ADD.D F" + registroF2 + ",F0,F0");
        codeList.addLast("ADDI R"+registro1+",R0,1");
        codeList.addLast("DMTC1 R"+registro1+",F"+registroF1);
        codeList.addLast("MOVT.D F"+registroF2+",F"+registroF1+",3");
        codeList.addLast("DMFC1 R"+ansRegister + ",F"+registroF2);
        freeRegister(registro1);
        freeRegister(ansRegister);
        freeRegisterFloat(registroF1);
        freeRegisterFloat(registroF2);
    }

    //Method thatt allows to calculate the offset from the variable name
    String getOffset(int register,String tipo)
    {
        int register1;
        int register2;
        if(tipo.equals(".word16"))
        {
            register1=getFreeRegister();
            registroOffset=getFreeRegister();
            codeList.addLast("ADDI R" + register1 + ", R0, 2");
            codeList.addLast("MULT R" + register1 + ", R" + register);
            codeList.addLast("MFLO R" + registroOffset);
            freeRegister(register1);
            return "R"+registroOffset;
        }
        else if(tipo.equals(".word32"))
        {
            register1=getFreeRegister();
            registroOffset=getFreeRegister();
            codeList.addLast("ADDI R" + register1 + ", R0, 4");
            codeList.addLast("MULT R" + register1 + ", R" + register);
            codeList.addLast("MFLO R" + registroOffset);
            freeRegister(register1);
            return "R"+registroOffset;
        }
        else if(tipo.equals(".word64") ||  tipo.equals(".double") )
        {
            register1=getFreeRegister();
            registroOffset=getFreeRegister();
            codeList.addLast("DADDI R" + register1 + ", R0, 8");
            codeList.addLast("DMULT R" + register1 + ", R" + register);
            codeList.addLast("MFLO R" + registroOffset);
            freeRegister(register1);
            return "R"+registroOffset;
        }
        return "";
    }

    //createthe output file
    void MakeOutputFile()
    {
        File file= new File(outputPath);
        try
        {
            FileOutputStream fos = new FileOutputStream(file);
            DataOutputStream dos=new DataOutputStream(fos);
            dos.writeBytes(".data\n");
            Collection c = identificatori.values();
            Set s11=identificatori.keySet();
            for(Iterator itr = s11.iterator();itr.hasNext();)
            {
                Object i1=itr.next();
                dos.writeBytes(i1.toString()+":\t");
                Identificatore iden=identificatori.getByCompleteName((String)i1);

                dos.writeBytes(iden.tipo+"  ");
                dos.writeBytes(iden.valore+"\n");
                //dos.writeBytes(s2);
            }
            dos.writeBytes("\n\n.code\n");
            dos.writeBytes("J main\n");
            for(Iterator it=codeList.listIterator();it.hasNext();)
            {
                String s1=(String)it.next()+"\n";
                dos.writeBytes(s1);
            }
            dos.writeBytes("NOP");
        }
        catch(Exception e)
        {
        }
    }

    void initializePrinting()
    {
        Vector preprocs = preprocessorInfoChannel.extractLinesPrecedingTokenNumber( new Integer(1) );
        printPreprocs(preprocs);
    }

    void finalizePrinting()
    {
         MakeOutputFile();
        // flush any leftover preprocessing instructions to the stream

        printPreprocs(
            preprocessorInfoChannel.extractLinesPrecedingTokenNumber(
                    new Integer( preprocessorInfoChannel.getMaxTokenNumber() + 1 ) ));
        //print a newline so file ends at a new line
        currentOutput.println();
    }

    void printPreprocs( Vector preprocs )
    {
        // if there was a preprocessingDirective previous to this token then
        // print a newline and the directive, line numbers handled later
        if ( preprocs.size() > 0 )
        {
            if ( trueSourceFile != null )
            {
                currentOutput.println();  //make sure we're starting a new line unless this is the first line directive
            }
            lineNum++;
            Enumeration e = preprocs.elements();
            while (e.hasMoreElements())
            {
                Object o = e.nextElement();
                if ( o.getClass().getName().equals("LineObject") )
                {
                    LineObject l = (LineObject) o;

                    // we always return to the trueSourceFile, we never enter it from another file
                    // force it to be returning if in fact we aren't currently in trueSourceFile
                    if (( trueSourceFile != null ) //trueSource exists
                            && ( !currentSource.equals(trueSourceFile.getSource()) ) //currently not in trueSource
                            && ( trueSourceFile.getSource().equals(l.getSource())  ) )
                    { //returning to trueSource
                        l.setEnteringFile( false );
                        l.setReturningToFile( true );
                    }


                    // print the line directive
                    currentOutput.println(l);
                    lineNum = l.getLine();
                    currentSource = l.getSource();

                    // the very first line directive always represents the true sourcefile
                    if ( trueSourceFile == null )
                    {
                        trueSourceFile = new LineObject(currentSource);
                        sourceFiles.push(trueSourceFile);
                    }

                    // keep our own stack of files entered
                    if ( l.getEnteringFile() )
                    {
                        sourceFiles.push(l);
                    }

                    // if returning to a file, pop the exited files off the stack
                    if ( l.getReturningToFile() )
                    {
                        LineObject top = (LineObject) sourceFiles.peek();
                        while (( top != trueSourceFile ) && (! l.getSource().equals(top.getSource()) ))
                        {
                            sourceFiles.pop();
                            top = (LineObject) sourceFiles.peek();
                        }
                    }
                }
                else
                { // it was a #pragma or such
                    currentOutput.println(o);
                    lineNum++;
                }
            }
        }
    }

    void print( TNode t )
    {
        int tLineNum = t.getLocalLineNum();
        if ( tLineNum == 0 ) tLineNum = lineNum;

        Vector preprocs = preprocessorInfoChannel.extractLinesPrecedingTokenNumber((Integer)t.getAttribute("tokenNumber"));
        printPreprocs(preprocs);

        if ( (lineNum != tLineNum) )
        {
            // we know we'll be newlines or a line directive or it probably
            // is just the case that this token is on the next line
            // either way start a new line and indent it
            currentOutput.println();
            lineNum++;
            printTabs();
        }

        if ( lineNum == tLineNum )
        {
            // do nothing special, we're at the right place
        }
        else
        {
            int diff = tLineNum - lineNum;
            if ( lineNum < tLineNum )
            {
                // print out the blank lines to bring us up to right line number
                for ( ; lineNum < tLineNum ; lineNum++ )
                {
                    currentOutput.println();
                }
                printTabs();
            }
            else
            { // just reset lineNum
                lineNum = tLineNum;
            }
        }
       // currentOutput.print("pagghiazzo\n"); /*io */
        currentOutput.print( t.getText() + " " );
    }


    /* This was my attempt at being smart about line numbers
       It didn't work quite right but I don't know why, I didn't
       have enough test cases.  Worked ok compiling rcs and ghostscript
    */
    void printAddingLineDirectives( TNode t )
    {
        int tLineNum = t.getLocalLineNum();
        String tSource = (String) t.getAttribute("source");

        if ( tSource == null ) tSource = currentSource;
        if ( tLineNum == 0 ) tLineNum = lineNum;

        Vector preprocs = preprocessorInfoChannel.extractLinesPrecedingTokenNumber((Integer)t.getAttribute("tokenNumber"));
        printPreprocs(preprocs);

        if ( (lineNum != tLineNum) || !currentSource.equals(tSource) )
        {
            // we know we'll be newlines or a line directive or it probably
            // is just the case that this token is on the next line
            // either way start a new line and indent it
            currentOutput.println();
            lineNum++;
            printTabs();
        }

        if ( ( lineNum == tLineNum ) && ( currentSource.equals(tSource) ) )
        {
            // do nothing special, we're at the right place
        }
        else if ( currentSource.equals(tSource) )
        {
            int diff = tLineNum - lineNum;
            if (diff > 0 && diff < lineDirectiveThreshold)
            {
                // print out the blank lines to bring us up to right line number
                for ( ; lineNum < tLineNum ; lineNum++ )
                {
                    currentOutput.println();
                }
            }
            else
            { // print line directive to get us to right line number
                // preserve flags 3 and 4 if present in current file
                if ( ! sourceFiles.empty() )
                {
                    LineObject l = (LineObject) sourceFiles.peek();
                    StringBuffer tFlags = new StringBuffer("");
                    if (l.getSystemHeader())
                    {
                        tFlags.append(" 3");
                    }
                    if (l.getTreatAsC())
                    {
                        tFlags.append(" 4");
                    }
                    currentOutput.println("# " + tLineNum + " \"" + tSource + "\"" + tFlags.toString());
                    lineNum = tLineNum;
                }
            }
            printTabs();
        }
        else
        { // different source
            Enumeration sources = sourceFiles.elements();
            // see if we're returning to a file we entered earlier
            boolean returningToEarlierFile = false;
            while (sources.hasMoreElements())
            {
                LineObject l = (LineObject) sources.nextElement();
                if (l.getSource().equals(tSource))
                {
                    returningToEarlierFile = true;
                    break;
                }
            }
            if (returningToEarlierFile)
            {
                // pop off the files we're exiting, but never pop the trueSourceFile
                LineObject l = (LineObject) sourceFiles.peek();
                while ( ( l != trueSourceFile ) &&(! l.getSource().equals(tSource) ) )
                {
                    sourceFiles.pop();
                    l = (LineObject) sourceFiles.peek();
                }

                // put in the return flag, plus others as needed
                StringBuffer tFlags = new StringBuffer(" 2");
                if (l.getSystemHeader())
                {
                    tFlags.append(" 3");
                }
                if (l.getTreatAsC())
                {
                    tFlags.append(" 4");
                }

                currentOutput.println("# " + tLineNum + " \"" + tSource + "\"" + tFlags);
                lineNum = tLineNum;
                currentSource = tSource;
                printTabs();
            }
            else
            {       // entering a file that wasn't in the original source
                    // pretend we're entering it from top of stack
                currentOutput.println("# " + tLineNum + " \"" + tSource + "\"" + " 1");
                lineNum = tLineNum;
                currentSource = tSource;
                printTabs();
            }
        }
        currentOutput.print( t.getText() + " " );
    }

    /** It is not ok to print newlines from the String passed in as
    it will screw up the line number handling **/
    void print( String s )
    {
        currentOutput.print( s + " " );
    }

    void printTabs()
    {
        for ( int i = 0; i< tabs; i++ )
        {
            currentOutput.print( "\t" );
        }
    }

    void commaSep( TNode t )
    {
        print( t );
        if ( t.getNextSibling() != null )
        {
            print( "," );
        }
    }

    int traceDepth = 0;
    public void reportError(RecognitionException ex)
    {
        if ( ex != null)
        {
            System.err.println("ANTLR Tree Parsing RecognitionException Error: " + ex.getClass().getName() + " " + ex );
            ex.printStackTrace(System.err);
        }
    }

    public void reportError(NoViableAltException ex)
    {
        System.err.println("ANTLR Tree Parsing NoViableAltException Error: " + ex.toString());
        TNode.printTree( ex.node );
        ex.printStackTrace(System.err);
    }

    public void reportError(MismatchedTokenException ex)
    {
        if ( ex != null)
        {
            TNode.printTree( ex.node );
            System.err.println("ANTLR Tree Parsing MismatchedTokenException Error: " + ex );
            ex.printStackTrace(System.err);
        }
    }

    public void reportError(String s)
    {
        System.err.println("ANTLR Error from String: " + s);
    }

    public void reportWarning(String s)
    {
        System.err.println("ANTLR Warning from String: " + s);
    }

    protected void match(AST t, int ttype) throws MismatchedTokenException
    {
        //System.out.println("match("+ttype+"); cursor is "+t);
        super.match(t, ttype);
    }

    public void match(AST t, BitSet b) throws MismatchedTokenException
    {
        //System.out.println("match("+b+"); cursor is "+t);
        super.match(t, b);
    }

    protected void matchNot(AST t, int ttype) throws MismatchedTokenException
    {
        //System.out.println("matchNot("+ttype+"); cursor is "+t);
        super.matchNot(t, ttype);
    }

    public void traceIn(String rname, AST t)
    {
        traceDepth += 1;
        for (int x=0; x<traceDepth; x++) System.out.print(" ");
            super.traceIn(rname, t);
    }

    public void traceOut(String rname, AST t)
    {
        for (int x=0; x<traceDepth; x++) System.out.print(" ");
        super.traceOut(rname, t);
        traceDepth -= 1;
    }
}
translationUnit 
options {
	defaultErrorHandler=false;
}
:{ initializePrinting(); }
                ( externalList )?
                { finalizePrinting(); }
        ;

externalList :( externalDef )+
        ;

externalDef :declaration
        |       functionDef
        |       asm_expr
        |       typelessDeclaration
        |       s:SEMI                          { print( s ); }
        ;

typelessDeclaration :#(NTypeMissing initDeclList s: SEMI)    { print( s ); }
        ;

asm_expr :#( a:"asm"                              { print( a ); } 
                 ( v:"volatile"                         { print( v ); } 
                 )? 
                    lc:LCURLY                           { print( lc ); tabs++; }
                    expr
                    rc:RCURLY                           { tabs--; print( rc ); }
                    s:SEMI                              { print( s ); }
                )
        ;

declaration :#( NDeclaration
                    declSpecifiers 
                    (                   
                        initDeclList
                    )?
                    ( s:SEMI { print( s ); } )+
                )
        ;

declSpecifiers :( storageClassSpecifier
                | typeQualifier
                | typeSpecifier
                )+
        ;

storageClassSpecifier :a:"auto"                                { print( a ); }
        |       b:"register"                    { print( b ); }
        |       c:"typedef"                     { print( c ); }
        |       functionStorageClassSpecifier
        ;

functionStorageClassSpecifier :a:"extern"                      { print( a ); }
        |       b:"static"                      { print( b ); }
        |       c:"inline"                      { print( c ); }
        ;

typeQualifier :a:"const"                       { print( a ); }
        |       b:"volatile"                    { print( b ); }
        ;

typeSpecifier :a:"void"				{ print( a ); }
        |       b:"char"                        	{ print( b ); }
        |       c:"short"                       	{ tipoDichiarazione = ".word16"; print( c ); }
        |       d:"int"                          	{ tipoDichiarazione = ".word32"; print( d ); }
        |       e:"long"                        	{ tipoDichiarazione = ".word64"; print( e ); }
        |       f:"float"                        	{ print( f ); throw new SemanticException("In Edumips non sono supportati i float, ma solo i double!!"); }
        |       g:"double"                              { tipoDichiarazione = ".double"; print( g ); }
        |       h:"signed"                      	{ print( h ); }
        |       i:"unsigned"                    	{ print( i ); }
        |       structSpecifier ( attributeDecl )*
        |       unionSpecifier  ( attributeDecl )*
        |       enumSpecifier
        |       typedefName
        |       #(n:"typeof" lp:LPAREN             { print( n ); print( lp ); }
                    ( (typeName )=> typeName 
                    | expr
                    )
                    rp:RPAREN                      { print( rp ); }
                )
        |       p:"__complex"                   { print( p ); }
        ;

typedefName :#(NTypedefName i:ID         { print( i ); } )
        ;

structSpecifier :#( a:"struct"                       { print( a ); }
                structOrUnionBody
            )
        ;

unionSpecifier :#( a:"union"                        { print( a ); }
                structOrUnionBody
            )
        ;

structOrUnionBody :( (ID LCURLY) => i1:ID lc1:LCURLY   {FunzioneCorrente.push(i1.getText());print( i1 ); print ( "{" ); tabs++; }
                        ( structDeclarationList )?
                        rc1:RCURLY                  { FunzioneCorrente.pop();tabs--; print( rc1 ); }
                |   lc2:LCURLY                      { print( lc2 ); tabs++; }
                    ( structDeclarationList )?
                    rc2:RCURLY                      { tabs--; print( rc2 ); }
                | i2:ID                     { print( i2 ); }
                )
        ;

structDeclarationList :( structDeclaration             { print( ";" ); }
                )+
        ;

structDeclaration :specifierQualifierList structDeclaratorList
        ;

specifierQualifierList :(
                typeSpecifier
                | typeQualifier
                )+
        ;

structDeclaratorList :structDeclarator
                ( { print(","); } structDeclarator )*
        ;

structDeclarator :#( NStructDeclarator       
            ( declarator )?
            ( c:COLON { print( c ); } expr )?
            ( attributeDecl )*
        )
        ;

enumSpecifier :#(  a:"enum"                           { print( a ); }
                ( i:ID { print( i ); } )? 
                ( lc:LCURLY                        { print( lc ); tabs++; }
                    enumList 
                  rc:RCURLY                        { tabs--; print( rc ); }
                )?
            )
        ;

enumList :enumerator ( {print(",");} enumerator)*
        ;

enumerator :i:ID            { print( i ); }
                ( b:ASSIGN      { print( b ); }
                  expr
                )?
        ;

attributeDecl :#( a:"__attribute"              { print( a ); }
           (b:. { print( b ); } )*
        )
        | #( n:NAsmAttribute            { print( n ); }
             lp:LPAREN                  { print( lp ); }
             expr                       { print( ")" ); }
             rp:RPAREN                  { print( rp ); }
           )    
        ;

initDeclList :initDecl     
		( { print( "," ); } initDecl )*
        ;

initDecl { String declName = ""; }
:#(NInitDecl
                declarator
                ( attributeDecl )*
                ( a:ASSIGN              { print( a ); }
                  initializer
                | b:COLON               { print( b ); }
                  expr
                )?
                )
        ;

pointerGroup :#( NPointerGroup 
                   ( a:STAR             { print( a ); }
                    ( typeQualifier )* 
                   )+ 
                )
        ;

idList :i:ID                            { print( i ); }
                (  c:COMMA                      { print( c ); }
                   id:ID                        { print( id ); }
                )*
        ;

initializer :#( n:NInitializer (initializerElementLabel)?  expr )
                                                              
                {
                    String tipoVarInizializzata=identificatori.get(nomeIdCorrente).tipo;
                    ansType=tipoVarInizializzata;
                    //if we have a variable assignation (not an array) we must generate a store instruction   e.s int x=5;    sw R5,x(r0) where r5 contains 5
                    if(!identificatori.get(nomeIdCorrente).variabilepuntata.equals("vettore")  )
                    {
                        if(!tipoVarInizializzata.equals(".double"))
                        {
                            codeList.addLast(getStore(tipoVarInizializzata) + ansRegister + "," + creaSuffisso(nomeIdCorrente) + "(R0)");
                            freeRegister(ansRegister);
                        }
                        else
                        {
                            codeList.addLast(getStore(tipoVarInizializzata) + ansRegister + "," + creaSuffisso(nomeIdCorrente) + "(R0)");
                            freeRegisterFloat(ansRegister);
                        }
                    }
                }
                | lcurlyInitializer
        ;

initializerElementLabel :#( NInitializerElementLabel
                (
                    ( l:LBRACKET              { print( l ); }
                        expr
                        r:RBRACKET            { print( r ); }
                        (a1:ASSIGN             { print( a1 ); } )?
                    )
                    | i1:ID c:COLON           { print( i1 ); print( c ); } 
                    | d:DOT i2:ID a2:ASSIGN      { print( d ); print( i2 ); print( a2 ); }
                )
            )
        ;

lcurlyInitializer :#(n:NLcurlyInitializer    { print( n ); tabs++; }
                initializerList       
                rc:RCURLY               { tabs--; print( rc ); 
                                          String tipovettore=identificatori.get(nomeVettoreCorrente).tipo;  
                                          identificatori.put(nomeVettoreCorrente,new Identificatore(tipovettore, listaValori,"vettore"));
                                          listaValori="";
                                        } 
                )
        ;

initializerList :( i:initializer 
                                 
                    {
                        listaValori+=numero;
                        if(!i.getNextSibling().getText().equals("}"))
                            listaValori+=",";
                        commaSep( i );
                    }
                )*
        ;

declarator :#( NDeclarator
                ( pointerGroup )?               

                ( id:ID
                    {
                        if(flagFunzione==0)
                        {
                            print(id);
                            if(tipoDichiarazione.equals(".double"))
                                identificatori.put(id.getText(),new Identificatore(tipoDichiarazione,"0.0",creaSuffisso(id.getText()) + "(R0)"));
                            else
                                identificatori.put(id.getText(),new Identificatore(tipoDichiarazione,"0",creaSuffisso(id.getText()) + "(R0)"));
                                                        
                            //if i'm an array i write my name in nomeVettoreCorrente so that initialization can be carried out.
                            if(id.getNextSibling()!=null && id.getNextSibling().getText().equals("["))
                            {
                                nomeVettoreCorrente=id.getText();
                                nomeIdCorrente=id.getText();
                            }
                            else
                                nomeIdCorrente=id.getText();
                        }
                        else
                        {
                            System.out.println(id.getNextSibling());
                            if(id.getNextSibling()!=null)
                            {
                                System.out.println("Nome funzione: "+id.getText());
                                FunzioneCorrente.push(id.getText());
                                functionList.put(id.getText(),new InfoFunzione());
                                FunzioneCorrente.push(id.getText());
                                functionList.get(FunzioneCorrente.peek()).tipo_di_ritorno=tiporitorno;
                                if(!functionList.get(FunzioneCorrente.peek()).tipo_di_ritorno.equals("void"))
                                    identificatori.put("return",new Identificatore(getReturn(functionList.get(FunzioneCorrente.peek()).tipo_di_ritorno),"0",creaSuffisso("return")+"(R0)"));
                                codeList.addLast(id.getText()+":");
                                codeList.addLast("NOP");
                            }
                            else
                            {
                                if(flag_passaggio_parametri==0)
                                {
                                    String nome=FunzioneCorrente.peek();
                                    LinkedList l=(LinkedList)functionList.get(nome).lista_parametri;
                                    l.addLast(#id.getText());
                                    if(tipoCorrente.equals(".double"))
                                        identificatori.put(#id.getText(),new Identificatore(getReturn(tiporitorno),"0.0",creaSuffisso(id.getText()) + "(R0)"));
                                    else
                                       identificatori.put(#id.getText(),new Identificatore(getReturn(tiporitorno),"0",creaSuffisso(id.getText()) + "(R0)"));
                                                               
                                    print( id );
                                }
                            }
                        }
                   }
                | lp:LPAREN { print( lp ); } declarator rp:RPAREN { print( rp ); }
                )

                (   #( n:NParameterTypeList       { print( n ); }
                    (
                        parameterTypeList
                        | (idList)?
                    )
                    r:RPAREN                      { print( r ); }
                    )
                 | lb:LBRACKET { numero="";print( lb ); } ( expr )?
                            {
                                String init="";
                                String tipoVettore=tipoVettore=identificatori.get(nomeVettoreCorrente).tipo;
                                //if we find a number(no float-->exception) so that int x[number], we must compose the string   var: .type 0,0,0...number times
                                                            
                                if(!numero.equals("") && !isFloatNumber(numero))
                                {
                                    for(int i = 0; i<Integer.parseInt(numero); i++)
                                    {
                                        if(tipoVettore.equals(".double"))
                                        {
                                            init += "0.0";
                                            if(i<Integer.parseInt(numero)-1)
                                                init+=",";
                                        }
                                        else
                                        {
                                            init += "0";
                                            if(i<Integer.parseInt(numero)-1)
                                                init+=",";
                                        }
                                    }
                                }
                                else if(!numero.equals("") && isFloatNumber(numero))
                                { // float number found between []
                                    throw new SemanticException("La dimensione di un vettore non può essere numero float");
                                }
                                identificatori.put(nomeVettoreCorrente,new Identificatore(tipoVettore,init,"vettore"));
                            }
                        rb:RBRACKET { print( rb ); }
                )*
             )
        ;

parameterTypeList :( parameterDeclaration
                    ( c:COMMA { print( c ); }
                      | s:SEMI { print( s ); }
                    )?
                )+
                ( v:VARARGS { print( v ); } )?
        ;

parameterDeclaration :#( NParameterDeclaration
                decla:declSpecifiers {tipoCorrente= getReturn(decla.getText());}
                (declarator | nonemptyAbstractDeclarator)?
                )
        ;

functionDef :#( nome:NFunctionDef {flagFunzione=1; }
                ( functionDeclSpecifiers)? 
                  declarator {flagFunzione=0;} 
                (d:declaration  {System.out.println("d:"+d);} 
                 | v:VARARGS    { print( v ); }
                )*
                compoundStatement
            )
            {
                if(!FunzioneCorrente.peek().equals("main"))
                {
                    if(!functionList.get(FunzioneCorrente.peek()).tipo_di_ritorno.equals("void"))
                    codeList.addLast((getStore(ansType) + ansRegister + ",return_"+FunzioneCorrente.peek() + "(R0)"));
                    codeList.addLast("ret_"+FunzioneCorrente.peek()+":	JR R31");
                }
                FunzioneCorrente.pop();
            }
        ;

functionDeclSpecifiers :( functionStorageClassSpecifier
                | typeQualifier
                | value:typeSpecifier
                    {
                        if(!(value.getText()).equals("void"))
                        {
                            tiporitorno=value.getText();
                        }
                        else
                            tiporitorno="void";
                    }
                )+
        ;

declarationList :(   //ANTLR doesn't know that declarationList properly eats all the declarations
                    //so it warns about the ambiguity
                    options { warnWhenFollowAmbig = false; } :
                localLabelDecl
                |  declaration
                )+
        ;

localLabelDecl :#(a:"__label__"             { print( a ); }
              ( i:ID                    { commaSep( i ); }
              )+
                                        { print( ";" ); }
            )
        ;

compoundStatement :#( cs:NCompoundStatement                { print( cs ); tabs++; }
                ( declarationList
                | functionDef
                )*
                ( statementList )?
                rc:RCURLY                               { tabs--; print( rc ); }
                )                               
                                                
        ;

statementList :( statement )+
        ;

statement :statementBody
        ;

statementBody :s:SEMI                          { print( s ); }

        |       compoundStatement       // Group of statements

        |       #(NStatementExpr
                expr                    { print( ";" ); }
                )                    // Expressions

// Iteration statements:

        |       #( w:"while" 
                    {
                        print( w ); print( "(" );
                        strutturePendenti.push("while");
                        int label=getFreeLabelWhile();
                        WhilePendenti.push(label);
                        codeList.addLast("WHILE_LOOP_"+WhilePendenti.peek() + ":"); print( ";" );
                    }
                expr 
                    {
                        print( ")" );
                        String reg_stl="R"+this.lastAssignedRegister;
                        codeList.addLast("BEQZ "+reg_stl+",END_WHILE_LOOP_"+WhilePendenti.peek());  
                    } 
                statement
                    {
                         codeList.addLast("J WHILE_LOOP_"+WhilePendenti.peek());
                         codeList.addLast("END_WHILE_LOOP_"+WhilePendenti.peek()+ ":");
                         codeList.addLast("NOP");
                         WhilePendenti.pop();
                         strutturePendenti.pop();
                     }
)

        |       #( d:"do"
                        {
                            int label=getFreeLabelDo();
                            strutturePendenti.push("dowhile");
                            DoPendenti.push(label);
                            codeList.addLast("DO_LOOP_"+DoPendenti.peek() + ":");
                            codeList.addLast("NOP");
                            print( d );
                        }
                        statement
                        { print( " while ( " ); }

                        expr
                        { 
                            String reg_stl="R"+this.lastAssignedRegister;
                            codeList.addLast("BEQZ "+reg_stl+",END_DO_LOOP_"+DoPendenti.peek());
                            codeList.addLast("END_DO_LOOP_"+DoPendenti.peek()+ ":");
                            codeList.addLast("NOP");
                            DoPendenti.pop();
                            strutturePendenti.pop();
                            print( " );" );
                        }
                )

        |       #( f:"for" { print( f ); print( "(" ); }
                   expr
                        {
                            int label=getFreeLabelFor();
                            strutturePendenti.push("for");
                            ForPendenti.push(label);
                            codeList.addLast("FOR_LOOP_"+ForPendenti.peek() + ":");
                            codeList.addLast("NOP");
                            print( ";" );
                        }
                   expr    
                        {
                            String reg_stl="R"+this.lastAssignedRegister;
                            codeList.addLast("BEQZ "+reg_stl+",END_FOR_LOOP"+ForPendenti.peek());
                            print( ";" );
                            statement(_t.getNextSibling());
                            variabileSinistra = "";
                        }
                   
                  //statement
                  expr    
                        {
                            codeList.addLast("J FOR_LOOP_"+ForPendenti.peek());
                            codeList.addLast("END_FOR_LOOP"+ForPendenti.peek()+ ":");
                            codeList.addLast("NOP");
                            ForPendenti.pop();
                            strutturePendenti.pop();
                            print( ")" );
                        }
                )

        // Jump statements:
        |       #( g:"goto"             { print( g );}
                   expr                 { print( ";" ); } 
                )
        |       c:"continue"            
                        {
                            print( c ); print( ";" );
                            if(strutturePendenti.empty() || strutturePendenti.peek().equals("switch"))
                                throw new SemanticException("continue compatibile solo i loop");
                            if(strutturePendenti.peek().equals("while"))
                                codeList.addLast("J WHILE_LOOP_"+WhilePendenti.peek());
                            else if(strutturePendenti.peek().equals("dowhile"))
                                codeList.addLast("J DO_LOOP_"+DoPendenti.peek());
                            else if(strutturePendenti.peek().equals("for"))
                                codeList.addLast("J FOR_LOOP_"+ForPendenti.peek());
                        }
        |       b:"break"  
                        {
                            print( b ); print( ";" );
                            if(strutturePendenti.empty())
                                throw new SemanticException("break compatibile solo con switch e loop");
                            if(strutturePendenti.peek().equals("while"))
                                codeList.addLast("J END_WHILE_LOOP_"+WhilePendenti.peek());
                            else if(strutturePendenti.peek().equals("dowhile"))
                                codeList.addLast("J END_DO_LOOP_"+WhilePendenti.peek());
                            else if(strutturePendenti.peek().equals("for"))
                                codeList.addLast("J END_FOR_LOOP"+ForPendenti.peek());
                            else if(strutturePendenti.peek().equals("switch"))
                                codeList.addLast("J END_LOOP_CASE" + SwitchPendenti.peek());
                         }
        |       #( r:"return" 
                        {
                            registroRitorno=ansRegister;
                            //  ritorno=1;
                            print( r );
                        }
                ( ris: expr )? 
                        {
                            if(!functionList.get(FunzioneCorrente.peek()).tipo_di_ritorno.equals("void"))
                                codeList.addLast((getStore(ansType) + ansRegister + ",return_"+FunzioneCorrente.peek() + "(R0)"));

                            registroRitorno=ansRegister;
                            codeList.addLast("JR R31"); print( ";" ); }
                )


// Labeled statements:
        |       #( NLabel 
                ni:ID                   { print( ni ); print( ":" ); }
                ( statement )?
                )

        |       #( 
                    ca:"case"               { print( ca );}
                    expr
                        {
                            print( ":" );
                            int indice=this.getFreeLabelCase();
                            codeList.addLast("DSUB R"+getFreeRegister()+",R"+ansRegister+",R"+SwitchLabelPendenti.peek());
                            codeList.addLast("BNEZ R"+lastAssignedRegister+",END_LABEL_CASE"+indice);
                        }
                    (statement)?
                        {
                             codeList.addLast("END_LABEL_CASE"+lastAssignedCase + ":");
                             codeList.addLast("NOP");
                        }
                )

        |       #( 
                de:"default"            { print( de ); print( ":" ); }
                (statement)? 
                )



// Selection statements:

        |       #( i:"if"               
                        {
                            print( i ); print( "(" );
                            ifPendenti.push(getFreeLabelIf());
                            codeList.addLast("IF_STATEM_"+ ifPendenti.peek() + ":"); print( ";" );
                        }
                 expr   
                        {
                            print( ")" );
                            codeList.addLast("BEQZ R" + ansRegister + ", " + "IF_STATEM_ELSE_" + ifPendenti.peek());
                        }
                statement 
                        {
                            codeList.addLast("J IF_STATEM_END_" + ifPendenti.peek());
                            codeList.addLast("IF_STATEM_ELSE_" + ifPendenti.peek() + ":");
                            codeList.addLast("NOP");
                        }
                (   e:"else" { print( e );}

                    statement 
                )?
                        {
                            codeList.addLast("IF_STATEM_END_" + ifPendenti.peek() + ":");
                            codeList.addLast("NOP");
                            ifPendenti.pop();
                        }
                )
        |       #( sw:"switch" 
                        {
                            print( sw );
                            strutturePendenti.push("switch");
                            int label=getFreeLabelSwitch();
                            SwitchPendenti.push(label);
                            codeList.addLast("SWITCH_LOOP_"+SwitchPendenti.peek() + ":");
                            print( "(" );
                        }
                    expr
                        {
                            print( ")" );
                            SwitchLabelPendenti.push(ansRegister);
                        }
                    statement
                        {
                            codeList.addLast("END_LOOP_CASE"+SwitchPendenti.peek()+ ":");
                            codeList.addLast("NOP");
                            SwitchPendenti.pop();
                            strutturePendenti.pop();
                        }
                )
        ;

expr :binaryExpr
        |       conditionalExpr
        |       castExpr
        |       unaryExpr
        |       postfixExpr
        |       primaryExpr
        |       emptyExpr
        |       compoundStatementExpr
        |       initializer
        |       rangeExpr
        |       gnuAsmExpr
        ;

emptyExpr :NEmptyExpression
        ;

compoundStatementExpr :#(l:LPAREN                  { print( l ); }
                compoundStatement 
                r:RPAREN                { print( r ); }
            )
        ;

rangeExpr :#(NRangeExpr expr v:VARARGS{ print( v ); } expr)
        ;

gnuAsmExpr :#(  n:NGnuAsmExpr           { print( n ); }
                (v:"volatile"           { print( v ); } )?
                    lp:LPAREN           { print( lp ); }
                    stringConst
                    (   options         { warnWhenFollowAmbig = false; }:
                        c1:COLON        { print( c1 );}
                    (   strOptExprPair
                        (   c2:COMMA    { print( c2 ); } strOptExprPair)*
                    )?
                    (   options         { warnWhenFollowAmbig = false; }:
                        c3:COLON            { print( c3 ); }
                        (   strOptExprPair
                                ( c4:COMMA { print( c4 ); } strOptExprPair)*
                        )?
                    )?
                )?
                ( c5:COLON              { print( c5 ); }
                  stringConst 
                  ( c6:COMMA            { print( c6 ); }
                    stringConst
                  )* 
                )?
                rp:RPAREN               { print( rp ); }
            )
        ;

strOptExprPair :stringConst 
            ( 
            l:LPAREN                    { print( l ); }
            expr 
            r:RPAREN                    { print( r ); }
            )?
        ;

binaryOperator :ASSIGN          {operazioniPendenti.push(1);}
        |       DIV_ASSIGN      {operazioniPendenti.push(2);}
        |       PLUS_ASSIGN     {operazioniPendenti.push(3);}
        |       MINUS_ASSIGN    {operazioniPendenti.push(4);}
        |       STAR_ASSIGN     {operazioniPendenti.push(5);}
        |       MOD_ASSIGN      {operazioniPendenti.push(6);}
        |       RSHIFT_ASSIGN   {operazioniPendenti.push(7);}
        |       LSHIFT_ASSIGN   {operazioniPendenti.push(8);}
        |       BAND_ASSIGN     {operazioniPendenti.push(9);}
        |       BOR_ASSIGN      {operazioniPendenti.push(10);}
        |       BXOR_ASSIGN     {operazioniPendenti.push(11);}
        |       LOR             {operazioniPendenti.push(12);}
        |       LAND            {operazioniPendenti.push(13);}
        |       BOR             {operazioniPendenti.push(14);}
        |       BXOR            {operazioniPendenti.push(15);}
        |       BAND            {operazioniPendenti.push(16);}
        |       EQUAL           {operazioniPendenti.push(17);}
        |       NOT_EQUAL       {operazioniPendenti.push(18);}
        |       LT              {operazioniPendenti.push(19);}
        |       LTE             {operazioniPendenti.push(20);}
        |       GT              {operazioniPendenti.push(21);}
        |       GTE             {operazioniPendenti.push(22);}
        |       LSHIFT          {operazioniPendenti.push(23);}
        |       RSHIFT          {operazioniPendenti.push(24);}
        |       PLUS            {operazioniPendenti.push(25);}
        |       MINUS           {operazioniPendenti.push(26);}
        |       STAR            {operazioniPendenti.push(27);}
        |       DIV             {operazioniPendenti.push(28);}
        |       MOD             {operazioniPendenti.push(29);}
        |       NCommaExpr      {operazioniPendenti.push(30);}
        ;

binaryExpr :b:binaryOperator
                    // no rules allowed as roots, so here I manually get 
                    // the first and second children of the binary operator
                    // and then print them out in the right order
                    {
                        TNode e1, e2;
                        e1 = (TNode) b.getFirstChild();
                        e2 = (TNode) e1.getNextSibling();

                        expr(e1);
                        //if we have an assign operation we must save the offset computed from the expr(e1) so that we can generate a dual store for this side
                        if(operazioniPendenti.peek()==1 || operazioniPendenti.peek()==2 || operazioniPendenti.peek()==3 || operazioniPendenti.peek()==4 ||operazioniPendenti.peek()==5 || operazioniPendenti.peek()==6 || operazioniPendenti.peek()==7 || operazioniPendenti.peek()==8 || operazioniPendenti.peek()==9 || operazioniPendenti.peek()==10 || operazioniPendenti.peek()==11)
                        {
                            offsetLatoSinistro=ultimoOffsetCalcolato;
                            tipoLatoSinistro=ansType;
                        }
                        //lato sinistro dell'operatore
                        int registroRisultato1=ansRegister;
                        String tipoRisultato1=ansType;

                        if(!OffsetPuntatore.equals(""))
                       {
                           offsetLatoSinistro=OffsetPuntatore;
                           OffsetPuntatore="";
                       }

                        variabileSinistra = getVariableName(ultimoOffsetCalcolato);
                        tipoId = identificatori.get(variabileSinistra).tipo;

                        print( b );
                        expr( e2 );
                        //lato destro dell'operatore
                        int registroRisultato2=ansRegister;
                        String tipoRisultato2=ansType;

                        if(!OffsetPuntatore.equals(""))
                        {
                            OffsetPuntatore="";
                            String variableName = getVariableName(ultimoOffsetCalcolato);
                            //it permits to maintain the left identifier of a pointer operator
                            identificatori.put(variabileSinistra,new Identificatore(tipoId, identificatori.get(variabileSinistra).valore,this.ultimoOffsetCalcolato));
                            
                            //this allows us to consider the differences between array and variables e.g. vett(R5) --> daddi r4,r0, vett; dadd r4, r4, r5
                            if(identificatori.get(variableName).variabilepuntata.equals("vettore"))
                            {
                                codeList.addLast("DADDI R"+ansRegister+",R0,"+creaSuffisso(variableName));
                                codeList.addLast("DADD R"+ansRegister+",R" + ansRegister + ","+ extractOffset(ultimoOffsetCalcolato));
                            }
                            else
                                codeList.addLast("DADDI R"+ansRegister+",R0,"+creaSuffisso(variableName));
                        }

                        //estraiamo l'operazione corrente dalla cima dello stack
                        operazioneBinaria=operazioniPendenti.pop();
                        switch(operazioneBinaria)
                        {
                            case 1: //assegnazione
                                codeList.addLast(getStore(tipoRisultato1) + registroRisultato2 + "," + offsetLatoSinistro);
                                freeBinaryRegister(tipoRisultato1,registroRisultato1,registroRisultato2);
                                break;

                            case 2: //diviso = "/="
                                //verifico il tipo dell'identificatore sulla sinistra dell'uguale
                                if(!tipoId.equals(".double"))
                                {
                                    registroRisultato1 = getFreeRegister();
                                }
                                else
                                {
                                    registroRisultato1 = getFreeRegisterFloat();
                                }
                                codeList.addLast(getLoad(tipoId) + registroRisultato1 + "," +offsetLatoSinistro);
                                getDivisione(registroRisultato1, tipoRisultato1, registroRisultato2, tipoRisultato2);
                                codeList.addLast(getStore(tipoId) + ansRegister + "," + offsetLatoSinistro);
                                break;

                                case 3: //piu uguale "+="
                                    //verifico il tipo dell'identificatore sulla sinistra dell'uguale
                                    if(!tipoId.equals(".double"))
                                        registroRisultato1 = getFreeRegister();
                                    else
                                        registroRisultato1 = getFreeRegisterFloat();
                                    codeList.addLast(getLoad(tipoId) + registroRisultato1 + "," + offsetLatoSinistro);
                                    getSomma(registroRisultato1, tipoRisultato1, registroRisultato2, tipoRisultato2);
                                    codeList.addLast(getStore(tipoId) + ansRegister + "," + offsetLatoSinistro);
                                    break;

                                case 4: //meno uguale "-="
                                    //verifico il tipo dell'identificatore sulla sinistra dell'uguale
                                    if(!tipoId.equals(".double"))
                                    {
                                        registroRisultato1 = getFreeRegister();
                                    }
                                    else
                                    {
                                        registroRisultato1 = getFreeRegisterFloat();
                                    }
                                    codeList.addLast(getLoad(tipoId) + registroRisultato1 + "," + offsetLatoSinistro);
                                    getSottrazione(registroRisultato1, tipoRisultato1, registroRisultato2, tipoRisultato2);
                                    codeList.addLast(getStore(tipoId) + ansRegister + "," + offsetLatoSinistro);
                                    break;

                                case 5: //per uguale "*="
                                    //verifico il tipo dell'identificatore sulla sinistra dell'uguale
                                    if(!tipoId.equals(".double"))
                                    {
                                        registroRisultato1 = getFreeRegister();
                                    }
                                    else
                                    {
                                        registroRisultato1 = getFreeRegisterFloat();
                                    }
                                    codeList.addLast(getLoad(tipoId) + registroRisultato1 + "," + offsetLatoSinistro);
                                    getMoltiplicazione(registroRisultato1, tipoRisultato1, registroRisultato2, tipoRisultato2);
                                    codeList.addLast(getStore(tipoId) + ansRegister + "," + offsetLatoSinistro);
                                    break;

                                case 6: //modulo uguale "%="
                                    //verifico il tipo dell'identificatore sulla sinistra dell'uguale
                                    if(!tipoId.equals(".double"))
                                    {
                                        registroRisultato1 = getFreeRegister();
                                    }
                                    else
                                    {
                                        registroRisultato1 = getFreeRegisterFloat();
                                    }
                                    codeList.addLast(getLoad(tipoId) + registroRisultato1 + "," + offsetLatoSinistro);
                                    getModulo(registroRisultato1, tipoRisultato1, registroRisultato2, tipoRisultato2);
                                    codeList.addLast(getStore(tipoId) + ansRegister + "," + offsetLatoSinistro);
                                    break;

                                case 7: //">>="
                                    //verifico il tipo dell'identificatore sulla sinistra dell'uguale
                                    if(!tipoId.equals(".double"))
                                    {
                                        registroRisultato1 = getFreeRegister();
                                    }
                                    else
                                    {
                                        registroRisultato1 = getFreeRegisterFloat();
                                    }
                                    ansRegister = getFreeRegister();
                                    codeList.addLast(getLoad(tipoId) + ansRegister + "," + offsetLatoSinistro);
                                    if(tipoId.equals(".word64"))
                                        codeList.addLast("DSRAV R" + ansRegister + ",R"+ansRegister+",R"+registroRisultato2);
                                    else if(tipoId.equals(".word32") || tipoId.equals(".word16"))
                                        codeList.addLast("SRAV R" + ansRegister + ",R"+ansRegister+",R"+registroRisultato2);
                                    else
                                        throw new SemanticException("Non e consentito fare lo shift di floating point");
                                    codeList.addLast(getStore(tipoId) + ansRegister + "," + offsetLatoSinistro);
                                    freeBinaryRegister(tipoId,registroRisultato1,registroRisultato2);
                                    break;

                                case 8: //"<<="
                                    //verifico il tipo dell'identificatore sulla sinistra dell'uguale
                                    if(!tipoId.equals(".double"))
                                    {
                                        registroRisultato1 = getFreeRegister();
                                    }
                                    else
                                    {
                                        registroRisultato1 = getFreeRegisterFloat();
                                    }
                                    ansRegister = getFreeRegister();
                                    codeList.addLast(getLoad(tipoId) + ansRegister + "," + offsetLatoSinistro);
                                    if(tipoId.equals(".word64"))
                                        codeList.addLast("DSLLV R" + ansRegister + ",R"+ansRegister+",R"+registroRisultato2);
                                    else if(tipoId.equals(".word32") || tipoId.equals(".word16"))
                                        codeList.addLast("SLLV R" + ansRegister + ",R"+ansRegister+",R"+registroRisultato2);
                                    else
                                        throw new SemanticException("Non e consentito fare lo shift di floating point");
                                    codeList.addLast(getStore(tipoId) + ansRegister + "," + offsetLatoSinistro);
                                    freeBinaryRegister(tipoId,registroRisultato1,registroRisultato2);
                                    break;

                                case 9: //"&="
                                    // System.out.println("AND Uguale");
                                    if(!tipoId.equals(".double"))
                                    {
                                        registroRisultato1 = getFreeRegister();
                                    }
                                    else
                                    {
                                        registroRisultato1 = getFreeRegisterFloat();
                                    }
                                    ansRegister = getFreeRegister();
                                    codeList.addLast(getLoad(tipoId) + ansRegister + "," + offsetLatoSinistro);
                                    codeList.addLast("AND R"+ansRegister+", R" + ansRegister + ", R" + registroRisultato2);
                                    codeList.addLast(getStore(tipoId) + ansRegister + "," + offsetLatoSinistro);
                                    freeBinaryRegister(tipoId,registroRisultato1,registroRisultato2);
                                    break;

                                case 10: //"|="
                                    // System.out.println("OR Uguale");
                                    if(!tipoId.equals(".double"))
                                    {
                                        registroRisultato1 = getFreeRegister();
                                    }
                                    else
                                    {
                                        registroRisultato1 = getFreeRegisterFloat();
                                    }
                                    ansRegister = getFreeRegister();
                                    codeList.addLast(getLoad(tipoId) + ansRegister + "," + offsetLatoSinistro);
                                    codeList.addLast("OR R"+ansRegister+", R" + ansRegister + ", R" + registroRisultato2);
                                    codeList.addLast(getStore(tipoId) + ansRegister + "," + offsetLatoSinistro);
                                    freeBinaryRegister(tipoId,registroRisultato1,registroRisultato2);
                                    break;

                                case 11: //"^="
                                    // System.out.println("XOR Uguale");
                                    if(!tipoId.equals(".double"))
                                    {
                                        registroRisultato1 = getFreeRegister();
                                    }
                                    else
                                    {
                                        registroRisultato1 = getFreeRegisterFloat();
                                    }
                                    ansRegister = getFreeRegister();
                                    codeList.addLast(getLoad(tipoId) + ansRegister + "," + offsetLatoSinistro);
                                    codeList.addLast("XOR R"+ansRegister+", R" + ansRegister + ", R" + registroRisultato2);
                                    codeList.addLast(getStore(tipoId) + ansRegister + "," + offsetLatoSinistro);
                                    freeBinaryRegister(tipoId,registroRisultato1,registroRisultato2);
                                    break;

                                case 12: //||
                                case 14: //|
                                    // System.out.println("OR");
                                    ansRegister=getFreeRegister();
                                    codeList.addLast("OR R"+ansRegister+", R" + registroRisultato1 + ", R" + registroRisultato2);
                                    freeBinaryRegister(tipoId,registroRisultato1,registroRisultato2);
                                    break;

                                case 13: //&&
                                case 16: //&
                                    // System.out.println("AND");
                                    ansRegister=getFreeRegister();
                                    codeList.addLast("AND R"+ansRegister+", R" + registroRisultato1 + ", R" + registroRisultato2);
                                    freeBinaryRegister(tipoId,registroRisultato1,registroRisultato2);
                                    break;

                                case 15: //"^"
                                    // System.out.println("XOR");
                                    ansRegister=getFreeRegister();
                                    codeList.addLast("XOR R"+ansRegister+", R" + registroRisultato1 + ", R" + registroRisultato2);
                                    freeBinaryRegister(tipoId,registroRisultato1,registroRisultato2);
                                    break;

                                case 17: // "=="
                                    getUguaglianza(tipoId, registroRisultato1, registroRisultato2);
                                    break;

                                case 18: //"!="
                                    if(!tipoId.equals(".double"))
                                    {
                                        int ansRegister1 = getFreeRegister();
                                        codeList.addLast("SLT R" + ansRegister1 + ",R"+registroRisultato1+",R"+registroRisultato2);
                                        int ansRegister2 = getFreeRegister();
                                        codeList.addLast("SLT R" + ansRegister2 + ",R"+registroRisultato2+",R"+registroRisultato1);
                                        ansRegister=getFreeRegister();
                                        codeList.addLast("OR R" + ansRegister + ",R"+ansRegister1+",R"+ansRegister2);
                                        freeBinaryRegisterInteger(registroRisultato1,registroRisultato2);
                                        freeRegister(ansRegister1);
                                        freeRegister(ansRegister2);
                                    }
                                    else
                                    {
                                        codeList.addLast("C.EQ.D 3,F"+registroRisultato1+", F"+registroRisultato2);
                                        int registro1 = getFreeRegister();
                                        int registroF1 = getFreeRegisterFloat();
                                        int registroF2 = getFreeRegisterFloat();
                                        ansRegister=getFreeRegister();
                                        codeList.addLast("ADDI R"+registro1+",R0,1");
                                        codeList.addLast("DMTC1 R"+registro1+",F"+registroF1);
                                        codeList.addLast("MOVF.D F"+registroF2+",F"+registroF1+",3");
                                        codeList.addLast("DMFC1 R"+ansRegister + ",F"+registroF2);
                                        freeRegisterFloat(registroF1);
                                        freeRegisterFloat(registroF2);
                                        freeRegister(ansRegister);
                                        freeRegister(registro1);
                                    }
                                    break;

                                case 19: //<
                                    // System.out.println("minore");
                                    getSLT(tipoRisultato1, registroRisultato1, registroRisultato2);
                                    break;

                                case 20: //<=
                                    // System.out.println("minore uguale");
                                    getSLT(tipoRisultato1, registroRisultato1, registroRisultato2);
                                    int  ansTemp = ansRegister;
                                    getUguaglianza(tipoRisultato1, registroRisultato1, registroRisultato2);
                                    codeList.addLast("OR R"+ansRegister+",R"+ansRegister+",R"+ansTemp);
                                    freeRegister(ansTemp);
                                    break;

                                case 21: //>
                                    // System.out.println("minore");
                                    getSLT(tipoRisultato1, registroRisultato2, registroRisultato1);
                                    break;

                                case 22: //>=
                                    // System.out.println("minore o maggiore uguale");
                                    getSLT(tipoRisultato1, registroRisultato2, registroRisultato1);
                                    int ansTemp1 = ansRegister;
                                    getUguaglianza(tipoRisultato1, registroRisultato1, registroRisultato2);
                                    codeList.addLast("OR R"+ansRegister+",R"+ansRegister+",R"+ansTemp1);
                                    freeRegister(ansTemp1);
                                    break;

                                case 23: //"<<"
                                    //verifico il tipo dell'identificatore sulla sinistra dell'uguale
                                    ansRegister = getFreeRegister();
                                    if(tipoId.equals(".word64"))
                                        codeList.addLast("DSLLV R" + ansRegister + ",R"+registroRisultato1+",R"+registroRisultato2);
                                    else if(tipoId.equals(".word32") || tipoId.equals(".word16"))
                                        codeList.addLast("SLLV R" + ansRegister + ",R"+registroRisultato1+",R"+registroRisultato2);
                                    else
                                        throw new SemanticException("Non e consentito fare lo shift di floating point");
                                    freeBinaryRegisterInteger(registroRisultato1,registroRisultato2);
                                    break;

                                case 24: //">>"
                                    //verifico il tipo dell'identificatore sulla sinistra dell'uguale
                                    ansRegister = getFreeRegister();
                                    if(tipoId.equals(".word64"))
                                        codeList.addLast("DSRAV R" + ansRegister + ",R"+registroRisultato1+",R"+registroRisultato2);
                                    else if(tipoId.equals(".word32") || tipoId.equals(".word16"))
                                        codeList.addLast("SRAV R" + ansRegister + ",R"+registroRisultato1+",R"+registroRisultato2);
                                    else
                                        throw new SemanticException("Non e consentito fare lo shift di floating point");
                                    freeBinaryRegisterInteger(registroRisultato1,registroRisultato2);
                                    break;

                                case 25: //piu
                                    getSomma(registroRisultato1, tipoRisultato1, registroRisultato2, tipoRisultato2);
                                    break;

                                case 26: //meno
                                    getSottrazione(registroRisultato1, tipoRisultato1, registroRisultato2, tipoRisultato2);
                                    break;

                                case 27: //per
                                    getMoltiplicazione(registroRisultato1, tipoRisultato1, registroRisultato2, tipoRisultato2);
                                    break;

                                case 28: //diviso
                                    getDivisione(registroRisultato1, tipoRisultato1, registroRisultato2, tipoRisultato2);
                                    break;

                                case 29: //modulo
                                    getModulo(registroRisultato1, tipoRisultato1, registroRisultato2, tipoRisultato2);
                                    break;
                            }
                    }
        ;

conditionalExpr :#( q:QUESTION 
                expr                    { print( q ); }
                ( expr )? 
                c:COLON                 { print( c ); }
                expr 
                )
        ;

castExpr :#( 
                c:NCast                 { print( c ); }
                typeName                
                rp:RPAREN               { print( rp ); }
                expr 
                )
        ;

typeName :specifierQualifierList (nonemptyAbstractDeclarator)?
        ;

nonemptyAbstractDeclarator :#( NNonemptyAbstractDeclarator
            (   pointerGroup
                (   (lp1:LPAREN                         { print( lp1 ); }
                    (   nonemptyAbstractDeclarator
                        | parameterTypeList
                    )?
                    rp1:RPAREN                          { print( rp1 ); }
                    )
                | (
                    lb1:LBRACKET                        { print( lb1 ); }
                    (expr)? 
                    rb1:RBRACKET                        { print( rb1 ); }
                  )
                )*

            |  (   (lp2:LPAREN                          { print( lp2 ); }
                    (   nonemptyAbstractDeclarator
                        | parameterTypeList
                    )?
                    rp2:RPAREN                          { print( rp2 ); }
                   )
                | (
                    lb2:LBRACKET                        { print( lb2 ); }
                    (expr)? 
                    rb2:RBRACKET                        { print( rb2 ); }
                  )
                )+
            )
            )
        ;

unaryExpr :#( i:INC  expr
                        {
                            //in the prefix increment or decrement we must assign the incremented value
                            int tempReg;
                            TNode temp=(TNode)unaryExpr_AST_in.getFirstChild();
                            if(temp.getText().equals(""))
                                tipoId = identificatori.get(temp.getFirstChild().getText()).tipo;
                            else
                                tipoId = identificatori.get(temp.getText()).tipo;
                            if(tipoId.equals(".double"))
                                tempReg = getFreeRegisterFloat();
                            else
                                tempReg = getFreeRegister();
                            codeList.addLast(getLoad(tipoId)+ansRegister+","+ ultimoOffsetCalcolato);
                            if(tipoId.equals(".word64"))
                            {
                                codeList.addLast("DADDI R"+tempReg+",R"+ansRegister+",1");
                                ansRegister = tempReg;
                            }
                            else if(!tipoId.equals(".double"))
                            {
                                codeList.addLast("ADDI R"+tempReg+",R"+ansRegister+",1");
                                ansRegister = tempReg;
                            }
                            else
                            {
                                int registro1 = getFreeRegister();
                                codeList.addLast("ADDI R"+registro1+",R0,1");
                                getSomma(registro1, ".word32",ansRegister,tipoId);
                            }
                            codeList.addLast(getStore(tipoId)+ansRegister+","+ ultimoOffsetCalcolato);
                            freeRegister(tempReg);
                            freeRegister(ansRegister);
                            print( i );
        				}
                    )

        |       #( d:DEC  expr
                        {

                            int tempReg;
                            TNode temp=(TNode)unaryExpr_AST_in.getFirstChild();
                            if(temp.getText().equals(""))
                                tipoId = identificatori.get(temp.getFirstChild().getText()).tipo;
                            else
                                tipoId = identificatori.get(temp.getText()).tipo;
                            if(tipoId.equals(".double"))
                                tempReg = getFreeRegisterFloat();
                            else
                                tempReg = getFreeRegister();
                            codeList.addLast(getLoad(tipoId)+ansRegister+","+ ultimoOffsetCalcolato);
                            if(tipoId.equals(".word64"))
                            {
                                codeList.addLast("DADDI R"+tempReg+",R"+ansRegister+",-1");
                                ansRegister = tempReg;
                            }
                            else if(!tipoId.equals(".double"))
                            {
                                codeList.addLast("ADDI R"+tempReg+",R"+ansRegister+",-1");
                                ansRegister = tempReg;
                            }
                            else
                            {
                                int registro1 = getFreeRegister();
                                codeList.addLast("ADDI R"+registro1+",R0,1");
                                getSottrazione(ansRegister,tipoId,registro1, ".word32");
						}
                            codeList.addLast(getStore(tipoId)+ansRegister+","+ ultimoOffsetCalcolato);
                            freeRegister(tempReg);
                            freeRegister(ansRegister);
                            print( d );
                        }
                    )

        |       #( NUnaryExpr u:unaryOperator
                        {
                            int registroRisultato1  = ansRegister;
                            print( u );
                        }
                        expr
                        {
                            operazioneBinaria=operazioniPendenti.pop();
                            switch(operazioneBinaria)
                            {
                                case 31: //uguale &
                                    OffsetPuntatore=ultimoOffsetCalcolato;
                                    break;

                                case 32: // *
                                    if(tipoId.equals(".double"))
                                        ansRegister=getFreeRegisterFloat();
                                    else
                                        ansRegister = getFreeRegister();
                                    String variableName = getVariableName(ultimoOffsetCalcolato);
                                    ultimoOffsetCalcolato=identificatori.get(variableName).variabilepuntata;
                                    codeList.addLast(getLoad(tipoId)+ansRegister +","+ identificatori.get(variableName).variabilepuntata);
                                    break;

                                case 33: //uguale piu "=+"
                                    //verifico il tipo dell'identificatore sulla sinistra dell'uguale
                                    getSomma(0,ansType, ansRegister, ansType);
                                    break;

                                case 34: //uguale meno "=-"
                                    //verifico il tipo dell'identificatore sulla sinistra dell'uguale
                                    getSottrazione(0, ansType, ansRegister, ansType);
                                    break;

                                case 36://not "!"
                                    int tempRegister = getFreeRegister();
                                    codeList.addLast("ADDI R"+tempRegister + ",R0,1");
                                    codeList.addLast("SUB R"+ansRegister+",R"+tempRegister+",R"+ansRegister);
                            }
                        }
                )
        |       #( s:"sizeof"                           { print( s ); }
                    ( ( LPAREN typeName )=> 
                        lps:LPAREN                      { print( lps ); }
                        typeName 
                        rps:RPAREN                      { print( rps ); }
                    | expr
                    )
                )
        |       #( a:"__alignof"                        { print( a ); }
                    ( ( LPAREN typeName )=> 
                        lpa:LPAREN                      { print( lpa ); }
                        typeName 
                        rpa:RPAREN                      { print( rpa ); }
                    | expr
                    )
                )
        ;

unaryOperator :BAND            {operazioniPendenti.push(31); 
                                 flag_puntamento=1;}
        |       STAR            {operazioniPendenti.push(32);}
        |       PLUS            {operazioniPendenti.push(33);}
        |       MINUS           {operazioniPendenti.push(34);}
        |       BNOT            {operazioniPendenti.push(35);}
        |       LNOT            {operazioniPendenti.push(36);}
        |       LAND            {operazioniPendenti.push(37);}
        |       "__real"
        |       "__imag"
        ;

postfixExpr :#( NPostfixExpr 
                    primaryExpr 
                    ( a:PTR b:ID                        { print( a ); print( b ); }
                    | c:DOT d:ID                        { print( c ); print( d ); }
                    | #( n:NFunctionCallArgs            { print( n ); }
                        (argExprList)?
                        rp:RPAREN                       
                                {
                                    codeList.addLast("JAL "+nome_funzione);
                                    if(!functionList.get(nome_funzione).tipo_di_ritorno.equals("void"))
                                        codeList.addLast(getLoad(getReturn(functionList.get(FunzioneCorrente.peek()).tipo_di_ritorno)) + ansRegister + ",return_" +nome_funzione+"(R0)");
                                    print( rp );
                                }
                        )
                    | lb:LBRACKET
                                {
                                    print( lb );
                                    tipo = tipoCorrente;
                                }
                        expr 
                        rb:RBRACKET
                                {
                                    print( rb );
                                    tipoCorrente = tipo;
                                    int loadRegister;
                                    String tipoVettore=identificatori.getByCompleteName(nomeVettoreCorrente).tipo;
                                    if(tipoVettore.equals(".double"))
                                        loadRegister=getFreeRegisterFloat();
                                    else
                                        loadRegister=getFreeRegister();
                                    ultimoOffsetCalcolato=nomeVettoreCorrente + "("  + getOffset(ansRegister, tipoVettore) + ")";
                                    codeList.addLast(getLoad(identificatori.getByCompleteName(nomeVettoreCorrente).tipo) + loadRegister + ", " + ultimoOffsetCalcolato);
                                    ansRegister=loadRegister;
                                    ansType=tipoVettore;
                                }
                    | f:INC    
                                {
                                    int tempReg;
                                    TNode temp=(TNode)postfixExpr_AST_in.getFirstChild();
                                    if(variabileSinistra.equals(""))
                                        variabileSinistra = temp.getText();
                                    tipoId = identificatori.get(variabileSinistra).tipo;
                                    if(tipoId.equals(".double"))
                                    {
                                        ansRegister = getFreeRegisterFloat();
                                        if(variabileSinistra.equals(temp.getText()))
                                            tempReg = ansRegister;
                                        else
                                            tempReg = getFreeRegisterFloat();
                                        freeRegisterFloat(tempReg);
                                        freeRegisterFloat(ansRegister);
                                    }
                                    else
                                    {
                                        ansRegister = getFreeRegister();
                                        if(variabileSinistra.equals(temp.getText()))
                                            tempReg = ansRegister;
                                        else
                                            tempReg = getFreeRegister();
                                        freeRegister(tempReg);
                                        freeRegister(ansRegister);
                                    }

                                    codeList.addLast(getLoad(tipoId)+ansRegister+","+ ultimoOffsetCalcolato);
                                    if(tipoId.equals(".word64"))
                                        codeList.addLast("DADDI R"+tempReg+",R"+ansRegister+",1");
                                    else if(!tipoId.equals(".double"))
                                        codeList.addLast("ADDI R"+tempReg+",R"+ansRegister+",1");
                                    else
                                    {
                                        int registro1 = getFreeRegister();
                                        codeList.addLast("ADDI R"+registro1+",R0,1");
                                        getSomma(registro1, ".word32",ansRegister,tipoId);
                                        tempReg = ansRegister;
                                        freeRegister(registro1);
                                    }
                                    codeList.addLast(getStore(tipoId)+tempReg+","+ ultimoOffsetCalcolato);
                                    print( f );
                            }
                    | g:DEC
                            {
                                int tempReg;
                                TNode temp=(TNode)postfixExpr_AST_in.getFirstChild();
                                if(variabileSinistra.equals(""))
                                    variabileSinistra = temp.getText();
                                tipoId = identificatori.get(variabileSinistra).tipo;
                                ansRegister = getFreeRegister();
                                if(variabileSinistra.equals(temp.getText()))
                                    tempReg = ansRegister;
                                else
                                    tempReg = getFreeRegister();

                                tipoId = identificatori.get(variabileSinistra).tipo;
                                if(tipoId.equals(".double"))
                                {    ansRegister = getFreeRegisterFloat();
                                    if(variabileSinistra.equals(temp.getText()))
                                        tempReg = ansRegister;
                                    else
                                        tempReg = getFreeRegisterFloat();
                                    freeRegisterFloat(tempReg);
                                    freeRegisterFloat(ansRegister);
                                }
                                else
                                {    ansRegister = getFreeRegister();
                                    if(variabileSinistra.equals(temp.getText()))
                                        tempReg = ansRegister;
                                    else
                                        tempReg = getFreeRegister();
                                    freeRegister(tempReg);
                                    freeRegister(ansRegister);
                                }

                                codeList.addLast(getLoad(tipoId)+ansRegister+","+ ultimoOffsetCalcolato);
                                if(tipoId.equals(".word64"))
                                    codeList.addLast("DADDI R"+tempReg+",R"+ansRegister+",-1");
                                else if(!tipoId.equals(".double"))
                                    codeList.addLast("ADDI R"+tempReg+",R"+ansRegister+",-1");
                                else
                                {
                                    int registro1 = getFreeRegister();
                                    codeList.addLast("ADDI R"+registro1+",R0,1");
                                    getSottrazione(ansRegister,tipoId,registro1, ".word32");
                                    tempReg = ansRegister;
                                    freeRegister(registro1);
                                }
                                codeList.addLast(getStore(tipoId)+tempReg+","+ ultimoOffsetCalcolato);
                                print( g );
                            }
                    )+
                )
        ;

primaryExpr :i:ID    
                    {
                        print( i );
                        if(!is_a_function(i.getText()))
                        {
                            ansType=identificatori.get(i.getText()).tipo;
                            tipoId =  identificatori.get(i.getText()).tipo;
                            tipoCorrente = identificatori.get(i.getText()).tipo;
                            if(tipoId.equals(".double"))
                            {
                                ansRegister=getFreeRegisterFloat();
                                freeRegisterFloat(ansRegister);
                            }
                            else
                            {
                                ansRegister = getFreeRegister();
                                freeRegister(ansRegister);
                            }
                            //variabile o vettore (vengono caricati identificatori)
                            ultimoOffsetCalcolato=creaSuffisso(i.getText()) + "(R0)"; //è quello standard per il caricamento delle variabili es.  x(R0)
                            codeList.addLast(getLoad(tipoId) + ansRegister + ", " + ultimoOffsetCalcolato );

                            //se sono un vettore memorizzo il mio nome su nomeVettoreCorrente che servirà alla postfixExpr per comporre la load corretta
                            if(i.getNextSibling()!=null && i.getNextSibling().getText().equals("["))
                                nomeVettoreCorrente=creaSuffisso(i.getText());
                        }
                        else
                        {
                            ritorno=1;
                            flag_passaggio_parametri=1;
                            nome_funzione=i.getText();
                        }
                    }
        |       n:Number
                    {
                        print( n );
                        if(isFloatNumber(n))  //since immediate instructions for floting point do not exist we have to declarate new variables with the float numeric value
                        {
                            ansRegister=getFreeRegisterFloat();
                            ansType=".double";
                            numero=n.getText();
                            int registro1=getFreeRegisterFloat();
                            String label="label"+this.getFreeLabel();
                            String command=label+": .double "+n.getText();
                            String command2="LDC1 F"+registro1+","+creaSuffisso(label)+"(R0)";
                            identificatori.put(label,new Identificatore(".double", n.getText()));
                            codeList.addLast(command2);
                            codeList.addLast("ADD.D F" + ansRegister + ",F0,F" + registro1);
                            freeRegisterFloat(ansRegister);
                            freeRegisterFloat(registro1);
                        }
                        else //every not float numeric value is handled as 32 bit
                        {
                            ansRegister=getFreeRegister();
                            ansType=".word32";
                            numero=n.getText();
                            codeList.addLast("ADDI R" + ansRegister + ", R0," + n.getText());
                            freeRegister(ansRegister);
                        }
                    }
        |       charConst
        |       stringConst

// JTC:
// ID should catch the enumerator
// leaving it in gives ambiguous err
//      | enumerator

        |       #( eg:NExpressionGroup          { print( eg ); }
                 expr                           { print( ")" ); }
                )
        ;

argExprList :{
                flag_passaggio_parametri=1;
                cont=0;
            } 
            par1:expr (
                {
                    FunzioneCorrente.push(nome_funzione);
                    LinkedList l=(LinkedList)this.functionList.get(this.nome_funzione).lista_parametri;
                    String par=(String)l.get(cont);
                    cont++;
                    codeList.addLast(getStore(tipoCorrente)+ ansRegister+","+creaSuffisso(par)+"(R0)");
                    FunzioneCorrente.pop();
                    print( "," );
                 }
             par2:expr )*
                 {
                    FunzioneCorrente.push(nome_funzione);
                    LinkedList l=(LinkedList)this.functionList.get(this.nome_funzione).lista_parametri;
                    String par=(String)l.get(cont);
                    cont=0;
                    codeList.addLast(getStore(tipoCorrente)+ ansRegister+","+creaSuffisso(par)+"(R0)");
                    FunzioneCorrente.pop();
                    flag_passaggio_parametri=0;
                 }
        ;

protected charConst :c:CharLiteral                   { print( c ); }
        ;

protected stringConst :#( NStringSeq
                    (
                    s:StringLiteral                 { print( s ); }
                    )+
                )
        ;

protected intConst :IntOctalConst
        |       LongOctalConst
        |       UnsignedOctalConst
        |       IntIntConst
        |       LongIntConst
        |       UnsignedIntConst
        |       IntHexConst
        |       LongHexConst
        |       UnsignedHexConst
        ;

protected floatConst :FloatDoubleConst
        |       DoubleDoubleConst
        |       LongDoubleConst
        ;

// inherited from grammar GnuCTreeParser
commaExpr :#(NCommaExpr expr expr)
        ;

// inherited from grammar GnuCTreeParser
assignExpr :#( ASSIGN expr expr)
        |       #( DIV_ASSIGN expr expr)
        |       #( PLUS_ASSIGN expr expr)
        |       #( MINUS_ASSIGN expr expr)
        |       #( STAR_ASSIGN expr expr)
        |       #( MOD_ASSIGN expr expr)
        |       #( RSHIFT_ASSIGN expr expr)
        |       #( LSHIFT_ASSIGN expr expr)
        |       #( BAND_ASSIGN expr expr)
        |       #( BOR_ASSIGN expr expr)
        |       #( BXOR_ASSIGN expr expr)
        ;

// inherited from grammar GnuCTreeParser
logicalOrExpr :#( LOR expr expr) 
        ;

// inherited from grammar GnuCTreeParser
logicalAndExpr :#( LAND expr expr )
        ;

// inherited from grammar GnuCTreeParser
inclusiveOrExpr :#( BOR expr expr )
        ;

// inherited from grammar GnuCTreeParser
exclusiveOrExpr :#( BXOR expr expr )
        ;

// inherited from grammar GnuCTreeParser
bitAndExpr :#( BAND expr expr )
        ;

// inherited from grammar GnuCTreeParser
equalityExpr :#( EQUAL expr expr)
        |       #( NOT_EQUAL expr expr)
        ;

// inherited from grammar GnuCTreeParser
relationalExpr :#( LT expr expr)
        |       #( LTE expr expr)
        |       #( GT expr expr)
        |       #( GTE expr expr)
        ;

// inherited from grammar GnuCTreeParser
shiftExpr :#( LSHIFT expr expr)
                | #( RSHIFT expr expr)
        ;

// inherited from grammar GnuCTreeParser
additiveExpr :#( PLUS expr expr)
        |       #( MINUS expr expr)
        ;

// inherited from grammar GnuCTreeParser
multExpr :#( STAR expr expr)
        |       #( DIV expr expr)
        |       #( MOD expr expr)
        ;


