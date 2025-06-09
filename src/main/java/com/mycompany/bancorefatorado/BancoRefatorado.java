package com.mycompany.bancorefatorado;

import cadastro.Cliente;
import cadastro.Usuarios;
import com.google.gson.Gson;
import dao.ArquivoJson;
import java.util.List;
import java.util.ArrayList;
import tela.Login;


public class BancoRefatorado {

    public static void main(String[] args) {
        
        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        
        
        
        /*Usuarios user = new Cliente("caio", "6565", "123", 0);
        user.setCpf("89899");
        user.setNome("Cesar");
        user.setSenha("1");
        List<Usuarios> usuarios = new ArrayList<>();
        usuarios.add(user);
        
        String jsonUser = new Gson().toJson(usuarios);
        System.out.println(jsonUser);
        ArquivoJson json = new ArquivoJson();
        
        json.salvarUsuario(user);*/
    }
}
