package org.linphone.core;

import org.linphone.core.Call;

/* loaded from: classes3.dex */
public interface CallLog {
    String getCallId();

    ConferenceInfo getConferenceInfo();

    Call.Dir getDir();

    int getDuration();

    ErrorInfo getErrorInfo();

    Address getFromAddress();

    Address getLocalAddress();

    long getNativePointer();

    float getQuality();

    String getRefKey();

    Address getRemoteAddress();

    long getStartDate();

    Call.Status getStatus();

    Address getToAddress();

    Object getUserData();

    boolean isVideoEnabled();

    void setRefKey(String str);

    void setRemoteAddress(Address address);

    void setUserData(Object obj);

    String toStr();

    String toString();

    boolean wasConference();
}
