public class CircleCollider implements Collidable {
	private int centerX;
	private int centerY;
	private int radius;

	public CircleCollider(int centerX, int centerY, int radius) {
		if (radius <= 0) {
			throw new IllegalArgumentException("Radius mora biti strogo pozitivan.");
		}
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = radius;
	}

	@Override
	public int getX() {
		return centerX;
	}

	@Override
	public int getY() {
		return centerY;
	}

	public int getCenterX() {
		return centerX;
	}

	public int getCenterY() {
		return centerY;
	}

	@Override
	public void setPosition(int x, int y) {
		this.centerX = x;
		this.centerY = y;
	}

	public int getRadius() {
		return radius;
	}

	@Override
	public boolean intersects(Collidable other) {
		if (other instanceof CircleCollider) {
			CircleCollider c = (CircleCollider) other;
			long dx = centerX - c.centerX;
			long dy = centerY - c.centerY;
			long rsum = (long) radius + c.radius;
			return dx * dx + dy * dy <= rsum * rsum;
		} else if (other instanceof RectangleCollider) {
			return other.intersects(this);
		} else {
			return false;
		}
	}
}
