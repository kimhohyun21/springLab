package com.sist.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.model.*;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("classpath:app2.xml"); // �׳� app2.xml �� ����
		BoardModel bm=(BoardModel) app.getBean("bm");
		bm.execute();
		
		MemberModel mm=(MemberModel) app.getBean("memberModel"); //component�� �̸��� �����س��� ���� Ŭ���� �̸����� ���� �Ұ���
		mm.execute();
	}
}
