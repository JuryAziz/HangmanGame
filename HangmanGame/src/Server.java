
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;
import javax.swing.ImageIcon;

public class Server extends javax.swing.JFrame {

    private static int sessionNum = 0; //the session number
    //Image for error
    static ImageIcon serverError = new ImageIcon("src/Images/serverError.png");

    public Server() {
        initComponents();
        //Set Icon
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Images//server.png")));
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackGround_Panel = new javax.swing.JPanel();
        text_UpdateAboutGame = new javax.swing.JLabel();
        serverImage = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textBox = new javax.swing.JTextArea();
        label_serverSide = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hangman Server");
        setBackground(new java.awt.Color(232, 232, 201));

        BackGround_Panel.setBackground(new java.awt.Color(232, 232, 201));
        BackGround_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        text_UpdateAboutGame.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        text_UpdateAboutGame.setText("Updates About Game");
        BackGround_Panel.add(text_UpdateAboutGame, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 340, 30));

        serverImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/serverGIF.gif"))); // NOI18N
        BackGround_Panel.add(serverImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(-60, 60, 260, 230));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        textBox.setEditable(false);
        textBox.setColumns(20);
        textBox.setFont(new java.awt.Font("Ebrima", 0, 18)); // NOI18N
        textBox.setRows(5);
        textBox.setAutoscrolls(false);
        jScrollPane1.setViewportView(textBox);
        textBox.getAccessibleContext().setAccessibleDescription("");

        BackGround_Panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 480, 290));

        label_serverSide.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        label_serverSide.setText("SERVER SIDE");
        BackGround_Panel.add(label_serverSide, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackGround_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BackGround_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackGround_Panel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_serverSide;
    public static javax.swing.JLabel serverImage;
    private static javax.swing.JTextArea textBox;
    private javax.swing.JLabel text_UpdateAboutGame;
    // End of variables declaration//GEN-END:variables

    public static AudioInputStream audioInputStream;
    public static Clip clip;

    // ----------------- MAIN --------------------------
    public static void main(String args[]) throws FileNotFoundException, IOException, UnsupportedAudioFileException, LineUnavailableException {
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
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Server.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        new Server().setVisible(true);

        //create a server socket
        ServerSocket serverSocket = new ServerSocket(1743);

        audioInputStream = AudioSystem.getAudioInputStream(new File("sounds/soundtrack.wav"));

        textBox.append("---- SERVER IS WORKING ----");

        try {
            while (true) {
                
                textBox.append("\n\nSession No." + ++sessionNum);
                textBox.append("\nWaiting for player 1 to join the game...");

                //Accept connection of player 1
                Socket player1Socket = serverSocket.accept();
                new DataOutputStream(player1Socket.getOutputStream()).writeInt(1); //inform the player he/she is player one
                textBox.append("\nPlayer 1 has joined the game!\n");
                textBox.append("\nWaiting for player 2 to join the game...\n");

                //Accept connection of player 2
                Socket player2Socket = serverSocket.accept();
                new DataOutputStream(player2Socket.getOutputStream()).writeInt(2); //inform the player he/she is player two
                textBox.append("\nPlayer 2 has joined the game\n");

                // audio 
                clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
                gainControl.setValue(-35.0f); // Reduce volume by 35 decibels.
                clip.loop(Clip.LOOP_CONTINUOUSLY);
                clip.start();

                // Message to inform players that the game has started
                textBox.append("\nThe game has started!");
                new DataOutputStream(player1Socket.getOutputStream()).writeUTF("START!");
                new DataOutputStream(player2Socket.getOutputStream()).writeUTF("START!");

                // starting a new thread for the game
                new Thread(new HangmanGame(player1Socket, player2Socket, textBox, sessionNum)).start();

            }
        } catch (Exception ex) {
            textBox.append("\nError in Server");
            serverImage.setIcon(serverError);
        }

    }

}//class

// ------------------- HANGMAN GAME --------------------------
class HangmanGame extends Thread {

