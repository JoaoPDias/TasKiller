package trabalholab3final.telas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.FormatStyle;
import java.util.List;
import javax.swing.JOptionPane;
import trabalholab3final.ListModel.TarefaListModel;
import trabalholab3final.ListModel.PessoaListModel;
import trabalholab3final.modelos.Projeto;
import trabalholab3final.modelos.Status;
import trabalholab3final.modelos.Tarefa;
import trabalholab3final.modelos.Pessoa;

public class AlterarTarefa extends javax.swing.JFrame {

    ListarTarefas listarTarefa;
    Status status[];
    Integer idTarefa;

    public AlterarTarefa(ListarTarefas listar, Tarefa tarefa) {
        super("Alterar Tarefa");
        idTarefa=tarefa.getId();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
        this.listarTarefa = listar;
        status = Status.values();
        initComponents();
        this.listarTarefa = listar;
        projetoCombo.setSelectedIndex(tarefa.getProjeto());
        txtDuracao.setText(Integer.toString(tarefa.getDuracao()));
        dataInicio.setText(tarefa.getDataInicio().format(formatter));
        dataFinal.setText(tarefa.getDataConclusao().format(formatter));
        txtPorcentagem.setText(tarefa.getValorConclusao().toString());
        if (tarefa.getStatus() == Status.BLOQUEADO) {
            statusCombo.setEnabled(false);
        }
        statusCombo.setSelectedItem(tarefa.getStatus());
        descricaotxt.setText(tarefa.getDescricao());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dataInicioLbl = new javax.swing.JLabel();
        dataFimLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        statusLbl = new javax.swing.JLabel();
        statusCombo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descricaotxt = new javax.swing.JTextArea();
        btn_Salvar = new javax.swing.JButton();
        projetoCombo = new trabalholab3final.utilitarios.ProjetoComboBox();
        dataInicio = new javax.swing.JFormattedTextField();
        dataFinal = new javax.swing.JFormattedTextField();
        txtPorcentagem = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtDuracao = new javax.swing.JTextField();

        dataInicioLbl.setText("Data Inicial (dd/mm/yyyy):");

        dataFimLbl.setText("Data Final(dd/mm/yyyy):");

        jLabel1.setText("Porcetagem concluída(%):");

        jTextField1.setText("%");

        statusLbl.setText("Status:");

        statusCombo.setModel(new javax.swing.DefaultComboBoxModel<>(status));

        jLabel2.setText("Projeto:");

        jLabel3.setText("Descrição da tarefa:");

        descricaotxt.setColumns(15);
        descricaotxt.setRows(5);
        jScrollPane1.setViewportView(descricaotxt);

        btn_Salvar.setBackground(new java.awt.Color(0, 204, 51));
        btn_Salvar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Salvar.setText("Salvar");
        btn_Salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalvarActionPerformed(evt);
            }
        });

        dataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        dataFinal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));

        txtPorcentagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPorcentagemActionPerformed(evt);
            }
        });

        jLabel4.setText("Duração:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(5, 5, 5)
                        .addComponent(txtPorcentagem))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(88, 88, 88)
                        .addComponent(txtDuracao))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataInicioLbl)
                            .addComponent(dataFimLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataInicio)
                            .addComponent(dataFinal)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(projetoCombo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(statusLbl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 176, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(statusCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1)))
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(btn_Salvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(projetoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataInicioLbl)
                    .addComponent(dataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataFimLbl)
                    .addComponent(dataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDuracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPorcentagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusLbl)
                    .addComponent(statusCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Salvar)
                .addGap(44, 44, 44))
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
        try {
            projeto = (Projeto) projetoCombo.getSelectedItem();

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dtinicio = LocalDate.parse(dataInicio.getText(), formatter);
            dtfinal = LocalDate.parse(dataFinal.getText(), formatter);
            duracao = Integer.parseInt(txtDuracao.getText());
            porcentagem = Double.parseDouble(txtPorcentagem.getText());

            status = (Status) statusCombo.getSelectedItem();

            descricao = descricaotxt.getText();
            Tarefa tarefa = new Tarefa(idTarefa,projeto, descricao, duracao, porcentagem, dtinicio, dtfinal, status);
            this.listarTarefa.AlterarTarefa(this, tarefa);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Formato de Número Inválido. Verifique, por favor!",
                    "Valor Inválido",
                    JOptionPane.ERROR_MESSAGE);
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this,
                    "Formato de Data Inválido. Verifique, por favor! Exemplo de data Válida: 07/12/2017",
                    "Valor Inválido",
                    JOptionPane.ERROR_MESSAGE);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Salvar;
    private javax.swing.JLabel dataFimLbl;
    private javax.swing.JFormattedTextField dataFinal;
    private javax.swing.JFormattedTextField dataInicio;
    private javax.swing.JLabel dataInicioLbl;
    private javax.swing.JTextArea descricaotxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private trabalholab3final.utilitarios.ProjetoComboBox projetoCombo;
    private javax.swing.JComboBox<Status> statusCombo;
    private javax.swing.JLabel statusLbl;
    private javax.swing.JTextField txtDuracao;
    private javax.swing.JTextField txtPorcentagem;
    // End of variables declaration//GEN-END:variables
}
