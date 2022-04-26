package pages;

import org.openqa.selenium.By;

public class homepage extends seleniumActions{

    private By hmaBurgerMenu = By.cssSelector("[id=nav-hamburger-menu] > i");//All

    private By hmenuitemhmenutitle  = By.cssSelector("[id=hmenu-content] > ul.hmenu.hmenu-visible > li:nth-child(16) > a > div");//TV, Appliances, Electronics

    private By hmenuitem  = By.xpath("[id=hmenu-content] > ul.hmenu.hmenu-visible.hmenu-translateX > li:nth-child(3) > a");//Televisions



    public productPage clickHamburgerMenu(){

        click(hmaBurgerMenu);
        sleep(2000);
        click(hmenuitemhmenutitle);
        jsClick(hmenuitem);

        return new productPage();

        
        
    }





    
    
}
