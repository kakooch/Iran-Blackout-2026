package org.webrtc;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.EnumSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.linphone.mediastream.Factory;

/* loaded from: classes3.dex */
public class Logging {
    private static final Logger fallbackLogger = createFallbackLogger();
    private static Loggable loggable;
    private static Severity loggableSeverity;
    private static volatile boolean loggingEnabled;

    public enum Severity {
        LS_VERBOSE,
        LS_INFO,
        LS_WARNING,
        LS_ERROR,
        LS_NONE
    }

    @Deprecated
    public static void enableTracing(String path, EnumSet<TraceLevel> levels) {
    }

    private static native void nativeEnableLogThreads();

    private static native void nativeEnableLogTimeStamps();

    private static native void nativeEnableLogToDebugOutput(int nativeSeverity);

    private static native void nativeLog(int severity, String tag, String message);

    private static Logger createFallbackLogger() throws SecurityException {
        Logger logger = Logger.getLogger("org.webrtc.Logging");
        logger.setLevel(Level.ALL);
        return logger;
    }

    static void injectLoggable(Loggable injectedLoggable, Severity severity) {
        if (injectedLoggable != null) {
            loggable = injectedLoggable;
            loggableSeverity = severity;
        }
    }

    static void deleteInjectedLoggable() {
        loggable = null;
    }

    @Deprecated
    public enum TraceLevel {
        TRACE_NONE(0),
        TRACE_STATEINFO(1),
        TRACE_WARNING(2),
        TRACE_ERROR(4),
        TRACE_CRITICAL(8),
        TRACE_APICALL(16),
        TRACE_DEFAULT(255),
        TRACE_MODULECALL(32),
        TRACE_MEMORY(Factory.DEVICE_HAS_CRAPPY_OPENSLES),
        TRACE_TIMER(Factory.DEVICE_USE_ANDROID_CAMCORDER),
        TRACE_STREAM(Factory.DEVICE_MCH264ENC_NO_PIX_FMT_CONV),
        TRACE_DEBUG(Factory.DEVICE_MCH265_LIMIT_DEQUEUE_OF_OUTPUT_BUFFERS),
        TRACE_INFO(Factory.DEVICE_HAS_CRAPPY_AAUDIO),
        TRACE_TERSEINFO(8192),
        TRACE_ALL(65535);

        public final int level;

        TraceLevel(int level) {
            this.level = level;
        }
    }

    public static void enableLogThreads() {
        nativeEnableLogThreads();
    }

    public static void enableLogTimeStamps() {
        nativeEnableLogTimeStamps();
    }

    public static synchronized void enableLogToDebugOutput(Severity severity) {
        if (loggable != null) {
            throw new IllegalStateException("Logging to native debug output not supported while Loggable is injected. Delete the Loggable before calling this method.");
        }
        nativeEnableLogToDebugOutput(severity.ordinal());
        loggingEnabled = true;
    }

    public static void log(Severity severity, String tag, String message) {
        Level level;
        if (tag == null || message == null) {
            throw new IllegalArgumentException("Logging tag or message may not be null.");
        }
        if (loggable != null) {
            if (severity.ordinal() < loggableSeverity.ordinal()) {
                return;
            }
            loggable.onLogMessage(message, severity, tag);
            return;
        }
        if (loggingEnabled) {
            nativeLog(severity.ordinal(), tag, message);
            return;
        }
        int i = AnonymousClass1.$SwitchMap$org$webrtc$Logging$Severity[severity.ordinal()];
        if (i == 1) {
            level = Level.SEVERE;
        } else if (i == 2) {
            level = Level.WARNING;
        } else if (i == 3) {
            level = Level.INFO;
        } else {
            level = Level.FINE;
        }
        fallbackLogger.log(level, tag + ": " + message);
    }

    /* renamed from: org.webrtc.Logging$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$webrtc$Logging$Severity;

        static {
            int[] iArr = new int[Severity.values().length];
            $SwitchMap$org$webrtc$Logging$Severity = iArr;
            try {
                iArr[Severity.LS_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$webrtc$Logging$Severity[Severity.LS_WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$webrtc$Logging$Severity[Severity.LS_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static void d(String tag, String message) {
        log(Severity.LS_INFO, tag, message);
    }

    public static void e(String tag, String message) {
        log(Severity.LS_ERROR, tag, message);
    }

    public static void w(String tag, String message) {
        log(Severity.LS_WARNING, tag, message);
    }

    public static void e(String tag, String message, Throwable e) {
        Severity severity = Severity.LS_ERROR;
        log(severity, tag, message);
        log(severity, tag, e.toString());
        log(severity, tag, getStackTraceString(e));
    }

    public static void w(String tag, String message, Throwable e) {
        Severity severity = Severity.LS_WARNING;
        log(severity, tag, message);
        log(severity, tag, e.toString());
        log(severity, tag, getStackTraceString(e));
    }

    public static void v(String tag, String message) {
        log(Severity.LS_VERBOSE, tag, message);
    }

    private static String getStackTraceString(Throwable e) {
        if (e == null) {
            return "";
        }
        StringWriter stringWriter = new StringWriter();
        e.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
