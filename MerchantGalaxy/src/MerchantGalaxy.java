import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;


/**
 * @author akanksha
 * This class is capable of converting Intergalactia Units into 
 * credits as well as Roman into Numerals
 */
public class MerchantGalaxy {
	private HashMap<String,Integer> romanNumerals = null;
	private TreeMap<String, Integer> treeMap  = null;
	private HashMap<String, String> intergalactiaMap = null;
	private HashMap<String, Float> currencyMap = null;
	
	public MerchantGalaxy() {
		populateIntergalactiaMap();
	}
	
	/**
	 * This method populates Roman currency notation Map
	 */
	private void populateRomanMap(){
		if(romanNumerals == null){
			romanNumerals = new HashMap<String, Integer>();
			romanNumerals.put("I", 1);
			romanNumerals.put("IV", 4);
			romanNumerals.put("V", 5);
			romanNumerals.put("IX", 9);
			romanNumerals.put("X", 10);
			romanNumerals.put("XL", 40);
			romanNumerals.put("L", 50);
			romanNumerals.put("XC", 90);
			romanNumerals.put("C", 100);
			romanNumerals.put("CD", 400);
			romanNumerals.put("D", 500);
			romanNumerals.put("CM", 900);
			romanNumerals.put("M", 1000);
		}
		ValueComparator comp = new ValueComparator(romanNumerals);
		treeMap = new TreeMap<String,Integer>(comp);
		treeMap.putAll(romanNumerals);
	}
	
	/**
	 * This method populates all the Maps required for conversion of currency
	 */
	private void populateIntergalactiaMap(){
		populateRomanMap();
		if(intergalactiaMap == null){
			intergalactiaMap = new HashMap<String, String>();
			intergalactiaMap.put("glob","I");
			intergalactiaMap.put("prok", "V");
			intergalactiaMap.put("tegj", "L");
			intergalactiaMap.put("pish", "X");
		}
		if(currencyMap == null){
			currencyMap = new HashMap<String,Float>();
			currencyMap.put("Silver", 17f);
			currencyMap.put("Gold", 14450f);
			currencyMap.put("Iron", 195.5f);
		}
	}
	
	
	
	/**
	 * This method returns Number equivalent to Roman string
	 * @param roman
	 * @return
	 * return -1 if a Roman String is not valid
	 *  
	 */
	public int romToNum(String roman){
		int res = 0;
		int count = 0;
		boolean inValid = false;
		Set<Map.Entry<String,Integer>> map = treeMap.entrySet();
		int beginIndex = 0;
		int endIndex = 1;
		
		for (Entry<String, Integer> pair : map) {
			while(endIndex <= roman.length()){
				if(!inValid && pair.getKey().equals(roman.substring(beginIndex, endIndex))){
					res = res + pair.getValue();
					beginIndex = endIndex;
					endIndex++;
					if(count < 3){
						count++;
					}else{
						inValid = true;
						break;
					}
				}else if(!inValid && endIndex+1 <= roman.length() && pair.getKey().equals(roman.substring(beginIndex, endIndex+1))){
					res = res + pair.getValue();
					beginIndex = endIndex+1;
					endIndex+=2;
					break;
				}else{
					count = 0;
					break;
				}
			}
		}
		if(inValid || (beginIndex < roman.length())){
			return -1;
		}
		
		return res;
		
	}
	
	/**
	 * This method calculates the credits for a given Intergalactia Unit
	 * @param notes
	 * @return
	 * Return null if the String is invalid
	 */
	public String intergalactiaToCredit(String notes){
		StringTokenizer strToken = new StringTokenizer(notes, " ");
		StringBuffer roman = new StringBuffer();
		float credit = 1f;
		float result = 0f;
		String resultStr = null; 
		while(strToken.hasMoreTokens()){
			String token = strToken.nextToken();
			
			if(credit == 1 && intergalactiaMap.containsKey(token)){
				roman.append(intergalactiaMap.get(token));
			}else if(currencyMap.containsKey(token)){
				if(credit != 1){
					return null;
				}
				credit = currencyMap.get(token);
			}else{
				return null;
			}
		}
		int dimes = romToNum(roman.toString());
		if(dimes == -1){
			return null;
		}else if(credit == 1){
			resultStr = dimes+"";
		}else{
			result = dimes * credit;
			resultStr = result + " Credit";
		}
		return resultStr;
	}
	
	/**
	 * This main will take the input from command line, it reads whole line and print the answer
	 * @param args
	 */
	public static void main(String args[]){
		MerchantGalaxy curr = new MerchantGalaxy();
		BufferedReader reader = (new BufferedReader(new InputStreamReader(System.in)));
		String notes = null;
		try {
			while( (notes = reader.readLine()) != null){
				String result = curr.intergalactiaToCredit(notes);
				if(result == null){
					System.out.println("I have no idea what you are talking about");
				}else {
					System.out.println(notes+" is "+result);
				}
				
			}
		} catch (IOException e) {
			System.out.println("System is not able to read the file : "+e.getMessage());;
		}

	}

}
