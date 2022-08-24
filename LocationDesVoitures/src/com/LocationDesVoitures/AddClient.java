package com.LocationDesVoitures;

import javax.swing.*;
import javax.swing.event.*;

import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import net.codejava.swing.DateLabelFormatter;

import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static javax.swing.JOptionPane.showMessageDialog;


import java.awt.event.*;
import java.sql.ResultSet;
public class AddClient extends JPanel implements ActionListener {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JPanel jp1;
	private JFrame frame;
	private JLabel l1, l2, l3, l4, l5,l6,l7,l8,l9,l10,l11,l12,l13,label;
	private JTextField t1, t2, t3, t4,t5;
	private JComboBox cb1,cb2;
	private ImageIcon img1;
	private Image image,image2;
	private List<String> categories = new ArrayList<String>();
	private List<String> names = new ArrayList<String>();
	private List<String> Datet,Datef = new ArrayList<String>();
	private String Item = "bmw";
	private JButton  save,cancel;
	private JDatePickerImpl datePicker1,datePicker;
	private  boolean check = false;
	private static	Date date1;
	private static Date date2;
	private boolean dateA = false;
	private List<Date> DatesNamesF = new ArrayList<Date>();
	private List<Date> DatesNamesT = new ArrayList<Date>();
	private int itera = 0;
	
	public AddClient() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(450, 190, 1014, 597);
		frame.setResizable(false);
		frame.getContentPane();
		frame.setLayout(null);
		/////////////////////////
		img1 = new ImageIcon("assets/addClient.png");
		image = img1.getImage();
		image2 = image.getScaledInstance(120, 70, java.awt.Image.SCALE_SMOOTH);
		img1 = new ImageIcon(image2);
		label = new JLabel(img1);
		label.setBounds(450, 65, 130, 70);
		frame.add(label);
         /////////////////////////

		l1 = new JLabel("Add Client");
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Times New Roman", Font.PLAIN, 46));
		l1.setBounds(420, 0, 350, 93);
		////////////////////////////////////////
		jp1 = new JPanel();
		jp1.setBounds(280, 130, 450, 400);
		jp1.setBackground(Color.WHITE);
		jp1.setLayout(null);
		/////////////////////////NOM////////////////////

		l2 = new JLabel("Nom :");
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		l2.setBounds(15, 25, 161, 26);
		jp1.add(l2);
		t1 = new JTextField();

