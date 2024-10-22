import java.io.FileNotFoundException;
import java.io.FileReader;

public class Errors_and_Exceptions {
    public static void main(String[] args) {
        // StackOverflowError
        try {
            stackOverflowErrorExample();
        } catch (StackOverflowError e) {
            System.out.println("Erro: " + e);
        }
        
        // NullPointerException
        try {
            nullPointerExceptionExample();
        } catch (NullPointerException e) {
            System.out.println("Erro: " + e);
        }
        
        // ArrayIndexOutOfBoundsException
        try {
            arrayIndexOutOfBoundsExample();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Erro: " + e);
        }
        
        // NumberFormatException
        try {
            numberFormatExceptionExample();
        } catch (NumberFormatException e) {
            System.out.println("Erro: " + e);
        }
        
        // ArithmeticException
        try {
            arithmeticExceptionExample();
        } catch (ArithmeticException e) {
            System.out.println("Erro: " + e);
        }
        
        // FileNotFoundException
        try {
            fileNotFoundExceptionExample();
        } catch (FileNotFoundException e) {
            System.out.println("Erro: " + e);
        }
        
        // ClassCastException
        try {
            classCastExceptionExample();
        } catch (ClassCastException e) {
            System.out.println("Erro: " + e);
        }
    }
    
    // StackOverflowError
    public static void stackOverflowErrorExample() {
        recursiveMethod();
    }

    public static void recursiveMethod() {
        recursiveMethod(); // chamada recursiva infinita
    }
    
    // NullPointerException
    public static void nullPointerExceptionExample() {
        String str = null;
        System.out.println(str.length()); // Vai causar NullPointerException
    }
    
    // ArrayIndexOutOfBoundsException
    public static void arrayIndexOutOfBoundsExample() {
        int[] arr = {1, 2, 3};
        System.out.println(arr[3]); // Vai causar ArrayIndexOutOfBoundsException
    }
    
    // NumberFormatException
    public static void numberFormatExceptionExample() {
        String invalidNumber = "abc";
        int number = Integer.parseInt(invalidNumber); // Vai causar NumberFormatException
    }
    
    // ArithmeticException
    public static void arithmeticExceptionExample() {
        int result = 10 / 0; // Vai causar ArithmeticException
    }
    
    // FileNotFoundException
    public static void fileNotFoundExceptionExample() throws FileNotFoundException {
        FileReader file = new FileReader("arquivo_inexistente.txt"); // Vai causar FileNotFoundException
    }
    
    // ClassCastException
    public static void classCastExceptionExample() {
        Object obj = new String("Texto");
        Integer num = (Integer) obj; // Vai causar ClassCastException
    }
}
