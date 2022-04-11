package forms;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import testEvelia.TestIniciarSesion;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class FrmRendirEvaluacion extends JFrame {

	private static JPanel contentPane;
	private static JTextField valueUsuario;
	private static JTextField valueContrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRendirEvaluacion frame = new FrmRendirEvaluacion();
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
	public FrmRendirEvaluacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 453, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(35, 26, 150, 15);
		contentPane.add(lblUsuario);
		
		valueUsuario = new JTextField();
		valueUsuario.setBounds(203, 24, 213, 19);
		contentPane.add(valueUsuario);
		valueUsuario.setColumns(10);
		
		JLabel lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setBounds(35, 82, 150, 15);
		contentPane.add(lblContrasenia);
		
		valueContrasenia = new JTextField();
		valueContrasenia.setColumns(10);
		valueContrasenia.setBounds(203, 80, 213, 19);
		contentPane.add(valueContrasenia);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				System.out.println("Iniciando Sesion Test");
				String usuario = valueUsuario.getText();
				String contrasenia = valueContrasenia.getText();
				System.out.println(usuario);
				System.out.println(contrasenia);
				try {
					TestIniciarSesion.iniciarSesionConParametros(usuario,contrasenia);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		btnEnviar.setBounds(35, 136, 117, 25);
		contentPane.add(btnEnviar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(299, 136, 117, 25);
		contentPane.add(btnCancelar);
	}
}
