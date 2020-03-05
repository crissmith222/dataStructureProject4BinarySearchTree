 /*
*this BinarySearchTree class creates an empty tree with a no-parameter
*constructor. It has the insert method which inserts a node according to their name. Indeed, 
*it contains the method for finding and deleting a node in the tree according to the name. This class, also, contains 
*three methods the would print the tree in preoder, postorder, and inorder traverse. Also, it 
*has 2 mehtods that would print the bottom ten and top ten nodes according to the GDP per capital.
*Last,  it contains another class that creates nodes and references other other nodes on the tree like the right and left child.  
*@author<Cristian Cedeno>
*@version<11/16/2019>
*/
public class BinarySearchTree {
	
	/*
	*this Node class creates by using a node constructor with name and the GDP per capital as parameters.
	*Also, it has the references for their left child and right child on the tree. Last, it includes the printNode 
	*methods which prints the nodes name and GDP per capital.  
	*@author<Cristian Cedeno>
	*@version<11/16/2019>
	*/
	private class Node {
		 String name;
		 double gdpPerCapital;
		 Node leftChild;
		 Node rightChild;
		 
		 
		 public Node(String name, double gdpPerCapital) {
			 this.name = name;
			 this.gdpPerCapital = gdpPerCapital;
		 }
		 
		 
		 public void printNode() {
			 System.out.printf("%-25s%,-20.2f\n", name, gdpPerCapital);
		 }
	}
	
	
	int visited;
	
	public Node root;
	
	Node[] nodeArray = new Node[155];
	
	public BinarySearchTree() {
		root = null;
	}
	
	
	/*this method inserts a new node into the tree. I inserts the nodes on the tree according to the
	 * name parameter, it goes left if it less the the current node , and it goes right
	 * if its greater than the current node.
	 *@param name contains the string value of the node's name
	 *@param gdpPerCapital contains the double value of the GDP per capital
	 **/
	public void insert(String name, double gdpPerCapital) {
		Node newNode = new Node(name, gdpPerCapital);
		//newNode.name = name;
		//newNode.gdpPerCapital = gdpPerCapital;
		if(root == null) {
			root = newNode;
		}else {
			Node now = root;
			Node parent;
			
			while(true) {
				parent = now;
				
				if( 0 > name.compareToIgnoreCase(now.name)){
					now = now.leftChild;
					if(now == null) {
						parent.leftChild = newNode;
						return;
					}
					
				}else {
					now = now.rightChild;
					if(now == null) {
						parent.rightChild = newNode;
						return;
					}
				}
				
			}
		}
		
		
	}
	
	
	/*this printInorder method will traverse the tree in a inorder traversal
	 * (LNR), and it prints every single node
	 *@param currentRoot it references to the current root of the tree 
	 **/
	public void printInorder(Node currentRoot) {
		
		
		if(currentRoot != null) {
			
			printInorder(currentRoot.leftChild);
			currentRoot.printNode();
			printInorder(currentRoot.rightChild);
		}
			
			
	}
	
	/*this printPreorder method will traverse the tree in a preorder traversal 
	 * (NLR), and it prints every single node
	 *@param currentRoot it references to the current root of the tree 
	 **/
	public void printPreorder(Node currentRoot) {
			
			
			if(currentRoot != null) {
				
				currentRoot.printNode();
				printPreorder(currentRoot.leftChild);
				printPreorder(currentRoot.rightChild);
			}
				
				
		}

	
	/*this printPostorder method will traverse the tree in a postorder traversal
	 * (LRN), and it prints every single node
	 *@param currentRoot it references to the current root of the tree 
	 **/
	public void printPostorder(Node currentRoot) {
		
		
		if(currentRoot != null) {
			
			
			printPostorder(currentRoot.leftChild);
			printPostorder(currentRoot.rightChild);
			currentRoot.printNode();
		}
			
			
	}



	/*this find method searches in the tree for a country according to 
	 * the giving name value, and when it's found ,it returns the GDP 
	 * per capital, and when it's not it returns a negative one 
	 *@param name the string value of name 
	 **/
	public void find(String name) {
		Node current = root;
		visited = 0;
		
		while(name.compareToIgnoreCase(current.name) != 0) {
			visited ++; 
			if(0  > name.compareToIgnoreCase(current.name)) {
				current = current.leftChild;
				
			}else {
				current = current.rightChild;
				
			}
			
			if(current == null) {
				System.out.println(-1 + ": " + name + " was not found.");
				return;
				
			}
			
				
		}
		
		System.out.println(current.name + " is found with GDP per Capita "  + current.gdpPerCapital);
	}
	
	
	/*this printBootomTen method finds the bottom ten countries according to the 
	 * GDP per capital, and it prints only the bottom Ten Countries with the lowest
	 * number
	 **/
	public void printBottonTen() {
		
		printLowest(root);
		
		System.out.println("\nBOTTON 10 \nName                GDP Per Capital\n---------------------------------------");
		for(int i =0; i<10; i++) {
			nodeArray[i].printNode();
		}
	}
	
	
	/*this printTopTen method finds the top ten countries according to the 
	 * GDP per capital, and it prints only the top Ten Countries with the highest
	 * number
	 **/
	public void printTopTen() {
			
		//printLowest(root);
		
		System.out.println("\nTOP 10 \nName                GDP Per Capital\n---------------------------------------");

		for(int j=146; j>136; j--) {
			nodeArray[j].printNode();
		}
	}
	
	
	
	
	
	
	int count = 0;
	/*this printLowest method will traverse throgh the tree and insert it 
	 * into and array which will be used to sort the nodes according to 
	 * the GDP per capital
	 * @param currentRoot references to the currnt root in the tree
	 **/
	public void printLowest(Node currentRoot) {
		
			
			if(currentRoot != null) {
				
				printLowest(currentRoot.leftChild);
				nodeArray[count] = currentRoot;
				count++;
				printLowest(currentRoot.rightChild);
			}
				
	}
	
	
	/*This InsertLowest method inserts nodes into the tree according
	 * to their GDP per capital. It compares the GDP per capital to the 
	 * current node, and if it's lower ,it goes to the left child, or
	 * if it's higher it goes to the right child
	 * @param name has the string value of the node's name
	 * @param gdpPerCapital has the dobule value of the node's gdp per capital 
	 **/
	public void insertLowest(String name, double gdpPerCapital) {
		Node newNode = new Node(name, gdpPerCapital);
		//newNode.name = name;
		//newNode.gdpPerCapital = gdpPerCapital;
		if(root == null) {
			root = newNode;
		}else {
			Node now = root;
			Node parent;
			
			while(true) {
				parent = now;
				
				if(  gdpPerCapital < now.gdpPerCapital){
					now = now.leftChild;
					if(now == null) {
						parent.leftChild = newNode;
						return;
					}
					
				}else {
					now = now.rightChild;
					if(now == null) {
						parent.rightChild = newNode;
						return;
					}
				}
				
			}
		}
		
		
	}
	
	
	
