public class StringPermutation {

	public void printPerm(String str, String buff, int beginIndex, int len) {
		if (beginIndex < len) {

			printPerm(str, buff + str.charAt(beginIndex), beginIndex + 1, len);
		    if (beginIndex != len - 1)
			printPerm(str, buff + str.charAt(beginIndex) + " ", beginIndex + 1,
					len);
		} else {
			System.out.println(buff);
		}
	}

	public static void main(String args[]) {
		StringPermutation perm = new StringPermutation();
		String str = "ABCD";
		StringBuffer buff = new StringBuffer();
		perm.printPerm(str, "", 0, str.length());
	}

}
