
public class SpiralMatrix {

	public void printSpiralMatrix(int[][] matrix){
		int end_row = matrix.length-1;
		int end_coloumn = matrix[0].length-1;
		int start_row = 0;
		int start_coloumn = 0;
		//loop which iterate 4 directions
		while(start_row <= end_row || start_coloumn <= end_coloumn){
			for(int i=start_coloumn; i<=end_coloumn; i++ ){
				System.out.print(matrix[start_row][i]+",");
			}
			
			for(int i=start_row+1; i<= end_row; i++){
				System.out.print(matrix[i][end_coloumn]+",");
			}
			
			for(int i=end_coloumn-1;i>start_coloumn; i--){
				System.out.print(matrix[end_row][i]+",");
			}
			
			for(int i=end_row-1;i>start_row; i--){
				System.out.print(matrix[i][start_coloumn]+",");
			}
			if(end_row - 1 < start_row + 1 && end_coloumn-1 < start_coloumn + 1){
				break;
			}
			end_row--;
			end_coloumn--;
			start_row++;
			start_coloumn++;
		}
	}
	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{12,13,14,15}};
		SpiralMatrix sp = new SpiralMatrix();
		sp.printSpiralMatrix(matrix);

	}

}
