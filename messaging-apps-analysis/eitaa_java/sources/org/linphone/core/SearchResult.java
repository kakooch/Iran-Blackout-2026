package org.linphone.core;

/* loaded from: classes3.dex */
public interface SearchResult {
    Address getAddress();

    int getCapabilities();

    Friend getFriend();

    long getNativePointer();

    String getPhoneNumber();

    int getSourceFlags();

    Object getUserData();

    int getWeight();

    boolean hasCapability(FriendCapability friendCapability);

    void setUserData(Object obj);

    String toString();
}
