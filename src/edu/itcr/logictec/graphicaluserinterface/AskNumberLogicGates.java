package edu.itcr.logictec.graphicaluserinterface;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JTextPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JInternalFrame;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JDesktopPane;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import java.awt.TextField;
import javax.swing.JButton;

public class AskNumberLogicGates extends JDialog {
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AskNumberLogicGates dialog = new AskNumberLogicGates();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public AskNumberLogicGates() {
		setResizable(false);
		setTitle("LogiCTec - Asking number of logic gates");
		setBounds(100, 100, 450, 300);
		
		JTextPane txtpnEnterNumber = new JTextPane();
		txtpnEnterNumber.setForeground(Color.BLACK);
		txtpnEnterNumber.setBackground(UIManager.getColor("Button.background"));
		txtpnEnterNumber.setEditable(false);
		txtpnEnterNumber.setText("Greetings user.\nPlease, enter the number of gates you are going to use :");
		getContentPane().add(txtpnEnterNumber, BorderLayout.NORTH);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(UIManager.getColor("Button.background"));
		getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		TextField textNumbers = new TextField();
		textNumbers.setBounds(200, 33, 96, 19);
		desktopPane.add(textNumbers);
		
		JLabel lblNumberOfGates = new JLabel("Number of gates:");
		lblNumberOfGates.setBounds(61, -72, 123, 232);
		desktopPane.add(lblNumberOfGates);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(UIManager.getColor("Button.disabledToolBarBorderBackground"));
		btnCancel.setBounds(102, 195, 117, 25);
		desktopPane.add(btnCancel);
		
		JButton btnOK = new JButton("OK");
		btnOK.setBackground(UIManager.getColor("Button.disabledText"));
		btnOK.setBounds(231, 195, 117, 25);
		desktopPane.add(btnOK);

	}
}
