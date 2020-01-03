package game;

import java.util.*;

public class TextUserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		
		final char TOKENONE='X';
		final char TOKENTWO='Y';
		int onTurn=1;
		char tokenOnTurn=' ';
		
		System.out.println("Welcome to Connect Four by T09!");
		
		System.out.println("Player One enter your name: ");
		String playerOne = input.nextLine();
		System.out.println(playerOne + " your Token is " + TOKENONE);
		
		System.out.println("Player Two enter your name: ");
		String playerTwo = input.nextLine();
		System.out.println(playerTwo + " your Token is " + TOKENTWO);
		System.out.println();
		
		char[][] placedTokens = new char[6][7];
		
		while(true) {
		
			if (onTurn%2>0) {
				tokenOnTurn=TOKENONE;
				System.out.println(playerOne + " which column do you want to drop your token (" + TOKENONE +")?: ");
			}
			else {
				tokenOnTurn=TOKENTWO;
				System.out.println(playerTwo + " which column do you want to drop your token (" + TOKENTWO +")?: ");
			}
			
		PlayingField.showGrid(placedTokens);
		if(PlayingField.placeToken(placedTokens, input.nextInt(), tokenOnTurn)) {
			if(PlayingField.checkFour(placedTokens,  tokenOnTurn)) {
				PlayingField.showGrid(placedTokens);
				System.out.println("Winner!");
				break;
				
			}
			System.out.println("Next Player");
			onTurn++;
		}
		}
		
		input.close();
	}
	}


