package org.linphone.core;

/* loaded from: classes3.dex */
public interface VideoActivationPolicy {
    boolean getAutomaticallyAccept();

    boolean getAutomaticallyInitiate();

    long getNativePointer();

    Object getUserData();

    void setAutomaticallyAccept(boolean z);

    void setAutomaticallyInitiate(boolean z);

    void setUserData(Object obj);

    String toString();
}
