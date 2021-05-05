package in.bitcode.profileapp;

import java.io.Serializable;

public class Profile implements Serializable {
    private String name;
    private String phone, email;
    private String skills;

    public static final String KEY_PROFILE = "profile";

    public Profile(String name, String phone, String email, String skills) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
