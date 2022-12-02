
//This is a small project about the Binary Search Tree.
//As a very useful data structure, the logic of adding notes, deleteing notes and traversing the tree is very interesting.

import java.io.*;
import java.util.*;               

class Node
   {
   public int iData;              // data item (key)
   public double dData;           // data item
   public Node leftChild;         // this node's left child
   public Node rightChild;        // this node's right child

   }  // end class Node  
class Tree
   {
   private Node root;             // first node of tree
   public Node rootgetter() {
	   return root;
   }
// -------------------------------------------------------------
   public Tree()                  // constructor
      { root = null; }            // no nodes in tree yet
// -------------------------------------------------------------
   public Node find(int key)      // find node with given key
      {  Node cur = root;
      
      // (assumes non-empty tree)
      	while (cur.iData!= key) {
      		if(key<cur.iData) {
      			cur=cur.leftChild;
      		}//end of if
      		else {
      			cur= cur.rightChild;	
      		}//end of else
      		if(cur==null) {
      			return null;
      		}
      		
      	}    	
      	return cur;
      }  // end find()
// -------------------------------------------------------------
   public void insert(int id, double dd) //this method inserts a node of (id and dd) into the tree. 
   {
	   Node myNode = new Node();
	   
	   myNode.iData = id;
	   myNode.dData = dd;
	   
	   if (root == null) {
		   root = myNode;
	   }
	   
	   else {
		   Node cur = root;
		   Node temp;
		   
		   while(true) {
			   temp = cur;
			   if(id<cur.iData) {
				   cur = cur.leftChild;
				   if(cur == null) {
					   temp.leftChild = myNode;
					   return;
				   }
				   
			   }
			   
			   else {
				   cur = cur.rightChild;
				   if (cur == null) {
					   temp.rightChild = myNode;
					   return;
				   }
			   }
			   
		   }
	   
	   }
 
      }  // end insert()
//////////////////////////////////////////////////////

   public void traverse(int traverseType) //this method is full implemented see below 
      {
       switch(traverseType)
         {
         case 1: System.out.print("\nPreorder traversal: ");
                 preOrder(root);
                 break;
         case 2: System.out.print("\nInorder traversal:  ");
                 inOrder(root);
                 break;
         case 3: System.out.print("\nPostorder traversal: ");
                 postOrder(root);
                 break;
         }
      System.out.println();
      }
// -------------------------------------------------------------
   private void preOrder(Node localRoot) //implement preOrder traversal
      {
	   if(localRoot != null){
       
		   
       System.out.print(localRoot.iData+" ");
       //System.out.println();
       
       preOrder(localRoot.leftChild);
       preOrder(localRoot.rightChild);
       }
     

      }
// -------------------------------------------------------------
   private void inOrder(Node localRoot) //implement in Order traversal
      {
	   if(localRoot != null){
       
       inOrder(localRoot.leftChild);
       System.out.print(localRoot.iData+" ");
       //System.out.println();
       inOrder(localRoot.rightChild);
       }
      }
// -------------------------------------------------------------
   private void postOrder(Node localRoot) //implement postOrder traversal
      {
	   if(localRoot != null){
       
       postOrder(localRoot.leftChild);
       postOrder(localRoot.rightChild);
       
       System.out.print(localRoot.iData+" ");
       //System.out.println();
       } 
      }
///////////////////////////////////////////////////////////////
    public void isBST(Node localRoot) //this method will take a tree as an input and will PRINT to the screen if the tree is a BST or NOT.
    {
    	//I am going to use three help methods for this program
    	int result = isBSTtest(localRoot);
    	
    	if (result == 1) {
    		System.out.println("It's a BST");
    	}
    	
    	else {
    		System.out.println("It's not a BST");
    	}
    }//end of the method 
    
    public int isBSTtest(Node localRoot) {
    	//1 means is BST
    	//0 means not a bst
    	
    	if (localRoot == null) {
    		return 1;
    	}
    	
        if (localRoot.leftChild != null
            && MaxValue(localRoot.leftChild) > localRoot.iData) {
          return 0;
        }
       
        if (localRoot.rightChild != null
            && MinValue(localRoot.rightChild) < localRoot.iData) {
          return 0;
        }
       
        if (isBSTtest(localRoot.leftChild) != 1
            || isBSTtest(localRoot.rightChild) != 1) {
          return 0;
        }
        return 1;
    	
    }   
    public int MaxValue(Node localRoot) {
    	
    
    	if (localRoot == null) {
    	      return Integer.MIN_VALUE;
    	    }
    	    int value = localRoot.iData;
    	    int leftMax = MaxValue(localRoot.leftChild);
    	    int rightMax = MaxValue(localRoot.rightChild);
    	 
    	    return Math.max(value, Math.max(leftMax, rightMax));
    }
    
    public int MinValue(Node localRoot) {
    	if (localRoot == null) {
    	      return Integer.MAX_VALUE;
    	    }
    	    int value = localRoot.iData;
    	    int leftMax = MinValue(localRoot.leftChild);
    	    int rightMax = MinValue(localRoot.rightChild);
    	 
    	    return Math.min(value, Math.min(leftMax, rightMax));
    }
   
// -------------------------------------------------------------  
    public boolean delete (int key) {
 	   
 	   while(deleteDetect(key)!= false) {
 		   OnceDelete(key);
 	   }
 	   return true;
    }
     
     public boolean deleteDetect(int key) {
     	
     	// delete node with given key (iData) (if there are multiple nodes match key
     	// with iData you have to delete all of them.
     	
     	Node deleteNode = find(key);
     	if (deleteNode == null) {
     		
     		return false;
     	} 
     	else {
     		
     		
     		
     		return true;
     		}//end of elsed
     		
     	}//end of delete

     public void OnceDelete(int key) { // (assumes non-empty list)
     	
     	Node Cur = root;
     	Node Temp = root;
     	
     	boolean isLeftChild=true;
     	while (Cur != null) {
     		
     		
 			if (Cur.iData < key) {
 			Temp = Cur;
 			Cur = Cur.rightChild;
 			isLeftChild = false;
 					}//end of if
 			
 			else if (Cur.iData > key) {
 				
 				Temp = Cur;
 				Cur = Cur.leftChild;
 				isLeftChild = true;
 				
 				} //end of else if
 			
 			else {
 				
 				if (Cur.leftChild == null && Cur.rightChild == null) {
 				if(Cur==root) {
 				this.root = null;
 				return;
 				}
 				
 			if(isLeftChild==true) {
 			Temp.leftChild = null;
 			}
 			else {
 			Temp.rightChild = null;
 			}
 			return;			
 								}
 				
 			else if(Cur.leftChild==null && Cur.rightChild!=null) {
 				
 				
 				if(Cur==root) {
 				this.root = Cur.rightChild;
 				}
 				else {
 					
 					if(isLeftChild) {
 					Temp.leftChild = Cur.rightChild;
 					}
 				else {
 				Temp.rightChild = Cur.rightChild;
 				}//end of else
 				
 				}//end of outer else
 				return;
 }//end of else if 
 			
 			else if(Cur.leftChild!=null && Cur.rightChild==null) {								
 				if(Cur==root) {
 					this.root = Cur.leftChild;
 					}
 				else {
 					
 					if(isLeftChild) {
 					Temp.leftChild = Cur.leftChild;
 					}
 				else {
 					Temp.rightChild = Cur.leftChild;
 					}//end of else
 				
 				}//end of outer else
 				return;
 	}			
 			else {
 	
 				Node Parent = Cur.leftChild;
 				Node SpecialP = Cur;
 				if (Parent.leftChild == null & Parent.rightChild == null) {
 					Parent.rightChild = SpecialP.rightChild;
 				}
 				else {
 			
 				
 				while(Parent.rightChild!=null) {
 					
 					SpecialP = Parent;
 					Parent = Parent.rightChild;
 				}
 				
 				SpecialP.rightChild = Parent.leftChild;
 				Parent.leftChild = Cur.leftChild;
 				Parent.rightChild = Cur.rightChild;

 				}
 				if(Cur==root) {
 					
 					this.root = Parent;
 				}
 				else {
 					
 					if(isLeftChild) {
 					Temp.leftChild = Parent;
 					}
 					else {
 					Temp.rightChild = Parent;
 						}
 					
 					}//end of else
 				return;
 				}//end of else
 			}

     	}    	
 } // end deleteOnce

// -------------------------------------------------------------
   public void displayTreeLevels() // this method will display the nodes at each level in the tree. (The method should print the nodes (id) as: Level1:.... - Level2:... 
      {
	   
	  Node curroot = root;
      int myHeight = height(curroot);
      
      for (int i = 1; i<= myHeight;i++) {
    	  System.out.print("level "+i+": ");
    	  EachLevel(curroot,i);
    	  System.out.println();
      }
      System.out.println();
      }  // end displayTreeLevels()

   
   public int height(Node localroot) {
   
       if (localroot == null) {
           return 0;
       }
       else {
           /* compute height of each subtree */
           int leftheight = height(localroot.leftChild);
           int rightheight = height(localroot.rightChild);

           /* use the larger one */
           if (leftheight > rightheight) {
               return (leftheight)+1;
           }
           else {
               return (rightheight)+1;
           }
       }
   }//end of height method
   
   public void EachLevel(Node localroot, int lv){
   
       if (localroot == null) {
           return;}
       
       if (lv == 1) {
           System.out.print(localroot.iData + " ");
       }
       else {
    	   EachLevel(localroot.leftChild, lv - 1);
    	   EachLevel(localroot.rightChild, lv - 1);
       }
   }

  }// end class Tree

////////////////////////////////////////////////////////////////
class TreesApplication
   {
   public static void main(String[] args) throws IOException
      {
      
      Tree theTree = new Tree();
      theTree.insert(50, 1.5);
      theTree.insert(25, 1.2);
      theTree.insert(75, 1.7);
      theTree.insert(12, 1.5);
      theTree.insert(37, 1.2);
      theTree.insert(43, 1.7);
      theTree.insert(30, 1.5);
      theTree.insert(33, 1.2);
      theTree.insert(87, 1.7);
      theTree.insert(93, 1.5);
      theTree.insert(97, 1.5);
      
      theTree.displayTreeLevels();// display trees by level works
      
      theTree.traverse(1);
      theTree.traverse(2);
      theTree.traverse(3);
    
      //delete a node with repetitive values, for instance: 50
      theTree.delete(50);
      theTree.displayTreeLevels();
   
      theTree.isBST(theTree.rootgetter());//isBST, works

	
// -------------------------------------------------------------
   }
}  // end class TreeApp
