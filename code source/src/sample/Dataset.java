package sample;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.lang.Math;
import java.text.DecimalFormat;
import java.util.Comparator;

public class Dataset {
    ArrayList<Row> rowsList;
    int nombreAttributs;
    HashMap<String, Integer> classesDistribution;
    int rowCpt =0;

    public Dataset() {}
    public Dataset(ArrayList<Row> rowsList) {
        this.rowsList = rowsList;
    }

    public ArrayList<Row> getRowsList() {
        return rowsList;
    }

    public void setRowsList(ArrayList<Row> rowsList) {
        this.rowCpt = rowsList.size();
        this.rowsList = rowsList;
    }


    public void addRow(Row row,int i) {
        row.setNInstance(i);
        this.rowsList.add(row);
    }

    public void removeRow(Row row) {
        this.rowsList.remove(row);
    }

    public int getNombreClasses() {
        return classesDistribution.size();
    }

    public HashMap<String, Integer> getClassesDistribution() {
        return classesDistribution;
    }

    public void setClassesDistribution(HashMap<String, Integer> classesDistribution) {
        this.classesDistribution = classesDistribution;
    }


    ArrayList<Double> zoneAttribut;
    ArrayList<Double> perimetreAttribut;
    ArrayList<Double> compaciteAttribut;
    ArrayList<Double> longueurNoyauAttribut;
    ArrayList<Double> largeurNoyauAttribut;
    ArrayList<Double> asymetrieCoefficientAttribut;
    ArrayList<Double> longueurRainureNoyauAttribut;
    ArrayList<Integer> classeAttribut;

    public ArrayList<Double> getZoneAttribut() {
        return zoneAttribut;
    }
    public ArrayList<Double> getPerimetreAttribut() {
        return perimetreAttribut;
    }
    public ArrayList<Double> getCompaciteAttribut() {
        return compaciteAttribut;
    }
    public ArrayList<Double> getLongueurNoyauAttribut() {
        return longueurNoyauAttribut;
    }
    public ArrayList<Double> getLargeurNoyauAttribut() {
        return largeurNoyauAttribut;
    }
    public ArrayList<Double> getAsymetrieCoefficientAttribut() {
        return asymetrieCoefficientAttribut;
    }
    public ArrayList<Double> getLongueurRainureNoyauAttribut() {
        return longueurRainureNoyauAttribut;
    }
    public ArrayList<Integer> getclasseAttribut() {
        return classeAttribut;
    }

    public void setZoneAttribut() {
        ArrayList<Double> attribut = new ArrayList<>();
        for(Row row: this.rowsList){
            attribut.add(row.getZone());
        }
        this.zoneAttribut = attribut;
    }

    public void setPerimetreAttribut() {
        ArrayList<Double> attribut = new ArrayList<>();
        for(Row row: this.rowsList){
            attribut.add(row.getPerimetre());
        }
        this.perimetreAttribut = attribut;
    }

    public void setCompaciteAttribut() {
        ArrayList<Double> attribut = new ArrayList<>();
        for(Row row: this.rowsList){
            attribut.add(row.getCompacite());
        }
        this.compaciteAttribut = attribut;
    }

    public void setLongueurNoyauAttribut() {
        ArrayList<Double> attribut = new ArrayList<>();
        for(Row row: this.rowsList){
            attribut.add(row.getLongueurNoyau());
        }
        this.longueurNoyauAttribut = attribut;
    }

    public void setLargeurNoyauAttribut() {
        ArrayList<Double> attribut = new ArrayList<>();
        for(Row row: this.rowsList){
            attribut.add(row.getLargeurNoyau());
        }
        this.largeurNoyauAttribut = attribut;
    }

    public void setAsymetrieCoefficientAttribut() {
        ArrayList<Double> attribut = new ArrayList<>();
        for(Row row: this.rowsList){
            attribut.add(row.getAsymetrieCoefficient());
        }
        this.asymetrieCoefficientAttribut = attribut;
    }

    public void setLongueurRainureNoyauAttribut() {
        ArrayList<Double> attribut = new ArrayList<>();
        for(Row row: this.rowsList){
            attribut.add(row.getLongueurRainureNoyau());
        }
        this.longueurRainureNoyauAttribut = attribut;
    }

    public void setClasseAttribut() {
        ArrayList<Integer> attribut = new ArrayList<>();
        for(Row row: this.rowsList){
            attribut.add(row.getClasse());
        }
        this.classeAttribut = attribut;
    }

    public void setData() {
        setZoneAttribut();
        setPerimetreAttribut();
        setCompaciteAttribut();
        setLongueurNoyauAttribut();
        setLargeurNoyauAttribut();
        setAsymetrieCoefficientAttribut();
        setLongueurRainureNoyauAttribut();
        setClasseAttribut();
    }

    private HashMap<String, Double> zoneInfos;
    private HashMap<String, ArrayList<Double>> zoneInfos2 = new HashMap<String, ArrayList<Double>>();
    private String zoneSymetrie;
    private HashMap<String, Double> perimetreInfos;
    private HashMap<String, ArrayList<Double>> perimetreInfos2 = new HashMap<String, ArrayList<Double>>();
    private String perimetreSymetrie;
    private HashMap<String, Double> compaciteInfos;
    private HashMap<String, ArrayList<Double>> compaciteInfos2 = new HashMap<String, ArrayList<Double>>();
    private String compaciteSymetrie;
    private HashMap<String, Double> longueurNoyauInfos;
    private HashMap<String, ArrayList<Double>> longueurNoyauInfos2 = new HashMap<String, ArrayList<Double>>();
    private String longueurNoyauSymetrie;
    private HashMap<String, Double> largeurNoyauInfos;
    private HashMap<String, ArrayList<Double>> largeurNoyauInfos2 = new HashMap<String, ArrayList<Double>>();
    private String largeurNoyauSymetrie;
    private HashMap<String, Double> asymetrieCoefficientInfos;
    private HashMap<String, ArrayList<Double>> asymetrieCoefficientInfos2 = new HashMap<String, ArrayList<Double>>();
    private String asymetrieCoefficientSymetrie;
    private HashMap<String, Double> LongueurRainureNoyauInfos;
    private HashMap<String, ArrayList<Double>> LongueurRainureNoyauInfos2 = new HashMap<String, ArrayList<Double>>();
    private String longueurRainureNoyauSymetrie;

    public HashMap<String, Double> getZoneInfos() {
        return zoneInfos;
    }
    public HashMap<String, Double> getPerimetreInfos() {
        return perimetreInfos;
    }
    public HashMap<String, Double> getCompaciteInfos() {
        return compaciteInfos;
    }
    public HashMap<String, Double> getLongueurNoyauInfos() {
        return longueurNoyauInfos;
    }
    public HashMap<String, Double> getLargeurNoyauInfos() {
        return largeurNoyauInfos;
    }
    public HashMap<String, Double> getAsymetrieCoefficientInfos() {
        return asymetrieCoefficientInfos;
    }
    public HashMap<String, Double> getLongueurRainureNoyauInfos() {
        return LongueurRainureNoyauInfos;
    }
    public HashMap<String, ArrayList<Double>> getZoneInfos2() {
        return zoneInfos2;
    }
    public HashMap<String, ArrayList<Double>> getPerimetreInfos2() {
        return perimetreInfos2;
    }
    public HashMap<String, ArrayList<Double>> getCompaciteInfos2() {
        return compaciteInfos2;
    }
    public HashMap<String, ArrayList<Double>> getLongueurNoyauInfos2() {
        return longueurNoyauInfos2;
    }
    public HashMap<String, ArrayList<Double>> getLargeurNoyauInfos2() {
        return largeurNoyauInfos2;
    }
    public HashMap<String, ArrayList<Double>> getAsymetrieCoefficientInfos2() {
        return asymetrieCoefficientInfos2;
    }
    public HashMap<String, ArrayList<Double>> getLongueurRainureNoyauInfos2() {
        return LongueurRainureNoyauInfos2;
    }

    public String getzoneSymetrie() {
        return zoneSymetrie;
    }
    public String getperimetreSymetrie() {
        return perimetreSymetrie;
    }
    public String getcompaciteSymetrie() {
        return compaciteSymetrie;
    }
    public String getlongueurNoyauSymetrie() {
        return longueurNoyauSymetrie;
    }
    public String getlargeurNoyauSymetrie() {
        return largeurNoyauSymetrie;
    }
    public String getasymetrieCoefficientSymetrie() {
        return asymetrieCoefficientSymetrie;
    }
    public String getlongueurRainureNoyauSymetrie() {
        return longueurRainureNoyauSymetrie;
    }



