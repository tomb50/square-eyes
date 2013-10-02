package tomb.rough.tests;

import tomb.rough.game.FullScreenGame;
import tomb.rough.game.Game;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 23/09/2013 Time: 15:50
 */
public class Main
{

  private Game game;
  private static Boolean fullscreen = false;

  public static void main( String[] args )
  {
    Main main = new Main();
    main.run();
  }

  private void run()
  {
    game = fullscreen ? new FullScreenGame() : new MouseLookTest();
    game.run();


  }
}