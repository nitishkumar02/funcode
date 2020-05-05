class Person
{

private String lastName;
private String firstName;
private int age;

//-----------------------------------------------------------
public Person(String last, String first, int a)
{ 
    // constructor
lastName = last;
firstName = first;
age = a;
}

//-----------------------------------------------------------
public void displayPerson()
{
System.out.print("Last name: " + lastName);
System.out.print(", First name: " + firstName);
System.out.println(", Age: " + age);
}

//-----------------------------------------------------------
public String getLast() // get last name
{ 
    return lastName;
 }

} // end class Person

class ArrayInOb
{
    private Person[] a;
    private int nElems;
    //Constructor
    ArrayInOb(int size)
    {
        a = new Person[size];
        nElems = 0;
    }

    //insert Person Object into array
    public void insert(String firstName, String lastName, int age)
    {
      a[nElems] = new Person(firstName, lastName, age);
      nElems++;
    }

    //display each object from array
    public void display()
    {
        for(int i =0; i < nElems; i++)
        {
            a[i].displayPerson();
        }
    }
    //sort the Person Object Based on Last nmae
    public void insertionSort()
    {
        int in , out;
        for(out=1; out<nElems; out++)
        {
            Person temp = a[out];
            in=out;
            while(in>0 && a[in-1].getLast().compareTo(temp.getLast())>0)
            {
              a[in]= a[in-1];
              in--;
            }
            a[in] = temp;

        }
    }
}

class ObjectSortApp
{
    public static void main(String[] args)
    {
        int maxSize = 10; // array size
        
        ArrayInOb arr; // reference to array
        
        arr = new ArrayInOb(maxSize); // create the array
        
        arr.insert("Evans", "Patty", 24);
        
        arr.insert("Smith", "Doc", 59);

        arr.insert("Smith", "Lorraine", 37);

        arr.insert("Smith", "Paul", 37);

        arr.insert("Yee", "Tom", 43);

        arr.insert("Hashimoto", "Sato", 21);

        arr.insert("Stimson", "Henry", 29);

        arr.insert("Velasquez", "Jose", 72);

        arr.insert("Vang", "Minh", 22);

        arr.insert("Creswell", "Lucinda", 18);

        System.out.println("Before sorting:");

        arr.display(); // display items

        arr.insertionSort(); // insertion-sort them

        System.out.println("After sorting:");

        arr.display(); // display them again

    } // end main()
} // end class ObjectSortApp

    
