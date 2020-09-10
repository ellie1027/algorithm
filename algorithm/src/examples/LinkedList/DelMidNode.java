package examples.LinkedList;

import examples.LinkedList.LinkedList.Node;

//단방향 링크드 리스트에서 중간에 있는 노드를 삭제하시오. 
//단 당신은 첫번째 노드가 어딨는지 모르고 오직 삭제할 노드만 갖고 있다.
public class DelMidNode {
	
	private static boolean deleteNode(Node node) {
		if(node == null || node.next == null) {
			return false;
		}
		
		//다음 노드를 받아옴
		Node next = node.next;
		//다음 데이터로 바꿈
		node.data = next.data;
		//다음 노드로 바꿈
		node.next = next.next;
		
		return true;		
	}
	
	
	
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		
		//데이터 추가
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.append(5);
		
		ll.retrieve();		
		
		deleteNode(ll.get(3));
		
		ll.retrieve();		
		
	}

}
