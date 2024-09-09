//Herança

public class Cat extends Animal {
    public Cat(String name, int age){
        super(name, age);
    }

    @Override
    protected void makeSound(){
        System.out.println("O gato faz miau!");
    }
}