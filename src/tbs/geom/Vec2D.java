package tbs.geom;

public class Vec2D {
	public final double x;
	public final double y;
	
	public Vec2D(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vec2D add(Vec2D v) {
		return new Vec2D(this.x + v.x, this.y + v.y);
	}
	
	Vec2D add(double x, double y) {
		return new Vec2D(this.x + x, this.y + y);
	}

	public Vec2D sub(Vec2D v) {
		return new Vec2D(this.x - v.x, this.y - v.y);
	}

	Vec2D sub(double x, double y) {
		return new Vec2D(this.x - x, this.y - y);
	}

	Vec2D mul(double s) {
		return new Vec2D(this.x * s, this.y * s);
	}
	
	double dot(Vec2D v) {
		return this.x * v.x + this.y * v.y;
	}
	
	public double magnitude() {
		return Math.sqrt(x * x + y * y);
	}
	
	public Vec2D rotate(double angle) {
		double sin = Math.sin(angle);
		double cos = Math.cos(angle);
		
		double x = this.x * cos - this.y * sin;
		double y = this.x * sin + this.y * cos;
		return new Vec2D(x, y);
	}
	
	public IntVec2D toIntVec2D() {
		int x = (int)Math.round(this.x);
		int y = (int)Math.round(this.y);
		return new IntVec2D(x, y);
	}
}
