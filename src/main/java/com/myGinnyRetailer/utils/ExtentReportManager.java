package com.myGinnyRetailer.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;

public class ExtentReportManager {

    public static ExtentReports report;
    public static ExtentReports getReportInstance(){
        if ( report == null){
            //Create file name to store the test report in html format

            String reportNames = DateUtils.getTimeStamp() + ".html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/src/test/test-output/" + reportNames);

            report = new ExtentReports();
            report.attachReporter(sparkReporter);

            report.setSystemInfo("OS", "Window 10");
            report.setSystemInfo("Environment", "UAT");
            report.setSystemInfo("Build Number", "1.0");
            report.setSystemInfo("Browser", "Chrome");
            report.setSystemInfo("Browser", "FireFox");
            report.setSystemInfo("Browser", "Edge");

            sparkReporter.config().setDocumentTitle("Backed UAT Retailers UI Automation Result");
            sparkReporter.config().setDocumentTitle("All Headlines UI Test Result");
            sparkReporter.config().setTimeStampFormat("MM dd, yyyy HH:mm:ss");
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.viewConfigurer().viewOrder().as(new ViewName[]{ViewName.DASHBOARD,ViewName.TEST,ViewName.CATEGORY}).apply();

//            ExtentTest logger = report.createTest("MGI Retailer").assignAuthor("Md Imaran Shah").assignCategory("Regression").assignCategory("Smoke").assignDevice("Chrome 113");
//            logger.pass("Login test start successfully");
//            logger.info("URL is loaded");
//            logger.pass("Enter UserName");
//
//            Arrays.asList(new String []{"Selenium", "Appium", "Rest Assured "}).forEach(logger::pass);

            //logger.pass(MarkupHelper.createOrderedList(Arrays.asList(new String[]{"Selenium", "Appium", "Rest Assured "})).getMarkup());


        }
        return report;
    }

}
