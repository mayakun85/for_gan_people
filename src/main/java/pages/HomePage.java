package pages;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$x;

public class HomePage {
    private static final String HOMEPAGE_TITLE_XPATH = "//a/child::img[@title='MoneyGaming']";
    private static final String JOIN_NOW_BUTTON_XPATH = "//a[contains(text(),'Join Now!')]";

    public HomePage validateHomepageTitle(String titleText){
        $x(HOMEPAGE_TITLE_XPATH).shouldHave(Condition.exactText(titleText));
        return this;
    }

    public SignUpPage proceedToSignUp(){
        $x(JOIN_NOW_BUTTON_XPATH).shouldBe(Condition.visible).click();
        return new SignUpPage();
    }
}
