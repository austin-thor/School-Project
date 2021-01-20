package edu.game.Component;

import javax.swing.ImageIcon;

import edu.game.Interface.GameGui;

public class Computer extends Player {

	private int choice;
	
	//generate random computer choice for the game [1]shoot[2]block[3]reload - methods
	public void computerChoice(){
		do {
			choice = (int)(Math.random()*3)+1;	
			if(choice == 1) {
				shootPicture();
			}
			else if(choice == 2) {
				blockPicture();
			}
			else if(choice == 3) {
				shieldPicture();
			}
		} while ((choice == 1 && ammo == 0)|| (choice == 2 && shield == 0));	
	}
	//getter - methods
	public int getChoice() {
		return choice;
	}
	
	public void shootPicture() {
		ImageIcon icGun = new ImageIcon("gun.jpg");  // Displays picture when is clicked.
		GameGui.addComputerImage(icGun); // goes into GameGui Class to access the method "addComputerImage" and adds it to GameGui.imagePanel
	}
	
	public void blockPicture() {
		ImageIcon icShield = new ImageIcon("shield.jpg");  // Displays picture when is clicked.
		GameGui.addComputerImage(icShield); // goes into GameGui Class to access the method "addComputerImage" and adds it to GameGui.imagePanel
	}
	
	public void shieldPicture() {
		ImageIcon icAmmo = new ImageIcon("ammo.jpg");  // Displays picture when is clicked.
		GameGui.addComputerImage(icAmmo); // goes into GameGui Class to access the method "addComputerImage" and adds it to GameGui.imagePanel
		
	}
	
}
