package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class newRowController implements Initializable{
	@FXML
    private TextField InputZone, InputasymetrieCoefficient, Inputcompacite, InputlongueurNoyau, InputlongueurRainureNoyau, Inputperimetre, InputlargeurNoyau;
    private Stage AddModal = null;
    private Row row;
	@FXML
    private ChoiceBox<String> SelectClasse;
    ObservableList<String> Classes = FXCollections.observableArrayList("Kama", "Rosa", "Canadian");
    
    @FXML
    void Close(ActionEvent event) {
        CloseAddModal();
    }

    @FXML
    void AddRow(ActionEvent event) {
        if (InputZone.getText().isEmpty()|| InputasymetrieCoefficient.getText().isEmpty()|| Inputcompacite.getText().isEmpty()||
            InputlongueurNoyau.getText().isEmpty()|| InputlongueurRainureNoyau.getText().isEmpty()|| Inputperimetre.getText().isEmpty() || InputlargeurNoyau.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Vous avez un ou plusieurs champs incomplets.", ButtonType.OK);
            alert.setTitle("Erreur");
            alert.showAndWait();
        } else{
                  
            row = new Row(Double.parseDouble(InputZone.getText().trim())
            		, Double.parseDouble(Inputperimetre.getText().trim())
            		, Double.parseDouble(Inputcompacite.getText().trim())
            		, Double.parseDouble(InputlongueurNoyau.getText().trim())
            		, Double.parseDouble(InputlargeurNoyau.getText().trim())
            		, Double.parseDouble(InputasymetrieCoefficient.getText().trim())
            		, Double.parseDouble(InputlongueurRainureNoyau.getText().trim())
            		, selectedClass(SelectClasse.getValue()));
            CloseAddModal();
        }
    }
    


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SelectClasse.setItems(Classes);
    }

    public Row getNewRow() {
        return this.row;
    }
    public void setStage(Stage AddModal) {
        this.AddModal = AddModal;
    }

    private void CloseAddModal() {
        if(AddModal!=null) {
            AddModal.close();
        }
    }
    private int selectedClass(String S) {
    	switch (S){
        case "Kama": return 1;  
        case "Rosa": return 2; 
        case "Canadian": return 3;
        }
    	return 0;
    }
}
