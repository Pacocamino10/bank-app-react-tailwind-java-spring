package Backend.demo.services;

import Backend.demo.models.BankAccountModel;
import Backend.demo.models.UserModel;
import Backend.demo.repositories.BankRepository;
import Backend.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;
    @Autowired
    private UsuarioRepository userRepository;
    @Autowired
    private UsuarioService usuarioService;

    // CREAR CUENTA DE BANCO
    public BankAccountModel createBankAccount(BankAccountModel bankAccount, Long userId) {
        // Asegúrate de asignar el usuario a la cuenta bancaria antes de guardarla
        bankAccount.setUser(usuarioService.getUserById(userId));
        return bankRepository.save(bankAccount);
    }

    //OBETENER CUENTAS BANCOS
    public ArrayList<BankAccountModel> getBankAccounts() {
        return (ArrayList<BankAccountModel>) bankRepository.findAll();
    }

    //OBTENER CUENTA DE BANCO POR USER ID
    public BankAccountModel  getBankAccountByUserId(Long userid) {
        Optional<BankAccountModel> optionalBankAccount = bankRepository.findById(userid);

        if (optionalBankAccount.isPresent()) {
            return optionalBankAccount.get();
        } else {
            return null; // Devuelve null si la cuenta bancaria no se encuentra
        }}

    //GUARDAR BANCO POR ID USER
    public BankAccountModel guardarBankAccount(BankAccountModel bankAccountModel, Long userId) {
        Optional<UserModel> optionalUser = userRepository.findById(userId);

        if (optionalUser.isPresent()) {
            UserModel user = optionalUser.get();
            bankAccountModel.setUser(user);
            return bankRepository.save(bankAccountModel);
        } else {
            return null;
        }
    }

    //DELETE BANK ACCOUNT
    public void deleteBankAccount(Long accountId){
        bankRepository.deleteById(accountId);
    }
}
