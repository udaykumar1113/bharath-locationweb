package com.uday.location.utility;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class ReportUtilityImpl implements ReportUtility {
    @Override
    public void generatePieChart(String path, List<Object[]> data) {

        DefaultPieDataset dataset=new DefaultPieDataset();

        for (Object[] objects : data) {
            dataset.setValue(objects[0].toString(), new Double(objects[1].toString()));
        }

        JFreeChart chart= ChartFactory.createPieChart3D("lOCATION TYPE REPORT",dataset);
        try {
            System.out.println("before generating pie chart at path"+path);
            ChartUtilities.saveChartAsJPEG(new File(path+"/pieChart.jpeg"), chart, 300, 300);
                System.out.println("generated pie chart");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
