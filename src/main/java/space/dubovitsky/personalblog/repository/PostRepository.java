package space.dubovitsky.personalblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.dubovitsky.personalblog.entity.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByTextContains(String text);

}
