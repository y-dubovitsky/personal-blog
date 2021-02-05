package space.dubovitsky.personalblog.service;

import org.springframework.stereotype.Service;
import space.dubovitsky.personalblog.entity.Post;
import space.dubovitsky.personalblog.repository.PostRepository;

@Service
public class PostService {

    private PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post getPersonById(Long id) {
        Post ret = new Post();
        postRepository.findById(id).ifPresent(post -> { //TODO Переделать
            ret.setId(post.getId());
            ret.setTitle(post.getTitle());
            ret.setText(post.getText());
        });

        return ret;
    }

    public Iterable<Post> getAllPost() {
        return postRepository.findAll();
    }

    public Post addPost(Post post) {
        return postRepository.save(post);
    }
}
