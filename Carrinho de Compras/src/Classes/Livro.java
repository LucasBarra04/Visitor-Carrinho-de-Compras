package Classes;

public class Livro implements ItemCarrinho {
    private final String titulo;
    private final double preco;
    private final int quantidade;

    public Livro(String titulo, double preco, int quantidade) {
        this.titulo = titulo;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getTitulo() { return titulo; }
    public double getPreco() { return preco; }
    public int getQuantidade() { return quantidade; }

    @Override
    public void aceitar(VisitanteCarrinho visitante) {
        visitante.visitar(this);
    }
}
