package com.LocationDesVoitures;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class UpdateCar  extends JPanel implements ActionListener {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private JPanel jp1;
	private JFrame frame;
	private JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, label;
	private JTextField t1, t2, t3, t4, t5;
	private ImageIcon img1;
	private Image image, image2;

	private JButton save, cancel;
	private boolean check = false;
	private int select;
	public UpdateCar(List<String> c, int selectedC) {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(450, 190, 1014, 597);
		frame.setResizable(false);
		frame.getContentPane();
		frame.setLayout(null);
		select = selectedC;
		/////////////////////////
		img1 = new ImageIcon("assets/addClient.png");
		image = img1.getImage();
		image2 = image.getScaledInstance(120, 70, java.awt.Image.SCALE_SMOOTH);
		img1 = new ImageIcon(image2);
		label = new JLabel(img1);
		label.setBounds(450, 65, 130, 70);
		frame.add(label);
		/////////////////////////

		l1 = new JLabel("Add Car");
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Times New Roman", Font.PLAIN, 46));
		l1.setBounds(420, 0, 350, 93);
		////////////////////////////////////////
		jp1 = new JPanel();
		jp1.setBounds(280, 130, 450, 400);
		jp1.setBackground(Color.WHITE);
		jp1.setLayout(null);

		///////////////////////// NOM////////////////////

		l2 = new JLabel("Car Name :");
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		l2.setBounds(15, 25, 161, 26);
		jp1.add(l2);
		t1 = new JTextField();
		t1.setText(c.get(2));

		t1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t1.setBounds(160, 25, 260, 26);
		l4 = new JLabel("");
		t1.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {

				Pattern pattern = Pattern.compile("[^a-z_A-Z_\s_[0-9]]");
				Matcher matcher = pattern.matcher(t1.getText());
				boolean matchFound = matcher.find();
				if (matchFound) {

					l4.setText("Please Enter a Valid Name [a-z] ou [A-Z]");
					l4.setForeground(Color.RED);
					l4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					l4.setBounds(160, 55, 251, 16);
					check = true;

				} else {
					l4.setText("");
					check = false;
				}
			}
		});
		jp1.add(l4);
		jp1.add(t1);
/////////////////////Matricule////////////////////////

		l6 = new JLabel("Matricule :");
		l6.setForeground(Color.BLACK);
		l6.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		l6.setBounds(15, 120, 161, 26);
		jp1.add(l6);
		t3 = new JTextField();
		t3.setText(c.get(0));
		
		t3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t3.setBounds(160, 120, 260, 26);
		l7 = new JLabel("");
		t3.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {

				Pattern pattern = Pattern.compile("[^0-9]");
				Matcher matcher = pattern.matcher(t3.getText());
				boolean matchFound = matcher.find();
				if (matchFound) {

					l7.setText("Please Enter a Valid Number");
					l7.setForeground(Color.RED);
					l7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					l7.setBounds(160, 150, 251, 16);
					check = true;

				} else {
					l7.setText("");
					check = false;
				}
			}
		});
		jp1.add(l7);
		jp1.add(t3);

		///////////////////// Car Category////////////////////////

		l3 = new JLabel("Car Category:");
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		l3.setBounds(15, 75, 161, 26);
		jp1.add(l3);
		t2 = new JTextField();
		t2.setText(c.get(1));
		t2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t2.setBounds(160, 75, 260, 26);
		l5 = new JLabel("");
		t2.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {

				Pattern pattern = Pattern.compile("[^a-z_A-Z_\s]");
				Matcher matcher = pattern.matcher(t2.getText());
				boolean matchFound = matcher.find();
				if (matchFound) {

					l5.setText("Please Enter a Valid Name [a-z] ou [A-Z]");
					l5.setForeground(Color.RED);
					l5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					l5.setBounds(160, 100, 251, 16);
					check = true;
				} else {
					l5.setText("");
					check = false;
				}
			}
		});
		jp1.add(l5);
		jp1.add(t2);
/////////////////////Rent price////////////////////////

		l8 = new JLabel("Rent Per/Day:");
		l8.setForeground(Color.BLACK);
		l8.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		l8.setBounds(15, 170, 161, 26);
		jp1.add(l8);
		t4 = new JTextField();
		t4.setText(c.get(3));
		
		t4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t4.setBounds(160, 170, 260, 26);
		l9 = new JLabel("");
		t4.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {

				Pattern pattern = Pattern.compile("[^0-9]");
				Matcher matcher = pattern.matcher(t4.getText());
				boolean matchFound = matcher.find();
				if (matchFound) {

					l9.setText("Please Enter a Valid Number");
					l9.setForeground(Color.RED);
					l9.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					l9.setBounds(160, 200, 251, 16);
					check = true;

				} else {
					l9.setText("");
					check = false;
				}
			}
		});
		jp1.add(l9);
		jp1.add(t4);
/////////////////////Qte///////////////////////



		save = new JButton("Update");
		save.setFont(new Font("Tahoma", Font.PLAIN, 21));
		save.setBackground(Color.GREEN);
		save.setBounds(80, 230, 135, 23);
		save.addActionListener(this);
		save.setCursor(new Cursor(Cursor.HAND_CURSOR));
//////////////////////////////
		cancel = new JButton("Annuler");
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		cancel.setBackground(Color.RED);
		cancel.setBounds(240, 230, 135, 23);
		cancel.addActionListener(this);
		cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		jp1.add(save);
		jp1.add(cancel);
///////////////////////////
		frame.add(jp1);
		frame.add(l1);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
	

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == cancel) {
			int reply = JOptionPane.showConfirmDialog(null, "Are you Sure, You want to Cancel This ? ", "Warning", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
			frame.setVisible(false);
			Dashboard d = new Dashboard();
			d.setVisible(true);
			
			    JOptionPane.showMessageDialog(null, "Update Car Canceled successfully ");
			}}
			if (e.getSource() == save) {
				if (check == true) {
				    JOptionPane.showMessageDialog(null, "please check invalid inputs ");
				}
				else {
					try {
					Connexion conn1 = new Connexion();
					
					conn1.UpdateCar(String.valueOf(select),Integer.parseInt(t3.getText()),t1.getText(),t2.getText(),Integer.parseInt(t4.getText()));
					
					JOptionPane.showMessageDialog(null, " Car Updated  successfully ");
					frame.setVisible(false);
					Dashboard d = new Dashboard();
					d.setVisible(true);
					}catch (Exception er) {
				// TODO Auto-generated catch block
						 JOptionPane.showMessageDialog(null, "error  "+ er.getMessage());
			}
				}

			}
		}
}
