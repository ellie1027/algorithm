package examples.LinkedList;

//단방향 LinkedList의 끝에서 k번째 노드를 찾는 알고리즘을 구현하시오. 
//방법 1. 전체 갯수를 세고 전체 갯수에서 k만큼 빼서 k번째 노드 구하기 
public class KthToLast {
	
	private static Node KthToLast(Node first, int k){
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
	
	public static void main(String[] args) {
		
		Node first = new Node(1);
		first.append(2);
		first.append(3);
		first.append(4);
		
		int k = 1;
		Node kth = KthToLast(first, k);
		System.out.println("Last k(" + k + ")th data is " + kth.data);


    }

}
