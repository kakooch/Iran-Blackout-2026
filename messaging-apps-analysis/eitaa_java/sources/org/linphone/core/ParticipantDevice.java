package org.linphone.core;

/* loaded from: classes3.dex */
public interface ParticipantDevice {
    void addListener(ParticipantDeviceListener participantDeviceListener);

    Object createNativeVideoWindowId();

    Address getAddress();

    ParticipantDeviceDisconnectionMethod getDisconnectionMethod();

    String getDisconnectionReason();

    boolean getIsMuted();

    boolean getIsSpeaking();

    ParticipantDeviceJoiningMethod getJoiningMethod();

    String getName();

    long getNativePointer();

    Object getNativeVideoWindowId();

    ChatRoomSecurityLevel getSecurityLevel();

    int getSsrc(StreamType streamType);

    ParticipantDeviceState getState();

    boolean getStreamAvailability(StreamType streamType);

    MediaDirection getStreamCapability(StreamType streamType);

    long getTimeOfDisconnection();

    long getTimeOfJoining();

    Object getUserData();

    boolean isInConference();

    void removeListener(ParticipantDeviceListener participantDeviceListener);

    void setNativeVideoWindowId(Object obj);

    void setUserData(Object obj);

    String toString();
}
