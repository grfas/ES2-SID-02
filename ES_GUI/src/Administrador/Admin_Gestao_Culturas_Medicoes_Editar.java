package Administrador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Investigador.Medicoes;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

@SuppressWarnings("serial")
public class Admin_Gestao_Culturas_Medicoes_Editar extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<String> listaMedicoes;
	private Administrador admin;
	private String c;
	private String v;

			public void run() {
				try {
					this.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	public Admin_Gestao_Culturas_Medicoes_Editar(Administrador admin, DefaultListModel<String> listaMedicoes, String c, String v) {
		this.admin = admin;
		if (v.equals("   ")) {
			this.v = "Nenhuma Variável Selecionada";
		} else {
			this.v = v;
		}
		if (c.equals("   ")) {
			this.c = "Nenhuma Cultura Selecionada";
		} else {
			this.c = c;
		}
		
		this.listaMedicoes = listaMedicoes;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCultura = new JLabel("Cultura");
		lblCultura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCultura.setBounds(69, 100, 99, 17);
		contentPane.add(lblCultura);

		JLabel lblVariavel = new JLabel("Variavel");
		lblVariavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblVariavel.setBounds(69, 128, 99, 17);
		contentPane.add(lblVariavel);

		JLabel lblnomecultura = new JLabel(this.c);
		lblnomecultura.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnomecultura.setBounds(191, 100, 139, 20);
		contentPane.add(lblnomecultura);

		JLabel lblnomevariavel = new JLabel(this.v);
		lblnomevariavel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblnomevariavel.setBounds(191, 128, 139, 20);
		contentPane.add(lblnomevariavel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(69, 186, 370, 189);
		contentPane.add(scrollPane);

		JList<String> list = new JList<String>(listaMedicoes);
		scrollPane.setViewportView(list);

		JButton btnApagar = new JButton("Apagar");
		btnApagar.setBounds(350, 400, 89, 23);
		contentPane.add(btnApagar);
		btnApagar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				admin.apagaMedicao(list.getSelectedIndex());
				listaMedicoes.clear();
				atualizaListaMedicoes();
			}
		});

	}

	private void atualizaListaMedicoes() {
		for (Medicoes val : admin.lista) {
			listaMedicoes.addElement(Integer.toString(val.getNumero_medicao()) + "    " + val.getData().toString()
					+ "    " + Integer.toString(val.getValor_medicao()) + "    " + Integer.toString(val.getId_cultura())
					+ "    " + Integer.toString(val.getId_variavel()));

		}
	}

}
