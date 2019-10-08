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
        
        System.out.println("DataStructure Object is made");
    }
    
    //set the sentinel node to a given node, and make the sentinel black
    public void setNil(Node node) {
        node.color = BLACK;
        super.setNil(node);
    }
    
    //performs a left rotation on a node, making a node's right child its parent 
   protected void leftRotate(Node x) {
       Node y = (Node) x.right;
       
       //swap the inbetween subtree from y to x.
       x.right = y.left;
       if (y.left != nil) {
           y.left.parent = x;
       }
       
       //make y the root of the subtree for which x was the root
       y.parent = x.parent;
       
       //if x is the root of the entire tree, make y the root.
       //Otherwise, make y the correct child of the subtree's parent
       if (x.parent == nil) {
           root = y;
       } else {
           if (x == x.parent.left) {
               x.parent.left = y;
           } else {
               x.parent.right = y;
           }
       }
       
       //relink x and y
       y.left = x;
       x.parent = y;
       
   }
   
   //performs a right rotation on a node, making the node's left child its parent
   protected void rightRotate(Node x) {
       Node y = (Node) x.left;
       
       x.left = y.right;
       if (x.left != null) {
           y.right.parent = x;
       }
       
       y.parent = x.parent;
       
       y.right = x;
       x.parent = y;
       
       if (root == x) {
           root = y;
       } else {
           if (y.parent.left == x) {
               y.parent.left = y;
           } else {
               y.parent.right = y;
           } 
       }
   }
   
   //inserts data into the tree, creating a new node for this data
   public Object insert(Comparable data){
       Node z = new Node(data);
       treeInsert(z);
       
       System.out.println(z);
       return z;
   }
   
   //inserts a node into the tree
   protected void treeInsert(Node z) {
       super.treeInsert(z);
       insertFixup(z);
   }
   
   //retores the red-blck conditions of the tree after inserting a node
   protected void insertFixup(Node z) {
       Node y = null;
       
       while(((Node) z.parent).color == RED) {
           if (z.parent == z.parent.parent.left) {
               y = (Node) z.parent.parent.right;
               
               if (y.color == RED) {
                   ((Node) z.parent).color = BLACK;
                   y.color = BLACK;
                   ((Node) z.parent.parent).color = RED;
                   z = (Node) z.parent.parent;
               } else {
                   if (z == z.parent.right) {
                       z = (Node) z.parent;
                       leftRotate(z); 
                   }
                   
                   ((Node) z.parent).color = BLACK;
                   ((Node) z.parent.parent).color = RED;
                   rightRotate((Node) z.parent.parent);
               }
           } else {
               y = (Node) z.parent.parent.left;
               if (y.color == RED) {
                   ((Node) z.parent).color = BLACK;
                   y.color = BLACK;
                   ((Node) z.parent.parent).color = RED;
                   z = (Node) z.parent.parent;
               } else {
                   if (z == z.parent.left) {
                       z = (Node) z.parent;
                       rightRotate(z);
                   }
                   
                   ((Node) z.parent).color = BLACK;
                   ((Node) z.parent.parent).color = RED;
                   leftRotate((Node) z.parent.parent);
               }
           }
       }
       
       ((Node) root).color = BLACK;
   }
   
   //Removes a node from the tree
   public void delete(Object handle) {
       Node z = (Node) handle;
       Node y = z;
       Node x = (Node) nil;
       
       //do not allow the sentinel to be deleted
       if(z == nil) {
           //throw new DeleteSentinelException();
           System.out.println("there was an attempt to delete the sentinel");
       }
       
       if (z.left != nil && z.right != nil) {
           y = (Node) successor(z);
       }
       
       if (z.left != nil) {
           x = (Node) y.left;
       } else {
           x = (Node) y.right;
       }
       
       x.parent = y.parent;
       
       if (y.parent == nil) {
           root = x; 
       } else if (y == y.parent.left) {
           y.parent.left = x; 
       } else {
           y.parent.right = x;
       }
       
       if (y != z) {
           y.left = z.left;
           y.left.parent = y;
           y.right = z.right;
           y.right.parent = y;
           y.parent = z.parent;
           
           if (z == root) {
               root = y;
           } else if (z == z.parent.left) {
               z.parent.left = y;
           } else {
               z.parent.right = y;
           }
       }
       
       if (y.color == BLACK) {
           DeleteFixup(x);
       }
   }
   
   //retores the red=black properties of the tree after a deletion
   protected void DeleteFixup(Node x) {
        while (x != root && x.color == BLACK) {
            if (x.parent.left == x) {
                Node w = (Node) x.parent.right;

                if (w.color == RED) {
                    w.color = BLACK;
                    ((Node) x.parent).color = RED;
                    leftRotate((Node) x.parent);
                    w = (Node) x.parent.right;
                }

                if (((Node) w.left).color == BLACK
                        && ((Node) w.right).color == BLACK) {
                    w.color = RED;
                    x = (Node) x.parent;
                } else {
                    if (((Node) w.right).color == BLACK) {
                        ((Node) w.left).color = BLACK;
                        w.color = RED;
                        rightRotate(w);
                        w = (Node) x.parent.right;
                    }

                    w.color = ((Node) x.parent).color;
                    ((Node) x.parent).color = BLACK;
                    ((Node) w.right).color = BLACK;
                    leftRotate((Node) x.parent);
                    x = (Node) root;
                }
            } else {
                Node w = (Node) x.parent.left;

                if (w.color == RED) {
                    w.color = BLACK;
                    ((Node) x.parent).color = RED;
                    rightRotate((Node) x.parent);
                    w = (Node) x.parent.left;
                }

                if (((Node) w.right).color == BLACK
                        && ((Node) w.left).color == BLACK) {
                    w.color = RED;
                    x = (Node) x.parent;
                } else {
                    if (((Node) w.left).color == BLACK) {
                        ((Node) w.right).color = BLACK;
                        w.color = RED;
                        leftRotate(w);
                        w = (Node) x.parent.left;
                    }

                    w.color = ((Node) x.parent).color;
                    ((Node) x.parent).color = BLACK;
                    ((Node) w.left).color = BLACK;
                    rightRotate((Node) x.parent);
                    x = (Node) root;
                }
            }
        }
        x.color = BLACK;
    }
   
   //returns the number of black nodse from a given node down to any leaf
   //The values should be the same for all paths
   public int blackHeight(Node z) {
        if (z == nil) {
            return 0;
        }

        int left = blackHeight((Node) z.left);
        int right = blackHeight((Node) z.right);
        if (left == right) {
            if (z.color == BLACK) {
                return left + 1;
            } else {
                return left;
            }
        } else {
            //throw new BlackHeightException();
            System.out.println("Thrown BlackHeightException");
        }
    }
    
   //returns the number of black nodes from the root down to any leaf.
   //The value should be the same for all paths.
   public int blackHeight() {
       return blackHeight((Node) root);
   }
   
    protected class Node extends BinarySearchTree.Node{
        //this nodes color, red of black
        protected Color color;
        
        //Initialises a node with the data, nades other pointers nil and makes the node red
        public Node(Comparable data) {
            super(data);
            this.color = RED;
        }
        
        public String toString() {
            return super.toString() + ", " + (color == RED ? "red" : "black");
        }
        
    }
    
    //if data is contained in the node, return true
    public boolean contains(Comparable data){
        Node current = (Node) root;
        
        if (containsInNode(current, data)) {
            return true;
        } else {
            return false;
        }
    }
    
    //searches the tree for contains, return true if contains data is found
    private boolean containsInNode(Node x, Comparable data) {
        if (x != nil) {
            if (x.compareTo(new BinarySearchTree.Node(data)) == 0) {
                return true;
            }
        }

        return false;
    }
    
    //finds the gap between 2 smallest nodes
    public int minGap(Node x, Node y){
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        
        //TODO: Finish off. Add minGap(node, data)
        
    }
    
}
