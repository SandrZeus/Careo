CREATE TABLE review_votes (
    id UUID PRIMARY KEY,
    review_id UUID NOT NULL REFERENCES reviews(id),
    user_id UUID NOT NULL REFERENCES users(id),
    vote SMALLINT NOT NULL CHECK (vote IN (-1, 1)),
    UNIQUE (review_id, user_id)
)
