package org.linphone.core;

/* loaded from: classes3.dex */
public interface FriendPhoneNumber {
    /* renamed from: clone */
    FriendPhoneNumber mo48clone();

    String getLabel();

    long getNativePointer();

    String getPhoneNumber();

    Object getUserData();

    void setLabel(String str);

    void setPhoneNumber(String str);

    void setUserData(Object obj);

    String toString();
}
