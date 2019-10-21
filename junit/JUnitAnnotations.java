package abcpack;

import org.junit.jupiter.api.*;

public class JUnitAnnotations {
	
	@BeforeEach
	public void setUp()
	{
		System.out.println("@BeforeEach");
	}
	@AfterEach
	public void tearDown()
	{
		System.out.println("@AfterEach");
	}
	@BeforeAll
	public static void oneTimeSetUp()
	{
		System.out.println("@BeforeAll");
	}
	@AfterAll
	public static void oneTimetearDown()
	{
		System.out.println("@AfterAll");
	}
	@Test
	public void testMeth1()
	{
		System.out.println("@Test1");
	}
	@Test
	public void testMeth2()
	{
		System.out.println("@Test2");
	}

}
