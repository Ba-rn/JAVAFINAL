package JAVAGAME;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;


// basic enemy class that is to be avoided by the player
public class BasicEnemy extends GameObject {
    public BasicEnemy(int x, int y, ID id) {
        super(x,y,id);
        velX = 5;
        velY = 5;
    }
    // part of the not working collision system, would return a rectangle
    // that could be checked if intersecting with Player's rectangle
    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }
    // this updates the enemy every tick so that they move around a little bit, yuknow like an enemy would
    public void tick() {
        x += velX;
        y += velY;

        if(y <= 0 || y >= Game.HEIGHT-32) {
            velY *= -1;
        }
        if(x <= 0 || x >= Game.WIDTH-16) {
            velX *= -1;
        }
    }
    // renders our enemy
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x,y,16,16);
    }
}
