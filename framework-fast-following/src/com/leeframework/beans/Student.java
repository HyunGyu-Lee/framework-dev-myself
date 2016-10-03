package com.leeframework.beans;

import java.util.Set;

import com.leeframework.beans.aware.BeanFactoryAware;
import com.leeframework.beans.aware.BeanNameAware;
import com.leeframework.beans.factory.AbstractBeanFactory;
import com.leeframework.context.ApplicationContext;
import com.leeframework.context.ApplicationContextAware;

public class Student implements BeanNameAware, BeanFactoryAware, ApplicationContextAware {
	
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + "]";
	}
	@Override
	public void setBeanName(String beanName) {
		System.out.println("BeanNameAware�� ���� bean�� �ڽ��� �̸��� �� �� �ֽ��ϴ�."+beanName);
	}

	@Override
	public void setBeanFactory(AbstractBeanFactory beanFactory) {
		System.out.println("BeanFactoryAware�� ���� �󿡼� �����丮�� ������ �����ϰ� �մϴ�.");
		System.out.println("Student�󿡼� ��� �� ��Ʈ�� ���");
		Set<String> k = beanFactory.getBeanFactoryMetaData().getBeanEntries().keySet();
		
		for(String kk : k) {
			System.out.println(beanFactory.getBeanFactoryMetaData().getEntry(kk));
		}
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		System.out.println("ApplicationContextAware�� ���� ���� Context�� ������ �� �ֽ��ϴ�.");
		System.out.println(applicationContext);
	}
	
}
