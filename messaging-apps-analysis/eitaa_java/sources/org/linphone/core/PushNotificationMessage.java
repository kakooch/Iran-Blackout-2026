package org.linphone.core;

/* loaded from: classes3.dex */
public interface PushNotificationMessage {
    long getNativePointer();

    Object getUserData();

    boolean isConferenceInvitationCancellation();

    boolean isConferenceInvitationNew();

    boolean isConferenceInvitationUpdate();

    boolean isIcalendar();

    void setUserData(Object obj);

    String toString();
}
