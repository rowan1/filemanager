--
-- Create permission_groups table
--
CREATE TABLE permission_groups (
    id BIGSERIAL NOT NULL,
    group_name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP NOT NULL DEFAULT NOW(),
    PRIMARY KEY (id)
);

