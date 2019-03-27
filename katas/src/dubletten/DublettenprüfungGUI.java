package dubletten;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DublettenprüfungGUI extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private javax.swing.JTextField outputFileNameField;
    private javax.swing.JButton startButton;
    private javax.swing.JLabel outputFileNameLabel;

	public DublettenprüfungGUI() {
		init();
	}
	
	private void init() {
		JPanel panel = new JPanel();
		
		outputFileNameLabel = new JLabel("Ergebnis speichern in: ");
//		outputFileNameLabel.setHorizontalAlignment(JLabel.LEFT);
//		outputFileNameLabel.setVerticalAlignment(JLabel.TOP);
		panel.add(outputFileNameLabel);
		
		outputFileNameField = new JTextField("Absoluter Dateipfad", 20);
		panel.add(outputFileNameField);
		
		startButton = new JButton("Start");
		panel.add(startButton);
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dublettenprüfung");
        setSize(400, 400);
        
        add(panel);
	}
	
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DublettenprüfungGUI().setVisible(true);
            }
        });
    }

}
