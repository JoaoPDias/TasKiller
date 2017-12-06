
package trabalholab3final.TableModel;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import trabalholab3final.dao.ProjetoDAO;
import trabalholab3final.dao.TarefaDAO;
import trabalholab3final.modelos.Tarefa;


public class TarefaTableModel extends AbstractTableModel {

    private List<Tarefa> tarefas;
    private TarefaDAO tarefaDAO;
    private ProjetoDAO projetoDAO = new ProjetoDAO();

    public TarefaTableModel() throws SQLException, ClassNotFoundException {
            
            this.tarefaDAO = new TarefaDAO(projetoDAO);
            this.tarefas = tarefaDAO.listarTodos();       
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
                return tarefas.get(rowIndex).getDataInicio().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
			case 6:
                return tarefas.get(rowIndex).getDataConclusao().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)); 
			case 7:
                return tarefas.get(rowIndex).getStatus().toString(); 
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
    
    public void addRow(Tarefa t) throws SQLException{
        tarefaDAO.inserir(t);
		this.tarefas = tarefaDAO.listarTodos();
        this.fireTableDataChanged();
    }
	
	public void editRow(Tarefa t) throws SQLException{
        tarefaDAO.alterar(t);
		this.tarefas = tarefaDAO.listarTodos();
        this.fireTableDataChanged();
    }
	
    public void removeRow(Tarefa t) throws SQLException{
        tarefaDAO.excluir(t.getId());
		this.tarefas = tarefaDAO.listarTodos();
        this.fireTableDataChanged();
    }

}
