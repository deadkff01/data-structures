/**
 * Simple linked list
 * 
 * 
 * @author Dennis Kaffer
 * **/

public class LinkedList<T extends Comparable<T>> {

	private Node<T> head; 
	private Node<T> tail; 
	private int size;


	public void add(T data){
		Node<T> newNode = new Node<>(data);
		newNode.setNext(head);
		head = newNode;

		if (tail == null){
			tail = head;
		}
		size++;
	}

	public void add(Node<T> newNode, Node<T> prev){
		if (prev == tail) {
			tail.setNext((Node<T>)newNode);
			tail = newNode;
		} else {
			newNode.setNext(prev.getNext());
			prev.setNext(newNode);
		}
		size++;
	}

	public void append(Node<T> novo){
		tail.setNext(novo);
		tail = novo;
		
		size++;
	}
 
		

	public boolean find(T data){
		Node<T> toFind = new Node<>(data);
		Node<T> cur = getHead();
		Node<T> prev = null;
		
		try{
		 if(!isEmpty()){
		  while(cur.getData() != toFind.getData()){
			
			prev = cur;
			cur = cur.getNext();
		  }
			if(cur.getData() == toFind.getData())
				return true;
		
		 }
		}catch(Exception e){
		System.out.println("Does not have this value ("+data+") in list..");
		return false;
			
		}
		return false;
	}
	
	
	public void remove(T data){
		Node<T> toRemove = new Node<>(data);
		Node<T> cur = getHead();
		Node<T> prev = null;
		
		try{
		 if(!isEmpty()){
		  while(cur.getData() != toRemove.getData()){
			
			prev = cur;
			cur = cur.getNext();
		  }
			if(cur.getData() == toRemove.getData()){
				if(getSize() == 1){
					head = tail = null;
				}else{
					if(cur == getHead())
					head = cur.getNext();
					else
						prev.setNext(cur.getNext());
			  }
			}
		 }
		}catch(Exception e){
			System.out.println("Does not have this value ("+data+") in list..");
			
		}
	}
	
	
	
	
	public Node<T> getHead(){
		return head;
	}
	public int getSize() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}

	
	public String toString(){
		StringBuilder tmp = new StringBuilder("List: [");
		Node<T> temp = head;
		while(temp != null){
			tmp.append(temp);
			temp = temp.next;
		}
		tmp.append("]");
		return tmp.toString();
		
	}

}