package com.kh.practice.scor.view;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.util.Scanner;

import com.kh.practice.score.controller.ScoreController;


public class ScoreMenu {

	Scanner sc=new Scanner(System.in);
	
	private ScoreController scr=new ScoreController();
	
	  public void mainMenu() {
		int cho=0;
		  
	      
	       while(cho!=9) {
	    	   System.out.println("1.���� ����\n2.���� ���\n9.������ ");
	    	   System.out.print("�޴� ��ȣ:");
		       cho=sc.nextInt();
	    	   
		       switch (cho) {
		       case 1 : saveScore(); break;
		       case 2 : readScore(); break;
		       case 9 : System.out.println("���α׷��� �����մϴ�.");return;
		       default : System.out.println("�߸� �Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
		       
		       }
	    	   
	       }
		
		
	}
	
	public void saveScore() {
		
		int num=0; //�л� ���ڸ� ��Ÿ�� ����
		String cho="a";
		
		do {
			sc.nextLine();
			num++;
		 System.out.println(num+"�� ° �л� ���� ���");
		 System.out.print("�̸� :");
		 String name=sc.nextLine();
		 System.out.print("�������� :");
		 int kor=sc.nextInt();
		 System.out.print("�������� :");
		 int eng=sc.nextInt();
		 System.out.print("�������� :");
		 int math=sc.nextInt();
		 int sum=kor+eng+math;
		 double avg=(sum/3);
		
		 scr.saveScore(name,kor,eng,math,sum,avg);

		sc.nextLine();
		 System.out.print("�׸� �Է��Ͻ÷��� N�Ǵ� n�Է�, ����Ͻ÷��� �ƹ�Ű�� �Է��ϼ���:");
		 cho=sc.next();
		 
		} while(!cho.toUpperCase().equals("N")  ); 
		
		
	}
	
	public void readScore() {
		int count = 0; // �� ���� �л�����(�ݺ����� �� �� ����ƴ���) ���� ����
		int sumAll=0;
		double avgAll=0.0;// ��� �л����� �հ� ����� ���� ����
		//int data=-1;
		//DataInputStream dis=scr.readScore();
		
		try(DataInputStream dis=scr.readScore() ){
			while(true) {
				String name=dis.readUTF();
				int kor=dis.readInt();
				int eng=dis.readInt();
				int math=dis.readInt();
				int sum=dis.readInt();
				double avg=dis.readDouble();
				count++;
				sumAll+=sum;
				
			   System.out.println("�̸�\t����\t����\t����\t�հ�\t���");
			   System.out.println(""+name+"\t"+eng+"\t"+kor+"\t"+math+"\t"+sum+"\t"+avg);
		     }
		}catch(EOFException e) {
			System.out.println("���� Ƚ��\t��ü �հ�\t��ü ���");
			avgAll=(sumAll/count);
			System.out.println(count+"\t"+sumAll+"\t"+avgAll);
		}catch(IOException e) {
			
		}
	}
	
}
