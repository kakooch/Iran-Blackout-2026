package org.linphone.core;

import org.linphone.core.ChatMessage;

/* loaded from: classes3.dex */
public class ChatMessageListenerStub implements ChatMessageListener {
    @Override // org.linphone.core.ChatMessageListener
    public void onEphemeralMessageDeleted(ChatMessage chatMessage) {
    }

    @Override // org.linphone.core.ChatMessageListener
    public void onEphemeralMessageTimerStarted(ChatMessage chatMessage) {
    }

    @Override // org.linphone.core.ChatMessageListener
    public void onFileTransferProgressIndication(ChatMessage chatMessage, Content content, int i, int i2) {
    }

    @Override // org.linphone.core.ChatMessageListener
    public void onFileTransferRecv(ChatMessage chatMessage, Content content, Buffer buffer) {
    }

    @Override // org.linphone.core.ChatMessageListener
    public Buffer onFileTransferSend(ChatMessage chatMessage, Content content, int i, int i2) {
        return null;
    }

    @Override // org.linphone.core.ChatMessageListener
    public void onFileTransferSendChunk(ChatMessage chatMessage, Content content, int i, int i2, Buffer buffer) {
    }

    @Override // org.linphone.core.ChatMessageListener
    public void onMsgStateChanged(ChatMessage chatMessage, ChatMessage.State state) {
    }

    @Override // org.linphone.core.ChatMessageListener
    public void onParticipantImdnStateChanged(ChatMessage chatMessage, ParticipantImdnState participantImdnState) {
    }
}
