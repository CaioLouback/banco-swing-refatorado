package cadastro;

public class Cliente extends Usuarios{
    private double saldo;

    public Cliente(String nome, String cpf, String senha, double saldo) {
        super(nome, cpf, senha, "Cliente");
        this.saldo = saldo;
    }
    
    public double getSaldo(){
        return saldo;
    }
    
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    @Override
    public String getTipoUsuario() {
        return "Cliente";
    }
}
