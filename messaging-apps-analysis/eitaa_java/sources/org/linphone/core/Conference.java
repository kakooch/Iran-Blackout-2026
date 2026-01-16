package org.linphone.core;

/* loaded from: classes3.dex */
public interface Conference {
    void addListener(ConferenceListener conferenceListener);

    int addParticipant(Address address);

    int addParticipant(Call call);

    int addParticipants(Address[] addressArr);

    int addParticipants(Call[] callArr);

    int enter();

    Participant findParticipant(Address address);

    ParticipantDevice getActiveSpeakerParticipantDevice();

    Call getCall();

    Address getConferenceAddress();

    Core getCore();

    ConferenceParams getCurrentParams();

    int getDuration();

    @Deprecated
    String getId();

    AudioDevice getInputAudioDevice();

    Participant getMe();

    long getNativePointer();

    AudioDevice getOutputAudioDevice();

    int getParticipantCount();

    ParticipantDevice[] getParticipantDeviceList();

    int getParticipantDeviceVolume(ParticipantDevice participantDevice);

    Participant[] getParticipantList();

    @Deprecated
    Address[] getParticipants();

    long getStartTime();

    State getState();

    String getSubject();

    Object getUserData();

    String getUsername();

    int inviteParticipants(Address[] addressArr, CallParams callParams);

    boolean isIn();

    boolean isMe(Address address);

    boolean isRecording();

    int leave();

    void removeListener(ConferenceListener conferenceListener);

    @Deprecated
    int removeParticipant(Address address);

    @Deprecated
    int removeParticipant(Call call);

    int removeParticipant(Participant participant);

    void setConferenceAddress(Address address);

    @Deprecated
    void setId(String str);

    void setInputAudioDevice(AudioDevice audioDevice);

    void setLocalParticipantStreamCapability(MediaDirection mediaDirection, StreamType streamType);

    void setOutputAudioDevice(AudioDevice audioDevice);

    void setParticipantAdminStatus(Participant participant, boolean z);

    void setSubject(String str);

    void setUserData(Object obj);

    void setUsername(String str);

    int startRecording(String str);

    int stopRecording();

    int terminate();

    String toString();

    int updateParams(ConferenceParams conferenceParams);

    public enum State {
        None(0),
        Instantiated(1),
        CreationPending(2),
        Created(3),
        CreationFailed(4),
        TerminationPending(5),
        Terminated(6),
        TerminationFailed(7),
        Deleted(8);

        protected final int mValue;

        State(int i) {
            this.mValue = i;
        }

        public static State fromInt(int i) throws RuntimeException {
            switch (i) {
                case 0:
                    return None;
                case 1:
                    return Instantiated;
                case 2:
                    return CreationPending;
                case 3:
                    return Created;
                case 4:
                    return CreationFailed;
                case 5:
                    return TerminationPending;
                case 6:
                    return Terminated;
                case 7:
                    return TerminationFailed;
                case 8:
                    return Deleted;
                default:
                    throw new RuntimeException("Unhandled enum value " + i + " for State");
            }
        }

        public int toInt() {
            return this.mValue;
        }
    }
}
