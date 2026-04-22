package ge.careo.backend.review.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import java.util.UUID;

@Entity
@Table(
    name = "review_votes",
    uniqueConstraints = @UniqueConstraint(columnNames = {"review_id", "user_id"}))
public class ReviewVote {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "review_id", nullable = false)
  private UUID reviewId;

  @Column(name = "user_id", nullable = false)
  private UUID userId;

  @Column(name = "vote", nullable = false, columnDefinition = "SMALLINT")
  private Integer vote;

  public ReviewVote() {}

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public UUID getReviewId() {
    return reviewId;
  }

  public void setReviewId(UUID reviewId) {
    this.reviewId = reviewId;
  }

  public UUID getUserId() {
    return userId;
  }

  public void setUserId(UUID userId) {
    this.userId = userId;
  }

  public Integer getVote() {
    return vote;
  }

  public void setVote(Integer vote) {
    this.vote = vote;
  }
}
