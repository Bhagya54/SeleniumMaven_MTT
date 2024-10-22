package testngTestcases;

import org.testng.annotations.Test;

public class GroupingDemo {

	@Test(groups = {"smoke","sanity"})
	public void FirstTest() {
		System.out.println("First Test");
	}
	
	@Test(groups = {"smoke"})
	public void SecondTest() {
		System.out.println("Second Test");
	}
	
	@Test(groups = {"sanity"})
	public void ThirdTest() {
		System.out.println("Third Test");
	}

}
