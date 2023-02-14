package org.acme.Controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.Entity.Personal;
import java.util.List;
import java.util.Optional;

@Path("/personal")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class PersonalController {

    @GET
    @Path("{id}")
    public Personal findPersonalById(@PathParam("id") Long id) {
        return (Personal) Personal.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @GET
    public List<Personal> getAllPersonal() {
        return Personal.listAll();
    }

    @POST
    @Transactional
    public Personal addPersonal(Personal personal) {
        personal.setState(1);
        Personal.persist(personal);
        return personal;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Personal updatePersonal(@PathParam("id") Long id, Personal personal) {
        Optional<Personal> personalById = Optional.ofNullable(findPersonalById(id));
        personalById.orElseThrow(NotFoundException::new);
        Personal perToUpdate = personalById.get();
        if (personal.getName() != null) {
            perToUpdate.setName(personal.getName());}
        if (personal.getLastname() != null) {
            perToUpdate.setLastname(personal.getLastname());}
        if (personal.getEmail() != null) {
            perToUpdate.setEmail(personal.getEmail());}
        if (personal.getDni() != null) {
            perToUpdate.setDni(personal.getDni());}
        if (personal.getPhone() != null) {
            perToUpdate.setPhone(personal.getPhone());}
        if (personal.getState() != null) {
            perToUpdate.setState(personal.getState());}
        Personal.getEntityManager().merge(perToUpdate);
        return personal;
    }


    @DELETE
    @Path("/{id}")
    @Transactional
    public void deletePersonal(@PathParam("id") Long id) {

        Optional<Personal> personalById = Optional.ofNullable(findPersonalById(id));
        personalById.orElseThrow(NotFoundException::new);
        Personal perToUpdate = personalById.get();
        perToUpdate.setState(0);
        Personal.getEntityManager().merge(perToUpdate);
    }
}
