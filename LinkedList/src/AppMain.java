/**
 * main class
 * 
 * 
 * @author Dennis Kaffer
 * **/
public class AppMain {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();

		list.add(1);
		list.add(0);
		list.add(2);
		list.add(4);
		
		list.remove(2);
			
		System.out.println(list.find(0));
		System.out.println(list.find(9));
		
		System.out.println(list);
		System.out.println("List head = "+ list.getHead());
		
		
		OrderedList<Integer> orderedList = new OrderedList<Integer>();
		
		orderedList.add(1);
		orderedList.add(0);
		orderedList.add(2);
		orderedList.add(4);
		orderedList.remove(0);
	
		System.out.println(orderedList.find(1));
		System.out.println(orderedList.find(0));

     	System.out.println(orderedList);
		System.out.println("List head = "+ orderedList.getHead());
	}
}
