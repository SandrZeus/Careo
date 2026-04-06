CREATE TABLE cars (
    id UUID PRIMARY KEY NOT NULL,
    make VARCHAR(50) NOT NULL,
    model VARCHAR(50) NOT NULL,
    generation VARCHAR(50) NOT NULL,
    production_year SMALLINT NOT NULL,
    body_type VARCHAR(50),
    engine_type VARCHAR(20),
    cubic_capacity INT,
    power INT,
    transmission VARCHAR(20),
    drive VARCHAR(20),
    cylinder_count INT,
    seat_count INT,
    door_count INT,
    weight INT,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW()
)
