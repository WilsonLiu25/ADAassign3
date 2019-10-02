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
    public void inorderWalk(Visitor visitor){
        inorderWalk(root, visitor);
    }
    
    protected void inorderWalk(Node x, Visitor visitor) {
        if (x != nil) {
            inorderWalk(x.left, visitor);
            visitor.visit(x);
            inorderWalk(x.right, visitor);
        }
    }
    
    public void preorderWalk(Visitor visitor) {
        preorderWalk(root, visitor);
    }
    
    protected void preorderWalk(Node x, Visitor visitor) {
        if (x != nil) {
            visitor.visit(x);
            preorderWalk(x.left,visitor);
            preorderWalk(x.right,visitor);
        }
    }
    
    public void postorderWalk(Visitor visitor) {
        postorderWalk(root, visitor);
    }
    
    protected void postorderWalk(Node x, Visitor visitor){
        if (x != nil) {
            postorderWalk(x.left,visitor);
            postorderWalk(x.left, visitor);
            visitor.visit(x);
        }
    }
    
    //returns a multiline String representation of the tree, representing the depth
    //of each node by two spaces per depth preceding the String representation of the node
    public String toString(){
        return root.toString(0);
    }
    
    public Object search(Comparable k) {
        return search(root, k);
    }
    
    //Searches the subtree rooted at a given node for a node with a given key
    protected Object search(Node x, Comparable k) {
        int c;
        
        if (x == nil || (c = k.compareTo(x.data)) == 0) {
            return x;
        }
        
        if (c < 0) {
            return search(x.left, k);
        }else {
            return search(x.right, k);
        }
    }
    
    //Searches the tree for a node with a given key
    public Object iterativeSearch(Comparable k) {
        Node x = root;
        int c;
        
        while (x != nil && (c = k.compareTo(x.data)) != 0) {
            if (c < 0) {
                x = x.left; 
            } else {
                x = x.right;
            }
        }
        
        return x;
    }
    
    //returns the node with the minimum key in the tree
    public Object minimum() {
        return treeMinimum(root);
    }
    
    protected Object treeMinimum(Node x) {
        while (x.left != nil) {
            x = x.left;
        }
        
        return x;
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
