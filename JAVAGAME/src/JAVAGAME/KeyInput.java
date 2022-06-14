package JAVAGAME;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

// this class handles user keyboard input with the built in KeyAdapter and KeyEvent classes 

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }
    // keyPressed is what happens when, guess what, a key is pressed
    // getKeyCode is a method of KeyEvent that stores the user's input in key
    // we can then check this key against KeyEvent constants and move the player if the press a move key
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for(int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {
                // key events for Player
                if (key == KeyEvent.VK_W) {
                    tempObject.setVelY(-5); 
                } 
                if (key == KeyEvent.VK_S) {
                    tempObject.setVelY(5); 
                } 
                if (key == KeyEvent.VK_D) {
                    tempObject.setVelX(5); 
                } 
                if (key == KeyEvent.VK_A) {
                    tempObject.setVelX(-5); 
                } 
            }
        }
        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(1);
        }
    }
    // keyReleased works the same way as keyPressed but when the key is released,
    // 
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {
            // key events for Player
                if(key == KeyEvent.VK_W) {
                    tempObject.setVelY(0); 
                } 
                if(key == KeyEvent.VK_S) {
                    tempObject.setVelY(0); 
                } 
                if(key == KeyEvent.VK_D) {
                    tempObject.setVelX(0); 
                } 
                if(key == KeyEvent.VK_A) {
                    tempObject.setVelX(0); 
                } 
            }
        }
    }
}
