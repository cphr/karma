/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.karma.helper;

import java.util.Enumeration;
import java.util.regex.Pattern;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author Manos
 */
public class searchJTree {

public DefaultMutableTreeNode  doit(JTree tree,String find){
DefaultMutableTreeNode found =   searchNode(find,tree);
TreePath path  = null;

return found;
}

public DefaultMutableTreeNode  doitRegex(JTree tree,String find){
DefaultMutableTreeNode found =   searchNodeRegex(find,tree);
TreePath path  = null;

return found;
}

public DefaultMutableTreeNode searchNodeRegex(String nodeStr,JTree tree)
    {


        DefaultMutableTreeNode node = null;
        String root = ((DefaultMutableTreeNode)(tree.getModel().getRoot())).toString();
        Enumeration enuma = ((DefaultMutableTreeNode)(tree.getModel().getRoot())).breadthFirstEnumeration();


        //iterate through the enumeration
        while(enuma.hasMoreElements())
        {
            //get the node
            node = (DefaultMutableTreeNode)enuma.nextElement();
            String path="";
            for(int a=0;a<node.getPath().length;a++)
            {
            if (!(node.getPath()[a].toString().indexOf("(")==-1))
            path = path +System.getProperty("file.separator")+node.getPath()[a];
            else
             path = path +node.getPath()[a];
            }
            //match the string with the user-object of the node


            String cleanPath="";
            if ((path.indexOf("(")!=-1))
            {cleanPath = path.substring(0,path.indexOf("("));}
            // System.out.println(cleanPath+" - "+nodeStr);
            //String nodeStrClean = root+nodeStr.substring(projectInfo.base.length());
            //System.out.println(nodeStrClean);
            if(Pattern.matches(nodeStr,cleanPath))
            {
                //tree node with string found
                return node;
            }
        }

        //tree node with string node found return null
        return null;
    }

public DefaultMutableTreeNode searchNode(String nodeStr,JTree tree)
    {


        DefaultMutableTreeNode node = null;
        String root = ((DefaultMutableTreeNode)(tree.getModel().getRoot())).toString();
        Enumeration enuma = ((DefaultMutableTreeNode)(tree.getModel().getRoot())).breadthFirstEnumeration();


        //iterate through the enumeration
        while(enuma.hasMoreElements())
        {
            //get the node
            node = (DefaultMutableTreeNode)enuma.nextElement();
            String path="";
            for(int a=0;a<node.getPath().length;a++)
            {
            if (!(node.getPath()[a].toString().indexOf("(")==-1))
            path = path +System.getProperty("file.separator")+node.getPath()[a];
            else
             path = path +node.getPath()[a];
            }
            //match the string with the user-object of the node
           
            
            String cleanPath="";
            if ((path.indexOf("(")!=-1))
            {cleanPath = path.substring(0,path.indexOf("("));}
             //System.out.println(cleanPath+" - "+root+nodeStr);
            //String nodeStrClean = root+nodeStr.substring(projectInfo.base.length());
            //System.out.println(nodeStrClean);
            if((root+nodeStr).equals(cleanPath))
            {
                //tree node with string found
                return node;
            }
        }

        //tree node with string node found return null
        return null;
    }


public void selectNode(DefaultMutableTreeNode selNode,JTree tree)
    {

        if (selNode != null)
        {
            //get the parent of the selected node
            //MutableTreeNode parent = (MutableTreeNode)(selNode.getParent());
            DefaultTreeModel m_model=  (DefaultTreeModel) tree.getModel() ;
            // if the parent is not null
            TreeNode[] nodes =m_model.getPathToRoot(selNode);
                TreePath path = new TreePath(nodes);
                tree.scrollPathToVisible(path);
                tree.setSelectionPath(path);

                //remove the node from the parent
               
        }
    }
}
