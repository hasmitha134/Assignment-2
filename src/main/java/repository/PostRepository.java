package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
