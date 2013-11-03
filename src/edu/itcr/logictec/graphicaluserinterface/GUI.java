package edu.itcr.logictec.graphicaluserinterface;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;


import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

import edu.itcr.logictec.constants.Constants;
import edu.itcr.logictec.logicaluserinterface.LUI;

import java.awt.Color;
import java.io.IOException;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


/**
 * Creates our GUI 
 * @author zyoruk
 *
 */

public class GUI extends JFrame {

	/**
	 * Different variables that we are going to use
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DrawGate drawGate;
	private LUI createGates;
	private JPanel panel_1;
	private int listIndex;
	private String[] gateStrings;
	private FilteredJList list;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}			
		});
	}

	/**
	 * Creates the frame and all of its components
	 */
	public GUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAccesories = new JMenu("Accesories");
		mnAccesories.setIcon(new ImageIcon(GUI.class.getResource(
														Constants.menuGIF)));
		menuBar.add(mnAccesories);
		
		JButton btnImport = new JButton("Import");
		
		btnImport.setIcon(new ImageIcon(GUI.class.getResource(
													Constants.directoryGIF)));
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Esto tiene que abrir desde un XML");
			}
		});
		
		mnAccesories.add(btnImport);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("Esto tiene que guardar en un XML");
			}
		});
		
		btnSave.setIcon(new ImageIcon(GUI.class.getResource(
														Constants.floppyGIF)));
		mnAccesories.add(btnSave);
		
		JButton btnCreateTable = new JButton("CreateTable");
		btnCreateTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("Tiene que mostrar una ventana con la tabla de"
												+	" verdad de la compuerta");
			}
		});
		
		mnAccesories.add(btnCreateTable);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setIcon(new ImageIcon(GUI.class.getResource(
							Constants.infoGIF)));
		menuBar.add(mnHelp);
		
		
		JButton btnDoc = new JButton("Information");
		btnDoc.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.print("Abre la documentacion");
			}
		});
		mnHelp.add(btnDoc);
		
		JButton btnUndo1 = new JButton("Undo");
		btnUndo1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				drawGate.unDo();
				createGates.undo();
			}
		});
		menuBar.add(btnUndo1);
		
		JButton btnRedo1 = new JButton("Redo");
		btnRedo1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				drawGate.reDo();
				createGates.redo();
			}
		});
		menuBar.add(btnRedo1);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Panel panel = new Panel();
		contentPane.add(panel, BorderLayout.EAST);
		
		GridBagLayout gbl_panel = new GridBagLayout();
		
		gbl_panel.columnWidths = new int[]{129, 0};
		
		gbl_panel.rowHeights = new int[]{19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
							   0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		
		panel.setLayout(gbl_panel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblLogicGates = new JLabel("Compuertas logicas");
		GridBagConstraints gbc_lblLogicGates = new GridBagConstraints();
		gbc_lblLogicGates.fill = GridBagConstraints.BOTH;
		gbc_lblLogicGates.insets = new Insets(0, 0, 5, 0);
		gbc_lblLogicGates.gridx = 0;
		gbc_lblLogicGates.gridy = 0;
		panel.add(lblLogicGates, gbc_lblLogicGates);
		
		JToggleButton btnDrawLine = new JToggleButton("DrawLine");
		btnDrawLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		
		
		btnDrawLine.setHorizontalAlignment(SwingConstants.LEFT);
		
		GridBagConstraints gbc_btnDrawLine = new GridBagConstraints();
		gbc_btnDrawLine.anchor = GridBagConstraints.WEST;
		gbc_btnDrawLine.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDrawLine.insets = new Insets(0, 0, 5, 0);
		gbc_btnDrawLine.gridx = 0;
		gbc_btnDrawLine.gridy = 8;
		
		panel.add(btnDrawLine, gbc_btnDrawLine);
		
		
		JPanel panel2 = new JPanel();
		contentPane.add(panel2, BorderLayout.EAST);
		panel2.setLayout(
			   new MigLayout("", "[70px,grow][]", "[40px][][][][][grow][grow]"));	
		
		gateStrings = new String[]{"AND","NAND","XOR","XNOR","OR","NOR","NOT"};		
		
		list= new FilteredJList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    for (int i=0; i<gateStrings.length; i++)
	        list.addItem (gateStrings[i]);
		list.setVisibleRowCount(7);
	
		panel2.add(list.getFilterField(), "cell 0 0,growx");
		
		
		JScrollPane scrollPane = 
		new JScrollPane(list,
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel2.add(scrollPane, "cell 0 1,growx,aligny center");
		listIndex =list.getSelectedIndex();

		
		JButton btnDraw = new JButton("Draw");
		btnDraw.setHorizontalAlignment(SwingConstants.LEFT);
		
		btnDraw.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				for (int i = 0 ; i < gateStrings.length; i++)
					if (gateStrings[i] == list.getSelectedValue()){
						drawGate = new DrawGate(220,110,100,(String) list.getSelectedValue(),
								   panel_1);
						createGates = new LUI ((String)list.getSelectedValue());
						createGates.createLogicGates();
					try {
						drawGate.paint();
					} catch (IOException pe) {
						pe.printStackTrace();
					}					
				}
			}
		});
		panel2.add(btnDraw, "cell 0 2,growx");
		
		final JToggleButton btnConnectTo = new JToggleButton("Connect to");
		btnConnectTo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConnectTo.setHorizontalAlignment(SwingConstants.LEFT);
		panel2.add(btnConnectTo, "cell 0 3");
		

	}
}
