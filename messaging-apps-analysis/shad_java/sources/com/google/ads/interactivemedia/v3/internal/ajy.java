package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Currency;

/* compiled from: IMASDK */
/* loaded from: classes.dex */
final class ajy extends agt<Currency> {
    ajy() {
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ Currency read(alb albVar) throws IOException {
        return Currency.getInstance(albVar.g());
    }

    @Override // com.google.ads.interactivemedia.v3.internal.agt
    public final /* bridge */ /* synthetic */ void write(ald aldVar, Currency currency) throws IOException {
        aldVar.k(currency.getCurrencyCode());
    }
}
