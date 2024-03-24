--
-- Create items table
--
CREATE TABLE items (
    id BIGSERIAL NOT NULL AUTO INCREMENT,
    name VARCHAR(100) NOT NULL,
    type VARCHAR(10) NOT NULL,
    permission_group_id BIGSERIAL NULL,
    parent_id INT8 DEFAULT NULL,
    root_id INT8 DEFAULT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    PRIMARY KEY (id),
    FOREIGN KEY (root_id) REFERENCES items(id),
    FOREIGN KEY (parent_id) REFERENCES items(id)
);

