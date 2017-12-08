
package trabalholab3final.modelos;


public enum Status {
    BLOQUEADO("Bloqueada"), DISPONIVEL("Disponível"), ANDAMENTO("Em Andamento"), CONCLUIDO("Concluída");
    String nome;

    private Status(String nome) {
        this.nome = nome;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
