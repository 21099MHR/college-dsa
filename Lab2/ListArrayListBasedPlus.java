/*

 * Purpose: Data Structure and Algorithms Lab 2 Problem 1

 * Status: Complete and thoroughly tested

 * Last update: 02/4/20

 * Submitted:  02/4/20

 * Comment: test suite and sample run attached

 * @author: Matthew Ryan

 * @version: 2020.02.4

 */

import java.util.Collections;

public class ListArrayListBasedPlus extends ListArrayListBased {

    public ListArrayListBasedPlus()
    {
        super();
    }

    public void toString(Object []items)
    {
        for(int i = 0; i < items.length; i++)
        {
            System.out.print(items[i]);
        }
    }

    public void reverseArray()
    {
        Collections.reverse(items);
    }

    public int size() {
        // TODO Auto-generated method stub
        return items.size();
    }

}

