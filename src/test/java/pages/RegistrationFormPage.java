package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.SetBirthdayDate;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {

    SetBirthdayDate setDate = new SetBirthdayDate();


    //locators
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement chooseGender = $(byText("Male"));
    SelenideElement setPhoneNumber = $("#userNumber");
    SelenideElement inputSubject = $("#subjectsInput");
    SelenideElement chooseHobbie = $(byText("Reading"));
    SelenideElement uploadElement = $("#uploadPicture");
    SelenideElement setCurrentAdress = $("#currentAddress");
    SelenideElement setState = $("#state");
    SelenideElement findState = $(byText("Uttar Pradesh"));
    SelenideElement setCity = $("#city");
    SelenideElement findCity = $(byText("Lucknow"));
    SelenideElement submitForm = $("#submit");

    SelenideElement checkForm = $(".modal-open");
    SelenideElement checkValues = $(".table-responsive");
    SelenideElement closeForm =  $("#closeLargeModal");



    //actions

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public RegistrationFormPage setFirstName(String name) {
        firstNameInput.setValue(name);
        return this;
    }

    public RegistrationFormPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationFormPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    public RegistrationFormPage chooseGender() {
        chooseGender.click();
        return this;
    }

    public RegistrationFormPage setPhoneNumber(String phoneNumber) {
        setPhoneNumber.setValue(phoneNumber);
        return this;
    }

    public RegistrationFormPage chooseBDdate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        setDate.setDate(day, month, year);
        return this;
    }

    public RegistrationFormPage setSubject(String subject) {
        inputSubject.setValue(subject);
        inputSubject.pressEnter();
        return this;
    }

    public RegistrationFormPage chooseHobbie() {
        chooseHobbie.click();
        return this;
    }

    public RegistrationFormPage uploadElement(String file) {
        uploadElement.uploadFromClasspath(file);
        return this;
    }

    public RegistrationFormPage setCurrentAdress(String adress_name) {
        setCurrentAdress.setValue(adress_name);
        return this;
    }

    public RegistrationFormPage setState() {
        setState.click();
        findState.click();
        return this;
    }

    public RegistrationFormPage setCity() {
        setCity.click();
        findCity.click();
        return this;
    }
    public void submitForm() {
        submitForm.click();
    }

    //Asserts
    public RegistrationFormPage checkForm(String check_text) {
        checkForm.shouldHave(text(check_text));
        return this;
    }
    public RegistrationFormPage checkName(String FullName) {
        checkValues.shouldHave(text(FullName));
        return this;
    }
    public RegistrationFormPage checkEmail(String email) {
        checkValues.shouldHave(text(email));
        return this;
    }
    public RegistrationFormPage checkGender(String gender) {
        checkValues.shouldHave(text(gender));
        return this;
    }
    public RegistrationFormPage checkPhoneNumber(String phoneNumber) {
        checkValues.shouldHave(text(phoneNumber));
        return this;
    }
    public RegistrationFormPage checkBD(String date) {
        checkValues.shouldHave(text(date));
        return this;
    }
    public RegistrationFormPage checkSubject(String subject) {
        checkValues.shouldHave(text(subject));
        return this;
    }
    public RegistrationFormPage checkHobbie(String hobbie) {
        checkValues.shouldHave(text(hobbie));
        return this;
    }
    public RegistrationFormPage checkUploadFile(String file) {
        checkValues.shouldHave(text(file));
        return this;
    }
    public RegistrationFormPage checkCurrentAdress(String adress_name) {
        checkValues.shouldHave(text(adress_name));
        return this;
    }
    public RegistrationFormPage checkStateAndCIty(String StateCity) {
        checkValues.shouldHave(text(StateCity));
        return this;
    }
    public void closeForm() {
        closeForm.click();
    }

}
