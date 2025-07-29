package java_day3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();

        Element<Integer> element1 = new Element<Integer>(1);
        Element<Integer> element2 = new Element<Integer>(2);
        Element<Integer> element3 = new Element<Integer>(3);

        //adding elements to the list
        linkedList.add(element1);
        linkedList.add(element2);
        linkedList.add(element3);

        Scanner scanner = new Scanner(System.in);

        System.out.println("enter an element to delete :");
        int numToDelete = scanner.nextInt();

        //delete element from list
        linkedList.deleteElementFromList(numToDelete);


        //reversing linkedlist
        linkedList.reverseList();

        //iterating over list
        linkedList.iterateOverList(linkedList);

        //checking for loop
        Element loopAt = linkedList.hasLoop();

        if (loopAt == null)
        {
            System.out.println("No loop found");
        }
        else {
            System.out.println("Loop found at :" + loopAt.data);
        }

        //checking for mid of loop
        linkedList.findMiddleOfLoop();

        //find nth element from the list
        linkedList.findNthFromLast(4);

    }
}
