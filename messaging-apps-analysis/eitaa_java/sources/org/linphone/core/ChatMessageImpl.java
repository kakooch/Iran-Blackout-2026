package org.linphone.core;

import org.linphone.core.ChatMessage;
import org.linphone.mediastream.Log;

/* compiled from: ChatMessage.java */
/* loaded from: classes3.dex */
class ChatMessageImpl implements ChatMessage {
    protected boolean _isConst;
    protected Core core;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void addContent(long j, Content content);

    private native void addCustomHeader(long j, String str, String str2);

    private native void addFileContent(long j, Content content);

    private native void addListener(long j, ChatMessageListener chatMessageListener);

    private native void addTextContent(long j, String str);

    private native void addUtf8TextContent(long j, String str);

    private native void cancelFileTransfer(long j);

    private native boolean downloadContent(long j, Content content);

    private native String getAppdata(long j);

    private native String getCallId(long j);

    private native ChatRoom getChatRoom(long j);

    private native String getContentType(long j);

    private native Content[] getContents(long j);

    private native Core getCore(long j);

    private native String getCustomHeader(long j, String str);

    private native long getEphemeralExpireTime(long j);

    private native long getEphemeralLifetime(long j);

    private native ErrorInfo getErrorInfo(long j);

    private native String getExternalBodyUrl(long j);

    private native Content getFileTransferInformation(long j);

    private native String getForwardInfo(long j);

    private native Address getFromAddress(long j);

    private native Address getLocalAddress(long j);

    private native String getMessageId(long j);

    private native ParticipantImdnState[] getParticipantsByImdnState(long j, int i);

    private native ChatMessage getReplyMessage(long j);

    private native String getReplyMessageId(long j);

    private native Address getReplyMessageSenderAddress(long j);

    private native int getState(long j);

    private native String getTextContent(long j);

    private native long getTime(long j);

    private native Address getToAddress(long j);

    private native boolean getToBeStored(long j);

    private native String getUtf8Text(long j);

    private native boolean hasConferenceInvitationContent(long j);

    private native boolean hasTextContent(long j);

    private native boolean isEphemeral(long j);

    private native boolean isFileTransfer(long j);

    private native boolean isFileTransferInProgress(long j);

    private native boolean isForward(long j);

    private native boolean isOutgoing(long j);

    private native boolean isRead(long j);

    private native boolean isReply(long j);

    private native boolean isSecured(long j);

    private native boolean isText(long j);

    private native int putChar(long j, int i);

    private native void removeContent(long j, Content content);

    private native void removeCustomHeader(long j, String str);

    private native void removeListener(long j, ChatMessageListener chatMessageListener);

    private native void send(long j);

    private native void setAppdata(long j, String str);

    private native void setContentType(long j, String str);

    private native void setExternalBodyUrl(long j, String str);

    private native void setToBeStored(long j, boolean z);

    private native int setUtf8Text(long j, String str);

    private native boolean unref(long j, boolean z);

