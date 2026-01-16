package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ajt extends agt<StringBuffer> {
    ajt() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ StringBuffer read(alb albVar) throws IOException {
        if (albVar.p() != 9) {
            return new StringBuffer(albVar.g());
        }
        albVar.i();
        return null;
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, StringBuffer stringBuffer) throws IOException {
        StringBuffer stringBuffer2 = stringBuffer;
        aldVar.k(stringBuffer2 == null ? null : stringBuffer2.toString());
    }
}
