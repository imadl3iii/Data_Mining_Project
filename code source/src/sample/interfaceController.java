package sample;

import javafx.application.Platform;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;


public class interfaceController implements Initializable {
    Dataset dataset = new Dataset();
    int compteur = 0;

    @FXML
    private TableView<Row> TableDataset, TableNormalization;
    ObservableList<Row> rows, rowsNormal;

    @FXML
    private TableView<RowDiscritization> TableDiscritization;
    ObservableList<RowDiscritization> rowsDiscritizate;

    @FXML
    private TableColumn<Row, String> zoneAttr, perimetreAttr, compaciteAttr,
            longueurNoyauAttr, largeurNoyauAttr, asymetrieCoefficientAttr, longueurRainureNoyauAttr;

    @FXML
    private TableColumn<Row, String> zoneAttr1N, perimetreAttr1N, compaciteAttr1N,
            longueurNoyauAttr1N, largeurNoyauAttr1N, asymetrieCoefficientAttr1N, longueurRainureNoyauAttr1N;



    @FXML
    private TableColumn<Row, Integer> AttributOcc,AttributOcc1N;

    @FXML
    private TableColumn<RowDiscritization, Integer> AttributOcc1D;
    @FXML
    private TableColumn<RowDiscritization, String> zoneAttr1D, perimetreAttr1D, compaciteAttr1D,
            longueurNoyauAttr1D, largeurNoyauAttr1D, asymetrieCoefficientAttr1D, longueurRainureNoyauAttr1D,Classe1D;

    @FXML
    private TableColumn<Row, String> Classe,Classe1N;

    @FXML
    private TextField minNormal,maxNormal,inputDiscritizate;

    @FXML
    private TextField inputTailleClass,a1,a2,a3,a4,a5,a6,a7,inputDiscClass;

    @FXML
    private TextField inputK;

    @FXML
    private TextField inputTestCB,inputIntervalCB;

    @FXML
    private TextField inputTestKNN,inputKTest;

    @FXML
    private ChoiceBox<String> selectedFunctionTestKnn;
    ObservableList<String> functionClassTest = FXCollections.observableArrayList("Euclidienne", "Manhattan");


    @FXML
    private ChoiceBox<String> selectedFunctionKnn;
    ObservableList<String> functionClass = FXCollections.observableArrayList("Euclidienne", "Manhattan");


    @FXML
    private Button normlizeBtn,discritizateBtn;

    @FXML
    private Button TestCB,testKnn;

    @FXML
    private Button confusionBtnB,confusionBtnB1;

    @FXML
    private HBox horizontalMinMax;

    @FXML
    private VBox vboxKnn;

    @FXML
    private Label precision1,precision2,precision3,precision_m,precision_m1;

    @FXML
    private Label rappel1,rappel2,rappel3,rappel_m,rappel_m1;

    @FXML
    private Label sensitivity1,sensitivity2,sensitivity3,sensitivity_m,sensitivity_m1;

    @FXML
    private Label specificity1,specificity2,specificity3,specificity_m,specificity_m1;

    @FXML
    private Label fscore1,fscore2,fscore3,fscore_m,fscore_m1;

    @FXML
    private Label accuracy1,accuracy2,accuracy3,accuracy_m,accuracy_m1;

    @FXML
    private Label fn1,fn2,fn3,fn4,fp1,fp2,fp3,fp4,tp1,tp2,tp3,tp4,tn1,tn2,tn3,tn4;

    @FXML
    private Label classResult;


    @FXML
    private Label precision11,precision21,precision31;

    @FXML
    private Label rappel11,rappel21,rappel31;

    @FXML
    private Label sensitivity11,sensitivity21,sensitivity31;

    @FXML
    private Label specificity11,specificity21,specificity31;

    @FXML
    private Label fscore11,fscore21,fscore31;

    @FXML
    private Label accuracy11,accuracy21,accuracy31;

    @FXML
    private Label fn11,fn21,fn31,fn41,fp11,fp21,fp31,fp41,tp11,tp21,tp31,tp41,tn11,tn21,tn31,tn41;


    @FXML
    private Text  NombresR, Dataset_Caracteristiques, Valeurs_manquantes, NbrAttributs,NbrInstances, NbrClasses;

    @FXML
    private TextArea Dataset_description,Attr_Symetrie;


    @FXML
    private ChoiceBox<String> Select;
    ObservableList<String> Options = FXCollections.observableArrayList("Surface", "P�rim�tre", "Compacit�", "Longueur du grain","Largeur du grain", "Coefficient d'asym�trie", "Longueur du sillon du noyau", "Classe");

    @FXML
    private ChoiceBox<String> selectedTypeNormalization;
    ObservableList<String> normalizationType = FXCollections.observableArrayList("Normalisation Min-Max", "Normalisation Z-score");

    @FXML
    private ChoiceBox<String> selectedTypeDiscritization;
    ObservableList<String> discritizationType = FXCollections.observableArrayList("Nombre de Quantiles", "Nombre d'intervalles");

    @FXML
    private ChoiceBox<String> selectedTypeClass;
    ObservableList<String> classficationType = FXCollections.observableArrayList("classification Na�ve Bay�sienne", "classification KNN");

    @FXML
    private RadioButton CheckHisto, CheckScatterP, CheckBoxP;


    @FXML
    private ChoiceBox<String> Selected1, Selected2;

    @FXML
    private Button DisplayGraph;


    @FXML
    private Text Attr_EcartType, Attr_quartiles,Attr_Moyenne,Attr_Mediane,Attr_Midrange,Attr_Mode,Attr_Etendue,Attr_MoyenneTronquee,Attr_Variance, Attr_IQR, Attr_ValeursAberrantes;

    @FXML
    private GridPane GraphDiv1, GraphDiv2;

    @FXML
    private SwingNode Graphique_Attr,Graphique_Class;

    ArrayList<Double> Att1 = new ArrayList<>();
    ArrayList<Double> Att2 = new ArrayList<>();

