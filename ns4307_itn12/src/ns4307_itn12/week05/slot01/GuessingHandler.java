package ns4307_itn12.week05.slot01;

import java.net.*;
import java.util.Random;
import java.io.*;

public class GuessingHandler implements Runnable {

	Socket player1, player2;
	DataInputStream fromPlayer1, fromPlayer2;
	DataOutputStream toPlayer1, toPlayer2;
	
	public GuessingHandler(Socket player1, Socket player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public void run() {
		try {
			fromPlayer1 = new DataInputStream(player1.getInputStream());
			fromPlayer2 = new DataInputStream(player2.getInputStream());
			toPlayer1 = new DataOutputStream(player1.getOutputStream());
			toPlayer2 = new DataOutputStream(player2.getOutputStream());
			
			String welcomeMsg = "Connected: Starting guessing game as ";
			toPlayer1.writeUTF(
					welcomeMsg + "player 1.");
			toPlayer2.writeUTF(
					welcomeMsg + "player 2.");
			
			Random random = new Random();
			int randomValue = random.nextInt(99) + 1;
			System.out.println(randomValue);
			
			while(true) {
				int player1Guess = fromPlayer1.readInt();
				int player2Guess = fromPlayer2.readInt();
				
				byte player1Result =
						calculateWin(randomValue, player1Guess);
				byte player2Result =
						calculateWin(randomValue, player2Guess);
				
				String result1 = "";
				String result2 = "";
				boolean stopGame = false;
				if(player1Result == 1 && player2Result == 1) {
					result1 = "Draw";
					result2 = "Draw";
					stopGame = true;
				} else if(player1Result == 1 && player2Result != 1) {
					result1 = "You win";
					result2 = "You lose";
					stopGame = true;
				} else if(player1Result != 1 && player2Result == 1) {
					result1 = "You lose";
					result2 = "You win";
					stopGame = true;
				} else {
					if(player1Result == 2) {
						result1 = "Your guess is less than the random value.";
					} else {
						result1 = "Your guess is more than the random value.";
					}
					if(player2Result == 2) {
						result2 = "Your guess is less than the random value.";
					} else {
						result2 = "Your guess is more than the random value.";
					}
				}
				toPlayer1.writeUTF(result1);
				toPlayer2.writeUTF(result2);
				toPlayer1.writeBoolean(stopGame);
				toPlayer2.writeBoolean(stopGame);
				if(stopGame) {
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public byte calculateWin(int randomValue, int playerGuess) {
		if(randomValue == playerGuess) {
			return 1;
		} else if (playerGuess < randomValue) {
			return 2;
		} else {
			return 3;
		}
	}
	
}
