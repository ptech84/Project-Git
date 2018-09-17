package com.freecrm.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PracticeTest {
	
	WebDriver driver;
	
	
//	aunch new Browser
//	Open “http://toolsqa.wpengine.com/automation-practice-form/“
//	Challenge One – Select the deselected Radio button (female) for category Sex (Use IsSelected method)
//	Challenge Two – Select the Third radio button for category ‘Years of Exp’ (Use Id attribute to select Radio button)
//	Challenge Three – Check the Check Box ‘Automation Tester’ for category ‘Profession'( Use Value attribute to match the selection)
//	Challenge Four – Check the Check Box ‘Selenium IDE’ for category ‘Automation Tool’ (Use cssSelector)
	
	@Test
	public void Test1() {
	System.setProperty("webdriver.chrome.driver", "/Users/praveennaidu/Downloads/chromedriver");
	driver = new ChromeDriver();
	driver.get("http://toolsqa.wpengine.com/automation-practice-form/");
	//boolean sel = driver.findElement(By.xpath("//input[@name='sex' and @value='Female']")).isSelected();
	
	List<WebElement> radioBtns = driver.findElements(By.name("sex"));
	boolean flag = false;
	for(int i=0;i<radioBtns.size();i++) {
	flag = radioBtns.get(i).isSelected();
	if(flag == false) {
		if(radioBtns.get(i).getAttribute("value").equals("Female")) {
		
		radioBtns.get(i).click();
	}}
	}

	driver.findElement(By.cssSelector("input[value='Selenium IDE']")).click();;
	
	
	
		
	}
	

}
