package ge.careo.backend.review.repository;

import ge.careo.backend.review.entity.ReviewVote;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewVoteRepository extends JpaRepository<ReviewVote, UUID> {}
