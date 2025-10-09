package java_day2;

public class Element<T> {

    public T data;

    public Element next;

    public Element(T data) {
        this.data = data;
    }
}

class LinkedList {
    public Element head;
    public Element mover;

    public LinkedList() {
        this.head = null;
    }

    public <T> void add(Element<T> element) {
        if (head == null) {
            head = element;
            mover = head;
            return;
        }
        mover.next = element;
        mover = element;
        return;
    }

    public void iterateOverList(LinkedList list) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Element iterator = head;
        while (iterator != null) {
            System.out.println("data: " + iterator.data);
            iterator = iterator.next;
        }
    }

    public boolean searchFromList(int num) {
        if (head == null) {
            System.out.println("List is empty");
            return false;
        }
        Element iterator = head;

        while (iterator != null) {
            if ((int) iterator.data == num) {
                return true;
            }
            iterator = iterator.next;
        }
        return false;
    }

    public <T> void deleteElementFromList(int element) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if ((int) head.data == element && head.next == null) {
            head = null;
            System.out.println("element deleted successfully!");
            return;
        } else if ((int) head.data == element && head.next != null) {
            head = head.next;
            System.out.println("element deleted successfully!");
            return;
        }

        Element iterator = head;
        while (iterator.next != null) {
            if ((int) iterator.next.data == element) {
                iterator.next = iterator.next.next;
                System.out.println("java_day2.Element deleted sucessfully");
                return;
            }
            iterator = iterator.next;
        }
        System.out.println("element not found");
    }

    public Element hasLoop() {
        if (head == null || head.next == null) {
            return null;
        }

        Element slow = head;
        Element fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

    public void reverseList() {
        Element prev = null;
        Element current = head;
        Element next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }


    public Element findMiddleOfLoop() {
        Element meetingPoint = hasLoop();

        if (meetingPoint == null) {
            System.out.println("No loop found in the list.");
            return null;
        }

        Element ptr1 = head;
        Element ptr2 = meetingPoint;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        Element loopStart = ptr1;
        int loopLength = 1;
        Element current = loopStart.next;
        while (current != loopStart) {
            loopLength++;
            current = current.next;
        }

        Element middleOfLoop = loopStart;
        int stepsToMiddle = loopLength / 2;
        for (int i = 0; i < stepsToMiddle; i++) {
            middleOfLoop = middleOfLoop.next;
        }
        return middleOfLoop;
    }


}

