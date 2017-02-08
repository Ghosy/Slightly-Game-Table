import java.util.List;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Icon;

public class DispScreen extends JFrame {
	private String owner;
	private JPanel panel;
	private JLabel background;

	public DispScreen(String owner, boolean isPublic) {
		this.owner = owner;
		setSize(800, 600);
		setTitle("Screen: " + owner);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		panel = new JPanel();
		add(panel);
		// Create background label
		background = new JLabel() {
			@Override
			public boolean isOptimizedDrawingEnabled() {
				return false;
			}
		};
		background.setBounds(0, 0, 800, 600);
		panel.setLayout(new BorderLayout());
		panel.add(background);
		panel.setLayout(null);
	}

	public String getowner() {
		return owner;
	}

	public void changeBackground(Icon icon) {
		background.setIcon(icon);
		panel.repaint();
	}

	public void spawnItem(Item i, List<Item> items) {
		// Setup item based on owner context of DispScreen
		i.init(owner);
		items.add(i);
		i.addMouseListener(new Movement());
		i.addMouseMotionListener(new Movement());
		i.addComponentListener(new ChangeSync(items));
		panel.add(i);
		Icon img = i.getIcon();
		i.setBounds(i.getX(), i.getY(), img.getIconWidth(), img.getIconHeight());
		// Make sure everything is up to date
		panel.repaint();
	}
}
