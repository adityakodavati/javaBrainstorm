package JavaDay1;

public class Element<T> {

    public T data;

    public Element next;

    public Element(T data) {
        this.data = data;
    }
}

class LinkedList{
    public Element head;
    public Element mover;

    public LinkedList() {
        this.head = null;
    }

    public <T> void add(Element<T> element)
    {
        if(head == null)
        {
            head = element;
            mover = head;
            return;
        }
        mover.next = element;
        mover = element;
        return;
    }

    public  void iterateOverList(LinkedList list)
    {
        if (head == null)
        {
            System.out.println("List is empty");
            return;
        }
        Element iterator = head;
        while (iterator != null)
        {
            System.out.println("data: " +iterator.data);
            iterator = iterator.next;
        }
    }

    public  boolean searchFromList(int num)
    {
        if (head == null)
        {
            System.out.println("List is empty");
            return false;
        }
        Element iterator = head;

        while (iterator != null)
        {
            if ((int)iterator.data == num)
            {
               return true;
            }
            iterator = iterator.next;
        }
        return false;
    }

}

