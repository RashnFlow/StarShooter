package ru.shishmakov;

import com.badlogic.gdx.Game;

import ru.shishmakov.screen.MenuScreen;

public class StarShooter extends Game {
	@Override
	public void create () {
		setScreen( new MenuScreen());
	}

}
