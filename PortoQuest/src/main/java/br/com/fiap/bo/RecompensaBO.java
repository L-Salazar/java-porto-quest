package br.com.fiap.bo;

import br.com.fiap.dao.RecompensaDAO;
import br.com.fiap.to.RecompensaTO;

import java.util.ArrayList;

public class RecompensaBO {

    private RecompensaDAO recompensaDAO;

    public ArrayList<RecompensaTO> findAll() {
        recompensaDAO = new RecompensaDAO();
        return recompensaDAO.findAll();
    }

    public RecompensaTO findById(int id) {
        recompensaDAO = new RecompensaDAO();
        return recompensaDAO.findById(id);
    }

    public RecompensaTO save(RecompensaTO recompensa) {
        recompensaDAO = new RecompensaDAO();
        return recompensaDAO.save(recompensa);
    }

    public boolean delete(int id) {
        recompensaDAO = new RecompensaDAO();
        return recompensaDAO.delete(id);
    }

    public RecompensaTO update(RecompensaTO recompensa) {
        recompensaDAO = new RecompensaDAO();
        return recompensaDAO.update(recompensa);
    }

}
