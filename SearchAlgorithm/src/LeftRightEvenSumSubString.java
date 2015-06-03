
public class LeftRightEvenSumSubString {
	private int range_i = -1;
	private int range_j = -1;
	private int subStrLen = -1;
	private int[][] memCache = null;
	
	public int getRange_i() {
		return range_i;
	}


	public void setRange_i(int range_i) {
		this.range_i = range_i;
	}


	public int getRange_j() {
		return range_j;
	}


	public void setRange_j(int range_j) {
		this.range_j = range_j;
	}


	public int getSubStrLen() {
		return subStrLen;
	}


	public void setSubStrLen(int subStrLen) {
		this.subStrLen = subStrLen;
	}
	public void getLength(String str){
		intializeMemCach(str.length());
		for(int i=0 ; i< str.length()-1 ; i++){
			for (int j=i+1; j<str.length(); j+=2){
				divideNSum(str,i,j);
			}
		}
	}
	
	

	private void divideNSum(String str, int begin, int end) {
		int sumLeft = 0;
		int sumRight = 0;
		int i = begin;
		int j= end ;
		System.out.println("enter "+begin+":"+end);
		for (int cnt = 0; cnt <= (end - begin) / 2 && i < j; i++,j--) {
			sumLeft = Integer.parseInt(str.charAt(i)+"") + sumLeft;
			sumRight = Integer.parseInt(str.charAt(j)+"") + sumRight;
			System.out.println("sumLeft" + sumLeft+":"+sumRight);
		}
		if (sumLeft == sumRight && subStrLen < (end - begin) + 1) {
			subStrLen = end - begin + 1;
			range_i = begin;
			range_j = end;
		}
	}
	
	private void intializeMemCach(int len) {
		memCache = new int[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				memCache[i][j] = -1;

			}
		}
	}

	private void memDivideNSum(String str, int begin, int end) {
		int sumLeft = 0;
		int sumRight = 0;
		int i = begin;
		int j = end;
		if(memCache[begin][end] == -1){
		for (int cnt = 0; cnt <= (end - begin) / 2 && i < j; i++, j--) {
			sumLeft = Integer.parseInt(str.charAt(i) + "") + sumLeft;
			sumRight = Integer.parseInt(str.charAt(j) + "") + sumRight;
			System.out.println("sumLeft" + sumLeft + ":" + sumRight);
		}
		}
		if (sumLeft == sumRight && subStrLen < (end - begin) + 1) {
			subStrLen = end - begin + 1;
			range_i = begin;
			range_j = end;
		}
	}

	public static void main(String[] args) {
		LeftRightEvenSumSubString lf = new LeftRightEvenSumSubString();
		String str = "12253084";
		lf.getLength(str);
		System.out.println("Sub length " +lf.getSubStrLen() +" Ranje is "+lf.getRange_i()+":"+lf.getRange_j());
		
	}

}
