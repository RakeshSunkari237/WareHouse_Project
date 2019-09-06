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
public class OrderMethodUtil {

	public void generatePieChart(String path,List<Object[]> orderModes) {
		
		//create dataset 
		DefaultPieDataset dataset=new DefaultPieDataset();
		
		for(Object[] ob:orderModes) {
		dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		
		//convert to JFree Chart using ChartFactory
		JFreeChart jFreeChart = ChartFactory.createPieChart3D("Order Mode chart", dataset, true, true, false);
		
		//save image as jpeg
		try {
		ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/Ordermethodpie.jpg"), jFreeChart, 250, 250);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
       public void generateBarChart(String path,List<Object[]> orderModes) {
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(Object[] d: orderModes) {
			dataset.setValue(new Double(d[1].toString()), d[0].toString(), "");
		}
		
		JFreeChart jFreeChart=ChartFactory.createBarChart("Order Mode Bar Chart", "Order Mode", "Count", dataset);
		
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/Ordermethodbar.jpg"), jFreeChart, 250, 250);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
