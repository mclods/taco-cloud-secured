CREATE TABLE IF NOT EXISTS taco_order(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    delivery_name VARCHAR(50) NOT NULL,
    delivery_street VARCHAR(50) NOT NULL,
    delivery_city VARCHAR(50) NOT NULL,
    delivery_state VARCHAR(50) NOT NULL,
    delivery_zip VARCHAR(50) NOT NULL,
    cc_number VARCHAR(50) NOT NULL,
    cc_expiration VARCHAR(50) NOT NULL,
    cc_cvv VARCHAR(50) NOT NULL,
    order_date TIMESTAMP NOT NULL
);


CREATE TABLE IF NOT EXISTS taco(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    creation_date TIMESTAMP NOT NULL,
    taco_order_id INTEGER REFERENCES taco_order(id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS ingredient(
    id char(4) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    type VARCHAR(20) NOT NULL
);

CREATE TABLE IF NOT EXISTS taco_ingredient(
    taco_id INTEGER REFERENCES taco(id) ON DELETE CASCADE,
    ingredient_id char(4) REFERENCES ingredient(id) ON DELETE CASCADE,
    PRIMARY KEY(taco_id, ingredient_id)
);