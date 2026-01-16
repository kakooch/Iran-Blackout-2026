package android.gov.nist.javax.sip.stack;

import android.gov.nist.core.CommonLogger;
import android.gov.nist.core.Separators;
import android.gov.nist.core.ServerLogger;
import android.gov.nist.core.StackLogger;
import android.gov.nist.javax.sip.LogRecord;
import android.gov.nist.javax.sip.header.CallID;
import android.gov.nist.javax.sip.header.SIPHeaderNames;
import android.gov.nist.javax.sip.message.SIPMessage;
import ir.nasim.InterfaceC16186kq7;
import ir.nasim.MD6;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Properties;

/* loaded from: classes.dex */
public class ServerLog implements ServerLogger {
    private String auxInfo;
    private Properties configurationProperties;
    private String description;
    private boolean logContent;
    private String logFileName;
    private PrintWriter printWriter;
    private SIPTransactionStack sipStack;
    private String stackIpAddress;
    protected StackLogger stackLogger;
    protected int traceLevel = 16;

    private void logMessage(String str) throws IOException {
        checkLogFile();
        PrintWriter printWriter = this.printWriter;
        if (printWriter != null) {
            printWriter.println(str);
        }
        if (this.sipStack.isLoggingEnabled()) {
            this.stackLogger.logInfo(str);
        }
    }

    private void setProperties(Properties properties) throws IOException {
        this.configurationProperties = properties;
        this.description = properties.getProperty("android.javax.sip.STACK_NAME");
        this.stackIpAddress = properties.getProperty("android.javax.sip.IP_ADDRESS");
        this.logFileName = properties.getProperty("android.gov.nist.javax.sip.SERVER_LOG");
        String property = properties.getProperty("android.gov.nist.javax.sip.TRACE_LEVEL");
        String property2 = properties.getProperty("android.gov.nist.javax.sip.LOG_MESSAGE_CONTENT");
        this.logContent = property2 != null && property2.equals("true");
        if (property != null) {
            if (property.equals("LOG4J")) {
                CommonLogger.useLegacyLogger = false;
            } else {
                try {
                    setTraceLevel(property.equals("DEBUG") ? 32 : property.equals("INFO") ? 16 : property.equals("ERROR") ? 4 : (property.equals("NONE") || property.equals("OFF")) ? 0 : Integer.parseInt(property));
                } catch (NumberFormatException unused) {
                    PrintStream printStream = System.out;
                    printStream.println("ServerLog: WARNING Bad integer " + property);
                    printStream.println("logging dislabled ");
                    setTraceLevel(0);
                }
            }
        }
        checkLogFile();
    }

