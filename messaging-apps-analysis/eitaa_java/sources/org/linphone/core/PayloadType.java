package org.linphone.core;

/* loaded from: classes3.dex */
public interface PayloadType {
    /* renamed from: clone */
    PayloadType mo51clone();

    int enable(boolean z);

    boolean enabled();

    int getChannels();

    int getClockRate();

    String getDescription();

    String getEncoderDescription();

    String getMimeType();

    long getNativePointer();

    int getNormalBitrate();

    int getNumber();

    String getRecvFmtp();

    String getSendFmtp();

    int getType();

    Object getUserData();

    boolean isUsable();

    boolean isVbr();

    void setNormalBitrate(int i);

    void setNumber(int i);

    void setRecvFmtp(String str);

    void setSendFmtp(String str);

    void setUserData(Object obj);

    String toString();
}
