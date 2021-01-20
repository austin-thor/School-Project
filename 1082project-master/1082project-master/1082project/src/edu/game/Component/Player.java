package edu.game.Component;

public class Player {	
    public int life;
    public int ammo;
    public int shield;    
    
    //no argument - constructor
    public Player() {
		this.life = 3;
		this.ammo = 0;
		this.shield = 3;
	}
    
    //setter getters - methods
	public int getLife() {
        return life;
    }
    public void setLife(int life) {
        this.life = life;
    }
    public int getAmmo() {
        return ammo;
    }
    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }
    public int getShield() {
        return shield;
    }
    public void setShield(int shield) {
        this.shield = shield;
    }
}
