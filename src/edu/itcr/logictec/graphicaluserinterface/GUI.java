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
import edu.itcr.logictec.logicgates.LogicGate;

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

@SuppressWarnings("serial")
public class GUI extends JFrame {

	/**
	 * Different variables that we are going to use
	 */
	
	//variables for graphical part
	private JPanel contentPane;
	private DrawGate drawGate;
	private MyPanel panel_1;
	private FilteredJList list;
	private int J = 0;

	private DrawGate[] gatelist;
	private MyLabel[] labelList = new MyLabel[10];
	private String[] gateStrings;
	private MyLabel[] clickedOnes;
	
	//variables for logical part
	@SuppressWarnings("rawtypes")
	private LogicGate[] logicgatelist;
	private LUI createGates;
	@SuppressWarnings("rawtypes")
	private LogicGate logicgate;

	private static GUI frame;


	/**
	 * Launches the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					frame = new GUI();
					frame.setVisible(true);	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}			
		});
	}

	/**
	 * Creates the frame and all of its components
	 * @throws IOException 
	 */
	public GUI() throws IOException {
		// we are gonna use these objects
		drawGate = new DrawGate();
		logicgatelist = new LogicGate[2]; 
		gatelist = new DrawGate[10];
		clickedOnes = new MyLabel[2];

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setBounds(100, 100, 800, 600);

		// menu at the top of the frame
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		// menu inside the top menu
		JMenu mnAccesories = new JMenu("Accesories");
		mnAccesories.setIcon(new ImageIcon(GUI.class.getResource(
							 Constants.menuGIF)));
		
		menuBar.add(mnAccesories);

		// button that will let us import a component
		JButton btnImport = new JButton("Import");		
		btnImport.setIcon(new ImageIcon(GUI.class.getResource(
						  Constants.directoryGIF)));
		btnImport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Esto tiene que abrir desde un XML");
			}
		});

		mnAccesories.add(btnImport);

		// button  that will let us save our current component
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("Esto tiene que guardar en un XML");
			}
		});

		btnSave.setIcon(new ImageIcon(GUI.class.getResource(
				Constants.floppyGIF)));
		mnAccesories.add(btnSave);

		// menu inside the top menu
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setIcon(new ImageIcon(GUI.class.getResource(
				Constants.infoGIF)));
		menuBar.add(mnHelp);

		// button that will open a document
		JButton btnDoc = new JButton("Information");
		btnDoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("Abre la documentacion");
			}
		});
		mnHelp.add(btnDoc);

		// button that will undo changes
		JButton btnUndo1 = new JButton("Undo");
		btnUndo1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drawGate.unDo();
				createGates.undo();
			}
		});
		menuBar.add(btnUndo1);

		// button that will redo removals		
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

		panel_1 = new MyPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);

		JLabel lblLogicGates = new JLabel("Compuertas logicas");
		
		GridBagConstraints gbc_lblLogicGates = new GridBagConstraints();
		gbc_lblLogicGates.fill = GridBagConstraints.BOTH;
		gbc_lblLogicGates.insets = new Insets(0, 0, 5, 0);
		gbc_lblLogicGates.gridx = 0;
		gbc_lblLogicGates.gridy = 0;
		panel.add(lblLogicGates, gbc_lblLogicGates);

		JPanel panel2 = new JPanel();
		contentPane.add(panel2, BorderLayout.EAST);
		panel2.setLayout(new MigLayout("", "[70px,grow][]", 
				"[40px][][][][][][grow][grow]"));	

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

		JButton btnDraw = new JButton("Draw");
		btnDraw.setHorizontalAlignment(SwingConstants.LEFT);

		btnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0 ; i < gateStrings.length; i++){
					if (gateStrings[i] == list.getSelectedValue()){
						if (J != 10){
							createGate();
							J++;
						}else{
							break;
						}				
					}
				}
			}
		});


		panel2.add(btnDraw, "cell 0 2,growx");

		final JToggleButton btnConnectOIA = new JToggleButton("Connect OIA");
		btnConnectOIA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(gatelist[0] == null){
					btnConnectOIA.setSelected(false);

				}else{
					if (getClickedOnes()[0] != null && getClickedOnes()[1] 
						!= null){
						connectOIA();
						btnConnectOIA.setSelected(false);
					}
				}
			}
		});		
		btnConnectOIA.setHorizontalAlignment(SwingConstants.LEFT);
		panel2.add(btnConnectOIA, "cell 0 3");

		final JToggleButton btnConnectOIB = new JToggleButton("Connect OIB");
		btnConnectOIB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(gatelist[0] == null){
					btnConnectOIB.setSelected(false);
					
				}else{
					if (getClickedOnes()[0] != null && getClickedOnes()[1] 
						!= null){ 						
						connectOIB();
						btnConnectOIB.setSelected(false);
					}
				}
			}
		});	
		btnConnectOIB.setHorizontalAlignment(SwingConstants.LEFT);
		panel2.add(btnConnectOIB, "cell 0 4");
	}

	//Checks the entries of the gates and set the exit.
	@SuppressWarnings("unchecked")
	public void check(){
		for(int i = 0 ;i < gatelist.length; i ++){
			if (gatelist[i] == null){
				break;
			}
			if(gatelist[i].getGateKind()!= "NOT"){
				gatelist[i].setInA(Integer.toString(gatelist[i].getInA()));
				gatelist[i].setInB(Integer.toString(gatelist[i].getInB()));
				logicgate.setInA(gatelist[i].getInA());
				logicgate.setInB(gatelist[i].getInB());
				gatelist[i].setOut(Integer.toString(
						(int)logicgate.getExit()));
			}else{
				gatelist[i].setInA(Integer.toString(gatelist[i].getInA()));
				gatelist[i].setInB(Integer.toString(gatelist[i].getInB()));
				logicgate.setInA(gatelist[i].getInB());
				logicgate.setInB(gatelist[i].getInB());
				gatelist[i].setOut(Integer.toString(
						(int)logicgate.getExit()));
				repaint();
			}
		}
	}

	//Connects logically and graphically two gates Output - InputA
	@SuppressWarnings("unchecked")
	public void connectOIA(){
		panel_1.connectOIA(getClickedOnes(), Color.BLACK);	
		
		createGates =
				new LUI (getClickedOnes()[0].getGatekind());
		
		logicgate = createGates.createLogicGates();
		logicgatelist[0] = logicgate;
		
		createGates =
				new LUI (getClickedOnes()[1].getGatekind());	
		
		logicgate = createGates.createLogicGates();
		logicgatelist[1] = logicgate;
		logicgatelist[0].connectGatesA(logicgatelist[1]);
		clearClickedOnes();
	}

	//Connects logically and graphically two gates Output - InputB
	@SuppressWarnings("unchecked")
	public void connectOIB(){
		panel_1.connectOIB(getClickedOnes(), Color.BLACK);
		createGates =
				new LUI (getClickedOnes()[0].getGatekind());
		
		logicgate = createGates.createLogicGates();
		logicgatelist[0] = logicgate;

		createGates =
				new LUI (getClickedOnes()[1].getGatekind());
		logicgate = createGates.createLogicGates();
		logicgatelist[1] = logicgate;

		logicgatelist[0].connectGatesB(logicgatelist[1]);
		clearClickedOnes();
	}

	// Sets the  two last clicked gates
	public void setClickedOne(MyLabel label){	

		if(clickedOnes[0] == null){
			clickedOnes[0] = label;	
			System.out.println(true);
		}else if (clickedOnes[1] == null && clickedOnes[0] != null){
			clickedOnes[1] = label;			
		}else{
			clickedOnes[0].setIfClicked(false);
			clickedOnes[0] = clickedOnes[1];
			clickedOnes[1] = label;
		}

	}	

	//Gets the two last clicked gates as a list.
	public MyLabel[] getClickedOnes(){
		return this.clickedOnes;
	}

	//Clears the list of clicked gates.
	public void clearClickedOnes(){
		clickedOnes[0] = null;
		clickedOnes[1] = null;
	}
	
	//creates the gate logically and graphically
	public void createGate(){
		drawGate = new DrawGate(220,110,100,
				(String) list.getSelectedValue(),panel_1, 
				labelList,frame);	
		gatelist[J] = drawGate ;

		createGates =
				new LUI ((String)list.getSelectedValue());

		logicgate = createGates.createLogicGates();

		try {
			drawGate.paint();
			check();
		} catch (IOException pe) {
			pe.printStackTrace();
		}	
	}

}
