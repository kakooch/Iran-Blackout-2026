package org.linphone.core;

/* loaded from: classes3.dex */
public interface ChatRoom {
    void addListener(ChatRoomListener chatRoomListener);

    void addParticipant(Address address);

    boolean addParticipants(Address[] addressArr);

    void allowCpim();

    void allowMultipart();

    boolean canHandleParticipants();

    void compose();

    ChatMessage createEmptyMessage();

    ChatMessage createFileTransferMessage(Content content);

    ChatMessage createForwardMessage(ChatMessage chatMessage);

    @Deprecated
    ChatMessage createMessage(String str);

    ChatMessage createMessageFromUtf8(String str);

    ChatMessage createReplyMessage(ChatMessage chatMessage);

    ChatMessage createVoiceRecordingMessage(Recorder recorder);

    void deleteHistory();

    void deleteMessage(ChatMessage chatMessage);

    boolean ephemeralSupportedByAllParticipants();

    ChatMessage findMessage(String str);

    Participant findParticipant(Address address);

    Call getCall();

    int getCapabilities();

    int getChar();

    Address[] getComposingAddresses();

    Address getConferenceAddress();

    Core getCore();

    long getCreationTime();

    ChatRoomParams getCurrentParams();

    long getEphemeralLifetime();

    ChatRoomEphemeralMode getEphemeralMode();

    ChatMessage[] getHistory(int i);

    EventLog[] getHistoryEvents(int i);

    int getHistoryEventsSize();

    EventLog[] getHistoryMessageEvents(int i);

    ChatMessage[] getHistoryRange(int i, int i2);

    EventLog[] getHistoryRangeEvents(int i, int i2);

    EventLog[] getHistoryRangeMessageEvents(int i, int i2);

    int getHistorySize();

    ChatMessage getLastMessageInHistory();

    long getLastUpdateTime();

    Address getLocalAddress();

    Participant getMe();

    long getNativePointer();

    int getNbParticipants();

    Participant[] getParticipants();

    Address getPeerAddress();

    ChatRoomSecurityLevel getSecurityLevel();

    State getState();

    String getSubject();

    ChatMessage[] getUnreadHistory();

    int getUnreadMessagesCount();

    Object getUserData();

    @Deprecated
    boolean hasBeenLeft();

    boolean hasCapability(int i);

    boolean isEmpty();

    boolean isEphemeralEnabled();

    boolean isReadOnly();

    boolean isRemoteComposing();

    void leave();

    boolean limeAvailable();

    void markAsRead();

    void notifyParticipantDeviceRegistration(Address address);

    void receiveChatMessage(ChatMessage chatMessage);

    void removeListener(ChatRoomListener chatRoomListener);

    void removeParticipant(Participant participant);

    void removeParticipants(Participant[] participantArr);

    void setConferenceAddress(Address address);

    void setEphemeralEnabled(boolean z);

    void setEphemeralLifetime(long j);

    void setEphemeralMode(ChatRoomEphemeralMode chatRoomEphemeralMode);

    void setParticipantAdminStatus(Participant participant, boolean z);

    void setParticipantDevices(Address address, ParticipantDeviceIdentity[] participantDeviceIdentityArr);

    void setSubject(String str);

    void setUserData(Object obj);

    String stateToString(State state);

    String toString();

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
