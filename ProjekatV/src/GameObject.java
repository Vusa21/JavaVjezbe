public abstract class GameObject {
    private int x;
    private int y;
    private Collidable collider;

    public GameObject(int x, int y, Collidable collider) {
        if (collider == null) {
            throw new IllegalArgumentException("Collider ne smije biti null");
        }
        this.x = x;
        this.y = y;
        this.collider = collider;
        this.collider.setPosition(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Collidable getCollider() {
        return collider;
    }

    public void setX(int x) {
        this.x = x;
        this.collider.setPosition(this.x, this.y);
    }

    public void setY(int y) {
        this.y = y;
        this.collider.setPosition(this.x, this.y);
    }

    public boolean intersects(GameObject other) {
        if (other == null) return false;
        return this.collider.intersects(other.collider);
    }

    public abstract String getDisplayName();

    @Override
    public String toString() {
        return getDisplayName() + " (" + x + "," + y + ")";
    }
}