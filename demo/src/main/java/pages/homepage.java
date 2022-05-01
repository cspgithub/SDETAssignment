package pages;

import org.openqa.selenium.By;

public class homepage extends seleniumActions{

    private By hamBurgerMenu = By.cssSelector("[id=nav-hamburger-menu] > span");//All

    private By hmenuitemhmenutitle  = By.cssSelector("[id=hmenu-content] > ul.hmenu.hmenu-visible > li:nth-child(16) > a > i");//TV, Appliances, Electronics

    private By hmenuitem  = By.cssSelector("[id=hmenu-content] > ul.hmenu.hmenu-visible.hmenu-translateX > li:nth-child(3) > a");//Televisions



    public productPage clickHamburgerMenuOnHomePage(){

        click(hamBurgerMenu);
        sleep(2000);
        click(hmenuitemhmenutitle);
        jsClick(hmenuitem);

        return new productPage();

        
        
    }





    
    
}
