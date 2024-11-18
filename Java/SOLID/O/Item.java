//package Java.SOLID.O;

public class Item {
    private String nome;
    private double preco;
    private Desconto desconto;

    public Item(String nome, double preco, Desconto desconto){
        this.nome = nome;
        this.preco = preco;
        this.desconto = desconto;
    }

    public String getNome(){
        return nome;
    }

    public double getPreco(){
        return preco;
    }

    public Desconto getDesconto(){
        return desconto;
    }
}
