package main.java.edu.chalmers.projecttemplate.view;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.swing.*;
import main.java.edu.chalmers.projecttemplate.model.Project;

import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author linae
 */

public class myFirstForm extends javax.swing.JFrame {

    /**
     * Creates new form myFirstForm
     */

    private Project project;
    public ArrayList<hexButton> buttonBoard = new ArrayList<hexButton>();

    private OHexagonButtonState observer;


    public myFirstForm(Project Project) {

//        int maxHeight = 11;
//        int maxWidth = 11;

        initComponents();
        this.project=Project;
        jPanel1.setLayout(new FlowLayout(5,0,0 ));


        for(int i =0;i<=120;i++){
            buttonBoard.add(generateButton(i));

        }
        observer = new OHexagonButtonState(buttonBoard, project.getBoard());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 575));

        jButton1.setBackground(new java.awt.Color(102, 255, 255));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Counter:");

        jPanel1.setMaximumSize(new java.awt.Dimension(548, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(548, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(548, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public OHexagonButtonState getObserver() {
        return observer;
    }
    public JButton getjButton1() {
        return jButton1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public ArrayList<hexButton> getButtonBoard() {
        return buttonBoard;
    }


    public hexButton generateButton(Integer index){
        hexButton generatedButton = new hexButton(project.board.getHexagon(index));
        generatedButton.setBackground(Color.cyan);
        generatedButton.setPreferredSize(new Dimension(40,40));
        jPanel1.add(generatedButton);
        jPanel1.add(Box.createRigidArea(new Dimension(8,0)));
        if (index == 10 || index == 32 || index == 54 || index == 76 || index == 98){
            for (int i = 0; i < 4 ; i++) {
                JPanel jPanelMini = new JPanel();
                jPanelMini.setSize(20,40);
                jPanel1.add(jPanelMini);
            }
        }
        return generatedButton;
    }
}
