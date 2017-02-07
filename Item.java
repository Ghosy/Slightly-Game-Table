import java.io.File;
import java.io.IOException;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.ImageIcon;


public class Item {
	private final String itemPath = "items/";
	private final String imgPath = "images/";;

	private String name;
	private String owner;
	private boolean isPrivate;
	private ImageIcon pubImg;
	private ImageIcon privImg;
	private int x;
	private int y;

	public Item(String name, String owner) {
		try {
			List<String> lines = Files.readAllLines(Paths.get(itemPath + name));
			isPrivate = "private".equals(lines.get(0));
			pubImg = new ImageIcon(imgPath + lines.get(1));
			// If item config should have privImg
			if(isPrivate) {
				privImg = new ImageIcon(imgPath + lines.get(2));
			}
		} catch(IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

		this.name = name;
		this.owner = owner;
		this.x = 0;
		this.y = 0;
	}

	public Item(String name, String owner, int x, int y) {
		this(name, owner);
		this.x = x;
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public boolean getIsPrivate() {
		return isPrivate;
	}

	public ImageIcon getImg(String player) {
		// If item is private and owner/public asking
		if(isPrivate && (player.equals(owner) || player.equals("Public")))
			return privImg;
		return pubImg;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}