    public int[][] confusionCB;
    public int[][] confusionKNN;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        Select.setItems(Options);
        Selected1.setItems(Options);
        Selected2.setItems(Options);

        selectedTypeNormalization.setValue("S�lectionner la normalisation");
        selectedTypeNormalization.setItems(normalizationType);
        horizontalMinMax.setVisible(false);

        selectedTypeDiscritization.setValue("S�lectionner la discr�tisation");
        selectedTypeDiscritization.setItems(discritizationType);

        selectedTypeClass.setValue("S�lectionner la classification");
        selectedTypeClass.setItems(classficationType);

        vboxKnn.setVisible(false);
        inputDiscClass.setVisible(false);

        selectedFunctionKnn.setValue("La mesure");
        selectedFunctionKnn.setItems(functionClass);

        selectedFunctionTestKnn.setValue("La mesure");
        selectedFunctionTestKnn.setItems(functionClassTest);

        Selected2.setVisible(false);
        CheckBoxP.setSelected(true);

        Selected2.setDisable(true);
        CheckHisto.selectedProperty().addListener((observableValue) -> {
            Selected2.setDisable(true);
            Selected2.setVisible(false);
        });
        CheckBoxP.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed( ObservableValue<? extends Boolean> ObservableValue, Boolean a ,Boolean b) {
                Selected2.setDisable(true);
                Selected2.setVisible(false);
            }
        });

        CheckScatterP.selectedProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean a, Boolean b) {
                Selected2.setDisable(false);
                Selected2.setVisible(true);
            }
        });


        Select.setValue("S�lectionner l'attribut");

        Selected1.setValue("S�lectionner l'attribut");
        Selected2.setValue("S�lectionner l'attribut");



        selectedTypeNormalization.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            if(newValue == "Normalisation Min-Max") {
                horizontalMinMax.setVisible(true);
            }else {
                horizontalMinMax.setVisible(false);
            }
        });

        selectedTypeDiscritization.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {
            if(newValue == "Nombre de Quantiles") {
                inputDiscritizate.setPromptText("Veuillez introduire de nombre de Quantiles");
            }else if(newValue == "Nombre d'intervalles") {
                inputDiscritizate.setPromptText("Veuillez introduire de nombre d'intervalles");
            }
        });

        selectedTypeClass.getSelectionModel().selectedItemProperty().addListener((options, oldValue, newValue) -> {

            if(newValue == "classification Na�ve Bay�sienne") {
                inputDiscClass.setVisible(true);
                vboxKnn.setVisible(false);
            }else if(newValue == "classification KNN") {
                vboxKnn.setVisible(true);
                inputDiscClass.setVisible(false);
            }
        });


        try {
            List<String> reader = Files.readAllLines(Paths.get("./Data File/seeds.txt"));
            ImportDATA(reader);
        } catch (IOException e) {
        }
        String DataInfo = "Le groupe examin� comprenait des grains appartenant � trois vari�t�s diff�rentes de bl� : Kama, Rosa et Canadian, 70 �l�ments chacun, s�lectionn�s au hasard pour l'exp�rience. Une visualisation de haute qualit� de la structure interne du noyau a �t� d�tect�e � l'aide d'une technique de rayons X doux. Elle est non destructive et consid�rablement moins ch�re que d'autres techniques d'imagerie plus sophistiqu�es comme la microscopie � balayage ou la technologie laser. Les images ont �t� enregistr�es sur des plaques KODAK � rayons X de 13x18 cm. Des �tudes ont �t� men�es � l'aide de grains de bl� r�colt�s � la moissonneuse-batteuse provenant de champs exp�rimentaux, explor�s � l'Institut d'agrophysique de l'Acad�mie polonaise des sciences � Lublin. \n"
                +"technique de rayons X doux. Elle est non destructive et consid�rablement moins ch�re que d'autres techniques . \n L'ensemble de donn�es peut �tre utilis� pour les t�ches de classification et d'analyse de cluster. M. Charytanowicz, J. Niewczas, P. Kulczycki, P.A. Kowalski, S. Lukasik, S. Zak, � A Complete Gradient Clustering Algorithm for Features Analysis of X-ray Images �, dans : Information Technologies in Biomedicine, Ewa Pietka, Jacek Kawa (eds.), Springer-Verlag, Berlin-Heidelberg , 2010, p. 15-24.";
        Dataset_description.setText(DataInfo);
        Dataset_description.setWrapText(true);

        Dataset_Caracteristiques.setText("multivari�e");
        NombresR.setText("Nombres r�els");
        Valeurs_manquantes.setText("Pas de valeurs manquantes");
        NbrAttributs.setText("7");
        NbrInstances.setText(String.valueOf(this.compteur));

        dataset.setData();

        Traitement Tr = new Traitement(dataset.getZoneAttribut());

//    	System.out.println(Tr.Discretisation_Quentiles(dataset.getZoneAttribut(),dataset.getPerimetreAttribut(),dataset.getCompaciteAttribut(),dataset.getLongueurNoyauAttribut(),dataset.getLargeurNoyauAttribut(),dataset.getAsymetrieCoefficientAttribut(),dataset.getLongueurRainureNoyauAttribut(),dataset.getclasseAttribut(),25));
//    	System.out.println(Tr.Discretisation_intervalles_egaux(dataset.getZoneAttribut(),dataset.getPerimetreAttribut(),dataset.getCompaciteAttribut(),dataset.getLongueurNoyauAttribut(),dataset.getLargeurNoyauAttribut(),dataset.getAsymetrieCoefficientAttribut(),dataset.getLongueurRainureNoyauAttribut(),dataset.getclasseAttribut(),4));
        ArrayList<ArrayList<String> > dsc = new ArrayList<ArrayList<String> >(Tr.Discretisation_intervalles_egaux(dataset.getZoneAttribut(),dataset.getPerimetreAttribut(),dataset.getCompaciteAttribut(),dataset.getLongueurNoyauAttribut(),dataset.getLargeurNoyauAttribut(),dataset.getAsymetrieCoefficientAttribut(),dataset.getLongueurRainureNoyauAttribut(),dataset.getclasseAttribut(),4));
        HashMap<String,ArrayList<Boolean>> tv = new HashMap<String,ArrayList<Boolean>>(Tr.tableVertical(dsc));
        List<Map<List<String>,Integer>> item = new ArrayList<Map<List<String>,Integer>>(Tr.Eclat_Items_set_Frequents(tv,20,dsc.size()));
        System.out.println("C1 = "+item.get(0));
        System.out.println("C2 = "+item.get(1));
