package org.linphone.core;

/* loaded from: classes3.dex */
public interface RecorderParams {
    /* renamed from: clone */
    RecorderParams mo53clone();

    AudioDevice getAudioDevice();

    RecorderFileFormat getFileFormat();

    long getNativePointer();

    Object getUserData();

    String getVideoCodec();

    String getWebcamName();

    Object getWindowId();

    void setAudioDevice(AudioDevice audioDevice);

    void setFileFormat(RecorderFileFormat recorderFileFormat);

    void setUserData(Object obj);

    void setVideoCodec(String str);

    void setWebcamName(String str);

    void setWindowId(Object obj);

    String toString();
}
