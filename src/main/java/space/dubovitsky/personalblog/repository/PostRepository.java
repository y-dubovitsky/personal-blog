package space.dubovitsky.personalblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.dubovitsky.personalblog.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
