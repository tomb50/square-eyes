package tomb.unit001.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import tomb.unit001.Unit001;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 28/12/2013 Time: 19:56
 */
public class Unit001Audio
{
  private Unit001Audio(){}

  public static Music song = Gdx.audio.newMusic( Gdx.files.internal( "assets/data/determination.mp3" ) );
  public static Music shoot = Gdx.audio.newMusic( Gdx.files.internal( "assets/data/shoot.wav" ) );
  public static Music explosion = Gdx.audio.newMusic( Gdx.files.internal( "assets/data/boom.wav" ) );

  public static void playMusic(boolean looping)
  {
    song.setLooping( looping );
    song.play();

  }

  public static void stopMusic()
  {
    song.stop();
  }
  public static void shoot()
  {
    shoot.play();
  }

  public static void hit()
  {
    explosion.play();
  }

  public static void dispose()
  {
    shoot.dispose();
    song.dispose();
    explosion.dispose();
  }
}

