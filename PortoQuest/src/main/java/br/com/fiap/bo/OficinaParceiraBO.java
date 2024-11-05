package br.com.fiap.bo;

import br.com.fiap.dao.OficinaParceiraDAO;
import br.com.fiap.to.OficinaParceiraTO;

import java.util.ArrayList;

public class OficinaParceiraBO {

    private OficinaParceiraDAO oficinaParceiraDAO;

    public ArrayList<OficinaParceiraTO> findAll() {
        oficinaParceiraDAO = new OficinaParceiraDAO();
        return oficinaParceiraDAO.findAll();
    }

    public OficinaParceiraTO findById(int id) {
        oficinaParceiraDAO = new OficinaParceiraDAO();
        return oficinaParceiraDAO.findById(id);
    }

    public OficinaParceiraTO save(OficinaParceiraTO oficinaParceira) {
        oficinaParceiraDAO = new OficinaParceiraDAO();
        return oficinaParceiraDAO.save(oficinaParceira);
    }

    public boolean delete(int id) {
        oficinaParceiraDAO = new OficinaParceiraDAO();
        return oficinaParceiraDAO.delete(id);
    }

    public OficinaParceiraTO update(OficinaParceiraTO oficinaParceira) {
        oficinaParceiraDAO = new OficinaParceiraDAO();
        return oficinaParceiraDAO.update(oficinaParceira);
    }

}
