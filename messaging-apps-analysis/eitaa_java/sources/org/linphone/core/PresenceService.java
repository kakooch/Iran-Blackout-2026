package org.linphone.core;

/* loaded from: classes3.dex */
public interface PresenceService {
    int addNote(PresenceNote presenceNote);

    int clearNotes();

    PresenceBasicStatus getBasicStatus();

    String getContact();

    String getId();

    long getNativePointer();

    int getNbNotes();

    PresenceNote getNthNote(int i);

    String[] getServiceDescriptions();

    Object getUserData();

    int setBasicStatus(PresenceBasicStatus presenceBasicStatus);

    int setContact(String str);

    int setId(String str);

    int setServiceDescriptions(String[] strArr);

    void setUserData(Object obj);

    String toString();
}