	/*this delete mehtod deletes a node on the tree according to the 
	 * giving name and it will rearange the tree's nodes if necessary.
	 * @param name has the string value of the node's name
	 **/
	public void delete(String name) {
		Node now = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		while(name.compareToIgnoreCase(now.name) != 0) {
			parent = now;
			
			if(name.compareToIgnoreCase(now.name) < 0) {
				isLeftChild = true;
				now = now.leftChild;
			}else {
				isLeftChild = false;
				now = now.rightChild;
			}
			
			if(now == null) {
				return;
			}
		}//end of while
		
		System.out.println(name + " has been deleted from the tree.");
		//if no children, simply delete it
		if(now.leftChild == null && now.rightChild == null) {
			if(now == root) {
				root = null;
			}else if(isLeftChild) {
				parent.leftChild = null;
			}else {
				parent.rightChild = null;
			}
		//if no right child, replace with left subtree
		}else if(now.rightChild == null) {
			if(now == root) {
				root = now.leftChild;
			}else if(isLeftChild) {
				parent.leftChild = now.leftChild;
			}else {
				parent.rightChild = now.leftChild;
			}
		//if no left child, replace with right subtree
		}else if(now.leftChild == null) {
			if(now == root) {
				root = now.rightChild;
			}else if(isLeftChild) {
				parent.leftChild = now.rightChild;
			}else {
				parent.rightChild = now.rightChild;
			}
		//two children, so replace with inorder successor
		}else {
			Node successor = getSuccessor(now);
			
			if(now == root) {
				root = successor;
			}else if(isLeftChild) {
				parent.leftChild = successor;
			}else {
				parent.rightChild = successor;
			}
			successor.leftChild = now.leftChild;
		}//end else two children
		
		
	}//end of delet()
	
	
	/*this method finds the successor of the tree when a node
	 * needs to be deleted, and it returns the node that that is 
	 * the successor
	 * @return the reference of the node's succesor
	 **/
	private Node getSuccessor(Node deleteNode) {
		Node successorParent = deleteNode;
		Node successor = deleteNode;
		Node now = deleteNode.rightChild;
		
		while(now != null) {
			successorParent = successor;
			successor = now;
			now = now.leftChild;
		}
		
		if(successor != deleteNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = deleteNode.rightChild;
		}
		
		return successor;
	}
	
	
	/*this delete mehtod deletes a node on the tree according to the 
	 * giving GDP per capital and it will rearange the tree's nodes if necessary.
	 * @param GDP has the double value of the GPD per capitals
	 **/
	public void delete(double GDP) {
		Node now = root;
		Node parent = root;
		boolean isLeftChild = true;
		while(now.gdpPerCapital != GDP) {
			parent = now;
			if(GDP < now.gdpPerCapital) {
				isLeftChild = true;
				now = now.leftChild;
			}else {
				isLeftChild = false;
				now = now.rightChild;
			}
			
			if(now == null) {
				System.out.println("NOT FOUND");
				return;
			}
		}//end of while
		
		
		//if no children, simply delete it
		if(now.leftChild == null && now.rightChild == null) {
			if(now == root) {
				root = null;
			}else if(isLeftChild) {
				parent.leftChild = null;
			}else {
				parent.rightChild = null;
			}
		//if no right child, replace with left subtree
		}else if(now.rightChild == null) {
			if(now == root) {
				root = now.leftChild;
			}else if(isLeftChild) {
				parent.leftChild = now.leftChild;
			}else {
				parent.rightChild = now.leftChild;
			}
		//if no left child, replace with right subtree
		}else if(now.leftChild == null) {
			if(now == root) {
				root = now.rightChild;
			}else if(isLeftChild) {
				parent.leftChild = now.rightChild;
			}else {
				parent.rightChild = now.rightChild;
			}
		//two children, so replace with inorder successor
		}else {
			Node successor = getSuccessor(now);
			
			if(now == root) {
				root = successor;
			}else if(isLeftChild) {
				parent.leftChild = successor;
			}else {
				parent.rightChild = successor;
			}
			successor.leftChild = now.leftChild;
		}//end else two children
		
		
	}//end of delet()
	
	
	
}
