
import org.junit.Before;
import org.junit.Test;

import com.leeframework.beans.RefTest;
import com.leeframework.beans.Student;
import com.leeframework.context.XmlApplicationContext;

public class TestUnit {
	
	private XmlApplicationContext context;
	
	@Before
	public void setUp() {
		context = new XmlApplicationContext("lee-context.xml");
	}
	
	@Test
	public void main() {
		Student student = context.getBean("test", Student.class);
		RefTest t = context.getBean("rf", RefTest.class);
		System.out.println(student.toString()+","+t);
		context.close();
	}
	
}
