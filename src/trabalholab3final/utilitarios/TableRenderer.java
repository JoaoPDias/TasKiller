/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalholab3final.utilitarios;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import trabalholab3final.TableModel.TarefaTableModel;
import trabalholab3final.modelos.Status;

public class TableRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        String status = ((TarefaTableModel)table.getModel()).getValueAt(row, 7);

        if (status.equals(Status.CONCLUIDO.getNome())) {
            comp.setBackground(new java.awt.Color(0, 153, 51));
            comp.setForeground(new java.awt.Color(255, 255, 255));
        } else if (status.equals(Status.BLOQUEADO.getNome())) {
            comp.setBackground(new java.awt.Color(204, 0, 0));
            comp.setForeground(new java.awt.Color(255, 255, 255));
        } else if (status.equals(Status.ANDAMENTO.getNome())) {
            comp.setBackground(new java.awt.Color(255, 204, 51));
            comp.setForeground(new java.awt.Color(255, 255, 255));
        } else if (status.equals(Status.DISPONIVEL.getNome())) {
            comp.setBackground(Color.BLUE);
            comp.setForeground(new java.awt.Color(255, 255, 255));
        }

        return comp;
    }
}
