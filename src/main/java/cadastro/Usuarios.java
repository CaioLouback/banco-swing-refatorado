package cadastro;

public  abstract class Usuarios {
    private String cpf;
    private String senha;
    private String nome;
    private String tipo;
 
    public Usuarios(String nome, String cpf, String senha, String tipo) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.tipo = tipo;   
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public abstract String getTipoUsuario();
    
}
