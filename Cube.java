import java.util.ArrayList;
import java.util.Random;

public class Cube {
	Face front, back, up, down, right, left;
	
	// constructor that initializes a complete cube
	public Cube(){	
		front = new Face("blue");
		back = new Face("green");
		up = new Face("white");
		down = new Face("yellow");
		right = new Face("red");
		left = new Face("orange");
	}
	
	// given a String array with [6][3][3] size of colors, initialize the 6 faces
	// first color = front of cube
	// second color = back of cube
	// third color = up of cube
	// fourth color = down of cube
	// fifth color = right of cube
	// sixth color = left of cube
	public Cube(String[][][] colors){
		String[][] frontColors = new String[3][3];
		String[][] backColors = new String[3][3];
		String[][] upColors = new String[3][3];
		String[][] downColors = new String[3][3];
		String[][] rightColors = new String[3][3];
		String[][] leftColors = new String[3][3];
		
		// Sets the colors
		for(int c = 0; c < 6; c++){
			for(int i = 0; i < 3; i++){
				for(int j = 0; j < 3; j++){
					if(c == 0){
						frontColors[i][j] = colors[c][i][j];
					}else if(c == 1){
						backColors[i][j] = colors[c][i][j];
					}else if(c == 2){
						upColors[i][j] = colors[c][i][j];
					}else if(c == 3){
						downColors[i][j] = colors[c][i][j];
					}else if(c == 4){
						rightColors[i][j] = colors[c][i][j];
					}else{
						leftColors[i][j] = colors[c][i][j];
					}
				}
			}
		}
		
		// Initialize the faces
		front = new Face(frontColors);
		back = new Face(backColors);
		up = new Face(upColors);
		down = new Face(downColors);
		right = new Face(rightColors);
		left = new Face(leftColors);
		
	}
	
	// function to get all the faces with the colors
	public ArrayList<Face> getFaces() {
		
		ArrayList<Face> faces = new ArrayList<Face>();
		faces.add(front);
		faces.add(back);
		faces.add(up);
		faces.add(down);
		faces.add(right);
		faces.add(left);		
		return faces;
	}
	
	// Method that returns true if the cube is complete (all faces with same colors)
	public boolean isCubeComplete(){
		if(front.isComplete() && back.isComplete() && up.isComplete() 
				&& down.isComplete() && right.isComplete() && left.isComplete()){
			return true;
		}
		return false;
	}
	
	// Method that randomly rotates the cube
	public void randomizeCube(){
		// gets the current clock time as a seed to make it more random
		Random rand = new Random(System.currentTimeMillis());
		
		// randomly rotates the cube, performing 500 moves
		int number;
		for(int i = 0; i < 500; i++){
			// gets a random number between 0 and 11
			number = rand.nextInt(12);
			if(number == 0){
				rotateFrontClockwise();
			}else if(number == 1){
				rotateBackClockwise();
			}else if(number == 2){
				rotateUpClockwise();
			}else if(number == 3){
				rotateDownClockwise();
			}else if(number == 4){
				rotateRightClockwise();
			}else if(number == 5){
				rotateLeftClockwise();
			}else if(number == 6){
				rotateFrontCounterClockwise();
			}else if(number == 7){
				rotateBackCounterClockwise();
			}else if(number == 8){
				rotateUpCounterClockwise();
			}else if(number == 9){
				rotateDownCounterClockwise();
			}else if(number == 10){
				rotateRightCounterClockwise();
			}else if(number == 11){
				rotateLeftCounterClockwise();
			}
		}
	}
	
	// Methods below: rotate a certain face Clockwise or counter Clockwise
	public void rotateFrontClockwise(){
		// rotates the face clockwise
		front.rotateClockwise();
		
		// holds the lower row of up
		String[] tempRow;
		tempRow = up.getDownRow();
		
		// rotate the colors of the row that will be affected
		up.setDownRow(left.getRightRow(), true);
		left.setRightRow(down.getUpRow(), false);
		down.setUpRow(right.getLeftRow(), true);
		right.setLeftRow(tempRow, false);
		
	}
	
