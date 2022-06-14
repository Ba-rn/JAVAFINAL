package JAVAGAME;

import java.awt.Graphics;
import java.awt.Color;

// the heads up display is pretty lame so far especially
// considering collision doesn't work so I can't even update it correctly

public class HUD {

    public static int HEALTH = 100;

    // tick() calls clamp once per tick to make sure that HEALTH is not above or below the max and min

    public void tick() {
        HEALTH = Game.clamp(HEALTH, 1, 100);
    }
    // render draws the healthbar to the screen, if you want to see it without draining 
    // comment out HUD.HEALTH -= 1 in the collision method of player.java

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(Color.red);
        g.fillRect(15, 15, HEALTH * 2, 32);
        g.setColor(Color.white);
        g.drawRect(15, 15, 200, 32);
    }
}
