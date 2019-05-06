package dev.adiswami.finalproject.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;

import dev.adiswami.finalproject.Game;
import dev.adiswami.finalproject.gfx.Text;


public class MenuState extends State{

		private Game game;
		public MenuState(Game game)
		{
			super(game);
			this.game = game;
		}
		@Override
		public void tick() {
			if(game.getMouse().LeftP() && MouseInfo.getPointerInfo().getLocation().x>=0 && MouseInfo.getPointerInfo().getLocation().y<=800)
				State.setState(game.gameState);
			
		}

		@Override
		public void render(Graphics g) {
			//g.setColor(Color.DARK_GRAY);
			//g.setFont(new Font("Sans Serif", Font.BOLD, 50));
			//g.drawString("ATARI BREAKOUT", 30, 90);
			Text.drawString(g, "ATARI BREAKOUT", 275, 90, Color.YELLOW, new Font("Times New Roman", Font.ROMAN_BASELINE, 50));
			Text.drawString(g,"PLAY", 425, 400, Color.PINK, new Font("Times New Roman", Font.ITALIC, 50));
		}


}
