CREATE TABLE if NOT EXISTS cab_hex_address
(
    cab_id                  varchar(255) NOT NULL PRIMARY KEY,
    h3_index                varchar(255),
    latitude                decimal,
    longitude               decimal
);