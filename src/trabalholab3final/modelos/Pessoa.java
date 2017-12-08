package trabalholab3final.modelos;

import java.util.List;
import javax.swing.JOptionPane;

public class Pessoa {

    private Integer id;
    private String nome;
    private String email;
    private List<Tarefa> tarefas;

    public Pessoa(Integer id, String nome, String email, List<Tarefa> tarefas) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.tarefas = tarefas;
    }

    public Pessoa(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Pessoa(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Pessoa() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (!nome.isEmpty()) {
            this.nome = nome;
        } else {
            JOptionPane.showMessageDialog(null, "Nome está vazio");
        }

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!email.isEmpty()) {
            this.email = email;
        } else {
            JOptionPane.showMessageDialog(null, "Nome está vazio");
        }

    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    public void setTarefas(List<Tarefa> tarefas) {
        this.tarefas = tarefas;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
