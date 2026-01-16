package org.linphone.core;

/* loaded from: classes3.dex */
public interface Friend {
    void addAddress(Address address);

    void addListener(FriendListener friendListener);

    void addPhoneNumber(String str);

    void addPhoneNumberWithLabel(FriendPhoneNumber friendPhoneNumber);

    boolean createVcard(String str);

    void done();

    void edit();

    Address getAddress();

    Address[] getAddresses();

    int getCapabilities();

    float getCapabilityVersion(FriendCapability friendCapability);

    ConsolidatedPresence getConsolidatedPresence();

    Core getCore();

    SubscribePolicy getIncSubscribePolicy();

    String getName();

    long getNativePointer();

    String getNativeUri();

    String getOrganization();

    String[] getPhoneNumbers();

    FriendPhoneNumber[] getPhoneNumbersWithLabel();

    String getPhoto();

    PresenceModel getPresenceModel();

    PresenceModel getPresenceModelForUriOrTel(String str);

    String getRefKey();

    boolean getStarred();

    SubscriptionState getSubscriptionState();

    Object getUserData();

    Vcard getVcard();

    boolean hasCapability(FriendCapability friendCapability);

    boolean hasCapabilityWithVersion(FriendCapability friendCapability, float f);

    boolean hasCapabilityWithVersionOrMore(FriendCapability friendCapability, float f);

    boolean hasPhoneNumber(String str);

    boolean inList();

    boolean isPresenceReceived();

    boolean isSubscribesEnabled();

    Friend newFromVcard(Vcard vcard);

    void remove();

    void removeAddress(Address address);

    void removeListener(FriendListener friendListener);

    void removePhoneNumber(String str);

    void removePhoneNumberWithLabel(FriendPhoneNumber friendPhoneNumber);

    void save(Core core);

    int setAddress(Address address);

    int setIncSubscribePolicy(SubscribePolicy subscribePolicy);

    int setName(String str);

    void setNativeUri(String str);

    void setOrganization(String str);

    void setPhoto(String str);

    void setPresenceModel(PresenceModel presenceModel);

    void setPresenceModelForUriOrTel(String str, PresenceModel presenceModel);

    void setRefKey(String str);

    void setStarred(boolean z);

    int setSubscribesEnabled(boolean z);

    void setUserData(Object obj);

    void setVcard(Vcard vcard);

    String toString();
}
