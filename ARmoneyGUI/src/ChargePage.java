import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChargePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChargePage frame = new ChargePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChargePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblInfo = new JLabel("Please select the charge amout");
		lblInfo.setFont(new Font("Times New Roman", Font.BOLD, 48));
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblInfo = new GridBagConstraints();
		gbc_lblInfo.weighty = 0.3;
		gbc_lblInfo.insets = new Insets(0, 0, 5, 0);
		gbc_lblInfo.weightx = 1.0;
		gbc_lblInfo.fill = GridBagConstraints.BOTH;
		gbc_lblInfo.gridx = 0;
		gbc_lblInfo.gridy = 0;
		contentPane.add(lblInfo, gbc_lblInfo);
		
		JPanel btnPane = new JPanel();
		GridBagConstraints gbc_btnPane = new GridBagConstraints();
		gbc_btnPane.weighty = 0.4;
		gbc_btnPane.insets = new Insets(0, 0, 5, 0);
		gbc_btnPane.fill = GridBagConstraints.BOTH;
		gbc_btnPane.gridx = 0;
		gbc_btnPane.gridy = 1;
		contentPane.add(btnPane, gbc_btnPane);
		GridBagLayout gbl_btnPane = new GridBagLayout();
		gbl_btnPane.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_btnPane.rowWeights = new double[]{0.0, 0.0};
		btnPane.setLayout(gbl_btnPane);
		
		JButton btn500yen = new JButton("\u00A5500");
		btn500yen.setFont(new Font("Times New Roman", Font.BOLD, 24));
		GridBagConstraints gbc_btn500yen = new GridBagConstraints();
		gbc_btn500yen.weightx = 0.3;
		gbc_btn500yen.weighty = 0.5;
		gbc_btn500yen.fill = GridBagConstraints.BOTH;
		gbc_btn500yen.insets = new Insets(40, 10, 40, 10);
		gbc_btn500yen.gridx = 0;
		gbc_btn500yen.gridy = 0;
		btnPane.add(btn500yen, gbc_btn500yen);
		
		JButton btn1000yen = new JButton("\u00A51000");
		btn1000yen.setFont(new Font("Times New Roman", Font.BOLD, 24));
		GridBagConstraints gbc_btn1000yen = new GridBagConstraints();
		gbc_btn1000yen.weighty = 0.5;
		gbc_btn1000yen.weightx = 0.3;
		gbc_btn1000yen.fill = GridBagConstraints.BOTH;
		gbc_btn1000yen.insets = new Insets(40, 10, 40, 10);
		gbc_btn1000yen.gridx = 1;
		gbc_btn1000yen.gridy = 0;
		btnPane.add(btn1000yen, gbc_btn1000yen);
		
		JButton btn2000yen = new JButton("\u00A52000");
		btn2000yen.setFont(new Font("Times New Roman", Font.BOLD, 24));
		GridBagConstraints gbc_btn2000yen = new GridBagConstraints();
		gbc_btn2000yen.weighty = 0.5;
		gbc_btn2000yen.weightx = 0.3;
		gbc_btn2000yen.fill = GridBagConstraints.BOTH;
		gbc_btn2000yen.insets = new Insets(40, 10, 40, 10);
		gbc_btn2000yen.gridx = 2;
		gbc_btn2000yen.gridy = 0;
		btnPane.add(btn2000yen, gbc_btn2000yen);
		
		JButton btn3000yen = new JButton("\u00A53000");
		btn3000yen.setFont(new Font("Times New Roman", Font.BOLD, 24));
		GridBagConstraints gbc_btn3000yen = new GridBagConstraints();
		gbc_btn3000yen.weightx = 0.3;
		gbc_btn3000yen.weighty = 0.5;
		gbc_btn3000yen.fill = GridBagConstraints.BOTH;
		gbc_btn3000yen.insets = new Insets(40, 10, 40, 10);
		gbc_btn3000yen.gridx = 0;
		gbc_btn3000yen.gridy = 1;
		btnPane.add(btn3000yen, gbc_btn3000yen);
		
		JButton btn4000yen = new JButton("\u00A54000");
		btn4000yen.setFont(new Font("Times New Roman", Font.BOLD, 24));
		GridBagConstraints gbc_btn4000yen = new GridBagConstraints();
		gbc_btn4000yen.weighty = 0.5;
		gbc_btn4000yen.weightx = 0.3;
		gbc_btn4000yen.fill = GridBagConstraints.BOTH;
		gbc_btn4000yen.insets = new Insets(40, 10, 40, 10);
		gbc_btn4000yen.gridx = 1;
		gbc_btn4000yen.gridy = 1;
		btnPane.add(btn4000yen, gbc_btn4000yen);
		
		JButton btn5000yen = new JButton("\u00A55000");
		btn5000yen.setFont(new Font("Times New Roman", Font.BOLD, 24));
		GridBagConstraints gbc_btn5000yen = new GridBagConstraints();
		gbc_btn5000yen.insets = new Insets(40, 10, 40, 10);
		gbc_btn5000yen.weighty = 0.5;
		gbc_btn5000yen.weightx = 0.3;
		gbc_btn5000yen.fill = GridBagConstraints.BOTH;
		gbc_btn5000yen.gridx = 2;
		gbc_btn5000yen.gridy = 1;
		btnPane.add(btn5000yen, gbc_btn5000yen);
		
		JButton btnReturn = new JButton("Back to Menu");
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MainGUI().setVisible(true);
			}
		});
		btnReturn.setFont(new Font("Times New Roman", Font.BOLD, 18));
		GridBagConstraints gbc_btnReturn = new GridBagConstraints();
		gbc_btnReturn.insets = new Insets(0, 0, 0, 10);
		gbc_btnReturn.ipady = 20;
		gbc_btnReturn.ipadx = 20;
		gbc_btnReturn.anchor = GridBagConstraints.EAST;
		gbc_btnReturn.weighty = 0.3;
		gbc_btnReturn.gridx = 0;
		gbc_btnReturn.gridy = 2;
		contentPane.add(btnReturn, gbc_btnReturn);
	}

}