    public void setZoneInfos() {
        setZoneAttribut();
        Traitement Tr = new Traitement(getZoneAttribut());

        this.zoneInfos = Tr.Data;
        this.zoneInfos2 = Tr.Data2;
        this.zoneSymetrie = Tr.Symetrie;
    }

    public void setPerimetreInfos() {
        setPerimetreAttribut();
        Traitement Tr = new Traitement(getPerimetreAttribut());
        this.perimetreInfos = Tr.Data;
        this.perimetreInfos2 = Tr.Data2;
        this.perimetreSymetrie = Tr.Symetrie;
    }

    public void setCompaciteInfos() {
        setCompaciteAttribut();
        Traitement Tr = new Traitement(getCompaciteAttribut());
        this.compaciteInfos = Tr.Data;
        this.compaciteInfos2 = Tr.Data2;
        this.compaciteSymetrie = Tr.Symetrie;
    }

    public void setLongueurNoyauInfos() {
        setLongueurNoyauAttribut();
        Traitement Tr = new Traitement(getLongueurNoyauAttribut());
        this.longueurNoyauInfos = Tr.Data;
        this.longueurNoyauInfos2 = Tr.Data2;
        this.longueurNoyauSymetrie = Tr.Symetrie;
    }

    public void setLargeurNoyauInfos() {
        setLargeurNoyauAttribut();
        Traitement Tr = new Traitement(getLargeurNoyauAttribut());
        this.largeurNoyauInfos = Tr.Data;
        this.largeurNoyauInfos2 = Tr.Data2;
        this.largeurNoyauSymetrie = Tr.Symetrie;
    }

    public void setAsymetrieCoefficientInfos() {
        setAsymetrieCoefficientAttribut();
        Traitement Tr = new Traitement(getAsymetrieCoefficientAttribut());
        this.asymetrieCoefficientInfos = Tr.Data;
        this.asymetrieCoefficientInfos2 = Tr.Data2;
        this.asymetrieCoefficientSymetrie = Tr.Symetrie;
    }

    public void setLongueurRainureNoyauInfos() {
        setLongueurRainureNoyauAttribut();
        Traitement Tr = new Traitement(getLongueurRainureNoyauAttribut());
        this.LongueurRainureNoyauInfos = Tr.Data;
        this.LongueurRainureNoyauInfos2 = Tr.Data2;
        this.longueurRainureNoyauSymetrie = Tr.Symetrie;
    }

}


class Traitement {

    ArrayList<Double> attribut;
    HashMap<String, Double> Data = new HashMap<String, Double>();
    HashMap<String, ArrayList<Double>> Data2 = new HashMap<String, ArrayList<Double>>();
    String Symetrie;
    public  Traitement(ArrayList<Double> attribut) {
        this.attribut = attribut;

        this.Data.put("Min", Min(this.attribut));
        this.Data.put("Max", Max(this.attribut));
        this.Data.put("Moyenne", Moyenne(this.attribut));
        this.Data.put("Mediane",Mediane(this.attribut));
        this.Data.put("Q1",Q1(this.attribut));
        this.Data.put("Q3",Q3(this.attribut));
        this.Data.put("IQR",IQR(this.attribut));
        this.Data.put("Midrange",Midrange(this.attribut));
        this.Data.put("Etendue",Etendue(this.attribut));
        this.Data.put("Variance",Variance(this.attribut));
        this.Data.put("EcartType",EcartType(this.attribut));
        this.Data.put("MoyenneTronquee",MoyenneTronquee(this.attribut));

        this.Data2.put("Mode",Mode(this.attribut));
        this.Data2.put("ValeursAberrantes",Vaberrantes(this.attribut));

        this.Symetrie = typeSymetrie(this.attribut);

    }

    public double Somme(ArrayList<Double> c) {
        double s = 0.0;
        for(Double value: c){ s += value;}
        return s;
    }

    public double Moyenne(ArrayList<Double> c) {
        return Somme(c)/c.size();
    }

    public double Min(ArrayList<Double> c) {
        ArrayList<Double> newList = new ArrayList<>(c);
        Collections.sort(newList);
        return newList.get(0);
    }
    public double Max(ArrayList<Double> c) {
        ArrayList<Double> newList = new ArrayList<>(c);
        Collections.sort(newList);
        return newList.get(newList.size()-1);
    }

    public double Mediane(ArrayList<Double> c) {

        if (c.size() % 2 == 0){
            return (c.get((c.size()/2)-1)+c.get(c.size()/2))/2;
        }
        else{
            return c.get((c.size()/2));
        }
    }

    public double Q1(ArrayList<Double> c) {
        int position;
        if (c.size()%4 ==0 ) {
            position = (int) (c.size()/4);
        }else {
            position = (int) (c.size()/4)+1;
        }
        return c.get(position);
    }

    public double Q3(ArrayList<Double> c) {
        int position;
        if ((c.size()*3)%4 ==0 ) {
            position = (int) ((c.size()*3)/4);
        }else {
            position = (int) ((c.size()*3)/4)+1;
        }
        return c.get(position);
    }

    public double IQR(ArrayList<Double> c){
        return Q3(c)-Q1(c);
    }

    public double Midrange(ArrayList<Double> c){
        return (Min(c)+Max(c))/2;
    }

    public double Etendue(ArrayList<Double> c){
        return Max(c)-Min(c);
    }

    public double Variance(ArrayList<Double> c){
        double sc = 0;
        for(int i = 0; i <c.size(); i++){
            sc += Math.pow(c.get(i)-Moyenne(c), 2);
        }
        return sc/c.size();
    }

    public double EcartType(ArrayList<Double> c){
        return Math.sqrt(Variance(c));
    }

    public double MoyenneTronquee(ArrayList<Double> c){

        int nb = (int) 0.2*c.size();

        double s =0;
        for(int i=nb;i<(c.size()-nb);i++){
            s += c.get(i);
        }
        return s/(c.size()-(nb*2));
    }

    public ArrayList<Double> Vaberrantes(ArrayList<Double> c){
        ArrayList<Double> out = new ArrayList<Double>();
        double BorneInf = Q1(c)-1.5*IQR(c);
        double BorneSup = Q3(c)+1.5*IQR(c);
        for(int i = 0; i <c.size(); i++){
            if(c.get(i)< BorneInf || c.get(i)>BorneSup){
                out.add(c.get(i));
            }
        }
        return out;
    }

    public Map<Double,Integer> Occurence (ArrayList<Double> c){

        Map<Double,Integer> Occ = new HashMap<Double, Integer>();
        int cpt;

        for (int i =0; i<c.size(); i++) {
            if(!Occ.containsKey(c.get(i)))
            {

                cpt=1;
                for (int j=i+1;j<c.size(); j++){
                    if(Double.compare(c.get(i),c.get(j)) == 0){
                        cpt++;
                    }
                }
                Occ.put(c.get(i), cpt);
            }
        }


        return Occ;
    }

    public ArrayList<Double> Mode(ArrayList<Double> c){

        ArrayList<Double> modes = new ArrayList<Double>();
        Map<Double,Integer> frequences = new HashMap<Double, Integer>();

        frequences = Occurence(c);

        int Maxf = Collections.max(frequences.values());
        if(Maxf == 1){

            return new ArrayList<Double>();

        }else{
            for(Map.Entry elem : frequences.entrySet()){

                if((int) elem.getValue()==Maxf){
                    modes.add((double) elem.getKey());
                }
            }
            return modes;
        }

    }

