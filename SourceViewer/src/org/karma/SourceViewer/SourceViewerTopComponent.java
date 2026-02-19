/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.karma.SourceViewer;

import FlowDiags.DoxygenWorker;
import FlowDiags.DoxygenWorkerCalls;
import FlowDiags.InspectorDlg;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.BadLocationException;
import javax.swing.text.Caret;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.Highlighter;
import jsyntaxpane.DefaultSyntaxKit;
import org.karma.asearch.CodeSearchDlg;
import org.karma.asearch.XMLQueryDlg;
import org.karma.helper.BasexHelper;
import org.karma.helper.DoxygenHelper;
import org.karma.helper.GenericLoadingDlg;
import org.karma.helper.KarmaTableCellRenderer;
import org.karma.helper.KarmaVaultHelp;
import org.karma.helper.projectInfo;
import org.karma.visual.BugsLinesGraph;
import org.karma.visual.CommentsLinesGraph;
import org.karma.visual.CyclomaticCGraph;
import org.karma.visual.FileNetwork;
import org.karma.visual.InclusionNetwork;
import org.karma.visual.controlFlow;
import org.karma.visual.keyWordSearchDlg;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;
import org.openide.windows.TopComponent;
import org.openide.util.ImageUtilities;
import org.openide.windows.Mode;
import org.openide.windows.WindowManager;


//import org.netbeans.api.settings.ConvertAsProperties;
/**
 * Top component which displays something.
 */
