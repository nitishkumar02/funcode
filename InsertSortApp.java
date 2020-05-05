class ArrayIns
{
    private long[] a; // ref to array a
    private int nElems; // number of data items

//--------------------------------------------------------------
public ArrayIns(int max) // constructor
{
a = new long[max]; // create the array
nElems = 0; // no items yet
}

//--------------------------------------------------------------
public void insert(long value) // put element into array
{
a[nElems] = value; // insert it
nElems++; // increment size
}

//--------------------------------------------------------------
public void display() // displays array contents
{
for(int j=0; j<nElems; j++) // for each element,
System.out.print(a[j] + " "); // display it

System.out.println("No Of Elemnts "+ nElems);
System.out.println(" ");

}
//..............................................................
public void insertionSort()
{
   int in ,out;
   //outer loop
   for(out =1 ; out < nElems ; out++)
   {
       long temp = a[out];
       in=out;
       while(in > 0 && a[in-1]>=temp)
       {
          a[in] = a[in-1];
          in--;
       }
       a[in] = temp;
   }

} // end of fun

}

public class InsertSortApp
{
    public static void main(String[] args)
    {
    int maxSize = 6; // array size
     
     ArrayIns arr; // reference to array
   
     arr = new ArrayIns(maxSize); // create the array
   
    arr.insert(22); // insert 6 items
    arr.insert(29);
    arr.insert(84);
    arr.insert(75);
    arr.insert(72);
    arr.insert(68);
   
    arr.display();
    arr.insertionSort();
    arr.display();
    }

}