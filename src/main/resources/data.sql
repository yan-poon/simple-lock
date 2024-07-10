-- Drop the existing table for optimistic lock coin price to reset the schema
DROP TABLE IF EXISTS OPTIMISTIC_LOCK_COIN_PRICE;

-- Create a new table for managing coin prices with optimistic locking
CREATE TABLE OPTIMISTIC_LOCK_COIN_PRICE ( 
   id BIGINT NOT NULL auto_increment, -- Unique identifier for each record
   local_date_time DATETIME NOT NULL, -- Timestamp of the last update
   coin_id BIGINT NOT NULL, -- Identifier for the coin
   price FLOAT(4) NOT NULL, -- Current price of the coin
   version BIGINT NOT NULL, -- Version number for optimistic locking
   updated_by VARCHAR(10) -- Identifier of the updater
);

-- Insert an initial record into the optimistic lock coin price table
insert into OPTIMISTIC_LOCK_COIN_PRICE(local_date_time,coin_id,price,version) values(CURRENT_TIMESTAMP,1,1.0,0);

-- Drop the existing table for pessimistic lock coin price to reset the schema
DROP TABLE IF EXISTS PESSIMISTIC_LOCK_COIN_PRICE;

-- Create a new table for managing coin prices with pessimistic locking
CREATE TABLE PESSIMISTIC_LOCK_COIN_PRICE ( 
   id BIGINT NOT NULL auto_increment, -- Unique identifier for each record
   local_date_time DATETIME NOT NULL, -- Timestamp of the last update
   coin_id BIGINT NOT NULL, -- Identifier for the coin
   price FLOAT(4) NOT NULL, -- Current price of the coin
   version BIGINT NOT NULL, -- Version number for record tracking
   updated_by VARCHAR(10) -- Identifier of the updater
);

-- Insert an initial record into the pessimistic lock coin price table
insert into PESSIMISTIC_LOCK_COIN_PRICE(local_date_time,coin_id,price,version) values(CURRENT_TIMESTAMP,1,1.0,0);