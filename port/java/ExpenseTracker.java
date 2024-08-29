import java.util.ArrayList;
import java.util.Scanner;

class Expense {
    private String date;
    private String category;
    private double amount;

    public Expense(String date, String category, double amount){
        this.date = date;
        this.category = category;
        this.amount = amount;
    }

    public String getDate(){
        return date;
    }

    public String getCategory(){
        return category;
    }

    public double getAmount(){
        return amount;
    }
}

class User{
    private String username;
    private String password;

    public User(String username, String  password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public boolean authenticate(String password){
        return this.password.equals(password);
    }
}

public class ExpenseTracker{
    private ArrayList<Expense> expenses;
    private Scanner scanner;
    private User user;

    public ExpenseTracker(User user){
        this.user = user;
        this.expenses = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    private boolean login(){
        System.out.println("Úsuario: ");
        String username = scanner.next();
        System.out.println("Senha: ");
        String password = scanner.next();

        if (user.getUsername().equals(username) && user.authenticate(password)){
            System.out.println("Login bem-sucedido!");
            return true;
        } else {
            System.out.println("Úsuario ou senha incorretos.");
            return false;
            }
        }

    public void addExpense(){
        System.out.println("Data (dd/mm/aaaa)");
        String date = scanner.next();
        System.out.println("Categoria:");
        String category = scanner.next();
        System.out.println("Valor:");
        double amount = scanner.nextDouble();

        Expense expense = new Expense(date, category, amount);
        expenses.add(expense);
        System.out.println("Despesa adicionada com sucesso!");
    }

    public void viewExpenses(){
        if(expenses.isEmpty()){
            System.out.println("Sem despesas até o momento!");
        } else {
            for(Expense expense : expenses ){
                System.out.println("Data: " + expense.getDate());
                System.out.println("Categoria: " + expense.getCategory());
                System.out.println("Valor: " + expense.getAmount());
                System.out.println();
            }
        }
    }

    public void generateMonthlyReport(){
        if (expenses.isEmpty()){
            System.out.println("Sem despesas até o momento!");
        } else {
            double total = 0;
            for (Expense expense : expenses){
                total += expense.getAmount();
            }
            System.out.println("Total de despesas do mês: " + total);
        }
    }

    public void run(){
        if(!login()){
            return;
        }

        while(true){
            System.out.println("1. Adicionar despesa");
            System.out.println("2. Vizualisar despesas");
            System.out.println("3. Gerar relatório mensal");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    generateMonthlyReport();
                    break;
                case 4:
                    System.out.println("Saíndo...");
                    return;
                default:
                    System.out.println("Escolha inválida, tente novamente.");
            }
        }
    }

    public static void main(String[] args){
        User user = new User("admin", "password123");
        ExpenseTracker tracker = new ExpenseTracker(user);
        tracker.run();
    }
}