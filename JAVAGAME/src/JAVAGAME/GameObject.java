package JAVAGAME;

import java.awt.Graphics;
import java.awt.Rectangle;

//GameObject is the superclass for all of our other game objects like player or enemy 

public abstract class GameObject {
    protected int x, y;
    protected ID id;
    protected int velX, velY;

    public GameObject(int x, int y, ID id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }
    // each GameObject needs to be able to update on a tick
    public abstract void tick();
    // each GameObject needs to be able to be rendered to the screen using Graphics
    public abstract void render(Graphics g);
    // allows us to establish collision which is not working lol
    public abstract Rectangle getBounds();

    // getter and setter methods necessary for every game object to access it's fields 
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setId(ID id) {
        this.id = id;
    }
    public ID getId() {
        return id;
    }
    public void setVelX(int velX) {
        this.velX = velX;
    }
    public void setVelY(int velY) {
        this.velY = velY;
    }
    public int getVelX() {
        return velX;
    }
    public int getVelY() {
        return velY;
    }
}
