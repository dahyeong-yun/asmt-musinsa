SET REFERENTIAL_INTEGRITY FALSE;

TRUNCATE TABLE brand;
TRUNCATE TABLE item;

ALTER TABLE brand ALTER COLUMN id RESTART WITH 1;
ALTER TABLE item ALTER COLUMN id RESTART WITH 1;

SET REFERENTIAL_INTEGRITY TRUE;
