package sample;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.renderer.xy.XYDotRenderer;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.statistics.BoxAndWhiskerCalculator;
import org.jfree.data.statistics.BoxAndWhiskerItem;
import org.jfree.data.statistics.DefaultBoxAndWhiskerXYDataset;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;


public class Graph {
	
    ArrayList<Double> dataOfAttribute;
   
    public Graph() {}
    
    public Graph(ArrayList<Double> dataOfAttribute){
        this.dataOfAttribute = dataOfAttribute;
    }
     
 
    public JFreeChart DistributionClassesPie(Dataset dataset) {
    	boolean legend = true;
    	boolean tooltips = true;
    	boolean urls = false;
    	
    	DefaultPieDataset pieData = new DefaultPieDataset( );
        for(Map.Entry<String, Integer> val : dataset.getClassesDistribution().entrySet()) {
        	pieData.setValue( val.getKey() , val.getValue());
        }
    	
        JFreeChart pie = ChartFactory.createPieChart("Distribution des classes",pieData,legend,tooltips,urls);
        pie.setBackgroundPaint(new Color(239, 246, 255));
        PiePlot plot = (PiePlot) pie.getPlot();
        plot.setSectionPaint("Rosa", new Color(147, 197, 253));
        plot.setSectionPaint("Kama", new Color(118, 170, 226));
        plot.setSectionPaint("Canadian", new Color(162, 170, 178));
        plot.setBackgroundPaint(new Color(239, 246, 255));
        return pie;
    }
    
    public JFreeChart BoiteMoustache(ArrayList<Double> dataOfAttribute, String attributeName){
        DefaultBoxAndWhiskerXYDataset CollectionData = new DefaultBoxAndWhiskerXYDataset("");
        BoxAndWhiskerItem itemBox = BoxAndWhiskerCalculator.calculateBoxAndWhiskerStatistics(dataOfAttribute);
        CollectionData.add(new Date(),itemBox);
        JFreeChart box = ChartFactory.createBoxAndWhiskerChart("Boite � moustache", attributeName,null,CollectionData, true);
        box.setBackgroundPaint(new Color(239, 246, 255));
        XYPlot plotB  = (XYPlot) box.getPlot();
        plotB.setBackgroundPaint(new Color(239, 246, 255));
        return box;
    }

    
    public JFreeChart Histogramme(ArrayList<Double> dataOfAttribute){
    	boolean legend = true;
    	boolean tooltips = true;
    	boolean urls = true;
    	
    	double[] col = new double[dataOfAttribute.size()];
    	 for (int i = 0; i < col.length; i++) {
    		 col[i] = dataOfAttribute.get(i).doubleValue(); 
    	 }
    	 
        HistogramDataset HistogramData = new HistogramDataset ();
        HistogramData.addSeries("Distribution", col , 20);
        JFreeChart Histogram = ChartFactory.createHistogram("Histogramme", null, null,HistogramData, PlotOrientation.VERTICAL, legend, tooltips, urls);
        Histogram.setBackgroundPaint(new Color(239, 246, 255));
        XYPlot plotH  = (XYPlot) Histogram.getPlot();
    
        var renderer = new XYBarRenderer();
        renderer.setSeriesPaint(0,new Color(147, 197, 253));
        renderer.setShadowVisible(false);
        plotH.setRenderer(renderer);
        plotH.setBackgroundPaint(new Color(239, 246, 255));

        return Histogram;
    }
   
    public JFreeChart nuagePoint(ArrayList<Double> dataOfAttributeA, ArrayList<Double> dataOfAttributeB){
        XYSeriesCollection collectionData = new XYSeriesCollection();
        XYSeries element = new XYSeries("");
     
        int size = 0;
        if(dataOfAttributeA.size() > dataOfAttributeB.size()) {
        	size = dataOfAttributeA.size();
        }else {
        	size = dataOfAttributeB.size();
        }
  
        int cpt = 0;
        while(cpt < size) {
        	element.add(dataOfAttributeA.get(cpt),dataOfAttributeB.get(cpt));
        	cpt++;
        }
        collectionData.addSeries(element);
        
        boolean legend = false;
    	boolean tooltips = true;
    	boolean urls = true;
        JFreeChart sctr = ChartFactory.createScatterPlot("Diagramme de dispersion",null,null, collectionData,PlotOrientation.HORIZONTAL,legend, tooltips , urls);
        
        sctr.setBackgroundPaint(new Color(239, 246, 255));
        XYPlot plotS  = (XYPlot) sctr.getPlot();
        
        var renderer = new XYDotRenderer();
        renderer.setDotWidth(5);
        renderer.setDotHeight(5);
        renderer.setSeriesPaint(0,new Color(147, 197, 253));
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        plotS.setRenderer(renderer);
        plotS.setBackgroundPaint(new Color(239, 246, 255));

        return sctr;
    }


}
