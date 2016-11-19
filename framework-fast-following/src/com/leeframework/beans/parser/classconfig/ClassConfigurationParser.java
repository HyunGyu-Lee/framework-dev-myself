package com.leeframework.beans.parser.classconfig;

import com.leeframework.beans.metadata.BeanDependency;
import com.leeframework.beans.metadata.BeanEntry;
import com.leeframework.beans.metadata.BeanFactoryMetaData;
import com.leeframework.beans.metadata.BeanReference;
import com.leeframework.beans.streotype.Bean;

import static com.leeframework.utils.ReflectionUtils.*;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class ClassConfigurationParser {

	public static void parseAndApply(BeanFactoryMetaData metaData, Class<?> configurable) {
		Method[] beans = getAnnotatedMethods(configurable, Bean.class);
		
		for(Method bean : beans)
		{
			/* �� ��Ʈ�� ���� */
			BeanEntry entry = new BeanEntry();

			/* �޼ҵ忡 ������ ������̼� */
			Bean beanInfo = bean.getAnnotation(Bean.class);
			
			Class<?> beanType = bean.getReturnType();

			entry.setBeanType(beanType);
			entry.setBeanName(beanInfo.name().equals("")?bean.getName():beanInfo.name());
			entry.setInitMethod(beanInfo.initMethod().equals("")?null:beanInfo.initMethod());
			entry.setDestroyMethod(beanInfo.destroyMethod().equals("")?null:beanInfo.destroyMethod());
			
			/* �������� �߰� ó�� */
			proceedingReference(metaData, entry, bean);
			
			System.out.println(entry+"\n\n");			
		}
		
	}
	
	public static void proceedingReference(BeanFactoryMetaData metaData, BeanEntry entry, Method bean) {
		
		/* ���⼭ �� ���� ���ԵǴ� �������� Ȯ���� �� ������ ������ ���� ������̾ �Ǿ��Ѵ�.
		 * 
		 * ������ �̰� ��� ���� ���� �о�� ���� ���� �������� ó���Ǿ���Ѵ�.
		 *  */
		
		for(Parameter clazz : bean.getParameters())
		{
			metaData.addDefendencies(entry.getBeanName(), new BeanDependency(clazz.getType(), clazz.getName()));
		}
		
	}
	
}