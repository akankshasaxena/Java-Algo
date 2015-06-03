import java.util.Comparator;
import java.util.HashMap;

/**
 * @author akanksha
 * This comparator class provides the comparison for HashMap
 * on the basis of their values 
 */
public class ValueComparator implements Comparator<String> {

	HashMap<String, Integer> map;

	/**
	 * @param map
	 */
	public ValueComparator(HashMap<String, Integer> map) {
		this.map = map;
	}

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 * 
	 * This method is responsible for comparing the values of two entries in Hashmap
	 */
	@Override
	public int compare(String str1, String str2) {
		if (map.get(str1) >= map.get(str2)) {
			return -1;
		}  else {
			return 1;
		}
	}
}
