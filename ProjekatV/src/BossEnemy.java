public class BossEnemy extends Enemy {
	public BossEnemy(String type, int damage, int health, int x, int y, Collidable collider) {
		super(type, damage, health, x, y, collider);
	}

	@Override
	public int getEffectiveDamage() {
		return Math.min(Integer.MAX_VALUE, super.getEffectiveDamage() * 2);
	}

	@Override
	public String toString() {
		return "BOSS " + super.toString();
	}
}
