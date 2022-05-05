package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import static io.qameta.allure.Allure.step;
import static java.lang.String.format;

public class TestPracticeForm extends TestBase {
    Faker faker = new Faker();
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();


    @Test
    @DisplayName("Заполнение формы на сайте demoqa.com")
    void FormTests() {
        String FirstName = faker.name().firstName();
        String LastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String PhoneNumber = faker.phoneNumber().subscriberNumber(10);
        String day = "18";
        String month = "November";
        String year = "1982";
        String subject_1 = "English";
        String subject_2 = "Arts";
        String subject_3 = "Computer Science";
        String file = "1.txt";
        String current_address = faker.address().fullAddress();
        //for asserts
        String check_text = "Thanks for submitting the form";
        String FullName = format("%s %s", FirstName, LastName);
        String gender = "Male";
        String BirthDay = format("%s %s,%s", day, month, year);
        String hobby = "Reading";
        String state = "Uttar Pradesh";
        String city = "Lucknow";
        String StateAndCity = format("%s %s", state, city);


        //Actions
        step("Открываем форму регистрации", () -> {
            registrationFormPage.openPage();
        });

        step("Заполняем данные", () -> {
            registrationFormPage.setFirstName(FirstName)
                    .setLastName(LastName)
                    .setEmail(email)
                    .chooseGender()
                    .setPhoneNumber(PhoneNumber)
                    .chooseBDdate(day, month, year)
                    .setSubject(subject_1)
                    .setSubject(subject_2)
                    .setSubject(subject_3)
                    .chooseHobbie()
                    .uploadElement(file)
                    .setCurrentAdress(current_address)
                    .setState()
                    .setCity();
        });

        step("Отправляем заполненную форму", () -> {
            registrationFormPage.submitForm();
        });

        //Asserts
        step("Проверяем данные заполненной формы", () -> {
            registrationFormPage.checkForm(check_text)
                .checkName(FullName)
                .checkEmail(email)
                .checkGender(gender)
                .checkPhoneNumber(PhoneNumber)
                .checkBD(BirthDay)
                .checkSubject(subject_1)
                .checkSubject(subject_2)
                .checkSubject(subject_3)
                .checkHobbie(hobby)
                .checkUploadFile(file)
                .checkCurrentAdress(current_address)
                .checkStateAndCIty(StateAndCity)
                .closeForm();
        });
    }
}
