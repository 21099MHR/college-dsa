/*

 * Purpose: Data Structure and Algorithms Lab 3 Problem 1

 * Status: Complete and thoroughly tested

 * Last update: 02/11/20

 * Submitted:  02/11/20

 * Comment: test suite and sample run attached

 * @author: Matthew Ryan

 * @version: 2020.02.11

 */

// Please note that this code is slightly different from the textbook code
//to reflect the fact that the Node class is implemented using data encapsulation


// ****************************************************
// Reference-based implementation of ADT list.
// ****************************************************
public class ListCDLSBased implements ListInterface
{
    // reference to linked list of items
    private DNode head;
    private int numItems;

    public ListCDLSBased()
    {
        head = null;
        numItems = 0;
    }  // end default constructor

    public boolean isEmpty()
    {
        return size() == 0;
    }  // end isEmpty

    public int size()
    {
        return numItems;
    }  // end size

    private Node find(int index)
    {
        // --------------------------------------------------
        // Locates a specified node in a linked list.
        // Precondition: index is the number of the desired
        // node. Assumes that 0 <= index <= numItems
        // Postcondition: Returns a reference to the desired
        // node.
        // --------------------------------------------------
        DNode curr = head;
        if(index <= numItems/2)
        {
            for (int skip = 0; skip < index; skip++)
            {
                curr = curr.getNext();
            }
        }
        else
        {
            for(int skip = numItems-1; skip > index; skip--)
            {
                curr = curr.getBack();
            }
        }

        return curr;
    } // end find

    public Object get(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            // get reference to node, then data in node
            Node curr = find(index);
            Object dataItem = curr.getItem();
            return dataItem;
        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds exception on get");
        } // end if
    } // end get

    public void add(int index, Object item)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems+1)
        {
            numItems++;
            if(numItems == 0)
            {
                DNode newNode = new DNode(item);
                head = newNode;
            }
            else if(index == numItems)
            {
                DNode prev = head.getBack();
                DNode newNode = new DNode(item, head, prev);
                head.setBack(newNode);
                prev.setNext(newNode);
            }
            else
            {
                DNode toFind = (DNode) find(index);
                DNode toAdd = new DNode(item, toFind, toFind.getBack());

                toFind.getBack().setNext(toAdd);
                toFind.setBack(toAdd);
            }
        }

        else
        {
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds exception on add");
        } // end if
    }  // end add

    public void remove(int index)
    throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < numItems)
        {
            numItems--;

            if(index == 0)
            {
                head = (DNode) find(index).getNext();
            }
            else if (index == numItems)
            {
                find(index-1).getNext().setNext(null);
            }
            else
            {
                DNode nodeBack = (DNode) find(index-1);
                DNode nodeFront = (DNode) find(index+1);

                nodeBack.setNext(nodeFront);
                nodeFront.setBack(nodeBack);
            }

        }
        else
        {
            throw new ListIndexOutOfBoundsException(
                "List index out of bounds exception on remove");
        } // end if
    }   // end remove

    public void removeAll()
    {
        // setting head to null causes list to be
        // unreachable and thus marked for garbage
        // collection
        head = null;
    } // end removeAll

    public String toString()
    {
        Node next = head;
        StringBuilder builder = new StringBuilder();
        String toReturn = "";

        while(next != null)
        {
            String name = next.getItem().toString() + " ";
            builder.append(name);
            next.getNext();
        }
        toReturn = builder.toString();

        return toReturn;
    }

} // end ListReferenceBased