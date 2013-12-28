package tomb.unit001.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEmitter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import tomb.unit001.model.Bullet;
import tomb.unit001.model.Enemy;
import tomb.unit001.model.Follower;
import tomb.unit001.model.Ship;

import java.util.Iterator;

/**
 * Created with IntelliJ IDEA. User: tombeadman Date: 17/10/2013 Time: 16:10
 */
public class WorldRenderer

{
  ParticleEmitter exhaust;
  SpriteBatch batch;
  OrthographicCamera cam;
  World world;
  Texture shipTexture, followerTexture, bulletTexture;
  Ship ship;
  float width, height;
  ShapeRenderer shapeRenderer;
  Array<Enemy> enemies;
  Enemy e;
  Array<Bullet> bullets = new Array<Bullet>();
  Iterator<Bullet> iterator;
  Bullet b;
  Iterator<Enemy> eIterator;


  public WorldRenderer( final World world )
  {
    this.world = world;

    world.setWorldRenderer( this );
    enemies = world.getEnemies();

    width =  Gdx.graphics.getWidth() / 40;
    height =  Gdx.graphics.getHeight() / 40;
    batch = new SpriteBatch();
    cam = new OrthographicCamera();
    cam.setToOrtho( false, width, height );
    cam.update();

    batch = new SpriteBatch(  );
    batch.setProjectionMatrix( cam.combined );



    shipTexture = new Texture( "assets/data/ship.png" );
    shipTexture.setFilter( Texture.TextureFilter.Linear, Texture.TextureFilter.Linear );
    followerTexture = new Texture("assets/data/follower.png");
    followerTexture.setFilter( Texture.TextureFilter.Linear, Texture.TextureFilter.Linear  );

    bulletTexture = new Texture("assets/data/bullet.png");
    bulletTexture.setFilter( Texture.TextureFilter.Linear, Texture.TextureFilter.Linear  );
    shapeRenderer = new ShapeRenderer(  );

    exhaust = new ParticleEmitter(  );

    try {
      exhaust.load( Gdx.files.internal( "assets/data/exhaust" ).reader( 2024 ) );
    }catch(Exception e)
    {
      e.printStackTrace();
    }
    Texture particleTexture = new Texture(Gdx.files.internal( "assets/data/particle.png" ));
    Sprite particle = new Sprite( particleTexture );
    exhaust.setSprite( particle );
    exhaust.getScale().setHigh( 0.3f );
    exhaust.start();

  }

  public void render()
  {
    Gdx.gl.glClearColor( 0, 0, 0, 1 );
    Gdx.gl.glClear( GL10.GL_COLOR_BUFFER_BIT );

    ship = world.getShip();
    enemies = world.getEnemies();
    bullets = world.getBullets();


    exhaust.setPosition( ship.getPosition().x + ship.getWidth()/2, ship.getPosition().y + ship.getHieght()/2 );

    setExhaustRotation();

    cam.position.set( ship.getPosition().x, ship.getPosition().y,0 );
    cam.update();
    batch.setProjectionMatrix( cam.combined );
    batch.begin();
    exhaust.draw( batch,Gdx.graphics.getDeltaTime() );
    batch.draw( shipTexture, ship.getPosition().x, ship.getPosition().y, ship.getWidth() / 2, ship.getHieght() / 2,
                ship.getWidth(), ship.getHieght(), 1, 1,
                ship.getRotation(), 0, 0, shipTexture.getWidth(), shipTexture.getHeight(), false, false );


    eIterator = enemies.iterator();
    while(eIterator.hasNext())
    {
      e = eIterator.next();
      batch.draw(followerTexture, e.getPosition().x, e.getPosition().y, e.getWidth() / 2,
                 e.getHieght() / 2,
                 e.getWidth(), e.getHieght(), 1, 1,
                 e.getRotation(), 0, 0, followerTexture.getWidth(), followerTexture.getHeight(), false, false );

    }

    iterator = bullets.iterator();
    while(iterator.hasNext())
    {
      b = iterator.next();
      batch.draw(bulletTexture, b.getPosition().x, b.getPosition().y, b.getWidth() / 2,
                 b.getHieght() / 2,
                 b.getWidth(), b.getHieght(), 1, 1,
                 b.getRotation(), 0, 0, bulletTexture.getWidth(), bulletTexture.getHeight(), false, false );

    }
    batch.end();

    shapeRenderer.setProjectionMatrix( cam.combined );

    //Ship and enemy hitboxes
    shapeRenderer.begin( ShapeRenderer.ShapeType.Rectangle );
    shapeRenderer.setColor( Color.CYAN );
    shapeRenderer.rect( ship.getBounds().x, ship.getBounds().y, ship.getBounds().width, ship.getBounds().height );
    shapeRenderer.setColor( Color.RED );
    eIterator = enemies.iterator();
    while(eIterator.hasNext())
    {
      e = eIterator.next();
    shapeRenderer.rect( e.getBounds().x, e.getBounds().y, e.getBounds().width, e.getBounds().height );
    }


    shapeRenderer.end();
  }

  private void setExhaustRotation()
  {
    float angle = ship.getRotation();
    exhaust.getAngle().setLow( angle + 270 );
    exhaust.getAngle().setHighMin( angle+270-45 );
    exhaust.getAngle().setHighMax( angle+270+45 );

  }

  public OrthographicCamera getCamera()
  {
    return cam;
  }

  public void dispose()
  {
    batch.dispose();
    shipTexture.dispose();
    shapeRenderer.dispose();
  }
}
