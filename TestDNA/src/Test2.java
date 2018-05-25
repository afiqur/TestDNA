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

public class Test2 extends JFrame {

	private JPanel contentPane;
	private JTextArea inputTA;

	private JTextArea outputTA;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test2 frame = new Test2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private String ch;
	int i, len;

	/**
	 * Create the frame.
	 */
	private void calculate() {
		ch = inputTA.getText();
		String out = "";
		for (int i = 0; i < ch.length(); ++i) {
			char c = ch.charAt(i);
			if (c == 'T') {
				out += 'U';
			} else if (c == 't') {
				out += 'u';
			} else {
				out += c;
			}
		}
		outputTA.setText(out);
	}

	public Test2() {
		setTitle("Transcribing DNA into RNA");
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

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(27, 109, 373, 51);
		contentPane.add(scrollPane_1);

		outputTA = new JTextArea();
		scrollPane_1.setViewportView(outputTA);
		outputTA.setFont(new Font("Monospaced", Font.PLAIN, 15));
	}
}
