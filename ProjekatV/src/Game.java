import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
	private Player player;
	private List<Enemy> enemies = new ArrayList<>();
	private List<String> log = new ArrayList<>();

	public Game() {
	}

	public void setPlayer(Player p) {
		this.player = p;
		log.add("Player created: " + p);
	}

	public Player getPlayer() {
		return player;
	}

	public List<Enemy> getEnemies() {
		return enemies;
	}

	public List<String> getLog() {
		return log;
	}

	public boolean checkCollision(Player p, Enemy e) {
		return p.intersects(e);
	}

	public void decreaseHealth(Player p, Enemy e) {
		int dmg = e.getEffectiveDamage();
		int before = p.getHealth();
		p.decreaseHealth(dmg);
		int after = p.getHealth();
		log.add("Player hit by " + e.getDisplayName() + " for " + dmg + " dmg. health: " + before + " -> " + after);
	}

	public void addEnemy(Enemy e) {
		enemies.add(e);
		log.add("Enemy added: " + e);
	}

	public List<Enemy> findByType(String query) {
		List<Enemy> result = new ArrayList<>();
		if (query == null) {
			query = "";
		}
		String q = query.toLowerCase();
		for (Enemy e : enemies) {
			if (e.getType().toLowerCase().contains(q)) {
				result.add(e);
			}
		}
		return result;
	}

	public List<Enemy> collidingWithPlayer() {
		List<Enemy> result = new ArrayList<>();
		if (player == null) {
			return result;
		}
		for (Enemy e : enemies) {
			if (checkCollision(player, e)) {
				result.add(e);
			}
		}
		return result;
	}

	public void resolveCollisions() {
		if (player == null) {
			return;
		}
		for (Enemy e : enemies) {
			if (checkCollision(player, e)) {
				decreaseHealth(player, e);
			}
		}
		if (player.getHealth() <= 0) {
			log.add("Player defeated.");
		} else {
			log.add("Collision resolution complete. Player health: " + player.getHealth());
		}
	}

	public static List<Enemy> loadEnemiesFromCSV(String filePath) {
		List<Enemy> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			int lineNo = 0;
			while ((line = br.readLine()) != null) {
				lineNo++;
				if (line.trim().isEmpty()) {
					continue;
				}
				String[] parts = line.split(",");
				for (int i = 0; i < parts.length; i++) {
					parts[i] = parts[i].trim();
				}

				try {
					if (parts.length < 8) {
						throw new IllegalArgumentException("Neispravan broj polja.");
					}
					String type = parts[0];
					String clazz = parts[1].toLowerCase();
					int x = Integer.parseInt(parts[2]);
					int y = Integer.parseInt(parts[3]);
					String shape = parts[4].toLowerCase();

					Collidable col;
					int indexAfterShape = 5;

					if (shape.equals("rect")) {
						if (parts.length < 9) {
							throw new IllegalArgumentException("Nedostaju parametri za rect.");
						}
						int w = Integer.parseInt(parts[5]);
						int h = Integer.parseInt(parts[6]);
						col = new RectangleCollider(x, y, w, h);
						indexAfterShape = 7;
					} else if (shape.equals("circle")) {
						if (parts.length < 8) {
							throw new IllegalArgumentException("Nedostaje parametar za circle.");
						}
						int r = Integer.parseInt(parts[5]);
						col = new CircleCollider(x, y, r);
						indexAfterShape = 6;
					} else {
						throw new IllegalArgumentException("Nepoznat shape: " + shape);
					}

					if (parts.length <= indexAfterShape + 1) {
						throw new IllegalArgumentException("Nedostaju damage/health polja.");
					}

					int damage = Integer.parseInt(parts[indexAfterShape]);
					int health = Integer.parseInt(parts[indexAfterShape + 1]);

					Enemy enemy;
					if ("melee".equals(clazz)) {
						enemy = new MeleeEnemy(type, damage, health, x, y, col);
					} else if ("boss".equals(clazz)) {
						enemy = new BossEnemy(type, damage, health, x, y, col);
					} else {
						throw new IllegalArgumentException("Nepoznata klasa neprijatelja: " + clazz);
					}

					list.add(enemy);
				} catch (NumberFormatException nfe) {
					throw new IllegalArgumentException("Format broja u liniji " + lineNo + ": " + nfe.getMessage());
				}
			}
		} catch (IOException ioe) {
			throw new IllegalArgumentException("Greska pri citanju fajla: " + ioe.getMessage());
		}
		return list;
	}
}
