import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.ImageIcon;

public class DispScreen extends JFrame {
	private String owner;
	private JPanel panel;

	public DispScreen(String owner, boolean isPublic) {
		this.owner = owner;
		setSize(800, 600);
		setTitle("Screen: " + owner);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		panel = new JPanel();
		panel.setLayout(null);
		add(panel);
	}

	public String getowner() {
		return owner;
	}

	public void spawnItem(Item i, List<JLabel> labels) {
		ImageIcon img = i.getImg(owner);
		JLabel label = new JLabel(img);
		labels.add(label);
		label.addMouseListener(new Movement());
		label.addMouseMotionListener(new Movement());
		label.addComponentListener(new ChangeSync(labels));
		panel.add(label);
		label.setBounds(50, 50, img.getIconWidth(), img.getIconHeight());
	}
}
