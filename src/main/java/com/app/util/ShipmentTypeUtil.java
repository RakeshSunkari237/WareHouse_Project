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
public class ShipmentTypeUtil {

	public void generatePie(String path,List<Object[]> shipmentTypes) {
		
		// 1.create DataSet using shipmentTypes
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] ob:shipmentTypes) {
		dataset.setValue(ob[0].toString(),new Double(ob[1].toString()));
		}
		
		//2.convert to jFree chart using chartFactory
		JFreeChart chart = ChartFactory.createPieChart3D("ShipmentTypes Modes", dataset);
		
		//3.save ad image using ChartUtils
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/ShipmentPie.jpg"), chart, 500, 600);
		} catch (IOException e) {
			System.out.println("Error in Genarate Pie chart");
			e.printStackTrace();
		}
		
	}
	
	public void generateBar(String path,List<Object[]> shipmentTypes) {
		
		//1.create dataset using shipmentTypes
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] ob:shipmentTypes) {
		dataset.setValue(new Double(ob[1].toString()), ob[0].toString(), "Shipment Modes Details");
		}
		
		//2.convert to jFreechart using ChartFactroy
		JFreeChart chart = ChartFactory.createBarChart("ShipmentTypeModes", "Modes", "count", dataset);
		
		//3.save as Image using ChartUtis
		try {
		ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/ShipmentBar.jpeg"), chart, 300, 300);
		}catch(IOException e) {
			System.out.println("Error in Genarate Bar chart");
			e.printStackTrace();
		}
	}
}
