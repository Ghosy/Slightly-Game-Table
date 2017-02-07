import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;
import java.awt.Point;

class Movement extends MouseAdapter {
	private int xOffset;
	private int yOffset;

	@Override
	public void mousePressed(MouseEvent e) {
		// ignore RMB
		if (e.isMetaDown()) return;
		Component c = (Component)e.getSource();
		Point itemPos = c.getLocation();
		Point origin = c.getLocationOnScreen();
		xOffset = (int)e.getX() - (int)itemPos.getX();
		yOffset = (int)e.getY() - (int)itemPos.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// xOffset = 0;
		// yOffset = 0;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// ignore RMB
		if (e.isMetaDown()) return;
		Component c = (Component)e.getSource();
		Point current = c.getLocation();
		e.translatePoint(c.getX(), c.getY());

		c.setLocation((int)e.getX() - xOffset, (int)e.getY() - yOffset);

	}
}
