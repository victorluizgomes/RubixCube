import java.awt.Color;

public class Square {
	String color;      // colors: green, blue, red, yellow, white, orange
	Color realColor;
	String squareType; // corner, side, center
	
	public Square(String color, String squareType){
		this.color = color;
		setRealColor();
		this.squareType = squareType;
	}
	
	// setters and getters
	public String getColor(){
		return color;
	}
	
	public void setColor(String color){
		this.color = color;
		setRealColor();
	}
	
	public Color getRealColor() {
		return realColor;
	}

	public String getSquareType(){
		return squareType;
	}	
	
	public void setSquareType(String squareType){
		this.squareType = squareType;
	}
	
	private void setRealColor() {
		if(color.equals("green")){
			realColor = Color.GREEN;
		}else if(color.equals("blue")){
			realColor = Color.BLUE;
		}else if(color.equals("red")){
			realColor = Color.RED;
		}else if(color.equals("yellow")){
			realColor = Color.YELLOW;
		}else if(color.equals("white")){
			realColor = Color.LIGHT_GRAY;
		}else{
			realColor = Color.ORANGE;
		}
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
