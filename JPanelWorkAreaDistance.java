package UI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;

import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import controller.Commands;
import controller.ConstantsDistance;
import controller.DistanceListener;

public class JPanelWorkAreaDistance extends JPanel{

	private static final long serialVersionUID = -5702479834570018174L;
	private JPanelDistance jPanelDistance;
	private JPopupMenu jPopupMenu;
	private static JPanelWorkAreaDistance jPanelWorkAreaDistance;
	private Color colorFont;
	private double zoom = 1;
		
	public static JPanelWorkAreaDistance getInstance(){
		if(jPanelWorkAreaDistance == null){
			jPanelWorkAreaDistance = new JPanelWorkAreaDistance();
		}
		return jPanelWorkAreaDistance;

	}
	
	private  JPanelWorkAreaDistance() {
		this.setLayout(null);
		this.jPopupMenu = new JPopupMenu();
		this.setPreferredSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize()));
		colorFont = ConstantsDistance.APP_COLOR_FONT;
		this.setBackground(colorFont);
		init();
		
	}

	private void init() {
		
		this.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		this.addMouseMotionListener(DistanceListener.getInstance());
		this.addMouseListener(DistanceListener.getInstance());
		this.jPopupMenu.add(getItem(Commands.COMMAND_ADD_POINT_INIT));
		this.jPopupMenu.add(getItem(Commands.COMMAND_ADD_POINT_FINAL));
		this.jPopupMenu.add(getItem(Commands.COMMAND_OPTION_SHOW_POINT));
		this.jPopupMenu.add(getItem(Commands.COMMAND_OPTION_COLOR_FONT));
		this.jPopupMenu.add(getItem(Commands.COMMAND_OPTION_COLOR_LINE));
		this.jPopupMenu.add(getItem(Commands.COMMAND_OPTION_COLOR_POINT));
		this.jPopupMenu.add(getItem(Commands.COMMAND_OPTION_SET_NUM_DECIMAL));
		this.add(jPopupMenu);
		this.addMouseWheelListener(DistanceListener.getInstance());
		
	}
	
	public JMenuItem getItem(Commands commands){
		JMenuItem item = new JMenuItem(commands.getTitle());
		item.setActionCommand(commands.getCommand());
		item.setToolTipText(commands.getHind());
		item.addActionListener(DistanceListener.getInstance());
		return item;
	}
	
	public void setFontJPopupMenu(Font font) {
		jPopupMenu.setFont(font);
		
		for (int i = 0; i < jPopupMenu.getComponents().length; i++) {
			jPopupMenu.getComponents()[i].setFont(font);
		}
	}
	
	public JPanelDistance getjPanelDistance() {
		
		return jPanelDistance;
	}

	public void setjPanelDistance(JPanelDistance jPanelDistance) {
		this.jPanelDistance = jPanelDistance;
	}

	public JPopupMenu getJPopupMenu() {
		return jPopupMenu;
	}
	
	
	
	public JPopupMenu getjPopupMenu() {
		return jPopupMenu;
	}

	

	public Color getColorFont() {
		return colorFont;
	}

	public void setColorFont(Color colorFont) {
		this.setBackground(colorFont);
	}

	public void setZoom(double zoomQ){
		this.zoom = zoomQ;
	}
	
	public double getZoom(){
		return this.zoom;
	}
	
	
	
	
	@Override
	public void  paint(Graphics graphics) {
		super.paint(graphics);// para limpiar la pantalla
		JToolBarZoom.getInstence().getjPanelMap().setjPanelDistance(jPanelDistance);
		JToolBarZoom.getInstence().getjPanelMap().repaint();
		graphics.setColor(ConstantsDistance.APP_COLOR_LINE);
         graphics.drawRect(0, 0, 250, 250);
		Graphics2D g2d = (Graphics2D) graphics;
		
         double width = this.getWidth();
         System.out.println(this.getWidth() + " "+  this.getHeight());
         double height = this.getHeight();
         System.out.println("zoom "+zoom);
         double zoomWidth = width * zoom;
         double zoomHeight = height * zoom;
         double anchorx = (width - zoomWidth) / 2;
         double anchory = (height - zoomHeight) / 2;
         AffineTransform at = new AffineTransform();
         at.translate(anchorx, anchory);
         at.scale(zoom, zoom);
          g2d.setTransform(at);
         jPanelDistance.showLine(g2d);
  		jPanelDistance.showOvale(g2d);
  		jPanelDistance.showString(g2d);
  		  at.translate(0, 0);
         g2d.dispose();
	}
	
//	@Override
//	public void  paint(Graphics graphics) {
//		super.paint(graphics);// para limpiar la pantalla
//		jPanelDistance.showLine(graphics);
//		jPanelDistance.showOvale(graphics);
//		jPanelDistance.showString(graphics);
//	}
	
}
