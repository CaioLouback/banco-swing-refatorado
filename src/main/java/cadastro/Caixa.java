package cadastro;

public class Caixa extends Usuarios{
    
    public Caixa(String nome, String cpf, String senha) {
        super(nome, cpf, senha, "Caixa");
    }

    @Override
    public String getTipoUsuario() {
        return "Caixa";
    }
    
}
