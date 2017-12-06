package trabalholab3final.telas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import trabalholab3final.dao.ProjetoDAO;
import trabalholab3final.modelos.Projeto;

public class ListarProjetos extends JFrame {

    private JPanel painelFundo;
    private JPanel painelBotoes;
    private JTable tabela;
    private JScrollPane barraRolagem;
    private JButton btInserir;
    private JButton btExcluir;
    private JButton btEditar;
    private DefaultTableModel modelo = new DefaultTableModel();

    public ListarProjetos() throws SQLException, ClassNotFoundException {
        super("TasKiller");
        
        criaJTable();
        criaJanela();
    }

    private void criaJanela() {
        btInserir = new JButton("Inserir");
        btExcluir = new JButton("Excluir");
        btEditar = new JButton("Editar");
        painelBotoes = new JPanel();
        barraRolagem = new JScrollPane(tabela);
        painelFundo = new JPanel();
        painelFundo.setLayout(new BorderLayout());
        painelFundo.add(BorderLayout.CENTER, barraRolagem);
        painelBotoes.add(btInserir);
        painelBotoes.add(btEditar);
        painelBotoes.add(btExcluir);
        painelFundo.add(BorderLayout.SOUTH, painelBotoes);

        getContentPane().add(painelFundo);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500, 320);
        setVisible(true);
        btInserir.addActionListener(new BtInserirListener());
        btEditar.addActionListener(new BtEditarListener());
        btExcluir.addActionListener(new BtExcluirListener());
    }

    private void criaJTable() throws SQLException, ClassNotFoundException {
        tabela = new JTable(modelo);
        modelo.addColumn("Id");
        modelo.addColumn("Descrição");
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(120);
        pesquisar(modelo);
    }

    public static void pesquisar(DefaultTableModel modelo) throws SQLException, ClassNotFoundException {
        modelo.setNumRows(0);
        ProjetoDAO dao = new ProjetoDAO();
        for (Projeto p : dao.listarTodos()) {
            modelo.addRow(new Object[]{p.getId(), p.getDescricao()});
        }
    }

    private class BtInserirListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            InserirProjeto ip = new InserirProjeto(modelo);
            ip.setVisible(true);
        }

    }

    private class BtEditarListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int linhaSelecionada = -1;
            linhaSelecionada = tabela.getSelectedRow();
            if (linhaSelecionada >= 0) {
                int idProjeto = (int) tabela.getValueAt(linhaSelecionada, 0);
                
                try {
                    AtualizarProjeto ip = new AtualizarProjeto(modelo, idProjeto, linhaSelecionada);
                    ip.setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ListarProjetos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ListarProjetos.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }
        }
    }

    private class BtExcluirListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int linhaSelecionada = -1;
            linhaSelecionada = tabela.getSelectedRow();
            if (linhaSelecionada >= 0) {
                int idContato = (int) tabela.getValueAt(linhaSelecionada, 0);
                ProjetoDAO dao;
                try {
                    dao = new ProjetoDAO();
                    dao.excluir(idContato);
                    modelo.removeRow(linhaSelecionada);
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Não é possível excluir esse projeto.");
                    Logger.getLogger(ListarProjetos.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
                    Logger.getLogger(ListarProjetos.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
            }
        }

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        //ListarProjetos lc = new ListarProjetos();
        //DashBoard dash = new DashBoard();
        //dash.setVisible(true);
    }
}
