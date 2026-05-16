package Classes;

public class VisitanteImpressao implements VisitanteCarrinho {
    private final StringBuilder sb = new StringBuilder();

    @Override
    public void visitar(Livro livro) {
        sb.append("Livro: ").append(livro.getTitulo())
                .append(" - Preço unitário: R$").append(livro.getPreco())
                .append(" - Quantidade: ").append(livro.getQuantidade())
                .append(" - Subtotal: R$").append(livro.getPreco() * livro.getQuantidade())
                .append("\n");
    }

    @Override
    public void visitar(Fruta fruta) {
        sb.append("Fruta: ").append(fruta.getNome())
                .append(" - Preço por kg: R$").append(fruta.getPrecoPorKg())
                .append(" - Peso: ").append(fruta.getPeso()).append("kg")
                .append(" - Subtotal: R$").append(fruta.getPrecoPorKg() * fruta.getPeso())
                .append("\n");
    }

    @Override
    public void visitar(Eletronico eletronico) {
        sb.append("Eletrônico: ").append(eletronico.getNome())
                .append(" - Preço unitário: R$").append(eletronico.getPreco())
                .append(" - Quantidade: ").append(eletronico.getQuantidade())
                .append(" - Subtotal: R$").append(eletronico.getPreco() * eletronico.getQuantidade())
                .append("\n");
    }

    public String getResultado() {
        return sb.toString();
    }

    public void resetar() {
        sb.setLength(0);
    }
}