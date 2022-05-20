package vip.almaty.servicevisits.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Authority {

    @Id
    private Long authorityId;
    private String authority;
    @ManyToOne
    private User user;


    public String getAuthority() {
        return this.authority;
    }

    public Long getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Long id) {
        this.authorityId = id;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
