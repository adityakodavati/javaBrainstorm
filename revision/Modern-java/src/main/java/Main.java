import comparatorAndComparable.Person;
import modernJava.FunctionalInterface;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        FunctionalInterface functionalInterface = () -> System.out.println("Printing from functional interface");

        functionalInterface.greetUsingFunctionalInterface();

        //List of functional interfaces

        //Consumer takes 1 arg and returns void contains accept()
        Consumer<String> stringConsumer = (data) -> System.out.println(data.toUpperCase());
        stringConsumer.accept("aditya kodavati");

        //takes nothing and returns value T contains get()
        Supplier<LocalTime> timeSupplier = () -> LocalTime.now();
        System.out.println("Use of supplier() :" + timeSupplier.get());


        //takes 2 args and returns value T contains apply()
        Function<Integer, String> intToStringConverter = number -> "Given number is :" + number;
        System.out.println(intToStringConverter.apply(1010));
        System.out.println();


        //takes 1 arg and returns boolean contains test()
        Predicate<Integer> predicate = number -> number % 2 == 0;
        System.out.println("Use of predicate :" + predicate.test(908));


        List<Person> personArrayList = Arrays
                .asList(new Person("Aditya", 25),
                        new Person("Giri", 23),
                        new Person("Bala", 24)
                );

        Collections.sort(personArrayList);

        for (Person person : personArrayList) {
            System.out.println(person.toString());
        }

        personArrayList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.valueOf(o1.getId()).compareTo(Integer.valueOf(o1.getId()));
            }
        });

        int result = personArrayList.stream().map(person -> person.getId()).reduce(0, (a, b) -> a + b);

        System.out.println("Result using streams map and reduce" + result);
    }
}
