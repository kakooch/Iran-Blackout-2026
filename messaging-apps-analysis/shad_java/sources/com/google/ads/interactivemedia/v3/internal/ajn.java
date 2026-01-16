package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ajn extends agt<Character> {
    ajn() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ Character read(alb albVar) throws IOException {
        if (albVar.p() == 9) {
            albVar.i();
            return null;
        }
        String strG = albVar.g();
        if (strG.length() == 1) {
            return Character.valueOf(strG.charAt(0));
        }
        throw new agq("Expecting character, got: " + strG);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, Character ch) throws IOException {
        Character ch2 = ch;
        aldVar.k(ch2 == null ? null : String.valueOf(ch2));
    }
}
