CREATE TABLE IF NOT EXISTS consumed_messages (
    event_id VARCHAR(255) PRIMARY KEY,
    time_of_receiving TIMESTAMP NOT NULL,
    version INTEGER NOT NULL
);
