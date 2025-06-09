package cadastro;

public class Gerente extends Usuarios{
    
    public Gerente(String nome, String cpf, String senha){
        super(nome, cpf, senha, "Gerente");
    }

    @Override
    public String getTipoUsuario() {
        return "Gerente";
    }
    
}
