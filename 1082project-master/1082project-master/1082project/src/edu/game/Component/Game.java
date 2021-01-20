package edu.game.Component;

public class Game {
	private static int rounds = 1;
	public Human human = new Human();
	public Computer computer = new Computer();
	
	//no constructor - using default constructor
	
	//compute human shoot vs computer random choice -methods
	public void shoot() {
		human.ammo -= 1;
		human.shield = 3;
		computer.computerChoice();		
		if(computer.getChoice() == 1) { //computer shoot			
			human.life  -= 1;
			computer.life  -= 1;
			computer.ammo  -= 1;
			computer.shield  = 3;							
		}
		else if(computer.getChoice() == 2) { //computer guard	
			computer.shield  -= 1;				
		}			
		else if(computer.getChoice() == 3) { //computer reload
			computer.life  -= 1;
			computer.ammo  += 1;
			computer.shield  = 3;
		}
	}
	//compute human guard vs computer random choice -methods
	public void guard() {	
		human.shield -= 1;
		computer.computerChoice();
		if(computer.getChoice() == 1) { //computer shoot
			computer.ammo  -= 1;
			computer.shield  = 3;
		}
		else if(computer.getChoice() == 2) { //computer guard
			computer.shield  -= 1;
		}
		else if(computer.getChoice() == 3) { //computer reload
			computer.ammo  += 1;
			computer.shield  = 3;			
		}
	}
	//compute human reload vs computer random choice -methods
	public void reload() {
		human.ammo = human.getAmmo() + 1;
		human.shield = 3;
		computer.computerChoice();	
		if(computer.getChoice() == 1) { //computer shoot
			human.life  -= 1;
			computer.ammo  -= 1;
			computer.shield  = 3;
		}
		else if(computer.getChoice() == 2) { //computer guard
			computer.shield  -= 1;
		}
		else if(computer.getChoice() == 3) { //computer reload
			computer.ammo  += 1;
			computer.shield  = 3;			
		}
	}
	public void setNewGame() {
		human.life  = computer.life = 3;
		human.shield = computer.shield  = 3;
		human.ammo = computer.ammo = 0;
		rounds = 1;
	}
	
	@Override
	public String toString() {
		String message = 	"Round: " + (rounds++) + "\n" +
				"Player Counters: " + "\n" +
				"---------------------" + "\n" +
				"player life: " + human.getLife()+ "\n" +
				"player ammo: " + human.getAmmo()+ "\n" +
				"player shield: " + human.getShield()+ "\n\n" +

				"Computer Counters: "+ "\n" +
				"---------------------"+ "\n" +
				"computer life: " + computer.getLife()+ "\n" +
				"computer ammo: " + computer.getAmmo()+ "\n" +
				"computer shield: " + computer.getShield()+ "\n" ;
		return message;
	}



}
