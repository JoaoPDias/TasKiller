package trabalholab3final.modelos;

import java.time.LocalDate;
import java.util.List;

public class Tarefa {

    private Integer id;
    private Projeto projeto;
    private String descricao;
    private Integer duracao;
    private Double valorConclusao;
    private LocalDate dataInicio;
    private LocalDate dataConclusao;
    private Status status;
    private List<Tarefa> requisitos;
    private List<Pessoa> colaboradores;

    public Tarefa(Integer id, Projeto projeto, String descricao, Integer duracao, Double valorConclusao, LocalDate dataInicio, LocalDate dataConclusao, String status, List<Tarefa> requisitos, List<Pessoa> colaboradores) {
        this.id = id;
        this.projeto = projeto;
        this.descricao = descricao;
        this.duracao = duracao;
        this.valorConclusao = valorConclusao;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
        this.status = Status.valueOf(status);
        this.requisitos = requisitos;
        this.colaboradores = colaboradores;
    }

    public Tarefa(Integer id, Projeto projeto, String descricao, Integer duracao, Double valorConclusao, LocalDate dataInicio, LocalDate dataConclusao, Status status, List<Tarefa> requisitos, List<Pessoa> colaboradores) {
        this.id = id;
        this.projeto = projeto;
        this.descricao = descricao;
        this.duracao = duracao;
        this.valorConclusao = valorConclusao;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
        this.status = status;
        this.requisitos = requisitos;
        this.colaboradores = colaboradores;
    }

    public Tarefa(Projeto projeto, String descricao, Integer duracao, Double valorConclusao, LocalDate dataInicio, LocalDate dataConclusao, String status, List<Tarefa> requisitos, List<Pessoa> colaboradores) {
        this.projeto = projeto;
        this.descricao = descricao;
        this.duracao = duracao;
        this.valorConclusao = valorConclusao;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
        this.status = Status.valueOf(status);
        this.requisitos = requisitos;
        this.colaboradores = colaboradores;
    }
    
    public Tarefa(Projeto projeto, String descricao, Integer duracao, Double valorConclusao, LocalDate dataInicio, LocalDate dataConclusao, Status status, List<Tarefa> requisitos, List<Pessoa> colaboradores) {
        this.projeto = projeto;
        this.descricao = descricao;
        this.duracao = duracao;
        this.valorConclusao = valorConclusao;
        this.dataInicio = dataInicio;
        this.dataConclusao = dataConclusao;
        this.status = status;
        this.requisitos = requisitos;
        this.colaboradores = colaboradores;
    }
    public Tarefa(String descricao) {
        this.descricao = descricao;
    }

    public Tarefa(Integer id,Projeto projeto, String descricao, Integer duracao, Double porcentagem, LocalDate dtinicio, LocalDate dtfinal, Status status) {
        this.id = id;
        this.projeto = projeto;
        this.descricao = descricao;
        this.duracao = duracao;
        this.valorConclusao = porcentagem;
        this.dataInicio = dtinicio;
        this.dataConclusao = dtfinal;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getDuracao() {
        return duracao;
    }

    public void setDuracao(Integer duracao) {
        this.duracao = duracao;
    }

    public Double getValorConclusao() {
        return valorConclusao;
    }

    public void setValorConclusao(Double valorConclusao) {
        this.valorConclusao = valorConclusao;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = Status.valueOf(status);
    }

    public List<Tarefa> getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(List<Tarefa> requisitos) {
        this.requisitos = requisitos;
    }

    public List<Pessoa> getColaboradores() {
        return colaboradores;
    }

    public void setColaboradores(List<Pessoa> colaboradores) {
        this.colaboradores = colaboradores;
    }

    @Override
    public String toString() {
        return descricao;
    }

}
