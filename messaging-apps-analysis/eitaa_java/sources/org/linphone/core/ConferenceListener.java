package org.linphone.core;

import org.linphone.core.Conference;

/* loaded from: classes3.dex */
public interface ConferenceListener {
    void onActiveSpeakerParticipantDevice(Conference conference, ParticipantDevice participantDevice);

    void onAudioDeviceChanged(Conference conference, AudioDevice audioDevice);

    void onAvailableMediaChanged(Conference conference);

    void onParticipantAdded(Conference conference, Participant participant);

    void onParticipantAdminStatusChanged(Conference conference, Participant participant);

    void onParticipantDeviceAdded(Conference conference, ParticipantDevice participantDevice);

    void onParticipantDeviceIsMuted(Conference conference, ParticipantDevice participantDevice, boolean z);

    void onParticipantDeviceIsSpeakingChanged(Conference conference, ParticipantDevice participantDevice, boolean z);

    void onParticipantDeviceMediaAvailabilityChanged(Conference conference, ParticipantDevice participantDevice);

    void onParticipantDeviceMediaCapabilityChanged(Conference conference, ParticipantDevice participantDevice);

    void onParticipantDeviceRemoved(Conference conference, ParticipantDevice participantDevice);

    void onParticipantDeviceStateChanged(Conference conference, ParticipantDevice participantDevice, ParticipantDeviceState participantDeviceState);

    void onParticipantRemoved(Conference conference, Participant participant);

    void onStateChanged(Conference conference, Conference.State state);

    void onSubjectChanged(Conference conference, String str);
}
