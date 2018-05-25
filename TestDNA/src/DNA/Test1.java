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

public class Test1 extends JFrame {

	private JPanel contentPane;
	private JTextField outputTF;
	private JTextArea inputTA;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test1 frame = new Test1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private String ch;
	int i, len, A = 0, C = 0, G = 0, T = 0;

	/**
	 * Create the frame.
	 */

	private void calculate() {
		ch = inputTA.getText();
		for (i = 0; i < ch.length(); i++) {
			if (ch.charAt(i) == 'A') {
				A++;
			} else if (ch.charAt(i) == 'C') {
				C++;
			} else if (ch.charAt(i) == 'G') {
				G++;
			} else if (ch.charAt(i) == 'T') {
				T++;
			}
		}
		outputTF.setText(A + " " + C + " " + G + " " + T);

	}

	public Test1() {
		setTitle("Counting DNA Nucleotides");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		outputTF = new JTextField();
		outputTF.setHorizontalAlignment(SwingConstants.CENTER);
		outputTF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		outputTF.setEditable(false);
		outputTF.setBounds(112, 109, 211, 43);
		contentPane.add(outputTF);
		outputTF.setColumns(10);

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
				outputTF.setText(null);
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
	}
}
