package projectFiles;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Library extends JFrame{
 static Library frame;
 private JLabel fpanel;
 private JPanel contentPane;
 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame= new Library();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 
 public Library(){

	 super("Library Management System");
	 
	 
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 setBounds(100, 100, 800, 450); //Frame Size and where to open in screen
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setBackground(Color.decode("#FFE4B5"));
		contentPane.setBorder(new EmptyBorder(30, 0, 0, 0));
	 
	Icon libicon = new ImageIcon(getClass().getResource("images/frameicon.png"));
	 fpanel = new JLabel("Library Management System",libicon, SwingConstants.CENTER);
	 fpanel.setFont(new Font("Helvetica", Font.BOLD, 25));
	 fpanel.setBorder(new EmptyBorder(0, 0, 40, 0));
	 fpanel.setForeground(Color.GRAY);
	 
	 add(fpanel);
	 
	 
	 
	 
	 //Admin Login button 
	 
	 Icon Adbtn = new ImageIcon(getClass().getResource("images/adminloginicon.jpg"));
	 JButton btnAdminLogin = new JButton("Admin Login",Adbtn);
	 btnAdminLogin.setPreferredSize(new Dimension(500, 100));
	 btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			AdminLogin.main(new String[]{});
			frame.dispose();
			}
		});
	 
	 
	 btnAdminLogin.setToolTipText("Click to Log as Admin");
	 btnAdminLogin.setBackground(Color.decode("#FFFACD"));
	 btnAdminLogin.setFont(new Font("Helvetica", Font.BOLD, 30));
	 btnAdminLogin.setIconTextGap(45);
	 add(btnAdminLogin, BorderLayout.CENTER);
	 
	 
	 //Librarian Login button
	 Icon Libbtn = new ImageIcon(getClass().getResource("images/librarianicon.png"));
	 JButton btnLibrarianLogin = new JButton("Librarian Login",Libbtn);
	 btnLibrarianLogin.setPreferredSize(new Dimension(500, 100));
	 btnLibrarianLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			LibrarianLogin.main(new String[]{});
			frame.dispose();
			}
		});
	 btnLibrarianLogin.setFont(new Font("Helvetica", Font.BOLD, 30));
	 btnLibrarianLogin.setToolTipText("Click to Log as Librarian");
	 btnLibrarianLogin.setBackground(Color.decode("#FFFACD"));
	 add(btnLibrarianLogin, BorderLayout.CENTER);

	
	 
 }
 
	
}
