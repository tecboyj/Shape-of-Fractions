package tbs.simpleapp;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import tbs.gfx.Screen;

public class SimpleScreen extends JPanel {
	private static final long serialVersionUID = 1L;
	private final Screen screen;
	
	SimpleScreen(Screen screen) {
		setPreferredSize(new Dimension(screen.width, screen.height));
		this.screen = screen;
	}

	@Override
	public void paintComponent(Graphics g2) {
		Graphics2D g = (Graphics2D)g2;		
		screen.paint(g);
	}
}
