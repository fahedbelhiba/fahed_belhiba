package com.LocationDesVoitures;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.ProcessHandle.Info;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class JtableDash extends JPanel implements ActionListener {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	private ModeleD modele = new ModeleD();
	private JTable tableau;
	private JFrame frame;
	private JScrollPane tab;
	private JPanel p1;
	private JLabel jl5, label;
	private ImageIcon img1;
	private Image image, image2;
	public static final Color DARK_BLUE = new Color(205 - 0 - 0);
	private JButton b1, b2,b3,b4,b5,b6,b7;
	List<String> rclients ;
	ArrayList<Integer> select;

	public JtableDash() {
		super();
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(450, 190, 1014, 597);
		frame.setResizable(false);
		frame.getContentPane();
		frame.setLayout(null);
		
		frame.setTitle("Manage Clients");

		tableau = new JTable(modele);
		tab = new JScrollPane(tableau);
		tab.setBounds(280, 80, 700, 400);

		
		/////////////// Columns Width 
		
		
		
/////////////////Delete Client Button////////////////

b6 = new JButton("Delete Client");
b6.setFocusPainted(false);
b6.setForeground(Color.WHITE);
b6.setBorder(null);
b6.setFont(new Font("Arial", Font.PLAIN, 15));
b6.setBackground(Color.RED);
b6.setBounds(670, 490, 100, 35);
b6.setCursor(new Cursor(Cursor.HAND_CURSOR));
b6.addActionListener(this);
frame.add(b6);
frame.add(tab);
////////////////////////////////////////////////
		//////////////////////
		tableau.getColumnModel().getColumn(0).setPreferredWidth(27);
		tableau.getColumnModel().getColumn(1).setPreferredWidth(120);
		tableau.getColumnModel().getColumn(2).setPreferredWidth(100);
		tableau.getColumnModel().getColumn(3).setPreferredWidth(100);
		tableau.getColumnModel().getColumn(4).setPreferredWidth(100);
		tableau.getColumnModel().getColumn(5).setPreferredWidth(100);
		tableau.getColumnModel().getColumn(6).setPreferredWidth(100);
		tableau.getColumnModel().getColumn(7).setPreferredWidth(125);
		tableau.getColumnModel().getColumn(8).setPreferredWidth(100);
	

		///////////////  Row Height //////////////////////
		tableau.setRowHeight(30);
	
/////////////////////////
		
		//////////////////////////
		p1 = new JPanel();
		p1.setBounds(0, 150, 250, 9126);
		p1.setBackground(Color.BLACK);
////////////////////////////////////////
		jl5 = new JLabel("Manage Clients");
		jl5.setForeground(Color.BLACK);
		jl5.setFont(new Font("Times New Roman", Font.PLAIN, 46));
		jl5.setBounds(473, 3, 350, 93);

////////////////////////////////////
		b4 = new JButton("DashBoard");
		b4.setFocusPainted(false);
		b4.setForeground(Color.WHITE);
		b4.setBorder(null);
		b4.setFont(new Font("Arial", Font.PLAIN, 25));
		b4.setBackground(Color.BLACK);
		b4.setBounds(0, 85, 250, 70);
		b4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b4.addActionListener(this);
		b4.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				b4.setBackground(DARK_BLUE);
			}

			public void mouseExited(MouseEvent evt) {
				b4.setBackground(Color.BLACK);
			}

		});
//////////////////Add Client Button////////////////
b5 = new JButton("Add Client");
b5.setFocusPainted(false);
b5.setForeground(Color.WHITE);
b5.setBorder(null);
b5.setFont(new Font("Arial", Font.PLAIN, 15));
b5.setBackground(Color.BLUE);
b5.setBounds(840, 35, 90, 35);
b5.setCursor(new Cursor(Cursor.HAND_CURSOR));
b5.addActionListener(this);

////////////////////////////////////////////////
//////////////////Update Client Button////////////////
b7 = new JButton("Update Client");
b7.setFocusPainted(false);
b7.setForeground(Color.WHITE);
b7.setBorder(null);
b7.setFont(new Font("Arial", Font.PLAIN, 15));
b7.setBackground(Color.DARK_GRAY);
b7.setBounds(550, 490, 100, 35);
b7.setCursor(new Cursor(Cursor.HAND_CURSOR));
b7.addActionListener(this);
frame.add(b7);

