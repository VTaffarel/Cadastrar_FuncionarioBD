public class FuncionarioDTO {
    String nome;
    String cpf;
    String tell;
    String email;
    int codigo;

    
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTell() {
        return tell;
    }
    public void setTell(String tell) {
        this.tell = tell;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }



    public void descricaoFuncionario(){
        System.out.println("|Cod:"+codigo+"|Nome:"+nome+"|email:"+email+"|telefone"+tell+"|"+"|Cpf:"+cpf+"|");
    }
    
}
