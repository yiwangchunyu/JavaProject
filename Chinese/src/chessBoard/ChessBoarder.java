package chessBoard;

import java.awt.Point;

import whindow.ChineseChessMainFrame;

public class ChessBoarder {
	/*
	 * 9��10�е���������
	 * null��ʾ��ǰλ������û������
	 */
	public ChessPieces[][] MyPieces;
	
	//2�����������ʾ�����߶�·��,null��ʾ����ʾ
	public Point p1;
	public Point p2;
	String [][] StrPos = {{"1","2","3","4","5","6","7","8","9"},
			{"��","��","��","��","��","��","��","��","һ"}};
	
	/**
	 * ��ʼ������
	 * @author ��ط��
	 * ʱ�䣺20141113
	 */
	public ChessBoarder(){
		//��2����ĳ�ֵ
		p1 = null;
		p2 = null;
		//������������г�ʼ��
		MyPieces = new ChessPieces[10][9];
		for (int i = 0;i < 10;i ++){
			for (int j = 0;j < 9;j ++){
				MyPieces[i][j] = null;
			}
		}
		//����Ĭ������λ��
		//���úڳ�
		MyPieces[0][0] = new ChessPieces(1);
		//���ú���
		MyPieces[0][1] = new ChessPieces(2);
		//���ú���
		MyPieces[0][2] = new ChessPieces(5);
		//���ú�ʿ
		MyPieces[0][3] = new ChessPieces(4);
		//���úڽ�
		MyPieces[0][4] = new ChessPieces(0);
		//���ú�ʿ
		MyPieces[0][5] = new ChessPieces(4);
		//���ú���
		MyPieces[0][6] = new ChessPieces(5);
		//���ú���
		MyPieces[0][7] = new ChessPieces(2);
		//���úڳ�
		MyPieces[0][8] = new ChessPieces(1);
		//���ú���
		for (int i = 0;i < 9;i += 2){
			MyPieces[3][i] = new ChessPieces(6);
		}
		//���ú���
		MyPieces[2][1] = new ChessPieces(3);
		MyPieces[2][7] = new ChessPieces(3);
		
		//���ú쳵
		MyPieces[9][0] = new ChessPieces(8);
		//���ú���
		MyPieces[9][1] = new ChessPieces(9);
		//���ú���
		MyPieces[9][2] = new ChessPieces(13);
		//���ú�ʿ
		MyPieces[9][3] = new ChessPieces(11);
		//���ú�˧
		MyPieces[9][4] = new ChessPieces(12);
		//���ú�ʿ
		MyPieces[9][5] = new ChessPieces(11);
		//���ú���
		MyPieces[9][6] = new ChessPieces(13);
		//���ú���
		MyPieces[9][7] = new ChessPieces(9);
		//���ú쳵
		MyPieces[9][8] = new ChessPieces(8);
		//���ú��
		for (int i = 0;i < 9;i += 2){
			MyPieces[6][i] = new ChessPieces(7);
		}
		//���ú���
		MyPieces[7][1] = new ChessPieces(10);
		MyPieces[7][7] = new ChessPieces(10);
		
	}
	/**
	 * �����ƶ�
	 * @param src ԭλ��
	 * @param des Ŀ��λ��
	 * @return �ƶ��ɹ�����true�����򷵻�false
	 * @author ��ط��
	 * ʱ�䣺20141118
	 */
	public boolean PieceMove(Point src,Point des){
		//test
		/*
		MyPieces[des.y][des.x] = MyPieces[src.y][src.x];
		MyPieces[src.y][src.x] = null;
		*/
		
		if (MyPieces[src.y][src.x] == null){
			//Դλ��û�����ӣ��ƶ�ʧ��
			return false;
		}
		else{
			//������
			switch(MyPieces[src.y][src.x].name.charAt(1)){
			case '��':
				//�ж��Ƿ��ھŹ���
				if (des.x >= 3 && des.x <= 5 && des.y >= 0 && des.y <= 2){
					if (Distance(src,des) == 1){
						//���߲���Ϊ1��
						//���������Ϣ
						if (src.y == des.y){
							ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[0][src.x] + "ƽ" + StrPos[0][des.x]);
						}
						else{
							ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[0][src.x] + (des.y > src.y ? "��" : "��") + 1) ;
						}
						MyPieces[des.y][des.x] = MyPieces[src.y][src.x];
						MyPieces[src.y][src.x] = null; 
						
						return true;
					}
					else{
						return false;
					}
				}
				else{
					return false;
				}
			case '˧':
				//�ж��Ƿ��ھŹ���
				if (des.x >= 3 && des.x <= 5 && des.y >= 7 && des.y <= 9){
					if (Distance(src,des) == 1){
						//���߲���Ϊ1��
						//���������Ϣ
						if (src.y == des.y){
							ChineseChessMainFrame.InfBoard.AddLog("˧" + StrPos[1][src.x] + "ƽ" + StrPos[1][des.x]);
						}
						else{
							ChineseChessMainFrame.InfBoard.AddLog("˧" + StrPos[1][src.x] + (des.y < src.y ? "��" : "��") + 1) ;
						}
						MyPieces[des.y][des.x] = MyPieces[src.y][src.x];
						MyPieces[src.y][src.x] = null; 
						return true;
					}
					else{
						return false;
					}
				}
				else{
					return false;
				}
			case 'ʿ':
				//�ж��Ƿ��Ǻ췽
				if (MyPieces[src.y][src.x].name.charAt(0) == '��'){
					//�ж��Ƿ��ھŹ���
					if (des.x >= 3 && des.x <= 5 && des.y >= 7 && des.y <= 9){
						//�ж��Ƿ���б����
						if (Distance(src,des) > 1.4 && Distance(src,des) < 1.5){
							//���������Ϣ
							ChineseChessMainFrame.InfBoard.AddLog("ʿ" + StrPos[1][src.x] + (des.y < src.y ? "��" : "��") +StrPos[1][des.x] ) ;
							MyPieces[des.y][des.x] = MyPieces[src.y][src.x];
							MyPieces[src.y][src.x] = null; 
							return true;
						}
						else{
							return false;
						}
					}
					else{
						return false;
					}
				}
				else{
					//�ж��Ƿ��ھŹ���
					if (des.x >= 3 && des.x <= 5 && des.y >= 0 && des.y <= 2){
						//�ж��Ƿ���б����
						if (Distance(src,des) > 1.4 && Distance(src,des) < 1.5){
							//���������Ϣ
							ChineseChessMainFrame.InfBoard.AddLog("ʿ" + StrPos[1][src.x] + (des.y > src.y ? "��" : "��") +StrPos[1][des.x] ) ;
							MyPieces[des.y][des.x] = MyPieces[src.y][src.x];
							MyPieces[src.y][src.x] = null; 
							return true;
						}
						else{
							return false;
						}
					}
				}
			case '��':
				//�ж��Ƿ�û����
				if (des.y <= 4 ){
					//�ж��Ƿ�б��2��
					if (Distance(src,des) > 2.8 && Distance(src,des) < 2.9){
						//�Ƿ�δѹ���
						if (MyPieces[(des.y + src.y)/2][(des.x + src.x)/2] == null){
							//���������Ϣ
							ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[0][src.x] + (des.y > src.y ? "��" : "��") +StrPos[0][des.x] ) ;
							MyPieces[des.y][des.x] = MyPieces[src.y][src.x];
							MyPieces[src.y][src.x] = null; 
							return true;
						}
						else{
							return false;
						}
					}
					else{
						return false;
					}
				}
				else{
					return false;
				}
			case '��':
				//�ж��Ƿ�û����
				if (des.y >= 5 ){
					//�ж��Ƿ�б��2��
					if (Distance(src,des) > 2.8 && Distance(src,des) < 2.9){
						//�Ƿ�δѹ���
						if (MyPieces[(des.y + src.y)/2][(des.x + src.x)/2] == null){
							//���������Ϣ
							ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[1][src.x] + (des.y < src.y ? "��" : "��") +StrPos[1][des.x] ) ;
							MyPieces[des.y][des.x] = MyPieces[src.y][src.x];
							MyPieces[src.y][src.x] = null; 
							return true;
						}
					}
					else{
						return false;
					}
				}
				else{
					return false;
				}
			case '��':
				//�ж��Ƿ���2����5��
				if (Distance(src,des) > 2.2 && Distance(src,des) < 2.3){
					//�ж��Ƿ�ѹ���
					if (Math.abs(src.x - des.x) == 1){
						if (MyPieces[(src.y+des.y)/2][src.x] == null){
							if (MyPieces[src.y][src.x].name.charAt(0) == '��' ){
								//���������Ϣ
								ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[0][src.x] + (des.y > src.y ? "��" : "��") +StrPos[0][des.x] ) ;
							}
							else{
								//���������Ϣ
								ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[1][src.x] + (des.y < src.y ? "��" : "��") +StrPos[1][des.x] ) ;
							}
							MyPieces[des.y][des.x] = MyPieces[src.y][src.x];
							MyPieces[src.y][src.x] = null; 
							return true;
						}
						else{
							return false;
						}
					}
					else{
						if (MyPieces[src.y][(src.x+des.x)/2] == null){
							if (MyPieces[src.y][src.x].name.charAt(0) == '��' ){
								//���������Ϣ
								ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[0][src.x] + (des.y > src.y ? "��" : "��") +StrPos[0][des.x] ) ;
							}
							else{
								//���������Ϣ
								ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[1][src.x] + (des.y < src.y ? "��" : "��") +StrPos[1][des.x] ) ;
							}
							MyPieces[des.y][des.x] = MyPieces[src.y][src.x];
							MyPieces[src.y][src.x] = null; 
							return true;
						}
						else{
							return false;
						}
					}
				}
				else{
					return false;
				}
			case '��':
				if (src.y == des.y || src.x == des.x){
					//ֱ����û�����ӵ�ס
					if (IsBlock(src,des) == 0){
						if (MyPieces[src.y][src.x].name.charAt(0) == '��' ){
							if (src.y == des.y){
								ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[1][src.x] + "ƽ" + StrPos[1][des.x]);
							}
							else{
								ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[1][src.x] + (des.y < src.y ? "��" : "��") + Math.abs(des.y - src.y)) ;
							}
						}
						else{
							if (src.y == des.y){
								ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[0][src.x] + "ƽ" + StrPos[0][des.x]);
							}
							else{
								ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[0][src.x] + (des.y > src.y ? "��" : "��") + Math.abs(des.y - src.y)) ;
							}
						}
						
						MyPieces[des.y][des.x] = MyPieces[src.y][src.x];
						MyPieces[src.y][src.x] = null; 
						return true;
					}
					else{
						return false;
					}
				}
				else{
					return false;
				}
			case '��':
				if (src.y == des.y || src.x == des.x){
					//ֱ����û�����ӵ�ס
					if (IsBlock(src,des) == 0){
						if (MyPieces[src.y][src.x].name.charAt(0) == '��' ){
							if (src.y == des.y){
								ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[1][src.x] + "ƽ" + StrPos[1][des.x]);
							}
							else{
								ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[1][src.x] + (des.y < src.y ? "��" : "��") + Math.abs(des.y - src.y)) ;
							}
						}
						else{
							if (src.y == des.y){
								ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[0][src.x] + "ƽ" + StrPos[0][des.x]);
							}
							else{
								ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[0][src.x] + (des.y > src.y ? "��" : "��") + Math.abs(des.y - src.y)) ;
							}
						}
						MyPieces[des.y][des.x] = MyPieces[src.y][src.x];
						MyPieces[src.y][src.x] = null; 
						return true;
					}
					else{
						return false;
					}
				}
				else{
					return false;
				}
			case '��':
				//����ֱǰ
				if (des.y >= src.y){
					//����
					if (des.y >= 5){
						if (Distance(src,des) == 1){
							if (src.y == des.y){
								ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[0][src.x] + "ƽ" + StrPos[0][des.x]);
							}
							else{
								ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[0][src.x] +"��" + 1) ;
							}
							MyPieces[des.y][des.x] = MyPieces[src.y][src.x];
							MyPieces[src.y][src.x] = null; 
							return true;
						}
						else{
							return false;
						}
					}
					else{
						if (des.x == src.x && Math.abs(des.y - src.y) == 1){
							ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[0][src.x] + "��" + 1) ;
							MyPieces[des.y][des.x] = MyPieces[src.y][src.x];
							MyPieces[src.y][src.x] = null; 
							return true;
						}
						else{
							return false;
						}
					}
				}
				else{
					return false;
				}
			case '��':
				//����ֱǰ
				if (des.y <= src.y){
					//����
					if (des.y <= 4){
						if (Distance(src,des) == 1){
							if (src.y == des.y){
								ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[1][src.x] + "ƽ" + StrPos[1][des.x]);
							}
							else{
								ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[1][src.x] +"��" + 1) ;
							}
							MyPieces[des.y][des.x] = MyPieces[src.y][src.x];
							MyPieces[src.y][src.x] = null; 
							return true;
						}
						else{
							return false;
						}
					}
					else{
						if (des.x == src.x && Math.abs(des.y - src.y) == 1){
							ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[1][src.x] + "��" + 1) ;
							MyPieces[des.y][des.x] = MyPieces[src.y][src.x];
							MyPieces[src.y][src.x] = null; 
							return true;
						}
						else{
							return false;
						}
					}
				}
				else{
					return false;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * ���ӳ���
	 * @param src ԭλ��
	 * @param des Ŀ��λ��
	 * @return �ƶ��ɹ�����true�����򷵻�false
	 * @author ��ط��
	 * ʱ�䣺20141118
	 */
	public boolean PieceEat(Point src,Point des){
		if (MyPieces[src.y][src.x] == null){
			//Դλ��û�����ӣ�����ʧ��
			return false;
		}
		else{
			//������
			switch(MyPieces[src.y][src.x].name.charAt(1)){
			//�����⴦��
			case '��':
				if (src.y == des.y || src.x == des.x){
					//ֱ����ֻ��һ�����ӵ�ס
					if (IsBlock(src,des) == 1){
						if (MyPieces[src.y][src.x].name.charAt(0) == '��' ){
							if (src.y == des.y){
								ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[1][src.x] + "ƽ" + StrPos[1][des.x]);
							}
							else{
								ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[1][src.x] + (des.y < src.y ? "��" : "��") + Math.abs(des.y - src.y)) ;
							}
						}
						else{
							if (src.y == des.y){
								ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[0][src.x] + "ƽ" + StrPos[0][des.x]);
							}
							else{
								ChineseChessMainFrame.InfBoard.AddLog("��" + StrPos[0][src.x] + (des.y > src.y ? "��" : "��") + Math.abs(des.y - src.y)) ;
							}
						}
						MyPieces[des.y][des.x] = MyPieces[src.y][src.x];
						MyPieces[src.y][src.x] = null; 
						return true;
					}
					else{
						return false;
					}
				}
				else{
					return false;
				}
			default:
				 return PieceMove(src,des);
			}
		}
		//MyPieces[des.y][des.x] = MyPieces[src.y][src.x];
		//MyPieces[src.y][src.x] = null;
	}
	
	/**
	 * 
	 * @param a��a
	 * @param b��b
	 * @return ab�����
	 * @author ��ط��
	 */
	public float Distance(Point a,Point b){
		System.out.println((float)Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y)));
		return (float)Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
	}
	
	/**
	 * 
	 * @param a��a
	 * @param b��b
	 * @return ab����˶�������
	 * @author ��ط��
	 */
	public int IsBlock(Point a,Point b){
		int n = 0;
		if (a.x == b.x){
			int min,max;
			if (a.y > b.y){
				min = b.y;
				max = a.y;
			}
			else{
				min = a.y;
				max = b.y;
			}
			for (int i = min + 1;i < max;i ++){
				if (MyPieces[i][a.x] != null){
					n ++;
				}
			}
		}
		else{
			int min,max;
			if (a.x > b.x){
				min = b.x;
				max = a.x;
			}
			else{
				min = a.x;
				max = b.x;
			}
			for (int i = min + 1;i < max;i ++){
				if (MyPieces[a.y][i] != null){
					n ++;
				}
			}
		}
		return n;
	}
	/**
	 * �õ�ʤ����
	 * @return ʤ�������죬�ڣ���
	 * @author ��ط��
	 */
	public char Winner(){
		//�жϽ��Ƿ����
		Point pp1 = null;
		boolean ExJ = false;
		for (int i = 0;i <= 8;i ++){
			for (int j = 0;j <=9;j ++){
				if (MyPieces[j][i] != null){
					if (MyPieces[j][i].name.charAt(1) == '��'){
						pp1 = new Point(i,j);
						ExJ = true;
					}
				}
			}
		}
		if (!ExJ){
			ChineseChessMainFrame.DoPlayer = '��';
			return '��';
		}
		//�ж�˧�Ƿ����
		Point pp2 = null;
		boolean ExS = false;
		for (int i = 0;i <= 8;i ++){
			for (int j = 0;j <=9;j ++){
				if (MyPieces[j][i] != null){
					if (MyPieces[j][i].name.charAt(1) == '˧'){
						pp2 = new Point(i,j);
						ExS = true;
					}
				}
			}
		}
		if (!ExS){
			ChineseChessMainFrame.DoPlayer = '��';
			return '��';
		}
		//������
		//�ж��Ƿ�Խ�
		if (pp1.x == pp2.x && IsBlock(pp1,pp2) == 0){
			char TempC;
			TempC = ChineseChessMainFrame.DoPlayer;
			if (TempC == '��'){
				TempC = '��';
			}
			else if (TempC == '��'){
				TempC = '��';
			}
			ChineseChessMainFrame.DoPlayer = '��';
			System.out.println(TempC);
			return TempC;
		}
		
		return '��';
	}
}
