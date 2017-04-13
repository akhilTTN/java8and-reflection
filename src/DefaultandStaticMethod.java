

/**
 * Write a program having interface with default and static methods and call them also in your main method
 */

interface Interface1 {

    static boolean isNull(String str) {
        System.out.println("Interface Null Check");

        return str == null ? true : "".equals(str) ? true : false;
    }

    void method1(String str);

    default void log(String str) {
        System.out.println("I1 logging::" + str);
    }

    default void print(String str) {
        if (!isNull(str))
            System.out.println("MyData Print::" + str);
    }
}


public class DefaultandStaticMethod implements Interface1 {

    public static void main(String[] args) {
        DefaultandStaticMethod dsm = new DefaultandStaticMethod();
        dsm.log("Hello");
        dsm.print("abc");
        System.out.println(dsm.isNull("abc"));
        System.out.println(Interface1.isNull("abc"));
    }

    @Override
    public void method1(String str) {
    }

    @Override
    public void log(String str) {
        System.out.println("MyClass logging::" + str);
    }

    public boolean isNull(String str) {
        System.out.println("Impl Null Check");

        return str == null ? true : false;
    }
}
