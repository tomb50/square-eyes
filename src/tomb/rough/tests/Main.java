package tomb.rough.tests;

import tomb.rough.game.FullScreenAbstractGame;
import tomb.rough.game.AbstractGame;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 23/09/2013 Time: 15:50
 */
public class Main
{

  private AbstractGame abstractGame;
  private static Boolean fullscreen = false;

  public static void main( String[] args )
  {
    Main main = new Main();
    main.run();
  }

  private void run()
  {
    abstractGame = fullscreen ? new FullScreenAbstractGame() : new MouseLookTest();
    abstractGame.run();


  }
}
