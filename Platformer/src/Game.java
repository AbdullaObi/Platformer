import javax.swing.JFrame;


public class Game {
    public Game() {

        GameWorld world = new GameWorld();
        GameView view = new GameView(world, 800, 700);
        JFrame frame = new JFrame("Game");
        frame.addKeyListener(world);
        frame.add(view);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        world.start();
    }

    public static void main(String[] args) {
    	Resources.loadResources();
        new Game();
    }

}
