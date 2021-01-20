package edu.game.Interface;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.*;

public class ScoreGUI extends JFrame{

	private JTextArea textArea = new JTextArea();
	private JScrollPane pane = new JScrollPane(textArea);
	private ArrayList<PlayerScore> playerScoreliste = new ArrayList<>();
	private PlayerScore tempPlayerScore;
	
	//no argument constructor
	public ScoreGUI() {		
		add(pane);
		setSize(600, 300);
		setVisible(true);
		setResizable(false);
		textArea.setEditable(false);
		setLocationRelativeTo(null);
		createdSavefile();
		displayLearderboard();	
	}
	//argument constructor - mainly use to record data to file
	public ScoreGUI(String result) {
		addPlayerToArrayList(result);
		saveDataTofile();
	}
	
	//methods use to look for list of player and display it to text area
	public void displayLearderboard() {
		Scanner fileScanner;
		try {
			fileScanner = new Scanner(new FileInputStream("playerList.csv"));
			while ( fileScanner.hasNextLine()) {
				String line  = fileScanner.nextLine();
				String[] tempString = line.split(", ");
				String name = tempString[0];
				int gameWon = Integer.parseInt(tempString[1]);
				int gameLost = Integer.parseInt(tempString[2]);
				int gameDraw = Integer.parseInt(tempString[3]);
				int gameTotals = Integer.parseInt(tempString[4]);
				double winRatio = Double.parseDouble(tempString[5]);
				tempPlayerScore = new PlayerScore(name,gameWon,gameLost,gameDraw);
				playerScoreliste.add(tempPlayerScore);				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int rankCounter = 1;
		for (PlayerScore temp: playerScoreliste) {			//display date to textarea 	
			BigDecimal rate = new BigDecimal(temp.getWinRate());
			rate = rate.round(new MathContext(3));
			textArea.append("rank " + rankCounter + ": [ "
					+ temp.getName() +" ], "
					+ temp.getGameWon()+"W, " +temp.getGameLost()+ "L, " + temp.getGameDraw() + "D, "
					+ rate+ "% win rate\n");
			rankCounter++;
		}
	}
	//methods to sort and write data to file "playerList.csv"
	public void saveDataTofile() {
		Collections.sort(playerScoreliste, PlayerScore.CompareByWinRatio);
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream("playerList.csv", false));
			for (PlayerScore temp: playerScoreliste) {						
				pw.println(temp);			
			}
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//methods  save player data into an arraylist with updated game result
	public void addPlayerToArrayList(String result) {
		Scanner fileScanner;
		boolean playerFound = false;
		try {
			fileScanner = new Scanner(new FileInputStream("playerList.csv"));
			while ( fileScanner.hasNextLine()) {
				String line  = fileScanner.nextLine();
				String[] tempString = line.split(", ");
				String name = tempString[0];
				int gameWon;
				int gameLost;
				int gameDraw;
				int gameTotals;
				double winRatio;
				if (name.equalsIgnoreCase(GameGui.getTxtName().getText())) { //if current player is a returning player
					playerFound = true;
					switch (result) {
					case "win":{
						gameWon = Integer.parseInt(tempString[1]) + 1;
						gameLost = Integer.parseInt(tempString[2]);
						gameDraw = Integer.parseInt(tempString[3]);
						gameTotals = Integer.parseInt(tempString[4]);
						winRatio = Double.parseDouble(tempString[5]);
						tempPlayerScore = new PlayerScore(name,gameWon,gameLost,gameDraw);
						playerScoreliste.add(tempPlayerScore);	
						break;
					}
					case "lose": {
						gameWon = Integer.parseInt(tempString[1]);
						gameLost = Integer.parseInt(tempString[2]) + 1;
						gameDraw = Integer.parseInt(tempString[3]);
						gameTotals = Integer.parseInt(tempString[4]);
						winRatio = Double.parseDouble(tempString[5]);
						tempPlayerScore = new PlayerScore(name,gameWon,gameLost,gameDraw);
						playerScoreliste.add(tempPlayerScore);	
						break;
					}
					case "draw":{
						gameWon = Integer.parseInt(tempString[1]);
						gameLost = Integer.parseInt(tempString[2]);
						gameDraw = Integer.parseInt(tempString[3]) + 1;
						gameTotals = Integer.parseInt(tempString[4]);
						winRatio = Double.parseDouble(tempString[5]);
						tempPlayerScore = new PlayerScore(name,gameWon,gameLost,gameDraw);
						playerScoreliste.add(tempPlayerScore);	
						break;
					}	
					}
				} else { //old data players
					gameWon = Integer.parseInt(tempString[1]);
					gameLost = Integer.parseInt(tempString[2]);
					gameDraw = Integer.parseInt(tempString[3]);
					gameTotals = Integer.parseInt(tempString[4]);
					winRatio = Double.parseDouble(tempString[5]);
					tempPlayerScore = new PlayerScore(name,gameWon,gameLost,gameDraw);
					playerScoreliste.add(tempPlayerScore);
				}
			}
			if (playerFound == false) { //if current player is a new player
				addNewplayer(result);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//method add new player to arraylist with current game result
	public void addNewplayer(String result) {
		String name = GameGui.getTxtName().getText();
		switch (result) { 
		case "win":{
			tempPlayerScore = new PlayerScore(name,1,0,0);
			playerScoreliste.add(tempPlayerScore);	
			break;
		}
		case "lose": {
			tempPlayerScore = new PlayerScore(name,0,1,0);
			playerScoreliste.add(tempPlayerScore);	
			break;
		}
		case "draw":{
			tempPlayerScore = new PlayerScore(name,0,0,1);
			playerScoreliste.add(tempPlayerScore);	
			break;
		}
		}		
	}

	//methods to create file if doesn't exist
	public void createdSavefile() {
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream("playerList.csv", true));
			pw.close();			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