    //Attribute for the clients
    private String randomWord; //chose the random word from the dictionary
    private String hint; //hint for the word
    private char[] encryptedWord; //encrypted the random word into _,_,_,_
    private Socket player1;
    private Socket player2;
    private DataInputStream fromPlayer1;
    private DataOutputStream toPlayer1;
    private DataInputStream fromPlayer2;
    private DataOutputStream toPlayer2;
    private final int attempts = 7;
    private int player1Attempts;
    private int player2Attempts;
    private boolean won;
    private String answer;
    private ArrayList<String> Dictionary = new ArrayList();
    private ArrayList<String> Hints = new ArrayList();
    private javax.swing.JTextArea textBox;
    private int Session;

    public HangmanGame(Socket player1, Socket player2, javax.swing.JTextArea textBox, int Session) {
        this.player1 = player1;
        this.player2 = player2;
        this.textBox = textBox;
        this.Session = Session;
    }

    @Override
    public void run() {

        try {

            words();

            fromPlayer1 = new DataInputStream(player1.getInputStream());
            fromPlayer2 = new DataInputStream(player2.getInputStream());
            toPlayer1 = new DataOutputStream(player1.getOutputStream());
            toPlayer2 = new DataOutputStream(player2.getOutputStream());

            do {
                randomWord();
                textBox.append("\n The random word is: "+randomWord);
                // The players attempts are the length of the word + 2 
                player1Attempts = player2Attempts = attempts;

                Game();
                won = false;

            } while (true);

        } catch (IOException ex) {
            textBox.append("\nGame ended in Session " + Session);
            Server.clip.stop(); // players have quit the game
        }

    }

