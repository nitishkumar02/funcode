import java.util.Scanner;
class HighArray
{
	private long[] a;
	private int nElems;

	//constructor
	public HighArray(int size)
	{
		a = new long[size];
		nElems =0;//no elements initally
	}

	//insert the elements
	public void insert(long data)
	{
		a[nElems] = data;
		nElems++;
	}

	//find the elements
	public boolean find(long searchKey)
	{
		int i;
         for( i =0; i<nElems; i++)
         {
         	if(a[i]==searchKey)
         		return true;
         }
         
         	return false;
	}

	//delete the given key
	public boolean delete(int searchKey)
	{
		//first find the element
		int i;
		for(i =0; i<nElems; i++)
         {
         	if(a[i]==searchKey)
         		break;
         }
         if(i==nElems)
         {
         	return false;
         }
         else
         {
         	//shift the elements
         	for(int k =i; k<nElems-1; k++)
         	{
         		a[k] = a[k+1];
         	}
         	nElems--;//decrement thr size of Array
         	return true;
         }
	}

	//diaplay the Elements
	public void dispaly()
	{
		for(int i = 0; i<nElems; i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

}

class HighArrayApp
{
	public static void main(String[] args)
	{
		int arrySize =10;
		//create reference
		HighArray arr ;
		//create the array
		arr = new HighArray(arrySize);
		//insert the elements
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the nos:");
		long data;
		
		for(int k =0; k<10; k++)
			{
                data = sc.nextLong();
				arr.insert(data);
			}

			arr.dispaly();
			
			System.out.println("enter the nos to Search:");
			long searchKey = sc.nextLong();
			
			boolean b =arr.find(searchKey);
			if(b)
			{
				System.out.println("Found the key");
			}	
			else
			{
				System.out.println("Not Found the key");
			}



	}
}