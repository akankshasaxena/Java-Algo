public class PrintWithoutLoop extends PrintLoopUsingThis{
  
    static int counter = 0;
    
    public static void main(String args[])
    {
        PrintLoopUsingThis b = new PrintLoopUsingThis();
    }
}
class PrintLoopUsingThis {
	PrintWithoutLoop loop1;
    
    PrintLoopUsingThis(){
    	PrintWithoutLoop.counter++;
        System.out.println("printng without using loop");
        if(PrintWithoutLoop.counter < 10)
        {
            loop1 = new PrintWithoutLoop();
            
        }
    }
    
}
