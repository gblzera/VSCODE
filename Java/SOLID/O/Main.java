//package Java.SOLID.O;

public class Main {
    public static void main(String[] args){
        //Criando itens
        Item eletronico = new Item("MacBook Pro", 49999.0, new DescontoEletronicos());
        Item roupa = new Item("Boné Senna",  317.99, new DescontoRoupas());
        Item outro = new Item("Livro", 49.99, new DescontoComum());

        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        carrinho.adicionarItem(eletronico);
        carrinho.adicionarItem(roupa);
        carrinho.adicionarItem(outro);

        System.out.println("Total da compra: R$ " + carrinho.calcularTotal());
    }
}
