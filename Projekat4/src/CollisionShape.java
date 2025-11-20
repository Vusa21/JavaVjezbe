
public abstract class CollisionShape {

	public abstract boolean intersectsWith(CollisionShape other, double x1, double y1, double x2, double y2);

	protected void validateNonNegative(String name, double value) {
		if (value < 0) {
			throw new IllegalArgumentException(name + "Mora biti pozitivna vrijednost:" + value);
		}
	}

	public abstract String getDisplayName();
}
