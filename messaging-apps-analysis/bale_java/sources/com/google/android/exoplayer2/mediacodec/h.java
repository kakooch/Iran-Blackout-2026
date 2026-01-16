package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.mediacodec.b;
import com.google.android.exoplayer2.mediacodec.j;
import com.google.android.exoplayer2.mediacodec.q;
import ir.nasim.AbstractC18815pI3;
import ir.nasim.AbstractC24462yf4;
import ir.nasim.AbstractC9683aN7;

/* loaded from: classes2.dex */
public final class h implements j.b {
    private int a = 0;
    private boolean b;

    @Override // com.google.android.exoplayer2.mediacodec.j.b
    public j a(j.a aVar) {
        int i;
        int i2 = AbstractC9683aN7.a;
        if (i2 < 23 || ((i = this.a) != 1 && (i != 0 || i2 < 31))) {
            return new q.b().a(aVar);
        }
        int iK = AbstractC24462yf4.k(aVar.c.l);
        AbstractC18815pI3.f("DMCodecAdapterFactory", "Creating an asynchronous MediaCodec adapter for track type " + AbstractC9683aN7.k0(iK));
        return new b.C0161b(iK, this.b).a(aVar);
    }
}
