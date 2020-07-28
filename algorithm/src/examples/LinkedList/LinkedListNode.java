package examples.LinkedList;

//링크드 리스트의 헤더를 데이터가 아닌 링크드 리스트의 시작을 알리는 용도로 만듬
//헤더가 삭제되었을시 헤더의 주소를 가지고 있는 데이터가 없도록 하기를 위함
class LinkedList {
	Node header;
	
	static class Node {
		int data;
		Node next = null;
	}
	
	LinkedList() {
		header = new Node();
	}
	
	//단방향 링크드 리스트에 데이터 추가 
	void append(int d) {
		Node end = new Node();
		//추가할 데이터를 끝 노드의 데이터로 붙인다
		end.data = d;
		Node n = header;
		
		while(n.next != null) {
			n = n.next;
		}
		
		//새롭게 만든 노드가 마지막에 가서 붙는다	
		n.next = end;
	}
	
	
	//단방향 링크드 리스트에 데이터 삭제 
	void delete(int d) {
		Node n = header;
		
		while(n.next != null) {
			if(n.next.data == d) {
				//내 다음 노드를 내 다다음 노드로 바꿈
				n.next = n.next.next;
			}else {
				n = n.next;	
			}
		}
		
	}
	
	void retrieve() {
		Node n = header.next;
		
		while(n.next != null) {
			System.out.print(n.data + " > ");
			n = n.next;
		}
		
		System.out.println(n.data);
	}
	
	
	
}


public class LinkedListNode {
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.retrieve();
		ll.delete(1);
		ll.retrieve();

    }

}
