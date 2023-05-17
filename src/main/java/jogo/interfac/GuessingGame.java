package jogo.interfac;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class GuessingGame extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblGuessingGame;
    private JLabel lblGuessANumber;
    private JLabel lblResult;
    private JButton btnGuess;
    private JButton btnNewGame;
    private int secretNumber;
    private int attemptsLeft = 5;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GuessingGame frame = new GuessingGame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GuessingGame() {
    	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\guessingGameIcon.jpg"));
    	setFont(new Font("Dialog", Font.ITALIC, 12));
    	setBackground(new Color(255, 255, 255));
    	setResizable(false);
    	setTitle("The best guessing game ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        setLocationRelativeTo(null);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblGuessingGame = new JLabel("Guessing Game");
        lblGuessingGame.setFont(new Font("Lucida Grande", Font.BOLD, 18));
        lblGuessingGame.setHorizontalAlignment(SwingConstants.CENTER);
        lblGuessingGame.setBounds(-4, 44, 438, 25);
        contentPane.add(lblGuessingGame);
        
        lblGuessANumber = new JLabel("Guess a number between 1 and 100:");
        lblGuessANumber.setFont(new Font("Tahoma", Font.ITALIC, 11));
        lblGuessANumber.setHorizontalAlignment(SwingConstants.CENTER);
        lblGuessANumber.setBounds(-4, 76, 438, 25);
        contentPane.add(lblGuessANumber);

        lblResult = new JLabel("");
        lblResult.setHorizontalAlignment(SwingConstants.CENTER);
        lblResult.setBounds(6, 193, 438, 25);
        contentPane.add(lblResult);

        btnGuess = new JButton("Guess!");
        btnGuess.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\guessIcon.png"));
        btnGuess.setBackground(new Color(192, 192, 192));
        btnGuess.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
        btnGuess.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int guess = Integer.parseInt(JOptionPane.showInputDialog("Enter your guess:"));
                if (guess == secretNumber) {
                    lblResult.setText("You guessed it! You win!");
                    btnGuess.setEnabled(false);
                    btnNewGame.setEnabled(true);
                } else {
                    attemptsLeft--;
                    if (attemptsLeft == 0) {
                        lblResult.setText("You ran out of attempts! The secret number was " + secretNumber + ". You lose.");
                        btnGuess.setEnabled(false);
                        btnNewGame.setEnabled(true);
                    } else {
                        String result = guess < secretNumber ? "Too low! " : "Too high! ";
                        result += "You have " + attemptsLeft + " attempts left.";
                        lblResult.setText(result);
                    }
                }
            }
        });
        btnGuess.setBounds(81, 128, 117, 29);
        contentPane.add(btnGuess);

        btnNewGame = new JButton("New Game");
        btnNewGame.setIcon(new ImageIcon("C:\\Users\\GETIN\\Desktop\\Gerenciador de salário(GS)\\GerenciadorSalario\\img\\guessIcon.png"));
        btnNewGame.setBackground(new Color(192, 192, 192));
        btnNewGame.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
        btnNewGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secretNumber = new Random().nextInt(100) + 1;
                attemptsLeft = 5;
                lblResult.setText("");
                btnGuess.setEnabled(true);
                btnNewGame.setEnabled(false);
            }
        });
        btnNewGame.setBounds(226, 128, 117, 29);
        btnNewGame.setEnabled(false);
        contentPane.add(btnNewGame); 
}
    
}