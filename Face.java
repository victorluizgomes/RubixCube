public class Face {
	Square[][] cubeFace = new Square[3][3];
	
	// given one color start face all with the same color
	public Face(String color){
		for(int row = 0; row < 3; row++){
			for(int col = 0; col < 3; col++){
				if(row == 1 && col == 1){
					cubeFace[row][col] = new Square(color, "center");
				}else if(row == col || (row == 2 && col == 0) || (row == 0 && col == 2)){
					cubeFace[row][col] = new Square(color, "corner");
				}else{
					cubeFace[row][col] = new Square(color, "side");
				}
			}
		}
	}
	
	// Given 2D array of colors, initialize face
	public Face(String[][] color){
		for(int row = 0; row < 3; row++){
			for(int col = 0; col < 3; col++){
				if(row == 1 && col == 1){
					cubeFace[row][col] = new Square(color[row][col], "center");
				}else if(row == col || (row == 2 && col == 0) || (row == 0 && col == 2)){
					cubeFace[row][col] = new Square(color[row][col], "corner");
				}else{
					cubeFace[row][col] = new Square(color[row][col], "side");
				}
			}
		}
	}
	
	// Method that rotates the face clockwise
	public void rotateClockwise(){
		
		Square[][] cubeFaceTemp = new Square[3][3];
		
		// sets a temporary face as the clockwise rotation of cubeFace
		int j;
		for(int row = 0; row < 3; row++){
			j = 2;
			for(int col = 0; col < 3; col++){
				cubeFaceTemp[row][col] = cubeFace[j][row];
				j--; 
			}
		}
		
		// sets cubeFace to its clockwise rotation
		for(int row = 0; row < 3; row++){
			for(int col = 0; col < 3; col++){
				cubeFace[row][col] = cubeFaceTemp[row][col];
			}
		}
	}
	
	// Method that rotates the face counter clockwise
	public void rotateCounterClockwise(){
		Square[][] cubeFaceTemp = new Square[3][3];
		
		// sets a temporary face as the counter clockwise rotation of cubeFace
		int j = 2;
		for(int row = 0; row < 3; row++){
			for(int col = 0; col < 3; col++){
				cubeFaceTemp[row][col] = cubeFace[col][j];
			}
			j--;
		}
		
		// sets cubeFace to its counter clockwise rotation
		for(int row = 0; row < 3; row++){
			for(int col = 0; col < 3; col++){
				cubeFace[row][col] = cubeFaceTemp[row][col];
			}
		}
	}
	
	// gets the color of the middle square in the Face
	public String getCenterColor(){
		return cubeFace[1][1].getColor();
	}
	
	// returns the middle row
	public String[] getMiddleRow(){
		String[] middleRow = new String[3];
		
		middleRow[0] = cubeFace[1][0].getColor();
		middleRow[1] = cubeFace[1][1].getColor();
		middleRow[2] = cubeFace[1][2].getColor();
		return middleRow;
	}
	
	// Method that changes the whole lower row
	public void setDownRow(String[] downRow, boolean control){
		
		// if control is true, the first element becomes the last of the row
		if(control){
			cubeFace[2][2].setColor(downRow[0]);
			cubeFace[2][2].setSquareType("corner");
			cubeFace[2][1].setColor(downRow[1]);
			cubeFace[2][1].setSquareType("side");
			cubeFace[2][0].setColor(downRow[2]);
			cubeFace[2][0].setSquareType("corner");
		} else {
			cubeFace[2][0].setColor(downRow[0]);
			cubeFace[2][0].setSquareType("corner");
			cubeFace[2][1].setColor(downRow[1]);
			cubeFace[2][1].setSquareType("side");
			cubeFace[2][2].setColor(downRow[2]);
			cubeFace[2][2].setSquareType("corner");
		}
	}
	
	// Method that returns the whole lower row
	public String[] getDownRow(){
		String[] downRow = new String[3];
		
		downRow[0] = cubeFace[2][0].getColor();
		downRow[1] = cubeFace[2][1].getColor();
		downRow[2] = cubeFace[2][2].getColor();
				
		return downRow;
	}
	
	// Method that changes the whole upper row
	public void setUpRow(String[] upRow, boolean control) {
		
		// if control is true, the first element becomes the last of the row
		if (control){
			cubeFace[0][2].setColor(upRow[0]);
			cubeFace[0][2].setSquareType("corner");
			cubeFace[0][1].setColor(upRow[1]);
			cubeFace[0][1].setSquareType("side");
			cubeFace[0][0].setColor(upRow[2]);
			cubeFace[0][0].setSquareType("corner");
		} else {
			cubeFace[0][0].setColor(upRow[0]);
			cubeFace[0][0].setSquareType("corner");
			cubeFace[0][1].setColor(upRow[1]);
			cubeFace[0][1].setSquareType("side");
			cubeFace[0][2].setColor(upRow[2]);
			cubeFace[0][2].setSquareType("corner");
		}
	}
	
	// Method that returns the whole upper row
	public String[] getUpRow() {
		String[] upRow = new String[3];

		upRow[0] = cubeFace[0][0].getColor();
		upRow[1] = cubeFace[0][1].getColor();
		upRow[2] = cubeFace[0][2].getColor();

		return upRow;
	}

	// Method that changes the whole right row
	public void setRightRow(String[] rightRow, boolean control) {
		
		// if control is true, the first element becomes the last of the row
		if(control){
			cubeFace[2][2].setColor(rightRow[0]);
			cubeFace[2][2].setSquareType("corner");
			cubeFace[1][2].setColor(rightRow[1]);
			cubeFace[1][2].setSquareType("side");
			cubeFace[0][2].setColor(rightRow[2]);
			cubeFace[0][2].setSquareType("corner");
		} else {
			cubeFace[0][2].setColor(rightRow[0]);
			cubeFace[0][2].setSquareType("corner");
			cubeFace[1][2].setColor(rightRow[1]);
			cubeFace[1][2].setSquareType("side");
			cubeFace[2][2].setColor(rightRow[2]);
			cubeFace[2][2].setSquareType("corner");
		}
	}
	
	// Method that returns the whole right row
	public String[] getRightRow() {
		String[] rightRow = new String[3];

		rightRow[0] = cubeFace[0][2].getColor();
		rightRow[1] = cubeFace[1][2].getColor();
		rightRow[2] = cubeFace[2][2].getColor();

		return rightRow;
	}

	// Method that changes the whole left row
	public void setLeftRow(String[] leftRow, boolean control) {
		
		// if control is true, the first element becomes the last of the row
		if(control){
			cubeFace[2][0].setColor(leftRow[0]);
			cubeFace[2][0].setSquareType("corner");
			cubeFace[1][0].setColor(leftRow[1]);
			cubeFace[1][0].setSquareType("side");
			cubeFace[0][0].setColor(leftRow[2]);
			cubeFace[0][0].setSquareType("corner");
		} else {
			cubeFace[0][0].setColor(leftRow[0]);
			cubeFace[0][0].setSquareType("corner");
			cubeFace[1][0].setColor(leftRow[1]);
			cubeFace[1][0].setSquareType("side");
			cubeFace[2][0].setColor(leftRow[2]);
			cubeFace[2][0].setSquareType("corner");
		}
	}
	
	// Method that returns the whole left row
	public String[] getLeftRow() {
		String[] leftRow = new String[3];

		leftRow[0] = cubeFace[0][0].getColor();
		leftRow[1] = cubeFace[1][0].getColor();
		leftRow[2] = cubeFace[2][0].getColor();

		return leftRow;
	}
	
	// Method that returns true if all colors are the same in the face
	public boolean isComplete(){
		String middleColor = cubeFace[1][1].getColor();
		
		for(int row = 0; row < 3; row++){
			for(int col = 0; col < 3; col++){
				if(!cubeFace[row][col].getColor().equals(middleColor)){
					return false;
				}
			}
		}
		return true;
	}
	
	// Method that prints a face of the cube
	public void printWholeFace(){
		
		boolean notFirst = false;
		for(int i = 0; i < 3; i++){
			
			// if it is the first run don't make the line in between rows
			if(notFirst){
				System.out.println("-----------");
			}else{
				notFirst = true;
			}
			
			// prints a row 
			System.out.print(" " + cubeFace[i][0].getColorInit() + " |");
			System.out.print(" " + cubeFace[i][1].getColorInit() + " ");
			System.out.println("| " + cubeFace[i][2].getColorInit() + " ");
		}
	}
	
	// Method that prints a row of the cube
	public void printFirstRow(){
		System.out.print(" " + cubeFace[0][0].getColorInit() + " |");
		System.out.print(" " + cubeFace[0][1].getColorInit() + " ");
		System.out.print("| " + cubeFace[0][2].getColorInit() + " ");
	}
	
	// Method that prints a row of the cube
	public void printSecondRow(){
		System.out.print(" " + cubeFace[1][0].getColorInit() + " |");
		System.out.print(" " + cubeFace[1][1].getColorInit() + " ");
		System.out.print("| " + cubeFace[1][2].getColorInit() + " ");
	}
	
	// Method that prints a row of the cube
	public void printThirdRow(){
		System.out.print(" " + cubeFace[2][0].getColorInit() + " |");
		System.out.print(" " + cubeFace[2][1].getColorInit() + " ");
		System.out.print("| " + cubeFace[2][2].getColorInit() + " ");
	}
}
