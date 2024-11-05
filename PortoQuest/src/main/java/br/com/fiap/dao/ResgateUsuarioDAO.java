package br.com.fiap.dao;

import br.com.fiap.to.ResgateUsuarioTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResgateUsuarioDAO extends Repository {

    public ArrayList<ResgateUsuarioTO> findAll() {
        ArrayList<ResgateUsuarioTO> resgates = new ArrayList<>();
        String sql = "SELECT * FROM t_pq_resgate_recompensa ORDER BY id_resgate";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ResgateUsuarioTO resgate = new ResgateUsuarioTO();
                resgate.setIdResgate(rs.getInt("id_resgate"));
                resgate.setIdUsuario(rs.getInt("id_usuario"));
                resgate.setIdRecompensa(rs.getInt("id_recompensa"));
                resgate.setDtResgate(rs.getDate("dt_resgate").toLocalDate());
                resgate.setQtPontosUtilizados(rs.getInt("qt_pontos_utilizados"));
                resgate.setDescricaoRecompensa(rs.getString("ds_recompensa"));

                resgates.add(resgate);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar resgates: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return resgates;
    }

    public ArrayList<ResgateUsuarioTO> findAllByUser(int idUsuario) {
        ArrayList<ResgateUsuarioTO> resgates = new ArrayList<>();
        String sql = "SELECT * FROM t_pq_resgate_recompensa WHERE id_usuario = ? ORDER BY id_resgate";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ResgateUsuarioTO resgate = new ResgateUsuarioTO();
                resgate.setIdResgate(rs.getInt("id_resgate"));
                resgate.setIdUsuario(rs.getInt("id_usuario"));
                resgate.setIdRecompensa(rs.getInt("id_recompensa"));
                resgate.setDtResgate(rs.getDate("dt_resgate").toLocalDate());
                resgate.setQtPontosUtilizados(rs.getInt("qt_pontos_utilizados"));
                resgate.setDescricaoRecompensa(rs.getString("ds_recompensa"));

                resgates.add(resgate);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar resgates: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return resgates;
    }

    public ResgateUsuarioTO findById(int idUsuario) {
        ResgateUsuarioTO resgate = new ResgateUsuarioTO();
        String sql = "SELECT * FROM t_pq_resgate_recompensa WHERE id_usuario = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idUsuario);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                resgate.setIdResgate(rs.getInt("id_resgate"));
                resgate.setIdUsuario(rs.getInt("id_usuario"));
                resgate.setIdRecompensa(rs.getInt("id_recompensa"));
                resgate.setDtResgate(rs.getDate("dt_resgate").toLocalDate());
                resgate.setQtPontosUtilizados(rs.getInt("qt_pontos_utilizados"));
                resgate.setDescricaoRecompensa(rs.getString("ds_recompensa"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar resgate: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return resgate;
    }



    public ResgateUsuarioTO save(ResgateUsuarioTO resgate) {
        String sql = "INSERT INTO t_pq_resgate_recompensa (id_usuario, id_recompensa, dt_resgate, qt_pontos_utilizados, ds_recompensa) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, resgate.getIdUsuario());
            ps.setInt(2, resgate.getIdRecompensa());
            ps.setDate(3, java.sql.Date.valueOf(resgate.getDtResgate()));
            ps.setInt(4, resgate.getQtPontosUtilizados());
            ps.setString(5, resgate.getDescricaoRecompensa());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar resgate: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return resgate;
    }

    public ResgateUsuarioTO update(ResgateUsuarioTO resgate) {
        String sql = "UPDATE t_pq_resgate_recompensa SET id_usuario = ?, id_recompensa = ?, dt_resgate = ?, qt_pontos_utilizados, ds_recompensa = ? WHERE id_resgate = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, resgate.getIdUsuario());
            ps.setInt(2, resgate.getIdRecompensa());
            ps.setDate(3, java.sql.Date.valueOf(resgate.getDtResgate()));
            ps.setInt(4, resgate.getQtPontosUtilizados());
            ps.setString(5, resgate.getDescricaoRecompensa());
            ps.setInt(6, resgate.getIdResgate());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar resgate: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return resgate;
    }

    public boolean delete(int idResgate) {
        String sql = "DELETE FROM t_pq_resgate_recompensa WHERE id_resgate = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idResgate);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar resgate: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return false;
    }

}
