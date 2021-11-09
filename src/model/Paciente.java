package model;

public class Paciente {
    private int id;
    private String nome;
    private String sexo;
    private String data_nasc; 
    private String cpf; 
    private String plano_saude;
    private String created_at;
    private String deleted_at;
    
    public Paciente(int id, String nome, String sexo, String data_nasc, 
    String cpf, String plano_saude, String created_at, String deleted_at) {
        this.id = id;
        this.nome = nome;
        this.sexo = sexo;
        this.data_nasc = data_nasc;
        this.cpf = cpf;
        this.plano_saude = plano_saude;
        this.created_at = created_at;
        this.deleted_at = deleted_at;
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
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
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
    public String getCreatedAt() {
        return created_at;
    }
    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }
    public String getDeletedAt() {
        return deleted_at;
    }
    public void setDeletedAt(String deleted_at) {
        this.deleted_at = deleted_at;
    }

}
