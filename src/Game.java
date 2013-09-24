import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 23/09/2013 Time: 19:27
 */
public abstract class Game
{
  protected Image bg;
  protected Animation a;

  protected abstract void start();
  protected abstract void update();
  protected abstract Graphics getGraphics();


  protected void run()
  {
    loadImages();
    movieLoop();
  }

  protected void loadImages()
  {
    bg = new ImageIcon( "/Users/tombeadman/Downloads/undergrowth-wallpaper-2880x1800.jpg" ).getImage();

    a = new Animation();
    a.addScene( new ImageIcon( "/Users/tombeadman/Downloads/Numbers-1-filled-icon.png" ).getImage(), 250 );
    a.addScene( new ImageIcon( "/Users/tombeadman/Downloads/Numbers-2-filled-icon.png" ).getImage(), 250 );
    a.addScene( new ImageIcon( "/Users/tombeadman/Downloads/Numbers-3-filled-icon.png" ).getImage(), 250 );
    a.addScene( new ImageIcon( "/Users/tombeadman/Downloads/Numbers-4-filled-icon.png" ).getImage(), 250 );
  }



  protected void movieLoop()
  {

    long startingTime = System.currentTimeMillis();
    long cumTime = startingTime;
    while ( cumTime - startingTime < 5000 )
    {
      long timePassed = System.currentTimeMillis() - cumTime;
      cumTime += timePassed;
      a.update( timePassed );

      Graphics2D graphics = (Graphics2D) getGraphics();
      draw( graphics );
      graphics.dispose();
      update();

      try{Thread.sleep( 20 );}catch(Exception ignored){}
    }

  }

  protected void draw( final Graphics g )
  {
    g.drawImage( bg,0,0,null );
    g.drawImage( a.getImage(),100,100,null );
  }
}
