package chessBoard;

import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;

import whindow.ChineseChessMainFrame;

/**
 * ����������
 * @author ��ط��
 * ʱ�䣺20141113
 */
public class ChessPieces {
	public String name;
	/**
	 * 0���ڽ�
	 * 1���ڳ�
	 * 2������
	 * 3������
	 * 4����ʿ
	 * 5������
	 * 6������
	 * 7�����
	 * 8���쳵
	 * 9������
	 * 10������
	 * 11����ʿ
	 * 12����˧
	 * 13������
	 */
	public int id;
	public Image Icon;
	
	public ChessPieces(int Id){
		this.id = Id;
		String FileName = null;
		if (this.id == 0){
			this.name = new String("�ڽ�");
			FileName = new String("black-jiang");
		}
		else if (this.id == 1){
			this.name = new String("�ڳ�");
			FileName = new String("black-ju");
		}
		else if (this.id == 2){
			this.name = new String("����");
			FileName = new String("black-ma");
		}
		else if (this.id == 3){
			this.name = new String("����");
			FileName = new String("black-pao");
		}
		else if (this.id == 4){
			this.name = new String("��ʿ");
			FileName = new String("black-shi");
		}
		else if (this.id == 5){
			this.name = new String("����");
			FileName = new String("black-xiang");
		}
		else if (this.id == 6){
			this.name = new String("����");
			FileName = new String("black-zu");
		}
		else if (this.id == 7){
			this.name = new String("���");
			FileName = new String("red-bing");
		}
		else if (this.id == 8){
			this.name = new String("�쳵");
			FileName = new String("red-ju");
		}
		else if (this.id == 9){
			this.name = new String("����");
			FileName = new String("red-ma");
		}
		else if (this.id == 10){
			this.name = new String("����");
			FileName = new String("red-pao");
		}
		else if (this.id == 11){
			this.name = new String("��ʿ");
			FileName = new String("red-shi");
		}
		else if (this.id == 12){
			this.name = new String("��˧");
			FileName = new String("red-shuai");
		}
		else if (this.id == 13){
			this.name = new String("����");
			FileName = new String("red-xiang");
		}
		
		//����ImageIcon
		this.Icon = Toolkit.getDefaultToolkit().getImage(ChineseChessMainFrame.class.getResource("/imageLibary/" + FileName + ".png"));
	}
}
