package android.gov.nist.core;

import java.util.Properties;
import org.apache.log4j.Logger;

/* loaded from: classes.dex */
public class CommonLogger implements StackLogger {
    public static StackLogger legacyLogger = null;
    public static boolean useLegacyLogger = true;
    private String name;
    private StackLogger otherLogger;

    public CommonLogger(String str) {
        this.name = str;
    }

    public static StackLogger getLogger(String str) {
        return new CommonLogger(str);
    }

    public static void init(Properties properties) {
    }

    private StackLogger logger() {
        if (useLegacyLogger) {
            StackLogger stackLogger = legacyLogger;
            return stackLogger == null ? new CommonLoggerLog4j(Logger.getLogger(this.name)) : stackLogger;
        }
        if (this.otherLogger == null) {
            this.otherLogger = new CommonLoggerLog4j(Logger.getLogger(this.name));
        }
        return this.otherLogger;
    }

    @Override // android.gov.nist.core.StackLogger
    public void disableLogging() {
        logger().disableLogging();
    }

    @Override // android.gov.nist.core.StackLogger
    public void enableLogging() {
        logger().enableLogging();
    }

    @Override // android.gov.nist.core.StackLogger
    public int getLineCount() {
        return logger().getLineCount();
    }

    @Override // android.gov.nist.core.StackLogger
    public String getLoggerName() {
        return logger().getLoggerName();
    }

    @Override // android.gov.nist.core.StackLogger
    public boolean isLoggingEnabled() {
        return logger().isLoggingEnabled();
    }

    @Override // android.gov.nist.core.StackLogger
    public void logDebug(String str) {
        logger().logDebug(str);
    }

    @Override // android.gov.nist.core.StackLogger
    public void logError(String str) {
        logger().logError(str);
    }

    @Override // android.gov.nist.core.StackLogger
    public void logException(Throwable th) {
        logger().logException(th);
    }

    @Override // android.gov.nist.core.StackLogger
    public void logFatalError(String str) {
        logger().logFatalError(str);
    }

    @Override // android.gov.nist.core.StackLogger
    public void logInfo(String str) {
        logger().logInfo(str);
    }

    @Override // android.gov.nist.core.StackLogger
    public void logStackTrace() {
        logger().logStackTrace();
    }

    @Override // android.gov.nist.core.StackLogger
    public void logTrace(String str) {
        logger().logTrace(str);
    }

    @Override // android.gov.nist.core.StackLogger
    public void logWarning(String str) {
        logger().logWarning(str);
    }

    @Override // android.gov.nist.core.StackLogger
    public void setBuildTimeStamp(String str) {
        logger().setBuildTimeStamp(str);
    }

    @Override // android.gov.nist.core.StackLogger
    public void setStackProperties(Properties properties) {
        legacyLogger.setStackProperties(properties);
    }

    public static StackLogger getLogger(Class cls) {
        return getLogger(cls.getName());
    }

    @Override // android.gov.nist.core.StackLogger
    public boolean isLoggingEnabled(int i) {
        return logger().isLoggingEnabled(i);
    }

    @Override // android.gov.nist.core.StackLogger
    public void logDebug(String str, Exception exc) {
        logger().logDebug(str, exc);
    }

    @Override // android.gov.nist.core.StackLogger
    public void logError(String str, Exception exc) {
        logger().logError(str, exc);
    }

    @Override // android.gov.nist.core.StackLogger
    public void logStackTrace(int i) {
        logger().logStackTrace(i);
    }
}