    private void Game() throws IOException {

        toPlayer1.writeUTF(hint);
        toPlayer2.writeUTF(hint);
        toPlayer1.writeInt(player1Attempts);
        toPlayer1.writeInt(player2Attempts);
        toPlayer2.writeInt(player2Attempts);
        toPlayer2.writeInt(player1Attempts);
        do {

            // Player 1's turn
            if (player1Attempts > 0) {

                //send the encryped word to both players
                toPlayer1.writeUTF(formatWord());
                toPlayer2.writeUTF(formatWord());

                // Send playerID to players to indicate which player's turn it is
                toPlayer1.writeInt(1);
                toPlayer2.writeInt(1);

                // Send message to players
                toPlayer1.writeUTF("It is now your turn! ");

                if (player2Attempts != 0) {
                    toPlayer2.writeUTF("It's player 1's turn!");
                } else {
                    toPlayer2.writeUTF("You lost, It's player 1's turn!");
                }

                // Read player 1's answer
                answer = fromPlayer1.readUTF().toLowerCase();
                boolean exist = alreadyExist(answer.charAt(0));
                // If player 1's answer is correct
                if (checkCorrect(answer)) {
                    if (answer.length() == 1 && exist) {
                        toPlayer1.writeUTF("The letter '" + answer + "' already answered before!\nTry to focus next time");
                        toPlayer2.writeUTF("Player 1 sent the letter '" + answer + "' again!");

                        // No winner
                        toPlayer2.writeInt(0); // winnerID
                        toPlayer1.writeInt(0); // winnerID
                    } // If player 1 entered an entire word
                    else if (answer.length() > 1) {
                        toPlayer1.writeUTF("Congratulations, you won! \n the word is ");
                        toPlayer1.writeUTF(randomWord);
                        toPlayer2.writeUTF("Player 1 has won, the word is ");
                        toPlayer2.writeUTF(randomWord);

                        toPlayer1.writeInt(1); // winnerID
                        toPlayer2.writeInt(1); // winnerID
                        won = true;
                        break;
                        // If player 1 completed the word using the last character
                    } else if (isWinner()) {
                        toPlayer1.writeUTF("Congratulations, you won! \n the word is ");
                        toPlayer1.writeUTF(randomWord);
                        toPlayer2.writeUTF("Player 1 has won, the word is ");
                        toPlayer2.writeUTF(randomWord);

                        toPlayer1.writeInt(1); // winnerID
                        toPlayer2.writeInt(1); // winnerID
                        // Player 1 won --> increment score, rveal winner, new round, new word
                        won = true;
                        break;
                    } else {
                        // Update player 1 & 2 guesses
                        toPlayer1.writeUTF("Your guess is correct!");
                        toPlayer2.writeUTF("Player 1's guess is correct!");

                        // No one has won
                        toPlayer1.writeInt(0); // winnerID
                        toPlayer2.writeInt(0); // winnerID
                    }
                } else {
                    // Player 1 = wrong answer
                    // Update player 1 & 2 guesses
                    toPlayer1.writeUTF("Your guess is incorrect!");
                    toPlayer2.writeUTF("Player 1's guess is incorrect!");
                    // Decrease player attempts
                    player1Attempts--;

                    // No one has won
                    toPlayer1.writeInt(0); // winnerID
                    toPlayer2.writeInt(0); // winnerID
                }

                // sending player attempts for both players
                toPlayer1.writeInt(player1Attempts);
                toPlayer1.writeInt(player2Attempts);
                toPlayer2.writeInt(player2Attempts);
                toPlayer2.writeInt(player1Attempts);
            }

            // Player 2's turn
            if (player2Attempts > 0) {

                //send the encryped word to the players
                toPlayer1.writeUTF(formatWord());
                toPlayer2.writeUTF(formatWord());

                // Send playerID to players to indicate which player's turn it is
                toPlayer2.writeInt(2);
                toPlayer1.writeInt(2);

                // >> STILL UNDER MAKING, INFINITE LOOP FOR SOME REASON :/ <<
                // --- HINT ---
                /*if(player2Attempts == 2){
                            toPlayer2.writeUTF("Only two attempts are left, would you like a hint? y/n: ");
                            answerOfhint = (fromPlayer2.readUTF()).toLowerCase();
                            if("y".equals(answerOfhint)){
                                toPlayer2.writeUTF(hint);
                            }  
                        }*/
                // Take input from player 2
                toPlayer2.writeUTF("It is now your turn! ");

                if (player1Attempts != 0) {
                    toPlayer1.writeUTF("It's player 2's turn!");
                } else {
                    toPlayer1.writeUTF("You lost, It's player 2's turn.");
                }

                // Read player 2's answer
                answer = fromPlayer2.readUTF().toLowerCase();
                boolean exist = alreadyExist(answer.charAt(0));
                // If player 2's answer is correct
                if (checkCorrect(answer)) {
                    //check if the answer alread exist
                    if (answer.length() == 1 && exist) {
                        toPlayer2.writeUTF("The letter '" + answer + "' already answered before!\nTry to focus next time");
                        toPlayer1.writeUTF("Player 2 sent the letter '" + answer + "' again!");

                        // No winner
                        toPlayer2.writeInt(0); // winnerID
                        toPlayer1.writeInt(0); // winnerID
                    } // If player 2 entered an entire word
                    else if (answer.length() > 1) {
                        toPlayer2.writeUTF("Congratulations, you won! \n the word is ");
                        toPlayer2.writeUTF(randomWord);
                        toPlayer1.writeUTF("Player 2 has won, the word is ");
                        toPlayer1.writeUTF(randomWord);

                        toPlayer2.writeInt(2); // winnerID
                        toPlayer1.writeInt(2); // winnerID
                        won = true;
                        break;
                        // If player 2 completed the word using the last character
                    } else if (isWinner()) {
                        toPlayer2.writeUTF("Congratulations, you won! \n the word is ");
                        toPlayer2.writeUTF(randomWord);
                        toPlayer1.writeUTF("Player 2 has won, the word is ");
                        toPlayer1.writeUTF(randomWord);
                        toPlayer2.writeInt(2); // winnerID
                        toPlayer1.writeInt(2); // winnerID
                        // Player 2 won --> increment score, rveal winner, new round, new word
                        won = true;
                        break;

                    } else {
                        // Update player 1 & 2 guesses
                        toPlayer2.writeUTF("Your guess is correct!");
                        toPlayer1.writeUTF("Player 2's guess is correct!");

                        // No winner
                        toPlayer2.writeInt(0); // winnerID
                        toPlayer1.writeInt(0); // winnerID
                    }
                } else {

                    // Player 2 = wrong answer
                    // Update player 1 & 2 guesses
                    toPlayer2.writeUTF("Your guess is incorrect!");
                    toPlayer1.writeUTF("Player 2's guess is incorrect!");

                    // Decrease player attempts
                    player2Attempts--;

                    // No winner
                    toPlayer2.writeInt(0); // winnerID
                    toPlayer1.writeInt(0); // winnerID
                }

                // sending player attempts for both players
                toPlayer1.writeInt(player1Attempts);
                toPlayer1.writeInt(player2Attempts);
                toPlayer2.writeInt(player2Attempts);
                toPlayer2.writeInt(player1Attempts);

            }

        } while (!won && (player1Attempts != 0 || player2Attempts != 0)); // End the game if all attempts are 0 or someone won the game
        //In case no one won and number of attempts were zero for both
        if (!won) {
            toPlayer1.writeUTF(randomWord);
            toPlayer2.writeUTF(randomWord);
        }
    }

