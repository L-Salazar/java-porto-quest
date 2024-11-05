package br.com.fiap.dao;

import br.com.fiap.to.PecaTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PecaDAO extends Repository {

    public ArrayList<PecaTO> findAll() {
        ArrayList<PecaTO> pecas = new ArrayList<PecaTO>();
        String sql = "SELECT * FROM t_pq_peca ORDER BY id_peca";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PecaTO peca = new PecaTO();
                peca.setIdPeca(rs.getInt("id_peca"));
                peca.setNomePeca(rs.getString("nm_peca"));
                peca.setCodigoPeca(rs.getString("cd_peca"));
                peca.setDescricacoPeca(rs.getString("ds_peca"));
                peca.setValorUnitario(rs.getDouble("vl_unitario"));
                pecas.add(peca);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar peças: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return pecas;
    }

    public PecaTO findById(int idPeca) {
        PecaTO peca = new PecaTO();
        String sql = "SELECT * FROM t_pq_peca WHERE id_peca = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idPeca);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                peca.setIdPeca(rs.getInt("id_peca"));
                peca.setNomePeca(rs.getString("nm_peca"));
                peca.setCodigoPeca(rs.getString("cd_peca"));
                peca.setDescricacoPeca(rs.getString("ds_peca"));
                peca.setValorUnitario(rs.getDouble("vl_unitario"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar peça: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return peca;
    }

    public PecaTO save(PecaTO peca) {
        String sql = "INSERT INTO t_pq_peca (nm_peca, cd_peca, ds_peca, vl_unitario) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, peca.getNomePeca());
            ps.setString(2, peca.getCodigoPeca());
            ps.setString(3, peca.getDescricacoPeca());
            ps.setDouble(4, peca.getValorUnitario());
            if(ps.executeUpdate() > 0) {
                return peca;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar peça: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }

    public boolean delete(int idPeca) {
        String sql = "DELETE FROM t_pq_peca WHERE id_peca = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idPeca);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar peça: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return false;
    }

    public PecaTO update(PecaTO peca) {
        String sql = "UPDATE t_pq_peca SET nm_peca = ?, cd_peca = ?, ds_peca = ?, vl_unitario = ? WHERE id_peca = ?";
        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, peca.getNomePeca());
            ps.setString(2, peca.getCodigoPeca());
            ps.setString(3, peca.getDescricacoPeca());
            ps.setDouble(4, peca.getValorUnitario());
            ps.setInt(5, peca.getIdPeca());
            if(ps.executeUpdate() > 0) {
                return peca;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar peça: " + e.getMessage());
        } finally {
            closeConnection();
        }
        return null;
    }


}
