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

public class InserirProjeto extends JFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    private JPanel painelFundo;
    private JButton btSalvar;
    private JButton btLimpar;
    private JLabel lbNome;
    private JLabel lbTelefone;
    private JLabel lbEmail;
    private JTextField txNome;
    private JTextField txTelefone;
    private JTextField txEmail;

    public InserirProjeto(DefaultTableModel md) {
        super("Prohetos");
        criaJanela();
        modelo = md;
    }

    public void criaJanela() {
        btSalvar = new JButton("Salvar");
        btLimpar = new JButton("Limpar");
        lbNome = new JLabel("         Nome.:   ");

        txNome = new JTextField(10);

        painelFundo = new JPanel();
        painelFundo.setLayout(new GridLayout(4, 2, 2, 4));
        painelFundo.add(lbNome);
        painelFundo.add(txNome);

        painelFundo.add(btLimpar);
        painelFundo.add(btSalvar);

        getContentPane().add(painelFundo);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300, 150);
        setVisible(true);
        btSalvar.addActionListener(new BtSalvarListener());
        btLimpar.addActionListener(new BtLimparListener());
    }

    private class BtSalvarListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Projeto p = new Projeto();
            p.setDescricao(txNome.getText());

            try {
                ProjetoDAO dao = new ProjetoDAO();
                dao.inserir(p);
                ListarProjetos.pesquisar(modelo);
                setVisible(false);
            } catch (SQLException ex) {
                Logger.getLogger(InserirProjeto.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(InserirProjeto.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private class BtLimparListener implements ActionListener {

       public void actionPerformed(ActionEvent e) {
			txNome.setText("");			
		}
    }

}
