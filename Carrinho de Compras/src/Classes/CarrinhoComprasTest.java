package Classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarrinhoComprasTest {
    private CarrinhoCompras carrinho;

    @BeforeEach
    void setUp() {
        carrinho = new CarrinhoCompras();
    }

    @Test
    void testCalcularTotalComLivrosEEletronicos() {
        carrinho.adicionarItem(new Livro("Padrões de Projeto", 45.90, 2));
        carrinho.adicionarItem(new Eletronico("Mouse", 79.90, 1));
        double esperado = (45.90 * 2) + 79.90;
        assertEquals(esperado, carrinho.calcularTotal(), 0.001);
    }

    @Test
    void testCalcularTotalComFrutas() {
        carrinho.adicionarItem(new Fruta("Maçã", 5.99, 1.5));
        double esperado = 5.99 * 1.5;
        assertEquals(esperado, carrinho.calcularTotal(), 0.001);
    }

    @Test
    void testCalcularTotalComItensMisturados() {
        carrinho.adicionarItem(new Livro("Código Limpo", 62.90, 1));
        carrinho.adicionarItem(new Fruta("Banana", 3.49, 2.0));
        carrinho.adicionarItem(new Eletronico("Teclado", 120.00, 1));
        double esperado = 62.90 + (3.49 * 2.0) + 120.00;
        assertEquals(esperado, carrinho.calcularTotal(), 0.001);
    }

    @Test
    void testCarrinhoVazioTotal() {
        assertEquals(0.0, carrinho.calcularTotal(), 0.001);
    }

    @Test
    void testImprimirCupomContemTodosItens() {
        Livro livro = new Livro("Java Efetivo", 89.90, 1);
        Fruta fruta = new Fruta("Laranja", 4.50, 0.8);
        carrinho.adicionarItem(livro);
        carrinho.adicionarItem(fruta);
        String cupom = carrinho.imprimirCupom();
        assertTrue(cupom.contains("Java Efetivo"));
        assertTrue(cupom.contains("Laranja"));
        assertTrue(cupom.contains("89.9"));
        assertTrue(cupom.contains("4.5"));
    }

    @Test
    void testRemoverItem() {
        Livro livro = new Livro("TDD", 55.00, 1);
        carrinho.adicionarItem(livro);
        assertEquals(55.00, carrinho.calcularTotal(), 0.001);
        carrinho.removerItem(livro);
        assertEquals(0.0, carrinho.calcularTotal(), 0.001);
    }

    @Test
    void testVisitantePrecoIndependente() {
        VisitantePreco visitante = new VisitantePreco();
        carrinho.adicionarItem(new Eletronico("Monitor", 850.00, 1));
        carrinho.aceitar(visitante);
        assertEquals(850.00, visitante.getTotal(), 0.001);
        visitante.resetar();
        assertEquals(0.0, visitante.getTotal(), 0.001);
        carrinho.aceitar(visitante);
        assertEquals(850.00, visitante.getTotal(), 0.001);
    }
}