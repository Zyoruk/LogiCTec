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
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;

import edu.itcr.logictec.constants.Constants;

import java.awt.Color;
import java.io.IOException;
import javax.swing.JTextField;




public class Simulator extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textMouseCoords;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Simulator frame = new Simulator();
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
	public Simulator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAccesorios = new JMenu("Accesorios");
		mnAccesorios.setIcon(new ImageIcon(Simulator.class.getResource(
														Constants.menuGIF)));
		menuBar.add(mnAccesorios);
		
		JButton btnAbrir = new JButton("Abrir");
		btnAbrir.setIcon(new ImageIcon(Simulator.class.getResource(
													Constants.directoryGIF)));
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.print("Esto tiene que abrir desde un XML");
			}
		});
		mnAccesorios.add(btnAbrir);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("Esto tiene que guardar en un XML");
			}
		});
		btnGuardar.setIcon(new ImageIcon(Simulator.class.getResource(
														Constants.floppyGIF)));
		mnAccesorios.add(btnGuardar);
		
		JButton btnCrearTablaDe = new JButton("Crear Tabla de Verdad");
		btnCrearTablaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("Tiene que mostrar una ventana con la tabla de"
												+	" verdad de la compuerta");
			}
		});
		mnAccesorios.add(btnCrearTablaDe);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setIcon(new ImageIcon(Simulator.class.getResource(
							Constants.infoGIF)));
		menuBar.add(mnAyuda);
		
		
		JButton btnDocumentacion = new JButton("Documentacion");
		btnDocumentacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("Abre la documentacion");
			}
		});
		mnAyuda.add(btnDocumentacion);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		Panel panel = new Panel();
		contentPane.add(panel, BorderLayout.WEST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{129, 0};
		gbl_panel.rowHeights = new int[]{19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
											0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		final JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblCompuertasLogicas = new JLabel("Compuertas logicas");
		GridBagConstraints gbc_lblCompuertasLogicas = new GridBagConstraints();
		gbc_lblCompuertasLogicas.fill = GridBagConstraints.BOTH;
		gbc_lblCompuertasLogicas.insets = new Insets(0, 0, 5, 0);
		gbc_lblCompuertasLogicas.gridx = 0;
		gbc_lblCompuertasLogicas.gridy = 0;
		panel.add(lblCompuertasLogicas, gbc_lblCompuertasLogicas);
		
		
		JButton btnNewButton_8 = new JButton("AND");
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PintaCompuerta pintaComp = new PintaCompuerta(0,0,100,"AND",
										   panel_1);
				try {
					pintaComp.pintar();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			});

		btnNewButton_8.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnNewButton_8 = new GridBagConstraints();
		gbc_btnNewButton_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_8.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_8.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_8.gridx = 0;
		gbc_btnNewButton_8.gridy = 1;
		panel.add(btnNewButton_8, gbc_btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("NAND");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PintaCompuerta pintaComp = new PintaCompuerta(110,0,100,"NAND",
										   panel_1);
				try {
					pintaComp.pintar();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		btnNewButton_9.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnNewButton_9 = new GridBagConstraints();
		gbc_btnNewButton_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_9.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_9.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_9.gridx = 0;
		gbc_btnNewButton_9.gridy = 2;
		panel.add(btnNewButton_9, gbc_btnNewButton_9);
		
		JButton btnNewButton = new JButton("NOR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PintaCompuerta pintaComp = new PintaCompuerta(220,0,100,"NOR",
										   panel_1);
				try {
					pintaComp.pintar();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 3;
		panel.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_12 = new JButton("NOT");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PintaCompuerta pintaComp = new PintaCompuerta(340,0,100,"NOT",
										   panel_1);
				try {
					pintaComp.pintar();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		btnNewButton_12.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnNewButton_12 = new GridBagConstraints();
		gbc_btnNewButton_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_12.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_12.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_12.gridx = 0;
		gbc_btnNewButton_12.gridy = 4;
		panel.add(btnNewButton_12, gbc_btnNewButton_12);
		
		JButton btnNewButton_13 = new JButton("OR");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PintaCompuerta pintaComp = new PintaCompuerta(0,110,100,"OR",
										   panel_1);
				try {
					pintaComp.pintar();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		
		btnNewButton_13.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnNewButton_13 = new GridBagConstraints();
		gbc_btnNewButton_13.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_13.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_13.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_13.gridx = 0;
		gbc_btnNewButton_13.gridy = 5;
		panel.add(btnNewButton_13, gbc_btnNewButton_13);
		
		JButton btnNewButton_11 = new JButton("XNOR");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PintaCompuerta pintaComp = new PintaCompuerta(110,110,100,"XNOR",
						   				   panel_1);
				try {
					pintaComp.pintar();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		btnNewButton_11.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnNewButton_11 = new GridBagConstraints();
		gbc_btnNewButton_11.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_11.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_11.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_11.gridx = 0;
		gbc_btnNewButton_11.gridy = 6;
		panel.add(btnNewButton_11, gbc_btnNewButton_11);
		
		JButton btnNewButton_10 = new JButton("XOR");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PintaCompuerta pintaComp = new PintaCompuerta(220,110,100,"XOR",
										   panel_1);
				try {
					pintaComp.pintar();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		btnNewButton_10.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnNewButton_10 = new GridBagConstraints();
		gbc_btnNewButton_10.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_10.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_10.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_10.gridx = 0;
		gbc_btnNewButton_10.gridy = 7;
		panel.add(btnNewButton_10, gbc_btnNewButton_10);
		MouseLocation mousecoords = new MouseLocation();
		
		JButton btnLinea = new JButton("Linea");
		btnLinea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DrawLine linedrawer = new DrawLine();
				linedrawer.setColor(Color.RED);
				linedrawer.paint(panel_1.getGraphics());
			}
		});
		btnLinea.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_btnLinea = new GridBagConstraints();
		gbc_btnLinea.anchor = GridBagConstraints.WEST;
		gbc_btnLinea.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLinea.insets = new Insets(0, 0, 5, 0);
		gbc_btnLinea.gridx = 0;
		gbc_btnLinea.gridy = 8;
		panel.add(btnLinea, gbc_btnLinea);
		
		textMouseCoords = new JTextField();
		GridBagConstraints gbc_textMouseCoords = new GridBagConstraints();
		gbc_textMouseCoords.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMouseCoords.gridx = 0;
		gbc_textMouseCoords.gridy = 9;
		textMouseCoords.setText(mousecoords.getMouseLocation());
		panel.add(textMouseCoords, gbc_textMouseCoords);
		textMouseCoords.setColumns(10);
	}
}
