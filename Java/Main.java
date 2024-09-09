public class Main{
    public static void main(String[] args){
        Cat cat = new Cat("Chloe", 1);

        System.out.println("O nome do gato(a) é:  " + cat.getName());
        System.out.println("A idade do gato(a) é: " + cat.getAge());

        cat.setAge(-2);

        cat.makeSound();

        Common.printDivider();
    }
}