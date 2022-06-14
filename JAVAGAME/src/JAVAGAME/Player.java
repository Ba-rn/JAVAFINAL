package JAVAGAME;

import java.awt.Graphics;
import java.util.Random;
import java.awt.Color;

public class Player extends GameObject {

    Random r = new Random();
    
    public Player(int x, int y, ID id) {
        super(x, y, id);

    }
    
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH-48);
        y = Game.clamp(y, 0, Game.HEIGHT-64);
    }

    public void render(Graphics g) {
        if (id == ID.Player) { 
            g.setColor(Color.white);
        }
        g.fillRect(x, y, 32, 32);
    }

}