/*
@ConvertAsProperties(
dtd="-//org.karma.SourceViewer//SourceViewer//EN",
autostore=false
)*/
public /*final*/ class SourceViewerTopComponent extends TopComponent {
final static String whereAMI = ""+KarmaVaultHelp.class.getProtectionDomain().getCodeSource().getLocation().getPath();
final static String RootDir =new File(whereAMI.substring(whereAMI.indexOf(System.getProperty("file.separator")))).getParent()+System.getProperty("file.separator")+".."+System.getProperty("file.separator")+"Doxygen.config";

    public static final String[] columnNames = {"Line No", "Code Snippet", "Confidence %"};
    public static DefaultTableModel bugsTableModel;
    //private static SourceViewerTopComponent instance;
    /** path to the icon used by the component and its open action */
    static final String ICON_PATH = "org/karma/SourceViewer/1246385659_eye.png";
//    private static final String PREFERRED_ID = "SourceViewerTopComponent";
    JMenuItem mCFG, mCloud, mCC, mAST, mCS, mTeachBug, mTeachBugNot, mNote, mNoteDefinition,mDefinition,mDefinitionFollow,mDefinitionFollowCalls, mIG, mBL, mAS, mDS, mQuery;
    JPopupMenu RCM;
    WordSearcher searcher;
    public static String word;
    public static Highlighter highlighter = new UnderlineHighlighter(null);

    public void open() {
              Mode m = WindowManager.getDefault().findMode ("editor");
              if (m != null) {    m.dockInto(this);   }
          super.open();
          }
		  
		  
    public SourceViewerTopComponent() {

        initComponents();
        JPanel searchP = new jsyntaxpane.actions.gui.QuickFindPanel(SourceCode, (new jsyntaxpane.actions.DocumentSData()).getFromEditor(SourceCode));
        SourceCode.requestFocus();
        if (org.karma.helper.projectInfo.StartUpCount == 0) {
            
            jSplitPane1.removeAll();
            jSplitPane1.add(SourceCode);
            SourceCode.setContentType("text/html");
            SourceCode.setText("<font face=\"Arial\"><center><br><br><br><big>v0.4b</big><br>Self-taught Source Code Analyser"
                    + "<br><small>Choose Source Base and Start Analysis</small><br><img src=\"" + super.getClass().getResource("karmalogo.png") + "\">"
                    + "<br><small>You can create and train your own Karma-Brains<br>It is recommended to read the help pages.<br><br><br>Brought "
                    + "to you by<br><img src=\"" + super.getClass().getResource("logo.png") + "\"><br>&copy;" + Calendar.getInstance().get(Calendar.YEAR) + "</small></center></font>");
            jPanel1.add(searchP);            
            org.karma.helper.projectInfo.StartUpCount++;
            
        } 
        else {
            
        
            
            
            SourceCode.setCaretPosition(0);
            jPanel1.add(searchP);
            
            InputStream is = null;
        
            Font font = null;
        try {
            is = (getClass().getResource("/org/karma/helper/VeraMono.ttf")).openStream();
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (FontFormatException ex) {
            Exceptions.printStackTrace(ex);
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }

        Font f = new Font(font.getFontName(),Font.TRUETYPE_FONT,14);
        
        
        
            DefaultSyntaxKit kit = null;
            String lang = org.karma.helper.projectInfo.languageName;
            
            
            if (lang.equalsIgnoreCase("c"))
            kit = new jsyntaxpane.syntaxkits.CSyntaxKit();
            else if (lang.equalsIgnoreCase("java"))
            kit = new jsyntaxpane.syntaxkits.JavaSyntaxKit();            
            else if (lang.equalsIgnoreCase("c++"))
            kit = new jsyntaxpane.syntaxkits.CppSyntaxKit();
            else if (lang.equalsIgnoreCase("ruby"))
            kit = new jsyntaxpane.syntaxkits.RubySyntaxKit();
            else if (lang.equalsIgnoreCase("python"))
            kit = new jsyntaxpane.syntaxkits.PythonSyntaxKit();
            else 
            kit = new jsyntaxpane.syntaxkits.CSyntaxKit();
            
            kit.setProperty("Style.COMMENT","0x4A9586, 2");
            kit.setProperty("Style.COMMENT2","0x4A9586, 2");
           
            
            SourceCode.setEditorKit(kit);
            
            
            
            

        }






        // SourceCode.setSelectionColor(new Color(1.0f, 1.0f, 1.0f, 0.0f));

        bugsTableModel = new DefaultTableModel(new Object[0][0][0], columnNames) {

            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        Bugs.setModel(bugsTableModel);

        //Set the size so it looks good
        TableColumn colLine = Bugs.getColumnModel().getColumn(0);
        colLine.setPreferredWidth(100);
        colLine.setMaxWidth(200);
        TableColumn colConfidence = Bugs.getColumnModel().getColumn(2);
        colConfidence.setPreferredWidth(100);
        colConfidence.setMaxWidth(200);


        //Decorative things
        Bugs.setShowHorizontalLines(false);
        Bugs.setShowVerticalLines(true);
        Bugs.setGridColor(Color.lightGray);
        Bugs.setDefaultRenderer(Object.class, new KarmaTableCellRenderer());
        for (int a = 0; a < 15; a++) {
            bugsTableModel.insertRow(Bugs.getRowCount(), new Object[]{""});
        }




        //SourceCode.setEditorKit(new NumberedEditorKit());
        // SourceCode.setContentType("text/x-java");
        // SourceCode.setEditorKit(new BaseKit());
        // SourceCode.setUI(new BaseTextUI());
        //BaseTextUI eui = new BaseTextUI();
        //eui.installUI(SourceCode);
        // eui.getEditorUI().getExtComponent();





        //SourceCode.setEditorKit(new NumberedEditorKit());
        //SourceCode.setContentType("text/java");
        //Settings.setValue(BaseKit.class,SettingsNames.LINE_NUMBER_VISIBLE,true);
        //setSettingBoolean(SettingsNames.LINE_NUMBER_VISIBLE, b,
        //+        LINE_NUMBER_VISIBLE_PROP);
        //NbEditorKit a =        new NbEditorKit();
        //SourceCode.setEditorKit(a);
        //a.install(SourceCode);
        //SourceCode.setContentType("text/x-java");

        //Word Search within editorpane
        searcher = new WordSearcher(SourceCode);
        SourceCode.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent evt) {
                searcher.search(word);
            }

            public void removeUpdate(DocumentEvent evt) {
                searcher.search(word);
            }

            public void changedUpdate(DocumentEvent evt) {
            }
        });



        //Right-Click menu
        RCM = new JPopupMenu();
        //VisiCode
        JMenuItem VisiCodeMenu = new JMenuItem("VisiCode");
        mIG = new JMenuItem("Inclusion Graph [P]");
        mIG.setIcon(new ImageIcon(super.getClass().getResource("cubepoint.png")));
        mCFG = new JMenuItem("Control Flow Graph [F]");
        mCFG.setIcon(new ImageIcon(super.getClass().getResource("cubepointb.png")));
        mCloud = new JMenuItem("Keyword Cloud [P]");
        mCloud.setIcon(new ImageIcon(super.getClass().getResource("cubepoint.png")));
        mCC = new JMenuItem("Cyclomatic Complexity [P]");
        mCC.setIcon(new ImageIcon(super.getClass().getResource("cubepoint.png")));
        mAST = new JMenuItem("AST Graph [F]");
        mAST.setIcon(new ImageIcon(super.getClass().getResource("cubepointb.png")));
        mBL = new JMenuItem("Bugs/Lines Graph [P]");
        mBL.setIcon(new ImageIcon(super.getClass().getResource("cubepoint.png")));
        mCS = new JMenuItem("Comments/Lines Graph [P]");
        mCS.setIcon(new ImageIcon(super.getClass().getResource("cubepoint.png")));
        //Advanced Search
        JMenuItem AdvancedSearch = new JMenuItem("Search");
        mAS = new JMenuItem("Advanced Search Engine [P]");
        mAS.setIcon(new ImageIcon(super.getClass().getResource("search1.png")));
        mQuery = new JMenuItem("XML Query");
        mQuery.setIcon(new ImageIcon(super.getClass().getResource("search1.png")));
       //
               
       // mDS = new JMenuItem("Document Search [D]");
       // mDS.setIcon(new ImageIcon(super.getClass().getResource("document_search.png")));

        //Training
        JMenuItem TrainingMenu = new JMenuItem("Training");
        mTeachBug = new JMenuItem("This is a bug [K]");
        mTeachBug.setIcon(new ImageIcon(super.getClass().getResource("bug_add.png")));
        mTeachBugNot = new JMenuItem("This is not a bug [K]");
        mTeachBugNot.setIcon(new ImageIcon(super.getClass().getResource("bug_delete.png")));


        //Utils
        JMenuItem UtilsMenu = new JMenuItem("Flow Utils");
        mNote = new JMenuItem("Add Line");
        mNote.setIcon(new ImageIcon(super.getClass().getResource("note.gif")));


        mNoteDefinition = new JMenuItem("Add Definition");
        mNoteDefinition.setIcon(new ImageIcon(super.getClass().getResource("definition.gif")));

        //Doxygen 
        //Definition and calls/calle
        JMenuItem DoxMenu = new JMenuItem("Inspector");
        mDefinition = new JMenuItem("Find Definition");
        mDefinition.setIcon(new ImageIcon(super.getClass().getResource("findDefinition.png")));
        //Follow called by
        mDefinitionFollow = new JMenuItem("Follow \"Called by\"");
        mDefinitionFollow.setIcon(new ImageIcon(super.getClass().getResource("findDefinition2.png")));
        
        //Follow Calls
        mDefinitionFollowCalls = new JMenuItem("Follow \"Calls\"");
        mDefinitionFollowCalls.setIcon(new ImageIcon(super.getClass().getResource("findDefinition3.png")));
        
        
        //Add MenuItems and decrate
        Font menuFont = new Font(mCFG.getFont().toString(), 0, 11);
        Font titleMenuFont = new Font(mCFG.getFont().toString(), 0, 12);

        VisiCodeMenu.setEnabled(false);
        VisiCodeMenu.setFont(titleMenuFont);

        AdvancedSearch.setEnabled(false);
        AdvancedSearch.setFont(titleMenuFont);

        RCM.add(VisiCodeMenu);
        RCM.addSeparator();
        mIG.setFont(menuFont);
        RCM.add(mIG);
        mCloud.setFont(menuFont);
        RCM.add(mCloud);
        mCC.setFont(menuFont);
        RCM.add(mCC);
        mBL.setFont(menuFont);
        RCM.add(mBL);
        mCS.setFont(menuFont);
        RCM.add(mCS);
        mAST.setFont(menuFont);
        //RCM.add(mAST);
        mCFG.setFont(menuFont);
       // RCM.add(mCFG);
        RCM.addSeparator();
        RCM.add(AdvancedSearch);
        mAS.setFont(menuFont);
        mQuery.setFont(menuFont);
        RCM.add(mAS);
        RCM.add(mQuery);
       
        
        //mDS.setFont(menuFont);
        //RCM.add(mDS);
        TrainingMenu.setEnabled(false);
        TrainingMenu.setFont(titleMenuFont);
        RCM.addSeparator();
        RCM.add(TrainingMenu);
        RCM.addSeparator();
        mTeachBug.setFont(menuFont);
        RCM.add(mTeachBug);
        mTeachBugNot.setFont(menuFont);
        RCM.add(mTeachBugNot);
        UtilsMenu.setEnabled(false);
        UtilsMenu.setFont(titleMenuFont);
        RCM.addSeparator();
        RCM.add(UtilsMenu);
        RCM.addSeparator();
        mNote.setFont(menuFont);
        RCM.add(mNote);
        mNoteDefinition.setFont(menuFont);
        RCM.add(mNoteDefinition);
        
        RCM.addSeparator();
        DoxMenu.setFont(menuFont);
        DoxMenu.setEnabled(false);
        RCM.add(DoxMenu);
        RCM.addSeparator();
        mDefinition.setFont(menuFont);
        RCM.add(mDefinition);
        mDefinitionFollow.setFont(menuFont);
        RCM.add(mDefinitionFollow);
        mDefinitionFollowCalls.setFont(menuFont);
        RCM.add(mDefinitionFollowCalls);
        
        
        //Check if we should allow cyclomatic complexity
        if(!Arrays.asList(org.karma.metrics.CyclomaticComplexity.supportedLanguages).contains(projectInfo.languageName.toLowerCase()))
            mCC.setEnabled(false);
        
        
        
        
        
        
        
        mCFG.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                mCFGActionPerformed(evt);
            }
        });

        mCloud.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                mCloudActionPerformed(evt);
            }
        });

        mCC.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                mCCActionPerformed(evt);
            }
        });

        mIG.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                mIGActionPerformed(evt);
            }
        });

        mBL.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                mBLActionPerformed(evt);
            }
        });

        mCS.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                mCSActionPerformed(evt);
            }
        });

        mAS.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                mASActionPerformed(evt);
            }
        });
        
        mQuery.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                mQueryActionPerformed(evt);
            }
        });
        

