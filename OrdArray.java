class OrdArray
{
	

private long[] a; // ref to array a
private int nElems; // number of data items

//-----------------------------------------------------------

public OrdArray(int max) // constructor
{
a = new long[max]; // create array
nElems = 0;
}
//-----------------------------------------------------------

public int size()
{ 
	return nElems; 
}
//-----------------------------------------------------------

public int find(long searchKey)
{
int lowerBound = 0;
int upperBound = nElems-1;
int curIn;

   while(true)
  {
    curIn = (lowerBound + upperBound ) / 2;
     
     if(a[curIn]==searchKey)
      return curIn; // found it
    
    else if(lowerBound > upperBound)
     return nElems; // can’t find it
    
    else // divide range
    {
      if(a[curIn] < searchKey)
        lowerBound = curIn + 1; // it’s in upper half
      else
        upperBound = curIn - 1; // it’s in lower half
    } // end else divide range

  } // end while

} // end find()

//-----------------------------------------------------------
public void insert(long value) // put element into array
{
 int j;

 for(j=0; j<nElems; j++) // find where it goes
   if(a[j] > value) // (linear search)
     break;

 for(int k=nElems; k>j; k--)
 {
  // move bigger ones up
 a[k] = a[k-1];

}
 // insert it
 a[j] = value; 
 
 // increment size
 nElems++; 
} 
// end insert()

//-----------------------------------------------------------
public boolean delete(long value)
{
int j = find(value);
 if(j==nElems) // can’t find it
   return false;
   else // found it
   {
   	 // move bigger ones down
    for(int k=j; k<nElems-1; k++)
    a[k] = a[k+1];
   
    // decrement size
    nElems--; 
    return true;
   }
} // end delete()

//-----------------------------------------------------------
// displays array contents
public void display() 
{
for(int j=0; j<nElems; j++) // for each element,
System.out.print(a[j] + “ “); // display it
System.out.println(“”);
}
//-----------------------------------------------------------

} // end class OrdArray