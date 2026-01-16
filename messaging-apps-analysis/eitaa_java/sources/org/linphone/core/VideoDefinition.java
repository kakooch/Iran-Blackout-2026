package org.linphone.core;

/* loaded from: classes3.dex */
public interface VideoDefinition {
    /* renamed from: clone */
    VideoDefinition mo55clone();

    boolean equals(VideoDefinition videoDefinition);

    int getHeight();

    String getName();

    long getNativePointer();

    Object getUserData();

    int getWidth();

    boolean isUndefined();

    void setDefinition(int i, int i2);

    void setHeight(int i);

    void setName(String str);

    void setUserData(Object obj);

    void setWidth(int i);

    boolean strictEquals(VideoDefinition videoDefinition);

    String toString();
}
