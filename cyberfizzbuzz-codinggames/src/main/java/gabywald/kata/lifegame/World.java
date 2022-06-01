package gabywald.kata.lifegame;

/**
 * Representartion of LifeGame (a Matrix). 
 * NOTE / TODO : a World Builder ?
 * @author gabywald
 */
public class World {

	/**
	 * Modelise world of simulation : true if cell is alive, false if not. 
	 */
	private boolean[][] matrix;
	
	private int heigth, width;
	
	public World(int heigth, int width) {
		this.matrix = new boolean[heigth][width]; // Cell's here ?!
		this.heigth = heigth;
		this.width  = width;
	}
	
	/**
	 * 
	 * @param posX
	 * @param posY
	 * @return True or false (if out of the world's border). 
	 */
	public boolean getStateAt(int posX, int posY) {
		// NOTE : check values if correctly inside the world's instance (throw exception ?)
		if ( (posX < 0) || (posY < 0) ) 
			{ return false; }
		if ( (posX >= this.matrix.length) 
				|| (posY >= this.matrix[posX].length) ) 
			{ return false; }
		return this.matrix[posX][posY];
	}
	
	public void setStateAt(int posX, int posY, boolean isAlive) {
		if ( (posX < 0) || (posY < 0) ) { return; }
		if ( (posX >= this.matrix.length) 
				|| (posY >= this.matrix[posX].length) ) 
			{ return; }
		this.matrix[posX][posY] = isAlive;
	}
	
	/**
	 * Check alive cells around (special cases of borders)
	 * NOTE constraint here : borders !
	 * @param posX
	 * @param posY
	 * @return Number of alive neighbours. 
	 */
	public int checkNeighbours(int posX, int posY) {
		int areAliveAround = 0;
		for (int i = posX -1 ; i <= posX+1 ; i++) {
			for (int j = posY -1 ; j <= posY+1 ; j++) {
				
				if ( (i == posX) && (j == posY) ) 
					{ continue; }
				
				areAliveAround += (this.getStateAt(i, j)?1:0);
			}
		}
		return areAliveAround;
	}
	
	public static boolean checkCellState(boolean isAlive, int areAliveAround) {
		if (areAliveAround == 3) { return true; }
		else if (areAliveAround == 2) { return isAlive; }
		else if ( (areAliveAround < 2) && (areAliveAround > 3) ) 
			{ return false; }
		return false;
	}
	
	public void processState() {
		// ... 
		// 2 matrixes : current and next
		// Check values of current to process next state !
		boolean[][] nextmatrix = new boolean[this.heigth][this.width];
		
		for (int i = 0 ; i < this.heigth ; i++) {
			for (int j = 0 ; j < this.width ; j++) {
				int areAliveAround = this.checkNeighbours(i, j);
				nextmatrix[i][j] = World.checkCellState(this.matrix[i][j], areAliveAround);
			}
		}
		
		this.matrix = nextmatrix;
	}
	
//	public enum WorldCase {
//		ALIVE(3,3),
//		STAY(2, 2);
//
//		WorldCase(int i, int j) {
//			// TODO Auto-generated constructor stub
//			
//		}
//		
//	}
}
