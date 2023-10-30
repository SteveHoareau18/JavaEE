package fr.stevehoareau18.projetExemple.rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import fr.stevehoareau18.projetExemple.model.Bonbon;

@Path("/bonbons")
@RequestScoped
public class BonbonController {
	
	@GET
	@Path("/fraise")
	public Bonbon getBonbon() {
		Bonbon fraiseTagada = new Bonbon();
		fraiseTagada.setNom("Fraise tagada").setPrix(1.05f).setCalorie(1000f).setIndiceGlycerique(5f);
		
		return fraiseTagada;
	}
}
