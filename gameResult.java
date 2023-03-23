public class gameResult {
	
	private int indexNumberOfPlayer;
	private final int mapSize;

	public gameResult(int mapSize){
		this.mapSize = mapSize;
	}
	
	public boolean isWin(String[][] gameMap, int[] selectedRowAndColumn, String[] players) {	
		if (filledRow(gameMap, selectedRowAndColumn, players)) {
			return true;
		}
		if (filledColumn(gameMap, selectedRowAndColumn, players)) {
			return true;
		}
		if (filledBackDiagonal(gameMap, players)) {
			return true;
		}
		if (filledForwardDiagonal(gameMap, players)) {
			return true;
		}
		return false;
	}
	
	public void setindexNumberOfPlayer(int indexNumberOfPlayer) {
		this.indexNumberOfPlayer = indexNumberOfPlayer;
	}
	
	private boolean filledRow(String[][] gameMap, int[] selectedRow, String[] players) {
		checkLineIndex checkLineIndex = new checkLineIndex(mapSize);
		
		
		for(int column=0; column < gameMap.length; column++){
			if(gameMap[selectedRow[0]][column].equals(players[0]+" ")){
				checkLineIndex.setWinX(1);
			}
			
			if (gameMap[selectedRow[0]][column].equals(players[1]+" ")) {
				checkLineIndex.setWinO(1);
			}
		}
		
		if (checkLineIndex.someoneFilledALine(players, indexNumberOfPlayer)) {
			return true;
		}
		return false;
	}
	
	private boolean filledColumn(String[][] gameMap, int[] selectedColumn, String[] players) {
		checkLineIndex checkLineIndex = new checkLineIndex(mapSize);

		
		for(int row=0; row < gameMap.length; row++){
			if(gameMap[row][selectedColumn[1]].equals(players[0]+" ")){
				checkLineIndex.setWinX(1);
			}
			
			if (gameMap[row][selectedColumn[1]].equals(players[1]+" ")) {
				checkLineIndex.setWinO(1);
			}
		}
		
		if (checkLineIndex.someoneFilledALine(players, indexNumberOfPlayer)) {
			return true;
		}
		return false;
	}
	
	private boolean filledBackDiagonal(String[][] gameMap, String[] players) {
		checkLineIndex checkLineIndex = new checkLineIndex(mapSize);

		
		for(int row=0; row < gameMap.length; row++){
			if(gameMap[row][row].equals(players[0]+" ")){
				checkLineIndex.setWinX(1);
			}
			
			if (gameMap[row][row].equals(players[1]+" ")) {
				checkLineIndex.setWinO(1);
			}
		}
		
		if (checkLineIndex.someoneFilledALine(players, indexNumberOfPlayer)) {
			return true;
		}
		return false;
	}
	
	private boolean filledForwardDiagonal(String[][] gameMap, String[] players) {
		checkLineIndex checkLineIndex = new checkLineIndex(mapSize);

		
		for(int row=0; row < gameMap.length; row++){
			if(gameMap[row][gameMap.length - row - 1].equals(players[0]+" ")){
				checkLineIndex.setWinX(1);
			}
			
			if (gameMap[row][gameMap.length - row - 1].equals(players[1]+" ")) {
				checkLineIndex.setWinO(1);
			}
		}
		
		if (checkLineIndex.someoneFilledALine(players, indexNumberOfPlayer)) {
			return true;
		}
		return false;
	}
	
	public boolean gameIsDraw(String[][] gameMap) {
		for (int row = 0; row < gameMap.length; row++) {
			for (int column = 0; column <gameMap[row].length; column++) {
				if (gameMap[row][column].equals("- ")) {
					return false;	
				}
			}		
		}
		System.out.println("DRAW!");
		return true;
	}
}
