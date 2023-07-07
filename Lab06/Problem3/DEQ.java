
public class DEQ<T> extends Queue<T> implements ExtendedQueueInterface<T> {


    public DEQ()
    {
        super();
    }

    @Override
    public void enqueueFirst(Object newItem) throws ExtendedQueueException {
        if(numItems == items.length)
        {
            super.resize();
        }

        front = (front + items.length-1)%items.length;

        items[front] = (T) newItem;
        numItems++;
    }

    @Override
    public T dequeueLast() throws ExtendedQueueException {
        T result = null;
        if(numItems > 0)
        {
            back = (back + items.length-1)%items.length;
            result = items[back];
            items[back] = null;
            numItems--;
        }
        return result;
    }

    @Override
    public T peekLast() throws ExtendedQueueException {
        T result = null;
        if(numItems > 0)
        {
            result = items[(back + items.length-1)%items.length];
        }
        else
        {
            System.out.println("Queue empty!");
        }
        return result;
    }

}
