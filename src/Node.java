
public class Node<k , v> {
	k  key;
	v  value;
	public Node<k ,v> nextNode;
	
	public  Node(k key, v value) {
		this.key = key;
		this.value = value;	
	}
}
