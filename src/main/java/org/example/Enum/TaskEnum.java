package org.example.Enum;

public class TaskEnum {
    public enum Status {
        DONE,
        TODO,
        PROGRESS,
        ALL
    }




    public enum Action {
        ADD,
        DELETE,
        CHANGE,
        CHANGE_STATUS,
        EXIT,
        SHOW,
        YES,
        NO,
        LOGIN,
        REGISTRATION


    }
    public static Status fromDb(String value) {
        return Status.valueOf(value.toUpperCase());
    }

}
