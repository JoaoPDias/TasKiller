package trabalholab3final.TableModel;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import trabalholab3final.dao.ProjetoDAO;
import trabalholab3final.dao.TarefaDAO;
import trabalholab3final.modelos.Status;
import trabalholab3final.modelos.Tarefa;

public class TarefaTableModel extends AbstractTableModel {

    private List<Tarefa> tarefas;
    private TarefaDAO tarefaDAO;
    private ProjetoDAO projetoDAO;

    public TarefaTableModel() {

        try {
            projetoDAO = new ProjetoDAO();
            this.tarefaDAO = new TarefaDAO(projetoDAO);
            this.tarefas = tarefaDAO.listarTodos();
        } catch (SQLException ex) {
            Logger.getLogger(TarefaTableModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TarefaTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public TarefaTableModel(Status status) throws SQLException, ClassNotFoundException {
        projetoDAO = new ProjetoDAO();
        this.tarefaDAO = new TarefaDAO(projetoDAO);
        this.tarefas = tarefaDAO.listarApenasStatus(status);
    }

    @Override
    public int getRowCount() {
        return tarefas.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        switch (columnIndex) {
            case 0:
                return Integer.toString(tarefas.get(rowIndex).getId());
            case 1:
                return tarefas.get(rowIndex).getProjeto().getDescricao();
            case 2:
                return tarefas.get(rowIndex).getDescricao();
            case 3:
                return Integer.toString(tarefas.get(rowIndex).getDuracao());
            case 4:
                return Double.toString(tarefas.get(rowIndex).getValorConclusao());
            case 5:
                return tarefas.get(rowIndex).getDataInicio().format(formatter);
            case 6:
                return tarefas.get(rowIndex).getDataConclusao().format(formatter);
            case 7:
                return tarefas.get(rowIndex).getStatus().getNome();
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String getColumnName(int column) {

        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nome do Projeto";
            case 2:
                return "Descrição da Tarefa";
            case 3:
                return "Duração";
            case 4:
                return "% de Conclusão";
            case 5:
                return "Data de Início";
            case 6:
                return "Data de Conclusão";
            case 7:
                return "Status";
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    public void addRow(Tarefa t) throws SQLException {
        tarefaDAO.inserir(t);
        this.tarefas = tarefaDAO.listarTodos();
        this.fireTableDataChanged();
    }

    public void editRow(Tarefa t) throws SQLException {
        tarefaDAO.alterar(t);
        this.tarefas = tarefaDAO.listarTodos();
        this.fireTableDataChanged();
    }

    public void removeRow(Tarefa t) throws SQLException {
        tarefaDAO.excluir(t.getId());
        this.tarefas = tarefaDAO.listarTodos();
        this.fireTableDataChanged();
    }

    public Tarefa getRow(int selectedRow) {
        return tarefas.get(selectedRow);
        
    }

}