    public String typeSymetrie(ArrayList<Double> c){
        String str = null;

        if(Mode(c).size()==0){
            str ="Sym�trie ind�finie (pas de mode)";
        }
        else{
            if(this.Mode(c).size() == 1){
                if ((int) Math.abs(Mediane(c) - Moyenne(c)) == 0 && (int) Math.abs(Mediane(c) - Mode(c).get(0).intValue()) == 0){
                    str="Sym�trique";
                }
                else {


                    if(Moyenne(c)> Mediane(c)){
                        if(Mediane(c) > Mode(c).get(0)){
                            str="Positivement Sym�trique";
                        }
                    }
                    else{
                        if(Moyenne(c)< Mediane(c)){
                            if(Mediane(c) < Mode(c).get(0)){
                                str="N�gativement Sym�trique";
                            }
                        }
                    }
                }
            }
            else {

                str ="Sym�trie ind�finie -> plusieurs modes";
            }
        }
        return str;

    }
    public ArrayList<Double> Normalization_Min_Max_ForAttr (ArrayList<Double> c,double Valeur_Min_N,double Valeur_Max_N ){

        ArrayList<Double> normalized = new ArrayList<Double>();
        double max = Max(c);
        double min = Min(c);
        double tmp = 0;
        for (int i =0; i<c.size(); i++) {
            tmp = ((c.get(i) - min )/(max-min))*(Valeur_Max_N - Valeur_Min_N)+Valeur_Min_N;
            normalized.add(i,tmp) ;
        }

        return normalized;
    }
    public ArrayList<Row> Normalization_Min_Max (ArrayList<Double> a1 , ArrayList<Double> a2 , ArrayList<Double> a3 , ArrayList<Double> a4 , ArrayList<Double> a5 , ArrayList<Double> a6 , ArrayList<Double> a7 , ArrayList<Integer> classe , double Valeur_Min_N,double Valeur_Max_N ) {

        ArrayList<Double> zone = new ArrayList<>(Normalization_Min_Max_ForAttr(a1,Valeur_Min_N,Valeur_Max_N));
        ArrayList<Double> perimetre = new ArrayList<>(Normalization_Min_Max_ForAttr(a2,Valeur_Min_N,Valeur_Max_N));
        ArrayList<Double> compacite = new ArrayList<>(Normalization_Min_Max_ForAttr(a3,Valeur_Min_N,Valeur_Max_N));
        ArrayList<Double> LongueurNoyau = new ArrayList<>(Normalization_Min_Max_ForAttr(a4,Valeur_Min_N,Valeur_Max_N));
        ArrayList<Double> LargeurNoyau = new ArrayList<>(Normalization_Min_Max_ForAttr(a5,Valeur_Min_N,Valeur_Max_N));
        ArrayList<Double> AsymetrieCoefficient = new ArrayList<>(Normalization_Min_Max_ForAttr(a6,Valeur_Min_N,Valeur_Max_N));
        ArrayList<Double> LongueurRainureNoyau = new ArrayList<>(Normalization_Min_Max_ForAttr(a7,Valeur_Min_N,Valeur_Max_N));

        ArrayList<Row> Tmp = new ArrayList<Row>();

        for(int i=0 ; i<a1.size() ; i++) {
            Tmp.add(new Row(zone.get(i),perimetre.get(i),compacite.get(i),LongueurNoyau.get(i),LargeurNoyau.get(i),AsymetrieCoefficient.get(i), LongueurRainureNoyau.get(i),classe.get(i)));
        }

        return Tmp;
    }

    public ArrayList<Double> Normalization_Z_Score_ForAttr (ArrayList<Double> c){
        ArrayList<Double> normalized = new ArrayList<Double>();
        double tmp = 0;
        double moyenne = Moyenne(c);
        double S = S_function(c);
        for (int i =0; i<c.size(); i++) {
            tmp = (c.get(i)-moyenne)/S;
            normalized.add(i,tmp) ;
        }
        return normalized;
    }

    public ArrayList<Row> Normalization_Z_Score (ArrayList<Double> a1 , ArrayList<Double> a2 , ArrayList<Double> a3 , ArrayList<Double> a4 , ArrayList<Double> a5 , ArrayList<Double> a6 , ArrayList<Double> a7 , ArrayList<Integer> classe ) {

        ArrayList<Double> zone = new ArrayList<>(Normalization_Z_Score_ForAttr(a1));
        ArrayList<Double> perimetre = new ArrayList<>(Normalization_Z_Score_ForAttr(a2));
        ArrayList<Double> compacite = new ArrayList<>(Normalization_Z_Score_ForAttr(a3));
        ArrayList<Double> LongueurNoyau = new ArrayList<>(Normalization_Z_Score_ForAttr(a4));
        ArrayList<Double> LargeurNoyau = new ArrayList<>(Normalization_Z_Score_ForAttr(a5));
        ArrayList<Double> AsymetrieCoefficient = new ArrayList<>(Normalization_Z_Score_ForAttr(a6));
        ArrayList<Double> LongueurRainureNoyau = new ArrayList<>(Normalization_Z_Score_ForAttr(a7));

        ArrayList<Row> Tmp = new ArrayList<Row>();

        for(int i=0 ; i<a1.size() ; i++) {
            Tmp.add(new Row(zone.get(i),perimetre.get(i),compacite.get(i),LongueurNoyau.get(i),LargeurNoyau.get(i),AsymetrieCoefficient.get(i), LongueurRainureNoyau.get(i),classe.get(i)));
        }

        return Tmp;
    }




    private Double S_function( ArrayList<Double> c ) {
        double somme = 0;
        double moyenne = Moyenne(c);
        for(int i=0;i<c.size();i++) {
            somme += Math.abs( c.get(i) - moyenne );
        }

        return (somme/c.size());
    }

    public ArrayList<String> Discretisation_intervalles_egaux_ForAttr (ArrayList<Double> c , char attr ,int Q){
        String tmp = "";
        DecimalFormat df = new DecimalFormat("0.00");
        ArrayList<String> discretized = new ArrayList<String>();
        double max = Max(c);
        double min = Min(c);
        double size_interval = (max-min)/Q;

        for(int i=0;i<c.size();i++) {
            for (int j=0;j<Q;j++) {
                if((c.get(i)>=min+(size_interval*j)) && (c.get(i) < (min+size_interval*(j+1)))) {
                    tmp = "I"+attr+(j+1);
                }
            }
            discretized.add(i,tmp);
        }

        return discretized;
    }

    public ArrayList<ArrayList<String> > Discretisation_intervalles_egaux (ArrayList<Double> a1 , ArrayList<Double> a2 , ArrayList<Double> a3 , ArrayList<Double> a4 , ArrayList<Double> a5 , ArrayList<Double> a6 , ArrayList<Double> a7 ,ArrayList<Integer> classe , int Q) {

        ArrayList<String> zone = new ArrayList<>(Discretisation_intervalles_egaux_ForAttr(a1,'1',Q));
        ArrayList<String> perimetre = new ArrayList<>(Discretisation_intervalles_egaux_ForAttr(a2,'2',Q));
        ArrayList<String> compacite = new ArrayList<>(Discretisation_intervalles_egaux_ForAttr(a3,'3',Q));
        ArrayList<String> LongueurNoyau = new ArrayList<>(Discretisation_intervalles_egaux_ForAttr(a4,'4',Q));
        ArrayList<String> LargeurNoyau = new ArrayList<>(Discretisation_intervalles_egaux_ForAttr(a5,'5',Q));
        ArrayList<String> AsymetrieCoefficient = new ArrayList<>(Discretisation_intervalles_egaux_ForAttr(a6,'6',Q));
        ArrayList<String> LongueurRainureNoyau = new ArrayList<>(Discretisation_intervalles_egaux_ForAttr(a7,'7',Q));

        ArrayList<ArrayList<String> > Tmp = new ArrayList<ArrayList<String>>();

        for(int i=0 ; i<a1.size() ; i++) {
            Tmp.add(new ArrayList<String>(
                    Arrays.asList(zone.get(i),perimetre.get(i),compacite.get(i),LongueurNoyau.get(i),LargeurNoyau.get(i),AsymetrieCoefficient.get(i), LongueurRainureNoyau.get(i),String.valueOf(classe.get(i)))));
        }

        return Tmp;
    }




    public ArrayList<ArrayList<String> > Discretisation_Quentiles (ArrayList<Double> a1 , ArrayList<Double> a2 , ArrayList<Double> a3 , ArrayList<Double> a4 , ArrayList<Double> a5 , ArrayList<Double> a6 , ArrayList<Double> a7 , ArrayList<Integer> classe ,int Q) {

        ArrayList<String> zone = new ArrayList<>(Discretisation_Quantiles_ForAtrr(a1,'1',Q));
        ArrayList<String> perimetre = new ArrayList<>(Discretisation_Quantiles_ForAtrr(a2,'2',Q));
        ArrayList<String> compacite = new ArrayList<>(Discretisation_Quantiles_ForAtrr(a3,'3',Q));
        ArrayList<String> LongueurNoyau = new ArrayList<>(Discretisation_Quantiles_ForAtrr(a4,'4',Q));
        ArrayList<String> LargeurNoyau = new ArrayList<>(Discretisation_Quantiles_ForAtrr(a5,'5',Q));
        ArrayList<String> AsymetrieCoefficient = new ArrayList<>(Discretisation_Quantiles_ForAtrr(a6,'6',Q));
        ArrayList<String> LongueurRainureNoyau = new ArrayList<>(Discretisation_Quantiles_ForAtrr(a7,'7',Q));

        ArrayList<ArrayList<String> > Tmp = new ArrayList<ArrayList<String>>();

        for(int i=0 ; i<a1.size() ; i++) {
            Tmp.add(new ArrayList<String>(
                    Arrays.asList(zone.get(i),perimetre.get(i),compacite.get(i),LongueurNoyau.get(i),LargeurNoyau.get(i),AsymetrieCoefficient.get(i), LongueurRainureNoyau.get(i), String.valueOf(classe.get(i)) )));
        }

        return Tmp;
    }

