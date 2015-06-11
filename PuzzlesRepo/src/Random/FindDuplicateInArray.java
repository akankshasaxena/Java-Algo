package Random;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class FindDuplicateInArray implements Serializable{

	private String name;
	private transient String  add;
	public int findDuplicte(int[] arr){
		boolean notDuplicate = false;
		for(int i=0; i< arr.length; i++){
			//if( arr[i]	
		}
		
		
		return 0;
	}
	
	public FindDuplicateInArray(String name, String add) {
		super();
		this.name = name;
		this.add = add;
	}

	public Object writeObject() throws NotSerializableException{
		throw new NotSerializableException();
	}
	
	public void readObject() throws NotSerializableException{
		throw new NotSerializableException();
	}
	public static void main(String[] args) {
		FindDuplicateInArray in = new FindDuplicateInArray("Akki", "awesome");
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("./Test.ser"));
			out.writeObject(in);
			out.close();
			
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("./Test.ser"));
			FindDuplicateInArray res = (FindDuplicateInArray)input.readObject();
			input.close();
			
			System.out.println(res.name +" address "+ res.add);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			
	}

}
