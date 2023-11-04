package chess;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
public class chess 

{
	
static	String a[][]=new String[8][8];
static	int b[][]=new int[8][8];

static int currentrow=0;
static int currentcolumn=0;

	public static void main(String args[])
	{
		

		for(int i=0;i<=7;i++) {
			
			for(int j=0;j<=7;j++) 
			{
				if(i==0||i==1||i==6||i==7)b[i][j]=1;
				else b[i][j]=0;
			}
			}
		
		for(int i=0;i<=7;i++) {
			
			for(int j=0;j<=7;j++) 
			{
				
				if((i==0&&j==1)||(i==7&&j==1)||(i==0&&j==6)||(i==7&&j==6)) 
				{
					a[i][j]="k";
				}
				if((i==0&&j==2)||(i==7&&j==2)||(i==0&&j==5)||(i==7&&j==5)) 
				{
					a[i][j]="c";
				}
				if((i==0&&j==0)||(i==7&&j==0)||(i==0&&j==7)||(i==7&&j==7)) 
				{
					a[i][j]="e";
				}
				if((i==0&&j==3)||(i==7&&j==3)) 
				{
					a[i][j]="k";
				}
				
				if((i==0&&j==4)||(i==7&&j==4)) 
				{
					a[i][j]="q";
				}
				
				if(i==1||i==6) 
				{
					a[i][j]="p";
				}
				
				
				if(a[i][j]==null) {
					a[i][j]="  ";}
			}
			
		}
		
		for(int i=0;i<=7;i++) {
			
			for(int j=0;j<=7;j++) {
				
				if(i==1||i==0) {
					a[i][j]="w"+a[i][j];
				}
				else if(i==6||i==7)
				{
					a[i][j]="b"+a[i][j];
					
				}
			}
		}
		
		int my=5;
		while(my>=0) {
             disply(a);
			Scanner s=new Scanner(System.in);
			System.out.println("Enter move");
			int cr=s.nextInt();
			int cc=s.nextInt();
			int dr=s.nextInt();
			int dc=s.nextInt();
			b[cr][cc]=0;
			b[dr][dc]=1;	
			a[cr][cc]="  ";
			a[dr][dc]="bp";
			
			
			

			HashMap<Integer,Integer> opmove=selectedpiece();
			System.out.print("select");
			ran1("wp", 1, 5, opmove);
			HashMap<Integer,Integer> h=moves("wp",currentrow,currentcolumn);		
			ran("wp", 1, 5, h);
			disply(a);
			my--;
			
		}
		
	
	}
	
	public static HashMap<Integer,Integer> selectedpiece()
	{
		HashMap<Integer,Integer> myh=new HashMap<Integer, Integer>();
		
		for(int i=0;i<=7;i++) {
			
			for(int j=0;j<=7;j++)
			{
				
				
				System.out.println(a[i][j]);
				if(a[i][j].equals("wp"))
				{
					
					System.out.println("ij"+i+"  "+j);
					myh.put(i,j);
					
				}
				
			}
		}
		
		return myh;
	}
	
	
	
	public static void ran1(String c,int row,int column,HashMap<Integer,Integer> h) 
	{
		
		
		System.out.println("r1");
		 Random r=new Random(); 
		 int key=r.nextInt(2);
		 
		 
		 
		 for(Map.Entry<Integer,Integer> m:h.entrySet()) {
			 
			 System.out.println("key__"+m.getKey());
		 }
		 System.out.println(key);
			 while(!h.containsKey(key)) 
				 
			 { key=r.nextInt(2);
			 
			  } 
			 int value= h.get(key);
			 
			
			 System.out.println("r"+currentrow+"   c"+currentcolumn);
			    currentrow=key;
	            currentcolumn=value;
			
	}
	
	
	public static void ran(String c,int row,int column,HashMap<Integer,Integer> h) 
	{
		
		 Random r=new Random(); 
		 int key=r.nextInt(8);
		 
		 
		 
			 while(!h.containsKey(key)) 
			 { key=r.nextInt(8);
			  
			  } 
			 int value= h.get(key);
			 
			
			b[row][column]=0;
			a[key][value]=c;
			a[row][column]="  ";

		
	}
	
	
	public  static void disply(String chess [][])
	{
		
		System.out.println("--------------------------");
		for(int i=0;i<=7;i++)
		{
			System.out.print("|");
			for(int j=0;j<=7;j++) 
			{
				System.out.print(chess[i][j]+" ");
			}
			System.out.println("|");
		}

		System.out.println("--------------------------");
	}
	
	public static HashMap<Integer,Integer> moves(String c,int row,int column)
	{
		HashMap<Integer,Integer> h=new HashMap<Integer, Integer>();
		
		if(c=="wp") 
		{
             row=row+1;
             
             if(b[row][column+1]==1)
             {
            	 h.put(row,column+1);
            	 row=row+1;
             }
			while(b[row][column]!=1)
			{
				h.put(row,column);
				row=row+1;
			}
		}
		
		return h;
	}
	
	
}
