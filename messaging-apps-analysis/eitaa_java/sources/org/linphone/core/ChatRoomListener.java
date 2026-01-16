package org.linphone.core;

import org.linphone.core.ChatRoom;

/* loaded from: classes3.dex */
public interface ChatRoomListener {
    void onChatMessageParticipantImdnStateChanged(ChatRoom chatRoom, ChatMessage chatMessage, ParticipantImdnState participantImdnState);

    void onChatMessageReceived(ChatRoom chatRoom, EventLog eventLog);

    void onChatMessageSending(ChatRoom chatRoom, EventLog eventLog);

    void onChatMessageSent(ChatRoom chatRoom, EventLog eventLog);

    void onChatMessageShouldBeStored(ChatRoom chatRoom, ChatMessage chatMessage);

    void onChatMessagesReceived(ChatRoom chatRoom, EventLog[] eventLogArr);

    void onConferenceAddressGeneration(ChatRoom chatRoom);

    void onConferenceJoined(ChatRoom chatRoom, EventLog eventLog);

    void onConferenceLeft(ChatRoom chatRoom, EventLog eventLog);

    void onEphemeralEvent(ChatRoom chatRoom, EventLog eventLog);

    void onEphemeralMessageDeleted(ChatRoom chatRoom, EventLog eventLog);

    void onEphemeralMessageTimerStarted(ChatRoom chatRoom, EventLog eventLog);

    void onIsComposingReceived(ChatRoom chatRoom, Address address, boolean z);

    void onMessageReceived(ChatRoom chatRoom, ChatMessage chatMessage);

    void onMessagesReceived(ChatRoom chatRoom, ChatMessage[] chatMessageArr);

    void onNewEvent(ChatRoom chatRoom, EventLog eventLog);

    void onNewEvents(ChatRoom chatRoom, EventLog[] eventLogArr);

    void onParticipantAdded(ChatRoom chatRoom, EventLog eventLog);

    void onParticipantAdminStatusChanged(ChatRoom chatRoom, EventLog eventLog);

    void onParticipantDeviceAdded(ChatRoom chatRoom, EventLog eventLog);

    void onParticipantDeviceMediaAvailabilityChanged(ChatRoom chatRoom, EventLog eventLog);

    void onParticipantDeviceRemoved(ChatRoom chatRoom, EventLog eventLog);

    void onParticipantDeviceStateChanged(ChatRoom chatRoom, EventLog eventLog, ParticipantDeviceState participantDeviceState);

    void onParticipantRegistrationSubscriptionRequested(ChatRoom chatRoom, Address address);

    void onParticipantRegistrationUnsubscriptionRequested(ChatRoom chatRoom, Address address);

    void onParticipantRemoved(ChatRoom chatRoom, EventLog eventLog);

    void onSecurityEvent(ChatRoom chatRoom, EventLog eventLog);

    void onStateChanged(ChatRoom chatRoom, ChatRoom.State state);

    void onSubjectChanged(ChatRoom chatRoom, EventLog eventLog);

    void onUndecryptableMessageReceived(ChatRoom chatRoom, ChatMessage chatMessage);
}
