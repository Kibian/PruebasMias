package igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import src.Cliente;
import src.DatabaseManager;
import src.Edificio;
import src.Envio;
import src.Fallo;
import src.MyTableModel;
import src.RegistroMovimiento;
import src.Transportista;
import src.Vehiculo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	
	private Cliente clienteActual;
	private MyTableModel modelEnviosEnviados;
	private MyTableModel modelEnviosARepartir;
	private MyTableModel modelRegistrosAMostrar;
	private MyTableModel modelFallosAMostrar;
	private Transportista transportistaActual;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblAplicacinDeEntrega;
	private JButton btnIniciarSesin;
	private JButton btnRegistrarse;
	private JLabel label;
	private JPanel panelInicioEntrada;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel;
	private JPanel panelRegistro;
	private JPanel panel_1;
	private JLabel label_1;
	private JLabel lblRegistro;
	private JLabel label_2;
	private JPanel panelNombre;
	private JLabel lblNombre;
	private JTextField textField;
	private JPanel panel_2;
	private JLabel lblContrasea;
	private JTextField textField_1;
	private JPanel panel_5;
	private JLabel label_4;
	private JTextField textField_2;
	private JPanel panel_6;
	private JLabel lblApellidos;
	private JTextField textField_3;
	private JPanel panel_7;
	private JLabel lblDireccin;
	private JTextField textField_4;
	private JPanel panel_8;
	private JLabel lblProvincia;
	private JComboBox<String> comboBox;
	private JLabel lblCampoNo;
	private JPanel panel_9;
	private JLabel label_5;
	private JPanel panel_10;
	private JButton btnRegistrarse_1;
	private JPanel panelLogin;
	private JPanel panel_11;
	private JLabel label_7;
	private JLabel label_8;
	private JPanel panel_12;
	private JLabel lblInicioDeSesin;
	private JPanel panelLoginUser;
	private JLabel lblDni;
	private JTextField textField_5;
	private JPanel panel_13;
	private JPanel panelLoginPw;
	private JLabel lblContrasea_1;
	private JTextField textField_6;
	private JPanel panel_14;
	private JButton btnEntrarLogin;
	private JPanel panelInicioUser;
	private JPanel panel_15;
	private JLabel lblOpcionesDeUsuario;
	private JPanel panel_16;
	private JLabel label_10;
	private JButton btnCrearUnEnvo;
	private JPanel panel_17;
	private JLabel label_11;
	private JPanel panel_18;
	private JLabel label_12;
	private JPanel panel_19;
	private JLabel label_13;
	private JButton btnConsultarEnvos;
	private JPanel panel_20;
	private JLabel label_14;
	private JPanel panel_21;
	private JPanel panel_22;
	private JLabel label_16;
	private JPanel panel_23;
	private JLabel label_17;
	private JButton btnDesconectar;
	private JPanel panel_24;
	private JPanel panel_25;
	private JLabel lblNewLabel;
	private JPanel panel_26;
	private JPanel panel_27;
	private JPanel panel_28;
	private JLabel lblBienvenido;
	private JLabel label_9;
	private JPanel panelCrearEnvío;
	private JLabel label_3;
	private JPanel panel_29;
	private JLabel lblCrearEnvo;
	private JLabel label_18;
	private JPanel panel_30;
	private JLabel lblDniReceptor;
	private JTextField textField_7;
	private JPanel panel_35;
	private JPanel panel_36;
	private JLabel label_26;
	private JPanel panel_37;
	private JButton btnConfirmar;
	private JLabel label_27;
	private JRadioButton rdbtnRecogidaADomicilio;
	private JRadioButton rdbtnEnvoADomicilio;
	private JPanel panelConsultaEnvios;
	private JPanel panelLista;
	private JPanel panelInfo;
	private JLabel label_15;
	private JLabel label_19;
	private JLabel label_20;
	private JPanel panel_31;
	private JLabel lblListaDeEnvos;
	private JPanel panel_32;
	private JButton btnModificar;
	private JButton btnActualizar;
	private JTable table;
	private JLabel lblListado;
	private JPanel panel_33;
	private JRadioButton rdbtnADomicilio;
	private JRadioButton rdbtnEnAlmacnU;
	private JPanel panelInicioTransportista;
	private JPanel panel_34;
	private JLabel lblOpcionesDeTransportista;
	private JPanel panel_38;
	private JLabel label_23;
	private JPanel panel_39;
	private JLabel label_24;
	private JButton btnListadoDeEnvos;
	private JPanel panel_40;
	private JLabel label_25;
	private JPanel panel_41;
	private JLabel label_28;
	private JPanel panel_42;
	private JLabel label_29;
	private JPanel panel_43;
	private JPanel panel_46;
	private JPanel panel_47;
	private JPanel panel_48;
	private JLabel label_30;
	private JPanel panel_49;
	private JLabel label_31;
	private JLabel label_32;
	private JButton button_3;
	private JPanel panel_50;
	private JLabel label_33;
	private JLabel label_34;
	private JPanel panelConsultaEnviosAsignados;
	private JPanel panel_44;
	private JTable table_1;
	private JLabel lblListadoEnviosAsignados;
	private JPanel panel_45;
	private JLabel label_22;
	private JLabel label_35;
	private JPanel panel_51;
	private JLabel lblNewLabel_1;
	private JPanel panel_52;
	private JButton btnActualizar_1;
	private JPanel panel_53;
	private JPanel panel_56;
	private JPanel panelInicioAdmin;
	private JPanel panel_59;
	private JLabel lblOpcionesDeAdministrador;
	private JPanel panel_60;
	private JLabel label_37;
	private JPanel panel_61;
	private JLabel label_38;
	private JPanel panel_62;
	private JLabel label_39;
	private JPanel panel_63;
	private JLabel label_40;
	private JButton btnListadoVehculos;
	private JPanel panel_64;
	private JLabel label_41;
	private JPanel panel_65;
	private JPanel panel_68;
	private JPanel panel_69;
	private JPanel panel_70;
	private JLabel label_42;
	private JPanel panel_71;
	private JLabel label_43;
	private JLabel label_44;
	private JButton button_4;
	private JPanel panel_72;
	private JLabel lblBienvenidoAdministrador;
	private JPanel panelListadoRegistros;
	private JPanel panel_73;
	private JLabel lblListadoRegistros;
	private JPanel panel_74;
	private JTable table_2;
	private JPanel panel_78;
	private JLabel label_36;
	private JPanel panel_66;
	private JPanel panel_67;
	private JLabel label_45;
	private JButton btnModificarDatosUsuario;
	private JPanel panelCambioDatos;
	private JLabel label_46;
	private JPanel panel_79;
	private JLabel lblCambioDeDatos;
	private JLabel label_48;
	private JPanel panel_80;
	private JLabel label_49;
	private JTextField txtNoEditable;
	private JPanel panel_81;
	private JLabel label_50;
	private JTextField passwordField;
	private JPanel panel_82;
	private JLabel label_51;
	private JTextField textField_9;
	private JPanel panel_83;
	private JLabel label_52;
	private JTextField textField_10;
	private JPanel panel_84;
	private JLabel label_53;
	private JTextField textField_11;
	private JPanel panel_85;
	private JLabel label_54;
	private JComboBox<String> comboBox_1;
	private JLabel label_55;
	private JPanel panel_86;
	private JLabel label_56;
	private JPanel panel_87;
	private JPanel panelFallosEnEnvios;
	private JPanel panel_88;
	private JPanel panel_89;
	private JPanel panel_90;
	private JPanel panel_91;
	private JPanel panel_92;
	private JLabel lblFallosProducidosEn;
	private JTable table_3;
	private JButton btnActualizar_2;
	private JPanel panel_93;
	private JPanel panel_94;
	private JButton btnActualizar_3;
	private JButton btnVolver_1;
	private JPanel panel_95;
	private JLabel label_6;
	private JButton btnVolver_2;
	private JButton btnVolver_3;
	private JLabel label_58;
	private JLabel label_60;
	private JPanel panel_96;
	private JButton btnVolver_4;
	private JLabel label_61;
	private JLabel label_62;
	private JPanel panel_97;
	private JButton btnVolver_5;
	private JPanel panel_98;
	private JLabel label_57;
	private JButton btnVolver_6;
	private JLabel label_63;
	private JPanel panel_100;
	private JButton btnVolver_8;
	private JLabel label_64;
	private JButton btnCrearEnvo;
	private JPanel panelCrearEnvioAdmin;
	private JLabel label_65;
	private JPanel panel_101;
	private JLabel label_66;
	private JPanel panel_102;
	private JLabel label_68;
	private JTextField textField_8;
	private JPanel panel_103;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JPanel panel_104;
	private JLabel label_69;
	private JPanel panel_105;
	private JButton button;
	private JButton button_1;
	private JPanel panel_107;
	private JLabel lblDni_1;
	private JTextField textField_12;
	private JPanel panel_108;
	private JPanel panel_109;
	private JPanel panel_110;
	private JPanel panel_111;
	private JLabel lblProvinciaDestinatario;
	private JLabel lblProvinciaRemitente;
	private JComboBox<String> comboBox_2;
	private JComboBox<String> comboBox_3;
	private JPanel panel_112;
	private JLabel label_67;
	private JLabel label_70;
	private JLabel lblDireccinDestinatario;
	private JLabel lblDireccinRemitente;
	private JTextField textField_13;
	private JTextField textField_14;
	private JPanel panelEntregaPaqueteEnOficina;
	private JPanel panelRecogidaPaqueteEnOficina;
	private JPanel panel_106;
	private JPanel panel_113;
	private JLabel label_71;
	private JTable table_5;
	private JLabel label_72;
	private JLabel label_73;
	private JButton btnMarcarComoEntregado;
	private JPanel panel_115;
	private JLabel label_75;
	private JLabel label_76;
	private JLabel label_77;
	private JButton btnMarcarComoRecogido;
	private JPanel panel_114;
	private JLabel lblPaquetesPendientesDe;
	private JTable table_6;
	private MyTableModel modelEnviosARecoger;
	private MyTableModel modelEnviosAEntregar;
	private JButton btnActualizar_5;
	private JButton btnActualizar_6;
	private JLabel label_78;
	private JPanel panel_116;
	private JLabel label_79;
	private JButton btnMarcarRecogidos;
	private JLabel label_80;
	private JPanel panel_117;
	private JLabel label_81;
	private JButton btnMarcarEntregados;
	private JPanel panelRegistroDejadaYRecogidaPaquetes;
	private JPanel panel_54;
	private JPanel panel_55;
	private JPanel panel_57;
	private JLabel lblRegistroEntregaDe;
	private JLabel lblRegistroRecogidaPaquetes;
	private JPanel panel_58;
	private JPanel panel_118;
	private JLabel lblLugarDeEntrega;
	private JTextField textField_15;
	private JTable table_7;
	private JPanel panel_119;
	private JButton btnNewButton;
	private JTable table_8;
	private JPanel panel_120;
	private JPanel panel_121;
	private JButton btnVolver_9;
	private JButton btnRegistrarComoRecogidos;
	private MyTableModel modelRegistrarEntregados;
	private MyTableModel modelRegistrarRecogidos;
	private JPanel panel_122;
	private JLabel lblProvinciaDestinatario_1;
	private JComboBox<String> comboBox_4;
	private JPanel panel_123;
	private JLabel label_47;
	private JTextField textField_16;
	private JButton btnRegistrarCambiosEnvios;
	private JButton btnActualizar_7;
	private JButton btnActualizar_8;
	private JPanel panelEnvioProvinciaReceptor;
	private JPanel panel_124;
	private JLabel label_59;
	private JPanel panel_125;
	private JLabel label_74;
	private JTextField textField_17;
	private JLabel lblPedidosPendientesDe;
	private JTable table_9;
	private JPanel panel_126;
	private JButton btnEnviarAProvincia;
	private JButton btnVolver_10;
	private MyTableModel modelPedidosEntreProvincias;
	private JButton btnEnvioEntreProvincias;
	private JButton btnVolver;
	private JPanel panel_75;
	private JPanel panel_76;
	private JLabel label_82;
	private JButton btnVolver_11;
	private JPanel panel_77;
	private JPanel panel_127;
	private JLabel label_83;
	private JButton btnVolver_12;
	private JPanel panelRegistroFallo;
	private JLabel label_84;
	private JPanel panel_128;
	private JLabel lblRegistroDeFallos;
	private JPanel panel_129;
	private JPanel panel_130;
	private JPanel panel_131;
	private JLabel lblIdDelEnvo;
	private JLabel lblMotivoDelFallo;
	private JTextField textField_18;
	private JTextField textField_19;
	private JButton btnConfirmar_1;
	private JLabel label_85;
	private JLabel label_86;
	private JPanel panel_132;
	private JLabel label_87;
	private JLabel label_88;
	private JPanel panel_133;
	private JLabel label_89;
	private JLabel label_90;
	private JButton btnVolver_13;
	private JLabel label_91;
	private JButton btnRegistrarFallo;
	private JLabel label_92;
	private JPanel panel_134;
	private JLabel label_93;
	private JButton button_2;
	private JPanel panel_99;
	private JButton btnActualizar_4;
	private JPanel panelEntregasProgramadas;
	private JLabel lblEntregasProgramadas;
	private JPanel panel_136;
	private JPanel panel_137;
	private JTable table_10;
	private JButton btnActualizar_9;
	private JButton btnVolver_7;
	private MyTableModel modelEntregasProgramadas;
	private JLabel label_94;
	private JPanel panel_135;
	private JLabel label_95;
	private JButton btnEnvosProgramados;
	private JPanel panel_138;
	private JLabel label_21;
	private JPanel panel_139;
	private JLabel lblNuevaEntregaA;
	private JTextField textField_20;
	private JButton btnModificarDatos;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public VentanaPrincipal() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getPanelInicioEntrada(), "panelInicio");
		contentPane.add(getPanelRegistro(), "panelRegistro");
		contentPane.add(getPanelLogin(), "panelLogin");
		contentPane.add(getPanelInicioUser(), "panelInicioUser");
		contentPane.add(getPanelCrearEnvío(), "panelCrearEnvio");
		contentPane.add(getPanelConsultaEnvios(), "panelConsultaEnvios");
		contentPane.add(getPanelInicioTransportista(), "panelInicioTransportista");
		contentPane.add(getPanelConsultaEnviosAsignados(), "panelConsultaEnviosAsignados");
		contentPane.add(getPanelInicioAdmin(), "panelInicioAdmin");
		contentPane.add(getPanelListadoRegistros(), "panelListadoRegistros");
		contentPane.add(getPanelCambioDatos(), "panelCambioDatos");
		contentPane.add(getPanelFallosEnEnvios(), "panelFallosEnvios");
		contentPane.add(getPanelCrearEnvioAdmin(), "panelCrearEnvioAdmin");
		contentPane.add(getPanelEntregaPaqueteEnOficina(), "panelEntregaPaqueteEnOficina");
		contentPane.add(getPanelRecogidaPaqueteEnOficina(), "panelRecogidaPaqueteEnOficina");
		contentPane.add(getPanelRegistroDejadaYRecogidaPaquetes(), "panelRegistroDejadaYRecogidaPaquetes");
		contentPane.add(getPanelEnvioProvinciaReceptor(), "panelEnvioProvinciaReceptor");
		contentPane.add(getPanelRegistroFallo(), "panelRegistroFallo");
		contentPane.add(getPanelEntregasProgramadas(), "panelEntregasProgramadas");
	}
	private JLabel getLblAplicacinDeEntrega() {
		if (lblAplicacinDeEntrega == null) {
			lblAplicacinDeEntrega = new JLabel("Aplicaci\u00F3n de env\u00EDos");
			lblAplicacinDeEntrega.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		}
		return lblAplicacinDeEntrega;
	}
	private JButton getBtnIniciarSesin() {
		if (btnIniciarSesin == null) {
			btnIniciarSesin = new JButton("Iniciar Sesi\u00F3n");
			btnIniciarSesin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelLogin");
				}
			});
		}
		return btnIniciarSesin;
	}
	private JButton getBtnRegistrarse() {
		if (btnRegistrarse == null) {
			btnRegistrarse = new JButton("Registrarse");
			btnRegistrarse.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelRegistro");
				}
			});
		}
		return btnRegistrarse;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel(new ImageIcon("/IMG/CartelInicial.png"));
			label = new JLabel();
		}
		return label;
	}
	private JPanel getPanelInicioEntrada() {
		if (panelInicioEntrada == null) {
			panelInicioEntrada = new JPanel();
			panelInicioEntrada.setLayout(new BorderLayout(0, 0));
			panelInicioEntrada.add(getPanel_3(), BorderLayout.SOUTH);
			panelInicioEntrada.add(getPanel_4());
		}
		return panelInicioEntrada;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setLayout(new BorderLayout(0, 0));
			panel_3.add(getLblAplicacinDeEntrega(), BorderLayout.CENTER);
			panel_3.add(getPanel_5(), BorderLayout.EAST);
		}
		return panel_3;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setLayout(new BorderLayout(0, 0));
			panel_4.add(getLabel(), BorderLayout.NORTH);
		}
		return panel_4;
	}
	private JPanel getPanel_5() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(0, 2, 4, 0));
			panel.add(getBtnIniciarSesin());
			panel.add(getBtnRegistrarse());
		}
		return panel;
	}
	private JPanel getPanelRegistro() {
		if (panelRegistro == null) {
			panelRegistro = new JPanel();
			panelRegistro.setLayout(new GridLayout(0, 3, 0, 0));
			panelRegistro.add(getLabel_1());
			panelRegistro.add(getPanel_1());
		}
		return panelRegistro;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(10, 0, 0, 0));
			panel_1.add(getLblRegistro());
			panel_1.add(getLabel_2());
			panel_1.add(getPanelNombre());
			panel_1.add(getPanel_2());
			panel_1.add(getPanel_5_1());
			panel_1.add(getPanel_6());
			panel_1.add(getPanel_7());
			panel_1.add(getPanel_8());
			panel_1.add(getLabel_3_1());
			panel_1.add(getPanel_9());
		}
		return panel_1;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel("");
		}
		return label_1;
	}
	private JLabel getLblRegistro() {
		if (lblRegistro == null) {
			lblRegistro = new JLabel("Registro");
			lblRegistro.setHorizontalAlignment(SwingConstants.CENTER);
			lblRegistro.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		}
		return lblRegistro;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel("");
		}
		return label_2;
	}
	private JPanel getPanelNombre() {
		if (panelNombre == null) {
			panelNombre = new JPanel();
			panelNombre.setLayout(null);
			panelNombre.add(getLblNombre());
			panelNombre.add(getTextField());
		}
		return panelNombre;
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("DNI: ");
			lblNombre.setBounds(10, 15, 159, 22);
		}
		return lblNombre;
	}
	private JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(89, 15, 220, 22);
			textField.setColumns(10);
		}
		return textField;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.add(getLblContrasea());
			panel_2.add(getTextField_1());
		}
		return panel_2;
	}
	private JLabel getLblContrasea() {
		if (lblContrasea == null) {
			lblContrasea = new JLabel("Contrase\u00F1a: ");
			lblContrasea.setBounds(10, 15, 159, 22);
		}
		return lblContrasea;
	}
	private JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JPasswordField();
			textField_1.setColumns(10);
			textField_1.setBounds(89, 15, 220, 22);
		}
		return textField_1;
	}
	private JPanel getPanel_5_1() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setLayout(null);
			panel_5.add(getLabel_4());
			panel_5.add(getTextField_2());
		}
		return panel_5;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel("Nombre: ");
			label_4.setBounds(10, 15, 159, 22);
		}
		return label_4;
	}
	private JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(89, 15, 220, 22);
		}
		return textField_2;
	}
	private JPanel getPanel_6() {
		if (panel_6 == null) {
			panel_6 = new JPanel();
			panel_6.setLayout(null);
			panel_6.add(getLblApellidos());
			panel_6.add(getTextField_3());
		}
		return panel_6;
	}
	private JLabel getLblApellidos() {
		if (lblApellidos == null) {
			lblApellidos = new JLabel("Apellidos(*): ");
			lblApellidos.setBounds(10, 15, 159, 22);
		}
		return lblApellidos;
	}
	private JTextField getTextField_3() {
		if (textField_3 == null) {
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(89, 15, 220, 22);
		}
		return textField_3;
	}
	private JPanel getPanel_7() {
		if (panel_7 == null) {
			panel_7 = new JPanel();
			panel_7.setLayout(null);
			panel_7.add(getLblDireccin());
			panel_7.add(getTextField_4());
		}
		return panel_7;
	}
	private JLabel getLblDireccin() {
		if (lblDireccin == null) {
			lblDireccin = new JLabel("Direcci\u00F3n: ");
			lblDireccin.setBounds(10, 15, 159, 22);
		}
		return lblDireccin;
	}
	private JTextField getTextField_4() {
		if (textField_4 == null) {
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(89, 15, 220, 22);
		}
		return textField_4;
	}
	private JPanel getPanel_8() {
		if (panel_8 == null) {
			panel_8 = new JPanel();
			panel_8.setLayout(null);
			panel_8.add(getLblProvincia());
			panel_8.add(getComboBox());
		}
		return panel_8;
	}
	private JLabel getLblProvincia() {
		if (lblProvincia == null) {
			lblProvincia = new JLabel("Provincia: ");
			lblProvincia.setBounds(10, 15, 159, 22);
		}
		return lblProvincia;
	}
	private JComboBox<String> getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox<String>();
			comboBox.setBounds(89, 16, 220, 20);
			comboBox.addItem("Álava");
			comboBox.addItem("Albacete");
			comboBox.addItem("Alicante");
			comboBox.addItem("Almería");
			comboBox.addItem("Asturias");
			comboBox.addItem("Ávila");
			comboBox.addItem("Badajoz");
			comboBox.addItem("Barcelona");
			comboBox.addItem("Burgos");
			comboBox.addItem("Cáceres");
			comboBox.addItem("Cádiz");
			comboBox.addItem("Cantabria");
			comboBox.addItem("Castellón");
			comboBox.addItem("Ciudad Real");
			comboBox.addItem("Córdoba");
			comboBox.addItem("Cuenca");
			comboBox.addItem("Girona");
			comboBox.addItem("Granada");
			comboBox.addItem("Guadalajara");
			comboBox.addItem("Guipúzcoa");
			comboBox.addItem("Huelva");
			comboBox.addItem("Huesca");
			comboBox.addItem("Islas Baleares");
			comboBox.addItem("Jaén");
			comboBox.addItem("La Coruña");
			comboBox.addItem("La Rioja");
			comboBox.addItem("Las Palmas");
			comboBox.addItem("León");
			comboBox.addItem("Lérida");
			comboBox.addItem("Lugo");
			comboBox.addItem("Madrid");
			comboBox.addItem("Málaga");
			comboBox.addItem("Murcia");
			comboBox.addItem("Navarra");
			comboBox.addItem("Orense");
			comboBox.addItem("Palencia");
			comboBox.addItem("Pontevedra");
			comboBox.addItem("Salamanca");
			comboBox.addItem("Segovia");
			comboBox.addItem("Sevilla");
			comboBox.addItem("Soria");
			comboBox.addItem("Tarragona");
			comboBox.addItem("Tenerife");
			comboBox.addItem("Teruel");
			comboBox.addItem("Toledo");
			comboBox.addItem("Valencia");
			comboBox.addItem("Valladolid");
			comboBox.addItem("Vizcaya");
			comboBox.addItem("Zamora");
			comboBox.addItem("Zaragoza");
		}
		return comboBox;
	}
	private JLabel getLabel_3_1() {
		if (lblCampoNo == null) {
			lblCampoNo = new JLabel("   (*): campo no obligatorio");
			lblCampoNo.setVerticalAlignment(SwingConstants.BOTTOM);
		}
		return lblCampoNo;
	}
	private JPanel getPanel_9() {
		if (panel_9 == null) {
			panel_9 = new JPanel();
			panel_9.setLayout(new GridLayout(0, 3, 0, 0));
			panel_9.add(getLabel_5());
			panel_9.add(getPanel_10());
			panel_9.add(getPanel_95());
		}
		return panel_9;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel("");
		}
		return label_5;
	}
	private JPanel getPanel_10() {
		if (panel_10 == null) {
			panel_10 = new JPanel();
			panel_10.add(getBtnRegistrarse_1());
		}
		return panel_10;
	}
	private JButton getBtnRegistrarse_1() {
		if (btnRegistrarse_1 == null) {
			btnRegistrarse_1 = new JButton("Registrarse");
			btnRegistrarse_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String dniUsuario = textField.getText();
					String contrasenna = textField_1.getText();
					String direccion = textField_4.getText();
					boolean capitalLetter = false;
					boolean minimalLetter = false;
					boolean number = false;
					for(char ch : contrasenna.toCharArray()) {
						if(Character.isUpperCase(ch)) {
							capitalLetter = true;
						}
						if(Character.isLowerCase(ch)) {
							minimalLetter = true;
						}
						if(Character.isDigit(ch)) {
							number = true;
						}
					}
					if(dniUsuario.length()!=9)  {
						JOptionPane.showMessageDialog(null,
								"La longitud del DNI debe ser de 9 caracteres.");
					}
					else if(textField_2.getText().length()<1) {
						JOptionPane.showMessageDialog(null,
								"Debe introducir al menos el nombre.");
					}
					else if(Character.isLetter(dniUsuario.charAt(8))==false) {
						JOptionPane.showMessageDialog(null,
								"El DNI debe contener una letra al final.");
					}
					else if(contrasenna.length()<5) {
						JOptionPane.showMessageDialog(null,
								"La contraseña debe de tener longitud 5 o más.");
					}
					else if(!capitalLetter && !minimalLetter && !number) {
						JOptionPane.showMessageDialog(null,
								"La contraseña debe poseer como mínimo una letra mayúscula, minúscula y un número.");
					}
					else if(direccion.length()<2) {
						JOptionPane.showMessageDialog(null,
								"La dirección debe de ser válida.");
					}
					else {
						char letraMayuscula = (dniUsuario.substring(8).toUpperCase()).charAt(0);
						boolean letraFinal = false;
						int size = dniUsuario.length();
						int contador = 0;
						int contadorNumeros = 0;
						for(char ch : dniUsuario.toCharArray()) {
							contador++;
							if(size!=contador) {
								if(Character.isDigit(ch)) {
									contadorNumeros++;
								}
							}
							else {
								if(ch == letraMayuscula)
									letraFinal = true;
							}
						}
						if(contadorNumeros!=8 && !letraFinal) {
							JOptionPane.showMessageDialog(null,
									"La estructura del DNI es incorrecta, deben ser 8 números y letra mayuscula al final.");
						}
						else {
							try {
								boolean yaExistePorCliente = DatabaseManager.existeClientePorDNI(dniUsuario);
								boolean yaExistePorTransportista = DatabaseManager.existeTransportistaPorDNI(dniUsuario);
								if(yaExistePorCliente || yaExistePorTransportista) {
									JOptionPane.showMessageDialog(null,
											"Ya existe un usuario con ese DNI.");
								}
								else {
									DatabaseManager.registroCliente(dniUsuario, textField_2.getText(), textField_3.getText(), contrasenna, direccion, comboBox.getSelectedItem().toString());
									
									clienteActual = DatabaseManager.checkLoginCliente(dniUsuario, contrasenna);
									
									CardLayout card = (CardLayout) contentPane.getLayout();
									card.show(contentPane, "panelInicioUser");
								}
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			});
		}
		return btnRegistrarse_1;
	}
	private JPanel getPanelLogin() {
		if (panelLogin == null) {
			panelLogin = new JPanel();
			panelLogin.setLayout(new GridLayout(0, 3, 0, 0));
			panelLogin.add(getLabel_7());
			panelLogin.add(getPanel_11());
		}
		return panelLogin;
	}
	private JPanel getPanel_11() {
		if (panel_11 == null) {
			panel_11 = new JPanel();
			panel_11.setLayout(new GridLayout(3, 0, 0, -400));
			panel_11.add(getLabel_8());
			panel_11.add(getPanel_12());
			panel_11.add(getPanel_13());
		}
		return panel_11;
	}
	private JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel("");
		}
		return label_7;
	}
	private JLabel getLabel_8() {
		if (label_8 == null) {
			label_8 = new JLabel("");
		}
		return label_8;
	}
	private JPanel getPanel_12() {
		if (panel_12 == null) {
			panel_12 = new JPanel();
			panel_12.setLayout(new GridLayout(4, 0, 0, 0));
			panel_12.add(getLblInicioDeSesin());
			panel_12.add(getPanelLoginUser());
			panel_12.add(getPanelLoginPw());
			panel_12.add(getPanel_14());
		}
		return panel_12;
	}
	private JLabel getLblInicioDeSesin() {
		if (lblInicioDeSesin == null) {
			lblInicioDeSesin = new JLabel("Inicio de sesi\u00F3n:");
			lblInicioDeSesin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		}
		return lblInicioDeSesin;
	}
	private JPanel getPanelLoginUser() {
		if (panelLoginUser == null) {
			panelLoginUser = new JPanel();
			panelLoginUser.setLayout(null);
			panelLoginUser.add(getLblDni());
			panelLoginUser.add(getTextField_5());
		}
		return panelLoginUser;
	}
	private JLabel getLblDni() {
		if (lblDni == null) {
			lblDni = new JLabel("DNI:");
			lblDni.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
			lblDni.setBounds(10, 47, 68, 30);
		}
		return lblDni;
	}
	private JTextField getTextField_5() {
		if (textField_5 == null) {
			textField_5 = new JTextField();
			textField_5.setBounds(143, 47, 166, 30);
			textField_5.setColumns(10);
		}
		return textField_5;
	}
	private JPanel getPanel_13() {
		if (panel_13 == null) {
			panel_13 = new JPanel();
			panel_13.setLayout(null);
			panel_13.add(getBtnVolver_3());
		}
		return panel_13;
	}
	private JPanel getPanelLoginPw() {
		if (panelLoginPw == null) {
			panelLoginPw = new JPanel();
			panelLoginPw.setLayout(null);
			panelLoginPw.add(getLblContrasea_1());
			panelLoginPw.add(getTextField_6());
		}
		return panelLoginPw;
	}
	private JLabel getLblContrasea_1() {
		if (lblContrasea_1 == null) {
			lblContrasea_1 = new JLabel("Contrase\u00F1a:");
			lblContrasea_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
			lblContrasea_1.setBounds(10, 38, 123, 36);
		}
		return lblContrasea_1;
	}
	private JTextField getTextField_6() {
		if (textField_6 == null) {
			textField_6 = new JPasswordField();
			textField_6.setBounds(143, 44, 166, 30);
			textField_6.setColumns(10);
		}
		return textField_6;
	}
	private JPanel getPanel_14() {
		if (panel_14 == null) {
			panel_14 = new JPanel();
			panel_14.setLayout(null);
			panel_14.add(getBtnEntrarLogin());
		}
		return panel_14;
	}
	private JButton getBtnEntrarLogin() {
		if (btnEntrarLogin == null) {
			btnEntrarLogin = new JButton("Entrar");
			btnEntrarLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						clienteActual = DatabaseManager.checkLoginCliente(textField_5.getText(), textField_6.getText());
						transportistaActual = DatabaseManager.checkLoginTransportista(textField_5.getText(), textField_6.getText());
						if(clienteActual!=null) {
							//abre el panel de inicio
							CardLayout card = (CardLayout) contentPane.getLayout();
							card.show(contentPane, "panelInicioUser");
							textField_5.setText("");
							textField_6.setText("");
						}
						else if(transportistaActual!=null) {
							CardLayout card = (CardLayout) contentPane.getLayout();
							card.show(contentPane, "panelInicioTransportista");
							textField_5.setText("");
							textField_6.setText("");
						}
						else if(textField_5.getText().equals("SA") && textField_6.getText().equals("SA")) {
							CardLayout card = (CardLayout) contentPane.getLayout();
							card.show(contentPane, "panelInicioAdmin");
							textField_5.setText("");
							textField_6.setText("");
						}
						else {
							JOptionPane.showMessageDialog(null,
									"El usuario no existe o es incorrecto.");
							textField_5.setText("");
							textField_6.setText("");
						}
					} catch (SQLException e1) {

						e1.printStackTrace();
					}
				}
			});
			btnEntrarLogin.setBounds(106, 40, 106, 32);
		}
		return btnEntrarLogin;
	}
	private JPanel getPanelInicioUser() {
		if (panelInicioUser == null) {
			panelInicioUser = new JPanel();
			panelInicioUser.setLayout(new BorderLayout(0, 0));
			panelInicioUser.add(getPanel_15(), BorderLayout.EAST);
			panelInicioUser.add(getPanel_28(), BorderLayout.CENTER);
		}
		return panelInicioUser;
	}
	private JPanel getPanel_15() {
		if (panel_15 == null) {
			panel_15 = new JPanel();
			panel_15.setLayout(new GridLayout(7, 0, 0, 0));
			panel_15.add(getLblOpcionesDeUsuario());
			panel_15.add(getPanel_16());
			panel_15.add(getPanel_18());
			panel_15.add(getPanel_20());
			panel_15.add(getPanel_24());
			panel_15.add(getPanel_25());
			panel_15.add(getPanel_22());
		}
		return panel_15;
	}
	private JLabel getLblOpcionesDeUsuario() {
		if (lblOpcionesDeUsuario == null) {
			lblOpcionesDeUsuario = new JLabel("Opciones de usuario:                   ");
			lblOpcionesDeUsuario.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		}
		return lblOpcionesDeUsuario;
	}
	private JPanel getPanel_16() {
		if (panel_16 == null) {
			panel_16 = new JPanel();
			panel_16.setBackground(Color.WHITE);
			panel_16.setLayout(new GridLayout(3, 0, 0, 0));
			panel_16.add(getLabel_10());
			panel_16.add(getPanel_17());
		}
		return panel_16;
	}
	private JLabel getLabel_10() {
		if (label_10 == null) {
			label_10 = new JLabel("");
			label_10.setBackground(Color.WHITE);
		}
		return label_10;
	}
	private JButton getBtnCrearUnEnvo() {
		if (btnCrearUnEnvo == null) {
			btnCrearUnEnvo = new JButton("Crear un env\u00EDo");
			btnCrearUnEnvo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelCrearEnvio");
				}
			});
		}
		return btnCrearUnEnvo;
	}
	private JPanel getPanel_17() {
		if (panel_17 == null) {
			panel_17 = new JPanel();
			panel_17.setBackground(Color.WHITE);
			panel_17.setLayout(new GridLayout(0, 3, 0, 0));
			panel_17.add(getLabel_11());
			panel_17.add(getBtnCrearUnEnvo());
		}
		return panel_17;
	}
	private JLabel getLabel_11() {
		if (label_11 == null) {
			label_11 = new JLabel("");
			label_11.setForeground(Color.WHITE);
			label_11.setBackground(Color.WHITE);
		}
		return label_11;
	}
	private JPanel getPanel_18() {
		if (panel_18 == null) {
			panel_18 = new JPanel();
			panel_18.setBackground(Color.WHITE);
			panel_18.setLayout(new GridLayout(3, 0, 0, 0));
			panel_18.add(getLabel_12());
			panel_18.add(getPanel_19());
		}
		return panel_18;
	}
	private JLabel getLabel_12() {
		if (label_12 == null) {
			label_12 = new JLabel("");
			label_12.setBackground(Color.WHITE);
		}
		return label_12;
	}
	private JPanel getPanel_19() {
		if (panel_19 == null) {
			panel_19 = new JPanel();
			panel_19.setBackground(Color.WHITE);
			panel_19.setLayout(new GridLayout(0, 3, 0, 0));
			panel_19.add(getLabel_13());
			panel_19.add(getBtnConsultarEnvos());
		}
		return panel_19;
	}
	private JLabel getLabel_13() {
		if (label_13 == null) {
			label_13 = new JLabel("");
			label_13.setForeground(Color.WHITE);
			label_13.setBackground(Color.WHITE);
		}
		return label_13;
	}
	private JButton getBtnConsultarEnvos() {
		if (btnConsultarEnvos == null) {
			btnConsultarEnvos = new JButton("Consultar env\u00EDos");
			btnConsultarEnvos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelConsultaEnvios");
				}
			});
		}
		return btnConsultarEnvos;
	}
	private JPanel getPanel_20() {
		if (panel_20 == null) {
			panel_20 = new JPanel();
			panel_20.setBackground(Color.WHITE);
			panel_20.setLayout(new GridLayout(3, 0, 0, 0));
			panel_20.add(getLabel_14());
			panel_20.add(getPanel_21());
		}
		return panel_20;
	}
	private JLabel getLabel_14() {
		if (label_14 == null) {
			label_14 = new JLabel("");
			label_14.setBackground(Color.WHITE);
		}
		return label_14;
	}
	private JPanel getPanel_21() {
		if (panel_21 == null) {
			panel_21 = new JPanel();
			panel_21.setLayout(new GridLayout(0, 3, 0, 0));
			panel_21.add(getPanel_26());
			panel_21.add(getButton_2_1());
			panel_21.add(getPanel_27());
		}
		return panel_21;
	}
	private JPanel getPanel_22() {
		if (panel_22 == null) {
			panel_22 = new JPanel();
			panel_22.setBackground(Color.WHITE);
			panel_22.setLayout(new GridLayout(3, 0, 0, 0));
			panel_22.add(getLabel_16());
			panel_22.add(getPanel_23());
		}
		return panel_22;
	}
	private JLabel getLabel_16() {
		if (label_16 == null) {
			label_16 = new JLabel("");
			label_16.setBackground(Color.WHITE);
		}
		return label_16;
	}
	private JPanel getPanel_23() {
		if (panel_23 == null) {
			panel_23 = new JPanel();
			panel_23.setBackground(Color.WHITE);
			panel_23.setLayout(new GridLayout(0, 3, 0, 0));
			panel_23.add(getLabel_17());
			panel_23.add(getLblNewLabel());
			panel_23.add(getBtnDesconectar());
		}
		return panel_23;
	}
	private JLabel getLabel_17() {
		if (label_17 == null) {
			label_17 = new JLabel("");
			label_17.setForeground(Color.WHITE);
			label_17.setBackground(Color.WHITE);
		}
		return label_17;
	}
	private JButton getBtnDesconectar() {
		if (btnDesconectar == null) {
			btnDesconectar = new JButton("Desconectar");
			btnDesconectar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelInicio");
					clienteActual = null;
				}
			});
		}
		return btnDesconectar;
	}
	private JPanel getPanel_24() {
		if (panel_24 == null) {
			panel_24 = new JPanel();
			panel_24.setBackground(Color.WHITE);
			panel_24.setLayout(new GridLayout(3, 0, 0, 0));
			panel_24.add(getPanel_66());
			panel_24.add(getPanel_67());
		}
		return panel_24;
	}
	private JPanel getPanel_25() {
		if (panel_25 == null) {
			panel_25 = new JPanel();
			panel_25.setBackground(Color.WHITE);
			panel_25.setLayout(new GridLayout(3, 0, 0, 0));
			panel_25.add(getLabel_92());
			panel_25.add(getPanel_134());
		}
		return panel_25;
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("");
		}
		return lblNewLabel;
	}
	private JPanel getPanel_26() {
		if (panel_26 == null) {
			panel_26 = new JPanel();
			panel_26.setBackground(Color.WHITE);
		}
		return panel_26;
	}
	private JPanel getPanel_27() {
		if (panel_27 == null) {
			panel_27 = new JPanel();
			panel_27.setBackground(Color.WHITE);
		}
		return panel_27;
	}
	private JPanel getPanel_28() {
		if (panel_28 == null) {
			panel_28 = new JPanel();
			panel_28.setLayout(new BorderLayout(0, 0));
			panel_28.add(getLabel_9_1(), BorderLayout.NORTH);
			panel_28.add(getLabel_9_2(), BorderLayout.CENTER);
		}
		return panel_28;
	}
	private JLabel getLabel_9_1() {
		if (lblBienvenido == null) {
			lblBienvenido = new JLabel("Bienvenido");
			if(clienteActual != null) {
				lblBienvenido = new JLabel("Bienvenido " + clienteActual.getNombre());
			}
			lblBienvenido.setFont(new Font("Tahoma", Font.ITALIC, 18));
		}
		return lblBienvenido;
	}
	private JLabel getLabel_9_2() {
		if (label_9 == null) {
			label_9 = new JLabel("");
		}
		return label_9;
	}
	private JPanel getPanelCrearEnvío() {
		if (panelCrearEnvío == null) {
			panelCrearEnvío = new JPanel();
			panelCrearEnvío.setLayout(new GridLayout(0, 3, 0, 0));
			panelCrearEnvío.add(getLabel_3());
			panelCrearEnvío.add(getPanel_29());
		}
		return panelCrearEnvío;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel("");
		}
		return label_3;
	}
	private JPanel getPanel_29() {
		if (panel_29 == null) {
			panel_29 = new JPanel();
			panel_29.setLayout(new GridLayout(10, 0, 0, 0));
			panel_29.add(getLblCrearEnvo());
			panel_29.add(getLabel_18());
			panel_29.add(getPanel_30());
			panel_29.add(getPanel_122());
			panel_29.add(getPanel_35());
			panel_29.add(getPanel_123());
			panel_29.add(getPanel_36());
			panel_29.add(getLabel_58());
			panel_29.add(getLabel_60());
			panel_29.add(getPanel_96());
		}
		return panel_29;
	}
	private JLabel getLblCrearEnvo() {
		if (lblCrearEnvo == null) {
			lblCrearEnvo = new JLabel("Crear env\u00EDo");
			lblCrearEnvo.setHorizontalAlignment(SwingConstants.CENTER);
			lblCrearEnvo.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		}
		return lblCrearEnvo;
	}
	private JLabel getLabel_18() {
		if (label_18 == null) {
			label_18 = new JLabel("");
		}
		return label_18;
	}
	private JPanel getPanel_30() {
		if (panel_30 == null) {
			panel_30 = new JPanel();
			panel_30.setLayout(null);
			panel_30.add(getLblDniReceptor());
			panel_30.add(getTextField_7());
		}
		return panel_30;
	}
	private JLabel getLblDniReceptor() {
		if (lblDniReceptor == null) {
			lblDniReceptor = new JLabel("DNI destinatario: ");
			lblDniReceptor.setBounds(10, 15, 159, 22);
		}
		return lblDniReceptor;
	}
	private JTextField getTextField_7() {
		if (textField_7 == null) {
			textField_7 = new JTextField();
			textField_7.setColumns(10);
			textField_7.setBounds(106, 15, 203, 22);
		}
		return textField_7;
	}
	private JPanel getPanel_35() {
		if (panel_35 == null) {
			panel_35 = new JPanel();
			panel_35.setLayout(null);
			panel_35.add(getRdbtnRecogidaADomicilio());
			panel_35.add(getRdbtnEnvoADomicilio());
		}
		return panel_35;
	}
	private JPanel getPanel_36() {
		if (panel_36 == null) {
			panel_36 = new JPanel();
			panel_36.setLayout(new GridLayout(0, 3, 0, 0));
			panel_36.add(getLabel_26());
			panel_36.add(getPanel_37());
			panel_36.add(getLabel_27());
		}
		return panel_36;
	}
	private JLabel getLabel_26() {
		if (label_26 == null) {
			label_26 = new JLabel("");
		}
		return label_26;
	}
	private JPanel getPanel_37() {
		if (panel_37 == null) {
			panel_37 = new JPanel();
			panel_37.add(getBtnConfirmar());
		}
		return panel_37;
	}
	private JButton getBtnConfirmar() {
		if (btnConfirmar == null) {
			btnConfirmar = new JButton("Confirmar");
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String dniIntroducido = textField_7.getText();
					try {						
						Envio envio = null;

						//SI EL ENVIO Y LA RECOGIDA ES A DOMICILIO NO HACE FALTA ASIGNAR UN EDIFICIO
						if(rdbtnEnvoADomicilio.isSelected() && rdbtnRecogidaADomicilio.isSelected()) {
							
							List<Transportista> temisor = DatabaseManager.getTransportistasProvincia(clienteActual.getProvincia());
							List<Vehiculo> vemisor = DatabaseManager.getVehiculosDeProvincia(clienteActual.getProvincia());
							List<Transportista> treceptor = DatabaseManager.getTransportistasProvincia((String)comboBox_4.getSelectedItem());
							DatabaseManager.getVehiculosDeProvincia((String)comboBox_4.getSelectedItem());
							if(temisor.size()==0) {
								JOptionPane.showMessageDialog(null,
										"No hay transportistas para la provincia del emisor disponibles.");
							}
							else if(vemisor.size()==0) {
								JOptionPane.showMessageDialog(null,
										"No hay vehiculos de transporte para la provincia del emisor.");
							}
							else if(treceptor.size()==0) {
								JOptionPane.showMessageDialog(null,
										"No hay transportistas para la provincia del receptor disponibles.");
							}
							else if(vemisor.size()==0) {
								JOptionPane.showMessageDialog(null,
										"No hay vehiculos de transporte para la provincia del receptor.");
							}
							else {
								
								int posRandom = ThreadLocalRandom.current().nextInt(0, temisor.size());
								Transportista transE = temisor.get(posRandom);
								int posRandomOne = ThreadLocalRandom.current().nextInt(0, vemisor.size());
								Vehiculo vehE = vemisor.get(posRandomOne);
//									int posRandomDos = ThreadLocalRandom.current().nextInt(0, treceptor.size());		SOLO CALCULAMOS EL EMISOR, EL V Y T DEL RECEPTOR SE CALCULA CDO LLEGUE AL ALMACÉN
//									Transportista transR = treceptor.get(posRandomDos);
//									int posRandomTres = ThreadLocalRandom.current().nextInt(0, vreceptor.size());
//									Vehiculo vehR = vreceptor.get(posRandomTres);
								envio = new Envio(rdbtnRecogidaADomicilio.isSelected(), rdbtnEnvoADomicilio.isSelected(), dniIntroducido, clienteActual.getDni(),
										transE.getDNI(), vehE.getMatricula(), (String)comboBox_4.getSelectedItem(), clienteActual.getProvincia(), textField_16.getText(), clienteActual.getDireccion(),
										"Recogida a domicilio", clienteActual.getDireccion());
								envio.calculaPrecio();
								DatabaseManager.registraEnvio(envio);
								JOptionPane.showMessageDialog(null,
										"Se ha creado el envío correctamente, el precio del envío es de: " + envio.getPrecio() + "€.");
								CardLayout card = (CardLayout) contentPane.getLayout();
								card.show(contentPane, "panelInicioUser");
								//ahora hacemos los cambios en el transportista
								//buscamos edificio
								//le asignamos la ruta inicial
							}
						}
						//si solo EL ENVIO (RECEPTOR) es a domicilio
						else if(rdbtnEnvoADomicilio.isSelected() && !rdbtnRecogidaADomicilio.isSelected()) {
							DatabaseManager.getTransportistasProvincia(clienteActual.getProvincia());
							DatabaseManager.getVehiculosDeProvincia(clienteActual.getProvincia());
							List<Transportista> treceptor = DatabaseManager.getTransportistasProvincia((String)comboBox_4.getSelectedItem());
							List<Vehiculo> vreceptor = DatabaseManager.getVehiculosDeProvincia((String)comboBox_4.getSelectedItem());
							if(treceptor.size()==0) {
								JOptionPane.showMessageDialog(null,
										"No hay transportistas para la provincia del receptor.");
							}
							else if(vreceptor.size()==0) {
								JOptionPane.showMessageDialog(null,
										"No hay vehiculos de transporte para la provincia del receptor.");
							}
							else {
								//edificio de la provincia del emisor

								//el transportista se calculará cdo el paquete esté en la otra comunidad
//								int posRandom = ThreadLocalRandom.current().nextInt(0, temisor.size());
//								Transportista transE = temisor.get(posRandom);
//								int posRandomOne = ThreadLocalRandom.current().nextInt(0, vemisor.size());
//								Vehiculo vehE = vreceptor.get(posRandomOne);
								envio = new Envio(rdbtnRecogidaADomicilio.isSelected(), rdbtnEnvoADomicilio.isSelected(), dniIntroducido, clienteActual.getDni(),
										"", "", (String)comboBox_4.getSelectedItem(), clienteActual.getProvincia(),textField_16.getText(), "", "", "");
								envio.calculaPrecio();
								
								JOptionPane.showMessageDialog(null,
										"Se ha creado el envío correctamente, el precio del envío es de: " + envio.getPrecio() + "€.");
								CardLayout card = (CardLayout) contentPane.getLayout();
								card.show(contentPane, "panelInicioUser");
								
								//ASIGNAMOS EL TRANSPORTISTA YA QUE SIMULAMOS TODO LO ANTERIOR
								
								int posRandom = ThreadLocalRandom.current().nextInt(0, treceptor.size());
								treceptor.get(posRandom);
								int posRandomOne = ThreadLocalRandom.current().nextInt(0, vreceptor.size());
								vreceptor.get(posRandomOne);
								
								//LO HAREMOS CDO EL ENVIO ESTÉ EN EL ALMACEN U OFICINA RECEPTORA
//								envio.setVehiculo(vehR.getMatricula());
//								envio.setTransportista(transR.getDNI());
								DatabaseManager.registraEnvio(envio);
							}
						}//SI SOLO LA RECOGIDA (EMISOR) ES A DOMICILIO
						else if(!rdbtnEnvoADomicilio.isSelected() && rdbtnRecogidaADomicilio.isSelected()) {
							List<Transportista> temisor = DatabaseManager.getTransportistasProvincia(clienteActual.getProvincia());
							List<Vehiculo> vemisor = DatabaseManager.getVehiculosDeProvincia(clienteActual.getProvincia());
							DatabaseManager.getTransportistasProvincia((String)comboBox_4.getSelectedItem());
							DatabaseManager.getVehiculosDeProvincia((String)comboBox_4.getSelectedItem());
							if(temisor.size()==0) {
								JOptionPane.showMessageDialog(null,
										"No hay transportistas para la provincia del emisor.");
							}
							else if(vemisor.size()==0) {
								JOptionPane.showMessageDialog(null,
										"No hay vehiculos de transporte para la provincia del emisor.");
							}
							
							else {
								//la entrega será en un edificio de la provincia del receptor
								//cogemos transportistas y vehiculos de la provincia del emisor para la primera entrega
								int posRandom = ThreadLocalRandom.current().nextInt(0, temisor.size());
								Transportista transE = temisor.get(posRandom);
								int posRandomOne = ThreadLocalRandom.current().nextInt(0, vemisor.size());
								Vehiculo vehE = vemisor.get(posRandomOne);
								//EL ENVIO TIENE LAS UBICACIONES INICIAL Y FINAL, EL TRANSPORTISTA SOLO LAS QUE EL HACE
								envio = new Envio(rdbtnRecogidaADomicilio.isSelected(), rdbtnEnvoADomicilio.isSelected(), dniIntroducido, clienteActual.getDni(),
										transE.getDNI(), vehE.getMatricula(), (String)comboBox_4.getSelectedItem(), clienteActual.getProvincia(), "", 
										clienteActual.getDireccion(), "Recogida a domicilio", clienteActual.getDireccion());
								envio.calculaPrecio();
								DatabaseManager.registraEnvio(envio);
								JOptionPane.showMessageDialog(null,
										"Se ha creado el envío correctamente, el precio del envío es de: " + envio.getPrecio() + "€.");
								CardLayout card = (CardLayout) contentPane.getLayout();
								card.show(contentPane, "panelInicioUser");
								//ASIGNAMOS LA RUTA DEL TRANSPORTISTA
							}
						}
							
						else {			//SI NO HAY A DOMICILIOS ENTONCES SI CALCULAMOS LOS EDIFICIOS
							//NO CALCULAMOS LOS TRANSPORTISTAS YA QUE NO RECOGEN A DOMICILIO
							envio = new Envio(rdbtnRecogidaADomicilio.isSelected(), rdbtnEnvoADomicilio.isSelected(), dniIntroducido, clienteActual.getDni(),
									"", "", (String)comboBox_4.getSelectedItem(), clienteActual.getProvincia(), "", "", "", "");
							envio.calculaPrecio();
							DatabaseManager.registraEnvio(envio);
							JOptionPane.showMessageDialog(null,
									"Se ha creado el envío correctamente, el precio del envío es de: " + envio.getPrecio() + "€.");
							CardLayout card = (CardLayout) contentPane.getLayout();
							card.show(contentPane, "panelInicioUser");
							//NO ASIGNAMOS LA RUTA DEL TRANSPORTISTA
							
						}
					}catch(SQLException x) {
						try {
							throw new SQLException(x);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return btnConfirmar;
	}
	private JLabel getLabel_27() {
		if (label_27 == null) {
			label_27 = new JLabel("");
		}
		return label_27;
	}
	private JRadioButton getRdbtnRecogidaADomicilio() {
		if (rdbtnRecogidaADomicilio == null) {
			rdbtnRecogidaADomicilio = new JRadioButton("Recogida a domicilio");
			rdbtnRecogidaADomicilio.setFont(new Font("Tahoma", Font.BOLD, 11));
			rdbtnRecogidaADomicilio.setBounds(6, 7, 148, 17);
		}
		return rdbtnRecogidaADomicilio;
	}
	private JRadioButton getRdbtnEnvoADomicilio() {
		if (rdbtnEnvoADomicilio == null) {
			rdbtnEnvoADomicilio = new JRadioButton("Env\u00EDo a domicilio");
			rdbtnEnvoADomicilio.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(rdbtnEnvoADomicilio.isSelected()) {
						textField_16.setEnabled(true);
					}
					else {
						textField_16.setEnabled(false);
					}
				}
			});
			
			rdbtnEnvoADomicilio.setFont(new Font("Tahoma", Font.BOLD, 11));
			rdbtnEnvoADomicilio.setBounds(6, 29, 148, 17);
		}
		return rdbtnEnvoADomicilio;
	}
	private JPanel getPanelConsultaEnvios() throws SQLException {
		if (panelConsultaEnvios == null) {
			panelConsultaEnvios = new JPanel();
			panelConsultaEnvios.setLayout(new BorderLayout(0, 0));
			panelConsultaEnvios.add(getPanelLista(), BorderLayout.CENTER);
			panelConsultaEnvios.add(getPanelInfo(), BorderLayout.EAST);
		}
		return panelConsultaEnvios;
	}
	private JPanel getPanelLista() throws SQLException {
		if (panelLista == null) {
			panelLista = new JPanel();
			panelLista.setLayout(new BorderLayout(0, 0));
			panelLista.add(getTable());
			panelLista.add(getLblListado(), BorderLayout.NORTH);
		}
		return panelLista;
	}
	private JPanel getPanelInfo() {
		if (panelInfo == null) {
			panelInfo = new JPanel();
			panelInfo.setLayout(new GridLayout(9, 0, 0, 0));
			panelInfo.add(getLabel_15());
			panelInfo.add(getLabel_19());
			panelInfo.add(getLabel_20());
			panelInfo.add(getPanel_31());
			panelInfo.add(getPanel_33());
			panelInfo.add(getPanel_138());
			panelInfo.add(getLabel_61());
			panelInfo.add(getLabel_62());
			panelInfo.add(getPanel_97());
		}
		return panelInfo;
	}
	private JLabel getLabel_15() {
		if (label_15 == null) {
			label_15 = new JLabel("");
		}
		return label_15;
	}
	private JPanel getPanel_31() {
		if (panel_31 == null) {
			panel_31 = new JPanel();
			panel_31.setLayout(new GridLayout(2, 0, 0, 0));
			panel_31.add(getLblListaDeEnvos());
			panel_31.add(getPanel_32());
		}
		return panel_31;
	}
	private JLabel getLblListaDeEnvos() {
		if (lblListaDeEnvos == null) {
			lblListaDeEnvos = new JLabel("Lista de env\u00EDos creados");
			lblListaDeEnvos.setHorizontalAlignment(SwingConstants.CENTER);
			lblListaDeEnvos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		}
		return lblListaDeEnvos;
	}
	private JPanel getPanel_32() {
		if (panel_32 == null) {
			panel_32 = new JPanel();
			panel_32.setLayout(new GridLayout(0, 2, 0, 0));
			panel_32.add(getBtnModificar());
			panel_32.add(getBtnActualizar());
		}
		return panel_32;
	}
	private JLabel getLabel_19() {
		if (label_19 == null) {
			label_19 = new JLabel("");
		}
		return label_19;
	}
	private JLabel getLabel_20() {
		if (label_20 == null) {
			label_20 = new JLabel("");
		}
		return label_20;
	}
	private JButton getBtnActualizar() {
		if (btnActualizar == null) {
			btnActualizar = new JButton("Actualizar");
			btnActualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						actualizarModel();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return btnActualizar;
	}
	
	private JButton getBtnModificar() {
		if (btnModificar == null) {
			btnModificar = new JButton("Modificar direcci\u00F3n entrega");
			btnModificar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int x = table.getSelectedRow();
					if(x==-1 || x==0) {
						JOptionPane.showMessageDialog(null,
								"Ha de seleccionar uno de los envíos de la tabla.");
					}
					else {
						if(!rdbtnADomicilio.isSelected() && !rdbtnEnAlmacnU.isSelected()) {
							JOptionPane.showMessageDialog(null,
									"Debe seleccionar el tipo de modificación de entrega (a domicilio o en almacén).");
						}
						else if(((String)modelEnviosEnviados.getValueAt(x,3)).contains("Entregado")) {
							JOptionPane.showMessageDialog(null,
									"No se puede modificar el lugar de entrega de un envio ya entregado.");
						}
						else {
							try {
								Envio en = DatabaseManager.getEnvioById(Integer.parseInt((String) modelEnviosEnviados.getValueAt(x, 0)));
								if(rdbtnADomicilio.isSelected()) {		
									//MODIFICA ENTREGA DEL ENVIO
									if(textField_20.getText().length()<5) {
										JOptionPane.showMessageDialog(null,
												"Debe introducir una dirección válida.");
									}
									else {
										DatabaseManager.modifyEnvioById("Si", textField_20.getText(), Integer.parseInt((String) modelEnviosEnviados.getValueAt(x, 0)));
										//MODIFICA EL PRECIO
										en = DatabaseManager.getEnvioById(Integer.parseInt((String) modelEnviosEnviados.getValueAt(x, 0)));
										Double precioNuevo = en.calculaPrecio();
										DatabaseManager.updatePrecioEnvio(Integer.parseInt((String) modelEnviosEnviados.getValueAt(x, 0)), precioNuevo);
									}
								}
								else {
									List<Edificio> lista = DatabaseManager.getEdificiosByProvincia(en.getProvinciaDestino());
									if(lista.size()==0) {
										JOptionPane.showMessageDialog(null,
												"No existen oficinas en la provincia del receptor.");
									}
									else {
										//MODIFICA ENTREGA DEL ENVIO
										int posRandom = ThreadLocalRandom.current().nextInt(0, lista.size());
										Edificio edificioSeleccionado = lista.get(posRandom);
										DatabaseManager.modifyEnvioById("No", edificioSeleccionado.getTipo()+"-"+edificioSeleccionado.getNombre()+"-"+
										edificioSeleccionado.getProvinciaLocalizacion(), Integer.parseInt((String) modelEnviosEnviados.getValueAt(x, 0)));
										//MODIFICA EL PRECIO
										en = DatabaseManager.getEnvioById(Integer.parseInt((String) modelEnviosEnviados.getValueAt(x, 0)));
										Double precioNuevo = en.calculaPrecio();
										DatabaseManager.updatePrecioEnvio(Integer.parseInt((String) modelEnviosEnviados.getValueAt(x, 0)), precioNuevo);
									}
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
			});
		}
		return btnModificar;
	}
	private JTable getTable() throws SQLException {
		if (table == null) {
			modelEnviosEnviados = new MyTableModel();
			modelEnviosEnviados.addColumn("Id");
			modelEnviosEnviados.addColumn("Destino");
			modelEnviosEnviados.addColumn("Receptor");
			modelEnviosEnviados.addColumn("Estado");
			modelEnviosEnviados.addColumn("Precio");
			String[] x = {"Id", "Destino", "DNI Receptor", "Estado", "Precio"};
			modelEnviosEnviados.addRow(x);
			table = new JTable(modelEnviosEnviados);
			actualizarModel();
		}
		return table;
	}
	
	private void addToModel(MyTableModel model, List<String[]> datos) {
		for (String[] dato : datos) {
			model.addRow(dato);
		}
	}

	private void removeModelContent(MyTableModel model) {
		if (model.getRowCount() > 0)
			for (int i = model.getRowCount() - 1; i >= 0; i--)
				model.removeRow(i);
	}
	
	private void actualizarModel() throws SQLException {
		removeModelContent(modelEnviosEnviados);
		String[] x = {"Id", "Destino", "DNI Receptor", "Estado", "Precio"};
		modelEnviosEnviados.addRow(x);
		if(clienteActual!=null)
			addToModel(modelEnviosEnviados, DatabaseManager.getEnviosEmisor(clienteActual.getDni()));
	}
	
	private JLabel getLblListado() {
		if (lblListado == null) {
			lblListado = new JLabel("Listado:");
			lblListado.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		}
		return lblListado;
	}
	private JPanel getPanel_33() {
		if (panel_33 == null) {
			panel_33 = new JPanel();
			panel_33.setLayout(new GridLayout(2, 0, 0, 0));
			panel_33.add(getRdbtnADomicilio());
			panel_33.add(getRdbtnEnAlmacnU());
		}
		return panel_33;
	}
	private JRadioButton getRdbtnADomicilio() {
		if (rdbtnADomicilio == null) {
			rdbtnADomicilio = new JRadioButton("A domicilio");
			rdbtnADomicilio.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					rdbtnEnAlmacnU.setSelected(false);
					rdbtnADomicilio.setSelected(true);
					textField_20.setEnabled(true);
				}
			});
		}
		return rdbtnADomicilio;
	}
	private JRadioButton getRdbtnEnAlmacnU() {
		if (rdbtnEnAlmacnU == null) {
			rdbtnEnAlmacnU = new JRadioButton("En almac\u00E9n u oficina");
			rdbtnEnAlmacnU.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					rdbtnADomicilio.setSelected(false);
					rdbtnEnAlmacnU.setSelected(true);
					textField_20.setEnabled(false);
				}
			});
		}
		return rdbtnEnAlmacnU;
	}
	private JPanel getPanelInicioTransportista() {
		if (panelInicioTransportista == null) {
			panelInicioTransportista = new JPanel();
			panelInicioTransportista.setLayout(new BorderLayout(0, 0));
			panelInicioTransportista.add(getPanel_34(), BorderLayout.EAST);
			panelInicioTransportista.add(getPanel_50());
		}
		return panelInicioTransportista;
	}
	private JPanel getPanel_34() {
		if (panel_34 == null) {
			panel_34 = new JPanel();
			panel_34.setLayout(new GridLayout(7, 0, 0, 0));
			panel_34.add(getLblOpcionesDeTransportista());
			panel_34.add(getPanel_38());
			panel_34.add(getPanel_40());
			panel_34.add(getPanel_42());
			panel_34.add(getPanel_46());
			panel_34.add(getPanel_47());
			panel_34.add(getPanel_48());
		}
		return panel_34;
	}
	private JLabel getLblOpcionesDeTransportista() {
		if (lblOpcionesDeTransportista == null) {
			lblOpcionesDeTransportista = new JLabel("Opciones de transportista:                   ");
			lblOpcionesDeTransportista.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		}
		return lblOpcionesDeTransportista;
	}
	private JPanel getPanel_38() {
		if (panel_38 == null) {
			panel_38 = new JPanel();
			panel_38.setBackground(Color.WHITE);
			panel_38.setLayout(new GridLayout(3, 0, 0, 0));
			panel_38.add(getLabel_23());
			panel_38.add(getPanel_39());
		}
		return panel_38;
	}
	private JLabel getLabel_23() {
		if (label_23 == null) {
			label_23 = new JLabel("");
			label_23.setBackground(Color.WHITE);
		}
		return label_23;
	}
	private JPanel getPanel_39() {
		if (panel_39 == null) {
			panel_39 = new JPanel();
			panel_39.setBackground(Color.WHITE);
			panel_39.setLayout(new GridLayout(0, 3, 0, 0));
			panel_39.add(getLabel_24());
			panel_39.add(getBtnListadoDeEnvos());
		}
		return panel_39;
	}
	private JLabel getLabel_24() {
		if (label_24 == null) {
			label_24 = new JLabel("");
			label_24.setForeground(Color.WHITE);
			label_24.setBackground(Color.WHITE);
		}
		return label_24;
	}
	private JButton getBtnListadoDeEnvos() {
		if (btnListadoDeEnvos == null) {
			btnListadoDeEnvos = new JButton("Listado de env\u00EDos asignados");
			btnListadoDeEnvos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelConsultaEnviosAsignados");
					
				}
			});
		}
		return btnListadoDeEnvos;
	}
	private JPanel getPanel_40() {
		if (panel_40 == null) {
			panel_40 = new JPanel();
			panel_40.setBackground(Color.WHITE);
			panel_40.setLayout(new GridLayout(3, 0, 0, 0));
			panel_40.add(getLabel_25());
			panel_40.add(getPanel_41());
		}
		return panel_40;
	}
	private JLabel getLabel_25() {
		if (label_25 == null) {
			label_25 = new JLabel("");
			label_25.setBackground(Color.WHITE);
		}
		return label_25;
	}
	private JPanel getPanel_41() {
		if (panel_41 == null) {
			panel_41 = new JPanel();
			panel_41.setBackground(Color.WHITE);
			panel_41.setLayout(new GridLayout(0, 3, 0, 0));
			panel_41.add(getLabel_28());
			panel_41.add(getBtnRegistrarCambiosEnvios());
		}
		return panel_41;
	}
	private JLabel getLabel_28() {
		if (label_28 == null) {
			label_28 = new JLabel("");
			label_28.setForeground(Color.WHITE);
			label_28.setBackground(Color.WHITE);
		}
		return label_28;
	}
	private JPanel getPanel_42() {
		if (panel_42 == null) {
			panel_42 = new JPanel();
			panel_42.setBackground(Color.WHITE);
			panel_42.setLayout(new GridLayout(3, 0, 0, 0));
			panel_42.add(getLabel_29());
			panel_42.add(getPanel_43());
		}
		return panel_42;
	}
	private JLabel getLabel_29() {
		if (label_29 == null) {
			label_29 = new JLabel("");
			label_29.setBackground(Color.WHITE);
		}
		return label_29;
	}
	private JPanel getPanel_43() {
		if (panel_43 == null) {
			panel_43 = new JPanel();
			panel_43.setBackground(Color.WHITE);
			panel_43.setLayout(new GridLayout(0, 3, 0, 0));
			panel_43.add(getLabel_91());
			panel_43.add(getBtnRegistrarFallo());
		}
		return panel_43;
	}
	private JPanel getPanel_46() {
		if (panel_46 == null) {
			panel_46 = new JPanel();
			panel_46.setBackground(Color.WHITE);
			panel_46.setLayout(new GridLayout(3, 0, 0, 0));
			panel_46.add(getLabel_94());
			panel_46.add(getPanel_135_1());
		}
		return panel_46;
	}
	private JPanel getPanel_47() {
		if (panel_47 == null) {
			panel_47 = new JPanel();
			panel_47.setBackground(Color.WHITE);
		}
		return panel_47;
	}
	private JPanel getPanel_48() {
		if (panel_48 == null) {
			panel_48 = new JPanel();
			panel_48.setBackground(Color.WHITE);
			panel_48.setLayout(new GridLayout(3, 0, 0, 0));
			panel_48.add(getLabel_30());
			panel_48.add(getPanel_49());
		}
		return panel_48;
	}
	private JLabel getLabel_30() {
		if (label_30 == null) {
			label_30 = new JLabel("");
			label_30.setBackground(Color.WHITE);
		}
		return label_30;
	}
	private JPanel getPanel_49() {
		if (panel_49 == null) {
			panel_49 = new JPanel();
			panel_49.setBackground(Color.WHITE);
			panel_49.setLayout(new GridLayout(0, 3, 0, 0));
			panel_49.add(getLabel_31());
			panel_49.add(getLabel_32());
			panel_49.add(getButton_3());
		}
		return panel_49;
	}
	private JLabel getLabel_31() {
		if (label_31 == null) {
			label_31 = new JLabel("");
			label_31.setForeground(Color.WHITE);
			label_31.setBackground(Color.WHITE);
		}
		return label_31;
	}
	private JLabel getLabel_32() {
		if (label_32 == null) {
			label_32 = new JLabel("");
		}
		return label_32;
	}
	private JButton getButton_3() {
		if (button_3 == null) {
			button_3 = new JButton("Desconectar");
			button_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					transportistaActual=null;
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelInicio");
					try {
						actualizarModelt();
						actualizarTableProgramados();
						actualizarModelRE();
						actualizarModelRR();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return button_3;
	}
	private JPanel getPanel_50() {
		if (panel_50 == null) {
			panel_50 = new JPanel();
			panel_50.setLayout(new BorderLayout(0, 0));
			panel_50.add(getLabel_33(), BorderLayout.NORTH);
			panel_50.add(getLabel_34(), BorderLayout.CENTER);
		}
		return panel_50;
	}
	private JLabel getLabel_33() {
		if (label_33 == null) {
			label_33 = new JLabel("Bienvenido");
			if(transportistaActual != null) {
				lblBienvenido = new JLabel("Bienvenido " + transportistaActual.getNombre());
			}
			label_33.setFont(new Font("Tahoma", Font.ITALIC, 18));
		}
		return label_33;
	}
	private JLabel getLabel_34() {
		if (label_34 == null) {
			label_34 = new JLabel("");
		}
		return label_34;
	}
	private JPanel getPanelConsultaEnviosAsignados() throws SQLException {
		if (panelConsultaEnviosAsignados == null) {
			panelConsultaEnviosAsignados = new JPanel();
			panelConsultaEnviosAsignados.setLayout(new BorderLayout(0, 0));
			panelConsultaEnviosAsignados.add(getPanel_44(), BorderLayout.CENTER);
			panelConsultaEnviosAsignados.add(getPanel_45(), BorderLayout.EAST);
		}
		return panelConsultaEnviosAsignados;
	}
	private JPanel getPanel_44() throws SQLException {
		if (panel_44 == null) {
			panel_44 = new JPanel();
			panel_44.setLayout(new BorderLayout(0, 0));
			panel_44.add(getTable_1());
			panel_44.add(getLblListadoEnviosAsignados(), BorderLayout.NORTH);
		}
		return panel_44;
	}
	private JTable getTable_1() throws SQLException {
		//LOS ENVIOS SON POR EJEMPLO DESDE MI CASA HASTA EL ALMACEN O VICEVERSA
		if (table_1 == null) {
			modelEnviosARepartir = new MyTableModel();
			modelEnviosARepartir.addColumn("Id");	
			modelEnviosARepartir.addColumn("Recogida");
			modelEnviosARepartir.addColumn("Destino");
			modelEnviosARepartir.addColumn("Vehiculo");
			String[] x = {"Id envío", "Lugar recogida", "Lugar destino", "Matricula vehículo"};
			modelEnviosARepartir.addRow(x);
			table_1 = new JTable(modelEnviosARepartir);
			actualizarModelt();
		}
		return table_1;
	}

	private JLabel getLblListadoEnviosAsignados() {
		if (lblListadoEnviosAsignados == null) {
			lblListadoEnviosAsignados = new JLabel("Listado envios asignados:");
			lblListadoEnviosAsignados.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		}
		return lblListadoEnviosAsignados;
	}
	private JPanel getPanel_45() {
		if (panel_45 == null) {
			panel_45 = new JPanel();
			panel_45.setLayout(new GridLayout(7, 0, 0, 0));
			panel_45.add(getLabel_22());
			panel_45.add(getLabel_35());
			panel_45.add(getPanel_53());
			panel_45.add(getPanel_51());
			panel_45.add(getPanel_56());
			panel_45.add(getLabel_63());
			panel_45.add(getPanel_100());
		}
		return panel_45;
	}
	private JLabel getLabel_22() {
		if (label_22 == null) {
			label_22 = new JLabel("");
		}
		return label_22;
	}
	private JLabel getLabel_35() {
		if (label_35 == null) {
			label_35 = new JLabel("");
		}
		return label_35;
	}
	private JPanel getPanel_51() {
		if (panel_51 == null) {
			panel_51 = new JPanel();
			panel_51.setLayout(new GridLayout(2, 0, 0, 0));
			panel_51.add(getLblNewLabel_1());
			panel_51.add(getPanel_52());
		}
		return panel_51;
	}
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("Lista de env\u00EDos asignados");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		}
		return lblNewLabel_1;
	}
	private JPanel getPanel_52() {
		if (panel_52 == null) {
			panel_52 = new JPanel();
			panel_52.setLayout(new GridLayout(0, 1, 0, 0));
			panel_52.add(getBtnActualizar_1());
		}
		return panel_52;
	}
	private JButton getBtnActualizar_1() {
		if (btnActualizar_1 == null) {
			btnActualizar_1 = new JButton("Actualizar");
			btnActualizar_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					try {
						actualizarModelt();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}
		return btnActualizar_1;
	}
	
	
	private void addToModelt(MyTableModel model, List<String[]> datos) {
		for (String[] dato : datos) {
			model.addRow(dato);
		}
	}

	private void removeModelContentt(MyTableModel model) {
		if (model.getRowCount() > 0)
			for (int i = model.getRowCount() - 1; i >= 0; i--)
				model.removeRow(i);
	}
	
	private void actualizarModelt() throws SQLException {
		removeModelContentt(modelEnviosARepartir);
		String[] x = {"Id", "Lugar Recogida", "Destino", "Vehículo"};
		modelEnviosARepartir.addRow(x);
		if(transportistaActual!=null) {
			addToModelt(modelEnviosARepartir, DatabaseManager.getEnviosTransportista(transportistaActual.getDNI()));
		}
		
	}
	
	
	
	private JPanel getPanel_53() {
		if (panel_53 == null) {
			panel_53 = new JPanel();
			panel_53.setLayout(new GridLayout(0, 2, 0, 0));
		}
		return panel_53;
	}
	private JPanel getPanel_56() {
		if (panel_56 == null) {
			panel_56 = new JPanel();
			panel_56.setLayout(new GridLayout(0, 2, 0, 0));
		}
		return panel_56;
	}
	private JPanel getPanelInicioAdmin() {
		if (panelInicioAdmin == null) {
			panelInicioAdmin = new JPanel();
			panelInicioAdmin.setLayout(new BorderLayout(0, 0));
			panelInicioAdmin.add(getPanel_59(), BorderLayout.EAST);
			panelInicioAdmin.add(getPanel_72());
		}
		return panelInicioAdmin;
	}
	private JPanel getPanel_59() {
		if (panel_59 == null) {
			panel_59 = new JPanel();
			panel_59.setLayout(new GridLayout(7, 0, 0, 0));
			panel_59.add(getLblOpcionesDeAdministrador());
			panel_59.add(getPanel_64());
			panel_59.add(getPanel_60());
			panel_59.add(getPanel_62());
			panel_59.add(getPanel_68());
			panel_59.add(getPanel_69());
			panel_59.add(getPanel_70());
		}
		return panel_59;
	}
	private JLabel getLblOpcionesDeAdministrador() {
		if (lblOpcionesDeAdministrador == null) {
			lblOpcionesDeAdministrador = new JLabel("Opciones de administrador:                   ");
			lblOpcionesDeAdministrador.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		}
		return lblOpcionesDeAdministrador;
	}
	private JPanel getPanel_60() {
		if (panel_60 == null) {
			panel_60 = new JPanel();
			panel_60.setBackground(Color.WHITE);
			panel_60.setLayout(new GridLayout(3, 0, 0, 0));
			panel_60.add(getLabel_37());
			panel_60.add(getPanel_61());
		}
		return panel_60;
	}
	private JLabel getLabel_37() {
		if (label_37 == null) {
			label_37 = new JLabel("");
			label_37.setBackground(Color.WHITE);
		}
		return label_37;
	}
	private JPanel getPanel_61() {
		if (panel_61 == null) {
			panel_61 = new JPanel();
			panel_61.setBackground(Color.WHITE);
			panel_61.setLayout(new GridLayout(0, 3, 0, 0));
			panel_61.add(getLabel_38());
			panel_61.add(getBtnListadoVehculos());
		}
		return panel_61;
	}
	private JLabel getLabel_38() {
		if (label_38 == null) {
			label_38 = new JLabel("");
			label_38.setForeground(Color.WHITE);
			label_38.setBackground(Color.WHITE);
		}
		return label_38;
	}
	private JPanel getPanel_62() {
		if (panel_62 == null) {
			panel_62 = new JPanel();
			panel_62.setBackground(Color.WHITE);
			panel_62.setLayout(new GridLayout(3, 0, 0, 0));
			panel_62.add(getLabel_39());
			panel_62.add(getPanel_63());
		}
		return panel_62;
	}
	private JLabel getLabel_39() {
		if (label_39 == null) {
			label_39 = new JLabel("");
			label_39.setBackground(Color.WHITE);
		}
		return label_39;
	}
	private JPanel getPanel_63() {
		if (panel_63 == null) {
			panel_63 = new JPanel();
			panel_63.setBackground(Color.WHITE);
			panel_63.setLayout(new GridLayout(0, 3, 0, 0));
			panel_63.add(getLabel_40());
			panel_63.add(getBtnMarcarRecogidos());
		}
		return panel_63;
	}
	private JLabel getLabel_40() {
		if (label_40 == null) {
			label_40 = new JLabel("");
			label_40.setForeground(Color.WHITE);
			label_40.setBackground(Color.WHITE);
		}
		return label_40;
	}
	private JButton getBtnListadoVehculos() {
		if (btnListadoVehculos == null) {
			btnListadoVehculos = new JButton("Listado registros");
			btnListadoVehculos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelListadoRegistros");
				}
			});
		}
		return btnListadoVehculos;
	}
	private JPanel getPanel_64() {
		if (panel_64 == null) {
			panel_64 = new JPanel();
			panel_64.setBackground(Color.WHITE);
			panel_64.setLayout(new GridLayout(3, 0, 0, 0));
			panel_64.add(getLabel_41());
			panel_64.add(getPanel_65());
		}
		return panel_64;
	}
	private JLabel getLabel_41() {
		if (label_41 == null) {
			label_41 = new JLabel("");
			label_41.setBackground(Color.WHITE);
		}
		return label_41;
	}
	private JPanel getPanel_65() {
		if (panel_65 == null) {
			panel_65 = new JPanel();
			panel_65.setBackground(Color.WHITE);
			panel_65.setLayout(new GridLayout(0, 3, 0, 0));
			panel_65.add(getLabel_64());
			panel_65.add(getBtnCrearEnvo());
		}
		return panel_65;
	}
	private JPanel getPanel_68() {
		if (panel_68 == null) {
			panel_68 = new JPanel();
			panel_68.setBackground(Color.WHITE);
			panel_68.setLayout(new GridLayout(3, 0, 0, 0));
			panel_68.add(getLabel_78());
			panel_68.add(getPanel_116());
		}
		return panel_68;
	}
	private JPanel getPanel_69() {
		if (panel_69 == null) {
			panel_69 = new JPanel();
			panel_69.setBackground(Color.WHITE);
			panel_69.setLayout(new GridLayout(3, 0, 0, 0));
			panel_69.add(getLabel_80());
			panel_69.add(getPanel_117());
		}
		return panel_69;
	}
	private JPanel getPanel_70() {
		if (panel_70 == null) {
			panel_70 = new JPanel();
			panel_70.setBackground(Color.WHITE);
			panel_70.setLayout(new GridLayout(3, 0, 0, 0));
			panel_70.add(getLabel_42());
			panel_70.add(getPanel_71());
		}
		return panel_70;
	}
	private JLabel getLabel_42() {
		if (label_42 == null) {
			label_42 = new JLabel("");
			label_42.setBackground(Color.WHITE);
		}
		return label_42;
	}
	private JPanel getPanel_71() {
		if (panel_71 == null) {
			panel_71 = new JPanel();
			panel_71.setBackground(Color.WHITE);
			panel_71.setLayout(new GridLayout(0, 3, 0, 0));
			panel_71.add(getLabel_43());
			panel_71.add(getLabel_44());
			panel_71.add(getButton_4());
		}
		return panel_71;
	}
	private JLabel getLabel_43() {
		if (label_43 == null) {
			label_43 = new JLabel("");
			label_43.setForeground(Color.WHITE);
			label_43.setBackground(Color.WHITE);
		}
		return label_43;
	}
	private JLabel getLabel_44() {
		if (label_44 == null) {
			label_44 = new JLabel("");
		}
		return label_44;
	}
	private JButton getButton_4() {
		if (button_4 == null) {
			button_4 = new JButton("Desconectar");
			button_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelInicio");
				}
			});
		}
		return button_4;
	}
	private JPanel getPanel_72() {
		if (panel_72 == null) {
			panel_72 = new JPanel();
			panel_72.setLayout(new BorderLayout(0, 0));
			panel_72.add(getLblBienvenidoAdministrador(), BorderLayout.NORTH);
			panel_72.add(getLabel_36(), BorderLayout.CENTER);
		}
		return panel_72;
	}
	private JLabel getLblBienvenidoAdministrador() {
		if (lblBienvenidoAdministrador == null) {
			lblBienvenidoAdministrador = new JLabel("Bienvenido administrador");
			lblBienvenidoAdministrador.setFont(new Font("Tahoma", Font.ITALIC, 18));
		}
		return lblBienvenidoAdministrador;
	}
	private JPanel getPanelListadoRegistros() throws SQLException {
		if (panelListadoRegistros == null) {
			panelListadoRegistros = new JPanel();
			panelListadoRegistros.setLayout(new BorderLayout(0, 0));
			panelListadoRegistros.add(getPanel_73(), BorderLayout.CENTER);
		}
		return panelListadoRegistros;
	}
	private JPanel getPanel_73() throws SQLException {
		if (panel_73 == null) {
			panel_73 = new JPanel();
			panel_73.setLayout(new BorderLayout(0, 0));
			panel_73.add(getLblListadoRegistros(), BorderLayout.NORTH);
			panel_73.add(getPanel_74(), BorderLayout.CENTER);
			panel_73.add(getPanel_78(), BorderLayout.SOUTH);
		}
		return panel_73;
	}
	private JLabel getLblListadoRegistros() {
		if (lblListadoRegistros == null) {
			lblListadoRegistros = new JLabel("Listado registros");
			lblListadoRegistros.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		}
		return lblListadoRegistros;
	}
	private JPanel getPanel_74() throws SQLException {
		if (panel_74 == null) {
			panel_74 = new JPanel();
			panel_74.setLayout(new BorderLayout(0, 0));
			panel_74.add(getTable_2());
		}
		return panel_74;
	}
	private JTable getTable_2() throws SQLException {
		if (table_2 == null) {
			modelRegistrosAMostrar = new MyTableModel();
			modelRegistrosAMostrar.addColumn("IdEnvio");
			modelRegistrosAMostrar.addColumn("DNITransportista");
			modelRegistrosAMostrar.addColumn("MatriculaVehiculo");
			modelRegistrosAMostrar.addColumn("UbicacionActual");
			modelRegistrosAMostrar.addColumn("FechaRegistro");
			String[] x = {"Id envio", "DNI transportista", "Matrícula vehículo", "Ubicación actual envío"
					, "Fecha de registro"};
			modelRegistrosAMostrar.addRow(x);
			table_2 = new JTable(modelRegistrosAMostrar);
			actualizarModelV();
			
		}
		return table_2;
	}
	
	private void actualizarModelV() throws SQLException {
		removeModelContent(modelRegistrosAMostrar);
		String[] x = {"Id Envio", "DNI Transportista", "Matrícula vehículo", "Ubicación actual envío", "Fecha de registro"};
		modelRegistrosAMostrar.addRow(x);
		addToModel(modelRegistrosAMostrar, DatabaseManager.getRegistros());
//		table_2.setModel(modelVehiculosAMostrar);
	}
	private JPanel getPanel_78() {
		if (panel_78 == null) {
			panel_78 = new JPanel();
			panel_78.setLayout(new BorderLayout(0, 0));
			panel_78.add(getBtnActualizar_2(), BorderLayout.WEST);
			panel_78.add(getBtnVolver(), BorderLayout.EAST);
		}
		return panel_78;
	}
	private JLabel getLabel_36() {
		if (label_36 == null) {
			label_36 = new JLabel("");
		}
		return label_36;
	}
	private JPanel getPanel_66() {
		if (panel_66 == null) {
			panel_66 = new JPanel();
			panel_66.setBackground(Color.WHITE);
		}
		return panel_66;
	}
	private JPanel getPanel_67() {
		if (panel_67 == null) {
			panel_67 = new JPanel();
			panel_67.setBackground(Color.WHITE);
			panel_67.setLayout(new GridLayout(0, 3, 0, 0));
			panel_67.add(getLabel_45());
			panel_67.add(getBtnModificarDatosUsuario());
		}
		return panel_67;
	}
	private JLabel getLabel_45() {
		if (label_45 == null) {
			label_45 = new JLabel("");
		}
		return label_45;
	}
	private JButton getBtnModificarDatosUsuario() {
		if (btnModificarDatosUsuario == null) {
			btnModificarDatosUsuario = new JButton("Modificar datos usuario");
			btnModificarDatosUsuario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelCambioDatos");
				}
			});
		}
		return btnModificarDatosUsuario;
	}
	private JPanel getPanelCambioDatos() throws SQLException {
		if (panelCambioDatos == null) {
			panelCambioDatos = new JPanel();
			panelCambioDatos.setLayout(new GridLayout(0, 3, 0, 0));
			panelCambioDatos.add(getLabel_46());
			panelCambioDatos.add(getPanel_79());
		}
		return panelCambioDatos;
	}
	private JLabel getLabel_46() {
		if (label_46 == null) {
			label_46 = new JLabel("");
		}
		return label_46;
	}
	private JPanel getPanel_79() throws SQLException {
		if (panel_79 == null) {
			panel_79 = new JPanel();
			panel_79.setLayout(new GridLayout(10, 0, 0, 0));
			panel_79.add(getLblCambioDeDatos());
			panel_79.add(getLabel_48());
			panel_79.add(getPanel_80());
			panel_79.add(getPanel_81());
			panel_79.add(getPanel_82());
			panel_79.add(getPanel_83());
			panel_79.add(getPanel_84());
			panel_79.add(getPanel_85());
			panel_79.add(getLabel_55());
			panel_79.add(getPanel_86());
		}
		return panel_79;
	}
	private JLabel getLblCambioDeDatos() {
		if (lblCambioDeDatos == null) {
			lblCambioDeDatos = new JLabel("Cambio de datos");
			lblCambioDeDatos.setHorizontalAlignment(SwingConstants.CENTER);
			lblCambioDeDatos.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		}
		return lblCambioDeDatos;
	}
	private JLabel getLabel_48() {
		if (label_48 == null) {
			label_48 = new JLabel("");
		}
		return label_48;
	}
	private JPanel getPanel_80() {
		if (panel_80 == null) {
			panel_80 = new JPanel();
			panel_80.setLayout(null);
			panel_80.add(getLabel_49());
			panel_80.add(getTxtNoEditable());
		}
		return panel_80;
	}
	private JLabel getLabel_49() {
		if (label_49 == null) {
			label_49 = new JLabel("DNI: ");
			label_49.setBounds(10, 15, 159, 22);
		}
		return label_49;
	}
	private JTextField getTxtNoEditable() {
		if (txtNoEditable == null) {
			txtNoEditable = new JTextField();
			txtNoEditable.setText("No editable");
			txtNoEditable.setEditable(false);
			txtNoEditable.setEnabled(false);
			txtNoEditable.setColumns(10);
			txtNoEditable.setBounds(89, 15, 202, 22);
		}
		return txtNoEditable;
	}
	private JPanel getPanel_81() {
		if (panel_81 == null) {
			panel_81 = new JPanel();
			panel_81.setLayout(null);
			panel_81.add(getLabel_50());
			panel_81.add(getPasswordField());
		}
		return panel_81;
	}
	private JLabel getLabel_50() {
		if (label_50 == null) {
			label_50 = new JLabel("Contrase\u00F1a: ");
			label_50.setBounds(10, 15, 159, 22);
		}
		return label_50;
	}
	private JTextField getPasswordField() {
		if (passwordField == null) {
			passwordField = new JPasswordField();
			passwordField.setColumns(10);
			passwordField.setBounds(89, 15, 202, 22);
		}
		return passwordField;
	}
	private JPanel getPanel_82() {
		if (panel_82 == null) {
			panel_82 = new JPanel();
			panel_82.setLayout(null);
			panel_82.add(getLabel_51());
			panel_82.add(getTextField_9());
		}
		return panel_82;
	}
	private JLabel getLabel_51() {
		if (label_51 == null) {
			label_51 = new JLabel("Nombre: ");
			label_51.setBounds(10, 15, 159, 22);
		}
		return label_51;
	}
	private JTextField getTextField_9() {
		if (textField_9 == null) {
			textField_9 = new JTextField();
			textField_9.setColumns(10);
			textField_9.setBounds(89, 15, 202, 22);
		}
		return textField_9;
	}
	private JPanel getPanel_83() {
		if (panel_83 == null) {
			panel_83 = new JPanel();
			panel_83.setLayout(null);
			panel_83.add(getLabel_52());
			panel_83.add(getTextField_10());
		}
		return panel_83;
	}
	private JLabel getLabel_52() {
		if (label_52 == null) {
			label_52 = new JLabel("Apellidos(*): ");
			label_52.setBounds(10, 15, 159, 22);
		}
		return label_52;
	}
	private JTextField getTextField_10() {
		if (textField_10 == null) {
			textField_10 = new JTextField();
			textField_10.setColumns(10);
			textField_10.setBounds(89, 15, 202, 22);
		}
		return textField_10;
	}
	private JPanel getPanel_84() throws SQLException {
		if (panel_84 == null) {
			panel_84 = new JPanel();
			panel_84.setLayout(null);
			panel_84.add(getLabel_53());
			panel_84.add(getTextField_11());
		}
		return panel_84;
	}
	private JLabel getLabel_53() {
		if (label_53 == null) {
			label_53 = new JLabel("Direcci\u00F3n: ");
			label_53.setBounds(10, 15, 159, 22);
		}
		return label_53;
	}
	private JTextField getTextField_11() throws SQLException {
		if (textField_11 == null) {
			textField_11 = new JTextField();
			textField_11.setColumns(10);
			textField_11.setBounds(89, 15, 202, 22);
			if(clienteActual!=null)
				if(DatabaseManager.enviosPendientes(clienteActual.getDni())) { //si tiene envios pendientes que no hayan acabado entonces el enabled pasa a false
					textField_11.setEnabled(false);
				}
		}
		return textField_11;
	}
	private JPanel getPanel_85() throws SQLException {
		if (panel_85 == null) {
			panel_85 = new JPanel();
			panel_85.setLayout(null);
			panel_85.add(getLabel_54());
			panel_85.add(getComboBox_1());
		}
		return panel_85;
	}
	private JLabel getLabel_54() {
		if (label_54 == null) {
			label_54 = new JLabel("Provincia: ");
			label_54.setBounds(10, 15, 159, 22);
		}
		return label_54;
	}
	private JComboBox<String> getComboBox_1() throws SQLException {
		if (comboBox_1 == null) {
			comboBox_1 = new JComboBox<String>();
			comboBox_1.setBounds(89, 16, 202, 20);
			comboBox_1.addItem("");
			comboBox_1.addItem("Álava");
			comboBox_1.addItem("Albacete");
			comboBox_1.addItem("Alicante");
			comboBox_1.addItem("Almería");
			comboBox_1.addItem("Asturias");
			comboBox_1.addItem("Ávila");
			comboBox_1.addItem("Badajoz");
			comboBox_1.addItem("Barcelona");
			comboBox_1.addItem("Burgos");
			comboBox_1.addItem("Cáceres");
			comboBox_1.addItem("Cádiz");
			comboBox_1.addItem("Cantabria");
			comboBox_1.addItem("Castellón");
			comboBox_1.addItem("Ciudad Real");
			comboBox_1.addItem("Córdoba");
			comboBox_1.addItem("Cuenca");
			comboBox_1.addItem("Girona");
			comboBox_1.addItem("Granada");
			comboBox_1.addItem("Guadalajara");
			comboBox_1.addItem("Guipúzcoa");
			comboBox_1.addItem("Huelva");
			comboBox_1.addItem("Huesca");
			comboBox_1.addItem("Islas Baleares");
			comboBox_1.addItem("Jaén");
			comboBox_1.addItem("La Coruña");
			comboBox_1.addItem("La Rioja");
			comboBox_1.addItem("Las Palmas");
			comboBox_1.addItem("León");
			comboBox_1.addItem("Lérida");
			comboBox_1.addItem("Lugo");
			comboBox_1.addItem("Madrid");
			comboBox_1.addItem("Málaga");
			comboBox_1.addItem("Murcia");
			comboBox_1.addItem("Navarra");
			comboBox_1.addItem("Orense");
			comboBox_1.addItem("Palencia");
			comboBox_1.addItem("Pontevedra");
			comboBox_1.addItem("Salamanca");
			comboBox_1.addItem("Segovia");
			comboBox_1.addItem("Sevilla");
			comboBox_1.addItem("Soria");
			comboBox_1.addItem("Tarragona");
			comboBox_1.addItem("Tenerife");
			comboBox_1.addItem("Teruel");
			comboBox_1.addItem("Toledo");
			comboBox_1.addItem("Valencia");
			comboBox_1.addItem("Valladolid");
			comboBox_1.addItem("Vizcaya");
			comboBox_1.addItem("Zamora");
			comboBox_1.addItem("Zaragoza");
			if(clienteActual!=null)
				if(DatabaseManager.enviosPendientes(clienteActual.getDni())) { //si tiene envios pendientes que no hayan acabado entonces el enabled pasa a false
					comboBox_1.setEnabled(false);
				}
		}
		return comboBox_1;
	}
	private JLabel getLabel_55() {
		if (label_55 == null) {
			label_55 = new JLabel("   (*): campo no obligatorio");
			label_55.setVerticalAlignment(SwingConstants.BOTTOM);
		}
		return label_55;
	}
	private JPanel getPanel_86() {
		if (panel_86 == null) {
			panel_86 = new JPanel();
			panel_86.setLayout(new GridLayout(0, 3, 0, 0));
			panel_86.add(getLabel_56());
			panel_86.add(getPanel_87());
			panel_86.add(getPanel_98());
		}
		return panel_86;
	}
	private JLabel getLabel_56() {
		if (label_56 == null) {
			label_56 = new JLabel("");
		}
		return label_56;
	}
	private JPanel getPanel_87() {
		if (panel_87 == null) {
			panel_87 = new JPanel();
			panel_87.setLayout(new GridLayout(2, 1, 0, 0));
			panel_87.add(getBtnModificarDatos());
		}
		return panel_87;
	}
	private JPanel getPanelFallosEnEnvios() throws SQLException {
		if (panelFallosEnEnvios == null) {
			panelFallosEnEnvios = new JPanel();
			panelFallosEnEnvios.setLayout(new BorderLayout(0, 0));
			panelFallosEnEnvios.add(getPanel_88(), BorderLayout.CENTER);
			panelFallosEnEnvios.add(getPanel_89(), BorderLayout.NORTH);
			panelFallosEnEnvios.add(getPanel_90(), BorderLayout.SOUTH);
			panelFallosEnEnvios.add(getPanel_91(), BorderLayout.WEST);
			panelFallosEnEnvios.add(getPanel_92(), BorderLayout.EAST);
		}
		return panelFallosEnEnvios;
	}
	private JPanel getPanel_88() throws SQLException {
		if (panel_88 == null) {
			panel_88 = new JPanel();
			panel_88.setLayout(new BorderLayout(0, 0));
			panel_88.add(getLblFallosProducidosEn(), BorderLayout.NORTH);
			panel_88.add(getPanel_93(), BorderLayout.CENTER);
		}
		return panel_88;
	}
	private JPanel getPanel_89() {
		if (panel_89 == null) {
			panel_89 = new JPanel();
		}
		return panel_89;
	}
	private JPanel getPanel_90() {
		if (panel_90 == null) {
			panel_90 = new JPanel();
		}
		return panel_90;
	}
	private JPanel getPanel_91() {
		if (panel_91 == null) {
			panel_91 = new JPanel();
		}
		return panel_91;
	}
	private JPanel getPanel_92() {
		if (panel_92 == null) {
			panel_92 = new JPanel();
		}
		return panel_92;
	}
	private JLabel getLblFallosProducidosEn() {
		if (lblFallosProducidosEn == null) {
			lblFallosProducidosEn = new JLabel("Fallos producidos en entregas");
			lblFallosProducidosEn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		}
		return lblFallosProducidosEn;
	}
	private JTable getTable_3() throws SQLException {
		if (table_3 == null) {
			modelFallosAMostrar = new MyTableModel();
			modelFallosAMostrar.addColumn("LugarEntrega");
			modelFallosAMostrar.addColumn("Razon");
			modelFallosAMostrar.addColumn("NumeroFallos");
			modelFallosAMostrar.addColumn("ProxEntrega");
			String[] x = {"Lugar de entrega", "Razón", "Número de fallos", "Proxima entrega"};
			modelFallosAMostrar.addRow(x);
			table_3 = new JTable(modelFallosAMostrar);
			actualizarModelf();
		}
		return table_3;
	}
	
	private void actualizarModelf() throws SQLException {
		removeModelContentt(modelFallosAMostrar);
		String[] x = {"Lugar de entrega", "Razón", "Número de fallos", "Proxima entrega"};
		modelFallosAMostrar.addRow(x);
		if(clienteActual!=null)
			addToModelt(modelFallosAMostrar, DatabaseManager.getFallos(clienteActual.getDni()));
	}
	
	private JButton getBtnActualizar_2() {
		if (btnActualizar_2 == null) {
			btnActualizar_2 = new JButton("Actualizar");
			btnActualizar_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						actualizarModelV();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return btnActualizar_2;
	}
	private JPanel getPanel_93() throws SQLException {
		if (panel_93 == null) {
			panel_93 = new JPanel();
			panel_93.setLayout(new BorderLayout(0, 0));
			panel_93.add(getTable_3());
			panel_93.add(getPanel_94(), BorderLayout.SOUTH);
		}
		return panel_93;
	}
	private JPanel getPanel_94() {
		if (panel_94 == null) {
			panel_94 = new JPanel();
			panel_94.setLayout(new BorderLayout(0, 0));
			panel_94.add(getBtnActualizar_3(), BorderLayout.WEST);
			panel_94.add(getBtnVolver_1(), BorderLayout.EAST);
		}
		return panel_94;
	}
	private JButton getBtnActualizar_3() {
		if (btnActualizar_3 == null) {
			btnActualizar_3 = new JButton("Actualizar");
			btnActualizar_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						actualizarModelf();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return btnActualizar_3;
	}
	private JButton getBtnVolver_1() {
		if (btnVolver_1 == null) {
			btnVolver_1 = new JButton("Volver");
			btnVolver_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelInicioUser");
				}
			});
		}
		return btnVolver_1;
	}
	private JPanel getPanel_95() {
		if (panel_95 == null) {
			panel_95 = new JPanel();
			panel_95.setLayout(new GridLayout(2, 0, 0, 0));
			panel_95.add(getLabel_6_1());
			panel_95.add(getBtnVolver_2());
		}
		return panel_95;
	}
	private JLabel getLabel_6_1() {
		if (label_6 == null) {
			label_6 = new JLabel("");
		}
		return label_6;
	}
	private JButton getBtnVolver_2() {
		if (btnVolver_2 == null) {
			btnVolver_2 = new JButton("Volver");
			btnVolver_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelInicio");
				}
			});
		}
		return btnVolver_2;
	}
	private JButton getBtnVolver_3() {
		if (btnVolver_3 == null) {
			btnVolver_3 = new JButton("Volver");
			btnVolver_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelInicio");
				}
			});
			btnVolver_3.setBounds(230, 422, 89, 23);
		}
		return btnVolver_3;
	}
	private JLabel getLabel_58() {
		if (label_58 == null) {
			label_58 = new JLabel("");
		}
		return label_58;
	}
	private JLabel getLabel_60() {
		if (label_60 == null) {
			label_60 = new JLabel("");
		}
		return label_60;
	}
	private JPanel getPanel_96() {
		if (panel_96 == null) {
			panel_96 = new JPanel();
			panel_96.setLayout(null);
			panel_96.add(getBtnVolver_4());
		}
		return panel_96;
	}
	private JButton getBtnVolver_4() {
		if (btnVolver_4 == null) {
			btnVolver_4 = new JButton("Volver");
			btnVolver_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelInicioUser");
				}
			});
			btnVolver_4.setBounds(230, 30, 89, 23);
		}
		return btnVolver_4;
	}
	private JLabel getLabel_61() {
		if (label_61 == null) {
			label_61 = new JLabel("");
		}
		return label_61;
	}
	private JLabel getLabel_62() {
		if (label_62 == null) {
			label_62 = new JLabel("");
		}
		return label_62;
	}
	private JPanel getPanel_97() {
		if (panel_97 == null) {
			panel_97 = new JPanel();
			panel_97.setLayout(null);
			panel_97.add(getBtnVolver_5());
		}
		return panel_97;
	}
	private JButton getBtnVolver_5() {
		if (btnVolver_5 == null) {
			btnVolver_5 = new JButton("Volver");
			btnVolver_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelInicioUser");
				}
				
			});
			btnVolver_5.setBounds(233, 36, 89, 23);
		}
		return btnVolver_5;
	}
	private JPanel getPanel_98() {
		if (panel_98 == null) {
			panel_98 = new JPanel();
			panel_98.setLayout(new GridLayout(2, 0, 0, 0));
			panel_98.add(getLabel_57_1());
			panel_98.add(getBtnVolver_6());
		}
		return panel_98;
	}
	private JLabel getLabel_57_1() {
		if (label_57 == null) {
			label_57 = new JLabel("");
		}
		return label_57;
	}
	private JButton getBtnVolver_6() {
		if (btnVolver_6 == null) {
			btnVolver_6 = new JButton("Volver");
			btnVolver_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelInicioUser");
				}
			});
		}
		return btnVolver_6;
	}
	private JLabel getLabel_63() {
		if (label_63 == null) {
			label_63 = new JLabel("");
		}
		return label_63;
	}
	private JPanel getPanel_100() {
		if (panel_100 == null) {
			panel_100 = new JPanel();
			panel_100.setLayout(null);
			panel_100.add(getBtnVolver_8());
		}
		return panel_100;
	}
	private JButton getBtnVolver_8() {
		if (btnVolver_8 == null) {
			btnVolver_8 = new JButton("Volver");
			btnVolver_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelInicioTransportista");
				}
			});
			btnVolver_8.setBounds(118, 53, 89, 23);
		}
		return btnVolver_8;
	}
	private JLabel getLabel_64() {
		if (label_64 == null) {
			label_64 = new JLabel("");
		}
		return label_64;
	}
	private JButton getBtnCrearEnvo() {
		if (btnCrearEnvo == null) {
			btnCrearEnvo = new JButton("Crear env\u00EDo");
			btnCrearEnvo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelCrearEnvioAdmin");
				}
			});
		}
		return btnCrearEnvo;
	}
	private JPanel getPanelCrearEnvioAdmin() {
		if (panelCrearEnvioAdmin == null) {
			panelCrearEnvioAdmin = new JPanel();
			panelCrearEnvioAdmin.setLayout(new GridLayout(0, 3, 0, 0));
			panelCrearEnvioAdmin.add(getLabel_65());
			panelCrearEnvioAdmin.add(getPanel_101());
		}
		return panelCrearEnvioAdmin;
	}
	private JLabel getLabel_65() {
		if (label_65 == null) {
			label_65 = new JLabel("");
		}
		return label_65;
	}
	private JPanel getPanel_101() {
		if (panel_101 == null) {
			panel_101 = new JPanel();
			panel_101.setLayout(new GridLayout(10, 0, 0, 0));
			panel_101.add(getLabel_66());
			panel_101.add(getPanel_102());
			panel_101.add(getPanel_107());
			panel_101.add(getPanel_110());
			panel_101.add(getPanel_111());
			panel_101.add(getPanel_103());
			panel_101.add(getPanel_108());
			panel_101.add(getPanel_109());
			panel_101.add(getLabel_70_1());
			panel_101.add(getPanel_104());
		}
		return panel_101;
	}
	private JLabel getLabel_66() {
		if (label_66 == null) {
			label_66 = new JLabel("Crear env\u00EDo");
			label_66.setHorizontalAlignment(SwingConstants.CENTER);
			label_66.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		}
		return label_66;
	}
	private JPanel getPanel_102() {
		if (panel_102 == null) {
			panel_102 = new JPanel();
			panel_102.setLayout(null);
			panel_102.add(getLabel_68());
			panel_102.add(getTextField_8());
		}
		return panel_102;
	}
	private JLabel getLabel_68() {
		if (label_68 == null) {
			label_68 = new JLabel("DNI destinatario: ");
			label_68.setBounds(10, 15, 159, 22);
		}
		return label_68;
	}
	private JTextField getTextField_8() {
		if (textField_8 == null) {
			textField_8 = new JTextField();
			textField_8.setColumns(10);
			textField_8.setBounds(105, 15, 204, 22);
		}
		return textField_8;
	}
	private JPanel getPanel_103() {
		if (panel_103 == null) {
			panel_103 = new JPanel();
			panel_103.setLayout(null);
			panel_103.add(getRadioButton());
			panel_103.add(getRadioButton_1());
		}
		return panel_103;
	}
	private JRadioButton getRadioButton() {
		if (radioButton == null) {
			radioButton = new JRadioButton("Recogida a domicilio");
			radioButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(radioButton.isSelected()) {
						textField_14.setEnabled(true);
					}
					else {
						textField_14.setEnabled(false);
					}
				}
			});
			radioButton.setFont(new Font("Tahoma", Font.BOLD, 11));
			radioButton.setBounds(6, 29, 148, 17);
		}
		return radioButton;
	}
	private JRadioButton getRadioButton_1() {
		if (radioButton_1 == null) {
			radioButton_1 = new JRadioButton("Env\u00EDo a domicilio");
			radioButton_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(radioButton_1.isSelected()) {
						textField_13.setEnabled(true);
					}
					else {
						textField_13.setEnabled(false);
					}
				}
			});
			radioButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			radioButton_1.setBounds(6, 7, 148, 17);
		}
		return radioButton_1;
	}
	private JPanel getPanel_104() {
		if (panel_104 == null) {
			panel_104 = new JPanel();
			panel_104.setLayout(new GridLayout(0, 3, 0, 0));
			panel_104.add(getLabel_69());
			panel_104.add(getPanel_105());
			panel_104.add(getPanel_112());
		}
		return panel_104;
	}
	private JLabel getLabel_69() {
		if (label_69 == null) {
			label_69 = new JLabel("");
		}
		return label_69;
	}
	private JPanel getPanel_105() {
		if (panel_105 == null) {
			panel_105 = new JPanel();
			panel_105.add(getButton());
		}
		return panel_105;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("Confirmar");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String dniReceptor = textField_8.getText();
					String dniEmisor = textField_12.getText();
					String direccionReceptor = textField_13.getText();
					String direccionEmisor = textField_14.getText();
					String provinciaReceptor = comboBox_2.getSelectedItem().toString();
					String provinciaEmisor = comboBox_3.getSelectedItem().toString();
					if(radioButton.isSelected()) {
						if(textField_14.getText().length()<3) {
							JOptionPane.showMessageDialog(null,
									"Debe introducir una dirección valida del remitente para recoger el envío.");
						}
					}
					else if(radioButton_1.isSelected()) {
						if(textField_13.getText().length()<3) {
							JOptionPane.showMessageDialog(null,
									"Debe introducir una dirección valida del destinatario para entregar el envío.");
						}
					}
					if(textField_8.getText().length()!=9)  {
						JOptionPane.showMessageDialog(null,
								"La longitud del DNI del destinatario debe ser de 9 caracteres.");
					}
					else if(Character.isLetter(textField_8.getText().charAt(8))==false) {
						JOptionPane.showMessageDialog(null,
								"El DNI del destinatario debe contener una letra al final.");
					}
					else if(textField_12.getText().length()!=9) {
						JOptionPane.showMessageDialog(null,
								"La longitud del DNI del remitente debe ser de 9 caracteres.");
					}
					else if(Character.isLetter(textField_12.getText().charAt(8))==false) {
						JOptionPane.showMessageDialog(null,
								"El DNI del remitente debe contener una letra al final.");
					}
					else {
						
						Envio envio = null;
						try {
							DatabaseManager.getEdificiosByProvincia(provinciaReceptor);
						} catch (SQLException e3) {
							// TODO Auto-generated catch block
							e3.printStackTrace();
						}
						List<Edificio> edificiosProvinciaEmisor = null;
						try {
							edificiosProvinciaEmisor = DatabaseManager.getEdificiosByProvincia(provinciaEmisor);
						} catch (SQLException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						List<Transportista> temisor = new ArrayList<Transportista>();
						try {
							temisor = DatabaseManager.getTransportistasProvincia(provinciaEmisor);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						List<Vehiculo> vemisor = new ArrayList<Vehiculo>();;
						try {
							vemisor = DatabaseManager.getVehiculosDeProvincia(provinciaEmisor);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						
						//si entrega y recogida es a domicilio
						if(radioButton.isSelected() && radioButton_1.isSelected()) {
							//si provincias son diferentes
							if(temisor.size()==0) {
								JOptionPane.showMessageDialog(null,
										"No hay transportistas en la provincia del emisor");
							}
							else if(vemisor.size()==0) {
								JOptionPane.showMessageDialog(null,
										"No hay vehiculos en la provincia del emisor");
							}
							else {
								if(!provinciaEmisor.equals(provinciaReceptor)) {
									int posRandom = ThreadLocalRandom.current().nextInt(0, temisor.size());
									Transportista transE = temisor.get(posRandom);
									int posRandomOne = ThreadLocalRandom.current().nextInt(0, vemisor.size());
									Vehiculo vehE = vemisor.get(posRandomOne);
									
									
									
									envio = new Envio(radioButton.isSelected(), radioButton_1.isSelected(), dniReceptor, dniEmisor,
											transE.getDNI(), vehE.getMatricula(), provinciaReceptor, provinciaEmisor, direccionReceptor, direccionEmisor,
											"Recogida a domicilio", direccionEmisor);
								}
								//si provincia es la misma
								else {
									int posRandom = ThreadLocalRandom.current().nextInt(0, temisor.size());
									Transportista transE = temisor.get(posRandom);
									int posRandomOne = ThreadLocalRandom.current().nextInt(0, vemisor.size());
									Vehiculo vehE = vemisor.get(posRandomOne);
									
									envio = new Envio(radioButton.isSelected(), radioButton_1.isSelected(), dniReceptor, dniEmisor,
											transE.getDNI(), vehE.getMatricula(), provinciaReceptor, provinciaEmisor, direccionReceptor, direccionEmisor,
											"Recogida a domicilio", direccionEmisor);
								}
							}
						}
						else if(radioButton.isSelected() && !radioButton_1.isSelected()) {
							if(temisor.size()==0) {
								JOptionPane.showMessageDialog(null,
										"No hay transportistas en la provincia del emisor");
							}
							else if(vemisor.size()==0) {
								JOptionPane.showMessageDialog(null,
										"No hay vehiculos en la provincia del emisor");
							}
							else {
								if(!provinciaEmisor.equals(provinciaReceptor)) {
									int posRandom = ThreadLocalRandom.current().nextInt(0, temisor.size());
									Transportista transE = temisor.get(posRandom);
									int posRandomOne = ThreadLocalRandom.current().nextInt(0, vemisor.size());
									Vehiculo vehE = vemisor.get(posRandomOne);
									
									
									envio = new Envio(radioButton.isSelected(), radioButton_1.isSelected(), dniReceptor, dniEmisor,
											transE.getDNI(), vehE.getMatricula(), provinciaReceptor, provinciaEmisor, direccionReceptor, direccionEmisor,
											"Recogida a domicilio", direccionEmisor);
								}
								else {
									int posRandom = ThreadLocalRandom.current().nextInt(0, temisor.size());
									Transportista transE = temisor.get(posRandom);
									int posRandomOne = ThreadLocalRandom.current().nextInt(0, vemisor.size());
									Vehiculo vehE = vemisor.get(posRandomOne);
									
									int posRandomEdifE = ThreadLocalRandom.current().nextInt(0, edificiosProvinciaEmisor.size());
									edificiosProvinciaEmisor.get(posRandomEdifE);
									
									
									envio = new Envio(radioButton.isSelected(), radioButton_1.isSelected(), dniReceptor, dniEmisor,
											transE.getDNI(), vehE.getMatricula(), provinciaReceptor, provinciaEmisor, direccionReceptor, direccionEmisor,
									"Recogida a domicilio", direccionEmisor);
								}
							}
						}
						//EN ESTOS CASOS HAY QUE ESPERAR A QUE EL EMISOR LO ENTREGUE EN LA OFICINA (NO TIENE ESTADO)
						else if(!radioButton.isSelected() && radioButton_1.isSelected()) {
							
							envio = new Envio(radioButton.isSelected(), radioButton_1.isSelected(), dniReceptor, dniEmisor,
									"", "", provinciaReceptor, provinciaEmisor, direccionReceptor, "",
									"", "");
						}
						else {
							envio = new Envio(radioButton.isSelected(), radioButton_1.isSelected(), dniReceptor, dniEmisor,
									"", "", provinciaReceptor, provinciaEmisor, "", "",
									"", "");
						}
						if(envio!=null) {
							envio.calculaPrecio();
							JOptionPane.showMessageDialog(null,
									"Precio del envío: " + envio.getPrecio() + "€.");
							CardLayout card = (CardLayout) contentPane.getLayout();
							card.show(contentPane, "panelInicioAdmin");
							try {
								DatabaseManager.registraEnvio(envio);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
			});
		}
		return button;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton("Volver");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelInicioAdmin");
				}
			});
		}
		return button_1;
	}
	private JPanel getPanel_107() {
		if (panel_107 == null) {
			panel_107 = new JPanel();
			panel_107.setLayout(null);
			panel_107.add(getLblDni_1());
			panel_107.add(getTextField_12());
		}
		return panel_107;
	}
	private JLabel getLblDni_1() {
		if (lblDni_1 == null) {
			lblDni_1 = new JLabel("DNI remitente:");
			lblDni_1.setBounds(10, 11, 85, 31);
		}
		return lblDni_1;
	}
	private JTextField getTextField_12() {
		if (textField_12 == null) {
			textField_12 = new JTextField();
			textField_12.setBounds(105, 16, 204, 20);
			textField_12.setColumns(10);
		}
		return textField_12;
	}
	private JPanel getPanel_108() {
		if (panel_108 == null) {
			panel_108 = new JPanel();
			panel_108.setLayout(null);
			panel_108.add(getLblDireccinDestinatario());
			panel_108.add(getTextField_13());
		}
		return panel_108;
	}
	private JPanel getPanel_109() {
		if (panel_109 == null) {
			panel_109 = new JPanel();
			panel_109.setLayout(null);
			panel_109.add(getLblDireccinRemitente());
			panel_109.add(getTextField_14());
		}
		return panel_109;
	}
	private JPanel getPanel_110() {
		if (panel_110 == null) {
			panel_110 = new JPanel();
			panel_110.setLayout(null);
			panel_110.add(getLabel_67_1());
			panel_110.add(getComboBox_2());
		}
		return panel_110;
	}
	private JPanel getPanel_111() {
		if (panel_111 == null) {
			panel_111 = new JPanel();
			panel_111.setLayout(null);
			panel_111.add(getLabel_67_2());
			panel_111.add(getComboBox_3());
		}
		return panel_111;
	}
	private JLabel getLabel_67_1() {
		if (lblProvinciaDestinatario == null) {
			lblProvinciaDestinatario = new JLabel("Provincia destinatario: ");
			lblProvinciaDestinatario.setBounds(10, 11, 110, 31);
		}
		return lblProvinciaDestinatario;
	}
	private JLabel getLabel_67_2() {
		if (lblProvinciaRemitente == null) {
			lblProvinciaRemitente = new JLabel("Provincia remitente:");
			lblProvinciaRemitente.setBounds(10, 11, 107, 31);
		}
		return lblProvinciaRemitente;
	}
	private JComboBox<String> getComboBox_2() {
		if (comboBox_2 == null) {
			comboBox_2 = new JComboBox<String>();
			comboBox_2.setBounds(130, 16, 179, 20);
			comboBox_2.addItem("Álava");
			comboBox_2.addItem("Albacete");
			comboBox_2.addItem("Alicante");
			comboBox_2.addItem("Almería");
			comboBox_2.addItem("Asturias");
			comboBox_2.addItem("Ávila");
			comboBox_2.addItem("Badajoz");
			comboBox_2.addItem("Barcelona");
			comboBox_2.addItem("Burgos");
			comboBox_2.addItem("Cáceres");
			comboBox_2.addItem("Cádiz");
			comboBox_2.addItem("Cantabria");
			comboBox_2.addItem("Castellón");
			comboBox_2.addItem("Ciudad Real");
			comboBox_2.addItem("Córdoba");
			comboBox_2.addItem("Cuenca");
			comboBox_2.addItem("Girona");
			comboBox_2.addItem("Granada");
			comboBox_2.addItem("Guadalajara");
			comboBox_2.addItem("Guipúzcoa");
			comboBox_2.addItem("Huelva");
			comboBox_2.addItem("Huesca");
			comboBox_2.addItem("Islas Baleares");
			comboBox_2.addItem("Jaén");
			comboBox_2.addItem("La Coruña");
			comboBox_2.addItem("La Rioja");
			comboBox_2.addItem("Las Palmas");
			comboBox_2.addItem("León");
			comboBox_2.addItem("Lérida");
			comboBox_2.addItem("Lugo");
			comboBox_2.addItem("Madrid");
			comboBox_2.addItem("Málaga");
			comboBox_2.addItem("Murcia");
			comboBox_2.addItem("Navarra");
			comboBox_2.addItem("Orense");
			comboBox_2.addItem("Palencia");
			comboBox_2.addItem("Pontevedra");
			comboBox_2.addItem("Salamanca");
			comboBox_2.addItem("Segovia");
			comboBox_2.addItem("Sevilla");
			comboBox_2.addItem("Soria");
			comboBox_2.addItem("Tarragona");
			comboBox_2.addItem("Tenerife");
			comboBox_2.addItem("Teruel");
			comboBox_2.addItem("Toledo");
			comboBox_2.addItem("Valencia");
			comboBox_2.addItem("Valladolid");
			comboBox_2.addItem("Vizcaya");
			comboBox_2.addItem("Zamora");
			comboBox_2.addItem("Zaragoza");
		}
		return comboBox_2;
	}
	private JComboBox<String> getComboBox_3() {
		if (comboBox_3 == null) {
			comboBox_3 = new JComboBox<String>();
			comboBox_3.setBounds(130, 16, 179, 20);
			comboBox_3.addItem("Álava");
			comboBox_3.addItem("Albacete");
			comboBox_3.addItem("Alicante");
			comboBox_3.addItem("Almería");
			comboBox_3.addItem("Asturias");
			comboBox_3.addItem("Ávila");
			comboBox_3.addItem("Badajoz");
			comboBox_3.addItem("Barcelona");
			comboBox_3.addItem("Burgos");
			comboBox_3.addItem("Cáceres");
			comboBox_3.addItem("Cádiz");
			comboBox_3.addItem("Cantabria");
			comboBox_3.addItem("Castellón");
			comboBox_3.addItem("Ciudad Real");
			comboBox_3.addItem("Córdoba");
			comboBox_3.addItem("Cuenca");
			comboBox_3.addItem("Girona");
			comboBox_3.addItem("Granada");
			comboBox_3.addItem("Guadalajara");
			comboBox_3.addItem("Guipúzcoa");
			comboBox_3.addItem("Huelva");
			comboBox_3.addItem("Huesca");
			comboBox_3.addItem("Islas Baleares");
			comboBox_3.addItem("Jaén");
			comboBox_3.addItem("La Coruña");
			comboBox_3.addItem("La Rioja");
			comboBox_3.addItem("Las Palmas");
			comboBox_3.addItem("León");
			comboBox_3.addItem("Lérida");
			comboBox_3.addItem("Lugo");
			comboBox_3.addItem("Madrid");
			comboBox_3.addItem("Málaga");
			comboBox_3.addItem("Murcia");
			comboBox_3.addItem("Navarra");
			comboBox_3.addItem("Orense");
			comboBox_3.addItem("Palencia");
			comboBox_3.addItem("Pontevedra");
			comboBox_3.addItem("Salamanca");
			comboBox_3.addItem("Segovia");
			comboBox_3.addItem("Sevilla");
			comboBox_3.addItem("Soria");
			comboBox_3.addItem("Tarragona");
			comboBox_3.addItem("Tenerife");
			comboBox_3.addItem("Teruel");
			comboBox_3.addItem("Toledo");
			comboBox_3.addItem("Valencia");
			comboBox_3.addItem("Valladolid");
			comboBox_3.addItem("Vizcaya");
			comboBox_3.addItem("Zamora");
			comboBox_3.addItem("Zaragoza");
		}
		return comboBox_3;
	}
	private JPanel getPanel_112() {
		if (panel_112 == null) {
			panel_112 = new JPanel();
			panel_112.setLayout(new GridLayout(2, 0, 0, 0));
			panel_112.add(getLabel_67_3());
			panel_112.add(getButton_1());
		}
		return panel_112;
	}
	private JLabel getLabel_67_3() {
		if (label_67 == null) {
			label_67 = new JLabel("");
		}
		return label_67;
	}
	private JLabel getLabel_70_1() {
		if (label_70 == null) {
			label_70 = new JLabel("");
		}
		return label_70;
	}
	private JLabel getLblDireccinDestinatario() {
		if (lblDireccinDestinatario == null) {
			lblDireccinDestinatario = new JLabel("Direcci\u00F3n destinatario:");
			lblDireccinDestinatario.setBounds(10, 11, 111, 31);
		}
		return lblDireccinDestinatario;
	}
	private JLabel getLblDireccinRemitente() {
		if (lblDireccinRemitente == null) {
			lblDireccinRemitente = new JLabel("Direcci\u00F3n remitente:");
			lblDireccinRemitente.setBounds(10, 11, 111, 31);
		}
		return lblDireccinRemitente;
	}
	private JTextField getTextField_13() {
		if (textField_13 == null) {
			textField_13 = new JTextField();
			textField_13.setBounds(130, 16, 179, 20);
			textField_13.setColumns(10);
			textField_13.setEnabled(false);
		}
		return textField_13;
	}
	private JTextField getTextField_14() {
		if (textField_14 == null) {
			textField_14 = new JTextField();
			textField_14.setBounds(130, 16, 179, 20);
			textField_14.setColumns(10);
			textField_14.setEnabled(false);
		}
		return textField_14;
	}
	private JPanel getPanelEntregaPaqueteEnOficina() throws SQLException {
		if (panelEntregaPaqueteEnOficina == null) {
			panelEntregaPaqueteEnOficina = new JPanel();
			panelEntregaPaqueteEnOficina.setLayout(new BorderLayout(0, 0));
			panelEntregaPaqueteEnOficina.add(getPanel_106(), BorderLayout.CENTER);
			panelEntregaPaqueteEnOficina.add(getPanel_113(), BorderLayout.EAST);
		}
		return panelEntregaPaqueteEnOficina;
	}
	private JPanel getPanelRecogidaPaqueteEnOficina() throws SQLException {
		if (panelRecogidaPaqueteEnOficina == null) {
			panelRecogidaPaqueteEnOficina = new JPanel();
			panelRecogidaPaqueteEnOficina.setLayout(new BorderLayout(0, 0));
			panelRecogidaPaqueteEnOficina.add(getPanel_114(), BorderLayout.CENTER);
			panelRecogidaPaqueteEnOficina.add(getPanel_115(), BorderLayout.EAST);
		}
		return panelRecogidaPaqueteEnOficina;
	}
	private JPanel getPanel_106() throws SQLException {
		if (panel_106 == null) {
			panel_106 = new JPanel();
			panel_106.setLayout(new BorderLayout(0, 0));
			panel_106.add(getLabel_71(), BorderLayout.NORTH);
			panel_106.add(getTable_5(), BorderLayout.CENTER);
		}
		return panel_106;
	}
	private JPanel getPanel_113() {
		if (panel_113 == null) {
			panel_113 = new JPanel();
			panel_113.setLayout(new GridLayout(7, 0, 0, 0));
			panel_113.add(getLabel_72());
			panel_113.add(getLabel_73());
			panel_113.add(getPanel_124());
			panel_113.add(getBtnMarcarComoEntregado());
			panel_113.add(getBtnActualizar_5());
			panel_113.add(getPanel_77());
			panel_113.add(getPanel_127());
		}
		return panel_113;
	}
	private JLabel getLabel_71() {
		if (label_71 == null) {
			label_71 = new JLabel("Paquetes pendientes de entregar:");
			label_71.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		}
		return label_71;
	}
	private JTable getTable_5() throws SQLException {
		if (table_5 == null) {
			modelEnviosAEntregar = new MyTableModel();
			modelEnviosAEntregar.addColumn("Id");
			modelEnviosAEntregar.addColumn("Emisor");
			String[] x = {"Id", "Emisor"};
			modelEnviosAEntregar.addRow(x);
			table_5 = new JTable(modelEnviosAEntregar);
			actualizarModelEE();
		}
		return table_5;
	}
	private void actualizarModelEE() throws SQLException {
		removeModelContent(modelEnviosAEntregar);
		String[] x = {"Id", "Emisor"};
		modelEnviosAEntregar.addRow(x);
		addToModel(modelEnviosAEntregar, DatabaseManager.getEnviosAEntregar());
		table_5.setModel(modelEnviosAEntregar);
	}
	private JLabel getLabel_72() {
		if (label_72 == null) {
			label_72 = new JLabel("");
		}
		return label_72;
	}
	private JLabel getLabel_73() {
		if (label_73 == null) {
			label_73 = new JLabel("");
		}
		return label_73;
	}
	private JButton getBtnMarcarComoEntregado() {
		if (btnMarcarComoEntregado == null) {
			btnMarcarComoEntregado = new JButton("Marcar como entregado");
			btnMarcarComoEntregado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int x = table_5.getSelectedRow();
					if(x==-1 || x==0) {
						JOptionPane.showMessageDialog(null,
								"Debe de seleccionar uno de los envíos del listado");
					}
					else {
						int envioId = Integer.parseInt((String) table_5.getValueAt(x, 0)); //el id del envío
						Envio envio = null;
						try {
							envio = DatabaseManager.getEnvioById(envioId);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						if(textField_17.getText().length()==0) {
							JOptionPane.showMessageDialog(null,
								"Debe incluir un lugar de entrega.");
						}
						else if((textField_17.getText().contains("Oficina") || textField_17.getText().contains("Almacen")) && textField_17.getText().contains("-")){
							String[] lugarActual = textField_17.getText().split("-");
							if(lugarActual.length!=3) {
								JOptionPane.showMessageDialog(null,
										"El lugar de entrega debe de seguir el formato: Tipo-Nombre-Provincia.");
							}else if(!lugarActual[2].equals(envio.getProvinciaOrigen())) {
								JOptionPane.showMessageDialog(null,
										"La provincia del edificio debe de ser la misma que la del emisor.");
							}
							else {
								envio.setEstado("En " + lugarActual[0]);
								envio.setUbicacionActual(textField_17.getText());
								try {
									DatabaseManager.updateEstadoYTVEnvio(envio);
									actualizarModelEE();
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
						else {
							JOptionPane.showMessageDialog(null,
									"El lugar de entrega debe de seguir el formato: Tipo-Nombre-Provincia.");
						}
						try {
							actualizarModelER();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				
			});
		}
		return btnMarcarComoEntregado;
	}
	private JPanel getPanel_115() {
		if (panel_115 == null) {
			panel_115 = new JPanel();
			panel_115.setLayout(new GridLayout(7, 0, 0, 0));
			panel_115.add(getLabel_75());
			panel_115.add(getLabel_77());
			panel_115.add(getBtnMarcarComoRecogido());
			panel_115.add(getBtnActualizar_6());
			panel_115.add(getLabel_76());
			panel_115.add(getPanel_75());
			panel_115.add(getPanel_76());
		}
		return panel_115;
	}
	private JLabel getLabel_75() {
		if (label_75 == null) {
			label_75 = new JLabel("");
		}
		return label_75;
	}
	private JLabel getLabel_76() {
		if (label_76 == null) {
			label_76 = new JLabel("");
		}
		return label_76;
	}
	private JLabel getLabel_77() {
		if (label_77 == null) {
			label_77 = new JLabel("");
		}
		return label_77;
	}
	private JButton getBtnMarcarComoRecogido() {
		if (btnMarcarComoRecogido == null) {
			btnMarcarComoRecogido = new JButton("Marcar como recogido");
			btnMarcarComoRecogido.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int x = table_6.getSelectedRow();
					if(x==-1 || x==0) {
						JOptionPane.showMessageDialog(null,
								"Debe de seleccionar uno de los envíos del listado");
					}
					else {
						int envioId = Integer.parseInt((String) table_6.getValueAt(x, 0)); //el id del envío
						Envio envio = null;
						try {
							envio = DatabaseManager.getEnvioById(envioId);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						envio.setEstado("Recogido-Cliente");
						envio.setTransportista("");
						envio.setVehiculo("");
						try {
							envio.setUbicacionActual("");
							DatabaseManager.updateEstadoYTVEnvio(envio);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return btnMarcarComoRecogido;
	}
	private JPanel getPanel_114() throws SQLException {
		if (panel_114 == null) {
			panel_114 = new JPanel();
			panel_114.setLayout(new BorderLayout(0, 0));
			panel_114.add(getLblPaquetesPendientesDe(), BorderLayout.NORTH);
			panel_114.add(getTable_6(), BorderLayout.CENTER);
		}
		return panel_114;
	}
	private JLabel getLblPaquetesPendientesDe() {
		if (lblPaquetesPendientesDe == null) {
			lblPaquetesPendientesDe = new JLabel("Paquetes pendientes de recoger:");
			lblPaquetesPendientesDe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		}	
		return lblPaquetesPendientesDe;
	}
	private JTable getTable_6() throws SQLException {
		if (table_6 == null) {
			modelEnviosARecoger = new MyTableModel();
			modelEnviosARecoger.addColumn("Id");
			modelEnviosARecoger.addColumn("Receptor");
			String[] x = {"Id", "Receptor"};
			modelEnviosARecoger.addRow(x);
			table_6 = new JTable(modelEnviosARecoger);
			actualizarModelER();
		}
		return table_6;
	}
	
	private void actualizarModelER() throws SQLException {
		removeModelContent(modelEnviosARecoger);
		String[] x = {"Id", "Receptor"};
		modelEnviosARecoger.addRow(x);
		List<String[]> enviosARecoger = DatabaseManager.getEnviosARecoger();
		List<String[]> enviosQueDebenSerRecogidosPorCliente = new ArrayList<String[]>();
		for(String[] s : enviosARecoger) {
			Envio e = DatabaseManager.getEnvioById(Integer.parseInt(s[0]));
			String provincia = e.getProvinciaDestino();
			if(e.getUbicacionActual()!=null)
				if (e.getUbicacionActual().contains(provincia)) {
					enviosQueDebenSerRecogidosPorCliente.add(s);
				}
		}
		addToModel(modelEnviosARecoger, enviosQueDebenSerRecogidosPorCliente);
		table_6.setModel(modelEnviosARecoger);
	}
	private JButton getBtnActualizar_5() {
		if (btnActualizar_5 == null) {
			btnActualizar_5 = new JButton("Actualizar");
			btnActualizar_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						actualizarModelEE();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return btnActualizar_5;
	}
	private JButton getBtnActualizar_6() {
		if (btnActualizar_6 == null) {
			btnActualizar_6 = new JButton("Actualizar");
			btnActualizar_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						actualizarModelER();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return btnActualizar_6;
	}
	private JLabel getLabel_78() {
		if (label_78 == null) {
			label_78 = new JLabel("");
		}
		return label_78;
	}
	private JPanel getPanel_116() {
		if (panel_116 == null) {
			panel_116 = new JPanel();
			panel_116.setBackground(Color.WHITE);
			panel_116.setLayout(new GridLayout(0, 3, 0, 0));
			panel_116.add(getLabel_79());
			panel_116.add(getBtnMarcarEntregados());
		}
		return panel_116;
	}
	private JLabel getLabel_79() {
		if (label_79 == null) {
			label_79 = new JLabel("");
		}
		return label_79;
	}
	private JButton getBtnMarcarRecogidos() {
		if (btnMarcarRecogidos == null) {
			btnMarcarRecogidos = new JButton("Marcar recogidos en oficina");
			btnMarcarRecogidos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelRecogidaPaqueteEnOficina");
				}
			});
		}
		return btnMarcarRecogidos;
	}
	private JLabel getLabel_80() {
		if (label_80 == null) {
			label_80 = new JLabel("");
		}
		return label_80;
	}
	private JPanel getPanel_117() {
		if (panel_117 == null) {
			panel_117 = new JPanel();
			panel_117.setBackground(Color.WHITE);
			panel_117.setLayout(new GridLayout(0, 3, 0, 0));
			panel_117.add(getLabel_81());
			panel_117.add(getBtnEnvioEntreProvincias());
		}
		return panel_117;
	}
	private JLabel getLabel_81() {
		if (label_81 == null) {
			label_81 = new JLabel("");
		}
		return label_81;
	}
	private JButton getBtnMarcarEntregados() {
		if (btnMarcarEntregados == null) {
			btnMarcarEntregados = new JButton("Marcar entregados en oficina");
			btnMarcarEntregados.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelEntregaPaqueteEnOficina");
				}
			});
		}
		return btnMarcarEntregados;
	}
	private JPanel getPanelRegistroDejadaYRecogidaPaquetes() throws SQLException {
		if (panelRegistroDejadaYRecogidaPaquetes == null) {
			panelRegistroDejadaYRecogidaPaquetes = new JPanel();
			panelRegistroDejadaYRecogidaPaquetes.setLayout(new BorderLayout(0, 0));
			panelRegistroDejadaYRecogidaPaquetes.add(getPanel_54());
			panelRegistroDejadaYRecogidaPaquetes.add(getPanel_121(), BorderLayout.SOUTH);
		}
		return panelRegistroDejadaYRecogidaPaquetes;
	}
	private JPanel getPanel_54() throws SQLException {
		if (panel_54 == null) {
			panel_54 = new JPanel();
			panel_54.setLayout(new GridLayout(0, 2, 10, 0));
			panel_54.add(getPanel_55_1());
			panel_54.add(getPanel_57_1());
		}
		return panel_54;
	}
	private JPanel getPanel_55_1() throws SQLException {
		if (panel_55 == null) {
			panel_55 = new JPanel();
			panel_55.setLayout(new BorderLayout(0, 0));
			panel_55.add(getLblRegistroEntregaDe(), BorderLayout.NORTH);
			panel_55.add(getPanel_58_1(), BorderLayout.CENTER);
		}
		return panel_55;
	}
	private JPanel getPanel_57_1() throws SQLException {
		if (panel_57 == null) {
			panel_57 = new JPanel();
			panel_57.setLayout(new BorderLayout(0, 0));
			panel_57.add(getLblRegistroRecogidaPaquetes(), BorderLayout.NORTH);
			panel_57.add(getTable_8(), BorderLayout.CENTER);
			panel_57.add(getPanel_120(), BorderLayout.SOUTH);
		}
		return panel_57;
	}
	private JLabel getLblRegistroEntregaDe() {
		if (lblRegistroEntregaDe == null) {
			lblRegistroEntregaDe = new JLabel("Registro entrega de paquetes");
			lblRegistroEntregaDe.setFont(new Font("Tahoma", Font.ITALIC, 18));
		}
		return lblRegistroEntregaDe;
	}
	private JLabel getLblRegistroRecogidaPaquetes() {
		if (lblRegistroRecogidaPaquetes == null) {
			lblRegistroRecogidaPaquetes = new JLabel("Registro recogida de paquetes");
			lblRegistroRecogidaPaquetes.setFont(new Font("Tahoma", Font.ITALIC, 18));
		}
		return lblRegistroRecogidaPaquetes;
	}
	private JPanel getPanel_58_1() throws SQLException {
		if (panel_58 == null) {
			panel_58 = new JPanel();
			panel_58.setLayout(new BorderLayout(0, 0));
			panel_58.add(getPanel_118(), BorderLayout.NORTH);
			panel_58.add(getTable_7(), BorderLayout.CENTER);
			panel_58.add(getPanel_119(), BorderLayout.SOUTH);
		}
		return panel_58;
	}
	private JPanel getPanel_118() {
		if (panel_118 == null) {
			panel_118 = new JPanel();
			panel_118.setLayout(new BorderLayout(0, 0));
			panel_118.add(getLblLugarDeEntrega(), BorderLayout.WEST);
			panel_118.add(getTextField_15(), BorderLayout.CENTER);
		}
		return panel_118;
	}
	private JLabel getLblLugarDeEntrega() {
		if (lblLugarDeEntrega == null) {
			lblLugarDeEntrega = new JLabel("Lugar de entrega: ");
		}
		return lblLugarDeEntrega;
	}
	private JTextField getTextField_15() {
		if (textField_15 == null) {
			textField_15 = new JTextField();
			textField_15.setColumns(10);
		}
		return textField_15;
	}
	private JTable getTable_7() throws SQLException {
		if (table_7 == null) {
			modelRegistrarEntregados = new MyTableModel();
			modelRegistrarEntregados.addColumn("id");
			modelRegistrarEntregados.addColumn("receptor");
			modelRegistrarEntregados.addColumn("lugarEntrega");
			String[] x = {"id", "Receptor", "Lugar de entrega"};
			modelRegistrarEntregados.addRow(x);
			table_7 = new JTable(modelRegistrarEntregados);
			actualizarModelRE();
		}
		return table_7;
	}
	
	private void actualizarModelRE() throws SQLException {
		removeModelContent(modelRegistrarEntregados);
		String[] x = {"Id", "Receptor", "Lugar de entrega"};
		modelRegistrarEntregados.addRow(x);
		if(transportistaActual!=null)
			addToModel(modelRegistrarEntregados, DatabaseManager.getEnviosPorEntregarDeTransportista(transportistaActual.getDNI()));
		table_7.setModel(modelRegistrarEntregados);
	}
	
	private JPanel getPanel_119() {
		if (panel_119 == null) {
			panel_119 = new JPanel();
			panel_119.setLayout(new BorderLayout(0, 0));
			panel_119.add(getBtnNewButton(), BorderLayout.EAST);
			panel_119.add(getBtnActualizar_8(), BorderLayout.WEST);
		}
		return panel_119;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Registrar como entregados");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int[] elegidos = table_7.getSelectedRows();
					if(elegidos.length==0) {
						JOptionPane.showMessageDialog(null,
								"Debe elegir al menos un envio.");
					}
					else if(textField_15.getText().length()==0) {
						JOptionPane.showMessageDialog(null,
								"Debe incluir un lugar de entrega.");
					}
					else if(textField_15.getText().equalsIgnoreCase("Domicilio cliente")) {
						for(int i : elegidos) {
							Envio env = null;
							String vehiculo = "";
							int id = Integer.parseInt((String) modelRegistrarEntregados.getValueAt(i, 0));
							try {
								env = DatabaseManager.getEnvioById(id);
								vehiculo = env.getVehiculo();
								String lugarEntrega = env.getLugarEnvio();
								env.setUbicacionActual(lugarEntrega);
								env.setEstado("Entregado al Cliente");
								env.setTransportista("");
								env.setVehiculo("");
								DatabaseManager.updateEstadoYTVEnvio(env);
								DatabaseManager.añadirRegistro(new RegistroMovimiento(transportistaActual.getDNI(), vehiculo, env.getId(), env.getUbicacionActual()));
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							try {
								actualizarModelRE();
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
					else if((textField_15.getText().contains("Oficina") || textField_15.getText().contains("Almacen")) && textField_15.getText().contains("-"))
					{
						String[] lugarActual = textField_15.getText().split("-");
						if(lugarActual.length!=3) {
							JOptionPane.showMessageDialog(null,
									"El lugar de entrega debe de seguir el formato: Tipo-Nombre-Provincia.");
						}else if(!lugarActual[2].equals(transportistaActual.getProvincia())) {
							JOptionPane.showMessageDialog(null,
									"La provincia del edificio debe de ser la misma que la del transportista.");
						}
						else {
							Envio env = null;
							for(int i : elegidos) {
								int id = Integer.parseInt((String) modelRegistrarEntregados.getValueAt(i, 0));
								try {
									env = DatabaseManager.getEnvioById(id);
									if(env.getLugarEnvio().equals(textField_15.getText())){
										env = DatabaseManager.getEnvioById(id);
										env.setUbicacionActual(textField_15.getText());
										env.setEstado("En " + lugarActual[0]);
										env.setTransportista("");
										env.setVehiculo("");
										DatabaseManager.updateEstadoYTVEnvio(env);
										DatabaseManager.añadirRegistro(new RegistroMovimiento(transportistaActual.getDNI(), env.getVehiculo(), env.getId(), env.getUbicacionActual()));
									}
									else {
										env.setUbicacionActual(textField_15.getText());
										env.setEstado("En " + lugarActual[0]);
										DatabaseManager.updateEstadoYTVEnvio(env);
										DatabaseManager.añadirRegistro(new RegistroMovimiento(transportistaActual.getDNI(), env.getVehiculo(), env.getId(), env.getUbicacionActual()));
									}
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
							try {
								actualizarModelRE();
								
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
					else {
						JOptionPane.showMessageDialog(null,
								"El lugar de entrega debe de seguir el formato: Tipo-Nombre-Provincia.");
					}
				}
			});
		}
		return btnNewButton;
	}
	private JTable getTable_8() throws SQLException {
		if (table_8 == null) {
			modelRegistrarRecogidos = new MyTableModel();
			modelRegistrarRecogidos.addColumn("id");
			modelRegistrarRecogidos.addColumn("receptor");
			modelRegistrarRecogidos.addColumn("lugarEntrega");
			String[] x = {"id", "Receptor", "Lugar de entrega"};
			modelRegistrarRecogidos.addRow(x);
			table_8 = new JTable(modelRegistrarEntregados);
			actualizarModelRR();
		}
		return table_8;
	}
	
	private void actualizarModelRR() throws SQLException {
		removeModelContent(modelRegistrarRecogidos);
		String[] x = {"id", "Receptor", "Lugar de entrega"};
		modelRegistrarRecogidos.addRow(x);
		if(transportistaActual!=null)
			addToModel(modelRegistrarRecogidos, DatabaseManager.getEnviosPorRecogerDeTransportista(transportistaActual.getDNI()));
		table_8.setModel(modelRegistrarRecogidos);
	}
	
	private JPanel getPanel_120() {
		if (panel_120 == null) {
			panel_120 = new JPanel();
			panel_120.setLayout(new BorderLayout(0, 0));
			panel_120.add(getBtnRegistrarComoRecogidos(), BorderLayout.EAST);
			panel_120.add(getBtnActualizar_7(), BorderLayout.WEST);
		}
		return panel_120;
	}
	private JPanel getPanel_121() {
		if (panel_121 == null) {
			panel_121 = new JPanel();
			panel_121.setLayout(new BorderLayout(0, 0));
			panel_121.add(getBtnVolver_9(), BorderLayout.EAST);
		}
		return panel_121;
	}
	private JButton getBtnVolver_9() {
		if (btnVolver_9 == null) {
			btnVolver_9 = new JButton("Volver");
			btnVolver_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelInicioTransportista");
				}
			});
		}
		return btnVolver_9;
	}
	private JButton getBtnRegistrarComoRecogidos() {
		if (btnRegistrarComoRecogidos == null) {
			btnRegistrarComoRecogidos = new JButton("Registrar como recogidos");
			btnRegistrarComoRecogidos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int[] elegidos = table_8.getSelectedRows();
					if(elegidos.length==0) {
						JOptionPane.showMessageDialog(null,
								"Debe elegir al menos un envio.");
					}
					else {
						for(int i : elegidos) {
							int id = Integer.parseInt((String) modelRegistrarRecogidos.getValueAt(i, 0));
							try {
								Envio env = DatabaseManager.getEnvioById(id);
								env.setUbicacionActual("");
								env.setEstado("En Transporte");
								env.setTransportista(transportistaActual.getDNI());
								List<Vehiculo> v = DatabaseManager.getVehiculosDeProvincia(transportistaActual.getProvincia());
								Vehiculo random = v.get((new Random()).nextInt(v.size()));
								env.setVehiculo(random.getMatricula());
								DatabaseManager.updateEstadoYTVEnvio(env);
								DatabaseManager.añadirRegistro(new RegistroMovimiento(transportistaActual.getDNI(), env.getVehiculo(), env.getId(), env.getEstado()));
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
						try {
							actualizarModelRR();
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return btnRegistrarComoRecogidos;
	}
	private JPanel getPanel_122() {
		if (panel_122 == null) {
			panel_122 = new JPanel();
			panel_122.setLayout(null);
			panel_122.add(getLabel_47_1());
			panel_122.add(getComboBox_4());
		}
		return panel_122;
	}
	private JLabel getLabel_47_1() {
		if (lblProvinciaDestinatario_1 == null) {
			lblProvinciaDestinatario_1 = new JLabel("Provincia destinatario:");
			lblProvinciaDestinatario_1.setBounds(10, 11, 122, 31);
		}
		return lblProvinciaDestinatario_1;
	}
	private JComboBox<String> getComboBox_4() {
		if (comboBox_4 == null) {
			comboBox_4 = new JComboBox<String>();
			comboBox_4.setBounds(142, 16, 167, 20);
			comboBox_4.addItem("Álava");
			comboBox_4.addItem("Albacete");
			comboBox_4.addItem("Alicante");
			comboBox_4.addItem("Almería");
			comboBox_4.addItem("Asturias");
			comboBox_4.addItem("Ávila");
			comboBox_4.addItem("Badajoz");
			comboBox_4.addItem("Barcelona");
			comboBox_4.addItem("Burgos");
			comboBox_4.addItem("Cáceres");
			comboBox_4.addItem("Cádiz");
			comboBox_4.addItem("Cantabria");
			comboBox_4.addItem("Castellón");
			comboBox_4.addItem("Ciudad Real");
			comboBox_4.addItem("Córdoba");
			comboBox_4.addItem("Cuenca");
			comboBox_4.addItem("Girona");
			comboBox_4.addItem("Granada");
			comboBox_4.addItem("Guadalajara");
			comboBox_4.addItem("Guipúzcoa");
			comboBox_4.addItem("Huelva");
			comboBox_4.addItem("Huesca");
			comboBox_4.addItem("Islas Baleares");
			comboBox_4.addItem("Jaén");
			comboBox_4.addItem("La Coruña");
			comboBox_4.addItem("La Rioja");
			comboBox_4.addItem("Las Palmas");
			comboBox_4.addItem("León");
			comboBox_4.addItem("Lérida");
			comboBox_4.addItem("Lugo");
			comboBox_4.addItem("Madrid");
			comboBox_4.addItem("Málaga");
			comboBox_4.addItem("Murcia");
			comboBox_4.addItem("Navarra");
			comboBox_4.addItem("Orense");
			comboBox_4.addItem("Palencia");
			comboBox_4.addItem("Pontevedra");
			comboBox_4.addItem("Salamanca");
			comboBox_4.addItem("Segovia");
			comboBox_4.addItem("Sevilla");
			comboBox_4.addItem("Soria");
			comboBox_4.addItem("Tarragona");
			comboBox_4.addItem("Tenerife");
			comboBox_4.addItem("Teruel");
			comboBox_4.addItem("Toledo");
			comboBox_4.addItem("Valencia");
			comboBox_4.addItem("Valladolid");
			comboBox_4.addItem("Vizcaya");
			comboBox_4.addItem("Zamora");
			comboBox_4.addItem("Zaragoza");
		}
		return comboBox_4;
	}
	private JPanel getPanel_123() {
		if (panel_123 == null) {
			panel_123 = new JPanel();
			panel_123.setLayout(null);
			panel_123.add(getLabel_47());
			panel_123.add(getTextField_16());
		}
		return panel_123;
	}
	private JLabel getLabel_47() {
		if (label_47 == null) {
			label_47 = new JLabel("Direcci\u00F3n destinatario:");
			label_47.setBounds(10, 11, 111, 31);
		}
		return label_47;
	}
	private JTextField getTextField_16() {
		if (textField_16 == null) {
			textField_16 = new JTextField();
			textField_16.setEnabled(false);
			textField_16.setColumns(10);
			textField_16.setBounds(130, 16, 179, 20);
		}
		return textField_16;
	}
	private JButton getBtnRegistrarCambiosEnvios() {
		if (btnRegistrarCambiosEnvios == null) {
			btnRegistrarCambiosEnvios = new JButton("Registrar cambios envios");
			btnRegistrarCambiosEnvios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelRegistroDejadaYRecogidaPaquetes");
				}
			});
		}
		return btnRegistrarCambiosEnvios;
	}
	private JButton getBtnActualizar_7() {
		if (btnActualizar_7 == null) {
			btnActualizar_7 = new JButton("Actualizar");
			btnActualizar_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						actualizarModelRR();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return btnActualizar_7;
	}
	private JButton getBtnActualizar_8() {
		if (btnActualizar_8 == null) {
			btnActualizar_8 = new JButton("Actualizar");
			btnActualizar_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						actualizarModelRE();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return btnActualizar_8;
	}
	private JPanel getPanelEnvioProvinciaReceptor() throws SQLException {
		if (panelEnvioProvinciaReceptor == null) {
			panelEnvioProvinciaReceptor = new JPanel();
			panelEnvioProvinciaReceptor.setLayout(new BorderLayout(0, 0));
			panelEnvioProvinciaReceptor.add(getLblPedidosPendientesDe(), BorderLayout.NORTH);
			panelEnvioProvinciaReceptor.add(getTable_9(), BorderLayout.CENTER);
			panelEnvioProvinciaReceptor.add(getPanel_126(), BorderLayout.SOUTH);
		}
		return panelEnvioProvinciaReceptor;
	}
	private JPanel getPanel_124() {
		if (panel_124 == null) {
			panel_124 = new JPanel();
			panel_124.setLayout(new GridLayout(3, 1, 0, 0));
			panel_124.add(getLabel_59());
			panel_124.add(getPanel_125());
		}
		return panel_124;
	}
	private JLabel getLabel_59() {
		if (label_59 == null) {
			label_59 = new JLabel("");
		}
		return label_59;
	}
	private JPanel getPanel_125() {
		if (panel_125 == null) {
			panel_125 = new JPanel();
			panel_125.setLayout(new GridLayout(0, 2, 0, 0));
			panel_125.add(getLabel_74());
			panel_125.add(getTextField_17());
		}
		return panel_125;
	}
	private JLabel getLabel_74() {
		if (label_74 == null) {
			label_74 = new JLabel("Lugar entrega:");
		}
		return label_74;
	}
	private JTextField getTextField_17() {
		if (textField_17 == null) {
			textField_17 = new JTextField();
			textField_17.setColumns(10);
		}
		return textField_17;
	}
	private JLabel getLblPedidosPendientesDe() {
		if (lblPedidosPendientesDe == null) {
			lblPedidosPendientesDe = new JLabel("Pedidos pendientes de env\u00EDo:");
			lblPedidosPendientesDe.setFont(new Font("Tahoma", Font.ITALIC, 18));
		}
		return lblPedidosPendientesDe;
	}
	private JTable getTable_9() throws SQLException {
		if (table_9 == null) {
			modelPedidosEntreProvincias = new MyTableModel();
			modelPedidosEntreProvincias.addColumn("id");
			modelPedidosEntreProvincias.addColumn("provinciaRecogida");
			modelPedidosEntreProvincias.addColumn("provinciaEntrega");
			String[] x = {"Id", "Provincia Recogida", "Provincia entrega"};
			modelPedidosEntreProvincias.addRow(x);
			table_9 = new JTable(modelPedidosEntreProvincias);
			actualizarModelPEE();
		}
		return table_9;
	}
	private void actualizarModelPEE() throws SQLException {
		removeModelContent(modelPedidosEntreProvincias);
		String[] x = {"Id", "Provincia Recogida", "Provincia entrega"};
		modelPedidosEntreProvincias.addRow(x);
		addToModel(modelPedidosEntreProvincias, DatabaseManager.getEnviosEntreProvincias());
		table_9.setModel(modelPedidosEntreProvincias);
	}
	
	private JPanel getPanel_126() {
		if (panel_126 == null) {
			panel_126 = new JPanel();
			panel_126.setLayout(new BorderLayout(0, 0));
			panel_126.add(getBtnVolver_10(), BorderLayout.EAST);
			panel_126.add(getPanel_99(), BorderLayout.WEST);
		}
		return panel_126;
	}
	private JButton getBtnEnviarAProvincia() {
		if (btnEnviarAProvincia == null) {
			btnEnviarAProvincia = new JButton("Enviar a provincia destinatario");
			btnEnviarAProvincia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					int idPedido = Integer.parseInt((String) modelPedidosEntreProvincias.getValueAt(table_9.getSelectedRow(), 0));
					if(table_9.getSelectedRow()==-1 || table_9.getSelectedRow()==0) {
						JOptionPane.showMessageDialog(null,
								"Debe de seleccionar uno de los envíos del listado");
					}
					else {
						Envio envio = null;
						try {
							envio = DatabaseManager.getEnvioById(idPedido);
							
							if (envio==null) {
								JOptionPane.showMessageDialog(null,
										"No existe un envio con esa id");
							}
							else {
								//hay que asociarle al pedido un edificio, y un transportista y vehiculo si la entrega es a domicilio
								List<Edificio> edificiosProvinciaReceptor = DatabaseManager.getEdificiosByProvincia(envio.getProvinciaDestino());
								Random randomGenerator = new Random();
								int index = randomGenerator.nextInt(edificiosProvinciaReceptor.size());
								Edificio edifElegido = edificiosProvinciaReceptor.get(index);
								
								String transportistaDni = "";
								String vehiculoMatricula = "";
								
								if(envio.isEnvioADomicilio()) {
									List<Transportista> transportistasProvinciaReceptor = DatabaseManager.getTransportistasProvincia(envio.getProvinciaDestino());
									Random randomGenerator2 = new Random();
									int index2 = randomGenerator2.nextInt(transportistasProvinciaReceptor.size());
									Transportista transElegido = transportistasProvinciaReceptor.get(index2);
									
									List<Vehiculo> vehiculosProvinciaReceptor = DatabaseManager.getVehiculosDeProvincia(envio.getProvinciaDestino());
									Random randomGenerator3 = new Random();
									int index3 = randomGenerator3.nextInt(vehiculosProvinciaReceptor.size());
									Vehiculo vehElegido = vehiculosProvinciaReceptor.get(index3);
									
									transportistaDni = transElegido.getDNI();
									vehiculoMatricula = vehElegido.getMatricula();
								}
								
								envio.setTransportista(transportistaDni);
								envio.setVehiculo(vehiculoMatricula);
								envio.setUbicacionActual(edifElegido.getTipo()+ "-" + edifElegido.getNombre() + "-" + edifElegido.getProvinciaLocalizacion());
								envio.setLugarRecogida(edifElegido.getTipo()+ "-" + edifElegido.getNombre() + "-" + edifElegido.getProvinciaLocalizacion());
								envio.setEstado("En " + edifElegido.getTipo());
								DatabaseManager.updateEstadoYTVEnvio(envio);
								actualizarModelPEE();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});
		}
		return btnEnviarAProvincia;
	}
	private JButton getBtnVolver_10() {
		if (btnVolver_10 == null) {
			btnVolver_10 = new JButton("Volver");
			btnVolver_10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelInicioAdmin");
				}
			});
		}
		return btnVolver_10;
	}
	private JButton getBtnEnvioEntreProvincias() {
		if (btnEnvioEntreProvincias == null) {
			btnEnvioEntreProvincias = new JButton("Envio entre provincias");
			btnEnvioEntreProvincias.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelEnvioProvinciaReceptor");
				}
			});
		}
		return btnEnvioEntreProvincias;
	}
	private JButton getBtnVolver() {
		if (btnVolver == null) {
			btnVolver = new JButton("Volver");
			btnVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelInicioAdmin");
				}
			});
		}
		return btnVolver;
	}
	private JPanel getPanel_75() {
		if (panel_75 == null) {
			panel_75 = new JPanel();
		}
		return panel_75;
	}
	private JPanel getPanel_76() {
		if (panel_76 == null) {
			panel_76 = new JPanel();
			panel_76.setLayout(new GridLayout(2, 0, 0, 0));
			panel_76.add(getLabel_82());
			panel_76.add(getBtnVolver_11());
		}
		return panel_76;
	}
	private JLabel getLabel_82() {
		if (label_82 == null) {
			label_82 = new JLabel("");
		}
		return label_82;
	}
	private JButton getBtnVolver_11() {
		if (btnVolver_11 == null) {
			btnVolver_11 = new JButton("Volver");
			btnVolver_11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelInicioAdmin");
				}
			});
		}
		return btnVolver_11;
	}
	private JPanel getPanel_77() {
		if (panel_77 == null) {
			panel_77 = new JPanel();
		}
		return panel_77;
	}
	private JPanel getPanel_127() {
		if (panel_127 == null) {
			panel_127 = new JPanel();
			panel_127.setLayout(new GridLayout(2, 0, 0, 0));
			panel_127.add(getLabel_83());
			panel_127.add(getBtnVolver_12());
		}
		return panel_127;
	}
	private JLabel getLabel_83() {
		if (label_83 == null) {
			label_83 = new JLabel("");
		}
		return label_83;
	}
	private JButton getBtnVolver_12() {
		if (btnVolver_12 == null) {
			btnVolver_12 = new JButton("Volver");
			btnVolver_12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelInicioAdmin");
				}
			});
		}
		return btnVolver_12;
	}
	private JPanel getPanelRegistroFallo() {
		if (panelRegistroFallo == null) {
			panelRegistroFallo = new JPanel();
			panelRegistroFallo.setLayout(new GridLayout(0, 3, 0, 0));
			panelRegistroFallo.add(getLabel_84());
			panelRegistroFallo.add(getPanel_128());
		}
		return panelRegistroFallo;
	}
	private JLabel getLabel_84() {
		if (label_84 == null) {
			label_84 = new JLabel("");
		}
		return label_84;
	}
	private JPanel getPanel_128() {
		if (panel_128 == null) {
			panel_128 = new JPanel();
			panel_128.setLayout(new GridLayout(7, 0, 0, 0));
			panel_128.add(getLblRegistroDeFallos());
			panel_128.add(getPanel_129());
			panel_128.add(getPanel_130());
			panel_128.add(getPanel_131());
			panel_128.add(getLabel_85());
			panel_128.add(getLabel_86());
			panel_128.add(getPanel_132());
		}
		return panel_128;
	}
	private JLabel getLblRegistroDeFallos() {
		if (lblRegistroDeFallos == null) {
			lblRegistroDeFallos = new JLabel("Registro de fallos en entregas");
			lblRegistroDeFallos.setFont(new Font("Tahoma", Font.ITALIC, 18));
		}
		return lblRegistroDeFallos;
	}
	private JPanel getPanel_129() {
		if (panel_129 == null) {
			panel_129 = new JPanel();
			panel_129.setLayout(null);
			panel_129.add(getLblIdDelEnvo());
			panel_129.add(getTextField_18());
		}
		return panel_129;
	}
	private JPanel getPanel_130() {
		if (panel_130 == null) {
			panel_130 = new JPanel();
			panel_130.setLayout(null);
			panel_130.add(getLblMotivoDelFallo());
			panel_130.add(getTextField_19());
		}
		return panel_130;
	}
	private JPanel getPanel_131() {
		if (panel_131 == null) {
			panel_131 = new JPanel();
			panel_131.setLayout(null);
			panel_131.add(getBtnConfirmar_1());
		}
		return panel_131;
	}
	private JLabel getLblIdDelEnvo() {
		if (lblIdDelEnvo == null) {
			lblIdDelEnvo = new JLabel("Id del env\u00EDo:");
			lblIdDelEnvo.setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblIdDelEnvo.setBounds(10, 11, 85, 54);
		}
		return lblIdDelEnvo;
	}
	private JLabel getLblMotivoDelFallo() {
		if (lblMotivoDelFallo == null) {
			lblMotivoDelFallo = new JLabel("Motivo del fallo:");
			lblMotivoDelFallo.setFont(new Font("Tahoma", Font.ITALIC, 14));
			lblMotivoDelFallo.setBounds(10, 11, 115, 54);
		}
		return lblMotivoDelFallo;
	}
	private JTextField getTextField_18() {
		if (textField_18 == null) {
			textField_18 = new JTextField();
			textField_18.setBounds(123, 30, 186, 20);
			textField_18.setColumns(10);
		}
		return textField_18;
	}
	private JTextField getTextField_19() {
		if (textField_19 == null) {
			textField_19 = new JTextField();
			textField_19.setBounds(123, 30, 186, 20);
			textField_19.setColumns(10);
		}
		return textField_19;
	}
	private JButton getBtnConfirmar_1() {
		if (btnConfirmar_1 == null) {
			btnConfirmar_1 = new JButton("Confirmar");
			btnConfirmar_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String id = textField_18.getText();
					String razon = textField_19.getText();
					boolean idValido = true;
					for(char x : id.toCharArray()) {
						if(Character.isLetter(x)) {
							idValido=false;
						}
					}
					if(!idValido) {
						JOptionPane.showMessageDialog(null,
								"Debe introducir una id válida.");
					}
					else {
						int idEntero = Integer.parseInt(id);
						Envio envio;
						try {
							envio = DatabaseManager.getEnvioById(idEntero);
							if(envio==null) {
								JOptionPane.showMessageDialog(null,
										"No existe un envío con ese id.");
							} else {
								if(!envio.getTransportista().equals(transportistaActual.getDNI())) {
									JOptionPane.showMessageDialog(null,
											"Solo puede añadir fallos de los envíos que le estan asignados.");
								} 
								else if(!envio.getEstado().equals("En Transporte")) {
									JOptionPane.showMessageDialog(null,
											"Este envío se encuentra entregado al cliente o en un edificio.");
								}
								else {
									Fallo falloExistente = DatabaseManager.getFalloById(idEntero);
									if(falloExistente==null) {
										java.util.Date date = new java.util.Date();
										Calendar c = Calendar.getInstance(); 
										c.setTime(date); 
										c.add(Calendar.DATE, 1);
										date = c.getTime();
										
										//asi establecemos la proxima entrega para mañana
										
										Date sqlDate = new java.sql.Date(date.getTime());
										Fallo f = new Fallo(idEntero, 
												envio.getReceptor(),
												envio.getLugarEnvio(),
												razon, transportistaActual.getDNI(), sqlDate, 1);
										DatabaseManager.addFallo(f);
										JOptionPane.showMessageDialog(null,
												"El fallo ha sido registrado correctamente.");
									}
									else {
										if(falloExistente.getNumeroFallos()==3) {
											falloExistente.setNumeroFallos(falloExistente.getNumeroFallos()+1);
											//se debe asignar un edificio de la provincia para depositar alli el pedido
											List<Edificio> lista = DatabaseManager.getEdificiosByProvincia(envio.getProvinciaDestino());
											int posRandom = ThreadLocalRandom.current().nextInt(0, lista.size());
											Edificio edificioSeleccionado = lista.get(posRandom);
											envio.setLugarEntrega(edificioSeleccionado.getTipo()+"-"+edificioSeleccionado.getNombre()+"-"+edificioSeleccionado.getProvinciaLocalizacion());
											String razonDef = textField_19.getText();
											falloExistente.setRazon(razonDef);
											DatabaseManager.updateFallo(falloExistente);
											DatabaseManager.updateLugarEntregaEnvio(envio);
											JOptionPane.showMessageDialog(null,
													"El fallo ha sido registrado correctamente.");
										}
										else if(falloExistente.getNumeroFallos()==4) {
											JOptionPane.showMessageDialog(null,
													"Este envío ya consta del máximo número de fallos y su entrega se encuentra establecida en un edificio.");
										}
										else {
											falloExistente.setNumeroFallos(falloExistente.getNumeroFallos()+1);
											java.util.Date date = new java.util.Date();
											Calendar c = Calendar.getInstance(); 
											c.setTime(date); 
											c.add(Calendar.DATE, 1);
											date = c.getTime();
											Date sqlDate = new java.sql.Date(date.getTime());
											String razonDef = textField_19.getText();
											falloExistente.setRazon(razonDef);
											falloExistente.setProximaEntrega(sqlDate);
											DatabaseManager.updateFallo(falloExistente);
											JOptionPane.showMessageDialog(null,
													"El fallo ha sido registrado correctamente.");
										}
									}
								}
							
							}
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				}
			});
			btnConfirmar_1.setBounds(118, 28, 89, 23);
		}
		return btnConfirmar_1;
	}
	private JLabel getLabel_85() {
		if (label_85 == null) {
			label_85 = new JLabel("");
		}
		return label_85;
	}
	private JLabel getLabel_86() {
		if (label_86 == null) {
			label_86 = new JLabel("");
		}
		return label_86;
	}
	private JPanel getPanel_132() {
		if (panel_132 == null) {
			panel_132 = new JPanel();
			panel_132.setLayout(new GridLayout(3, 0, 0, 0));
			panel_132.add(getLabel_88());
			panel_132.add(getLabel_87());
			panel_132.add(getPanel_133());
		}
		return panel_132;
	}
	private JLabel getLabel_87() {
		if (label_87 == null) {
			label_87 = new JLabel("");
		}
		return label_87;
	}
	private JLabel getLabel_88() {
		if (label_88 == null) {
			label_88 = new JLabel("");
		}
		return label_88;
	}
	private JPanel getPanel_133() {
		if (panel_133 == null) {
			panel_133 = new JPanel();
			panel_133.setLayout(new GridLayout(0, 3, 0, 0));
			panel_133.add(getLabel_89());
			panel_133.add(getLabel_90());
			panel_133.add(getBtnVolver_13());
		}
		return panel_133;
	}
	private JLabel getLabel_89() {
		if (label_89 == null) {
			label_89 = new JLabel("");
		}
		return label_89;
	}
	private JLabel getLabel_90() {
		if (label_90 == null) {
			label_90 = new JLabel("");
		}
		return label_90;
	}
	private JButton getBtnVolver_13() {
		if (btnVolver_13 == null) {
			btnVolver_13 = new JButton("Volver");
			btnVolver_13.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelInicioTransportista");
				}
			});
		}
		return btnVolver_13;
	}
	private JLabel getLabel_91() {
		if (label_91 == null) {
			label_91 = new JLabel("");
		}
		return label_91;
	}
	private JButton getBtnRegistrarFallo() {
		if (btnRegistrarFallo == null) {
			btnRegistrarFallo = new JButton("Registrar fallo");
			btnRegistrarFallo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelRegistroFallo");
				}
			});
		}
		return btnRegistrarFallo;
	}
	private JLabel getLabel_92() {
		if (label_92 == null) {
			label_92 = new JLabel("");
		}
		return label_92;
	}
	private JPanel getPanel_134() {
		if (panel_134 == null) {
			panel_134 = new JPanel();
			panel_134.setBackground(Color.WHITE);
			panel_134.setLayout(new GridLayout(0, 3, 0, 0));
			panel_134.add(getLabel_93());
		}
		return panel_134;
	}
	private JLabel getLabel_93() {
		if (label_93 == null) {
			label_93 = new JLabel("");
		}
		return label_93;
	}
	private JButton getButton_2_1() {
		if (button_2 == null) {
			button_2 = new JButton("Entregas fallidas");
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelFallosEnvios");
				}
			});
		}
		return button_2;
	}
	private JPanel getPanel_99() {
		if (panel_99 == null) {
			panel_99 = new JPanel();
			panel_99.setLayout(new GridLayout(0, 2, 0, 0));
			panel_99.add(getBtnEnviarAProvincia());
			panel_99.add(getBtnActualizar_4());
		}
		return panel_99;
	}
	private JButton getBtnActualizar_4() {
		if (btnActualizar_4 == null) {
			btnActualizar_4 = new JButton("Actualizar");
			btnActualizar_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						actualizarModelPEE();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return btnActualizar_4;
	}
	private JPanel getPanelEntregasProgramadas() throws SQLException {
		if (panelEntregasProgramadas == null) {
			panelEntregasProgramadas = new JPanel();
			panelEntregasProgramadas.setLayout(new BorderLayout(0, 0));
			panelEntregasProgramadas.add(getLblEntregasProgramadas(), BorderLayout.NORTH);
			panelEntregasProgramadas.add(getPanel_136(), BorderLayout.CENTER);
			panelEntregasProgramadas.add(getPanel_137(), BorderLayout.SOUTH);
		}
		return panelEntregasProgramadas;
	}
	private JLabel getLblEntregasProgramadas() {
		if (lblEntregasProgramadas == null) {
			lblEntregasProgramadas = new JLabel("Entregas programadas");
			lblEntregasProgramadas.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		}
		return lblEntregasProgramadas;
	}
	private JPanel getPanel_136() throws SQLException {
		if (panel_136 == null) {
			panel_136 = new JPanel();
			panel_136.setLayout(new BorderLayout(0, 0));
			panel_136.add(getTable_10(), BorderLayout.CENTER);
		}
		return panel_136;
	}
	private JPanel getPanel_137() {
		if (panel_137 == null) {
			panel_137 = new JPanel();
			panel_137.setLayout(new BorderLayout(0, 0));
			panel_137.add(getBtnActualizar_9(), BorderLayout.WEST);
			panel_137.add(getBtnVolver_7(), BorderLayout.EAST);
		}
		return panel_137;
	}
	private JTable getTable_10() throws SQLException {
		if (table_10 == null) {
			modelEntregasProgramadas = new MyTableModel();
			modelEntregasProgramadas.addColumn("Id");
			modelEntregasProgramadas.addColumn("Receptor");
			modelEntregasProgramadas.addColumn("Lugar de entrega");
			modelEntregasProgramadas.addColumn("Fecha entrega");
			modelEntregasProgramadas.addColumn("Número fallos");
			String[] x = {"Id", "Receptor", "Lugar de entrega", "Fecha entrega", "Número de fallos"};
			modelEntregasProgramadas.addRow(x);
			table_10 = new JTable(modelEntregasProgramadas);
			actualizarTableProgramados();
		}
		return table_10;
	}
	private void actualizarTableProgramados() throws SQLException {
		removeModelContent(modelEntregasProgramadas);
		String[] x = {"Id", "Receptor", "Lugar de entrega", "Fecha entrega", "Número de fallos"};
		modelEntregasProgramadas.addRow(x);
		if(transportistaActual!=null)
			addToModel(modelEntregasProgramadas, DatabaseManager.getFallosWithConditions(transportistaActual.getDNI()));
		table_10.setModel(modelEntregasProgramadas);
	}

	private JButton getBtnActualizar_9() {
		if (btnActualizar_9 == null) {
			btnActualizar_9 = new JButton("Actualizar");
			btnActualizar_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						actualizarTableProgramados();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}
		return btnActualizar_9;
	}
	private JButton getBtnVolver_7() {
		if (btnVolver_7 == null) {
			btnVolver_7 = new JButton("Volver");
			btnVolver_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelInicioTransportista");
				}
			});
		}
		return btnVolver_7;
	}
	private JLabel getLabel_94() {
		if (label_94 == null) {
			label_94 = new JLabel("");
		}
		return label_94;
	}
	private JPanel getPanel_135_1() {
		if (panel_135 == null) {
			panel_135 = new JPanel();
			panel_135.setBackground(Color.WHITE);
			panel_135.setLayout(new GridLayout(0, 3, 0, 0));
			panel_135.add(getLabel_95());
			panel_135.add(getBtnEnvosProgramados());
		}
		return panel_135;
	}
	private JLabel getLabel_95() {
		if (label_95 == null) {
			label_95 = new JLabel("");
		}
		return label_95;
	}
	private JButton getBtnEnvosProgramados() {
		if (btnEnvosProgramados == null) {
			btnEnvosProgramados = new JButton("Env\u00EDos programados");
			btnEnvosProgramados.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "panelEntregasProgramadas");
				}
			});
		}
		return btnEnvosProgramados;
	}
	private JPanel getPanel_138() {
		if (panel_138 == null) {
			panel_138 = new JPanel();
			panel_138.setLayout(new GridLayout(3, 0, 0, 0));
			panel_138.add(getLabel_21_1());
			panel_138.add(getPanel_139());
		}
		return panel_138;
	}
	private JLabel getLabel_21_1() {
		if (label_21 == null) {
			label_21 = new JLabel("");
		}
		return label_21;
	}
	private JPanel getPanel_139() {
		if (panel_139 == null) {
			panel_139 = new JPanel();
			panel_139.setLayout(null);
			panel_139.add(getLblNuevaEntregaA());
			panel_139.add(getTextField_20());
		}
		return panel_139;
	}
	private JLabel getLblNuevaEntregaA() {
		if (lblNuevaEntregaA == null) {
			lblNuevaEntregaA = new JLabel("Nueva entrega a domicilio: ");
			lblNuevaEntregaA.setBounds(0, 0, 145, 19);
		}
		return lblNuevaEntregaA;
	}
	private JTextField getTextField_20() {
		if (textField_20 == null) {
			textField_20 = new JTextField();
			textField_20.setBounds(146, 0, 176, 19);
			textField_20.setColumns(10);
			textField_20.setEnabled(false);
		}
		return textField_20;
	}
	private JButton getBtnModificarDatos() {
		if (btnModificarDatos == null) {
			btnModificarDatos = new JButton("Modificar datos");
			btnModificarDatos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String password = passwordField.getText();
					String nombre = textField_9.getText();
					String apellidos = textField_10.getText();
					String direccion = "";
					String provincia = "";
					boolean direccionEditable = false;
					boolean capitalLetter = false;
					boolean minimalLetter = false;
					boolean number = false;
					for(char ch : password.toCharArray()) {
						if(Character.isUpperCase(ch)) {
							capitalLetter = true;
						}
						if(Character.isLowerCase(ch)) {
							minimalLetter = true;
						}
						if(Character.isDigit(ch)) {
							number = true;
						}
					}
					if(textField_11.getText().length()!=0) {
						direccion = textField_11.getText();
						direccionEditable = true;
					}
					if(comboBox_1.getSelectedItem().toString().length()!=0) {
						provincia = (String) comboBox_1.getSelectedItem();
					}
					if(password.length()!=0) {
						if(password.length()<5) {
							JOptionPane.showMessageDialog(null,
								"La contraseña debe de tener longitud 5 o más.");
						}
						else if(!capitalLetter && !minimalLetter && !number) {
							JOptionPane.showMessageDialog(null,
									"La contraseña debe poseer como mínimo una letra mayúscula, minúscula y un número.");
						}
					}
					if(direccionEditable){
						if(direccion.length()<2) {
							JOptionPane.showMessageDialog(null,
									"La dirección debe de ser válida.");
						}
						else {
							try {
								DatabaseManager.updateCliente(clienteActual.getDni(), nombre, apellidos, password, direccion, provincia);
								JOptionPane.showMessageDialog(null,
										"Se han modificado los datos correctamente.");
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
			});
		}
		return btnModificarDatos;
	}
}
