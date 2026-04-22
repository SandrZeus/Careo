package ge.careo.backend.review.repository;

import ge.careo.backend.review.entity.ReviewComment;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewCommentRepository extends JpaRepository<ReviewComment, UUID> {}
