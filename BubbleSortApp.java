class ArrayBub
{
private long[] a; // ref to array a
private int nElems; // number of data items

//--------------------------------------------------------------
public ArrayBub(int max) // constructor
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


public void bubbleSort()
{
    int inner, outer;
    int a1 =0;

    for(outer = nElems-1; outer >0;outer --)
    {
        int swap =0;
        System.out.println("outer pass no:"+ ++a1); 
        for(inner= 0; inner<outer; inner++)
         {
            
             if(a[inner]>a[inner+1])
             {
                 swap++;
                 swap(inner, inner+1);
             }
         }
         System.out.println("Innner Loop runs-Comparision no:"+inner); 
         System.out.println("No of Swaps:"+swap); 
         System.out.println(" ");

    }
}
private void swap(int one , int two)
{
   long temp = a[one];
   a[one] = a[two];
   a[two]= temp;
}

}



public class BubbleSortApp 
{
   public static void main(String[] args)
 {
  int maxSize = 6; // array size
  
  ArrayBub arr; // reference to array

  arr = new ArrayBub(maxSize); // create the array

 arr.insert(87); // insert 6 items
 arr.insert(79);
 arr.insert(74);
 arr.insert(75);
 arr.insert(72);
 arr.insert(68);

 arr.display();
 arr.bubbleSort();
 arr.display();


    
}
}