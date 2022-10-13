package main.java.edu.chalmers.projecttemplate.view;


import javax.swing.*;

import main.java.edu.chalmers.projecttemplate.model.Project;

import java.awt.*;
import java.util.ArrayList;


/**
 *
 * @author linae
 */

public class ProjectView extends javax.swing.JFrame {

    /**
     * Creates new form myFirstForm
     */

    private Project project;
    public ArrayList<hexButton> buttonBoard = new ArrayList<hexButton>();
    private OBoardState observer;


    public ProjectView(Project Project) {
        initComponents();
        this.project=Project;
        jPanel1.setLayout(new FlowLayout(5,0,0 ));

        for(int i =0;i<=120;i++){
            buttonBoard.add(generateButton(i));
        }
        observer = new OBoardState(this, project );
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
        jLabel2 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 575));
        setMinimumSize(new java.awt.Dimension(800, 575));

        jButton1.setBackground(new java.awt.Color(102, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 18)); // NOI18N
        jButton1.setText("Reset");
        /*
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

         */

        //jLabel1.setText("Counter:");

        jPanel1.setMaximumSize(new java.awt.Dimension(548, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(548, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(548, 500));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        jLabel2.setText("Number of turns: ");
        jLabel2.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 18));

        jRadioButton1.setText("Easy");

        jRadioButton2.setText("Medium");

        jRadioButton3.setText("Hard");

        ButtonGroup group = new ButtonGroup();
        group.add(jRadioButton1);
        group.add(jRadioButton2);
        group.add(jRadioButton3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(126, 126, 126)
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(1, 1, 40)
                                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(40, 40, 86)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(27, 27, 27)
                                                .addComponent(jRadioButton1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jRadioButton2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jRadioButton3)))
                                .addGap(14, 14, 14))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents



    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;

    // End of variables declaration//GEN-END:variables

    public OBoardState getObserver() {
        return observer;
    }
    public JButton getjButton1() {
        return jButton1;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getjLabel2() { return jLabel2; }

    public JRadioButton getjRadioButton1() {
        return jRadioButton1;
    }
    public JRadioButton getjRadioButton2() {
        return jRadioButton2;
    }
    public JRadioButton getjRadioButton3() {
        return jRadioButton3;
    }

    public ArrayList<hexButton> getButtonBoard() {
        return buttonBoard;
    }



    private hexButton generateButton(Integer index){
        hexButton generatedButton = new hexButton(project.getBoard().getHexagon(index));
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

    public void setProject(Project project) {//slay
        this.project = project;
    }
}
