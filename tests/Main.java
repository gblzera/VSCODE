public class Main {
    public static void main(String[] args){
    Cat cat = new Cat("Chloe", 1);

        System.out.println("Nome : " + cat.getName());
        System.out.println("Idade : " + cat.getAge());

        cat.setAge(20);

        cat.makeSound();
    }
}
