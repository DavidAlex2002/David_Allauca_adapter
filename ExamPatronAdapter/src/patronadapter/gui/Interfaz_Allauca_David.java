package patronadapter.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import patronadapter.mundo.Customer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DashBoard extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtDir;
	private JTextField txtZip;
	private JTextField txtState;
	private JTable table;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard frame = new DashBoard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public DashBoard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 512, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Nombre");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(10, 10, 100, 24);
		contentPane.add(lblName);
		
		JLabel lblDir = new JLabel("Dirercci\u00F3n");
		lblDir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDir.setBounds(10, 44, 100, 24);
		contentPane.add(lblDir);
		
		JLabel lblZip = new JLabel("Zip");
		lblZip.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblZip.setBounds(10, 78, 100, 24);
		contentPane.add(lblZip);
		
		JLabel lblState = new JLabel("Estado");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblState.setBounds(10, 112, 100, 24);
		contentPane.add(lblState);
		
		JLabel lblType = new JLabel("Tipo");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblType.setBounds(10, 146, 100, 24);
		contentPane.add(lblType);
		
		txtName = new JTextField();
		txtName.setBounds(120, 10, 255, 24);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtDir = new JTextField();
		txtDir.setColumns(10);
		txtDir.setBounds(120, 49, 255, 24);
		contentPane.add(txtDir);
		
		txtZip = new JTextField();
		txtZip.setColumns(10);
		txtZip.setBounds(120, 83, 255, 24);
		contentPane.add(txtZip);
		
		txtState = new JTextField();
		txtState.setColumns(10);
		txtState.setBounds(120, 117, 255, 24);
		contentPane.add(txtState);
		
		JComboBox cbType = new JComboBox();
		cbType.setToolTipText("US\r\nCANADA");
		cbType.setBounds(120, 150, 255, 21);
		cbType.addItem("US");
		cbType.addItem("CANADA");
		contentPane.add(cbType);
		
		JButton btnSave = new JButton("Guardar");
		
		// Click btnSave
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtName.getText() != null && txtDir.getText() != null && txtZip.getText() != null && txtState.getText() != null)
				{
					Customer c = null;
					if (cbType.getSelectedItem() == "US")
						c = new Customer(txtName.getText(), txtDir.getText(), txtZip.getText(), txtState.getText(), Customer.US);
					if (cbType.getSelectedItem() == "CANADA")
						c = new Customer(txtName.getText(), txtDir.getText(), txtZip.getText(), txtState.getText(), Customer.CANADA);
					
					if (c.isValidAddress())
						JOptionPane.showMessageDialog(null, "Direccion Valida");
					else
						JOptionPane.showMessageDialog(null, "Direccion no Valida");
				}
			}
		});
		
		btnSave.setBounds(388, 148, 100, 25);
		contentPane.add(btnSave);
		
		table = new JTable();
		table.setBounds(10, 209, 478, 220);
		contentPane.add(table);
		
		JButton btnEdit = new JButton("Editar");
		btnEdit.setBounds(10, 439, 100, 25);
		contentPane.add(btnEdit);
		
		JButton btnDelete = new JButton("Eliminar");
		btnDelete.setBounds(388, 439, 100, 25);
		contentPane.add(btnDelete);
	}
}
