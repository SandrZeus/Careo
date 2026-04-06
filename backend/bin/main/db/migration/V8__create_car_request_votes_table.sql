CREATE TABLE car_request_votes (
    id UUID PRIMARY KEY,
    request_id UUID NOT NULL REFERENCES car_requests(id),
    user_id UUID NOT NULL REFERENCES users(id),
    UNIQUE (request_id, user_id)
)
