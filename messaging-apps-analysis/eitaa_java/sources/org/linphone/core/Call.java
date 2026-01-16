package org.linphone.core;

/* loaded from: classes3.dex */
public interface Call {
    int accept();

    int acceptEarlyMedia();

    int acceptEarlyMediaWithParams(CallParams callParams);

    int acceptUpdate(CallParams callParams);

    int acceptWithParams(CallParams callParams);

    void addListener(CallListener callListener);

    boolean askedToAutoanswer();

    void cancelDtmfs();

    void confirmGoClear();

    Object createNativeVideoWindowId();

    int decline(Reason reason);

    int declineWithErrorInfo(ErrorInfo errorInfo);

    int deferUpdate();

    CallStats getAudioStats();

    String getAuthenticationToken();

    boolean getAuthenticationTokenVerified();

    float getAverageQuality();

    CallLog getCallLog();

    ChatRoom getChatRoom();

    Conference getConference();

    Core getCore();

    CallParams getCurrentParams();

    float getCurrentQuality();

    Dir getDir();

    Address getDiversionAddress();

    int getDuration();

    ErrorInfo getErrorInfo();

    AudioDevice getInputAudioDevice();

    boolean getMicrophoneMuted();

    float getMicrophoneVolumeGain();

    long getNativePointer();

    Object getNativeVideoWindowId();

    AudioDevice getOutputAudioDevice();

    CallParams getParams();

    float getPlayVolume();

    Player getPlayer();

    Reason getReason();

    float getRecordVolume();

    String getReferTo();

    Address getRemoteAddress();

    @Deprecated
    String getRemoteAddressAsString();

    String getRemoteContact();

    CallParams getRemoteParams();

    String getRemoteUserAgent();

    Call getReplacedCall();

    Address getRequestAddress();

    boolean getSpeakerMuted();

    float getSpeakerVolumeGain();

    State getState();

    CallStats getStats(StreamType streamType);

    int getStreamCount();

    CallStats getTextStats();

    Address getToAddress();

    @Deprecated
    String getToHeader(String str);

    State getTransferState();

    Call getTransferTargetCall();

    Call getTransfererCall();

    Object getUserData();

    VideoSourceDescriptor getVideoSource();

    CallStats getVideoStats();

    boolean hasTransferPending();

    boolean isCameraEnabled();

    boolean isEchoCancellationEnabled();

    boolean isEchoLimiterEnabled();

    @Deprecated
    boolean isRecording();

    boolean mediaInProgress();

    void notifyRinging();

    void oglRender();

    int pause();

    @Deprecated
    int redirect(String str);

    int redirectTo(Address address);

    void removeListener(CallListener callListener);

    void requestNotifyNextVideoFrameDecoded();

    int resume();

    int sendDtmf(char c);

    int sendDtmfs(String str);

    int sendInfoMessage(InfoMessage infoMessage);

    void sendVfuRequest();

    void setAuthenticationTokenVerified(boolean z);

    void setCameraEnabled(boolean z);

    void setEchoCancellationEnabled(boolean z);

    void setEchoLimiterEnabled(boolean z);

    void setInputAudioDevice(AudioDevice audioDevice);

    void setMicrophoneMuted(boolean z);

    void setMicrophoneVolumeGain(float f);

    void setNativeVideoWindowId(Object obj);

    void setOutputAudioDevice(AudioDevice audioDevice);

    void setParams(CallParams callParams);

    void setSpeakerMuted(boolean z);

    void setSpeakerVolumeGain(float f);

    void setUserData(Object obj);

    void setVideoSource(VideoSourceDescriptor videoSourceDescriptor);

    void startRecording();

    void stopRecording();

    int takePreviewSnapshot(String str);

    int takeVideoSnapshot(String str);

    int terminate();

    int terminateWithErrorInfo(ErrorInfo errorInfo);

    String toString();

    @Deprecated
    int transfer(String str);

    int transferTo(Address address);

    int transferToAnother(Call call);

    int update(CallParams callParams);

    void zoom(float f, float f2, float f3);

    public enum Status {
        Success(0),
        Aborted(1),
        Missed(2),
        Declined(3),
        EarlyAborted(4),
        AcceptedElsewhere(5),
        DeclinedElsewhere(6);

        protected final int mValue;

        Status(int i) {
            this.mValue = i;
        }

        public static Status fromInt(int i) throws RuntimeException {
            switch (i) {
                case 0:
                    return Success;
                case 1:
                    return Aborted;
                case 2:
                    return Missed;
                case 3:
                    return Declined;
                case 4:
                    return EarlyAborted;
                case 5:
                    return AcceptedElsewhere;
                case 6:
                    return DeclinedElsewhere;
                default:
                    throw new RuntimeException("Unhandled enum value " + i + " for Status");
            }
        }

        public int toInt() {
            return this.mValue;
        }
    }

    public enum Dir {
        Outgoing(0),
        Incoming(1);

        protected final int mValue;

        Dir(int i) {
            this.mValue = i;
        }

        public static Dir fromInt(int i) throws RuntimeException {
            if (i == 0) {
                return Outgoing;
            }
            if (i == 1) {
                return Incoming;
            }
            throw new RuntimeException("Unhandled enum value " + i + " for Dir");
        }

        public int toInt() {
            return this.mValue;
        }
    }

    public enum State {
        Idle(0),
        IncomingReceived(1),
        PushIncomingReceived(2),
        OutgoingInit(3),
        OutgoingProgress(4),
        OutgoingRinging(5),
        OutgoingEarlyMedia(6),
        Connected(7),
        StreamsRunning(8),
        Pausing(9),
        Paused(10),
        Resuming(11),
        Referred(12),
        Error(13),
        End(14),
        PausedByRemote(15),
        UpdatedByRemote(16),
        IncomingEarlyMedia(17),
        Updating(18),
        Released(19),
        EarlyUpdatedByRemote(20),
        EarlyUpdating(21);

        protected final int mValue;

        State(int i) {
            this.mValue = i;
        }

        public static State fromInt(int i) throws RuntimeException {
            switch (i) {
                case 0:
                    return Idle;
                case 1:
                    return IncomingReceived;
                case 2:
                    return PushIncomingReceived;
                case 3:
                    return OutgoingInit;
                case 4:
                    return OutgoingProgress;
                case 5:
                    return OutgoingRinging;
                case 6:
                    return OutgoingEarlyMedia;
                case 7:
                    return Connected;
                case 8:
                    return StreamsRunning;
                case 9:
                    return Pausing;
                case 10:
                    return Paused;
                case 11:
                    return Resuming;
                case 12:
                    return Referred;
                case 13:
                    return Error;
                case 14:
                    return End;
                case 15:
                    return PausedByRemote;
                case 16:
                    return UpdatedByRemote;
                case 17:
                    return IncomingEarlyMedia;
                case 18:
                    return Updating;
                case 19:
                    return Released;
                case 20:
                    return EarlyUpdatedByRemote;
                case 21:
                    return EarlyUpdating;
                default:
                    throw new RuntimeException("Unhandled enum value " + i + " for State");
            }
        }

        public int toInt() {
            return this.mValue;
        }
    }
}
