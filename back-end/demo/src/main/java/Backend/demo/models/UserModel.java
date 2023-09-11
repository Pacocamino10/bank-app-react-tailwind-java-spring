package Backend.demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usermodel")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)

    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String username;
    @OneToMany(mappedBy = "user")
    private List<BankAccountModel> bankAccountModels;

    // Getters y setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<BankAccountModel> getBankAccounts() {
        return bankAccountModels;
    }

    public void setBankAccounts(List<BankAccountModel> bankAccountModels) {
        this.bankAccountModels = bankAccountModels;
    }

}
