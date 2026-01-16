package org.linphone.core;

/* loaded from: classes3.dex */
public interface ConferenceParams {
    /* renamed from: clone */
    ConferenceParams mo47clone();

    Account getAccount();

    Address getConferenceFactoryAddress();

    String getDescription();

    long getEndTime();

    long getNativePointer();

    ConferenceParticipantListType getParticipantListType();

    @Deprecated
    ProxyConfig getProxyCfg();

    long getStartTime();

    String getSubject();

    Object getUserData();

    boolean isAudioEnabled();

    boolean isChatEnabled();

    boolean isLocalParticipantEnabled();

    boolean isOneParticipantConferenceEnabled();

    boolean isVideoEnabled();

    void setAudioEnabled(boolean z);

    void setChatEnabled(boolean z);

    void setConferenceFactoryAddress(Address address);

    void setDescription(String str);

    void setEndTime(long j);

    void setLocalParticipantEnabled(boolean z);

    void setOneParticipantConferenceEnabled(boolean z);

    void setParticipantListType(ConferenceParticipantListType conferenceParticipantListType);

    void setStartTime(long j);

    void setSubject(String str);

    void setUserData(Object obj);

    void setVideoEnabled(boolean z);

    String toString();
}
