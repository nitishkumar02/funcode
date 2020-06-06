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
private Link first; // ref to first item on list
// -------------------------------------------------------------
public SortedList() // constructor
{ 
    first = null; 
}
// -------------------------------------------------------------
public boolean isEmpty() // true if no links
{ 
    return (first==null); 
}
// -------------------------------------------------------------
public void insert(long key)
{
    //make a link
    Link newLink = new Link(key);
    Link current = first;
    Link previous = null;

    //until end of list
    while(current!=null && key > current.dData)
    {
        previous = current;
        current = current.next;
    }
    //if at the beginning of list
    if(previous==null)
    {
        //means at beginning of list
        first = newLink;
    }
    else
    {
        previous.next = newLink;
    }

    newLink.next = current;

}

// -------------------------------------------------------------
public Link remove() // return & delete first link
{ 
    // (assumes non-empty list)
Link temp = first; // save first
first = first.next; // delete first
return temp; // return value
}

// -------------------------------------------------------------
public void displayList()
{
System.out.print("List (first-->last): ");
Link current = first; // start at beginning of list
while(current != null) // until end of list,
{
current.displayLink(); // print data
current = current.next; // move to next link
}
System.out.println(" ");
}
} // end class SortedList


class SortedListApp
{
public static void main(String[] args)
{ // create new list
SortedList theSortedList = new SortedList();
theSortedList.insert(20); // insert 2 items
theSortedList.insert(40);

theSortedList.displayList(); // display list

theSortedList.insert(10); // insert 3 more items
theSortedList.insert(30);
theSortedList.insert(50);

theSortedList.displayList(); // display list

theSortedList.remove(); // remove an item
theSortedList.displayList(); // display list
} // end main()
}
