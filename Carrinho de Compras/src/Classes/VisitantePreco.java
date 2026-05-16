package Classes;

public class VisitantePreco implements VisitanteCarrinho {
    private double total = 0.0;

    @Override
    public void visitar(Livro livro) {
        total += livro.getPreco() * livro.getQuantidade();
    }

    @Override
    public void visitar(Fruta fruta) {
        total += fruta.getPrecoPorKg() * fruta.getPeso();
    }

    @Override
    public void visitar(Eletronico eletronico) {
        total += eletronico.getPreco() * eletronico.getQuantidade();
    }

    public double getTotal() {
        return total;
    }

    public void resetar() {
        total = 0.0;
    }
}
