import java.io.File;
import java.util.Scanner;
import java.io.IOException;


/*
*this Project4 class reads the input file Countries4.cvs, and it creates a binary search treee calling the insert method. Also, it 
*Inorder traverse the tree and print all nodes. Ten it deletes three nodes according to their name, after that, it prints the tree by 
*preorder traverse. Then, it seraches for three nodes according to their name, and if it's found, it prints the GDP per capital. Additonally,
*It prints the number of nodes traversed after finding the node. Then, we it deletes 4 nodes according to their name , and it prints the tree in 
*postorder traversed. Last, It prints the bottom ten and top ten countries regarding to GDP
*@author<Cristian Cedeno>
*@version<11/16/2019>
*/
public class Project4 {
	public static void main(String[] args){

		String scannedName = "";
	    double scannedPopulation = 0;
	    double scannedGDP = 0;
	    double gdpPerCapital = 0;
	    int num = 0;
	    double Australia = 0;
	    double Norway = 0;
	    double Tunisia = 0;
	    double Malawi = 0;
	    double Somalia = 0;
	    double Ireland = 0;
	    double Greece = 0;
	    double Singapore = 0;
	    
	    
		String[] fields = new String[6];
		
		File file = new File("Countries4.csv");
		
		
		BinarySearchTree tree = new BinarySearchTree();
		BinarySearchTree bottonTen = new BinarySearchTree();
		BinarySearchTree topTen = new BinarySearchTree();
		
		try{
		      Scanner input = new Scanner(file);
		      input.useDelimiter( ",|\n" );
	
		      for(int i=0; i<6; i++){
		        fields[i] = input.next();
		      }
	
		      
		      while(input.hasNext()){
		        
		        
		        scannedName = input.next();
		        input.next();
		        input.next();
		        scannedPopulation = input.nextDouble();
		        scannedGDP = input.nextDouble();
		        input.nextInt();
		        
		        if(scannedName.compareTo("Australia")==0) {
		        	Australia = scannedGDP/ scannedPopulation;
		        }else if
		        (scannedName.compareTo("Norway")==0) {
		        	Norway = scannedGDP/ scannedPopulation;
		        }else if
		        (scannedName.compareTo("Tunisia")==0) {
		        	Tunisia = scannedGDP/ scannedPopulation;
		        }else if
		        (scannedName.compareTo("Malawi")==0) {
		        	Malawi = scannedGDP/ scannedPopulation;
		        }else if
		        (scannedName.compareTo("Somalia")==0) {
		        	Somalia = scannedGDP/ scannedPopulation;
		        }else if
		        (scannedName.compareTo("Ireland")==0) {
		        	Ireland = scannedGDP/ scannedPopulation;
		        }else if
		        (scannedName.compareTo("Greece")==0) {
		        	Greece = scannedGDP/ scannedPopulation;
		        }else if
		        (scannedName.compareTo("Singapore")==0) {
		        	Singapore = scannedGDP/ scannedPopulation;
		        }
		        
		        gdpPerCapital = scannedGDP / scannedPopulation;
		        
		        tree.insert(scannedName, gdpPerCapital);
		        bottonTen.insertLowest(scannedName, gdpPerCapital);
		             
		         
		      }
	

		    }catch(IOException exception){
		      System.out.printf("EXCEPTION");
		    }
		
		
		System.out.println("Inorder \nName                GDP Per Capital\n--------------------------------------------------------");
		tree.printInorder(tree.root);
		System.out.print("\n");
		
		tree.delete("Australia");
		tree.delete("Tunisia");
		tree.delete("Norway");
		
		System.out.println("\nPreorder \nName                GDP Per Capital\n--------------------------------------------------------");
		tree.printPreorder(tree.root);
		System.out.print("\n");
		
		tree.find("Sri Lanka");
		System.out.println("Visited: " + tree.visited + " Nodes");
		tree.find("North Cyprus");
		System.out.println("Visited: " + tree.visited + " Nodes");
		tree.find("Tunisia");
		System.out.println("Visited: " + tree.visited + " Nodes");
		
		System.out.print("\n");
		tree.delete("Malawi");
		tree.delete("Somalia");
		tree.delete("Ireland");
		tree.delete("Greece");
		tree.delete("Singapore");
		
		System.out.println("\nPostorder \nName                GDP Per Capital\n--------------------------------------------------------");
		tree.printPostorder(tree.root);
		

		bottonTen.delete(Australia);
		bottonTen.delete(Tunisia);
		bottonTen.delete(Norway);
		
		bottonTen.delete(Malawi);
		bottonTen.delete(Somalia);
		bottonTen.delete(Ireland);
		bottonTen.delete(Greece);
		bottonTen.delete(Singapore);
		
		//bottonTen.printInorder(bottonTen.root);
		bottonTen.printBottonTen();
		bottonTen.printTopTen();
		
		
		
		
		
	}
}
