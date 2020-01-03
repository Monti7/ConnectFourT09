package game;
public class PlayingField {

	public static void showGrid(char[][] placedTokens) {
		System.out.println();
		final char WALLS = '|';
		
		//Print Column Headline
		for(int columns = 0; columns<placedTokens[0].length; columns++) {
			System.out.print("  " + columns + " ");
		}
		
		//Print first floor
			printFloor(placedTokens[0].length);
			
		//Printing walls and placed tokens for each row	
		for (int rows = 0; rows<placedTokens.length; rows++) {

			System.out.print(WALLS);
			
			for(int columns = 0; columns < placedTokens[0].length;columns++) {
				System.out.print(" " + placedTokens[rows][columns] + " " + WALLS);
			}
			
			//Print following floors
			printFloor(placedTokens[0].length);
			
			
			
		}
		
	  
	}
	
	public static void printFloor(int floors) {
		final char FLOOR = '—';
		System.out.println();
		for(int i = 0; i<floors*4+1;i++) {
			System.out.print(FLOOR);
		}
		System.out.println();
	}
	public static boolean placeToken(char[][] placedTokens, int column, char token) {
		boolean placed = false;
			if(placedTokens.length<column) {
				System.out.println("This column doesn't exist! Choose a column below " + placedTokens[0].length);
				return placed;
			}
			
			if(placedTokens[0][column] == 0) {
				for (int row = placedTokens.length-1; row >= 0; row--){
					if (placedTokens[row][column] == 0){
						placedTokens[row][column] = token;
						placed = true;
						break;
						
			}
					
			}
				
				
			
	}
			else{
				System.out.println("Column is already full, choose another!");
				System.out.println();
			}
			return placed;


}		
	public static boolean checkFour(char[][] placedTokens,char token) {
	int rows = placedTokens.length;
	int columns = placedTokens[0].length;
	//Processing each field in the playingField
	for (int i = 0; i < rows; i++) {
		for(int j = 0; j< columns; j++) {
			//If the field doesn't match with the players token move forward
			if(token != placedTokens[i][j])
				continue;
			//Checking horizontal (left to right)
			if(j+3 < columns &&
			   token == placedTokens[i][j+1] &&
			   token == placedTokens[i][j+2] &&			
			   token == placedTokens[i][j+3]) {
				return true;
			}
			//Checking vertical (bottom to top)
			if(i+3 < rows) {
				if(token==placedTokens[i+1][j] &&
				   token==placedTokens[i+2][j] &&
				   token==placedTokens[i+3][j]) {
				   return true;
				}
				//Checking Slash (right and up diagonal)
				if(j+3 < columns &&
				   token==placedTokens[i+1][j+1] &&
				   token==placedTokens[i+2][j+2] &&
				   token==placedTokens[i+3][j+3]) {
				   return true;
				}
				//Checking backslash (right and down diagonal)
				if(j+3 < columns &&
				   i-3 >= 0 &&
				   token==placedTokens[i-1][j+1] &&
				   token==placedTokens[i-2][j+2] &&
				   token==placedTokens[i-3][j+3]) {
					return true;
					}
			}
			
		
		}
	}
	return false;
	
		}
	
	
}