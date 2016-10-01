package com.leeframework.context;

import com.leeframework.beans.BeanFactoryMetaData;
import com.leeframework.beans.factory.AbstractBeanFactory;
import com.leeframework.beans.factory.BeanFactory;

public abstract class ApplicationContext {
	
	private AbstractBeanFactory beanFactory;
	
	public void initailize() {
		beanFactory = new BeanFactory(createBeanFactoryMetaDataStrategy());
		System.out.println("���޹��� metaData�� beanFactory ����");
	}
	
	public abstract BeanFactoryMetaData createBeanFactoryMetaDataStrategy();
	
	public <T> Object getBean(String beanName, Class<T> clazz) { 
		System.out.println(beanFactory);
		return beanFactory.getBean(beanName, clazz);
	}
	
}
