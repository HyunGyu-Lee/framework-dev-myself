package com.leeframework.context;

import com.leeframework.beans.BeanFactoryMetaData;

public class XmlApplicationContext extends ApplicationContext {
	
	private String[] xmls;
	
	public XmlApplicationContext(String...xmls) {
		this.xmls = xmls;
		super.initailize();
	}
	
	@Override
	public BeanFactoryMetaData createBeanFactoryMetaDataStrategy() {
		BeanFactoryMetaData metaData = new BeanFactoryMetaData();
		System.out.println("XML������ �Ľ� �� metaData ������ �� ��ȯ");
		for(String xml : xmls)
		{
			System.out.println(xml);
		}
		return metaData;
	}

	
	
}
