package br.com.alura.loja.dao;

import br.com.alura.loja.modelo.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao {

    private final EntityManager entityManager;

    public CategoriaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void cadastrar(Categoria categoria) {
        this.entityManager.persist(categoria);
    }

}
