
package projectFiles;
import database_access.LibrarianDao;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
public class LibrarianLogin extends JFrame {
	
	static LibrarianLogin frame;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LibrarianLogin();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public LibrarianLogin() {
		super("Librarian Login");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(30, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(Color.decode("#FFE4B5"));
		
		Icon Libicon = new ImageIcon(getClass().getResource("images/librarianicon.png"));
		JLabel lblAdminLoginForm = new JLabel("Librarian Login Form",Libicon,SwingConstants.CENTER);
		lblAdminLoginForm.setForeground(Color.GRAY);
		lblAdminLoginForm.setFont(new Font("Helvetica", Font.BOLD, 20));
		
		JLabel lblEnterName = new JLabel("Enter Name:");
		
		JLabel lblEnterPassword = new JLabel("Enter Password:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=textField.getText();
			String password=String.valueOf(passwordField.getPassword());
			//System.out.println(name+" "+password);
			if(database_access.LibrarianDao.validate(name, password)){
				LibrarianSuccess.main(new String[]{});
				frame.dispose();
			}else{
				UIManager.put("OptionPane.background",Color.decode("#FFE4B5"));
				UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#FFE4B5"));
				JOptionPane.showMessageDialog(LibrarianLogin.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
				textField.setText("");
				passwordField.setText("");
			}
			}
		});
		
		btnLogin.setBackground(Color.decode("#FFFACD"));
		
		passwordField = new JPasswordField();
		
		GroupLayout Librcontentpane = new GroupLayout(contentPane);
		
		
		Librcontentpane.setHorizontalGroup(
			Librcontentpane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Librcontentpane.createSequentialGroup()
					.addGroup(Librcontentpane.createParallelGroup(Alignment.LEADING)
						.addGroup(Librcontentpane.createSequentialGroup()
							.addGap(100)
							.addComponent(lblAdminLoginForm))
						.addGroup(Librcontentpane.createSequentialGroup()
							.addGap(19)
							.addGroup(Librcontentpane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEnterName)
								.addComponent(lblEnterPassword))
							.addGap(47)
							.addGroup(Librcontentpane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))))
					.addContainerGap(107, Short.MAX_VALUE))
				.addGroup(Librcontentpane.createSequentialGroup()
					.addContainerGap(187, Short.MAX_VALUE)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(151))
		);
		Librcontentpane.setVerticalGroup(
			Librcontentpane.createParallelGroup(Alignment.LEADING)
				.addGroup(Librcontentpane.createSequentialGroup()
					.addComponent(lblAdminLoginForm)
					.addGap(30)
					.addGroup(Librcontentpane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(Librcontentpane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE))
		);
		contentPane.setLayout(Librcontentpane);
	}

}
