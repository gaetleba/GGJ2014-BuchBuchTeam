package com.buchbuchteam.buchbuch.model.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.buchbuchteam.buchbuch.control.Controllable;
import com.buchbuchteam.buchbuch.model.Team;
import com.buchbuchteam.buchbuch.model.entities.traps.Acorn;
import com.buchbuchteam.buchbuch.view.screens.GameScreen;

public class MovingTree extends MoveableEntity implements Controllable
{
	private static MovingTree instance;
	
	private float x, y;
	private int firing;
	private int dying;
	
	private MovingTree()
	{
		this.x = 1000;
		this.y = 240;
		this.dying = 0;
		cry();
	}
	
	public void setFiring()
	{
		firing = 60;
	}

	@Override
	public TextureRegion getFrame(float stateTime)
	{
		if (x > 700)
			x--;
		if (dying>0)
		{
			dying --;
			if (dying == 0)
			{
				this.x = 1100;
				this.y = 240;
			}
			return treeDie.getKeyFrames()[dying/20];
		}
				
		if (firing>=0)
		{
			firing --;
			if (firing == 10)
				fireAcorn();
			return acornFireAnim.getKeyFrames()[firing/20];
		}
		return treeAnim.getKeyFrame(stateTime);
	}

	@Override
	public float getX()
	{
		return x;
	}

	@Override
	public float getY()
	{
		return y;
	}
	
	public static void cry(){
		Sound sound = Gdx.audio.newSound(Gdx.files.internal("sounds/Tree.wav"));
		sound.play(1.0f);
		sound.loop();
	}

	public static MovingTree getInstance()
	{
		if (instance == null)
			instance = new MovingTree();
		return instance;
	}

	@Override
	public void up()
	{
		// TODO Auto-generated method stub
	}

	private void fireAcorn()
	{
		System.out.println("a");
		GameScreen.getInstance().add(new Acorn(x+64, y+16));
	}

	@Override
	public void down()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void left()
	{
		setFiring();
	}

	@Override
	public void right()
	{
		// TODO Auto-generated method stub
		
	}
	
	public void kill()
	{
		dying = 120;
		Team.getInstance().walk();
	}

	private static Animation acornFireAnim;
	{
		Sprite[] treeFrames = new Sprite[3];
		treeFrames[0] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/acorn/char_tree_gland_03.png")), 0,
				0, 128, 128);
		treeFrames[1] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/acorn/char_tree_gland_02.png")), 0,
				0, 128, 128);
		treeFrames[2] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/acorn/char_tree_gland_01.png")), 0,
				0, 128, 128);
		acornFireAnim = new Animation(0.2F, treeFrames);
		acornFireAnim.setPlayMode(Animation.LOOP);
	}	
	private static Animation treeAnim;
	{
		Sprite[] treeFrames = new Sprite[3];
		treeFrames[0] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/char_tree01.png")), 0,
				0, 128, 128);
		treeFrames[1] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/char_tree02.png")), 0,
				0, 128, 128);
		treeFrames[2] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/char_tree03.png")), 0,
				0, 128, 128);
		treeAnim = new Animation(0.2F, treeFrames);
		treeAnim.setPlayMode(Animation.LOOP);
	}
	private static Animation treeDie;
	{
		Sprite[] treeFrames = new Sprite[6];
		treeFrames[0] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/death/char_tree_death06.png")), 0,
				0, 128, 128);
		treeFrames[1] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/death/char_tree_death05.png")), 0,
				0, 128, 128);
		treeFrames[2] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/death/char_tree_death04.png")), 0,
				0, 128, 128);
		treeFrames[3] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/death/char_tree_death03.png")), 0,
				0, 128, 128);
		treeFrames[4] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/death/char_tree_death02.png")), 0,
				0, 128, 128);
		treeFrames[5] = new Sprite(new Texture(
				Gdx.files.internal("img/characters/tree/death/char_tree_death01.png")), 0,
				0, 128, 128);
		treeDie = new Animation(0.1F, treeFrames);
		treeDie.setPlayMode(Animation.LOOP);
	}
	public boolean isInplace()
	{
		return x <= 700;
	}

	public boolean isDying()
	{
		return dying > 0;
	}
}
