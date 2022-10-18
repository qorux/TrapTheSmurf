package main.java.edu.chalmers.projecttemplate.view;


import javax.swing.*;

import main.java.edu.chalmers.projecttemplate.model.*;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;


/**
 *
 * @author linae
 */

public class ProjectView extends javax.swing.JFrame implements PropertyChangeListener {

    /**
     * Creates new form myFirstForm
     */

    //private Game game;
    private ButtonBoard buttonBoard;
    private Board hexagonBoard;

    private GameHandler gameHandler;


    public ProjectView(GameHandler gameHandler) {
        initComponents();
        jPanel1.setLayout(new FlowLayout(5,0,0 ));

        this.gameHandler = gameHandler;
        this.buttonBoard = new ButtonBoard(gameHandler.getCurrentGame().getBoard(), jPanel1);
        this.hexagonBoard = gameHandler.getCurrentGame().getBoard();


        this.setTitle("Trap the smurf!");
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
        jPanel1 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabelWinLose = new javax.swing.JLabel();
        jLabelRecord = new javax.swing.JLabel();
        jLabelRule = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 575));
        setMinimumSize(new java.awt.Dimension(800, 575));

        jButton1.setBackground(new java.awt.Color(102, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 221, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 151, Short.MAX_VALUE)
        );

        jPanel1.setMaximumSize(new java.awt.Dimension(548, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(548, 500));
        jPanel1.setPreferredSize(new java.awt.Dimension(548, 500));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelRule, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(101, 101, 160))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(114, 114, 114))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(114, 114, 114))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(66, 66, 66))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelWinLose, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(40, 40, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton3)
                                .addGap(36, 36, 36)
                                .addComponent(jLabelRule)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel2)
                                .addGap(20, 20, 20)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 290)
                                .addComponent(jLabelWinLose)
                                .addGap(10,10,10)
                                .addComponent(jLabelRecord)
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents



    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelRecord;
    private javax.swing.JLabel jLabelRule;
    private javax.swing.JLabel jLabelWinLose;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    // End of variables declaration//GEN-END:variables

    public void setLabels() {
        jButton1.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 18)); // NOI18N
        jButton1.setText("Reset game");
        jButton1.setToolTipText("Press to reset the game");

        jLabel2.setText("Number of turns: ");
        jLabel2.setFont(new java.awt.Font("Segoe UI", Font.BOLD, 18));

        jLabelRule.setText("<html> Your record: "+gameHandler.getRecordTurns()+"<br> Total wins: "+gameHandler.getTotalWins()+"<br> Total losses: "+gameHandler.getTotalLosses()+"</html>");
        jLabelRule.setToolTipText("Your record displays the least amount of turns it took you to beat the smurf");

        jRadioButton1.setText("Easy");
        jRadioButton1.setToolTipText("Choose easy difficulty, press reset to apply");
        jRadioButton2.setText("Medium");
        jRadioButton2.setToolTipText("Choose medium difficulty, press reset to apply");
        jRadioButton3.setText("Hard");
        jRadioButton3.setToolTipText("Choose hard difficulty, press reset to apply");

        ButtonGroup group = new ButtonGroup();
        group.add(jRadioButton1);
        group.add(jRadioButton2);
        group.add(jRadioButton3);
    }

    public void propertyChange(PropertyChangeEvent evt) {

        if(!gameHandler.getCurrentGame().isHasLost() && !gameHandler.getCurrentGame().isHasWon()){
            repaintBoardView();
        }
        else if (Objects.equals(evt.getPropertyName(), "Won")) {//aids
            for (int i = 0; i<121; i++) {
                buttonBoard.getButton(i).setEnabled(false);
            }
            getjLabel2().setText("You won the game! You won in " + gameHandler.getCurrentGame().getTurn() + " turns. Press reset to play again");
        }
        else if (Objects.equals(evt.getPropertyName(), "Lost")) {
            for (int i = 0; i<121; i++) {
                buttonBoard.getButton(i).setEnabled(false);
            }
            getjLabel2().setText("The Smurf won. It escaped in " + gameHandler.getCurrentGame().getTurn() + " turns. Press reset to play again");
        }
    }

    public void repaintBoardView(){
        getjLabel2().setText("Number of wins: " + gameHandler.getCurrentGame().getTurn() + " ");
        setLabels();
        for(int i = 0; i<121; i++) {
            if (FreeTile.class.equals(hexagonBoard.getHexagon(i).getCurrentStateClass())&& !buttonBoard.getButton(i).getIsHovered()){
                buttonBoard.getButton(i).setBackground(Color.cyan);
                buttonBoard.getButton(i).setEnabled(true);
            }
            else if (FreeTile.class.equals(hexagonBoard.getHexagon(i).getCurrentStateClass())&& buttonBoard.getButton(i).getIsHovered()){
                buttonBoard.getButton(i).setBackground(Color.getHSBColor(0.5f, 0.7f, 0.7f));
                buttonBoard.getButton(i).setEnabled(true);
            }
            else if (OccupiedTile.class.equals(hexagonBoard.getHexagon(i).getCurrentStateClass())) {
                try {
                    setSmurfImage(i);
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
                buttonBoard.getButton(i).setEnabled(false);
            }
            else if (BlockedTile.class.equals(hexagonBoard.getHexagon(i).getCurrentStateClass())) {
                buttonBoard.getButton(i).setBackground(Color.darkGray);
                buttonBoard.getButton(i).setEnabled(false);
            }
        }
    }


    public void setSmurfImage(int i) throws MalformedURLException { //Funkar inte , DMHB!
        ImageIcon smurf = new ImageIcon(new URL("https://e7.pngegg.com/pngimages/1016/380/png-clipart-sticker-telegram-the-smurfs-text-viber-smurf-area-soccer.png"));
        Image image = smurf.getImage();
        Image smurfImage = image.getScaledInstance(10, 10,  java.awt.Image.SCALE_SMOOTH);
        smurf = new ImageIcon(smurfImage);
        buttonBoard.getButton(i).setIcon(smurf);
        buttonBoard.getButton(i).setBackground(Color.RED);
    }

    // standard getter and setter

    public JButton getjButton1() {
        return jButton1;
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

    public hexButton getButton(int Index) {
        return buttonBoard.getButton(Index);
    }

    public ArrayList<hexButton> getButtonBoard() {
        return buttonBoard.getButtonBoard();
    }

    public void setGame(Game game) {
        this.gameHandler.getCurrentGame().getBoard().removePropertyChangeListener(this);
        this.hexagonBoard = game.getBoard();
        buttonBoard.setBoard(game.getBoard());
        for(int i = 0; i<121 ;i++){
            buttonBoard.getButton(i).setNewHexagonBoard(this.gameHandler.getCurrentGame().getBoard().getHexagon(i));
        }
        this.gameHandler.getCurrentGame().getBoard().addPropertyChangeListener(this);
    }
}