    public ArrayList<String> Discretisation_Quantiles_ForAtrr (ArrayList<Double> c , char attr ,int Q){
        String tmp = "";
        ArrayList<String> discretized = new ArrayList<String>();

        ArrayList<Double> newList = new ArrayList<>(c);
        Collections.sort(newList);

        int nb_classes = c.size()/Q;

        for(int i=0;i<newList.size();i++) {
            for (int j=0;j<nb_classes;j++) {
                if((c.get(i)>= newList.get((j*Q))) && (c.get(i) <= (newList.get(((j+1)*Q)-1)) ) ){
                    tmp = "I"+attr+"-"+(j+1);
                }
            }
            discretized.add(i,tmp);
        }
        return discretized;
    }


    public ArrayList<Map<List<String> , Integer>> Itemsets_frequents_ForAttr ( ArrayList<String> Disc ,int min_supp){

        ArrayList<Map<List<String> , Integer>> MapList = new ArrayList<Map<List<String> , Integer>>();

        Map<List<String> , Integer> C1 = new HashMap<List<String> , Integer>();
        int occurrences,Support_Min;
        for(int i=0; i < Disc.size();i++) {
            if( C1.get( Arrays.asList(new String[]{Disc.get(i)}) ) == null) {
                occurrences = Collections.frequency(Disc, Disc.get(i));
                C1.put(Arrays.asList(new String[]{Disc.get(i)}), occurrences);
            }
        }
        Support_Min = (Disc.size()*min_supp)/100;
        Map<List<String> , Integer> L1 = new HashMap<List<String> , Integer>();

        for(List<String> i : C1.keySet() ) {
            if( C1.get(i) >= Support_Min) {
                L1.put(Arrays.asList(new String[]{i.get(0)}), C1.get(i));
            }
        }

        MapList.add(C1);
        MapList.add(L1);
        return MapList;
    }

    public ArrayList<HashMap<List<String> , Integer>> Itemsets_frequents1 (int disc , int min_supp,ArrayList<Double> a1 , ArrayList<Double> a2 , ArrayList<Double> a3 , ArrayList<Double> a4 , ArrayList<Double> a5 , ArrayList<Double> a6 , ArrayList<Double> a7){

        ArrayList<String> zone = new ArrayList<>(Discretisation_intervalles_egaux_ForAttr(a1,'1',disc));
        ArrayList<String> perimetre = new ArrayList<>(Discretisation_intervalles_egaux_ForAttr(a2,'2',disc));
        ArrayList<String> compacite = new ArrayList<>(Discretisation_intervalles_egaux_ForAttr(a3,'3',disc));
        ArrayList<String> LongueurNoyau = new ArrayList<>(Discretisation_intervalles_egaux_ForAttr(a4,'4',disc));
        ArrayList<String> LargeurNoyau = new ArrayList<>(Discretisation_intervalles_egaux_ForAttr(a5,'5',disc));
        ArrayList<String> AsymetrieCoefficient = new ArrayList<>(Discretisation_intervalles_egaux_ForAttr(a6,'6',disc));
        ArrayList<String> LongueurRainureNoyau = new ArrayList<>(Discretisation_intervalles_egaux_ForAttr(a7,'7',disc));


        ArrayList<Map<List<String> , Integer>> MapList_zone = new ArrayList<Map<List<String> , Integer>>(Itemsets_frequents_ForAttr(zone,min_supp));

        Map<List<String> , Integer> C1_Att1 = new HashMap<List<String> , Integer>(MapList_zone.get(0));
        HashMap<List<String> , Integer> L1_Att1 = new HashMap<List<String> , Integer>(MapList_zone.get(1));

        ArrayList<Map<List<String> , Integer>> MapList_perimetre = new ArrayList<Map<List<String> , Integer>>(Itemsets_frequents_ForAttr(perimetre,min_supp));
        HashMap<List<String> , Integer> C1_Att2 = new HashMap<List<String> , Integer>(MapList_perimetre.get(0));
        HashMap<List<String> , Integer> L1_Att2 = new HashMap<List<String> , Integer>(MapList_perimetre.get(1));

        ArrayList<Map<List<String> , Integer>> MapList_compacite = new ArrayList<Map<List<String> , Integer>>(Itemsets_frequents_ForAttr(compacite,min_supp));
        HashMap<List<String> , Integer> C1_Att3 = new HashMap<List<String> , Integer>(MapList_compacite.get(0));
        HashMap<List<String> , Integer> L1_Att3 = new HashMap<List<String> , Integer>(MapList_compacite.get(1));

        ArrayList<Map<List<String> , Integer>> MapList_LongueurNoyau = new ArrayList<Map<List<String> , Integer>>(Itemsets_frequents_ForAttr(LongueurNoyau,min_supp));
        HashMap<List<String> , Integer> C1_Att4 = new HashMap<List<String> , Integer>(MapList_LongueurNoyau.get(0));
        HashMap<List<String> , Integer> L1_Att4 = new HashMap<List<String> , Integer>(MapList_LongueurNoyau.get(1));


        ArrayList<Map<List<String> , Integer>> MapList_LargeurNoyau = new ArrayList<Map<List<String> , Integer>>(Itemsets_frequents_ForAttr(LargeurNoyau,min_supp));
        HashMap<List<String> , Integer> C1_Att5 = new HashMap<List<String> , Integer>(MapList_LargeurNoyau.get(0));
        HashMap<List<String> , Integer> L1_Att5 = new HashMap<List<String> , Integer>(MapList_LargeurNoyau.get(1));

        ArrayList<Map<List<String> , Integer>> MapList_AsymetrieCoefficient = new ArrayList<Map<List<String> , Integer>>(Itemsets_frequents_ForAttr(AsymetrieCoefficient,min_supp));
        HashMap<List<String> , Integer> C1_Att6 = new HashMap<List<String> , Integer>(MapList_AsymetrieCoefficient.get(0));
        HashMap<List<String> , Integer> L1_Att6 = new HashMap<List<String> , Integer>(MapList_AsymetrieCoefficient.get(1));

        ArrayList<Map<List<String> , Integer>> MapList_LongueurRainureNoyau = new ArrayList<Map<List<String> , Integer>>(Itemsets_frequents_ForAttr(LongueurRainureNoyau,min_supp));
        HashMap<List<String> , Integer> C1_Att7 = new HashMap<List<String> , Integer>(MapList_LongueurRainureNoyau.get(0));
        HashMap<List<String> , Integer> L1_Att7 = new HashMap<List<String> , Integer>(MapList_LongueurRainureNoyau.get(1));


        HashMap<List<String> , Integer> C1 = new HashMap<List<String> , Integer>();
        C1.putAll(C1_Att1);C1.putAll(C1_Att2); C1.putAll(C1_Att3); C1.putAll(C1_Att4); C1.putAll(C1_Att5); C1.putAll(C1_Att6);C1.putAll(C1_Att7);
        HashMap<List<String> , Integer> L1 = new HashMap<List<String> , Integer>();
        L1.putAll(L1_Att1);L1.putAll(L1_Att2);L1.putAll(L1_Att3); L1.putAll(L1_Att4); L1.putAll(L1_Att5); L1.putAll(L1_Att6); L1.putAll(L1_Att7);

        ArrayList<HashMap<List<String> , Integer>> MapList_Result = new ArrayList<HashMap<List<String> , Integer>>();
        MapList_Result.add(C1);
        MapList_Result.add(L1);

        return MapList_Result;
    }


