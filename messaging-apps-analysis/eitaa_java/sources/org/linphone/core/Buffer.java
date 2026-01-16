package org.linphone.core;

/* loaded from: classes3.dex */
public interface Buffer {
    byte[] getContent();

    long getNativePointer();

    int getSize();

    String getStringContent();

    Object getUserData();

    boolean isEmpty();

    Buffer newFromData(byte[] bArr, int i);

    Buffer newFromString(String str);

    void setContent(byte[] bArr, int i);

    void setSize(int i);

    void setStringContent(String str);

    void setUserData(Object obj);

    String toString();
}
