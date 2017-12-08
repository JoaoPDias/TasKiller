/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalholab3final.utilitarios;

import java.util.List;
import java.util.Objects;
import javax.swing.JComboBox;
import trabalholab3final.ListModel.ProjetoComboBoxModel;
import trabalholab3final.modelos.Projeto;

public class ProjetoComboBox extends JComboBox {

    private List<Projeto> projetos;

    public ProjetoComboBox() {
        setModel(new ProjetoComboBoxModel());
        projetos = ((ProjetoComboBoxModel) getModel()).getProjetos();
    }

    public void setSelectedIndex(Projeto p) {
        for (Projeto projeto : projetos) {
            if (Objects.equals(projeto.getId(), p.getId())) {
                setSelectedItem(projeto);
                selectedItemChanged();
                fireActionEvent();
            }
        }
    }
}
