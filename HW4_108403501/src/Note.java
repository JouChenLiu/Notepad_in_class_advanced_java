//�B�X�� 108403501 ��ޤTA
import java.awt.*;	//�ϥ�BorderLayout�������Jawt�M��
import java.awt.event.*;	//�ϥΨƥ󥲶����Jevent�M��
import javax.swing.*;	//���Jswing�M��
import javax.swing.text.DefaultStyledDocument;
import java.io.*;

public class Note extends JFrame implements ActionListener{
	private DB db;
	
	private final JToolBar toolBar;	//�u���
	private final JButton buttonNewBuild, buttonOpen, buttonSave, buttonExit, buttonCut, buttonCopy, buttonPaste, buttonAbout;
	//���s�s��.���}.�O�s.�h�X.�Ť�.�ƻs.�K�W.����
	
	private final JTextArea textArea;	//�s���
	private final JLabel bottomLabel;	//����������
	private final JFileChooser fileChooser;	//����ܾ�
	
	public Note() {
		db = new DB();
		
		//��ҤƤu���
		toolBar = new JToolBar();
		//��Ҥƫ��s
		buttonNewBuild = new JButton("�s��");
		buttonNewBuild.addActionListener(this);
		buttonNewBuild.setActionCommand("newBuild");
		buttonOpen = new JButton("���}");
		buttonOpen.addActionListener(this);
		buttonOpen.setActionCommand("open");
		buttonSave = new JButton("�O�s");
		buttonSave.addActionListener(this);
		buttonSave.setActionCommand("save");
		buttonExit = new JButton("�h�X");
		buttonExit.addActionListener(this);
		buttonExit.setActionCommand("exit");
		buttonCut = new JButton("�Ť�");
		buttonCut.addActionListener(this);
		buttonCut.setActionCommand("cut");
		buttonCopy = new JButton("�ƻs");
		buttonCopy.addActionListener(this);
		buttonCopy.setActionCommand("copy");
		buttonPaste = new JButton("�K�W");
		buttonPaste.addActionListener(this);
		buttonPaste.setActionCommand("paste");
		buttonAbout = new JButton("����");
		buttonAbout.addActionListener(this);
		buttonAbout.setActionCommand("about");
		
		//�u����]�m���s
		toolBar.add(buttonNewBuild);
		toolBar.add(buttonOpen);
		toolBar.add(buttonSave);
		toolBar.add(buttonExit);
		toolBar.add(buttonCut);
		toolBar.add(buttonCopy);
		toolBar.add(buttonPaste);
		toolBar.add(buttonAbout);
		
		//��Ҥƽs�赡�f
		textArea = new JTextArea();
		bottomLabel = new JLabel("108403501�B�X��");
		
		//��ҤƤ���ܾ�
		fileChooser = new JFileChooser();
		
		//���f�e�����K�[�ե�]�ϥ���ɥ����^
		Container container = getContentPane(); //�o��e��
		container.add(toolBar, BorderLayout.NORTH); //�W�[�u����
		container.add(textArea, BorderLayout.CENTER);	//�W�[�s���
		container.add(bottomLabel, BorderLayout.SOUTH); //�W�[���A��
		
		textArea.setText(db.getRS());	//�}�Үɸ��J��Ʈw�������~��ƪ�
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("newBuild")) {
			textArea.setDocument(new DefaultStyledDocument());	//�M�Ť���
		}else if(e.getActionCommand().equals("open")) {
			int i = fileChooser.showOpenDialog(Note.this);	//��ܥ��}����ܮ�
			if(i == JFileChooser.APPROVE_OPTION) {	//�I����ܮؤ����}�ﶵ
				File f = fileChooser.getSelectedFile();	//�o���ܪ����
				try {
					FileReader reader = new FileReader(f);	//�o�����J�y
					textArea.read(reader, f);	//Ū�J����奻����
				} catch (Exception ex) {
					ex.printStackTrace();	//��X�X���H��
				}
			}
		}else if(e.getActionCommand().equals("save")) {
			int i = fileChooser.showSaveDialog(Note.this);	//��ܫO�s����ܮ�
			if(i == JFileChooser.APPROVE_OPTION) {	//�I����ܮؤ��O�s���s
				File f = fileChooser.getSelectedFile();	//�o���ܪ����
				try {
					FileOutputStream out = new FileOutputStream(f);	//�o�����X�y
					out.write(textArea.getText().getBytes());	//�g�X���
				} catch(Exception ex) {
					ex.printStackTrace();	//��X�X���T��
				}
			}
		}else if(e.getActionCommand().equals("exit")) {
			System.exit(0);
		}else if(e.getActionCommand().equals("cut")) {
			textArea.cut();		//�եX�奻�Ť���k
		}else if(e.getActionCommand().equals("copy")) {
			textArea.copy();	//�եX�ƻs��k
		}else if(e.getActionCommand().equals("paste")) {
			textArea.paste();	//�եX�K�W��k
		}else if(e.getActionCommand().equals("about")) {
			JOptionPane.showMessageDialog(Note.this, "²�檺�奻�s�边�i��");
		}
	}
}
