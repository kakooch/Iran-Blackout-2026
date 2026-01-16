package com.google.android.exoplayer2.video;

import android.view.Surface;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.k;

/* loaded from: classes2.dex */
public class MediaCodecVideoDecoderException extends MediaCodecDecoderException {
    public final int c;
    public final boolean d;

    public MediaCodecVideoDecoderException(Throwable th, k kVar, Surface surface) {
        super(th, kVar);
        this.c = System.identityHashCode(surface);
        this.d = surface == null || surface.isValid();
    }
}
