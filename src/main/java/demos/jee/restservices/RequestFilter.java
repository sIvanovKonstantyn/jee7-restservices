@Provider
@PreMatching
@Stateless
public class RequestFilter implements ContainerFilter {
	@EJB 
	AuthentificationService service;
	
	@Override
	public void filter(ContainerRequestContext requestContext) {
		if (requestContext.getRequest().getMethod().equals("OPTIONS")) {
			requestContext.abortWith(Response.status(Response.Status.OK).build());
			return;
		}
		
		try {
			if (!service.principalIsValid(new HttpPrincipal(requestContext.getHeaderString("userNameParameter"), 
											requestContext.getHeaderString("userPasswordParameter")))) {
						
				requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());		
			}
		}catch(RuntimeExeption e) {
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
		}
	}
}