package pt.com.example.thymeleafTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pt.com.example.thymeleafTest.model.Usuario;
import pt.com.example.thymeleafTest.model.UsuarioAplicacao;
import pt.com.example.thymeleafTest.repository.UsuarioRepository;

@Service
public class MeuUSerDetailsService implements UserDetailsService{
    
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    public MeuUSerDetailsService(UsuarioRepository usuarioRepository) {
        super();
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmail(username);
        
        if (usuario == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UsuarioAplicacao(usuario);
    }

}
