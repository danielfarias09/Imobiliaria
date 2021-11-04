package pt.com.example.thymeleafTest.service;

import static org.springframework.data.jpa.domain.Specification.where;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import pt.com.example.thymeleafTest.dto.FiltroDTO;
import pt.com.example.thymeleafTest.model.Imovel;
import pt.com.example.thymeleafTest.model.TipoImovel;
import pt.com.example.thymeleafTest.repository.ImovelRepository;

@Service
public class ImobiliariaService {
    
    @Autowired
    private ImovelRepository imovelRepository;
    
    public void save(Imovel imovel) {
        imovelRepository.save(imovel);
    }
    
    public void delete(Imovel imovel) {
        imovelRepository.delete(imovel);
    }
    
    public List<Imovel> findAll() {
        return imovelRepository.findAll();
    }
    
    public Optional<Imovel> findById(Long id) {
        return imovelRepository.findById(id);
    }
    
    public List<Imovel> filter(FiltroDTO filtro) {       
        Specification<Imovel> specification = where(descricaoLike("")) ;
        
        if(!ObjectUtils.isEmpty(filtro.getDescricao())) {
            specification = specification.and(descricaoLike(filtro.getDescricao()));
        }
        
        if(!ObjectUtils.isEmpty(filtro.getTipo())) {
            specification = specification.and(tipoIgual(filtro.getTipo()));
        }
        
        if(!ObjectUtils.isEmpty(filtro.getPrecoMax())) {
            specification = specification.and(precoMenorOuIgual(filtro.getPrecoMax()));
        }
        
        if(!ObjectUtils.isEmpty(filtro.getPrecoMin())) {
            specification = specification.and(precoMaiorOuIgual(filtro.getPrecoMin()));
        }
        
        return imovelRepository.findAll(specification);
    }
    
    private Specification<Imovel> descricaoLike(String descricao){
        return (root, query, criteriaBuilder) 
                -> criteriaBuilder.like(criteriaBuilder.lower(root.get("descricao")), "%"+descricao.toLowerCase()+"%");
    }
    
    private Specification<Imovel> tipoIgual(TipoImovel tipo){
        return (root, query, criteriaBuilder) 
                -> criteriaBuilder.equal(root.get("tipo"), tipo);
    }
    
    private Specification<Imovel> precoMenorOuIgual(BigDecimal precoMax){
        return (root, query, criteriaBuilder) 
                -> criteriaBuilder.le(root.get("preco"), precoMax);
    }
    
    private Specification<Imovel> precoMaiorOuIgual(BigDecimal precoMin){
        return (root, query, criteriaBuilder) 
                -> criteriaBuilder.ge(root.get("preco"), precoMin);
    }
}
