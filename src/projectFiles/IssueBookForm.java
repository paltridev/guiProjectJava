package projectFiles;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import database_access.IssueBookDao;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class IssueBookForm extends JFrame {
	static IssueBookForm frame;
	private JPanel contentPane;
	private JTextField ssnTex;
	private JTextField sIDText;
	private JTextField snameTex;
	private JTextField sconTex;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new IssueBookForm();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public IssueBookForm() {
		
		super("Issue Book");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 390);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#FFE4B5"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Icon ibicon = new ImageIcon(getClass().getResource("images/bookicon.png"));
		JLabel lblNewLabel = new JLabel("Issue Book ",ibicon,SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Helvetica", Font.BOLD, 22));
		lblNewLabel.setForeground(Color.GRAY);
		
		JLabel lblBookName = new JLabel("Book SSN:");
		
		ssnTex = new JTextField();
		ssnTex.setColumns(10);
		
		sIDText = new JTextField();
		sIDText.setColumns(10);
		
		snameTex = new JTextField();
		snameTex.setColumns(10);
		
		sconTex = new JTextField();
		sconTex.setColumns(10);
		
		JLabel lblStudentId = new JLabel("Student Id:");
		
		JLabel lblStudentName = new JLabel("Student Name:");
		
		JLabel lblStudentContact = new JLabel("Student Contact:");
		
		JButton btnIssueBook = new JButton("Issue Book");
		btnIssueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			String bookcallno=ssnTex.getText();
			int studentid=Integer.parseInt(sIDText.getText());
			String studentname=snameTex.getText();
			String studentcontact=sconTex.getText();
			
			if(database_access.IssueBookDao.checkBook(bookcallno)){
			
			int i=database_access.IssueBookDao.save(bookcallno, studentid, studentname, studentcontact);
			if(i>0){
				UIManager.put("OptionPane.background",Color.decode("#FFE4B5"));
				UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#FFE4B5"));
				JOptionPane.showMessageDialog(IssueBookForm.this,"Book issued successfully!");
				LibrarianSuccess.main(new String[]{});
				frame.dispose();
				
			}else{
				UIManager.put("OptionPane.background",Color.decode("#FFE4B5"));
				UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#FFE4B5"));
				JOptionPane.showMessageDialog(IssueBookForm.this,"Sorry, unable to issue!");
			}//end of save if-else
			
			}else{
				UIManager.put("OptionPane.background",Color.decode("#FFE4B5"));
				UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#FFE4B5"));
				JOptionPane.showMessageDialog(IssueBookForm.this,"Sorry, SSN doesn't exist!");
			}//end of checkbook if-else
			
			}
		});
		btnIssueBook.setBackground(Color.decode("#FFFACD"));
		btnIssueBook.setFont(new Font("Helvetica", Font.BOLD, 15));
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		
		btnBack.setBackground(Color.decode("#FFFACD"));
		btnBack.setFont(new Font("Helvetica", Font.BOLD, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Note: Please check Student ID Carefully before issuing book!", SwingConstants.CENTER);
		
		lblNewLabel_1.setFont(new Font("Helvetica", Font.ITALIC, 11));
		lblNewLabel_1.setForeground(Color.RED);
		
		GroupLayout Ibcontentpane = new GroupLayout(contentPane);
		
		
		Ibcontentpane.setHorizontalGroup(
			Ibcontentpane.createParallelGroup(Alignment.LEADING)
				.addGroup(Ibcontentpane.createSequentialGroup()
					.addContainerGap(10, Short.MAX_VALUE)
					.addGroup(Ibcontentpane.createParallelGroup(Alignment.LEADING)
						.addGroup(Ibcontentpane.createSequentialGroup()
							.addGroup(Ibcontentpane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblBookName, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblStudentId, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblStudentName, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblStudentContact, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(Ibcontentpane.createParallelGroup(Alignment.LEADING)
								.addComponent(sIDText, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(ssnTex, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(snameTex, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addComponent(sconTex, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
							.addGap(48))
						.addGroup(Alignment.TRAILING, Ibcontentpane.createSequentialGroup()
							.addGap(20)
							.addGroup(Ibcontentpane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_1)
								.addGroup(Ibcontentpane.createSequentialGroup()
									
									.addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
									.addGap(80)
									.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
							)))
				.addGroup(Ibcontentpane.createSequentialGroup()
					.addGap(195)
					.addComponent(lblNewLabel)
					.addGap(180)
					.addContainerGap(235, Short.MAX_VALUE))
		);
		Ibcontentpane.setVerticalGroup(
			Ibcontentpane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Ibcontentpane.createSequentialGroup()
					.addGap(37)
					.addComponent(lblNewLabel)
					.addGap(43)
					.addGroup(Ibcontentpane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookName)
						.addComponent(ssnTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(Ibcontentpane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentId)
						.addComponent(sIDText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(Ibcontentpane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentName)
						.addComponent(snameTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(Ibcontentpane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentContact)
						.addComponent(sconTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(Ibcontentpane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnIssueBook, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack))
					.addGap(18)
					.addComponent(lblNewLabel_1)
					)
		);
		contentPane.setLayout(Ibcontentpane);
	}
}