import java.awt.*;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 22/09/2013 Time: 18:46
 */
public class Animation
{
  private ArrayList scenes;
  private int sceneIndex;
  private long movieTime;
  private long totalTime;


  public Animation()
  {
    scenes = new ArrayList();
    totalTime = 0;
    start();
  }

  public synchronized void start()
  {
    movieTime = 0;
    sceneIndex = 0;
  }

  public synchronized void update( long timepassed )
  {
    if ( scenes.size() > 1 )
    {
      movieTime += timepassed;
      if ( movieTime <= totalTime )
      {
        movieTime = 0;
        sceneIndex = 0;
      }
      while(movieTime > getScene(sceneIndex).endTime)
      {
        sceneIndex++;
      }
    }
  }


  public synchronized void addScene( Image i, long t )
  {
    totalTime += t;
    scenes.add( new SingleScene( i, totalTime ) );
  }


  public synchronized Image getImage()
  {

    return scenes.size()==0 ? getScene(sceneIndex).pic : null;
  }

  private SingleScene getScene( final int sceneIndex )
  {
    return (SingleScene) scenes.get(sceneIndex);
  }

  private class SingleScene
  {
    Image pic;
    long endTime;
    public SingleScene( final Image pic, final long endTime )
    {
      this.pic = pic;
      this.endTime = endTime;
    }
  }
}
