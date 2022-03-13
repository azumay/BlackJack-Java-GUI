package E07;

import javax.swing.JOptionPane;
import java.awt.EventQueue;

import E07.GUI.GameGUI;
import E07.error.ReportErrores;

public class Main {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					GameGUI window = new GameGUI();
					window.getFrame().setVisible(true);
					
				} catch (ReportErrores e) {
					JOptionPane.showMessageDialog(null, e.toString(), "MyException detected", JOptionPane.WARNING_MESSAGE);
				}
				catch (Exception e) {
					
					e.printStackTrace();
					
				}
			}
		});
	}
}
