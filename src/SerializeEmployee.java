
import java.io.*;

/**
 * Write a program to serialize a class Employee with property name and then deserialize it
 */
class Employee implements Serializable {
    private static final long serialVersionUID = 10L;
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    void serializeEmployee(Employee e) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File("/home/akhil/SerializeEmployeeOutput.txt")));
        out.writeObject(e);
        out.flush();
        out.close();
    }

    void deSerializeEmployee() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("/home/akhil/SerializeEmployeeOutput.txt")));
        Employee e = (Employee) in.readObject();
        System.out.println("Employee Name: " + e.getName());
        in.close();
    }
}

public class SerializeEmployee {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee e = new Employee("akhil", 24);
        e.serializeEmployee(e);
        e.deSerializeEmployee();
    }
}
