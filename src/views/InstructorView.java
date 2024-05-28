package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class InstructorView {
    private JFrame frame;
    private JTable table;

    public InstructorView() {
        frame = new JFrame("Instructores");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);

        JLabel label = new JLabel("Instructores", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label, BorderLayout.NORTH);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton okButton = new JButton("Ok");
        okButton.addActionListener(e -> frame.dispose());
        panel.add(okButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public void displayInstructors(List<List<String>> data) {
        String[] columnNames = {"Nombre", "Apellidos", "Especialidad", "Email"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for (List<String> row : data) {
            tableModel.addRow(row.toArray(new String[0]));
        }

        table.setModel(tableModel);
    }
}
