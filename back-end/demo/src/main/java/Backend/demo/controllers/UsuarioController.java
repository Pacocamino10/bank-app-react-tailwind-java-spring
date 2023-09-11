package Backend.demo.controllers;

import Backend.demo.models.UserModel;
import Backend.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/crear")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel userModel) {
        UserModel createdUser = usuarioService.createUser(userModel);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
    @PostMapping("/guardar")
    public UserModel guardarUsuario(@RequestBody  UserModel usermodel){
        return usuarioService.guardarUsuario(usermodel);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserModel> updateUser(@PathVariable Long userId, @RequestBody UserModel updatedUser) {
        UserModel updatedUserData = usuarioService.updateUser(userId, updatedUser);
        return new ResponseEntity<>(updatedUserData, HttpStatus.OK);
    }
    @GetMapping
    public ArrayList<UserModel> obtenerUsuarios(){
        return usuarioService.obtenerUsuarios();
    }
    @GetMapping("/{userId}")
    public ResponseEntity<UserModel> getUserById(@PathVariable Long userId) {
        UserModel user = usuarioService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }



}
