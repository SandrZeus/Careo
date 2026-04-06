CREATE TABLE review_ratings (
    id UUID PRIMARY KEY,
    review_id UUID UNIQUE NOT NULL REFERENCES reviews(id),
    purchase_affordability SMALLINT NOT NULL CHECK (purchase_affordability BETWEEN 1 AND 10),
    fuel_economy SMALLINT NOT NULL CHECK (fuel_economy BETWEEN 1 AND 10),
    resale_value SMALLINT NOT NULL CHECK (resale_value BETWEEN 1 AND 10),
    maintenance_cost SMALLINT NOT NULL CHECK (maintenance_cost BETWEEN 1 AND 10),
    acceleration SMALLINT NOT NULL CHECK (acceleration BETWEEN 1 AND 10),
    handling SMALLINT NOT NULL CHECK (handling BETWEEN 1 AND 10),
    ride_comfort SMALLINT NOT NULL CHECK (ride_comfort BETWEEN 1 AND 10),
    cargo_space SMALLINT NOT NULL CHECK (cargo_space BETWEEN 1 AND 10),
    passenger_room SMALLINT NOT NULL CHECK (passenger_room BETWEEN 1 AND 10),
    mechanical_reliability SMALLINT NOT NULL CHECK (mechanical_reliability BETWEEN 1 AND 10),
    parts_availability SMALLINT NOT NULL CHECK (parts_availability BETWEEN 1 AND 10),
    infotainment_quality SMALLINT NOT NULL CHECK (infotainment_quality BETWEEN 1 AND 10),
    driver_assist SMALLINT NOT NULL CHECK (driver_assist BETWEEN 1 AND 10)
)
