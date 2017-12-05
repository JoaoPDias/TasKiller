package trabalholab3final.modelos;

import java.util.List;

public class Projeto {

    private Integer id;
    private String descricao;
    private List<Tarefa> tarefas;

    public Projeto() {
    }
    
    public Projeto(Integer id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public Projeto(String descricao) {
        this.descricao = descricao;
    }

    public Projeto(Integer id, String descricao, List<Tarefa> tarefas) {
        this.id = id;
        this.descricao = descricao;
        this.tarefas = tarefas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

}
