package UI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JToolBar;

import controller.Commands;
import controller.DistanceListener;

public class JToolBarZoom extends JToolBar{
	private JButton jButtonPlus;
	private JButton jButtonLess;
	private DistanceListener distanceListener;
	private JPanelMap jPanelMap;
	private static JToolBarZoom jToolBarZoom;
	
	public static JToolBarZoom getInstence() {
		if(jToolBarZoom == null){
			return jToolBarZoom = new JToolBarZoom();
		}
		return jToolBarZoom;
	}
	
	private  JToolBarZoom(){
		super();
		distanceListener = DistanceListener.getInstance();
		this.jPanelMap = JPanelMap.getIntence();
		init();
	}
	
	private void init(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(createButton(Commands.COMMAND_FRAME_PLUS));
		this.add(createButton(Commands.COMMAND_FRAME_LESS));
		jPanelMap.setPreferredSize(new Dimension(250, 250));
		jPanelMap.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		this.add(jPanelMap);
	}
	
	
	
	public JPanelMap getjPanelMap() {
		return jPanelMap;
	}

	public void setjPanelMap(JPanelMap jPanelMap) {
		this.jPanelMap = jPanelMap;
	}

	private JButton createButton(Commands commands) {
		JButton jButton = new JButton(commands.getImageIcon());
		jButton.setActionCommand(commands.getCommand());
		jButton.setToolTipText(commands.getHind());
		jButton.addActionListener(distanceListener);
		return jButton;
	}
}
