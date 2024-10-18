package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports () { //synchronized means keeping the thread
        ExtentSparkReporter reporter = new ExtentSparkReporter(ConstantUtils.EXTENT_FOLDER + SeleniumUtils.getReportName());
        reporter.config().setReportName("AUT 09 REPORT");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Author", "Andrei Gunta");
        extentReports.setSystemInfo("Environment", "local");
        extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java runtime version", System.getProperty("java.runtime.version"));

        return extentReports;
    }
}
