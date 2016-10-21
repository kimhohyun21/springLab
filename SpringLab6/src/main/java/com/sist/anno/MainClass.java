package com.sist.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.model.*;

public class MainClass {
	public static void main(String[] args) {
		ApplicationContext app=new ClassPathXmlApplicationContext("classpath:app2.xml"); // 그냥 app2.xml 도 가능
		BoardModel bm=(BoardModel) app.getBean("bm");
		bm.execute();
		
		MemberModel mm=(MemberModel) app.getBean("memberModel"); //component에 이름을 지정해놓은 경우는 클래스 이름으로 지정 불가능
		mm.execute();
	}
}
