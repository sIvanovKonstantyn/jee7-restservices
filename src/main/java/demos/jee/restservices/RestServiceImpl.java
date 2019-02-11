
@Stateless
@Path(value="/rest")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class RestServiceImpl {
	@POST
	public Response postMethod(@HeaderParam("Content-type") Sring contentType, RequestDto requestDto) {
		// to do something with requestDto;
		return Response
			.ok()
			.entity(new ResponseDro("id1", "name1"))
			.type(contentType)
			.build();
	}
}
		