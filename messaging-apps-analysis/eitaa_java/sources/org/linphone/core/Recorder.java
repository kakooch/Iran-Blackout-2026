package org.linphone.core;

/* loaded from: classes3.dex */
public interface Recorder {
    void close();

    Content createContent();

    float getCaptureVolume();

    int getDuration();

    String getFile();

    long getNativePointer();

    RecorderParams getParams();

    RecorderState getState();

    Object getUserData();

    int open(String str);

    int pause();

    void setParams(RecorderParams recorderParams);

    void setUserData(Object obj);

    int start();

    String toString();
}
