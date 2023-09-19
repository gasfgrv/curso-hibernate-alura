package br.com.alura.loja.vo;

import java.time.LocalDate;
import lombok.Getter;

@Getter
public class RelatorioDeVendasVo {

    private final String nomeProduto;
    private final Long quantidadeVendida;
    private final LocalDate dataUltimaVenda;

    public RelatorioDeVendasVo(String nomeProduto, Long quantidadeVendida, LocalDate dataUltimaVenda) {
        this.nomeProduto = nomeProduto;
        this.quantidadeVendida = quantidadeVendida;
        this.dataUltimaVenda = dataUltimaVenda;
    }

    @Override
    public String toString() {
        return "RelatorioDeVendasVo [nomeProduto=" + nomeProduto +
                ", quantidadeVendida=" + quantidadeVendida +
                ", dataUltimaVenda=" + dataUltimaVenda + "]";
    }

}
