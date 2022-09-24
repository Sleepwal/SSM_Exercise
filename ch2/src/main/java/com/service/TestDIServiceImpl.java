package com.service;
import dao.TestDIDao;

public class TestDIServiceImpl implements TestDIService {
	private TestDIDao testDIDao;

	public TestDIServiceImpl() {
	}

	public TestDIServiceImpl(TestDIDao testDIDao) {
		super();
		this.testDIDao = testDIDao;
		System.out.println("构造器注入");
	}

	public void setTestDIDao(TestDIDao testDIDao) {
		this.testDIDao = testDIDao;
		System.out.println("setter注入");
	}

	@Override
	public void sayHello() {
		testDIDao.sayHello();
	}

}
