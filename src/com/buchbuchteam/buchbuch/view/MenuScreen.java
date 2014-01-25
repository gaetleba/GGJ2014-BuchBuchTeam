package com.buchbuchteam.buchbuch.view;
import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

public class MenuScreen extends ScreenMaster implements MouseListener {
	
	//Variables de bouttons
	
	
	public static final int buttonWidth = 250, buttonHeight=40;
	public static final int espaceEntreButton = 5;
	public static final int buttonX = Game.WIDTH/2 - buttonWidth / 2;
	public static final int jouerY = Game.HEIGHT /2, 
							controlY = jouerY - buttonHeight - espaceEntreButton,
							hightscoreY = controlY - buttonHeight - espaceEntreButton, 
							creditsY= hightscoreY - buttonHeight - espaceEntreButton, 
							quitterY = creditsY - buttonHeight - espaceEntreButton ;
	private Sprite jouerSprite, controlSprite, hightscoreSprite, creditsSprite, quitterSprite;
	private Button jouerButton, controlButton, hightscoreButton, creditsButton, quitterButton;
	
	private Animation jack;
	private Animation tree;
	private float animTime;

	protected MenuScreen() {
		super("img/menu/bgmenu.png");
		Gdx.input.setInputProcessor(stage);	
		{
			Sprite[] jackFrames = new Sprite[4];
			jackFrames[0] = new Sprite(
					new Texture(
							Gdx.files
									.internal("img/characters/jack/char_jackMarche.png")),
					0, 0, 64, 64);
			jackFrames[1] = new Sprite(
					new Texture(
							Gdx.files
									.internal("img/characters/jack/char_jackMarche.png")),
					64, 0, 64, 64);
			jackFrames[2] = new Sprite(
					new Texture(
							Gdx.files
									.internal("img/characters/jack/char_jackMarche.png")),
					128, 0, 64, 64);
			jackFrames[3] = new Sprite(
					new Texture(
							Gdx.files
									.internal("img/characters/jack/char_jackMarche.png")),
					192, 0, 64, 64);
			jack = new Animation(0.2F, jackFrames);
			jack.setPlayMode(Animation.LOOP);
		}
		
		{
			Sprite[] treeFrames = new Sprite[3];
			treeFrames[0] = new Sprite(
					new Texture(
							Gdx.files
									.internal("img/characters/tree/char_tree01.png")),
					0, 0, 128, 128);
			treeFrames[1] = new Sprite(
					new Texture(
							Gdx.files
									.internal("img/characters/tree/char_tree02.png")),
					0, 0, 128, 128);
			treeFrames[2] = new Sprite(
					new Texture(
							Gdx.files
									.internal("img/characters/tree/char_tree03.png")),
					0, 0, 128, 128);
			tree = new Animation(0.2F, treeFrames);
			tree.setPlayMode(Animation.LOOP);
		}
	

		//sprite menu 
		
		jouerSprite = new Sprite(new Texture(Gdx.files.internal("img/menu/jouerbutton.png")),buttonWidth,buttonHeight);
		jouerSprite.setX(buttonX);
		jouerSprite.setY(jouerY);
		jouerButton = new Button(new SpriteDrawable(jouerSprite));
		stage.addActor(jouerButton);
		jouerButton.addListener(new ClickListener(){
			public void clicked(InputEvent event, float x, float y){
				((com.badlogic.gdx.Game) Gdx.app.getApplicationListener()).setScreen(new GameScreen());
				jouerButton.removeListener(this);
				controlButton.removeListener(this);
				hightscoreButton.removeListener(this);
				creditsButton.removeListener(this);
				quitterButton.removeListener(this);
			}
		});

		controlSprite = new Sprite(new Texture(Gdx.files.internal("img/menu/controlbutton.png")),buttonWidth,buttonHeight);
		controlSprite.setX(buttonX);
		controlSprite.setY(controlY);
		controlButton = new Button(new SpriteDrawable(controlSprite));
		stage.addActor(controlButton);
		
		hightscoreSprite = new Sprite(new Texture(Gdx.files.internal("img/menu/hightscorebutton.png")),buttonWidth,buttonHeight);
		hightscoreSprite.setX(buttonX);
		hightscoreSprite.setY(hightscoreY);
		hightscoreButton = new Button(new SpriteDrawable(hightscoreSprite));
		stage.addActor(hightscoreButton);
	
		
		creditsSprite = new Sprite(new Texture(Gdx.files.internal("img/menu/creditsbutton.png")),buttonWidth,buttonHeight);
		creditsSprite.setX(buttonX);
		creditsSprite.setY(creditsY);
		creditsButton = new Button(new SpriteDrawable(creditsSprite));
		stage.addActor(creditsButton);
	
		quitterSprite = new Sprite(new Texture(Gdx.files.internal("img/menu/quitterbutton.png")),buttonWidth,buttonHeight);
		quitterSprite.setX(buttonX);
		quitterSprite.setY(quitterY);
		quitterButton = new Button(new SpriteDrawable(quitterSprite));
		stage.addActor(quitterButton);
		
	
		
		
	}

	@Override
	public void render(float delta) {
		
		


		if(MouseInfo.getPointerInfo().getLocation().x == 10 )
		{
			System.out.println("10");
		}
		super.bgRender();
		animTime += Gdx.graphics.getDeltaTime();
		stage.act(delta);
		
stage.act();
stage.getSpriteBatch().begin();

stage.getSpriteBatch().draw(bgSprite, 0, 0);

stage.getSpriteBatch().draw(jouerSprite, buttonX, jouerY);
stage.getSpriteBatch().draw(controlSprite, buttonX, controlY);
stage.getSpriteBatch().draw(hightscoreSprite, buttonX, hightscoreY);
stage.getSpriteBatch().draw(creditsSprite, buttonX, creditsY);
stage.getSpriteBatch().draw(quitterSprite, buttonX, quitterY);


stage.getSpriteBatch().draw(jack.getKeyFrame(animTime), 100*animTime % (960-64), 4);
stage.getSpriteBatch().draw(tree.getKeyFrame(animTime), 80*animTime % (960-128), 20);

stage.getSpriteBatch().end();
	
	
	
	
		
	
	
	
		}

	@Override
	public void resize(int width, int height)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void show()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void hide()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void pause()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void resume()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose()
	{
		// TODO Auto-generated method stub

	}
	
	
		
		public void SOURIS(){
			
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			int x=e.getX();
		    int y=e.getY();
		    System.out.println(x+","+y);//these co-ords are relative to the component
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	

}
