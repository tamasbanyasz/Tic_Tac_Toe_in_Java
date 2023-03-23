import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {

		static final int mapSize = 3;
		public static int indexNumberOfPlayer = 0;

	public static void main(String[] args) {
		String[] players = {"O", "X"};
		playerInput playerInput = new playerInput();
		gameMap gameMap = new gameMap(mapSize);
		
		gameResult gameResult = new gameResult(mapSize);
		
		while (true) {
			System.out.println("Player " + players[indexNumberOfPlayer] + " turn!");

			int[] selectedRowAndColumn = playerInput.selectingRowAndColumn();
			
			gameMap.displayPlayersHit(selectedRowAndColumn, players, indexNumberOfPlayer);
			gameMap.displayMap();
			gameResult.setindexNumberOfPlayer(indexNumberOfPlayer);
			if (gameResult.isWin(gameMap.getGameMap(), selectedRowAndColumn, players)) {
				break;
			}
			turnPlayer(players);

			if (gameResult.gameIsDraw(gameMap.getGameMap())) {
				break;
			}
		}
	}
	
	static void turnPlayer(String[] players) {
		if (indexNumberOfPlayer < players.length - 1) {
			indexNumberOfPlayer++;
		} else {
			indexNumberOfPlayer = 0;
		}
	}
}