    public void checkLogFile() throws IOException {
        if (this.logFileName == null || this.traceLevel < 16) {
            return;
        }
        try {
            File file = new File(this.logFileName);
            if (!file.exists()) {
                file.createNewFile();
                this.printWriter = null;
            }
            if (this.printWriter == null) {
                PrintWriter printWriter = new PrintWriter((Writer) new FileWriter(this.logFileName, !Boolean.valueOf(this.configurationProperties.getProperty("android.gov.nist.javax.sip.SERVER_LOG_OVERWRITE")).booleanValue()), true);
                this.printWriter = printWriter;
                printWriter.println("<!-- Use the  Trace Viewer in src/tools/tracesviewer to view this  trace  \nHere are the stack configuration properties \nandroid.javax.sip.IP_ADDRESS= " + this.configurationProperties.getProperty("android.javax.sip.IP_ADDRESS") + Separators.RETURN + "android.javax.sip.STACK_NAME= " + this.configurationProperties.getProperty("android.javax.sip.STACK_NAME") + Separators.RETURN + "android.javax.sip.ROUTER_PATH= " + this.configurationProperties.getProperty("android.javax.sip.ROUTER_PATH") + Separators.RETURN + "android.javax.sip.OUTBOUND_PROXY= " + this.configurationProperties.getProperty("android.javax.sip.OUTBOUND_PROXY") + Separators.RETURN + "-->");
                PrintWriter printWriter2 = this.printWriter;
                StringBuilder sb = new StringBuilder();
                sb.append("<description\n logDescription=\"");
                sb.append(this.description);
                sb.append("\"\n name=\"");
                sb.append(this.configurationProperties.getProperty("android.javax.sip.STACK_NAME"));
                sb.append("\"\n auxInfo=\"");
                sb.append(this.auxInfo);
                sb.append("\"/>\n ");
                printWriter2.println(sb.toString());
                if (this.auxInfo == null) {
                    if (this.sipStack.isLoggingEnabled(32)) {
                        this.stackLogger.logDebug("Here are the stack configuration properties \n" + this.configurationProperties + Separators.RETURN);
                        this.stackLogger.logDebug(" ]]>");
                        this.stackLogger.logDebug("</debug>");
                        this.stackLogger.logDebug("<description\n logDescription=\"" + this.description + "\"\n name=\"" + this.stackIpAddress + "\" />\n");
                        this.stackLogger.logDebug("<debug>");
                        this.stackLogger.logDebug("<![CDATA[ ");
                        return;
                    }
                    return;
                }
                if (this.sipStack.isLoggingEnabled(32)) {
                    this.stackLogger.logDebug("Here are the stack configuration properties \nandroid.javax.sip.IP_ADDRESS= " + this.configurationProperties.getProperty("android.javax.sip.IP_ADDRESS") + Separators.RETURN + "android.javax.sip.ROUTER_PATH= " + this.configurationProperties.getProperty("android.javax.sip.ROUTER_PATH") + Separators.RETURN + "android.javax.sip.OUTBOUND_PROXY= " + this.configurationProperties.getProperty("android.javax.sip.OUTBOUND_PROXY") + Separators.RETURN + "android.gov.nist.javax.sip.CACHE_CLIENT_CONNECTIONS= " + this.configurationProperties.getProperty("android.gov.nist.javax.sip.CACHE_CLIENT_CONNECTIONS") + Separators.RETURN + "android.gov.nist.javax.sip.CACHE_SERVER_CONNECTIONS= " + this.configurationProperties.getProperty("android.gov.nist.javax.sip.CACHE_SERVER_CONNECTIONS") + Separators.RETURN + "android.gov.nist.javax.sip.REENTRANT_LISTENER= " + this.configurationProperties.getProperty("android.gov.nist.javax.sip.REENTRANT_LISTENER") + "android.gov.nist.javax.sip.THREAD_POOL_SIZE= " + this.configurationProperties.getProperty("android.gov.nist.javax.sip.THREAD_POOL_SIZE") + Separators.RETURN);
                    this.stackLogger.logDebug(" ]]> ");
                    this.stackLogger.logDebug("</debug>");
                    StackLogger stackLogger = this.stackLogger;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("<description\n logDescription=\"");
                    sb2.append(this.description);
                    sb2.append("\"\n name=\"");
                    sb2.append(this.stackIpAddress);
                    sb2.append("\"\n auxInfo=\"");
                    sb2.append(this.auxInfo);
                    sb2.append("\"/>\n ");
                    stackLogger.logDebug(sb2.toString());
                    this.stackLogger.logDebug("<debug>");
                    this.stackLogger.logDebug("<![CDATA[ ");
                }
            }
        } catch (IOException unused) {
        }
    }

    @Override // android.gov.nist.core.ServerLogger
    public synchronized void closeLogFile() {
        PrintWriter printWriter = this.printWriter;
        if (printWriter != null) {
            printWriter.close();
            this.printWriter = null;
        }
    }

    public String getLogFileName() {
        return this.logFileName;
    }

    public int getTraceLevel() {
        return this.traceLevel;
    }

