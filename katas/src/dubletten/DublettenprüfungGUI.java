package dubletten;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Dublettenpr�fungGUI extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
    private JTextField outputFileNameField = new JTextField("Absoluter Dateipfad", 20);
    private JLabel startPath = new JLabel("Zu durchsuchender Pfad");
    private GridBagConstraints constraints = new GridBagConstraints();
    
	public Dublettenpr�fungGUI() {
		init();
	}
	
	private void init() {
		add(createPanel());
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dublettenpr�fung");
        setMinimumSize(new Dimension(600,150));
		setResizable(false);
        pack();
	}

	private JPanel createPanel() {
		JPanel panel = new JPanel();
		setPanelLayout(panel);
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		panel.add(createPathChooseButton(), constraints);
		constraints.gridx = 1;
		panel.add(startPath, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		panel.add(new JLabel("Ergebnis speichern in: "), constraints);
		constraints.gridx = 1;
		panel.add(outputFileNameField, constraints);
		
		constraints.gridwidth = 2;
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.fill = GridBagConstraints.NONE;
		panel.add(createStartButton(), constraints);
		return panel;
	}

	private JButton createStartButton() {
		JButton startButton = new JButton("Start");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ComparisonFileWriter.schreibeDublettenInDatei(outputFileNameField.getText(), startPath.getText());
				} catch (IOException e1) {
					System.out.println("Pr�fung fehlgeschlagen");
					e1.printStackTrace();
				}
			}
		});
		return startButton;
	}

	private JButton createPathChooseButton() {
		JButton pathChooseButton = new JButton("W�hle Root-Pfad");
		pathChooseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { handleFileChoosing(); }
		});
		return pathChooseButton;
	}

	private void handleFileChoosing() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int rueckgabeWert = chooser.showOpenDialog(null);
		
		if(rueckgabeWert == JFileChooser.APPROVE_OPTION) {
			startPath.setText(chooser.getSelectedFile().getPath());
		}
	}
	
	private void setPanelLayout(JPanel panel) {
		panel.setLayout(new GridBagLayout());
		constraints.insets = new Insets(5,5,5,5);
		constraints.fill = GridBagConstraints.HORIZONTAL;
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
