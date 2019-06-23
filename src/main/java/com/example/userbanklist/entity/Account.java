package com.example.userbanklist.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "account")
public class Account extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountid")
    private Long id;

    @Column(name = "account")
    private Long account;

    @Column(name = "userid")
    private Long userId;

    public Account() {
    }

    public Account(Long id, Long account, Long userId) {
        this.id = id;
        this.account = account;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(Long account) {
        this.account = account;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account1 = (Account) o;
        return Objects.equals(id, account1.id) &&
                Objects.equals(account, account1.account) &&
                Objects.equals(userId, account1.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, userId);
    }
}
