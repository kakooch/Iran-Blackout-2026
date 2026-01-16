package org.linphone.core;

/* loaded from: classes3.dex */
public interface Headers {
    void add(String str, String str2);

    long getNativePointer();

    Object getUserData();

    String getValue(String str);

    void remove(String str);

    void setUserData(Object obj);

    String toString();
}
