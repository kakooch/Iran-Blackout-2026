package org.linphone.core;

/* loaded from: classes3.dex */
public interface TunnelConfig {
    int getDelay();

    String getHost();

    String getHost2();

    long getNativePointer();

    int getPort();

    int getPort2();

    int getRemoteUdpMirrorPort();

    Object getUserData();

    void setDelay(int i);

    void setHost(String str);

    void setHost2(String str);

    void setPort(int i);

    void setPort2(int i);

    void setRemoteUdpMirrorPort(int i);

    void setUserData(Object obj);

    String toString();
}
