package App.model;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.Reference;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ScopedProxyMode;

@Component
@Scope(value = "session",  proxyMode = ScopedProxyMode.TARGET_CLASS)

public class User {


    public String id;

    public String firstname;

    public String lastname;

    public String email;


   /* @Reference
    private List<Role> roles = new ArrayList<>();*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUserId() {
        return email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

  

/*    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }*/
}
