package Backend.demo.repositories;

import Backend.demo.models.BankAccountModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends CrudRepository <BankAccountModel,Long> {

}
