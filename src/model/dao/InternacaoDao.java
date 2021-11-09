package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionFactory;
import model.Internacao;

public class InternacaoDao {
    
    public void create(Internacao internacao) {
        Connection conn = ConnectionFactory.getConnection(); 
        PreparedStatement stmt = null;

        java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
        // Date date = new Date(timestamp.getTime());
        String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp.getTime());

        try {
            stmt = conn.prepareStatement("INSERT INTO internacao" +  
            "(id, paciente_id, data_entrada, data_saida, causa, quarto, created_at, deleted_at)" + 
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, Integer.toString(internacao.getId()));
            stmt.setString(2, Integer.toString(internacao.getPacienteId()));
            stmt.setString(3, internacao.getDataEntrada());
            stmt.setString(4, internacao.getDataSaida());
            stmt.setString(5, internacao.getCausa());
            stmt.setString(6, internacao.getQuarto());
            stmt.setString(7, now);
            stmt.setString(8, "null");

            stmt.executeUpdate();
            // Print internacao salvo com sucesso
        }
        catch (SQLException ex){
            // PRINT box com Exception ex
        }
        finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
    }

    public List<Internacao> read() {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Internacao> listaInternacoes = new ArrayList<>();
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM internacao " + 
            "WHERE internacao.deleted_at IS NOT NULL");
            rs = stmt.executeQuery();
            
            while (rs.next()){
                Internacao internacao = new Internacao(
                    rs.getInt("id"),
                    rs.getInt("paciente_id"),
                    rs.getString("data_entrada"),
                    rs.getString("data_saida"),
                    rs.getString("causa"),
                    rs.getString("quarto"),
                    rs.getString("created_at"),
                    rs.getString("deleted_at")
                );
                listaInternacoes.add(internacao);
            }
        }
        catch (SQLException e) {
            // PRINT ERROR FRONT
        }
        finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return listaInternacoes;
    }

    public void update(Internacao internacao) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("UPDATE internacao " + 
            "SET data_entrada = ? data_saida = ? causa = ? quarto = ? " +
            "WHERE id = ?");
            stmt.setString(1, internacao.getDataEntrada());
            stmt.setString(2, internacao.getDataSaida());
            stmt.setString(3, internacao.getCausa());
            stmt.setString(4, internacao.getQuarto());
            stmt.setString(5, Integer.toString(internacao.getId()));
            
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
    public void delete(Internacao internacao) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        java.sql.Timestamp timestamp = new java.sql.Timestamp(System.currentTimeMillis());
        // Date date = new Date(timestamp.getTime());
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp.getTime());

        try {
            stmt = conn.prepareStatement("UPDATE internacao " + 
            "SET deleted_at = ? " +
            "WHERE id = ?");
            stmt.setString(1, date);
            stmt.setString(2, Integer.toString(internacao.getId()));
            
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

    public Internacao read(int id) {
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Internacao internacao = null;
        
        try {
            stmt = conn.prepareStatement("SELECT * FROM internacao " + 
            "WHERE internacao.deleted_at IS NOT NULL " + 
            "AND internacao.id = ?");
            stmt.setInt(1, id);

            rs = stmt.executeQuery();
            while(rs.next()) {
                internacao = new Internacao(
                    rs.getInt("id"),
                    rs.getInt("paciente_id"),
                    rs.getString("data_entrada"),
                    rs.getString("data_saida"),
                    rs.getString("causa"),
                    rs.getString("quarto"),
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
        return internacao;
    }

}
