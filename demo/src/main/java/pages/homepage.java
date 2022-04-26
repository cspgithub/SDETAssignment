package pages;

import org.openqa.selenium.By;

public class homepage extends seleniumActions{

    private By hmaBurgerMenu = By.xpath("//div[@class='nav-left']/a[@id='nav-hamburger-menu']");//All

    private By hmenuitemhmenutitle  = By.xpath("//div[@id='hmenu-content']/ul/li/div[@class='hmenu-item hmenu-title '][text()='shop by department']/following::div[text()='TV, Appliances, Electronics']/..");//TV, Appliances, Electronics

    private By hmenuitem  = By.xpath("//div[@id='hmenu-content']/ul/li/div[@class='hmenu-item hmenu-title '][text()='tv, audio & cameras']/following::a[text()='Televisions']");//Televisions



    public productPage clickHamburgerMenu(){

        click(hmaBurgerMenu);
        sleep(2000);
        click(hmenuitemhmenutitle);
        jsClick(hmenuitem);

        return new productPage();

        
        
    }





    
    
}
