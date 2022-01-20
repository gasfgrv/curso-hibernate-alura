package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ClienteDao;
import br.com.alura.loja.dao.PedidoDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Cliente;
import br.com.alura.loja.modelo.ItemPedido;
import br.com.alura.loja.modelo.Pedido;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JpaUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDePedido {

    public static void main(String[] args) {
        popularBancoDeDados();

        EntityManager em = JpaUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        Produto produto = produtoDao.buscarPorId(1L);

        ClienteDao clienteDao = new ClienteDao(em);
        Cliente cliente = clienteDao.buscarPorId(1L);

        em.getTransaction().begin();

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(10, pedido, produto));

        PedidoDao pedidoDao = new PedidoDao(em);
        pedidoDao.cadastrar(pedido);

        em.getTransaction().commit();
        em.close();
    }

    private static void popularBancoDeDados() {
        Categoria celulares = new Categoria("Celulares");

        Produto celular = new Produto("iPhone",
                "Muito caro",
                new BigDecimal("8000"),
                celulares);

        Cliente cliente = new Cliente("Gustavo", "123456");

        EntityManager em = JpaUtil.getEntityManager();
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ProdutoDao produtoDao = new ProdutoDao(em);
        ClienteDao clienteDao = new ClienteDao(em);

        em.getTransaction().begin();
        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        clienteDao.cadastrar(cliente);
        em.getTransaction().commit();
        em.close();
    }

}
