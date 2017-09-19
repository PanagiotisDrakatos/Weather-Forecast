package com.plugin.awesomejava.Location;

public enum Error {
    LISTVALUES(0, "The List is Empty"),
    DAYNOTVALID(1, "This day was not seted properly."),
    DATE_EROR(2, "There is an error with the current date"),
    NULL_OBJECT(3, "There is null object date");

    private final int code;
    private final String description;

    private Error(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}
