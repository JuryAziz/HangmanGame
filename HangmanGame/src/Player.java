
import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

/*
 add score (for player and opponent)in GUI display word is after round finishes , decreament score? 
 hint after two unsucessful attempts..
 */
public class Player extends javax.swing.JFrame {

    //create the images for hanging process
    static ImageIcon stage1 = new ImageIcon("hangingProcess/stage1.png");
    static ImageIcon stage2 = new ImageIcon("hangingProcess/stage2.png");
    static ImageIcon stage3 = new ImageIcon("hangingProcess/stage3.png");
    static ImageIcon stage4 = new ImageIcon("hangingProcess/stage4.png");
    static ImageIcon stage5 = new ImageIcon("hangingProcess/stage5.png");
    static ImageIcon stage6 = new ImageIcon("hangingProcess/stage6.png");
    static ImageIcon stage7 = new ImageIcon("hangingProcess/stage7.png");
    static ImageIcon stage8 = new ImageIcon("hangingProcess/hangedManGIF.gif");

    //create images for the hearts
    static ImageIcon heart7 = new ImageIcon("hearts/7.png");
    static ImageIcon heart6 = new ImageIcon("hearts/6.png");
    static ImageIcon heart5 = new ImageIcon("hearts/5.png");
    static ImageIcon heart4 = new ImageIcon("hearts/4.png");
    static ImageIcon heart3 = new ImageIcon("hearts/3.png");
    static ImageIcon heart2 = new ImageIcon("hearts/2.png");
    static ImageIcon heart1 = new ImageIcon("hearts/1.png");
    static ImageIcon heart0 = new ImageIcon("hearts/0.png");

    static String hint;
    static String answer;
    static String end;

    //NewJFrame frame;
    private static int playerScore;
    private static int opponentScore;
    private static int attempts;
    private static int winnerID = 0;
    private static int playerID;
    private static DataInputStream fromServer;
    private static DataOutputStream toServer;
    private static Socket socket;

    //constructor
    public Player() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images//gallowsLogo.png")));

