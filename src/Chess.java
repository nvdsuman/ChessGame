import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
class Chess implements ActionListener
{
	static JButton[][] btn = new JButton[8][];
	static JFrame frm;
	static int x1, y1, x2, y2, click;
	static boolean turn = true;
	static String msg;
	static String[][] color = new String[8][];
	static String[][] name = new String[8][];
	static ImageIcon sainik_wh = new ImageIcon("ChessIcon/sainik_wh.png");
	static ImageIcon raja_wh = new ImageIcon("ChessIcon/raja_wh.png");
	static ImageIcon mantri_wh = new ImageIcon("ChessIcon/mantri_wh.png");
	static ImageIcon ghoda_wh = new ImageIcon("ChessIcon/ghoda_wh.png");
	static ImageIcon uant_wh = new ImageIcon("ChessIcon/uant_wh.png");
	static ImageIcon hathi_wh = new ImageIcon("ChessIcon/hathi_wh.png");
	static ImageIcon sainik_bl = new ImageIcon("ChessIcon/sainik_bl.png");
	static ImageIcon raja_bl = new ImageIcon("ChessIcon/raja_bl.png");
	static ImageIcon mantri_bl = new ImageIcon("ChessIcon/mantri_bl.png");
	static ImageIcon ghoda_bl = new ImageIcon("ChessIcon/ghoda_bl.png");
	static ImageIcon uant_bl = new ImageIcon("ChessIcon/uant_bl.png");
	static ImageIcon hathi_bl = new ImageIcon("ChessIcon/hathi_bl.png");
	static ImageIcon blank = new ImageIcon();
	static ImageIcon dot = new ImageIcon("ChessIcon/dot.png");
	public Chess()
	{
		for(int x = 0; x < 8; x++)
		{
			btn[x] = new JButton[8];
			color[x] = new String[8]; 
			name[x] = new String[8]; 
		}
		frm = new JFrame();
		frm.setLayout(new GridLayout(8,8));
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
			{
				btn[i][j] = new JButton();
				frm.add(btn[i][j]);
				color[i][j] = "bl";
				name[i][j] = "bl";
			}
		setColor();
		setName();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setSize(400, 500);
		frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frm.setVisible(true);
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				btn[i][j].addActionListener(this);
	}
	public static void setName()
	{
   		for(int i = 0; i < 8; i++)
		{
			color[1][i] = "white";
			name[1][i] = "SAINIK";
			btn[1][i].setIcon(sainik_wh);
			color[6][i] = "black";
			name[6][i] = "SAINIK";
			btn[6][i].setIcon(sainik_bl);
		}
		color[0][0] = "white";
		name[0][0] = "HATHI";
		btn[0][0].setIcon(hathi_wh);
		color[0][7] = "white";
		name[0][7] = "HATHI";
		btn[0][7].setIcon(hathi_wh);
		color[0][1] = "white";
		name[0][1] = "GHODA";
		btn[0][1].setIcon(ghoda_wh);
		color[0][6] = "white";
		name[0][6] = "GHODA";
		btn[0][6].setIcon(ghoda_wh);
		color[0][2] = "white";
		name[0][2] = "UANT";
		btn[0][2].setIcon(uant_wh);
		color[0][5] = "white";
		name[0][5] = "UANT";
		btn[0][5].setIcon(uant_wh);
		color[0][3] = "white";
		name[0][3] = "MANTRI";
		btn[0][3].setIcon(mantri_wh);
		color[0][4] = "white";
		name[0][4] = "RAJA";
		btn[0][4].setIcon(raja_wh);
		
		color[7][0] = "black";
		name[7][0] = "HATHI";
		btn[7][0].setIcon(hathi_bl);
		color[7][7] = "black";
		name[7][7] = "HATHI";
		btn[7][7].setIcon(hathi_bl);
		color[7][1] = "black";
		name[7][1] = "GHODA";
		btn[7][1].setIcon(ghoda_bl);
		color[7][6] = "black";
		name[7][6] = "GHODA";
		btn[7][6].setIcon(ghoda_bl);
		color[7][2] = "black";
		name[7][2] = "UANT";
		btn[7][2].setIcon(uant_bl);
		color[7][5] = "black";
		name[7][5] = "UANT";
		btn[7][5].setIcon(uant_bl);
		color[7][3] = "black";
		name[7][3] = "MANTRI";
		btn[7][3].setIcon(mantri_bl);
		color[7][4] = "black";
		name[7][4] = "RAJA";
		btn[7][4].setIcon(raja_bl);
		
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				if(name[i][j].length() < 2)
					name[i][j] = "bl";
		
	}
	public void setDirection(String msg){
		int x = x1, y = y1;
		if(msg.equals("SAINIK")){
			if(color[x][y].equals("black")){
				if(name[x-1][y].equals("bl"))
					btn[x-1][y].setIcon(dot);
			} else {
				if(name[x+1][y].equals("bl"))
					btn[x+1][y].setIcon(dot);
			}
		}
		if(msg.equals("GHODA")){
			if(x+2 < 8 && y+1 < 8 && name[x+2][y+1].equals("bl"))
				btn[x+2][y+1].setIcon(dot);
			if(x+2 < 8 && y-1 >= 0 && name[x+2][y-1].equals("bl"))
				btn[x+2][y-1].setIcon(dot);
			if(x-2 >= 0 && y+1 < 8 && name[x-2][y+1].equals("bl"))
				btn[x-2][y+1].setIcon(dot);
			if(x-2 >= 0 && y-1 >= 0 && name[x-2][y-1].equals("bl"))
				btn[x-2][y-1].setIcon(dot);
			if(x+1 < 8 && y+2 < 8 && name[x+1][y+2].equals("bl"))
				btn[x+1][y+2].setIcon(dot);
			if(x+1 < 8 && y-2 >= 0 && name[x+1][y-2].equals("bl"))
				btn[x+1][y-2].setIcon(dot);
			if(x-1 >= 0 && y+2 < 8 && name[x-1][y+2].equals("bl"))
				btn[x-1][y+2].setIcon(dot);
			if(x-1 >= 0 && y-2 >= 0 && name[x-1][y-2].equals("bl"))
				btn[x-1][y-2].setIcon(dot);
		}
		if(msg.equals("HATHI")){
			for(int i = x+1; i < 8; i++)
				if(name[i][y].equals("bl"))
					btn[i][y].setIcon(dot);
				else
					break;
					
			for(int i = x-1; i >= 0; i--)
				if(name[i][y].equals("bl"))
					btn[i][y].setIcon(dot);
				else
					break;
					
			for(int i = y+1; i < 8; i++)
				if(name[x][i].equals("bl"))
					btn[x][i].setIcon(dot);
				else
					break;
					
			for(int i = y-1; i >= 0; i--)
				if(name[x][i].equals("bl"))
					btn[x][i].setIcon(dot);
				else
					break;
		}
		if(msg.equals("UANT")){
			int i = x+1, j = y+1;
			while(i < 8 && j < 8){
				if(name[i][j].equals("bl"))
					btn[i][j].setIcon(dot);
				else
					break;
				i++;
				j++;
			}
			
			i = x+1; j = y-1;
			while(i < 8 && j >= 0){
				if(name[i][j].equals("bl"))
					btn[i][j].setIcon(dot);
				else
					break;
				i++;
				j--;
			}
			
			i = x-1; j = y+1;
			while(i >= 0 && j < 8){
				if(name[i][j].equals("bl"))
					btn[i][j].setIcon(dot);
				else
					break;
				i--;
				j++;
			}
			
			i = x-1; j = y-1;
			while(i >= 0 && j >= 0){
				if(name[i][j].equals("bl"))
					btn[i][j].setIcon(dot);
				else
					break;
				i--;
				j--;
			}
		}
		if(msg.equals("MANTRI")){
			for(int i = x+1; i < 8; i++)
				if(name[i][y].equals("bl"))
					btn[i][y].setIcon(dot);
				else
					break;
					
			for(int i = x-1; i >= 0; i--)
				if(name[i][y].equals("bl"))
					btn[i][y].setIcon(dot);
				else
					break;
					
			for(int i = y+1; i < 8; i++)
				if(name[x][i].equals("bl"))
					btn[x][i].setIcon(dot);
				else
					break;
					
			for(int i = y-1; i >= 0; i--)
				if(name[x][i].equals("bl"))
					btn[x][i].setIcon(dot);
				else
					break;
			
			int i = x+1, j = y+1;
			while(i < 8 && j < 8){
				if(name[i][j].equals("bl"))
					btn[i][j].setIcon(dot);
				else
					break;
				i++;
				j++;
			}
			
			i = x+1; j = y-1;
			while(i < 8 && j >= 0){
				if(name[i][j].equals("bl"))
					btn[i][j].setIcon(dot);
				else
					break;
				i++;
				j--;
			}
			
			i = x-1; j = y+1;
			while(i >= 0 && j < 8){
				if(name[i][j].equals("bl"))
					btn[i][j].setIcon(dot);
				else
					break;
				i--;
				j++;
			}
			
			i = x-1; j = y-1;
			while(i >= 0 && j >= 0){
				if(name[i][j].equals("bl"))
					btn[i][j].setIcon(dot);
				else
					break;
				i--;
				j--;
			}
		}
		if(msg.equals("RAJA")){
			if(x+1 < 8 && name[x+1][y].equals("bl"))
					btn[x+1][y].setIcon(dot);
					
			if(x-1 >= 0 && name[x-1][y].equals("bl"))
					btn[x-1][y].setIcon(dot);
					
			if(y+1 < 8 && name[x][y+1].equals("bl"))
					btn[x][y+1].setIcon(dot);
					
			if(y-1 >= 0 && name[x][y-1].equals("bl"))
					btn[x][y-1].setIcon(dot);
					
			if(x+1 < 8 && y+1 < 8 && name[x+1][y+1].equals("bl"))
					btn[x+1][y+1].setIcon(dot);
					
			if(x+1 < 8 && y-1 >= 0 && name[x+1][y-1].equals("bl"))
					btn[x+1][y-1].setIcon(dot);
					
			if(x-1 >= 0 && y+1 < 8 && name[x-1][y+1].equals("bl"))
					btn[x-1][y+1].setIcon(dot);
					
			if(x-1 >= 0 && y-1 >= 0 && name[x-1][y-1].equals("bl"))
					btn[x-1][y-1].setIcon(dot);
		}
	}
	public void actionPerformed(ActionEvent e)
	{
		click++;
		JButton jb = (JButton)e.getSource();
		getID(jb);
		String s;
		if(click == 1)
			s = name[x1][y1];
		else
			s = name[x2][y2];
		if(s.equals("bl") && click == 1)
		{
			//JOptionPane.showMessageDialog(frm, "Invalid Move.....");
			click = 0;
		}
		else
		{	
			if(click == 1){
				msg = s;
				boolean invalidMove = false;
				if(color[x1][y1].equals("black") && turn) {
					JOptionPane.showMessageDialog(frm, "It's white turn.....");
					click = 0;
					invalidMove = true;
				} else if(color[x1][y1].equals("white") && !turn){
					JOptionPane.showMessageDialog(frm, "It's black turn.....");
					click = 0;
					invalidMove = true;
				}
				if(!invalidMove)
					setDirection(msg);
					
			}
			if(click == 2)
			{
				removeDotIcon();
				boolean moved = false;
				if(msg.equals("SAINIK"))
				{
					moved = moveSainik();
					if(moved) {
						turn = !turn;
					}
				}
				else if(msg.equals("HATHI"))
				{
					moved = moveHathi();
					if(moved) {
						turn = !turn;
					}
				}
				else if(msg.equals("UANT"))
				{
					moved = moveUant();
					if(moved) {
						turn = !turn;
					}
				}
				else if(msg.equals("MANTRI"))
				{
					moved = moveMantri();
					if(moved) {
						turn = !turn;
					}
				}
				else if(msg.equals("GHODA"))
				{
					moved = moveGhoda();
					if(moved) {
						turn = !turn;
					}
				}
				else if(msg.equals("RAJA"))
				{
					moved = moveRaja();
					if(moved) {
						turn = !turn;
					}
				}
			}
		}
		if(click == 2)
			click = 0;
	}
	public static boolean moveRaja()
	{
		if((color[x1][y1].equals(color[x2][y2]) && !name[x2][y2].equals("bl")) || !(abs(x1-x2) <= 1 && abs(y1-y2) <= 1)) 
		{
			JOptionPane.showMessageDialog(frm, "Invalid Move.....");
			return false;
		}
		else
		{
			btn[x2][y2].setIcon(btn[x1][y1].getIcon());
			btn[x1][y1].setIcon(blank);
			name[x1][y1] = "bl";
			name[x2][y2] = "RAJA";
			color[x2][y2] = color[x1][y1];
			return true;
		}
	}
	public static boolean moveGhoda()
	{
		if((color[x1][y1].equals(color[x2][y2]) && !name[x2][y2].equals("bl")) || !(abs(x1-x2) == 2 && abs(y1-y2) == 1 || abs(x1-x2) == 1 && abs(y1-y2) == 2)) 
		{
			JOptionPane.showMessageDialog(frm, "Invalid Move.....");
			return false;
		}
		else
		{
			btn[x2][y2].setIcon(btn[x1][y1].getIcon());
			btn[x1][y1].setIcon(blank);
			name[x1][y1] = "bl";
			name[x2][y2] = "GHODA";
			color[x2][y2] = color[x1][y1];
			return true;
		}
	
	}
	public static boolean moveMantri()
	{
		if((color[x1][y1].equals(color[x2][y2]) && !name[x2][y2].equals("bl")) || (abs(x1-x2) != abs(y1-y2) && x1 != x2 && y1 != y2) || isNotEmpty()) 
		{
			JOptionPane.showMessageDialog(frm, "Invalid Move.....");
			return false;
		}
		else
		{
			
			btn[x2][y2].setIcon(btn[x1][y1].getIcon());
			btn[x1][y1].setIcon(blank);
			name[x1][y1] = "bl";
			name[x2][y2] = "MANTRI";
			color[x2][y2] = color[x1][y1];
			return true;
		}
	}
	public static boolean moveUant()
	{
		if((color[x1][y1].equals(color[x2][y2]) && !name[x2][y2].equals("bl")) || abs(x1-x2) != abs(y1-y2) || isNotEmpty()) 
		{
			JOptionPane.showMessageDialog(frm, "Invalid Move.....");
			return false;
		}
		else
		{
			btn[x2][y2].setIcon(btn[x1][y1].getIcon());
			btn[x1][y1].setIcon(blank);
			name[x1][y1] = "bl";
			name[x2][y2] = "UANT";
			color[x2][y2] = color[x1][y1];
			return true;
		}
	}
	public static boolean moveHathi()
	{
		if((color[x1][y1].equals(color[x2][y2]) && !name[x2][y2].equals("bl")) || (x1 != x2 && y1 != y2) || isNotEmpty()) 
		{
			JOptionPane.showMessageDialog(frm, "Invalid Move.....");
			return false;
		}
		else
		{
			btn[x2][y2].setIcon(btn[x1][y1].getIcon());
			btn[x1][y1].setIcon(blank);
			name[x1][y1] = "bl";
			name[x2][y2] = "HATHI";
			color[x2][y2] = color[x1][y1];
			return true;
		}
	}
	public static boolean moveSainik()
	{
		if(color[x1][y1].equals("white"))
		{
			if(x1 + 1 == x2 && y1 == y2 && name[x2][y2].equals("bl"))
			{
				name[x1][y1] = "bl";
				btn[x1][y1].setIcon(blank);
				btn[x2][y2].setIcon(sainik_wh);
				name[x2][y2] = "SAINIK";
				color[x2][y2] = "white";
				return true;
			}
			else if(x1 + 1 == x2 && (y1 + 1 == y2 || y1 - 1 == y2) && color[x2][y2].equals("black") && !name[x2][y2].equals("bl"))
			{
				name[x1][y1] = "bl";
				btn[x1][y1].setIcon(blank);
				btn[x2][y2].setIcon(sainik_wh);
				name[x2][y2] = "SAINIK";
				color[x2][y2] = "white";
				return true;
			}
			else 
			{
				JOptionPane.showMessageDialog(frm, "Invalid Move.....");
				return false;
			}
		}	
		else if(color[x1][y1].equals("black"))
		{
			if(x1 - 1 == x2 && y1 == y2 && name[x2][y2].equals("bl"))
			{
				name[x1][y1] = "bl";
				btn[x1][y1].setIcon(blank);
				btn[x2][y2].setIcon(sainik_bl);
				name[x2][y2] = "SAINIK";
				color[x2][y2] = "black";
				return true;
			}
			else if(x1 - 1 == x2 && (y1 + 1 == y2 || y1 - 1 == y2) && color[x2][y2].equals("white") && !name[x2][y2].equals("bl"))
			{
				name[x1][y1] = "bl";
				btn[x1][y1].setIcon(blank);
				btn[x2][y2].setIcon(sainik_bl);
				name[x2][y2] = "SAINIK";
				color[x2][y2] = "black";
				return true;
			}
			else
			{
				JOptionPane.showMessageDialog(frm, "Invalid Move.....");
				return false;
			}
		}
		return false;
	}
	public static int abs(int x)
	{
		if(x < 0)
			return x * -1;
		else
			return x;
	}
	public void removeDotIcon(){
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				if(btn[i][j].getIcon() == dot)
					btn[i][j].setIcon(blank);
	}
	public static boolean isNotEmpty()
	{
		if(msg.equals("HATHI"))
		{
			if(x1 == x2)
			{
				if(y1 > y2)
				{
					for(int i = y2+1; i < y1; i++)
					{
						if(!name[x1][i].equals("bl"))
							return true;
					}
					return false;
				}
				else
				{
					for(int i = y1+1; i < y2; i++)
					{
						if(!name[x1][i].equals("bl"))
							return true;
					}
					return false;
				}
			}
			else
			{
				if(x1 > x2)
				{
					for(int i = x2+1; i < x1; i++)
					{
						if(!name[i][y1].equals("bl"))
							return true;
					}
					return false;
				}
				else
				{
					for(int i = x1+1; i < x2; i++)
					{
						if(!name[i][y1].equals("bl"))
							return true;
					}
					return false;
				}
			}
		}
		else if(msg.equals("MANTRI"))
		{
			if(x1 == x2)
			{
				if(y1 > y2)
				{
					for(int i = y2+1; i < y1; i++)
					{
						if(!name[x1][i].equals("bl"))
							return true;
					}
					return false;
				}
				else
				{
					for(int i = y1+1; i < y2; i++)
					{
						if(!name[x1][i].equals("bl"))
							return true;
					}
					return false;
				}
			}
			else if(y1 == y2)
			{
				if(x1 > x2)
				{
					for(int i = x2+1; i < x1; i++)
					{
						if(!name[i][y1].equals("bl"))
							return true;
					}
					return false;
				}
				else
				{
					for(int i = x1+1; i < x2; i++)
					{
						if(!name[i][y1].equals("bl"))
							return true;
					}
					return false;
				}
			}
			else if( x1 - x2 > 0 && y1 - y2 > 0 )
			{
				int j = y1;
				for(int i = x1 - 1; i > x2; i--)
				{
					j--;
					if(!name[i][j].equals("bl"))
						return true;
				}
				return false;
			}
			else if( x1 - x2 > 0 && y1 - y2 < 0 )
			{
				int j = y1;
				for(int i = x1 - 1; i > x2; i--)
				{
					j++;
					if(!name[i][j].equals("bl"))
						return true;
				}
				return false;
			}
			else if( x1 - x2 < 0 && y1 - y2 > 0 )
			{
				int j = y1;
				for(int i = x1 + 1; i < x2; i++)
				{
					j--;
					if(!name[i][j].equals("bl"))
						return true;
				}
				return false;
			}
			else if( x1 - x2 < 0 && y1 - y2 < 0 )
			{
				int j = y1;
				for(int i = x1 + 1; i < x2; i++)
				{
					j++;
					if(!name[i][j].equals("bl"))
						return true;
				}
				return false;
			}
		}
		else if(msg.equals("UANT"))
		{
			if( x1 - x2 > 0 && y1 - y2 > 0 )
			{
				int j = y1;
				for(int i = x1 - 1; i > x2; i--)
				{
					j--;
					if(!name[i][j].equals("bl"))
						return true;
				}
				return false;
			}
			else if( x1 - x2 > 0 && y1 - y2 < 0 )
			{
				int j = y1;
				for(int i = x1 - 1; i > x2; i--)
				{
					j++;
					if(!name[i][j].equals("bl"))
						return true;
				}
				return false;
			}
			else if( x1 - x2 < 0 && y1 - y2 > 0 )
			{
				int j = y1;
				for(int i = x1 + 1; i < x2; i++)
				{
					j--;
					if(!name[i][j].equals("bl"))
						return true;
				}
				return false;
			}
			else if( x1 - x2 < 0 && y1 - y2 < 0 )
			{
				int j = y1;
				for(int i = x1 + 1; i < x2; i++)
				{
					j++;
					if(!name[i][j].equals("bl"))
						return true;
				}
				return false;
			}
		}
		return false;
	}
	
	public static void getID(JButton jb)
	{
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				if(btn[i][j] == jb)
				{	
					if(click == 1)
					{
						x1 = i;
						y1 = j;
					}
					else
					{
						x2 = i;
						y2 = j;
					}
				}
	}
	public static void setColor()
	{
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
				btn[i][j].setBackground(Color.WHITE);
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j+=2)
			{
				btn[i][j+i%2].setBackground(Color.BLACK);
			}
	}
	public static void main(String args[])
	{
		new Chess();
	}
}