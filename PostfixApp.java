import java.io.IOException;
import java.io.*;

class StackX
{
    //Fields
    private int maxSize;
    private int[] stackArray;
    private int top;

    //Constructor
    public StackX(int size)
    {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;

    }

    // push the elements to Stack
    public void push(int j)
    {
        stackArray[++top]=j;
    }

    //just return the top of stack
    public long peek()
    {
        return stackArray[top];
    }

    //pop the elements
    public int pop()
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

    //pick from nth position
    public int peekN(int n)
    {
        return stackArray[n];
    }

    //find the size of Stack
    public int size()
    {
       return top+1;
    }

    //display the stack at each point
    public void displayStack(String s)
    {
        System.out.print(s);
        System.out.print("Stack (bottom--->top: ");
        for(int j =0; j < size(); j++)
        {
            System.out.print( peekN(j));
            System.out.print(' ');
        }
    }



}

class ParsePost
{
    private StackX theStack;
    private String input;
    //constructor
    public ParsePost(String s)
    {
        //initalize the incoming string
        input = s;

    }
    //pase the input postfix expession
    public int doParse()
    {
        //make a stack
        theStack = new StackX(20);
        //get the char from input
        char ch ;
        int j;
        int num1, num2, interAns;
        //for eacch char
        for(j=0; j < input.length(); j++)
        {
            ch = input.charAt(j);
            //diagnostic
            theStack.displayStack(" "+ch+" ");
            System.out.println();
            //find out what is in the char
            //if  number , simply push the operand to stack, after converting it to corresponding integer val
            if(ch >= '0' && ch <= '9')
            {
                theStack.push((int)(ch -'0'));
            }
            else
            {
                //operator, pop the last entered two number from stack
                num2 = theStack.pop();
                num1 = theStack.pop();
                //apply the operator;
                switch(ch)
                {
                    case'+':
                    interAns = num1+num2;
                    break;

                    case'-':
                    interAns = num1-num2;
                    break;

                    case'*':
                    interAns = num1*num2;
                    break;

                    case'/':
                    interAns = num1/num2;
                    break;

                    default:
                    interAns =0;


                } //end switch
                //now push the intermediate result
                theStack.push(interAns);
            }//else 
        }//end for
        //now eyerything pased from input, pop the result
        interAns = theStack.pop();


        return interAns;
    }//end of parse func

}//end of class

class PostfixApp
{
    public static void main(String[] args) throws IOException
    {
        String input;
        int output;

        while(true)
        {
        System.out.print("Enter postfix: ");
        System.out.flush();
        input = getString(); // read a string from kbd
         if( input.equals(" ") ) // quit if [Enter]
           break;

            // make a parser
             ParsePost aParser = new ParsePost(input);

             output = aParser.doParse(); // do the evaluation

             System.out.println("Evaluates to " + output);

            } // end while
    }


    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);

        BufferedReader br = new BufferedReader(isr);

        String s = br.readLine();

        return s;
    }


}