package org.linphone.core;

import org.linphone.core.Conference;

/* loaded from: classes3.dex */
public class ConferenceListenerStub implements ConferenceListener {
    @Override // org.linphone.core.ConferenceListener
    public void onActiveSpeakerParticipantDevice(Conference conference, ParticipantDevice participantDevice) {
    }

    @Override // org.linphone.core.ConferenceListener
    public void onAudioDeviceChanged(Conference conference, AudioDevice audioDevice) {
    }

    @Override // org.linphone.core.ConferenceListener
    public void onAvailableMediaChanged(Conference conference) {
    }

    @Override // org.linphone.core.ConferenceListener
    public void onParticipantAdded(Conference conference, Participant participant) {
    }

    @Override // org.linphone.core.ConferenceListener
    public void onParticipantAdminStatusChanged(Conference conference, Participant participant) {
    }

    @Override // org.linphone.core.ConferenceListener
    public void onParticipantDeviceAdded(Conference conference, ParticipantDevice participantDevice) {
    }

    @Override // org.linphone.core.ConferenceListener
    public void onParticipantDeviceIsMuted(Conference conference, ParticipantDevice participantDevice, boolean z) {
    }

    @Override // org.linphone.core.ConferenceListener
    public void onParticipantDeviceIsSpeakingChanged(Conference conference, ParticipantDevice participantDevice, boolean z) {
    }

    @Override // org.linphone.core.ConferenceListener
    public void onParticipantDeviceMediaAvailabilityChanged(Conference conference, ParticipantDevice participantDevice) {
    }

    @Override // org.linphone.core.ConferenceListener
    public void onParticipantDeviceMediaCapabilityChanged(Conference conference, ParticipantDevice participantDevice) {
    }

    @Override // org.linphone.core.ConferenceListener
    public void onParticipantDeviceRemoved(Conference conference, ParticipantDevice participantDevice) {
    }

    @Override // org.linphone.core.ConferenceListener
    public void onParticipantDeviceStateChanged(Conference conference, ParticipantDevice participantDevice, ParticipantDeviceState participantDeviceState) {
    }

    @Override // org.linphone.core.ConferenceListener
    public void onParticipantRemoved(Conference conference, Participant participant) {
    }

    @Override // org.linphone.core.ConferenceListener
    public void onStateChanged(Conference conference, Conference.State state) {
    }

    @Override // org.linphone.core.ConferenceListener
    public void onSubjectChanged(Conference conference, String str) {
    }
}
