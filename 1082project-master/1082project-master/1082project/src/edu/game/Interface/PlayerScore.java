package edu.game.Interface;

import java.util.Comparator;

public class PlayerScore implements Comparable<PlayerScore>{
	private String name;
	private int gameWon;
	private int gameLost;
	private int gameDraw;
	private int gameTotals;
	private double winRate;
		
	public PlayerScore(String name, int gameWon, int gameLost, int gameDraw) {
		super();
		this.name = name;
		this.gameWon = gameWon;
		this.gameLost = gameLost;
		this.gameDraw = gameDraw;
		this.gameTotals = gameWon + gameLost + gameDraw;
		//win = 2 point, draw = 1 point, lose = 0 point
		this.winRate = (
				((double)(gameWon * 2) + (double)(gameDraw))
				/ ((double)(gameTotals * 2))
				)* 100;
	}	
	//setters and getters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGameWon() {
		return gameWon;
	}
	public void setGameWon(int gameWon) {
		this.gameWon = gameWon;
	}
	public int getGameLost() {
		return gameLost;
	}
	public void setGameLost(int gameLost) {
		this.gameLost = gameLost;
	}	
	public int getGameDraw() {
		return gameDraw;
	}
	public void setGameDraw(int gameDraw) {
		this.gameDraw = gameDraw;
	}
	public int getGameTotals() {
		return gameTotals;
	}
	public void setGameTotals(int gameTotals) {
		this.gameTotals = gameTotals;
	}	
	public double getWinRate() {
		return winRate;
	}
	public void setWinRate(int winRate) {
		this.winRate = winRate;
	}	
	public static Comparator<PlayerScore> CompareByWinRatio = new Comparator<PlayerScore>() {
		@Override
		public int compare(PlayerScore p1, PlayerScore p2) {
			return 	(int)(p2.winRate - p1.winRate);
		}
	};
	
	
	@Override
	public String toString() {

		return name + ", " + gameWon + ", " + gameLost + ", "+ gameDraw + ", "+ gameTotals + ", " + winRate;
	}
	@Override
	public int compareTo(PlayerScore arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
