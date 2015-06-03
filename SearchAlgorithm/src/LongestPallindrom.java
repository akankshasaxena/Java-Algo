
public class LongestPallindrom {

	private String longestPallindrom=""; 
	private int[][] palindrom;
	//This is a brute force algorithm
	
	public String bruteLongestPalindrom(String str){
		for(int i=0; i< str.length()-1; i++){
			for(int j=i+1; j< str.length(); j++){
				setPallindrom(str, i, j);
			}
		}
		return longestPallindrom;
	}
	
	private void setPallindrom(String str ,int i, int j){
		int beginwith = i ;
		int endWith = j;
		while(str.charAt(beginwith) == str.charAt(endWith) && beginwith < endWith){
			beginwith++;
			endWith--;
		}
		if(beginwith >= endWith && longestPallindrom.length() < str.substring(i, j+1).length()){
			longestPallindrom =  str.substring(i, j+1);
		}
	} 
	
	
	//This is the memoised version of LongestPallindrom
	private void initialize(int len){
		if(palindrom == null){
			palindrom = new int[len][len];
			for (int i = 0; i < len - 1; i++) {
				for (int j = i + 1; j < len; j++) {
					palindrom[i][j] = -1;
				}
			}
		}
	}
	
	private String longestPalBydp(String str) {
		// initializing matrix
		initialize(str.length());

		for (int i = 0; i < str.length() - 1; i++) {
			for (int j = i + 1; j < str.length(); j++) {
				if (isPallindrom(str, i, j) == 1) {
					if (longestPallindrom.length() < (j - i + 1)) {
						longestPallindrom = str.substring(i, j + 1);
					}
				}

			}
		}
		printpal();
		return longestPallindrom;
	} 
	
	private int isPallindrom(String str, int i, int j) {
		if (i == j) {
			palindrom[i][j] = 1;
		} else if (i < j ) {
			if (isPallindrom(str, i + 1, j - 1) == 1
					&& (str.charAt(i) == str.charAt(j))){
				palindrom[i][j] = 1;
			}else{
				System.out.println(" print i" + i +" : "+j);
				//printpal();
				palindrom[i][j] = 0;
			}
		} else
			return 0;
		return palindrom[i][j];

	}
	
	private void printpal(){
		for (int[] bs : palindrom) {
			for (int i = 0; i < bs.length; i++) {
				System.out.print(bs[i]+"\t");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		LongestPallindrom lp = new LongestPallindrom();
		String str = "abcccdccebf";
		String str1 = "forgeeksskeegfor";
		//System.out.println(lp.bruteLongestPalindrom(str1));
		System.out.println(lp.longestPalBydp(str));
	}

}
