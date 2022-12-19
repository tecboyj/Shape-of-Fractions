package tbs.geom;

public class IntVec2D {
	public final int x;
	public final int y;
	
	public IntVec2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public IntVec2D add(IntVec2D v) {
		return new IntVec2D(this.x + v.x, this.y + v.y);
	}
	
	IntVec2D add(int x, int y) {
		return new IntVec2D(this.x + x, this.y + y);
	}

	public IntVec2D sub(IntVec2D v) {
		return new IntVec2D(this.x - v.x, this.y - v.y);
	}

	IntVec2D sub(int x, int y) {
		return new IntVec2D(this.x - x, this.y - y);
	}

	IntVec2D mul(int s) {
		return new IntVec2D(this.x * s, this.y * s);
	}
	
	double dot(IntVec2D v) {
		return this.x * v.x + this.y * v.y;
	}
	
	public double magnitude() {
		return Math.sqrt(x * x + y * y);
	}
	
	public Vec2D toVec2D() {
		return new Vec2D(x, y);
	}
}
