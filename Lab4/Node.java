/*

 * Purpose: Data Structure and Algorithms Lab 3 Problem 1

 * Status: Complete and thoroughly tested

 * Last update: 02/11/20

 * Submitted:  02/11/20

 * Comment: test suite and sample run attached

 * @author: Matthew Ryan

 * @version: 2020.02.11

 */

//please note that this code is different from the textbook code, because the data is encapsulated!

public class Node
{
    private Object item;
    private Node next;
    private Node back;

    public Node(Object newItem)
    {
        item = newItem;
        next = null;
    } // end constructor

    public Node(Object newItem, Node nextNode)
    {
        item = newItem;
        next = nextNode;
    } // end constructor

    public void setItem(Object newItem)
    {
        item = newItem;
    } // end setItem

    public Object getItem()
    {
        return item;
    } // end getItem

    public void setNext(Node nextNode)
    {
        next = nextNode;
    } // end setNext

    public Node getNext()
    {
        return next;
    } // end getNext


} // end class Node