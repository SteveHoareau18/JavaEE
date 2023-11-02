package fr.stevehoareau18.projetExemple.rest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.Base64.Encoder;

import org.wildfly.security.WildFlyElytronProvider;
import org.wildfly.security.password.PasswordFactory;
import org.wildfly.security.password.interfaces.BCryptPassword;
import org.wildfly.security.password.spec.EncryptablePasswordSpec;
import org.wildfly.security.password.spec.IteratedSaltedPasswordAlgorithmSpec;

import fr.stevehoareau18.projetExemple.model.Utilisateur;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@SuppressWarnings("deprecation")
@Path("/utilisateurs")
@RequestScoped
@Transactional
public class UtilisateurController {

	@PersistenceContext(unitName = "JEEDSPU")
	private EntityManager em;

	@POST
	@Produces("application/json")
	public Response create(Utilisateur utilisateur) {
		
		em.persist(utilisateur);
		
		return Response.status(201).entity(utilisateur).build();
	}
	
	static final Provider ELYTRON_PROVIDER = new WildFlyElytronProvider();
	
	@GET
	@Produces("application/json")
	@Path("/default")
	public Response createDefault() {
		String password = "mangeur";
	   
		PasswordFactory passwordFactory = null;
		try {
			passwordFactory = PasswordFactory.getInstance(BCryptPassword.ALGORITHM_BCRYPT, ELYTRON_PROVIDER);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	    int iterationCount = 6;

	    byte[] salt = new byte[BCryptPassword.BCRYPT_SALT_SIZE];
	    SecureRandom random = new SecureRandom();
	    random.nextBytes(salt);

	    IteratedSaltedPasswordAlgorithmSpec iteratedAlgorithmSpec = new IteratedSaltedPasswordAlgorithmSpec(iterationCount, salt);
	    EncryptablePasswordSpec encryptableSpec = new EncryptablePasswordSpec(password.toCharArray(), iteratedAlgorithmSpec);
	    
	    BCryptPassword original = null;
		try {
			original = (BCryptPassword) passwordFactory.generatePassword(encryptableSpec);
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}

	    byte[] hash = original.getHash();
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    try {
			out.write(hash);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    Encoder encoder = Base64.getEncoder();
	    
		Utilisateur utilisateur = new Utilisateur().setUsername("mangeur").setPassword(encoder.encodeToString(hash)).setSalt(encoder.encodeToString(salt));
		
		em.persist(utilisateur);
		
		return Response.ok(utilisateur.getUsername()+" a été crée").build();
	}

}
