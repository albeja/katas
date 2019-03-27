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
    private JTextField outputFileNameField = new JTextField("Absoluter Dateipfad", 20);
    private JLabel startPath = new JLabel("Zu durchsuchender Pfad");
    
	public DublettenprüfungGUI() {
		init();
		setResizable(false);
	}
	
	private void init() {
		add(createPanel());
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dublettenprüfung");
        setSize(300, 200);
        pack();
	}

	private JPanel createPanel() {
		JPanel panel = new JPanel();
		setPanelLayout(panel);
		
		panel.add(createPathChooseButton());
		panel.add(startPath);
		
		panel.add(new JLabel("Ergebnis speichern in: "));
		panel.add(outputFileNameField);
		
		panel.add(createStartButton());
		return panel;
	}

	private JButton createStartButton() {
		JButton startButton = new JButton("Start");
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
		return startButton;
	}

	private JButton createPathChooseButton() {
		JButton pathChooseButton = new JButton("Wähle Pfad");
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
		return pathChooseButton;
	}

	private void setPanelLayout(JPanel panel) {
		panel.setLayout(new GridLayout(3,3, 10, 10));
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
