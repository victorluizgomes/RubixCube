
public class Test01RandomCube {
	public static Cube rubixCube = new Cube();
	
	public static void main(String[] args){
		
		rubixCube.randomizeCube();
		
		rubixCube.printCurrentCube(); // should be a randomly generated cube
		
		rubixCube.rotateBackClockwise();
		rubixCube.rotateBackCounterClockwise();
		rubixCube.rotateDownClockwise();
		rubixCube.rotateDownCounterClockwise();
		rubixCube.rotateFrontClockwise();
		rubixCube.rotateFrontCounterClockwise();
		rubixCube.rotateLeftClockwise();
		rubixCube.rotateLeftCounterClockwise();
		rubixCube.rotateRightClockwise();
		rubixCube.rotateRightCounterClockwise();
		rubixCube.rotateUpClockwise();
		rubixCube.rotateUpCounterClockwise();
		
		rubixCube.printCurrentCube(); // should stay the same as before
	}
}