    public ArrayList<HashMap<List<String> , Integer>> Itemsets_frequents (int iter, int disc ,int min_supp,HashMap<List<String> , Integer> old_L ,ArrayList<Double> at1 , ArrayList<Double> at2 , ArrayList<Double> at3 , ArrayList<Double> at4 , ArrayList<Double> at5 , ArrayList<Double> at6 , ArrayList<Double> at7) {
        ArrayList<HashMap<List<String> , Integer>> result = new ArrayList<HashMap<List<String> , Integer>>();
        if(iter==1) {
            result = new ArrayList<HashMap<List<String> , Integer>>(Itemsets_frequents1(disc,min_supp,at1,at2,at3,at4,at5,at6,at7));

            return result;
        }else {
            HashMap<List<String> , Integer> C2 = new HashMap<List<String>,Integer>();
            HashMap<List<String> , Integer> L2 = new HashMap<List<String>,Integer>();

            ArrayList<String> a1 = new ArrayList<>(Discretisation_intervalles_egaux_ForAttr(at1,'1',disc));
            ArrayList<String> a2 = new ArrayList<>(Discretisation_intervalles_egaux_ForAttr(at2,'2',disc));
            ArrayList<String> a3 = new ArrayList<>(Discretisation_intervalles_egaux_ForAttr(at3,'3',disc));
            ArrayList<String> a4 = new ArrayList<>(Discretisation_intervalles_egaux_ForAttr(at4,'4',disc));
            ArrayList<String> a5 = new ArrayList<>(Discretisation_intervalles_egaux_ForAttr(at5,'5',disc));
            ArrayList<String> a6 = new ArrayList<>(Discretisation_intervalles_egaux_ForAttr(at6,'6',disc));
            ArrayList<String> a7 = new ArrayList<>(Discretisation_intervalles_egaux_ForAttr(at7,'7',disc));

            ArrayList<String> TemporaryRow = new ArrayList<String>();

            int cpt=0;
            for(int i =0; i<old_L.size()-1;i++) {
                for(int j = i+1;j<old_L.size();j++) {
                    ArrayList<String> tmp = new ArrayList<>();
                    tmp.addAll((Collection<? extends String>) old_L.keySet().toArray()[i]);
                    List<String> twoCopy = new ArrayList<>((Collection<? extends String>) old_L.keySet().toArray()[j]);
                    twoCopy.removeAll((Collection<? extends String>) old_L.keySet().toArray()[i]);
                    tmp.addAll(twoCopy);
                    cpt = 0;
                    if(tmp.size() == iter) {
                        for(int t=0;t< a1.size();t++) {

                            TemporaryRow.add(a1.get(t));
                            TemporaryRow.add(a2.get(t));
                            TemporaryRow.add(a3.get(t));
                            TemporaryRow.add(a4.get(t));
                            TemporaryRow.add(a5.get(t));
                            TemporaryRow.add(a6.get(t));
                            TemporaryRow.add(a7.get(t));

                            boolean bool = true;
                            for(String str : tmp ) {
                                if(!TemporaryRow.contains(str)) {
                                    bool = false;
                                }
                            }
                            if (bool) {
                                cpt ++;
                            }

                            TemporaryRow.clear();
                        }
                        C2.put(tmp, cpt);
                    }
                }
            }

            int Support_Minimal =  (at1.size()*min_supp)/100;
            for (List<String> i : C2.keySet()) {
                List<String> ii = new ArrayList<String>(i);
                Collections.sort(ii);
                if (C2.get(i) >= Support_Minimal) {
                    L2.put(ii, C2.get(i));
                }
            }

            result.add(C2);
            result.add(L2);
            return result;
        }
    }




    public HashMap<List<String> , Integer> Apriori(int disc , int supp_min , ArrayList<Double> at1 , ArrayList<Double> at2 , ArrayList<Double> at3 , ArrayList<Double> at4 , ArrayList<Double> at5 , ArrayList<Double> at6 , ArrayList<Double> at7 ) {
        ArrayList<HashMap<List<String> , Integer>> MapList_Result = new ArrayList<HashMap<List<String> , Integer>>();
        HashMap<List<String> , Integer> Result = new HashMap<List<String> , Integer>();
        MapList_Result = Itemsets_frequents(1,disc,supp_min,null,at1,at2,at3,at4,at5,at6,at7);
        Result.putAll(MapList_Result.get(1));
        int i =2;
        while(MapList_Result.get(0).size() > 0) {
            MapList_Result = Itemsets_frequents(i,4,20,MapList_Result.get(1),at1,at2,at3,at4,at5,at6,at7);
            Result.putAll(MapList_Result.get(1));
            i=i+1;
        }

        return Result;
    }


    public ArrayList<Rule> GenerateAssociativeRules(HashMap<List<String> , Integer> Result,double min_conf){

        ArrayList<Rule> All_Rules = new ArrayList<Rule>();

        for(int x=0;x<Result.keySet().size();x++) {
            ArrayList<String> tmp = new ArrayList<String>((List<? extends String>)Result.keySet().toArray()[x]);
            ArrayList<String> left = new ArrayList<String>();
            ArrayList<String> right = new ArrayList<String>(tmp);
            if(tmp.size() > 1) {

                ArrayList<ArrayList<String> > tft = new ArrayList<ArrayList<String> >();
                if(tmp.size() > 1) {
                    tft = associationRules(tmp);
                    for (ArrayList<String> nb : tft) {

                        left.addAll(nb);
                        right.removeAll(nb);
                        Collections.sort(left);
                        Collections.sort(right);
                        if((double)Result.get(tmp)/Result.get(left) >= min_conf) {
                            All_Rules.add(new Rule(left,right,(double)Result.get(tmp)/Result.get(left),(double)Result.get(tmp)/(Result.get(left)*Result.get(right))));
                        }

                        left= new ArrayList<String>();
                        right= new ArrayList<String>(tmp);
                    }

                }

            }

        }

        return All_Rules;
    }

    public static ArrayList<ArrayList<String> > associationRules(ArrayList<String> elements) {

        ArrayList<ArrayList<String> > result = new ArrayList<ArrayList<String> >();
        long limit = 1 << elements.size();

        for (long i = 1; i < limit; ++i) {
            ArrayList<String> seq = new ArrayList<String>();

            for (int pos = 0; pos < elements.size(); ++pos) {
                boolean include = ((i >> pos) % 2) == 1;
                if (include) {
                    seq.add(elements.get(pos));
                }
            }

            if(seq.size() < elements.size()) {
                result.add(seq);
            }


        }

        return result;
    }

    public int classification_naive_b(int ensemble_app,ArrayList<Row> Rows , String a1 , String a2 , String a3 , String a4 , String a5 , String a6 , String a7 , int dics) {
        List<ArrayList<Row>> MapList_Result = new ArrayList<ArrayList<Row>>(Split_Data(ensemble_app,Rows));
        ArrayList<Row> Appren = MapList_Result.get(1);

        int c1=0,c2=0,c3=0;
        for(Row s : Appren) {
            if(s.getRow().get(7).equals(String.valueOf(1))) {
                c1++;
            }else if (s.getRow().get(7).equals(String.valueOf(2))) {
                c2++;
            }else if(s.getRow().get(7).equals(String.valueOf(3))) {
                c3++;
            }
        }

        int[] cpt = {0, 0, 0, 0, 0, 0, 0};
        Map<Integer , List<Integer>> data = new HashMap<Integer , List<Integer>>();
        Dataset D = new Dataset(Appren);
        D.setData();
        ArrayList<ArrayList<String>> D_Appren =  new ArrayList<ArrayList<String>>(Discretisation_intervalles_egaux(D.getZoneAttribut(),D.getPerimetreAttribut(),D.getCompaciteAttribut(),D.getLongueurNoyauAttribut(),D.getLargeurNoyauAttribut(),D.getAsymetrieCoefficientAttribut(),D.getLongueurRainureNoyauAttribut(),D.getclasseAttribut(),dics));

        for(int i=1;i<4;i++) {
            for(ArrayList<String> s : D_Appren) {
                if (s.get(0).equals(a1) & s.get(7).equals(String.valueOf(i))) {cpt[0]++;}
                if (s.get(1).equals(a2) & s.get(7).equals(String.valueOf(i))) {cpt[1]++;}
                if (s.get(2).equals(a3) & s.get(7).equals(String.valueOf(i))) {cpt[2]++;}
                if (s.get(3).equals(a4) & s.get(7).equals(String.valueOf(i))) {cpt[3]++;}
                if (s.get(4).equals(a5) & s.get(7).equals(String.valueOf(i))) {cpt[4]++;}
                if (s.get(5).equals(a6) & s.get(7).equals(String.valueOf(i))) {cpt[5]++;}
                if (s.get(6).equals(a7) & s.get(7).equals(String.valueOf(i))) {cpt[6]++;}
            }
            data.put(i,Arrays.asList(cpt[0],cpt[1],cpt[2],cpt[3],cpt[4],cpt[5],cpt[6]));
            Arrays.fill(cpt, 0);
        }
        double p_x_c1 = 1,p_x_c2=1,p_x_c3=1;
        for (int i=0;i<7;i++) {
            p_x_c1 *= (float)(data.get(1).get(i)+1)/(c1+dics);
            p_x_c2 *= (float)(data.get(2).get(i)+1)/(c2+dics);
            p_x_c3 *= (float)(data.get(3).get(i)+1)/(c3+dics);
        }
        p_x_c1 *= (double)c1/Appren.size();
        p_x_c2 *= (double)c2/Appren.size();
        p_x_c3 *= (double)c3/Appren.size();

        if((Math.max(p_x_c1, Math.max(p_x_c2, p_x_c3))) == p_x_c1 ) {
            return 1;
        }else if((Math.max(p_x_c1, Math.max(p_x_c2, p_x_c3))) == p_x_c2) {
            return 2;
        }else if((Math.max(p_x_c1, Math.max(p_x_c2, p_x_c3))) == p_x_c3) {
            return 3;
        }
        return 0;
    }

