package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import controllers.AuthController;
import models.AuthModel;
import models.RegisterModel;

public class AuthView {
    
    private JFrame frame;
    private AuthModel functions; 
    private RegisterModel functions1; 
    private AuthController controller;
    
    public AuthView() {
        frame = new JFrame();
        frame.setVisible(false);
        frame.setSize(550, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Autenticación");
        frame.setLocationRelativeTo(null);
        functions = new AuthModel();
        functions1 = new RegisterModel();
    }
    
    private void prepareFrame() {
        frame.getContentPane().removeAll();
        frame.repaint();
        frame.revalidate();
    }

    public void register() {
        prepareFrame();
        frame.setVisible(true);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 248, 255));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblTitle = new JLabel("Crear una cuenta");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setBounds(100, 30, 300, 50);
        panel.add(lblTitle);

        JTextField emailField = new JTextField();
        emailField.setBounds(100, 100, 300, 40);
        panel.add(emailField);
        emailField.setColumns(10);

        JLabel lblEmail = new JLabel("Correo electrónico");
        lblEmail.setForeground(Color.BLACK);
        lblEmail.setBounds(100, 80, 300, 20);
        panel.add(lblEmail);

        JTextField passwordField = new JTextField();
        passwordField.setBounds(100, 180, 300, 40);
        panel.add(passwordField);
        passwordField.setColumns(10);

        JLabel lblPassword = new JLabel("Contraseña");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBounds(100, 160, 300, 20);
        panel.add(lblPassword);

        JButton btnRegister = new JButton("Registrarse");
        btnRegister.setFont(new Font("Arial", Font.BOLD, 18));
        btnRegister.setBackground(new Color(100, 149, 237));
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setBounds(100, 250, 300, 40);
        panel.add(btnRegister);
        
        JButton btnToMainPanel = new JButton("Regresar");
        btnToMainPanel.setFont(new Font("Arial", Font.PLAIN, 12));
        btnToMainPanel.setBounds(20, 400, 95, 35);
        btnToMainPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); 
                controller = new AuthController(); 
                controller.mainPanel();  
            }
        });
        panel.add(btnToMainPanel);
        
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                functions1.register(emailField.getText(), passwordField.getText());
                frame.dispose(); 
                controller = new AuthController(); 
                controller.mainPanel();  
            }
        });
    }
    
    public void login() {
        prepareFrame();
        frame.setVisible(true);
        
        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 248, 255));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblTitle = new JLabel("Iniciar sesión");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setBounds(100, 30, 300, 50);
        panel.add(lblTitle);

        JTextField usernameField = new JTextField();
        usernameField.setBounds(100, 100, 300, 40);
        panel.add(usernameField);
        usernameField.setColumns(10);

        JLabel lblUsername = new JLabel("Usuario");
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setBounds(100, 80, 300, 20);
        panel.add(lblUsername);

        JTextField passwordField = new JTextField();
        passwordField.setBounds(100, 180, 300, 40);
        panel.add(passwordField);
        passwordField.setColumns(10);

        JLabel lblPassword = new JLabel("Contraseña");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBounds(100, 160, 300, 20);
        panel.add(lblPassword);

        JButton btnLogin = new JButton("Acceder");
        btnLogin.setFont(new Font("Arial", Font.BOLD, 18));
        btnLogin.setBackground(new Color(100, 149, 237));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setBounds(100, 250, 300, 40);
        panel.add(btnLogin);
        
        JButton btnToMainPanel = new JButton("Regresar");
        btnToMainPanel.setFont(new Font("Arial", Font.PLAIN, 12));
        btnToMainPanel.setBounds(20, 400, 95, 35);
        btnToMainPanel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); 
                controller = new AuthController(); 
                controller.mainPanel(); 
            }
        });
        panel.add(btnToMainPanel);
    
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                functions.login(usernameField.getText(), passwordField.getText());
            }
        });

        JButton btnToRegister = new JButton("Crear cuenta");
        btnToRegister.setFont(new Font("Arial", Font.PLAIN, 14));
        btnToRegister.setBounds(100, 300, 300, 30);
        btnToRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                controller = new AuthController();
                controller.registro();
            }
        });
        panel.add(btnToRegister);
    }
}
