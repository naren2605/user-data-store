package test.fission.model;

public class User{

    private String firstName;
    private String lastName;
    private int experience;
    private int age ;
    private String organization;
    private double experienceRatio;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public double getExperienceRatio() {
        return experienceRatio;
    }

    public void setExperienceRatio(double experienceRatio) {
        this.experienceRatio = experienceRatio;
    }
}
