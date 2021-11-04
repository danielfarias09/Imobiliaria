package pt.com.example.thymeleafTest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pt.com.example.thymeleafTest.dto.FiltroDTO;
import pt.com.example.thymeleafTest.model.Imovel;
import pt.com.example.thymeleafTest.service.ImobiliariaService;

@Controller
@RequestMapping("/imoveis")
public class ImobiliariaController {
    
    @Autowired
    private ImobiliariaService imovelService;
    
    @GetMapping
    public String getIndex (Model model) {
        model.addAttribute("imoveis", imovelService.filter(new FiltroDTO()));
        return "index";
    }
    
    @GetMapping("/cadastro-imovel")
    public String novoImovel(Model model) {
        //Envia o objeto imovel para ser preenchido na view
        model.addAttribute("imovel", new Imovel());
        return "cadastro-imovel";
    }
    
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        return "dashboard";
    }
    
    @PostMapping
    public String salvarImovel(@Validated Imovel imovel, Errors errors, RedirectAttributes attributes) {
        if(errors.hasErrors()) {
            return "cadastro-imovel";
        }
        
        imovelService.save(imovel);
        attributes.addFlashAttribute("mensagem", "Imóvel cadastrado com sucesso!");
        //redireciona para a página cadastro-imovel que está mapeada no controller
        return "redirect:/imoveis/cadastro-imovel/";
    }
    
    @DeleteMapping("/{id}")
    public String excluirImovel(@PathVariable Long id, RedirectAttributes attributes, Model model) {
        Optional<Imovel> imovel = imovelService.findById(id);
        if(imovel.isPresent()) {
            imovelService.delete(imovel.get());
            model.addAttribute("imoveis", imovelService.filter(new FiltroDTO()));
            attributes.addFlashAttribute("mensagem", "Imóvel excluído com sucesso!");
        }
        return "fragments/tabela-imoveis :: tabela-imoveis";        
    }
    
    @PostMapping("/filtrar")
    public String filtrarImoveis(@ModelAttribute("filtro") FiltroDTO filtro, Model model) {
        model.addAttribute("imoveis", imovelService.filter(filtro));
        return "fragments/tabela-imoveis :: tabela-imoveis";  
    }
    
}
