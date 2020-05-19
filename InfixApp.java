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

    public int size()
    {
        return top+1;
    }

    //return item at index n
    public char peekN(int n)
    {
        return stackArray[n];
    }
    //display the contents
    public void displayStack(String s)
    {
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for(int j=0; j<size(); j++)
        {
            System.out.print(peekN(j));
            System.out.print(' ');

        }
        System.out.println(" ");
    }
    //...........................................


}

class InPost
{
    private StackX theStack;
    private String input;
    private String output =" ";
    
    //constructor
    public InPost(String in)
    {
        input = in;
        int stackSize = input.length();
        theStack = new StackX(stackSize);
    }
     
    //do Translation to postfix
    public String doTrans()
    {
        //for each Character in input infix
        for(int j =0; j < input.length() ; j++)
        {
            char ch = input.charAt(j);
            //display stack content for each Character
            theStack.displayStack("For "+ch+" ");
            //apply rules based on input char
            switch(ch)
            {
                case '+':
                case '-':
                gotOper(ch,1);// got pop operator, precedence 1
                break;

                case '*':
                case '/':
                gotOper(ch,2);// got pop operator, precedence 2
                break;

                case '(':
                theStack.push(ch);
                break;

                case ')':
                gotParen(ch);
                break;
                
                default:
                output = output+ch;
                break;
            }//end of switch


        }//end of for loop
        while( !theStack.isEmpty() ) // pop remaining opers
        {
        theStack.displayStack("While "); // *diagnostic*
        output = output + theStack.pop(); // write to output
        }
        theStack.displayStack("End "); // *diagnostic*
        return output;
        
    }//end of do trans
    
    
    
    //check for operator and perform oprn
    private void gotOper(char opThis, int prec1)
    {
        while(!theStack.isEmpty())
        {
           //stack is not empty, pop the stack
           char opTop = theStack.pop();
           //check for close paren '(', if its , push it
           if(opTop=='(')
           {
               theStack.push(opTop);
               break;
           }
           
           else
           {
               //Its an operator
               //find precedence of new op
               int prec2;
               if(opTop =='+' || opTop =='-')
               {
                   prec2 =1;
               }
               else
               {
                   prec2 =2;
               }

               //comapre poped and incoming opThis operator on their precedence
               if(prec2 < prec1) //mens incoming is higher
               {
                   //simply push the poped operator first, and then push the incoming
                   theStack.push(opTop);
                   break;
               }
               else
               {
                   //incoming is having lower prec, so popped oper will go to output
                   output = output + opTop;

               } 
           }//end else(Its an operator)

           
           
        }//end while
        //in the end push new operator
        theStack.push(opThis);
    }// end of gotOper

    private void gotParen(char ch)
    {
        //got right parenthesis
        while(!theStack.isEmpty())
        {
            char chpop = theStack.pop();
            if(chpop == '(')
            {
                //just break
                break;
            }
            else{
                output =output +chpop; //output the content of stack till '('
            }

        }//end while
    }


}//end of class InToPost

//Driver class or User class
class InfixApp
{
    public static void main(String[] args) throws IOException
     {
         String input, output;
        while(true)
       {
        System.out.print("Enter infix: ");
        System.out.flush();
         // read a string from kbd
         input = getString();
         if( input.equals(" ") ) // quit if [Enter]
           break;
        
           // make a translator
           InPost theTrans = new InPost(input);
           output = theTrans.doTrans(); // do the translation
           System.out.println("Postfix is " + output + '\n');

        } // end while
    } // end main()

    //--------------------------------------------------------------
public static String getString() throws IOException
{
InputStreamReader isr = new InputStreamReader(System.in);
BufferedReader br = new BufferedReader(isr);
String s = br.readLine();
return s;
}
//--------------------------------------------------------------
} // end class InfixApp