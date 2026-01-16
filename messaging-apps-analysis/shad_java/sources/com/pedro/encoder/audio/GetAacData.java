package com.pedro.encoder.audio;

import android.media.MediaCodec;
import android.media.MediaFormat;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public interface GetAacData {
    void getAacData(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo);

    void onAudioFormat(MediaFormat mediaFormat);
}