    public Values Test_classification_naive_b(int ensemble_app,ArrayList<Row> Rows ,int dics ) {
        List<ArrayList<Row>> MapList_Result = new ArrayList<ArrayList<Row>>(Split_Data(ensemble_app,Rows));
        ArrayList<Row> Test = MapList_Result.get(0);
        Dataset D = new Dataset(Test);
        D.setData();
        ArrayList<ArrayList<String>> D_Test=  new ArrayList<ArrayList<String>>(Discretisation_intervalles_egaux(D.getZoneAttribut(),D.getPerimetreAttribut(),D.getCompaciteAttribut(),D.getLongueurNoyauAttribut(),D.getLargeurNoyauAttribut(),D.getAsymetrieCoefficientAttribut(),D.getLongueurRainureNoyauAttribut(),D.getclasseAttribut(),dics));
        int[][] classe = {{0, 0}, {0, 0}};
        int[][] Confusion = {{0, 0, 0}, {0, 0, 0},{0, 0, 0}};

        HashMap<Integer,List<Integer>> classes = new HashMap<Integer,List<Integer>>();
        for(int i=1;i<4;i++) {
            for(ArrayList<String> s : D_Test){

                if(s.get(7).equals(String.valueOf(i)) & String.valueOf(classification_naive_b(ensemble_app,Rows,s.get(0),s.get(1),s.get(2),s.get(3),s.get(4),s.get(5),s.get(6),dics)).equals(s.get(7))) {
                    classe[0][0]++;
                    Confusion[(i-1)][(i-1)]++;
                }
                if(s.get(7).equals(String.valueOf(i)) & !String.valueOf(classification_naive_b(ensemble_app,Rows,s.get(0),s.get(1),s.get(2),s.get(3),s.get(4),s.get(5),s.get(6),dics)).equals(s.get(7))) {
                    classe[0][1]++;
                    Confusion[(i-1)][Integer.valueOf(classification_naive_b(ensemble_app,Rows,s.get(0),s.get(1),s.get(2),s.get(3),s.get(4),s.get(5),s.get(6),dics))-1]++;
                }
                if(!s.get(7).equals(String.valueOf(i))  & !String.valueOf(classification_naive_b(ensemble_app,Rows,s.get(0),s.get(1),s.get(2),s.get(3),s.get(4),s.get(5),s.get(6),dics)).equals(String.valueOf(i))) {
                    classe[1][1]++;
                }
                if(!s.get(7).equals(String.valueOf(i)) & String.valueOf(classification_naive_b(ensemble_app,Rows,s.get(0),s.get(1),s.get(2),s.get(3),s.get(4),s.get(5),s.get(6),dics)).equals(String.valueOf(i))) {
                    classe[1][0]++;
                }
            }

            classes.put(Integer.valueOf(i),Arrays.asList(classe[0][0],classe[0][1],classe[1][0],classe[1][1]));
            classe[0][0] = 0;classe[0][1] = 0;classe[1][0] = 0;classe[1][1] = 0;
        }
        double[] accuracy = new double[3] ;
        double[] sensitivity = new double[3];
        double[] specificity = new double[3];
        double[] rappel = new double[3];
        double[] precision = new double[3];
        double[] F_SCORE = new double[3];
        for(int i=1;i<4;i++) {
            accuracy[i-1] = (double)(classes.get(i).get(0)+classes.get(i).get(3))/D_Test.size();
            sensitivity[i-1] = (double)(classes.get(i).get(0))/(classes.get(i).get(0)+classes.get(i).get(1));
            double fp_tn = classes.get(i).get(2) + classes.get(i).get(3);
            specificity[i-1] = (classes.get(i).get(3)/ fp_tn );
            double tp_fp = classes.get(i).get(0) + classes.get(i).get(2);
            precision[i-1] = classes.get(i).get(0)/tp_fp;
            double tp_fn = classes.get(i).get(0) + classes.get(i).get(1);
            rappel[i-1] = classes.get(i).get(0)/tp_fn;
            F_SCORE[i-1] = (2*precision[i-1]*rappel[i-1])/(precision[i-1]+rappel[i-1]);
        }

        double accuracy_moyenne = (accuracy[0]+accuracy[1]+accuracy[2])/3;
        double sensitivity_moyenne = (sensitivity[0]+sensitivity[1]+sensitivity[2])/3;
        double specificity_moyenne = (specificity[0]+specificity[1]+specificity[2])/3;
        double rappel_moyenne = (rappel[0]+rappel[1]+rappel[2])/3;
        double precision_moyenne = (precision[0]+precision[1]+precision[2])/3;
        double F_SCORE_moyenne = (F_SCORE[0]+F_SCORE[1]+F_SCORE[2])/3;

        return new Values(classes,accuracy,sensitivity,specificity,rappel,precision,F_SCORE,Confusion,accuracy_moyenne,sensitivity_moyenne,specificity_moyenne,rappel_moyenne,precision_moyenne,F_SCORE_moyenne);

    }

    public List<ArrayList<Row>> Split_Data(int ensemble_app,ArrayList<Row> Rows) {
        ArrayList<Row> Test = new ArrayList<Row>();
        ArrayList<Row> Appren = new ArrayList<Row>(Rows);
        int cptC1=0,cptC2=0,cptC3=0;
        for (Row i : Rows) {
            if(cptC1 < ensemble_app & i.getRow().get(7).equals(String.valueOf(1))) {
                Test.add(i);
                Appren.remove(i);
                cptC1 ++;
            }
            else if(cptC2 <ensemble_app & i.getRow().get(7).equals(String.valueOf(2))) {
                Test.add(i);
                Appren.remove(i);
                cptC2++;
            }
            else if(cptC3 <ensemble_app & i.getRow().get(7).equals(String.valueOf(3))) {
                Test.add(i);
                Appren.remove(i);
                cptC3++;
            }
        }

        List<ArrayList<Row>> MapList_Result = new ArrayList<ArrayList<Row>>();
        MapList_Result.add(Test);
        MapList_Result.add(Appren);
        return MapList_Result;
    }
    //___________________________________Imad Eddine HEBBACHE CODE________________________________________________________________
    //Fonction pour normalisation min max
    public ArrayList<Double> Max_Min_Normalisation(double Q0,double Q4,ArrayList<Double> valeursAttrX,int newMin,int newMax){
        ArrayList<Double> temp=new ArrayList<>();
        double valNew;

        for(int i=0;i<valeursAttrX.size();i++){
            valNew=((valeursAttrX.get(i)-Q0)/(Q4-Q0))*(newMax-newMin)+newMin;
            temp.add(valNew);
        }
        return temp;
    }
    //fonction pour discritisation quantiles
    public ArrayList<String> Discretisation_Quantiles_Imadeddine (ArrayList<Double> c , char attr , boolean print,int Q){
        String tmp = "";
        ArrayList<String> discretized = new ArrayList<String>();

        ArrayList<Double> newList = new ArrayList<>(c);
        Collections.sort(newList);
        ArrayList<Integer> quantiles = new ArrayList<>();

        int nb_classes = c.size()/Q;
        System.out.println("Pour l'attribut "+attr+":");
        int cast;
        cast = (int)(c.size() / Q );
        if (((int) ((c.size() / Q * cast)*10)) <= 5){
            for (int k=0;k<c.size();k=k+Q-1) {
                quantiles.add(k);

            }
        }
        else {
            for (int k=0;k<c.size();k=k+Q) {
                quantiles.add(k);
            }
        }
        System.out.println(quantiles);
        quantiles.add(c.size()-1);
        for(int i=1;i<quantiles.size();i++) {
            System.out.println("Interval " + i + " = [ " + newList.get(quantiles.get(i-1)) + " ; " + newList.get(quantiles.get(i)) + " ]");
        }
        for(int i=0;i<newList.size();i++) {
            for (int j=0;j<nb_classes;j++) {
                if((c.get(i)>= newList.get(quantiles.get(j)) && (c.get(i) < (newList.get(quantiles.get(j+1) ))))){
                    tmp = "I"+attr+"-"+(j+1);
                }
            }
            discretized.add(i,tmp);
        }

        return discretized;
    }

