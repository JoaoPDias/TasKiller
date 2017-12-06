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

public class TarefaListModel implements ListModel {

    private List<Tarefa> tarefas;
    private List<ListDataListener> dataListeners = new LinkedList<>();
    private TarefaDAO tarefaDAO;
    private ProjetoDAO projetoDAO;

    public TarefaListModel(Status status, Projeto projeto) {
        try {
            projetoDAO = new ProjetoDAO();
            tarefaDAO = new TarefaDAO(projetoDAO);
            this.tarefas = tarefaDAO.listarPorStatus(status, projeto);
            if(this.tarefas.isEmpty()){
                this.tarefas.add(new Tarefa("Não há tarefas nesse Status"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TarefaListModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TarefaListModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getSize() {
        return tarefas.size();
    }

    @Override
    public Tarefa getElementAt(int index) {
        return tarefas.get(index);
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
