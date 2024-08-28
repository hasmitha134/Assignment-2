package service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Comment;
import model.Post;
import repository.CommentRepository;
import repository.PostRepository;
@Service
public abstract class CommentServiceImpl implements CommentService {
	 @Autowired
	    private CommentRepository commentRepository;

	    @Autowired
	    private PostRepository postRepository;

	    public Comment addComment(Long postId, Comment comment) {
	        Optional<Post> postOptional = postRepository.findById(postId);
	        if (!postOptional.isPresent()) {
	            throw new IllegalArgumentException("Post not found");
	        }
	        Post post = postOptional.get();
	         comment.setPost(post);
	        comment.setCreatedDate(LocalDateTime.now());
	        return commentRepository.save(comment);
	    }
	    @Override
	    public List<Comment> getCommentsForPost(Long postId) {
	        return commentRepository.findByPostIdOrderByCreatedDateDesc(postId);

	    
		}
		
}


