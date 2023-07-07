
public class StackSLS<T> implements StackInterface {

    private Node top;

    public <T> StackSLS()
    {
        top = null;
    }

    @Override
    public boolean isEmpty() {
        if(top == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void popAll() {
        top = null;
    }

    @Override
    public void push(Object newItem) throws StackException {
        top = new Node(newItem, top);
    }

    @Override
    public T pop() throws StackException {
        T result = null;
        if(top != null)
        {
            result = (T) top.getItem();
            top = top.getNext();
        }
        return result;
    }

    @Override
    public T peek() throws StackException {
        T result = null;
        if(top != null)
        {
            result = (T) top.getItem();
        }
        return result;
    }

    public String toString()
    {
        Node<T> next = top;
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
