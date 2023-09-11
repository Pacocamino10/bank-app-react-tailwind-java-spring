package Backend.demo.controllers;

import Backend.demo.models.TransactionModel;
import Backend.demo.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionModel> createTransaction(@RequestBody TransactionModel transaction) {
        TransactionModel createdTransaction = transactionService.createTransaction(transaction);
        return new ResponseEntity<>(createdTransaction, HttpStatus.CREATED);
    }

    @GetMapping("/bank-account/{bankAccountId}")
    public ResponseEntity<List<TransactionModel>> getTransactionsByBankAccountId(@PathVariable Long bankAccountId) {
        List<TransactionModel> transactions = transactionService.getTransactionsByBankAccountId(bankAccountId);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }

}
