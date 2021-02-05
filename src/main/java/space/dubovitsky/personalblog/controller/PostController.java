package space.dubovitsky.personalblog.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import space.dubovitsky.personalblog.entity.Post;
import space.dubovitsky.personalblog.service.PostService;

//    @Profile("dev")
@RestController
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPersonById(id);
    }

    @GetMapping("/all")
    public Iterable<Post> getAllPosts() {
        return postService.getAllPost();
    }

    @PostMapping("/post")
    public ResponseEntity getPost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.addPost(post));
    }

}
