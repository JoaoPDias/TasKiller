package trabalholab3final.telas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import trabalholab3final.dao.ProjetoDAO;
import trabalholab3final.modelos.Projeto;

/**
 *
 * @author Ricardo Alves
 */
public class AtualizarProjeto extends JFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    private JPanel painelFundo;
    private JButton btSalvar;
    private JButton btLimpar;
    private JLabel lbNome;
    private JLabel lbId;
    private JTextField txNome;
    private JTextField txId;
    Projeto contato;
    private int linhaSelecionada;

    public AtualizarProjeto(DefaultTableModel md, int id, int linha) throws SQLException, ClassNotFoundException {
        super("Projetos");
        criaJanela();
        modelo = md;
        ProjetoDAO dao = new ProjetoDAO();
        contato = dao.listar(id);
        txId.setText(Integer.toString(contato.getId()));
        txNome.setText(contato.getDescricao());

        linhaSelecionada = linha;
    }

    public void criaJanela() {
        btSalvar = new JButton("Salvar");
        btLimpar = new JButton("Limpar");
        lbNome = new JLabel("         Nome.:   ");

        lbId = new JLabel("         Id.:   ");
        txNome = new JTextField();

        txId = new JTextField();
        txId.setEditable(false);

        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(5, 2, 2, 4));
        painelFundo.add(lbId);
        painelFundo.add(txId);
        painelFundo.add(lbNome);
        painelFundo.add(txNome);
        painelFundo.add(btLimpar);
        painelFundo.add(btSalvar);

        getContentPane().add(painelFundo);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);

        btSalvar.addActionListener(new AtualizarProjeto.BtSalvarListener());
        btLimpar.addActionListener(new AtualizarProjeto.BtLimparListener());
    }

    private class BtSalvarListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Projeto p = new Projeto();
            p.setId(Integer.parseInt(txId.getText()));
            p.setDescricao(txNome.getText());

            try {
                ProjetoDAO dao = new ProjetoDAO();
                dao.alterar(p);
                modelo.removeRow(linhaSelecionada);
                modelo.addRow(new Object[]{p.getId(), p.getDescricao()});
                setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(AtualizarProjeto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AtualizarProjeto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class BtLimparListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            txNome.setText("");

        }
    }

}
