package projectFiles;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database_access.ReturnBookDao;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class ReturnBook extends JFrame {
	static ReturnBook frame;
	private JPanel contentPane;
	private JTextField bookSSNTex;
	private JTextField sidTex;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new ReturnBook();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public ReturnBook() {
		
		super("Return Book");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 516, 340);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#FFE4B5"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		Icon rbicon = new ImageIcon(getClass().getResource("images/bookreturnboxicon.png"));
		JLabel lblReturnBook = new JLabel("Return Book",rbicon,SwingConstants.CENTER);
		lblReturnBook.setForeground(Color.GRAY);
		lblReturnBook.setFont(new Font("Helvetica", Font.BOLD, 25));
		
		JLabel lblBookCallno = new JLabel("Book SSN:");
		
		JLabel lblStudentId = new JLabel("Student Id:");
		
		bookSSNTex = new JTextField();
		bookSSNTex.setColumns(10);
		
		sidTex = new JTextField();
		sidTex.setColumns(10);
		
		JButton btnReturnBook = new JButton("Return Book");
		btnReturnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookcallno=bookSSNTex.getText();
				int studentid=Integer.parseInt(sidTex.getText());
				int i=ReturnBookDao.delete(bookcallno, studentid);
				if(i>0){
					UIManager.put("OptionPane.background",Color.decode("#FFE4B5"));
					UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#FFE4B5"));
					JOptionPane.showMessageDialog(ReturnBook.this,"Book returned successfully!");
					LibrarianSuccess.main(new String[]{});
					frame.dispose();
					
				}else{
					UIManager.put("OptionPane.background",Color.decode("#FFE4B5"));
					UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#FFE4B5"));
					JOptionPane.showMessageDialog(ReturnBook.this,"Sorry, unable to return book!");
				}
			}
		});
		
		btnReturnBook.setBackground(Color.decode("#FFFACD"));
		
		JLabel lblNewLabel = new JLabel("Note: Check the book properly!");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Helvetica", Font.ITALIC, 13));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		
		btnBack.setBackground(Color.decode("#FFFACD"));
		
		
		GroupLayout RBcontentPane = new GroupLayout(contentPane);
		
		
		RBcontentPane.setHorizontalGroup(
			RBcontentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(RBcontentPane.createSequentialGroup()
					.addGap(36)
					.addGroup(RBcontentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(lblStudentId, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
						.addComponent(lblBookCallno, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
					.addGap(56)
					.addGroup(RBcontentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(sidTex, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
						.addComponent(bookSSNTex, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(139, Short.MAX_VALUE))
				.addGroup(RBcontentPane.createSequentialGroup()
					.addContainerGap(210, Short.MAX_VALUE)
					.addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(176))
				.addGroup(RBcontentPane.createSequentialGroup()
					.addContainerGap(205, Short.MAX_VALUE)
					.addComponent(lblReturnBook)
					.addGap(140))
				.addGroup(RBcontentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel)
					)
				.addGroup(RBcontentPane.createSequentialGroup()
					.addContainerGap(355, Short.MAX_VALUE)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(178))
		);
		RBcontentPane.setVerticalGroup(
			RBcontentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(RBcontentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblReturnBook)
					.addGap(32)
					.addGroup(RBcontentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBookCallno)
						.addComponent(bookSSNTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(RBcontentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStudentId)
						.addComponent(sidTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addComponent(btnReturnBook, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(72))
		);
		contentPane.setLayout(RBcontentPane);
	}

}