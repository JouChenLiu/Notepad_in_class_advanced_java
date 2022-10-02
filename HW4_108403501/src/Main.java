//劉柔辰 108403501 資管三A
import javax.swing.*;
import java.awt.*;

public class Main {
	public static void main(String[] args) {
        Note n = new Note();
        n.setTitle("記事本");
        n.setSize(600, 400);
		n.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;		//屏幕寬度
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;	//獲得屏幕高度
		n.setLocation((width - 600) / 2, (height - 400) / 2);
		n.setVisible(true);
		n.setResizable(true);
	}
}