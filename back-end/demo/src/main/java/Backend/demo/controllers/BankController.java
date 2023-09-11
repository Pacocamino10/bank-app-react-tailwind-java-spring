package Backend.demo.controllers;

import Backend.demo.models.BankAccountModel;
import Backend.demo.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/bankaccount")
public class BankController {
    @Autowired
    BankService bankService;
    @GetMapping
    public ArrayList<BankAccountModel> obtenerBankAccounts(){

        return bankService.getBankAccounts();
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<BankAccountModel> createBankAccount(@RequestBody BankAccountModel bankAccount, @PathVariable Long userId) {
        BankAccountModel createdAccount = bankService.createBankAccount(bankAccount, userId);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }
}
