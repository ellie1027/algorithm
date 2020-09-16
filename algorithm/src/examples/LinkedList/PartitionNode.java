package examples.LinkedList;

import examples.LinkedList.LinkedList.Node;


//Linked List에 있는 노드들을 x값을 기준으로 값이 작은 것들은 왼쪽, 큰 것들은 오른쪽 두 파트로 나누기
//단 , x는 오른쪽 파트 어디에 놔도 상관없음.
public class PartitionNode {
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		
		//데이터 추가
		ll.append(7);
		ll.append(2);
		ll.append(8);
		ll.append(5);
		ll.append(3);
		ll.append(4);

		ll.retrieve();		
		
		Node n = Partition1(ll.get(1), 5);
		while(n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}				
		
	}
	
	//방법 1	
	@SuppressWarnings("unused")
	private static Node Partition1(Node node, int x) {
		//두 줄로 만들어서 풀기(앞줄, 뒷줄)
		Node s1 = null;
		Node e1 = null;
		Node s2 = null;
		Node e2 = null;
		
		while(node != null) {	
			//해당 노드 다음 노드 저장
			Node next = node.next;
			node.next = null;
			
			//데이터가 기준점보다 작을시 앞으로 보내야 함
			if(node.data < x) {
				if(s1 == null) {
					s1 = node;
					e1 = s1;
				}else {
	                System.out.println("e1.data : "+e1.data + " n.data : " +node.data);
	                // e1의 다음 주소값으로 n을 갖게 하고
					e1.next = node;
	                System.out.println("e1.data : "+e1.data + " n.data : " +node.data);
	                // e1도 n 노드의 위치로 이동한다
					e1 = node;
	                System.out.println("e1.data : "+e1.data + " n.data : " +node.data);					
				}
			}else {
				if(s2 == null) {
					s2 = node;
					e2 = s2;
				}else {
					e2.next = node;
					e2 = node;
				}
			}		
			node = next;			
		}	
		
		if(s1 == null) {
			return s2;
		}
		
		e1.next = s2;
		return s1;
	}	
	
	//방법 2
	//head와 tail을 이용하여 나눔
	@SuppressWarnings("unused")
	private static Node Partition2(Node n, int x) {
		
		Node h = n;
		Node t = n;
		
		while(n != null) {
			Node next = n.next;
			
			if(n.data < x) {
				n.next = h;
				h = n;				
			}else {
				t.next = n;
				t = n;
			}
			
			n = next;			
		}
		
		t.next = null;
		
		return h;			
	}

}