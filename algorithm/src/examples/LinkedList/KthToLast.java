package examples.LinkedList;

//단방향 LinkedList의 끝에서 k번째 노드를 찾는 알고리즘을 구현하시오. 
public class KthToLast {
	
	//실행
	public static void main(String[] args) {
		
		Node first = new Node(1);
		first.append(2);
		first.append(3);
		first.append(4);
		
		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(2);
		ll.append(2);
		ll.append(3);
		
		int k = 4;
		//1번
		Node kth = KthToLast_1(first, k);
		System.out.println("1. Last k(" + k + ")th data is " + kth.data);
		
		//2번 
		Reference r = new Reference();
		Node found = KthToLast_2(first, k, r);
		System.out.println("2. Last k(" + k + ")th data is " + found.data);		
		
		//3번 
		Node found2 = KthToLast_3(first, k);
		System.out.println("3. Last k(" + k + ")th data is " + found2.data);				

    }
	
	//방법 1. 전체 갯수를 세고 전체 갯수에서 k만큼 빼서 k번째 노드 구하기 
	private static Node KthToLast_1(Node first, int k){
		Node n = first;
		int total = 1;
		
		//총 갯수 세기
		while(n.next != null) {
			total++;
			n = n.next;
		}
		
		n = first;		
		for(int i = 1; i < total-k+1; i++) {
			n = n.next;
		}
		
		return n;		
	}
	
	//방법 2. 재귀 호출 
	static class Reference {
		public int count = 0;
	}
	
	private static Node KthToLast_2(Node n, int k, Reference r) {
		//마지막 노드 전까지 갔을 때 return 0
		if(n == null) {
			return null;			
		}
		
		//다음노드까지 세면서 k번째 노드를 찾는다
		Node found = KthToLast_2(n.next, k, r);
		r.count++;
		if(r.count == k) {
			return n;
		}
		return found;
	}
	
	//방법 3. 포인터
	public static Node KthToLast_3(Node first, int k) {
		Node p1 = first;
		Node p2 = first;
		
		//p1을 k번째 노드로 이동시킴 
		for(int i = 0; i < k; i++) {
			if(p1 == null) return null;
			p1 = p1.next;
		}
		
		//p1이 마지막 노드로 갈 때까지 p2를 이동시킴
		while(p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		return p2;
		
	}


}