    //____________________________________________Eclat_________________________________________________________________
    //fonction pour calculé le support
    public int support_item_Eclat(ArrayList<Boolean> List_TID_Values){
        int cpt=0;
        for(int i=0;i<List_TID_Values.size();i++){
            if(List_TID_Values.get(i) == true)cpt++;
        }
        return cpt;
    }
    //Fonction pour créer la table vertical des item et transaction
    public  HashMap<String,ArrayList<Boolean>> tableVertical(ArrayList<ArrayList<String>> datasetDiscritised){
        HashMap<String,ArrayList<Boolean>> tablV=new HashMap<>();
        int ligne=datasetDiscritised.get(0).size(),colone=datasetDiscritised.size();
        //System.out.println(datasetDiscritised);
        //System.out.println(colone+" "+ligne);
        for(int i=0;i<ligne-1;i++){
            for(int j=0;j<colone;j++){
                if(!(tablV.containsKey(datasetDiscritised.get(j).get(i)))){
                    //System.out.println(datasetDiscritised.get(j).get(i));
                    ArrayList<Boolean> listBool=new ArrayList<>();
                    for (int k=0;k<colone;k++){
                        if(datasetDiscritised.get(k).get(i).equals(datasetDiscritised.get(j).get(i))){
                            listBool.add(true);
                        }
                        else{
                            listBool.add(false);
                        }
                    }
                    //System.out.println(" item a ajouté = "+datasetDiscritised.get(j).get(i)+" list transaction appartenance = "+listBool+" size list bool = "+listBool.size());
                    tablV.put(datasetDiscritised.get(j).get(i),listBool);
                    //System.out.println(tablV.get(datasetDiscritised.get(j).get(i)));
                }
            }
        }
        //System.out.println(tablV.values());
        return tablV;
    }
    // fonction pour generer les itemes set frequent
    public List<Map<List<String>,Integer>> Eclat_Items_set_Frequents(HashMap<String,ArrayList<Boolean>> tableVertical,int supMin,int Nbr_transaction){

        Map<List<String> , Integer> C1 = new HashMap<List<String>,Integer>();
        Map<List<String> , Integer> L1 = new HashMap<List<String>,Integer>();
        for (Map.Entry<String, ArrayList<Boolean>> entry : tableVertical.entrySet()) {
            if (!(L1.containsKey(entry.getKey()))) {
                List<String> items= new ArrayList<>();
                items.add(entry.getKey());
                L1.put(items,support_item_Eclat(entry.getValue()));
            }
        }
        int supportMin=Nbr_transaction*supMin/100;
        for(List<String> i : L1.keySet()){
            if(L1.get(i)>= supportMin)C1.put(i,L1.get(i));
        }
        List<Map<List<String> , Integer>> MapList_Result = new ArrayList<Map<List<String> , Integer>>();

        MapList_Result.add(C1);
        Map<List<String> , Integer> L = new HashMap<List<String>,Integer>(C1);
        int t1,t2;
        while (!L.isEmpty()){
            t2=0;
            Map<List<String> , Integer> C = new HashMap<List<String>,Integer>();
            for (Map.Entry<List<String>, Integer> entry : L.entrySet()) {
                t1=0;
                for (Map.Entry<List<String>, Integer> entry2 : L.entrySet()){
                    List<String> items= new ArrayList<>(entry.getKey());
                    if(t1>t2){
                            for(String s : entry2.getKey()){
                                if(!items.contains(s))
                                    items.add(s);
                            }
                        if (!(C.containsKey(items))){
                            List<List<Boolean>> listsTabVer= new ArrayList<>();
                            for(String s2:items){
                                listsTabVer.add(tableVertical.get(s2));
                            }
                            ArrayList<Boolean> listBol = new ArrayList<>();
                            for (int x=0;x<listsTabVer.get(0).size();x++)listBol.add(true);
                            for (int i=0;i<listsTabVer.size();i++){
                                for(int j=0;j<listsTabVer.get(0).size();j++){
                                    listBol.set(j,((listBol.get(j)) & (listsTabVer.get(i).get(j))));

                                }
                            }
                        if (!(C.containsKey(items)))C.put(items,support_item_Eclat(listBol));}
                    }
                    t1++;
                }
                t2++;
            }
            Map<List<String> , Integer> Lk = new HashMap<List<String>,Integer>();
            for(List<String> i : C.keySet()){
                if(C.get(i)>= supportMin)Lk.put(i,C.get(i));
            }
            if(!Lk.isEmpty())
                MapList_Result.add(Lk);

            L.clear();
            L= new HashMap<List<String>,Integer>(Lk);

        }

        return MapList_Result;
    }

