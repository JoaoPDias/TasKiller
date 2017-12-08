package trabalholab3final.TableModel;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import trabalholab3final.modelos.Pessoa;
import trabalholab3final.dao.PessoaDAO;

public class PessoaTableModel extends AbstractTableModel {

    private List<Pessoa> pessoas;
    private PessoaDAO pessoaDAO;

    public PessoaTableModel() throws SQLException, ClassNotFoundException {
        this.pessoaDAO = new PessoaDAO();
        this.pessoas = pessoaDAO.listarTodos();
    }

    @Override
    public int getRowCount() {
        return pessoas.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Integer.toString(pessoas.get(rowIndex).getId());
            case 1:
                return pessoas.get(rowIndex).getNome();
            case 2:
                return pessoas.get(rowIndex).getEmail();
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
                return "Nome da Pessoa";
            case 2:
                return "E-mail";
            default:
                throw new IndexOutOfBoundsException();
        }
    }

    public void addRow(Pessoa p) throws SQLException {
        pessoaDAO.inserir(p);
        this.pessoas = pessoaDAO.listarTodos();
        this.fireTableDataChanged();
    }

    public void editRow(Pessoa p) throws SQLException {
        pessoaDAO.alterar(p);
        this.pessoas = pessoaDAO.listarTodos();
        this.fireTableDataChanged();
    }

    public void removeRow(Pessoa p) throws SQLException {
        pessoaDAO.excluir(p.getId());
        this.pessoas = pessoaDAO.listarTodos();
        this.fireTableDataChanged();
    }

    public Pessoa getRow(Integer id) {
        return pessoas.get(id);
    }

}
