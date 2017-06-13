package UI;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ConstantsDistance;

public class JPanelStatusBarDistance extends JPanel{


	private static JPanelStatusBarDistance jPanelStatusBarDistance;
	private JLabel jLabelMessage;
	
	private JPanelStatusBarDistance() {
		super();
		this.jLabelMessage = new JLabel("..Barra De Estado..");
		init();
	}
	
	public static JPanelStatusBarDistance getInstance(){
		if (jPanelStatusBarDistance ==null) {
			jPanelStatusBarDistance = new JPanelStatusBarDistance();
		}
		return jPanelStatusBarDistance;
	}

	private void init() {
		this.setBorder(BorderFactory.createLineBorder(ConstantsDistance.APP_BORDER_COLOR));
		this.setBackground(ConstantsDistance.APP_BACKGROUND_COLOR);
		this.add(this.jLabelMessage);
		
	}
	
	public void setMessage(String message){
		this.jLabelMessage.setText(message);
	}
}
	

