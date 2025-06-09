package dao;

import cadastro.Cliente;
import cadastro.Usuarios;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.List;
import java.util.ArrayList;

public class ArquivoJson {
    private static final String CAMINHO_ARQUIVO = "usuarios.json";
    private static final String CAMINHO_EXTRATO = "extrato.json";
    private static final String CAMINHO_CREDITO = "credito.json";
    private static final String CAMINHO_PEDIDO_SAQUE = "pedidosaque.json";
    
    public void salvarUsuario(Usuarios usuario) {
        File arquivo = new File(CAMINHO_ARQUIVO);
        Gson gson = new Gson();
        List<Usuarios> listaUsuarios = new ArrayList<>();
        
        try{
            listaUsuarios = leArquivoUsuario(listaUsuarios);
            
            listaUsuarios.add(usuario);
            
            // Escreve tudo de volta no arquivo
            try (Writer escreve = new FileWriter(arquivo)) {
                gson.toJson(listaUsuarios, escreve);
            }
            
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    
    private List<Usuarios> leArquivoUsuario(List<Usuarios> listaUsuarios){
        File arquivo = new File(CAMINHO_ARQUIVO);
        Gson gson = new Gson();

        //Se arquivo não existe
        if (!arquivo.exists()) {
            try (Writer escrever = new FileWriter(arquivo)) {
                gson.toJson(listaUsuarios, escrever);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Lendo conteudo existenet
        try (Reader ler = new FileReader(arquivo)) {
            Type tipoLista = new TypeToken<List<Usuarios>>() {
            }.getType();
            listaUsuarios = gson.fromJson(ler, tipoLista);
            if (listaUsuarios == null) {
                listaUsuarios = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return listaUsuarios;   
    }
    
   
    
}
