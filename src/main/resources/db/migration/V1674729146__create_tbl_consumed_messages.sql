create table if not exists consumed_messages
(
    event_id varchar(36) primary key,
    time_of_receiving datetime(6),
    version   int
)