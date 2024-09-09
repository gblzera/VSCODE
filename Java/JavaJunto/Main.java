public class Main {
    public String name;
    public int age;

    public static void main(String[] args) {
        
        
        Main dog = new Main();
        dog.name = "Rex";
        dog.age = 5;

       
        System.out.println("O nome do cachorro é: " + dog.name);
        System.out.println("A idade do cachorro é: " + dog.age);

      
        dog.age = -3; 
        System.out.println("A nova idade do cachorro: " + dog.age);

        dog.makeSound();

        dog.dogMakeSound();
    }

    public void makeSound() {
        System.out.println("O animal está fazendo um som.");
    }

    public void dogMakeSound() {
        System.out.println("O cachorro está latindo.");
    }
}
