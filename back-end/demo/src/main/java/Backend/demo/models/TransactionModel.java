package Backend.demo.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="transaction")
public class TransactionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Long bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    private Long bankAccountId;
    private double amount;
    private String description;
    private Date timestamp;
    @ManyToOne
    @JoinColumn(name = "source_account_id")
    private BankAccountModel sourceAccount;

    @ManyToOne
    @JoinColumn(name = "destination_account_id")
    private BankAccountModel destinationAccount;

    public TransactionModel() {
    }

    // Getters y setters
    // ...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BankAccountModel getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(BankAccountModel sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public BankAccountModel getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(BankAccountModel destinationAccount) {
        this.destinationAccount = destinationAccount;
    }
}
