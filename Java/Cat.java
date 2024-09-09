//Subclasse que herda da classe Animal

public class Cat extends Animal{
    public Cat(String name, int age){
        super(name, age);
    }

    //Polimorfismo
    @Override
        public void makeSound(){
            System.out.println("Meow!");
        }
}