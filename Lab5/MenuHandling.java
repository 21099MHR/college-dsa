import java.util.LinkedList;

public class MenuHandling {

    public static <T> T peek(StackInterface<T> items) {
        return items.peek();
    }

    public static <T> StackInterface<T> push(T item, StackInterface<T> items) {
        items.push(item);
        return items;
    }

    public static <T> T pop(StackInterface<T> items)
    {
        return items.pop();
    }

    public static <T> String showAll(StackInterface<T> items)
    {
        return items.toString();
    }
}
