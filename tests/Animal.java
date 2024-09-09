public class Animal{
    private String name;
    private int age;
    
    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        if(age > 0){
            this.age = age;
        }else{
            System.out.println("A idade deve ser positiva.");
        }
    }
    //Polimorfismo
    protected void makeSound(){
        System.out.println("O animal está fazendo um som.");
    }
}