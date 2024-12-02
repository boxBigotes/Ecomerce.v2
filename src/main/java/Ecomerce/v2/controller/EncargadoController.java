package Ecomerce.v2.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Ecomerce.v2.services.EncargadoService;

@RestController
@RequestMapping("/api/login")
public class EncargadoController {

    @Autowired
    private EncargadoService encargadoService;

    @PostMapping
    public boolean login(@RequestBody LoginRequest loginRequest) {
        return encargadoService.autenticar(loginRequest.getNombre(), loginRequest.getPassword());
    }
    
    public static class LoginRequest {
        private String nombre;
        private String password;

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}