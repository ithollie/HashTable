import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

class MapObject<K, V> 
{ 

    public ArrayList<Node<K, V>> containerArray; 
    public int container; 
    private int listSize; 
  
    public MapObject() throws IOException 
    { 
        containerArray = new ArrayList<>(); 
        container = 10; 
        listSize = 0; 
        generateEmptyChains();
            
    } 
    
    public  void  writeToFile() throws IOException {
    	
		File file  =  new  File("newFile.txt");
		DataOutputStream out = new DataOutputStream(new FileOutputStream(file));

		Node<K,V>  current = containerArray.get(0);
		if(file.exists()){
			System.out.println("File exists");
		}
		if(current == null) {
			System.out.println("Current is null");
		}
		try {
		
			while(current.nextNode != null) {
				out.writeUTF(current.value.toString());
				current = current.nextNode;
			}
			
		
		}catch(Exception e) {
			System.out.println("The error is " + e.toString());
		}finally {
			out.close();
		}
	}
    public  void  display() {
    	
    		Node<K, V> current = containerArray.get(0);
    		
    		while(current.nextNode != null){
    			int index =  getIndex(current.key);
    			System.out.println("Index is = " + current.key + "  " + "The value is " + current.value);
    		    System.out.println("Next node value "+ current.nextNode.value);
    			current = current.nextNode; 
    		}
    }
    
    public  void  fordisplay() {
       
    	 for (Node<K, V> num :containerArray) {
    		 
    			 System.out.println(num); 		
        }
    }
    //generate  empty chains
    public void  generateEmptyChains() {
    	for(int i = 0;   i < container; i++) {
    		containerArray.add(null); 
    	}
    }
    
    // size  of the  array
    public int size() { 
    	return listSize;
 
    } 
    //check  if  array is empty
    public boolean isEmpty() { 
    	return size() == 0; 
    
    }
  
   
    // get the index of  the key  as an  integer
    private int getIndex(K key) 
    { 
        int index = key.toString().length() % 6; 
      
        return index; 
    } 
  
    //get  value by  index.
    public V getValue(K key) 
    { 
        int index = getIndex(key); 
        Node<K, V> head = containerArray.get(index); 
        while (head != null) 
        { 
            if(head.key.equals(key)) {
            	return head.value; 
            }
            head = head.nextNode;    
        } 
        return null; 
    } 
  
    public void add(K key, V value) 
    { 
        int index = getIndex(key); 
        
        Node<K, V> head = containerArray.get(index); 
  
        while (head != null) 
        { 
            if (head.key.equals(key)) 
            { 
                head.value = value;
                
                return; 
            } 
            head = head.nextNode; 
        } 
  
        head = containerArray.get(index); 
	    Node<K, V> newNode = new Node<K, V>(key, value); 
	    newNode.nextNode = head; 
	    containerArray.set(index, newNode); 
	    listSize++; 
    
    }
}