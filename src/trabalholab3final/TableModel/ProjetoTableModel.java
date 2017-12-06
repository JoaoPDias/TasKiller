
package trabalholab3final.TableModel;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import trabalholab3final.modelos.Projeto;
import trabalholab3final.dao.ProjetoDAO;

public class ProjetoTableModel extends AbstractTableModel {

    private List<Projeto> projetos;
    private ProjetoDAO projetoDAO;

    public ProjetoTableModel() throws SQLException, ClassNotFoundException {
            this.projetoDAO= new ProjetoDAO();
            this.projetos = projetoDAO.listarTodos();       
    }

    @Override
    public int getRowCount() {
        return projetos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.toString(projetos.get(rowIndex).getId());
            case 1:
                return projetos.get(rowIndex).getDescricao();  
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
            default:
                throw new IndexOutOfBoundsException();
        }
    }
    
    public void addRow(Projeto p) throws SQLException{
        projetoDAO.inserir(p);
		this.projetos = projetoDAO.listarTodos();  
        this.fireTableDataChanged();
    }
	
	public void editRow(Projeto p) throws SQLException{
        projetoDAO.alterar(p);
		this.projetos = projetoDAO.listarTodos();  
        this.fireTableDataChanged();
    }
	
    public void removeRow(Projeto p) throws SQLException{
        projetoDAO.excluir(p.getId());
		this.projetos = projetoDAO.listarTodos();  
        this.fireTableDataChanged();
    }

}
