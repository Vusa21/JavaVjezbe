public interface Collidable {
	int getX();

	int getY();

	void setPosition(int x, int y);

	boolean intersects(Collidable other);
}
