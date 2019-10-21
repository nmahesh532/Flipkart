package abcpack;

import org.junit.Assert;
import org.testng.annotations.Test;

public class DependencyTest {
	
	@Test
	public void meth1()
	{
		System.out.println("meth1()");
		Assert.fail();
	}
	@Test(dependsOnMethods="meth1")
	public void meth2()
	{
		System.out.println("meth2()");
	}

}
