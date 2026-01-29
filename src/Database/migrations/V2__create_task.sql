USE TaskTracker;
CREATE TABLE IF NOT EXISTS task(
    id int REFERENCES users (userID),
    taskID int ,
    status VARCHAR(15)NOT NULL ,
    description VARCHAR(500),
    time TIMESTAMP,
    updateTime TIMESTAMP
);