package Backend.demo.services;

import Backend.demo.models.BankAccountModel;
import Backend.demo.models.TransactionModel;
import Backend.demo.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionModel createTransaction(TransactionModel transaction) {
        // Implementa la lógica de la transacción aquí (verificar saldos, registrar historial, etc.)
        // Luego, guarda la transacción
        return transactionRepository.save(transaction);
    }

    public List<TransactionModel> getTransactionsByBankAccountId(Long bankAccountId) {
        // Utiliza el repositorio para obtener todas las transacciones relacionadas con la cuenta bancaria
        return transactionRepository.findByBankAccountId(bankAccountId);
    }

}
