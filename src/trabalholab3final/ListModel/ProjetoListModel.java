package trabalholab3final.ListModel;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;
import trabalholab3final.dao.ProjetoDAO;
import trabalholab3final.dao.TarefaDAO;
import trabalholab3final.modelos.Projeto;
import trabalholab3final.modelos.Status;
import trabalholab3final.modelos.Tarefa;

public class ProjetoListModel implements ListModel {

    private List<Projeto> projetos;
    private List<ListDataListener> dataListeners = new LinkedList<>();
    private ProjetoDAO projetoDAO;

    public ProjetoListModel() {
        try {
            projetoDAO = new ProjetoDAO();
            this.projetos = projetoDAO.listarTodos();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoListModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjetoListModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getSize() {
        return projetos.size();
    }

    @Override
    public Projeto getElementAt(int index) {
        return projetos.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        dataListeners.add(l);
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        dataListeners.remove(l);
    }
   
}
