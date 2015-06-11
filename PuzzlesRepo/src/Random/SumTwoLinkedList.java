package Random;
import java.util.LinkedList;


class MyLinkedList{
	int value;
	MyLinkedList next;
}

public class SumTwoLinkedList {
	
	public int sumLinkedList(MyLinkedList a, MyLinkedList b,int digit){
		if((a == null && b == null) || digit < 0 ){
			return 0;
		}
		System.out.println("a : "+a.value*(int)(Math.pow(10,digit)));
		System.out.println("b : "+b.value*(int)(Math.pow(10,digit)));
		int sum = a.value*(int)(Math.pow(10,digit)) + b.value*(int)(Math.pow(10,digit)) + sumLinkedList(a.next, b.next,--digit);
		
		return sum;
	}
	public int add2LinkedList(MyLinkedList a, MyLinkedList b){
		int size_a=0;
		int size_b = 0;
		int res = 0;
		MyLinkedList tmp = null;
		tmp = a;
		while(tmp!=null){
			tmp = tmp.next;
			size_a++;
		}
		tmp = b;
		while(tmp!= null){
			tmp = tmp.next;
			size_b++;
		}
		int dif = size_a - size_b;
		if(dif > 0){
			System.out.println("diff"+size_b);
			tmp = a;
			for(int i=0;i<dif;i++){
				tmp = tmp.next;
			}
			
			res = sumLinkedList(tmp, b, size_b-1);
			int carry = (size_b-1)+dif;
			int res1 = 0;
			for(int i=0;i<dif;i++){
				res1 = res1*10+ a.value;
				a=a.next;
			}
			res = res1*(int)Math.pow(10, (size_b))+res;
		}else if(dif < 0 ) {
			tmp = b;
			for(int i=0;i<Math.abs(dif);i++){
				tmp = tmp.next;
			}
			res = sumLinkedList(a, tmp, size_a-1);
			int carry = size_a-1+Math.abs(dif);
			
			for(int i=0;i<dif;i++){
				res = res+ b.value*(int)(Math.pow(10,carry));
			}
		}else{
			res = sumLinkedList(a, tmp, size_a);
		}
		return res;
	}
	public static void main(String[] args) {
		SumTwoLinkedList sl = new SumTwoLinkedList();
		MyLinkedList a = new MyLinkedList();
		MyLinkedList a1 = new MyLinkedList();
		MyLinkedList a2 = new MyLinkedList();
		MyLinkedList a3 = new MyLinkedList();
		MyLinkedList a4 = new MyLinkedList();
		/*a.value = 5;
		a1.value = 6;
		a2.value = 3;
		a3.value =1;
		a1.next = a2;
		a.next = a1;
		a2.next = a3;
		*/
		a.value = 1;
		a1.value = 0;
		a2.value = 0;
		a3.value =0;
		a4.value =1;
		a1.next = a2;
		a.next = a1;
		a2.next = a3;
		a3.next = a4;
		MyLinkedList b = new MyLinkedList();
		MyLinkedList b1 = new MyLinkedList();
		MyLinkedList b2 = new MyLinkedList();
		/*b.value = 8;
		b1.value = 4;
		b2.value = 2;
		b1.next = b2;
		b.next = b1;*/
		b.value = 1;
		b1.value = 1;
		//b2.value = 2;
		//b1.next = b2;
		b.next = b1;
		
		System.out.println(sl.add2LinkedList(a, b));
	}

}
