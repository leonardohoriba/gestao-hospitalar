package model;

public class Paciente {
    private int id;
    private String nome;
    private char sexo;
    private String data_nasc; 
    private String cpf; 
    private String plano_saude;
    
    public Paciente(int id, String nome, char sexo,
     String data_nasc, String cpf, String plano_saude) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.data_nasc = data_nasc;
        this.cpf = cpf;
        this.plano_saude = plano_saude;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public String getDataNasc() {
        return data_nasc;
    }
    public void setDataNasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getPlanoSaude() {
        return plano_saude;
    }
    public void setPlanoSaude(String plano_saude) {
        this.plano_saude = plano_saude;
    }

}
