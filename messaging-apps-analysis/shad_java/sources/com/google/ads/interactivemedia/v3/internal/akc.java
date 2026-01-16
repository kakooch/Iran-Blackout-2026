package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Locale;
import java.util.StringTokenizer;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class akc extends agt<Locale> {
    akc() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ Locale read(alb albVar) throws IOException {
        if (albVar.p() == 9) {
            albVar.i();
            return null;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(albVar.g(), "_");
        String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
        return (strNextToken2 == null && strNextToken3 == null) ? new Locale(strNextToken) : strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, Locale locale) throws IOException {
        Locale locale2 = locale;
        aldVar.k(locale2 == null ? null : locale2.toString());
    }
}
