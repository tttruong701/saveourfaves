-- Create a keyspace
CREATE KEYSPACE IF NOT EXISTS master WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : '1' };

-- Create a table
CREATE TABLE IF NOT EXISTS master.business (
                                                   id text PRIMARY KEY,
                                                   name text,
                                                   giftCardURL text
);

-- Insert some data
-- INSERT INTO store.shopping_cart
-- (userid, item_count, last_update_timestamp)
-- VALUES ('9876', 2, toTimeStamp(now()));
-- INSERT INTO store.shopping_cart
-- (userid, item_count, last_update_timestamp)
-- VALUES ('1234', 5, toTimeStamp(now()));