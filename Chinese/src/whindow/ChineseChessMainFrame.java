package whindow;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import whindow.LabelEvent.ChessPieceClick;
import chessBoard.ChessBoarder;
import defultSet.DefultSet;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImageObserver;

public class ChineseChessMainFrame extends JFrame {

	private JPanel contentPane;
	private JPanel Pane1;
	private JPanel Pane2;
	private JPanel Pane3;
	private JPanel Pane4;
	
	static public InformationBoard InfBoard;
	
	/**
	 * ��Ϸģʽ
	 * 0��˫�˶Ծ�
	 * 1���˻��Ծ�
	 * 2��������ʾ
	 * 3���˳���Ϸ
	 */
	static public int MenuMode = 0;
	/**
	 * ִ�ӷ�
	 * ��:�췽
	 * ��:�ڷ�
	 * �ޣ��ޣ���������
	 */
	static public char DoPlayer = '��';
	//��������
	static public ChessBoarder MyBoarder;
	
	ChessBoarderCanvas MyCanvas;


	public ChineseChessMainFrame() {
		
		//���ݳ�ʼ��
		DataInit();
		
		//����ͼ��
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(ChineseChessMainFrame.class.getResource("/imageLibary/black-jiang.png")));
		//���ñ���
		this.setTitle("�й�����");
		//���ô��ڴ�С
		this.setBounds(0, 0, 1366, 768);
		//���ô��ڲ��ɸı��С
		this.setResizable(false);
		//����Ĭ�Ϲر�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ô��ھ���
		this.setLocationRelativeTo(null);
		
		//����ContentPane����
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//��ʹ�ò���
		contentPane.setLayout(null);
		//����ContentPaneΪ͸��
		contentPane.setOpaque(false);
		this.setContentPane(contentPane);
		
		//����ContentPane����Ϣ
		
		//��ӱ���ͼƬ
		JLabel BackGround = new JLabel("");
		BackGround.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage(ChineseChessMainFrame.class.getResource("/imageLibary/background.png"))));
		BackGround.setBounds(0, 0, 1366, 768);
		//��ӱ���ͼƬ�Ĺؼ����
		this.getLayeredPane().add(BackGround, new Integer(Integer.MIN_VALUE)); 

		
		//��ʼ��4��JPanel
		Pane1 = new JPanel();
		Pane2 = new JPanel();
		Pane3 = new JPanel();
		
		//����4��JPanel��λ�ú͹�ͬ����
		Pane1.setBounds(0, 0, 1366, 768);
		Pane1.setOpaque(false);
		Pane1.setVisible(true);
		Pane1.setLayout(null);
		Pane2.setBounds(0, 0, 1366, 768);
		Pane2.setOpaque(false);
		Pane2.setVisible(false);
		Pane2.setLayout(null);
		Pane3.setBounds(0, 0, 1366, 768);
		Pane3.setOpaque(false);
		Pane3.setVisible(false);
		Pane3.setLayout(null);

		
		//��4��Pane��ӽ�ContentPanel
		contentPane.add(Pane1);
		contentPane.add(Pane2);
		contentPane.add(Pane3);

		
		//��Pane1���Canvas����������
		MyCanvas = new ChessBoarderCanvas();
		//����Canvasλ�úʹ�С
		MyCanvas.setBounds(DefultSet.CanvasPosX, DefultSet.CanvasPosY, 661, 728);
		//ΪCanvas��������
		MyCanvas.SendData(this.MyBoarder, Toolkit.getDefaultToolkit().getImage(ChineseChessMainFrame.class.getResource("/imageLibary/background.png")), DefultSet.CanvasPosX, DefultSet.CanvasPosY, DefultSet.CanvasPosX+661, DefultSet.CanvasPosY+728);
		MyCanvas.repaint();
		MyCanvas.addMouseListener(new ChessPieceClick());
		Pane1.add(MyCanvas);
		
		//��Pane1�����Ϣ��
		InfBoard = new InformationBoard();
		InfBoard.setBounds(1011, 50, 394, 481);
		Pane1.add(InfBoard);
		
		InfBoard.AddLog("�췽ִ��");
		
		//������¿�ʼ��ť
		DiyButton AllReset = new DiyButton("Image\\ButtonAllReset(0).png","Image\\ButtonAllReset(1).png");
		AllReset.setBounds(780, 610, 326, 115);
		AllReset.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0){
				DataInit();
				InfBoard.Clear();
				InfBoard.AddLog("�췽ִ��");
				MyCanvas.SendWinner('��');
				MyCanvas.paintImmediately(0, 0, MyCanvas.getWidth(), MyCanvas.getHeight());
			}
		});
		Pane1.add(AllReset);
		
		//���ʱ���ǩ
		JLabel TimerLabel = new JLabel();
		TimerLabel.setBounds(1030, 570, 100, 50);
		TimerLabel.setFont(new Font("�����п�",Font.CENTER_BASELINE,28));
		Pane1.add(TimerLabel);
		TimerThread MyTimerThread = new TimerThread(TimerLabel);
		MyTimerThread.start();
		
		
		//������䰴ť
		DiyButton WantLose = new DiyButton("Image\\ButtonLose(0).png","Image\\ButtonLose(1).png");
		WantLose.setBounds(780, 360, 326, 115);
		WantLose.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0){
				if(DoPlayer == '��')MyCanvas.SendWinner('��');
				else MyCanvas.SendWinner('��');
			}
		});
		Pane1.add(WantLose);
		
		//���ƽ�ְ�ť
		DiyButton WantEqual = new DiyButton("Image\\ButtonEqual(0).png","Image\\ButtonEqual(1).png");
		WantEqual.setBounds(780, 230, 326, 115);
		WantEqual.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0){
				MyCanvas.SendWinner('��');
			}
		});
		Pane1.add(WantEqual);
		
		//��ӻ��尴ť
		DiyButton WantBack = new DiyButton("Image\\ButtonBack(0).png","Image\\ButtonBack(1).png");
		WantBack.setBounds(780, 100, 326, 115);
		WantBack.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent arg0){

			}
		});
		Pane1.add(WantBack);
		
	}
	
	/**�������ݳ�ʼ��
	 * @author ��ط��
	 * ʱ�䣺20141113
	 */
	public void DataInit(){
		MenuMode = 0;
		DoPlayer = '��';
		MyBoarder = new ChessBoarder();
	}

}
