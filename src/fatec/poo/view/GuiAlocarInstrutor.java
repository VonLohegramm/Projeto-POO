/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.view;

import fatec.poo.control.Conexao;
import fatec.poo.control.DaoCurso;
import fatec.poo.control.DaoInstrutor;
import fatec.poo.control.DaoTurma;
import fatec.poo.model.Curso;
import fatec.poo.model.Instrutor;
import fatec.poo.model.Turma;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class GuiAlocarInstrutor extends javax.swing.JFrame {

    /**
     * Creates new form GuiAlocarInstrutor
     */
    public GuiAlocarInstrutor() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSair = new javax.swing.JButton();
        btnLiberar = new javax.swing.JButton();
        btnAlocar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbCurso = new javax.swing.JComboBox<>();
        cmbTurma = new javax.swing.JComboBox<>();
        cmbInstrutor = new javax.swing.JComboBox<>();
        txtSituacao = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                formPropertyChange(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/exit.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnLiberar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/Eraser.png"))); // NOI18N
        btnLiberar.setText("Liberar");
        btnLiberar.setEnabled(false);
        btnLiberar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLiberarActionPerformed(evt);
            }
        });

        btnAlocar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/poo/view/icon/add.png"))); // NOI18N
        btnAlocar.setText("Alocar");
        btnAlocar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlocarActionPerformed(evt);
            }
        });

        jLabel1.setText("Curso");

        jLabel2.setText("Turma");

        jLabel3.setText("Instrutor");

        jLabel4.setText("Situação");

        cmbCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCursoActionPerformed(evt);
            }
        });

        cmbTurma.setToolTipText("");
        cmbTurma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTurmaActionPerformed(evt);
            }
        });

        txtSituacao.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAlocar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLiberar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(30, 30, 30)
                                            .addComponent(cmbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel3)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel4)
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbTurma, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbInstrutor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLiberar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAlocar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCursoActionPerformed
       cmbTurma.removeAllItems();
        for(int i = 0; i < cursos.size(); i++){
            if(cmbCurso.getSelectedItem().toString().equals(cursos.get(i).getSigla())){
                for(int y = 0; y < cursos.get(i).getTurmas().size(); y++){
                    cmbTurma.addItem(cursos.get(i).getTurmas().get(y).getSiglaTurma());
                }
            }
        }
    }//GEN-LAST:event_cmbCursoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        conexao = new Conexao("", "");
        ArrayList<Turma> turmas = null;
        conexao.setConnectionString("jdbc:ucanaccess://F:\\Dowloands\\prjPOOEduardoGabriel\\src\\fatec\\poo\\basededados\\bdPOO.accdb\\");
        conexao.setDriver("net.ucanaccess.jdbc.UcanaccessDriver");
        this.setTitle("Alocar Instrutor");
        daoTurma = new DaoTurma(conexao.conectar());
        daoCurso = new DaoCurso(conexao.conectar());
        daoInstrutor = new DaoInstrutor(conexao.conectar());
        
        cursos = daoCurso.listarSiglas();
        instrutores = daoInstrutor.listarSiglas();
        
        for (int i = 0; i < cursos.size(); i++) {
            
            turmas = daoTurma.listarTurmas(cursos.get(i).getSigla());
            for(int y = 0; y < turmas.size(); y++){
                cursos.get(i).addTurma(turmas.get(y));
            }
        }
        
        for(int i = 0; i < cursos.size(); i++){
            
            cmbCurso.addItem(cursos.get(i).getSigla());
        }
        
        for (int i = 0; i < instrutores.size(); i++) {
            cmbInstrutor.addItem(instrutores.get(i).getNome());
        }
        
    }//GEN-LAST:event_formWindowOpened

    private void formPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_formPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_formPropertyChange

    private void cmbTurmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTurmaActionPerformed
        
        if(cmbTurma.getItemCount() != 0){
            if(daoTurma.situacao(cmbTurma.getSelectedItem().toString())){
                txtSituacao.setText("Alocada");
                btnAlocar.setEnabled(false);
                btnLiberar.setEnabled(true);
            }
            else{
                txtSituacao.setText("Liberada");
                btnAlocar.setEnabled(true);
                btnLiberar.setEnabled(false);
            }
        }
        
        
    }//GEN-LAST:event_cmbTurmaActionPerformed

    private void btnAlocarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlocarActionPerformed
        String cpf = null;
        for(int i = 0; i < instrutores.size(); i++){
            if(cmbInstrutor.getSelectedItem().toString().equals(instrutores.get(i).getNome())){
                cpf = instrutores.get(i).getCpf();
            }
        }
        daoTurma.alocar(cpf, cmbTurma.getSelectedItem().toString());
        txtSituacao.setText("Alocada");
        btnAlocar.setEnabled(false);
        btnLiberar.setEnabled(true);
    }//GEN-LAST:event_btnAlocarActionPerformed

    private void btnLiberarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLiberarActionPerformed
        daoTurma.liberar(cmbTurma.getSelectedItem().toString());
        txtSituacao.setText("Liberada");
        btnAlocar.setEnabled(true);
        btnLiberar.setEnabled(false);
    }//GEN-LAST:event_btnLiberarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GuiAlocarInstrutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuiAlocarInstrutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuiAlocarInstrutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuiAlocarInstrutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuiAlocarInstrutor().setVisible(true);
            }
        });
    }
    private Conexao conexao = null;
    private DaoTurma daoTurma = null;
    private DaoCurso daoCurso = null;
    private DaoInstrutor daoInstrutor = null;
    ArrayList<Instrutor> instrutores = null;
    ArrayList<Curso> cursos = null;
    private Turma turma = null;
    private Curso curso = null;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlocar;
    private javax.swing.JButton btnLiberar;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> cmbCurso;
    private javax.swing.JComboBox<String> cmbInstrutor;
    private javax.swing.JComboBox<String> cmbTurma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtSituacao;
    // End of variables declaration//GEN-END:variables
}