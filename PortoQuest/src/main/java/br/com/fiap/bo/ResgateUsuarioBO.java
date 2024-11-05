package br.com.fiap.bo;

import br.com.fiap.dao.ResgateUsuarioDAO;
import br.com.fiap.to.ResgateUsuarioTO;

import java.util.ArrayList;

public class ResgateUsuarioBO {
    private ResgateUsuarioDAO resgateUsuarioDAO;

    public ArrayList<ResgateUsuarioTO> findAll() {
        resgateUsuarioDAO = new ResgateUsuarioDAO();
        return resgateUsuarioDAO.findAll();
    }

    public ResgateUsuarioTO findById(int idUsuario) {
        resgateUsuarioDAO = new ResgateUsuarioDAO();
        return resgateUsuarioDAO.findById(idUsuario);
    }

    public ResgateUsuarioTO save(ResgateUsuarioTO resgateUsuario) {
        resgateUsuarioDAO = new ResgateUsuarioDAO();
        return resgateUsuarioDAO.save(resgateUsuario);
    }

    public boolean delete(int idUsuario) {
        resgateUsuarioDAO = new ResgateUsuarioDAO();
        return resgateUsuarioDAO.delete(idUsuario);
    }

    public ResgateUsuarioTO update(ResgateUsuarioTO resgateUsuario) {
        resgateUsuarioDAO = new ResgateUsuarioDAO();
        return resgateUsuarioDAO.update(resgateUsuario);
    }
    public ArrayList<ResgateUsuarioTO> findAllByUser(int idUsuario) {
        resgateUsuarioDAO = new ResgateUsuarioDAO();
        return resgateUsuarioDAO.findAllByUser(idUsuario);
    }

}
