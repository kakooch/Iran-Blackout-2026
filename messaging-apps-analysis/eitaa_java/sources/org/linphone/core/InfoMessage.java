package org.linphone.core;

/* loaded from: classes3.dex */
public interface InfoMessage {
    void addHeader(String str, String str2);

    Content getContent();

    String getHeader(String str);

    long getNativePointer();

    Object getUserData();

    void setContent(Content content);

    void setUserData(Object obj);

    String toString();
}
