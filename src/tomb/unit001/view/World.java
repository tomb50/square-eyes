package tomb.unit001.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import tomb.unit001.Unit001;
import tomb.unit001.model.Bullet;
import tomb.unit001.model.Enemy;
import tomb.unit001.model.Follower;
import tomb.unit001.model.Ship;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 17/10/2013 Time: 15:49
 */
public class World
{
  Unit001 game;
  Ship ship;
  Array<Bullet> bullets = new Array<Bullet>();
  WorldRenderer worldRenderer;
  Iterator<Bullet> bIter;
  Bullet b;
  Array<Enemy> enemies = new Array<Enemy>();
  Iterator<Enemy> eIter;
  Enemy enemy;


  public Array<Enemy> getEnemies()
  {
    return enemies;
  }


  public World( final Unit001 game )
  {
    this.game = game;
    ship = new Ship( new Vector2( 5, 5 ), 1, 1, 0, 5f );
    enemies.add( new Follower( 5f, 0, new Vector2( 10, 10 ), 1, 1 ) );
    Gdx.input.setInputProcessor( new InputHandler( this ) );
  }

  public Ship getShip()
  {
    return ship;
  }

  public void update()
  {
    ship.update();

    bIter = bullets.iterator();
    while ( bIter.hasNext() )
    {
      b = bIter.next();
      b.update( ship );
    }

    eIter = enemies.iterator();
    while ( eIter.hasNext() )
    {
      enemy = eIter.next();
      enemy.advance( Gdx.graphics.getDeltaTime(), ship );

      if ( ship.getBounds().overlaps( enemy.getBounds() ) )
    {
      Gdx.app.log( Unit001.LOG, "Hit" );
    }

    }


    bIter = bullets.iterator();
    while ( bIter.hasNext() )
    {
      b = bIter.next();
      b.update( ship );

      eIter = enemies.iterator();
      while ( eIter.hasNext() )
      {
        enemy = eIter.next();




        if ( enemy.getBounds().overlaps( b.getBounds() ) )
        {
          Gdx.app.log( Unit001.LOG, "enemy hit by bullet!" );
          Unit001Audio.hit();
          eIter.remove();
          bIter.remove();
        }
      }
    }
  }

  public void dispose()
  {

  }

  public void addBullet( Bullet bullet )
  {
    bullets.add( bullet );
  }

  public Array<Bullet> getBullets()
  {
    return bullets;
  }

  public WorldRenderer getRenderer()
  {
    return worldRenderer;
  }

  public void setWorldRenderer( WorldRenderer worldRenderer )
  {
    this.worldRenderer = worldRenderer;
  }
}
