package Backend.demo.services;

import Backend.demo.models.UserModel;
import Backend.demo.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public ArrayList <UserModel> obtenerUsuarios(){
        return (ArrayList<UserModel>) usuarioRepository.findAll();
    }

    public UserModel guardarUsuario(UserModel userModel){
       return usuarioRepository.save(userModel);
    }

    public UserModel createUser(UserModel user){
        return usuarioRepository.save(user);
    }
    public UserModel getUserById(Long userId) {
        Optional<UserModel> user = usuarioRepository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        } else {
           return null;
        }
    }

    public UserModel updateUser(Long userId, UserModel updatedUserData) {
        UserModel existingUser = getUserById(userId);
        // Actualiza los datos del usuario con los datos proporcionados
        existingUser.setName(updatedUserData.getName());
        existingUser.setUsername(updatedUserData.getUsername());
        existingUser.setEmail(updatedUserData.getEmail());
        // Continúa actualizando otros campos según sea necesario
        return usuarioRepository.save(existingUser);
    }

    public void deleteUser(Long userId) {
        UserModel existingUser = getUserById(userId);
        usuarioRepository.delete(existingUser);
    }

}
