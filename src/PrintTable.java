import java.util.stream.IntStream;

/**
 * Write a program to print a table of any number using lambda expression
 */
public class PrintTable {
    interface MathOperation {
        void operation(int val);
    }
    void printTableForNumber(int number) {
        IntStream.range(1, 11)
                .map( i-> number*i )
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        PrintTable pt = new PrintTable();
        pt.printTableForNumber(2);
    }
}
