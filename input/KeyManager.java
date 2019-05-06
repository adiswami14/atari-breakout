package dev.adiswami.finalproject.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class KeyManager implements KeyListener{

	private boolean[] keys;
	public boolean left, right; //{left, right};
	public boolean spacebar;
	public KeyManager(){
		keys = new boolean[256];
	}
	public void tick()
	{
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		spacebar = keys[KeyEvent.VK_SPACE];
	}
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()]=true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()]=false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

}
