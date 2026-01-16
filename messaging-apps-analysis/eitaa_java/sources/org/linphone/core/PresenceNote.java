package org.linphone.core;

/* loaded from: classes3.dex */
public interface PresenceNote {
    String getContent();

    String getLang();

    long getNativePointer();

    Object getUserData();

    int setContent(String str);

    int setLang(String str);

    void setUserData(Object obj);

    String toString();
}
