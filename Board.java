/** Represents the game board for the maze with a 6x10 grid size.
 *  Each cell will store the integer value that represents 
 *  different components in the maze.
 */
public class Board implements Cloneable {
	private final int COLUMNS = 10;
	private final int ROWS = 6;
	private Integer[][] grid;
	public StepCounter stepCounter;

	/** Constructor for the board that will initialize a 6x10 empty board */
	public Board() {
		this.grid = new Integer[ROWS][COLUMNS];
	}

	/** Setter for stepCounter */
	public void setStepCounter() {
		stepCounter = new StepCounter();
	}

	/**
	 * Setter for a cell. Assigns the value of the cell at the given row and column.
	 * If the coordinates are outside the boundaries then no changes are made.
	 * 
	 * @param row the row index of the cell
	 * @param col the column index of the cell
	 * @param value the value to store in the cell
	 */
	public void setCell(int row, int col, int value) {
		if (row >= 0 && row < ROWS && col >= 0 && col < COLUMNS) {
			grid[row][col] = value;
		}
	}

	/**
	 * Getter for a cell. Retrieves the value of a cell at the given row and column.
	 * If the coordinates are outside the boundaries then -1 is returned
	 * 
	 * @param row the row index of the cell
	 * @param col the column index of the cell
	 * @return the value stored in the cell or -1
	 */
	public int getCell(int row, int col) {
		if (row >= 0 && row < ROWS && col >= 0 && col < COLUMNS) {
			return grid[row][col];
		}
		return -1; // Return -1 or throw exception for out of bounds
	}

	/**	
	 * Makes a deep copy of the board
	 * 
	 * @return a cloned copy of the board
	 */
	@Override
	public Board clone() {
		Board copy = new Board();
		copy.setStepCounter();
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLUMNS; c++) {
				copy.setCell(r, c, this.grid[r][c]);
			}
		}
		return copy;
	}
}
