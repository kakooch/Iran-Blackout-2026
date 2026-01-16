package org.linphone.core;

/* loaded from: classes3.dex */
public interface LoggingService {
    void addListener(LoggingServiceListener loggingServiceListener);

    void debug(String str);

    void error(String str);

    void fatal(String str);

    LoggingService get();

    String getDomain();

    int getLogLevelMask();

    long getNativePointer();

    Object getUserData();

    void message(String str);

    void removeListener(LoggingServiceListener loggingServiceListener);

    void setDomain(String str);

    void setLogFile(String str, String str2, int i);

    void setLogLevel(LogLevel logLevel);

    void setLogLevelMask(int i);

    void setStackTraceDumpsEnabled(boolean z);

    void setUserData(Object obj);

    String toString();

    void trace(String str);

    void warning(String str);
}