    public int Classification_knn (int k,String type,int ensemble_app,ArrayList<Row> Rows ,double a1, double a2, double a3, double a4, double a5, double a6, double a7) {
        List<ArrayList<Row>> MapList_Result = new ArrayList<ArrayList<Row>>(Split_Data(ensemble_app,Rows));
        ArrayList<Row> Appren = MapList_Result.get(1);
        double dist = 0;
        Map <Integer,Double> distance = new HashMap<Integer,Double>();
        for(Row s: Appren) {
            ArrayList<String> tmpRow = new ArrayList<String>(s.getRow());
            switch(type) {
                case "Euclidienne":
                    dist = Math.abs(( a1- Double.parseDouble(tmpRow.get(0))))+Math.pow((a2- Double.parseDouble(tmpRow.get(1))), 2)+Math.pow((a3- Double.parseDouble(tmpRow.get(2))), 2)+Math.pow((a4- Double.parseDouble(tmpRow.get(3))), 2)+Math.pow((a5- Double.parseDouble(tmpRow.get(4))), 2) + Math.pow((a6- Double.parseDouble(tmpRow.get(5))), 2)+Math.pow((a7- Double.parseDouble(tmpRow.get(6))), 2);
                    dist = Math.sqrt(dist);
                    break;
                case "Manhattan":
                    dist = Math.abs(( a1- Double.parseDouble(tmpRow.get(0))))+Math.abs((a2- Double.parseDouble(tmpRow.get(1))))+Math.abs((a3- Double.parseDouble(tmpRow.get(2))))+Math.abs((a4- Double.parseDouble(tmpRow.get(3))))+Math.abs((a5- Double.parseDouble(tmpRow.get(4)))) + Math.abs((a6- Double.parseDouble(tmpRow.get(5))))+Math.abs((a7- Double.parseDouble(tmpRow.get(6))));
                    break;

            }

            distance.put(s.getNInstance(), dist);
        }

        HashMap<Integer, Double> SortedDistance = sortByValue(distance);
        ArrayList <Integer> instances = GetNFirstValues(SortedDistance,k);
        ArrayList<String> rs = new ArrayList<String>();
        for(Row s: Appren) {
            if(instances.contains(s.getNInstance())) {
                rs.add(s.getRow().get(7));
            }
        }

        if((Math.max(Collections.frequency(rs, "1"), Math.max(Collections.frequency(rs, "2"), Collections.frequency(rs, "3")))) == Collections.frequency(rs, "1") ) {
            return 1;
        }else if((Math.max(Collections.frequency(rs, "1"), Math.max(Collections.frequency(rs, "2"), Collections.frequency(rs, "3")))) == Collections.frequency(rs, "2")) {
            return 2;
        }else if((Math.max(Collections.frequency(rs, "1"), Math.max(Collections.frequency(rs, "2"), Collections.frequency(rs, "3")))) == Collections.frequency(rs, "3")) {
            return 3;
        }
        return 0;
    }
    public Values Test_Classification_knn(int k,String type,int ensemble_app,ArrayList<Row> Rows) {

        List<ArrayList<Row>> MapList_Result = new ArrayList<ArrayList<Row>>(Split_Data(ensemble_app,Rows));
        ArrayList<Row> Test = MapList_Result.get(0);
        Dataset D = new Dataset(Test);
        D.setData();
        int[][] classe = {{0, 0}, {0, 0}};
        int[][] Confusion = {{0, 0, 0}, {0, 0, 0},{0, 0, 0}};

        HashMap<Integer,List<Integer>> classes = new HashMap<Integer,List<Integer>>();
        for(int i=1;i<4;i++) {
            for(Row row : D.getRowsList()){
                ArrayList<String> s = new ArrayList<String>(row.getRow());
                if(s.get(7).equals(String.valueOf(i)) & String.valueOf(Classification_knn(k,type,ensemble_app,Rows,row.getZone(),row.getPerimetre(),row.getCompacite(),row.getLongueurNoyau(),row.getLargeurNoyau(),row.getAsymetrieCoefficient(),row.getLongueurRainureNoyau())).equals(s.get(7))) {
                    classe[0][0]++;
                    Confusion[(i-1)][(i-1)]++;
                }
                if(s.get(7).equals(String.valueOf(i)) & !String.valueOf(Classification_knn(k,type,ensemble_app,Rows,row.getZone(),row.getPerimetre(),row.getCompacite(),row.getLongueurNoyau(),row.getLargeurNoyau(),row.getAsymetrieCoefficient(),row.getLongueurRainureNoyau())).equals(s.get(7))) {
                    classe[0][1]++;
                    Confusion[(i-1)][Integer.valueOf(Classification_knn(k,type,ensemble_app,Rows,row.getZone(),row.getPerimetre(),row.getCompacite(),row.getLongueurNoyau(),row.getLargeurNoyau(),row.getAsymetrieCoefficient(),row.getLongueurRainureNoyau()))-1]++;
                }
                if(!s.get(7).equals(String.valueOf(i))  & !String.valueOf(Classification_knn(k,type,ensemble_app,Rows,row.getZone(),row.getPerimetre(),row.getCompacite(),row.getLongueurNoyau(),row.getLargeurNoyau(),row.getAsymetrieCoefficient(),row.getLongueurRainureNoyau())).equals(String.valueOf(i))) {
                    classe[1][1]++;
                }
                if(!s.get(7).equals(String.valueOf(i)) & String.valueOf(Classification_knn(k,type,ensemble_app,Rows,row.getZone(),row.getPerimetre(),row.getCompacite(),row.getLongueurNoyau(),row.getLargeurNoyau(),row.getAsymetrieCoefficient(),row.getLongueurRainureNoyau())).equals(String.valueOf(i))) {
                    classe[1][0]++;
                }
            }

            classes.put(Integer.valueOf(i),Arrays.asList(classe[0][0],classe[0][1],classe[1][0],classe[1][1]));
            classe[0][0] = 0;classe[0][1] = 0;classe[1][0] = 0;classe[1][1] = 0;
        }
        double[] accuracy = new double[3] ;
        double[] sensitivity = new double[3];
        double[] specificity = new double[3];
        double[] rappel = new double[3];
        double[] precision = new double[3];
        double[] F_SCORE = new double[3];
        for(int i=1;i<4;i++) {
            accuracy[i-1] = (double)(classes.get(i).get(0)+classes.get(i).get(3))/D.getRowsList().size();
            sensitivity[i-1] = (double)(classes.get(i).get(0))/(classes.get(i).get(0)+classes.get(i).get(1));
            double fp_tn = classes.get(i).get(2) + classes.get(i).get(3);
            specificity[i-1] = (classes.get(i).get(3)/ fp_tn );
            double tp_fp = classes.get(i).get(0) + classes.get(i).get(2);
            precision[i-1] = classes.get(i).get(0)/tp_fp;
            double tp_fn = classes.get(i).get(0) + classes.get(i).get(1);
            rappel[i-1] = classes.get(i).get(0)/tp_fn;
            F_SCORE[i-1] = (2*precision[i-1]*rappel[i-1])/(precision[i-1]+rappel[i-1]);
        }

        double accuracy_moyenne = (accuracy[0]+accuracy[1]+accuracy[2])/3;
        double sensitivity_moyenne = (sensitivity[0]+sensitivity[1]+sensitivity[2])/3;
        double specificity_moyenne = (specificity[0]+specificity[1]+specificity[2])/3;
        double rappel_moyenne = (rappel[0]+rappel[1]+rappel[2])/3;
        double precision_moyenne = (precision[0]+precision[1]+precision[2])/3;
        double F_SCORE_moyenne = (F_SCORE[0]+F_SCORE[1]+F_SCORE[2])/3;

        return new Values(classes,accuracy,sensitivity,specificity,rappel,precision,F_SCORE,Confusion,accuracy_moyenne,sensitivity_moyenne,specificity_moyenne,rappel_moyenne,precision_moyenne,F_SCORE_moyenne);
    }

    public static HashMap<Integer, Double> sortByValue(Map<Integer, Double> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Double> > list =
                new LinkedList<Map.Entry<Integer, Double> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<Integer, Double> >() {
            public int compare(Map.Entry<Integer, Double> o1,
                               Map.Entry<Integer, Double> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<Integer, Double> temp = new LinkedHashMap<Integer, Double>();
        for (Map.Entry<Integer, Double> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public static ArrayList <Integer> GetNFirstValues (HashMap <Integer,Double> data , int nb){
        ArrayList <Integer> keys = new ArrayList<>();
        for(Integer key :data.keySet()){
            if(nb <= 0) { break; }
            keys.add(key);
            nb--;
        }

        return keys;
    }


}
class Values {
    HashMap<Integer,List<Integer>> classes = new HashMap<Integer,List<Integer>>();
    double[] accuracy = new double[3];
    double[] sensitivity = new double[3];
    double[] specificity = new double[3];
    double[] rappel = new double[3];
    double[] precision = new double[3];
    double[] F_SCORE = new double[3];
    double accuracy_moyenne,sensitivity_moyenne,specificity_moyenne,rappel_moyenne,precision_moyenne,F_SCORE_moyenne;
    int[][] Confusion = {{0, 0, 0}, {0, 0, 0},{0, 0, 0}};

    public Values(HashMap<Integer,List<Integer>> classes , double[] accuracy,double[] sensitivity,double[] specificity,double[] rappel,double[] precision,double[] F_SCORE,int[][] Confusion ,double accuracy_moyenne,double sensitivity_moyenne, double specificity_moyenne, double rappel_moyenne , double precision_moyenne , double F_SCORE_moyenne) {
        this.classes = classes;
        this.accuracy = accuracy;
        this.sensitivity = sensitivity;
        this.specificity = specificity;
        this.rappel = rappel;
        this.precision = precision;
        this.F_SCORE = F_SCORE;
        this.Confusion = Confusion;
        this.accuracy_moyenne = accuracy_moyenne;
        this.sensitivity_moyenne = sensitivity_moyenne;
        this.specificity_moyenne = specificity_moyenne;
        this.rappel_moyenne = rappel_moyenne;
        this.precision_moyenne = precision_moyenne;
        this.F_SCORE_moyenne = F_SCORE_moyenne;
    }

    public HashMap<Integer,List<Integer>> getClasses() {
        return classes;
    }
    public double[] getAccuracy() {
        return accuracy;
    }
    public double[] getSensitivity() {
        return sensitivity;
    }
    public double[] getSpecificity() {
        return specificity;
    }
    public double[] getRappel() {
        return rappel;
    }
    public double[] getPrecision() {
        return precision;
    }
    public double[] getF_SCORE() {
        return F_SCORE;
    }
    public int[][] getConfusion(){
        return Confusion;
    }
    public double getAccuracy_moyenne() {
        return accuracy_moyenne;
    }
    public double getSensitivity_moyenne() {
        return sensitivity_moyenne;
    }
    public double getSpecificity_moyenne() {
        return specificity_moyenne;
    }
    public double getRappel_moyenne() {
        return rappel_moyenne;
    }
    public double getPrecision_moyenne() {
        return precision_moyenne;
    }
    public double getF_SCORE_moyenne() {
        return F_SCORE_moyenne;
    }
}
class Rule {

    ArrayList<String> left;
    ArrayList<String> right;
    double conf;
    double lift;

    public Rule(ArrayList<String> left,ArrayList<String> right,double conf ,double lift) {
        this.left = left;
        this.right = right;
        this.conf = conf;
        this.lift = lift;
    }

    public ArrayList<String> getLeft() {
        return left;
    }
    public ArrayList<String> getRight(){
        return right;
    }
    public double getConf() {
        return conf;
    }
    public double getLift() {
        return lift;
    }
}