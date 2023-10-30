package fr.stevehoareau18.projetExemple.rest;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import fr.stevehoareau18.projetExemple.model.Bonbon;

@Path("/bonbons")
@RequestScoped
public class BonbonController {
	
	@GET
	@Path("/fraises")
	public Bonbon getBonbon() {
		Bonbon fraiseTagada = new Bonbon();
		fraiseTagada.setNom("Fraise tagada");
		fraiseTagada.setPrix(1.05f);
		fraiseTagada.setCalorie(1000f);
		fraiseTagada.setIndiceGlycerique(5f);
		
		return fraiseTagada;
	}
}
