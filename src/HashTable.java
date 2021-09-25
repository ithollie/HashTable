import java.io.IOException;
import java.util.ArrayList;
//time complexity is O(n).
public class HashTable {
	
	//The  main function 
	public static void main(String[] args) throws IOException {
	
		
		//hasTable instance
		Helper hashTable = new Helper(205);
		MapObject<Integer, String> map =  new MapObject<>();
		
		System.out.println("There is a collision so  it is good to use chaining ==" + hashTable.sameIndex());
		
		//check  if  two indexes are  the same  if so  go ahead  an  insert  in  to  arraylist
		if(hashTable.sameIndex() == true){
			hashTable.insert();
		}
		if(hashTable.sameIndex() == false){
			System.out.println("There no  two element are equal");
		}
		
		System.out.println("Linked List size " +  hashTable.map.size()); 
        System.out.println("Searched word is " + hashTable.map.getValue("Religion")); 
        System.out.println(hashTable.map.size());
        
        System.out.println(" ");
        System.out.println("<---- Displaying the ArrayList ---->");
        hashTable.map.display();
        System.out.println("<----- End  of ArrayList---->");
        System.out.println("   ");

        System.out.println("Storing strings   in  newFile.txt");
        map.writeToFile();
        
        System.out.println("ArrayList is empty ="  + hashTable.map.isEmpty()); 
        
        
		System.out.println("End of  programe");
	}

}
