package pl.btbw.post;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface PostRepository extends EntityRepository<Post, Long> {
}