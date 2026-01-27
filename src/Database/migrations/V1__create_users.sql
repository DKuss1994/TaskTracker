USE TaskTracker;
CREATE TABLE IF NOT EXISTS users (
    userID INT PRIMARY KEY AUTO_INCREMENT,
    userName VARCHAR(50) UNIQUE not null ,
    password VARCHAR(255)NOT NULL ,
    role VARCHAR(255)
);