        switch (playerID) {
            case 1:
                playerID_label.setText("PLAYER 1");
                playerOneAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images//Player1_.gif")));
                break;
            case 2:
                playerID_label.setText("PLAYER 2");
                playerOneAvatar.setIcon(new javax.swing.ImageIcon(getClass().getResource("Images/player2GIF.gif")));
                break;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        playerOneAvatar = new javax.swing.JLabel();
        playerAnswerBar = new javax.swing.JTextField();
        quitButton = new javax.swing.JButton();
        hintButton = new javax.swing.JButton();
        label_hint = new javax.swing.JLabel();
        feedbackLabel = new javax.swing.JLabel();
        encryptedWordLabel = new javax.swing.JLabel();
        hangingProcessLabel = new javax.swing.JLabel();
        score_label = new javax.swing.JLabel();
        sendButton = new javax.swing.JButton();
        enterLabel1 = new javax.swing.JLabel();
        heartsBar = new javax.swing.JLabel();
        infoLabel = new javax.swing.JLabel();
        playerID_label = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(232, 232, 201));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 220, 210));

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        jLabel2.setText("Welcome to Hangman Game");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 499, 81));

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        jLabel3.setText("Press \"Start\" to play");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, -1));

        jButton1.setBackground(new java.awt.Color(159, 156, 102));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("START");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 129, 41));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hangman Game ");
        setMinimumSize(new java.awt.Dimension(750, 346));

        jPanel2.setBackground(new java.awt.Color(232, 232, 201));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        playerOneAvatar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(playerOneAvatar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 170, 250));

        playerAnswerBar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        playerAnswerBar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        playerAnswerBar.setName("answer"); // NOI18N
        playerAnswerBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playerAnswerBarActionPerformed(evt);
            }
        });
        jPanel2.add(playerAnswerBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 400, 40));

        quitButton.setBackground(new java.awt.Color(159, 156, 102));
        quitButton.setText("Quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });
        jPanel2.add(quitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 310, -1, -1));

        hintButton.setBackground(new java.awt.Color(159, 156, 102));
        hintButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hintLamp.png"))); // NOI18N
        hintButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hintButtonActionPerformed(evt);
            }
        });
        jPanel2.add(hintButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 10, 50, 50));

        label_hint.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        label_hint.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_hint.setText("Hint!");
        jPanel2.add(label_hint, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 60, 50, -1));

        feedbackLabel.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        feedbackLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        feedbackLabel.setText("answer result");
        jPanel2.add(feedbackLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 750, 30));

        encryptedWordLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        encryptedWordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        encryptedWordLabel.setText("_,_,_,_");
        jPanel2.add(encryptedWordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 750, 40));

        hangingProcessLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hangingProcess/stage1.png"))); // NOI18N
        jPanel2.add(hangingProcessLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 260, 180));

        score_label.setFont(new java.awt.Font("Tempus Sans ITC", 0, 14)); // NOI18N
        score_label.setText("Score : 0");
        jPanel2.add(score_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        sendButton.setBackground(new java.awt.Color(159, 156, 102));
        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        jPanel2.add(sendButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, -1, -1));

        enterLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        enterLabel1.setText("Enter your guess (word or letter):");
        jPanel2.add(enterLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 390, 30));

        heartsBar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hearts/7.png"))); // NOI18N
        jPanel2.add(heartsBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 230, 40));

        infoLabel.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        infoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        infoLabel.setText("It's your turn");
        jPanel2.add(infoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 750, -1));

        playerID_label.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        playerID_label.setText("PLAYER");
        jPanel2.add(playerID_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 346, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void playerAnswerBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playerAnswerBarActionPerformed

    }//GEN-LAST:event_playerAnswerBarActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        // quit game and show winner to both players
        this.setVisible(false);
        closure c = new closure();
        c.setVisible(true);
        c.win_lose.setText((playerScore == opponentScore) ? "no winner DRAW" : ((playerScore > opponentScore) ? "You Won" : "You lost"));
        c.score.setText("Your score is " + playerScore);
    }//GEN-LAST:event_quitButtonActionPerformed

    private void hintButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hintButtonActionPerformed
        JOptionPane.showMessageDialog(null, hint);
    }//GEN-LAST:event_hintButtonActionPerformed

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        try {
            answer = playerAnswerBar.getText();
            toServer.writeUTF(answer);
            playerAnswerBar.setText("");
        } catch (IOException ex) {
        }
    }//GEN-LAST:event_sendButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    }

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
            java.util.logging.Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */

        new NewJFrame().setVisible(true);
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
        }

        try {

            // Create connection to server
            connectToServer();

            // Get the playerID from the server
            playerID = fromServer.readInt();
            new Player().setVisible(true);

            // Check which player you are
            if (playerID == 1) {
                // First player  

                //disable the buttons until player 2 joins the game
                playerAnswerBar.setEnabled(false);
                sendButton.setEnabled(false);
                JOptionPane.showMessageDialog(null, "You are player number " + playerID + " !");
                JOptionPane.showMessageDialog(null, "Waiting for player 2 to join...");
                // Wait for server to confirm the game
                fromServer.readUTF();
                JOptionPane.showMessageDialog(null, "Player 2 has joined the game");
                playerID_label.setText("PLAYER 1");

            } else if (playerID == 2) {

                // Second player
                JOptionPane.showMessageDialog(null, "Player 1 has already joined the game");
                JOptionPane.showMessageDialog(null, "You are player number " + playerID + "!");
                // Wait for server to confirm the game
                fromServer.readUTF();
                playerID_label.setText("PLAYER 2");

            }
            // else for the existing letter
            start();

        } catch (IOException ex) {

        }
    }

    public static void connectToServer() {
        try {
            // Connect to the server
            socket = new Socket("localhost", 1743);
            // Create output stream to send data from player to server
            toServer = new DataOutputStream(socket.getOutputStream());
            // Create input stream to get data from server
            fromServer = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            System.out.println("Error connecting! Please try again later");
        }
    }

    public static void start() {
        do {
            try {
                inGame();
                if (playerID == winnerID) {
                    playerScore++;
                } else if (winnerID != 0) {
                    opponentScore++;
                }
                score_label.setText("Score: "+playerScore);
                winnerID = 0;
            } catch (IOException ex) {

            }
        } while (true);
    }

    public static void inGame() throws IOException {
        playerAnswerBar.setEnabled(false);
        sendButton.setEnabled(false);
        hint = fromServer.readUTF();
        feedbackLabel.setText("");
        // read number of attempts
        attempts = fromServer.readInt();
        int opponentAttempts = fromServer.readInt();
        hangingProcessLabel.setIcon(stage1);
        heartsBar.setIcon(heart7);

        // while no one won or some still have attempts, keep playing.
        do {

            // Recieve the encrypted word and print it
            encryptedWordLabel.setText(fromServer.readUTF());

            // which player turn it is
            int playerTurn = fromServer.readInt();
            infoLabel.setText(fromServer.readUTF());

            if (playerID == playerTurn) {
                //enable to send answer
                playerAnswerBar.setEnabled(true);
                sendButton.setEnabled(true);
                waitforAnswer();
            }

            // Recieve the result from server
            String result = fromServer.readUTF();
            feedbackLabel.setText(result);

            if (result.contains("you won!")) {
                String word = fromServer.readUTF();
                winner w = new winner();
                w.setVisible(true);
                w.wordLabel.setText("The word is " + word);
            } else if (result.contains("has won")) {
                String word = fromServer.readUTF();
                loser l = new loser();
                l.setVisible(true);
                l.wordLabel.setText("The word is " + word);
            }

            //update winnerID 
            winnerID = fromServer.readInt();
            if (winnerID != 0) {
                break;
            }

            //Update number of attempts
            attempts = fromServer.readInt();
            opponentAttempts = fromServer.readInt();

            // change to hearts implement in switch 
            switch (attempts) {
                case 6:
                    hangingProcessLabel.setIcon(stage2);
                    heartsBar.setIcon(heart6);
                    break;
                case 5:
                    hangingProcessLabel.setIcon(stage3);
                    heartsBar.setIcon(heart5);
                    break;
                case 4:
                    hangingProcessLabel.setIcon(stage4);
                    heartsBar.setIcon(heart4);
                    break;
                case 3:
                    hangingProcessLabel.setIcon(stage5);
                    heartsBar.setIcon(heart3);
                    break;
                case 2:
                    hangingProcessLabel.setIcon(stage6);
                    heartsBar.setIcon(heart2);
                    break;
                case 1:
                    hangingProcessLabel.setIcon(stage7);
                    heartsBar.setIcon(heart1);
                    break;
                case 0:
                    hangingProcessLabel.setIcon(stage8);
                    heartsBar.setIcon(heart0);
                    break;
            }

            playerAnswerBar.setEnabled(false);
            sendButton.setEnabled(false);
        } while (opponentAttempts != 0 || attempts != 0);

        // needs implementation GUI
        //if someone won stop 
        if (winnerID == 0) {
            String word = fromServer.readUTF();
            noWinner n = new noWinner();
            n.setVisible(true);
            n.jLabel2.setText("The word is " + word);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel encryptedWordLabel;
    private static javax.swing.JLabel enterLabel1;
    public static javax.swing.JLabel feedbackLabel;
    private static javax.swing.JLabel hangingProcessLabel;
    private static javax.swing.JLabel heartsBar;
    private static javax.swing.JButton hintButton;
    public static javax.swing.JLabel infoLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel label_hint;
    public static javax.swing.JTextField playerAnswerBar;
    private static javax.swing.JLabel playerID_label;
    private static javax.swing.JLabel playerOneAvatar;
    private static javax.swing.JButton quitButton;
    private static javax.swing.JLabel score_label;
    static javax.swing.JButton sendButton;
    // End of variables declaration//GEN-END:variables

    public String getAnswer() {
        do {
            answer = playerAnswerBar.getText();
        } while (answer == null);
        return answer;
    }

    private static void waitforAnswer() {
        answer = "";
        while (answer.isEmpty()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }
    }
    
    private static void isQuit(String s){
        if (s.contains("quit")) {
            JOptionPane.showMessageDialog(null, "The opponent has quit the game");
        }
    }
}
