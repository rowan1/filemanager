--
-- Create file data table
--
CREATE TABLE file_data (
    id BIGSERIAL NOT NULL,
    item_id BIGSERIAL NOT NULL,
    file bytea NOT NULL,
    size BIGSERIAL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    PRIMARY KEY (id),
    FOREIGN KEY (item_id) REFERENCES items(id)
);

