package E07.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.GridBagConstraints;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import E07.error.ReportErrores;

import java.awt.event.ActionEvent;

public class GameGUI {

	private JFrame frame;
	
	private JDialog dialogNJ;
	
	private int numJugadores;
	
	private JPanel Jugador1;

	/**
	 * Constructor del juego
	 */
	public GameGUI() {
		interfazJuego();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void interfazJuego() {
		this.frame = new JFrame();
		this.frame.setSize(1500, 800);
		this.frame.setTitle("Juego Black Jack");
		this.frame.getContentPane().setBackground(new Color(24, 74, 65));
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Generar el menu
		JMenuBar barra = new JMenuBar();
		JMenu programa = new JMenu("Menu");
		JMenuItem acerca = new JMenuItem("Acerca de...");
		JMenuItem salir = new JMenuItem("Salir");
		

		this.frame.setJMenuBar(barra);
		barra.add(programa);
		programa.add(acerca);
		programa.add(salir);
		programa.addSeparator();
		programa.setMnemonic('P');
		
		/*POSICIONAMIENTO AUTO DE LA VENTANA DEL JUEGO*/
		
		Dimension sizeH, sizeW;

		sizeH = Toolkit.getDefaultToolkit().getScreenSize();
		sizeW = this.frame.getSize();
		
		this.frame.setLocation(((sizeH.width - sizeW.width) / 2), (sizeH.height - sizeW.height) / 2);
				
		
		/*ACIONES DEL MENU*/
		
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		acerca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Juego BlackJack creado por Xavi Yamuza", "Acerca de...",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		
		this.dialogNJ = new JDialog(this.frame);
		dialogNJ.setSize(300, 100);
		dialogNJ.getContentPane().setLayout(new GridLayout(3, 0, 10, 10));
		JLabel pregunta = new JLabel("Indica el número de jugadores");
		dialogNJ.getContentPane().add(pregunta);
		
		JTextField textArea = new JTextField();
		dialogNJ.getContentPane().add(textArea);
		dialogNJ.setLocation(((sizeH.width - sizeW.width) / 2), (sizeH.height - sizeW.height) / 2);
		dialogNJ.setVisible(true);
		JButton btn_addPlayers = new JButton("Empezar");
		dialogNJ.getContentPane().add(btn_addPlayers);
		
		btn_addPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					setNumJugadores(textArea.getText());
				} catch (ReportErrores mensaje) {
					JOptionPane.showMessageDialog(null, mensaje, "Exception detected", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		
		/*POSICIONAMIENTO AUTO DE LA VENTANA dialogNJ*/
		
		Dimension heightNJ, widthNJ;

		heightNJ = Toolkit.getDefaultToolkit().getScreenSize();
		widthNJ = this.dialogNJ.getSize();
		
		this.dialogNJ.setLocation(((heightNJ.width - widthNJ.width) / 2), (heightNJ.height - widthNJ.height) / 2);
		
		
	}
	
	private void loadGame () throws ReportErrores{
		
		this.dialogNJ.dispose();
		
		this.frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		JPanel panelCentral = new JPanel();
		this.frame.getContentPane().add(panelCentral, BorderLayout.CENTER);
		panelCentral.setBackground(new Color(255, 99, 71));
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("/E07/media/logo-juego.png"));
		panelCentral.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		panelCentral.add(lblNewLabel, gbc);
		
		
		// Panel inferior para los jugadores
			JPanel panelBot = new JPanel();
			panelBot.setBackground(new Color(40, 196, 125));
			this.frame.getContentPane().add(panelBot, BorderLayout.SOUTH);
		
			this.Jugador1 = new JPanel();
			FlowLayout flowLayout = (FlowLayout) this.Jugador1.getLayout();
			flowLayout.setVgap(0);
			flowLayout.setHgap(0);
			panelBot.add(this.Jugador1);
			Jugador1.setBackground(new Color(40, 196, 125));	
			
	}

	
	/*GETTERS & SETTERS*/
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	
	public int getNumJugadores() {
		return numJugadores;
	}


	private void setNumJugadores(String numJugadores) throws ReportErrores {
		try {
			int intJugadores = Integer.parseInt(numJugadores);
			if (intJugadores <= 4 && intJugadores > 0) {
				this.numJugadores = intJugadores + 1; // Añadir al croupier
				// Una vez definidos los usuarios seguimos con el programa con el metodo cargar
				// juego
				loadGame();
			} else {
				new ReportErrores("Numero de jugadores fuera de rango");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Exception detected", JOptionPane.WARNING_MESSAGE);
		}
	}

}
