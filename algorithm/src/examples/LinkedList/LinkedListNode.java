package examples.LinkedList;

import examples.LinkedList.LinkedList.Node;

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
	
	public Node get(int c) {
		Node n = header;
		for(int i = 0; i < c; i++) {
			n = n.next;
		}
		return n;
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
	
	//링크드리스트 예제
	//정렬되지 않은 링크드리스트의 중복값 제거하기(단, 버퍼 x)
	//포인터 사용하여 구현해보기
	//중복 제거 함수
	//버퍼 사용 하는 것보다 시간은 더 많이 들지만 공간 효율성이 우수
	void removeDups() {  
		Node n = header;
		while(n != null && n.next != null) {
			Node r = n;
			while(r.next != null) {
				if(n.data == r.next.data) {
					r.next = r.next.next;
				}else {
					r = r.next;
				}
			}
			n = n.next;
		}
	}		
}

public class LinkedListNode {
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(2);
		ll.append(2);
		ll.append(3);
		ll.retrieve();
		ll.delete(1);
		ll.retrieve();
		ll.removeDups();
		ll.retrieve();
		
		Node s = ll.get(5);

    }

}
