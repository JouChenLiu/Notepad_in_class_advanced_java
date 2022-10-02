//劉柔辰 108403501 資管三A
import java.awt.*;	//使用BorderLayout必須載入awt套件
import java.awt.event.*;	//使用事件必須載入event套件
import javax.swing.*;	//載入swing套件
import javax.swing.text.DefaultStyledDocument;
import java.io.*;

public class Note extends JFrame implements ActionListener{
	private DB db;
	
	private final JToolBar toolBar;	//工具條
	private final JButton buttonNewBuild, buttonOpen, buttonSave, buttonExit, buttonCut, buttonCopy, buttonPaste, buttonAbout;
	//按鈕新建.打開.保存.退出.剪切.複製.貼上.關於
	
	private final JTextArea textArea;	//編輯區
	private final JLabel bottomLabel;	//底部標籤欄
	private final JFileChooser fileChooser;	//文件選擇器
	
	public Note() {
		db = new DB();
		
		//實例化工具條
		toolBar = new JToolBar();
		//實例化按鈕
		buttonNewBuild = new JButton("新建");
		buttonNewBuild.addActionListener(this);
		buttonNewBuild.setActionCommand("newBuild");
		buttonOpen = new JButton("打開");
		buttonOpen.addActionListener(this);
		buttonOpen.setActionCommand("open");
		buttonSave = new JButton("保存");
		buttonSave.addActionListener(this);
		buttonSave.setActionCommand("save");
		buttonExit = new JButton("退出");
		buttonExit.addActionListener(this);
		buttonExit.setActionCommand("exit");
		buttonCut = new JButton("剪切");
		buttonCut.addActionListener(this);
		buttonCut.setActionCommand("cut");
		buttonCopy = new JButton("複製");
		buttonCopy.addActionListener(this);
		buttonCopy.setActionCommand("copy");
		buttonPaste = new JButton("貼上");
		buttonPaste.addActionListener(this);
		buttonPaste.setActionCommand("paste");
		buttonAbout = new JButton("關於");
		buttonAbout.addActionListener(this);
		buttonAbout.setActionCommand("about");
		
		//工具條設置按鈕
		toolBar.add(buttonNewBuild);
		toolBar.add(buttonOpen);
		toolBar.add(buttonSave);
		toolBar.add(buttonExit);
		toolBar.add(buttonCut);
		toolBar.add(buttonCopy);
		toolBar.add(buttonPaste);
		toolBar.add(buttonAbout);
		
		//實例化編輯窗口
		textArea = new JTextArea();
		bottomLabel = new JLabel("108403501劉柔辰");
		
		//實例化文件選擇器
		fileChooser = new JFileChooser();
		
		//窗口容器中添加組件（使用邊界布局）
		Container container = getContentPane(); //得到容器
		container.add(toolBar, BorderLayout.NORTH); //增加工具欄
		container.add(textArea, BorderLayout.CENTER);	//增加編輯區
		container.add(bottomLabel, BorderLayout.SOUTH); //增加狀態欄
		
		textArea.setText(db.getRS());	//開啟時載入資料庫中的產品資料表
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("newBuild")) {
			textArea.setDocument(new DefaultStyledDocument());	//清空文檔
		}else if(e.getActionCommand().equals("open")) {
			int i = fileChooser.showOpenDialog(Note.this);	//顯示打開文件對話框
			if(i == JFileChooser.APPROVE_OPTION) {	//點擊對話框中打開選項
				File f = fileChooser.getSelectedFile();	//得到選擇的文件
				try {
					FileReader reader = new FileReader(f);	//得到文件輸入流
					textArea.read(reader, f);	//讀入文件到文本窗格
				} catch (Exception ex) {
					ex.printStackTrace();	//輸出出錯信息
				}
			}
		}else if(e.getActionCommand().equals("save")) {
			int i = fileChooser.showSaveDialog(Note.this);	//顯示保存文件對話框
			if(i == JFileChooser.APPROVE_OPTION) {	//點擊對話框中保存按鈕
				File f = fileChooser.getSelectedFile();	//得到選擇的文件
				try {
					FileOutputStream out = new FileOutputStream(f);	//得到文件輸出流
					out.write(textArea.getText().getBytes());	//寫出文件
				} catch(Exception ex) {
					ex.printStackTrace();	//輸出出錯訊息
				}
			}
		}else if(e.getActionCommand().equals("exit")) {
			System.exit(0);
		}else if(e.getActionCommand().equals("cut")) {
			textArea.cut();		//調出文本剪切方法
		}else if(e.getActionCommand().equals("copy")) {
			textArea.copy();	//調出複製方法
		}else if(e.getActionCommand().equals("paste")) {
			textArea.paste();	//調出貼上方法
		}else if(e.getActionCommand().equals("about")) {
			JOptionPane.showMessageDialog(Note.this, "簡單的文本編輯器展示");
		}
	}
}
