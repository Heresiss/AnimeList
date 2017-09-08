package sample;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    FileHandler fh = new FileHandler();
    public TextField addField;
    public TextField searchField;
    public ListView listView;
    public Label nOfAnime;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.getItems().addAll(fh.getList());
        nOfAnime.setText(Integer.toString(fh.getList().size()));
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            ArrayList<String> l = new ArrayList<>();
            if (!searchField.getText().equals("")) {
                ArrayList<String> list = fh.getList();

                for (String s : list) {
                    if (s.toLowerCase().contains(searchField.getText().toLowerCase()))
                        l.add(s);
                }
            } else {
                l = fh.getList();
            }
            listView.getItems().clear();
            listView.getItems().addAll(l);
        });
    }

    public void addButtonClicked() {
        if (!addField.getText().equals("")) {
            if (fh.add(addField.getText())) {
                fh.save();
                refresh();
                String s = "Added '" + addField.getText() + "' to your list";
                JOptionPane.showMessageDialog(null, s, "Sup bruh", 1);
            }
        }
        addField.setText("");
    }

    private void refresh() {
        String s = searchField.getText();
        searchField.setText(s + "sd");
        searchField.setText(s);
        nOfAnime.setText(Integer.toString(fh.getList().size()));
    }

}
