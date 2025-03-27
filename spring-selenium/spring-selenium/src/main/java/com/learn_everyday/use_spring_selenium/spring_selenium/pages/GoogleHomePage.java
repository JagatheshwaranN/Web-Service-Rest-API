package com.learn_everyday.use_spring_selenium.spring_selenium.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // Marks GoogleHomePage as Spring-Managed bean
public class GoogleHomePage {
	
	private WebDriver driver;
	
	@Autowired // Spring injects WebDriver automatically
	public GoogleHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void openGoogle() {
		System.out.println("Opening Google...");
	    driver.get("https://www.google.com/");
	    System.out.println("Page title: " + driver.getTitle());
	}
	
	public void search(String searchKey) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement searchBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
	    searchBox.sendKeys(searchKey);
	    searchBox.submit();
	}

	
	public void closeBrowser() {
		if(driver != null) {
			driver.quit();
		}
	}
	
}
