public class Enemy extends GameObject implements Attacker {
	private String type;
	private int damage;
	private int health;

	public Enemy(String type, int damage, int health, int x, int y, Collidable collider) {
		super(x, y, collider);
		setType(type);
		setDamage(damage);
		setHealth(health);
	}

	protected void setType(String type) {
		if (type == null) {
			type = "";
		}
		type = type.trim();
		if (type.isEmpty()) {
			throw new IllegalArgumentException("Type ne smije biti prazno.");
		}
		this.type = type;
	}

	protected void setDamage(int damage) {
		if (damage < 0 || damage > 100) {
			throw new IllegalArgumentException("Damage mora biti između 0 i 100.");
		}
		this.damage = damage;
	}

	protected void setHealth(int health) {
		if (health < 0 || health > 100) {
			throw new IllegalArgumentException("Health mora biti između 0 i 100.");
		}
		this.health = health;
	}

	public String getType() {
		return type;
	}

	public int getDamage() {
		return damage;
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

	public int getEffectiveDamage() {
		return damage;
	}

	@Override
	public String getDisplayName() {
		return type;
	}

	@Override
	public String toString() {
		return "Enemy{type='" + type + "', dmg=" + damage + ", hp=" + health + ", pos=(" + getX() + "," + getY() + ")}";
	}
}
