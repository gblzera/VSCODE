public class Main {
    public static void main(String[] args) {
        String catName = "Chloe";
        int catAge = 1;

        System.out.println("Nome do gato(a): " + catName);
        System.out.println("Idade do gato(a): " + catAge);

        makeCatSound();

        describreCat(catName, catAge);
    }

    public static void makeCatSound(){
        System.out.println("O gato está miando.");
    }

    public static void describreCat(String name, int age){
        System.out.println("Gato(a) " + name + ", idade " + age + " anos.");
    }
}


