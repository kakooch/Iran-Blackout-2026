package org.linphone.core;

/* loaded from: classes3.dex */
public interface ErrorInfo {
    long getNativePointer();

    String getPhrase();

    String getProtocol();

    int getProtocolCode();

    Reason getReason();

    int getRetryAfter();

    ErrorInfo getSubErrorInfo();

    Object getUserData();

    String getWarnings();

    void set(String str, Reason reason, int i, String str2, String str3);

    void setPhrase(String str);

    void setProtocol(String str);

    void setProtocolCode(int i);

    void setReason(Reason reason);

    void setRetryAfter(int i);

    void setSubErrorInfo(ErrorInfo errorInfo);

    void setUserData(Object obj);

    void setWarnings(String str);

    String toString();
}
