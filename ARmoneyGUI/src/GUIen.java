import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIen extends JFrame {

	private JFrame frame = new JFrame("AR Money Project");
	private JPanel contentPane = new JPanel();
	private JPanel mainPane = new JPanel();
	private JPanel chargePane = new JPanel();;
	private JPanel purchasePane = new JPanel();;
	private JPanel balancePane = new JPanel();;
	private CardLayout cl = new CardLayout();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new GUIen();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUIen() {				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setLayout(cl);
		contentPane.add(mainPane, "main");
		contentPane.add(chargePane, "charge");
		contentPane.add(purchasePane, "purchase");
		contentPane.add(balancePane, "balance");
		mainPage();
		chargePage();
		purchasePage();
		balancePage();
		cl.show(contentPane, "main");
		
		frame.add(contentPane);
		frame.pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height;
		int width = screenSize.width;
		frame.setSize(width/2, height/2);
		//Center the JFrame on screen
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	
	//Create the main page
	void mainPage(){
		mainPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
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
		btnLanguage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					frame.dispose();
				    new GUIjp();
			}
		});
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
					cl.show(contentPane, "charge");
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
	
	
	//Create the charge page
	void chargePage(){
		chargePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GridBagLayout gbl_chargePane = new GridBagLayout();
		gbl_chargePane.columnWidths = new int[]{0, 0};
		gbl_chargePane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_chargePane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_chargePane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		chargePane.setLayout(gbl_chargePane);
		
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
		chargePane.add(lblInfo, gbc_lblInfo);
		
		JPanel btnPane = new JPanel();
		GridBagConstraints gbc_btnPane = new GridBagConstraints();
		gbc_btnPane.weighty = 0.4;
		gbc_btnPane.insets = new Insets(0, 0, 5, 0);
		gbc_btnPane.fill = GridBagConstraints.BOTH;
		gbc_btnPane.gridx = 0;
		gbc_btnPane.gridy = 1;
		chargePane.add(btnPane, gbc_btnPane);
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
				cl.show(contentPane, "main");
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
		chargePane.add(btnReturn, gbc_btnReturn);
	}
	
	//Create the purchase page
	void purchasePage(){
		
		
	}
	
	//Create the balance_check page
	void balancePage(){
		
		
	}

}
