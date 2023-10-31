package fr.stevehoareau18.projetExemple.rest;

import java.util.List;

import fr.stevehoareau18.projetExemple.model.Bonbon;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;


@Path("/bonbons")
@RequestScoped
@Transactional
public class BonbonController {
	
	@PersistenceContext(unitName = "JEEDSPU")
	private EntityManager em;
	
	@POST
	@Produces("application/json")
	public Response create(Bonbon bonbon) {
		
		em.persist(bonbon);
		
		return Response.status(201).entity(bonbon).build();
	}
	
	@GET
	@Produces("application/json")
	public List<Bonbon> getAll() {
		
		return em.createQuery("select b from Bonbon as b", Bonbon.class).getResultList();
	}
	
	@GET
	@Produces("application/json")
	@Path("/{id}")
	public Response get(@PathParam("id") Long id) {
		Bonbon bonbon = em.find(Bonbon.class, id);
		if(bonbon==null) return Response.status(404).build();
		return Response.ok(bonbon).build();
	}
	
	@PUT
	@Produces("application/json")
	public Response update(Bonbon bonbon) {
		
		em.merge(bonbon);
		
		return Response.ok(bonbon).status(202).build();
	}
}
