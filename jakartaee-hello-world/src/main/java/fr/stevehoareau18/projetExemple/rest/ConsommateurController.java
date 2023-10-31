package fr.stevehoareau18.projetExemple.rest;

import java.util.List;

import fr.stevehoareau18.projetExemple.model.Bonbon;
import fr.stevehoareau18.projetExemple.model.Consommateur;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("/consommateurs")
@RequestScoped
@Transactional
public class ConsommateurController {

	@PersistenceContext(unitName = "JEEDSPU")
	private EntityManager em;
	
	@POST
	@Produces("application/json")
	public Response create(Consommateur consommateur) {
		
		em.persist(consommateur);
		
		return Response.status(201).entity(consommateur).build();
	}
	
	@GET
	@Produces("application/json")
	public List<Consommateur> getAll() {
		
		return em.createQuery("select c from Consommateur as c", Consommateur.class).getResultList();
	}
	
	@GET
	@Produces("application/json")
	@Path("/{id}")
	public Response get(@PathParam("id") Long id) {
		Consommateur consommateur = em.find(Consommateur.class, id);
		if(consommateur==null) return Response.status(404).build();
		return Response.ok(consommateur).build();
	}
	
	@PUT
	@Produces("application/json")
	public Response update(Consommateur consommateur) {
		
		em.merge(consommateur);
		
		return Response.ok(consommateur).status(202).build();
	}
	
	@POST
	@Produces("application/json")
	@Path("/ajouter-bonbon/{bonbonId}")
	public Response addBonbon(Consommateur consommateur, @PathParam("bonbonId") Long bonbonId) {
		consommateur = em.find(Consommateur.class, consommateur.getId());
		if(consommateur==null) return Response.status(404).build();
		
		Bonbon bonbon = em.find(Bonbon.class, bonbonId);
		if(bonbon==null) return Response.status(404).build();
		
		consommateur.addBonbon(bonbon);
		
		em.merge(consommateur);
		
		return Response.ok(consommateur).status(202).build();
	}
}