class Queue
{
    //data fields
    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;
    private int nItems;

    //constructor
    public Queue(int size)
    {
        maxSize = size;
        queArray = new long[maxSize];
        front =0;
        rear=-1;
        nItems = 0;
    }

    //insert new Items
    public void insert(long item)
    {
        //put items at rear of queue
        //deal with the Wapearound
        if(rear == maxSize-1)
        {
            rear =-1;
        }
        queArray[++rear] = item;
        nItems++;

    }
    //remove items
    public long remove()
    {
        //take items from front of queue
        long temp = queArray[front++];
        //check for wraparound
        if(front == maxSize)
        {
            front =0;
        }
        nItems--;
        return temp;
    }

    //peek items
    public long peek()
    {
        return queArray[front];
    }

    //chek for empty
    public boolean isEmpty()
    {
        return(nItems==0);
    }

    //chek if full
    public boolean isFull()
    {
         return(nItems == maxSize);
    }

    //find no of items in queue at any time
    public int size()
    {
        return nItems;
    }



}
class QueueApp
{
    public static void main(String[] args)
    {
        //make the obj of Queue
        Queue theQueue = new Queue(5);

        //insert 4 items
        theQueue.insert(10); 
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);

        //remove 3 items
        theQueue.remove(); // remove 3 items
        theQueue.remove(); // (10, 20, 30)
        theQueue.remove();
        
        theQueue.insert(50); // insert 4 more items
        theQueue.insert(60); // (wraps around)
        theQueue.insert(70);
        theQueue.insert(80);

        while(!theQueue.isEmpty())
        {
             long n = theQueue.remove();
             System.out.print(n);
             System.out.print(" ");
        }

        System.out.println();
        
    }
}
