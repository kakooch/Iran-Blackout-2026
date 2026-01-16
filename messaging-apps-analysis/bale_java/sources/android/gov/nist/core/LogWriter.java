package android.gov.nist.core;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Properties;
import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

/* loaded from: classes.dex */
public class LogWriter implements StackLogger {
    private String buildTimeStamp;
    private Properties configurationProperties;
    private int lineCount;
    private Logger logger;
    private String stackName;
    private String logFileName = null;
    private volatile boolean needsLogging = false;
    protected int traceLevel = 0;

    private void countLines(String str) {
        for (char c : str.toCharArray()) {
            if (c == '\n') {
                this.lineCount++;
            }
        }
    }

    private String enhanceMessage(String str) {
        StackTraceElement stackTraceElement = new Exception().getStackTrace()[3];
        return stackTraceElement.getClassName() + Separators.DOT + stackTraceElement.getMethodName() + Separators.LPAREN + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") [" + str + "]";
    }

    private void setTraceLevel(int i) {
        this.traceLevel = i;
    }

    public void addAppender(Appender appender) {
        this.logger.addAppender(appender);
    }

    @Override // android.gov.nist.core.StackLogger
    public void disableLogging() {
        this.needsLogging = false;
    }

    @Override // android.gov.nist.core.StackLogger
    public void enableLogging() {
        this.needsLogging = true;
    }

    public Level getLevel(int i) {
        return i == 16 ? Level.INFO : i == 4 ? Level.ERROR : i == 32 ? Level.DEBUG : i == 64 ? Level.ALL : Level.OFF;
    }

    @Override // android.gov.nist.core.StackLogger
    public int getLineCount() {
        return this.lineCount;
    }

    public Priority getLogPriority() {
        int i = this.traceLevel;
        return i == 16 ? Priority.INFO : i == 4 ? Priority.ERROR : i == 32 ? Priority.DEBUG : i == 64 ? Priority.DEBUG : Priority.FATAL;
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
        return this.traceLevel;
    }

    @Override // android.gov.nist.core.StackLogger
    public boolean isLoggingEnabled() {
        return this.needsLogging;
    }

    @Override // android.gov.nist.core.StackLogger
    public void logDebug(String str) {
        if (this.needsLogging) {
            String strEnhanceMessage = enhanceMessage(str);
            if (this.lineCount == 0) {
                getLogger().debug("BUILD TIMESTAMP = " + this.buildTimeStamp);
                getLogger().debug("Config Propeties = " + this.configurationProperties);
            }
            countLines(strEnhanceMessage);
            getLogger().debug(strEnhanceMessage);
        }
    }

    @Override // android.gov.nist.core.StackLogger
    public void logError(String str) {
        Logger logger = getLogger();
        String strEnhanceMessage = enhanceMessage(str);
        countLines(strEnhanceMessage);
        logger.error(strEnhanceMessage);
    }

    @Override // android.gov.nist.core.StackLogger
    public void logException(Throwable th) {
        if (this.needsLogging) {
            getLogger().error(th.getMessage(), th);
        }
    }

    @Override // android.gov.nist.core.StackLogger
    public void logFatalError(String str) {
        Logger logger = getLogger();
        String strEnhanceMessage = enhanceMessage(str);
        countLines(strEnhanceMessage);
        logger.fatal(strEnhanceMessage);
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
        if (this.needsLogging) {
            String strEnhanceMessage = enhanceMessage(str);
            if (this.lineCount == 0) {
                getLogger().debug("BUILD TIMESTAMP = " + this.buildTimeStamp);
                getLogger().debug("Config Propeties = " + this.configurationProperties);
            }
            countLines(strEnhanceMessage);
            getLogger().trace(strEnhanceMessage);
        }
    }

    @Override // android.gov.nist.core.StackLogger
    public void logWarning(String str) {
        getLogger().warn(str);
    }

    @Override // android.gov.nist.core.StackLogger
    public void setBuildTimeStamp(String str) {
        this.buildTimeStamp = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008f A[Catch: NumberFormatException -> 0x0048, TryCatch #1 {NumberFormatException -> 0x0048, blocks: (B:7:0x0033, B:9:0x0041, B:31:0x0086, B:33:0x008f, B:40:0x00b6, B:42:0x00ba, B:44:0x00be, B:46:0x00cd, B:56:0x0106, B:49:0x00dd, B:50:0x00e1, B:51:0x00f2, B:54:0x0101, B:35:0x0099, B:37:0x00a3, B:39:0x00ad, B:13:0x004b, B:16:0x0054, B:19:0x005e, B:22:0x0068, B:24:0x0070, B:27:0x0079, B:29:0x007f), top: B:61:0x0033, inners: #2, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0097  */
    @Override // android.gov.nist.core.StackLogger
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void setStackProperties(java.util.Properties r8) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 304
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.gov.nist.core.LogWriter.setStackProperties(java.util.Properties):void");
    }

    @Override // android.gov.nist.core.StackLogger
    public boolean isLoggingEnabled(int i) {
        return this.needsLogging && i <= this.traceLevel;
    }

    @Override // android.gov.nist.core.StackLogger
    public void logStackTrace(int i) {
        if (this.needsLogging) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            StackTraceElement[] stackTrace = new Exception().getStackTrace();
            for (int i2 = 1; i2 < stackTrace.length; i2++) {
                printWriter.print("[" + stackTrace[i2].getFileName() + ":" + stackTrace[i2].getLineNumber() + "]");
            }
            printWriter.close();
            String string = stringWriter.getBuffer().toString();
            Level level = getLevel(i);
            if (level.isGreaterOrEqual(getLogPriority())) {
                this.logger.log(level, string);
            }
        }
    }

    @Override // android.gov.nist.core.StackLogger
    public void logError(String str, Exception exc) {
        getLogger().error(str, exc);
    }

    @Override // android.gov.nist.core.StackLogger
    public void logDebug(String str, Exception exc) {
        if (this.needsLogging) {
            String strEnhanceMessage = enhanceMessage(str);
            if (this.lineCount == 0) {
                getLogger().debug("BUILD TIMESTAMP = " + this.buildTimeStamp);
                getLogger().debug("Config Propeties = " + this.configurationProperties);
            }
            countLines(strEnhanceMessage);
            getLogger().debug(strEnhanceMessage, exc);
        }
    }
}
