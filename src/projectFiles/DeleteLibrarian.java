package projectFiles;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database_access.LibrarianDao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class DeleteLibrarian extends JFrame {
	static DeleteLibrarian frame;
	private JPanel contentPane;
	private JTextField sidTex;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DeleteLibrarian();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
	public DeleteLibrarian() {
		 
		super ("Delete Library");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#FFE4B5"));
		contentPane.setBorder(new EmptyBorder(30, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEnterId = new JLabel("Enter Id:");
		lblEnterId.setFont(new Font("Helvetica",Font.BOLD,15));
		
		sidTex = new JTextField();
		sidTex.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sid=sidTex.getText();
				if(sid==null||sid.trim().equals("")){
					JOptionPane.showMessageDialog(DeleteLibrarian.this,"Id can't be blank");
				}else{
					int id=Integer.parseInt(sid);
					int i=database_access.LibrarianDao.delete(id);
					if(i>0){
						UIManager.put("OptionPane.background",Color.decode("#FFE4B5"));
						UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#FFE4B5"));
						JOptionPane.showMessageDialog(DeleteLibrarian.this,"Record deleted successfully!");
					}else{
						UIManager.put("OptionPane.background",Color.decode("#FFE4B5"));
						UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#FFE4B5"));
						JOptionPane.showMessageDialog(DeleteLibrarian.this,"Unable to delete given id!");
					}
				}
			}
		});
		btnDelete.setFont(new Font("Helvetica", Font.BOLD, 18));
		btnDelete.setBackground(Color.decode("#FFFACD"));
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSuccess.main(new String[]{});
				frame.dispose();
			}
		});
		
		btnNewButton.setFont(new Font("Helvetica", Font.BOLD, 18));
		btnNewButton.setBackground(Color.decode("#FFFACD"));
		
		
		
		GroupLayout DLcontentpane = new GroupLayout(contentPane);
		
		
		DLcontentpane.setHorizontalGroup(
			DLcontentpane.createParallelGroup(Alignment.LEADING)
				.addGroup(DLcontentpane.createSequentialGroup()
					.addGap(39)
					.addComponent(lblEnterId)
					.addGap(57)
					.addComponent(sidTex, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(107, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, DLcontentpane.createSequentialGroup()
					.addContainerGap(175, Short.MAX_VALUE)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(140))
				.addGroup(Alignment.TRAILING, DLcontentpane.createSequentialGroup()
					.addContainerGap(322, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(140)
					.addContainerGap())
		);
		DLcontentpane.setVerticalGroup(
			DLcontentpane.createParallelGroup(Alignment.LEADING)
				.addGroup(DLcontentpane.createSequentialGroup()
					.addGap(19)
					.addGroup(DLcontentpane.createParallelGroup(Alignment.LEADING)
						.addComponent(sidTex, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEnterId))
					.addGap(50)
					.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(20)
					.addComponent(btnNewButton,GroupLayout.PREFERRED_SIZE,30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(78, Short.MAX_VALUE))
		);
		contentPane.setLayout(DLcontentpane);
	}
}
