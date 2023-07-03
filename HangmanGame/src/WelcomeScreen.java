import java.awt.*;


public class WelcomeScreen extends javax.swing.JFrame {

    public WelcomeScreen() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images//gallowsLogo.png")));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_forAll = new javax.swing.JPanel();
        label_gallowGif = new javax.swing.JLabel();
        label_welcome = new javax.swing.JLabel();
        label_pressStart = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hangman Game");

        panel_forAll.setBackground(new java.awt.Color(232, 232, 201));
        panel_forAll.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_gallowGif.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/gallowsGIF.gif"))); // NOI18N
        panel_forAll.add(label_gallowGif, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 220, 210));

        label_welcome.setFont(new java.awt.Font("Tempus Sans ITC", 1, 36)); // NOI18N
        label_welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_welcome.setText("Welcome to Hangman Game");
        panel_forAll.add(label_welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 499, 81));

        label_pressStart.setFont(new java.awt.Font("Tempus Sans ITC", 0, 18)); // NOI18N
        label_pressStart.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_pressStart.setText("Press \"Start\" to play");
        panel_forAll.add(label_pressStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, -1));

        startButton.setBackground(new java.awt.Color(159, 156, 102));
        startButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        startButton.setText("START");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });
        panel_forAll.add(startButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 129, 41));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_forAll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_forAll, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
      this.setVisible(false);
    }//GEN-LAST:event_startButtonActionPerformed


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
            java.util.logging.Logger.getLogger(WelcomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WelcomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WelcomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WelcomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WelcomeScreen().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel label_gallowGif;
    private javax.swing.JLabel label_pressStart;
    private javax.swing.JLabel label_welcome;
    private javax.swing.JPanel panel_forAll;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