	public void rotateFrontCounterClockwise(){
		// rotates the face counter clockwise
		front.rotateCounterClockwise();

		// holds the lower row of up
		String[] tempRow;
		tempRow = up.getDownRow();

		// rotate the colors of the rows that will be affected
		up.setDownRow(right.getLeftRow(), false);
		right.setLeftRow(down.getUpRow(), true);
		down.setUpRow(left.getRightRow(), false);
		left.setRightRow(tempRow, true);
	}
	
	public void rotateBackClockwise(){
		// rotates the face clockwise
		back.rotateClockwise();
		
		// holds the upper row of up
		String[] tempRow;
		tempRow = up.getUpRow();
		
		// rotate the colors of the rows that will be affected
		up.setUpRow(right.getRightRow(), false);
		right.setRightRow(down.getDownRow(), true);
		down.setDownRow(left.getLeftRow(), false);
		left.setLeftRow(tempRow, true);
	}
	
	public void rotateBackCounterClockwise(){
		// rotates the face counter clockwise
		back.rotateCounterClockwise();

		// holds the upper row of up
		String[] tempRow;
		tempRow = up.getUpRow();

		// rotate the colors of the rows that will be affected
		up.setUpRow(left.getLeftRow(), true);
		left.setLeftRow(down.getDownRow(), false);
		down.setDownRow(right.getRightRow(), true);
		right.setRightRow(tempRow, false);
	}
	
	public void rotateUpClockwise(){
		// rotates the face clockwise
		up.rotateClockwise();
		
		// holds the upper row of front
		String[] tempRow;
		tempRow = front.getUpRow();
		
		// rotate the colors of the rows that will be affected
		front.setUpRow(right.getUpRow(), false);
		right.setUpRow(back.getUpRow(), false);
		back.setUpRow(left.getUpRow(), false);
		left.setUpRow(tempRow, false);
	}
	
	public void rotateUpCounterClockwise(){
		// rotates the face counter clockwise
		up.rotateCounterClockwise();

		// holds the upper row of front
		String[] tempRow;
		tempRow = front.getUpRow();

		// rotate the colors of the rows that will be affected
		front.setUpRow(left.getUpRow(), false);
		left.setUpRow(back.getUpRow(), false);
		back.setUpRow(right.getUpRow(), false);
		right.setUpRow(tempRow, false);
	}
	
	public void rotateDownClockwise(){
		// rotates the face clockwise
		down.rotateClockwise();

		// holds the lower row of front
		String[] tempRow;
		tempRow = front.getDownRow();

		// rotate the colors of the rows that will be affected
		front.setDownRow(left.getDownRow(), false);
		left.setDownRow(back.getDownRow(), false);
		back.setDownRow(right.getDownRow(), false);
		right.setDownRow(tempRow, false);
	}
	
	public void rotateDownCounterClockwise(){
		// rotates the face counter clockwise
		down.rotateCounterClockwise();

		// holds the lower row of front
		String[] tempRow;
		tempRow = front.getDownRow();

		// rotate the colors of the rows that will be affected
		front.setDownRow(right.getDownRow(), false);
		right.setDownRow(back.getDownRow(), false);
		back.setDownRow(left.getDownRow(), false);
		left.setDownRow(tempRow, false);
	}
	
	public void rotateRightClockwise(){
		// rotates the face clockwise
		right.rotateClockwise();

		// holds the right row of front
		String[] tempRow;
		tempRow = front.getRightRow();
		
		// rotate the colors of the rows that will be affected
		front.setRightRow(down.getRightRow(), false);
		down.setRightRow(back.getLeftRow(), true);
		back.setLeftRow(up.getRightRow(), true);
		up.setRightRow(tempRow, false);
	}
	
	public void rotateRightCounterClockwise(){
		// rotates the face clockwise
		right.rotateCounterClockwise();

		// holds the right row of front
		String[] tempRow;
		tempRow = front.getRightRow();
			
		// rotate the colors of the rows that will be affected
		front.setRightRow(up.getRightRow(), false);
		up.setRightRow(back.getLeftRow(), true);
		back.setLeftRow(down.getRightRow(), true);
		down.setRightRow(tempRow, false);
	}
	
