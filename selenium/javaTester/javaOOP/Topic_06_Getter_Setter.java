package javaTester.javaOOP;

import net.bytebuddy.implementation.bytecode.Throw;

public class Topic_06_Getter_Setter {

    private String personName;
    private int personAge;
    private String personPhone;
    private float personBankAmount;

    public Topic_06_Getter_Setter() {
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        if (personName == null || personName.isEmpty()) {
            throw new IllegalArgumentException("Name is invalid");
        } else {
            this.personName = personName;
        }
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        if (personAge < 18) {
            throw new IllegalArgumentException("Age must greater than 18");
        } else {
            this.personAge = personAge;
        }
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        if (personPhone == null || personPhone.isEmpty()) {
            throw new IllegalArgumentException("Phone is required");
        } else {
            this.personPhone = personPhone;
        }
    }

    public float getPersonBankAmount() {
        return personBankAmount;
    }

    public void setPersonBankAmount(float personBankAmount) {
        if (personBankAmount < 0) {
            throw new IllegalArgumentException("Amount must greater than or equal 0");
        } else {
            this.personBankAmount = personBankAmount;
        }
    }

    public void sprintInfo() {
        System.out.println(this.getPersonName());
        System.out.println(this.getPersonAge());
        System.out.println(this.getPersonPhone());
        System.out.println(this.getPersonBankAmount());
    }
}
