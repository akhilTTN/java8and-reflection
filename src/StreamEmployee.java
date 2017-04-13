import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Create a class Employee with name and age.
 * Then write a program to print all those employees whose name start with n and age is greater then 24.
 */
public class StreamEmployee {

    Comparator<Employee> byAge = (Employee o1, Employee o2) -> Integer.compare(o1.getAge(), o2.getAge());

    void filterEmployee(List<Employee> list)
    {
        list.stream().filter(e -> e.getName().toLowerCase().startsWith("n") && e.getAge() > 24).sorted(byAge).forEach(e-> System.out.println(" Name: " + e.getName() + " Age: " + e.getAge()));
    }

    public static void main(String[] args) {
        StreamEmployee se = new StreamEmployee();
        Employee e1 = new Employee("Prashant", 25);
        Employee e2 = new Employee("Gunjan", 24);
        Employee e3 = new Employee("Kanishka", 24);
        Employee e4 = new Employee("Akhil", 25);
        Employee e5 = new Employee("Nikhil", 25);
        Employee e6 = new Employee("Nitin", 26);

        ArrayList<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(e5);
        list.add(e6);

        se.filterEmployee(list);
    }
}
