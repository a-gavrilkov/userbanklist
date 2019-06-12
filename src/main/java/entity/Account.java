package entity;

import java.util.Objects;

public class Account {
    private Long accountId;
    private Long account;
    private Long userId;

    public Account() {
    }

    public Account(Long accountId, Long account, Long userId) {
        this.accountId = accountId;
        this.account = account;
        this.userId = userId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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
        return Objects.equals(accountId, account1.accountId) &&
                Objects.equals(account, account1.account) &&
                Objects.equals(userId, account1.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, account, userId);
    }
}
