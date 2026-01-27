USE TaskTracker
CREATE Table IF NOT EXISTS taskHistory(
    id int REFERENCES users (userID),
    taskID int REFERENCES task (taskID),
    status VARCHAR(15)not null ,
    description VARCHAR(500),
    time TIMESTAMP,
    updateTime TIMESTAMP
);