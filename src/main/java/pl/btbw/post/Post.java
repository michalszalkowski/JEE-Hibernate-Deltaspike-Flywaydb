package pl.btbw.post;

import javax.persistence.*;

@Entity
@Table(name = "post")
@NamedQueries({
		@NamedQuery(name = "Post.all", query = "SELECT p FROM Post p")
})
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	public Post() {
	}

	public Post(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
