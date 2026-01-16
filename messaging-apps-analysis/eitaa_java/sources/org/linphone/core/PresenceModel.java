package org.linphone.core;

import org.linphone.core.PresenceActivity;

/* loaded from: classes3.dex */
public interface PresenceModel {
    int addActivity(PresenceActivity presenceActivity);

    int addNote(String str, String str2);

    int addPerson(PresencePerson presencePerson);

    int addService(PresenceService presenceService);

    int clearActivities();

    int clearNotes();

    int clearPersons();

    int clearServices();

    PresenceActivity getActivity();

    PresenceBasicStatus getBasicStatus();

    int getCapabilities();

    float getCapabilityVersion(FriendCapability friendCapability);

    ConsolidatedPresence getConsolidatedPresence();

    String getContact();

    long getLatestActivityTimestamp();

    long getNativePointer();

    int getNbActivities();

    int getNbPersons();

    int getNbServices();

    PresenceNote getNote(String str);

    PresenceActivity getNthActivity(int i);

    PresencePerson getNthPerson(int i);

    PresenceService getNthService(int i);

    Address getPresentity();

    long getTimestamp();

    Object getUserData();

    boolean hasCapability(FriendCapability friendCapability);

    boolean hasCapabilityWithVersion(FriendCapability friendCapability, float f);

    boolean hasCapabilityWithVersionOrMore(FriendCapability friendCapability, float f);

    boolean isOnline();

    PresenceModel newWithActivity(PresenceActivity.Type type, String str);

    PresenceModel newWithActivityAndNote(PresenceActivity.Type type, String str, String str2, String str3);

    int setActivity(PresenceActivity.Type type, String str);

    int setBasicStatus(PresenceBasicStatus presenceBasicStatus);

    int setContact(String str);

    int setPresentity(Address address);

    void setUserData(Object obj);

    String toString();
}
