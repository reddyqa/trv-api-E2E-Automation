package com.MSIL.TestUtils;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager
{
	private static ExtentReports extent;
	//private static ExtentTest test;
	private static ExtentHtmlReporter htmlReporter;
	private static String filePath = "./extentreport.html";


	public static ExtentReports GetExtent() {
		if (extent != null) {
			return extent;
		} else {
			extent = new ExtentReports();
			extent.attachReporter(getHtmlReporter());
			extent.setSystemInfo("Host Name", "Hanumaraddy M");
			
			extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
			return extent;
		}
	}

	public static ExtentHtmlReporter getHtmlReporter() {

		htmlReporter = new ExtentHtmlReporter(filePath);
		/*htmlReporter.config().setChartVisibilityOnOpen(true);
		htmlReporter.config().setDocumentTitle("IdentHQ Automation Report");
		htmlReporter.config().setReportName("Automation");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);*/
		
		htmlReporter.setAppendExisting(false);
		htmlReporter.loadXMLConfig("./extentconfig/ReportsConfig.xml");

		return htmlReporter;
	}

}
