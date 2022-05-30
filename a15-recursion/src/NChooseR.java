/**
 * Calculates the number of ways r different objects can be chosen from a set of n objects.
 * 
 * modified     20220527
 * date         20220524
 * @filename    NChooseR.java
 * @author      Alvin Chan, Evan Shizas
 * @version     1.0.0
 * @see         A15 - Recursion
 */

import java.awt.BorderLayout;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Color;

public class NChooseR extends JFrame {

	private JPanel contentPane;
	private JTextField dialogBox;
	private JTextArea nChooseRInfo;
	private JButton calculate;
	private JSpinner objectsSelect;
	private JSpinner chooseSelect;

	int oldNum = 0;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NChooseR frame = new NChooseR();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public NChooseR() {
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("A15 - n Choose r");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel title = new JLabel("n Choose r");
		title.setForeground(Color.BLUE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.BOLD, 30));
		title.setBackground(Color.WHITE);
		title.setBounds(0, 0, 475, 40);
		contentPane.add(title);
		
		JLabel enterObjectsLbl = new JLabel("Enter the number of objects to choose (r): [0 - 20]");
		enterObjectsLbl.setBackground(Color.WHITE);
		enterObjectsLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		enterObjectsLbl.setBounds(10, 112, 370, 22);
		contentPane.add(enterObjectsLbl);
		
		JLabel enterChooseLbl = new JLabel("Enter the number of objects to choose from (n): [r - 20]");
		enterChooseLbl.setBackground(Color.WHITE);
		enterChooseLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		enterChooseLbl.setBounds(10, 147, 370, 22);
		contentPane.add(enterChooseLbl);

		nChooseRInfo = new JTextArea();
		nChooseRInfo.setWrapStyleWord(true);
		nChooseRInfo.setLineWrap(true);
		nChooseRInfo.setText("This program calculates the number of ways r different objects can be chosen from a set of n objects...");
		nChooseRInfo.setFont(new Font("Tahoma", Font.ITALIC, 15));
		nChooseRInfo.setEditable(false);
		nChooseRInfo.setBackground(Color.WHITE);
		nChooseRInfo.setBounds(10, 55, 452, 50);
		contentPane.add(nChooseRInfo);

		objectsSelect = new JSpinner();
		objectsSelect.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		objectsSelect.setForeground(Color.WHITE);
		objectsSelect.setBackground(Color.WHITE);
		objectsSelect.setBounds(390, 112, 75, 22);
		contentPane.add(objectsSelect);
		objectsSelect.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
				objectsSelectActionPerformed(evt);
			}
		});
		
		chooseSelect = new JSpinner();
		chooseSelect.setModel(new SpinnerNumberModel(0, 0, 20, 1));
		chooseSelect.setForeground(Color.WHITE);
		chooseSelect.setBackground(Color.WHITE);
		chooseSelect.setBounds(390, 147, 75, 22);
		contentPane.add(chooseSelect);

		calculate = new JButton("Calculate the Number of Ways");
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
	
	private void objectsSelectActionPerformed(ChangeEvent e) { 
		// Needed due to Java not being able to handle the large values if objectSelect has a value greater than that of chooseSelect!
		
		if (oldNum > (int) objectsSelect.getValue() || (int) chooseSelect.getValue() > (int) objectsSelect.getValue())
			chooseSelect.setModel(new SpinnerNumberModel((int) chooseSelect.getValue(), (int) objectsSelect.getValue(), 20, 1));
		else
			chooseSelect.setModel(new SpinnerNumberModel((int) objectsSelect.getValue(), (int) objectsSelect.getValue(), 20, 1));
		
		oldNum = (int) objectsSelect.getValue();
	}

	private void calculateActionPerformed(java.awt.event.ActionEvent evt) {		
		long r = (long)((int) objectsSelect.getValue()), n = (long)((int) chooseSelect.getValue()), numerator = 1, denominator1 = 1, denominator2 = 1, result = 0,
				diffFactorial = n-r, i = n, i1 = r;
		
		result = numeratorRecur(numerator, i) / (denominator1Recur(denominator1, i1) * denominator2Recur(denominator2, diffFactorial));
		
		dialogBox.setText("There are " + result + " ways!");
		
		if (result == 1)
			dialogBox.setText("There is " + result + " way!");
	}
	
	public long numeratorRecur(long numerator, long i) {
		if (i > 0) {
			numerator *= i;
			i--;
			return numeratorRecur(numerator, i);
		}
		
		else {
			return numerator;
		}
	}
	
	public long denominator1Recur(long denominator1, long i1) {
		if (i1 > 0) {
			denominator1 *= i1;
			i1--;
			return denominator1Recur(denominator1, i1);
		}
		
		else {
			return denominator1;
		}
	}
	
	public long denominator2Recur(long denominator2, long diffFactorial) {
		if (diffFactorial > 0) {
			denominator2 *= diffFactorial;
			diffFactorial--;
			return denominator2Recur(denominator2, diffFactorial);
		}
		
		else {
			return denominator2;
		}
	}
}