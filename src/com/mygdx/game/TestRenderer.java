package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class TestRenderer {
	
	Constants constants = new Constants();
	ShapeRenderer shapeRenderer = new ShapeRenderer();
	
	public void testRender(Map map, SpriteBatch batch ){
		Integer blockSize = Constants.BLOCKSIZE;
		Integer mapLength = map.getSize();
		ArrayList<ArrayList<String>> grid = map.getGrid();
		
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		
		shapeRenderer.begin();
		
		
		
		for (int x = 0; x < mapLength; x++){
			for (int y = 0; y < mapLength; y++){
				if (grid.get(x).get(y).equals("Wall")){
					//draw some shapes
					shapeRenderer.setColor(Color.DARK_GRAY);
					shapeRenderer.rect(x*blockSize, y*blockSize, blockSize, blockSize);
				}
				if (grid.get(x).get(y).equals("floor")){
					shapeRenderer.setColor(Color.BROWN);
					shapeRenderer.rect(x*blockSize, y*blockSize, blockSize, blockSize);
					
				}
				if (grid.get(x).get(y).equals("door")){
					shapeRenderer.setColor(Color.RED);
					shapeRenderer.rect(x*blockSize, y*blockSize, blockSize, blockSize);
					
				}

				
			}
		}
		
		shapeRenderer.end();
		batch.end();
		
	}

}
