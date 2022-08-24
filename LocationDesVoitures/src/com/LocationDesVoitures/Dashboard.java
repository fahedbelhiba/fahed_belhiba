package com.LocationDesVoitures;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;

public class Dashboard extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JPanel p1, l1, l2, l3, l4;
	private JLabel label, jl1, jl2, jl3, jl4, jl5, jv1, jv2, jv3, jv4;
	private JButton b1, b2, b3, b4;
	private ImageIcon img1;
	private Image image, image2;
	private ArrayList<Long> allPrices = new ArrayList<Long>();
	private ArrayList<Integer> l = new ArrayList<Integer>();
	//////////////// colors///////////////////
	public static final Color DARK_BLUE = new Color(205 - 0 - 0);

	///////////////////////////////

	public Dashboard() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(450, 190, 1014, 597);
		frame.setResizable(false);
		frame.getContentPane();
		frame.setLayout(null);
		/////////////////////////
		p1 = new JPanel();
		p1.setBounds(0, 150, 250, 9126);
		p1.setBackground(Color.BLACK);
		////////////////////////////////////////
		jl5 = new JLabel("DASHBOARD");
		jl5.setForeground(Color.BLACK);
		jl5.setFont(new Font("Times New Roman", Font.PLAIN, 46));
		jl5.setBounds(463, 13, 350, 93);

		////////////////////////////////////
		b4 = new JButton("DashBoard");
		b4.setFocusPainted(false);
		b4.setForeground(Color.WHITE);
		b4.setBorder(null);
		b4.setFont(new Font("Arial", Font.PLAIN, 25));
		b4.setBackground(Color.BLACK);
		b4.setBounds(0, 85, 250, 70);
		b4.setCursor(new Cursor(Cursor.HAND_CURSOR));

		b4.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				b4.setBackground(DARK_BLUE);
			}

			public void mouseExited(MouseEvent evt) {
				b4.setBackground(Color.BLACK);
			}

		});
		//////////////////////////////////////:


////////////////////////////////////////////////

		b1 = new JButton("Manage Clients");
		b1.setFocusPainted(false);
		b1.setForeground(Color.WHITE);
		b1.setBorder(null);
		b1.setFont(new Font("Arial", Font.PLAIN, 25));
		b1.setBackground(Color.BLACK);
		b1.setBounds(0, 155, 250, 70);
		b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		b1.addActionListener(this);
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

		//////////////////////////////////////////////////////////////////
		l1 = new JPanel();
		l1.setBounds(670, 150, 250, 116);
		l1.setBackground(Color.WHITE);
		jl1 = new JLabel();
		jl1.setText("Revenus");
		jl1.setBounds(70, 0, 130, 40);
		jv3 = new JLabel();
		ModeleD M = new ModeleD();

		jv3.setFont(new Font("Arial", Font.PLAIN, 70));
		jv3.setBounds(100, 30, 80, 80);
		jv3.setForeground(Color.GREEN);
		jl1.setFont(new Font("Arial", Font.PLAIN, 25));
		l1.setLayout(null);
		l1.add(jv3);
		l1.add(jl1);

		/////////////////////////////////////////////////////////
		l2 = new JPanel();
		l2.setBounds(360, 150, 250, 116);
		l2.setBackground(Color.WHITE);
		jl2 = new JLabel();
		jl2.setText("Clients");
		jl2.setBounds(80, 0, 90, 40);
		jv1 = new JLabel();

		jv1.setText(String.valueOf(M.getRowCount()));
		jv1.setFont(new Font("Arial", Font.PLAIN, 70));
		jv1.setBounds(100, 30, 80, 80);
		jv1.setForeground(Color.GREEN);
		jl2.setFont(new Font("Arial", Font.PLAIN, 25));
		l2.setLayout(null);
		l2.add(jl2);
		l2.add(jv1);

		/////////////////////////////////////////////////////////
		l3 = new JPanel();
		l3.setBounds(360, 350, 250, 116);
		l3.setBackground(Color.WHITE);
		l3.setLayout(null);
		jl3 = new JLabel();
		jl3.setText("Cars Available");
		jl3.setFont(new Font("Arial", Font.PLAIN, 25));
		jl3.setBounds(40, 0, 160, 40);
		jv4 = new JLabel();
		ModeleV MV = new ModeleV();

		jv4.setText(String.valueOf(MV.getRowCount()));
		jv4.setFont(new Font("Arial", Font.PLAIN, 70));
		jv4.setBounds(100, 30, 80, 80);
		jv4.setForeground(Color.GREEN);
		l3.add(jl3);
		l3.add(jv4);
		/////////////////////////////////////////////////////////
		l4 = new JPanel();
		l4.setBounds(670, 350, 250, 116);
		l4.setBackground(Color.WHITE);
		jl4 = new JLabel();
		jl4.setText("Rented Cars");
		jl4.setFont(new Font("Arial", Font.PLAIN, 25));
		jl4.setBounds(50, 0, 170, 40);
		jv2 = new JLabel();

		jv2.setText(String.valueOf(M.getRowCount()));
		jv2.setFont(new Font("Arial", Font.PLAIN, 70));
		jv2.setBounds(100, 30, 80, 80);
		jv2.setForeground(Color.GREEN);
		jl4.setFont(new Font("Arial", Font.PLAIN, 25));
		l4.setLayout(null);
		l4.add(jv2);
		l4.add(jl4);

		img1 = new ImageIcon("assets/logo.png");
		image = img1.getImage();
		image2 = image.getScaledInstance(252, 100, java.awt.Image.SCALE_SMOOTH);
		img1 = new ImageIcon(image2);
		label = new JLabel(img1);
		label.setBounds(0, 0, 252, 85);
		////////////////////////////////////////////////// adding to the frame
		////////////////////////////////////////////////// //////////////
		frame.add(jl5);
		frame.add(b1);
		frame.add(b2);
		frame.add(b3);
		frame.add(b4);
		frame.add(p1);
		frame.add(label);
		frame.add(l1);
		frame.add(l2);
		frame.add(l3);
		frame.add(l4);

		//////////////////////////////////////////
		frame.setVisible(true);

	}



	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() == b2) {
			frame.setVisible(false);
			Login log = new Login();
			log.setVisible(true);
		}
		if (ev.getSource() == b3) {
			frame.setVisible(false);
			ManageCarDash Dash = new ManageCarDash();
			Dash.setVisible(true);
		}
		if (ev.getSource() == b1) {
			frame.setVisible(false);
			JtableDash Jt = new JtableDash();
			Jt.setVisible(true);
		}
	}
}