package trabalholab3final.ListModel;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import trabalholab3final.dao.PessoaDAO;
import trabalholab3final.modelos.Pessoa;

public class PessoaListModel implements ListModel {

    private List<Pessoa> pessoas;
    private List<ListDataListener> dataListeners = new LinkedList<>();
    private PessoaDAO pessoaDAO;

    public PessoaListModel(Boolean valor) {
        try {
            pessoaDAO = new PessoaDAO();
            this.pessoas = pessoaDAO.listarTodos();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaListModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PessoaListModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public PessoaListModel() {
        this.pessoas = new ArrayList<>();

    }

    @Override
    public int getSize() {
        return pessoas.size();
    }

    @Override
    public Pessoa getElementAt(int index) {
        if (!pessoas.isEmpty()) {
            return pessoas.get(index);
        }
        return null;
    }

    public void addElement(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        dataListeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        dataListeners.remove(l);
    }

    public void removeElement(Pessoa pessoa) {
        pessoas.remove(pessoa);
    }

    public List<Pessoa> getPessoas() {
        return pessoas;
    }

    public void setPessoas(List<Pessoa> pessoas) {
        this.pessoas = pessoas;
    }
    
    

}
