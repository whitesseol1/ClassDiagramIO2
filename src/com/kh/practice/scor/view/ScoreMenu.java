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
	    	   System.out.println("1.성적 저장\n2.성적 출력\n9.끝내기 ");
	    	   System.out.print("메뉴 번호:");
		       cho=sc.nextInt();
	    	   
		       switch (cho) {
		       case 1 : saveScore(); break;
		       case 2 : readScore(); break;
		       case 9 : System.out.println("프로그램을 종료합니다.");return;
		       default : System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
		       
		       }
	    	   
	       }
		
		
	}
	
	public void saveScore() {
		
		int num=0; //학생 숫자를 나타낼 변수
		String cho="a";
		
		do {
			sc.nextLine();
			num++;
		 System.out.println(num+"번 째 학생 정보 기록");
		 System.out.print("이름 :");
		 String name=sc.nextLine();
		 System.out.print("국어점수 :");
		 int kor=sc.nextInt();
		 System.out.print("영어점수 :");
		 int eng=sc.nextInt();
		 System.out.print("수학점수 :");
		 int math=sc.nextInt();
		 int sum=kor+eng+math;
		 double avg=(sum/3);
		
		 scr.saveScore(name,kor,eng,math,sum,avg);

		sc.nextLine();
		 System.out.print("그만 입력하시려면 N또는 n입력, 계속하시려면 아무키나 입력하세요:");
		 cho=sc.next();
		 
		} while(!cho.toUpperCase().equals("N")  ); 
		
		
	}
	
	public void readScore() {
		int count = 0; // 몇 명의 학생인지(반복문이 몇 번 실행됐는지) 담을 변수
		int sumAll=0;
		double avgAll=0.0;// 모든 학생들의 합과 평균을 담을 변수
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
				
			   System.out.println("이름\t국어\t영어\t수학\t합계\t평균");
			   System.out.println(""+name+"\t"+eng+"\t"+kor+"\t"+math+"\t"+sum+"\t"+avg);
		     }
		}catch(EOFException e) {
			System.out.println("읽은 횟수\t전체 합계\t전체 평균");
			avgAll=(sumAll/count);
			System.out.println(count+"\t"+sumAll+"\t"+avgAll);
		}catch(IOException e) {
			
		}
	}
	
}
