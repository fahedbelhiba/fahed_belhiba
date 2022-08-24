package com.LocationDesVoitures;


import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Login extends JFrame implements  ActionListener{

	private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel displayField,wrongL;
    private JPanel contentPane, wrong;	
    private ImageIcon imagei;
    private Image image,nImage;
	
	private JMenu m1;
	private JMenuItem i;
	
	public Login() {
	
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setBounds(450, 190, 1014, 597);
	        setResizable(false);
	        contentPane = new JPanel();
	        setContentPane(contentPane);
	        contentPane.setLayout(null);
/////////////////////////////////////////////////////////////////////////
	    	imagei = new ImageIcon("assets/logo.png");
	        image = imagei.getImage();
	        nImage = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH);
	        imagei = new ImageIcon(nImage);
	        displayField = new JLabel(imagei);
	        displayField.setBounds(450,100,120,120);
	        contentPane.add(displayField);
	        m1 = new JMenu("hi");
	        i = new JMenuItem("hi");
	        m1.add(i);
	        contentPane.add(m1);
	        
/////////////////////////////////////////////////////////////////////////////////
	        JLabel lblNewLabel = new JLabel("Login");
	        lblNewLabel.setForeground(Color.BLACK);
	        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
	        lblNewLabel.setBounds(450, 13, 173, 93);
	        contentPane.add(lblNewLabel);

	        textField = new JTextField();
	        textField.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        textField.setBounds(430, 250, 161, 26);
	        contentPane.add(textField);
	    

	        passwordField = new JPasswordField();
	        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 12));
	        passwordField.setBounds(430, 286, 161, 26);
	        contentPane.add(passwordField);

	        JLabel lblUsername = new JLabel("Username");
	        lblUsername.setBackground(Color.BLACK);
	        lblUsername.setForeground(Color.BLACK);
	        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 21));
	        lblUsername.setBounds(320, 250, 161, 26);
	        contentPane.add(lblUsername);

	        JLabel lblPassword = new JLabel("Password");
	        lblPassword.setForeground(Color.BLACK);
	        lblPassword.setBackground(Color.CYAN);
	        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 21));
	        lblPassword.setBounds(320, 286, 161, 26);
	        contentPane.add(lblPassword);

	        btnNewButton = new JButton("Login");
	        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 21));
	        btnNewButton.setBounds(430, 342, 162, 26);
	        btnNewButton.setBackground(Color.GREEN);
	        btnNewButton.addActionListener(this);
	        btnNewButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
	        
	        
	        contentPane.add(btnNewButton);
	        setVisible(true);
	        
		}
	
	public static void main(String[] args) {
		new Login();
		
	}
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == btnNewButton) {
	Connexion conn = new Connexion();
	boolean login = conn.connexion(textField.getText(), passwordField.getText());
	
	if (login == true) {
	setVisible(false);
	Dashboard dash = new Dashboard();
	dash.setVisible(true);
}
	else if (login == false) {
		wrong = new JPanel();
		wrongL = new JLabel("Wrong password or Login !");
		wrong.setBounds(430, 224, 165, 30);
		wrongL.setForeground(Color.WHITE);
		wrong.setBackground(Color.RED);
		wrong.add(wrongL);
		contentPane.add(wrong);
		setVisible(true);
		}
	
		
		}
}}

	   
	



