import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> itens = new ArrayList<>();

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Item item : itens) {
            total += item.getDesconto().calcular(item.getPreco());
        }
        return total;
    }
}