		t1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t1.setBounds(100, 25, 320, 26);
		l4 = new JLabel("");
		t1.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {

				Pattern pattern = Pattern.compile("[^a-z_A-Z_\s]");
				Matcher matcher = pattern.matcher(t1.getText());
				boolean matchFound = matcher.find();
				if (matchFound) {

					l4.setText("Please Enter a Valid Name [a-z] ou [A-Z]");
					l4.setForeground(Color.RED);
					l4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					l4.setBounds(100, 55, 251, 16);
					check = true;

				} else {
					l4.setText("");
					check = false;
				}
			}
		});
		jp1.add(l4);
		jp1.add(t1);

		/////////////////////PRENOM////////////////////////

		l3 = new JLabel("Prenom:");
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		l3.setBounds(15, 75, 161, 26);
		jp1.add(l3);
		t2 = new JTextField();
		t2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t2.setBounds(100, 75, 320, 26);
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
					l5.setBounds(100, 100, 251, 16);
					check = true;
				} else {
					l5.setText("");
					check = false;
				}
			}
		});
		jp1.add(l5);
		jp1.add(t2);
		/////////////////////CIN////////////////////////

		l6 = new JLabel("CIN :");
		l6.setForeground(Color.BLACK);
		l6.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		l6.setBounds(15, 120, 161, 26);
		jp1.add(l6);
		t3 = new JTextField();

		t3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t3.setBounds(100, 120, 320, 26);
		l7 = new JLabel("");
		t3.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {
  
				Pattern pattern = Pattern.compile("[^0-9]");
				Matcher matcher = pattern.matcher(t3.getText());
				boolean matchFound = matcher.find();
				if ((matchFound) || (t3.getText().length() != 8)) {
					
					l7.setText("Ajoutez un CIN valide");
					l7.setForeground(Color.RED);
					l7.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					l7.setBounds(100, 150, 251, 16);
					check = true;

				} else {
					l7.setText("");
					check = false;
				}
			}
		});
		jp1.add(l7);
		jp1.add(t3);

		///////////////////////Num telephone//////////////////////

		l8 = new JLabel("Phone:");
		l8.setForeground(Color.BLACK);
		l8.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		l8.setBounds(15, 170, 161, 26);
		jp1.add(l8);
		t4 = new JTextField();

		t4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		t4.setBounds(100, 170, 320, 26);
		l9 = new JLabel("");
		t4.addCaretListener(new CaretListener() {

			@Override
			public void caretUpdate(CaretEvent e) {

				Pattern pattern = Pattern.compile("[^0-9]");
				Matcher matcher = pattern.matcher(t4.getText());
				boolean matchFound = matcher.find();
				if ((matchFound) || (t4.getText().length() != 8)) {
					
					l9.setText("Ajouter un numéro valide(+216)");
					l9.setForeground(Color.RED);
					l9.setFont(new Font("Times New Roman", Font.PLAIN, 15));
					l9.setBounds(160, 200, 280, 16);
					check = true;

				} else {
					l9.setText("");
					check = false;
				}
			}
		});
		jp1.add(l9);
		jp1.add(t4);
		///////////////////////cars categories//////////////////////

		l10 = new JLabel("Cars:");
		l10.setForeground(Color.BLACK);
		l10.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		l10.setBounds(15, 220, 161, 26);
		jp1.add(l10);
		cb1 = new JComboBox<>();
		

		cb1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cb1.setBounds(80, 220, 130, 26);
		Connexion conn = new Connexion();
		categories = conn.retriveCat("category");
		for (int counter = 0; counter < categories.size(); counter++) { 
	          cb1.addItem(categories.get(counter)); 		
	      }	
		
		
		
		///////////////////////cars name//////////////////////

		l11 = new JLabel("serie:");
		l11.setForeground(Color.BLACK);
		l11.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		l11.setBounds(215, 220, 161, 26);
		jp1.add(l11);
		cb2 = new JComboBox<>();
		

		cb2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cb2.setBounds(290, 220, 130, 26);
		Connexion conn2 = new Connexion();
		
	     
		cb1.addActionListener(e-> {
			cb2.removeAllItems();
			Item =  cb1.getSelectedItem().toString();	
			names = conn2.retriveName("nameV",Item);
			for (String c : names) {
			cb2.addItem(c);
			}
		      
			
			
			
});//////////////////////////////////////////////////////////
		

		l12 = new JLabel("From:");
		l12.setForeground(Color.BLACK);
		l12.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		l12.setBounds(15, 280, 161, 26);
		jp1.add(l12);
		UtilDateModel model = new UtilDateModel();
		//model.setDate(20,04,2014);
		// Need this...
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		// Don't know about the formatter, but there it is...
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		
		datePicker.setBounds(80,280, 161, 26);
		///////////////////////////////////////////////////////////
		l13 = new JLabel("to:");
		l13.setForeground(Color.BLACK);
		l13.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		l13.setBounds(250, 280, 161, 26);
		jp1.add(l13);
		UtilDateModel model1 = new UtilDateModel();
		//model.setDate(20,04,2014);
		// Need this...
		Properties p1 = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel1 = new JDatePanelImpl(model1, p1);
		// Don't know about the formatter, but there it is...
		 datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());
		
		datePicker1.setBounds(280,280, 161, 26);
			/////////////////////////////
		
		save = new JButton("Add");
		save.setFont(new Font("Tahoma", Font.PLAIN, 21));
		save.setBackground(Color.GREEN);
		save.setBounds(80, 340, 135, 23);
		save.addActionListener(this);
		save.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//////////////////////////////
		cancel = new JButton("Annuler");
		cancel.setFont(new Font("Tahoma", Font.PLAIN, 21));
		cancel.setBackground(Color.RED);
		cancel.setBounds(240, 340, 135, 23);
		cancel.addActionListener(this);
		cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
	
		
		//////////////////////////////
		jp1.add(datePicker);
		jp1.add(datePicker1);
		jp1.add(cb2);
		jp1.add(cb1);
		jp1.add(save);
		jp1.add(cancel);
		
	 
		
		/////////////////////////////////

		
		//////////////////////////////////////////////
		frame.add(jp1);
		frame.add(l1);
		frame.setVisible(true);

	}



	@Override
	public void actionPerformed(ActionEvent e) {
		Connexion conn1 = new Connexion();
		Datef = conn1.retriveDateFCar(cb2.getSelectedItem().toString());
		Datet= conn1.retriveDatetCar(cb2.getSelectedItem().toString()); 
		dateA = false;
		    
		/////////////////////////////////////////////////////////////////////////////
		Date selectedDate = (Date) datePicker.getModel().getValue();
		Date selectedDate2 = (Date) datePicker1.getModel().getValue();
		///////////////////////////////////////////////////////////////////////////
	
		for (int i = 0; i<Datet.size(); i++) {
			
		
			try {
				String sDate2 =Datet.get(i);
				Date  DatesName1 = new SimpleDateFormat("dd MM yyyy").parse(sDate2);
				
				DatesNamesT.add(DatesName1);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		for (Date D : DatesNamesT) {
			if ((D.compareTo(selectedDate) > 0 ) && (D.compareTo(selectedDate2) > 0 )){
				itera++;
			}
			else if ((D.compareTo(selectedDate) < 0 ) && (D.compareTo(selectedDate2) < 0 )){
				itera = 0;
			}
			else 
				dateA = true;
				}
		
			
		////////////////////////////////////////////////////////////
	
		
		for (int i = 0; i<Datef.size(); i++) {
			
		
			try {
				String sDate1 =Datef.get(i);
				Date  DatesName = new SimpleDateFormat("dd MM yyyy").parse(sDate1);
				
				DatesNamesF.add(DatesName);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		for (Date D : DatesNamesF) {
			
			if ((D.compareTo(selectedDate) > 0 ) && (D.compareTo(selectedDate2) > 0 )){
				itera = 0;
			}
			else if ((D.compareTo(selectedDate) < 0 ) && (D.compareTo(selectedDate2) < 0 )){
				itera++;
			}
			else 
				dateA = true;
		}
		if (itera == 2) {
			dateA = true;
		}
		
		if (e.getSource() == cancel) {
			int reply = JOptionPane.showConfirmDialog(null, "Vous etes sur tu veux annuler le processus? ", "Warning", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
			
		

			
			frame.setVisible(false);
			Dashboard d = new Dashboard();
			d.setVisible(true);
			    JOptionPane.showMessageDialog(null, "Ajout de client annulé");
			}}
			if (e.getSource() == save) {
				if (check == true) {
				    JOptionPane.showMessageDialog(null, "S'il vous plait verifier votre données ");
				    return;
				}
				if (dateA == true) {
				    JOptionPane.showMessageDialog(null, "Cette Date est n'est pas disponible pour louer cette voiture ");
				    return;
				}
				
			
				else {
					try {					
					conn1.insertClient(t1.getText(), t2.getText(), Integer.parseInt(t3.getText()), Integer.parseInt(t4.getText()), cb1.getSelectedItem().toString(), cb2.getSelectedItem().toString(),datePicker.getJFormattedTextField().getText(),datePicker1.getJFormattedTextField().getText());
					
					JOptionPane.showMessageDialog(null, "Client ajouté success");
					
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