    @Override // android.gov.nist.core.ServerLogger
    public void logException(Exception exc) throws IOException {
        if (this.traceLevel >= 4) {
            checkLogFile();
            exc.printStackTrace();
            PrintWriter printWriter = this.printWriter;
            if (printWriter != null) {
                exc.printStackTrace(printWriter);
            }
        }
    }

    public boolean needsLogging() {
        return this.logFileName != null;
    }

    public void setAuxInfo(String str) {
        this.auxInfo = str;
    }

    public void setLevel(int i) {
    }

    public void setLogFileName(String str) {
        this.logFileName = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.gov.nist.core.ServerLogger
    public void setSipStack(MD6 md6) {
        if (!(md6 instanceof SIPTransactionStack)) {
            throw new IllegalArgumentException("sipStack must be a SIPTransactionStack");
        }
        SIPTransactionStack sIPTransactionStack = (SIPTransactionStack) md6;
        this.sipStack = sIPTransactionStack;
        this.stackLogger = sIPTransactionStack.getStackLogger();
    }

    public void setStackIpAddress(String str) {
        this.stackIpAddress = str;
    }

    @Override // android.gov.nist.core.ServerLogger
    public void setStackProperties(Properties properties) throws IOException {
        setProperties(properties);
    }

    public void setTraceLevel(int i) {
        this.traceLevel = i;
    }

    private void logMessage(String str, String str2, String str3, boolean z, String str4, String str5, String str6, String str7, long j, long j2) throws IOException {
        LogRecord logRecordCreateLogRecord = this.sipStack.logRecordFactory.createLogRecord(str, str2, str3, j, z, str5, str7, str4, j2);
        if (logRecordCreateLogRecord != null) {
            logMessage(logRecordCreateLogRecord.toString());
        }
    }

    @Override // android.gov.nist.core.ServerLogger
    public void logMessage(SIPMessage sIPMessage, String str, String str2, boolean z, long j) throws IOException {
        checkLogFile();
        if (sIPMessage.getFirstLine() == null) {
            return;
        }
        CallID callID = (CallID) sIPMessage.getCallId();
        String callId = callID != null ? callID.getCallId() : null;
        String strTrim = sIPMessage.getFirstLine().trim();
        String strEncode = this.logContent ? sIPMessage.encode() : sIPMessage.encodeMessage(new StringBuilder()).toString();
        String transactionId = sIPMessage.getTransactionId();
        InterfaceC16186kq7 interfaceC16186kq7 = (InterfaceC16186kq7) sIPMessage.getHeader(SIPHeaderNames.TIMESTAMP);
        logMessage(strEncode, str, str2, z, callId, strTrim, null, transactionId, j, interfaceC16186kq7 == null ? 0L : interfaceC16186kq7.getTime());
    }

    @Override // android.gov.nist.core.ServerLogger
    public void logMessage(SIPMessage sIPMessage, String str, String str2, String str3, boolean z, long j) throws IOException {
        checkLogFile();
        CallID callID = (CallID) sIPMessage.getCallId();
        String callId = callID != null ? callID.getCallId() : null;
        String strTrim = sIPMessage.getFirstLine().trim();
        String strEncode = this.logContent ? sIPMessage.encode() : sIPMessage.encodeMessage(new StringBuilder()).toString();
        String transactionId = sIPMessage.getTransactionId();
        InterfaceC16186kq7 interfaceC16186kq7 = (InterfaceC16186kq7) sIPMessage.getHeader(SIPHeaderNames.TIMESTAMP);
        logMessage(strEncode, str, str2, z, callId, strTrim, str3, transactionId, j, interfaceC16186kq7 == null ? 0L : interfaceC16186kq7.getTime());
    }

    @Override // android.gov.nist.core.ServerLogger
    public void logMessage(SIPMessage sIPMessage, String str, String str2, String str3, boolean z) throws IOException {
        logMessage(sIPMessage, str, str2, str3, z, System.currentTimeMillis());
    }
}
