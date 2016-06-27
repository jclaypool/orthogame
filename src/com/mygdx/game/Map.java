package com.mygdx.game;

import java.util.ArrayList;
import java.util.Random;

public class Map {
	private Integer size;
	private ArrayList<ArrayList<String>> grid;
	private ArrayList<ArrayList<String>> gridRooms;
	private Random random = new Random();
	private ArrayList<Room> rooms = new ArrayList<Room>(); 
	
	public Map(){}
	public Map(Integer size){
		this.size = size;
		this.grid = new ArrayList<ArrayList<String>>(size);
		for (int x = 0; x < size;x++){
			grid.add(new ArrayList<String>(size));
		}
	}
	public Map(Integer size, ArrayList<ArrayList<String>> grid){
		this.size = size;
		//initialize the grid to have all of the elements that we want
		this.grid = grid;
		
	}
	
	public void buildMap(){
		Integer maxRoomSize = 10;
		gridRooms = new ArrayList<ArrayList<String>>(size/maxRoomSize);
		
		//initialize the array to have stuff in it
		for (int x = 0; x < size/maxRoomSize; x++){
			gridRooms.add(new ArrayList<String>(size/maxRoomSize));
		}
		
		//randomly create roomies
		for (int x = 0; x < size/maxRoomSize; x = x +2){
			for (int y = 0; y < size/maxRoomSize; y = y +2){
				if (random.nextInt(2) == 1){
					
				}
				
			}
		}
		
	}
	
	
	
	public Integer getSize(){
		return this.size;
	}
	
	public ArrayList<ArrayList<String>> getGrid(){
		return this.grid;
	}
	
	public void setSize(Integer size){
		this.size = size;
	}
	
	public void setGrid(ArrayList<ArrayList<String>> grid){
		this.grid = grid;
	}
}


