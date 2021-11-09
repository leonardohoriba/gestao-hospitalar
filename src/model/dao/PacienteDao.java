package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Paciente;

public class PacienteDao {

    public void create(Paciente paciente) {
        Connection conn = ConnectionFactory.getConnection(); 
        PreparedStatement stmt = null;

        java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
        // Date date = new Date(timestamp.getTime());
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp.getTime());

        try {
            stmt = conn.prepareStatement("INSERT INTO gestao_hosp.paciente" +  
            "(id, nome, sexo, data_nasc, cpf, plano_saude, created_at, deleted_at)" + 
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, Integer.toString(paciente.getId()));
            stmt.setString(2, paciente.getNome());
            stmt.setString(3, paciente.getSexo());
            stmt.setString(4, paciente.getDataNasc());
            stmt.setString(5, paciente.getCpf());
            stmt.setString(6, paciente.getPlanoSaude());
            stmt.setString(7, now);
            stmt.setString(8, "null");

            stmt.executeUpdate();
            // Print paciente salvo com sucesso
        }
        catch (SQLException ex){
            // PRINT box com Exception ex
        }
        finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }

    public List<Paciente> read() {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Paciente> listaPacientes = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM paciente " + 
            "WHERE paciente.deleted_at IS NOT NULL");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                Paciente paciente = new Paciente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("sexo"),
                    rs.getString("data_nasc"),
                    rs.getString("cpf"),
                    rs.getString("plano_saude"),
                    rs.getString("created_at"),
                    rs.getString("deleted_at")
                );
                listaPacientes.add(paciente);
            }
        }
        catch (SQLException e) {
            // PRINT ERROR FRONT
        }
        finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return listaPacientes;
    }

    public void update(Paciente paciente) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("UPDATE paciente " + 
            "SET nome = ?, sexo = ?, data_nasc = ?, cpf = ?, plano_saude = ? " +
            "WHERE id = ?");
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getSexo());
            stmt.setString(3, paciente.getDataNasc());
            stmt.setString(4, paciente.getCpf());
            stmt.setString(5, paciente.getPlanoSaude());
            stmt.setString(6, Integer.toString(paciente.getId()));
            
            stmt.executeUpdate();
            // Mensagem de update
        }
        catch (SQLException e) {
            // PRINT EXCEPTION NA TELA
        }
        finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }
    // SOFT DELETE
    public void delete(Paciente paciente) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
        // Date date = new Date(timestamp.getTime());
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp.getTime());

        try {
            stmt = conn.prepareStatement("UPDATE paciente " + 
            "SET deleted_at = ? " +
            "WHERE id = ?");
            stmt.setString(1, date);
            stmt.setString(2, Integer.toString(paciente.getId()));
            
            stmt.executeUpdate();
            // Mensagem de update
        }
        catch (SQLException e) {
            // PRINT EXCEPTION NA TELA
        }
        finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }

    public Paciente read(int id) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Paciente paciente = null;
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM paciente " + 
            "WHERE paciente.deleted_at IS NOT NULL " + 
            "AND paciente.id = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            while(rs.next()) {
                paciente = new Paciente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("sexo"),
                    rs.getString("data_nasc"),
                    rs.getString("cpf"),
                    rs.getString("plano_saude"),
                    rs.getString("created_at"),
                    rs.getString("deleted_at")
                );
            }
        }
        catch (SQLException e) {
            // PRINT ERROR FRONT
        }
        finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return paciente;
    }

}
