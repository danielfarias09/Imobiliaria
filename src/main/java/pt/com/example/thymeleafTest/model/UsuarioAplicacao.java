package pt.com.example.thymeleafTest.model;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioAplicacao implements UserDetails{

    private static final long serialVersionUID = 4276228729885500916L;
    
    private Usuario usuario;
    
    private Set<? extends GrantedAuthority> grantedAuthorities;
    private String username;
    private String password;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;
    
    public UsuarioAplicacao(Usuario usuario) {
        this.usuario = usuario;
        this.grantedAuthorities = getPermissoes();
        this.username = usuario.getEmail();
        this.password = usuario.getSenha();
        this.isAccountNonExpired = true;
        this.isAccountNonLocked = true;
        this.isCredentialsNonExpired = true;
        this.isEnabled = true;
    }
    
    private Set<SimpleGrantedAuthority> getPermissoes(){
        return  usuario.getPermissoes().stream()
            .map(permissao -> new SimpleGrantedAuthority(permissao.getNomePermissao()))
            .collect(Collectors.toSet());
    }   

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
