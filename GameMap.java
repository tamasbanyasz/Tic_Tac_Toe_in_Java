public class gameMap {
	
	private int mapSize = 3;
	private String [][] gameMap;
	
	
	public gameMap(int mapSize) {
		this.mapSize = mapSize;
		this.gameMap = new String[mapSize][mapSize];
		createMap();
	}

	public void displayPlayersHit(int[] selectedRowAndColumn, String[] players, int indexNumberOfPlayer) {
		if (gameMap[selectedRowAndColumn[0]][selectedRowAndColumn[1]] != "- ") {
			System.out.println("---------------------------------------");
			System.out.println("---------Already selected--------------");
			System.out.println("---------------------------------------");
			indexNumberOfPlayer -= 1;
		}
		if (gameMap[selectedRowAndColumn[0]][selectedRowAndColumn[1]] == "- ") {
			gameMap[selectedRowAndColumn[0]][selectedRowAndColumn[1]] = players[indexNumberOfPlayer] + " ";
		}
	}

	private void createMap() {
		for (int row = 0; row < mapSize; row++) {
			for (int column = 0; column < mapSize; column++) {
				gameMap[row][column] = "- ";
				System.out.print(gameMap[row][column]);				
			}System.out.println();
		}	
	}
	
	public void displayMap() {
		for (int row = 0; row < mapSize; row++) {
			for (int column = 0; column < mapSize; column++) {
				System.out.print(gameMap[row][column]);	
			}System.out.println();
		}	
	}

	public String[][] getGameMap() {
		return gameMap;
	}
}
