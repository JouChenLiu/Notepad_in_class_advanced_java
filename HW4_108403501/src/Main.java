//�B�X�� 108403501 ��ޤTA
import javax.swing.*;
import java.awt.*;

public class Main {
	public static void main(String[] args) {
        Note n = new Note();
        n.setTitle("�O�ƥ�");
        n.setSize(600, 400);
		n.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;		//�̹��e��
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;	//��o�̹�����
		n.setLocation((width - 600) / 2, (height - 400) / 2);
		n.setVisible(true);
		n.setResizable(true);
	}
}