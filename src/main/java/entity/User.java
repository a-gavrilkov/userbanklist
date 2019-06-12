package entity;

import java.util.Objects;

public class User {
    private Long userId;
    private String name;
    private String sureName;

    public User() {

    }

    public User(Long userId, String name, String sureName) {
        this.userId = userId;
        this.name = name;
        this.sureName = sureName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(name, user.name) &&
                Objects.equals(sureName, user.sureName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, sureName);
    }
}
