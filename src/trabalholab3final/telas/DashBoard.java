/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalholab3final.telas;

import trabalholab3final.ListModel.ProjetoListModel;
import trabalholab3final.ListModel.TarefaListModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import trabalholab3final.modelos.Projeto;
import trabalholab3final.modelos.Status;
import trabalholab3final.modelos.Tarefa;

public class DashBoard extends javax.swing.JFrame {

    private TarefaListModel modeloBloqueadas;
    private TarefaListModel modeloDisponiveis;
    private TarefaListModel modeloAndamento;
    private TarefaListModel modeloConcluidas;

    public DashBoard() throws SQLException, ClassNotFoundException {
        super("DASHBOARD");
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tarefasBloqueadas = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tarefasDisponiveis = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tarefasAndamento = new javax.swing.JList<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        tarefasConcluidas = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstProjetos = new javax.swing.JList<>();
        lstProjetos.setModel(new ProjetoListModel());
        lstProjetos.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Projeto p = lstProjetos.getSelectedValue();
                if (p != null) {
                    modeloBloqueadas = new TarefaListModel(Status.BLOQUEADO, p);
                    modeloDisponiveis = new TarefaListModel(Status.DISPONIVEL, p);
                    modeloAndamento = new TarefaListModel(Status.ANDAMENTO, p);
                    modeloConcluidas = new TarefaListModel(Status.CONCLUIDO, p);

                    tarefasBloqueadas.setModel(modeloBloqueadas);
                    tarefasAndamento.setModel(modeloAndamento);
                    tarefasDisponiveis.setModel(modeloDisponiveis);
                    tarefasConcluidas.setModel(modeloConcluidas);
                    tarefasBloqueadas.updateUI();
                    tarefasAndamento.updateUI();
                    tarefasDisponiveis.updateUI();
                    tarefasConcluidas.updateUI();
                } else {
                    return;
                }
            }

        });
        initComponents();

    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        Font font = new Font("Calibri", Font.PLAIN, 18);
        Font fontTarefa = new Font("Calibri", Font.BOLD, 18);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setSize(new Dimension(900, 500));
        setResizable(false);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        lstProjetos.setBackground(Color.black);
        lstProjetos.setForeground(Color.WHITE);
        lstProjetos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstProjetos.setFont(fontTarefa);
        tarefasBloqueadas.setBackground(new java.awt.Color(204, 0, 0));
        tarefasBloqueadas.setForeground(Color.WHITE);
        tarefasBloqueadas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tarefasBloqueadas.setFont(fontTarefa);
        tarefasDisponiveis.setBackground(Color.BLUE);
        tarefasDisponiveis.setForeground(Color.WHITE);
        tarefasDisponiveis.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tarefasDisponiveis.setFont(fontTarefa);
        tarefasAndamento.setBackground(new java.awt.Color(255, 204, 51));
        tarefasAndamento.setForeground(Color.WHITE);
        tarefasAndamento.setFont(fontTarefa);
        tarefasAndamento.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tarefasConcluidas.setBackground(new java.awt.Color(0, 153, 51));
        tarefasConcluidas.setFont(fontTarefa);
        tarefasConcluidas.setForeground(Color.WHITE);
        tarefasConcluidas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JLabel lblProjetos = new JLabel("Projetos");
        JLabel lblBloqueadas = new JLabel("Tarefas Bloqueadas");
        JLabel lblDisponiveis = new JLabel("Tarefas Disponíveis");
        JLabel lblAndamento = new JLabel("Tarefas Em Andamento");
        JLabel lblConcluidas = new JLabel("Tarefas Concluídas");
        lblProjetos.setFont(font);
        lblBloqueadas.setFont(font);
        lblDisponiveis.setFont(font);
        lblAndamento.setFont(font);
        lblConcluidas.setFont(font);

        lblProjetos.setHorizontalAlignment(JLabel.CENTER);
        lblBloqueadas.setHorizontalAlignment(JLabel.CENTER);
        lblDisponiveis.setHorizontalAlignment(JLabel.CENTER);
        lblAndamento.setHorizontalAlignment(JLabel.CENTER);
        lblConcluidas.setHorizontalAlignment(JLabel.CENTER);
        JPanel titulo = new JPanel(new GridLayout(1, 5));
        titulo.add(lblProjetos, BorderLayout.CENTER);
        titulo.add(lblBloqueadas, BorderLayout.CENTER);
        titulo.add(lblDisponiveis, BorderLayout.CENTER);
        titulo.add(lblAndamento, BorderLayout.CENTER);
        titulo.add(lblConcluidas, BorderLayout.CENTER);
        add(titulo, BorderLayout.NORTH);
        jScrollPane1.setViewportView(tarefasBloqueadas);
        jScrollPane2.setViewportView(tarefasDisponiveis);
        jScrollPane3.setViewportView(tarefasAndamento);
        jScrollPane4.setViewportView(tarefasConcluidas);
        jScrollPane5.setViewportView(lstProjetos);

        JPanel corpo = new JPanel(new GridLayout(1, 5));
        corpo.add(jScrollPane5);
        corpo.add(jScrollPane1);
        corpo.add(jScrollPane2);
        corpo.add(jScrollPane3);
        corpo.add(jScrollPane4);
        add(corpo);

    }
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<Projeto> lstProjetos;
    private javax.swing.JList<Tarefa> tarefasAndamento;
    private javax.swing.JList<Tarefa> tarefasBloqueadas;
    private javax.swing.JList<Tarefa> tarefasConcluidas;
    private javax.swing.JList<Tarefa> tarefasDisponiveis;
}
