package br.com.alura.loja.testes;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.util.JpaUtil;
import lombok.extern.java.Log;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

@Log
public class CadastroDeProduto {

    public static void main(String[] args) {
        cadastrarProduto();
        Long id = 1L;
        EntityManager em = JpaUtil.getEntityManager();

        ProdutoDao produtoDao = new ProdutoDao(em);
        Produto produto = produtoDao.buscarPorId(id);

        log.info(produto.toString());

        List<Produto> produtos = produtoDao.buscarPorNomeDaCategoria("Celulares");
        produtos.forEach(p -> log.info(p.toString()));

        BigDecimal precoDoProduto = produtoDao.buscarPrecoDoProdutoComNome("iPhone");
        log.info("R$" + precoDoProduto);

    }

    private static void cadastrarProduto() {
        Categoria celulares = new Categoria("Celulares");

        Produto celular = new Produto("iPhone",
                "Muito caro",
                new BigDecimal("8000"),
                celulares);

        EntityManager em = JpaUtil.getEntityManager();
        CategoriaDao categoriaDao = new CategoriaDao(em);
        ProdutoDao produtoDao = new ProdutoDao(em);

        em.getTransaction().begin();
        categoriaDao.cadastrar(celulares);
        produtoDao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }

}
