package model;

public class Internacao {

    private int id;
    private int paciente_id;
    private String data_entrada; 
    private String data_saida; 
    private String causa;
    private String quarto;
    private String created_at;
    private String deleted_at;

    public Internacao(int id, int paciente_id, String data_entrada, String data_saida, 
    String causa, String quarto, String created_at, String deleted_at) {
        this.id = id;
        this.paciente_id = paciente_id;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;
        this.causa = causa;
        this.quarto = quarto;
        this.created_at = created_at;
        this.deleted_at = deleted_at;
     }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getPacienteId() {
        return paciente_id;
    }
    public void setPacienteId(int paciente_id) {
        this.paciente_id = paciente_id;
    }
    public String getDataEntrada() {
        return data_entrada;
    }
    public void setDataEntrada(String data_entrada) {
        this.data_entrada = data_entrada;
    }
    public String getDataSaida() {
        return data_saida;
    }
    public void setDataSaida(String data_saida) {
        this.data_saida = data_saida;
    }
    public String getCausa() {
        return causa;
    }
    public void setCausa(String causa) {
        this.causa = causa;
    }
    public String getQuarto() {
        return quarto;
    }
    public void setQuarto(String quarto) {
        this.quarto = quarto;
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
