package src;
class State {
	char[][] data;

	int point;
	boolean aboutToLose;
	boolean aboutToWin;

	// Calculates how much the state of move is good. I know it is not the best
	// implementation of calculating the move's goodness. But for a start, I think
	// it is good
	public int calculatePoint() {
		int maxPoints = Integer.MAX_VALUE;

		// Check for 4 consecutive 'B' vertically, horizontally, or diagonally
		if (checkConsecutive('B', 4)) {
			aboutToWin = true;
			point = maxPoints;
			return point;
		}

		// Check for 4 consecutive 'P' vertically, horizontally, or diagonally
		if (checkConsecutive('P', 4) && !aboutToWin) {
			aboutToLose = true;
			point = -maxPoints;
			return point;
		}

		int numConsecutive2B = countConsecutive('B', 2);
		int numConsecutive3B = countConsecutive('B', 3);
		int numConsecutive2P = countConsecutive('P', 2);
		int numConsecutive3P = countConsecutive('P', 3);

		// Calculate the final point value
		point = 2 * numConsecutive2B + 3 * numConsecutive3B - 2 * numConsecutive2P - 3 * numConsecutive3P;
		return point;
	}

	// Constructor, getter and setter
	public State() {
	}

	public State(char[][] data) {
		this.data = data;
	}

	public char[][] getData() {
		return this.data;
	}

	public void setData(char[][] data) {
		this.data = data;
	}

	// To display the current game
	public void display() {
		for (char[] line : data) {
			for (char c : line) {
				System.out.print(c + " ");
			}
			System.out.println();
			System.out.println();
		}
	}
	//Checks whether there is consecutive symbol according to number
	public boolean checkConsecutive(char symbol, int consecutiveCount) {
		return checkRows(symbol, consecutiveCount) || checkColumns(symbol, consecutiveCount)
				|| checkDiagonals(symbol, consecutiveCount);
	}
	
	
	private boolean checkRows(char symbol, int consecutiveCount) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j <= data[i].length - consecutiveCount; j++) {
				boolean consecutive = true;
				for (int k = 0; k < consecutiveCount; k++) {
					if (data[i][j + k] != symbol) {
						consecutive = false;
						break;
					}
				}
				if (consecutive) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkColumns(char symbol, int consecutiveCount) {
		for (int j = 0; j < data[0].length; j++) {
			for (int i = 0; i <= data.length - consecutiveCount; i++) {
				boolean consecutive = true;
				for (int k = 0; k < consecutiveCount; k++) {
					if (data[i + k][j] != symbol) {
						consecutive = false;
						break;
					}
				}
				if (consecutive) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkDiagonals(char symbol, int consecutiveCount) {
		// Check diagonal lines from top-left to bottom-right
		for (int i = 0; i <= data.length - consecutiveCount; i++) {
			for (int j = 0; j <= data[i].length - consecutiveCount; j++) {
				boolean consecutive = true;
				for (int k = 0; k < consecutiveCount; k++) {
					if (data[i + k][j + k] != symbol) {
						consecutive = false;
						break;
					}
				}
				if (consecutive) {
					return true;
				}
			}
		}

		// Check diagonal lines from top-right to bottom-left
		for (int i = 0; i <= data.length - consecutiveCount; i++) {
			for (int j = consecutiveCount - 1; j < data[i].length; j++) {
				boolean consecutive = true;
				for (int k = 0; k < consecutiveCount; k++) {
					if (data[i + k][j - k] != symbol) {
						consecutive = false;
						break;
					}
				}
				if (consecutive) {
					return true;
				}
			}
		}

		return false;
	}

	private int countConsecutive(char symbol, int consecutiveCount) {
		int count = 0;

		count += countRows(symbol, consecutiveCount);
		count += countColumns(symbol, consecutiveCount);
		count += countDiagonals(symbol, consecutiveCount);

		return count;
	}

	private int countRows(char symbol, int consecutiveCount) {
		int count = 0;

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j <= data[i].length - consecutiveCount; j++) {
				boolean consecutive = true;
				for (int k = 0; k < consecutiveCount; k++) {
					if (data[i][j + k] != symbol) {
						consecutive = false;
						break;
					}
				}
				if (consecutive) {
					count++;
				}
			}
		}

		return count;
	}

	private int countColumns(char symbol, int consecutiveCount) {
		int count = 0;

		for (int j = 0; j < data[0].length; j++) {
			for (int i = 0; i <= data.length - consecutiveCount; i++) {
				boolean consecutive = true;
				for (int k = 0; k < consecutiveCount; k++) {
					if (data[i + k][j] != symbol) {
						consecutive = false;
						break;
					}
				}
				if (consecutive) {
					count++;
				}
			}
		}

		return count;
	}

	private int countDiagonals(char symbol, int consecutiveCount) {
		int count = 0;

		// Count diagonal lines from top-left to bottom-right
		for (int i = 0; i <= data.length - consecutiveCount; i++) {
			for (int j = 0; j <= data[i].length - consecutiveCount; j++) {
				boolean consecutive = true;
				for (int k = 0; k < consecutiveCount; k++) {
					if (data[i + k][j + k] != symbol) {
						consecutive = false;
						break;
					}
				}
				if (consecutive) {
					count++;
				}
			}
		}

		// Count diagonal lines from top-right to bottom-left
		for (int i = 0; i <= data.length - consecutiveCount; i++) {
			for (int j = consecutiveCount - 1; j < data[i].length; j++) {
				boolean consecutive = true;
				for (int k = 0; k < consecutiveCount; k++) {
					if (data[i + k][j - k] != symbol) {
						consecutive = false;
						break;
					}
				}
				if (consecutive) {
					count++;
				}
			}
		}

		return count;
	}
}