package com.mygdx.game;

import java.util.ArrayList;
import java.util.Random;

public class Map {
	private Integer size;
	private ArrayList<ArrayList<String>> grid;
	private ArrayList<ArrayList<String>> gridRooms;
	private Random random = new Random();
	private ArrayList<Room> rooms = new ArrayList<Room>();
	private ArrayList<Room> corridors;
	
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
		corridors = new ArrayList<Room>();
		if (rooms.size() == 0){
			System.out.println("Error: there are no rooms (printed from the stranded Rooms check)");
		}
		for (Room room: rooms){
			for (int index = 0; index < rooms.size(); index ++){
				if (room.getX() == rooms.get(index).getX() && ( !room.equals(rooms.get(index)) ) ){
					buildVerticalCorridor(room, rooms.get(index));
				}
				if (room.getY() == rooms.get(index).getY() && ( !room.equals(rooms.get(index)) ) ){
					buildHorizontalCorridor(room, rooms.get(index));
				}
					
			}
		}
		//do a quick check to see if there are rooms with no corridors
		for (Room room: rooms){
			if (!room.hasCorridor){
				corridorlessRoomFix(room);
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
	private void corridorlessRoomFix(Room lonelyRoom){
		for (int index = 0; index < rooms.size(); index++){
			
		}
	}
	
	private void buildHorizontalCorridor(Room room1, Room room2){
		//create a corridor and add it to corridors!
		//get the max and min height of both rooms
		int room1MinHeight = room1.getY();
		int room1MaxHeight = room1.getY() + room1.getHeight();
		int room2MinHeight = room2.getHeight();
		int room2MaxHeight = room2.getHeight() + room2.getHeight();
		
		int minHeight = Math.max(room1MinHeight, room2MinHeight);
		int maxHeight = Math.min(room1MaxHeight, room2MaxHeight);
		
		int corridorY = minHeight + random.nextInt((maxHeight - minHeight) + 1);
		
		Integer corridorX;
		Integer corridorWidth;
		if (room1.getY() > room2.getY()){
			corridorX = room2.getX() + room2.getWidth();
			corridorWidth = room1.getX() - corridorX;
		}else{
			corridorX = room1.getX() + room1.getWidth();
			corridorWidth = room2.getX() - corridorX;
			
		}
		
		corridors.add(new Room(corridorX, corridorY, corridorWidth, 1));
		room1.setHasCorridor(true);
	}
	private void buildVerticalCorridor(Room room1, Room room2){
		//create a corridor and add it to corridors!
		//get the max and min width of both rooms
		int room1MinWidth = room1.getX();
		int room1MaxWidth = room1.getX() + room1.getWidth();
		int room2MinWidth = room2.getX();
		int room2MaxWidth = room2.getX() + room2.getWidth();
		
		int minWidth = Math.max(room1MinWidth, room2MinWidth);
		int maxWidth = Math.min(room1MaxWidth, room2MaxWidth);
		
		int corridorX = minWidth + random.nextInt((maxWidth - minWidth) + 1);
		
		Integer corridorY;
		Integer corridorHeight;
		if (room1.getY() > room2.getY()){
			corridorY = room2.getY() + room2.getHeight();
			corridorHeight = room1.getY() - corridorY;
		}else{
			corridorY = room1.getY() + room1.getHeight();
			corridorHeight = room2.getY() - corridorY;
			
		}
		
		corridors.add(new Room(corridorX, corridorY, 1, corridorHeight));
		room1.setHasCorridor(true);
	}
	
	
}


