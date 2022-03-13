package E07.GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
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
import E07.model.Baraja;
import E07.model.Carta;
import E07.model.Jugador;

import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Label;
import java.awt.SystemColor;

public class GameGUI extends JFrame{

	private JFrame frame;
	
	private JDialog dialogNJ;
	
	private JPanel panel_top;
	
	private JPanel panel_grupier;
	
	private int numJugadores;
	
	private JPanel Jugador1;
	
	private ArrayList<Jugador> jugadores;
	
	private Baraja baraja;
	
	private JPanel panel_jugador1;
	private JPanel panel_jugador2;
	private JPanel panel_jugador3;
	private JPanel panel_jugador4;
	private JPanel panel_jugador5;
	
	private JPanel panel_bottom;
	
	private Jugador grupier;
	
	private CartaGUI cartaGUI;
	

	/**
	 * Constructor del juego
	 * @throws IOException 
	 */
	public GameGUI() throws ReportErrores, IOException{
		this.baraja = new Baraja();
		this.grupier = new Jugador(this.baraja, "Grupier");
		
		this.jugadores = new ArrayList<Jugador>();
		this.cartaGUI = new CartaGUI(100);
		cartaGUI.setBounds(-5, 5, 101, 75);
		interfazJuego();
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void interfazJuego() throws ReportErrores{
		this.frame = new JFrame();
		this.frame.setSize(1350, 800);
		this.frame.setTitle("Juego Black Jack");
		this.frame.getContentPane().setBackground(new Color(24, 74, 65));
		frame.getContentPane().setLayout(new GridLayout(3, 1, 0, 0));
		
		
		/* PANEL SUPERIOR TABLERO */
		
		panel_top = new JPanel();
		panel_top.setBorder(null);
		frame.getContentPane().add(panel_top);
		panel_top.setBackground(new Color(24, 74, 65));
		panel_top.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_top.add(panel_1);
		
		JLabel lblImagenFichas = new JLabel();
		Image imgFichas= new ImageIcon("src/E07/media/fichas.png").getImage();
		ImageIcon img_Fichas=new ImageIcon(imgFichas.getScaledInstance(150, 54, Image.SCALE_SMOOTH));
		
		lblImagenFichas.setIcon(img_Fichas);
		panel_1.add(lblImagenFichas);
		
		panel_1.setBackground(new Color(24, 74, 65));
		
		
		
		
		this.panel_grupier = new JPanel();
		this.panel_grupier.setBorder(null);
		this.panel_grupier.setBackground(new Color(24, 74, 65));
		panel_top.add(this.panel_grupier);
		
	
		JPanel panel_top_3 = new JPanel();
		panel_top_3.setBorder(null);
		panel_top_3.setBackground(new Color(24, 74, 65));
		panel_top.add(panel_top_3);
		
		JLabel lblImagenCartas = new JLabel();
		Image imgCartas= new ImageIcon("src/E07/media/pila-Cartas.png").getImage();
		ImageIcon img_Cartas=new ImageIcon(imgCartas.getScaledInstance(150, 154, Image.SCALE_SMOOTH));
		
		lblImagenCartas.setIcon(img_Cartas);
		panel_top_3.add(lblImagenCartas);
		
		
		/* MITAD DEL TABLERO */
		
		JPanel panel_mid = new JPanel();
		panel_mid.setBorder(null);
		panel_mid.setBackground(new Color(24, 74, 65));
		frame.getContentPane().add(panel_mid);
		panel_mid.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_2_mid = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2_mid.getLayout();
		flowLayout.setHgap(2);
		flowLayout.setVgap(2);
		panel_2_mid.setBackground(new Color(24, 74, 65));
		panel_mid.add(panel_2_mid);
		
		JPanel panel_2_logo = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2_logo.getLayout();
		flowLayout_1.setVgap(15);
		flowLayout_1.setHgap(15);
		panel_2_logo.setBackground(new Color(24, 74, 65));
		panel_mid.add(panel_2_logo);
		
		JLabel lblImagenCentro = new JLabel();
		Image img= new ImageIcon("src/E07/media/mesa-black-jack.png").getImage();
		ImageIcon img2=new ImageIcon(img.getScaledInstance(450, 124, Image.SCALE_SMOOTH));
		
		lblImagenCentro.setIcon(img2);
		panel_2_logo.add(lblImagenCentro);
		
		JPanel panel_3_mid = new JPanel();
		panel_3_mid.setBackground(new Color(24, 74, 65));
		panel_mid.add(panel_3_mid);
		
		 this.panel_bottom = new JPanel();
		panel_bottom.setBorder(null);
		panel_bottom.setBackground(new Color(24, 74, 65));
		frame.getContentPane().add(panel_bottom);
		panel_bottom.setLayout(new GridLayout(0, 5, 0, 0));
		
		panel_jugador1 = new JPanel();
		panel_jugador1.setBackground(new Color(24, 74, 65));
		panel_jugador1.setBorder(null);
		panel_bottom.add(panel_jugador1);
		
		panel_jugador2 = new JPanel();
		panel_jugador2.setBorder(null);
		panel_jugador2.setBackground(new Color(24, 74, 65));
		panel_bottom.add(panel_jugador2);
		
		panel_jugador3 = new JPanel();
		panel_jugador3.setBorder(null);
		panel_jugador3.setBackground(new Color(24, 74, 65));
		panel_bottom.add(panel_jugador3);
		
		panel_jugador4 = new JPanel();
		panel_jugador4.setBorder(null);
		panel_jugador4.setBackground(new Color(24, 74, 65));
		panel_bottom.add(panel_jugador4);
		
		panel_jugador5 = new JPanel();
		panel_jugador5.setBorder(null);
		panel_jugador5.setBackground(new Color(24, 74, 65));
		panel_bottom.add(panel_jugador5);
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
		
		btn_addPlayers.addActionListener(new ActionListener(){
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
			
			
			JPanel panelLeft = new JPanel();
			panelLeft.setBackground(new Color(11, 43, 32));
			frame.getContentPane().add(panelLeft, BorderLayout.WEST);
			panelLeft.setLayout(new GridBagLayout());
			
			muestraCartas();
			
	}
	
	private void muestraCartas() {
		int x = 40;
		int y = 40;
		int posPlayer = 1;
	
		JPanel crupier = (JPanel) this.panel_top.getComponent(2-1);
	
		JLabel crupierName = new JLabel("Grupier");
		crupierName.setForeground(Color.WHITE);
		crupierName.setBounds(80, 0, 225, 20);
		crupier.add(crupierName);
		
		for (Carta crupierCarta : grupier.getCartas()) {
			Image cardImage = this.cartaGUI.getImatge(crupierCarta);
			ImageIcon icon = new ImageIcon(cardImage);

			JLabel crupierZone = new JLabel("");
			crupierZone.setSize(225, 315);
			crupierZone.setBounds(x, y, 225, 315);
			crupierZone.setIcon(icon);

			crupier.add(crupierZone);
			x += 30;
			y += 30;
		}
		
				for (Jugador jugador : this.jugadores) {
					x = 40;
					y = 40;
					// Creamos y mostramos las cartas de los jugadores
					for (Carta item : jugador.getCartas()) {
						// Generamos cada imagen y la asignamos a un icono
						Image cardImage = this.cartaGUI.getImatge(item);
						ImageIcon icon = new ImageIcon(cardImage);

						// Creamos la posicion donde ire la iamgen de la carta y la colocamos en su
						// lugar
						JLabel playerCard = new JLabel("");
						playerCard.setSize(225, 315);
						playerCard.setBounds(x, y, 225, 315);
						playerCard.setIcon(icon);

						switch (posPlayer) {
						case 1:
							this.panel_jugador1.add(playerCard);
							break;
						case 2:
							this.panel_jugador2.add(playerCard);
							break;
						case 3:
							this.panel_jugador3.add(playerCard);
							break;
						case 4:
							this.panel_jugador4.add(playerCard);
							break;
						case 5:
							this.panel_jugador5.add(playerCard);
							break;
						}

						// Incrementamos las posiciones para ir colocando las cartas solapadas
						x += 30;
						y += 30;
					}
					// Reiniciamos las variables para las siguientes 2 cartas
					x = 40;
					y = 40;
					posPlayer += 1;
					// player.getCards().stream().forEach(item->this.cardGUI.getImatge(item));
				}
				posPlayer = 0;
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
			if (intJugadores < 2) {
				 new ReportErrores("No pueden ser menos de 2 jugadores.");
			}
			else if (intJugadores > 5) {
				new ReportErrores("No pueden ser más de 5 jugadores.");
			}
			
			else {
				
				this.numJugadores = intJugadores ;
			
				for (int i = 1; i <= intJugadores; i++) {
					
					//Capturamos el nombre del jugador
					String namePlayer = JOptionPane.showInputDialog("Indica el nombre del jugador Nº" + i );
					
					//Lo agregamos al Arraylist de Jugadores con su baraja inicial
					Jugador jugador = new Jugador(this.baraja, namePlayer);
					this.jugadores.add(jugador);
					
					// Agregamos el nombre del jugador al tablero
					JLabel playerName = new JLabel(jugador.getNombre());
					playerName.setForeground(Color.YELLOW);
					playerName.setBounds(80, 0, 225, 20);
					JPanel panelAux = (JPanel) panel_bottom.getComponent(i - 1);
					
					panelAux.add(playerName);
				}
				
				loadGame();
			} 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e, "Exception detected", JOptionPane.WARNING_MESSAGE);
		}
	}

}
