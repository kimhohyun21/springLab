package com.sist.dao;

import java.util.Date;

/*
 * #Bean ��� ��Ÿ���� ���� ����
 * 	1. XML �ܵ� ���
 * 		1) ��� Bean�� ��������� XML�� ����ϴ� ���
 * 		2) ���� 
 * 			- �����Ǵ� ��� Bean�� XML���� Ȯ���� �� ����
 * 		3) ���� 
 * 			- Bean�� ������ �������� XML ���� ������ ���ŷο�
 * 			- �����ڰ��� ���������� ������ ��� ==> �浹 �߻�
 * 			- DI�� �ʿ��ϰ� ������ Setter �޼��� �Ǵ� Constructor�� �ڵ� ���� �ݵ�� �����ؾ���
 * 				==> ����, ���� �߿��� ������̼� ���� ��� ���
 * 					             � �߿��� ���� ���Ǽ� ���鿡�� XML ���� ���� 
 * 
 * 	2. XML�� �� ��ĳ��(Bean Scanning)�� ȥ��
 * 		1) Bean���� ���� Ŭ������ Ư���� ������̼�(annotation)�� �ο����ָ�
 * 		      �ش� Ŭ������ �ڵ����� ã�Ƽ� Bean���� �����
 * 			==> �� ��ĳ���� ���� �ڵ��ν� Bean ��� ���
 * 		2) ���� 
 * 			- ���� �ӵ� ���
 * 		3) ���� 
 * 			- ��ϵ� Bean���� ���� ���� �Ѵ��� �ľ��ϱ� �����
 * 
 * #Bean ��� �� ���� ���� ���� annotation
 * 	1. @Component
 * 		: ������Ʈ�� ��Ÿ���� �Ϲ����� ���׷��� Ÿ������ <bean> �±׿� ������ ������̼�
 * 	2. @Repository
 * 		: �۽ý��Ͻ� (persistance) ���̾�, ���Ӽ��� ������ �Ӽ�(����, DB)�� ������ ������̼�
 * 	3. @Service
 * 		: ���� ���̾�, �����Ͻ� ������ ���� Ŭ����
 * 	4. @Controller
 * 		: ���������̼� ���̾�, �����ø����̼ǿ� �� ��û�� ������ ó���ϴ� Ŭ����
 * 	5. @Autowired, @Resource
 * 		: ���� ��ü�� �ڵ����� ������ �ִ� ������̼� 
 * 		1) @Autowired
 * 			- ���� ���� ����(DI)�� �ʿ��� ��쿡 ��ȿ��
 * 			- ������Ƽ, Setter�޼���, ������, �Ϲݸ޼��忡 ��� ���� ����
 * 			- ���� ���� ��ü�� ������ �� �ַ� Type���� �̿��ϰ� ��
 * 			- <property>, <constructor-arg> �±׿� ������ ����
 * 		2) @Resource
 * 			- @Resource�� �̸�(name)���� ������
 * 			- ���ø����̼ǿ��� �ʿ�� �ϴ� �ڿ��� �ڵ����� ������ �� �����
 * 			- ������Ƽ, Setter �޼��忡 ���� ����
 * 	6. @Value
 * 		: �ܼ��� ���� �Է��� ��, ����ϴ� ������̼�
 * 		1) ����	
 * 			: @Value("Spring")  
 * 				==> XML���� <property.... value="Spring"/>�� ������ ��	
 * 	7. @Qualifier
 * 		: @Autowired ������̼ǰ� �Բ� �����
 * 			==> @Autowired Type(Ÿ��)���� ã�Ƽ� �����ϹǷ�
 * 				������ Ÿ���� Bean��ü�� ���� �� ������ ��, Ư�� Bean�� ã�� ���ؼ���
 * 				@Qualifier�� ���� ����ؾ� ��
 */		
public class EmpVO {
	private int emp;
	private String ename;
	private String job;
	private Date hiredate;
	private int sal;
	public int getEmp() {
		return emp;
	}
	public void setEmp(int emp) {
		this.emp = emp;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}	
}
