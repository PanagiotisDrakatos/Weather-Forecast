package com.plugin.awesomejava.UIApp;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javax.swing.SwingUtilities;

public class JFxBuilder {

    private DialogObject Dialog = null;

    public JFxBuilder() {
    }

    public JFxBuilder(DialogObject Dialog) {
        this.Dialog = Dialog;
    }

    private void initAndShowGUI() {
        final JFXPanel fxPanel = new JFXPanel();
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(fxPanel);
                if (Dialog != null) {
                    createAlertDialog(Dialog);
                }
            }
        });

    }

    private void initFX(JFXPanel fxPanel) {
        // This method is invoked on the JavaFX thread
        Group root = new Group();
        Scene scene = new Scene(root);
        fxPanel.setScene(scene);

    }

    private void createAlertDialog(DialogObject dialog) {
        Alert alert = new Alert(dialog.getType());
        alert.setTitle(dialog.getTitle());
        alert.setHeaderText(dialog.getHeader());
        alert.setContentText(dialog.getContent());

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
        } else {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            dialog.getexception().printStackTrace(pw);
            String exceptionText = sw.toString();

            Label label = new Label("The exception stacktrace was:");

            TextArea textArea = new TextArea(exceptionText);
            textArea.setEditable(false);
            textArea.setWrapText(true);

            textArea.setMaxWidth(Double.MAX_VALUE);
            textArea.setMaxHeight(Double.MAX_VALUE);
            GridPane.setVgrow(textArea, Priority.ALWAYS);
            GridPane.setHgrow(textArea, Priority.ALWAYS);

            GridPane expContent = new GridPane();
            expContent.setMaxWidth(Double.MAX_VALUE);
            expContent.add(label, 0, 0);
            expContent.add(textArea, 0, 1);

            alert.getDialogPane().setExpandableContent(expContent);

            alert.showAndWait();
        }
    }

    public void setDialog(DialogObject Dialog) {
        this.Dialog = Dialog;
    }

    public DialogObject getDialog() {
        return Dialog;
    }

    public void Invoke() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                initAndShowGUI();
            }
        });
    }
}
