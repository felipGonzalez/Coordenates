package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.Commands;
import controller.DistanceListener;

public class JDialogForm extends JDialog{

	public JButton jButtonOk;
	public JButton jButtonCancel;
	private JPanel panelPrincipal;
	private JPanel panelInfo;
	private JPanel panelBoton;
	private JPanel panelCombo;
	public static final int WIDTH_PANEL = 400;
	public static final int HEIGHT_PANEL= 250;
	private JList list;
	private DefaultListModel dlm;
	private JScrollPane jScrollPane;
	private JComboBox comboBox;
	private String [] fuentes;
	
	public JDialogForm() {
		super(new Frame(), "Administrador Hotel", true);
		jButtonOk = getButton(Commands.COMMAND_OK_APP);
		jButtonCancel =getButton(Commands.COMMAND_CANCEL_APP);
		//this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		System.out.println("entro");
		this.setUndecorated(true);// opcional revisar por que el florez es un marica
		this.fuentes = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
	}
	
	public void initJpanel() {
		panelPrincipal = new JPanel(new BorderLayout());
		panelInfo = new JPanel();
		panelBoton = new JPanel(new FlowLayout());
		panelCombo = new JPanel();
		panelCombo.setLayout(null);
		panelPrincipal.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		panelInfo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		panelBoton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
		this.dlm = new DefaultListModel();
		this.list = new JList();
		this.list.setModel(dlm);
		this.jScrollPane = new JScrollPane(list);
		this.comboBox = new JComboBox();
		initComponent();
		init();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}

	public void initComponent() {
		for (String fuente:  fuentes ) {
			dlm.addElement(fuente);
		}
		for (int i = 1; i < 100; i++) {
			comboBox.addItem(i);
		}
	}
	
	public void init() {
		panelBoton.add(jButtonOk);
		panelBoton.add(jButtonCancel);
		panelInfo.add(jScrollPane);
		panelInfo.add(panelCombo.add(comboBox));
		//panelInfo.add(jTextFieldEmail);
		panelPrincipal.add("Center", panelInfo);
		panelPrincipal.add("South", panelBoton);
		this.getContentPane().add(panelPrincipal);
		this.setSize(WIDTH_PANEL, HEIGHT_PANEL);
		

	}

	public JButton getButton(Commands commands){
		JButton button = new JButton(commands.getTitle());
		button.setActionCommand(commands.getCommand());
		button.setToolTipText(commands.getHind());
		button.addActionListener(DistanceListener.getInstance());
		return button;
	}

	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}
	
}