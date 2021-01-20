package edu.game.Interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GameAction implements ActionListener{	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equalsIgnoreCase("Shoot")
				&& humanHasAmmo()){ //Shoot button called and check for ammo
			ImageIcon icGun = new ImageIcon("gun.jpg");  // Displays picture when is clicked.
			GameGui.addPlayerImage(icGun); // goes into GameGui Class to access the method "addPlayerImage" and adds it to GameGui.imagePanel

			GameGui.getNewGame().shoot();
			GameGui.getTextArea().setText(GameGui.getNewGame().toString());
			hasWinner();
		} 
		else if(e.getActionCommand().equalsIgnoreCase("Block")
				&& humanHasGuard()) { //Block button called and check for shield

			ImageIcon icShield = new ImageIcon("shield.jpg");  // Displays picture when is clicked.
			GameGui.addPlayerImage(icShield); // goes into GameGui Class to access the method "addPlayerImage" and adds it to GameGui.imagePanel

			GameGui.getNewGame().guard();
			GameGui.getTextArea().setText(GameGui.getNewGame().toString());
			hasWinner();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Reload")) { //Reload button called

			ImageIcon icAmmo = new ImageIcon("ammo.jpg");  // Displays picture when is clicked.
			GameGui.addPlayerImage(icAmmo); // goes into GameGui Class to access the method "addPlayerImage" and adds it to GameGui.imagePanel

			GameGui.getNewGame().reload();
			GameGui.getTextArea().setText(GameGui.getNewGame().toString());
			hasWinner();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Start Game")) { //Start Game button called
			if (!GameGui.getTxtName().getText().isEmpty()) {
				GameGui.getTextArea().setText(GameGui.getNewGame().toString());
				GameGui.addFightButton();
			} else if (GameGui.getTxtName().getText().isEmpty()) {
				GameGui.getTextArea().setText("please enter a name to start the game!!");
			}
		}
		else if(e.getActionCommand().equalsIgnoreCase("New Game")) { //New Game button called
			GameGui.addStarMenuButton();
			GameGui.getNewGame().setNewGame();
		}
		else if(e.getActionCommand().equalsIgnoreCase("Exit")) { //Exit Button Called
			System.exit(0);
		}
		else if(e.getActionCommand().equalsIgnoreCase("Leaderboard")) { //Top10 Button Called
			ScoreGUI scoreWindow = new ScoreGUI();
		}
	}
	//check for human ammo  -methods
	public boolean humanHasAmmo() {		
		if (GameGui.getNewGame().human.getAmmo() == 0 
				&& GameGui.getNewGame().human.getShield() == 0) {
			GameGui.getTextArea().append("Can't shoot or guard!!\n");
			return false;
		} else if (GameGui.getNewGame().human.getAmmo() == 0) {
			GameGui.getTextArea().append("Can't shoot!!\n");
			return false;
		}
		return true;		
	}
	//check for human shield  -methods
	public boolean humanHasGuard() {
		if (GameGui.getNewGame().human.getAmmo() == 0 
				&& GameGui.getNewGame().human.getShield() == 0) {
			GameGui.getTextArea().append("Can't shoot or guard!!\n");
			return false;
		} else if (GameGui.getNewGame().human.getShield() == 0) {
			GameGui.getTextArea().append("Can't guard!!\n");
			return false;
		}		
		return true;		
	}
	//searching for winner and display if has one -methods
	public void hasWinner() {
		if (GameGui.getNewGame().human.getLife() == 0 
				&& GameGui.getNewGame().computer.getLife() == 0) {
			ScoreGUI saveDraw = new ScoreGUI("draw");
			GameGui.getTextArea().append("Draw!!\n");
			GameGui.removePictures();
			ImageIcon draw = new ImageIcon("draw.jpg");
			JLabel lbl = new JLabel(draw);
			JOptionPane.showMessageDialog(null, lbl, "It's a Draw!",JOptionPane.PLAIN_MESSAGE, null);  // Pop-up DRAW!
			GameGui.addNewGameButton();
		} else if (GameGui.getNewGame().human.getLife() == 0) {
			ScoreGUI saveLose = new ScoreGUI("lose");
			GameGui.getTextArea().append("YOU LOSE!!\n");
			GameGui.removePictures();
			ImageIcon youLose = new ImageIcon("youlose.jpg");
			JLabel lbl = new JLabel(youLose);
			JOptionPane.showMessageDialog(null, lbl, "Better Luck Next Time!",JOptionPane.PLAIN_MESSAGE, null); // Pop-up YOU LOSE!
			GameGui.addNewGameButton();
		} else if (GameGui.getNewGame().computer.getLife() == 0) {
			ScoreGUI saveWin = new ScoreGUI("win");
			GameGui.getTextArea().append("YOU WIN!!\n");
			GameGui.removePictures();
			ImageIcon youWin = new ImageIcon("youwin.jpg");
			JLabel lbl = new JLabel(youWin);
			JOptionPane.showMessageDialog(null, lbl, "Congratulation!",JOptionPane.PLAIN_MESSAGE, null); //Pop-up YOU WIN!
			GameGui.addNewGameButton();
		}
	}

}
