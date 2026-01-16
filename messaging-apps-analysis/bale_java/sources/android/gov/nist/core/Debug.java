package android.gov.nist.core;

/* loaded from: classes.dex */
public class Debug {
    public static boolean debug = false;
    public static boolean parserDebug = false;
    static StackLogger stackLogger;

    public static void logError(String str, Exception exc) {
        StackLogger stackLogger2;
        if ((parserDebug || debug) && (stackLogger2 = stackLogger) != null && stackLogger2.isLoggingEnabled(32)) {
            stackLogger.logError(str, exc);
        }
    }

    public static void printStackTrace(Exception exc) {
        StackLogger stackLogger2;
        if ((parserDebug || debug) && (stackLogger2 = stackLogger) != null) {
            stackLogger2.logError("Stack Trace", exc);
        }
    }

    public static void println(String str) {
        StackLogger stackLogger2;
        if ((parserDebug || debug) && (stackLogger2 = stackLogger) != null && stackLogger2.isLoggingEnabled(32)) {
            stackLogger.logDebug(str + Separators.RETURN);
        }
    }

    public static void setStackLogger(StackLogger stackLogger2) {
        stackLogger = stackLogger2;
    }
}
