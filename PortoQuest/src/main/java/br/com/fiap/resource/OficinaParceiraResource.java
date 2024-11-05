package br.com.fiap.resource;

import br.com.fiap.bo.OficinaParceiraBO;
import br.com.fiap.to.OficinaParceiraTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/oficinas")
public class OficinaParceiraResource {

    private OficinaParceiraBO oficinaParceiraBO = new OficinaParceiraBO();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<OficinaParceiraTO> resultado = oficinaParceiraBO.findAll();
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(int id) {
        OficinaParceiraTO resultado = oficinaParceiraBO.findById(id);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@Valid OficinaParceiraTO oficinaParceira) {
        OficinaParceiraTO resultado = oficinaParceiraBO.save(oficinaParceira);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(int id) {
        Response.ResponseBuilder response = null;
        if (oficinaParceiraBO.delete(id)) {
            response = Response.status(204);
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(OficinaParceiraTO oficinaParceira, @PathParam("id") int id) {
        oficinaParceira.setIdOficina(id);
        OficinaParceiraTO resultado = oficinaParceiraBO.update(oficinaParceira);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.created(null);
        } else {
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }

}
