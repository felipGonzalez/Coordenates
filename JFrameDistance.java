package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.ConstantsDistance;
import controller.DistanceListener;

public class JFrameDistance extends JFrame{

	private JMenuBarDistance jMenuBarDistance;
	private JToolBarDistance jToolBarDistance;
	private JPanelStatusBarDistance jpanelStatusBar;
	private JPanelWorkAreaDistance jPanelWorkArea;
	private JPopupMenuDistance jPopupMenuDistance;
	private JToolBarZoom jToolBarZoom;
	
	public JFrameDistance() {
		super(ConstantsDistance.APP_NAME+ "__" + ConstantsDistance.APP_VERSION);
		this.jMenuBarDistance   =   JMenuBarDistance.getInstance();
		this.jToolBarDistance   =   JToolBarDistance.getInstance();
		this.jpanelStatusBar    =   JPanelStatusBarDistance.getInstance();
		this.jPanelWorkArea     =  JPanelWorkAreaDistance.getInstance();
		this.jPopupMenuDistance =   new JPopupMenuDistance();
		this.jToolBarZoom = JToolBarZoom.getInstence(); 
		init();
	}

	public void init() {
		this.setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		this.setLayout(new BorderLayout());
		jPanelWorkArea.setLayout(new BorderLayout(0, 0));
		this.add(jpanelStatusBar, BorderLayout.SOUTH);
		this.add(jPanelWorkArea, BorderLayout.CENTER);
		this.add(jToolBarDistance, BorderLayout.NORTH);
		this.add(jToolBarZoom, BorderLayout.WEST);
		this.add(new JScrollPane(jPanelWorkArea));
		this.setJMenuBar(jMenuBarDistance);
		//this.add(jPopupMenuDistance);
		//*-------------------------------------------------------
		DistanceListener.getInstance().setJPanelWorkAreaDistance(jPanelWorkArea);
		DistanceListener.getInstance().setCreate();
		//*-------------------------------------------------------
		System.out.println("entro");
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.jPanelWorkArea.setjPanelDistance(jToolBarDistance.getPaint());
	}
	
	public JPanelStatusBarDistance getJPanelStatusBar(){
		return jpanelStatusBar;
	}
	
	public JToolBarDistance getJToolBarDistance() {
		return jToolBarDistance;
	}
	
	
}
