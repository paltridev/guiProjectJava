package projectFiles;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class AdminSuccess extends JFrame {
	
	static AdminSuccess frame;
	private JPanel contentPane;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminSuccess();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public AdminSuccess() {
		super("Admin Section");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 20, 650, 670);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#FFE4B5"));
		contentPane.setBorder(new EmptyBorder(30, 0, 0, 0));
		setContentPane(contentPane);
		
		
		ImageIcon Asicon =new ImageIcon(getClass().getResource("images/admin.png"));
		JLabel lAdminSection = new JLabel("Admin Section",Asicon,SwingConstants.CENTER);
		lAdminSection.setPreferredSize(new Dimension(650, 64));
		lAdminSection.setFont(new Font("Helvetica", Font.BOLD, 30));
		lAdminSection.setForeground(Color.GRAY);
		
		add(lAdminSection);
		
		ImageIcon newbtn =new ImageIcon(getClass().getResource("images/user.png"));
		JButton btnNewButton = new JButton(newbtn);
		btnNewButton.setBackground(Color.decode("#FFFACD"));
		btnNewButton.setPreferredSize(new Dimension(256, 256));
		btnNewButton.setToolTipText("Click to add Librarian");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			LibrarianForm.main(new String[]{});
			frame.dispose();
			}
		});
	
		ImageIcon newview =new ImageIcon(getClass().getResource("images/eye.png"));
		JButton btnViewLibrarian = new JButton(newview);
		btnViewLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ViewLibrarian.main(new String[]{});
			}
		});
		btnViewLibrarian.setBackground(Color.decode("#FFFACD"));
		btnViewLibrarian.setToolTipText("Click to view Librarians");
		btnViewLibrarian.setPreferredSize(new Dimension(256, 256));
		
		
		ImageIcon delbtn =new ImageIcon(getClass().getResource("images/deluser.png"));
		JButton btnDeleteLibrarian = new JButton(delbtn);
		btnDeleteLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			DeleteLibrarian.main(new String[]{});
			frame.dispose();
			}
		});
		
		btnDeleteLibrarian.setBackground(Color.decode("#FFFACD"));
		btnDeleteLibrarian.setToolTipText("Click to delete Librarian");
		btnDeleteLibrarian.setPreferredSize(new Dimension(256, 256));
		
		
		ImageIcon logouticon =new ImageIcon(getClass().getResource("images/logout.png"));
		JButton btnLogout = new JButton(logouticon);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Library.main(new String[]{});
				frame.dispose();
			}
		});
		
		
		btnLogout.setBackground(Color.decode("#FFFACD"));
		btnLogout.setToolTipText("Click to Logout");
		btnLogout.setPreferredSize(new Dimension(256, 256));
		
		
		add(btnNewButton);
		add(btnViewLibrarian);
		add(btnDeleteLibrarian);
		add(btnLogout);
		
	}
	
	}
	
