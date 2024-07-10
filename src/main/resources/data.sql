DROP TABLE OPTIMISTIC_LOCK_COIN_PRICE;
CREATE TABLE OPTIMISTIC_LOCK_COIN_PRICE ( 
   id BIGINT NOT NULL auto_increment, 
   local_date_time DATETIME NOT NULL,
   coin_id BIGINT NOT NULL,
   price FLOAT(4) NOT NULL, 
   version BIGINT NOT NULL,
   updated_by VARCHAR(10)
);
insert into OPTIMISTIC_LOCK_COIN_PRICE(local_date_time,coin_id,price,version) values(CURRENT_TIMESTAMP,1,1.0,0);

DROP TABLE PESSIMISTIC_LOCK_COIN_PRICE;
CREATE TABLE PESSIMISTIC_LOCK_COIN_PRICE ( 
   id BIGINT NOT NULL auto_increment, 
   local_date_time DATETIME NOT NULL,
   coin_id BIGINT NOT NULL,
   price FLOAT(4) NOT NULL,
   version BIGINT NOT NULL,
   updated_by VARCHAR(10)
);
insert into PESSIMISTIC_LOCK_COIN_PRICE(local_date_time,coin_id,price,version) values(CURRENT_TIMESTAMP,1,1.0,0);