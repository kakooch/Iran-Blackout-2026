package org.linphone.core;

/* loaded from: classes3.dex */
public interface DigestAuthenticationPolicy {
    boolean getAllowMd5();

    boolean getAllowNoQop();

    long getNativePointer();

    Object getUserData();

    void setAllowMd5(boolean z);

    void setAllowNoQop(boolean z);

    void setUserData(Object obj);

    String toString();
}