////////////////////////////////////////////////
		
		b1 = new JButton("Manage Clients");
		b1.setFocusPainted(false);
		b1.setForeground(Color.WHITE);
		b1.setBorder(null);
		b1.setFont(new Font("Arial", Font.PLAIN, 25));
		b1.setBackground(Color.BLACK);
		b1.setBounds(0, 155, 250, 70);
		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));

		b1.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				b1.setBackground(DARK_BLUE);
			}

			public void mouseExited(MouseEvent evt) {
				b1.setBackground(Color.BLACK);
			}

		});

////////////////////////////////////////////////
		
b3 = new JButton("Manage Cars");
b3.setFocusPainted(false);
b3.setForeground(Color.WHITE);
b3.setBorder(null);
b3.setFont(new Font("Arial", Font.PLAIN, 25));
b3.setBackground(Color.BLACK);
b3.setBounds(0, 225, 250, 70);
b3.addActionListener(this);
b3.setCursor(new Cursor(Cursor.HAND_CURSOR));
b3.addMouseListener(new MouseAdapter() {
public void mouseEntered(MouseEvent evt) {
b3.setBackground(DARK_BLUE);
}
///////////////////////::::

public void mouseExited(MouseEvent evt) {
b3.setBackground(Color.BLACK);
}

});
		////////////////////////////////////////////
		b2 = new JButton("Log Out");
		b2.setFocusPainted(false);
		b2.setForeground(Color.RED);
		b2.setBorder(null);
		b2.setFont(new Font("Arial", Font.PLAIN, 25));
		b2.setBackground(Color.BLACK);
		b2.setBounds(0, 295, 250, 70);
		b2.addActionListener(this);
		b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b2.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				b2.setBackground(DARK_BLUE);
			}

			public void mouseExited(MouseEvent evt) {
				b2.setBackground(Color.BLACK);
			}

		});
		///////////////////////////////////////
		img1 = new ImageIcon("assets/logo.png");
		image = img1.getImage();
		image2 = image.getScaledInstance(252, 100, java.awt.Image.SCALE_SMOOTH);
		img1 = new ImageIcon(image2);
		label = new JLabel(img1);
		label.setBounds(0, 0, 252, 85);
//////////////////////////////////////////////////////////////////
		
		

		
		
	
		
		
	
		
		///////////////////////////////////////////////////////
		frame.add(jl5);
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
		frame.add(b5);
		frame.add(p1);
		frame.add(label);

		frame.setVisible(true);

	}



	public void actionPerformed(ActionEvent ev) {
		
		if (ev.getSource() == b3) {
			frame.setVisible(false);
			ManageCarDash MCar = new ManageCarDash();
			MCar.setVisible(true);
		}if (ev.getSource() == b2) {
			frame.setVisible(false);
			Login log = new Login();
			log.setVisible(true);
		}
		if (ev.getSource() == b4) {
			frame.setVisible(false);
			Dashboard dash = new Dashboard();
			dash.setVisible(true);
		}
		if (ev.getSource() == b5) {
			frame.setVisible(false);
			AddClient cl = new AddClient();
			cl.setVisible(true);
		}
		if (ev.getSource() == b6) {
			int reply = JOptionPane.showConfirmDialog(null, "Are you Sure, You want to Delete This ? ", "Warning", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				int k = tableau.getSelectedRow();
				int selectedR =(int) tableau.getModel().getValueAt(k, 0);
				Connexion conn = new Connexion();
				///// Send it From Clients to Old Clients Table !!!!!!////////
				List<String> AClients= new ArrayList<String>();
				AClients =(conn.retriveSelectedC(selectedR));
				conn.insertAClient(AClients.get(0),AClients.get(1),Integer.parseInt(AClients.get(2)), Integer.parseInt(AClients.get(3)), AClients.get(4), AClients.get(5), AClients.get(6), AClients.get(7));
				conn.deleteCById(selectedR);
				modele.removeC(k);
			}
	}
		if (ev.getSource() == b7) {
	
			
			int k = tableau.getSelectedRow();
        	int selectedR =(int)tableau.getValueAt(k, 0);
			Connexion conn = new Connexion();
			rclients =(conn.retriveSelectedC(selectedR));
			UpdateClient UC=new UpdateClient(rclients,selectedR);
			frame.dispose();
		
			
		}
		}



		
}


