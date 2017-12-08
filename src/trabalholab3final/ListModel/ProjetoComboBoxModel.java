package trabalholab3final.ListModel;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;
import trabalholab3final.dao.ProjetoDAO;
import trabalholab3final.modelos.Projeto;

public class ProjetoComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private List<Projeto> projetos;
    private List<ListDataListener> dataListeners = new LinkedList<>();
    private ProjetoDAO projetoDAO;
    private Projeto projeto;

    public ProjetoComboBoxModel() {
        try {
            projetoDAO = new ProjetoDAO();
            this.projetos = projetoDAO.listarTodos();
        } catch (SQLException ex) {
            Logger.getLogger(ProjetoComboBoxModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProjetoComboBoxModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void setSelectedItem(Object item) {
        if ((projeto != null && !projeto.equals(item))
                || projeto == null && item != null) {
            projeto = (Projeto) item;
            fireContentsChanged(this, -1, -1);
        }
    }

    @Override
    public Object getSelectedItem() {
        return projeto;
    }

    @Override
    public int getSize() {
        return projetos.size();
    }

    @Override
    public Object getElementAt(int index) {
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
    
    public List<Projeto> getProjetos(){
        return this.projetos;
    }

}
