package src;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	// Last played position either from bot or player
	public static boolean playerWon = false;
	public static boolean botWon = false;
	public static boolean isGameOver = false;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Empty places are represented by 'O', players represented by 'P', bots
		// represented by 'B'
		State gameState = new State();
		char[][] table = new char[6][7];
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				table[i][j] = 'O';
			}
		}
		gameState.setData(table);
		
		while (!isGameOver) {
			
			gameState.display();
			System.out.println();
			// It is assumed that player does not play illegal move
			System.out.println("Enter a column number to play: ");
			int col = sc.nextInt();

			for (int i = 5; i >= 0; i--) {
				if (gameState.data[i][col] != 'P' && gameState.data[i][col] == 'O') {
					
					gameState.data[i][col] = 'P';
					if(gameState.checkConsecutive('P', 4)) {
						playerWon = true;
						isGameOver = true;
					}
					
					

					break;
				}
			}
			gameState = computersChoice(gameState);
			isGameOver = true;
			for(int l = 0; l<7; l++) {
				if(gameState.data[0][l] == 'O') {
					isGameOver = false;
				}
				
			}
			if(gameState.checkConsecutive('B', 4)) {
				isGameOver = true;
				botWon = true;
			}
			System.out.println("The game table after bot's move");
			gameState.display();
			System.out.println();

		}
		
		System.out.println("Game is Over");
		if(playerWon) {
			System.out.println("You won. Congratulations!");
		}
		else if(botWon) {
			System.out.println("You lost. Try harder");
		}
		else {
			System.out.println("No winner. It is tie!");
		}
		
		
		
		

	}

	// Chose the best move according to given state
	public static State computersChoice(State state) {
		LinkedList<State> possibleStates = possibleStatesByBot(state);
		State bestState = null;
		Tree tree = new Tree(new TreeNode(state));
		for (State s : possibleStates) {
			LinkedList<State> possibleStates2 = possibleStatesByPlayerAfterBot(s);
			TreeNode node = new TreeNode(s);
			for (State s2 : possibleStates2) {
				node.add(new TreeNode(s2));
			}
			tree.add(node);
		}

		bestState = tree.bestChoice();

		return bestState;
	}
	
	//Returns the list of possible states made by player after bots move in order to keep track of the goodness of the bot's move
	public static LinkedList<State> possibleStatesByPlayerAfterBot(State state) {
		LinkedList<State> list = new LinkedList<State>();
		char[][] table = state.getData();

		for (int j = 0; j < 7; j++) {
			char[][] updatedTable = copyArray(table); // Create a new copy of the table
			for (int i = 5; i >= 0; i--) {
				if (updatedTable[i][j] == 'O') {
					updatedTable[i][j] = 'P';
					State s = new State(updatedTable);

					// Check if the player's move creates a win condition
					if (s.checkConsecutive('P', 4)) {
						// If it does, return the state with the winning move
						list.clear();
						list.add(s);
						return list;
					}

					list.add(s);
					break;
				}
			}
		}

		return list;
	}

	// Helper method to create a copy of a 2D char array
	private static char[][] copyArray(char[][] array) {
		char[][] copy = new char[array.length][];
		for (int i = 0; i < array.length; i++) {
			copy[i] = array[i].clone();
		}
		return copy;
	}
	
	//Returns the list of possible states of moves of bot
	public static LinkedList<State> possibleStatesByBot(State state) {
		LinkedList<State> list = new LinkedList<State>();
		char[][] table = copyArray(state.getData());

		for (int j = 0; j < 7; j++) {
			for (int i = 5; i >= 0; i--) {
				if (table[i][j] == 'O') {
					char[][] updatedTable = copyArray(table);
					updatedTable[i][j] = 'B';
					State s = new State(updatedTable);

					// Check if the bot's move creates a win condition
					if (s.checkConsecutive('B', 4)) {
						// If it does, return the state with the winning move
						list.clear();
						list.add(s);
						botWon = true;
						isGameOver = true;
						return list;
					}

					list.add(s);
					break;
				}
			}
		}

		return list;
	}

}