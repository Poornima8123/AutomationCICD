package com.fireflink.seleniumframeworkdesign.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("poornima.b@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Password@123");
		driver.findElement(By.xpath("//input[@id=\"login\"]")).click();
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		System.out.println(products);
		
		WebElement prod = products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		

	}

}
