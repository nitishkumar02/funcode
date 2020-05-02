class Person
{
private String lastName;
private String firstName;
private int age;

//constructor
public Person(String last, String first, int a)
{ 
lastName = last;
firstName = first;
age = a;
}

//Display Data
public void displayPerson()
{
System.out.print("Last name:" + lastName);
System.out.print(", First name:" + firstName);
System.out.print(",Age:" + age);
System.out.println();
}

// get last name
public String getLast() 
{ 
    return lastName;
 }

}


 class ClassDataArray
{
    // reference to array
    private Person[] a;

    // number of data items 
    private int nElems; 
    
    // constructor
    public ClassDataArray(int max) 
    {
        // create the array
        a = new Person[max]; 
        // no items yet 
        nElems = 0; 
    }
   //-------------------------------
   public Person find(String searchName)
   {
       int i;
       for(i =0; i<nElems; i++)
       {
           if(a[i].getLast().equals(searchName))
           break;
       }
       if(i==nElems)
       {
           return null;
       }
       else{
           return a[i];
       }
   }

   //...............................................
   public void insert(String last, String first, int age)
   {
       a[nElems]= new Person(last, first, age);
       nElems++;
   }
   
   //....................................................
   public boolean delete(String searchName)
  { 
    // delete person from array
    int j;
    for(j=0; j<nElems; j++) // look for it
      if( a[j].getLast().equals(searchName) )
         break;

         if(j==nElems) // can’t find it
         return false;
         else              // found it
         {  
             for(int k=j;k<nElems-1;k++)
             {
                 a[k]=a[k+1];
             }
             nElems--;
             return true;
        }
    }

//--------------------------------------------------------------
   public void displayA() // displays array contents
  {
     for(int j=0; j<nElems; j++)
      { 
         // for each element,
            a[j].displayPerson(); // display it
        }   
   }
}

//...................................................

class ClassDataApp
{
public static void main(String[] args)
{
int maxSize = 100; // array size

ClassDataArray arr; // reference to array

arr = new ClassDataArray(maxSize); // create the array
// insert 10 items
arr.insert("Evans", "Patty", 24);

arr.insert("Smith", "Lorraine", 37);

arr.insert("Yee", "Tom", 43);

arr.insert("Adams", "Henry", 63);

arr.insert("Hashimoto", "Sato", 21);

arr.insert("Stimson", "Henry", 29);

arr.insert("Velasquez", "Jose", 72);

arr.insert("Lamarque", "Henry", 54);

arr.insert("Vang", "Minh", 22);

arr.insert("Creswell", "Lucinda", 18);
arr.displayA(); // display items
String searchKey = "Stimson"; // search for item
Person found;
found=arr.find(searchKey);
if(found != null)
{
System.out.print("Found ");

found.displayPerson();
}
else
System.out.println("Can’t find " + searchKey);

System.out.println("Deleting Smith, Yee, and Creswell");

arr.delete("Smith"); // delete 3 items

arr.delete("Yee");

arr.delete("Creswell");

arr.displayA(); // display items again
} // end main()

} // end class ClassDataApp