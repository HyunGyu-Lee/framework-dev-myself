package com.leeframework.beans.factory;

import java.util.HashMap;

import com.leeframework.beans.BeanEntry;
import com.leeframework.beans.BeanFactoryMetaData;
import com.leeframework.beans.exception.NoSuchBeanException;

public abstract class AbstractBeanFactory {
	
	private BeanFactoryMetaData beanFactoryMetaData;
	private HashMap<String, BeanEntry> beanEntries;
	
	public AbstractBeanFactory(BeanFactoryMetaData beanFactoryMetadata) {
		this.beanFactoryMetaData = beanFactoryMetadata;
		beanEntries = new HashMap<>();
		System.out.println("���޹��� ��Ÿ�����͸� ���� beanEntries ����");
	}
	public BeanFactoryMetaData getBeanFactoryMetaData() {
		return beanFactoryMetaData;
	}
	public void setBeanFactoryMetaData(BeanFactoryMetaData beanFactoryMetaData) {
		this.beanFactoryMetaData = beanFactoryMetaData;
	}
	public HashMap<String, BeanEntry> getBeanEntries() {
		return beanEntries;
	}
	public void setBeanEntries(HashMap<String, BeanEntry> beanEntries) {
		this.beanEntries = beanEntries;
	}
	public <T> Object getBean(String beanName, Class<T> clazz) {
		BeanEntry entry = beanEntries.get(beanName);
		System.out.println("�������� ���� �� ��ȯ ��� ���� �� ��ȯ");
		if(entry==null)throw new NoSuchBeanException(beanName);
		
		return entry.getInstance();
	}
}
