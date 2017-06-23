public class Square {
	String color;      // colors: green, blue, red, yellow, white, orange
	String squareType; // corner, side, center
	
	public Square(String color, String squareType){
		this.color = color;
		this.squareType = squareType;
	}
	
	// setters and getters
	public String getColor(){
		return color;
	}
	
	public void setColor(String color){
		this.color = color;
	}
	
	public String getSquareType(){
		return squareType;
	}	
	
	public void setSquareType(String squareType){
		this.squareType = squareType;
	}
	
	// Method that gets the initial letter of the Color
	public String getColorInit(){
		if(color.equals("green")){
			return "G";
		}else if(color.equals("blue")){
			return "B";
		}else if(color.equals("red")){
			return "R";
		}else if(color.equals("yellow")){
			return "Y";
		}else if(color.equals("white")){
			return "W";
		}else{
			return "O";
		}
	}
}
