package projectFiles;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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
public class AdminLogin extends JFrame {
	static AdminLogin frame;
	private JPanel contentPane;
	private JTextField nameText;
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AdminLogin();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AdminLogin() {
		super("Admin Login Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#FFE4B5"));
		setContentPane(contentPane);
		
		
		
		ImageIcon Adlicon =new ImageIcon(getClass().getResource("images/adminloginicon.jpg"));
		JLabel lAdminLoginForm = new JLabel("Admin Login Form", Adlicon, SwingConstants.CENTER);
		lAdminLoginForm.setForeground(Color.GRAY);
		lAdminLoginForm.setFont(new Font("Helvetica", Font.BOLD, 20));
		
		JLabel lEnterName = new JLabel("Enter Username:");
		
		JLabel lEnterPassword = new JLabel("Enter Password:");
		
		nameText = new JTextField();
		nameText.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=nameText.getText();
			String password=String.valueOf(passwordField.getPassword());
			if(name.equals("admin")&&password.equals("admin123")){
				AdminSuccess.main(new String[]{});
				frame.dispose();
			}else{
				UIManager.put("OptionPane.background",Color.decode("#FFE4B5"));
				UIManager.getLookAndFeelDefaults().put("Panel.background", Color.decode("#FFE4B5"));
				JOptionPane.showMessageDialog(AdminLogin.this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
				nameText.setText("");
				passwordField.setText("");
				
				
			}
			}
		});
		
		btnLogin.setBackground(Color.decode("#FFFACD"));
		
		passwordField = new JPasswordField();
		
		
		//ALign Content Horizontally using GroupLayout
		GroupLayout AlContentpane = new GroupLayout(contentPane);
		AlContentpane.setHorizontalGroup(
			AlContentpane.createParallelGroup(Alignment.TRAILING)
				.addGroup(AlContentpane.createSequentialGroup()
					.addGroup(AlContentpane.createParallelGroup(Alignment.LEADING)
						.addGroup(AlContentpane.createSequentialGroup()
							.addGap(120)
							.addComponent(lAdminLoginForm))
						.addGroup(AlContentpane.createSequentialGroup()
							.addGap(19)
							.addGroup(AlContentpane.createParallelGroup(Alignment.LEADING)
								.addComponent(lEnterName)
								.addComponent(lEnterPassword))
							.addGap(47)
							.addGroup(AlContentpane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(passwordField)
								.addComponent(nameText, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))))
					.addContainerGap(107, Short.MAX_VALUE))
				.addGroup(AlContentpane.createSequentialGroup()
					.addContainerGap(187, Short.MAX_VALUE)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addGap(151))
		);
		
		//ALign Content Vertically using GroupLayout
		AlContentpane.setVerticalGroup(
			AlContentpane.createParallelGroup(Alignment.LEADING)
				.addGroup(AlContentpane.createSequentialGroup()
					.addGap(20)
					.addComponent(lAdminLoginForm)
					.addGap(40)
					.addGroup(AlContentpane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lEnterName)
						.addComponent(nameText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(AlContentpane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lEnterPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(80, Short.MAX_VALUE))
		);
		contentPane.setLayout(AlContentpane);
	}
}