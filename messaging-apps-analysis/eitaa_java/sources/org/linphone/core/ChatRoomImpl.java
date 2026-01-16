package org.linphone.core;

import org.linphone.core.ChatRoom;
import org.linphone.mediastream.Log;

/* compiled from: ChatRoom.java */
/* loaded from: classes3.dex */
class ChatRoomImpl implements ChatRoom {
    protected boolean _isConst;
    protected Core core;
    protected long nativePtr;
    protected transient Object userData = null;

    private native void addListener(long j, ChatRoomListener chatRoomListener);

    private native void addParticipant(long j, Address address);

    private native boolean addParticipants(long j, Address[] addressArr);

    private native void allowCpim(long j);

    private native void allowMultipart(long j);

    private native boolean canHandleParticipants(long j);

    private native void compose(long j);

    private native ChatMessage createEmptyMessage(long j);

    private native ChatMessage createFileTransferMessage(long j, Content content);

    private native ChatMessage createForwardMessage(long j, ChatMessage chatMessage);

    private native ChatMessage createMessage(long j, String str);

    private native ChatMessage createMessageFromUtf88(long j, String str);

    private native ChatMessage createReplyMessage(long j, ChatMessage chatMessage);

    private native ChatMessage createVoiceRecordingMessage(long j, Recorder recorder);

    private native void deleteHistory(long j);

    private native void deleteMessage(long j, ChatMessage chatMessage);

    private native boolean ephemeralSupportedByAllParticipants(long j);

    private native ChatMessage findMessage(long j, String str);

    private native Participant findParticipant(long j, Address address);

    private native Call getCall(long j);

    private native int getCapabilities(long j);

    private native int getChar(long j);

    private native Address[] getComposingAddresses(long j);

    private native Address getConferenceAddress(long j);

    private native Core getCore(long j);

    private native long getCreationTime(long j);

    private native ChatRoomParams getCurrentParams(long j);

    private native long getEphemeralLifetime(long j);

    private native int getEphemeralMode(long j);

    private native ChatMessage[] getHistory(long j, int i);

    private native EventLog[] getHistoryEvents(long j, int i);

    private native int getHistoryEventsSize(long j);

    private native EventLog[] getHistoryMessageEvents(long j, int i);

    private native ChatMessage[] getHistoryRange(long j, int i, int i2);

    private native EventLog[] getHistoryRangeEvents(long j, int i, int i2);

    private native EventLog[] getHistoryRangeMessageEvents(long j, int i, int i2);

    private native int getHistorySize(long j);

    private native ChatMessage getLastMessageInHistory(long j);

    private native long getLastUpdateTime(long j);

    private native Address getLocalAddress(long j);

    private native Participant getMe(long j);

    private native int getNbParticipants(long j);

    private native Participant[] getParticipants(long j);

    private native Address getPeerAddress(long j);

    private native int getSecurityLevel(long j);

    private native int getState(long j);

    private native String getSubject(long j);

    private native ChatMessage[] getUnreadHistory(long j);

    private native int getUnreadMessagesCount(long j);

    private native boolean hasBeenLeft(long j);

    private native boolean hasCapability(long j, int i);

    private native boolean isEmpty(long j);

    private native boolean isEphemeralEnabled(long j);

    private native boolean isReadOnly(long j);

    private native boolean isRemoteComposing(long j);

    private native void leave(long j);

    private native boolean limeAvailable(long j);

    private native void markAsRead(long j);

    private native void notifyParticipantDeviceRegistration(long j, Address address);

    private native void receiveChatMessage(long j, ChatMessage chatMessage);

    private native void removeListener(long j, ChatRoomListener chatRoomListener);

    private native void removeParticipant(long j, Participant participant);

    private native void removeParticipants(long j, Participant[] participantArr);

    private native void setConferenceAddress(long j, Address address);

    private native void setEphemeralEnabled(long j, boolean z);

    private native void setEphemeralLifetime(long j, long j2);

