ALTER TABLE doctors ADD COLUMN active tinyint DEFAULT 1;
UPDATE doctors set active = 1;

ALTER TABLE doctors ADD UNIQUE (email);
