package JAVAGAME;

import java.util.LinkedList;
import java.awt.Graphics;

// Handler structures all of the game objects into a LinkedList
// contains the methods to display and update every GameObject

public class Handler {

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    // loops through each game object and uses that objects tick method 
    public void tick() {
        for(int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }
    // same as tick() but this one renders
    public void render(Graphics g) {
        for(int i = 0; i < object.size(); i++) {
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }
    }
    // allows us to add new GameObjects 
    public void addObject(GameObject object) {
        this.object.add(object);
    }
    // allows us to remove those objects
    public void removeObject(GameObject object) {
        this.object.remove(object);
    }
    
}
