create table if not exists outbox_events
(
    id             varchar(36) primary key,
    aggregate_type varchar(50)  not null,
    aggregate_id   bigint       not null,
    type           varchar(50),
    payload        json,
    timestamp      datetime(6) not null,
    version        int
)