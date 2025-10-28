package comparatorAndComparable;

public class Person implements Comparable<Person> {
//public class Person implements Comparable<Person> {

    String name;

    int id;

    public Person() {
    }

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

/*    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }*/

    
}
