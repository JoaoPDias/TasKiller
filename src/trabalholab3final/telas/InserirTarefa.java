package trabalholab3final.telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import trabalholab3final.ListModel.TarefaListModel;
import trabalholab3final.ListModel.PessoaListModel;
import trabalholab3final.modelos.Projeto;
import trabalholab3final.modelos.Status;
import trabalholab3final.modelos.Tarefa;
import trabalholab3final.modelos.Pessoa;

public class InserirTarefa extends javax.swing.JFrame {

    ListarTarefas listarTarefa;
    Status status[];

    public InserirTarefa(ListarTarefas listar) {
        super("Inserir Tarefa");
        this.listarTarefa = listar;
        status = Status.values();
        initComponents();
        projetoCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lstTarefas.setModel(new TarefaListModel((Projeto) projetoCombo.getSelectedItem()));
            }
        });

        btn_adicionaRequisito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tarefa tarefa = lstTarefas.getSelectedValue();
                if (tarefa != null && tarefa.getId() != null && tarefa.getId() > 0) {
                    ((TarefaListModel) lstRequisitos.getModel()).addElement(tarefa);
                    ((TarefaListModel) lstTarefas.getModel()).removeElement(tarefa);
                    lstTarefas.updateUI();
                    lstRequisitos.updateUI();
                }
            }
        });

        btn_removeRequisito.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tarefa tarefa = lstRequisitos.getSelectedValue();
                if (tarefa != null) {
                    ((TarefaListModel) lstTarefas.getModel()).addElement(tarefa);
                    ((TarefaListModel) lstRequisitos.getModel()).removeElement(tarefa);
                    lstTarefas.updateUI();
                    lstRequisitos.updateUI();
                }
            }
        });

        btn_adicionaColaborador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pessoa pessoa = lstPessoas.getSelectedValue();
                if (pessoa != null) {
                    ((PessoaListModel) lstColaboradores.getModel()).addElement(pessoa);
                    ((PessoaListModel) lstPessoas.getModel()).removeElement(pessoa);
                    lstPessoas.updateUI();
                    lstColaboradores.updateUI();
                }
            }
        });

        btn_removeColaborador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pessoa pessoa = lstColaboradores.getSelectedValue();
                if (pessoa != null) {
                    ((PessoaListModel) lstPessoas.getModel()).addElement(pessoa);
                    ((PessoaListModel) lstColaboradores.getModel()).removeElement(pessoa);
                    lstPessoas.updateUI();
                    lstColaboradores.updateUI();
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dataFinal = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_adicionaRequisito = new javax.swing.JButton();
        dataInicio = new javax.swing.JFormattedTextField();
        tarefasAssociadasLbl1 = new javax.swing.JLabel();
        pessoasTarefaLbl1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstRequisitos = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstColaboradores = new javax.swing.JList<>();
        dataInicioLbl = new javax.swing.JLabel();
        txtDuracao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descricaotxt = new javax.swing.JTextArea();
        dataFimLbl = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        statusCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstTarefas = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstPessoas = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        btn_removeRequisito = new javax.swing.JButton();
        txtPorcentagem = new javax.swing.JTextField();
        tarefasAssociadasLbl = new javax.swing.JLabel();
        btn_removeColaborador = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        btn_adicionaColaborador = new javax.swing.JButton();
        btn_Salvar = new javax.swing.JButton();
        statusLbl = new javax.swing.JLabel();
        projetoCombo = new trabalholab3final.utilitarios.ProjetoComboBox();
        pessoasTarefaLbl = new javax.swing.JLabel();

        dataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        jLabel1.setText("Porcetagem concluída(%):");

        btn_adicionaRequisito.setText(">>");

        dataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        tarefasAssociadasLbl1.setText("Tarefas associadas:");

        pessoasTarefaLbl1.setText("Pessoas designadas:");

        lstRequisitos.setModel(new TarefaListModel());
        lstRequisitos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(lstRequisitos);

        lstColaboradores.setModel(new PessoaListModel());
        lstColaboradores.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane4.setViewportView(lstColaboradores);

        dataInicioLbl.setText("Data Inicial (dd/mm/yyyy):");

        descricaotxt.setColumns(15);
        descricaotxt.setRows(5);
        jScrollPane1.setViewportView(descricaotxt);

        dataFimLbl.setText("Data Final(dd/mm/yyyy):");

        jLabel4.setText("Duração:");

        statusCombo.setModel(new javax.swing.DefaultComboBoxModel<>(status));

        jLabel2.setText("Projeto:");

        lstTarefas.setModel(new TarefaListModel());
        lstTarefas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(lstTarefas);

        lstPessoas.setModel(new PessoaListModel(true));
        lstPessoas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(lstPessoas);

        jLabel3.setText("Descrição da tarefa:");

        btn_removeRequisito.setText("<< ");

        txtPorcentagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPorcentagemActionPerformed(evt);
            }
        });

        tarefasAssociadasLbl.setText("Tarefas cadastradas:");

        btn_removeColaborador.setText("<< ");

        jTextField1.setText("%");

        btn_adicionaColaborador.setText(">>");

        btn_Salvar.setBackground(new java.awt.Color(0, 204, 51));
        btn_Salvar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Salvar.setText("Salvar");
        btn_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalvarActionPerformed(evt);
            }
        });

        statusLbl.setText("Status:");

        pessoasTarefaLbl.setText("Pessoas cadastradas:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(statusLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(statusCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(16, 16, 16))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(88, 88, 88)
                                .addComponent(txtDuracao))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(5, 5, 5)
                                .addComponent(txtPorcentagem))
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(projetoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(52, 52, 52))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataInicioLbl)
                            .addComponent(dataFimLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dataInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE)
                            .addComponent(dataFinal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pessoasTarefaLbl)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_adicionaColaborador)
                            .addComponent(btn_removeColaborador, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(tarefasAssociadasLbl)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_adicionaRequisito)
                            .addComponent(btn_removeRequisito, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pessoasTarefaLbl1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btn_Salvar)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tarefasAssociadasLbl1))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(projetoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dataInicioLbl)
                            .addComponent(dataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dataFimLbl)
                            .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(statusLbl)
                            .addComponent(statusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(pessoasTarefaLbl))
                            .addComponent(pessoasTarefaLbl1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_adicionaColaborador)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_removeColaborador)))
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(tarefasAssociadasLbl)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tarefasAssociadasLbl1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btn_Salvar))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                        .addComponent(btn_adicionaRequisito)
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_removeRequisito)
                                        .addGap(123, 123, 123)))))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPorcentagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPorcentagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPorcentagemActionPerformed

    private void btn_SalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalvarActionPerformed
        salvar();
    }//GEN-LAST:event_btn_SalvarActionPerformed

    private void salvar() {
        Projeto projeto;
        LocalDate dtinicio;
        LocalDate dtfinal;
        Integer duracao;
        Double porcentagem;
        Status status;
        String descricao;
        List<Pessoa> colaboradores;
        List<Tarefa> tarefas;
        try {
            projeto = (Projeto) projetoCombo.getSelectedItem();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dtinicio = LocalDate.parse(dataInicio.getText(), formatter);
            dtfinal = LocalDate.parse(dataFinal.getText(), formatter);
            duracao = Integer.parseInt(txtDuracao.getText());
            porcentagem = Double.parseDouble(txtPorcentagem.getText());

            status = (Status) statusCombo.getSelectedItem();

            descricao = descricaotxt.getText();

            colaboradores = ((PessoaListModel) lstColaboradores.getModel()).getPessoas();
            tarefas = ((TarefaListModel) lstRequisitos.getModel()).getTarefas();
            Tarefa tarefa = new Tarefa(projeto, descricao, duracao, porcentagem, dtinicio, dtfinal, status, tarefas, colaboradores);
            this.listarTarefa.InserirTarefa(tarefa);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Formato de Número Inválido. Verifique, por favor!",
                    "Valor Inválido",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    public void solicitaInsercao() {
        projetoCombo.setSelectedItem(0);
        txtDuracao.setText("");
        dataInicio.setText("");
        dataFinal.setText("");
        txtPorcentagem.setText("");
        statusCombo.setSelectedItem(0);
        descricaotxt.setText("");
        lstColaboradores.setModel(new PessoaListModel());
        lstPessoas.setModel(new PessoaListModel(true));
        lstRequisitos.setModel(new TarefaListModel());
        lstTarefas.setModel(new TarefaListModel());

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Salvar;
    private javax.swing.JButton btn_adicionaColaborador;
    private javax.swing.JButton btn_adicionaRequisito;
    private javax.swing.JButton btn_removeColaborador;
    private javax.swing.JButton btn_removeRequisito;
    private javax.swing.JLabel dataFimLbl;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicio;
    private javax.swing.JLabel dataInicioLbl;
    private javax.swing.JTextArea descricaotxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JList<Pessoa> lstColaboradores;
    private javax.swing.JList<Pessoa> lstPessoas;
    private javax.swing.JList<Tarefa> lstRequisitos;
    private javax.swing.JList<Tarefa> lstTarefas;
    private javax.swing.JLabel pessoasTarefaLbl;
    private javax.swing.JLabel pessoasTarefaLbl1;
    private trabalholab3final.utilitarios.ProjetoComboBox projetoCombo;
    private javax.swing.JComboBox<Status> statusCombo;
    private javax.swing.JLabel statusLbl;
    private javax.swing.JLabel tarefasAssociadasLbl;
    private javax.swing.JLabel tarefasAssociadasLbl1;
    private javax.swing.JTextField txtDuracao;
    private javax.swing.JTextField txtPorcentagem;
    // End of variables declaration//GEN-END:variables
}
