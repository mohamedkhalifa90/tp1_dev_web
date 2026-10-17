
package isep.lab1.bean;

public class Person {

    private String firstName;
    private String lastName;
    private String birthDay;
    private String sex;

    // Constructeur sans parametres
    public Person() {
    }

    // Getter et Setter de firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter et Setter de lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter et Setter de birthDay
    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    // Getter et Setter de sex
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
