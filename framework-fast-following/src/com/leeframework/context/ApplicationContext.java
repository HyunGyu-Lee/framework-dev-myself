package com.leeframework.context;

import com.leeframework.beans.BeanFactoryMetaData;
import com.leeframework.beans.factory.AbstractBeanFactory;
import com.leeframework.beans.factory.BeanFactory;

public abstract class ApplicationContext {
	
	private AbstractBeanFactory beanFactory;
	
	public void initailize() {
		System.out.println("�������ؽ�Ʈ���� ������ ��Ÿ�����ͻ��������� ���� beanFactory ����");
		beanFactory = new BeanFactory(createBeanFactoryMetaDataStrategy());
	}
	
	public abstract BeanFactoryMetaData createBeanFactoryMetaDataStrategy();
	
	public <T> T getBean(String beanName, Class<T> clazz) { 
		System.out.println(beanFactory);
		return beanFactory.getBean(beanName, clazz);
	}
	
}