/*        mDS.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                mDSActionPerformed(evt);
            }
        });
*/

        mNote.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                mNoteActionPerformed(evt);
            }
        });


        mNoteDefinition.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                mNoteDefinitionActionPerformed(evt);
            }
        });
        
        
           mDefinition.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                mDefinitionActionPerformed(evt);
            }
        });
           
            mDefinitionFollow.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                mDefinitionFollowActionPerformed(evt);
            }
        });

            
             mDefinitionFollowCalls.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                mDefinitionFollowCallsActionPerformed(evt);
            }
        });
        /*
        DefaultSyntaxKit.initKit();
        java.awt.EventQueue.invokeLater(new Runnable()
        {public void run() {SourceViewerTopComponent.SourceCode.setContentType("text/java");}});
         */

        //Check supported languages for VisiCode

        //Cyclomatic Complexity

        mAST.setEnabled(false);
        mCFG.setEnabled(false);


           //System.out.println("EMPTY====>"+bugsTableModel.getRowCount());
         
        
        
        //Check if doxygen is on from previous
        try
        {
            BufferedReader in = new BufferedReader(new FileReader(RootDir));
          do
            {  
                String str;
                str = in.readLine();
                if(str==null)
                {
                    projectInfo.isDoxygenOn = false;
                    break;
                }
                else 
                {
                    projectInfo.isDoxygenOn = true;
                    projectInfo.DoxygenPath = str;
                    break;
                }

            } while(true);
           in.close();
            
            
            
        }
         catch(IOException e)
        {
            projectInfo.isDoxygenOn = false;
        }
        
        
        
        
           

           
           

        setName(NbBundle.getMessage(SourceViewerTopComponent.class, "CTL_SourceViewerTopComponent"));
        setToolTipText(NbBundle.getMessage(SourceViewerTopComponent.class, "HINT_SourceViewerTopComponent"));
        setIcon(ImageUtilities.loadImage(ICON_PATH, true));

    }

    //Actions for MenuItems
    private void mCFGActionPerformed(ActionEvent evt) {

        new controlFlow(null, false).setVisible(true);
    }
    
    private void mQueryActionPerformed(ActionEvent evt) {
        
        BasexHelper bh = new BasexHelper();
         (new XMLQueryDlg(null, true)).setVisible(true);
       
    }
    

    private void mCloudActionPerformed(ActionEvent evt) {
        String searchFor = SourceCode.getSelectedText();
        String base = org.karma.helper.projectInfo.base;
        String ext = org.karma.helper.projectInfo.language;

        if (SourceCode.getSelectedText() == null) {
            (new keyWordSearchDlg(null, true, searchFor, base, ext)).setVisible(true);
        } else {
            (new FileNetwork(null, true, searchFor, base, ext)).setVisible(true);
        }
    }

    private void mASActionPerformed(ActionEvent evt) {

        (new CodeSearchDlg(null, true)).setVisible(true);
    }

    private void mDSActionPerformed(ActionEvent evt) {

       // if (SourceCode.getSelectedText() != null) {
         //   wordsearch.setText(SourceCode.getSelectedText());
       // }
    }

    private void mCCActionPerformed(ActionEvent evt) {
        String base = org.karma.helper.projectInfo.base;
        String ext = org.karma.helper.projectInfo.language;
        (new CyclomaticCGraph(null, true, base, ext)).setVisible(true);
    }

    private void mIGActionPerformed(ActionEvent evt) {
        String base = org.karma.helper.projectInfo.base;
        String ext = org.karma.helper.projectInfo.language;
        String langName = org.karma.helper.projectInfo.languageName;
        (new InclusionNetwork(null, true, base, ext, langName)).setVisible(true);
    }

    private void mBLActionPerformed(ActionEvent evt) {
        String base = org.karma.helper.projectInfo.base;
        String ext = org.karma.helper.projectInfo.language;
        String langName = org.karma.helper.projectInfo.languageName;
        (new BugsLinesGraph(null, true, base, ext)).setVisible(true);
    }

    private void mCSActionPerformed(ActionEvent evt) {
        String base = org.karma.helper.projectInfo.base;
        String ext = org.karma.helper.projectInfo.language;
        String langName = org.karma.helper.projectInfo.languageName;
        (new CommentsLinesGraph(null, true, base, ext)).setVisible(true);
    }

    private void mASTActionPerformed(ActionEvent evt, String line) {
    }

    private void mTeachBugActionPerformed(ActionEvent evt, String line) {
    }

    private void mTeachBugNotActionPerformed(ActionEvent evt, String line) {
    }

    private void mNoteActionPerformed(ActionEvent evt) {
        Document doc = SourceCode.getDocument();
        int offset = SourceCode.getCaretPosition();
        int lineNbr = doc.getDefaultRootElement().getElementIndex(offset);
        Element rootElement = doc.getDefaultRootElement();
        Caret caret = SourceCode.getCaret();
        int start = SourceCode.getCaretPosition();
        int end = start;
        int selStart = caret.getDot();
        int selEnd = caret.getMark();
        start = Math.min(selStart, selEnd);
        end = Math.max(selStart, selEnd) - 1;
        int zeroBaseStartLineNumber = rootElement.getElementIndex(start);
        int zeroBaseEndLineNumber = rootElement.getElementIndex(end);
        Element startLineElement = rootElement.getElement(zeroBaseStartLineNumber);
        int startLineStartOffset = startLineElement.getStartOffset();
        Element endLineElement = rootElement.getElement(zeroBaseEndLineNumber);
        int endLineEndOffset = endLineElement.getEndOffset();

        String linesText = "";
        try {
            linesText = doc.getText(startLineStartOffset, endLineEndOffset - startLineStartOffset);
        } catch (BadLocationException ex) {
            Exceptions.printStackTrace(ex);
        }

        lineNbr++;


        try{
                ((DefaultTableModel) (FlowDiags.FlowNotesTopComponent.Flow.getModel())).insertRow(0, new Object[]{lineNbr, linesText.substring(Integer.toString(lineNbr).length()), this.getToolTipText()});
            }
        catch(Exception e){}

    }

    private void mNoteDefinitionActionPerformed(ActionEvent evt) {
        
       if (SourceCode.getSelectedText() != null)
       { String defText = SourceCode.getSelectedText();
        (new FlowDiags.AddDefinitionDlg(null, true, defText)).setVisible(true);
       }


    }
    
    
     private void mDefinitionActionPerformed(ActionEvent evt) {
        //String defText = SourceCode.getSelectedText();
        
         
        String searchFor = SourceCode.getSelectedText();

        if (SourceCode.getSelectedText() == null) {
            //(new keyWordSearchDlg(null, true, searchFor, base, ext)).setVisible(true);
        } else {
           //(new FlowDiags.InspectorDlg(null, false, searchFor)).setVisible(true);
            
            GenericLoadingDlg GLDg = new GenericLoadingDlg(null,false,"Searching...","Close Dialog to stop");
            GLDg.setVisible(true);
            InspectorDlg idlg = new InspectorDlg(null,false);
            final DoxygenWorker inspectWorker = new DoxygenWorker(searchFor,"",GLDg,0,idlg,this.getToolTipText());
             GLDg.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) 
                {
                    if(inspectWorker.isAlive())
                    inspectWorker.interrupt();
                
                }});
             
            inspectWorker.start();
            
        }
        


    }
     
     
     private void mDefinitionFollowActionPerformed(ActionEvent evt) {
        //String defText = SourceCode.getSelectedText();
        
         
        String searchFor = SourceCode.getSelectedText();

        if (SourceCode.getSelectedText() == null) {
            //(new keyWordSearchDlg(null, true, searchFor, base, ext)).setVisible(true);
        } else {
           //(new FlowDiags.InspectorDlg(null, false, searchFor)).setVisible(true);
            
            GenericLoadingDlg GLDg = new GenericLoadingDlg(null,false,"Call graphs are slow...","Close Dialog to stop");
            GLDg.setVisible(true);
            final DoxygenWorkerCalls inspectWorker = new DoxygenWorkerCalls(searchFor,"",GLDg,"Called by",this.getToolTipText());
             GLDg.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) 
                {
                    if(inspectWorker.isAlive())
                    inspectWorker.interrupt();
                
                }});
             
            inspectWorker.start();
            
        }
        


    }
     
     private void mDefinitionFollowCallsActionPerformed(ActionEvent evt) {
        //String defText = SourceCode.getSelectedText();
        
         
        String searchFor = SourceCode.getSelectedText();

        if (SourceCode.getSelectedText() == null) {
            //(new keyWordSearchDlg(null, true, searchFor, base, ext)).setVisible(true);
        } else {
           //(new FlowDiags.InspectorDlg(null, false, searchFor)).setVisible(true);
            
            GenericLoadingDlg GLDg = new GenericLoadingDlg(null,false,"Call graphs are slow...","Close Dialog to stop");
            GLDg.setVisible(true);
             final DoxygenWorkerCalls inspectWorker = new DoxygenWorkerCalls(searchFor,"",GLDg,"Calls",this.getToolTipText());
             GLDg.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) 
                {
                    if(inspectWorker.isAlive())
                   // inspectWorker.destroy();
                        inspectWorker.stop();
                    
                
                }});
             
            inspectWorker.start();
            
            
           
        }
        


    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        SourceCode = new javax.swing.JEditorPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        Bugs = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();

        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jSplitPane1.setBackground(new java.awt.Color(101, 101, 101));
        jSplitPane1.setDividerLocation(180);
        jSplitPane1.setDividerSize(4);
        jSplitPane1.setForeground(java.awt.Color.gray);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jSplitPane1FocusGained(evt);
            }
        });

        SourceCode.setEditable(false);
        SourceCode.setFont(new java.awt.Font("Lucida Grande", 0, 11));
        SourceCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SourceCodeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(SourceCode);

        jSplitPane1.setRightComponent(jScrollPane1);

        Bugs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        Bugs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BugsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Bugs);

        jSplitPane1.setLeftComponent(jScrollPane2);

        jPanel1.setPreferredSize(new java.awt.Dimension(533, 30));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SourceCodeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SourceCodeMouseClicked
        // TODO add your handling code here:

        if (evt.getButton() == 3 && !org.karma.helper.projectInfo.base.equals("")) {
            if (!Pattern.matches("(c)|(JAVA)|(C\\+\\+)".toLowerCase(), org.karma.helper.projectInfo.languageName.toLowerCase())) {
                mCC.setEnabled(false);
                mCFG.setEnabled(false);
                mAST.setEnabled(false);
                mCS.setEnabled(false);
                mIG.setEnabled(false);
            }
            RCM.show(evt.getComponent(), evt.getX(), evt.getY());
        }

    }//GEN-LAST:event_SourceCodeMouseClicked
    LinkedList<Integer> SearchOffset;
    ListIterator<Integer> litr;
    private void BugsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BugsMouseClicked

        //System.out.println("---->" + this.getHtmlDisplayName());
        if (!((String) Bugs.getValueAt(Bugs.getSelectedRow(), 0)).equals("")) {
            if (SwingUtilities.isRightMouseButton(evt)) {
                JPopupMenu pum = new JPopupMenu();
                JMenuItem dnb = new JMenuItem("Definitely not a bug", new ImageIcon(super.getClass().getResource("definetelyNotBug.png")));
                dnb.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent evt) {
                        dnbActionPerformed(evt, "");
                    }
                });

                dnb.setEnabled(true);
                JMenuItem tnb = new JMenuItem("Teach a NOT bug", new ImageIcon(super.getClass().getResource("teachMeNotBug.png")));
                pum.add(tnb);
                pum.add(dnb);
                pum.show(evt.getComponent(), evt.getX(), evt.getY());
                //   (new DefNotBug(null,true)).setVisible(true);
            } else {
                //System.out.println("---->" + this.Bugs.getValueAt(Bugs.getSelectedRow(), 0));
                int line = Integer.parseInt((String) Bugs.getValueAt(Bugs.getSelectedRow(), 0));

                //System.out.println("Line : " + Bugs.getValueAt(Bugs.getSelectedRow(), 0));
                Document doc = SourceCode.getDocument();
                javax.swing.text.Element elem = doc.getDefaultRootElement();
                // if (elem.getElement(10)==null){System.out.println("NULL-");}
                this.SourceCode.setCaretPosition(elem.getElement(line-1).getStartOffset());
            }
        }

    }//GEN-LAST:event_BugsMouseClicked

    private void jSplitPane1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jSplitPane1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jSplitPane1FocusGained

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
 
    }//GEN-LAST:event_formComponentResized

    private void dnbActionPerformed(ActionEvent evt, String line) {
        (new DefNotBug(null, true)).setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable Bugs;
    public javax.swing.JEditorPane SourceCode;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables

    /**
     * Gets default instance. Do not use directly: reserved for *.settings files only,
     * i.e. deserialization routines; otherwise you could get a non-deserialized instance.
     * To obtain the singleton instance, use {@link #findInstance}.
     */
    /*public static synchronized SourceViewerTopComponent getDefault() {
    if (instance == null) {
    instance = new SourceViewerTopComponent();
    }
    return instance;
    }*/
    /**
     * Obtain the SourceViewerTopComponent instance. Never call {@link #getDefault} directly!
     */
    /*  public static synchronized SourceViewerTopComponent findInstance() {
    TopComponent win = WindowManager.getDefault().findTopComponent(PREFERRED_ID);
    if (win == null) {
    Logger.getLogger(SourceViewerTopComponent.class.getName()).warning(
    "Cannot find " + PREFERRED_ID + " component. It will not be located properly in the window system.");
    return getDefault();
    }
    if (win instanceof SourceViewerTopComponent) {
    return (SourceViewerTopComponent) win;
    }
    Logger.getLogger(SourceViewerTopComponent.class.getName()).warning(
    "There seem to be multiple components with the '" + PREFERRED_ID +
    "' ID. That is a potential source of errors and unexpected behavior.");
    return getDefault();
    }
     */
    @Override
    public int getPersistenceType() {
        return TopComponent.PERSISTENCE_NEVER;
        //return TopComponent.PERSISTENCE_ONLY_OPENED ;
        //return TopComponent.PERSISTENCE_ALWAYS;
    }
    /*
    void writeProperties(java.util.Properties p) {
    // better to version settings since initial version as advocated at
    // http://wiki.apidesign.org/wiki/PropertyFiles
    p.setProperty("version", "1.0");
    // TODO store your settings
    }
     * 
     */
    /*
    Object readProperties(java.util.Properties p) {
    SourceViewerTopComponent singleton = SourceViewerTopComponent.getDefault();
    singleton.readPropertiesImpl(p);
    return singleton;
    }*/
    /*
    private void readPropertiesImpl(java.util.Properties p) {
    String version = p.getProperty("version");
    // TODO read your settings according to their version
    }
     */
    /*  @Override
    protected String preferredID() {
    return PREFERRED_ID;
    }
     */
}
