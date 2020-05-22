class Link
{
    public int iData;
    public double dData;
    public Link next;
    //.................
    //constructor
    public Link(int id, double dd)
    {
        iData = id;
        dData = dd;
    }
    //dispaly thr Link
    public void displayLink()
    {
        System.out.println("{"+iData+","+dData+"}");
    }
}

class LinkList
{
    private Link first;
    //constructor
    public LinkList()
    {
        first = null;
    }
    //check if empty
    public boolean isEmpty()
    {
        return (first==null);
    }
    //insert at first
    public void insertFirst(int id, double dd)
    {
        //make a link
        Link newLink = new Link(id, dd);
        newLink.next = first;
        first = newLink;

    }
    //delete at first
    public Link deleteFirst()
    {
        //assume list is not empty
        Link temp = first;
        first =first.next;
        return temp;

    }
    //display the whole List
    public void displayList()
    {
       System.out.println("List (first--->last): ");
        Link current = first;
        while(current!=null)
        {
          current.displayLink();
          current = current.next;
        }
        System.out.println(" ");
    }

}

class LinkListApp
{
     public static void main(String[] args)
      {
        LinkList theList = new LinkList(); // make new list
        
        theList.insertFirst(22, 2.99); // insert four items
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);
        theList.displayList();
         // display list
        while( !theList.isEmpty() ) // until it’s empty,
        {
        Link aLink = theList.deleteFirst(); // delete link
        System.out.print("Deleted "); // display it
        aLink.displayLink();
        System.out.println(" ");
        }
        theList.displayList(); // display list
    }
}