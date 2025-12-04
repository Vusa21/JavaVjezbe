public class RectangleCollider implements Collidable {
	private int x;
	private int y;
	private int width;
	private int height;

	public RectangleCollider(int x, int y, int width, int height) {
		if (width <= 0 || height <= 0) {
			throw new IllegalArgumentException("Širina i visina moraju biti veće od nule.");
		}
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public boolean intersects(Collidable other) {
		if (other instanceof RectangleCollider) {
			RectangleCollider r = (RectangleCollider) other;
			boolean noOverlap = (x + width <= r.x) || (r.x + r.width <= x) || (y + height <= r.y)
					|| (r.y + r.height <= y);
			return !noOverlap;
		} else if (other instanceof CircleCollider) {
			CircleCollider c = (CircleCollider) other;
			int closestX = clamp(c.getCenterX(), x, x + width);
			int closestY = clamp(c.getCenterX(), y, y + height);
			long dx = c.getCenterX() - closestX;
			long dy = c.getCenterX() - closestY;
			return dx * dx + dy * dy <= (long) c.getRadius() * c.getRadius();
		} else {
			return false;
		}
	}

	private int clamp(int val, int min, int max) {
		if (val < min) {
			return min;
		}
		if (val > max) {
			return max;
		}
		return val;
	}
}