	public void rotateLeftClockwise(){
		// rotates the face clockwise
		left.rotateClockwise();

		// holds the left row of front
		String[] tempRow;
		tempRow = front.getLeftRow();
					
		// rotate the colors of the rows that will be affected
		front.setLeftRow(up.getLeftRow(), false);
		up.setLeftRow(back.getRightRow(), true);
		back.setRightRow(down.getLeftRow(), true);
		down.setLeftRow(tempRow, false);
	}
	
	public void rotateLeftCounterClockwise(){
		// rotates the face counter clockwise
		left.rotateCounterClockwise();
				
		// holds the left row of front
		String[] tempRow;
		tempRow = front.getLeftRow();
							
		// rotate the colors of the rows that will be affected
		front.setLeftRow(down.getLeftRow(), false);
		down.setLeftRow(back.getRightRow(), true);
		back.setRightRow(up.getLeftRow(), true);
		up.setLeftRow(tempRow, false);
	}

	// Method that prints the current state of the cube as ASCII characters
	public void printCurrentCube(){
	   /* Model of what this method is printing:
		* 
		*               R | R | R
		*   	       -----------
		*   		    R | R | R
		*   	       -----------
		*   		    R | R | R
		*   		  -------------
		*  B | B | B | W | W | W | G | G | G | Y | Y | Y 
		* -----------|-----------|-----------|-----------
		*  B | B | B | W | W | W | G | G | G | Y | Y | Y 
		* -----------|-----------|-----------|-----------
		*  B | B | B | W | W | W | G | G | G | Y | Y | Y 
		*            -------------  
		*    	 		O | O | O
		*   	       -----------
		*    	 		O | O | O
		*   	       -----------
		*    	 		O | O | O
	    *    
		*/

		System.out.println("Current state of cube:");
		System.out.println();

		// Prints the "up" face
		System.out.print("            ");
		up.printFirstRow();
		System.out.println();

		System.out.print("            ");
		System.out.println("-----------");

		System.out.print("            ");
		up.printSecondRow();
		System.out.println();

		System.out.print("            ");
		System.out.println("-----------");

		System.out.print("            ");
		up.printThirdRow();
		System.out.println();

		System.out.print("           ");
		System.out.println("-------------"); // Separator for the "up" face

		// Prints the second whole part, which is left, front, right and back respectively.
		// Prints first row:
		left.printFirstRow();
		System.out.print("|");
		front.printFirstRow();
		System.out.print("|");
		right.printFirstRow();
		System.out.print("|");
		back.printFirstRow();
		System.out.println();

		System.out.println("-----------|-----------|-----------|-----------");

		// Prints second row:
		left.printSecondRow();
		System.out.print("|");
		front.printSecondRow();
		System.out.print("|");
		right.printSecondRow();
		System.out.print("|");
		back.printSecondRow();
		System.out.println();

		System.out.println("-----------|-----------|-----------|-----------");

		// Prints third row:
		left.printThirdRow();
		System.out.print("|");
		front.printThirdRow();
		System.out.print("|");
		right.printThirdRow();
		System.out.print("|");
		back.printThirdRow();
		System.out.println();

		System.out.print("           ");
		System.out.println("-------------"); // separator for the "down" face

		// Prints the "down" face
		System.out.print("            ");
		down.printFirstRow();
		System.out.println();

		System.out.print("            ");
		System.out.println("-----------");

		System.out.print("            ");
		down.printSecondRow();
		System.out.println();

		System.out.print("            ");
		System.out.println("-----------");

		System.out.print("            ");
		down.printThirdRow();
		System.out.println();

		System.out.println();
	}
	
	// Method that solves the Rubik's cube using the most simple algorithm
	// Takes a boolean that determines if we print the 
	// (A better algorithm may be implemented in the future)
	public void simpleAlgorithmSolveCube(boolean printMoves){
			
		String[] upDownRow = up.getDownRow();
		// if the lower edge is not the correct color
		if(!upDownRow[1].equals(up.getCenterColor())){
			
			//String[] frontUpRow = front.getUpRow(); 
			// TODO: create a method that given two colors, finds an edge that has the two colors
		}
	}
}
