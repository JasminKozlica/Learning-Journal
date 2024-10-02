ALTER TABLE journal
ADD user_id BIGINT;

ALTER TABLE journal
ADD FOREIGN KEY (user_id) references appuser(id);