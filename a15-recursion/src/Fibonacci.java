/**
 * Lists fibonacci number term based on user selection.
 * 
 * modified     20220524
 * date         20220524
 * @filename    Fibonacci.java
 * @author      Alvin Chan, Evan Shizas
 * @version     1.0.0
 * @see         A15 - Recursion
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Fibonacci extends JFrame {

	private JPanel contentPane;
	private JTextField dialogBox;
	private JButton calculate;
	private JSpinner termSelect;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fibonacci frame = new Fibonacci();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Fibonacci() {
		setTitle("A15 - Fibonacci Numbers");
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 260);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Fibonacci Numbers");
		title.setForeground(Color.BLUE);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.BOLD, 30));
		title.setBackground(Color.WHITE);
		title.setBounds(0, 0, 475, 40);
		contentPane.add(title);
		
		JLabel enterHereLbl = new JLabel("Enter the fibonacci term that you would like to see: ");
		enterHereLbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		enterHereLbl.setBounds(10, 112, 310, 22);
		contentPane.add(enterHereLbl);
		
		JTextArea fibInfo = new JTextArea();
		fibInfo.setWrapStyleWord(true);
		fibInfo.setLineWrap(true);
		fibInfo.setText("The first ten fibonocci numbers are listed as follows: 0, 1, 1, 2, 3, 5, 8, 13, 21...");
		fibInfo.setFont(new Font("Tahoma", Font.ITALIC, 15));
		fibInfo.setEditable(false);
		fibInfo.setBackground(Color.WHITE);
		fibInfo.setBounds(10, 55, 452, 50);
		contentPane.add(fibInfo);
		
		termSelect = new JSpinner();
		termSelect.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		termSelect.setForeground(Color.WHITE);
		termSelect.setBackground(Color.WHITE);
		termSelect.setBounds(318, 112, 147, 22);
		contentPane.add(termSelect);
		
		calculate = new JButton("Find the Fibonacci Number");
		calculate.setBounds(10, 150, 455, 23);
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
		dialogBox.setBounds(10, 189, 455, 25);
		contentPane.add(dialogBox);
		dialogBox.setColumns(10);
	}
	
	void fibber(ArrayList<Integer> fib, int x, int n) {
		fib.add(fib.get(x-1) + fib.get(x-2));
		x++;
		
		if (x < n) {
			fibber(fib, x, n);
		}
	}
	
	private void calculateActionPerformed(java.awt.event.ActionEvent evt) {
		int n = (Integer) termSelect.getValue();;
		int x = 0;
		int sum = 0;
		ArrayList<Integer> fib = new ArrayList<Integer>();
		
		fib.add(1);
		x++;
		fib.add(1);
		x++;
		
		fibber(fib, x, n);
		
		dialogBox.setText(fib.get(n - 1).toString());
		
		// remove 0 from descrip
		// greater than 48 is broken af
	}
}