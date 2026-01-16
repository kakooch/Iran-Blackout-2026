package com.pedro.encoder.video;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public interface GetVideoData {
    void getVideoData(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo);

    void onSpsPps(ByteBuffer byteBuffer, ByteBuffer byteBuffer2);

    void onSpsPpsVps(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3);

    void onVideoFormat(MediaFormat mediaFormat);
}
