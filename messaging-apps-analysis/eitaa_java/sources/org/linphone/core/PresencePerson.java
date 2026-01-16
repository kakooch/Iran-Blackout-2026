package org.linphone.core;

/* loaded from: classes3.dex */
public interface PresencePerson {
    int addActivitiesNote(PresenceNote presenceNote);

    int addActivity(PresenceActivity presenceActivity);

    int addNote(PresenceNote presenceNote);

    int clearActivities();

    int clearActivitiesNotes();

    int clearNotes();

    String getId();

    long getNativePointer();

    int getNbActivities();

    int getNbActivitiesNotes();

    int getNbNotes();

    PresenceNote getNthActivitiesNote(int i);

    PresenceActivity getNthActivity(int i);

    PresenceNote getNthNote(int i);

    Object getUserData();

    int setId(String str);

    void setUserData(Object obj);

    String toString();
}
