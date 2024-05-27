package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class MainPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	
    public MainPanel() {
        setTitle("Panel Principal");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initialize();
    }

    private void initialize() {
        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);

        JLabel lblWelcome = new JLabel("Bienvenido al Panel Principal");
        panel.add(lblWelcome);
    }

    public void showPanel() {
        setVisible(true);
    }
}
