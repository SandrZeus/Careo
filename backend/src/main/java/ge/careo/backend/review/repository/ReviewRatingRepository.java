package ge.careo.backend.review.repository;

import ge.careo.backend.review.entity.ReviewRating;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRatingRepository extends JpaRepository<ReviewRating, UUID> {}
