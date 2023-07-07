
public class QueueRAB<T> implements QueueInterface<T>  {

	protected int numItems;
	protected int front;
	protected int back;
	protected T[] items;
	
	public QueueRAB()
	{
		numItems = 0;
		back = 0;
		front = 0;
		items = (T[]) new Object[3];
	}
	
	
	@Override
	public boolean isEmpty() {
		return (numItems == 0);
	}

	@Override
	public void enqueue(Object newItem) throws QueueException {
		if(numItems == items.length)
		{	
			resize();
		}
		items[back] = (T) newItem;
		back = (back+1)%items.length;
		numItems++;
		
	}
	
	@Override
	public T dequeue() throws QueueException {
		T result = null;
		if(numItems > 0)
		{
			result = items[front];
			items[front] = null;
			front = (front + 1)%items.length;
			numItems--;
		}		
		return result;
	}

	@Override
	public void dequeueAll() {		
		numItems = 0;
		back = 0;
		front = 0;
		items = (T[]) new Object[3];
	}

	@Override
	public T peek() throws QueueException {
		
		T result = null;
		if(numItems > 0)
		{
			result = items[front];
		}
		else
		{
			System.out.println("Queue empty!");
		}
		return result;
		
	}
	
	public String toString()
	{
		   StringBuilder builder = new StringBuilder();
		   String toReturn = "";
		int counter = 0;
		for(int i = front; counter < numItems; counter++)
		{

			String name = items[(i)].toString() + " ";
			builder.append(name);
			i = (i+1) % items.length;
		}
		
		return toReturn = builder.toString();	
		
	}

	private void resize() {
		T[] temp = (T[]) new Object[items.length + ((items.length/2) + 1)];
		System.out.println();
		int conuter = 0;
		for(int i = front; conuter < numItems; conuter++)
		{
			temp[conuter] = items[i];
			i = (i+1) % items.length;
		}
		
		items = temp;
		front = 0;
		back = numItems;
		
	}
	
}
