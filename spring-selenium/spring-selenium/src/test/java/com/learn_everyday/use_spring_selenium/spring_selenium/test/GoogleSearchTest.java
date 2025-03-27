package com.learn_everyday.use_spring_selenium.spring_selenium.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learn_everyday.use_spring_selenium.spring_selenium.pages.GoogleHomePage;

@SpringBootTest
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class})
public class GoogleSearchTest extends AbstractTestNGSpringContextTests {
    
    @Autowired
    private GoogleHomePage googleHomePage;
    
    @BeforeMethod
    public void beforeMethod() {
        googleHomePage.openGoogle();
    }
    
    @Test
    public void testGoogleSearch() throws InterruptedException {
        googleHomePage.search("Spring Framework");
        Thread.sleep(3000);
    }
    
    @AfterMethod
    public void afterMethod() {
        googleHomePage.closeBrowser();
    }
}