package sorting;

public class QuickSort {

	public void quickSort(int[] arr, int lo_idx, int hi_idx){
		if(lo_idx >= hi_idx){
			return;
		}
		int partition_idx = partition(arr,lo_idx,hi_idx);
		quickSort(arr, lo_idx, partition_idx - 1);
		quickSort(arr, partition_idx + 1, hi_idx);
		
	}
	
	private int partition(int[] arr, int lo_idx, int hi_idx) {
		int pivot = arr[hi_idx];
		int pIndex = lo_idx;
		for(int i=lo_idx; i< hi_idx;i++){
			if(arr[i] <= pivot){
				swap(arr, pIndex++,i);
			}
		}
		swap(arr,hi_idx,pIndex);
		
		return pIndex;
	}
	
	private void swap(int[] arr, int idx1, int idx2) {
		int tmp = arr[idx1];
		arr[idx1] = arr[idx2];
		arr[idx2] = tmp;
	}

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int[] arr={5,7,2,3,4,8,9,1};
		qs.quickSort(arr, 0, arr.length-1);
		
		for(int j=0; j< arr.length; j++){
			System.out.print(arr[j]);
		}
	}

}
