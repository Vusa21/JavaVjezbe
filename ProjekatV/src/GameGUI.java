import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GameGUI extends JFrame {

	private JTextField nameField;
	private JTextField healthField;
	private JTextField xField;
	private JTextField yField;
	private JRadioButton rectBtn;
	private JRadioButton circleBtn;
	private JTextArea output;

	public GameGUI() {
		setTitle("Igra - Player Setup");
		setSize(400, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		add(new JLabel("Ime igrača:"));
		nameField = new JTextField(20);
		add(nameField);

		add(new JLabel("Health (0-100):"));
		healthField = new JTextField(20);
		add(healthField);

		add(new JLabel("Pozicija X:"));
		xField = new JTextField(20);
		add(xField);

		add(new JLabel("Pozicija Y:"));
		yField = new JTextField(20);
		add(yField);

		rectBtn = new JRadioButton("Pravougaonik (32x32)");
		circleBtn = new JRadioButton("Krug (r=16)");
		ButtonGroup group = new ButtonGroup();
		group.add(rectBtn);
		group.add(circleBtn);
		rectBtn.setSelected(true);

		add(rectBtn);
		add(circleBtn);

		JButton startBtn = new JButton("Pokreni igru");
		add(startBtn);

		output = new JTextArea(15, 30);
		output.setEditable(false);
		add(new JScrollPane(output));

		startBtn.addActionListener(e -> startGame());

		setVisible(true);
	}

	private void startGame() {
		try {
			String name = nameField.getText();
			int health = Integer.parseInt(healthField.getText());
			int x = Integer.parseInt(xField.getText());
			int y = Integer.parseInt(yField.getText());

			Collidable collider;

			if (rectBtn.isSelected()) {
				collider = new RectangleCollider(x, y, 32, 32);
			} else {
				collider = new CircleCollider(x, y, 16);
			}

			Player player = new Player(x, y, collider, name, health);

			Game game = new Game();
			Game.loadEnemiesFromCSV("src/enemies.csv");

			game.resolveCollisions();

			output.setText("");
			output.append("Player:\n" + player + "\n\n");
			output.append("Enemy list:\n" + game.getEnemies() + "\n\n");
			output.append("Enemies colliding with player:\n" + game.collidingWithPlayer() + "\n\n");
			output.append("Game log:\n");

			for (String log : game.getLog()) {
				output.append(log + "\n");
			}

			if (player.getHealth() <= 0) {
				JOptionPane.showMessageDialog(this, "Igrač je poražen!");
			} else {
				JOptionPane.showMessageDialog(this, "Igra završena! Igrač je preživio.");
			}

		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Greška: " + ex.getMessage());
		}
	}
}
