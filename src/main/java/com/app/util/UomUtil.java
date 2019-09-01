package com.app.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class UomUtil {
	
	public void generatePieChart(String path,List<Object[]> uoms) {
		
		// create dataset
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:uoms) {
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		
		// convert to jfreechart using chartFactory
		JFreeChart chart = ChartFactory.createPieChart3D("uom pie chart", dataset);
		
		// save image as JPEG using ChartUtils
		
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resouces/images/uompie.jpg"), chart, 250	, 250);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void generateBarChart(String path,List<Object[]> uoms)  {
		//creata dataset
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] ob:uoms) {
			dataset.setValue(new Double(ob[1].toString()), ob[0].toString(),"");
		}
		
		// convert to Jfree Chart using ChartFactory
		JFreeChart chart = ChartFactory.createBarChart("uom Bar chart", "Order mode", "count", dataset);
		
		//save image ad jpeg
		try {
		ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/uombarchart.jpg"), chart, 500, 500);
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
}
