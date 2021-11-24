package pt.com.example.thymeleafTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.com.example.thymeleafTest.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    Usuario findByEmail(String email);
}
