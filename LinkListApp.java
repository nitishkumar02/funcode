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
    
    //find the link with specific key
    public Link find(int key)
    {
        //assume non-empty List
        Link current = first;
      
        while(current.iData!=key)
        {
            //if at the end of list
            if(current.next==null)
            {
            return null; //did not find the key
            }
            else
            {
                //go to next link
                current = current.next;
            }

            
        }

        // we found it ,if Its not null
        return current;
    }

    //delete the link based on key
    public Link delete(int key)
    {
        //first find the Link with specific key
        //assume non-empty list
        Link current = first;
        Link previous = first;
        
        while(current.iData!=key)
        {
            //if at the end of list
            if(current.next==null)
            {
            return null; //did not find the key
            }
            else
            {
                
                //keep track of previous link as well
                previous =current;

                //go to next link
                current = current.next;
            }

            
        }
        
        
        //if its first link, where u found the key
        if(current ==first)
        {
            first = first.next;
        }
        else
        {
            //either we r at in middle or at end
           previous.next = current.next;
        }
        //Found , if Its not null
        return current;


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
        LinkList theList = new LinkList(); // make a new list
        
        theList.insertFirst(22, 2.99); // insert four items
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);
       
        theList.displayList();
         // display list

         Link f = theList.find(22); //find a key
         if(f !=null)
         {
            System.out.println("Found Link with key"+ f.iData);
         }
         else
         {
             System.out.println("Cant find the Link");
         }
         
         Link d = theList.delete(88);//delete a key
         if(d!=null)
         {
             System.out.println("Deleted the Link with:"+d.iData);
         } 
         else
         {
             System.out.println("Could not find the link to Delete");
         }

    
        
        theList.displayList(); // display list
    }
}
