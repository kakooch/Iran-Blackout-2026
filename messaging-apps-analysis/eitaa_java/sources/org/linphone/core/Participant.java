package org.linphone.core;

/* loaded from: classes3.dex */
public interface Participant {
    ParticipantDevice findDevice(Address address);

    ParticipantDevice findDevice(Call call);

    Address getAddress();

    long getCreationTime();

    ParticipantDevice[] getDevices();

    long getNativePointer();

    ChatRoomSecurityLevel getSecurityLevel();

    Object getUserData();

    boolean isAdmin();

    boolean isFocus();

    void setUserData(Object obj);

    String toString();
}
