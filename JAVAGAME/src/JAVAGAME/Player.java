package JAVAGAME;

import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;
import java.awt.Rectangle;

// Player object that is controllable by the user

public class Player extends GameObject {

    Random r = new Random();
    Handler handler;
    
    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }
    // creates our bounds for collission for the player object 
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
    // uses clamp to keep the player from going out of bounds of the window and checks for collisions
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH-48);
        y = Game.clamp(y, 0, Game.HEIGHT-64);

        collision();
    }
    // this is the collision logic that should be checking if Player intersects with basic enemy, not currently working
    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {

            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.BasicEnemy) {
                if (getBounds().intersects(tempObject.getBounds())); {
                    HUD.HEALTH -= 1;
                }
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }

}
