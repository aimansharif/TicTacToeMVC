import java.util.ArrayList;

/**
 * Contains the logic of the game
 * @author Md Aiman Sharif
 *
 */
public class TTTModel {
	private TTTView view;
	private boolean player1Turn;
	private TTTEnum status;
	private char[][] grid;
	private static final int SIZE = 3;
	private ArrayList<TTTListener> tttListeners;
	
	public TTTModel(TTTView view) {
		this.view = view;
		this.player1Turn = true;
		this.grid = new char[SIZE][SIZE];
		this.tttListeners = new ArrayList<>();
		this.status = TTTEnum.IN_PROGRESS;
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid.length; j++) {
				grid[i][j] = ' ';
			}
		}
	}
	
	/**
	 * Checks whether the game is won or not
	 * @return 
	 */
	public TTTEnum isWon() {
		//Check rows for a win
				for(int i = 0; i<3; i++)
				{
					if(grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i])
					{
						if(grid[0][i] == 'X')
						{
							return TTTEnum.X_WON;
						}
						else if(grid[0][i] == 'O')
						{
							return TTTEnum.O_WON;
						}
					}
				}
				
				//Check columns for a win
				for(int i = 0; i<3; i++)
				{
					if(grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2])
					{
						if(grid[i][0] == 'X')
						{
							return TTTEnum.X_WON;
							
						}
						else if(grid[i][0] == 'O')
						{
							return TTTEnum.O_WON;
						}
					}
				}
				//Check diagonals for a win
				if(grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2])
				{
					if(grid[0][0] == 'X')
					{
						return TTTEnum.X_WON;
					}
					else if(grid[0][0] == 'O')
					{
						return TTTEnum.O_WON;
					}
				}
				
				if(grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0])
				{
					if(grid[0][2] == 'X')
					{
						return TTTEnum.X_WON;
					}
					else if(grid[0][2] == 'O')
					{
						return TTTEnum.O_WON;
					}
				}
				
				else {
					return TTTEnum.TIE;
				}
				
				//Check if board is still empty
				for(int i = 0; i<3; i++)
				{
					for(int j = 0; j<3; j++)
					{
						if(grid[i][j] == ' ')
						{
							return TTTEnum.IN_PROGRESS;
						}
					}
				}
				
				return status;
	}
	
	public boolean takeTurn(int x, int y) {
		
		TTTEvent e = new TTTEvent(this, x, y, player1Turn, status);
		if(player1Turn) {
			grid[x][y] = 'X';
			
			e.setPlayer1(true);
			
			status = isWon();
			player1Turn = false;
			
		}
		
		else {
			grid[x][y] = 'O';
			
			e.setPlayer1(false);
			
			status = isWon();
			player1Turn = true;
		}
		
		e.setStatus(status);
		
		if(status == TTTEnum.X_WON) {
			System.out.println("X WON the game");
		}
		
		else if(status == TTTEnum.O_WON) {
			System.out.println("O WON the game");
		}
		else if(status == TTTEnum.TIE){
			System.out.println("Game resulted in a TIE");
		}
		
		else {
			System.out.println(status);
		}
		
		for(TTTListener listener: tttListeners) {
			listener.handleTTTEvent(e);
		}
		
		return false;
	}
	
	
	//Adds a Tic Tac Toe listener
	public void addTTTListener(TTTListener listener) {
		tttListeners.add(listener);
	}
	
	//Removes a TicTacToe listener
	public void removeTTTListener(TTTListener listener) {
		tttListeners.remove(listener);
	}
	
}
