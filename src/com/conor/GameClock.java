package com.conor;

import java.util.TimerTask;

/*
TimerTask is an abstract class in Java
https://docs.oracle.com/javase/7/docs/api/java/util/TimerTask.html
 */

public class GameClock extends TimerTask {

	GameComponentManager componentManager;
	DrawSnakeGamePanel gamePanel;
		
	public GameClock(GameComponentManager components, DrawSnakeGamePanel gamePanel){
		this.componentManager = components;
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void run() {
		// This method will be called every clock tick
		int stage = SnakeGame.getGameStage(); // Method from line 41 of DrawSnakeGamePanel class

		switch (stage) {
			case SnakeGame.BEFORE_GAME: {
				//don't do anything, waiting for user to press a key to start
				break;
			}
			case SnakeGame.DURING_GAME: {
				//Game is running. Ask componentManager to tell components to update.
				componentManager.update();
				break;
			}
			case SnakeGame.GAME_OVER: {
				this.cancel();		//stop the Timer
				break;	
			}
			case SnakeGame.GAME_WON: {
				this.cancel();   //stop Timer
				break;
			}
		}

		/*
		Difference between Paint() and Repaint() method
		Paint():
		This method holds instructions to paint this component.
		Actually, in Swing, you should change paintComponent() instead of paint(), as paint calls paintBorder(), paintComponent() and paintChildren().
		You shouldn't call this method directly, you should call repaint() instead.

		Repaint():
		This method can't be overridden.
		It controls the update() -> paint() cycle.
		You should call this method to get a component to repaint itself.
		If you have done anything to change the look of the component, but not it's size ( like changing color, animating, etc. ) then call this method.

		****** http://stackoverflow.com/questions/10768619/paint-and-repaint-in-java *******
		 */
		gamePanel.repaint();		//In every circumstance, must update screen
		
	}
}
