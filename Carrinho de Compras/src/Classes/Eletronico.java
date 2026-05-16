package Classes;

public class Eletronico implements ItemCarrinho {
    private final String nome;
    private final double preco;
    private final int quantidade;

    public Eletronico(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() { return nome; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }

    @Override
    public void aceitar(VisitanteCarrinho visitante) {
        visitante.visitar(this);
    }
}