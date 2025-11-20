abstract class GameObject {
	private int x;
	private int y;
	private CollisionShape shape;

	public GameObject(int x, int y, CollisionShape shape) {
		this.x = x;
		this.y = y;
		this.shape = shape;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

	public CollisionShape getShape() {
		return shape;
	}

	public void setShape(CollisionShape shape) {
		this.shape = shape;
	}

	public abstract void update();

	public boolean collidesWith(GameObject other) {
		if (this.shape == null || other == null || other.getShape() == null) {
			return false;
		}
		return this.shape.intersectsWith(other.getShape(), this.getX(), this.getY(), other.getX(), other.getY());
	}

	public boolean intersects(GameObject other) {
		if (other == null) {
			return false;
		}
		if (this.shape == null || other.getShape() == null) {
			return false;
		}
		return this.shape.intersectsWith(other.getShape(), this.getX(), this.getY(), other.getX(), other.getY());
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " at (" + x + ", " + y + ")";
	}
}