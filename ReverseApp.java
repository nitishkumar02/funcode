import java.io.*;
class StackX
{
    //Fields
    private int maxSize;
    private char[] stackArray;
    private int top;

    //Constructor
    public StackX(int size)
    {
        maxSize = size;
        stackArray = new char[maxSize];
        top = -1;

    }

    // push the elements to Stack
    public void push(char j)
    {
        stackArray[++top]=j;
    }

    //just return the top of stack
    public char peek()
    {
        return stackArray[top];
    }
    //pop the elements
    public char pop()
    {
        return stackArray[top--];
    }

    //check if stack is Empty
    public boolean isEmpty()
    {
        return(top ==-1);
    }

    //check if stack is full
    public boolean isFull()
    {
        return(top==maxSize-1);
    }

}

class Reverser
{
    private String input;
    private String output;

    //.....................
    public Reverser(String in)
    {
       input = in;
    }
    //......................
    public String doRev()
    {
       //find the length of string to be size of array
       int stackSize = input.length();

       //create stack of input size
       StackX theStack = new StackX(stackSize);

       //get each char from input String ,put it to stackArray
       for(int i =0; i< stackSize ; i++)
       {
           char ch = input.charAt(i);
           theStack.push(ch);
       }

       output = " ";
       while(!theStack.isEmpty())
       {
           char ch = theStack.pop();
           output = output + ch; //append to the output
       }
       return output;
    }
}

class ReverseApp
{
    public static void main(String[] args) throws IOException
    {
        String input, output;
      while(true)
      {
        System.out.print("Enter a string: ");
        System.out.flush();
        input = getString(); // read a string from kbd
          if( input.equals(" ") ) // quit if [Enter]
               break;

            // make a Reverser
            Reverser theReverser = new Reverser(input);
            output = theReverser.doRev(); // use it
            System.out.println("Reversed: " + output);
      } // end while  
    }
     //--------------------------------------------------------------
    public static String getString() throws IOException
   {
       InputStreamReader isr = new InputStreamReader(System.in);
       BufferedReader br = new BufferedReader(isr);
       String s = br.readLine();
       return s;
   }
   //--------------------------------------------------------------
    
     
} 