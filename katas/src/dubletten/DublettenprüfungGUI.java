package dubletten;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DublettenprüfungGUI extends javax.swing.JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private JTextField outputFileNameField;
    private JLabel outputFileNameLabel;
    private JButton pathChooseButton;
    private JLabel startPath;
    private JButton startButton;
    
	public DublettenprüfungGUI() {
		init();
		setResizable(false);
	}
	
	private void init() {
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,3, 10, 10));
		
        // Button Verzeichnissuche
		pathChooseButton = new JButton("Wähle Pfad");
		pathChooseButton.setPreferredSize(new Dimension(40, 20));
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
		
		// Label ausgewähltes Verzeichnis
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
					System.out.println("Prüfung gestartet. Zieldatei: " + outputFileNameField.getText() + " | " + "Rootpfad: " + startPath.getText());
					ComparisonFileWriter.schreibeDublettenInDatei(outputFileNameField.getText(), startPath.getText());
					System.out.println("Prüfung fertig");
				} catch (IOException e1) {
					System.out.println("Prüfung fehlgeschlagen");
					e1.printStackTrace();
				}
			}
		});
		
		panel.add(startButton);
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dublettenprüfung");
        setSize(300, 200);
        
        add(panel);
        pack();
	}
	
	
	
    public static void main(String args[]) {
    	// C:\Users\jvonalbedyll\eclipse-workspace\program_files.txt
    	
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DublettenprüfungGUI().setVisible(true);
            }
        });
    }

}
