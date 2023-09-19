package br.com.alura.loja.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @EmbeddedId
    private CategoriaId categoriaId;

    public Categoria() {
    }

    public Categoria(String nome) {
        this.categoriaId = new CategoriaId(nome, "Teste");
    }

    public CategoriaId getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(CategoriaId categoriaId) {
        this.categoriaId = categoriaId;
    }
}
