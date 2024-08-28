package repository;

import java.util.List;

import javax.xml.stream.events.Comment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository  extends JpaRepository<Comment, Long> {
	  List<model.Comment> findByPostIdOrderByCreatedDateDesc(Long postId);

	model.Comment save(model.Comment comment);

}
