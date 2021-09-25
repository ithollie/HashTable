import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;



public class Helper {
	
	public String[] testArray;
	public int arraySize;
	public int counter;
	public int testArraySize;
	public MapObject<String ,String> map;
	
	//Helper constructor
	public Helper(int size) throws IOException { 
		this.arraySize =  size;
		this.testArray = new String[size];
		this.testArraySize = 0;
		this.counter = 0;
		this.map =  new MapObject<>();
		tempArray();
	}
	
	//check  same index  function
	public  boolean sameIndex() {
		
		for(int i  = 0;  i <  testArray.length; i++) {
			for(int j = i + 1; j < testArray.length; j++) {
				if(hashFunction(testArray[i]) == hashFunction(testArray[j])) {
					return true;
				}
			}
			
		}
		return false;
	}
	
	//insert data in  the testArray
	public  void tempArray() {
		int temp  = 0;
		try {
		      File myObj = new File("filename2.txt");
		      Scanner myReader = new Scanner(myObj);
		      
		  
		      while(myReader.hasNext()) {
		    	  	testArray[temp] = myReader.next();
		    	  	testArraySize++;
		    	  	temp++;
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		  }
	}
	
	//display  out put 
	public  void displayFileInput() {
		try {
		      File myObj = new File("filename.txt");
		      Scanner myReader = new Scanner(myObj);
		      while(myReader.hasNext()) {
		    	  
		    	  	String data = myReader.next();
		    	  	
		    	  	if(data.isEmpty()) {
		    	  		System.out.println(data);

		    	  	}
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		  }
	}
	
	public   void remove() {
		System.out.println("Node is removed");
	}
	//generate the address
	public int  hashFunction (String str) {
		int len  = str.length();
		return len % testArray.length;
	}
	
	//insert key  valve pair from  the  filename2.txt. to the arrayList 
	public void  insert() {
		
		try {
		      File myObj = new File("filename2.txt");
		      Scanner myReader = new Scanner(myObj);
		     
		      while(myReader.hasNext()) {
		    	    String data = myReader.next();
		    	  	map.add(data,data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		  }
	}
	
}
