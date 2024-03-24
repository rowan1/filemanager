--
-- Create permissions table
--
CREATE TABLE permissions (
    id BIGSERIAL NOT NULL,
    user_email VARCHAR(100) NOT NULL UNIQUE,
    permission_level VARCHAR(10) NOT NULL,
    group_id BIGSERIAL NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    PRIMARY KEY (id),
    FOREIGN KEY (group_id) REFERENCES permission_groups(id)
);