//    	ArrayList<Row> NZ_sc = new ArrayList<Row>(Tr.Normalization_Z_Score(dataset.getZoneAttribut(),dataset.getPerimetreAttribut(),dataset.getCompaciteAttribut(),dataset.getLongueurNoyauAttribut(),dataset.getLargeurNoyauAttribut(),dataset.getAsymetrieCoefficientAttribut(),dataset.getLongueurRainureNoyauAttribut(),dataset.getclasseAttribut()));
//    	ArrayList<Row> N_min_max = new ArrayList<Row>(Tr.Normalization_Min_Max(dataset.getZoneAttribut(),dataset.getPerimetreAttribut(),dataset.getCompaciteAttribut(),dataset.getLongueurNoyauAttribut(),dataset.getLargeurNoyauAttribut(),dataset.getAsymetrieCoefficientAttribut(),dataset.getLongueurRainureNoyauAttribut(),dataset.getclasseAttribut()));

//    	ArrayList<HashMap<List<String> , Integer>> MapList_Result = new ArrayList<HashMap<List<String> , Integer>>( Tr.Itemsets_frequents(1,10,20,null,dataset.getZoneAttribut(),dataset.getPerimetreAttribut(),dataset.getCompaciteAttribut(),dataset.getLongueurNoyauAttribut(),dataset.getLargeurNoyauAttribut(),dataset.getAsymetrieCoefficientAttribut(),dataset.getLongueurRainureNoyauAttribut()));
//    	System.out.println("C1 = "+MapList_Result.get(0));
//    	System.out.println("L1 = "+MapList_Result.get(1));
//    	ArrayList<HashMap<List<String> , Integer>> MapList_Result1 = new ArrayList<HashMap<List<String> , Integer>>( Tr.Itemsets_frequents(2,4,20,MapList_Result.get(1),dataset.getZoneAttribut(),dataset.getPerimetreAttribut(),dataset.getCompaciteAttribut(),dataset.getLongueurNoyauAttribut(),dataset.getLargeurNoyauAttribut(),dataset.getAsymetrieCoefficientAttribut(),dataset.getLongueurRainureNoyauAttribut()));
//    	System.out.println("L2 = "+MapList_Result1.get(1));
//    	System.out.println("\n \n \n");
//    	ArrayList<HashMap<List<String> , Integer>> MapList_Result2 = new ArrayList<HashMap<List<String> , Integer>>( Tr.Itemsets_frequents(3,4,20,MapList_Result1.get(1),dataset.getZoneAttribut(),dataset.getPerimetreAttribut(),dataset.getCompaciteAttribut(),dataset.getLongueurNoyauAttribut(),dataset.getLargeurNoyauAttribut(),dataset.getAsymetrieCoefficientAttribut(),dataset.getLongueurRainureNoyauAttribut()));
//    	System.out.println("C3 = "+MapList_Result2.get(0));
//    	System.out.println("L3 = "+MapList_Result2.get(1));
//    	System.out.println("\n \n \n");
//    	ArrayList<HashMap<List<String> , Integer>> MapList_Result3 = new ArrayList<HashMap<List<String> , Integer>>( Tr.Itemsets_frequents(4,4,20,MapList_Result2.get(1),dataset.getZoneAttribut(),dataset.getPerimetreAttribut(),dataset.getCompaciteAttribut(),dataset.getLongueurNoyauAttribut(),dataset.getLargeurNoyauAttribut(),dataset.getAsymetrieCoefficientAttribut(),dataset.getLongueurRainureNoyauAttribut()));
//    	System.out.println("C4 = "+MapList_Result3.get(0));
//    	System.out.println("L4 = "+MapList_Result3.get(1));
//    	List<Map<List<String> , Integer>> MapList_Result2 = new ArrayList<Map<List<String> , Integer>>(Tr.Itemsets_frequents2(MapList_Result.get(1),dataset.getZoneAttribut(),dataset.getPerimetreAttribut(),dataset.getCompaciteAttribut(),dataset.getLongueurNoyauAttribut(),dataset.getLargeurNoyauAttribut(),dataset.getAsymetrieCoefficientAttribut(),dataset.getLongueurRainureNoyauAttribut()));
//    	System.out.println("L2 = "+MapList_Result2.get(1));
//    	HashMap<List<String> , Integer> apriori = new HashMap<List<String> , Integer>( Tr.Apriori(2,20,dataset.getZoneAttribut(),dataset.getPerimetreAttribut(),dataset.getCompaciteAttribut(),dataset.getLongueurNoyauAttribut(),dataset.getLargeurNoyauAttribut(),dataset.getAsymetrieCoefficientAttribut(),dataset.getLongueurRainureNoyauAttribut()));
//    	apriori.entrySet().forEach(entry -> {
//    	    System.out.println(entry.getKey() + " => " + entry.getValue());
//    	});
//    	ArrayList<Rule> rules = new ArrayList<Rule>(Tr.GenerateAssociativeRules(apriori,0.60));
//    	System.out.println("----------- Rules -----------");
//    	for(Rule r : rules) {
//    		System.out.println(r.getLeft() +" => "+ r.getRight() + " || Conf = " + r.getConf()+ " || lift = " + r.getLift());
//    	}

//    	for(Row s:NZ_sc) {
//    		System.out.println(s.getClassString());
//    	}

