
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.beans.value.*;
import javafx.collections.*;

public class Controller {
    Warteliste warteliste;
    @FXML
    private ListView listView;

    @FXML
    private TextField txtName;

    @FXML
    private Label lblAufruf;

    //Inhalt für die ListView!
    private ObservableList<String> content;

    public Controller()
    {
        warteliste = new Warteliste();
    }

    @FXML
    private void initialize()   {
        
        listeAktualisieren();
    }

    @FXML
    public void aufruf(ActionEvent event) {
        Patient pat = warteliste.aufrufen();
        listeAktualisieren();
        lblAufruf.setText("Nächster Patient: " + pat.getName());

    }

    @FXML
    public void einfuegen(Event event) {
        patientEinfuegen();
    }

    @FXML
    public void handleTxtEinfuegen(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER)
        {
            patientEinfuegen();
        }

    }

    public void patientEinfuegen()
    {
        String name = txtName.getText();
        Patient pat = new Patient(name);
        warteliste.einfuegen(pat);
        listeAktualisieren();
        txtName.setText("");
    }

    public void listeAktualisieren()
    {

        listView.getItems().clear();
        Patient[] liste = warteliste.getListe();
        for (int i = 0; i < warteliste.getAnzahl(); i++)
        {
            // Label label = new Label(liste[i].getName());
            listView.getItems().add(liste[i].getName());
        }
    }

    @FXML
    void loeschen(ActionEvent event) {
        int index = listView.getSelectionModel().getSelectedIndex();
        warteliste.loeschen(index);
        listeAktualisieren();

    }

    @FXML
    void vorziehen(ActionEvent event) {
        int index = listView.getSelectionModel().getSelectedIndex();
        warteliste.vorziehen(index);
        listeAktualisieren();

    }
}