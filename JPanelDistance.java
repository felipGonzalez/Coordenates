package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Commands;
import controller.ConstantsDistance;
import model.Coordenate;
import model.Figure;

public class JPanelDistance extends JPanel {
	private JPanelCoordenate jPanelCoordenate;
	private JPanelCoordenate jPanelCoordenateTwo;
	private JLabel jLabelDistance;
	private FigureUI figureOne;
	private FigureUI figureTwo;
	private boolean printCoordenate;
	private Color colorLine;
	private Color colorPoint;
	private String format;
	private DecimalFormat formateador;
	private Font fontLine;

	public JPanelDistance() {
		jPanelCoordenate = new JPanelCoordenate(ConstantsDistance.APP_NAME_COORDENATE_ONE);
		jPanelCoordenateTwo = new JPanelCoordenate(ConstantsDistance.APP_NAME_COORDENATE_TWO);
		jLabelDistance = new JLabel();
		init();
	}

	private void init() {
		fontLine = new Font("Monospaced", Font.PLAIN, 12);
		jPanelCoordenate.setEvents(Commands.COMMAND_ADD_VALUE_X_INIT, Commands.COMMAND_ADD_VALUE_Y_INIT);
		jPanelCoordenateTwo.setEvents(Commands.COMMAND_ADD_VALUE_X_FINAL, Commands.COMMAND_ADD_VALUE_Y_FINAL);
		this.add(this.jPanelCoordenate);
		this.add(this.jPanelCoordenateTwo);
		this.add(this.jLabelDistance);
		this.jLabelDistance.setBorder(BorderFactory.createTitledBorder(ConstantsDistance.APP_NAME_COORDENATE_DISRANCE));
		figureOne = new FigureUI(new Figure(ConstantsDistance.SIZE_FIGURE));
		figureTwo = new FigureUI(new Figure(ConstantsDistance.SIZE_FIGURE));
		printCoordenate = false;
		colorLine = ConstantsDistance.APP_COLOR_LINE;
		colorPoint = ConstantsDistance.APP_COLOR_POINT;
		this.format = ConstantsDistance.APP_NUM_FORMAT_DECIMAL;
		this.formateador = new DecimalFormat(format);
	}

	public void set(Coordenate coordenateOne, Coordenate coordenateTwo) {
		this.jPanelCoordenate.set(coordenateOne);
		this.jPanelCoordenateTwo.set(coordenateTwo);
		if (jPanelCoordenate.get() != null && jPanelCoordenateTwo.get() != null) {
			this.jLabelDistance.setText("" + (jPanelCoordenate.get().getDistance(jPanelCoordenateTwo.get())));
		}

	}
	
	
	
	public Font getFontLine() {
		return fontLine;
	}

	public void setFontLine(Font fontLine) {
		this.fontLine = fontLine;
		this.jLabelDistance.setFont(fontLine);
		this.jPanelCoordenate.setFontTextField(fontLine);
		this.jPanelCoordenateTwo.setFontTextField(fontLine);
	}

	public void set() {
		this.jLabelDistance.setText("" + jPanelCoordenate.get().getDistance(jPanelCoordenateTwo.get()));
	}

	public double get() {
		return Double.parseDouble(jLabelDistance.getText());
	}

	public Coordenate getCoordenateOne() {
		return jPanelCoordenate.get();
	}

	public Coordenate getCoordenateTwo() {
		return jPanelCoordenateTwo.get();
	}

	public JPanelCoordenate getjPanelCoordenateOne() {
		return jPanelCoordenate;
	}

	public JPanelCoordenate getjPanelCoordenateTwo() {
		return jPanelCoordenateTwo;
	}

	public FigureUI getFigureOne() {
		return figureOne;
	}

	public void setFigureOne(FigureUI figureOne) {
		this.figureOne = figureOne;
	}

	public FigureUI getFigureTwo() {
		return figureTwo;
	}

	public void setFigureTwo(FigureUI figureTwo) {
		this.figureTwo = figureTwo;
	}

	public Color getColorLine() {
		return colorLine;
	}

	public void setColorLine(Color colorLine) {
		this.colorLine = colorLine;
	}

	public Color getColorPoint() {
		return colorPoint;
	}

	public void setColorPoint(Color colorPoint) {
		this.colorPoint = colorPoint;
	}

	public boolean isPrintCoordenate() {
		return printCoordenate;
	}

	public boolean setPrintCoordenate() {
		if (!printCoordenate) {
			printCoordenate = true;
			return this.printCoordenate;
		} else {
			return this.printCoordenate = false;
		}
	}

	public void setNumDecimal(int numDecimal) {
		if (numDecimal <= 14) {
			format = ConstantsDistance.APP_NUM_FORMAT_DECIMAL;
			for (int i = 0; i < numDecimal; i++) {
				format += "#";
			}
		}
	}

