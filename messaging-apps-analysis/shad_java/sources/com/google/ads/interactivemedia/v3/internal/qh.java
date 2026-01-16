package com.google.ads.interactivemedia.v3.internal;

import android.media.MediaCodec;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class qh extends Exception {
    public final String a;
    public final boolean b;
    public final qg c;
    public final String d;

    public qh(cy cyVar, Throwable th, boolean z, int i) {
        String strValueOf = String.valueOf(cyVar);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 36);
        sb.append("Decoder init failed: [");
        sb.append(i);
        sb.append("], ");
        sb.append(strValueOf);
        String string = sb.toString();
        String str = cyVar.l;
        int iAbs = Math.abs(i);
        StringBuilder sb2 = new StringBuilder(75);
        sb2.append("com.google.ads.interactivemedia.v3.exoplayer2.mediacodec.MediaCodecRenderer_");
        sb2.append("neg_");
        sb2.append(iAbs);
        this(string, th, str, z, null, sb2.toString());
    }

    static /* synthetic */ qh a(qh qhVar, qh qhVar2) {
        return new qh(qhVar.getMessage(), qhVar.getCause(), qhVar.a, qhVar.b, qhVar.c, qhVar.d);
    }

    public qh(cy cyVar, Throwable th, boolean z, qg qgVar) {
        String str = qgVar.a;
        String strValueOf = String.valueOf(cyVar);
        StringBuilder sb = new StringBuilder(str.length() + 23 + strValueOf.length());
        sb.append("Decoder init failed: ");
        sb.append(str);
        sb.append(", ");
        sb.append(strValueOf);
        this(sb.toString(), th, cyVar.l, z, qgVar, (aeu.a < 21 || !(th instanceof MediaCodec.CodecException)) ? null : ((MediaCodec.CodecException) th).getDiagnosticInfo());
    }

    private qh(String str, Throwable th, String str2, boolean z, qg qgVar, String str3) {
        super(str, th);
        this.a = str2;
        this.b = z;
        this.c = qgVar;
        this.d = str3;
    }
}
