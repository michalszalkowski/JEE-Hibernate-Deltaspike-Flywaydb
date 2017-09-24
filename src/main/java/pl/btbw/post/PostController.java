package pl.btbw.post;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/post")
public class PostController {

	@Inject
	private PostRepository postRepository;

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PostDto> doAll() {

		List<Post> posts = postRepository.findAll();

		List<PostDto> dtos = new ArrayList<>();

		for (Post post : posts) {
			dtos.add(new PostDto(post.getId(), post.getName()));
		}

		return dtos;
	}

	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, String> doAdd(@PathParam("name") String name) {

		postRepository.saveAndFlush(new Post(name));

		return new HashMap<String, String>() {{
			put("message", "ok");
		}};
	}
}
