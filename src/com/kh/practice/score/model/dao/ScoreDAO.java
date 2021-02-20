package com.kh.practice.score.model.dao;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;



public class ScoreDAO {
	
	public void saveScore(String name, int kor, int eng, int math, int sum, double avg) {
		
        String path=ScoreDAO.class.getResource("/").getPath();		
		path=path.substring(0,path.lastIndexOf("bin"));
		
		File f=new File(path+"student.dat");
		
		try(DataOutputStream dos=new DataOutputStream(new FileOutputStream(f,true)) ){
			//StringBuffer sb=new StringBuffer();
			//sb.append(""+name+kor+eng+math+sum+avg);
			dos.writeUTF(name);
			
			dos.writeInt(kor);
			dos.writeInt(eng);
			dos.writeInt(math);
			dos.writeInt(sum);
			dos.writeDouble(avg);
	 //System.out.println(""+name+kor+eng+math+sum+avg);
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		
		
	}

	public DataInputStream readScore() throws FileNotFoundException {
		String path=ScoreDAO.class.getResource("/").getPath();		
		path=path.substring(0,path.lastIndexOf("bin"));
		File f=new File(path+"student.dat");
		//try(DataInputStream dis=new DataInputStream(new FileInputStream(f)) ){
			DataInputStream dis=new DataInputStream(new FileInputStream(f) );
//			String str="";
//			StringBuffer sb=new StringBuffer();
//			//int data=-1;
//			while(dis.readUTF()!=null) {
//				
//				//sb.append(data);
//				str=dis.readUTF();
				return dis;
			}
			
			//System.out.println(sb);
			
//		}catch(IOException e) {
//			//System.out.println(sb);
//			e.printStackTrace();
//			
//		}
		
	
	
	
}
