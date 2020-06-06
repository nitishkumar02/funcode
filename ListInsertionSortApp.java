class Link
{
public long dData; // data item
public Link next; // next link in list
// -------------------------------------------------------------
public Link(long dd) // constructor
{ 
    dData = dd; 
}
// -------------------------------------------------------------
public void displayLink() // display ourself
{
     System.out.print(dData + " ");
 }
} // end class Link

class SortedList
{
    private Link first;
    //................
    public SortedList()
    {
        first = null;
    }

    //param constructor
    public SortedList(Link[] linkArr)
    {
       //initalize list
       first = null;
       //copy array to list
       for(int j=0; j < linkArr.length; j++)
       {
           insert(linkArr[j]);
       }
    }

    //
    public void insert(Link k)
{
    //make a link

    Link current = first;
    Link previous = null;

    //until end of list
    while(current!=null && k.dData > current.dData)
    {
        previous = current;
        current = current.next;
    }
    //if at the beginning of list
    if(previous==null)
    {
        //means at beginning of list
        first = k;
    }
    else
    {
        previous.next = k;
    }

    k.next = current;

}
public Link remove() // return & delete first link
{ 
    // (assumes non-empty list)
Link temp = first; // save first
first = first.next; // delete first
return temp; // return value
}

}

class ListInsertionSortApp
{
public static void main(String[] args)
{
int size = 10;
// create array of links
Link[] linkArray = new Link[size];
 
for(int j=0; j<size; j++) // fill array with links
{ 
    // random number
int n = (int)(java.lang.Math.random()*99);
Link newLink = new Link(n); // make link
linkArray[j] = newLink; // put in array
}
// display array contents

System.out.print("Unsorted array: ");
for(int j=0; j<size; j++)
{
System.out.print( linkArray[j].dData + " " );
}
System.out.println(" ");

// create new list
// initialized with array
SortedList theSortedList = new SortedList(linkArray);
for(int j=0; j<size; j++) // links from list to array
linkArray[j] = theSortedList.remove();
// display array contents
System.out.print("Sorted Array: ");
for(int j=0; j<size; j++)
System.out.print(linkArray[j].dData + " ");
System.out.println("  ");

}
 
}
