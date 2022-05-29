/**
 * Calculates and reduces a given fraction to its lowest terms.
 * 
 * modified     20220527
 * date         20220524
 * @filename    ReduceFraction.java
 * @author      Alvin Chan, Evan Shizas
 * @version     1.0.0
 * @see         A15 - Recursion
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ReduceFraction extends JFrame {

	private JPanel contentPane;
	private JTextField dialogBox;
	private JTextArea reducerInfo;
	private JButton calculate;
	private JSpinner numeratorSelect;
	private JSpinner denominatorSelect;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReduceFraction frame = new ReduceFraction();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ReduceFraction() {
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("A15 - Fraction Reducer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel title = new JLabel("Fraction Reducer");
		title.setForeground(Color.BLUE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.BOLD, 30));
		title.setBackground(Color.WHITE);
		title.setBounds(0, 0, 475, 40);
		contentPane.add(title);

		JLabel enterNumeratorLbl = new JLabel("Enter the Numerator:");
		enterNumeratorLbl.setBackground(Color.WHITE);
		enterNumeratorLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		enterNumeratorLbl.setBounds(10, 112, 310, 22);
		contentPane.add(enterNumeratorLbl);

		JLabel enterDenominatorLbl = new JLabel("Enter the Denominator:");
		enterDenominatorLbl.setBackground(Color.WHITE);
		enterDenominatorLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		enterDenominatorLbl.setBounds(10, 147, 310, 22);
		contentPane.add(enterDenominatorLbl);

		reducerInfo = new JTextArea();
		reducerInfo.setWrapStyleWord(true);
		reducerInfo.setLineWrap(true);
		reducerInfo.setText("This program calculates and reduces a given fraction to its lowest terms...");
		reducerInfo.setFont(new Font("Tahoma", Font.ITALIC, 15));
		reducerInfo.setEditable(false);
		reducerInfo.setBackground(Color.WHITE);
		reducerInfo.setBounds(10, 55, 452, 50);
		contentPane.add(reducerInfo);

		numeratorSelect = new JSpinner();
		numeratorSelect.setModel(new SpinnerNumberModel(0, -1000000000, 1000000000, 1));
		numeratorSelect.setForeground(Color.WHITE);
		numeratorSelect.setBackground(Color.WHITE);
		numeratorSelect.setBounds(318, 112, 147, 22);
		contentPane.add(numeratorSelect);

		denominatorSelect = new JSpinner();
		denominatorSelect.setModel(new SpinnerNumberModel(0, -1000000000, 1000000000, 1));
		denominatorSelect.setForeground(Color.WHITE);
		denominatorSelect.setBackground(Color.WHITE);
		denominatorSelect.setBounds(318, 147, 147, 22);
		contentPane.add(denominatorSelect);

		calculate = new JButton("Reduce Fraction to Lowest Terms");
		calculate.setBounds(10, 188, 455, 23);
		contentPane.add(calculate);
		calculate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				calculateActionPerformed(evt);
			}
		});

		dialogBox = new JTextField();
		dialogBox.setBackground(Color.WHITE);
		dialogBox.setEditable(false);
		dialogBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		dialogBox.setBounds(10, 227, 455, 25);
		contentPane.add(dialogBox);
		dialogBox.setColumns(10);
	}
	
	private void calculateActionPerformed(java.awt.event.ActionEvent evt) {
		int nu = (Integer) numeratorSelect.getValue(), de = (Integer) denominatorSelect.getValue(), nuReduced = nu, deReduced = de;
		int factor = gcd(nu, de);
		
		nuReduced /= factor;
		deReduced /= factor;
		
		if (deReduced == 1 || nuReduced == 0) {
			dialogBox.setText(nu + "/" + de + " in lowest terms is " + nuReduced + "!");
		} 
		
		else if (deReduced < 0 && nuReduced > 0) {
			dialogBox.setText(nu + "/" + de + " in lowest terms is " + (-1)*nuReduced + "/" + (-1)*deReduced + "!");
		}
		
		else {
			dialogBox.setText(nu + "/" + de + " in lowest terms is " + nuReduced + "/" + deReduced + "!");
		}
		
		if (de == 0 && nu != 0)
			dialogBox.setText("DENOMINATOR CANNOT BE 0! TRY AGAIN!");
	}
	
	public int gcd(int a, int b) {
		if (b == 0 && a != 0) {
			return a;
		}
		
		else if (a == 0) {
			return 1; // Prevents divide by zero!
		}

		else {
			return gcd(b, a % b);
		}
	}
}