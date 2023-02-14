package org.acme.Controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.Entity.CreditCard;

import java.util.List;
import java.util.Optional;

@Path("/creditcard")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class CreditCardController {

    @GET
    @Path("{id}")
    public CreditCard findCreditCardById(@PathParam("id") Long id) {
        return (CreditCard) CreditCard.findByIdOptional(id).orElseThrow(NotFoundException::new);
    }

    @GET
    public List<CreditCard> getAllCreditCard() {
        return CreditCard.listAll();
    }

    @POST
    @Transactional
    public CreditCard addCreditCard(CreditCard creditCard) {
        creditCard.setState(1);
        CreditCard.persist(creditCard);
        return creditCard;
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public CreditCard updateCreditCard(@PathParam("id") Long id, CreditCard creditCard) {
        Optional<CreditCard> creditCardById = Optional.ofNullable(findCreditCardById(id));
        creditCardById.orElseThrow(NotFoundException::new);
        CreditCard credToUpdate = creditCardById.get();
        if (creditCard.getCardnumber() != null) {
            credToUpdate.setCardnumber(creditCard.getCardnumber());}
        if (creditCard.getIdclient() != null) {
            credToUpdate.setIdclient(creditCard.getIdclient());}
        if (creditCard.getPin() != null) {
            credToUpdate.setPin(creditCard.getPin());}
        if (creditCard.getExpirationdate() != null) {
            credToUpdate.setExpirationdate(creditCard.getExpirationdate());}
        if (creditCard.getValidationcode() != null) {
            credToUpdate.setValidationcode(creditCard.getValidationcode());}
        if (creditCard.getCutoffdate() != null) {
            credToUpdate.setCutoffdate(creditCard.getCutoffdate());}
        if (creditCard.getMonthlypaydate() != null) {
            credToUpdate.setMonthlypaydate(creditCard.getMonthlypaydate());}
        if (creditCard.getCurrentbalance() != null) {
            credToUpdate.setCurrentbalance(creditCard.getCurrentbalance());}
        if (creditCard.getCreditlimit() != null) {
            credToUpdate.setCreditlimit(creditCard.getCreditlimit());}
        if (creditCard.getState() != null) {
            credToUpdate.setState(creditCard.getState());}
        CreditCard.getEntityManager().merge(credToUpdate);
        return creditCard;
    }


    @DELETE
    @Path("/{id}")
    @Transactional
    public void deleteCreditCard(@PathParam("id") Long id) {

        Optional<CreditCard> creditCardById = Optional.ofNullable(findCreditCardById(id));
        creditCardById.orElseThrow(NotFoundException::new);
        CreditCard credToUpdate = creditCardById.get();
        credToUpdate.setState(0);
        CreditCard.getEntityManager().merge(credToUpdate);
    }
}
