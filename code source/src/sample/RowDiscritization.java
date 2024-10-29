package sample;

public class RowDiscritization {
	int nInstance;
    String	zone;
    String	perimetre;
    String	compacite;
    String	longueurNoyau;
    String	largeurNoyau;
    String	asymetrieCoefficient;
    String	longueurRainureNoyau;
    String classe;
    
    public RowDiscritization(String zone, String perimetre, String compacite, String longueurNoyau, String largeurNoyau, String asymetrieCoefficient, String longueurRainureNoyau, String classe) {
        this.zone = zone;
        this.perimetre = perimetre;
        this.compacite = compacite;
        this.longueurNoyau = longueurNoyau;
        this.largeurNoyau = largeurNoyau;
        this.asymetrieCoefficient = asymetrieCoefficient;
        this.longueurRainureNoyau = longueurRainureNoyau;
        this.classe = classe;
    }
    
    public RowDiscritization(int i, String[] row) {
        this.nInstance = i;
        this.zone = row[0].toString();
        this.perimetre = row[1].toString();
        this.compacite = row[2].toString();
        this.longueurNoyau = row[3].toString();
        this.largeurNoyau = row[4].toString();
        this.asymetrieCoefficient = row[5].toString();
        this.longueurRainureNoyau = row[6].toString();
        this.classe = row[7].toString();
    }
    
    
    public int getNInstance() {
        return nInstance;
    }

    public String getZone() {
        return zone;
    }

    public String getPerimetre() {
        return perimetre;
    }

    public String getCompacite() {
        return compacite;
    }

    public String getLongueurNoyau() {
        return longueurNoyau;
    }

    public String getLargeurNoyau() {
        return largeurNoyau;
    }

    public String getAsymetrieCoefficient() {
        return asymetrieCoefficient;
    }

    public String getLongueurRainureNoyau() {
        return longueurRainureNoyau;
    }
    public String getClasse() {
        return classe;
    }
    
    public String getClassString(){ 
        switch (classe){
            case "1": return "Kama";
            case "2": return "Rosa";
            case "3": return "Canadian";
        }
        return "";
    }
}
