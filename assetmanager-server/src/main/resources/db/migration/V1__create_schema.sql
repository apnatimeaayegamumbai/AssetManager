USE `assetmanager`;

-- Table: asset
CREATE TABLE `assetmanager`.`asset`
(
    id   char(36) NOT NULL,
    name char(32) NOT NULL,
    city char(32) NOT NULL,
    state char(32) NOT NULL,
    zip_code char(32) NOT NULL,
    CONSTRAINT table_pk PRIMARY KEY (id)
);