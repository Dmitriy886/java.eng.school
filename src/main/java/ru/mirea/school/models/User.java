package ru.mirea.school.models;

import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getSubscriptionStart() {
        return subscriptionStart;
    }

    public void setSubscriptionStart(String subscriptionStart) {
        this.subscriptionStart = subscriptionStart;
    }

    public String getSubscriptionEnd() {
        return subscriptionEnd;
    }

    public void setSubscriptionEnd(String subscriptionEnd) {
        this.subscriptionEnd = subscriptionEnd;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getTodayDate() {
        String pattern = "dd.MM.yyyy";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(new Date());
    }

    private String username;
    private String password;

    private String avatarUrl = "https://i.imgur.com/4DINNqs.png";
    private String firstName = "...";
    private String secondName = "...";
    private String age = "0";
    private String height = "0";
    private String weight = "0";
    private String visits = "0";
    private String hours = "0";
    private String plan = "...";
    private String price = "0";
    private String days = "0";
    private String subscriptionStart = getTodayDate();
    private String subscriptionEnd = getTodayDate();

    private String role = "ROLE_USER";
    private boolean enabled = true;

    public Set<TeachingProgram> getTeachingPrograms() {
        return teachingPrograms;
    }

    public void setTeachingPrograms(Set<TeachingProgram> teachingPrograms) {
        this.teachingPrograms = teachingPrograms;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "users_teaching_programs",
            joinColumns = {
                    @JoinColumn(name = "users_user_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "teaching_programs_id",
                            nullable = false, updatable = false)})
    private Set<TeachingProgram> teachingPrograms = new HashSet<>();
}
