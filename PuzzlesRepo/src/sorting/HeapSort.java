package sorting;

import Random.FindKthSmallest;

public class HeapSort {
	
	public void minHeapSort(int[] arr){
		FindKthSmallest utility = new FindKthSmallest();
		int len = arr.length-1;
		while(len > 0){
			utility.minHeapify(arr, len);
			utility.swap(arr,0,len);
			len--;
		}
		
	}

	public static void main(String[] args) {
		int[] arr = {40, 20, 30, 10};
		HeapSort srt = new HeapSort();
		srt.minHeapSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");	
		}
		
	}

}
