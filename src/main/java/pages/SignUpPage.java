package pages;
import static com.codeborne.selenide.Selenide.$x;

import com.codeborne.selenide.Condition;
import domain.User;

public class SignUpPage {

    private static final String SIGNUP_PAGE_DROPDOWN_XPATH = "//select[@id='title']";
    private static final String SIGNUP_DROPDOWN_OPTION_XPATH = "//select[@id='title']/child::option[@value='Mr']";
    private static final String SIGNUP_INPUT_FIRSTNAME_XPATH = "//*[@id='forename']";
    private static final String SIGNUP_INPUT_LASTNAME_XPATH = "//*[@name='map(lastName)']";
    private static final String SIGNUP_CHECKBOX_XPATH = "//div[@id='termsCheckbox']/preceding::input[1]";
    private static final String JOIN_NOW_BUTTON = "//input[@value='Join Now!'][@id='form']";
    private static final String TEXT_ERROR_LABEL = "//*[@id='dobYear']/following::label[1]";

    public SignUpPage fillUpTheForm(User user){
        $x(SIGNUP_PAGE_DROPDOWN_XPATH).click();
        $x(SIGNUP_DROPDOWN_OPTION_XPATH).click();
        $x(SIGNUP_INPUT_FIRSTNAME_XPATH).setValue(user.getUserFirstName());
        $x(SIGNUP_INPUT_LASTNAME_XPATH).setValue(user.getUserLastName());
        $x(SIGNUP_CHECKBOX_XPATH).click();
        return this;

    }
    public SignUpPage clickJoinNowButton(){
        $x(JOIN_NOW_BUTTON).click();
        return this;
    }
    public SignUpPage validateErrorText(String textError){
        $x(TEXT_ERROR_LABEL).shouldHave(Condition.exactText(textError));
        return this;
    }

    public String getActualErrorLabelText(){
       return  $x(TEXT_ERROR_LABEL).shouldBe(Condition.visible).getText();
    }

}
