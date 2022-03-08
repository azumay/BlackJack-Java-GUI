package E07;

import javax.swing.JOptionPane;
import java.awt.EventQueue;

import E07.GUI.GameGUI;

public class Main {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					GameGUI window = new GameGUI();
					window.getFrame().setVisible(true);
					
				} catch (Exception e) {
					
					e.printStackTrace();
					
				}
			}
		});
	}
}
