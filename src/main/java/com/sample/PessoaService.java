package com.sample;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class PessoaService extends DbConnection {

    public boolean Salvar(PessoaModel pessoa) {
        String sql = "INSERT INTO pessoas (nome, data_nascimento, id_tipo_pessoa) VALUES (?, ?, ?)";
        try {
            PreparedStatement stmt = Connect().prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setDate(2, Date.valueOf(pessoa.getDataNascimento()));
            stmt.setInt(3, pessoa.getTipo());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } finally {
            Disconnect();
        }
    }

    public boolean Remover(int id) {
        String sql = "DELETE FROM pessoas WHERE id = ?";
        try {
            PreparedStatement stmt = Connect().prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } finally {
            Disconnect();
        }
    }

    public boolean Atualizar(PessoaModel pessoa) {
        String sql = "UPDATE pessoas SET nome = ?, data_nascimento = ?, id_tipo_pessoa = ? WHERE id = ?";
        try {
            PreparedStatement stmt = Connect().prepareStatement(sql);
            stmt.setString(1, pessoa.getNome());
            stmt.setDate(2, Date.valueOf(pessoa.getDataNascimento()));
            stmt.setInt(3, pessoa.getTipo());
            stmt.setInt(4, pessoa.getId());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } finally {
            Disconnect();
        }
    }

    public PessoaModel Ler(int id) {
        String sql = "SELECT * FROM pessoas WHERE id = ?";
        try {
            PreparedStatement stmt = Connect().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet result = stmt.executeQuery();

            PessoaModel pessoa = new PessoaModel();
            while (result.next()) {
                pessoa.setId(result.getInt("id"));
                pessoa.setNome(result.getString("nome"));
                pessoa.setDataNascimento(result.getDate("data_nascimento").toLocalDate());
                pessoa.setTipo(result.getInt("id_tipo_pessoa"));
            }

            return pessoa;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        } finally {
            Disconnect();
        }
    }
}