package UI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

import javax.swing.JPanel;

import controller.ConstantsDistance;

public class JPanelMap extends JPanel{

	private static JPanelMap jPanelMap;
	private JPanelDistance jPanelDistance;
	private double zoom;
	
	private JPanelMap() {
		this.zoom = 0.1;
	}
	
	public static JPanelMap getIntence() {
		if(jPanelMap == null){
			return jPanelMap = new JPanelMap();
		}
		return jPanelMap;
	}
	
	
	
	public JPanelDistance getjPanelDistance() {
		return jPanelDistance;
	}

	public void setjPanelDistance(JPanelDistance jPanelDistance) {
		this.jPanelDistance = jPanelDistance;
	}

	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);// para limpiar la pantalla
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
	
}
