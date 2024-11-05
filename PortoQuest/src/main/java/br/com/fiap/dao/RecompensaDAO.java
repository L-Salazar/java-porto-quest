package br.com.fiap.dao;

import br.com.fiap.to.RecompensaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RecompensaDAO extends Repository {

    public ArrayList<RecompensaTO> findAll() {
        ArrayList<RecompensaTO> recompensas = new ArrayList<RecompensaTO>();
        String sql = "SELECT * FROM t_pq_recompensa ORDER BY vl_estrelas";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                while (rs.next()) {
                    RecompensaTO recompensa = new RecompensaTO();
                    recompensa.setIdRecompensa(rs.getInt("id_recompensa"));
                    recompensa.setDescricao(rs.getString("ds_recompensa"));
                    recompensa.setValorEmEstrelas(rs.getInt("vl_estrelas"));
                    recompensa.setQrCode(rs.getString("qr_code_recompensa"));

                    recompensas.add(recompensa);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar recompensas: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return recompensas;
    }

    public RecompensaTO findById(int idRecompensa) {
        RecompensaTO recompensa = new RecompensaTO();
        String sql = "SELECT * FROM t_pq_recompensa WHERE id_recompensa = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idRecompensa);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                recompensa.setIdRecompensa(rs.getInt("id_recompensa"));
                recompensa.setDescricao(rs.getString("ds_recompensa"));
                recompensa.setValorEmEstrelas(rs.getInt("vl_estrelas"));
                recompensa.setQrCode(rs.getString("qr_code_recompensa"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar recompensa: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return recompensa;
    }
    public RecompensaTO save(RecompensaTO recompensa) {
        String sql = "INSERT INTO t_pq_recompensa (ds_recompensa, vl_estrelas, qr_code_recompensa) VALUES (?,?,?)";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, recompensa.getDescricao());
            ps.setInt(2, recompensa.getValorEmEstrelas());
            ps.setString(3, recompensa.getQrCode());

            if(ps.executeUpdate() > 0) {
                return recompensa;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar recompensa: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return null;
    }

    public RecompensaTO update(RecompensaTO recompensa) {
        String sql = "UPDATE t_pq_recompensa SET ds_recompensa = ?, vl_estrelas = ?, qr_code_recompensa = ? WHERE id_recompensa = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, recompensa.getDescricao());
            ps.setInt(2, recompensa.getValorEmEstrelas());
            ps.setString(3, recompensa.getQrCode());
            ps.setInt(4, recompensa.getIdRecompensa());

            if(ps.executeUpdate() > 0) {
                return recompensa;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar recompensa: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return null;
    }

    public boolean delete(int idRecompensa) {
        String sql = "DELETE FROM t_pq_recompensa WHERE id_recompensa = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idRecompensa);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar recompensa: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return false;
    }

}
