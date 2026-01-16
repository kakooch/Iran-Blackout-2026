package org.webrtc.audio;

/* loaded from: classes.dex */
public interface AudioDeviceModule {
    long getNativeAudioDeviceModulePointer();

    void release();

    void setMicrophoneMute(boolean mute);

    void setSpeakerMute(boolean mute);
}
