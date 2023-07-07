
public class QueueSLS<T> implements QueueInterface {

    Node<T> front;
    Node<T> back;

    public QueueSLS()
    {
        front = null;
        back = null;
    }

    @Override
    public boolean isEmpty() {

        if(front == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void enqueue(Object newItem) throws QueueException {
        if(back == null)
        {
            front = back = new Node(newItem);
        }
        else
        {
            Node temp = new Node(newItem);
            back.setNext(temp);
            back = temp;
        }
    }

    @Override
    public Object dequeue() throws QueueException {

        Object result = null;

        if(front.getNext() != null)
        {
            result = front.getItem();
            front = front.getNext();
            if(front == null)
            {
                back = null;
            }
        }

        return result;
    }

    @Override
    public void dequeueAll() {
        front = null;
        back = null;
    }

    @Override
    public Object peek() throws QueueException {
        return front.getItem();
    }

    public String toString()
    {
        Node<T> next = front;
        StringBuilder builder = new StringBuilder();
        String toReturn = "";

        while(next != null)
        {
            String name = next.getItem().toString() + " ";
            builder.append(name);
            next = next.getNext();
        }
        toReturn = builder.toString();

        return toReturn;

    }

}
