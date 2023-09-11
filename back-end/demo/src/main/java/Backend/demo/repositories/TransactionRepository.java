package Backend.demo.repositories;

        import Backend.demo.models.BankAccountModel;
        import Backend.demo.models.TransactionModel;
        import org.springframework.data.jpa.repository.JpaRepository;


        import java.util.List;

public interface TransactionRepository extends JpaRepository<TransactionModel, Long > {
    List<TransactionModel> findByBankAccountId(Long bankAccountId);

}
