package com.woniu.prolem.problem1;

import java.util.Arrays;

public class Problem1 {
	private String[] ss = null;
	public Problem1() {
		ss = new String[]{"woniu"};
	}
	public String[] getSs() {
//		return ss;//ʹ�����ַ�ʽ������ϣ���ڵõ�����woniu������,ȴ�õ��ķ�woniu����ʾ��Ϣ��
		return Arrays.copyOf(ss, ss.length);//����ʹ�����ַ�ʽ�����ǿ�����ȷ�õ���Ҫ������Ϣ����ˣ���Ҫ��˽�б�����й���������𲻱�Ҫ�ı�������²��ɿء�
	}
	public void setSs(String[] ss) {
		this.ss = ss;
	}
	
	public static void main(String[] args) {
		Problem1 problem1 = new Problem1();
		String[] testSS = problem1.getSs();
		testSS[0] = "I'm not woniu";
		
		System.out.println(problem1.getSs()[0]);
	}
	
}
