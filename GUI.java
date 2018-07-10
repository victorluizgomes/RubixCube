import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GUI extends Application {

	public static void main(String[] args) {
		launch(args); // TODO: Needed?
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		BorderPane all = new BorderPane();
		
		Canvas canvas = new Canvas(800, 800);
		all.setCenter(canvas);
		
		Cube cube = new Cube();
		cube.printCurrentCube();
		//cube.randomizeCube();
		drawOnCanvas(canvas, cube);
		
		Scene scene = new Scene(all, 800, 800);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	//draws the squares from the rubiks cube
	private void drawOnCanvas(Canvas canvas, Cube cube) {
		
		cube.rotateUpClockwise(); // brings the upper row of front to left
		cube.printCurrentCube();
		ArrayList<Face> faces = cube.getFaces();
		GraphicsContext gc = canvas.getGraphicsContext2D();
		
		drawMiddleFace(faces, gc, 2);	
		drawRightToMiddleFace(faces, gc, 2);
		drawLeftToMiddleFace(faces, gc, 2);
		drawUpToMiddleFace(faces, gc, 2);
		drawDownToMiddleFace(faces, gc, 2);
		
	}
	
	// The face that is in the front at the moment
	// The faces index are(0: front, 1: back, 2: up, 3: down, 4: right, 5: left) 
	private void drawMiddleFace(ArrayList<Face> faces, GraphicsContext gc, int faceInMiddle) {
		Color[][] colors = faces.get(faceInMiddle).getWholeFaceColor();
		SquareGUI[][] squares = new SquareGUI[3][3];
		for(int i = 0; i < colors.length; i++) {
			for(int j = 0; j < colors[0].length; j++) {
				
				// Cube will be 200 x 200, each square has 60 width and 10 in between squares
				squares[i][j] = new SquareGUI(colors[i][j], 
						new Point(300 + (j * 70), 300 + (i * 70)), 60, 5);
			}
		}
		
		// draw the squares
		for(int i = 0; i < colors.length; i++) {
			for(int j = 0; j < colors[0].length; j++) {
				
				squares[i][j].draw(gc);
			}
		}
	}
	
	// draws the face that is directly to the right of the face that is in the middle
	// The faces index are(0: front, 1: back, 2: up, 3: down, 4: right, 5: left) 
	private void drawRightToMiddleFace(ArrayList<Face> faces, GraphicsContext gc, int faceInMiddle) {
		
		int index = 0;
		if(faceInMiddle == 0 || faceInMiddle == 3 || faceInMiddle == 2) {
			index = 4;
		}else if(faceInMiddle == 1) {
			index = 5;
		}else if(faceInMiddle == 4) {
			index = 1;
		}else if(faceInMiddle == 5) {
			index = 0;
		}
		
		Color[][] colors = faces.get(index).getWholeFaceColor();
		SquareGUI[][] squares = new SquareGUI[3][3];
		for(int i = 0; i < colors.length; i++) {
			for(int j = 0; j < colors[0].length; j++) {
				
				squares[i][j] = new SquareGUI(colors[i][j], 
						new Point(600 + (j * 35), 350 + (i * 35)), 30, 2);
			}
		}
		
		// draw the squares
		for(int i = 0; i < colors.length; i++) {
			for(int j = 0; j < colors[0].length; j++) {
				
				squares[i][j].draw(gc);
			}
		}
	}
	
	// draws the face that is directly to the left of the face that is in the middle
	// The faces index are(0: front, 1: back, 2: up, 3: down, 4: right, 5: left) 
	private void drawLeftToMiddleFace(ArrayList<Face> faces, GraphicsContext gc, int faceInMiddle) {
		
		int index = 0;
		if(faceInMiddle == 0 || faceInMiddle == 3 || faceInMiddle == 2) {
			index = 5;
		}else if(faceInMiddle == 1) {
			index = 4;
		}else if(faceInMiddle == 4) {
			index = 0;
		}else if(faceInMiddle == 5) {
			index = 1;
		}
		
		Color[][] colors = faces.get(index).getWholeFaceColor();
		SquareGUI[][] squares = new SquareGUI[3][3];
		for(int i = 0; i < colors.length; i++) {
			for(int j = 0; j < colors[0].length; j++) {
				
				squares[i][j] = new SquareGUI(colors[i][j], 
						new Point(100 + (j * 35), 350 + (i * 35)), 30, 2);
			}
		}
		
		// draw the squares
		for(int i = 0; i < colors.length; i++) {
			for(int j = 0; j < colors[0].length; j++) {
				
				squares[i][j].draw(gc);
			}
		}
	}
	
	// draws the face that is directly up of the face that is in the middle
	// The faces index are(0: front, 1: back, 2: up, 3: down, 4: right, 5: left) 
	private void drawUpToMiddleFace(ArrayList<Face> faces, GraphicsContext gc, int faceInMiddle) {
		
		int index = 0;
		if(faceInMiddle == 0 || faceInMiddle == 1 || faceInMiddle == 4 || faceInMiddle == 5) {
			index = 2;
		}else if(faceInMiddle == 2) {
			index = 1;
		}else if(faceInMiddle == 3) {
			index = 0;
		}
		
		Color[][] colors = faces.get(index).getWholeFaceColor();
		SquareGUI[][] squares = new SquareGUI[3][3];
		for(int i = 0; i < colors.length; i++) {
			for(int j = 0; j < colors[0].length; j++) {
				
				squares[i][j] = new SquareGUI(colors[i][j], 
						new Point(350 + (j * 35), 100 + (i * 35)), 30, 2);
			}
		}
		
		// draw the squares
		for(int i = 0; i < colors.length; i++) {
			for(int j = 0; j < colors[0].length; j++) {
				
				squares[i][j].draw(gc);
			}
		}
	}
	
	// draws the face that is directly up of the face that is in the middle
	// The faces index are(0: front, 1: back, 2: up, 3: down, 4: right, 5: left) 
	private void drawDownToMiddleFace(ArrayList<Face> faces, GraphicsContext gc, int faceInMiddle) {
		
		int index = 0;
		if(faceInMiddle == 0 || faceInMiddle == 1 || faceInMiddle == 4 || faceInMiddle == 5) {
			index = 3;
		}else if(faceInMiddle == 2) {
			index = 0;
		}else if(faceInMiddle == 3) {
			index = 1;
		}
		
		Color[][] colors = faces.get(index).getWholeFaceColor();
		SquareGUI[][] squares = new SquareGUI[3][3];
		for(int i = 0; i < colors.length; i++) {
			for(int j = 0; j < colors[0].length; j++) {
				
				squares[i][j] = new SquareGUI(colors[i][j], 
						new Point(350 + (j * 35), 600 + (i * 35)), 30, 2);
			}
		}
		
		// draw the squares
		for(int i = 0; i < colors.length; i++) {
			for(int j = 0; j < colors[0].length; j++) {
				
				squares[i][j].draw(gc);
			}
		}
	}

	// Converts a javaFx color to awt color
	public java.awt.Color fx2Awt(javafx.scene.paint.Color fxColor) {
		int r = (int) (255 * fxColor.getRed());
		int g = (int) (255 * fxColor.getGreen());
		int b = (int) (255 * fxColor.getBlue());
		java.awt.Color awtColor = new java.awt.Color(r, g, b);
		return awtColor;
	}
}
