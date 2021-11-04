package pt.com.example.thymeleafTest.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Imovel {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message="A descrição do imóvel deve estar preenchida")
    private String descricao;
    
    @NotNull(message="O preço do imóvel deve estar preenchido")
    private BigDecimal preco;
    
    @NotNull(message="O tipo de imóvel deve estar selecionado")
    @Enumerated(EnumType.STRING)
    private TipoImovel tipo;
    
    public Imovel() {
        super();
    }

    public Imovel(String descricao, BigDecimal preco, TipoImovel tipo) {
        super();
        this.descricao = descricao;
        this.preco = preco;
        this.tipo = tipo;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public TipoImovel getTipo() {
        return tipo;
    }

    public void setTipo(TipoImovel tipo) {
        this.tipo = tipo;
    }
  
}