    private void words() throws IOException {

        //read the file that has all the words
        File inputFile = new File("hangmanDictionary.txt");
        File hints = new File("hangmanDictionaryhints.txt");

        if (!inputFile.exists()) {
            textBox.append("Oops, we can't find our dictionary!! "
                    + "\n please make sure you downloaded the game correctly "
                    + "\n we'll be waiting.. come back when you find it");
        }

        //Take the random word and its hint
        Scanner inputScanner = new Scanner(inputFile);
        Scanner hintsScanner = new Scanner(hints);

        while (inputScanner.hasNext()) {
            Dictionary.add(inputScanner.next().toLowerCase());
            Hints.add(hintsScanner.nextLine());
        }
    }

    //This method chooses a random word \\ CHANGE THIS \\
    private void randomWord() throws IOException {

        //choose random line (we have 107 words which means we have 107 lines)
        int randomLine = (int) (Math.random() * Dictionary.size());

        //return the appropriate word
        randomWord = Dictionary.remove(randomLine);
        encryptedWord = randomWord.replaceAll("\\w", "_").toCharArray();
        hint = Hints.remove(randomLine);

    }
    //-----------------------------------------------------------------------------------

    //-----------------------------------------------------------------------------------
    private boolean checkCorrect(String answer) {

        if (answer.equalsIgnoreCase(randomWord)) {
            return true;
        } else if (answer.length() == 1 && randomWord.contains(answer)) { // entered a char not a word
            revealChar(answer.charAt(0));
            return true;
        }
        return false;
    }
    //-----------------------------------------------------------------------------------

    private void revealChar(char answer) {
        for (int i = 0; i < randomWord.length(); i++) {
            int index = randomWord.indexOf(answer, i); //change the encrypted char with the actual letter starting from i to reveal all similar letters
            if (index == -1) {
                return;
            }
            encryptedWord[index] = answer;
        }
    }
    //-----------------------------------------------------------------------------------

    private String formatWord() {
        String s = "";
        for (int i = 0; i < encryptedWord.length - 1; i++) {
            s += encryptedWord[i] + ",";
        }
        return s + encryptedWord[encryptedWord.length - 1];
    }
    //-----------------------------------------------------------------------------------

    private boolean isWinner() {
        for (int i = 0; i < encryptedWord.length; i++) {
            if (randomWord.charAt(i) != encryptedWord[i]) {
                return false;
            }
        }
        return true;
    }
    //-----------------------------------------------------------------------------------

    private boolean alreadyExist(char answer) {
        //This method will check if the letter already was revealed
        for (int i = 0; i < encryptedWord.length; i++) {
            if (encryptedWord[i] == answer) {
                return true;
            }
        }
        return false;
    }
    //-----------------------------------------------------------------------------------

}//class end

