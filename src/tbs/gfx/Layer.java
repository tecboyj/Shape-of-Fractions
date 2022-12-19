package tbs.gfx;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.image.BufferedImage;

import tbs.geom.Vec2D;

public class Layer implements Comparable<Layer> {
	private final int width;
	private final int height;
	private final int depth;
	private BufferedImage image;
	private final AffineTransform affineTransform;
	private final AffineTransform inverseTransform;
	private final Graphics2D graphics;
	private int rgb = 0xffffff;

	public Layer(int width, int height, int depth) {
		this.width = width;
		this.height = height;
		this.depth = depth;
		int mode = depth != 0 ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB;
		image = new BufferedImage(width, height, mode);
		
		affineTransform = new AffineTransform();
		affineTransform.translate(width / 2.0, height / 2.0);
		affineTransform.scale(1, -1);
		inverseTransform = new AffineTransform(affineTransform);
		try {
			inverseTransform.invert();
		} catch(NoninvertibleTransformException e) {
			inverseTransform.setToIdentity();;
		}
		
		graphics = image.createGraphics();
	}
	
	public Graphics2D createGraphics() {
		Graphics2D g = image.createGraphics();
		g.setTransform(affineTransform);
		return g;
	}
	
	public Graphics2D getGraphics() {
		return graphics;
	}
	
	public AffineTransform getTransform() {
		return affineTransform;
	}
	
	public AffineTransform getInverseTransform() {
		return inverseTransform;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	@Override
	public int hashCode() {
		return depth;
	}
	
	@Override
	public boolean equals(Object o) {
		return o.getClass() == Layer.class && ((Layer)o).depth == depth;
	}
	
	@Override
	public int compareTo(Layer o) {
		return depth - o.depth;
	}
}
