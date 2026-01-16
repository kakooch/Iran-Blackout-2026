package org.linphone.core;

/* loaded from: classes3.dex */
public interface VideoSourceDescriptor {
    /* renamed from: clone */
    VideoSourceDescriptor mo56clone();

    Call getCall();

    String getCameraId();

    String getImage();

    long getNativePointer();

    VideoSourceType getType();

    Object getUserData();

    void setCall(Call call);

    void setCameraId(String str);

    void setImage(String str);

    void setUserData(Object obj);

    String toString();
}
