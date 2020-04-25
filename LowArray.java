class LowArray
{
	//ref  to array a
	private int[] a;

	//constructor initialize the array
	public LowArray( int size)
	{
		a = new int[size];
	}

	//set the value
	public void  setElement(int pos, int data)
	{
		a[pos] = data;
	}

	//get the value
	public int getElement(int pos)
	{
       return a[pos];
	}
}


class LowArrayApp
{
	public static void main(String[] args)
	{
		//reference
		LowArray lobj ;

		//create LowArray object
		lobj = new LowArray(7);

		//no elements in array present
		int nElemnts =0;

		//insert the elements into array
		lobj.setElement(0,10);
		lobj.setElement(1,1033);
		lobj.setElement(2,1055);
		lobj.setElement(3,55);
		lobj.setElement(4,103);
		lobj.setElement(5,102);
		lobj.setElement(6,23);

		nElemnts =7;

		//display Array
		for(int j =0; j<nElemnts; j++)
		{
			System.out.print(lobj.getElement(j)+" ");
		}
       System.out.println();
		//search the item
		int searchKey =23;

		//loop variable
		int i;
		 //find the item
		 for(i =0 ; i<nElemnts ;i++)
		 {
		 	if(searchKey == lobj.getElement(i))
		 		break;


		 }

		 if(i==nElemnts)
		 {
            System.out.println("did not find the item");
		 }
		 else
		 {
           System.out.println("Found the item " + searchKey);
		 }

		 //delete the value 55
		 for(i =0; i<nElemnts ;i++)
		 {
		 	if(lobj.getElement(i)==23)//look for it
		 		break;
		 }

         // higher ones down the indices..towards 0
         for(int k=i; k<nElemnts-1; k++)
         {
         	lobj.setElement(k,lobj.getElement(k+1));
         }

         nElemnts--;
         //display Array
		for(int j =0; j<nElemnts; j++)
		{
			System.out.print(lobj.getElement(j)+" ");
		}
	}
}










	