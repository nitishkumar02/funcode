class ArraySel
{
private long[] a; // ref to array a
private int nElems; // number of data items

//--------------------------------------------------------------
public ArraySel(int max) // constructor
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
public void selectSort()
{
    int out, in, min;
    //outer loop
    for(out = 0; out<nElems-1; out++)
    {
        min=out;
        //inner loop
        for(in = out+1; in<nElems; in++)
        {
            if(a[in]<a[min])
            {
                min =in;
            }
        }
        swap(out,min);

    }


}
//swap
private void swap(int one , int two)
{
   long temp = a[one];
   a[one] = a[two];
   a[two]= temp;
}

}//end of class


public class SelectSortApp 
{
    public static void main(String[] args)
    {
     int maxSize = 6; // array size
     
     ArraySel arr; // reference to array
   
     arr = new ArraySel(maxSize); // create the array
   
    arr.insert(22); // insert 6 items
    arr.insert(29);
    arr.insert(84);
    arr.insert(75);
    arr.insert(72);
    arr.insert(68);
   
    arr.display();
    arr.selectSort();
    arr.display();
   
   
       
   }
    
}