/*

 * Purpose: Data Structure and Algorithms Lab 2 Problem 1

 * Status: Complete and thoroughly tested

 * Last update: 02/4/20

 * Submitted:  02/4/20

 * Comment: test suite and sample run attached

 * @author: Matthew Ryan

 * @version: 2020.02.4

 */

import java.util.ArrayList;

public class ListArrayListBased {

    private static final int MAX_LIST = 3;
    static ArrayList<Object> items;
    int numItems = 0;

    public ListArrayListBased()
    {
        items = new ArrayList<Object>(MAX_LIST);
    }

    public void removeAll()
    {
        for(int i = items.size()-1; i >= 0; i--)
        {
            items.remove(i);
        }
    }
    public void add(int index, Object item)
    throws  ListIndexOutOfBoundsException
    {
        items.add(index, item);
        numItems++;
    }

    public Object get(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            return items.get(index);
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
            items.remove(index);
        }
        else
        {
            // index out of range
            throw new ListIndexOutOfBoundsException(
                "ListIndexOutOfBoundsException on remove");
        }  // end if
    } //end remove


}
