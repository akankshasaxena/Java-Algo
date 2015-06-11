package Random;

class A{
	
}
class B{}

public class Try {

	public static void main(String args[]){
		int[][] arr = {{1,2},{3,4},{5,6}};
		int row = arr.length;
		for(int i=0 ; i< row; i++){
			for(int j=0; j<arr[i].length; j++){
				System.out.println(arr[i][j]);
			}
		}
		
	}
}
