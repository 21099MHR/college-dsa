
public class StackRAB<T> implements StackInterface {

    private int top;
    private T[] items;

    public StackRAB()
    {
        items = (T[]) new Object[3];
        top = -1;
    }

    @Override
    public boolean isEmpty() {
        if(top == -1)
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
        items = (T[]) new Object[3];
        top = -1;
    }

    @Override
    public void push(Object newItem) throws StackException {
        if(top == items.length-1)
        {
            resize();
        }
        items[++top] = (T) newItem;
    }

    private void resize() {
        T[] newItems = (T[]) new Object[(items.length * (3/2)) + 1];

        for(int i = 0; i < items.length; i++)
        {
            newItems[i] = items[i];
        }

        items = newItems;
    }


    @Override
    public Object pop() throws StackException {
        T result = null;
        if(top != -1)
        {
            result = items[top];
            System.out.print("Item to be popped: " + result);
            items[top--] = null;
        }
        else
        {
            System.out.println("Stack is empty!");
        }
        return result;
    }

    @Override
    public T peek() throws StackException {

        T result = null;
        if(top != -1)
        {
            result = items[top];
        }
        else
        {
            System.out.println("List empty!");
        }
        return result;
    }

    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        String toReturn = "";

        for(int i = 0; i <= top; i++)
        {
            String name = items[i].toString() + " ";
            builder.append(name);
        }

        return toReturn = builder.toString();

    }


}
