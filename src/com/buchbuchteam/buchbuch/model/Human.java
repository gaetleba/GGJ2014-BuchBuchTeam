package com.buchbuchteam.buchbuch.model;

public class Human extends Player
{
	public Human()
	{
		controllable = Team.getInstance();
	}

	@Override
	public void right()
	{
		controllable.right();
	}

	@Override
	public void left()
	{
		controllable.left();
	}

	@Override
	public void up()
	{
		controllable.up();
	}

	@Override
	public void down()
	{
		controllable.down();
	}

}
