package com.java.test;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstScript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//setting the path of chrome Driver		
System.setProperty("webdriver.chrome.driver", "D:\\JAR_FILE\\chromedriver_win32\\chromedriver.exe");
		
//creating the object of ChromeDriver		
		WebDriver Driver=new ChromeDriver();

//opening url 		
		Driver.get("https://www.w3schools.com/");
//getting Title		
		String DestString="TITLE-----\t"+Driver.getTitle()+"\n\n\n";
		
		DestString+="LINKS----\n\n"	;
// Get List of web-page elements with tag name -a
		
		
List<WebElement>list=Driver.findElements(By.tagName("a"));
StringBuilder sb=new StringBuilder();
for(WebElement we:list) {
sb.append(we.getText()+"----\t"+we.getAttribute("href")+"\n\n");	
}
DestString+=sb.toString();	
		
File f=new File("Assignment_WebScrapping.txt");

try {
	FileUtils.writeStringToFile(f,DestString);
}catch(Exception e) {
	e.printStackTrace();
}
		

//closing Browser		
		Driver.quit();
		
	}
	
	
	
	
	

}
