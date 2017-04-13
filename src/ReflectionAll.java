
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Write a program to read all field and method names of a class using reflection
 */

class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private void print() {
        System.out.println("ID: " + id + " Name: " + name);
    }

}

public class ReflectionAll {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        Student s = new Student(1, "Akhil");

        Field[] fields = s.getClass().getDeclaredFields();
        System.out.println("Reflection Student Fields");
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            System.out.println(fields[i].getName() + " : " + fields[i].get(s));
        }
        fields[1].set(s, "Gunjan");
        System.out.println("Reflection Student Fields by setting value");
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            System.out.println(fields[i].getName() + " : " + fields[i].get(s));
        }

        Method[] methods = s.getClass().getDeclaredMethods();
        System.out.println("Reflection Student Method");
        for (int i = 0; i < methods.length; i++) {
            methods[i].setAccessible(true);
            System.out.println("Method Name: " + methods[i].getName());
            methods[i].invoke(s);
        }
    }
}
