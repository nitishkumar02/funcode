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

class BracketChecker
{
 // input string
 private String input;
//--------------------------------------------------------------
// constructor
public BracketChecker(String in) 
{ 
    input = in; 
}
//bracket check method
public void check()
{
    //get the size of stack
    int stackSize = input.length();

    //make stack
    StackX theStack = new StackX(stackSize);

    //get each char from input
    for(int j =0; j < stackSize; j++)
    {
        char ch = input.charAt(j);
        //based on char switch to
        switch(ch)
        {
            //if opening's breakts, just push them
            case'{':
            case'[':
            case'(':
            theStack.push(ch);
            break;

            //if closing symbols, start poping and chek them
            case '}':
            case ']':
            case ')':
            if(!theStack.isEmpty())
            {
                char chx = theStack.pop();
                //match for opening's
                if((chx !='{' && ch=='}')|| chx!='[' && ch==']' || chx!='(' && ch==')')
                {
                     System.out.println("Error: "+ch+" at"+j);
                }
            }
            
            else
            {
                //prematurely empty
                System.out.println("Error" +ch +"at "+j);
            }

            break;

            //no action on other character
            default:
            break;


        } //end switch

    }//end for
    //at this point, all characters have been processed
    if(!theStack.isEmpty())
    {
        System.out.println("Error : Missing right delimeter" );
    }
   
//end of check
}


}//end class BracketChecker

class BracketApp
{

    public static void main(String[] args) throws IOException
    {
      String input;
      while(true)
       {
        System.out.print("Enter string containing delimiters: ");
        System.out.flush();
        input = getString(); // read a string from kbd
        if(input.equals(" ") )
        {
            break;
        } // quit if [Enter]
        // make a BracketChecker
        BracketChecker theChecker = new BracketChecker(input);
        theChecker.check(); // check brackets
        } // end while
    }
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
} //
