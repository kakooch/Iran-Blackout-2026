package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCodec;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public class qf extends iv {
    /* JADX WARN: Illegal instructions before constructor call */
    public qf(Throwable th, qg qgVar) {
        String strValueOf = String.valueOf(qgVar == null ? null : qgVar.a);
        super(strValueOf.length() != 0 ? "Decoder failed: ".concat(strValueOf) : new String("Decoder failed: "), th);
        if (aeu.a < 21 || !(th instanceof MediaCodec.CodecException)) {
            return;
        }
        ((MediaCodec.CodecException) th).getDiagnosticInfo();
    }
}
