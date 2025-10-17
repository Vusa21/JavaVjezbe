class player {
	private int x;
	private int y;
	private int width;
	private int height;
	private int health;

	Player(int x, int y,int width, int height, int health){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.health = health;
		
		
}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if (health < 0) {
			this.health = 0;
		} else if (health > 100) {
			this.health = 100;
		} else {
			this.health = 0;
		}
	}

	class enemy {
		private int x;
		private int y;
		private int width;
		private int height;
		private int demage;

	Player(int x, int y,int width, int height, int demage){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.demage = demage;
		
		
}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public int getdemage() {
			return health;
		}

		public void setHealth(int demage) {
			if (demage < 0) {
				this.demage = 0;
			} else if (demage > 100) {
				this.demage = 100;
			} else {
				this.demage = 0;
			}
		}

		public class game {

			public static boolean checkCollision(player p, enemy e) {
				return (p.getX() < e.getX() + e.getWidth() && p.getX() + p.getWidth() > e.getX()
						&& p.getY() < e.getY() + e.getHeight() && p.getY() + p.getHeight() > e.getY());
			}

			// ako ima kolizije smanji health
			public static void decreaseHealth(player p, enemy e) {
				if (checkCollision(p, e)) {
					int newHealth = p.getHealth() - e.getdemage();
					if (newHealth < 0) {
						newHealth = 0;
					}
					p.setHealth(newHealth);
					System.out.println("Desila se kolizija novi health je: " + p.getHealth());
				}
			}

		}
	}
}
