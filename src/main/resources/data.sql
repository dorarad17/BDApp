DROP TABLE IF EXISTS billionaires;

CREATE TABLE attendees (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL
);

INSERT INTO attendees (first_name, last_name) VALUES
  ('Dora', 'Radosevic');