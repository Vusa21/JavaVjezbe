public class Player extends GameObject {
	private int vx;
	private int vy;
	private String name;
	private int health;

	public int getVx() {
		return vx;
	}

	public void setVx(int vx) {
		this.vx = vx;
	}

	public int getVy() {
		return vy;
	}

	public void setVy(int vy) {
		this.vy = vy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public Player(int x, int y, CollisionShape shape) {
		super(x, y, shape);
		this.vx = 0;
		this.vy = 0;
	}

	public void setVelocity(int vx, int vy) {
		this.vx = vx;
		this.vy = vy;
	}

	@Override
	public void update() {
		move(vx, vy);
	}
}