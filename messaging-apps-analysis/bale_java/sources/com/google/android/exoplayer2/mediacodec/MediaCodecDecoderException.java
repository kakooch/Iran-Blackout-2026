package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import com.google.android.exoplayer2.decoder.DecoderException;
import ir.nasim.AbstractC9683aN7;

/* loaded from: classes2.dex */
public class MediaCodecDecoderException extends DecoderException {
    public final k a;
    public final String b;

    public MediaCodecDecoderException(Throwable th, k kVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("Decoder failed: ");
        sb.append(kVar == null ? null : kVar.a);
        super(sb.toString(), th);
        this.a = kVar;
        this.b = AbstractC9683aN7.a >= 21 ? a(th) : null;
    }

    private static String a(Throwable th) {
        if (th instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        return null;
    }
}
