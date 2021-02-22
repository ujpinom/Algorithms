package stacksandqueue;

public class LinkedStacksOfStrings {
	
	private Node first=null;
	
	class Node{
		String item;
		Node next;
	
	}
	
	public boolean isEmpty() {
		return first==null;
	}
	
	public void push(String item) {
		
		Node oldenode=first;
		first=new Node();
		first.item=item;
		first.next=oldenode;
	}
	
	public String  pop() {
		
		String item=first.item;
		first=first.next;
		return item;
		
	}
	
}
