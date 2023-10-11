package xml;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.awt.event.ActionEvent;

public class MainApp {

	private JFrame frame;
	private JTextField tid;
	private JTextField tnom;
	private JTextField tprenom;
	private JTextField tsearch;

	/**
	 * Launch the application.
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApp window = new MainApp();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public MainApp() throws MalformedURLException, RemoteException, NotBoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws NotBoundException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	private void initialize() throws MalformedURLException, RemoteException, NotBoundException {
        UserServer server = (UserServer) Naming.lookup("rmi://localhost/UserServer");
		frame = new JFrame();
		frame.setBounds(100, 100, 509, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(61, 45, 45, 13);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("nom");
		lblNewLabel_1.setBounds(61, 68, 45, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("prenom");
		lblNewLabel_2.setBounds(61, 91, 45, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		tid = new JTextField();
		tid.setBounds(304, 45, 96, 19);
		frame.getContentPane().add(tid);
		tid.setColumns(10);
		
		tnom = new JTextField();
		tnom.setColumns(10);
		tnom.setBounds(304, 68, 96, 19);
		frame.getContentPane().add(tnom);
		
		tprenom = new JTextField();
		tprenom.setColumns(10);
		tprenom.setBounds(304, 91, 96, 19);
		frame.getContentPane().add(tprenom);
		
		JButton b_add = new JButton("Ajouter");
		b_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					server.addUser(Long.parseLong(tid.getText()), tnom.getText(), tprenom.getText());
					tid.setText(null);
					tnom.setText(null);
					tprenom.setText(null);
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		b_add.setBounds(170, 126, 85, 21);
		frame.getContentPane().add(b_add);
		
		JLabel lblNewLabel_3 = new JLabel("Chercher");
		lblNewLabel_3.setBounds(61, 169, 45, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("id");
		lblNewLabel_4.setBounds(61, 208, 45, 13);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel result_id = new JLabel("");
		result_id.setBounds(252, 302, 45, 13);
		frame.getContentPane().add(result_id);
		
		JLabel result_nom = new JLabel("");
		result_nom.setBounds(252, 325, 45, 13);
		frame.getContentPane().add(result_nom);
		
		JLabel result_prenom = new JLabel("");
		result_prenom.setBounds(252, 367, 45, 13);
		frame.getContentPane().add(result_prenom);

		tsearch = new JTextField();
		tsearch.setBounds(159, 205, 96, 19);
		frame.getContentPane().add(tsearch);
		tsearch.setColumns(10);
		
		JButton bsearch = new JButton("chercher");
		bsearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					User user = server.getUser(Long.parseLong(tsearch.getText()));
					if(user != null) {
						result_id.setText(user.getId().toString());
						result_nom.setText(user.getNom());
						result_prenom.setText(user.getPrenom());
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		bsearch.setBounds(315, 204, 85, 21);
		frame.getContentPane().add(bsearch);
		
		JLabel lblNewLabel_5 = new JLabel("Resultat");
		lblNewLabel_5.setBounds(61, 247, 45, 13);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("ID");
		lblNewLabel_6.setBounds(61, 302, 45, 13);
		frame.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Nom");
		lblNewLabel_7.setBounds(61, 325, 45, 13);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_2_1 = new JLabel("Prenom");
		lblNewLabel_2_1.setBounds(61, 351, 45, 13);
		frame.getContentPane().add(lblNewLabel_2_1);
		
	}
}
