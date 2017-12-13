package whindow;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Audio.MP3;
import chessBoard.ChessBoarder;

public class ChineseChessApp extends JFrame 
	implements ActionListener, MouseListener
	
{
	/**
	 * ��Ϸģʽ
	 * 1��˫�˶Ծ�
	 * 2���˻��Ծ�
	 * 3�����а�
	 * 4.����
	 * 5���˳���Ϸ
	 */
	private JLabel Menu1, Menu2, Menu3, Menu4, Menu5;
	
	public ChineseChessApp()
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(ChineseChessMainFrame.class.getResource("/imageLibary/black-jiang.png")));
		setTitle("�й�����");
		setBounds(0, 0, 1366, 768);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null); 
		addBackgroundImage("imageLibary\\background.png");
		
		JPanel contentPane = (JPanel)this.getContentPane();
		
		Menu1 = new JLabel("");
		Menu1.setOpaque(false);
		Menu2 = new JLabel("");
		Menu2.setOpaque(false);
		Menu3 = new JLabel("");
		Menu3.setOpaque(false);
		Menu4 = new JLabel("");
		Menu4.setOpaque(false);
		Menu5 = new JLabel("");
		Menu5.setOpaque(false);
		
		Menu1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\Menu1_0.png")));
		Menu1.addMouseListener(this);		
		Menu1.setBounds(460, 160,294,62);
		contentPane.add(Menu1);
		
		Menu2.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\Menu2_0.png")));
		Menu2.addMouseListener(this);		
		Menu2.setBounds(460, 260,294,62);
		contentPane.add(Menu2);
		
		Menu3.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\Menu3_0.png")));
		Menu3.addMouseListener(this);		
		Menu3.setBounds(460, 360,294,62);
		contentPane.add(Menu3);
		
		Menu4.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\Menu4_0.png")));
		Menu4.addMouseListener(this);		
		Menu4.setBounds(460, 460,294,62);
		contentPane.add(Menu4);
		
		Menu5.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\Menu5_0.png")));
		Menu5.addMouseListener(this);		
		Menu5.setBounds(460, 560,294,62);
		contentPane.add(Menu5);
	}
	
	public void addBackgroundImage(String s)
	{  
	    //ʵ����һ��ImageIconͼ����Ķ���  
	    ImageIcon image = new ImageIcon(s);  
	    //ʵ����һ����ǩ��Ķ���  
	    JLabel background = new JLabel(image);   
	    //���ñ�ǩ��ʾ��λ�úʹ�С  
	    background.setBounds(0,0,image.getIconWidth(),image.getIconHeight());  
	    //����ǩ��ӵ�����ĵڶ��������  
	    getLayeredPane().add(background,new Integer(Integer.MIN_VALUE));  
	    //��ȡ����ĵ�һ������  
	    JPanel contentPanel = (JPanel)this.getContentPane();  
	    //���õ�һ�����Ϊ͸��  
	    contentPanel.setOpaque(false);  
	     
	}		

	public void actionPerformed(ActionEvent evt)
	{
		
	}
	
    public void mouseClicked(MouseEvent evt) 
    {// �������ʱִ�еĲ���  
    	Object source = evt.getSource();
 	   	if(source == Menu1) {
	    	this.setVisible(false);
			ChineseChessMainFrame frame = new ChineseChessMainFrame();
			frame.setVisible(true);
			//MP3 BgMusic = new MP3(ChineseChessMainFrame.class.getResource("music\\bgm.mp3").getPath().substring(1));
			//BgMusic.play();    
 	   	}
 	   	if(source == Menu4) {
 	   		AboutDialog dialog = new AboutDialog(this);
 	   		dialog.setVisible(true);
 	   		dialog.setBounds(420,420,565,430);
 	   	}
 	   if(source == Menu5) {
 		   System.exit(0);
 	   }
 	   
 	   	
    }  
  
    public void mouseEntered(MouseEvent evt) 
    {// ���������ʱִ�еĲ���  
 	   	Object source = evt.getSource();
 	   	if(source == Menu1) {
 	   		Menu1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\Menu1_1.png")));
 	   	}
 	   	if(source == Menu2) {
 	   		Menu2.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\Menu2_1.png")));
 	   	}
 	   	if(source == Menu3) {
 	   		Menu3.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\Menu3_1.png")));
 	   	}
 	   	if(source == Menu4) {
 	   		Menu4.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\Menu4_1.png")));
 	   	}
 	   	if(source == Menu5) {
 	   		Menu5.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\Menu5_1.png")));
 	   	}
 	   	
 	 }  
  
    public void mouseExited(MouseEvent evt) 
    {// ����뿪���ʱִ�еĲ���  
 	   	Object source = evt.getSource();
 	   	if(source == Menu1) {
 	   		Menu1.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\Menu1_0.png")));
 	   	}
 	   	if(source == Menu2) {
 	   		Menu2.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\Menu2_0.png")));
 	   	}
 	   	if(source == Menu3) {
 	   		Menu3.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\Menu3_0.png")));
 	   	}
 	   	if(source == Menu4) {
 	   		Menu4.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\Menu4_0.png")));
 	   	}
 	   	if(source == Menu5) {
 	   		Menu5.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\Menu5_0.png")));
 	   	}

    }    
  
    public void mousePressed(MouseEvent evt) 
    {// ���������ϰ���ʱִ�еĲ���  
  
    }  
  
    public void mouseReleased(MouseEvent evt) 
    {// ����ͷ�ʱִ�еĲ���  
    }  	
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ChineseChessApp frame = new ChineseChessApp();
					frame.setVisible(true);
					MP3 BgMusic = new MP3(ChineseChessMainFrame.class.getResource("/music/bgm.mp3").getPath().substring(1));
					BgMusic.play();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


}

class AboutDialog extends JDialog
{  public AboutDialog(JFrame parent)
   {  super( parent, "����������Ա", true);


      JPanel b = new JPanel(new GridLayout(0,1));
      JLabel Inf = new JLabel("");
      Inf.setIcon(new ImageIcon(Toolkit.getDefaultToolkit().getImage("Image\\About.png")));
      b.add(Inf);
      getContentPane().add(b, "Center");

      JPanel p2 = new JPanel();
      JButton ok = new JButton("ȷ��");
      p2.add(ok);
      getContentPane().add(p2, "South");
      setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE );

      ok.addActionListener(new ActionListener()
         {  public void actionPerformed(ActionEvent evt)
            { setVisible(false); }
         } );

      setSize(565, 430);
      setLocationRelativeTo(null);
   }
}
