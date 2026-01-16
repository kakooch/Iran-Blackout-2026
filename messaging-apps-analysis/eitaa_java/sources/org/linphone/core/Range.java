package org.linphone.core;

/* loaded from: classes3.dex */
public interface Range {
    int getMax();

    int getMin();

    long getNativePointer();

    Object getUserData();

    void setMax(int i);

    void setMin(int i);

    void setUserData(Object obj);

    String toString();
}
