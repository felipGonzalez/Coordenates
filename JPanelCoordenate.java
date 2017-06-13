package UI;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.Document;

import controller.Commands;
import controller.DistanceListener;
import model.Coordenate;

public class JPanelCoordenate extends JPanel{
	
	private static final String NAME_VALUE_X = "Valor de x";
	private static final String NAME_VALUE_Y = "Valor de y";
	private JTextField jTextFieldValueX;
	private JTextField jTextFieldValueY;
	private Document documentX;
	private Document documentY;
	
	
	public JPanelCoordenate(String name) {
		super();
		this.jTextFieldValueX = new JTextField();
		this.jTextFieldValueY = new JTextField();
		this.setBorder(BorderFactory.createTitledBorder(name));
		init();
	}
	
	public void init() {
		this.add(new JLabel(NAME_VALUE_X));
		this.add(this.jTextFieldValueX);
		this.add(new JLabel(NAME_VALUE_Y));
		this.add(this.jTextFieldValueY);
	}
	
	public void setEvents(Commands commandOne, Commands commandTwo ) {
		jTextFieldValueX.setActionCommand(commandOne.getCommand());
		jTextFieldValueX.setActionCommand(commandOne.getCommand());
		jTextFieldValueX.setToolTipText(commandOne.getHind());
		jTextFieldValueX.addActionListener(DistanceListener.getInstance());
		//++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		jTextFieldValueY.setActionCommand(commandTwo.getCommand());
		jTextFieldValueY.setActionCommand(commandTwo.getCommand());
		jTextFieldValueY.setToolTipText(commandTwo.getHind());
		jTextFieldValueY.addActionListener(DistanceListener.getInstance());
		
		
	}
	
	public void set(Coordenate coordenate) {
		if(coordenate != null){
			this.jTextFieldValueX.setText(coordenate.getValueX()+"");
			this.jTextFieldValueY.setText(coordenate.getValueY()+"");
		}
		
	}
	
	public double getJTextFieldX(){
		return Double.parseDouble(this.jTextFieldValueX.getText());
	}
	
	public double getJTextFieldY(){
		return Double.parseDouble(this.jTextFieldValueY.getText());
	}
	
	public Coordenate get() {
		return new Coordenate(Double.parseDouble(this.jTextFieldValueX.getText()) ,
				Double.parseDouble(this.jTextFieldValueY.getText()) );
	}

	public Document getDocumentX() {
		return documentX;
	}

	public void setDocumentX(Document documentX) {
		this.documentX = documentX;
	}

	public Document getDocumentY() {
		return documentY;
	}

	public void setDocumentY(Document documentY) {
		this.documentY = documentY;
	}

	public JTextField getjTextFieldValueX() {
		return jTextFieldValueX;
	}

	public void setjTextFieldValueX(JTextField jTextFieldValueX) {
		this.jTextFieldValueX = jTextFieldValueX;
	}

	public JTextField getjTextFieldValueY() {
		return jTextFieldValueY;
	}

	public void setjTextFieldValueY(JTextField jTextFieldValueY) {
		this.jTextFieldValueY = jTextFieldValueY;
	}
	
	public void setFontTextField(Font font) {
		this.jTextFieldValueX.setFont(font);
		this.jTextFieldValueY.setFont(font);
	}
	
	
}
