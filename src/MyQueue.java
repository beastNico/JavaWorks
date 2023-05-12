import java.util.LinkedList;

public class MyQueue<E> 
{
    private LinkedList<E> list;

    public MyQueue()
    {
        list = new LinkedList<>();
    }

    public MyQueue(E[] e)
    {
        list = new LinkedList<>();

        for (E element : e) 
        {
            list.addLast(element);    
        }
    }

    public void enqueue(E e)
    {
        list.addLast(e);
    }

    public E dequeue()
    {
        if(isEmpty())
        {
            System.out.println("Queue is empty");
            return null;
        }

        E data = list.getFirst();
        list.removeFirst();
        return data;
    }

    public E getElement(int i)
    {
        if(i < 0 || i >= size())
        {
            throw new IndexOutOfBoundsException("Index is out of bound");
        }
        return list.get(i);
    }

    public E peek()
    {
        if(isEmpty())
        {
            System.out.println("Queue is empty");
            return null;
        }
        return list.getFirst(); 
    }

    public int size()
    {
        return list.size();
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

    public boolean contains(E e)
    {
        return list.contains(e);
    }

    @Override
    public String toString()
    {
        return list.toString();
    }

    public static void main(String[] args) 
    {
        String[] fruitArr = {"Durian", "Blueberry"};
        MyQueue<String> fruitQ = new MyQueue<>(fruitArr);
        System.out.println("Intial queue : " + fruitQ);
        
        fruitQ.enqueue("Apple");
        fruitQ.enqueue("Orange");
        fruitQ.enqueue("Grapes");
        fruitQ.enqueue("Cherry");

        System.out.println("After adding some items : " + fruitQ);
        System.out.println("The top item in the queue : " + fruitQ.peek());
        System.out.println("The size of the queue : " + fruitQ.size());
        fruitQ.dequeue();
        System.out.println("The item at the searched position : " + fruitQ.getElement(1));
        System.out.println("Does the queue contain the searched item : " + fruitQ.contains("Cherry"));
        System.out.println("Does the queue contain the searched item : " + fruitQ.contains("Durian"));
        System.out.println("Queue is empty? " + fruitQ.isEmpty());
    }

}