//    	System.out.println(Tr.classification_naive_b(20,dataset.getRowsList(),"I13","I23","I33","I43","I53","I63","I74",4));
//    	List<ArrayList<Row>> MapList_Result = new ArrayList<ArrayList<Row>>(Tr.Split_Data(20,dataset.getRowsList()));
//    	System.out.println(MapList_Result.get(0));
//    	Values v;
//    	v = Tr.Test_classification_naive_b(20,dataset.getRowsList(),4);
//    	v = Tr.Test_Classification_knn(3,"Manhattan", 20, dataset.getRowsList());
//    	System.out.println("Accurancy C1 :"+v.getAccuracy()[0]);
//    	Tr.Classification_knn(5,"Manhattan", 20, dataset.getRowsList(), 16.82, 15.51 , 0.8786, 6.017, 3.486, 4.004, 5.841);
        GetTraitements();
    }


    private void ImportDATA(List<String> reader) {
        Row row;
        ArrayList<Row> instancesList = new ArrayList<>();
        HashMap<String, Integer> distribClasses = new HashMap<String, Integer> ();

        for (int i =0; i<reader.size(); i++){
            compteur = i+1;
            row = new Row(i+1,(reader.get(i).split("\\s+")));

            if (distribClasses.containsKey(row.getClassString()))
                distribClasses.put(row.getClassString(), distribClasses.get(row.getClassString()) + 1);
            else
                distribClasses.put(row.getClassString(), 1);

            instancesList.add(row);
        }
        dataset = new Dataset(instancesList);
        dataset.setClassesDistribution(distribClasses);
        NbrClasses.setText(String.valueOf(dataset.getNombreClasses()));
        rows = FXCollections.observableArrayList(dataset.getRowsList());

        AttributOcc.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getNInstance()).asObject());
        zoneAttr.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getZone())));
        perimetreAttr.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPerimetre())));
        compaciteAttr.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCompacite())));
        longueurNoyauAttr.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getLongueurNoyau())));
        largeurNoyauAttr.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getLargeurNoyau())));
        asymetrieCoefficientAttr.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAsymetrieCoefficient())));
        longueurRainureNoyauAttr.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getLongueurRainureNoyau())));
        Classe.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getClassString())));
        TableDataset.setItems(rows);

    }

    @FXML
    void normlizeBtnFunction(ActionEvent event) {
        Traitement Tr = new Traitement(dataset.getZoneAttribut());

        if(selectedTypeNormalization.getValue() == "Normalisation Z-score") {
            ArrayList<Row> instancesList = new ArrayList<Row>(Tr.Normalization_Z_Score(dataset.getZoneAttribut(),dataset.getPerimetreAttribut(),dataset.getCompaciteAttribut(),dataset.getLongueurNoyauAttribut(),dataset.getLargeurNoyauAttribut(),dataset.getAsymetrieCoefficientAttribut(),dataset.getLongueurRainureNoyauAttribut(),dataset.getclasseAttribut()));
            Row row;
            ArrayList<Row> NZ_sc = new ArrayList<>();
            for (int i =0; i<instancesList.size(); i++){
                row = new Row(i+1,instancesList.get(i).getRow().toArray(new String[0]));
                NZ_sc.add(row);
            }
            rowsNormal = FXCollections.observableArrayList(NZ_sc);
        }else if(selectedTypeNormalization.getValue() == "Normalisation Min-Max") {

            if((minNormal.getText().trim().isEmpty()) || (maxNormal.getText().trim().isEmpty())) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Veuillez remplir les deux champs", ButtonType.OK);
                alert.setTitle("Erreur");
                alert.showAndWait();
            }else {
                if(Integer.parseInt(minNormal.getText()) >= Integer.parseInt(maxNormal.getText())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Le max doit etre sup�rieur au min", ButtonType.OK);
                    alert.setTitle("Erreur");
                    alert.showAndWait();
                }else {
                    ArrayList<Row> instancesList = new ArrayList<Row>(Tr.Normalization_Min_Max(dataset.getZoneAttribut(),dataset.getPerimetreAttribut(),dataset.getCompaciteAttribut(),dataset.getLongueurNoyauAttribut(),dataset.getLargeurNoyauAttribut(),dataset.getAsymetrieCoefficientAttribut(),dataset.getLongueurRainureNoyauAttribut(),dataset.getclasseAttribut(),Integer.parseInt(minNormal.getText()),Integer.parseInt(maxNormal.getText())));
                    Row row;
                    ArrayList<Row> NZ_min_max = new ArrayList<>();
                    for (int i =0; i<instancesList.size(); i++){
                        row = new Row(i+1,instancesList.get(i).getRow().toArray(new String[0]));
                        NZ_min_max.add(row);
                    }
                    rowsNormal = FXCollections.observableArrayList(NZ_min_max);
                }

            }

        }

        AttributOcc1N.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getNInstance()).asObject());
        zoneAttr1N.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getZone())));
        perimetreAttr1N.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPerimetre())));
        compaciteAttr1N.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCompacite())));
        longueurNoyauAttr1N.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getLongueurNoyau())));
        largeurNoyauAttr1N.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getLargeurNoyau())));
        asymetrieCoefficientAttr1N.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAsymetrieCoefficient())));
        longueurRainureNoyauAttr1N.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getLongueurRainureNoyau())));
        Classe1N.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getClassString())));
        TableNormalization.setItems(rowsNormal);

    }

    @FXML
    void discritizateBtnFunction(ActionEvent event) {
        Traitement Tr = new Traitement(dataset.getZoneAttribut());

        if(inputDiscritizate.getText().trim().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Veuillez remplir le champ", ButtonType.OK);
            alert.setTitle("Erreur");
            alert.showAndWait();
        }else{
            if(selectedTypeDiscritization.getValue() == "Nombre de Quantiles") {
                int number = Integer.parseInt(inputDiscritizate.getText());
                ArrayList<ArrayList<String>> instance = Tr.Discretisation_Quentiles(dataset.getZoneAttribut(),dataset.getPerimetreAttribut(),dataset.getCompaciteAttribut(),dataset.getLongueurNoyauAttribut(),dataset.getLargeurNoyauAttribut(),dataset.getAsymetrieCoefficientAttribut(),dataset.getLongueurRainureNoyauAttribut(),dataset.getclasseAttribut(),number);
                RowDiscritization row;
                ArrayList<RowDiscritization> rowDisc = new ArrayList<>();
                for(int i=0 ; i<instance.size() ; i++) {
                    row = new RowDiscritization(i+1,instance.get(i).toArray(new String[0]));
                    rowDisc.add(row);
                }
                rowsDiscritizate = FXCollections.observableArrayList(rowDisc);
            }else if(selectedTypeDiscritization.getValue() == "Nombre d'intervalles") {
                int number = Integer.parseInt(inputDiscritizate.getText());
                ArrayList<ArrayList<String>> instance = Tr.Discretisation_intervalles_egaux(dataset.getZoneAttribut(),dataset.getPerimetreAttribut(),dataset.getCompaciteAttribut(),dataset.getLongueurNoyauAttribut(),dataset.getLargeurNoyauAttribut(),dataset.getAsymetrieCoefficientAttribut(),dataset.getLongueurRainureNoyauAttribut(),dataset.getclasseAttribut(),number);
                RowDiscritization row;
                ArrayList<RowDiscritization> rowDisc = new ArrayList<>();
                for(int i=0 ; i<instance.size() ; i++) {
                    row = new RowDiscritization(i+1,instance.get(i).toArray(new String[0]));
                    rowDisc.add(row);
                }
                rowsDiscritizate = FXCollections.observableArrayList(rowDisc);
            }
        }

        AttributOcc1D.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getNInstance()).asObject());
        zoneAttr1D.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getZone())));
        perimetreAttr1D.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getPerimetre())));
        compaciteAttr1D.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCompacite())));
        longueurNoyauAttr1D.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getLongueurNoyau())));
        largeurNoyauAttr1D.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getLargeurNoyau())));
        asymetrieCoefficientAttr1D.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAsymetrieCoefficient())));
        longueurRainureNoyauAttr1D.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getLongueurRainureNoyau())));
        Classe1D.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getClassString())));
        TableDiscritization.setItems(rowsDiscritizate);

    }

    @FXML
    void classificationFunction(ActionEvent event) {
        Traitement Tr = new Traitement(dataset.getZoneAttribut());
        int result = 0;
        if(selectedTypeClass.getValue() == "classification Na�ve Bay�sienne") {
            result = Tr.classification_naive_b(Integer.parseInt(inputTailleClass.getText()),dataset.getRowsList(),a1.getText(),a2.getText(),a3.getText(),a4.getText(),a5.getText(),a6.getText(),a7.getText(),Integer.parseInt(inputDiscClass.getText()));
        }else if(selectedTypeClass.getValue() == "classification KNN") {
            result = Tr.Classification_knn(Integer.parseInt(inputK.getText()),selectedFunctionKnn.getValue(), Integer.parseInt(inputTailleClass.getText()), dataset.getRowsList(),Double.parseDouble(a1.getText()),Double.parseDouble(a2.getText()),Double.parseDouble(a3.getText()),Double.parseDouble(a4.getText()),Double.parseDouble(a5.getText()),Double.parseDouble(a6.getText()),Double.parseDouble(a7.getText()));
        }
        String r ="";
        switch(result) {
            case 1:
                r = "Kama";
            case 2:
                r = "Rosa";
            case 3:
                r = "Canadian";
        }

        classResult.setText("La classe pr�dite est : "+r);
    }


    @FXML
    void TestCB(ActionEvent event) {

        Traitement Tr = new Traitement(dataset.getZoneAttribut());
        Values v = Tr.Test_classification_naive_b(Integer.parseInt(inputTestCB.getText()),dataset.getRowsList(),Integer.parseInt(inputIntervalCB.getText()));

        accuracy1.setText(String.format("%.3f",v.getAccuracy()[0]));
        rappel1.setText(String.format("%.3f",v.getRappel()[0]));
        specificity1.setText(String.format("%.3f",v.getAccuracy()[0]));
        precision1.setText(String.format("%.3f",v.getPrecision()[0]));
        sensitivity1.setText(String.format("%.3f",v.getSpecificity()[0]));
        fscore1.setText(String.format("%.3f",v.getF_SCORE()[0]));

        tp1.setText(String.valueOf(v.getClasses().get(1).get(0)));
        fn1.setText(String.valueOf(v.getClasses().get(1).get(1)));
        fp1.setText(String.valueOf(v.getClasses().get(1).get(2)));
        tn1.setText(String.valueOf(v.getClasses().get(1).get(3)));

        accuracy2.setText(String.format("%.3f",v.getAccuracy()[1]));
        rappel2.setText(String.format("%.3f",v.getRappel()[1]));
        specificity2.setText(String.format("%.3f",v.getAccuracy()[1]));
        precision2.setText(String.format("%.3f",v.getPrecision()[1]));
        sensitivity2.setText(String.format("%.3f",v.getSpecificity()[1]));
        fscore2.setText(String.format("%.3f",v.getF_SCORE()[1]));

        tp2.setText(String.valueOf(v.getClasses().get(2).get(0)));
        fn2.setText(String.valueOf(v.getClasses().get(2).get(1)));
        fp2.setText(String.valueOf(v.getClasses().get(2).get(2)));
        tn2.setText(String.valueOf(v.getClasses().get(2).get(3)));

        accuracy3.setText(String.format("%.3f",v.getAccuracy()[2]));
        rappel3.setText(String.format("%.3f",v.getRappel()[2]));
        specificity3.setText(String.format("%.3f",v.getAccuracy()[2]));
        precision3.setText(String.format("%.3f",v.getPrecision()[2]));
        sensitivity3.setText(String.format("%.3f",v.getSpecificity()[2]));
        fscore3.setText(String.format("%.3f",v.getF_SCORE()[2]));

        tp3.setText(String.valueOf(v.getClasses().get(3).get(0)));
        fn3.setText(String.valueOf(v.getClasses().get(3).get(1)));
        fp3.setText(String.valueOf(v.getClasses().get(3).get(2)));
        tn3.setText(String.valueOf(v.getClasses().get(3).get(3)));


        accuracy_m.setText(String.format("%.3f",v.getAccuracy_moyenne()));
        sensitivity_m.setText(String.format("%.3f",v.getSensitivity_moyenne()));
        specificity_m.setText(String.format("%.3f",v.getSpecificity_moyenne()));
        rappel_m.setText(String.format("%.3f",v.getRappel_moyenne()));
        precision_m.setText(String.format("%.3f",v.getPrecision_moyenne()));
        fscore_m.setText(String.format("%.3f",v.getF_SCORE_moyenne()));


        confusionCB = v.getConfusion();
    }


    @FXML
    void testKnn(ActionEvent event) {
        Traitement Tr = new Traitement(dataset.getZoneAttribut());
        Values v = Tr.Test_Classification_knn(Integer.parseInt(inputKTest.getText()),selectedFunctionTestKnn.getValue(),Integer.parseInt(inputTestKNN.getText()),dataset.getRowsList());

        accuracy11.setText(String.format("%.3f",v.getAccuracy()[0]));
        rappel11.setText(String.format("%.3f",v.getRappel()[0]));
        specificity11.setText(String.format("%.3f",v.getAccuracy()[0]));
        precision11.setText(String.format("%.3f",v.getPrecision()[0]));
        sensitivity11.setText(String.format("%.3f",v.getSpecificity()[0]));
        fscore11.setText(String.format("%.3f",v.getF_SCORE()[0]));

        tp11.setText(String.valueOf(v.getClasses().get(1).get(0)));
        fn11.setText(String.valueOf(v.getClasses().get(1).get(1)));
        fp11.setText(String.valueOf(v.getClasses().get(1).get(2)));
        tn11.setText(String.valueOf(v.getClasses().get(1).get(3)));

        accuracy21.setText(String.format("%.3f",v.getAccuracy()[1]));
        rappel21.setText(String.format("%.3f",v.getRappel()[1]));
        specificity21.setText(String.format("%.3f",v.getAccuracy()[1]));
        precision21.setText(String.format("%.3f",v.getPrecision()[1]));
        sensitivity21.setText(String.format("%.3f",v.getSpecificity()[1]));
        fscore21.setText(String.format("%.3f",v.getF_SCORE()[1]));

        tp21.setText(String.valueOf(v.getClasses().get(2).get(0)));
        fn21.setText(String.valueOf(v.getClasses().get(2).get(1)));
        fp21.setText(String.valueOf(v.getClasses().get(2).get(2)));
        tn21.setText(String.valueOf(v.getClasses().get(2).get(3)));

        accuracy31.setText(String.format("%.3f",v.getAccuracy()[2]));
        rappel31.setText(String.format("%.3f",v.getRappel()[2]));
        specificity31.setText(String.format("%.3f",v.getAccuracy()[2]));
        precision31.setText(String.format("%.3f",v.getPrecision()[2]));
        sensitivity31.setText(String.format("%.3f",v.getSpecificity()[2]));
        fscore31.setText(String.format("%.3f",v.getF_SCORE()[2]));

        tp31.setText(String.valueOf(v.getClasses().get(3).get(0)));
        fn31.setText(String.valueOf(v.getClasses().get(3).get(1)));
        fp31.setText(String.valueOf(v.getClasses().get(3).get(2)));
        tn31.setText(String.valueOf(v.getClasses().get(3).get(3)));

        accuracy_m1.setText(String.format("%.3f",v.getAccuracy_moyenne()));
        sensitivity_m1.setText(String.format("%.3f",v.getSensitivity_moyenne()));
        specificity_m1.setText(String.format("%.3f",v.getSpecificity_moyenne()));
        rappel_m1.setText(String.format("%.3f",v.getRappel_moyenne()));
        precision_m1.setText(String.format("%.3f",v.getPrecision_moyenne()));
        fscore_m1.setText(String.format("%.3f",v.getF_SCORE_moyenne()));

        confusionKNN = v.getConfusion();
    }

    @FXML
    void showConfusion(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.NONE,"La matrice de confusion de la classification naive",ButtonType.OK);
        alert.setTitle("Matrice de confusion");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.addRow(0,new Label(""), new Label("Kama"), new Label("Rosa"), new Label("Canandian"));
        grid.addRow(1, new Label("Kama"), new Label(String.valueOf(confusionCB[0][0])),  new Label(String.valueOf(confusionCB[0][1])), new Label(String.valueOf(confusionCB[0][2])));
        grid.addRow(2, new Label("Rosa"), new Label(String.valueOf(confusionCB[1][0])),  new Label(String.valueOf(confusionCB[1][1])), new Label(String.valueOf(confusionCB[1][2])));
        grid.addRow(3, new Label("Canadian"), new Label(String.valueOf(confusionCB[2][0])),  new Label(String.valueOf(confusionCB[2][1])), new Label(String.valueOf(confusionCB[2][2])));

        grid.setGridLinesVisible(false);
        ColumnConstraints center = new ColumnConstraints();
        center.setHalignment(HPos.CENTER);
        grid.getColumnConstraints().setAll(new ColumnConstraints(), center);

        alert.getDialogPane().setContent(grid);
        alert.showAndWait();
    }


    @FXML
    void showConfusion1(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.NONE,"La matrice de confusion de la classification KNN",ButtonType.OK);
        alert.setTitle("Matrice de confusion");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.addRow(0,new Label(""), new Label("Kama"), new Label("Rosa"), new Label("Canandian"));
        grid.addRow(1, new Label("Kama"), new Label(String.valueOf(confusionKNN[0][0])),  new Label(String.valueOf(confusionKNN[0][1])), new Label(String.valueOf(confusionKNN[0][2])));
        grid.addRow(2, new Label("Rosa"), new Label(String.valueOf(confusionKNN[1][0])),  new Label(String.valueOf(confusionKNN[1][1])), new Label(String.valueOf(confusionKNN[1][2])));
        grid.addRow(3, new Label("Canadian"), new Label(String.valueOf(confusionKNN[2][0])),  new Label(String.valueOf(confusionKNN[2][1])), new Label(String.valueOf(confusionKNN[2][2])));

        grid.setGridLinesVisible(false);
        ColumnConstraints center = new ColumnConstraints();
        center.setHalignment(HPos.CENTER);
        grid.getColumnConstraints().setAll(new ColumnConstraints(), center);

        alert.getDialogPane().setContent(grid);
        alert.showAndWait();
    }





    @FXML
    void deleteRow(ActionEvent event) {
        this.compteur = this.compteur - 1;
        dataset.removeRow(TableDataset.getSelectionModel().getSelectedItems().get(0));
        TableDataset.getItems().removeAll(
                TableDataset.getSelectionModel().getSelectedItems()
        );
        NbrInstances.setText(String.valueOf(this.compteur));
    }

    @FXML
    void newRow(ActionEvent event) {
        Modal newModal = new Modal();
        newModal.Show();
        Row newRow = newModal.nrc.getNewRow();
        if (newRow!=null){
            this.compteur = this.compteur + 1;
            dataset.addRow(newRow,compteur);
            rows = FXCollections.observableArrayList(dataset.getRowsList());
            TableDataset.setItems(rows);
        }
        NbrInstances.setText(String.valueOf(this.compteur));
    }




    @FXML
    void SaveDATA(ActionEvent event) throws IOException {
        FileChooser File = new FileChooser();
        FileChooser.ExtensionFilter extention = new FileChooser.ExtensionFilter("(.txt)", "*.txt");
        File.getExtensionFilters().add(extention);
        File f = File.showSaveDialog(null);
        String currentDataset = "";
        ArrayList<Row> Rows = dataset.getRowsList();
        for(int i = 0;i<Rows.size();i++) {
            currentDataset += Rows.get(i).getRow().get(0)+" "+Rows.get(i).getRow().get(1)+" "+Rows.get(i).getRow().get(2)+" "+Rows.get(i).getRow().get(3)+" "+Rows.get(i).getRow().get(4)+" "+Rows.get(i).getRow().get(5)+" "+Rows.get(i).getRow().get(6)+" "+Rows.get(i).getRow().get(7)+" \n";
        }

        if (f != null) {

            try {
                PrintWriter Pw;
                Pw = new PrintWriter(f);
                Pw.println(currentDataset);
                Pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @FXML
    void ImportDATA(ActionEvent event) {

        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("(.txt)","*.txt" ));
        File f = fc.showOpenDialog(null);
        if (f!= null)
        {
            try {

                List<String> reader = Files.readAllLines(Paths.get(f.getAbsolutePath()));
                ImportDATA(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    private void GetTraitements() {

        Select.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number Val, Number Val2) {
                String quartiles = "";
                HashMap<String, Double> Data = new HashMap<String, Double>();
                HashMap<String, ArrayList<Double>> Data2 = new HashMap<String, ArrayList<Double>>();
                String Symetrie ="";
                Graphique_Class.setVisible(false);
                GraphDiv1.setVisible(true);
                GraphDiv2.setVisible(true);
                if(Select.getItems().get((Integer) Val2).equals("Surface")){
                    dataset.setZoneInfos();
                    Data = dataset.getZoneInfos();
                    Data2 = dataset.getZoneInfos2();
                    Symetrie = dataset.getzoneSymetrie();
                    Attr_Symetrie.setVisible(true);
                } else if(Select.getItems().get((Integer) Val2).equals("P�rim�tre")){
                    dataset.setPerimetreInfos();
                    Data = dataset.getPerimetreInfos();
                    Data2 = dataset.getPerimetreInfos2();
                    Symetrie = dataset.getperimetreSymetrie();
                    Attr_Symetrie.setVisible(true);
                } else if(Select.getItems().get((Integer) Val2).equals("Compacit�")){
                    dataset.setCompaciteInfos();
                    Data = dataset.getCompaciteInfos();
                    Data2 = dataset.getCompaciteInfos2();
                    Symetrie = dataset.getcompaciteSymetrie();
                    Attr_Symetrie.setVisible(true);
                } else if(Select.getItems().get((Integer) Val2).equals("Longueur du grain")){
                    dataset.setLongueurNoyauInfos();
                    Data = dataset.getLongueurNoyauInfos();
                    Data2 = dataset.getLongueurNoyauInfos2();
                    Symetrie = dataset.getlongueurNoyauSymetrie();
                    Attr_Symetrie.setVisible(true);
                } else if(Select.getItems().get((Integer) Val2).equals("Largeur du grain")){
                    dataset.setLargeurNoyauInfos();
                    Data = dataset.getLargeurNoyauInfos();
                    Data2 = dataset.getLargeurNoyauInfos2();
                    Symetrie = dataset.getlargeurNoyauSymetrie();
                    Attr_Symetrie.setVisible(true);
                } else if(Select.getItems().get((Integer) Val2).equals("Coefficient d'asym�trie")){
                    dataset.setAsymetrieCoefficientInfos();
                    Data = dataset.getAsymetrieCoefficientInfos();
                    Data2 = dataset.getAsymetrieCoefficientInfos2();
                    Symetrie = dataset.getasymetrieCoefficientSymetrie();
                    Attr_Symetrie.setVisible(true);
                }else if(Select.getItems().get((Integer) Val2).equals("Longueur du sillon du noyau")){
                    dataset.setLongueurRainureNoyauInfos();
                    Data = dataset.getLongueurRainureNoyauInfos();
                    Data2 = dataset.getLongueurRainureNoyauInfos2();
                    Symetrie = dataset.getlongueurRainureNoyauSymetrie();
                    Attr_Symetrie.setVisible(true);
                }else if(Select.getItems().get((Integer) Val2).equals("Classe")){
                    GraphDiv1.setVisible(false);
                    GraphDiv2.setVisible(false);
                    Attr_Symetrie.setVisible(false);
                    Graphique_Class.setVisible(true);
                    Graph graph = new Graph();
                    JFreeChart JFc = graph.DistributionClassesPie(dataset);
                    ChartPanel cp = new ChartPanel(JFc);

                    Graphique_Class.setContent(cp);
                    new Timer().schedule(new TimerTask() {
                        public void run() {
                            Graphique_Class.getContent().repaint();
                        }
                    }, 200);
                }

                quartiles = "("+String.format("%.3f", Data.get("Min")) +" , "+String.format("%.3f",Data.get("Q1"))+" , "+String.format("%.3f",Data.get("Mediane"))+" , "+String.format("%.3f",Data.get("Q3"))+" , "+String.format("%.3f",Data.get("Max"))+ ")";
                Attr_quartiles.setText(quartiles);
                Attr_Moyenne.setText(String.format("%.3f",Data.get("Moyenne")));
                Attr_Mediane.setText(String.format("%.3f",Data.get("Mediane")));
                Attr_Etendue.setText(String.format("%.3f",Data.get("Etendue")));
                Attr_Midrange.setText(String.format("%.3f",Data.get("Midrange")));
                Attr_IQR.setText(String.format("%.3f",Data.get("IQR")));
                Attr_Variance.setText(String.format("%.3f",Data.get("Variance")));
                Attr_EcartType.setText(String.format("%.3f",Data.get("EcartType")));
                Attr_MoyenneTronquee.setText(String.format("%.3f",Data.get("MoyenneTronquee")));
                Attr_Mode.setText(Data2.get("Mode").toString());
                Attr_Symetrie.setText(Symetrie);
                Attr_ValeursAberrantes.setText(Data2.get("ValeursAberrantes").toString());
            }
        });

        Selected1.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number Val, Number Val2) {
                if(Selected1.getItems().get((Integer) Val2).equals("Surface")){
                    Att1 = dataset.getZoneAttribut();
                } else if(Selected1.getItems().get((Integer) Val2).equals("P�rim�tre")){
                    Att1 = dataset.getPerimetreAttribut();
                } else if(Selected1.getItems().get((Integer) Val2).equals("Compacit�")){
                    Att1 = dataset.getCompaciteAttribut();
                } else if(Selected1.getItems().get((Integer) Val2).equals("Longueur du grain")){
                    Att1 = dataset.getLongueurNoyauAttribut();
                } else if(Selected1.getItems().get((Integer) Val2).equals("Largeur du grain")){
                    Att1 = dataset.getLargeurNoyauAttribut();
                } else if(Selected1.getItems().get((Integer) Val2).equals("Coefficient d'asym�trie")){
                }else if(Selected1.getItems().get((Integer) Val2).equals("Longueur du sillon du noyau")) {
                    Att1 = dataset.getLongueurRainureNoyauAttribut();
                }
            }
        });
        Selected2.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number Val, Number Val2) {
                if(Selected2.getItems().get((Integer) Val2).equals("Surface")){
                    dataset.setZoneAttribut();
                    Att2 = dataset.getZoneAttribut();
                } else if(Selected2.getItems().get((Integer) Val2).equals("P�rim�tre")){
                    dataset.setPerimetreAttribut();
                    Att2 = dataset.getPerimetreAttribut();
                } else if(Selected2.getItems().get((Integer) Val2).equals("Compacit�")){
                    dataset.setCompaciteAttribut();
                    Att2 = dataset.getCompaciteAttribut();
                } else if(Selected2.getItems().get((Integer) Val2).equals("Longueur du grain")){
                    dataset.setLongueurNoyauAttribut();
                    Att2 = dataset.getLongueurNoyauAttribut();
                } else if(Selected2.getItems().get((Integer) Val2).equals("Largeur du grain")){
                    dataset.setLargeurNoyauAttribut();
                    Att2 = dataset.getLargeurNoyauAttribut();
                } else if(Selected2.getItems().get((Integer) Val2).equals("Coefficient d'asym�trie")){
                    dataset.setAsymetrieCoefficientAttribut();
                    Att2 = dataset.getAsymetrieCoefficientAttribut();
                }else if(Selected2.getItems().get((Integer) Val2).equals("Longueur du sillon du noyau")) {
                    dataset.setLongueurRainureNoyauAttribut();
                    Att2 = dataset.getLongueurRainureNoyauAttribut();
                }
            }
        });



    }


    @FXML
    void DisplayGraphique(ActionEvent event) {
        JFreeChart JFc = null;
        Graph graph = new Graph();
        if(Selected1.getValue() != "S�lectionner l'attribut") {

            if (CheckHisto.isSelected()){
                JFc = graph.Histogramme(Att1);
            } else if (CheckBoxP.isSelected()){
                JFc = graph.BoiteMoustache(Att1, Selected1.getValue());
            } else {

                if(Selected2.getValue() != "S�lectionner l'attribut") {
                    if (CheckScatterP.isSelected() & !Selected1.getValue().equals(Selected2.getValue())){
                        JFc = graph.nuagePoint(Att1, Att2);
                    }
                    else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Veuillez s�lectionner 2 attributs diff�rents", ButtonType.OK);
                        alert.setTitle("Erreur");
                        alert.showAndWait();
                        return;
                    }
                }else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "Le champs attribut est vide.", ButtonType.OK);
                    alert.setTitle("Erreur");
                    alert.showAndWait();
                    return;
                }}

            ChartPanel cp = new ChartPanel(JFc);
            Graphique_Attr.setContent(cp);

            TimerTask task = new TimerTask() {
                public void run() {
                    Graphique_Attr.getContent().repaint();
                }
            };
            Timer timer = new Timer("Timer");
            long delay = 1000L;
            timer.schedule(task, delay);
            Platform.runLater(() -> Graphique_Attr.getContent().repaint());

        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Le champs attribut est vide.", ButtonType.OK);
            alert.setTitle("Erreur");
            alert.showAndWait();
        }
    }



    class Modal {
        newRowController nrc;
        void Show() {
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setResizable(false);
            stage.setTitle("Nouvelle ligne");

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("newRow.fxml"));
                Parent root = loader.load();
                root.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

                stage.setScene(new Scene(root));
                nrc = loader.getController();
                nrc.setStage(stage);
            } catch (IOException e){
                e.printStackTrace();
            }
            stage.showAndWait();
        }
    }

}
