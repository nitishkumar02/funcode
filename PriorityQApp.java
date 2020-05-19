import java.io.*;
class PriorityQ
{
// array in sorted order, from max at 0 to min at size-1
private int maxSize;
private long[] queArray;
private int nItems;
//-------------------------------------------------------------
public PriorityQ(int s) // constructor
{
maxSize = s;
queArray = new long[maxSize];
nItems = 0;
}
// insert items in Priority queue
public void insert(long item)
{
    int j;
    //if no items
    if(nItems==0)
    {
        queArray[nItems++] = item; //insert at 0
    }
    else
    {
        //if already present then start from back side
        for(j = nItems-1; j>0; j--)
        {
            if(item > queArray[j]) //if our item is bigger then shift
            {
                queArray[j+1] =queArray[j];
            }
            else{
                break;
            }
        }
        queArray[j+1] = item;
    }

}
//-------------------------------------------------------------
public long remove() // remove minimum item
{ 
    return queArray[--nItems];
 }
//-------------------------------------------------------------
public long peekMin() // peek at minimum item
{ 
    return queArray[nItems-1];
 }
//-------------------------------------------------------------
public boolean isEmpty() // true if queue is empty
{ 
    return (nItems==0); 
}
//-------------------------------------------------------------
public boolean isFull() // true if queue is full
{
     return (nItems == maxSize); 
}

 
}
class PriorityQApp
{

    public static void main(String[] args) throws IOException
   {

    PriorityQ thePQ = new PriorityQ(5);

    thePQ.insert(30);

    thePQ.insert(50);

    thePQ.insert(10);

    thePQ.insert(40);

    thePQ.insert(20);

    while( !thePQ.isEmpty() )

    {

        long item = thePQ.remove();

        System.out.print(item + " "); // 10, 20, 30, 40, 50

    } // end while

    System.out.println(" ");

} // end main()
//-------------------------------------------------------------
} // end class PriorityQApp