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
		Integer roomSize = maxRoomSize - 1;
		gridRooms = new ArrayList<ArrayList<String>>(size/maxRoomSize);
		ArrayList<Room> rooms = new ArrayList<Room>();
		
		//initialize the array to have stuff in it
		for (int x = 0; x < size/maxRoomSize; x++){
			gridRooms.add(new ArrayList<String>(size/maxRoomSize));
		}
		
		//randomly create roomies
		for (int x = 0; x < size/maxRoomSize; x = x +2){
			for (int y = 0; y < size/maxRoomSize; y = y +2){
				if (random.nextInt(2) == 1){
					rooms.add(new Room(x*maxRoomSize,y*maxRoomSize, roomSize, roomSize));
				}
				
			}
		}
		
		if (rooms.isEmpty()){
			buildMap();
			
		}
		else{
			//check to see if any rooms will not have corridors
			buildCorridors();
			
		}
		
		
		//finally we need to build the map array that the shapeRenderer and other logic can use 
		buildMapArray();
	}
	
	private void buildCorridors(){
		ArrayList<Room> corridors = new ArrayList<Room>();
		if (rooms.size() == 0){
			System.out.println("Error: there are no rooms (printed from the stranded Rooms check)");
		}
		for (Room room: rooms){
			for (int index = 0; index < rooms.size(); index ++){
				if (room.getX() == rooms.get(index).getX() && ( !room.equals(rooms.get(index)) ) ){
					//create a corridor and add it to corridors!
					//get the max and min width of both rooms
					int room1MinWidth = room.getX();
					int room1MaxWidth = room.getX() + room.getWidth();
					int room2MinWidth = rooms.get(index).getX();
					int room2MaxWidth = rooms.get(index).getX() + rooms.get(index).getWidth();
					
					int minWidth = Math.max(room1MinWidth, room2MinWidth);
					int maxWidth = Math.min(room1MaxWidth, room2MaxWidth);
					
					int corridorX = minWidth + random.nextInt((maxWidth - minWidth) + 1);
					
					Integer corridorY;
					Integer corridorHeight;
					if (room.getY() > rooms.get(index).getY()){
						corridorY = rooms.get(index).getY() + rooms.get(index).getHeight();
						corridorHeight = room.getY() - corridorY;
					}else{
						corridorY = room.getY() + room.getHeight();
						corridorHeight = rooms.get(index).getY() - corridorY;
						
					}
					
					corridors.add(new Room(corridorX, corridorY, 1, corridorHeight));
					
				}
				if (room.getY() == rooms.get(index).getY() && ( !room.equals(rooms.get(index)) ) ){
					//create a corridor and add it to corridors!
					//get the max and min height of both rooms
					int room1MinHeight = room.getY();
					int room1MaxHeight = room.getY() + room.getHeight();
					int room2MinHeight = rooms.get(index).getHeight();
					int room2MaxHeight = rooms.get(index).getHeight() + rooms.get(index).getHeight();
					
					int minHeight = Math.max(room1MinHeight, room2MinHeight);
					int maxHeight = Math.min(room1MaxHeight, room2MaxHeight);
					
					int corridorY = minHeight + random.nextInt((maxHeight - minHeight) + 1);
					
					Integer corridorX;
					Integer corridorWidth;
					if (room.getY() > rooms.get(index).getY()){
						corridorX = rooms.get(index).getX() + rooms.get(index).getWidth();
						corridorWidth = room.getX() - corridorX;
					}else{
						corridorX = room.getX() + room.getWidth();
						corridorWidth = rooms.get(index).getX() - corridorX;
						
					}
					
					corridors.add(new Room(corridorX, corridorY, corridorWidth, 1));
				}
					
			}
		}
		
		
		
		
		
		
		
	}
	
	
	private void buildMapArray(){
		
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


