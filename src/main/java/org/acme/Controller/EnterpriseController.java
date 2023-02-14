package org.acme.Controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.Entity.Enterprise;

import java.util.List;
import java.util.Optional;

@Path("/enterprise")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class EnterpriseController {

    @GET
    @Path("{id}")
    public Enterprise findEnterpriseById(@PathParam("id") Long id) {
        return (Enterprise) Enterprise.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @GET
    public List<Enterprise> getAllEnterprise() {
        return Enterprise.listAll();
    }

    @POST
    @Transactional
    public Enterprise addEnterprise(Enterprise enterprise) {
        enterprise.setState(1);
        Enterprise.persist(enterprise);
        return enterprise;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Enterprise updateEnterprise(@PathParam("id") Long id, Enterprise enterprise) {
        Optional<Enterprise> enterpriseById = Optional.ofNullable(findEnterpriseById(id));
        enterpriseById.orElseThrow(NotFoundException::new);
        Enterprise entToUpdate = enterpriseById.get();
        if (enterprise.getName() != null) {
            entToUpdate.setName(enterprise.getName());}
        if (enterprise.getEmail() != null) {
            entToUpdate.setEmail(enterprise.getEmail());}
        if (enterprise.getRuc() != null) {
            entToUpdate.setRuc(enterprise.getRuc());}
        if (enterprise.getPhone() != null) {
            entToUpdate.setPhone(enterprise.getPhone());}
        if (enterprise.getState() != null) {
            entToUpdate.setState(enterprise.getState());}
        Enterprise.getEntityManager().merge(entToUpdate);
        return enterprise;
    }


    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteEnterprise(@PathParam("id") Long id) {

        Optional<Enterprise> enterpriseById = Optional.ofNullable(findEnterpriseById(id));
        enterpriseById.orElseThrow(NotFoundException::new);
        Enterprise entToUpdate = enterpriseById.get();
        entToUpdate.setState(0);
        Enterprise.getEntityManager().merge(entToUpdate);
    }
}
