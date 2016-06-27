package com.mygdx.game;

public class Room {
	private Integer x;
	private Integer y;
	private Integer width;
	private Integer height;
	private String type = "plain";
	
	boolean hasCorridor = false;
	public Room(Integer x, Integer y, Integer width, Integer Height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
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
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isHasCorridor() {
		return hasCorridor;
	}
	public void setHasCorridor(boolean hasCorridor) {
		this.hasCorridor = hasCorridor;
	}

}
