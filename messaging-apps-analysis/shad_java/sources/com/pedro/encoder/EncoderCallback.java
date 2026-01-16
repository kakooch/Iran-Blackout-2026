package com.pedro.encoder;

import android.media.MediaCodec;
import android.media.MediaFormat;

/* loaded from: classes3.dex */
public interface EncoderCallback {
    void formatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat);
}
