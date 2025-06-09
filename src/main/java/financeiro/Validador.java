package financeiro;

import funcionalidades.Servico;
import java.text.ParseException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;


public class Validador {
    private String cpf;
    private static final String Formato = "###.###.###-##";
    
    
    public Validador(String C) {
        this.cpf = this.Format(C,false);
    }
    
    public boolean isCPF(){
        
        if (this.cpf.equals("00000000000") || 
            this.cpf.equals("11111111111") || 
            this.cpf.equals("22222222222") || 
            this.cpf.equals("33333333333") ||
            this.cpf.equals("44444444444") ||
            this.cpf.equals("55555555555") ||
            this.cpf.equals("66666666666") ||
            this.cpf.equals("77777777777") ||
            this.cpf.equals("88888888888") ||
            this.cpf.equals("99999999999") ||
            this.cpf.length() != 11)
            return(false);
        
        char dig10, dig11; 
        int sm, i, r, num, peso; 

        try { 
            // Calculo do primeiro Digito Verificador 
            sm = 0; 
            peso = 10; 
            for (i=0; i<9; i++) { 
                num = (int)(this.cpf.charAt(i) - 48); 
                sm = sm + (num * peso); 
                peso = peso - 1;
            } 
            r = 11 - (sm % 11); 
            if ((r == 10) || (r == 11)) 
                dig10 = '0'; 
            else 
                dig10 = (char)(r + 48); 

            // Calculo do segundo Digito Verificador 
            sm = 0; 
            peso = 11; 
            for(i=0; i<10; i++) { 
                num = (int)(this.cpf.charAt(i) - 48);
                sm = sm + (num * peso); 
                peso = peso - 1;
            } 
            r = 11 - (sm % 11); 
            if ((r == 10) || (r == 11)) 
                dig11 = '0'; 
            else 
                dig11 = (char)(r + 48); 

            if ((dig10 == this.cpf.charAt(9)) && (dig11 == this.cpf.charAt(10))) 
                return(true); 
            else return(false);
        } catch(Exception e) { 
            return(false); 
        } 
    }

    public String getCPF(boolean Mascara) {
        return Format(this.cpf,Mascara);
    }
    
    //Formatação do cpf para retorno
    private String Format(String C, boolean Mascara){
        if(Mascara){
            return(C.substring(0, 3) + "." + C.substring(3, 6) + "." +
            C.substring(6, 9) + "-" + C.substring(9, 11));
        }else{
            C = C.replace(".","");
            C = C.replace("-","");
            return C;
        }
    }
    
    public boolean validarCadastramento(String nome, String cpf, String senha, String confSenha, String tipoUsuario){
        Validador val = new Validador(cpf);
        boolean retorno = val.isCPF();
        
        if(retorno == false){
            System.out.println("CPF inválido!");
            return false;
        } else {
            Servico s = new Servico();
            if ("Cliente".equals(tipoUsuario)) {
                s.cadastrarCliente(nome, cpf, senha);
                System.out.println("Cadastro do Cliente Realizado com Sucesso!");
            } else if ("Caixa".equals(tipoUsuario)) {
                s.cadastrarCaixa(nome, cpf, senha);
                System.out.println("Cadastro do Caixa REalizado com Sucesso!");
            } else if ("Gerente".equals(tipoUsuario)) {
                s.cadastrarGerente(nome, cpf, senha);
                System.out.println("Cadastro do Gerente Realizado com Sucesso!");
            }
        }
        
        
        return false;
    }
 
}
