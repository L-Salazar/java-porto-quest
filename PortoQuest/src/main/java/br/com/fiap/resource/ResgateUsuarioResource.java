package br.com.fiap.resource;


import br.com.fiap.bo.ResgateUsuarioBO;
import br.com.fiap.to.ResgateUsuarioTO;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/resgate-usuario")
public class ResgateUsuarioResource {

    ResgateUsuarioBO resgateUsuarioBO = new ResgateUsuarioBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<ResgateUsuarioTO> resultado = resgateUsuarioBO.findAll();
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
    public Response findById(@PathParam("id") int id) {
        ArrayList resultado = resgateUsuarioBO.findAllByUser(id);
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
    public Response save(@Valid ResgateUsuarioTO resgateUsuario) {
        ResgateUsuarioTO resultado = resgateUsuarioBO.save(resgateUsuario);
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
    public Response delete(@PathParam("id") int id) {
        Response.ResponseBuilder response = null;
        if (resgateUsuarioBO.delete(id)) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, ResgateUsuarioTO resgateUsuario) {
        resgateUsuario.setIdResgate(id);
        ResgateUsuarioTO resultado = resgateUsuarioBO.update(resgateUsuario);
        Response.ResponseBuilder response = null;
        if (resultado != null) {
            response = Response.ok();
        } else {
            response = Response.status(404);
        }
        response.entity(resultado);
        return response.build();
    }

}
