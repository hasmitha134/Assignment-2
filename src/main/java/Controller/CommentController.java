package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Comment;
import service.CommentService;
@RestController
@RequestMapping("/posts/{postId}/comments")
public class CommentController {
	 @Autowired
	    private CommentService commentService;

	    @PostMapping
	    public ResponseEntity<Comment> addComment(@PathVariable Long postId, @RequestBody javax.xml.stream.events.Comment comment) {
	        try {
	            Comment savedComment = commentService.addComment(postId, comment);
	            return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
	        } catch (IllegalArgumentException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @GetMapping
	    public ResponseEntity<List<Comment>> getComments(@PathVariable Long postId) {
	        List<Comment> comments = commentService.getCommentsForPost(postId);
	        if (comments.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        return new ResponseEntity<>(comments, HttpStatus.OK);
	    }

}
