CREATE TABLE posts (
  id VARCHAR(16) NOT NULL
  ,sender_visibility BOOLEAN NOT NULL
  ,sender VARCHAR(16) DEFAULT 'default_sender' NOT NULL
  ,recipient VARCHAR(16) NOT NULL
  ,category_id VARCHAR(16) NOT NULL
  ,episode TEXT NOT NULL
  ,PRIMARY KEY (id)
);

CREATE TABLE category (
  id VARCHAR(16) NOT NULL
  ,colleague BOOLEAN NOT NULL
  ,customer BOOLEAN NOT NULL
  ,company BOOLEAN NOT NULL
  ,PRIMARY KEY (id)
);
  
CREATE TABLE partners (
  id VARCHAR(16) NOT NULL
  ,email VARCHAR(32) NOT NULL
  ,name VARCHAR(16) NOT NULL
  ,PRIMARY KEY (id)
);