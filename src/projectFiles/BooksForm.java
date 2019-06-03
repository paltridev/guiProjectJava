package projectFiles;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database_access.BookDao;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class BooksForm extends JFrame {
	static BooksForm frame;
	private JPanel contentPane;
	private JTextField ssnTex;
	private JTextField nameTex;
	private JTextField authorTex;
	private JTextField publisherTex;
	private JTextField quantityTex;


	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new BooksForm();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public BooksForm() {
		super("Add book to database");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 510, 410);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#FFE4B5"));
		contentPane.setBorder(new EmptyBorder(30, 5, 5, 5));
		setContentPane(contentPane);
		
		
		ImageIcon adicon =new ImageIcon(getClass().getResource("images/addbookicon.png"));
		JLabel lblAddBooks = new JLabel("Add Books to Database",adicon,SwingConstants.CENTER);
		lblAddBooks.setForeground(Color.GRAY);
		lblAddBooks.setFont(new Font("Helvetica", Font.BOLD, 25));
		
		JLabel lblCallNo = new JLabel("SSN:");
		
		JLabel lblName = new JLabel("Name:");
		
		JLabel lblAuthor = new JLabel("Author:");
		
		JLabel lblPublisher = new JLabel("Publisher:");
		
		JLabel lblQuantity = new JLabel("Quantity:");
		
		ssnTex = new JTextField();
		ssnTex.setColumns(10);
		
		nameTex = new JTextField();
		nameTex.setColumns(10);
		
		authorTex = new JTextField();
		authorTex.setColumns(10);
		
		publisherTex = new JTextField();
		publisherTex.setColumns(10);
		
		quantityTex = new JTextField();
		quantityTex.setColumns(10);
		
		JButton btnAddBooks = new JButton("Add Books");
		btnAddBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String callno=ssnTex.getText();
			String name=nameTex.getText();
			String author=authorTex.getText();
			String publisher=publisherTex.getText();
			String squantity=quantityTex.getText();
			int quantity=Integer.parseInt(squantity);
			int i=database_access.BookDao.save(callno, name, author, publisher, quantity);
			if(i>0){
				UIManager.put("OptionPane.background",Color.decode("#FFE4B5"));
				UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#FFE4B5"));
				JOptionPane.showMessageDialog(BooksForm.this,"Books added successfully!");
				LibrarianSuccess.main(new String[]{});
				frame.dispose();
				
			}else{
				UIManager.put("OptionPane.background",Color.decode("#FFE4B5"));
				UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#FFE4B5"));
				JOptionPane.showMessageDialog(BooksForm.this,"Sorry, unable to save!");
			}
			}
		});
		
		btnAddBooks.setBackground(Color.decode("#FFFACD"));
		btnAddBooks.setToolTipText("Click to add new book");
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		btnBack.setToolTipText("Click to go back");
		btnBack.setBackground(Color.decode("#FFFACD"));
		
		
		
		GroupLayout BFcontentpane = new GroupLayout(contentPane);
		
		BFcontentpane.setHorizontalGroup(
			BFcontentpane.createParallelGroup(Alignment.TRAILING)
				.addGroup(BFcontentpane.createSequentialGroup()
					.addGroup(BFcontentpane.createParallelGroup(Alignment.LEADING)
						.addGroup(BFcontentpane.createSequentialGroup()
							.addGap(90)
							.addComponent(lblAddBooks))
						.addGroup(BFcontentpane.createSequentialGroup()
							.addGap(18)
							.addGroup(BFcontentpane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCallNo, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAuthor, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPublisher, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
								.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
							.addGap(47)
							.addGroup(BFcontentpane.createParallelGroup(Alignment.LEADING)
								.addComponent(quantityTex, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(publisherTex, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(authorTex, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(nameTex, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(ssnTex, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(125, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, BFcontentpane.createSequentialGroup()
					.addGap(161)
					.addComponent(btnAddBooks, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(140, Short.MAX_VALUE)
					.addGap(70)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					)
		);
		
		
		BFcontentpane.setVerticalGroup(
			BFcontentpane.createParallelGroup(Alignment.LEADING)
				.addGroup(BFcontentpane.createSequentialGroup()
					.addComponent(lblAddBooks)
					.addGap(18)
					.addGroup(BFcontentpane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCallNo)
						.addComponent(ssnTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(BFcontentpane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(nameTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(BFcontentpane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAuthor)
						.addComponent(authorTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(BFcontentpane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPublisher)
						.addComponent(publisherTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(BFcontentpane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantity)
						.addComponent(quantityTex, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(btnAddBooks, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		contentPane.setLayout(BFcontentpane);
	}

}