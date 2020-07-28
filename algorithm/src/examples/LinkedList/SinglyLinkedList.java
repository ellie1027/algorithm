package examples.LinkedList;

class Node {
	
	int data;	
	Node next = null;
	
	Node(int d) {
		this.data = d;
	}
	
	//단방향 링크드 리스트에 데이터 추가 
	void append(int d) {
		Node end = new Node(d);
		Node n = this;
		
		while(n.next != null) {
			n = n.next;
		}
		
		//새롭게 만든 노드가 마지막에 가서 붙는다	
		n.next = end;
	}
	
	
	//단방향 링크드 리스트에 데이터 삭제 
	void delete(int d) {
		Node n = this;
		
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
		Node n = this;
		
		while(n.next != null) {
			System.out.print(n.data + " > ");
			n = n.next;
		}
		
		System.out.println(n.data);
	}
	
}


public class SinglyLinkedList {
	
	public static void main(String[] args) {
		//test
		Node head = new Node(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.retrieve();
		head.delete(2);
		head.retrieve();
    }

}


