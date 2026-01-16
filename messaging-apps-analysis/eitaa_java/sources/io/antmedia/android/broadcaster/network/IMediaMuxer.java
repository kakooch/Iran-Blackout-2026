package io.antmedia.android.broadcaster.network;

/* loaded from: classes.dex */
public interface IMediaMuxer {
    int getLastAudioFrameTimeStamp();

    int getLastVideoFrameTimeStamp();

    void stopMuxer();

    void writeAudio(byte[] data, int size, int presentationTime);

    void writeVideo(byte[] data, int length, int presentationTime);
}
