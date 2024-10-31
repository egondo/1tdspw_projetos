package br.com.fiap;

import br.com.fiap.model.Atendimento;
import br.com.fiap.model.Paciente;
import br.com.fiap.model.Triagem;
import br.com.fiap.negocio.BusinessPS;
import br.com.fiap.util.*;
import com.google.gson.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.lang.reflect.Type;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Path("ps")
public class ProntoSocorroResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("paciente")
    public Response cadastraPaciente(PacienteTO pac) {
        BusinessPS neg = new BusinessPS();
        try {
            neg.cadastraPaciente(pac.toPaciente());
            return Response.status(201).entity(pac).build();
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(406).entity(e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("triagem")
    public Response cadastraTriagem(TriagemTO tri) {
        BusinessPS neg = new BusinessPS();
        try {
            neg.cadastraTriagem(tri.toTriagem());
            return Response.status(201).entity(tri).build();
        }
        catch(Exception e) {
            e.printStackTrace();
            return Response.status(406).entity(e.getMessage()).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("atendimento")
    public Response cadastraAtendimento(AtendimentoTO ate) {
        BusinessPS neg = new BusinessPS();
        try {
            neg.cadastraAtendimento(ate.toAtendimento());
            return Response.status(201).entity(ate).build();
        }
        catch(Exception e) {
            e.printStackTrace();
            return Response.status(406).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("prontuario/paciente/{id}")
    public Response recuperaProntuario(@PathParam("id") long id) {
        BusinessPS neg = new BusinessPS();
        try {
            Paciente p = new Paciente();
            p.setId(id);
            Prontuario pront = neg.recuperaTratamento(p);

            ProntuarioTO prontuario = pront.toProntuarioTO();

            //Gson gson = new Gson();
            return Response.ok(prontuario).build();
        }
        catch (Exception e) {
            e.printStackTrace();
            return Response.status(406).entity(e.getMessage()).build();
        }
    }
}
