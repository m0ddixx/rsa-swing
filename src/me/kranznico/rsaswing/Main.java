package me.kranznico.rsaswing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.math.BigInteger;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.JTextArea;
import java.awt.Dimension;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import java.awt.Font;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1967378347139264362L;
	private JPanel contentPane;
	private JTextField pTextField;
	private JTextField qTextField;
	private JButton btnGenerateprimebutton;
	private JTextField nTextField;
	private JLabel nLabel;
	private RSA rsamodule;
	private JLabel lblE;
	private JTextField eTextField;
	private JButton btnRefreshbutton;
	private JLabel phiLabel;
	private JTextField phiTextField;
	private JTextArea clearTextArea;
	private JTextArea cipherTextArea;
	private JButton btnEncrypt;
	private JButton btnDecrypt;
	private JButton btnEditRsa;
	private ScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	private JTextField rangeTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPrimzahlP = new JLabel(Messages.getString("Main.0")); //$NON-NLS-1$
		lblPrimzahlP.setBounds(15, 9, 48, 14);
		contentPane.add(lblPrimzahlP);

		pTextField = new JTextField();
		pTextField.setFont(new Font("Tahoma", Font.PLAIN, 9)); //$NON-NLS-1$
		pTextField.setBounds(79, 6, 352, 20);
		pTextField.addInputMethodListener(new InputMethodListener() {
			@Override
			public void caretPositionChanged(InputMethodEvent event) {
			}
			@Override
			public void inputMethodTextChanged(InputMethodEvent event) {
				if(new BigInteger(pTextField.getText()).isProbablePrime(1000))
				{
					if(!qTextField.getText().isEmpty())
					{
						if(new BigInteger(qTextField.getText()).isProbablePrime(1000))
						{
							rsamodule = new RSA(new BigInteger(pTextField.getText()), new BigInteger(qTextField.getText()));
							nTextField.setText(rsamodule.getN());
						}
					}
				}
			}
		});
		contentPane.add(pTextField);
		pTextField.setColumns(10);
		
		nLabel = new JLabel(Messages.getString("Main.2")); //$NON-NLS-1$
		nLabel.setBounds(447, 9, 25, 14);
		contentPane.add(nLabel);
		
		nTextField = new JTextField();
		nTextField.setBounds(482, 6, 306, 20);
		contentPane.add(nTextField);
		nTextField.setColumns(10);
		
		lblE = new JLabel(Messages.getString("Main.3")); //$NON-NLS-1$
		lblE.setBounds(447, 64, 25, 14);
		contentPane.add(lblE);
		
		eTextField = new JTextField();
		eTextField.setBounds(482, 61, 306, 20);
		contentPane.add(eTextField);
		eTextField.setColumns(10);

		JLabel lblPrimzahlQ = new JLabel(Messages.getString("Main.4")); //$NON-NLS-1$
		lblPrimzahlQ.setBounds(15, 89, 48, 14);
		contentPane.add(lblPrimzahlQ);

		qTextField = new JTextField();
		qTextField.setFont(new Font("Tahoma", Font.PLAIN, 9)); //$NON-NLS-1$
		qTextField.setBounds(79, 86, 352, 20);
		qTextField.addInputMethodListener(new InputMethodListener() {
			@Override
			public void caretPositionChanged(InputMethodEvent event) {
			}
			@Override
			public void inputMethodTextChanged(InputMethodEvent event) {
				if(new BigInteger(qTextField.getText()).isProbablePrime(1000))
				{
					if(pTextField.getText() != "") //$NON-NLS-1$
					{
						if(new BigInteger(qTextField.getText()).isProbablePrime(1000))
						{
							rsamodule = new RSA(new BigInteger(pTextField.getText()), new BigInteger(qTextField.getText()));
							nTextField.setText(rsamodule.getN());
						}
					}
				}
			}
		});
		contentPane.add(qTextField);
		qTextField.setColumns(10);
		
		btnGenerateprimebutton = new JButton(Messages.getString("Main.7")); //$NON-NLS-1$
		btnGenerateprimebutton.setBounds(5, 129, 352, 23);
		btnGenerateprimebutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BigInteger p = Prime.generate();
				BigInteger q = Prime.generate();
				pTextField.setText(p == q ? Prime.generate().toString() : p.toString());
				qTextField.setText(q == p ? Prime.generate().toString() : q.toString());
				rsamodule = new RSA(p, q);
				nTextField.setText(rsamodule.getN());
				eTextField.setText(rsamodule.getE());
				phiTextField.setText(rsamodule.getPhi());
			}
		});
		
		phiLabel = new JLabel(Messages.getString("Main.8")); //$NON-NLS-1$
		phiLabel.setBounds(447, 34, 25, 14);
		contentPane.add(phiLabel);
		
		phiTextField = new JTextField();
		phiTextField.setBounds(482, 31, 306, 20);
		contentPane.add(phiTextField);
		phiTextField.setColumns(10);
		contentPane.add(btnGenerateprimebutton);
		
		btnRefreshbutton = new JButton(Messages.getString("Main.9")); //$NON-NLS-1$
		btnRefreshbutton.setBounds(429, 129, 359, 23);
		btnRefreshbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rsamodule = new RSA(new BigInteger(pTextField.getText()), new BigInteger(qTextField.getText()));
				nTextField.setText(rsamodule.getN());
				eTextField.setText(rsamodule.getE());
				phiTextField.setText(rsamodule.getPhi());
			}
		});
		contentPane.add(btnRefreshbutton);
		
		btnEditRsa = new JButton(Messages.getString("Main.10")); //$NON-NLS-1$
		btnEditRsa.setBounds(482, 85, 306, 23);
		btnEditRsa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rsamodule = new RSA(new BigInteger(pTextField.getText()), new BigInteger(qTextField.getText()), new BigInteger(eTextField.getText()));
			}
		});
		contentPane.add(btnEditRsa);
		
		btnEncrypt = new JButton(Messages.getString("Main.11")); //$NON-NLS-1$
		btnEncrypt.setBounds(5, 200, 352, 23);
		btnEncrypt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cipherTextArea.setText(rsamodule.encryptBlock(clearTextArea.getText()));
			}
		});
		contentPane.add(btnEncrypt);
		
		btnDecrypt = new JButton(Messages.getString("Main.12")); //$NON-NLS-1$
		btnDecrypt.setBounds(429, 200, 359, 23);
		btnDecrypt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clearTextArea.setText(rsamodule.decrypt(cipherTextArea.getText()));
			}
		});
		contentPane.add(btnDecrypt);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(429, 229, 359, 255);
		contentPane.add(scrollPane_2);
		
		cipherTextArea = new JTextArea();
		scrollPane_2.setViewportView(cipherTextArea);
		cipherTextArea.setMaximumSize(new Dimension(600, 400));
		cipherTextArea.setLineWrap(true);
		cipherTextArea.setWrapStyleWord(true);
		
		
		scrollPane_1 = new ScrollPane();
		scrollPane_1.setBounds(0, 229, 357, 255);
		contentPane.add(scrollPane_1);
		
		clearTextArea = new JTextArea();
		clearTextArea.setBounds(5, 229, 352, 255);
		clearTextArea.setMaximumSize(new Dimension(600, 400));
		clearTextArea.setLineWrap(true);
		clearTextArea.setWrapStyleWord(true);
		scrollPane_1.add(clearTextArea);
		
		JLabel lblRangePrimzahl = new JLabel(Messages.getString("Main.lblRangePrimzahl.text")); //$NON-NLS-1$
		lblRangePrimzahl.setBounds(15, 163, 83, 14);
		contentPane.add(lblRangePrimzahl);
		
		rangeTextField = new JTextField();
		rangeTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prime.setGlobalRange(rangeTextField.getText());
			}
		});
		rangeTextField.setText(Prime.getGlobalRange()); //$NON-NLS-1$
		rangeTextField.setBounds(108, 163, 249, 20);
		contentPane.add(rangeTextField);
		rangeTextField.setColumns(10);
	}
}
