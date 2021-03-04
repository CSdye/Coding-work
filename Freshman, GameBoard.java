package program5;
//Callen Dye
//This is the Game board that is a part of the battleship program
public class GameBoard 
{
	 
	private final int BOARDSIZE = 10;
	private char [] [] board = new char [BOARDSIZE] [BOARDSIZE];
	private int shipSunk = 0, plays = 0, battleShipHits = 0, carrierHits = 0, subHits = 0;
 
		public GameBoard()
		{
			for(int row = 0; row < BOARDSIZE; row++)
				for(int col = 0; col <BOARDSIZE; col++)
					board[row][col] = '-';
		}
		
		public boolean placeShip(char shipType, int row, int col, char orient)
		{
			if(shipType == 'A')
	{
			if (orient == 'H')
			{
				if (row < 0 || col < 0|| row > BOARDSIZE || col > BOARDSIZE - 5)
				{
					return false;
				}
				for(int i = col; i < col + 5;i++)
					if(board[row][i]!='-')
					{
					return false;
					}
				for (int i = 0; i< 5;i++)
					board[row][col+i] = 'A';
			}
			if (orient == 'V')
		{
				if (row < 0 || col < 0|| row > BOARDSIZE - 5 || col > BOARDSIZE)
				{
					return false;
				}
				for(int j = row; j < row + 5;j++)
					if(board[j][col]!='-')
					{
					return false;
					}
				for (int i = 0; i< 5;i++)
					board[row + i][col] = 'A';			
		}
	}
		if (shipType == 'B')
		{
			if (orient == 'H')
			{
				if (row < 0 || col < 0|| row > BOARDSIZE || col > BOARDSIZE - 4)
				{
					return false;
				}
				for(int i = col; i < col + 4;i++)
					if(board[row][i]!='-')
					{
					return false;
					}
				for (int i = 0; i< 4;i++)
					board[row][col+i] = 'B';
			}
			if (orient == 'V')
			{
				if (row < 0 || col < 0|| row > BOARDSIZE - 4 || col > BOARDSIZE)
				{
					return false;
				}
				for(int j = row; j < row + 3;j++)
					if(board[j][col]!='-')
					{
					return false;
					}
				for (int i = 0; i< 4;i++)
					board[row + i][col] = 'B';		
			}
		}
		
	
		if (shipType == 'S')
		{
			if (orient == 'H')
			{
				if (row < 0 || col < 0|| row > BOARDSIZE || col > BOARDSIZE - 3)
				{
					return false;
				}
				for(int i = col; i < col + 2;i++)
					if(board[row][i]!='-')
					{
					return false;
					}
				for (int i = 0; i< 3;i++)
					board[row][col+i] = 'S';
			}
			if (orient == 'V')
			{
				if (row < 0 || col < 0|| row > BOARDSIZE - 3 || col > BOARDSIZE)
				{
					return false;
				}
				for(int j = row; j < row + 2;j++)
					if(board[j][col]!='-')
					{
					return false;
					}
				for (int i = 0; i< 3;i++)
					board[row + i][col] = 'S';			
			} 
		}
			return true;
	}//place ships
	
		public boolean play(int row, int col, GameBoard peek)
		
		{
			if(board[row][col] != '-') {
			if(board[row][col] == 'A')
				{
				carrierHits++;
				if(carrierHits == 5)
					shipSunk++; 
				board[row][col] = 'X';
				char[][] temp = peek.getBoard();
				temp[row][col] = 'X';
				peek.setBoard(temp);
				}
			else if(board[row][col] == 'B')
				{
				battleShipHits++;
				
				if(battleShipHits == 4)
					shipSunk++;
				board[row][col] = 'X';
				char[][] temp = peek.getBoard();
				temp[row][col] = 'X';
				peek.setBoard(temp);
				}
				if(board[row][col] == 'S')
				{
					subHits++;
					if(subHits == 3)
						shipSunk++;
					board[row][col] = 'X';
					char[][] temp = peek.getBoard();
					temp[row][col] = 'X';
					peek.setBoard(temp);
				}
			}
			else {
			board[row][col] = '*';
			char[][] temp = peek.getBoard();
			temp[row][col] = '*';
			peek.setBoard(temp);}
				plays++;
				return true;
		}// plays
		
		public boolean play(int row, int col)
		
		{
			if(board[row][col] != '-') {
			if(board[row][col] == 'A')
				{
				carrierHits++;
				if(carrierHits == 5)
					shipSunk++; 
				board[row][col] = 'X';
				}
			else if(board[row][col] == 'B')
				{
				battleShipHits++;
				
				if(battleShipHits == 4)
					shipSunk++;
				board[row][col] = 'X';
				}
				if(board[row][col] == 'S')
				{
					subHits++;
					if(subHits == 3)
						shipSunk++;
					board[row][col] = 'X';
				}
			}
			else
				board[row][col] = '*';
				plays++;
				return true;
		}// plays
		
		public boolean validShot(int row, int col)
		
		{
			return ( row >= 0) && (col >= 0) && (row < BOARDSIZE) && (col < BOARDSIZE) && (board[row][col] != 'X') && (board[row][col] != '*');
		}//valid shot
		
		public boolean allSunk()
		
		{
			if(shipSunk == 3)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		
		public void showBoard()
		
		{
			System.out.println("  0 1 2 3 4 5 6 7 8 9"); 
			for(int row = 0; row < BOARDSIZE; row++)
			{
				System.out.print(row+" ");
				for(int col = 0; col < BOARDSIZE; col++)
					System.out.print(board[row][col] + " ");
				System.out.println();
			}
		}
		
		public char[][] getBoard()

		{
			return board;
		}
		
		public void setBoard(char[][] replace)

		{
			board = replace;
		}
		
		public int getPlays()
		{
			return plays;
		}
}
	
