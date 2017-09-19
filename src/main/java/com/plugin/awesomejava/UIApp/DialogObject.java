package com.plugin.awesomejava.UIApp;

import javafx.scene.control.Alert.AlertType;

public class DialogObject {

    private AlertType Type = null;
    private String Title = null;
    private String Header = null;
    private String Content = null;

    private Exception exception = null;
    private boolean AlertDialog = false;

    public DialogObject() {
    }

    public DialogObject(AlertType Type, String Title, String Header, String Content, Exception exception) {
        this.Type = Type;
        this.Title = Title;
        this.Header = Header;
        this.Content = Content;
        this.exception = exception;
    }

    public DialogObject(AlertType Type, String Title, String Content) {
        this.Type = Type;
        this.Title = Title;
        this.Content = Content;
    }

    public DialogObject(AlertType Type, String Title, String Header, String Content) {
        this.Type = Type;
        this.Title = Title;
        this.Header = Header;
        this.Content = Content;
    }
    
    public DialogObject(String Title, String Header, String Content) {
        this.Title = Title;
        this.Header = Header;
        this.Content = Content;
    }

    public DialogObject(AlertType Type, String Title, String Header, String Content, boolean AlertDialog) {
        this.Type = Type;
        this.Title = Title;
        this.Header = Header;
        this.Content = Content;
        this.AlertDialog = AlertDialog;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setType(AlertType Type) {
        this.Type = Type;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public void setexception(Exception exception) {
        this.exception = exception;
    }

    public void setHeader(String Header) {
        this.Header = Header;
    }

    public boolean isAlertDialog() {
        return AlertDialog;
    }

    public String getTitle() {
        return Title;
    }

    public String getHeader() {
        return Header;
    }

    public Exception getexception() {
        return exception;
    }

    public String getContent() {
        return Content;
    }

    public AlertType getType() {
        return Type;
    }

    public void setAlertDialog(boolean AlertDialog) {
        this.AlertDialog = AlertDialog;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
