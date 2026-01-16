package android.gov.nist.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;
import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/* loaded from: classes.dex */
public class CommonLoggerLog4j implements StackLogger {
    private Logger logger;

    public CommonLoggerLog4j(Logger logger) {
        this.logger = logger;
    }

    public static Level intToLevel(int i) {
        return i != 2 ? i != 4 ? i != 8 ? i != 16 ? i != 32 ? i != 64 ? Level.OFF : Level.TRACE : Level.DEBUG : Level.INFO : Level.WARN : Level.ERROR : Level.FATAL;
    }

    public static int levelToInt(Level level) {
        if (level.equals(Level.INFO)) {
            return 16;
        }
        if (level.equals(Level.ERROR)) {
            return 4;
        }
        if (level.equals(Level.DEBUG)) {
            return 32;
        }
        if (level.equals(Level.WARN)) {
            return 8;
        }
        if (level.equals(Level.TRACE)) {
            return 64;
        }
        return level.equals(Level.FATAL) ? 2 : 0;
    }

    private void setTraceLevel(int i) {
    }

    public void addAppender(Appender appender) {
        this.logger.addAppender(appender);
    }

    @Override // android.gov.nist.core.StackLogger
    public void disableLogging() {
    }

    @Override // android.gov.nist.core.StackLogger
    public void enableLogging() {
    }

    @Override // android.gov.nist.core.StackLogger
    public int getLineCount() {
        return 0;
    }

    public Logger getLogger() {
        return this.logger;
    }

    @Override // android.gov.nist.core.StackLogger
    public String getLoggerName() {
        Logger logger = this.logger;
        if (logger != null) {
            return logger.getName();
        }
        return null;
    }

    public int getTraceLevel() {
        return levelToInt(this.logger.getLevel());
    }

    @Override // android.gov.nist.core.StackLogger
    public boolean isLoggingEnabled() {
        return this.logger.isInfoEnabled();
    }

    @Override // android.gov.nist.core.StackLogger
    public void logDebug(String str) {
        this.logger.debug(str);
    }

    @Override // android.gov.nist.core.StackLogger
    public void logError(String str) {
        this.logger.error(str);
    }

    @Override // android.gov.nist.core.StackLogger
    public void logException(Throwable th) {
        this.logger.error("Error", th);
    }

    @Override // android.gov.nist.core.StackLogger
    public void logFatalError(String str) {
        this.logger.fatal(str);
    }

    @Override // android.gov.nist.core.StackLogger
    public void logInfo(String str) {
        getLogger().info(str);
    }

    @Override // android.gov.nist.core.StackLogger
    public void logStackTrace() {
        logStackTrace(32);
    }

    @Override // android.gov.nist.core.StackLogger
    public void logTrace(String str) {
        this.logger.debug(str);
    }

    @Override // android.gov.nist.core.StackLogger
    public void logWarning(String str) {
        getLogger().warn(str);
    }

    @Override // android.gov.nist.core.StackLogger
    public void setBuildTimeStamp(String str) {
        this.logger.info("Build timestamp: " + str);
    }

    @Override // android.gov.nist.core.StackLogger
    public void setStackProperties(Properties properties) {
    }

    @Override // android.gov.nist.core.StackLogger
    public boolean isLoggingEnabled(int i) {
        return this.logger.isEnabledFor(intToLevel(i));
    }

    @Override // android.gov.nist.core.StackLogger
    public void logDebug(String str, Exception exc) {
        this.logger.debug(str, exc);
    }

    @Override // android.gov.nist.core.StackLogger
    public void logError(String str, Exception exc) {
        getLogger().error(str, exc);
    }

    @Override // android.gov.nist.core.StackLogger
    public void logStackTrace(int i) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        StackTraceElement[] stackTrace = new Exception().getStackTrace();
        for (int i2 = 1; i2 < stackTrace.length; i2++) {
            printWriter.print("[" + stackTrace[i2].getFileName() + ":" + stackTrace[i2].getLineNumber() + "]");
        }
        printWriter.close();
        this.logger.debug(stringWriter.getBuffer().toString());
    }
}