	protected void showOvale(Graphics2D graphics2d) {
		graphics2d.setColor(colorPoint);
		if (figureOne != null && figureTwo != null) {
			graphics2d.fillOval((int)figureOne.getFigure().getCoordenate().getValueX()-figureOne.getFigure().getSize()/2,
					(int)figureOne.getFigure().getCoordenate().getValueY()-figureOne.getFigure().getSize()/2,
					figureOne.getFigure().getSize(), figureOne.getFigure().getSize());
			
			 graphics2d.fillOval((int)figureTwo.getFigure().getCoordenate().getValueX()-figureTwo.getFigure().getSize()/2,
						(int)figureTwo.getFigure().getCoordenate().getValueY()-figureTwo.getFigure().getSize()/2,
						figureTwo.getFigure().getSize(), figureTwo.getFigure().getSize());
		}

		if (printCoordenate) {
			graphics2d.drawString(
					"x : " + figureOne.getFigure().getCoordenate().getValueX() + " y: "
							+ figureOne.getFigure().getCoordenate().getValueY(),
					(int) figureOne.getFigure().getCoordenate().getValueX() - figureOne.getFigure().getSize() / 2,
					(int) figureOne.getFigure().getCoordenate().getValueY() - figureOne.getFigure().getSize() / 2);
			graphics2d.drawString(
					"x : " + figureTwo.getFigure().getCoordenate().getValueX() + " y: "
							+ figureTwo.getFigure().getCoordenate().getValueY(),
					(int) figureTwo.getFigure().getCoordenate().getValueX() - figureTwo.getFigure().getSize() / 2,
					(int) figureTwo.getFigure().getCoordenate().getValueY() - figureTwo.getFigure().getSize() / 2);
		}

	}

	private double getPending() {
		double angle = 0, pending = (jPanelCoordenateTwo.getJTextFieldY() - jPanelCoordenate.getJTextFieldY())
				/ (jPanelCoordenateTwo.getJTextFieldX() - jPanelCoordenate.getJTextFieldX());
		angle = (Math.atan(pending));
		return angle;
	}

	protected void showLine(Graphics2D graphics2d) {
		System.out.println(jPanelCoordenate.getJTextFieldX() + "  " + jPanelCoordenate.getJTextFieldY() + " "
				+ jPanelCoordenateTwo.getJTextFieldX() + "  " + jPanelCoordenateTwo.getJTextFieldY());
		graphics2d.setColor(colorLine);
		graphics2d.drawLine((int) jPanelCoordenate.getJTextFieldX(), (int) jPanelCoordenate.getJTextFieldY(),
				(int) jPanelCoordenateTwo.getJTextFieldX(), (int) jPanelCoordenateTwo.getJTextFieldY());
		figureOne.getFigure().getCoordenate().setCoordenates(jPanelCoordenate.getJTextFieldX(),
				jPanelCoordenate.getJTextFieldY());
		figureTwo.getFigure().getCoordenate().setCoordenates(jPanelCoordenateTwo.getJTextFieldX(),
				jPanelCoordenateTwo.getJTextFieldY());
		System.out.println(
				figureTwo.getFigure().getCoordenate().getValueX() + +figureTwo.getFigure().getCoordenate().getValueY());

	}

	
	
	
	public void showString(Graphics2D graphics2d) {
		graphics2d.setFont(fontLine);
		Graphics2D gd = graphics2d;
		formateador = new DecimalFormat(format);
		if (jPanelCoordenate.getJTextFieldX() < jPanelCoordenateTwo.getJTextFieldX()) {
			AffineTransform affineTransform = AffineTransform.getRotateInstance(getPending(),
					(int) (jPanelCoordenate.getJTextFieldX() + jPanelCoordenateTwo.getJTextFieldX()) / 2,
					(int) (jPanelCoordenate.getJTextFieldY() + jPanelCoordenateTwo.getJTextFieldY()) / 2);
			gd.transform(affineTransform);
			gd.drawString(String.valueOf(formateador.format(Double.parseDouble(jLabelDistance.getText()))),
					(int) (jPanelCoordenate.getJTextFieldX() + jPanelCoordenateTwo.getJTextFieldX()) / 2,
					(int) (jPanelCoordenate.getJTextFieldY() + jPanelCoordenateTwo.getJTextFieldY()) / 2);
			gd.dispose();
		} else {
			AffineTransform affineTransform = AffineTransform.getRotateInstance(getPending(),
					(int) (jPanelCoordenateTwo.getJTextFieldX() + jPanelCoordenate.getJTextFieldX()) / 2,
					(int) (jPanelCoordenateTwo.getJTextFieldY() + jPanelCoordenate.getJTextFieldY()) / 2);
			gd.transform(affineTransform);
			gd.drawString(String.valueOf(formateador.format(Double.parseDouble(jLabelDistance.getText()))),
					(int) (jPanelCoordenateTwo.getJTextFieldX() + jPanelCoordenate.getJTextFieldX()) / 2,
					(int) (jPanelCoordenateTwo.getJTextFieldY() + jPanelCoordenate.getJTextFieldY()) / 2);
			gd.dispose();

		}
	}

}
