package com.guincha.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.guincha.Model.LoginRequest;
import com.guincha.Model.LoginResponse;
import com.guincha.Model.User;
import com.guincha.Service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private UserService userService;  // Servicio para manejar los usuarios
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;  // Encoder para verificar contraseñas
    
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginRequest loginRequest) {
        // Buscar el usuario por correo electrónico
        User userOpt = userService.findByUserEmail(loginRequest.getEmail());

        // Si el usuario no se encuentra, devolver un error 401
        if (userOpt == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ResponseMessage("error", "User not found"));
        }

        // Verificar la contraseña ingresada con la almacenada
        if (!passwordEncoder.matches(loginRequest.getPassword(), userOpt.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ResponseMessage("error", "Invalid password"));
        }

        // Si la autenticación es exitosa, devolver un objeto con el mensaje y el usuario
        LoginResponse response = new LoginResponse("success", "Login successful", userOpt);
        return ResponseEntity.ok(response);
    }


}

// Clase para representar la respuesta de login
class ResponseMessage {
    private String status;
    private String message;

    // Constructor
    public ResponseMessage(String status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getters y setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
