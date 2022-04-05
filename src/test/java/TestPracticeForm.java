import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TestPracticeForm {



    @BeforeAll
    static void startup(){
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        //Configuration.browserSize = "1024x768";

    }
    @Test
    void FormTests(){
        String FirstName = "Oleg";
        String LastName = "Sheglov";
        String email = "os@os.com";
        String PhoneNumber = "9991234567";


        open("/automation-practice-form");
        $("#firstName").setValue(FirstName);
        $("#lastName").setValue(LastName);
        $("#userEmail").setValue(email);
        $(byText("Other")).click();
        $("#userNumber").setValue(PhoneNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionByValue("7");
        $(".react-datepicker__year-select").selectOptionByValue("1983");
        $(byText("23")).click();
        $("#subjectsInput").setValue("English");
        $("#subjectsInput").pressEnter();
        $("#subjectsInput").setValue("Arts");
        $("#subjectsInput").pressEnter();
        $("#subjectsInput").setValue("Computer Science");
        $("#subjectsInput").pressEnter();
        $(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("1.txt");
        $("#currentAddress").setValue("Street: Langley, House: 12");
        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Lucknow")).click();
        $("#submit").click();

    }
}
