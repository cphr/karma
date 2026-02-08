/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.metrics;

// $ANTLR 3.2 Sep 23, 2009 12:02:23 Cpp.g 2009-12-06 17:34:36

import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

public class CppParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IFDEF", "IFNDEF", "IF", "ELSE", "ENDIF", "WARNING", "ERROR", "PRAGMA", "EXPR", "EXPR_DEF", "EXPR_NDEF", "UNARY_MINUS", "UNARY_PLUS", "REFERANCE", "TYPECAST", "SIZEOF_TYPE", "INDEX_OP", "POST_INC", "POST_DEC", "POINTER_AT", "POINTER", "EXPR_GROUP", "METHOD_CALL", "ARGS", "TEXT_LINE", "TEXT_GROUP", "TEXT_END", "EXPAND", "EXP_ARGS", "EXP_ARG", "EXEC_MACRO", "CONCATENATE", "LINE", "INCLUDE", "INCLUDE_EXPAND", "DEFINE", "UNDEF", "MAC_OBJECT", "MAC_FUNCTION", "MAC_FUNCTION_OBJECT", "MACRO_DEFINE", "DIRECTIVE", "End", "IDENTIFIER", "LPAREN", "WS", "RPAREN", "COMMA", "ELLIPSIS", "ELIF", "DECIMAL_LITERAL", "STRING_LITERAL", "ASSIGNEQUAL", "TIMESEQUAL", "DIVIDEEQUAL", "MODEQUAL", "PLUSEQUAL", "MINUSEQUAL", "SHIFTLEFTEQUAL", "SHIFTRIGHTEQUAL", "BITWISEANDEQUAL", "BITWISEXOREQUAL", "BITWISEOREQUAL", "QUESTIONMARK", "COLON", "OR", "AND", "BITWISEOR", "BITWISEXOR", "AMPERSAND", "NOTEQUAL", "EQUAL", "LESSTHAN", "GREATERTHAN", "LESSTHANOREQUALTO", "GREATERTHANOREQUALTO", "SHIFTLEFT", "SHIFTRIGHT", "PLUS", "MINUS", "STAR", "DIVIDE", "MOD", "PLUSPLUS", "MINUSMINUS", "SIZEOF", "DEFINED", "NOT", "TILDE", "LSQUARE", "RSQUARE", "DOT", "POINTERTO", "HEX_LITERAL", "OCTAL_LITERAL", "CHARACTER_LITERAL", "FLOATING_POINT_LITERAL", "STRINGIFICATION", "STRING_OP", "SEMICOLON", "SHARPSHARP", "CKEYWORD", "COPERATOR", "INCLUDE_FILE", "MACRO_TEXT", "LETTER", "LCURLY", "RCURLY", "POINTERTOMBR", "DOTMBR", "SCOPE", "EscapeSequence", "HexDigit", "IntegerTypeSuffix", "Exponent", "FloatTypeSuffix", "OctalEscape", "UnicodeEscape", "COMMENT", "LINE_COMMENT", "ESCAPED_NEWLINE"
    };
    public static final int STAR=84;
    public static final int LSQUARE=93;
    public static final int FloatTypeSuffix=119;
    public static final int LETTER=109;
    public static final int MOD=86;
    public static final int TYPECAST=18;
    public static final int POINTER=24;
    public static final int BITWISEXOR=72;
    public static final int MINUSMINUS=88;
    public static final int ASSIGNEQUAL=56;
    public static final int NOT=91;
    public static final int EOF=-1;
    public static final int UNARY_PLUS=16;
    public static final int NOTEQUAL=74;
    public static final int COPERATOR=106;
    public static final int MINUSEQUAL=61;
    public static final int RPAREN=50;
    public static final int MAC_FUNCTION=42;
    public static final int STRING_LITERAL=55;
    public static final int FLOATING_POINT_LITERAL=100;
    public static final int DOTMBR=113;
    public static final int INCLUDE=37;
    public static final int ENDIF=8;
    public static final int ARGS=27;
    public static final int COMMENT=122;
    public static final int REFERANCE=17;
    public static final int DIVIDE=85;
    public static final int TEXT_END=30;
    public static final int GREATERTHAN=77;
    public static final int LINE_COMMENT=123;
    public static final int MAC_FUNCTION_OBJECT=43;
    public static final int IntegerTypeSuffix=117;
    public static final int POINTERTOMBR=112;
    public static final int DEFINED=90;
    public static final int ELSE=7;
    public static final int CHARACTER_LITERAL=99;
    public static final int ELLIPSIS=52;
    public static final int LCURLY=110;
    public static final int EXPR_DEF=13;
    public static final int UNARY_MINUS=15;
    public static final int SEMICOLON=103;
    public static final int BITWISEXOREQUAL=65;
    public static final int ERROR=10;
    public static final int METHOD_CALL=26;
    public static final int ELIF=53;
    public static final int WS=49;
    public static final int CKEYWORD=105;
    public static final int SHARPSHARP=104;
    public static final int SHIFTLEFTEQUAL=62;
    public static final int OR=69;
    public static final int SIZEOF=89;
    public static final int INDEX_OP=20;
    public static final int EXPR_GROUP=25;
    public static final int DIVIDEEQUAL=58;
    public static final int LESSTHANOREQUALTO=78;
    public static final int INCLUDE_FILE=107;
    public static final int WARNING=9;
    public static final int EscapeSequence=115;
    public static final int DECIMAL_LITERAL=54;
    public static final int EXP_ARGS=32;
    public static final int STRING_OP=102;
    public static final int End=46;
    public static final int ESCAPED_NEWLINE=124;
    public static final int MAC_OBJECT=41;
    public static final int PLUSPLUS=87;
    public static final int PRAGMA=11;
    public static final int INCLUDE_EXPAND=38;
    public static final int SHIFTLEFT=80;
    public static final int Exponent=118;
    public static final int STRINGIFICATION=101;
    public static final int AND=70;
    public static final int DEFINE=39;
    public static final int EXPAND=31;
    public static final int POINTER_AT=23;
    public static final int POST_DEC=22;
    public static final int DIRECTIVE=45;
    public static final int HexDigit=116;
    public static final int LPAREN=48;
    public static final int IF=6;
    public static final int PLUSEQUAL=60;
    public static final int GREATERTHANOREQUALTO=79;
    public static final int EXPR=12;
    public static final int MODEQUAL=59;
    public static final int SCOPE=114;
    public static final int COMMA=51;
    public static final int IDENTIFIER=47;
    public static final int EQUAL=75;
    public static final int SHIFTRIGHT=81;
    public static final int QUESTIONMARK=67;
    public static final int TILDE=92;
    public static final int PLUS=82;
    public static final int HEX_LITERAL=97;
    public static final int EXP_ARG=33;
    public static final int SHIFTRIGHTEQUAL=63;
    public static final int UNDEF=40;
    public static final int DOT=95;
    public static final int MACRO_DEFINE=44;
    public static final int LESSTHAN=76;
    public static final int EXEC_MACRO=34;
    public static final int IFNDEF=5;
    public static final int TEXT_GROUP=29;
    public static final int TIMESEQUAL=57;
    public static final int OCTAL_LITERAL=98;
    public static final int AMPERSAND=73;
    public static final int IFDEF=4;
    public static final int BITWISEANDEQUAL=64;
    public static final int RSQUARE=94;
    public static final int MINUS=83;
    public static final int LINE=36;
    public static final int TEXT_LINE=28;
    public static final int BITWISEOR=71;
    public static final int CONCATENATE=35;
    public static final int MACRO_TEXT=108;
    public static final int COLON=68;
    public static final int UnicodeEscape=121;
    public static final int RCURLY=111;
    public static final int EXPR_NDEF=14;
    public static final int POST_INC=21;
    public static final int POINTERTO=96;
    public static final int OctalEscape=120;
    public static final int SIZEOF_TYPE=19;
    public static final int BITWISEOREQUAL=66;

    // delegates
    // delegators


        public CppParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CppParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
            this.state.ruleMemo = new HashMap[170+1];


        }

    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return CppParser.tokenNames; }
    public String getGrammarFileName() { return "Cpp.g"; }


    public static class preprocess_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "preprocess"
    // Cpp.g:54:1: preprocess : ( procLine )+ ;
    public final CppParser.preprocess_return preprocess() throws RecognitionException {
        CppParser.preprocess_return retval = new CppParser.preprocess_return();
        retval.start = input.LT(1);
        int preprocess_StartIndex = input.index();
        Object root_0 = null;

        CppParser.procLine_return procLine1 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 1) ) { return retval; }
            // Cpp.g:55:3: ( ( procLine )+ )
            // Cpp.g:55:5: ( procLine )+
            {
            root_0 = (Object)adaptor.nil();

            // Cpp.g:55:5: ( procLine )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==IF||(LA1_0>=WARNING && LA1_0<=PRAGMA)||LA1_0==TEXT_END||LA1_0==EXEC_MACRO||(LA1_0>=LINE && LA1_0<=UNDEF)||(LA1_0>=DIRECTIVE && LA1_0<=COMMA)||(LA1_0>=DECIMAL_LITERAL && LA1_0<=STRING_LITERAL)||LA1_0==SIZEOF||(LA1_0>=HEX_LITERAL && LA1_0<=COPERATOR)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // Cpp.g:0:0: procLine
            	    {
            	    pushFollow(FOLLOW_procLine_in_preprocess222);
            	    procLine1=procLine();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, procLine1.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 1, preprocess_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "preprocess"

    public static class procLine_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "procLine"
    // Cpp.g:58:1: procLine : ( DIRECTIVE | text_line | diagnostics | fileInclusion | macroDefine | macroUndef | conditionalCompilation | lineControl | macroExecution )? End ;
    public final CppParser.procLine_return procLine() throws RecognitionException {
        CppParser.procLine_return retval = new CppParser.procLine_return();
        retval.start = input.LT(1);
        int procLine_StartIndex = input.index();
        Object root_0 = null;

        Token DIRECTIVE2=null;
        Token End11=null;
        CppParser.text_line_return text_line3 = null;

        CppParser.diagnostics_return diagnostics4 = null;

        CppParser.fileInclusion_return fileInclusion5 = null;

        CppParser.macroDefine_return macroDefine6 = null;

        CppParser.macroUndef_return macroUndef7 = null;

        CppParser.conditionalCompilation_return conditionalCompilation8 = null;

        CppParser.lineControl_return lineControl9 = null;

        CppParser.macroExecution_return macroExecution10 = null;


        Object DIRECTIVE2_tree=null;
        Object End11_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 2) ) { return retval; }
            // Cpp.g:59:3: ( ( DIRECTIVE | text_line | diagnostics | fileInclusion | macroDefine | macroUndef | conditionalCompilation | lineControl | macroExecution )? End )
            // Cpp.g:60:3: ( DIRECTIVE | text_line | diagnostics | fileInclusion | macroDefine | macroUndef | conditionalCompilation | lineControl | macroExecution )? End
            {
            root_0 = (Object)adaptor.nil();

            // Cpp.g:60:3: ( DIRECTIVE | text_line | diagnostics | fileInclusion | macroDefine | macroUndef | conditionalCompilation | lineControl | macroExecution )?
            int alt2=10;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // Cpp.g:60:5: DIRECTIVE
                    {
                    DIRECTIVE2=(Token)match(input,DIRECTIVE,FOLLOW_DIRECTIVE_in_procLine242); if (state.failed) return retval;

                    }
                    break;
                case 2 :
                    // Cpp.g:61:5: text_line
                    {
                    pushFollow(FOLLOW_text_line_in_procLine249);
                    text_line3=text_line();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, text_line3.getTree());

                    }
                    break;
                case 3 :
                    // Cpp.g:62:5: diagnostics
                    {
                    pushFollow(FOLLOW_diagnostics_in_procLine256);
                    diagnostics4=diagnostics();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, diagnostics4.getTree());

                    }
                    break;
                case 4 :
                    // Cpp.g:63:5: fileInclusion
                    {
                    pushFollow(FOLLOW_fileInclusion_in_procLine262);
                    fileInclusion5=fileInclusion();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, fileInclusion5.getTree());

                    }
                    break;
                case 5 :
                    // Cpp.g:64:5: macroDefine
                    {
                    pushFollow(FOLLOW_macroDefine_in_procLine268);
                    macroDefine6=macroDefine();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, macroDefine6.getTree());

                    }
                    break;
                case 6 :
                    // Cpp.g:65:5: macroUndef
                    {
                    pushFollow(FOLLOW_macroUndef_in_procLine274);
                    macroUndef7=macroUndef();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, macroUndef7.getTree());

                    }
                    break;
                case 7 :
                    // Cpp.g:66:5: conditionalCompilation
                    {
                    pushFollow(FOLLOW_conditionalCompilation_in_procLine280);
                    conditionalCompilation8=conditionalCompilation();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, conditionalCompilation8.getTree());

                    }
                    break;
                case 8 :
                    // Cpp.g:67:5: lineControl
                    {
                    pushFollow(FOLLOW_lineControl_in_procLine286);
                    lineControl9=lineControl();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, lineControl9.getTree());

                    }
                    break;
                case 9 :
                    // Cpp.g:68:5: macroExecution
                    {
                    pushFollow(FOLLOW_macroExecution_in_procLine293);
                    macroExecution10=macroExecution();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, macroExecution10.getTree());

                    }
                    break;

            }

            End11=(Token)match(input,End,FOLLOW_End_in_procLine300); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            End11_tree = (Object)adaptor.create(End11);
            adaptor.addChild(root_0, End11_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 2, procLine_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "procLine"

    public static class fileInclusion_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "fileInclusion"
    // Cpp.g:72:1: fileInclusion : ( INCLUDE -> ^( INCLUDE ) | INCLUDE_EXPAND -> ^( INCLUDE_EXPAND ) );
    public final CppParser.fileInclusion_return fileInclusion() throws RecognitionException {
        CppParser.fileInclusion_return retval = new CppParser.fileInclusion_return();
        retval.start = input.LT(1);
        int fileInclusion_StartIndex = input.index();
        Object root_0 = null;

        Token INCLUDE12=null;
        Token INCLUDE_EXPAND13=null;

        Object INCLUDE12_tree=null;
        Object INCLUDE_EXPAND13_tree=null;
        RewriteRuleTokenStream stream_INCLUDE_EXPAND=new RewriteRuleTokenStream(adaptor,"token INCLUDE_EXPAND");
        RewriteRuleTokenStream stream_INCLUDE=new RewriteRuleTokenStream(adaptor,"token INCLUDE");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 3) ) { return retval; }
            // Cpp.g:73:3: ( INCLUDE -> ^( INCLUDE ) | INCLUDE_EXPAND -> ^( INCLUDE_EXPAND ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==INCLUDE) ) {
                alt3=1;
            }
            else if ( (LA3_0==INCLUDE_EXPAND) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // Cpp.g:73:5: INCLUDE
                    {
                    INCLUDE12=(Token)match(input,INCLUDE,FOLLOW_INCLUDE_in_fileInclusion314); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_INCLUDE.add(INCLUDE12);



                    // AST REWRITE
                    // elements: INCLUDE
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 73:14: -> ^( INCLUDE )
                    {
                        // Cpp.g:73:18: ^( INCLUDE )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_INCLUDE.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // Cpp.g:74:5: INCLUDE_EXPAND
                    {
                    INCLUDE_EXPAND13=(Token)match(input,INCLUDE_EXPAND,FOLLOW_INCLUDE_EXPAND_in_fileInclusion328); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_INCLUDE_EXPAND.add(INCLUDE_EXPAND13);



                    // AST REWRITE
                    // elements: INCLUDE_EXPAND
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 74:21: -> ^( INCLUDE_EXPAND )
                    {
                        // Cpp.g:74:24: ^( INCLUDE_EXPAND )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_INCLUDE_EXPAND.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 3, fileInclusion_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "fileInclusion"

    public static class macroDefine_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "macroDefine"
    // Cpp.g:77:1: macroDefine : ( DEFINE IDENTIFIER LPAREN ( WS )? RPAREN ( macro_text )? -> ^( MAC_FUNCTION_OBJECT IDENTIFIER ( macro_text )? ) | DEFINE mac= IDENTIFIER LPAREN ( WS )? (arg+= macroParam ( WS )? ( COMMA ( WS )* arg+= macroParam ( WS )* )* )? RPAREN ( macro_text )? -> ^( MAC_FUNCTION $mac ( $arg)+ ( macro_text )? ) | DEFINE IDENTIFIER ( macro_text )? -> ^( MAC_OBJECT IDENTIFIER ( macro_text )? ) );
    public final CppParser.macroDefine_return macroDefine() throws RecognitionException {
        CppParser.macroDefine_return retval = new CppParser.macroDefine_return();
        retval.start = input.LT(1);
        int macroDefine_StartIndex = input.index();
        Object root_0 = null;

        Token mac=null;
        Token DEFINE14=null;
        Token IDENTIFIER15=null;
        Token LPAREN16=null;
        Token WS17=null;
        Token RPAREN18=null;
        Token DEFINE20=null;
        Token LPAREN21=null;
        Token WS22=null;
        Token WS23=null;
        Token COMMA24=null;
        Token WS25=null;
        Token WS26=null;
        Token RPAREN27=null;
        Token DEFINE29=null;
        Token IDENTIFIER30=null;
        List list_arg=null;
        CppParser.macro_text_return macro_text19 = null;

        CppParser.macro_text_return macro_text28 = null;

        CppParser.macro_text_return macro_text31 = null;

        RuleReturnScope arg = null;
        Object mac_tree=null;
        Object DEFINE14_tree=null;
        Object IDENTIFIER15_tree=null;
        Object LPAREN16_tree=null;
        Object WS17_tree=null;
        Object RPAREN18_tree=null;
        Object DEFINE20_tree=null;
        Object LPAREN21_tree=null;
        Object WS22_tree=null;
        Object WS23_tree=null;
        Object COMMA24_tree=null;
        Object WS25_tree=null;
        Object WS26_tree=null;
        Object RPAREN27_tree=null;
        Object DEFINE29_tree=null;
        Object IDENTIFIER30_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleTokenStream stream_DEFINE=new RewriteRuleTokenStream(adaptor,"token DEFINE");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_macroParam=new RewriteRuleSubtreeStream(adaptor,"rule macroParam");
        RewriteRuleSubtreeStream stream_macro_text=new RewriteRuleSubtreeStream(adaptor,"rule macro_text");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 4) ) { return retval; }
            // Cpp.g:78:3: ( DEFINE IDENTIFIER LPAREN ( WS )? RPAREN ( macro_text )? -> ^( MAC_FUNCTION_OBJECT IDENTIFIER ( macro_text )? ) | DEFINE mac= IDENTIFIER LPAREN ( WS )? (arg+= macroParam ( WS )? ( COMMA ( WS )* arg+= macroParam ( WS )* )* )? RPAREN ( macro_text )? -> ^( MAC_FUNCTION $mac ( $arg)+ ( macro_text )? ) | DEFINE IDENTIFIER ( macro_text )? -> ^( MAC_OBJECT IDENTIFIER ( macro_text )? ) )
            int alt14=3;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // Cpp.g:78:5: DEFINE IDENTIFIER LPAREN ( WS )? RPAREN ( macro_text )?
                    {
                    DEFINE14=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_macroDefine350); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_DEFINE.add(DEFINE14);

                    IDENTIFIER15=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroDefine353); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER15);

                    LPAREN16=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_macroDefine356); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN16);

                    // Cpp.g:78:32: ( WS )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==WS) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // Cpp.g:0:0: WS
                            {
                            WS17=(Token)match(input,WS,FOLLOW_WS_in_macroDefine358); if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_WS.add(WS17);


                            }
                            break;

                    }

                    RPAREN18=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_macroDefine361); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN18);

                    // Cpp.g:78:44: ( macro_text )?
                    int alt5=2;
                    int LA5_0 = input.LA(1);

                    if ( (LA5_0==TEXT_END||(LA5_0>=IDENTIFIER && LA5_0<=COMMA)||(LA5_0>=DECIMAL_LITERAL && LA5_0<=STRING_LITERAL)||LA5_0==SIZEOF||(LA5_0>=HEX_LITERAL && LA5_0<=COPERATOR)) ) {
                        alt5=1;
                    }
                    switch (alt5) {
                        case 1 :
                            // Cpp.g:0:0: macro_text
                            {
                            pushFollow(FOLLOW_macro_text_in_macroDefine364);
                            macro_text19=macro_text();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_macro_text.add(macro_text19.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: macro_text, IDENTIFIER
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 78:57: -> ^( MAC_FUNCTION_OBJECT IDENTIFIER ( macro_text )? )
                    {
                        // Cpp.g:78:60: ^( MAC_FUNCTION_OBJECT IDENTIFIER ( macro_text )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MAC_FUNCTION_OBJECT, "MAC_FUNCTION_OBJECT"), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                        // Cpp.g:78:94: ( macro_text )?
                        if ( stream_macro_text.hasNext() ) {
                            adaptor.addChild(root_1, stream_macro_text.nextTree());

                        }
                        stream_macro_text.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // Cpp.g:79:5: DEFINE mac= IDENTIFIER LPAREN ( WS )? (arg+= macroParam ( WS )? ( COMMA ( WS )* arg+= macroParam ( WS )* )* )? RPAREN ( macro_text )?
                    {
                    DEFINE20=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_macroDefine384); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_DEFINE.add(DEFINE20);

                    mac=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroDefine388); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(mac);

                    LPAREN21=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_macroDefine391); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN21);

                    // Cpp.g:79:35: ( WS )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==WS) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // Cpp.g:0:0: WS
                            {
                            WS22=(Token)match(input,WS,FOLLOW_WS_in_macroDefine393); if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_WS.add(WS22);


                            }
                            break;

                    }

                    // Cpp.g:79:40: (arg+= macroParam ( WS )? ( COMMA ( WS )* arg+= macroParam ( WS )* )* )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==IDENTIFIER||LA11_0==ELLIPSIS) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // Cpp.g:79:41: arg+= macroParam ( WS )? ( COMMA ( WS )* arg+= macroParam ( WS )* )*
                            {
                            pushFollow(FOLLOW_macroParam_in_macroDefine400);
                            arg=macroParam();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_macroParam.add(arg.getTree());
                            if (list_arg==null) list_arg=new ArrayList();
                            list_arg.add(arg.getTree());

                            // Cpp.g:79:57: ( WS )?
                            int alt7=2;
                            int LA7_0 = input.LA(1);

                            if ( (LA7_0==WS) ) {
                                alt7=1;
                            }
                            switch (alt7) {
                                case 1 :
                                    // Cpp.g:0:0: WS
                                    {
                                    WS23=(Token)match(input,WS,FOLLOW_WS_in_macroDefine402); if (state.failed) return retval;
                                    if ( state.backtracking==0 ) stream_WS.add(WS23);


                                    }
                                    break;

                            }

                            // Cpp.g:79:61: ( COMMA ( WS )* arg+= macroParam ( WS )* )*
                            loop10:
                            do {
                                int alt10=2;
                                int LA10_0 = input.LA(1);

                                if ( (LA10_0==COMMA) ) {
                                    alt10=1;
                                }


                                switch (alt10) {
                            	case 1 :
                            	    // Cpp.g:79:62: COMMA ( WS )* arg+= macroParam ( WS )*
                            	    {
                            	    COMMA24=(Token)match(input,COMMA,FOLLOW_COMMA_in_macroDefine406); if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA24);

                            	    // Cpp.g:79:68: ( WS )*
                            	    loop8:
                            	    do {
                            	        int alt8=2;
                            	        int LA8_0 = input.LA(1);

                            	        if ( (LA8_0==WS) ) {
                            	            alt8=1;
                            	        }


                            	        switch (alt8) {
                            	    	case 1 :
                            	    	    // Cpp.g:0:0: WS
                            	    	    {
                            	    	    WS25=(Token)match(input,WS,FOLLOW_WS_in_macroDefine408); if (state.failed) return retval;
                            	    	    if ( state.backtracking==0 ) stream_WS.add(WS25);


                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    break loop8;
                            	        }
                            	    } while (true);

                            	    pushFollow(FOLLOW_macroParam_in_macroDefine413);
                            	    arg=macroParam();

                            	    state._fsp--;
                            	    if (state.failed) return retval;
                            	    if ( state.backtracking==0 ) stream_macroParam.add(arg.getTree());
                            	    if (list_arg==null) list_arg=new ArrayList();
                            	    list_arg.add(arg.getTree());

                            	    // Cpp.g:79:88: ( WS )*
                            	    loop9:
                            	    do {
                            	        int alt9=2;
                            	        int LA9_0 = input.LA(1);

                            	        if ( (LA9_0==WS) ) {
                            	            alt9=1;
                            	        }


                            	        switch (alt9) {
                            	    	case 1 :
                            	    	    // Cpp.g:0:0: WS
                            	    	    {
                            	    	    WS26=(Token)match(input,WS,FOLLOW_WS_in_macroDefine415); if (state.failed) return retval;
                            	    	    if ( state.backtracking==0 ) stream_WS.add(WS26);


                            	    	    }
                            	    	    break;

                            	    	default :
                            	    	    break loop9;
                            	        }
                            	    } while (true);


                            	    }
                            	    break;

                            	default :
                            	    break loop10;
                                }
                            } while (true);


                            }
                            break;

                    }

                    RPAREN27=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_macroDefine426); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN27);

                    // Cpp.g:80:11: ( macro_text )?
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==TEXT_END||(LA12_0>=IDENTIFIER && LA12_0<=COMMA)||(LA12_0>=DECIMAL_LITERAL && LA12_0<=STRING_LITERAL)||LA12_0==SIZEOF||(LA12_0>=HEX_LITERAL && LA12_0<=COPERATOR)) ) {
                        alt12=1;
                    }
                    switch (alt12) {
                        case 1 :
                            // Cpp.g:0:0: macro_text
                            {
                            pushFollow(FOLLOW_macro_text_in_macroDefine428);
                            macro_text28=macro_text();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_macro_text.add(macro_text28.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: mac, macro_text, arg
                    // token labels: mac
                    // rule labels: retval
                    // token list labels:
                    // rule list labels: arg
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_mac=new RewriteRuleTokenStream(adaptor,"token mac",mac);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_arg=new RewriteRuleSubtreeStream(adaptor,"token arg",list_arg);
                    root_0 = (Object)adaptor.nil();
                    // 80:33: -> ^( MAC_FUNCTION $mac ( $arg)+ ( macro_text )? )
                    {
                        // Cpp.g:80:36: ^( MAC_FUNCTION $mac ( $arg)+ ( macro_text )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MAC_FUNCTION, "MAC_FUNCTION"), root_1);

                        adaptor.addChild(root_1, stream_mac.nextNode());
                        if ( !(stream_arg.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_arg.hasNext() ) {
                            adaptor.addChild(root_1, stream_arg.nextTree());

                        }
                        stream_arg.reset();
                        // Cpp.g:80:63: ( macro_text )?
                        if ( stream_macro_text.hasNext() ) {
                            adaptor.addChild(root_1, stream_macro_text.nextTree());

                        }
                        stream_macro_text.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // Cpp.g:81:6: DEFINE IDENTIFIER ( macro_text )?
                    {
                    DEFINE29=(Token)match(input,DEFINE,FOLLOW_DEFINE_in_macroDefine464); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_DEFINE.add(DEFINE29);

                    IDENTIFIER30=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroDefine466); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER30);

                    // Cpp.g:81:24: ( macro_text )?
                    int alt13=2;
                    int LA13_0 = input.LA(1);

                    if ( (LA13_0==TEXT_END||(LA13_0>=IDENTIFIER && LA13_0<=COMMA)||(LA13_0>=DECIMAL_LITERAL && LA13_0<=STRING_LITERAL)||LA13_0==SIZEOF||(LA13_0>=HEX_LITERAL && LA13_0<=COPERATOR)) ) {
                        alt13=1;
                    }
                    switch (alt13) {
                        case 1 :
                            // Cpp.g:0:0: macro_text
                            {
                            pushFollow(FOLLOW_macro_text_in_macroDefine468);
                            macro_text31=macro_text();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_macro_text.add(macro_text31.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: IDENTIFIER, macro_text
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 81:43: -> ^( MAC_OBJECT IDENTIFIER ( macro_text )? )
                    {
                        // Cpp.g:81:46: ^( MAC_OBJECT IDENTIFIER ( macro_text )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MAC_OBJECT, "MAC_OBJECT"), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());
                        // Cpp.g:81:72: ( macro_text )?
                        if ( stream_macro_text.hasNext() ) {
                            adaptor.addChild(root_1, stream_macro_text.nextTree());

                        }
                        stream_macro_text.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 4, macroDefine_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "macroDefine"

    public static class macroParam_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "macroParam"
    // Cpp.g:84:1: macroParam : ( IDENTIFIER ELLIPSIS -> ^( ELLIPSIS IDENTIFIER ) | ELLIPSIS | IDENTIFIER );
    public final CppParser.macroParam_return macroParam() throws RecognitionException {
        CppParser.macroParam_return retval = new CppParser.macroParam_return();
        retval.start = input.LT(1);
        int macroParam_StartIndex = input.index();
        Object root_0 = null;

        Token IDENTIFIER32=null;
        Token ELLIPSIS33=null;
        Token ELLIPSIS34=null;
        Token IDENTIFIER35=null;

        Object IDENTIFIER32_tree=null;
        Object ELLIPSIS33_tree=null;
        Object ELLIPSIS34_tree=null;
        Object IDENTIFIER35_tree=null;
        RewriteRuleTokenStream stream_ELLIPSIS=new RewriteRuleTokenStream(adaptor,"token ELLIPSIS");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 5) ) { return retval; }
            // Cpp.g:85:3: ( IDENTIFIER ELLIPSIS -> ^( ELLIPSIS IDENTIFIER ) | ELLIPSIS | IDENTIFIER )
            int alt15=3;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==IDENTIFIER) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==ELLIPSIS) ) {
                    alt15=1;
                }
                else if ( (LA15_1==EOF||(LA15_1>=WS && LA15_1<=COMMA)) ) {
                    alt15=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA15_0==ELLIPSIS) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // Cpp.g:85:5: IDENTIFIER ELLIPSIS
                    {
                    IDENTIFIER32=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroParam504); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER32);

                    ELLIPSIS33=(Token)match(input,ELLIPSIS,FOLLOW_ELLIPSIS_in_macroParam506); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_ELLIPSIS.add(ELLIPSIS33);



                    // AST REWRITE
                    // elements: ELLIPSIS, IDENTIFIER
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 85:25: -> ^( ELLIPSIS IDENTIFIER )
                    {
                        // Cpp.g:85:27: ^( ELLIPSIS IDENTIFIER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_ELLIPSIS.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // Cpp.g:86:5: ELLIPSIS
                    {
                    root_0 = (Object)adaptor.nil();

                    ELLIPSIS34=(Token)match(input,ELLIPSIS,FOLLOW_ELLIPSIS_in_macroParam520); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    ELLIPSIS34_tree = (Object)adaptor.create(ELLIPSIS34);
                    adaptor.addChild(root_0, ELLIPSIS34_tree);
                    }

                    }
                    break;
                case 3 :
                    // Cpp.g:87:5: IDENTIFIER
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER35=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroParam526); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER35_tree = (Object)adaptor.create(IDENTIFIER35);
                    adaptor.addChild(root_0, IDENTIFIER35_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 5, macroParam_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "macroParam"

    public static class macroExecution_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "macroExecution"
    // Cpp.g:90:1: macroExecution : EXEC_MACRO ifexpression -> ^( EXEC_MACRO ifexpression ) ;
    public final CppParser.macroExecution_return macroExecution() throws RecognitionException {
        CppParser.macroExecution_return retval = new CppParser.macroExecution_return();
        retval.start = input.LT(1);
        int macroExecution_StartIndex = input.index();
        Object root_0 = null;

        Token EXEC_MACRO36=null;
        CppParser.ifexpression_return ifexpression37 = null;


        Object EXEC_MACRO36_tree=null;
        RewriteRuleTokenStream stream_EXEC_MACRO=new RewriteRuleTokenStream(adaptor,"token EXEC_MACRO");
        RewriteRuleSubtreeStream stream_ifexpression=new RewriteRuleSubtreeStream(adaptor,"rule ifexpression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 6) ) { return retval; }
            // Cpp.g:91:3: ( EXEC_MACRO ifexpression -> ^( EXEC_MACRO ifexpression ) )
            // Cpp.g:91:5: EXEC_MACRO ifexpression
            {
            EXEC_MACRO36=(Token)match(input,EXEC_MACRO,FOLLOW_EXEC_MACRO_in_macroExecution539); if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_EXEC_MACRO.add(EXEC_MACRO36);

            pushFollow(FOLLOW_ifexpression_in_macroExecution541);
            ifexpression37=ifexpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_ifexpression.add(ifexpression37.getTree());


            // AST REWRITE
            // elements: ifexpression, EXEC_MACRO
            // token labels:
            // rule labels: retval
            // token list labels:
            // rule list labels:
            // wildcard labels:
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 91:29: -> ^( EXEC_MACRO ifexpression )
            {
                // Cpp.g:91:32: ^( EXEC_MACRO ifexpression )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_EXEC_MACRO.nextNode(), root_1);

                adaptor.addChild(root_1, stream_ifexpression.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 6, macroExecution_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "macroExecution"

    public static class macroUndef_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "macroUndef"
    // Cpp.g:94:1: macroUndef : UNDEF mac= IDENTIFIER -> ^( UNDEF IDENTIFIER ) ;
    public final CppParser.macroUndef_return macroUndef() throws RecognitionException {
        CppParser.macroUndef_return retval = new CppParser.macroUndef_return();
        retval.start = input.LT(1);
        int macroUndef_StartIndex = input.index();
        Object root_0 = null;

        Token mac=null;
        Token UNDEF38=null;

        Object mac_tree=null;
        Object UNDEF38_tree=null;
        RewriteRuleTokenStream stream_UNDEF=new RewriteRuleTokenStream(adaptor,"token UNDEF");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 7) ) { return retval; }
            // Cpp.g:95:3: ( UNDEF mac= IDENTIFIER -> ^( UNDEF IDENTIFIER ) )
            // Cpp.g:95:5: UNDEF mac= IDENTIFIER
            {
            UNDEF38=(Token)match(input,UNDEF,FOLLOW_UNDEF_in_macroUndef564); if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_UNDEF.add(UNDEF38);

            mac=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroUndef568); if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(mac);



            // AST REWRITE
            // elements: UNDEF, IDENTIFIER
            // token labels:
            // rule labels: retval
            // token list labels:
            // rule list labels:
            // wildcard labels:
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 95:27: -> ^( UNDEF IDENTIFIER )
            {
                // Cpp.g:95:30: ^( UNDEF IDENTIFIER )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_UNDEF.nextNode(), root_1);

                adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 7, macroUndef_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "macroUndef"

    public static class conditionalCompilation_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "conditionalCompilation"
    // Cpp.g:98:1: conditionalCompilation : IF ifexp+= ifexpression ifstmt+= statement ( ELIF ifexp+= ifexpression ifstmt+= statement )* ( ELSE elsestmt= statement )? ENDIF -> ^( IF ( $ifexp $ifstmt)+ ( ELSE $elsestmt)? ) ;
    public final CppParser.conditionalCompilation_return conditionalCompilation() throws RecognitionException {
        CppParser.conditionalCompilation_return retval = new CppParser.conditionalCompilation_return();
        retval.start = input.LT(1);
        int conditionalCompilation_StartIndex = input.index();
        Object root_0 = null;

        Token IF39=null;
        Token ELIF40=null;
        Token ELSE41=null;
        Token ENDIF42=null;
        List list_ifexp=null;
        List list_ifstmt=null;
        CppParser.statement_return elsestmt = null;

        RuleReturnScope ifexp = null;
        RuleReturnScope ifstmt = null;
        Object IF39_tree=null;
        Object ELIF40_tree=null;
        Object ELSE41_tree=null;
        Object ENDIF42_tree=null;
        RewriteRuleTokenStream stream_ENDIF=new RewriteRuleTokenStream(adaptor,"token ENDIF");
        RewriteRuleTokenStream stream_ELIF=new RewriteRuleTokenStream(adaptor,"token ELIF");
        RewriteRuleTokenStream stream_IF=new RewriteRuleTokenStream(adaptor,"token IF");
        RewriteRuleTokenStream stream_ELSE=new RewriteRuleTokenStream(adaptor,"token ELSE");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        RewriteRuleSubtreeStream stream_ifexpression=new RewriteRuleSubtreeStream(adaptor,"rule ifexpression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 8) ) { return retval; }
            // Cpp.g:99:3: ( IF ifexp+= ifexpression ifstmt+= statement ( ELIF ifexp+= ifexpression ifstmt+= statement )* ( ELSE elsestmt= statement )? ENDIF -> ^( IF ( $ifexp $ifstmt)+ ( ELSE $elsestmt)? ) )
            // Cpp.g:99:5: IF ifexp+= ifexpression ifstmt+= statement ( ELIF ifexp+= ifexpression ifstmt+= statement )* ( ELSE elsestmt= statement )? ENDIF
            {
            IF39=(Token)match(input,IF,FOLLOW_IF_in_conditionalCompilation590); if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_IF.add(IF39);

            pushFollow(FOLLOW_ifexpression_in_conditionalCompilation595);
            ifexp=ifexpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_ifexpression.add(ifexp.getTree());
            if (list_ifexp==null) list_ifexp=new ArrayList();
            list_ifexp.add(ifexp.getTree());

            pushFollow(FOLLOW_statement_in_conditionalCompilation600);
            ifstmt=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(ifstmt.getTree());
            if (list_ifstmt==null) list_ifstmt=new ArrayList();
            list_ifstmt.add(ifstmt.getTree());

            // Cpp.g:100:4: ( ELIF ifexp+= ifexpression ifstmt+= statement )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==ELIF) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // Cpp.g:100:5: ELIF ifexp+= ifexpression ifstmt+= statement
            	    {
            	    ELIF40=(Token)match(input,ELIF,FOLLOW_ELIF_in_conditionalCompilation608); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_ELIF.add(ELIF40);

            	    pushFollow(FOLLOW_ifexpression_in_conditionalCompilation612);
            	    ifexp=ifexpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_ifexpression.add(ifexp.getTree());
            	    if (list_ifexp==null) list_ifexp=new ArrayList();
            	    list_ifexp.add(ifexp.getTree());

            	    pushFollow(FOLLOW_statement_in_conditionalCompilation617);
            	    ifstmt=statement();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_statement.add(ifstmt.getTree());
            	    if (list_ifstmt==null) list_ifstmt=new ArrayList();
            	    list_ifstmt.add(ifstmt.getTree());


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // Cpp.g:100:53: ( ELSE elsestmt= statement )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==ELSE) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // Cpp.g:100:54: ELSE elsestmt= statement
                    {
                    ELSE41=(Token)match(input,ELSE,FOLLOW_ELSE_in_conditionalCompilation624); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_ELSE.add(ELSE41);

                    pushFollow(FOLLOW_statement_in_conditionalCompilation629);
                    elsestmt=statement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_statement.add(elsestmt.getTree());

                    }
                    break;

            }

            ENDIF42=(Token)match(input,ENDIF,FOLLOW_ENDIF_in_conditionalCompilation633); if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_ENDIF.add(ENDIF42);



            // AST REWRITE
            // elements: ifstmt, ifexp, elsestmt, ELSE, IF
            // token labels:
            // rule labels: retval, elsestmt
            // token list labels:
            // rule list labels: ifexp, ifstmt
            // wildcard labels:
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_elsestmt=new RewriteRuleSubtreeStream(adaptor,"rule elsestmt",elsestmt!=null?elsestmt.tree:null);
            RewriteRuleSubtreeStream stream_ifexp=new RewriteRuleSubtreeStream(adaptor,"token ifexp",list_ifexp);
            RewriteRuleSubtreeStream stream_ifstmt=new RewriteRuleSubtreeStream(adaptor,"token ifstmt",list_ifstmt);
            root_0 = (Object)adaptor.nil();
            // 101:4: -> ^( IF ( $ifexp $ifstmt)+ ( ELSE $elsestmt)? )
            {
                // Cpp.g:101:8: ^( IF ( $ifexp $ifstmt)+ ( ELSE $elsestmt)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_IF.nextNode(), root_1);

                if ( !(stream_ifstmt.hasNext()||stream_ifexp.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_ifstmt.hasNext()||stream_ifexp.hasNext() ) {
                    adaptor.addChild(root_1, stream_ifexp.nextTree());
                    adaptor.addChild(root_1, stream_ifstmt.nextTree());

                }
                stream_ifstmt.reset();
                stream_ifexp.reset();
                // Cpp.g:101:31: ( ELSE $elsestmt)?
                if ( stream_elsestmt.hasNext()||stream_ELSE.hasNext() ) {
                    adaptor.addChild(root_1, stream_ELSE.nextNode());
                    adaptor.addChild(root_1, stream_elsestmt.nextTree());

                }
                stream_elsestmt.reset();
                stream_ELSE.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 8, conditionalCompilation_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "conditionalCompilation"

    public static class lineControl_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "lineControl"
    // Cpp.g:104:1: lineControl : LINE n= DECIMAL_LITERAL (theFile= STRING_LITERAL )? -> ^( LINE $n ( $theFile)? ) ;
    public final CppParser.lineControl_return lineControl() throws RecognitionException {
        CppParser.lineControl_return retval = new CppParser.lineControl_return();
        retval.start = input.LT(1);
        int lineControl_StartIndex = input.index();
        Object root_0 = null;

        Token n=null;
        Token theFile=null;
        Token LINE43=null;

        Object n_tree=null;
        Object theFile_tree=null;
        Object LINE43_tree=null;
        RewriteRuleTokenStream stream_STRING_LITERAL=new RewriteRuleTokenStream(adaptor,"token STRING_LITERAL");
        RewriteRuleTokenStream stream_LINE=new RewriteRuleTokenStream(adaptor,"token LINE");
        RewriteRuleTokenStream stream_DECIMAL_LITERAL=new RewriteRuleTokenStream(adaptor,"token DECIMAL_LITERAL");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 9) ) { return retval; }
            // Cpp.g:105:3: ( LINE n= DECIMAL_LITERAL (theFile= STRING_LITERAL )? -> ^( LINE $n ( $theFile)? ) )
            // Cpp.g:105:5: LINE n= DECIMAL_LITERAL (theFile= STRING_LITERAL )?
            {
            LINE43=(Token)match(input,LINE,FOLLOW_LINE_in_lineControl676); if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_LINE.add(LINE43);

            n=(Token)match(input,DECIMAL_LITERAL,FOLLOW_DECIMAL_LITERAL_in_lineControl680); if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_DECIMAL_LITERAL.add(n);

            // Cpp.g:105:28: (theFile= STRING_LITERAL )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==STRING_LITERAL) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // Cpp.g:105:29: theFile= STRING_LITERAL
                    {
                    theFile=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_lineControl685); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_STRING_LITERAL.add(theFile);


                    }
                    break;

            }



            // AST REWRITE
            // elements: LINE, n, theFile
            // token labels: theFile, n
            // rule labels: retval
            // token list labels:
            // rule list labels:
            // wildcard labels:
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_theFile=new RewriteRuleTokenStream(adaptor,"token theFile",theFile);
            RewriteRuleTokenStream stream_n=new RewriteRuleTokenStream(adaptor,"token n",n);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 105:55: -> ^( LINE $n ( $theFile)? )
            {
                // Cpp.g:105:57: ^( LINE $n ( $theFile)? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot(stream_LINE.nextNode(), root_1);

                adaptor.addChild(root_1, stream_n.nextNode());
                // Cpp.g:105:67: ( $theFile)?
                if ( stream_theFile.hasNext() ) {
                    adaptor.addChild(root_1, stream_theFile.nextNode());

                }
                stream_theFile.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 9, lineControl_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "lineControl"

    public static class diagnostics_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "diagnostics"
    // Cpp.g:108:1: diagnostics : ( WARNING -> ^( WARNING ) | ERROR -> ^( ERROR ) | PRAGMA -> ^( PRAGMA ) );
    public final CppParser.diagnostics_return diagnostics() throws RecognitionException {
        CppParser.diagnostics_return retval = new CppParser.diagnostics_return();
        retval.start = input.LT(1);
        int diagnostics_StartIndex = input.index();
        Object root_0 = null;

        Token WARNING44=null;
        Token ERROR45=null;
        Token PRAGMA46=null;

        Object WARNING44_tree=null;
        Object ERROR45_tree=null;
        Object PRAGMA46_tree=null;
        RewriteRuleTokenStream stream_ERROR=new RewriteRuleTokenStream(adaptor,"token ERROR");
        RewriteRuleTokenStream stream_WARNING=new RewriteRuleTokenStream(adaptor,"token WARNING");
        RewriteRuleTokenStream stream_PRAGMA=new RewriteRuleTokenStream(adaptor,"token PRAGMA");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 10) ) { return retval; }
            // Cpp.g:109:3: ( WARNING -> ^( WARNING ) | ERROR -> ^( ERROR ) | PRAGMA -> ^( PRAGMA ) )
            int alt19=3;
            switch ( input.LA(1) ) {
            case WARNING:
                {
                alt19=1;
                }
                break;
            case ERROR:
                {
                alt19=2;
                }
                break;
            case PRAGMA:
                {
                alt19=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // Cpp.g:109:5: WARNING
                    {
                    WARNING44=(Token)match(input,WARNING,FOLLOW_WARNING_in_diagnostics718); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_WARNING.add(WARNING44);



                    // AST REWRITE
                    // elements: WARNING
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 109:13: -> ^( WARNING )
                    {
                        // Cpp.g:109:16: ^( WARNING )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_WARNING.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // Cpp.g:110:5: ERROR
                    {
                    ERROR45=(Token)match(input,ERROR,FOLLOW_ERROR_in_diagnostics730); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_ERROR.add(ERROR45);



                    // AST REWRITE
                    // elements: ERROR
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 110:11: -> ^( ERROR )
                    {
                        // Cpp.g:110:14: ^( ERROR )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_ERROR.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // Cpp.g:111:5: PRAGMA
                    {
                    PRAGMA46=(Token)match(input,PRAGMA,FOLLOW_PRAGMA_in_diagnostics742); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_PRAGMA.add(PRAGMA46);



                    // AST REWRITE
                    // elements: PRAGMA
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 111:12: -> ^( PRAGMA )
                    {
                        // Cpp.g:111:15: ^( PRAGMA )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_PRAGMA.nextNode(), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 10, diagnostics_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "diagnostics"

    public static class text_line_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "text_line"
    // Cpp.g:114:1: text_line : ( source_text )+ -> ^( TEXT_LINE ( source_text )+ ) ;
    public final CppParser.text_line_return text_line() throws RecognitionException {
        CppParser.text_line_return retval = new CppParser.text_line_return();
        retval.start = input.LT(1);
        int text_line_StartIndex = input.index();
        Object root_0 = null;

        CppParser.source_text_return source_text47 = null;


        RewriteRuleSubtreeStream stream_source_text=new RewriteRuleSubtreeStream(adaptor,"rule source_text");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 11) ) { return retval; }
            // Cpp.g:115:3: ( ( source_text )+ -> ^( TEXT_LINE ( source_text )+ ) )
            // Cpp.g:115:5: ( source_text )+
            {
            // Cpp.g:115:5: ( source_text )+
            int cnt20=0;
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==TEXT_END||(LA20_0>=IDENTIFIER && LA20_0<=COMMA)||(LA20_0>=DECIMAL_LITERAL && LA20_0<=STRING_LITERAL)||LA20_0==SIZEOF||(LA20_0>=HEX_LITERAL && LA20_0<=COPERATOR)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // Cpp.g:0:0: source_text
            	    {
            	    pushFollow(FOLLOW_source_text_in_text_line763);
            	    source_text47=source_text();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_source_text.add(source_text47.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt20 >= 1 ) break loop20;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(20, input);
                        throw eee;
                }
                cnt20++;
            } while (true);



            // AST REWRITE
            // elements: source_text
            // token labels:
            // rule labels: retval
            // token list labels:
            // rule list labels:
            // wildcard labels:
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 115:22: -> ^( TEXT_LINE ( source_text )+ )
            {
                // Cpp.g:115:25: ^( TEXT_LINE ( source_text )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TEXT_LINE, "TEXT_LINE"), root_1);

                if ( !(stream_source_text.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_source_text.hasNext() ) {
                    adaptor.addChild(root_1, stream_source_text.nextTree());

                }
                stream_source_text.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 11, text_line_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "text_line"

    public static class statement_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // Cpp.g:119:1: statement : ( procLine )+ ;
    public final CppParser.statement_return statement() throws RecognitionException {
        CppParser.statement_return retval = new CppParser.statement_return();
        retval.start = input.LT(1);
        int statement_StartIndex = input.index();
        Object root_0 = null;

        CppParser.procLine_return procLine48 = null;



        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 12) ) { return retval; }
            // Cpp.g:120:3: ( ( procLine )+ )
            // Cpp.g:120:5: ( procLine )+
            {
            root_0 = (Object)adaptor.nil();

            // Cpp.g:120:5: ( procLine )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==IF||(LA21_0>=WARNING && LA21_0<=PRAGMA)||LA21_0==TEXT_END||LA21_0==EXEC_MACRO||(LA21_0>=LINE && LA21_0<=UNDEF)||(LA21_0>=DIRECTIVE && LA21_0<=COMMA)||(LA21_0>=DECIMAL_LITERAL && LA21_0<=STRING_LITERAL)||LA21_0==SIZEOF||(LA21_0>=HEX_LITERAL && LA21_0<=COPERATOR)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // Cpp.g:0:0: procLine
            	    {
            	    pushFollow(FOLLOW_procLine_in_statement794);
            	    procLine48=procLine();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, procLine48.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 12, statement_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class type_name_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "type_name"
    // Cpp.g:123:1: type_name : IDENTIFIER ;
    public final CppParser.type_name_return type_name() throws RecognitionException {
        CppParser.type_name_return retval = new CppParser.type_name_return();
        retval.start = input.LT(1);
        int type_name_StartIndex = input.index();
        Object root_0 = null;

        Token IDENTIFIER49=null;

        Object IDENTIFIER49_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 13) ) { return retval; }
            // Cpp.g:124:3: ( IDENTIFIER )
            // Cpp.g:124:5: IDENTIFIER
            {
            root_0 = (Object)adaptor.nil();

            IDENTIFIER49=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_type_name810); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IDENTIFIER49_tree = (Object)adaptor.create(IDENTIFIER49);
            adaptor.addChild(root_0, IDENTIFIER49_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 13, type_name_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "type_name"

    public static class ifexpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ifexpression"
    // Cpp.g:127:1: ifexpression : ( IDENTIFIER {...}? -> ^( EXPR_NDEF IDENTIFIER ) | IDENTIFIER {...}? -> ^( EXPR_DEF IDENTIFIER ) | assignmentExpression -> ^( EXPR assignmentExpression ) );
    public final CppParser.ifexpression_return ifexpression() throws RecognitionException {
        CppParser.ifexpression_return retval = new CppParser.ifexpression_return();
        retval.start = input.LT(1);
        int ifexpression_StartIndex = input.index();
        Object root_0 = null;

        Token IDENTIFIER50=null;
        Token IDENTIFIER51=null;
        CppParser.assignmentExpression_return assignmentExpression52 = null;


        Object IDENTIFIER50_tree=null;
        Object IDENTIFIER51_tree=null;
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleSubtreeStream stream_assignmentExpression=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 14) ) { return retval; }
            // Cpp.g:128:3: ( IDENTIFIER {...}? -> ^( EXPR_NDEF IDENTIFIER ) | IDENTIFIER {...}? -> ^( EXPR_DEF IDENTIFIER ) | assignmentExpression -> ^( EXPR assignmentExpression ) )
            int alt22=3;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==IDENTIFIER) ) {
                int LA22_1 = input.LA(2);

                if ( (synpred33_Cpp()) ) {
                    alt22=1;
                }
                else if ( (synpred34_Cpp()) ) {
                    alt22=2;
                }
                else if ( (true) ) {
                    alt22=3;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;
                }
            }
            else if ( (LA22_0==LPAREN||(LA22_0>=DECIMAL_LITERAL && LA22_0<=STRING_LITERAL)||LA22_0==AMPERSAND||(LA22_0>=PLUS && LA22_0<=STAR)||(LA22_0>=PLUSPLUS && LA22_0<=TILDE)||(LA22_0>=HEX_LITERAL && LA22_0<=FLOATING_POINT_LITERAL)) ) {
                alt22=3;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // Cpp.g:128:5: IDENTIFIER {...}?
                    {
                    IDENTIFIER50=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_ifexpression823); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER50);

                    if ( !((input.LT(-2).getText().equals("ifndef"))) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "ifexpression", "input.LT(-2).getText().equals(\"ifndef\")");
                    }


                    // AST REWRITE
                    // elements: IDENTIFIER
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 128:62: -> ^( EXPR_NDEF IDENTIFIER )
                    {
                        // Cpp.g:128:65: ^( EXPR_NDEF IDENTIFIER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR_NDEF, "EXPR_NDEF"), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // Cpp.g:129:5: IDENTIFIER {...}?
                    {
                    IDENTIFIER51=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_ifexpression843); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER51);

                    if ( !((input.LT(-2).getText().equals("ifdef"))) ) {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        throw new FailedPredicateException(input, "ifexpression", "input.LT(-2).getText().equals(\"ifdef\")");
                    }


                    // AST REWRITE
                    // elements: IDENTIFIER
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 129:61: -> ^( EXPR_DEF IDENTIFIER )
                    {
                        // Cpp.g:129:64: ^( EXPR_DEF IDENTIFIER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR_DEF, "EXPR_DEF"), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // Cpp.g:130:5: assignmentExpression
                    {
                    pushFollow(FOLLOW_assignmentExpression_in_ifexpression863);
                    assignmentExpression52=assignmentExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignmentExpression.add(assignmentExpression52.getTree());


                    // AST REWRITE
                    // elements: assignmentExpression
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 130:26: -> ^( EXPR assignmentExpression )
                    {
                        // Cpp.g:130:29: ^( EXPR assignmentExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR, "EXPR"), root_1);

                        adaptor.addChild(root_1, stream_assignmentExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 14, ifexpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "ifexpression"

    public static class assignmentExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assignmentExpression"
    // Cpp.g:133:1: assignmentExpression : conditionalExpression ( ( ASSIGNEQUAL | TIMESEQUAL | DIVIDEEQUAL | MODEQUAL | PLUSEQUAL | MINUSEQUAL | SHIFTLEFTEQUAL | SHIFTRIGHTEQUAL | BITWISEANDEQUAL | BITWISEXOREQUAL | BITWISEOREQUAL ) assignmentExpression )? ;
    public final CppParser.assignmentExpression_return assignmentExpression() throws RecognitionException {
        CppParser.assignmentExpression_return retval = new CppParser.assignmentExpression_return();
        retval.start = input.LT(1);
        int assignmentExpression_StartIndex = input.index();
        Object root_0 = null;

        Token ASSIGNEQUAL54=null;
        Token TIMESEQUAL55=null;
        Token DIVIDEEQUAL56=null;
        Token MODEQUAL57=null;
        Token PLUSEQUAL58=null;
        Token MINUSEQUAL59=null;
        Token SHIFTLEFTEQUAL60=null;
        Token SHIFTRIGHTEQUAL61=null;
        Token BITWISEANDEQUAL62=null;
        Token BITWISEXOREQUAL63=null;
        Token BITWISEOREQUAL64=null;
        CppParser.conditionalExpression_return conditionalExpression53 = null;

        CppParser.assignmentExpression_return assignmentExpression65 = null;


        Object ASSIGNEQUAL54_tree=null;
        Object TIMESEQUAL55_tree=null;
        Object DIVIDEEQUAL56_tree=null;
        Object MODEQUAL57_tree=null;
        Object PLUSEQUAL58_tree=null;
        Object MINUSEQUAL59_tree=null;
        Object SHIFTLEFTEQUAL60_tree=null;
        Object SHIFTRIGHTEQUAL61_tree=null;
        Object BITWISEANDEQUAL62_tree=null;
        Object BITWISEXOREQUAL63_tree=null;
        Object BITWISEOREQUAL64_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 15) ) { return retval; }
            // Cpp.g:134:3: ( conditionalExpression ( ( ASSIGNEQUAL | TIMESEQUAL | DIVIDEEQUAL | MODEQUAL | PLUSEQUAL | MINUSEQUAL | SHIFTLEFTEQUAL | SHIFTRIGHTEQUAL | BITWISEANDEQUAL | BITWISEXOREQUAL | BITWISEOREQUAL ) assignmentExpression )? )
            // Cpp.g:134:5: conditionalExpression ( ( ASSIGNEQUAL | TIMESEQUAL | DIVIDEEQUAL | MODEQUAL | PLUSEQUAL | MINUSEQUAL | SHIFTLEFTEQUAL | SHIFTRIGHTEQUAL | BITWISEANDEQUAL | BITWISEXOREQUAL | BITWISEOREQUAL ) assignmentExpression )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_conditionalExpression_in_assignmentExpression884);
            conditionalExpression53=conditionalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, conditionalExpression53.getTree());
            // Cpp.g:135:4: ( ( ASSIGNEQUAL | TIMESEQUAL | DIVIDEEQUAL | MODEQUAL | PLUSEQUAL | MINUSEQUAL | SHIFTLEFTEQUAL | SHIFTRIGHTEQUAL | BITWISEANDEQUAL | BITWISEXOREQUAL | BITWISEOREQUAL ) assignmentExpression )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( ((LA24_0>=ASSIGNEQUAL && LA24_0<=BITWISEOREQUAL)) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // Cpp.g:135:6: ( ASSIGNEQUAL | TIMESEQUAL | DIVIDEEQUAL | MODEQUAL | PLUSEQUAL | MINUSEQUAL | SHIFTLEFTEQUAL | SHIFTRIGHTEQUAL | BITWISEANDEQUAL | BITWISEXOREQUAL | BITWISEOREQUAL ) assignmentExpression
                    {
                    // Cpp.g:135:6: ( ASSIGNEQUAL | TIMESEQUAL | DIVIDEEQUAL | MODEQUAL | PLUSEQUAL | MINUSEQUAL | SHIFTLEFTEQUAL | SHIFTRIGHTEQUAL | BITWISEANDEQUAL | BITWISEXOREQUAL | BITWISEOREQUAL )
                    int alt23=11;
                    switch ( input.LA(1) ) {
                    case ASSIGNEQUAL:
                        {
                        alt23=1;
                        }
                        break;
                    case TIMESEQUAL:
                        {
                        alt23=2;
                        }
                        break;
                    case DIVIDEEQUAL:
                        {
                        alt23=3;
                        }
                        break;
                    case MODEQUAL:
                        {
                        alt23=4;
                        }
                        break;
                    case PLUSEQUAL:
                        {
                        alt23=5;
                        }
                        break;
                    case MINUSEQUAL:
                        {
                        alt23=6;
                        }
                        break;
                    case SHIFTLEFTEQUAL:
                        {
                        alt23=7;
                        }
                        break;
                    case SHIFTRIGHTEQUAL:
                        {
                        alt23=8;
                        }
                        break;
                    case BITWISEANDEQUAL:
                        {
                        alt23=9;
                        }
                        break;
                    case BITWISEXOREQUAL:
                        {
                        alt23=10;
                        }
                        break;
                    case BITWISEOREQUAL:
                        {
                        alt23=11;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 23, 0, input);

                        throw nvae;
                    }

                    switch (alt23) {
                        case 1 :
                            // Cpp.g:135:8: ASSIGNEQUAL
                            {
                            ASSIGNEQUAL54=(Token)match(input,ASSIGNEQUAL,FOLLOW_ASSIGNEQUAL_in_assignmentExpression893); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            ASSIGNEQUAL54_tree = (Object)adaptor.create(ASSIGNEQUAL54);
                            root_0 = (Object)adaptor.becomeRoot(ASSIGNEQUAL54_tree, root_0);
                            }

                            }
                            break;
                        case 2 :
                            // Cpp.g:136:9: TIMESEQUAL
                            {
                            TIMESEQUAL55=(Token)match(input,TIMESEQUAL,FOLLOW_TIMESEQUAL_in_assignmentExpression904); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            TIMESEQUAL55_tree = (Object)adaptor.create(TIMESEQUAL55);
                            root_0 = (Object)adaptor.becomeRoot(TIMESEQUAL55_tree, root_0);
                            }

                            }
                            break;
                        case 3 :
                            // Cpp.g:137:9: DIVIDEEQUAL
                            {
                            DIVIDEEQUAL56=(Token)match(input,DIVIDEEQUAL,FOLLOW_DIVIDEEQUAL_in_assignmentExpression915); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            DIVIDEEQUAL56_tree = (Object)adaptor.create(DIVIDEEQUAL56);
                            root_0 = (Object)adaptor.becomeRoot(DIVIDEEQUAL56_tree, root_0);
                            }

                            }
                            break;
                        case 4 :
                            // Cpp.g:138:9: MODEQUAL
                            {
                            MODEQUAL57=(Token)match(input,MODEQUAL,FOLLOW_MODEQUAL_in_assignmentExpression926); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            MODEQUAL57_tree = (Object)adaptor.create(MODEQUAL57);
                            root_0 = (Object)adaptor.becomeRoot(MODEQUAL57_tree, root_0);
                            }

                            }
                            break;
                        case 5 :
                            // Cpp.g:139:9: PLUSEQUAL
                            {
                            PLUSEQUAL58=(Token)match(input,PLUSEQUAL,FOLLOW_PLUSEQUAL_in_assignmentExpression937); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            PLUSEQUAL58_tree = (Object)adaptor.create(PLUSEQUAL58);
                            root_0 = (Object)adaptor.becomeRoot(PLUSEQUAL58_tree, root_0);
                            }

                            }
                            break;
                        case 6 :
                            // Cpp.g:140:9: MINUSEQUAL
                            {
                            MINUSEQUAL59=(Token)match(input,MINUSEQUAL,FOLLOW_MINUSEQUAL_in_assignmentExpression948); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            MINUSEQUAL59_tree = (Object)adaptor.create(MINUSEQUAL59);
                            root_0 = (Object)adaptor.becomeRoot(MINUSEQUAL59_tree, root_0);
                            }

                            }
                            break;
                        case 7 :
                            // Cpp.g:141:9: SHIFTLEFTEQUAL
                            {
                            SHIFTLEFTEQUAL60=(Token)match(input,SHIFTLEFTEQUAL,FOLLOW_SHIFTLEFTEQUAL_in_assignmentExpression959); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            SHIFTLEFTEQUAL60_tree = (Object)adaptor.create(SHIFTLEFTEQUAL60);
                            root_0 = (Object)adaptor.becomeRoot(SHIFTLEFTEQUAL60_tree, root_0);
                            }

                            }
                            break;
                        case 8 :
                            // Cpp.g:142:9: SHIFTRIGHTEQUAL
                            {
                            SHIFTRIGHTEQUAL61=(Token)match(input,SHIFTRIGHTEQUAL,FOLLOW_SHIFTRIGHTEQUAL_in_assignmentExpression970); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            SHIFTRIGHTEQUAL61_tree = (Object)adaptor.create(SHIFTRIGHTEQUAL61);
                            root_0 = (Object)adaptor.becomeRoot(SHIFTRIGHTEQUAL61_tree, root_0);
                            }

                            }
                            break;
                        case 9 :
                            // Cpp.g:143:7: BITWISEANDEQUAL
                            {
                            BITWISEANDEQUAL62=(Token)match(input,BITWISEANDEQUAL,FOLLOW_BITWISEANDEQUAL_in_assignmentExpression979); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            BITWISEANDEQUAL62_tree = (Object)adaptor.create(BITWISEANDEQUAL62);
                            root_0 = (Object)adaptor.becomeRoot(BITWISEANDEQUAL62_tree, root_0);
                            }

                            }
                            break;
                        case 10 :
                            // Cpp.g:144:7: BITWISEXOREQUAL
                            {
                            BITWISEXOREQUAL63=(Token)match(input,BITWISEXOREQUAL,FOLLOW_BITWISEXOREQUAL_in_assignmentExpression988); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            BITWISEXOREQUAL63_tree = (Object)adaptor.create(BITWISEXOREQUAL63);
                            root_0 = (Object)adaptor.becomeRoot(BITWISEXOREQUAL63_tree, root_0);
                            }

                            }
                            break;
                        case 11 :
                            // Cpp.g:145:7: BITWISEOREQUAL
                            {
                            BITWISEOREQUAL64=(Token)match(input,BITWISEOREQUAL,FOLLOW_BITWISEOREQUAL_in_assignmentExpression997); if (state.failed) return retval;
                            if ( state.backtracking==0 ) {
                            BITWISEOREQUAL64_tree = (Object)adaptor.create(BITWISEOREQUAL64);
                            root_0 = (Object)adaptor.becomeRoot(BITWISEOREQUAL64_tree, root_0);
                            }

                            }
                            break;

                    }

                    pushFollow(FOLLOW_assignmentExpression_in_assignmentExpression1009);
                    assignmentExpression65=assignmentExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentExpression65.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 15, assignmentExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "assignmentExpression"

    public static class conditionalExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "conditionalExpression"
    // Cpp.g:151:1: conditionalExpression : logicalOrExpression ( QUESTIONMARK assignmentExpression COLON conditionalExpression )? ;
    public final CppParser.conditionalExpression_return conditionalExpression() throws RecognitionException {
        CppParser.conditionalExpression_return retval = new CppParser.conditionalExpression_return();
        retval.start = input.LT(1);
        int conditionalExpression_StartIndex = input.index();
        Object root_0 = null;

        Token QUESTIONMARK67=null;
        Token COLON69=null;
        CppParser.logicalOrExpression_return logicalOrExpression66 = null;

        CppParser.assignmentExpression_return assignmentExpression68 = null;

        CppParser.conditionalExpression_return conditionalExpression70 = null;


        Object QUESTIONMARK67_tree=null;
        Object COLON69_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 16) ) { return retval; }
            // Cpp.g:152:3: ( logicalOrExpression ( QUESTIONMARK assignmentExpression COLON conditionalExpression )? )
            // Cpp.g:152:5: logicalOrExpression ( QUESTIONMARK assignmentExpression COLON conditionalExpression )?
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_logicalOrExpression_in_conditionalExpression1028);
            logicalOrExpression66=logicalOrExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalOrExpression66.getTree());
            // Cpp.g:153:4: ( QUESTIONMARK assignmentExpression COLON conditionalExpression )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==QUESTIONMARK) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // Cpp.g:153:6: QUESTIONMARK assignmentExpression COLON conditionalExpression
                    {
                    QUESTIONMARK67=(Token)match(input,QUESTIONMARK,FOLLOW_QUESTIONMARK_in_conditionalExpression1036); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    QUESTIONMARK67_tree = (Object)adaptor.create(QUESTIONMARK67);
                    root_0 = (Object)adaptor.becomeRoot(QUESTIONMARK67_tree, root_0);
                    }
                    pushFollow(FOLLOW_assignmentExpression_in_conditionalExpression1039);
                    assignmentExpression68=assignmentExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentExpression68.getTree());
                    COLON69=(Token)match(input,COLON,FOLLOW_COLON_in_conditionalExpression1041); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COLON69_tree = (Object)adaptor.create(COLON69);
                    adaptor.addChild(root_0, COLON69_tree);
                    }
                    pushFollow(FOLLOW_conditionalExpression_in_conditionalExpression1043);
                    conditionalExpression70=conditionalExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, conditionalExpression70.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 16, conditionalExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "conditionalExpression"

    public static class logicalOrExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logicalOrExpression"
    // Cpp.g:156:1: logicalOrExpression : logicalAndExpression ( OR logicalAndExpression )* ;
    public final CppParser.logicalOrExpression_return logicalOrExpression() throws RecognitionException {
        CppParser.logicalOrExpression_return retval = new CppParser.logicalOrExpression_return();
        retval.start = input.LT(1);
        int logicalOrExpression_StartIndex = input.index();
        Object root_0 = null;

        Token OR72=null;
        CppParser.logicalAndExpression_return logicalAndExpression71 = null;

        CppParser.logicalAndExpression_return logicalAndExpression73 = null;


        Object OR72_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 17) ) { return retval; }
            // Cpp.g:157:3: ( logicalAndExpression ( OR logicalAndExpression )* )
            // Cpp.g:157:5: logicalAndExpression ( OR logicalAndExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_logicalAndExpression_in_logicalOrExpression1059);
            logicalAndExpression71=logicalAndExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalAndExpression71.getTree());
            // Cpp.g:157:26: ( OR logicalAndExpression )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==OR) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // Cpp.g:157:27: OR logicalAndExpression
            	    {
            	    OR72=(Token)match(input,OR,FOLLOW_OR_in_logicalOrExpression1062); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    OR72_tree = (Object)adaptor.create(OR72);
            	    root_0 = (Object)adaptor.becomeRoot(OR72_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_logicalAndExpression_in_logicalOrExpression1065);
            	    logicalAndExpression73=logicalAndExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, logicalAndExpression73.getTree());

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 17, logicalOrExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "logicalOrExpression"

    public static class logicalAndExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "logicalAndExpression"
    // Cpp.g:160:1: logicalAndExpression : inclusiveOrExpression ( AND inclusiveOrExpression )* ;
    public final CppParser.logicalAndExpression_return logicalAndExpression() throws RecognitionException {
        CppParser.logicalAndExpression_return retval = new CppParser.logicalAndExpression_return();
        retval.start = input.LT(1);
        int logicalAndExpression_StartIndex = input.index();
        Object root_0 = null;

        Token AND75=null;
        CppParser.inclusiveOrExpression_return inclusiveOrExpression74 = null;

        CppParser.inclusiveOrExpression_return inclusiveOrExpression76 = null;


        Object AND75_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 18) ) { return retval; }
            // Cpp.g:161:3: ( inclusiveOrExpression ( AND inclusiveOrExpression )* )
            // Cpp.g:161:5: inclusiveOrExpression ( AND inclusiveOrExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_inclusiveOrExpression_in_logicalAndExpression1080);
            inclusiveOrExpression74=inclusiveOrExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, inclusiveOrExpression74.getTree());
            // Cpp.g:161:27: ( AND inclusiveOrExpression )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==AND) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // Cpp.g:161:28: AND inclusiveOrExpression
            	    {
            	    AND75=(Token)match(input,AND,FOLLOW_AND_in_logicalAndExpression1083); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    AND75_tree = (Object)adaptor.create(AND75);
            	    root_0 = (Object)adaptor.becomeRoot(AND75_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_inclusiveOrExpression_in_logicalAndExpression1086);
            	    inclusiveOrExpression76=inclusiveOrExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, inclusiveOrExpression76.getTree());

            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 18, logicalAndExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "logicalAndExpression"

    public static class inclusiveOrExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "inclusiveOrExpression"
    // Cpp.g:164:1: inclusiveOrExpression : exclusiveOrExpression ( BITWISEOR exclusiveOrExpression )* ;
    public final CppParser.inclusiveOrExpression_return inclusiveOrExpression() throws RecognitionException {
        CppParser.inclusiveOrExpression_return retval = new CppParser.inclusiveOrExpression_return();
        retval.start = input.LT(1);
        int inclusiveOrExpression_StartIndex = input.index();
        Object root_0 = null;

        Token BITWISEOR78=null;
        CppParser.exclusiveOrExpression_return exclusiveOrExpression77 = null;

        CppParser.exclusiveOrExpression_return exclusiveOrExpression79 = null;


        Object BITWISEOR78_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 19) ) { return retval; }
            // Cpp.g:165:3: ( exclusiveOrExpression ( BITWISEOR exclusiveOrExpression )* )
            // Cpp.g:165:5: exclusiveOrExpression ( BITWISEOR exclusiveOrExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression1101);
            exclusiveOrExpression77=exclusiveOrExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, exclusiveOrExpression77.getTree());
            // Cpp.g:165:27: ( BITWISEOR exclusiveOrExpression )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==BITWISEOR) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // Cpp.g:165:28: BITWISEOR exclusiveOrExpression
            	    {
            	    BITWISEOR78=(Token)match(input,BITWISEOR,FOLLOW_BITWISEOR_in_inclusiveOrExpression1104); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    BITWISEOR78_tree = (Object)adaptor.create(BITWISEOR78);
            	    root_0 = (Object)adaptor.becomeRoot(BITWISEOR78_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression1107);
            	    exclusiveOrExpression79=exclusiveOrExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, exclusiveOrExpression79.getTree());

            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 19, inclusiveOrExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "inclusiveOrExpression"

    public static class exclusiveOrExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exclusiveOrExpression"
    // Cpp.g:168:1: exclusiveOrExpression : andExpression ( BITWISEXOR andExpression )* ;
    public final CppParser.exclusiveOrExpression_return exclusiveOrExpression() throws RecognitionException {
        CppParser.exclusiveOrExpression_return retval = new CppParser.exclusiveOrExpression_return();
        retval.start = input.LT(1);
        int exclusiveOrExpression_StartIndex = input.index();
        Object root_0 = null;

        Token BITWISEXOR81=null;
        CppParser.andExpression_return andExpression80 = null;

        CppParser.andExpression_return andExpression82 = null;


        Object BITWISEXOR81_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 20) ) { return retval; }
            // Cpp.g:169:3: ( andExpression ( BITWISEXOR andExpression )* )
            // Cpp.g:169:5: andExpression ( BITWISEXOR andExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_andExpression_in_exclusiveOrExpression1122);
            andExpression80=andExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, andExpression80.getTree());
            // Cpp.g:169:19: ( BITWISEXOR andExpression )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==BITWISEXOR) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // Cpp.g:169:20: BITWISEXOR andExpression
            	    {
            	    BITWISEXOR81=(Token)match(input,BITWISEXOR,FOLLOW_BITWISEXOR_in_exclusiveOrExpression1125); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    BITWISEXOR81_tree = (Object)adaptor.create(BITWISEXOR81);
            	    root_0 = (Object)adaptor.becomeRoot(BITWISEXOR81_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_andExpression_in_exclusiveOrExpression1128);
            	    andExpression82=andExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, andExpression82.getTree());

            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 20, exclusiveOrExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "exclusiveOrExpression"

    public static class andExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "andExpression"
    // Cpp.g:172:1: andExpression : equalityExpression ( AMPERSAND equalityExpression )* ;
    public final CppParser.andExpression_return andExpression() throws RecognitionException {
        CppParser.andExpression_return retval = new CppParser.andExpression_return();
        retval.start = input.LT(1);
        int andExpression_StartIndex = input.index();
        Object root_0 = null;

        Token AMPERSAND84=null;
        CppParser.equalityExpression_return equalityExpression83 = null;

        CppParser.equalityExpression_return equalityExpression85 = null;


        Object AMPERSAND84_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 21) ) { return retval; }
            // Cpp.g:173:3: ( equalityExpression ( AMPERSAND equalityExpression )* )
            // Cpp.g:173:5: equalityExpression ( AMPERSAND equalityExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_equalityExpression_in_andExpression1143);
            equalityExpression83=equalityExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, equalityExpression83.getTree());
            // Cpp.g:173:24: ( AMPERSAND equalityExpression )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==AMPERSAND) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // Cpp.g:173:25: AMPERSAND equalityExpression
            	    {
            	    AMPERSAND84=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_andExpression1146); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    AMPERSAND84_tree = (Object)adaptor.create(AMPERSAND84);
            	    root_0 = (Object)adaptor.becomeRoot(AMPERSAND84_tree, root_0);
            	    }
            	    pushFollow(FOLLOW_equalityExpression_in_andExpression1149);
            	    equalityExpression85=equalityExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, equalityExpression85.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 21, andExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "andExpression"

    public static class equalityExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "equalityExpression"
    // Cpp.g:176:1: equalityExpression : relationalExpression ( ( NOTEQUAL | EQUAL ) relationalExpression )* ;
    public final CppParser.equalityExpression_return equalityExpression() throws RecognitionException {
        CppParser.equalityExpression_return retval = new CppParser.equalityExpression_return();
        retval.start = input.LT(1);
        int equalityExpression_StartIndex = input.index();
        Object root_0 = null;

        Token NOTEQUAL87=null;
        Token EQUAL88=null;
        CppParser.relationalExpression_return relationalExpression86 = null;

        CppParser.relationalExpression_return relationalExpression89 = null;


        Object NOTEQUAL87_tree=null;
        Object EQUAL88_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 22) ) { return retval; }
            // Cpp.g:177:3: ( relationalExpression ( ( NOTEQUAL | EQUAL ) relationalExpression )* )
            // Cpp.g:177:5: relationalExpression ( ( NOTEQUAL | EQUAL ) relationalExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_relationalExpression_in_equalityExpression1164);
            relationalExpression86=relationalExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression86.getTree());
            // Cpp.g:177:26: ( ( NOTEQUAL | EQUAL ) relationalExpression )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( ((LA32_0>=NOTEQUAL && LA32_0<=EQUAL)) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // Cpp.g:177:27: ( NOTEQUAL | EQUAL ) relationalExpression
            	    {
            	    // Cpp.g:177:27: ( NOTEQUAL | EQUAL )
            	    int alt31=2;
            	    int LA31_0 = input.LA(1);

            	    if ( (LA31_0==NOTEQUAL) ) {
            	        alt31=1;
            	    }
            	    else if ( (LA31_0==EQUAL) ) {
            	        alt31=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 31, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt31) {
            	        case 1 :
            	            // Cpp.g:177:28: NOTEQUAL
            	            {
            	            NOTEQUAL87=(Token)match(input,NOTEQUAL,FOLLOW_NOTEQUAL_in_equalityExpression1168); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            NOTEQUAL87_tree = (Object)adaptor.create(NOTEQUAL87);
            	            root_0 = (Object)adaptor.becomeRoot(NOTEQUAL87_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // Cpp.g:177:40: EQUAL
            	            {
            	            EQUAL88=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_equalityExpression1173); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            EQUAL88_tree = (Object)adaptor.create(EQUAL88);
            	            root_0 = (Object)adaptor.becomeRoot(EQUAL88_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_relationalExpression_in_equalityExpression1177);
            	    relationalExpression89=relationalExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, relationalExpression89.getTree());

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 22, equalityExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "equalityExpression"

    public static class relationalExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "relationalExpression"
    // Cpp.g:180:1: relationalExpression : shiftExpression ( ( ( LESSTHAN | GREATERTHAN | LESSTHANOREQUALTO | GREATERTHANOREQUALTO ) shiftExpression )* ) ;
    public final CppParser.relationalExpression_return relationalExpression() throws RecognitionException {
        CppParser.relationalExpression_return retval = new CppParser.relationalExpression_return();
        retval.start = input.LT(1);
        int relationalExpression_StartIndex = input.index();
        Object root_0 = null;

        Token LESSTHAN91=null;
        Token GREATERTHAN92=null;
        Token LESSTHANOREQUALTO93=null;
        Token GREATERTHANOREQUALTO94=null;
        CppParser.shiftExpression_return shiftExpression90 = null;

        CppParser.shiftExpression_return shiftExpression95 = null;


        Object LESSTHAN91_tree=null;
        Object GREATERTHAN92_tree=null;
        Object LESSTHANOREQUALTO93_tree=null;
        Object GREATERTHANOREQUALTO94_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 23) ) { return retval; }
            // Cpp.g:181:3: ( shiftExpression ( ( ( LESSTHAN | GREATERTHAN | LESSTHANOREQUALTO | GREATERTHANOREQUALTO ) shiftExpression )* ) )
            // Cpp.g:181:5: shiftExpression ( ( ( LESSTHAN | GREATERTHAN | LESSTHANOREQUALTO | GREATERTHANOREQUALTO ) shiftExpression )* )
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_shiftExpression_in_relationalExpression1192);
            shiftExpression90=shiftExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, shiftExpression90.getTree());
            // Cpp.g:182:4: ( ( ( LESSTHAN | GREATERTHAN | LESSTHANOREQUALTO | GREATERTHANOREQUALTO ) shiftExpression )* )
            // Cpp.g:182:6: ( ( LESSTHAN | GREATERTHAN | LESSTHANOREQUALTO | GREATERTHANOREQUALTO ) shiftExpression )*
            {
            // Cpp.g:182:6: ( ( LESSTHAN | GREATERTHAN | LESSTHANOREQUALTO | GREATERTHANOREQUALTO ) shiftExpression )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=LESSTHAN && LA34_0<=GREATERTHANOREQUALTO)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // Cpp.g:182:8: ( LESSTHAN | GREATERTHAN | LESSTHANOREQUALTO | GREATERTHANOREQUALTO ) shiftExpression
            	    {
            	    // Cpp.g:182:8: ( LESSTHAN | GREATERTHAN | LESSTHANOREQUALTO | GREATERTHANOREQUALTO )
            	    int alt33=4;
            	    switch ( input.LA(1) ) {
            	    case LESSTHAN:
            	        {
            	        alt33=1;
            	        }
            	        break;
            	    case GREATERTHAN:
            	        {
            	        alt33=2;
            	        }
            	        break;
            	    case LESSTHANOREQUALTO:
            	        {
            	        alt33=3;
            	        }
            	        break;
            	    case GREATERTHANOREQUALTO:
            	        {
            	        alt33=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 33, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt33) {
            	        case 1 :
            	            // Cpp.g:182:10: LESSTHAN
            	            {
            	            LESSTHAN91=(Token)match(input,LESSTHAN,FOLLOW_LESSTHAN_in_relationalExpression1203); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            LESSTHAN91_tree = (Object)adaptor.create(LESSTHAN91);
            	            root_0 = (Object)adaptor.becomeRoot(LESSTHAN91_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // Cpp.g:183:8: GREATERTHAN
            	            {
            	            GREATERTHAN92=(Token)match(input,GREATERTHAN,FOLLOW_GREATERTHAN_in_relationalExpression1213); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            GREATERTHAN92_tree = (Object)adaptor.create(GREATERTHAN92);
            	            root_0 = (Object)adaptor.becomeRoot(GREATERTHAN92_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // Cpp.g:184:8: LESSTHANOREQUALTO
            	            {
            	            LESSTHANOREQUALTO93=(Token)match(input,LESSTHANOREQUALTO,FOLLOW_LESSTHANOREQUALTO_in_relationalExpression1223); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            LESSTHANOREQUALTO93_tree = (Object)adaptor.create(LESSTHANOREQUALTO93);
            	            root_0 = (Object)adaptor.becomeRoot(LESSTHANOREQUALTO93_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // Cpp.g:185:8: GREATERTHANOREQUALTO
            	            {
            	            GREATERTHANOREQUALTO94=(Token)match(input,GREATERTHANOREQUALTO,FOLLOW_GREATERTHANOREQUALTO_in_relationalExpression1233); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            GREATERTHANOREQUALTO94_tree = (Object)adaptor.create(GREATERTHANOREQUALTO94);
            	            root_0 = (Object)adaptor.becomeRoot(GREATERTHANOREQUALTO94_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_shiftExpression_in_relationalExpression1247);
            	    shiftExpression95=shiftExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, shiftExpression95.getTree());

            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 23, relationalExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "relationalExpression"

    public static class shiftExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "shiftExpression"
    // Cpp.g:191:1: shiftExpression : additiveExpression ( ( SHIFTLEFT | SHIFTRIGHT ) additiveExpression )* ;
    public final CppParser.shiftExpression_return shiftExpression() throws RecognitionException {
        CppParser.shiftExpression_return retval = new CppParser.shiftExpression_return();
        retval.start = input.LT(1);
        int shiftExpression_StartIndex = input.index();
        Object root_0 = null;

        Token SHIFTLEFT97=null;
        Token SHIFTRIGHT98=null;
        CppParser.additiveExpression_return additiveExpression96 = null;

        CppParser.additiveExpression_return additiveExpression99 = null;


        Object SHIFTLEFT97_tree=null;
        Object SHIFTRIGHT98_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 24) ) { return retval; }
            // Cpp.g:192:3: ( additiveExpression ( ( SHIFTLEFT | SHIFTRIGHT ) additiveExpression )* )
            // Cpp.g:192:5: additiveExpression ( ( SHIFTLEFT | SHIFTRIGHT ) additiveExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_additiveExpression_in_shiftExpression1271);
            additiveExpression96=additiveExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression96.getTree());
            // Cpp.g:192:24: ( ( SHIFTLEFT | SHIFTRIGHT ) additiveExpression )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( ((LA36_0>=SHIFTLEFT && LA36_0<=SHIFTRIGHT)) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // Cpp.g:192:25: ( SHIFTLEFT | SHIFTRIGHT ) additiveExpression
            	    {
            	    // Cpp.g:192:25: ( SHIFTLEFT | SHIFTRIGHT )
            	    int alt35=2;
            	    int LA35_0 = input.LA(1);

            	    if ( (LA35_0==SHIFTLEFT) ) {
            	        alt35=1;
            	    }
            	    else if ( (LA35_0==SHIFTRIGHT) ) {
            	        alt35=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 35, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt35) {
            	        case 1 :
            	            // Cpp.g:192:26: SHIFTLEFT
            	            {
            	            SHIFTLEFT97=(Token)match(input,SHIFTLEFT,FOLLOW_SHIFTLEFT_in_shiftExpression1275); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            SHIFTLEFT97_tree = (Object)adaptor.create(SHIFTLEFT97);
            	            root_0 = (Object)adaptor.becomeRoot(SHIFTLEFT97_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // Cpp.g:192:39: SHIFTRIGHT
            	            {
            	            SHIFTRIGHT98=(Token)match(input,SHIFTRIGHT,FOLLOW_SHIFTRIGHT_in_shiftExpression1280); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            SHIFTRIGHT98_tree = (Object)adaptor.create(SHIFTRIGHT98);
            	            root_0 = (Object)adaptor.becomeRoot(SHIFTRIGHT98_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_additiveExpression_in_shiftExpression1284);
            	    additiveExpression99=additiveExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, additiveExpression99.getTree());

            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 24, shiftExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "shiftExpression"

    public static class additiveExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "additiveExpression"
    // Cpp.g:195:1: additiveExpression : multiplicativeExpression ( ( PLUS | MINUS ) multiplicativeExpression )* ;
    public final CppParser.additiveExpression_return additiveExpression() throws RecognitionException {
        CppParser.additiveExpression_return retval = new CppParser.additiveExpression_return();
        retval.start = input.LT(1);
        int additiveExpression_StartIndex = input.index();
        Object root_0 = null;

        Token PLUS101=null;
        Token MINUS102=null;
        CppParser.multiplicativeExpression_return multiplicativeExpression100 = null;

        CppParser.multiplicativeExpression_return multiplicativeExpression103 = null;


        Object PLUS101_tree=null;
        Object MINUS102_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 25) ) { return retval; }
            // Cpp.g:196:3: ( multiplicativeExpression ( ( PLUS | MINUS ) multiplicativeExpression )* )
            // Cpp.g:196:5: multiplicativeExpression ( ( PLUS | MINUS ) multiplicativeExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1299);
            multiplicativeExpression100=multiplicativeExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression100.getTree());
            // Cpp.g:196:30: ( ( PLUS | MINUS ) multiplicativeExpression )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( ((LA38_0>=PLUS && LA38_0<=MINUS)) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // Cpp.g:196:31: ( PLUS | MINUS ) multiplicativeExpression
            	    {
            	    // Cpp.g:196:31: ( PLUS | MINUS )
            	    int alt37=2;
            	    int LA37_0 = input.LA(1);

            	    if ( (LA37_0==PLUS) ) {
            	        alt37=1;
            	    }
            	    else if ( (LA37_0==MINUS) ) {
            	        alt37=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 37, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt37) {
            	        case 1 :
            	            // Cpp.g:196:32: PLUS
            	            {
            	            PLUS101=(Token)match(input,PLUS,FOLLOW_PLUS_in_additiveExpression1303); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            PLUS101_tree = (Object)adaptor.create(PLUS101);
            	            root_0 = (Object)adaptor.becomeRoot(PLUS101_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // Cpp.g:196:40: MINUS
            	            {
            	            MINUS102=(Token)match(input,MINUS,FOLLOW_MINUS_in_additiveExpression1308); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MINUS102_tree = (Object)adaptor.create(MINUS102);
            	            root_0 = (Object)adaptor.becomeRoot(MINUS102_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_multiplicativeExpression_in_additiveExpression1312);
            	    multiplicativeExpression103=multiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, multiplicativeExpression103.getTree());

            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 25, additiveExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "additiveExpression"

    public static class multiplicativeExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "multiplicativeExpression"
    // Cpp.g:199:1: multiplicativeExpression : unaryExpression ( ( STAR | DIVIDE | MOD ) unaryExpression )* ;
    public final CppParser.multiplicativeExpression_return multiplicativeExpression() throws RecognitionException {
        CppParser.multiplicativeExpression_return retval = new CppParser.multiplicativeExpression_return();
        retval.start = input.LT(1);
        int multiplicativeExpression_StartIndex = input.index();
        Object root_0 = null;

        Token STAR105=null;
        Token DIVIDE106=null;
        Token MOD107=null;
        CppParser.unaryExpression_return unaryExpression104 = null;

        CppParser.unaryExpression_return unaryExpression108 = null;


        Object STAR105_tree=null;
        Object DIVIDE106_tree=null;
        Object MOD107_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 26) ) { return retval; }
            // Cpp.g:200:3: ( unaryExpression ( ( STAR | DIVIDE | MOD ) unaryExpression )* )
            // Cpp.g:200:5: unaryExpression ( ( STAR | DIVIDE | MOD ) unaryExpression )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1327);
            unaryExpression104=unaryExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression104.getTree());
            // Cpp.g:200:21: ( ( STAR | DIVIDE | MOD ) unaryExpression )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( ((LA40_0>=STAR && LA40_0<=MOD)) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // Cpp.g:200:22: ( STAR | DIVIDE | MOD ) unaryExpression
            	    {
            	    // Cpp.g:200:22: ( STAR | DIVIDE | MOD )
            	    int alt39=3;
            	    switch ( input.LA(1) ) {
            	    case STAR:
            	        {
            	        alt39=1;
            	        }
            	        break;
            	    case DIVIDE:
            	        {
            	        alt39=2;
            	        }
            	        break;
            	    case MOD:
            	        {
            	        alt39=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 39, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt39) {
            	        case 1 :
            	            // Cpp.g:200:23: STAR
            	            {
            	            STAR105=(Token)match(input,STAR,FOLLOW_STAR_in_multiplicativeExpression1331); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            STAR105_tree = (Object)adaptor.create(STAR105);
            	            root_0 = (Object)adaptor.becomeRoot(STAR105_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // Cpp.g:200:31: DIVIDE
            	            {
            	            DIVIDE106=(Token)match(input,DIVIDE,FOLLOW_DIVIDE_in_multiplicativeExpression1336); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            DIVIDE106_tree = (Object)adaptor.create(DIVIDE106);
            	            root_0 = (Object)adaptor.becomeRoot(DIVIDE106_tree, root_0);
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // Cpp.g:200:41: MOD
            	            {
            	            MOD107=(Token)match(input,MOD,FOLLOW_MOD_in_multiplicativeExpression1341); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) {
            	            MOD107_tree = (Object)adaptor.create(MOD107);
            	            root_0 = (Object)adaptor.becomeRoot(MOD107_tree, root_0);
            	            }

            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_unaryExpression_in_multiplicativeExpression1346);
            	    unaryExpression108=unaryExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpression108.getTree());

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 26, multiplicativeExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "multiplicativeExpression"

    public static class unaryExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryExpression"
    // Cpp.g:203:1: unaryExpression : ( PLUSPLUS unaryExpression -> ^( PLUSPLUS unaryExpression ) | MINUSMINUS unaryExpression -> ^( MINUSMINUS unaryExpression ) | SIZEOF unaryExpression -> ^( SIZEOF unaryExpression ) | SIZEOF LPAREN type_name RPAREN -> ^( SIZEOF_TYPE type_name ) | DEFINED type_name -> ^( DEFINED type_name ) | DEFINED LPAREN type_name RPAREN -> ^( DEFINED type_name ) | unaryExpressionNotPlusMinus );
    public final CppParser.unaryExpression_return unaryExpression() throws RecognitionException {
        CppParser.unaryExpression_return retval = new CppParser.unaryExpression_return();
        retval.start = input.LT(1);
        int unaryExpression_StartIndex = input.index();
        Object root_0 = null;

        Token PLUSPLUS109=null;
        Token MINUSMINUS111=null;
        Token SIZEOF113=null;
        Token SIZEOF115=null;
        Token LPAREN116=null;
        Token RPAREN118=null;
        Token DEFINED119=null;
        Token DEFINED121=null;
        Token LPAREN122=null;
        Token RPAREN124=null;
        CppParser.unaryExpression_return unaryExpression110 = null;

        CppParser.unaryExpression_return unaryExpression112 = null;

        CppParser.unaryExpression_return unaryExpression114 = null;

        CppParser.type_name_return type_name117 = null;

        CppParser.type_name_return type_name120 = null;

        CppParser.type_name_return type_name123 = null;

        CppParser.unaryExpressionNotPlusMinus_return unaryExpressionNotPlusMinus125 = null;


        Object PLUSPLUS109_tree=null;
        Object MINUSMINUS111_tree=null;
        Object SIZEOF113_tree=null;
        Object SIZEOF115_tree=null;
        Object LPAREN116_tree=null;
        Object RPAREN118_tree=null;
        Object DEFINED119_tree=null;
        Object DEFINED121_tree=null;
        Object LPAREN122_tree=null;
        Object RPAREN124_tree=null;
        RewriteRuleTokenStream stream_SIZEOF=new RewriteRuleTokenStream(adaptor,"token SIZEOF");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_MINUSMINUS=new RewriteRuleTokenStream(adaptor,"token MINUSMINUS");
        RewriteRuleTokenStream stream_PLUSPLUS=new RewriteRuleTokenStream(adaptor,"token PLUSPLUS");
        RewriteRuleTokenStream stream_DEFINED=new RewriteRuleTokenStream(adaptor,"token DEFINED");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_unaryExpression=new RewriteRuleSubtreeStream(adaptor,"rule unaryExpression");
        RewriteRuleSubtreeStream stream_type_name=new RewriteRuleSubtreeStream(adaptor,"rule type_name");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 27) ) { return retval; }
            // Cpp.g:204:3: ( PLUSPLUS unaryExpression -> ^( PLUSPLUS unaryExpression ) | MINUSMINUS unaryExpression -> ^( MINUSMINUS unaryExpression ) | SIZEOF unaryExpression -> ^( SIZEOF unaryExpression ) | SIZEOF LPAREN type_name RPAREN -> ^( SIZEOF_TYPE type_name ) | DEFINED type_name -> ^( DEFINED type_name ) | DEFINED LPAREN type_name RPAREN -> ^( DEFINED type_name ) | unaryExpressionNotPlusMinus )
            int alt41=7;
            alt41 = dfa41.predict(input);
            switch (alt41) {
                case 1 :
                    // Cpp.g:204:5: PLUSPLUS unaryExpression
                    {
                    PLUSPLUS109=(Token)match(input,PLUSPLUS,FOLLOW_PLUSPLUS_in_unaryExpression1361); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_PLUSPLUS.add(PLUSPLUS109);

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression1364);
                    unaryExpression110=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression110.getTree());


                    // AST REWRITE
                    // elements: unaryExpression, PLUSPLUS
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 204:31: -> ^( PLUSPLUS unaryExpression )
                    {
                        // Cpp.g:204:34: ^( PLUSPLUS unaryExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_PLUSPLUS.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // Cpp.g:205:5: MINUSMINUS unaryExpression
                    {
                    MINUSMINUS111=(Token)match(input,MINUSMINUS,FOLLOW_MINUSMINUS_in_unaryExpression1378); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_MINUSMINUS.add(MINUSMINUS111);

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression1380);
                    unaryExpression112=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression112.getTree());


                    // AST REWRITE
                    // elements: MINUSMINUS, unaryExpression
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 205:32: -> ^( MINUSMINUS unaryExpression )
                    {
                        // Cpp.g:205:35: ^( MINUSMINUS unaryExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_MINUSMINUS.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // Cpp.g:206:5: SIZEOF unaryExpression
                    {
                    SIZEOF113=(Token)match(input,SIZEOF,FOLLOW_SIZEOF_in_unaryExpression1394); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_SIZEOF.add(SIZEOF113);

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpression1396);
                    unaryExpression114=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression114.getTree());


                    // AST REWRITE
                    // elements: unaryExpression, SIZEOF
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 206:28: -> ^( SIZEOF unaryExpression )
                    {
                        // Cpp.g:206:31: ^( SIZEOF unaryExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_SIZEOF.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // Cpp.g:207:5: SIZEOF LPAREN type_name RPAREN
                    {
                    SIZEOF115=(Token)match(input,SIZEOF,FOLLOW_SIZEOF_in_unaryExpression1410); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_SIZEOF.add(SIZEOF115);

                    LPAREN116=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_unaryExpression1412); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN116);

                    pushFollow(FOLLOW_type_name_in_unaryExpression1414);
                    type_name117=type_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type_name.add(type_name117.getTree());
                    RPAREN118=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_unaryExpression1416); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN118);



                    // AST REWRITE
                    // elements: type_name
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 207:36: -> ^( SIZEOF_TYPE type_name )
                    {
                        // Cpp.g:207:39: ^( SIZEOF_TYPE type_name )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(SIZEOF_TYPE, "SIZEOF_TYPE"), root_1);

                        adaptor.addChild(root_1, stream_type_name.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // Cpp.g:208:5: DEFINED type_name
                    {
                    DEFINED119=(Token)match(input,DEFINED,FOLLOW_DEFINED_in_unaryExpression1430); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_DEFINED.add(DEFINED119);

                    pushFollow(FOLLOW_type_name_in_unaryExpression1432);
                    type_name120=type_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type_name.add(type_name120.getTree());


                    // AST REWRITE
                    // elements: DEFINED, type_name
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 208:25: -> ^( DEFINED type_name )
                    {
                        // Cpp.g:208:28: ^( DEFINED type_name )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_DEFINED.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_type_name.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // Cpp.g:209:5: DEFINED LPAREN type_name RPAREN
                    {
                    DEFINED121=(Token)match(input,DEFINED,FOLLOW_DEFINED_in_unaryExpression1448); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_DEFINED.add(DEFINED121);

                    LPAREN122=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_unaryExpression1450); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN122);

                    pushFollow(FOLLOW_type_name_in_unaryExpression1452);
                    type_name123=type_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type_name.add(type_name123.getTree());
                    RPAREN124=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_unaryExpression1455); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN124);



                    // AST REWRITE
                    // elements: DEFINED, type_name
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 209:38: -> ^( DEFINED type_name )
                    {
                        // Cpp.g:209:40: ^( DEFINED type_name )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_DEFINED.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_type_name.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // Cpp.g:210:5: unaryExpressionNotPlusMinus
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_unaryExpressionNotPlusMinus_in_unaryExpression1468);
                    unaryExpressionNotPlusMinus125=unaryExpressionNotPlusMinus();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, unaryExpressionNotPlusMinus125.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 27, unaryExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "unaryExpression"

    public static class unaryExpressionNotPlusMinus_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "unaryExpressionNotPlusMinus"
    // Cpp.g:213:1: unaryExpressionNotPlusMinus : ( NOT unaryExpression -> ^( NOT unaryExpression ) | TILDE unaryExpression -> ^( TILDE unaryExpression ) | AMPERSAND unaryExpression -> ^( REFERANCE unaryExpression ) | STAR unaryExpression -> ^( POINTER_AT unaryExpression ) | MINUS unaryExpression -> ^( UNARY_MINUS unaryExpression ) | PLUS unaryExpression -> ^( UNARY_PLUS unaryExpression ) | LPAREN type_name RPAREN unaryExpression -> ^( TYPECAST type_name unaryExpression ) | postfixExpression );
    public final CppParser.unaryExpressionNotPlusMinus_return unaryExpressionNotPlusMinus() throws RecognitionException {
        CppParser.unaryExpressionNotPlusMinus_return retval = new CppParser.unaryExpressionNotPlusMinus_return();
        retval.start = input.LT(1);
        int unaryExpressionNotPlusMinus_StartIndex = input.index();
        Object root_0 = null;

        Token NOT126=null;
        Token TILDE128=null;
        Token AMPERSAND130=null;
        Token STAR132=null;
        Token MINUS134=null;
        Token PLUS136=null;
        Token LPAREN138=null;
        Token RPAREN140=null;
        CppParser.unaryExpression_return unaryExpression127 = null;

        CppParser.unaryExpression_return unaryExpression129 = null;

        CppParser.unaryExpression_return unaryExpression131 = null;

        CppParser.unaryExpression_return unaryExpression133 = null;

        CppParser.unaryExpression_return unaryExpression135 = null;

        CppParser.unaryExpression_return unaryExpression137 = null;

        CppParser.type_name_return type_name139 = null;

        CppParser.unaryExpression_return unaryExpression141 = null;

        CppParser.postfixExpression_return postfixExpression142 = null;


        Object NOT126_tree=null;
        Object TILDE128_tree=null;
        Object AMPERSAND130_tree=null;
        Object STAR132_tree=null;
        Object MINUS134_tree=null;
        Object PLUS136_tree=null;
        Object LPAREN138_tree=null;
        Object RPAREN140_tree=null;
        RewriteRuleTokenStream stream_AMPERSAND=new RewriteRuleTokenStream(adaptor,"token AMPERSAND");
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_PLUS=new RewriteRuleTokenStream(adaptor,"token PLUS");
        RewriteRuleTokenStream stream_STAR=new RewriteRuleTokenStream(adaptor,"token STAR");
        RewriteRuleTokenStream stream_NOT=new RewriteRuleTokenStream(adaptor,"token NOT");
        RewriteRuleTokenStream stream_MINUS=new RewriteRuleTokenStream(adaptor,"token MINUS");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleTokenStream stream_TILDE=new RewriteRuleTokenStream(adaptor,"token TILDE");
        RewriteRuleSubtreeStream stream_unaryExpression=new RewriteRuleSubtreeStream(adaptor,"rule unaryExpression");
        RewriteRuleSubtreeStream stream_type_name=new RewriteRuleSubtreeStream(adaptor,"rule type_name");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 28) ) { return retval; }
            // Cpp.g:214:3: ( NOT unaryExpression -> ^( NOT unaryExpression ) | TILDE unaryExpression -> ^( TILDE unaryExpression ) | AMPERSAND unaryExpression -> ^( REFERANCE unaryExpression ) | STAR unaryExpression -> ^( POINTER_AT unaryExpression ) | MINUS unaryExpression -> ^( UNARY_MINUS unaryExpression ) | PLUS unaryExpression -> ^( UNARY_PLUS unaryExpression ) | LPAREN type_name RPAREN unaryExpression -> ^( TYPECAST type_name unaryExpression ) | postfixExpression )
            int alt42=8;
            alt42 = dfa42.predict(input);
            switch (alt42) {
                case 1 :
                    // Cpp.g:214:5: NOT unaryExpression
                    {
                    NOT126=(Token)match(input,NOT,FOLLOW_NOT_in_unaryExpressionNotPlusMinus1481); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_NOT.add(NOT126);

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1485);
                    unaryExpression127=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression127.getTree());


                    // AST REWRITE
                    // elements: NOT, unaryExpression
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 214:27: -> ^( NOT unaryExpression )
                    {
                        // Cpp.g:214:30: ^( NOT unaryExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_NOT.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // Cpp.g:215:5: TILDE unaryExpression
                    {
                    TILDE128=(Token)match(input,TILDE,FOLLOW_TILDE_in_unaryExpressionNotPlusMinus1499); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_TILDE.add(TILDE128);

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1502);
                    unaryExpression129=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression129.getTree());


                    // AST REWRITE
                    // elements: unaryExpression, TILDE
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 215:28: -> ^( TILDE unaryExpression )
                    {
                        // Cpp.g:215:31: ^( TILDE unaryExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_TILDE.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // Cpp.g:216:5: AMPERSAND unaryExpression
                    {
                    AMPERSAND130=(Token)match(input,AMPERSAND,FOLLOW_AMPERSAND_in_unaryExpressionNotPlusMinus1517); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_AMPERSAND.add(AMPERSAND130);

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1519);
                    unaryExpression131=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression131.getTree());


                    // AST REWRITE
                    // elements: unaryExpression
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 216:31: -> ^( REFERANCE unaryExpression )
                    {
                        // Cpp.g:216:34: ^( REFERANCE unaryExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(REFERANCE, "REFERANCE"), root_1);

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // Cpp.g:217:5: STAR unaryExpression
                    {
                    STAR132=(Token)match(input,STAR,FOLLOW_STAR_in_unaryExpressionNotPlusMinus1533); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_STAR.add(STAR132);

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1536);
                    unaryExpression133=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression133.getTree());


                    // AST REWRITE
                    // elements: unaryExpression
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 217:27: -> ^( POINTER_AT unaryExpression )
                    {
                        // Cpp.g:217:30: ^( POINTER_AT unaryExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(POINTER_AT, "POINTER_AT"), root_1);

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // Cpp.g:218:5: MINUS unaryExpression
                    {
                    MINUS134=(Token)match(input,MINUS,FOLLOW_MINUS_in_unaryExpressionNotPlusMinus1550); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_MINUS.add(MINUS134);

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1553);
                    unaryExpression135=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression135.getTree());


                    // AST REWRITE
                    // elements: unaryExpression
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 218:29: -> ^( UNARY_MINUS unaryExpression )
                    {
                        // Cpp.g:218:32: ^( UNARY_MINUS unaryExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(UNARY_MINUS, "UNARY_MINUS"), root_1);

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // Cpp.g:219:5: PLUS unaryExpression
                    {
                    PLUS136=(Token)match(input,PLUS,FOLLOW_PLUS_in_unaryExpressionNotPlusMinus1568); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_PLUS.add(PLUS136);

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1572);
                    unaryExpression137=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression137.getTree());


                    // AST REWRITE
                    // elements: unaryExpression
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 219:28: -> ^( UNARY_PLUS unaryExpression )
                    {
                        // Cpp.g:219:31: ^( UNARY_PLUS unaryExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(UNARY_PLUS, "UNARY_PLUS"), root_1);

                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // Cpp.g:220:5: LPAREN type_name RPAREN unaryExpression
                    {
                    LPAREN138=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_unaryExpressionNotPlusMinus1586); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN138);

                    pushFollow(FOLLOW_type_name_in_unaryExpressionNotPlusMinus1588);
                    type_name139=type_name();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_type_name.add(type_name139.getTree());
                    RPAREN140=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_unaryExpressionNotPlusMinus1590); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN140);

                    pushFollow(FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1593);
                    unaryExpression141=unaryExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_unaryExpression.add(unaryExpression141.getTree());


                    // AST REWRITE
                    // elements: type_name, unaryExpression
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 220:46: -> ^( TYPECAST type_name unaryExpression )
                    {
                        // Cpp.g:220:49: ^( TYPECAST type_name unaryExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TYPECAST, "TYPECAST"), root_1);

                        adaptor.addChild(root_1, stream_type_name.nextTree());
                        adaptor.addChild(root_1, stream_unaryExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    // Cpp.g:221:5: postfixExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_postfixExpression_in_unaryExpressionNotPlusMinus1609);
                    postfixExpression142=postfixExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, postfixExpression142.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 28, unaryExpressionNotPlusMinus_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "unaryExpressionNotPlusMinus"

    public static class postfixExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "postfixExpression"
    // Cpp.g:224:1: postfixExpression : primaryExpression (l= LSQUARE assignmentExpression RSQUARE | DOT IDENTIFIER | s= STAR IDENTIFIER | POINTERTO IDENTIFIER | p= PLUSPLUS | m= MINUSMINUS )* ;
    public final CppParser.postfixExpression_return postfixExpression() throws RecognitionException {
        CppParser.postfixExpression_return retval = new CppParser.postfixExpression_return();
        retval.start = input.LT(1);
        int postfixExpression_StartIndex = input.index();
        Object root_0 = null;

        Token l=null;
        Token s=null;
        Token p=null;
        Token m=null;
        Token RSQUARE145=null;
        Token DOT146=null;
        Token IDENTIFIER147=null;
        Token IDENTIFIER148=null;
        Token POINTERTO149=null;
        Token IDENTIFIER150=null;
        CppParser.primaryExpression_return primaryExpression143 = null;

        CppParser.assignmentExpression_return assignmentExpression144 = null;


        Object l_tree=null;
        Object s_tree=null;
        Object p_tree=null;
        Object m_tree=null;
        Object RSQUARE145_tree=null;
        Object DOT146_tree=null;
        Object IDENTIFIER147_tree=null;
        Object IDENTIFIER148_tree=null;
        Object POINTERTO149_tree=null;
        Object IDENTIFIER150_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 29) ) { return retval; }
            // Cpp.g:225:3: ( primaryExpression (l= LSQUARE assignmentExpression RSQUARE | DOT IDENTIFIER | s= STAR IDENTIFIER | POINTERTO IDENTIFIER | p= PLUSPLUS | m= MINUSMINUS )* )
            // Cpp.g:225:7: primaryExpression (l= LSQUARE assignmentExpression RSQUARE | DOT IDENTIFIER | s= STAR IDENTIFIER | POINTERTO IDENTIFIER | p= PLUSPLUS | m= MINUSMINUS )*
            {
            root_0 = (Object)adaptor.nil();

            pushFollow(FOLLOW_primaryExpression_in_postfixExpression1624);
            primaryExpression143=primaryExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, primaryExpression143.getTree());
            // Cpp.g:226:3: (l= LSQUARE assignmentExpression RSQUARE | DOT IDENTIFIER | s= STAR IDENTIFIER | POINTERTO IDENTIFIER | p= PLUSPLUS | m= MINUSMINUS )*
            loop43:
            do {
                int alt43=7;
                alt43 = dfa43.predict(input);
                switch (alt43) {
            	case 1 :
            	    // Cpp.g:226:7: l= LSQUARE assignmentExpression RSQUARE
            	    {
            	    l=(Token)match(input,LSQUARE,FOLLOW_LSQUARE_in_postfixExpression1634); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    l_tree = (Object)adaptor.create(l);
            	    root_0 = (Object)adaptor.becomeRoot(l_tree, root_0);
            	    }
            	    if ( state.backtracking==0 ) {
            	      l.setType(INDEX_OP);
            	    }
            	    pushFollow(FOLLOW_assignmentExpression_in_postfixExpression1639);
            	    assignmentExpression144=assignmentExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) adaptor.addChild(root_0, assignmentExpression144.getTree());
            	    RSQUARE145=(Token)match(input,RSQUARE,FOLLOW_RSQUARE_in_postfixExpression1641); if (state.failed) return retval;

            	    }
            	    break;
            	case 2 :
            	    // Cpp.g:227:7: DOT IDENTIFIER
            	    {
            	    DOT146=(Token)match(input,DOT,FOLLOW_DOT_in_postfixExpression1650); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    DOT146_tree = (Object)adaptor.create(DOT146);
            	    root_0 = (Object)adaptor.becomeRoot(DOT146_tree, root_0);
            	    }
            	    IDENTIFIER147=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_postfixExpression1658); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDENTIFIER147_tree = (Object)adaptor.create(IDENTIFIER147);
            	    adaptor.addChild(root_0, IDENTIFIER147_tree);
            	    }

            	    }
            	    break;
            	case 3 :
            	    // Cpp.g:228:5: s= STAR IDENTIFIER
            	    {
            	    s=(Token)match(input,STAR,FOLLOW_STAR_in_postfixExpression1673); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    s_tree = (Object)adaptor.create(s);
            	    root_0 = (Object)adaptor.becomeRoot(s_tree, root_0);
            	    }
            	    if ( state.backtracking==0 ) {
            	      s.setType(POINTER);
            	    }
            	    IDENTIFIER148=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_postfixExpression1678); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDENTIFIER148_tree = (Object)adaptor.create(IDENTIFIER148);
            	    adaptor.addChild(root_0, IDENTIFIER148_tree);
            	    }

            	    }
            	    break;
            	case 4 :
            	    // Cpp.g:229:7: POINTERTO IDENTIFIER
            	    {
            	    POINTERTO149=(Token)match(input,POINTERTO,FOLLOW_POINTERTO_in_postfixExpression1686); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    POINTERTO149_tree = (Object)adaptor.create(POINTERTO149);
            	    root_0 = (Object)adaptor.becomeRoot(POINTERTO149_tree, root_0);
            	    }
            	    IDENTIFIER150=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_postfixExpression1689); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    IDENTIFIER150_tree = (Object)adaptor.create(IDENTIFIER150);
            	    adaptor.addChild(root_0, IDENTIFIER150_tree);
            	    }

            	    }
            	    break;
            	case 5 :
            	    // Cpp.g:230:7: p= PLUSPLUS
            	    {
            	    p=(Token)match(input,PLUSPLUS,FOLLOW_PLUSPLUS_in_postfixExpression1699); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    p_tree = (Object)adaptor.create(p);
            	    root_0 = (Object)adaptor.becomeRoot(p_tree, root_0);
            	    }
            	    if ( state.backtracking==0 ) {
            	      p.setType(POST_INC);
            	    }

            	    }
            	    break;
            	case 6 :
            	    // Cpp.g:231:7: m= MINUSMINUS
            	    {
            	    m=(Token)match(input,MINUSMINUS,FOLLOW_MINUSMINUS_in_postfixExpression1715); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    m_tree = (Object)adaptor.create(m);
            	    root_0 = (Object)adaptor.becomeRoot(m_tree, root_0);
            	    }
            	    if ( state.backtracking==0 ) {
            	      m.setType(POST_DEC);
            	    }

            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 29, postfixExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "postfixExpression"

    public static class primaryExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primaryExpression"
    // Cpp.g:235:1: primaryExpression : ( ( IDENTIFIER LPAREN )=> functionCall | IDENTIFIER | constant | LPAREN assignmentExpression RPAREN -> ^( EXPR_GROUP assignmentExpression ) );
    public final CppParser.primaryExpression_return primaryExpression() throws RecognitionException {
        CppParser.primaryExpression_return retval = new CppParser.primaryExpression_return();
        retval.start = input.LT(1);
        int primaryExpression_StartIndex = input.index();
        Object root_0 = null;

        Token IDENTIFIER152=null;
        Token LPAREN154=null;
        Token RPAREN156=null;
        CppParser.functionCall_return functionCall151 = null;

        CppParser.constant_return constant153 = null;

        CppParser.assignmentExpression_return assignmentExpression155 = null;


        Object IDENTIFIER152_tree=null;
        Object LPAREN154_tree=null;
        Object RPAREN156_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_assignmentExpression=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 30) ) { return retval; }
            // Cpp.g:236:3: ( ( IDENTIFIER LPAREN )=> functionCall | IDENTIFIER | constant | LPAREN assignmentExpression RPAREN -> ^( EXPR_GROUP assignmentExpression ) )
            int alt44=4;
            switch ( input.LA(1) ) {
            case IDENTIFIER:
                {
                int LA44_1 = input.LA(2);

                if ( (synpred84_Cpp()) ) {
                    alt44=1;
                }
                else if ( (synpred85_Cpp()) ) {
                    alt44=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 44, 1, input);

                    throw nvae;
                }
                }
                break;
            case DECIMAL_LITERAL:
            case STRING_LITERAL:
            case HEX_LITERAL:
            case OCTAL_LITERAL:
            case CHARACTER_LITERAL:
            case FLOATING_POINT_LITERAL:
                {
                alt44=3;
                }
                break;
            case LPAREN:
                {
                alt44=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // Cpp.g:236:7: ( IDENTIFIER LPAREN )=> functionCall
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_functionCall_in_primaryExpression1749);
                    functionCall151=functionCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionCall151.getTree());

                    }
                    break;
                case 2 :
                    // Cpp.g:237:7: IDENTIFIER
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER152=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primaryExpression1757); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER152_tree = (Object)adaptor.create(IDENTIFIER152);
                    adaptor.addChild(root_0, IDENTIFIER152_tree);
                    }

                    }
                    break;
                case 3 :
                    // Cpp.g:238:7: constant
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_constant_in_primaryExpression1771);
                    constant153=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant153.getTree());

                    }
                    break;
                case 4 :
                    // Cpp.g:239:7: LPAREN assignmentExpression RPAREN
                    {
                    LPAREN154=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_primaryExpression1784); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN154);

                    pushFollow(FOLLOW_assignmentExpression_in_primaryExpression1787);
                    assignmentExpression155=assignmentExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_assignmentExpression.add(assignmentExpression155.getTree());
                    RPAREN156=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_primaryExpression1789); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN156);



                    // AST REWRITE
                    // elements: assignmentExpression
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 239:44: -> ^( EXPR_GROUP assignmentExpression )
                    {
                        // Cpp.g:239:47: ^( EXPR_GROUP assignmentExpression )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPR_GROUP, "EXPR_GROUP"), root_1);

                        adaptor.addChild(root_1, stream_assignmentExpression.nextTree());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 30, primaryExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "primaryExpression"

    public static class functionCall_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionCall"
    // Cpp.g:242:1: functionCall : id= IDENTIFIER LPAREN ( argList )? RPAREN -> ^( METHOD_CALL $id ( argList )? ) ;
    public final CppParser.functionCall_return functionCall() throws RecognitionException {
        CppParser.functionCall_return retval = new CppParser.functionCall_return();
        retval.start = input.LT(1);
        int functionCall_StartIndex = input.index();
        Object root_0 = null;

        Token id=null;
        Token LPAREN157=null;
        Token RPAREN159=null;
        CppParser.argList_return argList158 = null;


        Object id_tree=null;
        Object LPAREN157_tree=null;
        Object RPAREN159_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_argList=new RewriteRuleSubtreeStream(adaptor,"rule argList");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 31) ) { return retval; }
            // Cpp.g:243:3: (id= IDENTIFIER LPAREN ( argList )? RPAREN -> ^( METHOD_CALL $id ( argList )? ) )
            // Cpp.g:243:5: id= IDENTIFIER LPAREN ( argList )? RPAREN
            {
            id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_functionCall1816); if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_IDENTIFIER.add(id);

            LPAREN157=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_functionCall1818); if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN157);

            // Cpp.g:243:26: ( argList )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( ((LA45_0>=IDENTIFIER && LA45_0<=LPAREN)||(LA45_0>=DECIMAL_LITERAL && LA45_0<=STRING_LITERAL)||LA45_0==AMPERSAND||(LA45_0>=PLUS && LA45_0<=STAR)||(LA45_0>=PLUSPLUS && LA45_0<=TILDE)||(LA45_0>=HEX_LITERAL && LA45_0<=FLOATING_POINT_LITERAL)) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // Cpp.g:0:0: argList
                    {
                    pushFollow(FOLLOW_argList_in_functionCall1820);
                    argList158=argList();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_argList.add(argList158.getTree());

                    }
                    break;

            }

            RPAREN159=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_functionCall1823); if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN159);



            // AST REWRITE
            // elements: id, argList
            // token labels: id
            // rule labels: retval
            // token list labels:
            // rule list labels:
            // wildcard labels:
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 243:43: -> ^( METHOD_CALL $id ( argList )? )
            {
                // Cpp.g:243:46: ^( METHOD_CALL $id ( argList )? )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(METHOD_CALL, "METHOD_CALL"), root_1);

                adaptor.addChild(root_1, stream_id.nextNode());
                // Cpp.g:243:64: ( argList )?
                if ( stream_argList.hasNext() ) {
                    adaptor.addChild(root_1, stream_argList.nextTree());

                }
                stream_argList.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 31, functionCall_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "functionCall"

    public static class argList_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "argList"
    // Cpp.g:246:1: argList : assignmentExpression ( COMMA assignmentExpression )* -> ^( ARGS ( assignmentExpression )+ ) ;
    public final CppParser.argList_return argList() throws RecognitionException {
        CppParser.argList_return retval = new CppParser.argList_return();
        retval.start = input.LT(1);
        int argList_StartIndex = input.index();
        Object root_0 = null;

        Token COMMA161=null;
        CppParser.assignmentExpression_return assignmentExpression160 = null;

        CppParser.assignmentExpression_return assignmentExpression162 = null;


        Object COMMA161_tree=null;
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_assignmentExpression=new RewriteRuleSubtreeStream(adaptor,"rule assignmentExpression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 32) ) { return retval; }
            // Cpp.g:247:3: ( assignmentExpression ( COMMA assignmentExpression )* -> ^( ARGS ( assignmentExpression )+ ) )
            // Cpp.g:247:5: assignmentExpression ( COMMA assignmentExpression )*
            {
            pushFollow(FOLLOW_assignmentExpression_in_argList1849);
            assignmentExpression160=assignmentExpression();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_assignmentExpression.add(assignmentExpression160.getTree());
            // Cpp.g:247:26: ( COMMA assignmentExpression )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==COMMA) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // Cpp.g:247:27: COMMA assignmentExpression
            	    {
            	    COMMA161=(Token)match(input,COMMA,FOLLOW_COMMA_in_argList1852); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA161);

            	    pushFollow(FOLLOW_assignmentExpression_in_argList1854);
            	    assignmentExpression162=assignmentExpression();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_assignmentExpression.add(assignmentExpression162.getTree());

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);



            // AST REWRITE
            // elements: assignmentExpression
            // token labels:
            // rule labels: retval
            // token list labels:
            // rule list labels:
            // wildcard labels:
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 247:56: -> ^( ARGS ( assignmentExpression )+ )
            {
                // Cpp.g:247:59: ^( ARGS ( assignmentExpression )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(ARGS, "ARGS"), root_1);

                if ( !(stream_assignmentExpression.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_assignmentExpression.hasNext() ) {
                    adaptor.addChild(root_1, stream_assignmentExpression.nextTree());

                }
                stream_assignmentExpression.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 32, argList_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "argList"

    public static class constant_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "constant"
    // Cpp.g:250:1: constant : ( HEX_LITERAL | OCTAL_LITERAL | DECIMAL_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | FLOATING_POINT_LITERAL );
    public final CppParser.constant_return constant() throws RecognitionException {
        CppParser.constant_return retval = new CppParser.constant_return();
        retval.start = input.LT(1);
        int constant_StartIndex = input.index();
        Object root_0 = null;

        Token set163=null;

        Object set163_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 33) ) { return retval; }
            // Cpp.g:251:3: ( HEX_LITERAL | OCTAL_LITERAL | DECIMAL_LITERAL | CHARACTER_LITERAL | STRING_LITERAL | FLOATING_POINT_LITERAL )
            // Cpp.g:
            {
            root_0 = (Object)adaptor.nil();

            set163=(Token)input.LT(1);
            if ( (input.LA(1)>=DECIMAL_LITERAL && input.LA(1)<=STRING_LITERAL)||(input.LA(1)>=HEX_LITERAL && input.LA(1)<=FLOATING_POINT_LITERAL) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (Object)adaptor.create(set163));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 33, constant_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "constant"

    public static class source_text_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "source_text"
    // Cpp.g:261:1: source_text : ( sourceExpression | COMMA | LPAREN | RPAREN | WS );
    public final CppParser.source_text_return source_text() throws RecognitionException {
        CppParser.source_text_return retval = new CppParser.source_text_return();
        retval.start = input.LT(1);
        int source_text_StartIndex = input.index();
        Object root_0 = null;

        Token COMMA165=null;
        Token LPAREN166=null;
        Token RPAREN167=null;
        Token WS168=null;
        CppParser.sourceExpression_return sourceExpression164 = null;


        Object COMMA165_tree=null;
        Object LPAREN166_tree=null;
        Object RPAREN167_tree=null;
        Object WS168_tree=null;

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 34) ) { return retval; }
            // Cpp.g:262:3: ( sourceExpression | COMMA | LPAREN | RPAREN | WS )
            int alt47=5;
            alt47 = dfa47.predict(input);
            switch (alt47) {
                case 1 :
                    // Cpp.g:262:7: sourceExpression
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_sourceExpression_in_source_text1936);
                    sourceExpression164=sourceExpression();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, sourceExpression164.getTree());

                    }
                    break;
                case 2 :
                    // Cpp.g:263:5: COMMA
                    {
                    root_0 = (Object)adaptor.nil();

                    COMMA165=(Token)match(input,COMMA,FOLLOW_COMMA_in_source_text1942); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COMMA165_tree = (Object)adaptor.create(COMMA165);
                    adaptor.addChild(root_0, COMMA165_tree);
                    }

                    }
                    break;
                case 3 :
                    // Cpp.g:264:5: LPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    LPAREN166=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_source_text1948); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    LPAREN166_tree = (Object)adaptor.create(LPAREN166);
                    adaptor.addChild(root_0, LPAREN166_tree);
                    }

                    }
                    break;
                case 4 :
                    // Cpp.g:265:5: RPAREN
                    {
                    root_0 = (Object)adaptor.nil();

                    RPAREN167=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_source_text1954); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    RPAREN167_tree = (Object)adaptor.create(RPAREN167);
                    adaptor.addChild(root_0, RPAREN167_tree);
                    }

                    }
                    break;
                case 5 :
                    // Cpp.g:266:5: WS
                    {
                    root_0 = (Object)adaptor.nil();

                    WS168=(Token)match(input,WS,FOLLOW_WS_in_source_text1960); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WS168_tree = (Object)adaptor.create(WS168);
                    adaptor.addChild(root_0, WS168_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 34, source_text_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "source_text"

    public static class macroExpansion_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "macroExpansion"
    // Cpp.g:269:1: macroExpansion : (id= IDENTIFIER ( WS )? LPAREN ( WS )? RPAREN -> ^( EXPAND $id) | id= IDENTIFIER ( WS )? LPAREN ( WS )? macArgs ( WS )? RPAREN -> ^( EXPAND $id ( macArgs )? ) );
    public final CppParser.macroExpansion_return macroExpansion() throws RecognitionException {
        CppParser.macroExpansion_return retval = new CppParser.macroExpansion_return();
        retval.start = input.LT(1);
        int macroExpansion_StartIndex = input.index();
        Object root_0 = null;

        Token id=null;
        Token WS169=null;
        Token LPAREN170=null;
        Token WS171=null;
        Token RPAREN172=null;
        Token WS173=null;
        Token LPAREN174=null;
        Token WS175=null;
        Token WS177=null;
        Token RPAREN178=null;
        CppParser.macArgs_return macArgs176 = null;


        Object id_tree=null;
        Object WS169_tree=null;
        Object LPAREN170_tree=null;
        Object WS171_tree=null;
        Object RPAREN172_tree=null;
        Object WS173_tree=null;
        Object LPAREN174_tree=null;
        Object WS175_tree=null;
        Object WS177_tree=null;
        Object RPAREN178_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_macArgs=new RewriteRuleSubtreeStream(adaptor,"rule macArgs");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 35) ) { return retval; }
            // Cpp.g:270:3: (id= IDENTIFIER ( WS )? LPAREN ( WS )? RPAREN -> ^( EXPAND $id) | id= IDENTIFIER ( WS )? LPAREN ( WS )? macArgs ( WS )? RPAREN -> ^( EXPAND $id ( macArgs )? ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==IDENTIFIER) ) {
                int LA53_1 = input.LA(2);

                if ( (LA53_1==WS) ) {
                    int LA53_2 = input.LA(3);

                    if ( (LA53_2==LPAREN) ) {
                        switch ( input.LA(4) ) {
                        case WS:
                            {
                            int LA53_4 = input.LA(5);

                            if ( (LA53_4==TEXT_END||(LA53_4>=IDENTIFIER && LA53_4<=WS)||LA53_4==COMMA||(LA53_4>=DECIMAL_LITERAL && LA53_4<=STRING_LITERAL)||LA53_4==SIZEOF||(LA53_4>=HEX_LITERAL && LA53_4<=COPERATOR)) ) {
                                alt53=2;
                            }
                            else if ( (LA53_4==RPAREN) ) {
                                int LA53_5 = input.LA(6);

                                if ( (synpred100_Cpp()) ) {
                                    alt53=1;
                                }
                                else if ( (true) ) {
                                    alt53=2;
                                }
                                else {
                                    if (state.backtracking>0) {state.failed=true; return retval;}
                                    NoViableAltException nvae =
                                        new NoViableAltException("", 53, 5, input);

                                    throw nvae;
                                }
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 53, 4, input);

                                throw nvae;
                            }
                            }
                            break;
                        case RPAREN:
                            {
                            int LA53_5 = input.LA(5);

                            if ( (synpred100_Cpp()) ) {
                                alt53=1;
                            }
                            else if ( (true) ) {
                                alt53=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 53, 5, input);

                                throw nvae;
                            }
                            }
                            break;
                        case TEXT_END:
                        case IDENTIFIER:
                        case LPAREN:
                        case COMMA:
                        case DECIMAL_LITERAL:
                        case STRING_LITERAL:
                        case SIZEOF:
                        case HEX_LITERAL:
                        case OCTAL_LITERAL:
                        case CHARACTER_LITERAL:
                        case FLOATING_POINT_LITERAL:
                        case STRINGIFICATION:
                        case STRING_OP:
                        case SEMICOLON:
                        case SHARPSHARP:
                        case CKEYWORD:
                        case COPERATOR:
                            {
                            alt53=2;
                            }
                            break;
                        default:
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 53, 3, input);

                            throw nvae;
                        }

                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 53, 2, input);

                        throw nvae;
                    }
                }
                else if ( (LA53_1==LPAREN) ) {
                    switch ( input.LA(3) ) {
                    case WS:
                        {
                        int LA53_4 = input.LA(4);

                        if ( (LA53_4==TEXT_END||(LA53_4>=IDENTIFIER && LA53_4<=WS)||LA53_4==COMMA||(LA53_4>=DECIMAL_LITERAL && LA53_4<=STRING_LITERAL)||LA53_4==SIZEOF||(LA53_4>=HEX_LITERAL && LA53_4<=COPERATOR)) ) {
                            alt53=2;
                        }
                        else if ( (LA53_4==RPAREN) ) {
                            int LA53_5 = input.LA(5);

                            if ( (synpred100_Cpp()) ) {
                                alt53=1;
                            }
                            else if ( (true) ) {
                                alt53=2;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return retval;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 53, 5, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 53, 4, input);

                            throw nvae;
                        }
                        }
                        break;
                    case RPAREN:
                        {
                        int LA53_5 = input.LA(4);

                        if ( (synpred100_Cpp()) ) {
                            alt53=1;
                        }
                        else if ( (true) ) {
                            alt53=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return retval;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 53, 5, input);

                            throw nvae;
                        }
                        }
                        break;
                    case TEXT_END:
                    case IDENTIFIER:
                    case LPAREN:
                    case COMMA:
                    case DECIMAL_LITERAL:
                    case STRING_LITERAL:
                    case SIZEOF:
                    case HEX_LITERAL:
                    case OCTAL_LITERAL:
                    case CHARACTER_LITERAL:
                    case FLOATING_POINT_LITERAL:
                    case STRINGIFICATION:
                    case STRING_OP:
                    case SEMICOLON:
                    case SHARPSHARP:
                    case CKEYWORD:
                    case COPERATOR:
                        {
                        alt53=2;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 53, 3, input);

                        throw nvae;
                    }

                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 53, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // Cpp.g:270:5: id= IDENTIFIER ( WS )? LPAREN ( WS )? RPAREN
                    {
                    id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroExpansion1976); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(id);

                    // Cpp.g:270:19: ( WS )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( (LA48_0==WS) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // Cpp.g:0:0: WS
                            {
                            WS169=(Token)match(input,WS,FOLLOW_WS_in_macroExpansion1978); if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_WS.add(WS169);


                            }
                            break;

                    }

                    LPAREN170=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_macroExpansion1981); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN170);

                    // Cpp.g:270:30: ( WS )?
                    int alt49=2;
                    int LA49_0 = input.LA(1);

                    if ( (LA49_0==WS) ) {
                        alt49=1;
                    }
                    switch (alt49) {
                        case 1 :
                            // Cpp.g:0:0: WS
                            {
                            WS171=(Token)match(input,WS,FOLLOW_WS_in_macroExpansion1983); if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_WS.add(WS171);


                            }
                            break;

                    }

                    RPAREN172=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_macroExpansion1988); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN172);



                    // AST REWRITE
                    // elements: id
                    // token labels: id
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 270:44: -> ^( EXPAND $id)
                    {
                        // Cpp.g:270:47: ^( EXPAND $id)
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPAND, "EXPAND"), root_1);

                        adaptor.addChild(root_1, stream_id.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // Cpp.g:271:5: id= IDENTIFIER ( WS )? LPAREN ( WS )? macArgs ( WS )? RPAREN
                    {
                    id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_macroExpansion2006); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(id);

                    // Cpp.g:271:19: ( WS )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( (LA50_0==WS) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // Cpp.g:0:0: WS
                            {
                            WS173=(Token)match(input,WS,FOLLOW_WS_in_macroExpansion2008); if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_WS.add(WS173);


                            }
                            break;

                    }

                    LPAREN174=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_macroExpansion2011); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN174);

                    // Cpp.g:271:30: ( WS )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==WS) ) {
                        int LA51_1 = input.LA(2);

                        if ( (synpred102_Cpp()) ) {
                            alt51=1;
                        }
                    }
                    switch (alt51) {
                        case 1 :
                            // Cpp.g:0:0: WS
                            {
                            WS175=(Token)match(input,WS,FOLLOW_WS_in_macroExpansion2013); if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_WS.add(WS175);


                            }
                            break;

                    }

                    pushFollow(FOLLOW_macArgs_in_macroExpansion2016);
                    macArgs176=macArgs();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_macArgs.add(macArgs176.getTree());
                    // Cpp.g:271:43: ( WS )?
                    int alt52=2;
                    int LA52_0 = input.LA(1);

                    if ( (LA52_0==WS) ) {
                        alt52=1;
                    }
                    switch (alt52) {
                        case 1 :
                            // Cpp.g:0:0: WS
                            {
                            WS177=(Token)match(input,WS,FOLLOW_WS_in_macroExpansion2019); if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_WS.add(WS177);


                            }
                            break;

                    }

                    RPAREN178=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_macroExpansion2022); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN178);



                    // AST REWRITE
                    // elements: macArgs, id
                    // token labels: id
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_id=new RewriteRuleTokenStream(adaptor,"token id",id);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 271:55: -> ^( EXPAND $id ( macArgs )? )
                    {
                        // Cpp.g:271:58: ^( EXPAND $id ( macArgs )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXPAND, "EXPAND"), root_1);

                        adaptor.addChild(root_1, stream_id.nextNode());
                        // Cpp.g:271:71: ( macArgs )?
                        if ( stream_macArgs.hasNext() ) {
                            adaptor.addChild(root_1, stream_macArgs.nextTree());

                        }
                        stream_macArgs.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 35, macroExpansion_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "macroExpansion"

    public static class macArgs_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "macArgs"
    // Cpp.g:274:1: macArgs : marg+= mArg ( ( WS )? COMMA ( WS )? marg+= mArg )* -> ^( EXP_ARGS ( $marg)+ ) ;
    public final CppParser.macArgs_return macArgs() throws RecognitionException {
        CppParser.macArgs_return retval = new CppParser.macArgs_return();
        retval.start = input.LT(1);
        int macArgs_StartIndex = input.index();
        Object root_0 = null;

        Token WS179=null;
        Token COMMA180=null;
        Token WS181=null;
        List list_marg=null;
        RuleReturnScope marg = null;
        Object WS179_tree=null;
        Object COMMA180_tree=null;
        Object WS181_tree=null;
        RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
        RewriteRuleTokenStream stream_COMMA=new RewriteRuleTokenStream(adaptor,"token COMMA");
        RewriteRuleSubtreeStream stream_mArg=new RewriteRuleSubtreeStream(adaptor,"rule mArg");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 36) ) { return retval; }
            // Cpp.g:274:9: (marg+= mArg ( ( WS )? COMMA ( WS )? marg+= mArg )* -> ^( EXP_ARGS ( $marg)+ ) )
            // Cpp.g:274:11: marg+= mArg ( ( WS )? COMMA ( WS )? marg+= mArg )*
            {
            pushFollow(FOLLOW_mArg_in_macArgs2048);
            marg=mArg();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_mArg.add(marg.getTree());
            if (list_marg==null) list_marg=new ArrayList();
            list_marg.add(marg.getTree());

            // Cpp.g:274:22: ( ( WS )? COMMA ( WS )? marg+= mArg )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==WS) ) {
                    int LA56_1 = input.LA(2);

                    if ( (LA56_1==COMMA) ) {
                        alt56=1;
                    }


                }
                else if ( (LA56_0==COMMA) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // Cpp.g:274:24: ( WS )? COMMA ( WS )? marg+= mArg
            	    {
            	    // Cpp.g:274:24: ( WS )?
            	    int alt54=2;
            	    int LA54_0 = input.LA(1);

            	    if ( (LA54_0==WS) ) {
            	        alt54=1;
            	    }
            	    switch (alt54) {
            	        case 1 :
            	            // Cpp.g:0:0: WS
            	            {
            	            WS179=(Token)match(input,WS,FOLLOW_WS_in_macArgs2052); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) stream_WS.add(WS179);


            	            }
            	            break;

            	    }

            	    COMMA180=(Token)match(input,COMMA,FOLLOW_COMMA_in_macArgs2055); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_COMMA.add(COMMA180);

            	    // Cpp.g:274:34: ( WS )?
            	    int alt55=2;
            	    int LA55_0 = input.LA(1);

            	    if ( (LA55_0==WS) ) {
            	        int LA55_1 = input.LA(2);

            	        if ( (synpred105_Cpp()) ) {
            	            alt55=1;
            	        }
            	    }
            	    switch (alt55) {
            	        case 1 :
            	            // Cpp.g:0:0: WS
            	            {
            	            WS181=(Token)match(input,WS,FOLLOW_WS_in_macArgs2057); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) stream_WS.add(WS181);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_mArg_in_macArgs2062);
            	    marg=mArg();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_mArg.add(marg.getTree());
            	    if (list_marg==null) list_marg=new ArrayList();
            	    list_marg.add(marg.getTree());


            	    }
            	    break;

            	default :
            	    break loop56;
                }
            } while (true);



            // AST REWRITE
            // elements: marg
            // token labels:
            // rule labels: retval
            // token list labels:
            // rule list labels: marg
            // wildcard labels:
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_marg=new RewriteRuleSubtreeStream(adaptor,"token marg",list_marg);
            root_0 = (Object)adaptor.nil();
            // 274:52: -> ^( EXP_ARGS ( $marg)+ )
            {
                // Cpp.g:274:55: ^( EXP_ARGS ( $marg)+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXP_ARGS, "EXP_ARGS"), root_1);

                if ( !(stream_marg.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_marg.hasNext() ) {
                    adaptor.addChild(root_1, stream_marg.nextTree());

                }
                stream_marg.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 36, macArgs_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "macArgs"

    public static class mArg_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "mArg"
    // Cpp.g:277:1: mArg : ( ( sourceExpression )+ -> ^( EXP_ARG ( sourceExpression )+ ) | -> ^( EXP_ARG ) );
    public final CppParser.mArg_return mArg() throws RecognitionException {
        CppParser.mArg_return retval = new CppParser.mArg_return();
        retval.start = input.LT(1);
        int mArg_StartIndex = input.index();
        Object root_0 = null;

        CppParser.sourceExpression_return sourceExpression182 = null;


        RewriteRuleSubtreeStream stream_sourceExpression=new RewriteRuleSubtreeStream(adaptor,"rule sourceExpression");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 37) ) { return retval; }
            // Cpp.g:277:6: ( ( sourceExpression )+ -> ^( EXP_ARG ( sourceExpression )+ ) | -> ^( EXP_ARG ) )
            int alt58=2;
            switch ( input.LA(1) ) {
            case TEXT_END:
            case IDENTIFIER:
            case LPAREN:
            case DECIMAL_LITERAL:
            case STRING_LITERAL:
            case SIZEOF:
            case HEX_LITERAL:
            case OCTAL_LITERAL:
            case CHARACTER_LITERAL:
            case FLOATING_POINT_LITERAL:
            case STRINGIFICATION:
            case STRING_OP:
            case SEMICOLON:
            case SHARPSHARP:
            case CKEYWORD:
            case COPERATOR:
                {
                alt58=1;
                }
                break;
            case WS:
                {
                int LA58_2 = input.LA(2);

                if ( (synpred108_Cpp()) ) {
                    alt58=1;
                }
                else if ( (true) ) {
                    alt58=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 58, 2, input);

                    throw nvae;
                }
                }
                break;
            case EOF:
            case RPAREN:
            case COMMA:
                {
                alt58=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // Cpp.g:277:8: ( sourceExpression )+
                    {
                    // Cpp.g:277:8: ( sourceExpression )+
                    int cnt57=0;
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==WS) ) {
                            int LA57_1 = input.LA(2);

                            if ( (synpred107_Cpp()) ) {
                                alt57=1;
                            }


                        }
                        else if ( (LA57_0==TEXT_END||(LA57_0>=IDENTIFIER && LA57_0<=LPAREN)||(LA57_0>=DECIMAL_LITERAL && LA57_0<=STRING_LITERAL)||LA57_0==SIZEOF||(LA57_0>=HEX_LITERAL && LA57_0<=COPERATOR)) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // Cpp.g:0:0: sourceExpression
                    	    {
                    	    pushFollow(FOLLOW_sourceExpression_in_mArg2086);
                    	    sourceExpression182=sourceExpression();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_sourceExpression.add(sourceExpression182.getTree());

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt57 >= 1 ) break loop57;
                    	    if (state.backtracking>0) {state.failed=true; return retval;}
                                EarlyExitException eee =
                                    new EarlyExitException(57, input);
                                throw eee;
                        }
                        cnt57++;
                    } while (true);



                    // AST REWRITE
                    // elements: sourceExpression
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 277:27: -> ^( EXP_ARG ( sourceExpression )+ )
                    {
                        // Cpp.g:277:30: ^( EXP_ARG ( sourceExpression )+ )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXP_ARG, "EXP_ARG"), root_1);

                        if ( !(stream_sourceExpression.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_sourceExpression.hasNext() ) {
                            adaptor.addChild(root_1, stream_sourceExpression.nextTree());

                        }
                        stream_sourceExpression.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // Cpp.g:278:5:
                    {

                    // AST REWRITE
                    // elements:
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 278:5: -> ^( EXP_ARG )
                    {
                        // Cpp.g:278:8: ^( EXP_ARG )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(EXP_ARG, "EXP_ARG"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 37, mArg_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "mArg"

    public static class sourceExpression_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "sourceExpression"
    // Cpp.g:281:1: sourceExpression : ( ( IDENTIFIER ( WS )? LPAREN )=> macroExpansion | ( primarySource ( WS )? SHARPSHARP )=> concatenate | STRINGIFICATION IDENTIFIER -> ^( STRINGIFICATION IDENTIFIER ) | primarySource | STRING_OP | SIZEOF | LPAREN ( macArgs )? RPAREN -> ^( TEXT_GROUP ( macArgs )? ) | SEMICOLON | TEXT_END | WS );
    public final CppParser.sourceExpression_return sourceExpression() throws RecognitionException {
        CppParser.sourceExpression_return retval = new CppParser.sourceExpression_return();
        retval.start = input.LT(1);
        int sourceExpression_StartIndex = input.index();
        Object root_0 = null;

        Token STRINGIFICATION185=null;
        Token IDENTIFIER186=null;
        Token STRING_OP188=null;
        Token SIZEOF189=null;
        Token LPAREN190=null;
        Token RPAREN192=null;
        Token SEMICOLON193=null;
        Token TEXT_END194=null;
        Token WS195=null;
        CppParser.macroExpansion_return macroExpansion183 = null;

        CppParser.concatenate_return concatenate184 = null;

        CppParser.primarySource_return primarySource187 = null;

        CppParser.macArgs_return macArgs191 = null;


        Object STRINGIFICATION185_tree=null;
        Object IDENTIFIER186_tree=null;
        Object STRING_OP188_tree=null;
        Object SIZEOF189_tree=null;
        Object LPAREN190_tree=null;
        Object RPAREN192_tree=null;
        Object SEMICOLON193_tree=null;
        Object TEXT_END194_tree=null;
        Object WS195_tree=null;
        RewriteRuleTokenStream stream_RPAREN=new RewriteRuleTokenStream(adaptor,"token RPAREN");
        RewriteRuleTokenStream stream_STRINGIFICATION=new RewriteRuleTokenStream(adaptor,"token STRINGIFICATION");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");
        RewriteRuleTokenStream stream_LPAREN=new RewriteRuleTokenStream(adaptor,"token LPAREN");
        RewriteRuleSubtreeStream stream_macArgs=new RewriteRuleSubtreeStream(adaptor,"rule macArgs");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 38) ) { return retval; }
            // Cpp.g:282:3: ( ( IDENTIFIER ( WS )? LPAREN )=> macroExpansion | ( primarySource ( WS )? SHARPSHARP )=> concatenate | STRINGIFICATION IDENTIFIER -> ^( STRINGIFICATION IDENTIFIER ) | primarySource | STRING_OP | SIZEOF | LPAREN ( macArgs )? RPAREN -> ^( TEXT_GROUP ( macArgs )? ) | SEMICOLON | TEXT_END | WS )
            int alt60=10;
            alt60 = dfa60.predict(input);
            switch (alt60) {
                case 1 :
                    // Cpp.g:282:5: ( IDENTIFIER ( WS )? LPAREN )=> macroExpansion
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_macroExpansion_in_sourceExpression2131);
                    macroExpansion183=macroExpansion();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, macroExpansion183.getTree());

                    }
                    break;
                case 2 :
                    // Cpp.g:283:5: ( primarySource ( WS )? SHARPSHARP )=> concatenate
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_concatenate_in_sourceExpression2150);
                    concatenate184=concatenate();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, concatenate184.getTree());

                    }
                    break;
                case 3 :
                    // Cpp.g:284:5: STRINGIFICATION IDENTIFIER
                    {
                    STRINGIFICATION185=(Token)match(input,STRINGIFICATION,FOLLOW_STRINGIFICATION_in_sourceExpression2156); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_STRINGIFICATION.add(STRINGIFICATION185);

                    IDENTIFIER186=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_sourceExpression2158); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER186);



                    // AST REWRITE
                    // elements: STRINGIFICATION, IDENTIFIER
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 284:33: -> ^( STRINGIFICATION IDENTIFIER )
                    {
                        // Cpp.g:284:36: ^( STRINGIFICATION IDENTIFIER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_STRINGIFICATION.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // Cpp.g:285:5: primarySource
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_primarySource_in_sourceExpression2173);
                    primarySource187=primarySource();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, primarySource187.getTree());

                    }
                    break;
                case 5 :
                    // Cpp.g:286:5: STRING_OP
                    {
                    root_0 = (Object)adaptor.nil();

                    STRING_OP188=(Token)match(input,STRING_OP,FOLLOW_STRING_OP_in_sourceExpression2179); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    STRING_OP188_tree = (Object)adaptor.create(STRING_OP188);
                    adaptor.addChild(root_0, STRING_OP188_tree);
                    }

                    }
                    break;
                case 6 :
                    // Cpp.g:287:5: SIZEOF
                    {
                    root_0 = (Object)adaptor.nil();

                    SIZEOF189=(Token)match(input,SIZEOF,FOLLOW_SIZEOF_in_sourceExpression2185); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SIZEOF189_tree = (Object)adaptor.create(SIZEOF189);
                    adaptor.addChild(root_0, SIZEOF189_tree);
                    }

                    }
                    break;
                case 7 :
                    // Cpp.g:288:5: LPAREN ( macArgs )? RPAREN
                    {
                    LPAREN190=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_sourceExpression2191); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_LPAREN.add(LPAREN190);

                    // Cpp.g:288:12: ( macArgs )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==TEXT_END||(LA59_0>=IDENTIFIER && LA59_0<=WS)||LA59_0==COMMA||(LA59_0>=DECIMAL_LITERAL && LA59_0<=STRING_LITERAL)||LA59_0==SIZEOF||(LA59_0>=HEX_LITERAL && LA59_0<=COPERATOR)) ) {
                        alt59=1;
                    }
                    else if ( (LA59_0==RPAREN) ) {
                        int LA59_2 = input.LA(2);

                        if ( (synpred117_Cpp()) ) {
                            alt59=1;
                        }
                    }
                    switch (alt59) {
                        case 1 :
                            // Cpp.g:0:0: macArgs
                            {
                            pushFollow(FOLLOW_macArgs_in_sourceExpression2193);
                            macArgs191=macArgs();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_macArgs.add(macArgs191.getTree());

                            }
                            break;

                    }

                    RPAREN192=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_sourceExpression2196); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_RPAREN.add(RPAREN192);



                    // AST REWRITE
                    // elements: macArgs
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 288:28: -> ^( TEXT_GROUP ( macArgs )? )
                    {
                        // Cpp.g:288:31: ^( TEXT_GROUP ( macArgs )? )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(TEXT_GROUP, "TEXT_GROUP"), root_1);

                        // Cpp.g:288:44: ( macArgs )?
                        if ( stream_macArgs.hasNext() ) {
                            adaptor.addChild(root_1, stream_macArgs.nextTree());

                        }
                        stream_macArgs.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    // Cpp.g:289:5: SEMICOLON
                    {
                    root_0 = (Object)adaptor.nil();

                    SEMICOLON193=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_sourceExpression2211); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    SEMICOLON193_tree = (Object)adaptor.create(SEMICOLON193);
                    adaptor.addChild(root_0, SEMICOLON193_tree);
                    }

                    }
                    break;
                case 9 :
                    // Cpp.g:290:5: TEXT_END
                    {
                    root_0 = (Object)adaptor.nil();

                    TEXT_END194=(Token)match(input,TEXT_END,FOLLOW_TEXT_END_in_sourceExpression2217); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    TEXT_END194_tree = (Object)adaptor.create(TEXT_END194);
                    adaptor.addChild(root_0, TEXT_END194_tree);
                    }

                    }
                    break;
                case 10 :
                    // Cpp.g:291:5: WS
                    {
                    root_0 = (Object)adaptor.nil();

                    WS195=(Token)match(input,WS,FOLLOW_WS_in_sourceExpression2223); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    WS195_tree = (Object)adaptor.create(WS195);
                    adaptor.addChild(root_0, WS195_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 38, sourceExpression_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "sourceExpression"

    public static class concatenate_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "concatenate"
    // Cpp.g:294:1: concatenate : prim+= primarySource ( ( WS )? SHARPSHARP ( WS )? prim+= primarySource )+ -> ^( CONCATENATE ( $prim)+ ) ;
    public final CppParser.concatenate_return concatenate() throws RecognitionException {
        CppParser.concatenate_return retval = new CppParser.concatenate_return();
        retval.start = input.LT(1);
        int concatenate_StartIndex = input.index();
        Object root_0 = null;

        Token WS196=null;
        Token SHARPSHARP197=null;
        Token WS198=null;
        List list_prim=null;
        RuleReturnScope prim = null;
        Object WS196_tree=null;
        Object SHARPSHARP197_tree=null;
        Object WS198_tree=null;
        RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
        RewriteRuleTokenStream stream_SHARPSHARP=new RewriteRuleTokenStream(adaptor,"token SHARPSHARP");
        RewriteRuleSubtreeStream stream_primarySource=new RewriteRuleSubtreeStream(adaptor,"rule primarySource");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 39) ) { return retval; }
            // Cpp.g:295:3: (prim+= primarySource ( ( WS )? SHARPSHARP ( WS )? prim+= primarySource )+ -> ^( CONCATENATE ( $prim)+ ) )
            // Cpp.g:295:5: prim+= primarySource ( ( WS )? SHARPSHARP ( WS )? prim+= primarySource )+
            {
            pushFollow(FOLLOW_primarySource_in_concatenate2238);
            prim=primarySource();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_primarySource.add(prim.getTree());
            if (list_prim==null) list_prim=new ArrayList();
            list_prim.add(prim.getTree());

            // Cpp.g:295:25: ( ( WS )? SHARPSHARP ( WS )? prim+= primarySource )+
            int cnt63=0;
            loop63:
            do {
                int alt63=2;
                int LA63_0 = input.LA(1);

                if ( (LA63_0==SHARPSHARP) ) {
                    switch ( input.LA(2) ) {
                    case WS:
                        {
                        int LA63_4 = input.LA(3);

                        if ( (LA63_4==IDENTIFIER) ) {
                            int LA63_5 = input.LA(4);

                            if ( (synpred123_Cpp()) ) {
                                alt63=1;
                            }


                        }
                        else if ( ((LA63_4>=DECIMAL_LITERAL && LA63_4<=STRING_LITERAL)||(LA63_4>=HEX_LITERAL && LA63_4<=FLOATING_POINT_LITERAL)||(LA63_4>=SHARPSHARP && LA63_4<=COPERATOR)) ) {
                            alt63=1;
                        }


                        }
                        break;
                    case IDENTIFIER:
                        {
                        int LA63_5 = input.LA(3);

                        if ( (synpred123_Cpp()) ) {
                            alt63=1;
                        }


                        }
                        break;
                    case DECIMAL_LITERAL:
                    case STRING_LITERAL:
                    case HEX_LITERAL:
                    case OCTAL_LITERAL:
                    case CHARACTER_LITERAL:
                    case FLOATING_POINT_LITERAL:
                    case SHARPSHARP:
                    case CKEYWORD:
                    case COPERATOR:
                        {
                        alt63=1;
                        }
                        break;

                    }

                }
                else if ( (LA63_0==WS) ) {
                    int LA63_3 = input.LA(2);

                    if ( (LA63_3==SHARPSHARP) ) {
                        switch ( input.LA(3) ) {
                        case WS:
                            {
                            int LA63_4 = input.LA(4);

                            if ( (LA63_4==IDENTIFIER) ) {
                                int LA63_5 = input.LA(5);

                                if ( (synpred123_Cpp()) ) {
                                    alt63=1;
                                }


                            }
                            else if ( ((LA63_4>=DECIMAL_LITERAL && LA63_4<=STRING_LITERAL)||(LA63_4>=HEX_LITERAL && LA63_4<=FLOATING_POINT_LITERAL)||(LA63_4>=SHARPSHARP && LA63_4<=COPERATOR)) ) {
                                alt63=1;
                            }


                            }
                            break;
                        case IDENTIFIER:
                            {
                            int LA63_5 = input.LA(4);

                            if ( (synpred123_Cpp()) ) {
                                alt63=1;
                            }


                            }
                            break;
                        case DECIMAL_LITERAL:
                        case STRING_LITERAL:
                        case HEX_LITERAL:
                        case OCTAL_LITERAL:
                        case CHARACTER_LITERAL:
                        case FLOATING_POINT_LITERAL:
                        case SHARPSHARP:
                        case CKEYWORD:
                        case COPERATOR:
                            {
                            alt63=1;
                            }
                            break;

                        }

                    }


                }


                switch (alt63) {
            	case 1 :
            	    // Cpp.g:295:26: ( WS )? SHARPSHARP ( WS )? prim+= primarySource
            	    {
            	    // Cpp.g:295:26: ( WS )?
            	    int alt61=2;
            	    int LA61_0 = input.LA(1);

            	    if ( (LA61_0==WS) ) {
            	        alt61=1;
            	    }
            	    switch (alt61) {
            	        case 1 :
            	            // Cpp.g:0:0: WS
            	            {
            	            WS196=(Token)match(input,WS,FOLLOW_WS_in_concatenate2241); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) stream_WS.add(WS196);


            	            }
            	            break;

            	    }

            	    SHARPSHARP197=(Token)match(input,SHARPSHARP,FOLLOW_SHARPSHARP_in_concatenate2244); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_SHARPSHARP.add(SHARPSHARP197);

            	    // Cpp.g:295:42: ( WS )?
            	    int alt62=2;
            	    int LA62_0 = input.LA(1);

            	    if ( (LA62_0==WS) ) {
            	        alt62=1;
            	    }
            	    switch (alt62) {
            	        case 1 :
            	            // Cpp.g:0:0: WS
            	            {
            	            WS198=(Token)match(input,WS,FOLLOW_WS_in_concatenate2247); if (state.failed) return retval;
            	            if ( state.backtracking==0 ) stream_WS.add(WS198);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_primarySource_in_concatenate2252);
            	    prim=primarySource();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_primarySource.add(prim.getTree());
            	    if (list_prim==null) list_prim=new ArrayList();
            	    list_prim.add(prim.getTree());


            	    }
            	    break;

            	default :
            	    if ( cnt63 >= 1 ) break loop63;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(63, input);
                        throw eee;
                }
                cnt63++;
            } while (true);



            // AST REWRITE
            // elements: prim
            // token labels:
            // rule labels: retval
            // token list labels:
            // rule list labels: prim
            // wildcard labels:
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_prim=new RewriteRuleSubtreeStream(adaptor,"token prim",list_prim);
            root_0 = (Object)adaptor.nil();
            // 295:69: -> ^( CONCATENATE ( $prim)+ )
            {
                // Cpp.g:295:72: ^( CONCATENATE ( $prim)+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(CONCATENATE, "CONCATENATE"), root_1);

                if ( !(stream_prim.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_prim.hasNext() ) {
                    adaptor.addChild(root_1, stream_prim.nextTree());

                }
                stream_prim.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 39, concatenate_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "concatenate"

    public static class primarySource_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "primarySource"
    // Cpp.g:298:1: primarySource : ( SHARPSHARP ( WS )? IDENTIFIER -> ^( SHARPSHARP IDENTIFIER ) | IDENTIFIER | constant | CKEYWORD | COPERATOR );
    public final CppParser.primarySource_return primarySource() throws RecognitionException {
        CppParser.primarySource_return retval = new CppParser.primarySource_return();
        retval.start = input.LT(1);
        int primarySource_StartIndex = input.index();
        Object root_0 = null;

        Token SHARPSHARP199=null;
        Token WS200=null;
        Token IDENTIFIER201=null;
        Token IDENTIFIER202=null;
        Token CKEYWORD204=null;
        Token COPERATOR205=null;
        CppParser.constant_return constant203 = null;


        Object SHARPSHARP199_tree=null;
        Object WS200_tree=null;
        Object IDENTIFIER201_tree=null;
        Object IDENTIFIER202_tree=null;
        Object CKEYWORD204_tree=null;
        Object COPERATOR205_tree=null;
        RewriteRuleTokenStream stream_WS=new RewriteRuleTokenStream(adaptor,"token WS");
        RewriteRuleTokenStream stream_SHARPSHARP=new RewriteRuleTokenStream(adaptor,"token SHARPSHARP");
        RewriteRuleTokenStream stream_IDENTIFIER=new RewriteRuleTokenStream(adaptor,"token IDENTIFIER");

        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 40) ) { return retval; }
            // Cpp.g:299:3: ( SHARPSHARP ( WS )? IDENTIFIER -> ^( SHARPSHARP IDENTIFIER ) | IDENTIFIER | constant | CKEYWORD | COPERATOR )
            int alt65=5;
            switch ( input.LA(1) ) {
            case SHARPSHARP:
                {
                alt65=1;
                }
                break;
            case IDENTIFIER:
                {
                alt65=2;
                }
                break;
            case DECIMAL_LITERAL:
            case STRING_LITERAL:
            case HEX_LITERAL:
            case OCTAL_LITERAL:
            case CHARACTER_LITERAL:
            case FLOATING_POINT_LITERAL:
                {
                alt65=3;
                }
                break;
            case CKEYWORD:
                {
                alt65=4;
                }
                break;
            case COPERATOR:
                {
                alt65=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 65, 0, input);

                throw nvae;
            }

            switch (alt65) {
                case 1 :
                    // Cpp.g:299:6: SHARPSHARP ( WS )? IDENTIFIER
                    {
                    SHARPSHARP199=(Token)match(input,SHARPSHARP,FOLLOW_SHARPSHARP_in_primarySource2279); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_SHARPSHARP.add(SHARPSHARP199);

                    // Cpp.g:299:17: ( WS )?
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==WS) ) {
                        alt64=1;
                    }
                    switch (alt64) {
                        case 1 :
                            // Cpp.g:0:0: WS
                            {
                            WS200=(Token)match(input,WS,FOLLOW_WS_in_primarySource2281); if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_WS.add(WS200);


                            }
                            break;

                    }

                    IDENTIFIER201=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primarySource2284); if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_IDENTIFIER.add(IDENTIFIER201);



                    // AST REWRITE
                    // elements: IDENTIFIER, SHARPSHARP
                    // token labels:
                    // rule labels: retval
                    // token list labels:
                    // rule list labels:
                    // wildcard labels:
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (Object)adaptor.nil();
                    // 299:32: -> ^( SHARPSHARP IDENTIFIER )
                    {
                        // Cpp.g:299:35: ^( SHARPSHARP IDENTIFIER )
                        {
                        Object root_1 = (Object)adaptor.nil();
                        root_1 = (Object)adaptor.becomeRoot(stream_SHARPSHARP.nextNode(), root_1);

                        adaptor.addChild(root_1, stream_IDENTIFIER.nextNode());

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // Cpp.g:300:5: IDENTIFIER
                    {
                    root_0 = (Object)adaptor.nil();

                    IDENTIFIER202=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_primarySource2298); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IDENTIFIER202_tree = (Object)adaptor.create(IDENTIFIER202);
                    adaptor.addChild(root_0, IDENTIFIER202_tree);
                    }

                    }
                    break;
                case 3 :
                    // Cpp.g:301:5: constant
                    {
                    root_0 = (Object)adaptor.nil();

                    pushFollow(FOLLOW_constant_in_primarySource2305);
                    constant203=constant();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, constant203.getTree());

                    }
                    break;
                case 4 :
                    // Cpp.g:302:5: CKEYWORD
                    {
                    root_0 = (Object)adaptor.nil();

                    CKEYWORD204=(Token)match(input,CKEYWORD,FOLLOW_CKEYWORD_in_primarySource2311); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    CKEYWORD204_tree = (Object)adaptor.create(CKEYWORD204);
                    adaptor.addChild(root_0, CKEYWORD204_tree);
                    }

                    }
                    break;
                case 5 :
                    // Cpp.g:303:5: COPERATOR
                    {
                    root_0 = (Object)adaptor.nil();

                    COPERATOR205=(Token)match(input,COPERATOR,FOLLOW_COPERATOR_in_primarySource2317); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    COPERATOR205_tree = (Object)adaptor.create(COPERATOR205);
                    adaptor.addChild(root_0, COPERATOR205_tree);
                    }

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 40, primarySource_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "primarySource"

    public static class macro_text_return extends ParserRuleReturnScope {
        Object tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "macro_text"
    // Cpp.g:716:1: macro_text : ( source_text )+ -> ^( MACRO_DEFINE ( source_text )+ ) ;
    public final CppParser.macro_text_return macro_text() throws RecognitionException {
        CppParser.macro_text_return retval = new CppParser.macro_text_return();
        retval.start = input.LT(1);
        int macro_text_StartIndex = input.index();
        Object root_0 = null;

        CppParser.source_text_return source_text206 = null;


        RewriteRuleSubtreeStream stream_source_text=new RewriteRuleSubtreeStream(adaptor,"rule source_text");
        try {
            if ( state.backtracking>0 && alreadyParsedRule(input, 41) ) { return retval; }
            // Cpp.g:717:3: ( ( source_text )+ -> ^( MACRO_DEFINE ( source_text )+ ) )
            // Cpp.g:717:5: ( source_text )+
            {
            // Cpp.g:717:5: ( source_text )+
            int cnt66=0;
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( (LA66_0==TEXT_END||(LA66_0>=IDENTIFIER && LA66_0<=COMMA)||(LA66_0>=DECIMAL_LITERAL && LA66_0<=STRING_LITERAL)||LA66_0==SIZEOF||(LA66_0>=HEX_LITERAL && LA66_0<=COPERATOR)) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // Cpp.g:0:0: source_text
            	    {
            	    pushFollow(FOLLOW_source_text_in_macro_text4181);
            	    source_text206=source_text();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_source_text.add(source_text206.getTree());

            	    }
            	    break;

            	default :
            	    if ( cnt66 >= 1 ) break loop66;
            	    if (state.backtracking>0) {state.failed=true; return retval;}
                        EarlyExitException eee =
                            new EarlyExitException(66, input);
                        throw eee;
                }
                cnt66++;
            } while (true);



            // AST REWRITE
            // elements: source_text
            // token labels:
            // rule labels: retval
            // token list labels:
            // rule list labels:
            // wildcard labels:
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (Object)adaptor.nil();
            // 717:18: -> ^( MACRO_DEFINE ( source_text )+ )
            {
                // Cpp.g:717:21: ^( MACRO_DEFINE ( source_text )+ )
                {
                Object root_1 = (Object)adaptor.nil();
                root_1 = (Object)adaptor.becomeRoot((Object)adaptor.create(MACRO_DEFINE, "MACRO_DEFINE"), root_1);

                if ( !(stream_source_text.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_source_text.hasNext() ) {
                    adaptor.addChild(root_1, stream_source_text.nextTree());

                }
                stream_source_text.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (Object)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (Object)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
            if ( state.backtracking>0 ) { memoize(input, 41, macro_text_StartIndex); }
        }
        return retval;
    }
    // $ANTLR end "macro_text"

    // $ANTLR start synpred14_Cpp
    public final void synpred14_Cpp_fragment() throws RecognitionException {
        // Cpp.g:78:5: ( DEFINE IDENTIFIER LPAREN ( WS )? RPAREN ( macro_text )? )
        // Cpp.g:78:5: DEFINE IDENTIFIER LPAREN ( WS )? RPAREN ( macro_text )?
        {
        match(input,DEFINE,FOLLOW_DEFINE_in_synpred14_Cpp350); if (state.failed) return ;
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred14_Cpp353); if (state.failed) return ;
        match(input,LPAREN,FOLLOW_LPAREN_in_synpred14_Cpp356); if (state.failed) return ;
        // Cpp.g:78:32: ( WS )?
        int alt67=2;
        int LA67_0 = input.LA(1);

        if ( (LA67_0==WS) ) {
            alt67=1;
        }
        switch (alt67) {
            case 1 :
                // Cpp.g:0:0: WS
                {
                match(input,WS,FOLLOW_WS_in_synpred14_Cpp358); if (state.failed) return ;

                }
                break;

        }

        match(input,RPAREN,FOLLOW_RPAREN_in_synpred14_Cpp361); if (state.failed) return ;
        // Cpp.g:78:44: ( macro_text )?
        int alt68=2;
        int LA68_0 = input.LA(1);

        if ( (LA68_0==TEXT_END||(LA68_0>=IDENTIFIER && LA68_0<=COMMA)||(LA68_0>=DECIMAL_LITERAL && LA68_0<=STRING_LITERAL)||LA68_0==SIZEOF||(LA68_0>=HEX_LITERAL && LA68_0<=COPERATOR)) ) {
            alt68=1;
        }
        switch (alt68) {
            case 1 :
                // Cpp.g:0:0: macro_text
                {
                pushFollow(FOLLOW_macro_text_in_synpred14_Cpp364);
                macro_text();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred14_Cpp

    // $ANTLR start synpred22_Cpp
    public final void synpred22_Cpp_fragment() throws RecognitionException {
        Token mac=null;
        List list_arg=null;
        RuleReturnScope arg = null;
        // Cpp.g:79:5: ( DEFINE mac= IDENTIFIER LPAREN ( WS )? (arg+= macroParam ( WS )? ( COMMA ( WS )* arg+= macroParam ( WS )* )* )? RPAREN ( macro_text )? )
        // Cpp.g:79:5: DEFINE mac= IDENTIFIER LPAREN ( WS )? (arg+= macroParam ( WS )? ( COMMA ( WS )* arg+= macroParam ( WS )* )* )? RPAREN ( macro_text )?
        {
        match(input,DEFINE,FOLLOW_DEFINE_in_synpred22_Cpp384); if (state.failed) return ;
        mac=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred22_Cpp388); if (state.failed) return ;
        match(input,LPAREN,FOLLOW_LPAREN_in_synpred22_Cpp391); if (state.failed) return ;
        // Cpp.g:79:35: ( WS )?
        int alt75=2;
        int LA75_0 = input.LA(1);

        if ( (LA75_0==WS) ) {
            alt75=1;
        }
        switch (alt75) {
            case 1 :
                // Cpp.g:0:0: WS
                {
                match(input,WS,FOLLOW_WS_in_synpred22_Cpp393); if (state.failed) return ;

                }
                break;

        }

        // Cpp.g:79:40: (arg+= macroParam ( WS )? ( COMMA ( WS )* arg+= macroParam ( WS )* )* )?
        int alt80=2;
        int LA80_0 = input.LA(1);

        if ( (LA80_0==IDENTIFIER||LA80_0==ELLIPSIS) ) {
            alt80=1;
        }
        switch (alt80) {
            case 1 :
                // Cpp.g:79:41: arg+= macroParam ( WS )? ( COMMA ( WS )* arg+= macroParam ( WS )* )*
                {
                pushFollow(FOLLOW_macroParam_in_synpred22_Cpp400);
                arg=macroParam();

                state._fsp--;
                if (state.failed) return ;
                if (list_arg==null) list_arg=new ArrayList();
                list_arg.add(arg);

                // Cpp.g:79:57: ( WS )?
                int alt76=2;
                int LA76_0 = input.LA(1);

                if ( (LA76_0==WS) ) {
                    alt76=1;
                }
                switch (alt76) {
                    case 1 :
                        // Cpp.g:0:0: WS
                        {
                        match(input,WS,FOLLOW_WS_in_synpred22_Cpp402); if (state.failed) return ;

                        }
                        break;

                }

                // Cpp.g:79:61: ( COMMA ( WS )* arg+= macroParam ( WS )* )*
                loop79:
                do {
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==COMMA) ) {
                        alt79=1;
                    }


                    switch (alt79) {
                	case 1 :
                	    // Cpp.g:79:62: COMMA ( WS )* arg+= macroParam ( WS )*
                	    {
                	    match(input,COMMA,FOLLOW_COMMA_in_synpred22_Cpp406); if (state.failed) return ;
                	    // Cpp.g:79:68: ( WS )*
                	    loop77:
                	    do {
                	        int alt77=2;
                	        int LA77_0 = input.LA(1);

                	        if ( (LA77_0==WS) ) {
                	            alt77=1;
                	        }


                	        switch (alt77) {
                	    	case 1 :
                	    	    // Cpp.g:0:0: WS
                	    	    {
                	    	    match(input,WS,FOLLOW_WS_in_synpred22_Cpp408); if (state.failed) return ;

                	    	    }
                	    	    break;

                	    	default :
                	    	    break loop77;
                	        }
                	    } while (true);

                	    pushFollow(FOLLOW_macroParam_in_synpred22_Cpp413);
                	    arg=macroParam();

                	    state._fsp--;
                	    if (state.failed) return ;
                	    if (list_arg==null) list_arg=new ArrayList();
                	    list_arg.add(arg);

                	    // Cpp.g:79:88: ( WS )*
                	    loop78:
                	    do {
                	        int alt78=2;
                	        int LA78_0 = input.LA(1);

                	        if ( (LA78_0==WS) ) {
                	            alt78=1;
                	        }


                	        switch (alt78) {
                	    	case 1 :
                	    	    // Cpp.g:0:0: WS
                	    	    {
                	    	    match(input,WS,FOLLOW_WS_in_synpred22_Cpp415); if (state.failed) return ;

                	    	    }
                	    	    break;

                	    	default :
                	    	    break loop78;
                	        }
                	    } while (true);


                	    }
                	    break;

                	default :
                	    break loop79;
                    }
                } while (true);


                }
                break;

        }

        match(input,RPAREN,FOLLOW_RPAREN_in_synpred22_Cpp426); if (state.failed) return ;
        // Cpp.g:80:11: ( macro_text )?
        int alt81=2;
        int LA81_0 = input.LA(1);

        if ( (LA81_0==TEXT_END||(LA81_0>=IDENTIFIER && LA81_0<=COMMA)||(LA81_0>=DECIMAL_LITERAL && LA81_0<=STRING_LITERAL)||LA81_0==SIZEOF||(LA81_0>=HEX_LITERAL && LA81_0<=COPERATOR)) ) {
            alt81=1;
        }
        switch (alt81) {
            case 1 :
                // Cpp.g:0:0: macro_text
                {
                pushFollow(FOLLOW_macro_text_in_synpred22_Cpp428);
                macro_text();

                state._fsp--;
                if (state.failed) return ;

                }
                break;

        }


        }
    }
    // $ANTLR end synpred22_Cpp

    // $ANTLR start synpred33_Cpp
    public final void synpred33_Cpp_fragment() throws RecognitionException {
        // Cpp.g:128:5: ( IDENTIFIER {...}?)
        // Cpp.g:128:5: IDENTIFIER {...}?
        {
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred33_Cpp823); if (state.failed) return ;
        if ( !((input.LT(-2).getText().equals("ifndef"))) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred33_Cpp", "input.LT(-2).getText().equals(\"ifndef\")");
        }

        }
    }
    // $ANTLR end synpred33_Cpp

    // $ANTLR start synpred34_Cpp
    public final void synpred34_Cpp_fragment() throws RecognitionException {
        // Cpp.g:129:5: ( IDENTIFIER {...}?)
        // Cpp.g:129:5: IDENTIFIER {...}?
        {
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred34_Cpp843); if (state.failed) return ;
        if ( !((input.LT(-2).getText().equals("ifdef"))) ) {
            if (state.backtracking>0) {state.failed=true; return ;}
            throw new FailedPredicateException(input, "synpred34_Cpp", "input.LT(-2).getText().equals(\"ifdef\")");
        }

        }
    }
    // $ANTLR end synpred34_Cpp

    // $ANTLR start synpred67_Cpp
    public final void synpred67_Cpp_fragment() throws RecognitionException {
        // Cpp.g:206:5: ( SIZEOF unaryExpression )
        // Cpp.g:206:5: SIZEOF unaryExpression
        {
        match(input,SIZEOF,FOLLOW_SIZEOF_in_synpred67_Cpp1394); if (state.failed) return ;
        pushFollow(FOLLOW_unaryExpression_in_synpred67_Cpp1396);
        unaryExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred67_Cpp

    // $ANTLR start synpred68_Cpp
    public final void synpred68_Cpp_fragment() throws RecognitionException {
        // Cpp.g:207:5: ( SIZEOF LPAREN type_name RPAREN )
        // Cpp.g:207:5: SIZEOF LPAREN type_name RPAREN
        {
        match(input,SIZEOF,FOLLOW_SIZEOF_in_synpred68_Cpp1410); if (state.failed) return ;
        match(input,LPAREN,FOLLOW_LPAREN_in_synpred68_Cpp1412); if (state.failed) return ;
        pushFollow(FOLLOW_type_name_in_synpred68_Cpp1414);
        type_name();

        state._fsp--;
        if (state.failed) return ;
        match(input,RPAREN,FOLLOW_RPAREN_in_synpred68_Cpp1416); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred68_Cpp

    // $ANTLR start synpred77_Cpp
    public final void synpred77_Cpp_fragment() throws RecognitionException {
        // Cpp.g:220:5: ( LPAREN type_name RPAREN unaryExpression )
        // Cpp.g:220:5: LPAREN type_name RPAREN unaryExpression
        {
        match(input,LPAREN,FOLLOW_LPAREN_in_synpred77_Cpp1586); if (state.failed) return ;
        pushFollow(FOLLOW_type_name_in_synpred77_Cpp1588);
        type_name();

        state._fsp--;
        if (state.failed) return ;
        match(input,RPAREN,FOLLOW_RPAREN_in_synpred77_Cpp1590); if (state.failed) return ;
        pushFollow(FOLLOW_unaryExpression_in_synpred77_Cpp1593);
        unaryExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred77_Cpp

    // $ANTLR start synpred80_Cpp
    public final void synpred80_Cpp_fragment() throws RecognitionException {
        Token s=null;

        // Cpp.g:228:5: (s= STAR IDENTIFIER )
        // Cpp.g:228:5: s= STAR IDENTIFIER
        {
        s=(Token)match(input,STAR,FOLLOW_STAR_in_synpred80_Cpp1673); if (state.failed) return ;
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred80_Cpp1678); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred80_Cpp

    // $ANTLR start synpred84_Cpp
    public final void synpred84_Cpp_fragment() throws RecognitionException {
        // Cpp.g:236:7: ( IDENTIFIER LPAREN )
        // Cpp.g:236:8: IDENTIFIER LPAREN
        {
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred84_Cpp1741); if (state.failed) return ;
        match(input,LPAREN,FOLLOW_LPAREN_in_synpred84_Cpp1743); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred84_Cpp

    // $ANTLR start synpred85_Cpp
    public final void synpred85_Cpp_fragment() throws RecognitionException {
        // Cpp.g:237:7: ( IDENTIFIER )
        // Cpp.g:237:7: IDENTIFIER
        {
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred85_Cpp1757); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred85_Cpp

    // $ANTLR start synpred94_Cpp
    public final void synpred94_Cpp_fragment() throws RecognitionException {
        // Cpp.g:262:7: ( sourceExpression )
        // Cpp.g:262:7: sourceExpression
        {
        pushFollow(FOLLOW_sourceExpression_in_synpred94_Cpp1936);
        sourceExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred94_Cpp

    // $ANTLR start synpred96_Cpp
    public final void synpred96_Cpp_fragment() throws RecognitionException {
        // Cpp.g:264:5: ( LPAREN )
        // Cpp.g:264:5: LPAREN
        {
        match(input,LPAREN,FOLLOW_LPAREN_in_synpred96_Cpp1948); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred96_Cpp

    // $ANTLR start synpred100_Cpp
    public final void synpred100_Cpp_fragment() throws RecognitionException {
        Token id=null;

        // Cpp.g:270:5: (id= IDENTIFIER ( WS )? LPAREN ( WS )? RPAREN )
        // Cpp.g:270:5: id= IDENTIFIER ( WS )? LPAREN ( WS )? RPAREN
        {
        id=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred100_Cpp1976); if (state.failed) return ;
        // Cpp.g:270:19: ( WS )?
        int alt82=2;
        int LA82_0 = input.LA(1);

        if ( (LA82_0==WS) ) {
            alt82=1;
        }
        switch (alt82) {
            case 1 :
                // Cpp.g:0:0: WS
                {
                match(input,WS,FOLLOW_WS_in_synpred100_Cpp1978); if (state.failed) return ;

                }
                break;

        }

        match(input,LPAREN,FOLLOW_LPAREN_in_synpred100_Cpp1981); if (state.failed) return ;
        // Cpp.g:270:30: ( WS )?
        int alt83=2;
        int LA83_0 = input.LA(1);

        if ( (LA83_0==WS) ) {
            alt83=1;
        }
        switch (alt83) {
            case 1 :
                // Cpp.g:0:0: WS
                {
                match(input,WS,FOLLOW_WS_in_synpred100_Cpp1983); if (state.failed) return ;

                }
                break;

        }

        match(input,RPAREN,FOLLOW_RPAREN_in_synpred100_Cpp1988); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred100_Cpp

    // $ANTLR start synpred102_Cpp
    public final void synpred102_Cpp_fragment() throws RecognitionException {
        // Cpp.g:271:30: ( WS )
        // Cpp.g:271:30: WS
        {
        match(input,WS,FOLLOW_WS_in_synpred102_Cpp2013); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred102_Cpp

    // $ANTLR start synpred105_Cpp
    public final void synpred105_Cpp_fragment() throws RecognitionException {
        // Cpp.g:274:34: ( WS )
        // Cpp.g:274:34: WS
        {
        match(input,WS,FOLLOW_WS_in_synpred105_Cpp2057); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred105_Cpp

    // $ANTLR start synpred107_Cpp
    public final void synpred107_Cpp_fragment() throws RecognitionException {
        // Cpp.g:277:8: ( sourceExpression )
        // Cpp.g:277:8: sourceExpression
        {
        pushFollow(FOLLOW_sourceExpression_in_synpred107_Cpp2086);
        sourceExpression();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred107_Cpp

    // $ANTLR start synpred108_Cpp
    public final void synpred108_Cpp_fragment() throws RecognitionException {
        // Cpp.g:277:8: ( ( sourceExpression )+ )
        // Cpp.g:277:8: ( sourceExpression )+
        {
        // Cpp.g:277:8: ( sourceExpression )+
        int cnt86=0;
        loop86:
        do {
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==TEXT_END||(LA86_0>=IDENTIFIER && LA86_0<=WS)||(LA86_0>=DECIMAL_LITERAL && LA86_0<=STRING_LITERAL)||LA86_0==SIZEOF||(LA86_0>=HEX_LITERAL && LA86_0<=COPERATOR)) ) {
                alt86=1;
            }


            switch (alt86) {
        	case 1 :
        	    // Cpp.g:0:0: sourceExpression
        	    {
        	    pushFollow(FOLLOW_sourceExpression_in_synpred108_Cpp2086);
        	    sourceExpression();

        	    state._fsp--;
        	    if (state.failed) return ;

        	    }
        	    break;

        	default :
        	    if ( cnt86 >= 1 ) break loop86;
        	    if (state.backtracking>0) {state.failed=true; return ;}
                    EarlyExitException eee =
                        new EarlyExitException(86, input);
                    throw eee;
            }
            cnt86++;
        } while (true);


        }
    }
    // $ANTLR end synpred108_Cpp

    // $ANTLR start synpred110_Cpp
    public final void synpred110_Cpp_fragment() throws RecognitionException {
        // Cpp.g:282:5: ( IDENTIFIER ( WS )? LPAREN )
        // Cpp.g:282:6: IDENTIFIER ( WS )? LPAREN
        {
        match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_synpred110_Cpp2122); if (state.failed) return ;
        // Cpp.g:282:17: ( WS )?
        int alt87=2;
        int LA87_0 = input.LA(1);

        if ( (LA87_0==WS) ) {
            alt87=1;
        }
        switch (alt87) {
            case 1 :
                // Cpp.g:0:0: WS
                {
                match(input,WS,FOLLOW_WS_in_synpred110_Cpp2124); if (state.failed) return ;

                }
                break;

        }

        match(input,LPAREN,FOLLOW_LPAREN_in_synpred110_Cpp2127); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred110_Cpp

    // $ANTLR start synpred112_Cpp
    public final void synpred112_Cpp_fragment() throws RecognitionException {
        // Cpp.g:283:5: ( primarySource ( WS )? SHARPSHARP )
        // Cpp.g:283:6: primarySource ( WS )? SHARPSHARP
        {
        pushFollow(FOLLOW_primarySource_in_synpred112_Cpp2138);
        primarySource();

        state._fsp--;
        if (state.failed) return ;
        // Cpp.g:283:20: ( WS )?
        int alt88=2;
        int LA88_0 = input.LA(1);

        if ( (LA88_0==WS) ) {
            alt88=1;
        }
        switch (alt88) {
            case 1 :
                // Cpp.g:0:0: WS
                {
                match(input,WS,FOLLOW_WS_in_synpred112_Cpp2140); if (state.failed) return ;

                }
                break;

        }

        match(input,SHARPSHARP,FOLLOW_SHARPSHARP_in_synpred112_Cpp2143); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred112_Cpp

    // $ANTLR start synpred114_Cpp
    public final void synpred114_Cpp_fragment() throws RecognitionException {
        // Cpp.g:285:5: ( primarySource )
        // Cpp.g:285:5: primarySource
        {
        pushFollow(FOLLOW_primarySource_in_synpred114_Cpp2173);
        primarySource();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred114_Cpp

    // $ANTLR start synpred117_Cpp
    public final void synpred117_Cpp_fragment() throws RecognitionException {
        // Cpp.g:288:12: ( macArgs )
        // Cpp.g:288:12: macArgs
        {
        pushFollow(FOLLOW_macArgs_in_synpred117_Cpp2193);
        macArgs();

        state._fsp--;
        if (state.failed) return ;

        }
    }
    // $ANTLR end synpred117_Cpp

    // $ANTLR start synpred123_Cpp
    public final void synpred123_Cpp_fragment() throws RecognitionException {
        List list_prim=null;
        RuleReturnScope prim = null;
        // Cpp.g:295:26: ( ( WS )? SHARPSHARP ( WS )? prim+= primarySource )
        // Cpp.g:295:26: ( WS )? SHARPSHARP ( WS )? prim+= primarySource
        {
        // Cpp.g:295:26: ( WS )?
        int alt90=2;
        int LA90_0 = input.LA(1);

        if ( (LA90_0==WS) ) {
            alt90=1;
        }
        switch (alt90) {
            case 1 :
                // Cpp.g:0:0: WS
                {
                match(input,WS,FOLLOW_WS_in_synpred123_Cpp2241); if (state.failed) return ;

                }
                break;

        }

        match(input,SHARPSHARP,FOLLOW_SHARPSHARP_in_synpred123_Cpp2244); if (state.failed) return ;
        // Cpp.g:295:42: ( WS )?
        int alt91=2;
        int LA91_0 = input.LA(1);

        if ( (LA91_0==WS) ) {
            alt91=1;
        }
        switch (alt91) {
            case 1 :
                // Cpp.g:0:0: WS
                {
                match(input,WS,FOLLOW_WS_in_synpred123_Cpp2247); if (state.failed) return ;

                }
                break;

        }

        pushFollow(FOLLOW_primarySource_in_synpred123_Cpp2252);
        prim=primarySource();

        state._fsp--;
        if (state.failed) return ;
        if (list_prim==null) list_prim=new ArrayList();
        list_prim.add(prim);


        }
    }
    // $ANTLR end synpred123_Cpp

    // Delegated rules

    public final boolean synpred96_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred96_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred34_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred34_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred80_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred80_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred85_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred85_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred94_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred94_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred110_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred110_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred105_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred105_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred22_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred22_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred67_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred67_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred123_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred123_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred117_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred117_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred68_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred68_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred33_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred33_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred77_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred77_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred84_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred84_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred112_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred112_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred114_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred114_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred108_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred108_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred107_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred107_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred100_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred100_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred102_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred102_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred14_Cpp() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred14_Cpp_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA41 dfa41 = new DFA41(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA43 dfa43 = new DFA43(this);
    protected DFA47 dfa47 = new DFA47(this);
    protected DFA60 dfa60 = new DFA60(this);
    static final String DFA2_eotS =
        "\13\uffff";
    static final String DFA2_eofS =
        "\13\uffff";
    static final String DFA2_minS =
        "\1\6\12\uffff";
    static final String DFA2_maxS =
        "\1\152\12\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12";
    static final String DFA2_specialS =
        "\13\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\7\2\uffff\3\3\22\uffff\1\2\3\uffff\1\11\1\uffff\1\10\2\4"+
            "\1\5\1\6\4\uffff\1\1\1\12\5\2\2\uffff\2\2\41\uffff\1\2\7\uffff"+
            "\12\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "60:3: ( DIRECTIVE | text_line | diagnostics | fileInclusion | macroDefine | macroUndef | conditionalCompilation | lineControl | macroExecution )?";
        }
    }
    static final String DFA14_eotS =
        "\22\uffff";
    static final String DFA14_eofS =
        "\2\uffff\2\4\1\uffff\2\4\2\uffff\2\4\2\uffff\5\4";
    static final String DFA14_minS =
        "\1\47\1\57\2\36\1\uffff\2\36\1\uffff\1\0\2\36\1\0\1\uffff\5\36";
    static final String DFA14_maxS =
        "\1\47\1\57\2\152\1\uffff\2\152\1\uffff\1\0\2\152\1\0\1\uffff\5\152";
    static final String DFA14_acceptS =
        "\4\uffff\1\3\2\uffff\1\2\4\uffff\1\1\5\uffff";
    static final String DFA14_specialS =
        "\10\uffff\1\1\2\uffff\1\0\6\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\1",
            "\1\2",
            "\1\4\17\uffff\2\4\1\3\3\4\2\uffff\2\4\41\uffff\1\4\7\uffff"+
            "\12\4",
            "\1\4\17\uffff\1\4\1\6\1\4\1\5\1\10\1\4\1\7\1\uffff\2\4\41\uffff"+
            "\1\4\7\uffff\12\4",
            "",
            "\1\4\17\uffff\1\4\1\6\2\4\1\10\1\4\1\7\1\uffff\2\4\41\uffff"+
            "\1\4\7\uffff\12\4",
            "\1\4\17\uffff\3\4\1\11\1\13\1\12\1\7\1\uffff\2\4\41\uffff\1"+
            "\4\7\uffff\12\4",
            "",
            "\1\uffff",
            "\1\4\17\uffff\4\4\1\13\1\12\2\uffff\2\4\41\uffff\1\4\7\uffff"+
            "\12\4",
            "\1\4\17\uffff\1\4\1\16\1\4\1\15\2\4\1\7\1\uffff\2\4\41\uffff"+
            "\1\4\7\uffff\12\4",
            "\1\uffff",
            "",
            "\1\4\17\uffff\1\4\1\16\1\4\1\17\2\4\1\7\1\uffff\2\4\41\uffff"+
            "\1\4\7\uffff\12\4",
            "\1\4\17\uffff\3\4\1\20\1\13\1\12\1\7\1\uffff\2\4\41\uffff\1"+
            "\4\7\uffff\12\4",
            "\1\4\17\uffff\1\4\1\16\1\4\1\17\2\4\1\7\1\uffff\2\4\41\uffff"+
            "\1\4\7\uffff\12\4",
            "\1\4\17\uffff\3\4\1\21\1\13\1\12\2\uffff\2\4\41\uffff\1\4\7"+
            "\uffff\12\4",
            "\1\4\17\uffff\3\4\1\21\1\13\1\12\2\uffff\2\4\41\uffff\1\4\7"+
            "\uffff\12\4"
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "77:1: macroDefine : ( DEFINE IDENTIFIER LPAREN ( WS )? RPAREN ( macro_text )? -> ^( MAC_FUNCTION_OBJECT IDENTIFIER ( macro_text )? ) | DEFINE mac= IDENTIFIER LPAREN ( WS )? (arg+= macroParam ( WS )? ( COMMA ( WS )* arg+= macroParam ( WS )* )* )? RPAREN ( macro_text )? -> ^( MAC_FUNCTION $mac ( $arg)+ ( macro_text )? ) | DEFINE IDENTIFIER ( macro_text )? -> ^( MAC_OBJECT IDENTIFIER ( macro_text )? ) );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 :
                        int LA14_11 = input.LA(1);


                        int index14_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred22_Cpp()) ) {s = 7;}

                        else if ( (true) ) {s = 4;}


                        input.seek(index14_11);
                        if ( s>=0 ) return s;
                        break;
                    case 1 :
                        int LA14_8 = input.LA(1);


                        int index14_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred14_Cpp()) ) {s = 12;}

                        else if ( (synpred22_Cpp()) ) {s = 7;}

                        else if ( (true) ) {s = 4;}


                        input.seek(index14_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 14, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA41_eotS =
        "\15\uffff";
    static final String DFA41_eofS =
        "\15\uffff";
    static final String DFA41_minS =
        "\1\57\2\uffff\2\57\1\uffff\1\57\3\uffff\1\60\1\0\1\uffff";
    static final String DFA41_maxS =
        "\1\144\2\uffff\1\144\1\60\1\uffff\1\144\3\uffff\1\140\1\0\1\uffff";
    static final String DFA41_acceptS =
        "\1\uffff\1\1\1\2\2\uffff\1\7\1\uffff\1\3\1\6\1\5\2\uffff\1\4";
    static final String DFA41_specialS =
        "\13\uffff\1\0\1\uffff}>";
    static final String[] DFA41_transitionS = {
            "\2\5\5\uffff\2\5\21\uffff\1\5\10\uffff\3\5\2\uffff\1\1\1\2\1"+
            "\3\1\4\2\5\4\uffff\4\5",
            "",
            "",
            "\1\7\1\6\5\uffff\2\7\21\uffff\1\7\10\uffff\3\7\2\uffff\6\7"+
            "\4\uffff\4\7",
            "\1\11\1\10",
            "",
            "\1\12\1\7\5\uffff\2\7\21\uffff\1\7\10\uffff\3\7\2\uffff\6\7"+
            "\4\uffff\4\7",
            "",
            "",
            "",
            "\1\7\1\uffff\1\13\5\uffff\14\7\1\uffff\24\7\4\uffff\1\7\1\uffff"+
            "\2\7",
            "\1\uffff",
            ""
    };

    static final short[] DFA41_eot = DFA.unpackEncodedString(DFA41_eotS);
    static final short[] DFA41_eof = DFA.unpackEncodedString(DFA41_eofS);
    static final char[] DFA41_min = DFA.unpackEncodedStringToUnsignedChars(DFA41_minS);
    static final char[] DFA41_max = DFA.unpackEncodedStringToUnsignedChars(DFA41_maxS);
    static final short[] DFA41_accept = DFA.unpackEncodedString(DFA41_acceptS);
    static final short[] DFA41_special = DFA.unpackEncodedString(DFA41_specialS);
    static final short[][] DFA41_transition;

    static {
        int numStates = DFA41_transitionS.length;
        DFA41_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA41_transition[i] = DFA.unpackEncodedString(DFA41_transitionS[i]);
        }
    }

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = DFA41_eot;
            this.eof = DFA41_eof;
            this.min = DFA41_min;
            this.max = DFA41_max;
            this.accept = DFA41_accept;
            this.special = DFA41_special;
            this.transition = DFA41_transition;
        }
        public String getDescription() {
            return "203:1: unaryExpression : ( PLUSPLUS unaryExpression -> ^( PLUSPLUS unaryExpression ) | MINUSMINUS unaryExpression -> ^( MINUSMINUS unaryExpression ) | SIZEOF unaryExpression -> ^( SIZEOF unaryExpression ) | SIZEOF LPAREN type_name RPAREN -> ^( SIZEOF_TYPE type_name ) | DEFINED type_name -> ^( DEFINED type_name ) | DEFINED LPAREN type_name RPAREN -> ^( DEFINED type_name ) | unaryExpressionNotPlusMinus );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 :
                        int LA41_11 = input.LA(1);


                        int index41_11 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred67_Cpp()) ) {s = 7;}

                        else if ( (synpred68_Cpp()) ) {s = 12;}


                        input.seek(index41_11);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 41, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA42_eotS =
        "\13\uffff";
    static final String DFA42_eofS =
        "\13\uffff";
    static final String DFA42_minS =
        "\1\57\6\uffff\1\0\3\uffff";
    static final String DFA42_maxS =
        "\1\144\6\uffff\1\0\3\uffff";
    static final String DFA42_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\10\1\uffff\1\7";
    static final String DFA42_specialS =
        "\7\uffff\1\0\3\uffff}>";
    static final String[] DFA42_transitionS = {
            "\1\10\1\7\5\uffff\2\10\21\uffff\1\3\10\uffff\1\6\1\5\1\4\6\uffff"+
            "\1\1\1\2\4\uffff\4\10",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            ""
    };

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "213:1: unaryExpressionNotPlusMinus : ( NOT unaryExpression -> ^( NOT unaryExpression ) | TILDE unaryExpression -> ^( TILDE unaryExpression ) | AMPERSAND unaryExpression -> ^( REFERANCE unaryExpression ) | STAR unaryExpression -> ^( POINTER_AT unaryExpression ) | MINUS unaryExpression -> ^( UNARY_MINUS unaryExpression ) | PLUS unaryExpression -> ^( UNARY_PLUS unaryExpression ) | LPAREN type_name RPAREN unaryExpression -> ^( TYPECAST type_name unaryExpression ) | postfixExpression );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 :
                        int LA42_7 = input.LA(1);


                        int index42_7 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred77_Cpp()) ) {s = 10;}

                        else if ( (true) ) {s = 8;}


                        input.seek(index42_7);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 42, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA43_eotS =
        "\12\uffff";
    static final String DFA43_eofS =
        "\1\2\11\uffff";
    static final String DFA43_minS =
        "\1\6\1\57\6\uffff\1\0\1\uffff";
    static final String DFA43_maxS =
        "\1\152\1\144\6\uffff\1\0\1\uffff";
    static final String DFA43_acceptS =
        "\2\uffff\1\7\1\1\1\2\1\4\1\5\1\6\1\uffff\1\3";
    static final String DFA43_specialS =
        "\10\uffff\1\0\1\uffff}>";
    static final String[] DFA43_transitionS = {
            "\1\2\2\uffff\3\2\22\uffff\1\2\3\uffff\1\2\1\uffff\5\2\4\uffff"+
            "\7\2\2\uffff\36\2\1\1\2\2\1\6\1\7\1\2\3\uffff\1\3\1\2\1\4\1"+
            "\5\12\2",
            "\1\10\1\2\5\uffff\2\2\21\uffff\1\2\10\uffff\3\2\2\uffff\6\2"+
            "\4\uffff\4\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            ""
    };

    static final short[] DFA43_eot = DFA.unpackEncodedString(DFA43_eotS);
    static final short[] DFA43_eof = DFA.unpackEncodedString(DFA43_eofS);
    static final char[] DFA43_min = DFA.unpackEncodedStringToUnsignedChars(DFA43_minS);
    static final char[] DFA43_max = DFA.unpackEncodedStringToUnsignedChars(DFA43_maxS);
    static final short[] DFA43_accept = DFA.unpackEncodedString(DFA43_acceptS);
    static final short[] DFA43_special = DFA.unpackEncodedString(DFA43_specialS);
    static final short[][] DFA43_transition;

    static {
        int numStates = DFA43_transitionS.length;
        DFA43_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA43_transition[i] = DFA.unpackEncodedString(DFA43_transitionS[i]);
        }
    }

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = DFA43_eot;
            this.eof = DFA43_eof;
            this.min = DFA43_min;
            this.max = DFA43_max;
            this.accept = DFA43_accept;
            this.special = DFA43_special;
            this.transition = DFA43_transition;
        }
        public String getDescription() {
            return "()* loopback of 226:3: (l= LSQUARE assignmentExpression RSQUARE | DOT IDENTIFIER | s= STAR IDENTIFIER | POINTERTO IDENTIFIER | p= PLUSPLUS | m= MINUSMINUS )*";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 :
                        int LA43_8 = input.LA(1);


                        int index43_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred80_Cpp()) ) {s = 9;}

                        else if ( (true) ) {s = 2;}


                        input.seek(index43_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 43, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA47_eotS =
        "\21\uffff";
    static final String DFA47_eofS =
        "\21\uffff";
    static final String DFA47_minS =
        "\1\36\10\uffff\1\0\2\uffff\1\0\4\uffff";
    static final String DFA47_maxS =
        "\1\152\10\uffff\1\0\2\uffff\1\0\4\uffff";
    static final String DFA47_acceptS =
        "\1\uffff\1\1\13\uffff\1\2\1\4\1\3\1\5";
    static final String DFA47_specialS =
        "\11\uffff\1\0\2\uffff\1\1\4\uffff}>";
    static final String[] DFA47_transitionS = {
            "\1\1\20\uffff\1\1\1\11\1\14\1\16\1\15\2\uffff\2\1\41\uffff\1"+
            "\1\7\uffff\12\1",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "\1\uffff",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA47_eot = DFA.unpackEncodedString(DFA47_eotS);
    static final short[] DFA47_eof = DFA.unpackEncodedString(DFA47_eofS);
    static final char[] DFA47_min = DFA.unpackEncodedStringToUnsignedChars(DFA47_minS);
    static final char[] DFA47_max = DFA.unpackEncodedStringToUnsignedChars(DFA47_maxS);
    static final short[] DFA47_accept = DFA.unpackEncodedString(DFA47_acceptS);
    static final short[] DFA47_special = DFA.unpackEncodedString(DFA47_specialS);
    static final short[][] DFA47_transition;

    static {
        int numStates = DFA47_transitionS.length;
        DFA47_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA47_transition[i] = DFA.unpackEncodedString(DFA47_transitionS[i]);
        }
    }

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = DFA47_eot;
            this.eof = DFA47_eof;
            this.min = DFA47_min;
            this.max = DFA47_max;
            this.accept = DFA47_accept;
            this.special = DFA47_special;
            this.transition = DFA47_transition;
        }
        public String getDescription() {
            return "261:1: source_text : ( sourceExpression | COMMA | LPAREN | RPAREN | WS );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 :
                        int LA47_9 = input.LA(1);


                        int index47_9 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_Cpp()) ) {s = 1;}

                        else if ( (synpred96_Cpp()) ) {s = 15;}


                        input.seek(index47_9);
                        if ( s>=0 ) return s;
                        break;
                    case 1 :
                        int LA47_12 = input.LA(1);


                        int index47_12 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred94_Cpp()) ) {s = 1;}

                        else if ( (true) ) {s = 16;}


                        input.seek(index47_12);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 47, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String DFA60_eotS =
        "\20\uffff";
    static final String DFA60_eofS =
        "\20\uffff";
    static final String DFA60_minS =
        "\1\36\5\0\12\uffff";
    static final String DFA60_maxS =
        "\1\152\5\0\12\uffff";
    static final String DFA60_acceptS =
        "\6\uffff\1\3\1\5\1\6\1\7\1\10\1\11\1\12\1\1\1\2\1\4";
    static final String DFA60_specialS =
        "\1\uffff\1\0\1\1\1\2\1\3\1\4\12\uffff}>";
    static final String[] DFA60_transitionS = {
            "\1\13\20\uffff\1\1\1\11\1\14\4\uffff\2\3\41\uffff\1\10\7\uffff"+
            "\4\3\1\6\1\7\1\12\1\2\1\4\1\5",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "\1\uffff",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA60_eot = DFA.unpackEncodedString(DFA60_eotS);
    static final short[] DFA60_eof = DFA.unpackEncodedString(DFA60_eofS);
    static final char[] DFA60_min = DFA.unpackEncodedStringToUnsignedChars(DFA60_minS);
    static final char[] DFA60_max = DFA.unpackEncodedStringToUnsignedChars(DFA60_maxS);
    static final short[] DFA60_accept = DFA.unpackEncodedString(DFA60_acceptS);
    static final short[] DFA60_special = DFA.unpackEncodedString(DFA60_specialS);
    static final short[][] DFA60_transition;

    static {
        int numStates = DFA60_transitionS.length;
        DFA60_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA60_transition[i] = DFA.unpackEncodedString(DFA60_transitionS[i]);
        }
    }

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = DFA60_eot;
            this.eof = DFA60_eof;
            this.min = DFA60_min;
            this.max = DFA60_max;
            this.accept = DFA60_accept;
            this.special = DFA60_special;
            this.transition = DFA60_transition;
        }
        public String getDescription() {
            return "281:1: sourceExpression : ( ( IDENTIFIER ( WS )? LPAREN )=> macroExpansion | ( primarySource ( WS )? SHARPSHARP )=> concatenate | STRINGIFICATION IDENTIFIER -> ^( STRINGIFICATION IDENTIFIER ) | primarySource | STRING_OP | SIZEOF | LPAREN ( macArgs )? RPAREN -> ^( TEXT_GROUP ( macArgs )? ) | SEMICOLON | TEXT_END | WS );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 :
                        int LA60_1 = input.LA(1);


                        int index60_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred110_Cpp()) ) {s = 13;}

                        else if ( (synpred112_Cpp()) ) {s = 14;}

                        else if ( (synpred114_Cpp()) ) {s = 15;}


                        input.seek(index60_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 :
                        int LA60_2 = input.LA(1);


                        int index60_2 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred112_Cpp()) ) {s = 14;}

                        else if ( (synpred114_Cpp()) ) {s = 15;}


                        input.seek(index60_2);
                        if ( s>=0 ) return s;
                        break;
                    case 2 :
                        int LA60_3 = input.LA(1);


                        int index60_3 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred112_Cpp()) ) {s = 14;}

                        else if ( (synpred114_Cpp()) ) {s = 15;}


                        input.seek(index60_3);
                        if ( s>=0 ) return s;
                        break;
                    case 3 :
                        int LA60_4 = input.LA(1);


                        int index60_4 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred112_Cpp()) ) {s = 14;}

                        else if ( (synpred114_Cpp()) ) {s = 15;}


                        input.seek(index60_4);
                        if ( s>=0 ) return s;
                        break;
                    case 4 :
                        int LA60_5 = input.LA(1);


                        int index60_5 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred112_Cpp()) ) {s = 14;}

                        else if ( (synpred114_Cpp()) ) {s = 15;}


                        input.seek(index60_5);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 60, _s, input);
            error(nvae);
            throw nvae;
        }
    }


    public static final BitSet FOLLOW_procLine_in_preprocess222 = new BitSet(new long[]{0x00CFE1F440000E42L,0x000007FE02000000L});
    public static final BitSet FOLLOW_DIRECTIVE_in_procLine242 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_text_line_in_procLine249 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_diagnostics_in_procLine256 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_fileInclusion_in_procLine262 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_macroDefine_in_procLine268 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_macroUndef_in_procLine274 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_conditionalCompilation_in_procLine280 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_lineControl_in_procLine286 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_macroExecution_in_procLine293 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_End_in_procLine300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_in_fileInclusion314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCLUDE_EXPAND_in_fileInclusion328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_macroDefine350 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroDefine353 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_macroDefine356 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_WS_in_macroDefine358 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_macroDefine361 = new BitSet(new long[]{0x00CF800040000002L,0x000007FE02000000L});
    public static final BitSet FOLLOW_macro_text_in_macroDefine364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_macroDefine384 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroDefine388 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_macroDefine391 = new BitSet(new long[]{0x0016800000000000L});
    public static final BitSet FOLLOW_WS_in_macroDefine393 = new BitSet(new long[]{0x0014800000000000L});
    public static final BitSet FOLLOW_macroParam_in_macroDefine400 = new BitSet(new long[]{0x000E000000000000L});
    public static final BitSet FOLLOW_WS_in_macroDefine402 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_COMMA_in_macroDefine406 = new BitSet(new long[]{0x0012800000000000L});
    public static final BitSet FOLLOW_WS_in_macroDefine408 = new BitSet(new long[]{0x0012800000000000L});
    public static final BitSet FOLLOW_macroParam_in_macroDefine413 = new BitSet(new long[]{0x000E000000000000L});
    public static final BitSet FOLLOW_WS_in_macroDefine415 = new BitSet(new long[]{0x000E000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_macroDefine426 = new BitSet(new long[]{0x00CF800040000002L,0x000007FE02000000L});
    public static final BitSet FOLLOW_macro_text_in_macroDefine428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_macroDefine464 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroDefine466 = new BitSet(new long[]{0x00CF800040000002L,0x000007FE02000000L});
    public static final BitSet FOLLOW_macro_text_in_macroDefine468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroParam504 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_ELLIPSIS_in_macroParam506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ELLIPSIS_in_macroParam520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroParam526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXEC_MACRO_in_macroExecution539 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_ifexpression_in_macroExecution541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UNDEF_in_macroUndef564 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroUndef568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IF_in_conditionalCompilation590 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_ifexpression_in_conditionalCompilation595 = new BitSet(new long[]{0x00CFE1F440000E40L,0x000007FE02000000L});
    public static final BitSet FOLLOW_statement_in_conditionalCompilation600 = new BitSet(new long[]{0x0020000000000180L});
    public static final BitSet FOLLOW_ELIF_in_conditionalCompilation608 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_ifexpression_in_conditionalCompilation612 = new BitSet(new long[]{0x00CFE1F440000E40L,0x000007FE02000000L});
    public static final BitSet FOLLOW_statement_in_conditionalCompilation617 = new BitSet(new long[]{0x0020000000000180L});
    public static final BitSet FOLLOW_ELSE_in_conditionalCompilation624 = new BitSet(new long[]{0x00CFE1F440000E40L,0x000007FE02000000L});
    public static final BitSet FOLLOW_statement_in_conditionalCompilation629 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_ENDIF_in_conditionalCompilation633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LINE_in_lineControl676 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_DECIMAL_LITERAL_in_lineControl680 = new BitSet(new long[]{0x0080000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_lineControl685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WARNING_in_diagnostics718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ERROR_in_diagnostics730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PRAGMA_in_diagnostics742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_source_text_in_text_line763 = new BitSet(new long[]{0x00CF800040000002L,0x000007FE02000000L});
    public static final BitSet FOLLOW_procLine_in_statement794 = new BitSet(new long[]{0x00CFE1F440000E42L,0x000007FE02000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_type_name810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_ifexpression823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_ifexpression843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentExpression_in_ifexpression863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_conditionalExpression_in_assignmentExpression884 = new BitSet(new long[]{0xFF00000000000002L,0x0000000000000007L});
    public static final BitSet FOLLOW_ASSIGNEQUAL_in_assignmentExpression893 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_TIMESEQUAL_in_assignmentExpression904 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_DIVIDEEQUAL_in_assignmentExpression915 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_MODEQUAL_in_assignmentExpression926 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_PLUSEQUAL_in_assignmentExpression937 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_MINUSEQUAL_in_assignmentExpression948 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_SHIFTLEFTEQUAL_in_assignmentExpression959 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_SHIFTRIGHTEQUAL_in_assignmentExpression970 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_BITWISEANDEQUAL_in_assignmentExpression979 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_BITWISEXOREQUAL_in_assignmentExpression988 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_BITWISEOREQUAL_in_assignmentExpression997 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_assignmentExpression_in_assignmentExpression1009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalOrExpression_in_conditionalExpression1028 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_QUESTIONMARK_in_conditionalExpression1036 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_assignmentExpression_in_conditionalExpression1039 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_COLON_in_conditionalExpression1041 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_conditionalExpression_in_conditionalExpression1043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_logicalAndExpression_in_logicalOrExpression1059 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_OR_in_logicalOrExpression1062 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_logicalAndExpression_in_logicalOrExpression1065 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_inclusiveOrExpression_in_logicalAndExpression1080 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_AND_in_logicalAndExpression1083 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_inclusiveOrExpression_in_logicalAndExpression1086 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000040L});
    public static final BitSet FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression1101 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_BITWISEOR_in_inclusiveOrExpression1104 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_exclusiveOrExpression_in_inclusiveOrExpression1107 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_andExpression_in_exclusiveOrExpression1122 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_BITWISEXOR_in_exclusiveOrExpression1125 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_andExpression_in_exclusiveOrExpression1128 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000100L});
    public static final BitSet FOLLOW_equalityExpression_in_andExpression1143 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_AMPERSAND_in_andExpression1146 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_equalityExpression_in_andExpression1149 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression1164 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_NOTEQUAL_in_equalityExpression1168 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_EQUAL_in_equalityExpression1173 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_relationalExpression_in_equalityExpression1177 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000C00L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression1192 = new BitSet(new long[]{0x0000000000000002L,0x000000000000F000L});
    public static final BitSet FOLLOW_LESSTHAN_in_relationalExpression1203 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_GREATERTHAN_in_relationalExpression1213 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_LESSTHANOREQUALTO_in_relationalExpression1223 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_GREATERTHANOREQUALTO_in_relationalExpression1233 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_shiftExpression_in_relationalExpression1247 = new BitSet(new long[]{0x0000000000000002L,0x000000000000F000L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression1271 = new BitSet(new long[]{0x0000000000000002L,0x0000000000030000L});
    public static final BitSet FOLLOW_SHIFTLEFT_in_shiftExpression1275 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_SHIFTRIGHT_in_shiftExpression1280 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_additiveExpression_in_shiftExpression1284 = new BitSet(new long[]{0x0000000000000002L,0x0000000000030000L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1299 = new BitSet(new long[]{0x0000000000000002L,0x00000000000C0000L});
    public static final BitSet FOLLOW_PLUS_in_additiveExpression1303 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_MINUS_in_additiveExpression1308 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_multiplicativeExpression_in_additiveExpression1312 = new BitSet(new long[]{0x0000000000000002L,0x00000000000C0000L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1327 = new BitSet(new long[]{0x0000000000000002L,0x0000000000700000L});
    public static final BitSet FOLLOW_STAR_in_multiplicativeExpression1331 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_DIVIDE_in_multiplicativeExpression1336 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_MOD_in_multiplicativeExpression1341 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_unaryExpression_in_multiplicativeExpression1346 = new BitSet(new long[]{0x0000000000000002L,0x0000000000700000L});
    public static final BitSet FOLLOW_PLUSPLUS_in_unaryExpression1361 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression1364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUSMINUS_in_unaryExpression1378 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression1380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SIZEOF_in_unaryExpression1394 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpression1396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SIZEOF_in_unaryExpression1410 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_unaryExpression1412 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_type_name_in_unaryExpression1414 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_unaryExpression1416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINED_in_unaryExpression1430 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_type_name_in_unaryExpression1432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINED_in_unaryExpression1448 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_unaryExpression1450 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_type_name_in_unaryExpression1452 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_unaryExpression1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaryExpressionNotPlusMinus_in_unaryExpression1468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_unaryExpressionNotPlusMinus1481 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TILDE_in_unaryExpressionNotPlusMinus1499 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AMPERSAND_in_unaryExpressionNotPlusMinus1517 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_unaryExpressionNotPlusMinus1533 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_MINUS_in_unaryExpressionNotPlusMinus1550 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PLUS_in_unaryExpressionNotPlusMinus1568 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_unaryExpressionNotPlusMinus1586 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_type_name_in_unaryExpressionNotPlusMinus1588 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_unaryExpressionNotPlusMinus1590 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_unaryExpression_in_unaryExpressionNotPlusMinus1593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_postfixExpression_in_unaryExpressionNotPlusMinus1609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primaryExpression_in_postfixExpression1624 = new BitSet(new long[]{0x0000000000000002L,0x00000001A1900000L});
    public static final BitSet FOLLOW_LSQUARE_in_postfixExpression1634 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_assignmentExpression_in_postfixExpression1639 = new BitSet(new long[]{0x0000000000000000L,0x0000000040000000L});
    public static final BitSet FOLLOW_RSQUARE_in_postfixExpression1641 = new BitSet(new long[]{0x0000000000000002L,0x00000001A1900000L});
    public static final BitSet FOLLOW_DOT_in_postfixExpression1650 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_postfixExpression1658 = new BitSet(new long[]{0x0000000000000002L,0x00000001A1900000L});
    public static final BitSet FOLLOW_STAR_in_postfixExpression1673 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_postfixExpression1678 = new BitSet(new long[]{0x0000000000000002L,0x00000001A1900000L});
    public static final BitSet FOLLOW_POINTERTO_in_postfixExpression1686 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_postfixExpression1689 = new BitSet(new long[]{0x0000000000000002L,0x00000001A1900000L});
    public static final BitSet FOLLOW_PLUSPLUS_in_postfixExpression1699 = new BitSet(new long[]{0x0000000000000002L,0x00000001A1900000L});
    public static final BitSet FOLLOW_MINUSMINUS_in_postfixExpression1715 = new BitSet(new long[]{0x0000000000000002L,0x00000001A1900000L});
    public static final BitSet FOLLOW_functionCall_in_primaryExpression1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primaryExpression1757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_primaryExpression1771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_primaryExpression1784 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_assignmentExpression_in_primaryExpression1787 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_primaryExpression1789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_functionCall1816 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_functionCall1818 = new BitSet(new long[]{0x00C5800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_argList_in_functionCall1820 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_functionCall1823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assignmentExpression_in_argList1849 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_COMMA_in_argList1852 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_assignmentExpression_in_argList1854 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_set_in_constant0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sourceExpression_in_source_text1936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COMMA_in_source_text1942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_source_text1948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RPAREN_in_source_text1954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_source_text1960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroExpansion1976 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_WS_in_macroExpansion1978 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_macroExpansion1981 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_WS_in_macroExpansion1983 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_macroExpansion1988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_macroExpansion2006 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_WS_in_macroExpansion2008 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_macroExpansion2011 = new BitSet(new long[]{0x00CB800040000000L,0x000007FE02000000L});
    public static final BitSet FOLLOW_WS_in_macroExpansion2013 = new BitSet(new long[]{0x00CB800040000000L,0x000007FE02000000L});
    public static final BitSet FOLLOW_macArgs_in_macroExpansion2016 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_WS_in_macroExpansion2019 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_macroExpansion2022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mArg_in_macArgs2048 = new BitSet(new long[]{0x000A000000000002L});
    public static final BitSet FOLLOW_WS_in_macArgs2052 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_COMMA_in_macArgs2055 = new BitSet(new long[]{0x00CB800040000000L,0x000007FE02000000L});
    public static final BitSet FOLLOW_WS_in_macArgs2057 = new BitSet(new long[]{0x00CB800040000000L,0x000007FE02000000L});
    public static final BitSet FOLLOW_mArg_in_macArgs2062 = new BitSet(new long[]{0x000A000000000002L});
    public static final BitSet FOLLOW_sourceExpression_in_mArg2086 = new BitSet(new long[]{0x00C3800040000002L,0x000007FE02000000L});
    public static final BitSet FOLLOW_macroExpansion_in_sourceExpression2131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_concatenate_in_sourceExpression2150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRINGIFICATION_in_sourceExpression2156 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_sourceExpression2158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primarySource_in_sourceExpression2173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_OP_in_sourceExpression2179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SIZEOF_in_sourceExpression2185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_sourceExpression2191 = new BitSet(new long[]{0x00CF800040000000L,0x000007FE02000000L});
    public static final BitSet FOLLOW_macArgs_in_sourceExpression2193 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_sourceExpression2196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SEMICOLON_in_sourceExpression2211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEXT_END_in_sourceExpression2217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_sourceExpression2223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primarySource_in_concatenate2238 = new BitSet(new long[]{0x0002000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_WS_in_concatenate2241 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_SHARPSHARP_in_concatenate2244 = new BitSet(new long[]{0x00C2800000000000L,0x0000071E00000000L});
    public static final BitSet FOLLOW_WS_in_concatenate2247 = new BitSet(new long[]{0x00C0800000000000L,0x0000071E00000000L});
    public static final BitSet FOLLOW_primarySource_in_concatenate2252 = new BitSet(new long[]{0x0002000000000002L,0x0000010000000000L});
    public static final BitSet FOLLOW_SHARPSHARP_in_primarySource2279 = new BitSet(new long[]{0x0002800000000000L});
    public static final BitSet FOLLOW_WS_in_primarySource2281 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primarySource2284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_primarySource2298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_primarySource2305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CKEYWORD_in_primarySource2311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COPERATOR_in_primarySource2317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_source_text_in_macro_text4181 = new BitSet(new long[]{0x00CF800040000002L,0x000007FE02000000L});
    public static final BitSet FOLLOW_DEFINE_in_synpred14_Cpp350 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred14_Cpp353 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_synpred14_Cpp356 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_WS_in_synpred14_Cpp358 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_synpred14_Cpp361 = new BitSet(new long[]{0x00CF800040000002L,0x000007FE02000000L});
    public static final BitSet FOLLOW_macro_text_in_synpred14_Cpp364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINE_in_synpred22_Cpp384 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred22_Cpp388 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_synpred22_Cpp391 = new BitSet(new long[]{0x0016800000000000L});
    public static final BitSet FOLLOW_WS_in_synpred22_Cpp393 = new BitSet(new long[]{0x0014800000000000L});
    public static final BitSet FOLLOW_macroParam_in_synpred22_Cpp400 = new BitSet(new long[]{0x000E000000000000L});
    public static final BitSet FOLLOW_WS_in_synpred22_Cpp402 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_COMMA_in_synpred22_Cpp406 = new BitSet(new long[]{0x0012800000000000L});
    public static final BitSet FOLLOW_WS_in_synpred22_Cpp408 = new BitSet(new long[]{0x0012800000000000L});
    public static final BitSet FOLLOW_macroParam_in_synpred22_Cpp413 = new BitSet(new long[]{0x000E000000000000L});
    public static final BitSet FOLLOW_WS_in_synpred22_Cpp415 = new BitSet(new long[]{0x000E000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_synpred22_Cpp426 = new BitSet(new long[]{0x00CF800040000002L,0x000007FE02000000L});
    public static final BitSet FOLLOW_macro_text_in_synpred22_Cpp428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred33_Cpp823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred34_Cpp843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SIZEOF_in_synpred67_Cpp1394 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_unaryExpression_in_synpred67_Cpp1396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SIZEOF_in_synpred68_Cpp1410 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_synpred68_Cpp1412 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_type_name_in_synpred68_Cpp1414 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_synpred68_Cpp1416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_synpred77_Cpp1586 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_type_name_in_synpred77_Cpp1588 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_synpred77_Cpp1590 = new BitSet(new long[]{0x00C1800000000000L,0x0000001E1F9C0200L});
    public static final BitSet FOLLOW_unaryExpression_in_synpred77_Cpp1593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STAR_in_synpred80_Cpp1673 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred80_Cpp1678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred84_Cpp1741 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_synpred84_Cpp1743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred85_Cpp1757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sourceExpression_in_synpred94_Cpp1936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LPAREN_in_synpred96_Cpp1948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred100_Cpp1976 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_WS_in_synpred100_Cpp1978 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_synpred100_Cpp1981 = new BitSet(new long[]{0x0006000000000000L});
    public static final BitSet FOLLOW_WS_in_synpred100_Cpp1983 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_RPAREN_in_synpred100_Cpp1988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_synpred102_Cpp2013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_synpred105_Cpp2057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sourceExpression_in_synpred107_Cpp2086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_sourceExpression_in_synpred108_Cpp2086 = new BitSet(new long[]{0x00C3800040000002L,0x000007FE02000000L});
    public static final BitSet FOLLOW_IDENTIFIER_in_synpred110_Cpp2122 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_WS_in_synpred110_Cpp2124 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_LPAREN_in_synpred110_Cpp2127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primarySource_in_synpred112_Cpp2138 = new BitSet(new long[]{0x0002000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_WS_in_synpred112_Cpp2140 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_SHARPSHARP_in_synpred112_Cpp2143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_primarySource_in_synpred114_Cpp2173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_macArgs_in_synpred117_Cpp2193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WS_in_synpred123_Cpp2241 = new BitSet(new long[]{0x0000000000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_SHARPSHARP_in_synpred123_Cpp2244 = new BitSet(new long[]{0x00C2800000000000L,0x0000071E00000000L});
    public static final BitSet FOLLOW_WS_in_synpred123_Cpp2247 = new BitSet(new long[]{0x00C0800000000000L,0x0000071E00000000L});
    public static final BitSet FOLLOW_primarySource_in_synpred123_Cpp2252 = new BitSet(new long[]{0x0000000000000002L});

}