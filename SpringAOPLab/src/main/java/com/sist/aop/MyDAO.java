package com.sist.aop;
/*
 * #������ �ٽɱ�ɰ� �ΰ������ Ŭ������ ���� ������ ������
 * 	���⼭�� �۵��Ǵ� ������ �帧�� �ľ��ϱ� ����
 * 	���ǻ� DB�� ��������� �ʰ� �ϳ��� Ŭ������ �ۼ� 
 */
public class MyDAO {
	/*�ΰ�(advice) ��� ==> �α�, Ʈ�����*/
	public void getConnection(){
		System.out.println("����Ŭ ����");
	}
	
	/*�ΰ�(advice) ���*/
	public void disConnection(){
		System.out.println("����Ŭ ���� ����");
	}
	
	
	/*�ٽ� ����(Target)�ִ� �κ�*/
	public void ainsert(){
		/*�ΰ� ���
		getConnection();
		
		==> ������ �ٽ� ��ɿ� �������� �ʿ��� �ΰ� ����� 
			���������� ������� �ʰ� AOP�� �̿��Ͽ�
			����� �� �ֵ��� ����
		*/
		
		System.out.println("������ �߰�");
		
		/*�ΰ� ���
		disConnection();*/
	}
	
	/*�ٽ� ����(Target)�ִ� �κ�*/
	public void aselect(String sql){
		/*�ΰ� ���
		getConnection();*/
		
		System.out.println("SQL���� ����");
		
		/*�ΰ� ���
		disConnection();*/
	}
	
	/*�ٽ� ����(Target)�ִ� �κ�*/
	public void aupdate(){
		/*�ΰ� ���
		getConnection();*/
		
		System.out.println("������ ����");
		
		/*�ΰ� ���
		disConnection();*/
	}
	
	/*�ٽ� ����(Target)�ִ� �κ�*/
	public void adelete(){
		/*�ΰ� ���
		getConnection();*/
		
		System.out.println("������ ����");
		
		/*�ΰ� ���
		disConnection();*/
	}
}
