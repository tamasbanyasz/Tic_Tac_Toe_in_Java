import java.util.InputMismatchException;
import java.util.Scanner;

public class playerInput {
	
	static Scanner scanner = new Scanner(System.in);

	
	public int[] selectingRowAndColumn() {
		int selectedRow = selectingRow();
		int selectedColumn = selectingColumn();
		
		return new int[] {selectedRow, selectedColumn};	
	}
	
	private int selectingRow() {
		int selectedRow = 0;
		boolean inputCorrect = true;
		
		do {
			inputCorrect = true;
			try {
				System.out.print("Select a row: ");
				selectedRow = scanner.nextInt();
				if (checkInputLength(selectedRow)) {
					inputCorrect = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("Wrong input format.");
				inputCorrect = false;
			} finally {
				scanner.nextLine();
			}
			
		} while (!inputCorrect);
		return selectedRow;
	}
	
	private int selectingColumn() {
		int selectedColumn = 0;
		boolean inputCorrect = true;
		
		do {
			inputCorrect = true;
			try {
				System.out.print("Select a column: ");
				selectedColumn = scanner.nextInt();
				if (checkInputLength(selectedColumn)) {
					inputCorrect = false;
				}
			} catch (InputMismatchException e) {
				System.out.println("Wrong input format.");
				inputCorrect = false;
			} finally {
				scanner.nextLine();
			}
		} while (!inputCorrect);
		return selectedColumn;
	}

	private boolean checkInputLength(int numberOfInput) {
		if (numberOfInput < 0 || numberOfInput > 2) {
			System.out.println("Wrong input format.");
			return true;
		}
		return false;
	}

}
