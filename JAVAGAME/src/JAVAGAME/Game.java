package JAVAGAME;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

// Game class that contains main and the game loop
public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;

    private Thread thread;
    private boolean running = false;

    private Handler handler;
    private Random r;
    private HUD hud;

    // instantiates many of the game's objects like the visible window and the heads up display
    // uses handler to add GameObjects Player, and BasicEnemy
    public Game() {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));

        new Window(WIDTH, HEIGHT, "Dodge Ball", this);

        hud = new HUD();

        r = new Random();

        handler.addObject(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));

        handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy));
    }
    // begins the working thread
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }
    //halts the working thread
    public synchronized void stop() {
    try {
        thread.join();
        running = false;
    }catch(Exception e) {
        e.printStackTrace();
    }
    }
    // explanation of the game loop / run method
    // this is not my general design for a game loop, many games and other interactive programs use something similar
    // the first iteration of minecraft used a nearly identical game loop
    // variables lastTime, now, and ns are used to calculate delta, 
    // amountOfTicks is the amount of ticks/second and ns is the amount of nanoseconds/tick,
    //  when delta is calculated, you have (now-lastTime) / (ns/tick), but now and lastTime are in nanoseconds so it's units are "tick" 
    // this gets added to delta and we continue, when delta += 1, we know that one tick has passed and tick() gets called 
    // this resets delta to 0 in delta >= 1 loop 
    // the if (running) loop will render a new frame with the render() method and increase the frames counter by one
    //if (System.currentTimeMillis() - timer > 100) loop writes the fps to the console by checking if the current time is 1000 ms (1second) 
    // larger than timer, timer gets updated to one second later and the fps gets printed, happens once a second so variable frames is actually frames per second
    // stop() stops the game
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();
                frames++;
            }
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }
    // tells the objects to tick when a tick has passed
    private void tick() {
        handler.tick();
        hud.tick();

    }
    // renders the game using BufferStrategy which is an annoying little necessity 
    private void render() {
        BufferStrategy bs = this.getBufferStrategy(); 
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);
        hud.render(g);
        g.dispose();
        bs.show();
    }
    // clamp is a very useful method which unlocks features that are usually hidden behind a game library
    // clamp returns var at it's min or max when var appears to be outside of that maximum or minimum 
    // this is used usually for collission stuff like making sure that the player can't leave the game boundaries 
    public static int clamp(int var, int min, int max) {
        if (var >= max) {
            return var = max;
        } else if(var <= min) {
            return var = min;
        } else {
            return var;
        }
    }
    // main, runs the constructor
    public static void main(String[] args) {
        new Game();
    }
}
