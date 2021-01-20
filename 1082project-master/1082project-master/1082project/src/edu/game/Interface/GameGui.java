package edu.game.Interface;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import edu.game.Component.Game;
import javax.swing.JLabel;

public class GameGui extends JFrame{
	//Variables
	//Start of: TextFields/TextArea
	private static final JTextArea textArea = new JTextArea();
	private static final JTextField txtName = new JTextField(15);  //NOT IMPLEMENETED YET
	//Start of: JLABELS
//	private static JLabel lblName = new JLabel("Name");
	private static final JLabel playerTag = new JLabel("YOUR CHOICE: ");
	private static final JLabel computerTag = new JLabel("COMPUTER's CHOICE: ");
	private static final JLabel playerImage = new JLabel();
	private static final JLabel computerImage = new JLabel();
	private static final JLabel name = new JLabel("Name:");
	//Start of: JPanels
	private static final JPanel middlePanel = new JPanel(new BorderLayout());
	private static final JPanel imagePanel = new JPanel(new GridLayout(1,2));
	private static final JPanel middleTopPanel = new JPanel(new GridLayout(1,2));
	private static final JPanel startMenu = new JPanel(new FlowLayout());
	//Start of: JButtons
	private static final JButton btnShoot = new JButton("Shoot");
	private static final JButton btnBlock = new JButton("Block");
	private static final JButton btnReload = new JButton("Reload");
	private static final JButton btnNewGame = new JButton("New Game");
	private static final JButton btnStartGame = new JButton("Start Game");
	private static final JButton btnLeaderboard = new JButton("Leaderboard");
	private static final JButton btnExit = new JButton("Exit");
	private static final Game newGame = new Game();

	public GameGui() {		
		setTitle("Block, Shoot, Reload");
		setSize(800,800);
		textArea.setText("Welcome Player, to : Shoot, Shield, Reload!\n" +
				"Rules of the game: \n" +
				"--------------------\n" +
				"1: You start with 3 lives.\n" +
				"2: You cannot shoot if you do not have ammo.. Duh.\n" +
				"3: You cannot block more than 3 times in a row.\n"  +
				"4: To win, you must deplete your oppenents health to zero!\n" +
				"Have fun, and remember to stay safe!\n" + 
				"#COVID2020\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		addPanelsToFrame();
		add(startMenu, BorderLayout.SOUTH);
		setListener();
		setVisible(true);
	}
	//Start of Methods
	//ActionListener Method
	public void setListener() {
		GameAction actionListener = new GameAction();
		btnShoot.addActionListener(actionListener);
		btnBlock.addActionListener(actionListener);
		btnReload.addActionListener(actionListener);
		btnStartGame.addActionListener(actionListener);
		btnNewGame.addActionListener(actionListener);
		btnExit.addActionListener(actionListener);
		btnLeaderboard.addActionListener(actionListener);
	}

	public void addPanelsToFrame() {
		createTopPanel();
		createMiddlePanel();
		createImagePanel();
		addStarMenuButton();
	}

	public void createTopPanel() {
		JScrollPane pane = new JScrollPane(textArea);
		add(pane, BorderLayout.NORTH);
		textArea.setEditable(false);
	}
	
	private void createMiddlePanel() {
		add(middlePanel, BorderLayout.CENTER);
		middlePanel.add(middleTopPanel, BorderLayout.NORTH);
		middleTopPanel.add(playerTag);
		middleTopPanel.add(computerTag);
		middlePanel.add(imagePanel, BorderLayout.CENTER);
	}
	
	public void createImagePanel() {
		imagePanel.add(playerImage);
		imagePanel.add(computerImage);
	}

	public static void addStarMenuButton() {
		startMenu.setVisible(false);
		imagePanel.setVisible(true);
		startMenu.add(name);		
		name.setHorizontalAlignment(SwingConstants.RIGHT);
		startMenu.add(txtName);
		txtName.setVisible(true);
		startMenu.add(btnStartGame);
		startMenu.add(btnLeaderboard);
		startMenu.remove(btnBlock);
		startMenu.remove(btnReload);
		startMenu.remove(btnShoot);
		startMenu.remove(btnNewGame);
		startMenu.remove(btnExit);
		startMenu.setVisible(true);
	}
	public static void addFightButton() {
		startMenu.setVisible(false);
		imagePanel.setVisible(true);
		txtName.setVisible(false);
		startMenu.remove(name);
		startMenu.remove(btnLeaderboard);
		startMenu.remove(btnStartGame);
		startMenu.remove(btnNewGame);
		startMenu.remove(btnExit);
		btnBlock.setPreferredSize(new Dimension(100,100));
		btnReload.setPreferredSize(new Dimension(100,100));
		btnShoot.setPreferredSize(new Dimension(100,100));
		startMenu.add(btnBlock);
		startMenu.add(btnReload);
		startMenu.add(btnShoot);
		startMenu.setVisible(true);
	}
	public static void addNewGameButton() {
		startMenu.setVisible(false);
		startMenu.remove(btnStartGame);
		startMenu.remove(btnBlock);
		startMenu.remove(btnReload);
		startMenu.remove(btnShoot);
		startMenu.add(btnLeaderboard);
		startMenu.add(btnNewGame);
		startMenu.add(btnExit);
		startMenu.setVisible(true);
	}	
	public static JTextArea getTextArea() {
		return textArea;
	}
	public static Game getNewGame() {
		return newGame;
	}
	public static JPanel getStartMenu() {
		return startMenu;
	}
	public static JTextField getTxtName() {
		return txtName;
	}
	public static void addPlayerImage(ImageIcon x) {
		GameGui.playerImage.setIcon(x);
		imagePanel.add(playerImage);
	}	
	public static void addComputerImage(ImageIcon x) {
		GameGui.computerImage.setIcon(x);
		imagePanel.add(computerImage);
	}	
	public static void removePictures() {
		GameGui.playerImage.setIcon(null);
		GameGui.computerImage.setIcon(null);
	}	
	public static void main(String[]args) {
		GameGui gui = new GameGui();
	}

}
