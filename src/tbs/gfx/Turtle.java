package tbs.gfx;

import java.awt.Color;
import java.awt.Graphics2D;

import tbs.geom.Vec2D;

public class Turtle implements FrameListener {
	private static final double TAO = Math.PI * 2;

	private final Graphics2D paintGraphics;
	private final Graphics2D overGraphics;
	private double size;
	private Vec2D position;
	private double angle;
	private boolean isPenDown = true;
	
	public Turtle(Graphics2D paintLayer, Graphics2D overLayer, int size) {
		this.size = size;
		paintGraphics = paintLayer;
		overGraphics = overLayer;
		this.position = new Vec2D(0, 0);
		this.angle = 0;
		
		setColour(0xffffff);
	}
	
	public Vec2D getPosition() {
		return position;
	}
	
	public double getAngle() {
		return angle * 180.0 / Math.PI;
	}
	
	public boolean getPenDown() {
		return isPenDown;
	}
	
	public void setColour(int rgb) {
		Color c = new Color(rgb);
		paintGraphics.setColor(c);
		overGraphics.setColor(c);
	}
	
	public void setPosition(Vec2D point) {
		this.position = point;
	}

	public void setAngle(double angle) {
		this.angle = angle * Math.PI / 180.0;
	}
	
	public void setPosition(double x, double y) {
		this.position = new Vec2D(x, y);
	}
	
	public void setPenDown(boolean isPenDown) {
		this.isPenDown = isPenDown;
	}
	
	public void reset() {
		setAngle(0);
		setColour(0xffffff);
		setPosition(0, 0);
		setPenDown(true);
	}
	
	public void move(double distance) {
		int x1 = (int)Math.round(position.x);
		int y1 = (int)Math.round(position.y);
		Vec2D vector = new Vec2D(distance, 0).rotate(angle);
		position = position.add(vector);		
		int x2 = (int)Math.round(position.x);
		int y2 = (int)Math.round(position.y);
		if (isPenDown) paintGraphics.drawLine(x1, y1, x2, y2);
	}
	
	public void rotate(double angle) {
		angle *= Math.PI / 180.0;
		this.angle = (this.angle + angle) % TAO;
		this.angle = (this.angle + TAO) % TAO;
	}
	
	@Override
	public void onFrame() {
		Vec2D points[] = { 
				new Vec2D(size, 0),
				new Vec2D(-size / 4, size / 2),
				new Vec2D(0, 0), 
				new Vec2D(-size / 4, -size / 2)
		};
		
		Vec2D src = position.add(points[points.length - 1].rotate(angle));
		int x1 = (int)Math.round(src.x);
		int y1 = (int)Math.round(src.y);
		
		for (Vec2D dst : points) {
			dst = position.add(dst.rotate(angle));
			int x2 = (int)Math.round(dst.x);
			int y2 = (int)Math.round(dst.y);
			
			overGraphics.drawLine(x1, y1, x2, y2);
			
			x1 = x2;
			y1 = y2;
		}
	}	
}
