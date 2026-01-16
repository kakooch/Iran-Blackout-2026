package org.linphone.core;

import org.linphone.core.ChatMessage;

/* loaded from: classes3.dex */
public interface ChatMessageListener {
    void onEphemeralMessageDeleted(ChatMessage chatMessage);

    void onEphemeralMessageTimerStarted(ChatMessage chatMessage);

    void onFileTransferProgressIndication(ChatMessage chatMessage, Content content, int i, int i2);

    void onFileTransferRecv(ChatMessage chatMessage, Content content, Buffer buffer);

    Buffer onFileTransferSend(ChatMessage chatMessage, Content content, int i, int i2);

    void onFileTransferSendChunk(ChatMessage chatMessage, Content content, int i, int i2, Buffer buffer);

    void onMsgStateChanged(ChatMessage chatMessage, ChatMessage.State state);

    void onParticipantImdnStateChanged(ChatMessage chatMessage, ParticipantImdnState participantImdnState);
}
