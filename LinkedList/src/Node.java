/**
 * Node class
 * 
 * 
 * @author Dennis Kaffer
 * **/

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
	
	public T data;
	public Node<T> next;
	public Node<T> prev;
	
	public Node(){
		setData(null);
		setNext(null);
		
	}
		public Node(T data){
			this.setData(data);
			this.setNext(null);
			
		}
		
		
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public Node<T> getNext() {
			return next;
		}
		public void setNext(Node<T> next) {
			this.next = next;
		}
		public Node<T> getPrev() {
			return prev;
		}
		public void setPrev(Node<T> prev) {
			this.prev = prev;
		}
		
		 public String toString(){
			    StringBuilder tmp = new StringBuilder("Node [");
			      tmp.append(this.data);
			    tmp.append(']');
		
			    return tmp.toString();
			  }
		 @Override
			public int compareTo(Node<T> nodo) {
				return data.compareTo(nodo.getData());
			}

}