    private native void setEphemeralMode(long j, int i);

    private native void setParticipantAdminStatus(long j, Participant participant, boolean z);

    private native void setParticipantDevices(long j, Address address, ParticipantDeviceIdentity[] participantDeviceIdentityArr);

    private native void setSubject(long j, String str);

    private native String stateToString(long j, int i);

    private native boolean unref(long j, boolean z);

    protected ChatRoomImpl(long j, boolean z) {
        this.nativePtr = 0L;
        this.core = null;
        this._isConst = false;
        this.nativePtr = j;
        this.core = getCore();
        this._isConst = z;
    }

    @Override // org.linphone.core.ChatRoom
    public long getNativePointer() {
        return this.nativePtr;
    }

    public boolean isConst() {
        return this._isConst;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized Call getCall() {
        Call call;
        synchronized (this.core) {
            call = getCall(this.nativePtr);
        }
        return call;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized int getCapabilities() {
        int capabilities;
        synchronized (this.core) {
            capabilities = getCapabilities(this.nativePtr);
        }
        return capabilities;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized int getChar() {
        int i;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getChar() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            i = getChar(this.nativePtr);
        }
        return i;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized Address[] getComposingAddresses() {
        Address[] composingAddresses;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getComposingAddresses() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            composingAddresses = getComposingAddresses(this.nativePtr);
        }
        return composingAddresses;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized Address getConferenceAddress() {
        Address conferenceAddress;
        synchronized (this.core) {
            conferenceAddress = getConferenceAddress(this.nativePtr);
        }
        return conferenceAddress;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized void setConferenceAddress(Address address) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setConferenceAddress() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setConferenceAddress(this.nativePtr, address);
        }
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized Core getCore() {
        return getCore(this.nativePtr);
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized long getCreationTime() {
        long creationTime;
        synchronized (this.core) {
            creationTime = getCreationTime(this.nativePtr);
        }
        return creationTime;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized ChatRoomParams getCurrentParams() {
        ChatRoomParams currentParams;
        synchronized (this.core) {
            currentParams = getCurrentParams(this.nativePtr);
        }
        return currentParams;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized boolean isEphemeralEnabled() {
        boolean zIsEphemeralEnabled;
        synchronized (this.core) {
            zIsEphemeralEnabled = isEphemeralEnabled(this.nativePtr);
        }
        return zIsEphemeralEnabled;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized void setEphemeralEnabled(boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setEphemeralEnabled() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setEphemeralEnabled(this.nativePtr, z);
        }
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized long getEphemeralLifetime() {
        long ephemeralLifetime;
        synchronized (this.core) {
            ephemeralLifetime = getEphemeralLifetime(this.nativePtr);
        }
        return ephemeralLifetime;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized void setEphemeralLifetime(long j) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setEphemeralLifetime() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setEphemeralLifetime(this.nativePtr, j);
        }
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized ChatRoomEphemeralMode getEphemeralMode() {
        ChatRoomEphemeralMode chatRoomEphemeralModeFromInt;
        synchronized (this.core) {
            chatRoomEphemeralModeFromInt = ChatRoomEphemeralMode.fromInt(getEphemeralMode(this.nativePtr));
        }
        return chatRoomEphemeralModeFromInt;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized void setEphemeralMode(ChatRoomEphemeralMode chatRoomEphemeralMode) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setEphemeralMode() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setEphemeralMode(this.nativePtr, chatRoomEphemeralMode.toInt());
        }
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized int getHistoryEventsSize() {
        int historyEventsSize;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getHistoryEventsSize() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            historyEventsSize = getHistoryEventsSize(this.nativePtr);
        }
        return historyEventsSize;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized int getHistorySize() {
        int historySize;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getHistorySize() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            historySize = getHistorySize(this.nativePtr);
        }
        return historySize;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized boolean isEmpty() {
        boolean zIsEmpty;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call isEmpty() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            zIsEmpty = isEmpty(this.nativePtr);
        }
        return zIsEmpty;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized boolean isReadOnly() {
        boolean zIsReadOnly;
        synchronized (this.core) {
            zIsReadOnly = isReadOnly(this.nativePtr);
        }
        return zIsReadOnly;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized boolean isRemoteComposing() {
        boolean zIsRemoteComposing;
        synchronized (this.core) {
            zIsRemoteComposing = isRemoteComposing(this.nativePtr);
        }
        return zIsRemoteComposing;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized ChatMessage getLastMessageInHistory() {
        ChatMessage lastMessageInHistory;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getLastMessageInHistory() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            lastMessageInHistory = getLastMessageInHistory(this.nativePtr);
        }
        return lastMessageInHistory;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized long getLastUpdateTime() {
        long lastUpdateTime;
        synchronized (this.core) {
            lastUpdateTime = getLastUpdateTime(this.nativePtr);
        }
        return lastUpdateTime;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized Address getLocalAddress() {
        Address localAddress;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getLocalAddress() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            localAddress = getLocalAddress(this.nativePtr);
        }
        return localAddress;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized Participant getMe() {
        Participant me;
        synchronized (this.core) {
            me = getMe(this.nativePtr);
        }
        return me;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized int getNbParticipants() {
        int nbParticipants;
        synchronized (this.core) {
            nbParticipants = getNbParticipants(this.nativePtr);
        }
        return nbParticipants;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized Participant[] getParticipants() {
        Participant[] participants;
        synchronized (this.core) {
            participants = getParticipants(this.nativePtr);
        }
        return participants;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized Address getPeerAddress() {
        Address peerAddress;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getPeerAddress() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            peerAddress = getPeerAddress(this.nativePtr);
        }
        return peerAddress;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized ChatRoomSecurityLevel getSecurityLevel() {
        ChatRoomSecurityLevel chatRoomSecurityLevelFromInt;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getSecurityLevel() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            chatRoomSecurityLevelFromInt = ChatRoomSecurityLevel.fromInt(getSecurityLevel(this.nativePtr));
        }
        return chatRoomSecurityLevelFromInt;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized ChatRoom.State getState() {
        ChatRoom.State stateFromInt;
        synchronized (this.core) {
            stateFromInt = ChatRoom.State.fromInt(getState(this.nativePtr));
        }
        return stateFromInt;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized String getSubject() {
        String subject;
        synchronized (this.core) {
            subject = getSubject(this.nativePtr);
        }
        return subject;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized void setSubject(String str) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setSubject() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setSubject(this.nativePtr, str);
        }
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized ChatMessage[] getUnreadHistory() {
        ChatMessage[] unreadHistory;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getUnreadHistory() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            unreadHistory = getUnreadHistory(this.nativePtr);
        }
        return unreadHistory;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized int getUnreadMessagesCount() {
        int unreadMessagesCount;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getUnreadMessagesCount() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            unreadMessagesCount = getUnreadMessagesCount(this.nativePtr);
        }
        return unreadMessagesCount;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized void addParticipant(Address address) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call addParticipant() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            addParticipant(this.nativePtr, address);
        }
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized boolean addParticipants(Address[] addressArr) {
        boolean zAddParticipants;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call addParticipants() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            zAddParticipants = addParticipants(this.nativePtr, addressArr);
        }
        return zAddParticipants;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized void allowCpim() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call allowCpim() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            allowCpim(this.nativePtr);
        }
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized void allowMultipart() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call allowMultipart() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            allowMultipart(this.nativePtr);
        }
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized boolean canHandleParticipants() {
        boolean zCanHandleParticipants;
        synchronized (this.core) {
            zCanHandleParticipants = canHandleParticipants(this.nativePtr);
        }
        return zCanHandleParticipants;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized void compose() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call compose() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            compose(this.nativePtr);
        }
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized ChatMessage createEmptyMessage() {
        ChatMessage chatMessageCreateEmptyMessage;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call createEmptyMessage() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            chatMessageCreateEmptyMessage = createEmptyMessage(this.nativePtr);
        }
        return chatMessageCreateEmptyMessage;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized ChatMessage createFileTransferMessage(Content content) {
        ChatMessage chatMessageCreateFileTransferMessage;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call createFileTransferMessage() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            chatMessageCreateFileTransferMessage = createFileTransferMessage(this.nativePtr, content);
        }
        return chatMessageCreateFileTransferMessage;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized ChatMessage createForwardMessage(ChatMessage chatMessage) {
        ChatMessage chatMessageCreateForwardMessage;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call createForwardMessage() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            chatMessageCreateForwardMessage = createForwardMessage(this.nativePtr, chatMessage);
        }
        return chatMessageCreateForwardMessage;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized ChatMessage createMessage(String str) {
        ChatMessage chatMessageCreateMessage;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call createMessage() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            chatMessageCreateMessage = createMessage(this.nativePtr, str);
        }
        return chatMessageCreateMessage;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized ChatMessage createMessageFromUtf8(String str) {
        ChatMessage chatMessageCreateMessageFromUtf88;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call createMessageFromUtf8() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            chatMessageCreateMessageFromUtf88 = createMessageFromUtf88(this.nativePtr, str);
        }
        return chatMessageCreateMessageFromUtf88;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized ChatMessage createReplyMessage(ChatMessage chatMessage) {
        ChatMessage chatMessageCreateReplyMessage;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call createReplyMessage() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            chatMessageCreateReplyMessage = createReplyMessage(this.nativePtr, chatMessage);
        }
        return chatMessageCreateReplyMessage;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized ChatMessage createVoiceRecordingMessage(Recorder recorder) {
        ChatMessage chatMessageCreateVoiceRecordingMessage;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call createVoiceRecordingMessage() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            chatMessageCreateVoiceRecordingMessage = createVoiceRecordingMessage(this.nativePtr, recorder);
        }
        return chatMessageCreateVoiceRecordingMessage;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized void deleteHistory() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call deleteHistory() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            deleteHistory(this.nativePtr);
        }
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized void deleteMessage(ChatMessage chatMessage) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call deleteMessage() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            deleteMessage(this.nativePtr, chatMessage);
        }
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized boolean ephemeralSupportedByAllParticipants() {
        boolean zEphemeralSupportedByAllParticipants;
        synchronized (this.core) {
            zEphemeralSupportedByAllParticipants = ephemeralSupportedByAllParticipants(this.nativePtr);
        }
        return zEphemeralSupportedByAllParticipants;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized ChatMessage findMessage(String str) {
        ChatMessage chatMessageFindMessage;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call findMessage() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            chatMessageFindMessage = findMessage(this.nativePtr, str);
        }
        return chatMessageFindMessage;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized Participant findParticipant(Address address) {
        Participant participantFindParticipant;
        synchronized (this.core) {
            participantFindParticipant = findParticipant(this.nativePtr, address);
        }
        return participantFindParticipant;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized ChatMessage[] getHistory(int i) {
        ChatMessage[] history;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getHistory() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            history = getHistory(this.nativePtr, i);
        }
        return history;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized EventLog[] getHistoryEvents(int i) {
        EventLog[] historyEvents;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getHistoryEvents() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            historyEvents = getHistoryEvents(this.nativePtr, i);
        }
        return historyEvents;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized EventLog[] getHistoryMessageEvents(int i) {
        EventLog[] historyMessageEvents;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getHistoryMessageEvents() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            historyMessageEvents = getHistoryMessageEvents(this.nativePtr, i);
        }
        return historyMessageEvents;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized ChatMessage[] getHistoryRange(int i, int i2) {
        ChatMessage[] historyRange;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getHistoryRange() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            historyRange = getHistoryRange(this.nativePtr, i, i2);
        }
        return historyRange;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized EventLog[] getHistoryRangeEvents(int i, int i2) {
        EventLog[] historyRangeEvents;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getHistoryRangeEvents() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            historyRangeEvents = getHistoryRangeEvents(this.nativePtr, i, i2);
        }
        return historyRangeEvents;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized EventLog[] getHistoryRangeMessageEvents(int i, int i2) {
        EventLog[] historyRangeMessageEvents;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call getHistoryRangeMessageEvents() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            historyRangeMessageEvents = getHistoryRangeMessageEvents(this.nativePtr, i, i2);
        }
        return historyRangeMessageEvents;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized boolean hasBeenLeft() {
        boolean zHasBeenLeft;
        synchronized (this.core) {
            zHasBeenLeft = hasBeenLeft(this.nativePtr);
        }
        return zHasBeenLeft;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized boolean hasCapability(int i) {
        boolean zHasCapability;
        synchronized (this.core) {
            zHasCapability = hasCapability(this.nativePtr, i);
        }
        return zHasCapability;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized void leave() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call leave() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            leave(this.nativePtr);
        }
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized boolean limeAvailable() {
        boolean zLimeAvailable;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call limeAvailable() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            zLimeAvailable = limeAvailable(this.nativePtr);
        }
        return zLimeAvailable;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized void markAsRead() {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call markAsRead() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            markAsRead(this.nativePtr);
        }
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized void notifyParticipantDeviceRegistration(Address address) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call notifyParticipantDeviceRegistration() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            notifyParticipantDeviceRegistration(this.nativePtr, address);
        }
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized void receiveChatMessage(ChatMessage chatMessage) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call receiveChatMessage() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            receiveChatMessage(this.nativePtr, chatMessage);
        }
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized void removeParticipant(Participant participant) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call removeParticipant() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            removeParticipant(this.nativePtr, participant);
        }
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized void removeParticipants(Participant[] participantArr) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call removeParticipants() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            removeParticipants(this.nativePtr, participantArr);
        }
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized void setParticipantAdminStatus(Participant participant, boolean z) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setParticipantAdminStatus() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setParticipantAdminStatus(this.nativePtr, participant, z);
        }
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized void setParticipantDevices(Address address, ParticipantDeviceIdentity[] participantDeviceIdentityArr) {
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call setParticipantDevices() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            setParticipantDevices(this.nativePtr, address, participantDeviceIdentityArr);
        }
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized String stateToString(ChatRoom.State state) {
        String strStateToString;
        synchronized (this.core) {
            if (this._isConst) {
                try {
                    throw new CoreException(toString() + " is const! If you want to call stateToString() on it, clone it first.");
                } catch (CoreException e) {
                    Log.e(e);
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        Log.e(stackTraceElement);
                    }
                }
            }
            strStateToString = stateToString(this.nativePtr, state.toInt());
        }
        return strStateToString;
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized void addListener(ChatRoomListener chatRoomListener) {
        addListener(this.nativePtr, chatRoomListener);
    }

    @Override // org.linphone.core.ChatRoom
    public synchronized void removeListener(ChatRoomListener chatRoomListener) {
        removeListener(this.nativePtr, chatRoomListener);
    }

    protected void finalize() throws Throwable {
        long j = this.nativePtr;
        if (j != 0 && unref(j, this._isConst)) {
            this.nativePtr = 0L;
        }
        super.finalize();
    }

    @Override // org.linphone.core.ChatRoom
    public void setUserData(Object obj) {
        this.userData = obj;
    }

    @Override // org.linphone.core.ChatRoom
    public Object getUserData() {
        return this.userData;
    }

    @Override // org.linphone.core.ChatRoom
    public String toString() {
        return "Java object [" + super.toString() + "], native pointer [" + String.format("0x%08x", Long.valueOf(this.nativePtr)) + "]";
    }
}
