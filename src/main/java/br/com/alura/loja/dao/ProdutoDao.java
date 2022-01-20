package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDao {

    private final EntityManager entityManager;

    public ProdutoDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Produto produto) {
         this.entityManager.persist(produto);
    }

    public Produto buscarPorId(Long id) {
        return entityManager.find(Produto.class, id);
    }

    public List<Produto> buscarTodos() {
        String jpql = "SELECT p FROM Produto p";
        return entityManager.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> buscarPorNome(String nome) {
        String jpql = "SELECT p FROM Produto p where p.nome = :nome";
        return entityManager.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Produto> buscarPorNomeDaCategoria(String nomeDaCategoria) {
        String jpql = "SELECT p FROM Produto p where p.categoria.nome = :nomeDaCategoria";
        return entityManager.createQuery(jpql, Produto.class)
                .setParameter("nomeDaCategoria", nomeDaCategoria)
                .getResultList();
    }

    public BigDecimal buscarPrecoDoProdutoComNome(String nome) {
        String jpql = "SELECT p.preco FROM Produto p where p.nome = :nome";
        return entityManager.createQuery(jpql, BigDecimal.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }
}
