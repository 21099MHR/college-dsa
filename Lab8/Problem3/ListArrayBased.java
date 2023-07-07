// ********************************************************
// Array-based implementation of the ADT list.
// *********************************************************
public class ListArrayBased<T> implements AscendinglyOrderedStringListInterface
{
	
    private static final int MAX_LIST = 3;
    protected static Object[]items;  // an array of list items
    protected static int numItems;  // number of items in list

    public ListArrayBased()
    {
        items = (T[]) new Object[MAX_LIST];
        numItems = 0;
    }  // end default constructor

    public boolean isEmpty()
    {
        return (numItems == 0);
    } // end isEmpty

    public int size()
    {
        return numItems;
    }  // end size

    public void add(int index, Object item)
    throws  ListIndexOutOfBoundsException
    {
        if (numItems == items.length)
        {
            throw new ListException("ListException on add");
        }  // end if
        if (index >= 0 && index <= numItems)
        {
            // make room for new element by shifting all items at
            // positions >= index toward the end of the
            // list (no shift if index == numItems+1)
            for (int pos = numItems-1; pos >= index; pos--)  //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException
            {
                items[pos+1] = items[pos];
            } // end for
            // insert new item
            items[index] = (T) item;
            numItems++;
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on add");
        }  // end if
    } //end add

    public String get(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            return items[index].toString();
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on get");
        }  // end if
    } // end get

    public void remove(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            // delete item by shifting all items at
            // positions > index toward the beginning of the list
            // (no shift if index == size)
            for (int pos = index+1; pos < numItems; pos++) //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException

            {
                items[pos-1] = items[pos];
            }  // end for
		items[numItems-1] = null;            
		numItems--;
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on remove");
        }  // end if
    } //end remove

	@Override
	public void add(String item) throws ListIndexOutOfBoundsException {
		int index = search(item);
		
        if (numItems == items.length)
        {
            throw new ListException("ListException on add");
        }  // end if
        if (index >= 0 && index <= numItems)
        {
            // make room for new element by shifting all items at
            // positions >= index toward the end of the
            // list (no shift if index == numItems+1)
            for (int pos = numItems-1; pos >= index; pos--)  //textbook code modified to eliminate logic error causing ArrayIndexOutOfBoundsException
            {
                items[pos+1] = items[pos];
            } // end for
            // insert new item
            items[index] = (T) item;
            numItems++;
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on add");
        }  // end if
		
	}


	@Override
	public int search(String item) {
		boolean found = false;
		
		
		int min = 0;
		int max = size()-1;
		int middle = ((min + max)/2);
		
		while(found == false)
		{
			if((min == size()) || (min == max))
			{
				found = true;
			}					
			else if(item.compareTo(items[min].toString()) > 0)
			{
				min = middle+1;
				middle = ((min + max)/2);
			}
			else if(item.compareTo(items[max].toString()) < 0)
			{
				max = middle;
				middle = middle/2;
			}
			else
			{
				found = true;
			}
		}

		if(min == size())
		{
			return min;
		}
		else
		{
			if(item.compareTo(items[middle].toString()) == 0)
			{
				System.out.println("Item found at Index " + middle + ".");
			}
			return middle;
		}
	}

	@Override
	public void clear() {
        items = (T[]) new Object[MAX_LIST];
        numItems = 0;
	}
}
