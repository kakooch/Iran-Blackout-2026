package org.linphone.core;

import org.linphone.core.ChatMessage;

/* loaded from: classes3.dex */
public interface ParticipantImdnState {
    long getNativePointer();

    Participant getParticipant();

    ChatMessage.State getState();

    long getStateChangeTime();

    Object getUserData();

    void setUserData(Object obj);

    String toString();
}
