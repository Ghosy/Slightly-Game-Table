import java.util.List;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class ChangeSync extends ComponentAdapter {
	private List<Item> items;
	private boolean isChanging = false;

	public ChangeSync(List<Item> items) {
		this.items = items;
	}

	@Override
	public void componentMoved(ComponentEvent e) {
		if(!isChanging) {
			isChanging = true;
			for(Item i: items) {
				Item cur = (Item)e.getComponent();
				if(!i.equals(cur)) {
					i.setLocation(cur.getLocation());
				}
			}
			isChanging = false;
		}
	}
}
