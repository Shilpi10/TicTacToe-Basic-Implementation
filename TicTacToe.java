package Design;
class TicTacToe {

    /** Initialize your data structure here. */
    private final int[][] board;
	private final int n;
	private final int[] rowSum, colSum;
	private int diagSum, revDiagSum;
	private int winner;

    public TicTacToe(int n) {
        this.n =n;
        board = new int[n][n];
        rowSum = new int[n];
        colSum = new int[n];

    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player)  throws IllegalArgumentException{
    	if(row < 0 || col < 0 || row >= n || col >= n)
    	{
    		throw new IllegalArgumentException("Move is out of the board's boundary");
    	}
    	if(board[row][col] != 0)
    	{
    		throw new IllegalArgumentException("Square already occupied");
    	}

    	if(player != 1 && player != 2)
    	{
    		throw new IllegalArgumentException("Invalid Player");
    	}
    	if(getWinner() !=0)
		{
    		throw new IllegalArgumentException("Board already decided");
		}
    	
    	
    		player = player == 1 ? +1 : -1;
    		board[row][col] = player;
    		rowSum[row] += player;
    		colSum[col] += player;
    		if(row == col)
    		{
    			diagSum += player;
    		}
    		if(row == n-col-1)
    		{
    			revDiagSum += player;
    		}
    		// The sum will be -ve for second player so taking the absolute value in condition
    if(Math.abs(rowSum[row]) == n || Math.abs(colSum[col]) == n || Math.abs(diagSum) == n || Math.abs(revDiagSum) == n)
    		{
    			winner =  player;
        
    		}
		return getWinner();
    }
 
    public int getWinner()
    {
    	if(winner < 0)
        {
            return 2;
        }
        else if(winner > 0)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
//boolean winRow = true, winCol= true, winDiag= true, winRevDiag = true; // flag for win or loose


/* VERSION 2
 for(int i = 0; i < n ;i++)
{
	if(board[row][i] != player)
	{
		winRow = false;
	}
	if(board[i][col] != player)
	{
		winCol = false;
	}
	if(board[i][i] != player)
	{
		winDiag = false;
	}
	
	if(board[i][n-i-1] != player)
	{
		winRevDiag = false;
	}
}
	if(winRow || winCol || winDiag || winRevDiag)
	{
		return player;
	}
*/

/* VERSION 1
// for COLUMN
win = true;
for(int i = 0; i < n ;i++)
{
	if(board[i][col] != player)
	{
		win = false;
		break;
	}
	if(win)
	{
		return player;
	}
}

// for DIAGONAL and then REVERSE DIAGONAL
if(row == col) // for diagonal
{
win = true;
for(int i = 0; i < n ;i++)
{
	if(board[i][i] != player)
	{
		win = false;
		break;
	}
	if(win)
	{
		return player;
	}
}
}
if(row == n-col-1) // for reverse diagonal
{
	win = true;
	for(int i = 0; i < n ;i++)
	{
		if(board[i][n-i-1] != player)
		{
			win = false;
			break;
		}
		if(win)
		{
			return player;
		}
	}
	
}



*/	
