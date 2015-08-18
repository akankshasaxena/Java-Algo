package Random;
/**
 * Given MxN matrix with sorted elements row wise and column wise, find the Kth largest element
 * Solution - By MAXHEAP
 * @author akanksha
 *THis class find out kth smallest element in 2-D array
 */
public class FindKthSmallest {
	/**
	 * 
	 * @param arr
	 * @param n - rows
	 * @param m - coloumns
	 * @param k - position
	 * @return
	 */
	public int findKthSmallest(int[][] arr,int n, int m, int k){
		int[] heap = buildHeap(arr,n,m);
		int heap_length = heap.length;
		for (int i = 0; i < heap.length; i++) {
			System.out.print(heap[i]+" ");
		}
		System.out.println("After min Heapify");
		minHeapify(heap,heap_length-1);
		
		for (int i = 0; i < heap.length; i++) {
			System.out.print(heap[i]+" ");
		}
		int cnt = 1;
		while(k < heap_length && cnt < k){
			swap(heap, 0 ,heap_length-1);
			heap_length--;
			minHeapify(heap,heap_length-1);
			cnt++;
		}
		
		if(cnt == k){
			return heap[0];
		}
		return -1;
	}

	/**
	 * 
	 * @param heap
	 * @param heap_length
	 */
	public void minHeapify(int[] heap, int heap_length) {
		int parent_node = (heap_length-1)/2;
		while(parent_node >= 0){
			int smallest = parent_node;
			int left_child = 2*parent_node+1;
			int right_child = 2*parent_node+2;
			
			if(left_child <= heap_length && heap[left_child] < heap[smallest]){
				smallest = left_child;
			}
			if(right_child <= heap_length && heap[right_child] < heap[smallest]){
				smallest = right_child;
			}
			if (smallest != parent_node){
				swap(heap, smallest, parent_node);
			}
			parent_node--;
		}
	}
	
	/**
	 * 
	 * @param heap
	 * @param heap_length
	 */
	public void maxHeapify(int[] heap, int heap_length) {
		int parent_node = (heap_length-1)/2;
		while(parent_node >= 0){
			int biggest = parent_node;
			int left_child = 2*parent_node+1;
			int right_child = 2*parent_node+2;
			
			if(left_child <= heap_length && heap[left_child] > heap[biggest]){
				biggest = left_child;
			}
			if(right_child <= heap_length && heap[right_child] > heap[biggest]){
				biggest = right_child;
			}
			if (biggest != parent_node){
				swap(heap, biggest, parent_node);
			}
			parent_node--;
		}
	}

	/**
	 * @param heap
	 * @param ptr1
	 * @param ptr2
	 */
	public void swap(int[] heap, int ptr1, int ptr2) {
		int tmp = heap[ptr1];
		heap[ptr1] = heap[ptr2];
		heap[ptr2] = tmp;
		
	}

	/**
	 * @param arr
	 * @param n
	 * @param m
	 * @return
	 */
	private int[] buildHeap(int[][] arr, int n, int m) {
		int[] heap = new int[n*m];
		int k = 0;
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				heap[k++] = arr[i][j];
			}
		}
		return heap;
	}
	
	public static void main(String args[]){
		int[][] arr = {{10, 20, 30, 40},
		        {15, 25, 35, 45},
		        {24, 29, 37, 48},
		        {32, 33, 39, 50}};
		FindKthSmallest findk = new FindKthSmallest();
		int res = findk.findKthSmallest(arr, 4, 4, 7);
		System.out.println("result is : "+res);
		
		
	}

}
