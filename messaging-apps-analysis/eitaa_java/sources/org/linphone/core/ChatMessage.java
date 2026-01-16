package org.linphone.core;

/* loaded from: classes3.dex */
public interface ChatMessage {
    void addContent(Content content);

    void addCustomHeader(String str, String str2);

    void addFileContent(Content content);

    void addListener(ChatMessageListener chatMessageListener);

    @Deprecated
    void addTextContent(String str);

    void addUtf8TextContent(String str);

    void cancelFileTransfer();

    boolean downloadContent(Content content);

    String getAppdata();

    String getCallId();

    ChatRoom getChatRoom();

    String getContentType();

    Content[] getContents();

    Core getCore();

    String getCustomHeader(String str);

    long getEphemeralExpireTime();

    long getEphemeralLifetime();

    ErrorInfo getErrorInfo();

    String getExternalBodyUrl();

    Content getFileTransferInformation();

    String getForwardInfo();

    Address getFromAddress();

    Address getLocalAddress();

    String getMessageId();

    long getNativePointer();

    ParticipantImdnState[] getParticipantsByImdnState(State state);

    ChatMessage getReplyMessage();

    String getReplyMessageId();

    Address getReplyMessageSenderAddress();

    State getState();

    @Deprecated
    String getTextContent();

    long getTime();

    Address getToAddress();

    boolean getToBeStored();

    Object getUserData();

    String getUtf8Text();

    boolean hasConferenceInvitationContent();

    @Deprecated
    boolean hasTextContent();

    boolean isEphemeral();

    @Deprecated
    boolean isFileTransfer();

    boolean isFileTransferInProgress();

    boolean isForward();

    boolean isOutgoing();

    boolean isRead();

    boolean isReply();

    boolean isSecured();

    @Deprecated
    boolean isText();

    int putChar(int i);

    void removeContent(Content content);

    void removeCustomHeader(String str);

    void removeListener(ChatMessageListener chatMessageListener);

    void send();

    void setAppdata(String str);

    void setContentType(String str);

    void setExternalBodyUrl(String str);

    void setToBeStored(boolean z);

    void setUserData(Object obj);

    int setUtf8Text(String str);

    String toString();

    public enum Direction {
        Incoming(0),
        Outgoing(1);

        protected final int mValue;

        Direction(int i) {
            this.mValue = i;
        }

        public static Direction fromInt(int i) throws RuntimeException {
            if (i == 0) {
                return Incoming;
            }
            if (i == 1) {
                return Outgoing;
            }
            throw new RuntimeException("Unhandled enum value " + i + " for Direction");
        }

        public int toInt() {
            return this.mValue;
        }
    }

    public enum State {
        Idle(0),
        InProgress(1),
        Delivered(2),
        NotDelivered(3),
        FileTransferError(4),
        FileTransferDone(5),
        DeliveredToUser(6),
        Displayed(7),
        FileTransferInProgress(8);

        protected final int mValue;

        State(int i) {
            this.mValue = i;
        }

        public static State fromInt(int i) throws RuntimeException {
            switch (i) {
                case 0:
                    return Idle;
                case 1:
                    return InProgress;
                case 2:
                    return Delivered;
                case 3:
                    return NotDelivered;
                case 4:
                    return FileTransferError;
                case 5:
                    return FileTransferDone;
                case 6:
                    return DeliveredToUser;
                case 7:
                    return Displayed;
                case 8:
                    return FileTransferInProgress;
                default:
                    throw new RuntimeException("Unhandled enum value " + i + " for State");
            }
        }

        public int toInt() {
            return this.mValue;
        }
    }
}
