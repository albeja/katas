package dubletten;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Dublettenpr�fungGUI extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JTextField outputFileNameField;
    private JLabel outputFileNameLabel;
    private JButton pathChooseButton;
    private JLabel startPath;
    private JButton startButton;
    
	public Dublettenpr�fungGUI() {
		init();
	}
	
	private void init() {
		JPanel panel = new JPanel();
		
        // Button Verzeichnissuche
		pathChooseButton = new JButton("W�hle Pfad");
		pathChooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int rueckgabeWert = chooser.showOpenDialog(null);
				
				if(rueckgabeWert == JFileChooser.APPROVE_OPTION) {
					startPath.setText(chooser.getSelectedFile().getPath());
				}
				
			}
		});
		panel.add(pathChooseButton);
		
		// Label ausgew�hltes Verzeichnis
		startPath = new JLabel("Zu durchsuchender Pfad");
		panel.add(startPath);
		
		// Label Ergebnisfile
		outputFileNameLabel = new JLabel("Ergebnis speichern in: ");
		panel.add(outputFileNameLabel);
		
		// Formfield Ergebnisfile
		outputFileNameField = new JTextField("Absoluter Dateipfad", 20);
		panel.add(outputFileNameField);
		
        // Startbutton
		startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					System.out.println("Pr�fung gestartet. Zieldatei: " + outputFileNameField.getText() + " | " + "Rootpfad: " + startPath.getText());
					ComparisonFileWriter.schreibeDublettenInDatei(outputFileNameField.getText(), startPath.getText());
					System.out.println("Pr�fung fertig");
				} catch (IOException e1) {
					System.out.println("Pr�fung fehlgeschlagen");
					e1.printStackTrace();
				}
			}
		});
		
		panel.add(startButton);
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dublettenpr�fung");
        setSize(400, 400);
        
        add(panel);
	}
	
	
	
    public static void main(String args[]) {
    	// C:\Users\jvonalbedyll\eclipse-workspace\program_files.txt
    	
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dublettenpr�fungGUI().setVisible(true);
            }
        });
    }

}
