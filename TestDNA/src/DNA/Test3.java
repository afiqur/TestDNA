package DNA;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Test3 extends JFrame {

	private JPanel contentPane;
	private JTextArea inputTA;
	private JTextArea outputTA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test3 frame = new Test3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private String ch;
	int i, j, len;

	/**
	 * Create the frame.
	 */

	public void calculate() {

		ch = inputTA.getText();

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < ch.length(); i++) {
			//char c = ch.charAt(i);
			if (ch.charAt(i) == 'T') {
				builder.append('A');
			}
			if (ch.charAt(i) == 'A') {
				builder.append('T');
			}
			if (ch.charAt(i) == 'C') {
				builder.append('G');
			}
			if (ch.charAt(i) == 'G') {
				builder.append('C');
			}
		}
		outputTA.setText(builder.toString());

	}

	public Test3() {
		setTitle("Complementing a Strand of DNA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton calculateBtn = new JButton("Calculate");
		calculateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				calculate();
			}
		});
		calculateBtn.setBounds(176, 75, 89, 23);
		contentPane.add(calculateBtn);

		JButton resetBtn = new JButton("Reset");
		resetBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputTA.setText(null);
				outputTA.setText(null);
			}
		});
		resetBtn.setBounds(176, 163, 89, 23);
		contentPane.add(resetBtn);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 11, 375, 53);
		contentPane.add(scrollPane);

		inputTA = new JTextArea();
		inputTA.setFont(new Font("Monospaced", Font.PLAIN, 15));
		scrollPane.setViewportView(inputTA);
		
		outputTA = new JTextArea();
		outputTA.setBounds(27, 111, 375, 41);
		contentPane.add(outputTA);
	}
}