    protected ChatMessageImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this.core = null;
        this._isConst = false;
        this.nativePtr = j;
        this.core = getCore();
        this._isConst = z;
    }

    @Override // org.linphone.core.ChatMessage
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized String getAppdata() {
        String appdata;
        synchronized (this.core) {
            appdata = getAppdata(this.nativePtr);
        }
        return appdata;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized void setAppdata(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setAppdata() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setAppdata(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized String getCallId() {
        String callId;
        synchronized (this.core) {
            callId = getCallId(this.nativePtr);
        }
        return callId;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized ChatRoom getChatRoom() {
        ChatRoom chatRoom;
        synchronized (this.core) {
            chatRoom = getChatRoom(this.nativePtr);
        }
        return chatRoom;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized String getContentType() {
        String contentType;
        synchronized (this.core) {
            contentType = getContentType(this.nativePtr);
        }
        return contentType;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized void setContentType(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setContentType() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setContentType(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized Content[] getContents() {
        Content[] contents;
        synchronized (this.core) {
            contents = getContents(this.nativePtr);
        }
        return contents;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized Core getCore() {
        return getCore(this.nativePtr);
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized long getEphemeralExpireTime() {
        long ephemeralExpireTime;
        synchronized (this.core) {
            ephemeralExpireTime = getEphemeralExpireTime(this.nativePtr);
        }
        return ephemeralExpireTime;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized long getEphemeralLifetime() {
        long ephemeralLifetime;
        synchronized (this.core) {
            ephemeralLifetime = getEphemeralLifetime(this.nativePtr);
        }
        return ephemeralLifetime;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized ErrorInfo getErrorInfo() {
        ErrorInfo errorInfo;
        synchronized (this.core) {
            errorInfo = getErrorInfo(this.nativePtr);
        }
        return errorInfo;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized String getExternalBodyUrl() {
        String externalBodyUrl;
        synchronized (this.core) {
            externalBodyUrl = getExternalBodyUrl(this.nativePtr);
        }
        return externalBodyUrl;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized void setExternalBodyUrl(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setExternalBodyUrl() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setExternalBodyUrl(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized Content getFileTransferInformation() {
        Content fileTransferInformation;
        synchronized (this.core) {
            fileTransferInformation = getFileTransferInformation(this.nativePtr);
        }
        return fileTransferInformation;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized String getForwardInfo() {
        String forwardInfo;
        synchronized (this.core) {
            forwardInfo = getForwardInfo(this.nativePtr);
        }
        return forwardInfo;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized Address getFromAddress() {
        Address fromAddress;
        synchronized (this.core) {
            fromAddress = getFromAddress(this.nativePtr);
        }
        return fromAddress;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized boolean isEphemeral() {
        boolean zIsEphemeral;
        synchronized (this.core) {
            zIsEphemeral = isEphemeral(this.nativePtr);
        }
        return zIsEphemeral;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized boolean isFileTransfer() {
        boolean zIsFileTransfer;
        synchronized (this.core) {
            zIsFileTransfer = isFileTransfer(this.nativePtr);
        }
        return zIsFileTransfer;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized boolean isFileTransferInProgress() {
        boolean zIsFileTransferInProgress;
        synchronized (this.core) {
            zIsFileTransferInProgress = isFileTransferInProgress(this.nativePtr);
        }
        return zIsFileTransferInProgress;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized boolean isForward() {
        boolean zIsForward;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call isForward() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            zIsForward = isForward(this.nativePtr);
        }
        return zIsForward;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized boolean isOutgoing() {
        boolean zIsOutgoing;
        synchronized (this.core) {
            zIsOutgoing = isOutgoing(this.nativePtr);
        }
        return zIsOutgoing;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized boolean isRead() {
        boolean zIsRead;
        synchronized (this.core) {
            zIsRead = isRead(this.nativePtr);
        }
        return zIsRead;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized boolean isReply() {
        boolean zIsReply;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call isReply() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            zIsReply = isReply(this.nativePtr);
        }
        return zIsReply;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized boolean isSecured() {
        boolean zIsSecured;
        synchronized (this.core) {
            zIsSecured = isSecured(this.nativePtr);
        }
        return zIsSecured;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized boolean isText() {
        boolean zIsText;
        synchronized (this.core) {
            zIsText = isText(this.nativePtr);
        }
        return zIsText;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized Address getLocalAddress() {
        Address localAddress;
        synchronized (this.core) {
            localAddress = getLocalAddress(this.nativePtr);
        }
        return localAddress;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized String getMessageId() {
        String messageId;
        synchronized (this.core) {
            messageId = getMessageId(this.nativePtr);
        }
        return messageId;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized ChatMessage getReplyMessage() {
        ChatMessage replyMessage;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getReplyMessage() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            replyMessage = getReplyMessage(this.nativePtr);
        }
        return replyMessage;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized String getReplyMessageId() {
        String replyMessageId;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getReplyMessageId() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            replyMessageId = getReplyMessageId(this.nativePtr);
        }
        return replyMessageId;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized Address getReplyMessageSenderAddress() {
        Address replyMessageSenderAddress;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getReplyMessageSenderAddress() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            replyMessageSenderAddress = getReplyMessageSenderAddress(this.nativePtr);
        }
        return replyMessageSenderAddress;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized ChatMessage.State getState() {
        ChatMessage.State stateFromInt;
        synchronized (this.core) {
            stateFromInt = ChatMessage.State.fromInt(getState(this.nativePtr));
        }
        return stateFromInt;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized String getTextContent() {
        String textContent;
        synchronized (this.core) {
            textContent = getTextContent(this.nativePtr);
        }
        return textContent;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized long getTime() {
        long time;
        synchronized (this.core) {
            time = getTime(this.nativePtr);
        }
        return time;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized Address getToAddress() {
        Address toAddress;
        synchronized (this.core) {
            toAddress = getToAddress(this.nativePtr);
        }
        return toAddress;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized boolean getToBeStored() {
        boolean toBeStored;
        synchronized (this.core) {
            toBeStored = getToBeStored(this.nativePtr);
        }
        return toBeStored;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized void setToBeStored(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setToBeStored() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setToBeStored(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized String getUtf8Text() {
        String utf8Text;
        synchronized (this.core) {
            utf8Text = getUtf8Text(this.nativePtr);
        }
        return utf8Text;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized int setUtf8Text(String str) {
        int utf8Text;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setUtf8Text() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            utf8Text = setUtf8Text(this.nativePtr, str);
        }
        return utf8Text;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized void addContent(Content content) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call addContent() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            addContent(this.nativePtr, content);
        }
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized void addCustomHeader(String str, String str2) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call addCustomHeader() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            addCustomHeader(this.nativePtr, str, str2);
        }
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized void addFileContent(Content content) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call addFileContent() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            addFileContent(this.nativePtr, content);
        }
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized void addTextContent(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call addTextContent() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            addTextContent(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized void addUtf8TextContent(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call addUtf8TextContent() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            addUtf8TextContent(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized void cancelFileTransfer() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call cancelFileTransfer() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            cancelFileTransfer(this.nativePtr);
        }
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized boolean downloadContent(Content content) {
        boolean zDownloadContent;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call downloadContent() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            zDownloadContent = downloadContent(this.nativePtr, content);
        }
        return zDownloadContent;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized String getCustomHeader(String str) {
        String customHeader;
        synchronized (this.core) {
            customHeader = getCustomHeader(this.nativePtr, str);
        }
        return customHeader;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized ParticipantImdnState[] getParticipantsByImdnState(ChatMessage.State state) {
        ParticipantImdnState[] participantsByImdnState;
        synchronized (this.core) {
            participantsByImdnState = getParticipantsByImdnState(this.nativePtr, state.toInt());
        }
        return participantsByImdnState;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized boolean hasConferenceInvitationContent() {
        boolean zHasConferenceInvitationContent;
        synchronized (this.core) {
            zHasConferenceInvitationContent = hasConferenceInvitationContent(this.nativePtr);
        }
        return zHasConferenceInvitationContent;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized boolean hasTextContent() {
        boolean zHasTextContent;
        synchronized (this.core) {
            zHasTextContent = hasTextContent(this.nativePtr);
        }
        return zHasTextContent;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized int putChar(int i) {
        int iPutChar;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call putChar() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            iPutChar = putChar(this.nativePtr, i);
        }
        return iPutChar;
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized void removeContent(Content content) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call removeContent() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            removeContent(this.nativePtr, content);
        }
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized void removeCustomHeader(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call removeCustomHeader() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            removeCustomHeader(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized void send() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call send() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            send(this.nativePtr);
        }
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized void addListener(ChatMessageListener chatMessageListener) {
        addListener(this.nativePtr, chatMessageListener);
    }

    @Override // org.linphone.core.ChatMessage
    public synchronized void removeListener(ChatMessageListener chatMessageListener) {
        removeListener(this.nativePtr, chatMessageListener);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.ChatMessage
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.ChatMessage
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.ChatMessage
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
