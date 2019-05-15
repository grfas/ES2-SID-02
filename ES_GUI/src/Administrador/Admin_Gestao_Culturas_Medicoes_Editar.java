package Administrador;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Admin_Gestao_Culturas_Medicoes_Editar extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Gestao_Culturas_Medicoes_Editar frame = new Admin_Gestao_Culturas_Medicoes_Editar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Admin_Gestao_Culturas_Medicoes_Editar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMedicao = new JLabel("Medicao");
		lblMedicao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMedicao.setBounds(69, 72, 99, 17);
		contentPane.add(lblMedicao);

		JLabel lblCultura = new JLabel("Cultura");
		lblCultura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCultura.setBounds(69, 100, 99, 17);
		contentPane.add(lblCultura);

		JLabel lblVariavel = new JLabel("Variavel");
		lblVariavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVariavel.setBounds(69, 128, 99, 17);
		contentPane.add(lblVariavel);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(191, 72, 139, 20);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(191, 100, 139, 20);
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(191, 128, 139, 20);
		contentPane.add(textField_3);

		JList list = new JList();
		list.setBounds(69, 186, 370, 189);
		contentPane.add(list);

		JButton btnApagar = new JButton("Apagar");
		btnApagar.setBounds(350, 400, 89, 23);
		contentPane.add(btnApagar);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(69, 400, 89, 23);
		contentPane.add(btnGuardar);
	}

}
