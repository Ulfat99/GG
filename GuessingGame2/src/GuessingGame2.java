import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame2 extends JFrame {
	private final JLabel lblUlfatsHiloGuessinggame = new JLabel("Ulfat's Hi-Lo GuessingGame");
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {
			int guess = Integer.parseInt(guessText);
			if(guess < theNumber)
				message = guess + "is too low. Try again.";
			else if (guess > theNumber)
				message = guess + "is too high. Try again.";
			else {
				message = guess + "is correct. You win! Lets's play again!";
				newGame();
			}
		} catch (Exception e) {
			message = "Enter a whole number between 1 and 100.";
		} finally {
			lblOutput.setText(message);
			txtGuess.requestFocus();
			txtGuess.selectAll();
		}
	}
	public void newGame() {
		theNumber = (int)(Math.random() * 100 + 1);
	}
	public GuessingGame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Ulfat's Hi-Lo Guessing Game");
		getContentPane().setLayout(null);
		lblUlfatsHiloGuessinggame.setHorizontalAlignment(SwingConstants.CENTER);
		lblUlfatsHiloGuessinggame.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUlfatsHiloGuessinggame.setBounds(0, 37, 424, 32);
		getContentPane().add(lblUlfatsHiloGuessinggame);

		JLabel lblNewLabel = new JLabel("Guess a number between 1 and 100:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(46, 108, 220, 39);
		getContentPane().add(lblNewLabel);

		txtGuess = new JTextField();
		txtGuess.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGuess.setBounds(275, 117, 86, 20);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		txtGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});

		JButton btnNewButton = new JButton("Guess!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnNewButton.setBounds(177, 148, 89, 23);
		getContentPane().add(btnNewButton);

		lblOutput = new JLabel("Enter a number above and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(0, 182, 424, 39);
		getContentPane().add(lblOutput);
	}

	public static void main(String[] args) {
		GuessingGame2 theGame = new GuessingGame2();
		theGame.newGame();
		theGame.setSize(new Dimension(450,300));
		theGame.setVisible(true);
	}
}
