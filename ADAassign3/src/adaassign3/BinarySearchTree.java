/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adaassign3;

/**
 *
 * @author will2
 */
public class BinarySearchTree implements Dictionary {
    //root of binary search tree
    protected Node root;
    
    //sentinal replaces NIL
    protected Node nil;
    
    //Creates a binary search tree with just a NIL node, which is the root
    public BinarySearchTree() {
        setNil(new Node(null));
        root = nil;
    }
    
    //Sets the sentinel NIL to a given node
    protected void setNil(Node node){
        nil = node;
        nil.parent = nil;
        nil.left = nil;
        nil.right = nil;
    }
    
    //Returns true if the given node is the sentinel NIL
    public boolean isNil(Object node){
        return node == nil;
    }
    
    //Traverse the tree in inorder applying a Visitor to each node
    public void inorderWalk(Visitor visitor) {
        inorderWalk(root, visitor);
    }
    
    
    
    
            
    
    
    
    
    
    
    
    
    protected class Node implements Comparable {
        //The data stored in the node
        protected Comparable data;
        //The node's parents
        protected Node parent;
        //left child
        protected Node left;
        //right child 
        protected Node right;
        
        public Node(Comparable data){
            this.data = data;
            parent = nil;
            left = nil;
            right = nil;
        }
        
        //Compares this node to another node. The comparison is based on the 
        //data instance variable of the two nodes 
        //Compare this node to another node
        public int compareTo(Object o){
            return data.compareTo(((Node) o).data);
        }
        
        //Returns the data instance variable of the node in the form of String
        public String toString(){
            if (this == nil) {
                return "nil";
            }else{
                return data.toString();
            }
        }
        
        //Returns a multiline String representation of the subtree rooted at this node
        //representing the depth of each node by 2 spaces per depth preceding the 
        //String representation of the node
        //depth of this node
        public String toString(int depth){
            String result = "";
            
            if (left != nul) {
                result += left.toString(depth + 1);
            }  
            
            for (int i = 0; i < depth; i++) {
                result += " ";
            }
            
            result += toString() + "\n";
            
            if (right != nil) {
                result += right.toString(depth + 1);
            }
            
            return result;
        }
    }
    
    //interface for when we visit a node during a walk
    public interface Visitor {
        //perform some action upon visiting the node
        public Object visit(Object handle);
        
    }
    
    
}
