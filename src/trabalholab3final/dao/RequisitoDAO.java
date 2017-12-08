/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalholab3final.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import trabalholab3final.Connection.ConexaoJavaDB;
import trabalholab3final.modelos.Tarefa;

/**
 *
 * @author jpdia
 */
public class RequisitoDAO {

    Connection conexao;
    private String sqlInserirRequisito = "INSERT INTO REQUISITO(fk_tarefa,fk_tarefa_requisito) VALUES (?,?)";
    private String sqlExcluirRequisito = "DELETE FROM REQUISITO WHERE fk_tarefa = ?";
    private String sqlVerificaRequisito = "SELECT fk_tarefa FROM requisito WHERE fk_tarefa = ? AND concluido is null";
    private String sqlConcluiRequisito = "UPDATE requisito SET concluido = TRUE WHERE fk_tarefa_requisito = ?";
    private String sqlListarRequisito = "SELECT fk_tarefa_requisito FROM requisito WHERE fk_tarefa = ?";
    private String sqlListarRequisitados = "SELECT fk_tarefa FROM requisito WHERE fk_tarefa_requisito = ?";
    private TarefaDAO tarefaDao;

    public RequisitoDAO(TarefaDAO tarefaDAO) throws SQLException, ClassNotFoundException {
        this.conexao = ConexaoJavaDB.getConnection();
        this.tarefaDao = tarefaDAO;
    }

    public void inserirRequisito(Tarefa tarefa, List<Tarefa> lista) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlInserirRequisito);
        for (Tarefa t : lista) {
            operacao.setInt(1, tarefa.getId());
            operacao.setInt(2, t.getId());
            operacao.execute();
        }
        operacao.close();

    }

    public boolean naoHaRequisitos(Integer id) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlVerificaRequisito);
        operacao.setInt(1, id);
        operacao.execute();
        ResultSet rs = operacao.getResultSet();
        return !rs.next();
    }

    public void concluiRequisito(Integer id) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlConcluiRequisito);
        operacao.setInt(1, id);
        operacao.execute();

    }

    public List<Tarefa> ListarTarefas(Tarefa tarefa) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlListarRequisito);
        operacao.setInt(1, tarefa.getId());
        operacao.execute();
        ResultSet rs = operacao.getResultSet();
        List<Tarefa> tarefas = new ArrayList<>();
        while (rs.next()) {
            Tarefa p = tarefa;
            tarefas.add(p);
        }
        return tarefas;
    }

    public List<Tarefa> ListarRequisitados(Integer id) throws SQLException {
        PreparedStatement operacao = conexao.prepareStatement(sqlListarRequisitados);
        operacao.setInt(1, id);
        operacao.execute();
        ResultSet rs = operacao.getResultSet();
        List<Tarefa> tarefas = new ArrayList<>();
        while (rs.next()) {
            Tarefa p = tarefaDao.listar(rs.getInt("fk_tarefa"));
            if (this.naoHaRequisitos(p.getId())) {
                tarefas.add(p);
            }
        }
        return tarefas;
    }
}
