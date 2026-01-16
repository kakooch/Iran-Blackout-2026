package org.linphone.core;

/* loaded from: classes3.dex */
public interface ParticipantDeviceListener {
    void onIsMuted(ParticipantDevice participantDevice, boolean z);

    void onIsSpeakingChanged(ParticipantDevice participantDevice, boolean z);

    void onStateChanged(ParticipantDevice participantDevice, ParticipantDeviceState participantDeviceState);

    void onStreamAvailabilityChanged(ParticipantDevice participantDevice, boolean z, StreamType streamType);

    void onStreamCapabilityChanged(ParticipantDevice participantDevice, MediaDirection mediaDirection, StreamType streamType);

    void onVideoDisplayErrorOccurred(ParticipantDevice participantDevice, int i);
}
