package pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class brokenlinks extends seleniumActions {

    private By links = By.cssSelector("#content >.example >a");

    private String url = "";
    private int responseCode ;
    int validCount;

    HttpURLConnection huc =null;

    public void a() throws MalformedURLException, IOException {

        List<WebElement> allLinks = getListOfWebElements(links);// fina all links on page
     

        for (WebElement link : allLinks) {
            url = link.getAttribute("href");
           // System.out.println(url);
            huc = (HttpURLConnection)new URL(url).openConnection();
            huc.setRequestMethod("HEAD");
            huc.connect();
            responseCode =  huc.getResponseCode();
            if(responseCode>=400){
                System.out.println(url + "is broken link");
              
            }
            else{
                System.out.println(url + "is valid link");
                validCount++;
            }
           

        }
        System.out.println("total links present in page are  " +allLinks.size());
        System.out.println("valid links count : "+ validCount);

    }

}
