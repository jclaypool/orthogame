package com.mygdx.game;


public class Tile {
	private Integer x;
	private Integer y;
	private boolean discovered = false;
	public Tile(Integer x, Integer y){
		this.x = x;
		this.y = y;
	}

	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public boolean isDiscovered() {
		return discovered;
	}
	public void setDiscovered(boolean discovered) {
		this.discovered = discovered;
	}
}
