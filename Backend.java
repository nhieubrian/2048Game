/** Name: Brian Nhieu
 *  Project: 2048 Game
 *
 *  File: 2048 Backend Functionality
 *
 *  This file was created to create the functionality of the 2048 game. This
 *  file will include a terminal prototype of the game.
 *  */

import java.util.*;

public class Backend {

	private final static char SPACE_CHAR = '.';	
	private final static char VALUE_2 = '1';


	int gameHeight;
	int gameWidth;
	boolean levelPassed;

	
	char[][] board;

	public Backend(int gameHeight, int gameWidth){
		
		this.gameHeight = gameHeight;
		this.gameWidth = gameWidth;
	
		for(int i = 0; i < gameHeight; i++){
			for(int j = 0; j < gameWidth; j++){	
				this.board[i][j] = SPACE_CHAR;
			}
		}
	}

	void addNumber(int count) {

		int emptySpaces = 0;

		if(count <= 0){
			return;
		}

		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				
				if(board[i][j] == SPACE_CHAR){
					emptySpaces++;
				}
			}
		}

		if(count > emptySpaces){
			return;
		}

		Random rand = new Random();
		
		int repeater = 0;

		while(repeater != count){
			int colOfRandom = 0;
			int rowOfRandom = 0;

			colOfRandom = rand.nextInt(board[0].length);
			rowOfRandom = rand.nextInt(board.length);

			if(board[rowOfRandom][colOfRandom] == SPACE_CHAR){
				board[rowOfRandom][colOfRandom] = VALUE_2;

				repeater++;
			}
		}
	}	

	void rotateClockwise(){
		
		char[][] rotatedArray = new char[board[0].length][board.length];

		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){

				rotatedArray[i][j] = this.board
					[board.length - 1 - j][i];
			}
		}

		this.board = new char[rotatedArray.length]
			[rotatedArray[0].length];

		for(int i = 0; i < rotatedArray.length; i++){
			for(int j = 0; j < rotatedArray[i].length; j++){
				this.board[i][j] = rotatedArray[i][j];
			}
		}
	}

	void pushRight(){
		
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length - 1; j++){
				
				if(board[i][j+1] == SPACE_CHAR){
					board[i][j+1] = board[i][j];
					board[i][j] = SPACE_CHAR;
				}

				else if(board[i][j] == board[i][j+1]){
					
					// Need to figure out how to increment
					board[i][j+1] = (char)board[i][j] + 1;
					board[i][j] = SPACE_CHAR;
				}

				else if(board[i][j] != board[i][j+1]){
				}	
			}
		}
	}
}



