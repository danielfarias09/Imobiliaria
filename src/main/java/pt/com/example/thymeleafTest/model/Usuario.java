package pt.com.example.thymeleafTest.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    private String email;
    
    private String nome;
    
    private String senha;
    
    private boolean ativo;
    
    @OneToMany(mappedBy = "usuario",fetch = FetchType.EAGER)
    private List<Permissao> permissoes;

    public Usuario() {}
    
    public Usuario(String email, String nome, String senha) {
        super();
        this.email = email;
        this.nome = nome;
        this.senha = senha;
        this.ativo = true;
    } 

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public List<Permissao> getPermissoes() {
        return permissoes;
    }
    
}
