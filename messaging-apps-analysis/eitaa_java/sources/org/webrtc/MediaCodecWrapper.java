package org.webrtc;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
interface MediaCodecWrapper {
    void configure(MediaFormat format, Surface surface, MediaCrypto crypto, int flags);

    Surface createInputSurface();

    int dequeueInputBuffer(long timeoutUs);

    int dequeueOutputBuffer(MediaCodec.BufferInfo info, long timeoutUs);

    void flush();

    ByteBuffer[] getInputBuffers();

    ByteBuffer[] getOutputBuffers();

    MediaFormat getOutputFormat();

    void queueInputBuffer(int index, int offset, int size, long presentationTimeUs, int flags);

    void release();

    void releaseOutputBuffer(int index, boolean render);

    void setParameters(Bundle params);

    void start();

    void stop();
}
