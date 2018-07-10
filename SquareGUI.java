import java.awt.Color;
import java.awt.Point;

import javafx.scene.canvas.GraphicsContext;

public class SquareGUI {
	
	private Point p1;
	private double width;
	private Color color;
	private int strokeSize;
	
	public SquareGUI(Color color, Point p1, double width, int strokeSize) {
		this.width = width;
		this.color = color;
		this.p1 = p1;
		this.strokeSize = strokeSize;
	}
	
	// draws the actual square
	public void draw(GraphicsContext gc) {
		gc.setLineWidth(0);
		gc.setFill(awt2Fx(color));
		gc.fillRect(p1.getX(), p1.getY(), width, width);
		
		gc.setLineWidth(strokeSize);
		gc.setStroke(awt2Fx(Color.BLACK));
		gc.strokeRect(p1.getX(), p1.getY(), width, width);
	}

	// getters and setters
	public Point getpOne() {
		return p1;
	}

	public void setpOne(Point pOne) {
		this.p1 = pOne;
	}
	
	public double getW() {
		return width;
	}

	public void setW(double w) {
		this.width = w;
	}
	
	// Awt Color to JavaFX Color converter
	public javafx.scene.paint.Color awt2Fx(Color awtColor) {
		int r = awtColor.getRed();
		int g = awtColor.getGreen();
		int b = awtColor.getBlue();
		javafx.scene.paint.Color fxColor = javafx.scene.paint.Color.rgb(r, g, b); // , opacity);
		return fxColor;
	}
	
}
