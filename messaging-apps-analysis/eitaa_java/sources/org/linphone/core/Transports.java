package org.linphone.core;

/* loaded from: classes3.dex */
public interface Transports {
    int getDtlsPort();

    long getNativePointer();

    int getTcpPort();

    int getTlsPort();

    int getUdpPort();

    Object getUserData();

    void setDtlsPort(int i);

    void setTcpPort(int i);

    void setTlsPort(int i);

    void setUdpPort(int i);

    void setUserData(Object obj);

    String toString();
}
