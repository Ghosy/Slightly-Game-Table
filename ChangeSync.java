import java.util.List;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JLabel;


public class ChangeSync extends ComponentAdapter {
	private List<JLabel> labels;
	private boolean isChanging = false;

	public ChangeSync(List<JLabel> labels) {
		this.labels = labels;
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		if(!isChanging) {
			isChanging = true;
			for(JLabel j: labels) {
				JLabel cur = (JLabel)e.getComponent();
				if(!j.equals(cur)) {
					j.setLocation(cur.getLocation());
				}
			}
			isChanging = false;
		}
	}
}
