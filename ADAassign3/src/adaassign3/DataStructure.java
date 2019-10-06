/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adaassign3;

import java.awt.Color;

/**
 *
 * @author will2
 */
public class DataStructure extends BinarySearchTree{
    protected static final Color RED = Color.red;
    protected static final Color BLACK = Color.black;
    
    //create a redblack tree with just a single node with is the root node
    public DataStructure() {
        setNil(new Node(null));
        root = nil;
    }
    
    //set the sentinel node to a given node, and make the sentinel black
    public void setNil(Node node) {
        node.color = BLACK;
        super.setNil(node);
    }
    
    //performs a left rotation on a node, making a node's right child its parent 
   protected void leftRotate(Node x) {
       Node y = (Node)
   }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    protected class Node extends BinarySearchTree.Node{
        //this nodes color, red of black
        protected Color color;
        
        //Initialises a node with the data, nades other pointers nil and makes the node red
        public Node(Comparable data) {
            super(data);
            this.color = RED;
        }
        
        //
        public String toString() {
            return super.toString() + ", " + (color == RED ? "red" : "black");
        }
        
    }
    
    
    
    
}
