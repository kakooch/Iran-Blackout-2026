package com.google.ads.interactivemedia.v3.internal;

import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
public final class rd extends ra {
    public static final rc c(aee aeeVar) {
        String strH = aeeVar.H();
        ary.t(strH);
        String strH2 = aeeVar.H();
        ary.t(strH2);
        return new rc(strH, strH2, aeeVar.t(), aeeVar.t(), Arrays.copyOfRange(aeeVar.i(), aeeVar.g(), aeeVar.e()));
    }

    @Override // com.google.ads.interactivemedia.v3.internal.ra
    protected final qz b(ByteBuffer byteBuffer) {
        return new qz(c(new aee(byteBuffer.array(), byteBuffer.limit())));
    }
}
