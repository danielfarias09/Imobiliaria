package pt.com.example.thymeleafTest.dto;

import java.math.BigDecimal;

import pt.com.example.thymeleafTest.model.TipoImovel;

public class FiltroDTO {
    
    private String descricao;
    
    private BigDecimal precoMin;
    
    private BigDecimal precoMax;
    
    private TipoImovel tipo;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoMin() {
        return precoMin;
    }

    public void setPrecoMin(BigDecimal precoMin) {
        this.precoMin = precoMin;
    }

    public BigDecimal getPrecoMax() {
        return precoMax;
    }

    public void setPrecoMax(BigDecimal precoMax) {
        this.precoMax = precoMax;
    }

    public TipoImovel getTipo() {
        return tipo;
    }

    public void setTipo(TipoImovel tipo) {
        this.tipo = tipo;
    }
}
