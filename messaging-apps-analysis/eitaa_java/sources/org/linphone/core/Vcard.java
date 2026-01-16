package org.linphone.core;

/* loaded from: classes3.dex */
public interface Vcard {
    void addExtendedProperty(String str, String str2);

    void addPhoneNumber(String str);

    void addPhoneNumberWithLabel(FriendPhoneNumber friendPhoneNumber);

    void addSipAddress(String str);

    String asVcard4String();

    /* renamed from: clone */
    Vcard mo54clone();

    void editMainSipAddress(String str);

    boolean generateUniqueId();

    String getEtag();

    String[] getExtendedPropertiesValuesByName(String str);

    String getFamilyName();

    String getFullName();

    String getGivenName();

    long getNativePointer();

    String getOrganization();

    String[] getPhoneNumbers();

    FriendPhoneNumber[] getPhoneNumbersWithLabel();

    String getPhoto();

    Address[] getSipAddresses();

    boolean getSkipValidation();

    String getUid();

    String getUrl();

    Object getUserData();

    void removeExtentedPropertiesByName(String str);

    void removeOrganization();

    void removePhoneNumber(String str);

    void removePhoneNumberWithLabel(FriendPhoneNumber friendPhoneNumber);

    void removePhoto();

    void removeSipAddress(String str);

    void setEtag(String str);

    void setFamilyName(String str);

    void setFullName(String str);

    void setGivenName(String str);

    void setOrganization(String str);

    void setPhoto(String str);

    void setSkipValidation(boolean z);

    void setUid(String str);

    void setUrl(String str);

    void setUserData(Object obj);

    String toString();
}
