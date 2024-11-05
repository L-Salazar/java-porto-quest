package br.com.fiap.dao;

import br.com.fiap.to.VeiculoTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VeiculoDAO extends Repository{

    public ArrayList<VeiculoTO> findAll() {
        ArrayList<VeiculoTO> veiculos = new ArrayList<VeiculoTO>();
        String sql = "SELECT * FROM t_pq_veiculo ORDER BY id_veiculo";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                VeiculoTO veiculo = new VeiculoTO();
                veiculo.setIdVeiculo(rs.getInt("id_veiculo"));
                veiculo.setPlaca(rs.getString("nr_placa"));
                veiculo.setMarca(rs.getString("nm_marca"));
                veiculo.setModelo(rs.getString("nm_modelo"));
                veiculo.setAnoFabricacao(rs.getInt("nr_ano_fabricacao"));
                veiculo.setIdUsuario(rs.getInt("id_usuario"));

                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar veículos: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return veiculos;
    }

    public VeiculoTO findById(int idVeiculo) {
        VeiculoTO veiculo = new VeiculoTO();
        String sql = "SELECT * FROM t_pq_veiculo WHERE id_veiculo = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idVeiculo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                veiculo.setIdVeiculo(rs.getInt("id_veiculo"));
                veiculo.setPlaca(rs.getString("nr_placa"));
                veiculo.setMarca(rs.getString("nm_marca"));
                veiculo.setModelo(rs.getString("nm_modelo"));
                veiculo.setAnoFabricacao(rs.getInt("nr_ano_fabricacao"));
                veiculo.setIdUsuario(rs.getInt("id_usuario"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar veículo: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return veiculo;
    }

    public VeiculoTO save(VeiculoTO veiculo) {
        String sql = "INSERT INTO t_pq_veiculo (placa, marca, modelo, ano_fabricacao, id_usuario) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getMarca());
            ps.setString(3, veiculo.getModelo());
            ps.setInt(4, veiculo.getAnoFabricacao());
            ps.setInt(5, veiculo.getIdUsuario());

            if(ps.executeUpdate() > 0) {
                return veiculo;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar veículo: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return null;
    }

    public boolean delete(int idVeiculo) {
        String sql = "DELETE FROM t_pq_veiculo WHERE id_veiculo = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, idVeiculo);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar veículo: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return false;
    }

    public VeiculoTO update(VeiculoTO veiculo) {
        String sql = "UPDATE t_pq_veiculo SET nr_placa = ?, nm_marca = ?, nm_modelo = ?, nr_ano_fabricacao = ?, id_usuario = ? WHERE id_veiculo = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getMarca());
            ps.setString(3, veiculo.getModelo());
            ps.setInt(4, veiculo.getAnoFabricacao());
            ps.setInt(5, veiculo.getIdUsuario());
            ps.setInt(6, veiculo.getIdVeiculo());

            if(ps.executeUpdate() > 0) {
                return veiculo;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar veículo: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return null;
    }

}
