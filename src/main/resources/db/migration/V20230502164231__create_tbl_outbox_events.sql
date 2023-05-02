CREATE SEQUENCE IF NOT EXISTS outbox_events_id_seq;

CREATE TABLE IF NOT EXISTS outbox_events (
    id BIGINT PRIMARY KEY DEFAULT nextval('outbox_events_id_seq'),
    aggregate_type VARCHAR(255) NOT NULL,
    aggregate_id BIGINT NOT NULL,
    type VARCHAR(255) NOT NULL,
    payload TEXT NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    version INTEGER NOT NULL
);

CREATE OR REPLACE FUNCTION update_outbox_events_id()
  RETURNS TRIGGER AS $$
BEGIN
  IF NEW.id IS NULL THEN
    SELECT nextval('outbox_events_id_seq') INTO NEW.id;
  END IF;
  RETURN NEW;
END;
$$ LANGUAGE plpgsql;

DO $$
BEGIN
  IF NOT EXISTS (
    SELECT 1
    FROM pg_trigger
    WHERE tgname = 'outbox_events_id_trigger'
  ) THEN
    CREATE TRIGGER outbox_events_id_trigger
      BEFORE INSERT ON outbox_events
      FOR EACH ROW
      EXECUTE FUNCTION update_outbox_events_id();
  END IF;
END$$;
