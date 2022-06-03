package DRAGSTERGAME;

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
    }

    public void render(Graphics g) {
        if (id == ID.Player) { 
            g.setColor(Color.white);
        } else if(id == ID.Player1) {
            g.setColor(Color.BLUE);
        }
        g.fillRect(x, y, 32, 32);
    }

}
