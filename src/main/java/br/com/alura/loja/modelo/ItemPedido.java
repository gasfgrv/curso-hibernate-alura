package br.com.alura.loja.modelo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "itens_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;
    private Integer quantidade;
    @ManyToOne
    private Pedido pedido;
    @ManyToOne
    private Produto produto;

    public ItemPedido(Integer quantidade, Pedido pedido, Produto produto) {
        this.quantidade = quantidade;
        this.pedido = pedido;
        this.precoUnitario = produto.getPreco();
        this.produto = produto;
    }
}
