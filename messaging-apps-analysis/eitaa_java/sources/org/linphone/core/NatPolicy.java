package org.linphone.core;

/* loaded from: classes3.dex */
public interface NatPolicy {
    void clear();

    /* renamed from: clone */
    NatPolicy mo50clone();

    Core getCore();

    String getNatV4Address();

    String getNatV6Address();

    long getNativePointer();

    String getStunServer();

    String getStunServerUsername();

    Object getUserData();

    boolean isIceEnabled();

    boolean isStunEnabled();

    boolean isTcpTurnTransportEnabled();

    boolean isTlsTurnTransportEnabled();

    boolean isTurnEnabled();

    boolean isUdpTurnTransportEnabled();

    boolean isUpnpEnabled();

    void resolveStunServer();

    void setIceEnabled(boolean z);

    void setNatV4Address(String str);

    void setNatV6Address(String str);

    void setStunEnabled(boolean z);

    void setStunServer(String str);

    void setStunServerUsername(String str);

    void setTcpTurnTransportEnabled(boolean z);

    void setTlsTurnTransportEnabled(boolean z);

    void setTurnEnabled(boolean z);

    void setUdpTurnTransportEnabled(boolean z);

    void setUpnpEnabled(boolean z);

    void setUserData(Object obj);

    String toString();
}
