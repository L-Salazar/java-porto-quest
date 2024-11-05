package br.com.fiap.dao;

import br.com.fiap.to.OficinaParceiraTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OficinaParceiraDAO extends Repository{

    public ArrayList<OficinaParceiraTO> findAll() {
        ArrayList<OficinaParceiraTO> oficinasParceiras = new ArrayList<OficinaParceiraTO>();
        String sql = "SELECT * FROM t_pq_oficina_parceira ORDER BY id_oficina_parceira";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                OficinaParceiraTO oficinaParceira = new OficinaParceiraTO();
                oficinaParceira.setIdOficina(rs.getInt("id_oficina_parceira"));
                oficinaParceira.setUrlBanner(rs.getString("url_banner"));
                oficinaParceira.setNome(rs.getString("nm_oficina_parceira"));
                oficinaParceira.setPrioridade(rs.getInt("nr_prioridade"));

                oficinasParceiras.add(oficinaParceira);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar oficinas parceiras: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return oficinasParceiras;
    }

    public OficinaParceiraTO findById(int idOficinaParceira) {
        OficinaParceiraTO oficinaParceira = new OficinaParceiraTO();
        String sql = "SELECT * FROM t_pq_oficina_parceira WHERE id_oficina_parceira = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idOficinaParceira);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                oficinaParceira.setIdOficina(rs.getInt("id_oficina_parceira"));
                oficinaParceira.setUrlBanner(rs.getString("url_banner"));
                oficinaParceira.setNome(rs.getString("nm_oficina_parceira"));
                oficinaParceira.setPrioridade(rs.getInt("nr_prioridade"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar oficina parceira: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return oficinaParceira;
    }

    public OficinaParceiraTO save(OficinaParceiraTO oficinaParceira) {
        String sql = "INSERT INTO t_pq_oficina_parceira (url_banner, nm_oficina_parceira, nr_prioridade) VALUES (?, ?, ?)";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, oficinaParceira.getUrlBanner());
            ps.setString(2, oficinaParceira.getNome());
            ps.setInt(3, oficinaParceira.getPrioridade());
            if(ps.executeUpdate() > 0) {
                return oficinaParceira;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar oficina parceira: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return null;
    }

    public boolean delete(int idOficinaParceira) {
        String sql = "DELETE FROM t_pq_oficina_parceira WHERE id_oficina_parceira = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idOficinaParceira);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar oficina parceira: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return false;
    }

    public OficinaParceiraTO update(OficinaParceiraTO oficinaParceira) {
        String sql = "UPDATE t_pq_oficina_parceira SET url_banner = ?, nm_oficina_parceira = ?, nr_prioridade = ? WHERE id_oficina_parceira = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, oficinaParceira.getUrlBanner());
            ps.setString(2, oficinaParceira.getNome());
            ps.setInt(3, oficinaParceira.getPrioridade());
            ps.setInt(4, oficinaParceira.getIdOficina());
            if(ps.executeUpdate() > 0) {
                return oficinaParceira;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar oficina parceira: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return null;
    }

}
