package whindow;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DiyButton extends JLabel {
	//2��ͼƬ����δѡ�к�ѡ��
	ImageIcon p0;
	ImageIcon p1;
	public DiyButton(String pic0,String pic1){
		//��2ͼƬ��ֵ
		p0 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(pic0));
		p1 = new ImageIcon(Toolkit.getDefaultToolkit().getImage(pic1));
		//��ʼͼƬΪΪѡ��ͼƬ
		this.setIcon(p0);
		//����������¼�
		this.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseEntered(MouseEvent arg0){
				//����ͼƬΪѡ��״̬
				((DiyButton)arg0.getSource()).setIcon(p1);
			}
			public void mouseExited(MouseEvent arg0){
				//����ͼƬΪδѡ��״̬
				((DiyButton)arg0.getSource()).setIcon(p0);
			}
		});
	}
}
