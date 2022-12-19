package tbs.simpleapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import tbs.geom.Vec2D;
import tbs.gfx.Screen;

public abstract class SimpleApp {
	public final Screen screen;
	private final JFrame frame;
	private final SimpleScreen simpleScreen;
	
	public SimpleApp() {
		this(400, 400);
	}
		
	public SimpleApp(int width, int height) {
		frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Simple graphics window");

		screen = new Screen(width, height);
		simpleScreen = new SimpleScreen(screen);
		frame.getContentPane().add(simpleScreen);

		frame.pack();
		frame.setVisible(true);
		
		Timer timer = new Timer(20, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				screen.onFrame();
				onFrame();
				simpleScreen.repaint();
			}
		});

		SwingUtilities.invokeLater(new Runnable() {	
			@Override
			public void run() {
				main();
				addListeners();
				timer.start();
			}
		});
	}
	
	private void addListeners() {
		final SimpleApp app = this;
		
		simpleScreen.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				Vec2D point = new Vec2D(e.getX(), e.getY());
				point = screen.unproject(point);
				app.onMouseMove((int)point.x, (int)point.y);
			}			
		});
		
		simpleScreen.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Vec2D point = new Vec2D(e.getX(), e.getY());
				point = screen.unproject(point);
				app.onMouseClick((int)point.x, (int)point.y);
			}
		});
	}
	
	public void main() {
	}
	
	public void onFrame() {
	}
	
	public void onMouseMove(int x, int y) {
	}
	
	public void onMouseClick(int x, int y) {
	}
	
	public void sleep(int milliseconds) {
		try {
			Thread.sleep(milliseconds);
		} catch (Exception e) {
		}
	}
	
	public void setTitle(String title) {
		frame.setTitle(title);
	}
}
