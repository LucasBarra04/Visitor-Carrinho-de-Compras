package Classes;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompras {
    private final List<ItemCarrinho> itens = new ArrayList<>();

    public void adicionarItem(ItemCarrinho item) {
        itens.add(item);
    }

    public void removerItem(ItemCarrinho item) {
        itens.remove(item);
    }

    public void aceitar(VisitanteCarrinho visitante) {
        for (ItemCarrinho item : itens) {
            item.aceitar(visitante);
        }
    }

    public double calcularTotal() {
        VisitantePreco visitantePreco = new VisitantePreco();
        aceitar(visitantePreco);
        return visitantePreco.getTotal();
    }

    public String imprimirCupom() {
        VisitanteImpressao visitanteImpressao = new VisitanteImpressao();
        aceitar(visitanteImpressao);
        return visitanteImpressao.getResultado();
    }
}