package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import model.Target;

public class TargetController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label targetsNameTextField;

    @FXML
    private Button targetAchieved;

    @FXML
    private Button targetFailed;

    @FXML
    private Button closeProgram;

    @FXML
    private Button back;

    @FXML
    private Button addComment;

    @FXML
    private TableView<Target> commentsTableView;

    @FXML
    private TableColumn<Target, String> commentColumn;

    @FXML
    private TableColumn<Target, Target> editColumn;

    @FXML
    private TextArea commentTextArea;

    @FXML
    void handleAddCommentPressed(ActionEvent event) {

    }

    @FXML
    void handleBackPressed(ActionEvent event) {

    }

    @FXML
    void handleClosePressed(ActionEvent event) {
    	
    	System.exit(0);

    }

    @FXML
    void handleTargetAchievedPressed(ActionEvent event) {

    }

    @FXML
    void handleTargetFailedPressed(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert targetsNameTextField != null : "fx:id=\"targetsNameTextField\" was not injected: check your FXML file 'Target.fxml'.";
        assert targetAchieved != null : "fx:id=\"targetAchieved\" was not injected: check your FXML file 'Target.fxml'.";
        assert targetFailed != null : "fx:id=\"targetFailed\" was not injected: check your FXML file 'Target.fxml'.";
        assert closeProgram != null : "fx:id=\"closeProgram\" was not injected: check your FXML file 'Target.fxml'.";
        assert back != null : "fx:id=\"back\" was not injected: check your FXML file 'Target.fxml'.";
        assert addComment != null : "fx:id=\"addComment\" was not injected: check your FXML file 'Target.fxml'.";
        assert commentsTableView != null : "fx:id=\"commentsTableView\" was not injected: check your FXML file 'Target.fxml'.";
        assert commentColumn != null : "fx:id=\"commentColumn\" was not injected: check your FXML file 'Target.fxml'.";
        assert editColumn != null : "fx:id=\"editColumn\" was not injected: check your FXML file 'Target.fxml'.";
        assert commentTextArea != null : "fx:id=\"commentTextArea\" was not injected: check your FXML file 'Target.fxml'.";

    }
}
