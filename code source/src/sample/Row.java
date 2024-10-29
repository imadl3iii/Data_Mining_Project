package sample;

import java.util.ArrayList;

public class Row {
    int nInstance;
    double	zone;
    double	perimetre;
    double	compacite;
    double	longueurNoyau;
    double	largeurNoyau;
    double	asymetrieCoefficient;
    double	longueurRainureNoyau;
    int classe;

    public Row(double zone, double perimetre, double compacite, double longueurNoyau, double largeurNoyau, double asymetrieCoefficient, double longueurRainureNoyau, int classe) {
        this.zone = zone;
        this.perimetre = perimetre;
        this.compacite = compacite;
        this.longueurNoyau = longueurNoyau;
        this.largeurNoyau = largeurNoyau;
        this.asymetrieCoefficient = asymetrieCoefficient;
        this.longueurRainureNoyau = longueurRainureNoyau;
        this.classe = classe;
    }

    public Row(int i, String[] row) {
        this.nInstance = i;
        this.zone = Double.parseDouble(row[0]);
        this.perimetre = Double.parseDouble(row[1]);
        this.compacite = Double.parseDouble(row[2]);
        this.longueurNoyau = Double.parseDouble(row[3]);
        this.largeurNoyau = Double.parseDouble(row[4]);
        this.asymetrieCoefficient = Double.parseDouble(row[5]);
        this.longueurRainureNoyau = Double.parseDouble(row[6]);
        this.classe = Integer.parseInt(row[7]);
    }

    public ArrayList<String> getRow(){
        ArrayList<String> row = new ArrayList<String>();
        row.add(String.valueOf(zone));
        row.add(String.valueOf(perimetre));
        row.add(String.valueOf(compacite));
        row.add(String.valueOf(longueurNoyau));
        row.add(String.valueOf(largeurNoyau));
        row.add(String.valueOf(asymetrieCoefficient));
        row.add(String.valueOf(longueurRainureNoyau));
        row.add(String.valueOf(classe));
        return row;
    }

    public int getNInstance() {
        return nInstance;
    }

    public double getZone() {
        return zone;
    }

    public double getPerimetre() {
        return perimetre;
    }

    public double getCompacite() {
        return compacite;
    }

    public double getLongueurNoyau() {
        return longueurNoyau;
    }

    public double getLargeurNoyau() {
        return largeurNoyau;
    }

    public double getAsymetrieCoefficient() {
        return asymetrieCoefficient;
    }

    public double getLongueurRainureNoyau() {
        return longueurRainureNoyau;
    }
    public int getClasse() {
        return classe;
    }
    public String getClassString(){
        switch (classe){
            case 1: return "Kama";
            case 2: return "Rosa";
            case 3: return "Canadian";
        }
        return "";
    }


    public void setNInstance(int nInstance) {
        this.nInstance = nInstance;
    }

    public void setZone(double zone) {
        this.zone = zone;
    }

    public void setPerimetre(double perimetre) {
        this.perimetre = perimetre;
    }

    public void setCompacite(double compacite) {
        this.compacite = compacite;
    }

    public void setLongueurNoyau(double longueurNoyau) {
        this.longueurNoyau = longueurNoyau;
    }

    public void setLargeurNoyau(double largeurNoyau) {
        this.largeurNoyau = largeurNoyau;
    }

    public void setAsymetrieCoefficient(double asymetrieCoefficient) {
        this.asymetrieCoefficient = asymetrieCoefficient;
    }

    public void setLongueurRainureNoyau(double longueurRainureNoyau) {
        this.longueurRainureNoyau = longueurRainureNoyau;
    }
}
