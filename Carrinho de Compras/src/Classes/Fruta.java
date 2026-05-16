package Classes;

public class Fruta implements ItemCarrinho {
    private final String nome;
    private final double precoPorKg;
    private final double peso;

    public Fruta(String nome, double precoPorKg, double peso) {
        this.nome = nome;
        this.precoPorKg = precoPorKg;
        this.peso = peso;
    }

    public String getNome() { return nome; }
    public double getPrecoPorKg() { return precoPorKg; }
    public double getPeso() { return peso; }

    @Override
    public void aceitar(VisitanteCarrinho visitante) {
        visitante.visitar(this);
    }
}