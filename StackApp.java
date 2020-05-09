class StackX
{
    //Fields
    private int maxSize;
    private long[] stackArray;
    private int top;

    //Constructor
    public StackX(int size)
    {
        maxSize = size;
        stackArray = new long[maxSize];
        top = -1;

    }

    // push the elements to Stack
    public void push(long j)
    {
        stackArray[++top]=j;
    }

    //just return the top of stack
    public long peek()
    {
        return stackArray[top];
    }
    //pop the elements
    public long pop()
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

class StackApp
{
    public static void main(String[] args)
    {
       StackX theStackX = new StackX(10);
       theStackX.push(10);
       theStackX.push(20);
       theStackX.push(30);
       theStackX.push(40);
       theStackX.push(90);
       theStackX.push(34);
       theStackX.push(76);
       theStackX.push(90);
       theStackX.push(98);
       theStackX.push(66);
       while(!theStackX.isEmpty())
       {
           long value = theStackX.pop();
           System.out.print(value+" ");
       }
       System.out.println();
       
    }
}