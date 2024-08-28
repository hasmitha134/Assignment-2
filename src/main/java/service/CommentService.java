package service;

import java.util.List;

import javax.xml.stream.events.Comment;

public interface CommentService {
	model.Comment addComment(Long postId, Comment comment);
    List<model.Comment> getCommentsForPost(Long postId);

}
