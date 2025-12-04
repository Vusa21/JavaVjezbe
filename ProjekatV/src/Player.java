public class Player extends GameObject {
	private String name;
	private int health;

	public Player(String name, int health, int x, int y, Collidable collider) {
		super(x, y, collider);
		setName(name);
		setHealth(health);
	}

	private void setName(String name) {
		if (name == null) {
			name = "";
		}
		name = name.trim();
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Ime ne smije biti prazno.");
		}

		this.name = Character.toUpperCase(name.charAt(0)) + (name.length() > 1 ? name.substring(1) : "");
	}

	private void setHealth(int health) {
		if (health < 0 || health > 100) {
			throw new IllegalArgumentException("Health mora biti između 0 i 100.");
		}
		this.health = health;
	}

	public String getName() {
		return name;
	}

	public int getHealth() {
		return health;
	}

	public void decreaseHealth(int amount) {
		if (amount < 0) {
			return;
		}
		this.health = Math.max(0, this.health - amount);
	}

	@Override
	public String getDisplayName() {
		return name;
	}

	@Override
	public String toString() {
		return "Player{name='" + name + "', health=" + health + ", pos=(" + getX() + "," + getY() + ")}";
	}

	public boolean intersects(Enemy e) {

		return false;
	}
}
