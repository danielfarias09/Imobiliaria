package pt.com.example.thymeleafTest.model;

public enum TipoImovel {
    APARTAMENTO("Apartamento"), CASA("Casa"), ESCRITÓRIO("Escritório");
    
    private String descricao;

    private TipoImovel(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }  
}
