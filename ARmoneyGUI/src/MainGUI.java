import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {

	private JPanel mainPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
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
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		mainPane = new JPanel();
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPane);
		GridBagLayout gbl_mainPane = new GridBagLayout();
		gbl_mainPane.columnWidths = new int[]{800};
		gbl_mainPane.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_mainPane.columnWeights = new double[]{1.0};
		gbl_mainPane.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		mainPane.setLayout(gbl_mainPane);
		
		JLabel lblWeclome = new JLabel("Weclome to AR Money");
		lblWeclome.setFont(new Font("Times New Roman", Font.BOLD, 48));
		GridBagConstraints gbc_lblWeclome = new GridBagConstraints();
		gbc_lblWeclome.weighty = 0.3;
		gbc_lblWeclome.weightx = 1.0;
		gbc_lblWeclome.insets = new Insets(0, 0, 5, 5);
		gbc_lblWeclome.gridx = 0;
		gbc_lblWeclome.gridy = 0;
		mainPane.add(lblWeclome, gbc_lblWeclome);
		
		JButton btnLanguage = new JButton("\u65E5\u672C\u8A9E");
		btnLanguage.setFont(new Font("MS Mincho", Font.BOLD, 18));
		GridBagConstraints gbc_btnLanguage = new GridBagConstraints();
		gbc_btnLanguage.weighty = 0.1;
		gbc_btnLanguage.anchor = GridBagConstraints.EAST;
		gbc_btnLanguage.insets = new Insets(0, 0, 20, 75);
		gbc_btnLanguage.gridx = 0;
		gbc_btnLanguage.gridy = 1;
		mainPane.add(btnLanguage, gbc_btnLanguage);
		
		JPanel subPane = new JPanel();
		GridBagConstraints gbc_subPane = new GridBagConstraints();
		gbc_subPane.weighty = 0.5;
		gbc_subPane.weightx = 1.0;
		gbc_subPane.fill = GridBagConstraints.BOTH;
		gbc_subPane.gridx = 0;
		gbc_subPane.gridy = 2;
		mainPane.add(subPane, gbc_subPane);
		GridBagLayout gbl_subPane = new GridBagLayout();
		gbl_subPane.columnWeights = new double[]{0.0};
		gbl_subPane.rowWeights = new double[]{0.0};
		subPane.setLayout(gbl_subPane);
		
		JPanel btnPane = new JPanel();
		GridBagConstraints gbc_btnPane = new GridBagConstraints();
		gbc_btnPane.weighty = 1.0;
		gbc_btnPane.weightx = 1.0;
		gbc_btnPane.fill = GridBagConstraints.BOTH;
		gbc_btnPane.insets = new Insets(0, 0, 0, 0);
		gbc_btnPane.gridx = 0;
		gbc_btnPane.gridy = 0;
		subPane.add(btnPane, gbc_btnPane);
		GridBagLayout gbl_btnPane = new GridBagLayout();
		gbl_btnPane.columnWidths = new int[]{660};
		gbl_btnPane.rowHeights = new int[]{90, 90, 90};
		gbl_btnPane.columnWeights = new double[]{0.0};
		gbl_btnPane.rowWeights = new double[]{0.0, 0.0, 0.0};
		btnPane.setLayout(gbl_btnPane);
		
		JButton btnCharge = new JButton("Charge");
		btnCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					dispose();
				    new ChargePage().setVisible(true);
			}
		});
		btnCharge.setFont(new Font("Times New Roman", Font.BOLD, 36));
		GridBagConstraints gbc_btnCharge = new GridBagConstraints();
		gbc_btnCharge.fill = GridBagConstraints.BOTH;
		gbc_btnCharge.insets = new Insets(20, 10, 20, 10);
		gbc_btnCharge.weighty = 0.3;
		gbc_btnCharge.gridx = 0;
		gbc_btnCharge.gridy = 0;
		btnPane.add(btnCharge, gbc_btnCharge);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.setFont(new Font("Times New Roman", Font.BOLD, 36));
		GridBagConstraints gbc_btnPurchase = new GridBagConstraints();
		gbc_btnPurchase.fill = GridBagConstraints.BOTH;
		gbc_btnPurchase.insets = new Insets(20, 10, 20, 10);
		gbc_btnPurchase.weighty = 0.3;
		gbc_btnPurchase.gridx = 0;
		gbc_btnPurchase.gridy = 1;
		btnPane.add(btnPurchase, gbc_btnPurchase);
		
		JButton btnBalance = new JButton("Check Balance");
		btnBalance.setFont(new Font("Times New Roman", Font.BOLD, 36));
		GridBagConstraints gbc_btnBalance = new GridBagConstraints();
		gbc_btnBalance.fill = GridBagConstraints.BOTH;
		gbc_btnBalance.insets = new Insets(20, 10, 20, 10);
		gbc_btnBalance.weighty = 0.3;
		gbc_btnBalance.gridx = 0;
		gbc_btnBalance.gridy = 2;
		btnPane.add(btnBalance, gbc_btnBalance);
		
		JLabel lblInfo = new JLabel("<html><p align =\"right\">I-CARE Group<br>University of Tsukuba</p></html>");
		lblInfo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInfo.setFont(new Font("Times New Roman", Font.BOLD, 12));
		GridBagConstraints gbc_lblInfo = new GridBagConstraints();
		gbc_lblInfo.weighty = 0.1;
		gbc_lblInfo.fill = GridBagConstraints.BOTH;
		gbc_lblInfo.insets = new Insets(0, 0, 0, 50);
		gbc_lblInfo.gridx = 0;
		gbc_lblInfo.gridy = 3;
		mainPane.add(lblInfo, gbc_lblInfo);
	}

}
