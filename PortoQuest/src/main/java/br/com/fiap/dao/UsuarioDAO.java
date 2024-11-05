package br.com.fiap.dao;

import br.com.fiap.to.UsuarioTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UsuarioDAO extends Repository {

    public ArrayList<UsuarioTO> findAll() {
        ArrayList<UsuarioTO> usuarios = new ArrayList<UsuarioTO>();
        String sql = "SELECT * FROM t_pq_usuario ORDER BY id_usuario";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            if(rs != null) {
                while (rs.next()) {
                    UsuarioTO usuario = new UsuarioTO();
                    usuario.setIdUsuario(rs.getInt("id_usuario"));
                    usuario.setTotalPontos(rs.getInt("qt_total_pontos"));
                    usuario.setClientePorto(rs.getString("st_cliente_porto") == "S");
                    usuario.setCpf(rs.getString("nr_cpf"));
                    usuario.setNome(rs.getString("nm_usuario"));
                    usuario.setEmail(rs.getString("ds_email"));
                    usuarios.add(usuario);
                }
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuários: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return usuarios;
    }

    public UsuarioTO findById(int id) {
        UsuarioTO usuario = new UsuarioTO();
        String sql = "SELECT * FROM t_pq_usuario WHERE id_usuario = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setTotalPontos(rs.getInt("qt_total_pontos"));
                usuario.setClientePorto(rs.getString("st_cliente_porto") == "S");
                usuario.setCpf(rs.getString("nr_cpf"));
                usuario.setNome(rs.getString("nm_usuario"));
                usuario.setEmail(rs.getString("ds_email"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar usuário: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return usuario;
    }

    public UsuarioTO save(UsuarioTO usuario) {
        String sql = "INSERT INTO t_pq_usuario (qt_total_pontos, cliente_porto, nr_cpf, nm_usuario, ds_email) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, usuario.getTotalPontos());
            ps.setInt(2, usuario.isClientePorto() ? 1 : 0);
            ps.setString(3, usuario.getCpf());
            ps.setString(4, usuario.getNome());
            ps.setString(5, usuario.getEmail());
            if(ps.executeUpdate() > 0) {
                return usuario;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar usuário: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return null;
    }

    public boolean delete(int id) {
        String sql = "DELETE FROM t_pq_usuario WHERE id_usuario = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar usuário: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return false;
    }

    public UsuarioTO update(UsuarioTO usuario) {
        String sql = "UPDATE t_pq_usuario qt_total_pontos = ?, cliente_porto = ?, nr_cpf = ?, nm_usuario = ?, ds_email = ? WHERE id_usuario = ?";

        try (PreparedStatement ps = getConnection().prepareStatement(sql)) {
            ps.setInt(1, usuario.getTotalPontos());
            ps.setInt(2, usuario.isClientePorto() ? 1 : 0);
            ps.setString(3, usuario.getCpf());
            ps.setString(4, usuario.getNome());
            ps.setString(5, usuario.getEmail());
            ps.setInt(6, usuario.getIdUsuario());
            if(ps.executeUpdate() > 0) {
                return usuario;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar usuário: " + e.getMessage());
        } finally {
            closeConnection();
        }

        return null;
    }

}

