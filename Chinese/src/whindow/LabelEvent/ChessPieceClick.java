package whindow.LabelEvent;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Audio.MP3;
import defultSet.DefultSet;
import whindow.ChessBoarderCanvas;
import whindow.ChineseChessMainFrame;

/**
 * 
 * @author ��ΰ��
 *ʱ�䣺20141121
 */
public class ChessPieceClick extends MouseAdapter {
	@Override
	public void mouseClicked(MouseEvent arg0){
		MP3 DoPieceSound = new MP3(ChineseChessMainFrame.class.getResource("/music/dopiece.wav").getPath().substring(1),false);
		MP3 WinSound = new MP3(ChineseChessMainFrame.class.getResource("/music/win.wav").getPath().substring(1),false);
		int x,y;
		x = arg0.getX();
		y = arg0.getY();
		x = (x - DefultSet.ChessBoarderXX) / DefultSet.ChessBoarderPP;
		y = (y - DefultSet.ChessBoarderYY) / DefultSet.ChessBoarderPP;
		System.out.println(x + "," +  y);
		if (x < 0 || x > 8 || y < 0 || y > 9){
			//����������⣬���ε����Ч
			return;
		}
		else{
			if (ChineseChessMainFrame.MyBoarder.p1 == null){
			//��ѡ������
				System.out.println("��ѡ������");
				ChineseChessMainFrame.MyBoarder.p1 = new Point(x,y);
				//System.out.println(ChineseChessMainFrame.MyBoarder.p1);
			}
			else{
				//��ѡ������
				System.out.println("��ѡ������");
				if (ChineseChessMainFrame.MyBoarder.MyPieces[ChineseChessMainFrame.MyBoarder.p1.y][ChineseChessMainFrame.MyBoarder.p1.x] == null){
					//ѡ������Ϊ��
					System.out.println("ѡ������Ϊ��");
					ChineseChessMainFrame.MyBoarder.p1 = new Point(x,y);
				}
				else{
					//ѡ�����Ӳ�Ϊ��
					System.out.println("ѡ�����Ӳ�Ϊ��");
					if (ChineseChessMainFrame.MyBoarder.MyPieces[ChineseChessMainFrame.MyBoarder.p1.y][ChineseChessMainFrame.MyBoarder.p1.x].name.charAt(0) != ChineseChessMainFrame.DoPlayer){
						//ѡ�е��ǷǱ�������
						System.out.println("ѡ�е��ǷǱ�������");
						ChineseChessMainFrame.MyBoarder.p1 = new Point(x,y);
					}
					else{
						//ѡ�е��Ǳ�������
						System.out.println("ѡ�е��Ǳ�������");
						if (ChineseChessMainFrame.MyBoarder.MyPieces[y][x] == null){
							//�ڶ���ѡ��Ϊ��
							System.out.println("�ڶ���ѡ��Ϊ��");
							ChineseChessMainFrame.MyBoarder.p2 = new Point(x,y);
							if (ChineseChessMainFrame.MyBoarder.PieceMove(ChineseChessMainFrame.MyBoarder.p1, ChineseChessMainFrame.MyBoarder.p2) == true){
								//���ӿ����ƶ�
								DoPieceSound.play();
								System.out.println("���ӿ����ƶ�");
								char Winner = ChineseChessMainFrame.MyBoarder.Winner();
								if (Winner == '��'){
									WinSound.play();
									((ChessBoarderCanvas)arg0.getSource()).SendWinner('��');
									ChineseChessMainFrame.InfBoard.AddLog("�췽���ʤ��!");
								}
								else if (Winner == '��'){
									WinSound.play();
									((ChessBoarderCanvas)arg0.getSource()).SendWinner('��');
									ChineseChessMainFrame.InfBoard.AddLog("�ڷ����ʤ��!");
								}
								else{
									ChineseChessMainFrame.MyBoarder.p1 = null;
									ChineseChessMainFrame.MyBoarder.p2 = null;
									SwitchDoPlayer();
								}
								
							}
							else{
								//���Ӳ����ƶ�
								System.out.println("���Ӳ����ƶ�");
								ChineseChessMainFrame.MyBoarder.p1 = new Point(x,y);
								ChineseChessMainFrame.MyBoarder.p2 = null;
							}
						}
						else{
							//�ڶ���ѡ�зǿ�
							System.out.println("�ڶ���ѡ��Ϊ��");
							if (ChineseChessMainFrame.MyBoarder.MyPieces[y][x].name.charAt(0) == ChineseChessMainFrame.DoPlayer){
								//�ڶ���ѡ�еĻ��Ǳ�������
								System.out.println("�ڶ���ѡ�еĻ��Ǳ�������");
								ChineseChessMainFrame.MyBoarder.p1 = new Point(x,y);
							}
							else{
								//�ڶ���ѡ�е��ǵз�����
								System.out.println("�ڶ���ѡ�е��ǵз�����");
								ChineseChessMainFrame.MyBoarder.p2 = new Point(x,y);
								if (ChineseChessMainFrame.MyBoarder.PieceEat(ChineseChessMainFrame.MyBoarder.p1, ChineseChessMainFrame.MyBoarder.p2) == true){
									//���ӿ��Գ�
									DoPieceSound.play();
									System.out.println("���ӿ��Գ�");
									char Winner = ChineseChessMainFrame.MyBoarder.Winner();
									if (Winner == '��'){
										WinSound.play();
										((ChessBoarderCanvas)arg0.getSource()).SendWinner('��');
										ChineseChessMainFrame.InfBoard.AddLog("�췽���ʤ��!");
									}
									else if (Winner == '��'){
										WinSound.play();
										((ChessBoarderCanvas)arg0.getSource()).SendWinner('��');
										ChineseChessMainFrame.InfBoard.AddLog("�ڷ����ʤ��!");
									}
									else{
										ChineseChessMainFrame.MyBoarder.p1 = null;
										ChineseChessMainFrame.MyBoarder.p2 = null;
										SwitchDoPlayer();
									}
								}
								else{
									//���Ӳ��ܳ�
									System.out.println("���Ӳ��ܳ�");
									ChineseChessMainFrame.MyBoarder.p1 = new Point(x,y);
									ChineseChessMainFrame.MyBoarder.p2 = null;
								}
							}
						}
					}
				}
			}
		}
		((ChessBoarderCanvas)arg0.getSource()).repaint();
		((ChessBoarderCanvas)arg0.getSource()).paintImmediately(0, 0, ((ChessBoarderCanvas)arg0.getSource()).getWidth(), ((ChessBoarderCanvas)arg0.getSource()).getHeight());
		System.out.println("repaint done");
	}
	
	/**
	 * ��������ִ�з�
	 * @author ��ΰ��
	 * ʱ�䣺20141121
	 */
	static public void SwitchDoPlayer(){
		if (ChineseChessMainFrame.DoPlayer == '��'){
			ChineseChessMainFrame.DoPlayer = '��';
			ChineseChessMainFrame.InfBoard.AddLog("�ڷ�ִ��");
			System.out.println("�ֵ��ڷ�");
		}
		else if (ChineseChessMainFrame.DoPlayer == '��'){
			ChineseChessMainFrame.DoPlayer = '��';
			ChineseChessMainFrame.InfBoard.AddLog("�췽ִ��");
			System.out.println("�ֵ��췽");
		}
		else{
			//ʲô������
		}
	}
}
