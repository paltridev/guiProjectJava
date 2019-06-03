package projectFiles;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class LibrarianSuccess extends JFrame {
	static LibrarianSuccess frame;
	private JPanel contentPane;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LibrarianSuccess();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LibrarianSuccess() {
		
		super("Librarian Section");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 20, 1160, 700);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GRAY);
		contentPane.setBackground(Color.decode("#FFE4B5"));
		contentPane.setBorder(new EmptyBorder(30,0,0,0));
		setContentPane(contentPane);
		
		
		Icon lbllbricon = new ImageIcon(getClass().getResource("images/librarian.png"));
		JLabel lblLibrarianSection = new JLabel("Librarian Section",lbllbricon,SwingConstants.CENTER);
		lblLibrarianSection.setPreferredSize(new Dimension(1160, 64));
		lblLibrarianSection.setFont(new Font("Helvetica", Font.BOLD, 30));
		lblLibrarianSection.setForeground(Color.GRAY);
		
		//new book
		Icon abicon = new ImageIcon(getClass().getResource("images/addbook.png"));
		JButton btnNewButton = new JButton(abicon);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			BooksForm.main(new String[]{});
			frame.dispose();
			}
		});
		btnNewButton.setPreferredSize(new Dimension(256, 256));
		btnNewButton.setBackground(Color.decode("#FFFACD"));
		btnNewButton.setToolTipText("Click to add new book");
		
		//view book
		Icon vbicon = new ImageIcon(getClass().getResource("images/search.png"));
		JButton btnViewBooks = new JButton(vbicon);
		btnViewBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewBooks.main(new String[]{});
			}
		});
		
		btnViewBooks.setPreferredSize(new Dimension(256, 256));
		btnViewBooks.setBackground(Color.decode("#FFFACD"));
		btnViewBooks.setToolTipText("Click to view book list");
		
		
		//issue book
		Icon ibicon = new ImageIcon(getClass().getResource("images/book.png"));
		JButton btnIssueBook = new JButton(ibicon);
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IssueBookForm.main(new String[]{});
				frame.dispose();
			}
		});
		
		btnIssueBook.setPreferredSize(new Dimension(256, 256));
		btnIssueBook.setBackground(Color.decode("#FFFACD"));
		btnIssueBook.setToolTipText("Click to issue book");
		
		//view issued book
		Icon vibicon = new ImageIcon(getClass().getResource("images/viewissuedbook.png"));
		JButton btnViewIssuedBooks = new JButton(vibicon);
		btnViewIssuedBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewIssuedBooks.main(new String[]{});
			}
		});
		
		btnViewIssuedBooks.setPreferredSize(new Dimension(256, 256));
		btnViewIssuedBooks.setBackground(Color.decode("#FFFACD"));
		btnViewIssuedBooks.setToolTipText("Click to view issued books");
		
		//return book
		Icon rbicon = new ImageIcon(getClass().getResource("images/bookreturnbox.png"));
		JButton btnReturnBook = new JButton(rbicon);
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnBook.main(new String[]{});
				frame.dispose();
			}
		});
		
		btnReturnBook.setPreferredSize(new Dimension(256, 256));
		btnReturnBook.setBackground(Color.decode("#FFFACD"));
		btnReturnBook.setToolTipText("Click to record returned book");
		
		//logout
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
		
		
		add(lblLibrarianSection);
		add(btnNewButton);
		add(btnViewBooks);
		add(btnIssueBook);
		add(btnViewIssuedBooks);
		add(btnReturnBook);
		add(btnLogout);
	}

}
